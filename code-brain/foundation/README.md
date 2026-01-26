# OAF Foundation Framework

## Overview

The **OAF Foundation Framework** is a production-ready, enterprise-grade library of reusable Oracle OAF components designed for Oracle E-Business Suite R12.2.x. It provides base classes, utilities, security modules, and diagnostic tools that eliminate code duplication and enforce Oracle best practices.

## Architecture

```
foundation/
├── base/                    # Base Classes (4 files)
│   ├── BaseController.java
│   ├── BaseApplicationModule.java
│   ├── BaseViewObject.java
│   └── BaseEntityObject.java
├── utilities/               # Utility Modules (5 files)
│   ├── VOExecutor.java
│   ├── ParameterHelper.java
│   ├── ValidationHelper.java
│   ├── TransactionHelper.java
│   └── BindVariableHelper.java
├── security/                # Security Modules (2 files)
│   ├── SecurityValidator.java
│   └── UserContextHelper.java
└── diagnostics/             # Diagnostic Modules (2 files)
    ├── DiagnosticsLogger.java
    └── PerformanceMonitor.java
```

## Key Benefits

### ✅ Eliminates Hardcoded VO Names
**Before (Anti-Pattern):**
```java
EmployeeVOImpl vo = (EmployeeVOImpl) getEmployeeVO1();
vo.executeQuery();
```

**After (Generic Pattern):**
```java
OAViewObject vo = findVO("EmployeeSearchVO");
executeVO(vo);
```

### ✅ Prevents SQL Injection
**Before (Vulnerable):**
```java
vo.setWhereClause("EMPLOYEE_NAME = '" + userInput + "'");  // DANGEROUS!
```

**After (Secure):**
```java
setVOWhereClause("EmployeeSearchVO", "EMPLOYEE_NAME = :1", new Object[]{userInput});
```

### ✅ Automatic WHO Column Management
**Before (Manual):**
```java
row.setAttribute("CreatedBy", pageContext.getUserId());
row.setAttribute("CreationDate", getCurrentDate());
// ... 5 more WHO columns!
```

**After (Automatic):**
```java
// WHO columns populated automatically in BaseEntityObject.doDML()
```

## Quick Start Guide

### 1. Extend Base Classes

#### Controller Extension
```java
package oracle.apps.xx.employee.webui;

import oracle.apps.fnd.framework.foundation.base.BaseController;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

public class EmployeeCO extends BaseController {
    
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Use inherited helpers
        String empId = getRequiredParameter(pageContext, "empId");
        logDebug(pageContext, "Processing employee: " + empId);
    }
    
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        if (isEvent(pageContext, "search")) {
            handleSearch(pageContext);
        } else if (isEvent(pageContext, "create")) {
            handleCreate(pageContext);
        }
    }
    
    private void handleSearch(OAPageContext pageContext) {
        OAApplicationModule am = getRootAM(pageContext);
        // Use generic VO execution
        OAViewObject vo = findVO(am, "EmployeeSearchVO");
        executeVO(vo);
    }
}
```

#### Application Module Extension
```java
package oracle.apps.xx.employee.server;

import oracle.apps.fnd.framework.foundation.base.BaseApplicationModule;
import oracle.apps.fnd.framework.server.OAViewObject;

public class EmployeeAMImpl extends BaseApplicationModule {
    
    public void searchEmployees(String name, String department) {
        logProcedureEntry("searchEmployees");
        
        // Generic VO access - no hardcoded getEmployeeVO1()!
        OAViewObject vo = getVO("EmployeeSearchVO");
        
        // Secure search with bind variables
        setVOWhereClause("EmployeeSearchVO", 
                        "EMPLOYEE_NAME LIKE :1 AND DEPARTMENT_ID = :2",
                        new Object[]{name + "%", department});
        
        executeVO(vo);
        logDebug("searchEmployees", "Found " + getRowCount("EmployeeSearchVO") + " rows");
    }
    
    public void createEmployee(String name, String email, Number salary) {
        validateRequired(name, "Employee Name");
        validateRequired(email, "Email");
        validateRange(salary, 0, 999999, "Salary");
        
        OAViewObject vo = getVO("EmployeeVO");
        Row row = createRow("EmployeeVO");
        row.setAttribute("EmployeeName", name);
        row.setAttribute("Email", email);
        row.setAttribute("Salary", salary);
        
        commitTransaction();
    }
}
```

#### View Object Extension
```java
package oracle.apps.xx.employee.server;

import oracle.apps.fnd.framework.foundation.base.BaseViewObject;

public class EmployeeVOImpl extends BaseViewObject {
    
    public void searchByName(String name) {
        // Use ViewCriteria for SQL injection safety
        applyViewCriteria("NameSearchVC", new Object[]{name + "%"});
    }
    
    public void searchByDepartment(String deptId) {
        // Secure WHERE clause with bind variables
        setSecureWhereClause("DEPARTMENT_ID = :1", new Object[]{deptId});
        executeQuery();
    }
}
```

#### Entity Object Extension
```java
package oracle.apps.xx.employee.schema.server;

import oracle.apps.fnd.framework.foundation.base.BaseEntityObject;
import oracle.jbo.AttributeList;

public class EmployeeEOImpl extends BaseEntityObject {
    
    // WHO columns populated automatically!
    
    protected void validateEntity() {
        super.validateEntity();
        
        // Use inherited validation helpers
        validateRequired(getEmployeeName(), "Employee Name");
        validateEmail(getEmail(), "Email Address");
        validateRange(getSalary(), 0, 999999, "Salary");
        validateLength(getEmployeeName(), 100, "Employee Name");
    }
    
    // Enable auto-sequence for primary key
    protected String getSequenceName() {
        return "XX_EMPLOYEES_S";
    }
    
    // Getters/Setters
    public String getEmployeeName() {
        return getStringAttribute("EmployeeName");
    }
    
    public void setEmployeeName(String value) {
        setAttributeValue("EmployeeName", value);
    }
}
```

### 2. Use Utility Modules

#### VOExecutor - Generic VO Operations
```java
import oracle.apps.fnd.framework.foundation.utilities.VOExecutor;

// Find and execute VO
OAViewObject vo = VOExecutor.findVO(am, "EmployeeSearchVO");
VOExecutor.executeQuery(vo);

// Execute with WHERE clause
VOExecutor.executeWithWhereClause(vo, "EMPLOYEE_ID = :1", new Object[]{empId});

// Check if VO has rows
if (VOExecutor.hasRows(vo)) {
    Row row = VOExecutor.getCurrentRow(vo);
}
```

#### ParameterHelper - Request Parameters
```java
import oracle.apps.fnd.framework.foundation.utilities.ParameterHelper;

// Required parameter (throws exception if missing)
String empId = ParameterHelper.getRequiredParameter(pageContext, "empId");

// Optional with default
String deptId = ParameterHelper.getParameter(pageContext, "deptId", "10");

// Type conversion
int pageNum = ParameterHelper.getIntParameter(pageContext, "page", 1);
boolean isActive = ParameterHelper.getBooleanParameter(pageContext, "active", true);
```

#### ValidationHelper - Business Validations
```java
import oracle.apps.fnd.framework.foundation.utilities.ValidationHelper;

// Required field
ValidationHelper.validateRequired(employeeName, "Employee Name");

// Range validation
ValidationHelper.validateRange(salary, 0, 999999, "Salary");

// Date range
ValidationHelper.validateDateRange(hireDate, minDate, maxDate, "Hire Date");

// Email format
ValidationHelper.validateEmail(email, "Email Address");

// From-To validation
ValidationHelper.validateFromToDateRange(startDate, endDate, "Start Date", "End Date");
```

### 3. Security Best Practices

#### SecurityValidator - SQL Injection Prevention
```java
import oracle.apps.fnd.framework.foundation.security.SecurityValidator;

// Validate user input
String safeInput = SecurityValidator.sanitizeInput(userInput);

// Check for SQL injection
if (SecurityValidator.containsSQLInjection(userInput)) {
    throw new OAException("Invalid input");
}

// Validate alphanumeric only
SecurityValidator.validateAlphanumeric(employeeNumber, "Employee Number");

// Validate no XSS
SecurityValidator.validateNoXSS(userInput, "Comments");
```

#### UserContextHelper - User Information
```java
import oracle.apps.fnd.framework.foundation.security.UserContextHelper;

// Get current user info
Number userId = UserContextHelper.getUserId(pageContext);
String userName = UserContextHelper.getUserName(pageContext);
Number respId = UserContextHelper.getResponsibilityId(pageContext);

// Get profile values
String orgId = UserContextHelper.getOrgId(pageContext);
String langCode = UserContextHelper.getLanguageCode(pageContext);
```

### 4. Diagnostics & Performance

#### DiagnosticsLogger - Standardized Logging
```java
import oracle.apps.fnd.framework.foundation.diagnostics.DiagnosticsLogger;

// Log method entry/exit
DiagnosticsLogger.logMethodEntry(pageContext, this, "processRequest");
DiagnosticsLogger.logMethodExit(pageContext, this, "processRequest");

// Log parameters
DiagnosticsLogger.logParameter(pageContext, this, "empId", empId);

// Log exceptions
DiagnosticsLogger.logException(pageContext, this, "Search failed", e);

// Log SQL
DiagnosticsLogger.logSQL(pageContext, this, vo.getQuery());
```

#### PerformanceMonitor - Performance Tracking
```java
import oracle.apps.fnd.framework.foundation.diagnostics.PerformanceMonitor;

// Measure execution time
long startTime = PerformanceMonitor.startTimer();
// ... execute operation ...
long elapsed = PerformanceMonitor.stopTimer(startTime, "Search operation");

// Log VO performance
PerformanceMonitor.logVOQueryTime(vo);
PerformanceMonitor.logRowCount(vo, "EmployeeSearchVO");

// Log generated SQL
PerformanceMonitor.logGeneratedSQL(vo);
```

## Migration Guide

### Before (Anti-Patterns)
```java
// ❌ Hardcoded VO name
EmployeeVOImpl vo = (EmployeeVOImpl) getEmployeeVO1();

// ❌ SQL injection vulnerability
vo.setWhereClause("NAME = '" + userInput + "'");

// ❌ Manual WHO columns
row.setAttribute("CreatedBy", userId);
row.setAttribute("CreationDate", sysDate);
row.setAttribute("LastUpdatedBy", userId);
// ... 3 more lines!

// ❌ Scattered validation
if (empName == null || empName.trim().length() == 0) {
    throw new OAException("Name required");
}
```

### After (Best Practices)
```java
// ✅ Generic VO access
OAViewObject vo = findVO("EmployeeSearchVO");

// ✅ SQL injection safe
setVOWhereClause("EmployeeSearchVO", "NAME = :1", new Object[]{userInput});

// ✅ Automatic WHO columns (no code needed!)

// ✅ Centralized validation
validateRequired(empName, "Employee Name");
```

## Version History

- **v1.0.0** (2026-01-26): Initial release
  - 4 base classes (Controller, AM, VO, EO)
  - 5 utility modules
  - 2 security modules
  - 2 diagnostic modules
  - ~3,500 lines of production-ready code

## Best Practices

### ✅ DO
- Extend all base classes (BaseController, BaseApplicationModule, etc.)
- Use ViewCriteria for search instead of setWhereClause
- Use bind variables (:1, :2) instead of string concatenation
- Use generic helpers (findVO, executeVO, resetVO) instead of hardcoded methods
- Let BaseEntityObject handle WHO columns automatically
- Use validation helpers for consistent error messages

### ❌ DON'T
- Don't concatenate user input into SQL (SQL injection!)
- Don't hardcode VO names (getEmployeeVO1, getDepartmentVO2)
- Don't manually populate WHO columns
- Don't duplicate validation logic across files
- Don't use raw JDBC in Controllers (use PLSQL helpers in AM)

## Support

For questions or issues:
- Review code-brain/ examples
- Check JavaDoc in each class
- Refer to Oracle OAF Developer Guide

## License

Internal use - Oracle E-Business Suite R12.2.x custom development.
