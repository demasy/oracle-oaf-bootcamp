# MessageHelper Utility - Complete Usage Guide

## Overview

**MessageHelper** is a reusable utility class for creating OAF exceptions with proper message codes from the FND_MESSAGES table. It eliminates hardcoded error messages and ensures consistent error handling across your OAF application with multi-language support.

## Benefits

✅ **Multi-language Support (i18n)** - Messages display in user's language automatically  
✅ **No Code Changes for Message Updates** - Update messages via database only  
✅ **Centralized Management** - All message codes in MessageConstants.java  
✅ **Token Substitution** - Dynamic values in error messages  
✅ **Consistent Error Handling** - Standardized patterns across all layers  
✅ **Production Best Practice** - Follows Oracle OAF Framework standards  

## Quick Start

### Step 1: Import Required Classes

```java
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;
```

### Step 2: Replace Hardcoded Errors

**❌ Old Pattern (Hardcoded)**
```java
throw new OAException("Employee Name is required", OAException.ERROR);
```

**✅ New Pattern (MessageHelper)**
```java
throw MessageHelper.createError(MessageConstants.ERR_EMP_NAME_REQUIRED, "EmployeeName");
```

## Core Methods

### 1. Error Messages (Severity: ERROR)

#### Simple Error (No Tokens)
```java
// Message: "Please select at least one row to proceed."
throw MessageHelper.createError(MessageConstants.NO_ROWS_SELECTED);
```

#### Error with Single Token
```java
// Message: "Employee &EMP_NUMBER not found in the system."
// Result: "Employee 12345 not found in the system."
String empNumber = "12345";
throw MessageHelper.createError(MessageConstants.ERR_EMP_NOT_FOUND, empNumber);
```

#### Error with Multiple Tokens
```java
// Message: "Job headcount must be between &MIN and &MAX."
// Result: "Job headcount must be between 1 and 100."
String[] tokens = {"1", "100"};
throw MessageHelper.createError(
    MessageConstants.ERR_JOB_HEADCOUNT_OUT_OF_RANGE, 
    tokens
);
```

#### Error with Custom Application
```java
// Use XXVAL application for validation messages
throw MessageHelper.createError(
    MessageConstants.APP_XXVAL, 
    MessageConstants.ERR_EMAIL_INVALID
);
```

### 2. Warning Messages (Severity: WARNING)

```java
// Warning without token
throw MessageHelper.createWarning(MessageConstants.DUPLICATE_RECORD);

// Warning with token
String recordName = "John Doe";
throw MessageHelper.createWarning(MessageConstants.DUPLICATE_RECORD, recordName);
```

### 3. Confirmation Messages (Severity: CONFIRMATION)

```java
// Confirmation without token
throw MessageHelper.createConfirmation(MessageConstants.SAVE_SUCCESS);

// Confirmation with token
String empNumber = "12345";
throw MessageHelper.createConfirmation(
    MessageConstants.SAVE_SUCCESS, 
    empNumber
);
```

### 4. Information Messages (Severity: INFORMATION)

```java
// Information without token
throw MessageHelper.createInformation(MessageConstants.OPERATION_CANCELLED);

// Information with token
String operationName = "Employee Update";
throw MessageHelper.createInformation(
    MessageConstants.OPERATION_CANCELLED, 
    operationName
);
```

### 5. Validation Errors (XXVAL Application)

```java
// For DataValidation.java utilities
String fieldName = "EmailAddress";
throw MessageHelper.createValidationError(
    MessageConstants.ERR_EMAIL_INVALID, 
    fieldName
);

// Result: Error displays with XXVAL application context
```

### 6. Lab Exercise Messages (XXLAB Application)

```java
// Lab error
throw MessageHelper.createLabError(MessageConstants.LAB_SELECT_ROW);

// Lab information
throw MessageHelper.createLabInfo(MessageConstants.LAB_SEARCH_CLEARED);
```

### 7. Database Error Handling

```java
try {
    // Database operation
    vo.executeQuery();
} catch (SQLException e) {
    // Maps SQL error codes to appropriate message codes
    // -1: Duplicate record (ORA-00001)
    // -2291/-2292: Foreign key violation
    // -2290-2299: Constraint violation
    throw MessageHelper.createDatabaseError(e.getErrorCode(), e);
}
```

### 8. PL/SQL Error Wrapping

```java
try {
    // Call PL/SQL function
    CallableStatement cs = conn.prepareCall("{? = call my_function(?)}");
    cs.execute();
} catch (SQLException e) {
    throw MessageHelper.createPLSQLError(
        MessageConstants.ERR_PLSQL_FUNCTION, 
        e
    );
}
```

## Controller Integration Examples

### Example 1: Employee Validation

```java
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processFormRequest(pageContext, webBean);
    
    if ("save".equals(pageContext.getParameter("event"))) {
        String empNumber = pageContext.getParameter("EmpNumber");
        String empName = pageContext.getParameter("EmpName");
        String email = pageContext.getParameter("Email");
        
        // Validate Employee Number
        if (empNumber == null || empNumber.trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EMP_NUMBER_REQUIRED, 
                "Employee Number"
            );
        }
        
        // Validate Employee Name
        if (empName == null || empName.trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EMP_NAME_REQUIRED, 
                "Employee Name"
            );
        }
        
        // Validate Email
        if (email == null || email.trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EMAIL_REQUIRED, 
                "Email Address"
            );
        }
        
        // Call Application Module to save
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        try {
            am.invokeMethod("saveEmployee", 
                new String[] {empNumber, empName, email});
            
            // Success message
            throw MessageHelper.createConfirmation(
                MessageConstants.SAVE_SUCCESS
            );
        } catch (Exception e) {
            throw MessageHelper.createError(
                MessageConstants.ERR_AM_SAVE_ERROR
            );
        }
    }
}
```

### Example 2: Row Selection Validation

```java
public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processFormRequest(pageContext, webBean);
    
    if ("delete".equals(pageContext.getParameter("event"))) {
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        OAViewObject vo = (OAViewObject) am.findViewObject("EmployeesVO");
        
        // Get selected rows
        Row[] selectedRows = vo.getFilteredRows("SelectFlag", "Y");
        
        // Validate at least one row selected
        if (selectedRows == null || selectedRows.length == 0) {
            throw MessageHelper.createError(MessageConstants.NO_ROWS_SELECTED);
        }
        
        // Delete selected rows
        for (Row row : selectedRows) {
            row.remove();
        }
        
        am.getTransaction().commit();
        
        // Success confirmation
        throw MessageHelper.createConfirmation(MessageConstants.DELETE_SUCCESS);
    }
}
```

### Example 3: Excel File Validation

```java
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.cabo.ui.data.DataObject;

public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processFormRequest(pageContext, webBean);
    
    if ("upload".equals(pageContext.getParameter("event"))) {
        DataObject fileUploadData = 
            pageContext.getNamedDataObject("ExcelFile");
        
        if (fileUploadData == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED, 
                "Excel File"
            );
        }
        
        String fileName = (String) fileUploadData.selectValue(null, "UPLOAD_FILE_NAME");
        String contentType = (String) fileUploadData.selectValue(null, "UPLOAD_FILE_MIME_TYPE");
        
        // Validate Excel file format
        if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EXCEL_INVALID_FORMAT
            );
        }
        
        // Check file size
        Long fileSize = (Long) fileUploadData.selectValue(null, "FILE_SIZE");
        long maxSize = 10 * 1024 * 1024; // 10 MB
        
        if (fileSize > maxSize) {
            String[] tokens = {"10"};
            throw MessageHelper.createError(
                MessageConstants.ERR_EXCEL_FILE_TOO_LARGE, 
                tokens
            );
        }
        
        // Process file
        try {
            processExcelFile(fileUploadData);
            throw MessageHelper.createConfirmation(
                MessageConstants.SAVE_SUCCESS
            );
        } catch (Exception e) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EXCEL_UPLOAD
            );
        }
    }
}
```

### Example 4: Date Range Validation

```java
import oracle.jbo.domain.Date;

public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processFormRequest(pageContext, webBean);
    
    if ("search".equals(pageContext.getParameter("event"))) {
        String startDateStr = pageContext.getParameter("StartDate");
        String endDateStr = pageContext.getParameter("EndDate");
        
        try {
            Date startDate = new Date(Date.parseDate(startDateStr));
            Date endDate = new Date(Date.parseDate(endDateStr));
            
            // Validate start date before end date
            if (startDate.compareTo(endDate) > 0) {
                throw MessageHelper.createValidationError(
                    MessageConstants.ERR_START_AFTER_END, 
                    "Date Range"
                );
            }
            
            // Execute query
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            am.invokeMethod("searchByDateRange", 
                new Object[] {startDate, endDate});
                
        } catch (Exception e) {
            throw MessageHelper.createError(
                MessageConstants.ERR_INVALID_DATE
            );
        }
    }
}
```

## Application Module Examples

### Example 1: Entity Validation

```java
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

public class EmployeeAMImpl extends OAApplicationModuleImpl {
    
    public void createEmployee(String empNumber, String empName, String email) {
        // Validate duplicate employee number
        OAViewObject vo = getEmployeesVO();
        vo.setWhereClause("EMPLOYEE_NUMBER = :1");
        vo.setWhereClauseParams(null);
        vo.setWhereClauseParam(0, empNumber);
        vo.executeQuery();
        
        if (vo.hasNext()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EMP_DUPLICATE, 
                empNumber
            );
        }
        
        // Create new row
        EmployeeVORowImpl newRow = (EmployeeVORowImpl) vo.createRow();
        newRow.setEmployeeNumber(empNumber);
        newRow.setEmployeeName(empName);
        newRow.setEmail(email);
        
        vo.insertRow(newRow);
        getTransaction().commit();
    }
    
    public void deleteEmployee(String empNumber) {
        OAViewObject vo = getEmployeesVO();
        vo.setWhereClause("EMPLOYEE_NUMBER = :1");
        vo.setWhereClauseParams(null);
        vo.setWhereClauseParam(0, empNumber);
        vo.executeQuery();
        
        if (!vo.hasNext()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_EMP_NOT_FOUND, 
                empNumber
            );
        }
        
        EmployeeVORowImpl row = (EmployeeVORowImpl) vo.first();
        row.remove();
        getTransaction().commit();
    }
}
```

### Example 2: Business Rule Validation

```java
public void validateJobSalaryRange(Number minSalary, Number maxSalary) {
    if (minSalary.compareTo(maxSalary) > 0) {
        throw MessageHelper.createError(
            MessageConstants.ERR_JOB_MIN_SALARY_GT_MAX
        );
    }
    
    if (minSalary.doubleValue() < 0) {
        throw MessageHelper.createError(
            MessageConstants.ERR_SALARY_NEGATIVE
        );
    }
    
    Number maxAllowedSalary = new Number(1000000); // 1M limit
    if (maxSalary.compareTo(maxAllowedSalary) > 0) {
        String[] tokens = {
            maxSalary.toString(), 
            maxAllowedSalary.toString()
        };
        throw MessageHelper.createError(
            MessageConstants.ERR_SALARY_EXCEEDS_MAX, 
            tokens
        );
    }
}
```

## Entity Object Examples

### Example 1: Attribute Validation

```java
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

public class EmployeeEOImpl extends OAEntityImpl {
    
    public void setEmail(String value) {
        // Email format validation
        if (value != null && !value.isEmpty()) {
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            if (!value.matches(emailRegex)) {
                throw MessageHelper.createValidationError(
                    MessageConstants.ERR_EMAIL_INVALID, 
                    value
                );
            }
        }
        
        setAttributeInternal(EMAIL, value);
    }
    
    public void setSalary(Number value) {
        // Salary validation
        if (value != null) {
            if (value.doubleValue() < 0) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_SALARY_NEGATIVE
                );
            }
            
            Number maxSalary = new Number(500000);
            if (value.compareTo(maxSalary) > 0) {
                String[] tokens = {value.toString(), maxSalary.toString()};
                throw MessageHelper.createError(
                    MessageConstants.ERR_SALARY_EXCEEDS_MAX, 
                    tokens
                );
            }
        }
        
        setAttributeInternal(SALARY, value);
    }
}
```

## Token Substitution Guide

Messages in FND_MESSAGES can include tokens that are replaced at runtime:

### Single Token
```java
// Message: "Employee &EMP_NUMBER not found."
// Code:
throw MessageHelper.createError(
    MessageConstants.ERR_EMP_NOT_FOUND, 
    "12345"
);
// Result: "Employee 12345 not found."
```

### Multiple Tokens
```java
// Message: "Salary &SALARY exceeds maximum allowed &MAX_SALARY."
// Code:
String[] tokens = {"75000", "50000"};
throw MessageHelper.createError(
    MessageConstants.ERR_SALARY_EXCEEDS_MAX, 
    tokens
);
// Result: "Salary 75000 exceeds maximum allowed 50000."
```

### Field Name Token
```java
// Message: "&FIELD is required. Please provide a value."
// Code:
throw MessageHelper.createError(
    MessageConstants.ERR_FIELD_REQUIRED, 
    "Employee Name"
);
// Result: "Employee Name is required. Please provide a value."
```

## Best Practices

### ✅ DO

1. **Always use MessageHelper** instead of direct OAException instantiation
2. **Use MessageConstants** for all message codes (no magic strings)
3. **Provide field names** for better error context
4. **Use appropriate severity** (Error, Warning, Confirmation, Information)
5. **Wrap database errors** with createDatabaseError() for consistent handling
6. **Use token substitution** for dynamic values in messages

### ❌ DON'T

1. **Don't hardcode error messages** - always use message codes
2. **Don't concatenate error messages** - use token substitution
3. **Don't use generic messages** - be specific about the error
4. **Don't ignore exceptions** - always wrap and provide context
5. **Don't use wrong severity** - Error vs Warning vs Information
6. **Don't skip field context** - always provide field name when applicable

## Message Code Organization

All message codes are centralized in **MessageConstants.java**:

```java
// Application Short Names
public static final String APP_XX = "XX";
public static final String APP_XXVAL = "XXVAL";
public static final String APP_XXLAB = "XXLAB";

// Common Messages
public static final String SAVE_SUCCESS = "XX_SAVE_SUCCESS";
public static final String DELETE_SUCCESS = "XX_DELETE_SUCCESS";

// Validation Errors
public static final String ERR_FIELD_REQUIRED = "XX_FIELD_REQUIRED";
public static final String ERR_INVALID_FORMAT = "XX_INVALID_FORMAT";

// Employee Messages
public static final String ERR_EMP_NUMBER_REQUIRED = "XX_EMP_NUMBER_REQUIRED";
public static final String ERR_EMP_NOT_FOUND = "XX_EMP_NOT_FOUND";

// ... 60+ more constants
```

## Migration from Hardcoded Messages

**Before (v1.3.5 and earlier):**
```java
if (empName == null || empName.isEmpty()) {
    throw new OAException("Employee Name is required", OAException.ERROR);
}
```

**After (v1.4.0+):**
```java
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

if (empName == null || empName.isEmpty()) {
    throw MessageHelper.createError(
        MessageConstants.ERR_EMP_NAME_REQUIRED, 
        "Employee Name"
    );
}
```

## Complete Example: Employee CRUD Controller

```java
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

public class EmployeeCrudCO extends OAControllerImpl {
    
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        String event = pageContext.getParameter("event");
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Create Employee
        if ("create".equals(event)) {
            String empNumber = pageContext.getParameter("EmpNumber");
            String empName = pageContext.getParameter("EmpName");
            String email = pageContext.getParameter("Email");
            String salaryStr = pageContext.getParameter("Salary");
            
            // Validation
            if (empNumber == null || empNumber.trim().isEmpty()) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_EMP_NUMBER_REQUIRED, 
                    "Employee Number"
                );
            }
            
            if (empName == null || empName.trim().isEmpty()) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_EMP_NAME_REQUIRED, 
                    "Employee Name"
                );
            }
            
            if (email == null || email.trim().isEmpty()) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_EMAIL_REQUIRED, 
                    "Email Address"
                );
            }
            
            // Email format validation
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw MessageHelper.createValidationError(
                    MessageConstants.ERR_EMAIL_INVALID, 
                    email
                );
            }
            
            // Salary validation
            Number salary = null;
            try {
                salary = new Number(salaryStr);
                if (salary.doubleValue() < 0) {
                    throw MessageHelper.createError(
                        MessageConstants.ERR_SALARY_NEGATIVE
                    );
                }
            } catch (Exception e) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_SALARY_INVALID
                );
            }
            
            // Create employee
            try {
                am.invokeMethod("createEmployee", 
                    new Object[] {empNumber, empName, email, salary});
                
                String[] tokens = {empNumber};
                throw MessageHelper.createConfirmation(
                    MessageConstants.SAVE_SUCCESS
                );
            } catch (Exception e) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_AM_SAVE_ERROR
                );
            }
        }
        
        // Delete Employee
        else if ("delete".equals(event)) {
            OAViewObject vo = (OAViewObject) am.findViewObject("EmployeesVO");
            Row[] selectedRows = vo.getFilteredRows("SelectFlag", "Y");
            
            if (selectedRows == null || selectedRows.length == 0) {
                throw MessageHelper.createError(
                    MessageConstants.NO_ROWS_SELECTED
                );
            }
            
            for (Row row : selectedRows) {
                row.remove();
            }
            
            am.getTransaction().commit();
            throw MessageHelper.createConfirmation(
                MessageConstants.DELETE_SUCCESS
            );
        }
    }
}
```

## Related Documentation

- **[MESSAGE_CODES.md](MESSAGE_CODES.md)** - XXVAL validation message codes (v1.3.5)
- **[MESSAGE_REGISTRATION.sql](MESSAGE_REGISTRATION.sql)** - Complete FND_MESSAGES setup (v1.4.0)
- **[USAGE_EXAMPLES.md](USAGE_EXAMPLES.md)** - DataValidation utilities guide
- **[CHANGELOG.md](CHANGELOG.md)** - Version history and migration guides

## Support

For questions or issues:
- GitHub: [demasylabs/Oracle-OAF-BootCamp](https://github.com/demasylabs/Oracle-OAF-BootCamp)
- Issues: [Create an issue](https://github.com/demasylabs/Oracle-OAF-BootCamp/issues)

---

**Version**: 1.4.0  
**Last Updated**: 2025-01-30  
**Status**: Production-Ready
