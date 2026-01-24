package oracle.apps.xxcust.oaf.codebrain.labs;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.server.OAApplicationModule;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.Row;

/**
 * Lab 1: Query Page with Search Functionality
 * 
 * Classic search and results page pattern from R12 Building OAF Applications Labs.
 * Demonstrates search region with parameters and results table.
 * 
 * Lab Objective: Create a page that allows users to search for employees
 * by various criteria and display results in a table.
 * 
 * Layer: Complete Lab Example (Controller + Model integration)
 * Complexity: Beginner to Intermediate
 * Lab Reference: R12 Building OAF Applications - Lab 1/2
 * 
 * @author OAF Code Brain - Labs
 * @version 1.3
 */
public class Lab1QueryPageCO extends OAControllerImpl {

    /**
     * LAB EXERCISE 1: Initialize Query Page
     * 
     * Objective: Set up the search page with default values and clear results
     * 
     * What you'll learn:
     * - How to access the application module
     * - How to initialize View Objects
     * - How to clear search results on page load
     * 
     * Steps:
     * 1. Get the root application module
     * 2. Find the search View Object
     * 3. Set max rows to 0 (no results initially)
     * 4. Execute query (returns empty)
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Lab Step 1: Get the Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        if (!pageContext.isFormSubmission()) {
            // Lab Step 2: Find the View Object for employee search
            // Note: VO name matches what you created in JDeveloper
            OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeSearchVO");
            
            if (vo != null) {
                // Lab Step 3: Initialize with no results
                // This prevents the query from executing on initial page load
                vo.setMaxFetchSize(0);
                
                System.out.println("Query page initialized - no results shown");
            }
        }
    }

    /**
     * LAB EXERCISE 2: Handle Search Button Click
     * 
     * Objective: Process search criteria and execute query
     * 
     * What you'll learn:
     * - How to capture button events
     * - How to get search parameter values
     * - How to build dynamic WHERE clause
     * - How to execute query with parameters
     * 
     * Test Cases:
     * - Search by employee number only
     * - Search by employee name only  
     * - Search by department
     * - Search with multiple criteria
     * - Search with no criteria (show all)
     */
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        // Lab Step 1: Check if Search button was clicked
        if (pageContext.getParameter("SearchButton") != null) {
            
            // Lab Step 2: Get search criteria from the search region
            String empNumber = pageContext.getParameter("EmpNumber");
            String empName = pageContext.getParameter("EmpName");
            String department = pageContext.getParameter("Department");
            
            System.out.println("Search Parameters:");
            System.out.println("  Employee Number: " + empNumber);
            System.out.println("  Employee Name: " + empName);
            System.out.println("  Department: " + department);
            
            // Lab Step 3: Get the Application Module
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeSearchVO");
            
            if (vo != null) {
                // Lab Step 4: Build dynamic WHERE clause based on criteria
                StringBuilder whereClause = new StringBuilder();
                int paramIndex = 0;
                
                // Add employee number condition
                if (empNumber != null && !empNumber.trim().isEmpty()) {
                    whereClause.append("EMPLOYEE_NUMBER = :").append(++paramIndex);
                }
                
                // Add employee name condition (using LIKE for partial match)
                if (empName != null && !empName.trim().isEmpty()) {
                    if (whereClause.length() > 0) {
                        whereClause.append(" AND ");
                    }
                    whereClause.append("UPPER(FULL_NAME) LIKE :").append(++paramIndex);
                }
                
                // Add department condition
                if (department != null && !department.trim().isEmpty()) {
                    if (whereClause.length() > 0) {
                        whereClause.append(" AND ");
                    }
                    whereClause.append("DEPARTMENT_ID = :").append(++paramIndex);
                }
                
                // Lab Step 5: Apply WHERE clause and bind parameters
                if (whereClause.length() > 0) {
                    vo.setWhereClause(whereClause.toString());
                    
                    // Reset parameters
                    vo.setWhereClauseParams(null);
                    
                    // Bind parameters in the same order
                    paramIndex = 0;
                    
                    if (empNumber != null && !empNumber.trim().isEmpty()) {
                        vo.setWhereClauseParam(paramIndex++, empNumber);
                    }
                    
                    if (empName != null && !empName.trim().isEmpty()) {
                        vo.setWhereClauseParam(paramIndex++, "%" + empName.toUpperCase() + "%");
                    }
                    
                    if (department != null && !department.trim().isEmpty()) {
                        vo.setWhereClauseParam(paramIndex++, department);
                    }
                    
                    System.out.println("WHERE Clause: " + whereClause.toString());
                } else {
                    // No criteria - show all (optional: you may want to show a message instead)
                    vo.setWhereClause(null);
                    vo.setWhereClauseParams(null);
                }
                
                // Lab Step 6: Remove fetch limit and execute query
                vo.setMaxFetchSize(-1); // No limit
                vo.executeQuery();
                
                // Lab Step 7: Display result count
                int rowCount = vo.getRowCount();
                System.out.println("Search Results: " + rowCount + " rows found");
                
                if (rowCount == 0) {
                    throw new OAException("No employees found matching your criteria", 
                                        OAException.INFORMATION);
                }
            }
        }
        
        // Lab Step 8: Handle Clear button
        else if (pageContext.getParameter("ClearButton") != null) {
            clearSearchCriteria(pageContext, webBean);
        }
    }

    /**
     * LAB EXERCISE 3: Clear Search Functionality
     * 
     * Objective: Reset all search fields and clear results
     * 
     * What you'll learn:
     * - How to clear field values
     * - How to reset View Object state
     * - How to refresh the page
     */
    private void clearSearchCriteria(OAPageContext pageContext, OAWebBean webBean) {
        // Lab Step 1: Clear search parameters
        pageContext.putParameter("EmpNumber", "");
        pageContext.putParameter("EmpName", "");
        pageContext.putParameter("Department", "");
        
        // Lab Step 2: Clear VO and results
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        OAViewObject vo = (OAViewObject) am.findViewObject("EmployeeSearchVO");
        
        if (vo != null) {
            vo.setWhereClause(null);
            vo.setWhereClauseParams(null);
            vo.setMaxFetchSize(0);
            vo.executeQuery();
        }
        
        System.out.println("Search criteria cleared");
        
        // Optional: Show confirmation message
        throw new OAException("Search criteria cleared", OAException.INFORMATION);
    }

    /**
     * LAB EXERCISE 4 (BONUS): Add Row Selection Handler
     * 
     * Objective: Navigate to detail page when user selects a row
     * 
     * What you'll learn:
     * - How to handle row selection
     * - How to pass parameters between pages
     * - How to navigate with context
     */
    public void handleRowSelection(OAPageContext pageContext, OAWebBean webBean) {
        // Get selected employee ID from the row
        String empId = pageContext.getParameter("EmployeeId");
        
        if (empId != null) {
            System.out.println("Employee selected: " + empId);
            
            // Navigate to detail page with employee ID parameter
            // In a real lab, you'd create the detail page in Exercise 2
            HashMap params = new HashMap();
            params.put("pEmpId", empId);
            
            // Note: Replace with your actual detail page path
            pageContext.setForwardURL(
                "OA.jsp?page=/xxcust/oracle/apps/xxcust/employee/webui/EmpDetailPG",
                null,
                OAWebBeanConstants.KEEP_MENU_CONTEXT,
                null,
                params,
                true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
                OAWebBeanConstants.IGNORE_MESSAGES
            );
        }
    }

    /**
     * LAB BEST PRACTICES & TIPS
     * 
     * Query Page Pattern:
     * 1. Always validate search criteria before querying
     * 2. Use bind variables (not string concatenation) for WHERE clause
     * 3. Limit initial results (don't execute query on page load)
     * 4. Provide clear messages when no results found
     * 5. Consider performance - limit results or require minimum criteria
     * 
     * Common Lab Mistakes:
     * 1. ❌ Forgetting to reset VO parameters: setWhereClauseParams(null)
     * 2. ❌ Using string concatenation in WHERE clause (SQL injection risk)
     * 3. ❌ Not handling null/empty search criteria
     * 4. ❌ Executing query on every page refresh (check isFormSubmission)
     * 5. ❌ Wrong parameter names (must match region item names exactly)
     * 
     * Lab Enhancements (Try on your own):
     * - Add date range search (hire date from/to)
     * - Add sorting functionality
     * - Add export to Excel
     * - Add pagination for large result sets
     * - Add "Advanced Search" with more criteria
     * 
     * Testing Checklist:
     * ✓ Page loads without error
     * ✓ Search with single criterion works
     * ✓ Search with multiple criteria works
     * ✓ Clear button resets form
     * ✓ No results shows appropriate message
     * ✓ Results display correctly in table
     */
}
