package oracle.apps.xxcust.oaf.codebrain.labs;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.server.OAApplicationModule;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

/**
 * Lab 3: Master-Detail Page Pattern
 * 
 * Classic master-detail pattern from R12 Building OAF Applications Labs.
 * Demonstrates parent-child relationship with coordinated queries.
 * 
 * Lab Objective: Create a page showing employees (master) and their
 * job history (detail) with synchronized display using view links.
 * 
 * Scenario: 
 * - Master: Employee list
 * - Detail: Job history for selected employee
 * - When user selects employee, detail automatically refreshes
 * 
 * Layer: Complete Lab Example (Controller + Model integration)
 * Complexity: Intermediate to Advanced
 * Lab Reference: R12 Building OAF Applications - Lab 5/6
 * 
 * @author OAF Code Brain - Labs
 * @version 1.3
 */
public class Lab3MasterDetailPageCO extends OAControllerImpl {

    /**
     * LAB EXERCISE 1: Initialize Master-Detail Page
     * 
     * Objective: Set up master-detail relationship
     * 
     * What you'll learn:
     * - How to query master records
     * - How to set up view link between master and detail
     * - How to initialize empty detail on page load
     * - How to handle first row selection
     * 
     * Architecture:
     * - Master VO: EmployeeVO (all employees)
     * - Detail VO: JobHistoryVO (filtered by employee ID)
     * - View Link: EmployeeJobHistoryVL (master-detail relationship)
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Lab Step 1: Get the Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        if (!pageContext.isFormSubmission()) {
            
            // Lab Step 2: Get Master View Object (Employees)
            OAViewObject masterVO = (OAViewObject) am.findViewObject("EmployeeVO");
            
            if (masterVO == null) {
                throw new OAException("Employee View Object not found");
            }
            
            // Lab Step 3: Execute master query (show all employees)
            // In a real scenario, you might want to add search criteria
            masterVO.setWhereClause(null);
            masterVO.setWhereClauseParams(null);
            masterVO.setMaxFetchSize(100); // Limit for performance
            masterVO.executeQuery();
            
            System.out.println("Master VO executed: " + masterVO.getRowCount() + " employees");
            
            // Lab Step 4: Get Detail View Object (Job History)
            OAViewObject detailVO = (OAViewObject) am.findViewObject("JobHistoryVO");
            
            if (detailVO == null) {
                throw new OAException("Job History View Object not found");
            }
            
            // Lab Step 5: Initialize detail with no data
            // Detail will be populated when user selects a master row
            detailVO.setWhereClause("1=2"); // No rows
            detailVO.executeQuery();
            
            System.out.println("Detail VO initialized (empty)");
            
            // Lab Step 6 (Optional): Auto-select first employee
            if (masterVO.hasNext()) {
                Row firstRow = masterVO.first();
                masterVO.setCurrentRow(firstRow);
                
                // Get employee ID and load detail
                String empId = (String) firstRow.getAttribute("EmployeeId");
                loadJobHistoryForEmployee(pageContext, am, empId);
            }
        }
    }

    /**
     * LAB EXERCISE 2: Handle Master Row Selection
     * 
     * Objective: Refresh detail when master selection changes
     * 
     * What you'll learn:
     * - How to detect row selection change
     * - How to get selected row data
     * - How to filter detail VO based on master
     * - How to handle no selection scenario
     * 
     * PPR (Partial Page Rendering):
     * - Only the detail region refreshes
     * - Master region remains unchanged
     * - Improves user experience and performance
     */
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        // Lab Step 1: Check if master row selection changed
        String event = pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM);
        
        if ("masterRowSelect".equals(event)) {
            
            System.out.println("Master row selection changed");
            
            // Lab Step 2: Get Application Module
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            
            // Lab Step 3: Get selected employee ID from parameter
            String empId = pageContext.getParameter("pEmpId");
            
            if (empId != null && !empId.trim().isEmpty()) {
                
                System.out.println("Selected Employee ID: " + empId);
                
                // Lab Step 4: Load job history for selected employee
                loadJobHistoryForEmployee(pageContext, am, empId);
                
            } else {
                // No selection - clear detail
                clearJobHistory(am);
            }
        }
        
        // Lab Step 5: Handle Add Job History button
        else if (pageContext.getParameter("AddJobHistory") != null) {
            handleAddJobHistory(pageContext, webBean);
        }
        
        // Lab Step 6: Handle Delete Job History button
        else if (pageContext.getParameter("DeleteJobHistory") != null) {
            handleDeleteJobHistory(pageContext, webBean);
        }
    }

    /**
     * LAB EXERCISE 3: Load Job History for Selected Employee
     * 
     * Objective: Query and display job history for selected employee
     * 
     * What you'll learn:
     * - How to filter detail VO by foreign key
     * - How to use bind variables
     * - How to handle empty results
     * - How to display record count
     */
    private void loadJobHistoryForEmployee(OAPageContext pageContext,
                                           OAApplicationModule am,
                                           String empId) {
        
        System.out.println("Loading job history for employee: " + empId);
        
        // Lab Step 1: Get Detail View Object
        OAViewObject detailVO = (OAViewObject) am.findViewObject("JobHistoryVO");
        
        if (detailVO != null) {
            
            // Lab Step 2: Set WHERE clause to filter by employee ID
            detailVO.setWhereClause("EMPLOYEE_ID = :1");
            detailVO.setWhereClauseParams(null);
            detailVO.setWhereClauseParam(0, empId);
            
            // Lab Step 3: Add ORDER BY for chronological display
            detailVO.setOrderByClause("START_DATE DESC");
            
            // Lab Step 4: Execute query
            detailVO.executeQuery();
            
            // Lab Step 5: Get and display count
            int historyCount = detailVO.getRowCount();
            System.out.println("Job history records found: " + historyCount);
            
            // Lab Step 6 (Optional): Store count for display
            pageContext.putSessionValue("JobHistoryCount", historyCount);
            
            if (historyCount == 0) {
                System.out.println("No job history found for this employee");
                // Optionally show message
                // throw new OAException("No job history found", OAException.INFORMATION);
            }
        }
    }

    /**
     * LAB EXERCISE 4: Clear Job History Display
     * 
     * Objective: Clear detail when no master row is selected
     * 
     * What you'll learn:
     * - How to clear VO results
     * - How to reset query state
     */
    private void clearJobHistory(OAApplicationModule am) {
        
        System.out.println("Clearing job history display");
        
        OAViewObject detailVO = (OAViewObject) am.findViewObject("JobHistoryVO");
        
        if (detailVO != null) {
            // Set impossible WHERE clause to return no rows
            detailVO.setWhereClause("1=2");
            detailVO.setWhereClauseParams(null);
            detailVO.executeQuery();
            
            System.out.println("Job history cleared");
        }
    }

    /**
     * LAB EXERCISE 5: Add New Job History Record
     * 
     * Objective: Add new job history entry for selected employee
     * 
     * What you'll learn:
     * - How to create detail record linked to master
     * - How to set foreign key automatically
     * - How to populate default values
     * - How to maintain master-detail integrity
     */
    private void handleAddJobHistory(OAPageContext pageContext, OAWebBean webBean) {
        
        System.out.println("Add Job History button clicked");
        
        // Lab Step 1: Get Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Lab Step 2: Get master VO and current employee
        OAViewObject masterVO = (OAViewObject) am.findViewObject("EmployeeVO");
        Row masterRow = masterVO.getCurrentRow();
        
        if (masterRow == null) {
            throw new OAException("Please select an employee first", OAException.ERROR);
        }
        
        String empId = (String) masterRow.getAttribute("EmployeeId");
        String empName = (String) masterRow.getAttribute("FullName");
        
        // Lab Step 3: Get detail VO
        OAViewObject detailVO = (OAViewObject) am.findViewObject("JobHistoryVO");
        
        if (detailVO != null) {
            
            // Lab Step 4: Create new detail row
            Row newRow = detailVO.createRow();
            
            // Lab Step 5: Set foreign key (link to master)
            newRow.setAttribute("EmployeeId", empId);
            
            // Lab Step 6: Set default values
            newRow.setAttribute("StartDate", pageContext.getCurrentDBDate());
            newRow.setAttribute("Status", "ACTIVE");
            newRow.setAttribute("CreatedBy", pageContext.getUserId());
            newRow.setAttribute("CreationDate", pageContext.getCurrentDBDate());
            newRow.setAttribute("LastUpdatedBy", pageContext.getUserId());
            newRow.setAttribute("LastUpdateDate", pageContext.getCurrentDBDate());
            
            // Lab Step 7: Insert row into VO
            detailVO.insertRow(newRow);
            detailVO.setCurrentRow(newRow);
            
            System.out.println("New job history record created for: " + empName);
            
            // Note: Record is not yet committed to database
            // User needs to fill in remaining fields and click Apply
            
            throw new OAException(
                "New job history entry created. Please fill in the details and click Apply.",
                OAException.INFORMATION
            );
        }
    }

    /**
     * LAB EXERCISE 6: Delete Job History Record
     * 
     * Objective: Remove selected job history entry
     * 
     * What you'll learn:
     * - How to delete detail record
     * - How to get selected row in detail
     * - How to commit delete operation
     * - How to refresh display after delete
     */
    private void handleDeleteJobHistory(OAPageContext pageContext, OAWebBean webBean) {
        
        System.out.println("Delete Job History button clicked");
        
        // Lab Step 1: Get job history ID from parameter
        String jobHistId = pageContext.getParameter("pJobHistId");
        
        if (jobHistId == null || jobHistId.trim().isEmpty()) {
            throw new OAException("Please select a job history record to delete", 
                                OAException.ERROR);
        }
        
        // Lab Step 2: Get Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        OAViewObject detailVO = (OAViewObject) am.findViewObject("JobHistoryVO");
        
        if (detailVO != null) {
            
            // Lab Step 3: Find the row to delete
            Row[] rows = detailVO.getFilteredRows("JobHistoryId", jobHistId);
            
            if (rows != null && rows.length > 0) {
                Row rowToDelete = rows[0];
                
                try {
                    // Lab Step 4: Mark row for deletion
                    rowToDelete.remove();
                    
                    // Lab Step 5: Commit the transaction
                    am.getTransaction().commit();
                    
                    System.out.println("Job history record deleted: " + jobHistId);
                    
                    // Lab Step 6: Refresh the detail display
                    String empId = pageContext.getParameter("pEmpId");
                    if (empId != null) {
                        loadJobHistoryForEmployee(pageContext, am, empId);
                    }
                    
                    throw new OAException(
                        "Job history record deleted successfully",
                        OAException.CONFIRMATION
                    );
                    
                } catch (Exception e) {
                    // Lab Step 7: Rollback on error
                    am.getTransaction().rollback();
                    
                    System.err.println("Error deleting job history: " + e.getMessage());
                    
                    throw new OAException(
                        "Error deleting job history: " + e.getMessage(),
                        OAException.ERROR
                    );
                }
            } else {
                throw new OAException("Job history record not found", OAException.ERROR);
            }
        }
    }

    /**
     * LAB BEST PRACTICES & TIPS
     * 
     * Master-Detail Page Pattern:
     * 1. Use View Links to establish master-detail relationship in BC4J
     * 2. Initialize detail as empty until master selection
     * 3. Use PPR for detail refresh (better performance)
     * 4. Always validate master selection before detail operations
     * 5. Set foreign key automatically when creating detail records
     * 6. Use appropriate ORDER BY for detail records
     * 
     * Common Lab Mistakes:
     * 1. ❌ Not checking if master row is selected before detail operations
     * 2. ❌ Forgetting to set foreign key when creating detail record
     * 3. ❌ Not refreshing detail after add/delete operations
     * 4. ❌ Querying detail before master is loaded
     * 5. ❌ Not using PPR (page refreshes completely)
     * 
     * Lab Enhancements (Try on your own):
     * - Add search/filter in master region
     * - Add pagination for master records
     * - Add inline edit in detail table
     * - Add "Copy to New" functionality
     * - Add summary/aggregate in detail (total years, current position)
     * - Add multiple detail sections (job history, education, certifications)
     * - Add drill-down to third level (position -> projects)
     * 
     * Testing Checklist:
     * ✓ Master query loads successfully
     * ✓ Detail is empty on initial page load
     * ✓ Detail refreshes when master selection changes
     * ✓ Add new detail record works
     * ✓ Foreign key set correctly in new record
     * ✓ Delete detail record works
     * ✓ Detail display refreshes after delete
     * ✓ Validation prevents orphan records
     * ✓ PPR works without full page refresh
     * 
     * Architecture Notes:
     * - Master VO: Independent query
     * - Detail VO: Filtered by master foreign key
     * - View Link: Defines master-detail relationship
     * - Accessor: Method in master VO to access detail
     * - One master row -> Many detail rows
     */
}
