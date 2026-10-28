package oracle.apps.xxcust.oaf.codebrain.view.lov;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;
import oracle.apps.fnd.framework.webui.beans.lov.OAListOfValuesBean;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.domain.Number;

/**
 * List of Values (LOV) Patterns (View Layer)
 * 
 * Comprehensive patterns for LOV configuration and dependent LOV implementation.
 * Standard LOV, External LOV, Cascading LOVs, and programmatic LOV launch.
 * 
 * Layer: View Layer - UI Components
 * Complexity: Intermediate to Advanced
 * Syllabus: Level 101 Section 5.7, Level 102 Section 13.11
 * 
 * @author OAF Code Brain
 * @version 1.3
 */
public class LOVPatterns {

    /**
     * USE CASE 1: Configure Standard LOV Programmatically
     * 
     * Create LOV input field with external LOV region.
     * 
     * When to use:
     * - User needs to select from predefined list
     * - Search and select values
     * - Reference data selection
     * - Foreign key lookup
     * 
     * Best Practice:
     * - Set LOV region path correctly
     * - Configure mappings properly
     * - Set appropriate search criteria
     * - Handle no data found
     * 
     * Common Mistakes:
     * - Wrong LOV region path
     * - Missing mappings
     * - No validation base
     * - Poor search performance
     */
    public void configureStandardLOV(OAPageContext pageContext, OAWebBean webBean) {
        // Create LOV input bean
        OAMessageLovInputBean lovField = (OAMessageLovInputBean)
            pageContext.getWebBeanFactory().createWebBean(pageContext,
                OAWebBeanConstants.MESSAGE_LOV_INPUT_BEAN);
        
        lovField.setID("EmployeeLov");
        lovField.setPrompt("Employee");
        lovField.setViewAttributeName("EmployeeId");
        
        // Set external LOV region
        lovField.setExternalListOfValues(
            "/oracle/apps/fnd/framework/toolbox/lov/webui/EmpLovRN",
            "/oracle/apps/fnd/framework/toolbox/lov/webui/EmpLovRN",
            "Go"
        );
        
        // Configure LOV mappings
        lovField.addToLovMapping("EmployeeId", "Id");
        lovField.addToLovMapping("EmployeeName", "Name");
        lovField.addToLovMapping("Email", "EmailAddress");
        
        // Set validation base - required for LOV
        lovField.setAttributeValue(OAWebBeanConstants.LOV_VALIDATION_BASE_ATTR,
            "EmployeeId");
        
        // Set required property
        lovField.setRequired("yes");
        
        webBean.addIndexedChild(lovField);
        
        System.out.println("Standard LOV configured");
    }

    /**
     * USE CASE 2: Configure Dependent LOV (Cascading LOVs)
     * 
     * Setup cascading LOVs where second LOV depends on first LOV selection.
     * Classic example: Country -> State -> City
     * 
     * When to use:
     * - Hierarchical data selection
     * - Dependent dropdowns
     * - Filtered selection lists
     * - Multi-level lookups
     * 
     * Best Practice:
     * - Use PPR to refresh dependent LOV
     * - Clear dependent values on parent change
     * - Set proper criteria binding
     * - Handle empty dependent lists
     * 
     * Common Mistakes:
     * - Not using PPR
     * - Not clearing dependent values
     * - Wrong criteria binding
     * - Performance issues
     */
    public void configureDependentLOV(OAPageContext pageContext, OAWebBean webBean) {
        // Create Country LOV (parent)
        OAMessageLovInputBean countryLov = (OAMessageLovInputBean)
            pageContext.getWebBeanFactory().createWebBean(pageContext,
                OAWebBeanConstants.MESSAGE_LOV_INPUT_BEAN);
        
        countryLov.setID("CountryLov");
        countryLov.setPrompt("Country");
        countryLov.setViewAttributeName("CountryCode");
        countryLov.setExternalListOfValues(
            "/xxcust/oracle/apps/fnd/lov/webui/CountryLovRN",
            null, "Go"
        );
        
        // Enable PPR on country LOV to refresh state LOV
        countryLov.setAttributeValue(OAWebBeanConstants.FIRE_PARTIAL_ACTION_ATTR, Boolean.TRUE);
        countryLov.setAttributeValue(OAWebBeanConstants.EVENT_PARAM, "countryChange");
        
        webBean.addIndexedChild(countryLov);
        
        // Create State LOV (dependent child)
        OAMessageLovInputBean stateLov = (OAMessageLovInputBean)
            pageContext.getWebBeanFactory().createWebBean(pageContext,
                OAWebBeanConstants.MESSAGE_LOV_INPUT_BEAN);
        
        stateLov.setID("StateLov");
        stateLov.setPrompt("State");
        stateLov.setViewAttributeName("StateCode");
        stateLov.setExternalListOfValues(
            "/xxcust/oracle/apps/fnd/lov/webui/StateLovRN",
            null, "Go"
        );
        
        // Set criteria for dependent LOV
        // The StateLovRN should have a bind variable for CountryCode
        stateLov.addToLovMapping("StateCode", "Code");
        stateLov.addToLovMapping("StateName", "Name");
        
        // Mark as PPR target
        stateLov.setAttributeValue(OAWebBeanConstants.PARTIAL_TRIGGERS_ATTR, 
            new String[]{"CountryLov"});
        
        webBean.addIndexedChild(stateLov);
        
        System.out.println("Dependent LOVs configured");
    }

    /**
     * USE CASE 3: Handle Dependent LOV in Controller (PPR Event)
     * 
     * Process parent LOV change and refresh dependent LOV.
     * 
     * When to use:
     * - In processFormRequest
     * - After parent LOV selection
     * - Before dependent LOV display
     * - Clear dependent values
     * 
     * Best Practice:
     * - Check for PPR event
     * - Clear dependent field values
     * - Re-execute dependent VO
     * - Handle null parent values
     */
    public void handleDependentLOVEvent(OAPageContext pageContext, OAWebBean webBean) {
        // Check if country change event fired
        String event = pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM);
        
        if ("countryChange".equals(event)) {
            // Get the selected country code
            String countryCode = pageContext.getParameter("CountryCode");
            
            if (countryCode != null && !countryCode.isEmpty()) {
                // Get State LOV view object
                OAViewObject stateVO = (OAViewObject) 
                    pageContext.getApplicationModule(webBean)
                    .findViewObject("StateLovVO");
                
                if (stateVO != null) {
                    // Set where clause with country filter
                    stateVO.setWhereClause("COUNTRY_CODE = :1");
                    stateVO.setWhereClauseParams(null);
                    stateVO.setWhereClauseParam(0, countryCode);
                    stateVO.executeQuery();
                    
                    System.out.println("State LOV filtered by country: " + countryCode);
                }
                
                // Clear state and city values
                OAViewObject mainVO = (OAViewObject)
                    pageContext.getApplicationModule(webBean)
                    .findViewObject("MainVO");
                
                if (mainVO != null && mainVO.getCurrentRow() != null) {
                    mainVO.getCurrentRow().setAttribute("StateCode", null);
                    mainVO.getCurrentRow().setAttribute("StateName", null);
                    mainVO.getCurrentRow().setAttribute("CityCode", null);
                    mainVO.getCurrentRow().setAttribute("CityName", null);
                }
            }
        }
    }

    /**
     * USE CASE 4: Programmatically Launch LOV
     * 
     * Open LOV window programmatically from button or event.
     * 
     * When to use:
     * - Launch LOV from button click
     * - Open LOV on field focus
     * - Custom LOV trigger
     * - Search functionality
     * 
     * Best Practice:
     * - Use showLovWindow method
     * - Pass correct LOV field ID
     * - Handle LOV return values
     * - Set focus after selection
     */
    public void launchLOVProgrammatically(OAPageContext pageContext) {
        // Get LOV field
        String lovFieldId = "EmployeeLov";
        
        // Launch LOV window
        // This can be done using JavaScript or URL parameters
        String lovUrl = "OA.jsp?page=/oracle/apps/fnd/framework/toolbox/lov/webui/EmpLovPG" +
                       "&lovField=" + lovFieldId +
                       "&addBreadCrumb=Y";
        
        // Forward to LOV
        pageContext.setForwardURL(lovUrl,
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
            OAWebBeanConstants.IGNORE_MESSAGES);
        
        System.out.println("LOV launched programmatically");
    }

    /**
     * USE CASE 5: Configure LOV with Auto-Clear Behavior
     * 
     * Setup LOV to automatically clear related fields on change.
     * 
     * When to use:
     * - Dependent fields need clearing
     * - Related data must be refreshed
     * - Prevent stale data
     * - Maintain data consistency
     * 
     * Best Practice:
     * - Clear all dependent fields
     * - Use PPR for smooth UX
     * - Validate after clear
     * - Provide user feedback
     */
    public void configureLOVWithAutoClear(OAPageContext pageContext, OAWebBean webBean) {
        OAMessageLovInputBean empLov = (OAMessageLovInputBean)
            webBean.findChildRecursive("EmployeeLov");
        
        if (empLov != null) {
            // Enable auto-clear on LOV change
            empLov.setAttributeValue(OAWebBeanConstants.FIRE_PARTIAL_ACTION_ATTR, Boolean.TRUE);
            empLov.setAttributeValue(OAWebBeanConstants.EVENT_PARAM, "empChange");
            
            // Fields to clear when employee changes
            // These would be set in processFormRequest handler
            String[] fieldsToClear = {
                "EmployeeEmail",
                "EmployeePhone",
                "DepartmentName",
                "ManagerName"
            };
            
            // Store in session for handler use
            pageContext.putSessionValue("FIELDS_TO_CLEAR", fieldsToClear);
        }
    }

    /**
     * USE CASE 6: Validate LOV Selection
     * 
     * Validate that user selected value from LOV, not typed invalid value.
     * 
     * When to use:
     * - Ensure valid selection
     * - Prevent manual entry
     * - Enforce LOV usage
     * - Data integrity
     * 
     * Best Practice:
     * - Check validation base
     * - Verify ID populated
     * - Clear invalid entries
     * - Show clear error message
     */
    public void validateLOVSelection(OAPageContext pageContext, OAWebBean webBean) {
        // Get employee ID from LOV
        String empId = pageContext.getParameter("EmployeeId");
        String empName = pageContext.getParameter("EmployeeName");
        
        // Validate that ID is populated (means LOV was used)
        if (empName != null && !empName.isEmpty() && 
            (empId == null || empId.isEmpty())) {
            
            // User typed name without selecting from LOV
            throw new OAException(
                "Please select Employee from List of Values",
                OAException.ERROR
            );
        }
        
        // Additional validation - verify employee exists
        if (empId != null && !empId.isEmpty()) {
            OAViewObject empVO = (OAViewObject)
                pageContext.getApplicationModule(webBean)
                .findViewObject("EmployeeVO");
            
            if (empVO != null) {
                empVO.setWhereClause("EMPLOYEE_ID = :1");
                empVO.setWhereClauseParams(null);
                empVO.setWhereClauseParam(0, empId);
                empVO.executeQuery();
                
                if (!empVO.hasNext()) {
                    throw new OAException(
                        "Invalid Employee ID: " + empId,
                        OAException.ERROR
                    );
                }
            }
        }
    }

    /**
     * USE CASE 7: Configure LOV with Custom Criteria
     * 
     * Add custom search criteria to LOV query.
     * 
     * When to use:
     * - Filter LOV results
     * - Context-specific LOV
     * - Role-based filtering
     * - Date range filtering
     * 
     * Best Practice:
     * - Use bind variables
     * - Set criteria in processRequest
     * - Handle no results
     * - Optimize query performance
     */
    public void configureLOVWithCriteria(OAPageContext pageContext, OAWebBean webBean) {
        // Get LOV View Object
        OAViewObject empLovVO = (OAViewObject)
            pageContext.getApplicationModule(webBean)
            .findViewObject("EmployeeLovVO");
        
        if (empLovVO != null) {
            // Get filtering criteria
            String departmentId = pageContext.getParameter("DepartmentId");
            String status = "ACTIVE";
            
            // Build where clause
            StringBuilder whereClause = new StringBuilder();
            whereClause.append("STATUS = :1");
            
            Object[] params = new Object[2];
            params[0] = status;
            int paramIndex = 1;
            
            if (departmentId != null && !departmentId.isEmpty()) {
                whereClause.append(" AND DEPARTMENT_ID = :2");
                params[1] = departmentId;
                paramIndex = 2;
            }
            
            // Apply criteria to LOV VO
            empLovVO.setWhereClause(whereClause.toString());
            empLovVO.setWhereClauseParams(null);
            for (int i = 0; i < paramIndex; i++) {
                empLovVO.setWhereClauseParam(i, params[i]);
            }
            
            empLovVO.executeQuery();
            
            System.out.println("LOV filtered with custom criteria");
        }
    }

    /**
     * USE CASE 8: Handle LOV Return Values and Mappings
     * 
     * Process values returned from LOV selection.
     * 
     * When to use:
     * - After LOV selection
     * - Map multiple fields
     * - Populate related data
     * - Trigger dependent actions
     * 
     * Best Practice:
     * - Map all required fields
     * - Handle null returns
     * - Validate mapped data
     * - Trigger dependent LOVs
     */
    public void handleLOVReturnValues(OAPageContext pageContext, OAWebBean webBean) {
        // Check if returning from LOV
        String lovEvent = pageContext.getParameter("lovEvent");
        
        if ("return".equals(lovEvent)) {
            // Get returned values
            String empId = pageContext.getParameter("EmployeeId");
            String empName = pageContext.getParameter("EmployeeName");
            String empEmail = pageContext.getParameter("Email");
            String deptId = pageContext.getParameter("DepartmentId");
            String deptName = pageContext.getParameter("DepartmentName");
            
            // Get current row
            OAViewObject vo = (OAViewObject)
                pageContext.getApplicationModule(webBean)
                .findViewObject("TransactionVO");
            
            if (vo != null && vo.getCurrentRow() != null) {
                // Set returned values
                vo.getCurrentRow().setAttribute("EmployeeId", empId);
                vo.getCurrentRow().setAttribute("EmployeeName", empName);
                vo.getCurrentRow().setAttribute("EmployeeEmail", empEmail);
                vo.getCurrentRow().setAttribute("DepartmentId", deptId);
                vo.getCurrentRow().setAttribute("DepartmentName", deptName);
                
                System.out.println("LOV return values processed: " + empName);
                
                // Trigger dependent LOV refresh if needed
                // For example, refresh project LOV based on department
            }
        }
    }

    /**
     * USE CASE 9: Configure LOV with Query Limit
     * 
     * Set maximum rows for LOV query performance.
     * 
     * When to use:
     * - Large LOV datasets
     * - Performance optimization
     * - Encourage search usage
     * - Limit initial load
     * 
     * Best Practice:
     * - Set reasonable limit (100-500)
     * - Encourage search criteria
     * - Show message if limit hit
     * - Optimize VO query
     */
    public void configureLOVQueryLimit(OAPageContext pageContext, OAWebBean webBean) {
        OAMessageLovInputBean lovField = (OAMessageLovInputBean)
            webBean.findChildRecursive("EmployeeLov");
        
        if (lovField != null) {
            // Set query limit
            lovField.setMaximumRows(500);
            
            // Set property to show limit message
            lovField.setAttributeValue("showQueryLimitWarning", Boolean.TRUE);
        }
        
        // Also set on LOV VO
        OAViewObject lovVO = (OAViewObject)
            pageContext.getApplicationModule(webBean)
            .findViewObject("EmployeeLovVO");
        
        if (lovVO != null) {
            lovVO.setMaxFetchSize(500);
            System.out.println("LOV query limit set to 500 rows");
        }
    }

    /**
     * USE CASE 10: Best Practices Summary
     * 
     * Comprehensive best practices for LOV patterns.
     */
    public void lovBestPractices() {
        String practices =
            "LOV Patterns Best Practices:\n" +
            "============================\n" +
            "\n" +
            "Configuration:\n" +
            "- Set external LOV region path correctly\n" +
            "- Configure all required mappings\n" +
            "- Set validation base attribute\n" +
            "- Use meaningful LOV IDs\n" +
            "- Test with various datasets\n" +
            "\n" +
            "Dependent LOVs:\n" +
            "- Use PPR for dependent refresh\n" +
            "- Clear dependent values on parent change\n" +
            "- Set proper criteria binding\n" +
            "- Handle empty dependent lists\n" +
            "- Test cascade logic thoroughly\n" +
            "\n" +
            "Performance:\n" +
            "- Set query limits (100-500 rows)\n" +
            "- Encourage search criteria usage\n" +
            "- Optimize LOV VO queries\n" +
            "- Use indexes on search columns\n" +
            "- Test with production data volumes\n" +
            "\n" +
            "Validation:\n" +
            "- Verify ID populated from LOV\n" +
            "- Prevent manual invalid entries\n" +
            "- Clear error messages\n" +
            "- Handle no data found\n" +
            "- Validate dependent data\n" +
            "\n" +
            "User Experience:\n" +
            "- Provide clear prompts\n" +
            "- Show helpful search hints\n" +
            "- Handle no results gracefully\n" +
            "- Use PPR for smooth transitions\n" +
            "- Test keyboard navigation\n" +
            "\n" +
            "Common Patterns:\n" +
            "- Country -> State -> City\n" +
            "- Category -> Subcategory -> Item\n" +
            "- Organization -> Department -> Employee\n" +
            "- Product -> Model -> Serial Number";
        
        System.out.println(practices);
    }
}
