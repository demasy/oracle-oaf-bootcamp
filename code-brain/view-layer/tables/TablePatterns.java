package oracle.apps.xxcust.oaf.codebrain.view.tables;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;
import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;
import oracle.apps.fnd.framework.webui.beans.table.OAColumnBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.layout.OARowLayoutBean;
import oracle.apps.fnd.framework.webui.beans.layout.OACellFormatBean;
import oracle.apps.fnd.framework.webui.beans.nav.OAButtonBean;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OARow;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.Row;

/**
 * Table & Advanced Table Patterns (View Layer)
 * 
 * Comprehensive patterns for table configuration and manipulation in OA Framework.
 * Covers basic tables, advanced tables with selection, row actions, Excel export,
 * and dynamic table manipulation.
 * 
 * Layer: View Layer - UI Components
 * Complexity: Intermediate to Advanced
 * Syllabus: Level 101 Section 5.5, Level 102 Section 13.4
 * 
 * @author OAF Code Brain
 * @version 1.3
 */
public class TablePatterns {

    /**
     * USE CASE 1: Configure Basic Table Programmatically
     * 
     * Create and configure a basic table region with columns.
     * 
     * When to use:
     * - Building tables dynamically
     * - Programmatic table creation
     * - Custom table configuration
     * - Dynamic column setup
     * 
     * Best Practice:
     * - Set table ID for reference
     * - Configure width appropriately
     * - Set view instance and view attribute
     * - Enable sorting on appropriate columns
     * 
     * Common Mistakes:
     * - Not setting view instance
     * - Missing view attribute binding
     * - Incorrect width values
     * - Not testing with data
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     */
    public void configureBasicTable(OAPageContext pageContext, OAWebBean webBean) {
        // Create table bean
        OATableBean table = (OATableBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.TABLE_BEAN);
        
        // Set table properties
        table.setID("EmployeeTable");
        table.setWidth("100%");
        
        // Set view instance (binds to VO)
        table.setViewInstanceName("EmployeeVO1");
        
        // Set view attribute for querying
        table.setViewAttribute("EmployeeId");
        
        // Create column for Employee Number
        OAColumnBean empNumCol = (OAColumnBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.COLUMN_BEAN);
        empNumCol.setID("EmpNumCol");
        empNumCol.setPrompt("Employee Number");
        empNumCol.setSortAllowed(true);
        
        // Create styled text for display
        OAMessageStyledTextBean empNumField = (OAMessageStyledTextBean)
            pageContext.getWebBeanFactory().createWebBean(pageContext,
                OAWebBeanConstants.MESSAGE_STYLED_TEXT_BEAN);
        empNumField.setID("EmpNum");
        empNumField.setViewAttributeName("EmployeeNumber");
        
        // Add field to column
        empNumCol.addIndexedChild(empNumField);
        
        // Add column to table
        table.addIndexedChild(empNumCol);
        
        // Create column for Employee Name
        OAColumnBean empNameCol = (OAColumnBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.COLUMN_BEAN);
        empNameCol.setID("EmpNameCol");
        empNameCol.setPrompt("Employee Name");
        empNameCol.setSortAllowed(true);
        
        OAMessageStyledTextBean empNameField = (OAMessageStyledTextBean)
            pageContext.getWebBeanFactory().createWebBean(pageContext,
                OAWebBeanConstants.MESSAGE_STYLED_TEXT_BEAN);
        empNameField.setID("EmpName");
        empNameField.setViewAttributeName("EmployeeName");
        
        empNameCol.addIndexedChild(empNameField);
        table.addIndexedChild(empNameCol);
        
        // Add table to parent
        webBean.addIndexedChild(table);
        
        System.out.println("Basic table configured");
    }

    /**
     * USE CASE 2: Configure Advanced Table with Single Row Selection
     * 
     * Setup advanced table with single row selection capability.
     * 
     * When to use:
     * - Update/Delete operations on selected row
     * - Detail page navigation from selected row
     * - Single selection required
     * - Row actions needed
     * 
     * Best Practice:
     * - Use SINGLE_SELECTION for one row
     * - Handle selection in processFormRequest
     * - Clear selection after action
     * - Provide visual feedback
     * 
     * Common Mistakes:
     * - Not handling selection event
     * - Forgetting to get selected row
     * - Not clearing selection
     * - Wrong selection mode
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     */
    public void configureAdvancedTableSingleSelection(
            OAPageContext pageContext, 
            OAWebBean webBean) {
        
        // Find the advanced table
        OAAdvancedTableBean table = (OAAdvancedTableBean) 
            webBean.findIndexedChildRecursive("EmployeeTable");
        
        if (table != null) {
            // Enable single row selection
            table.setSelectionMode(OAWebBeanConstants.SINGLE_SELECTION);
            
            // Set selection column attributes
            table.setSelectionColumnWidth("5%");
            table.setSelectionText("Select");
            
            // Enable detail disclosure (expand/collapse)
            // table.setDetailViewAttribute("DetailFlag");
            
            // Set auto footer flag for totals
            // table.setAutoFooter(true);
            
            System.out.println("Advanced table with single selection configured");
        }
    }

    /**
     * USE CASE 3: Configure Advanced Table with Multiple Row Selection
     * 
     * Setup advanced table with multiple row selection capability.
     * 
     * When to use:
     * - Batch operations (delete multiple)
     * - Multi-row updates
     * - Bulk processing
     * - Mass operations
     * 
     * Best Practice:
     * - Use MULTIPLE_SELECTION for multiple rows
     * - Iterate through selected rows
     * - Validate before processing
     * - Commit in batches
     * 
     * Common Mistakes:
     * - Not iterating correctly
     * - Processing too many rows
     * - Not handling errors per row
     * - Poor performance on large sets
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     */
    public void configureAdvancedTableMultipleSelection(
            OAPageContext pageContext,
            OAWebBean webBean) {
        
        OAAdvancedTableBean table = (OAAdvancedTableBean)
            webBean.findIndexedChildRecursive("EmployeeTable");
        
        if (table != null) {
            // Enable multiple row selection
            table.setSelectionMode(OAWebBeanConstants.MULTIPLE_SELECTION);
            
            // Set selection attributes
            table.setSelectionColumnWidth("5%");
            table.setSelectAllText("Select All");
            table.setSelectNoneText("Select None");
            
            // Set initial sort
            table.setInitialSortSequence("EmployeeName");
            table.setInitialSortAscending(true);
            
            System.out.println("Advanced table with multiple selection configured");
        }
    }

    /**
     * USE CASE 4: Add Action Column with Update/Delete Buttons
     * 
     * Add action column to table with row-level buttons.
     * 
     * When to use:
     * - Row-level Update action
     * - Row-level Delete action
     * - Per-row operations
     * - Inline actions
     * 
     * Best Practice:
     * - Use fire action for PPR
     * - Pass primary key as parameter
     * - Confirm before delete
     * - Handle in processFormRequest
     * 
     * Common Mistakes:
     * - Not passing row identifier
     * - No delete confirmation
     * - Not refreshing table
     * - Hardcoded parameters
     * 
     * @param pageContext Current page context
     * @param table Table bean to add actions to
     */
    public void addActionColumn(OAPageContext pageContext, OATableBean table) {
        // Create action column
        OAColumnBean actionCol = (OAColumnBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.COLUMN_BEAN);
        actionCol.setID("ActionCol");
        actionCol.setPrompt("Actions");
        actionCol.setColumnDataFormat(OAWebBeanConstants.ICON_BUTTON_FORMAT);
        
        // Create row layout for buttons
        OARowLayoutBean rowLayout = (OARowLayoutBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.ROW_LAYOUT_BEAN);
        
        // Create Update button
        OAButtonBean updateBtn = (OAButtonBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.BUTTON_BEAN);
        updateBtn.setID("Update");
        updateBtn.setText("Update");
        updateBtn.setDestination("OA.jsp?page=/xxcust/oracle/apps/oaf/employee/webui/EmployeeUpdatePG" +
                                "&empId=${oa.EmployeeVO1.EmployeeId}");
        
        // Create Delete button
        OAButtonBean deleteBtn = (OAButtonBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.BUTTON_BEAN);
        deleteBtn.setID("Delete");
        deleteBtn.setText("Delete");
        deleteBtn.setAttributeValue(OAWebBeanConstants.FIRE_ACTION_EVENT_ATTR, "delete");
        deleteBtn.setAttributeValue(OAWebBeanConstants.PRIMARY_CLIENT_ACTION_ATTR,
            OAWebBeanConstants.FIRE_ACTION_EVENT);
        
        // Use parameters to pass employee ID
        deleteBtn.setAttributeValue(OAWebBeanConstants.PARAMETERS_ATTR,
            "{'empId':${oa.EmployeeVO1.EmployeeId}}");
        
        // Add buttons to row layout
        rowLayout.addIndexedChild(updateBtn);
        rowLayout.addIndexedChild(deleteBtn);
        
        // Add row layout to column
        actionCol.addIndexedChild(rowLayout);
        
        // Add column to table
        table.addIndexedChild(actionCol);
        
        System.out.println("Action column added to table");
    }

    /**
     * USE CASE 5: Handle Single Row Selection in Controller
     * 
     * Process selected row from advanced table.
     * 
     * When to use:
     * - After user selects row
     * - In processFormRequest
     * - Before performing action
     * - Navigation to detail page
     * 
     * Best Practice:
     * - Check if row is selected
     * - Get primary key attribute
     * - Validate before action
     * - Clear selection if needed
     * 
     * Common Mistakes:
     * - Not checking for null
     * - Wrong view object name
     * - Not getting correct attribute
     * - Not handling no selection
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void handleSingleRowSelection(
            OAPageContext pageContext,
            OAWebBean webBean) {
        
        // Get the application module
        String amName = webBean.getApplicationModuleDefFullName();
        
        // Get the view object
        OAViewObject vo = (OAViewObject) pageContext.getApplicationModule(webBean)
            .findViewObject("EmployeeVO1");
        
        if (vo != null) {
            // Get the selected row
            Row[] selectedRows = vo.getFilteredRows("SelectFlag", "Y");
            
            if (selectedRows != null && selectedRows.length > 0) {
                // Get first selected row
                OARow row = (OARow) selectedRows[0];
                
                // Get primary key
                String empId = (String) row.getAttribute("EmployeeId");
                String empName = (String) row.getAttribute("EmployeeName");
                
                System.out.println("Selected Employee ID: " + empId);
                System.out.println("Selected Employee Name: " + empName);
                
                // Perform action with selected row
                // navigateToDetailPage(pageContext, empId);
                // or deleteEmployee(pageContext, empId);
                
                // Clear selection after action
                row.setAttribute("SelectFlag", null);
                
            } else {
                // No row selected
                throw new OAException("Please select a row to continue",
                    OAException.ERROR);
            }
        }
    }

    /**
     * USE CASE 6: Handle Multiple Row Selection in Controller
     * 
     * Process multiple selected rows from advanced table.
     * 
     * When to use:
     * - Batch delete operations
     * - Bulk updates
     * - Mass processing
     * - Multi-row actions
     * 
     * Best Practice:
     * - Iterate through selected rows
     * - Process in batches
     * - Handle errors per row
     * - Provide progress feedback
     * 
     * Common Mistakes:
     * - Processing one by one slowly
     * - Not handling partial failures
     * - Poor error reporting
     * - Memory issues with large sets
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void handleMultipleRowSelection(
            OAPageContext pageContext,
            OAWebBean webBean) {
        
        // Get the view object
        OAViewObject vo = (OAViewObject) pageContext.getApplicationModule(webBean)
            .findViewObject("EmployeeVO1");
        
        if (vo != null) {
            // Get all selected rows
            Row[] selectedRows = vo.getFilteredRows("SelectFlag", "Y");
            
            if (selectedRows != null && selectedRows.length > 0) {
                int successCount = 0;
                int errorCount = 0;
                
                // Iterate through selected rows
                for (int i = 0; i < selectedRows.length; i++) {
                    OARow row = (OARow) selectedRows[i];
                    
                    try {
                        // Get row data
                        String empId = (String) row.getAttribute("EmployeeId");
                        String empName = (String) row.getAttribute("EmployeeName");
                        
                        System.out.println("Processing Employee: " + empName);
                        
                        // Perform action on row
                        // processEmployee(empId);
                        
                        successCount++;
                        
                        // Clear selection
                        row.setAttribute("SelectFlag", null);
                        
                    } catch (Exception e) {
                        errorCount++;
                        System.err.println("Error processing row: " + e.getMessage());
                        // Continue with next row
                    }
                }
                
                // Show summary message
                String message = "Processed " + successCount + " rows successfully";
                if (errorCount > 0) {
                    message += ", " + errorCount + " errors occurred";
                }
                
                System.out.println(message);
                
            } else {
                throw new OAException("Please select at least one row",
                    OAException.ERROR);
            }
        }
    }

    /**
     * USE CASE 7: Configure Sortable Columns
     * 
     * Enable sorting on table columns.
     * 
     * When to use:
     * - User needs to sort data
     * - Multiple sort criteria
     * - Alphanumeric sorting
     * - Date sorting
     * 
     * Best Practice:
     * - Enable on appropriate columns
     * - Set initial sort order
     * - Test with various data types
     * - Consider performance
     * 
     * Common Mistakes:
     * - Sorting on all columns
     * - Not setting initial sort
     * - Sorting large datasets
     * - Wrong sort sequence
     * 
     * @param table Table bean to configure
     */
    public void configureSortableColumns(OATableBean table) {
        // Find columns and enable sorting
        OAColumnBean empNumCol = (OAColumnBean) 
            table.findIndexedChildRecursive("EmpNumCol");
        
        if (empNumCol != null) {
            empNumCol.setSortAllowed(true);
            empNumCol.setSortByViewAttribute("EmployeeNumber");
        }
        
        OAColumnBean empNameCol = (OAColumnBean)
            table.findIndexedChildRecursive("EmpNameCol");
        
        if (empNameCol != null) {
            empNameCol.setSortAllowed(true);
            empNameCol.setSortByViewAttribute("EmployeeName");
        }
        
        // Set initial sort on table
        if (table instanceof OAAdvancedTableBean) {
            OAAdvancedTableBean advTable = (OAAdvancedTableBean) table;
            advTable.setInitialSortSequence("EmployeeName");
            advTable.setInitialSortAscending(true);
        }
        
        System.out.println("Sortable columns configured");
    }

    /**
     * USE CASE 8: Add Row Dynamically to Table
     * 
     * Add new row to table programmatically.
     * 
     * When to use:
     * - Add button functionality
     * - Create new records inline
     * - Multi-row entry
     * - Detail lines addition
     * 
     * Best Practice:
     * - Create row in view object
     * - Set default values
     * - Position cursor on new row
     * - Validate on save
     * 
     * Common Mistakes:
     * - Not inserting row
     * - Missing default values
     * - Not positioning correctly
     * - Immediate commit
     * 
     * @param pageContext Current page context
     * @param voName View object name
     */
    public void addRowDynamically(OAPageContext pageContext, String voName) {
        // Get application module
        OAViewObject vo = (OAViewObject) pageContext.getApplicationModule(null)
            .findViewObject(voName);
        
        if (vo != null) {
            // Create new row
            OARow row = (OARow) vo.createRow();
            
            // Set default values
            row.setAttribute("CreatedBy", pageContext.getUserId());
            row.setAttribute("CreationDate", pageContext.getCurrentDBDate());
            row.setAttribute("LastUpdatedBy", pageContext.getUserId());
            row.setAttribute("LastUpdateDate", pageContext.getCurrentDBDate());
            row.setAttribute("Status", "NEW");
            
            // Insert row at beginning
            vo.insertRow(row);
            
            // Set as current row
            vo.setCurrentRow(row);
            
            // Make row the first row
            row.setNewRowState(Row.STATUS_NEW);
            
            System.out.println("New row added to table");
        }
    }

    /**
     * USE CASE 9: Delete Row from Table
     * 
     * Delete row from table programmatically.
     * 
     * When to use:
     * - Delete button clicked
     * - Remove row from table
     * - Cascade delete
     * - Batch delete
     * 
     * Best Practice:
     * - Confirm before delete
     * - Check for dependencies
     * - Handle cascade delete
     * - Commit after validation
     * 
     * Common Mistakes:
     * - No confirmation dialog
     * - Immediate commit
     * - Not checking dependencies
     * - No error handling
     * 
     * @param pageContext Current page context
     * @param voName View object name
     * @param rowKey Primary key of row to delete
     */
    public void deleteRowFromTable(
            OAPageContext pageContext,
            String voName,
            String rowKey) {
        
        OAViewObject vo = (OAViewObject) pageContext.getApplicationModule(null)
            .findViewObject(voName);
        
        if (vo != null) {
            // Find row by key
            Row[] rows = vo.getFilteredRows("EmployeeId", rowKey);
            
            if (rows != null && rows.length > 0) {
                Row row = rows[0];
                
                // Mark row for deletion
                row.remove();
                
                System.out.println("Row marked for deletion: " + rowKey);
                
                // Note: Actual delete happens on commit
                // pageContext.getApplicationModule(null).getTransaction().commit();
            } else {
                throw new OAException("Row not found: " + rowKey,
                    OAException.ERROR);
            }
        }
    }

    /**
     * USE CASE 10: Export Table Data to Excel
     * 
     * Enable Excel export functionality for table data.
     * 
     * When to use:
     * - User needs to export data
     * - Reporting requirements
     * - Data analysis
     * - Offline processing
     * 
     * Best Practice:
     * - Use Export button
     * - Format appropriately
     * - Handle large datasets
     * - Set proper MIME type
     * 
     * Common Mistakes:
     * - Not handling large data
     * - Poor Excel formatting
     * - Missing headers
     * - Memory issues
     * 
     * Note: This is VIEW LAYER configuration.
     * For INTEGRATION layer Excel generation, see integration/excel/
     * 
     * @param table Advanced table bean
     */
    public void configureExcelExport(OAAdvancedTableBean table) {
        // Enable export feature
        table.setExportSupport(true);
        
        // Set export all rows (not just displayed)
        table.setExportAllRows(true);
        
        // Set export file name
        table.setExportFileName("EmployeeList.xls");
        
        System.out.println("Excel export configured for table");
        
        // Note: Framework handles the export automatically
        // No controller code needed for basic export
    }

    /**
     * USE CASE 11: Configure Table Footer with Totals
     * 
     * Add footer row with calculated totals.
     * 
     * When to use:
     * - Display sum of numeric columns
     * - Show count of rows
     * - Calculate averages
     * - Summary information
     * 
     * Best Practice:
     * - Use appropriate aggregation
     * - Format numbers correctly
     * - Handle null values
     * - Test with various data
     * 
     * Common Mistakes:
     * - Wrong aggregate function
     * - Not handling nulls
     * - Poor formatting
     * - Performance on large sets
     * 
     * @param table Advanced table bean
     */
    public void configureTableFooter(OAAdvancedTableBean table) {
        // Enable footer
        table.setAutoFooter(true);
        
        // Configure total for salary column
        OAColumnBean salaryCol = (OAColumnBean)
            table.findIndexedChildRecursive("SalaryCol");
        
        if (salaryCol != null) {
            // Set aggregate function
            salaryCol.setTotalValue(true);
            salaryCol.setTotalLabel("Total:");
            
            // Set format
            // salaryCol.setDataType(OAWebBeanConstants.NUMBER_DATA_TYPE);
        }
        
        // Configure count for employee column
        OAColumnBean empCol = (OAColumnBean)
            table.findIndexedChildRecursive("EmpNameCol");
        
        if (empCol != null) {
            empCol.setTotalValue(true);
            empCol.setTotalLabel("Count:");
        }
        
        System.out.println("Table footer configured");
    }

    /**
     * USE CASE 12: Best Practices Summary
     * 
     * Comprehensive best practices for table patterns.
     */
    public void tableBestPractices() {
        String practices =
            "Table Patterns Best Practices:\n" +
            "===============================\n" +
            "\n" +
            "Configuration:\n" +
            "- Always set table ID for reference\n" +
            "- Bind to view instance correctly\n" +
            "- Set appropriate widths (responsive)\n" +
            "- Enable sorting on searchable columns\n" +
            "- Test with real data volumes\n" +
            "\n" +
            "Selection:\n" +
            "- Use SINGLE_SELECTION for one row actions\n" +
            "- Use MULTIPLE_SELECTION for batch operations\n" +
            "- Always check if rows are selected\n" +
            "- Clear selection after action\n" +
            "- Provide visual feedback\n" +
            "\n" +
            "Actions:\n" +
            "- Confirm before destructive actions (delete)\n" +
            "- Pass primary key with action buttons\n" +
            "- Handle errors gracefully per row\n" +
            "- Refresh table after operations\n" +
            "- Use PPR for better UX\n" +
            "\n" +
            "Performance:\n" +
            "- Limit rows displayed (pagination)\n" +
            "- Use selective VO queries\n" +
            "- Avoid sorting large datasets\n" +
            "- Batch commit operations\n" +
            "- Test with production data volumes\n" +
            "\n" +
            "Excel Export:\n" +
            "- Enable only when needed\n" +
            "- Handle large datasets appropriately\n" +
            "- Set meaningful file names\n" +
            "- Format numbers/dates correctly\n" +
            "- Test export functionality\n" +
            "\n" +
            "Footer/Totals:\n" +
            "- Use appropriate aggregate functions\n" +
            "- Handle null values\n" +
            "- Format consistently with columns\n" +
            "- Test calculation accuracy\n" +
            "\n" +
            "Accessibility:\n" +
            "- Set meaningful prompts\n" +
            "- Provide alt text for icons\n" +
            "- Support keyboard navigation\n" +
            "- Test with screen readers";
        
        System.out.println(practices);
    }
}
