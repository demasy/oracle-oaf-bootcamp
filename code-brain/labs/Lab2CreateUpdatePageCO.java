package oracle.apps.xxcust.oaf.codebrain.labs;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.server.OAApplicationModule;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OARow;
import oracle.jbo.Row;
import java.sql.SQLException;

/**
 * Lab 2: Create and Update Page (CRUD Operations)
 * 
 * Complete CRUD pattern from R12 Building OAF Applications Labs.
 * Demonstrates Create, Read, Update operations on a single record.
 * 
 * Lab Objective: Create a page that allows users to create new employee
 * records or update existing ones with validation.
 * 
 * Layer: Complete Lab Example (Controller + Model integration)
 * Complexity: Intermediate
 * Lab Reference: R12 Building OAF Applications - Lab 3/4
 * 
 * @author OAF Code Brain - Labs
 * @version 1.3
 */
public class Lab2CreateUpdatePageCO extends OAControllerImpl {

    /**
     * LAB EXERCISE 1: Initialize Page for Create or Update
     * 
     * Objective: Determine if page is in CREATE or UPDATE mode
     * 
     * What you'll learn:
     * - How to distinguish between Create and Update modes
     * - How to load existing data for Update
     * - How to initialize new row for Create
     * - How to set page title dynamically
     * 
     * Page Modes:
     * - CREATE: No employee ID parameter, create new row
     * - UPDATE: Employee ID parameter present, load existing data
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Lab Step 1: Get the Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Lab Step 2: Check for employee ID parameter
        String empId = pageContext.getParameter("pEmpId");
        
        // Lab Step 3: Get the View Object
        OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeVO");
        
        if (vo == null) {
            throw new OAException("Employee View Object not found");
        }
        
        // Lab Step 4: Determine mode and initialize accordingly
        if (empId != null && !empId.trim().isEmpty()) {
            // UPDATE MODE
            System.out.println("Page Mode: UPDATE - Employee ID: " + empId);
            
            // Load the specific employee record
            vo.setWhereClause("EMPLOYEE_ID = :1");
            vo.setWhereClauseParams(null);
            vo.setWhereClauseParam(0, empId);
            vo.executeQuery();
            
            // Verify record found
            if (vo.hasNext()) {
                Row row = vo.first();
                vo.setCurrentRow(row);
                
                // Set page title for update mode
                pageContext.putSessionValue("PageTitle", "Update Employee");
                System.out.println("Loaded employee: " + row.getAttribute("FullName"));
            } else {
                throw new OAException("Employee not found with ID: " + empId, 
                                    OAException.ERROR);
            }
            
        } else {
            // CREATE MODE
            System.out.println("Page Mode: CREATE");
            
            // Check if we already created a row in this session
            if (!pageContext.isFormSubmission()) {
                // Create new row for data entry
                Row row = vo.createRow();
                
                // Set default values
                row.setAttribute("Status", "ACTIVE");
                row.setAttribute("CreatedBy", pageContext.getUserId());
                row.setAttribute("CreationDate", pageContext.getCurrentDBDate());
                row.setAttribute("LastUpdatedBy", pageContext.getUserId());
                row.setAttribute("LastUpdateDate", pageContext.getCurrentDBDate());
                
                // Insert into VO (not yet committed to database)
                vo.insertRow(row);
                vo.setCurrentRow(row);
                
                // Set page title for create mode
                pageContext.putSessionValue("PageTitle", "Create Employee");
                System.out.println("New employee row created");
            }
        }
    }

    /**
     * LAB EXERCISE 2: Handle Apply (Save) Button
     * 
     * Objective: Validate and save employee data
     * 
     * What you'll learn:
     * - How to validate user input
     * - How to handle required fields
     * - How to commit changes to database
     * - How to handle database errors
     * - How to show success messages
     * 
     * Validation Rules:
     * - Employee Number: Required, must be unique
     * - Full Name: Required
     * - Email: Required, valid format
     * - Salary: Optional, must be positive if provided
     */
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        // Lab Step 1: Check if Apply button was clicked
        if (pageContext.getParameter("Apply") != null) {
            
            System.out.println("Apply button clicked - saving data");
            
            // Lab Step 2: Get the Application Module and View Object
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeVO");
            
            if (vo != null) {
                Row row = vo.getCurrentRow();
                
                if (row != null) {
                    try {
                        // Lab Step 3: Perform validations
                        validateEmployeeData(pageContext, row);
                        
                        // Lab Step 4: Set WHO columns for audit
                        row.setAttribute("LastUpdatedBy", pageContext.getUserId());
                        row.setAttribute("LastUpdateDate", pageContext.getCurrentDBDate());
                        
                        // Lab Step 5: Commit the transaction
                        am.getTransaction().commit();
                        
                        // Lab Step 6: Get the saved employee ID
                        String savedEmpId = (String) row.getAttribute("EmployeeId");
                        String empName = (String) row.getAttribute("FullName");
                        
                        System.out.println("Employee saved successfully: " + empName + 
                                         " (ID: " + savedEmpId + ")");
                        
                        // Lab Step 7: Show success message and navigate back
                        throw new OAException(
                            "Employee " + empName + " saved successfully",
                            OAException.CONFIRMATION
                        );
                        
                        // Optional: Navigate back to search page
                        // pageContext.forwardImmediately("OA.jsp?page=/xxcust/.../EmpSearchPG", 
                        //                               null, 
                        //                               OAWebBeanConstants.KEEP_MENU_CONTEXT,
                        //                               null, null, false, 
                        //                               OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
                        
                    } catch (SQLException e) {
                        // Lab Step 8: Handle database errors
                        am.getTransaction().rollback();
                        
                        System.err.println("SQL Error: " + e.getMessage());
                        System.err.println("SQL Code: " + e.getErrorCode());
                        
                        // Check for specific errors
                        if (e.getErrorCode() == 1) {
                            // ORA-00001: Unique constraint violated
                            throw new OAException(
                                "Employee Number already exists. Please use a different number.",
                                OAException.ERROR
                            );
                        } else if (e.getErrorCode() == 1400) {
                            // ORA-01400: Cannot insert NULL
                            throw new OAException(
                                "Required field is missing. Please fill all mandatory fields.",
                                OAException.ERROR
                            );
                        } else {
                            throw new OAException(
                                "Error saving employee: " + e.getMessage(),
                                OAException.ERROR
                            );
                        }
                    }
                }
            }
        }
        
        // Lab Step 9: Handle Cancel button
        else if (pageContext.getParameter("Cancel") != null) {
            handleCancel(pageContext, webBean);
        }
        
        // Lab Step 10: Handle Delete button (if in update mode)
        else if (pageContext.getParameter("Delete") != null) {
            handleDelete(pageContext, webBean);
        }
    }

    /**
     * LAB EXERCISE 3: Validate Employee Data
     * 
     * Objective: Implement business validation rules
     * 
     * What you'll learn:
     * - How to validate required fields
     * - How to validate data format
     * - How to validate business rules
     * - How to throw validation errors
     */
    private void validateEmployeeData(OAPageContext pageContext, Row row) {
        
        // Validation 1: Employee Number (Required)
        String empNumber = (String) row.getAttribute("EmployeeNumber");
        if (empNumber == null || empNumber.trim().isEmpty()) {
            throw new OAException("Employee Number is required", OAException.ERROR);
        }
        
        // Validation 2: Full Name (Required)
        String fullName = (String) row.getAttribute("FullName");
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new OAException("Employee Name is required", OAException.ERROR);
        }
        
        // Validation 3: Email (Required and valid format)
        String email = (String) row.getAttribute("Email");
        if (email == null || email.trim().isEmpty()) {
            throw new OAException("Email is required", OAException.ERROR);
        }
        
        if (!email.contains("@") || !email.contains(".")) {
            throw new OAException("Invalid email format", OAException.ERROR);
        }
        
        // Validation 4: Salary (Must be positive if provided)
        Object salaryObj = row.getAttribute("Salary");
        if (salaryObj != null) {
            try {
                double salary = Double.parseDouble(salaryObj.toString());
                if (salary < 0) {
                    throw new OAException("Salary cannot be negative", OAException.ERROR);
                }
                if (salary > 999999) {
                    throw new OAException("Salary exceeds maximum allowed value", 
                                        OAException.ERROR);
                }
            } catch (NumberFormatException e) {
                throw new OAException("Invalid salary value", OAException.ERROR);
            }
        }
        
        // Validation 5: Hire Date (Cannot be future date)
        Object hireDateObj = row.getAttribute("HireDate");
        if (hireDateObj != null) {
            java.sql.Date hireDate = (java.sql.Date) hireDateObj;
            java.sql.Date currentDate = pageContext.getCurrentDBDate();
            
            if (hireDate.after(currentDate)) {
                throw new OAException("Hire Date cannot be in the future", 
                                    OAException.ERROR);
            }
        }
        
        System.out.println("All validations passed");
    }

    /**
     * LAB EXERCISE 4: Handle Cancel Operation
     * 
     * Objective: Discard changes and return to previous page
     * 
     * What you'll learn:
     * - How to rollback changes
     * - How to clean up uncommitted data
     * - How to navigate back
     */
    private void handleCancel(OAPageContext pageContext, OAWebBean webBean) {
        System.out.println("Cancel button clicked");
        
        // Rollback any uncommitted changes
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        am.getTransaction().rollback();
        
        System.out.println("Changes discarded");
        
        // Navigate back to search page
        // In a real lab, replace with your actual search page path
        pageContext.forwardImmediately(
            "OA.jsp?page=/xxcust/oracle/apps/xxcust/employee/webui/EmpSearchPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null, null, false,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO
        );
    }

    /**
     * LAB EXERCISE 5 (BONUS): Handle Delete Operation
     * 
     * Objective: Delete employee record with confirmation
     * 
     * What you'll learn:
     * - How to delete a record
     * - How to show confirmation dialog
     * - How to handle delete dependencies
     */
    private void handleDelete(OAPageContext pageContext, OAWebBean webBean) {
        System.out.println("Delete button clicked");
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeVO");
        
        if (vo != null) {
            Row row = vo.getCurrentRow();
            
            if (row != null) {
                String empName = (String) row.getAttribute("FullName");
                String empId = (String) row.getAttribute("EmployeeId");
                
                try {
                    // Mark row for deletion
                    row.remove();
                    
                    // Commit the deletion
                    am.getTransaction().commit();
                    
                    System.out.println("Employee deleted: " + empName);
                    
                    throw new OAException(
                        "Employee " + empName + " deleted successfully",
                        OAException.CONFIRMATION
                    );
                    
                } catch (Exception e) {
                    am.getTransaction().rollback();
                    
                    System.err.println("Delete error: " + e.getMessage());
                    
                    throw new OAException(
                        "Cannot delete employee: " + e.getMessage(),
                        OAException.ERROR
                    );
                }
            }
        }
    }

    /**
     * LAB BEST PRACTICES & TIPS
     * 
     * Create/Update Page Pattern:
     * 1. Always validate data before committing
     * 2. Use WHO columns (Created By/Date, Last Updated By/Date)
     * 3. Handle unique constraint violations gracefully
     * 4. Rollback on any error
     * 5. Provide clear success/error messages
     * 6. Navigate back after successful save
     * 
     * Common Lab Mistakes:
     * 1. ❌ Not checking if row is null before accessing attributes
     * 2. ❌ Forgetting to rollback on error
     * 3. ❌ Not validating required fields
     * 4. ❌ Committing without proper error handling
     * 5. ❌ Not updating WHO columns (audit trail)
     * 
     * Lab Enhancements (Try on your own):
     * - Add confirmation dialog before delete
     * - Add "Save and New" button
     * - Add field-level validation (onSubmit)
     * - Add duplicate check before save
     * - Add attachment functionality
     * - Add history/audit log display
     * 
     * Testing Checklist:
     * ✓ Create new employee successfully
     * ✓ Update existing employee
     * ✓ Required field validation works
     * ✓ Email format validation works
     * ✓ Salary validation works
     * ✓ Cancel discards changes
     * ✓ Delete removes record
     * ✓ Duplicate employee number shows error
     * ✓ Success messages display correctly
     */
}
