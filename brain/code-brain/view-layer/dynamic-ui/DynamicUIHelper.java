package oracle.apps.xx.common.view.dynamic;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageRadioButtonBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.layout.OARowLayoutBean;
import oracle.apps.fnd.framework.webui.beans.table.OAColumnBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import java.awt.Color;

import oracle.cabo.ui.data.DictionaryData;
import oracle.cabo.style.CSSStyle;

/**
 * Dynamic UI Component Creation Patterns
 * 
 * This class demonstrates ADVANCED patterns for programmatic UI generation
 * in OAF. Based on real-world analysis of JDEV codebase where dynamic
 * components are created from database-driven LOVs and business rules.
 * 
 * Use Cases:
 * - Radio buttons generated from lookup values
 * - Dynamic table columns based on configuration
 * - Conditional field rendering based on user role/status
 * - CSS styling applied programmatically
 * 
 * Source: Analyzed from demasylabs-barin/brain-repo/code/JDEV
 * Files: AssessmentCO.createActions(), XxEmpSumCO.processRequest()
 * 
 * @author OAF Code Brain - Based on Real-World Production Code
 * @version 1.5.0
 */
public class DynamicUIHelper {
    
    /**
     * PATTERN 1: Dynamic Radio Buttons from LOV
     * 
     * Create radio buttons programmatically based on database LOV values.
     * Common in assessment forms, approval workflows, status updates.
     * 
     * Found in: TmzIrcCandtAssessCO.createActions()
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean (typically a RowLayout)
     * @param am Application Module containing LOV VO
     * @param lovVOName View Object name for LOV values
     * @param targetVOName View Object to bind radio buttons to
     * @param targetAttribute Attribute name in target VO
     * @param codeAttribute LOV attribute for radio value
     * @param displayAttribute LOV attribute for radio label
     */
    public static void createRadioButtonsFromLOV(
            OAPageContext pageContext,
            OAWebBean webBean,
            OAApplicationModuleImpl am,
            String lovVOName,
            String targetVOName,
            String targetAttribute,
            String codeAttribute,
            String displayAttribute) {
        
        // Get LOV View Object
        OAViewObject lovVO = (OAViewObject) am.findViewObject(lovVOName);
        if (lovVO == null) {
            System.err.println("LOV VO not found: " + lovVOName);
            return;
        }
        
        // Execute query to get LOV values
        if (!lovVO.isPreparedForExecution()) {
            lovVO.executeQuery();
        }
        
        // Find the row layout container
        OARowLayoutBean rowLayout = null;
        if (webBean instanceof OARowLayoutBean) {
            rowLayout = (OARowLayoutBean) webBean;
        } else {
            rowLayout = (OARowLayoutBean) webBean.findChildRecursive("ActionsRow");
        }
        
        if (rowLayout == null) {
            System.err.println("Row layout not found");
            return;
        }
        
        // Iterate through LOV rows and create radio buttons
        RowSetIterator iter = lovVO.createRowSetIterator("DynamicRadioIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row row = iter.next();
                
                // Get code and display values
                Object codeObj = row.getAttribute(codeAttribute);
                Object displayObj = row.getAttribute(displayAttribute);
                
                if (codeObj == null || displayObj == null) {
                    continue; // Skip null values
                }
                
                String code = codeObj.toString();
                String display = displayObj.toString();
                
                // Create radio button bean
                OAMessageRadioButtonBean radioButton = 
                    (OAMessageRadioButtonBean) pageContext.getWebBeanFactory()
                        .createWebBean(
                            pageContext,
                            OAWebBeanConstants.MESSAGE_RADIO_BUTTON_BEAN,
                            null,
                            code // ID of the bean
                        );
                
                // Set radio button properties
                radioButton.setValue(code); // Value when selected
                radioButton.setPrompt(display); // Label text
                radioButton.setViewUsageName(targetVOName); // Bind to VO
                radioButton.setViewAttributeName(targetAttribute); // Bind to attribute
                
                // Add to row layout
                rowLayout.addIndexedChild(radioButton);
                
                System.out.println("Created radio button: " + code + " - " + display);
            }
            
        } finally {
            // CRITICAL: Close iterator to prevent memory leak
            iter.closeRowSetIterator();
        }
    }
    
    /**
     * PATTERN 2: Dynamic Dropdown (Choice List) from LOV
     * 
     * Create dropdown list programmatically.
     * Similar to radio buttons but for larger value sets.
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     * @param lovVOName LOV View Object name
     * @param choiceId ID for the choice bean
     * @param targetVOName Target VO for binding
     * @param targetAttribute Target attribute for binding
     * @param codeAttribute LOV code attribute
     * @param displayAttribute LOV display attribute
     * @return Created choice bean
     */
    public static OAMessageChoiceBean createDropdownFromLOV(
            OAPageContext pageContext,
            OAWebBean webBean,
            String lovVOName,
            String choiceId,
            String targetVOName,
            String targetAttribute,
            String codeAttribute,
            String displayAttribute) {
        
        // Create choice bean
        OAMessageChoiceBean choice = 
            (OAMessageChoiceBean) pageContext.getWebBeanFactory()
                .createWebBean(
                    pageContext,
                    OAWebBeanConstants.MESSAGE_CHOICE_BEAN,
                    null,
                    choiceId
                );
        
        // Set properties
        choice.setViewUsageName(targetVOName);
        choice.setViewAttributeName(targetAttribute);
        choice.setPickListViewName(lovVOName);
        choice.setPickListDisplayAttribute(displayAttribute);
        choice.setPickListValueAttribute(codeAttribute);
        
        // Add to parent
        webBean.addIndexedChild(choice);
        
        return choice;
    }
    
    /**
     * PATTERN 3: Conditional Field Visibility
     * 
     * Show/hide fields based on user role, status, or other criteria.
     * 
     * Found in: Multiple controllers checking user permissions
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     * @param fieldId ID of field to show/hide
     * @param condition true to show, false to hide
     */
    public static void setFieldVisibility(
            OAPageContext pageContext,
            OAWebBean webBean,
            String fieldId,
            boolean condition) {
        
        OAWebBean field = webBean.findChildRecursive(fieldId);
        
        if (field != null) {
            // Method 1: Rendered property (recommended)
            field.setRendered(condition);
            
            // Method 2: Required property (for validation)
            if (field instanceof OAMessageTextInputBean) {
                OAMessageTextInputBean textField = (OAMessageTextInputBean) field;
                textField.setRequired(condition);
            }
            
            System.out.println("Field " + fieldId + " visibility set to: " + condition);
        }
    }
    
    /**
     * PATTERN 4: Apply Custom CSS Styling
     * 
     * Apply dynamic styling to components based on data values.
     * Example: Highlight overdue items, color-code statuses
     * 
     * Found in: XxEmpSumCO.processRequest() - custom styling for day work hours
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     * @param fieldId Field to style
     * @param backgroundColor Background color (e.g., "#FF0000")
     * @param textColor Text color (e.g., "#FFFFFF")
     * @param fontSize Font size (e.g., "11pt")
     */
    public static void applyCustomStyling(
            OAPageContext pageContext,
            OAWebBean webBean,
            String fieldId,
            String backgroundColor,
            String textColor,
            String fontSize) {
        
        OAWebBean field = webBean.findChildRecursive(fieldId);
        
        if (field != null) {
            // Create CSS style
            CSSStyle customStyle = new CSSStyle();
            
            if (backgroundColor != null) {
                customStyle.setProperty("background-color", backgroundColor);
            }
            
            if (textColor != null) {
                customStyle.setProperty("color", textColor);
            }
            
            if (fontSize != null) {
                customStyle.setProperty("font-size", fontSize);
            }
            
            // Apply inline style
            if (field instanceof OAMessageStyledTextBean) {
                OAMessageStyledTextBean styledText = (OAMessageStyledTextBean) field;
                styledText.setInlineStyle(customStyle);
            }
            
            System.out.println("Applied custom styling to: " + fieldId);
        }
    }
    
    /**
     * PATTERN 5: Conditional Styling Based on Value
     * 
     * Apply different styles based on data value.
     * Example: Red for negative numbers, green for positive
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     * @param fieldId Field to style
     * @param value Value to evaluate
     * @param threshold Threshold for comparison
     */
    public static void applyConditionalStyling(
            OAPageContext pageContext,
            OAWebBean webBean,
            String fieldId,
            double value,
            double threshold) {
        
        String backgroundColor;
        String textColor = "#FFFFFF"; // White text
        
        if (value < threshold) {
            backgroundColor = "#FF0000"; // Red
        } else if (value == threshold) {
            backgroundColor = "#FFA500"; // Orange
        } else {
            backgroundColor = "#00FF00"; // Green
        }
        
        applyCustomStyling(pageContext, webBean, fieldId, 
                          backgroundColor, textColor, "11pt");
    }
    
    /**
     * PATTERN 6: Dynamic Table Column Creation
     * 
     * Add columns to table programmatically.
     * Useful for user-configurable reports.
     * 
     * @param pageContext Current page context
     * @param table Table bean
     * @param columnId Column ID
     * @param prompt Column header
     * @param viewAttribute VO attribute to bind
     * @param sortable Enable sorting
     */
    public static void addTableColumn(
            OAPageContext pageContext,
            OATableBean table,
            String columnId,
            String prompt,
            String viewAttribute,
            boolean sortable) {
        
        // Create column bean
        OAColumnBean column = (OAColumnBean) pageContext.getWebBeanFactory()
            .createWebBean(pageContext, OAWebBeanConstants.COLUMN_BEAN);
        
        column.setID(columnId);
        column.setPrompt(prompt);
        column.setSortAllowed(sortable);
        
        if (sortable) {
            column.setSortByViewAttribute(viewAttribute);
        }
        
        // Create styled text for display
        OAMessageStyledTextBean field = (OAMessageStyledTextBean)
            pageContext.getWebBeanFactory().createWebBean(
                pageContext,
                OAWebBeanConstants.MESSAGE_STYLED_TEXT_BEAN);
        
        field.setID(columnId + "Field");
        field.setViewAttributeName(viewAttribute);
        
        // Add field to column
        column.addIndexedChild(field);
        
        // Add column to table
        table.addIndexedChild(column);
        
        System.out.println("Added table column: " + columnId);
    }
    
    /**
     * PATTERN 7: Enable/Disable Fields Based on Status
     * 
     * Make fields read-only or editable based on document status.
     * Common in workflow-based forms.
     * 
     * @param pageContext Current page context
     * @param webBean Parent web bean
     * @param fieldIds Array of field IDs
     * @param readOnly true for read-only, false for editable
     */
    public static void setFieldsReadOnly(
            OAPageContext pageContext,
            OAWebBean webBean,
            String[] fieldIds,
            boolean readOnly) {
        
        if (fieldIds == null) {
            return;
        }
        
        for (String fieldId : fieldIds) {
            OAWebBean field = webBean.findChildRecursive(fieldId);
            
            if (field != null) {
                if (field instanceof OAMessageTextInputBean) {
                    OAMessageTextInputBean textInput = (OAMessageTextInputBean) field;
                    textInput.setReadOnly(readOnly);
                } else if (field instanceof OAMessageChoiceBean) {
                    OAMessageChoiceBean choice = (OAMessageChoiceBean) field;
                    choice.setReadOnly(readOnly);
                }
                
                System.out.println("Field " + fieldId + " readOnly set to: " + readOnly);
            }
        }
    }
    
    /**
     * PATTERN 8: Usage Example in Controller
     * 
     * Demonstrates how to use these helper methods in processRequest().
     * 
     * Example from XxEmpSumCO.processRequest():
     * <pre>
     * public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
     *     super.processRequest(pageContext, webBean);
     *     
     *     OAApplicationModuleImpl am = 
     *         (OAApplicationModuleImpl) pageContext.getApplicationModule(webBean);
     *     
     *     // Pattern 1: Create radio buttons from LOV
     *     DynamicUIHelper.createRadioButtonsFromLOV(
     *         pageContext,
     *         webBean,
     *         am,
     *         "ActionsLovVO1",          // LOV VO
     *         "AssessmentHeaderVO1",    // Target VO
     *         "Recommendation",         // Target attribute
     *         "ActionCode",             // LOV code attribute
     *         "Action"                  // LOV display attribute
     *     );
     *     
     *     // Pattern 4: Apply custom styling
     *     String status = pageContext.getParameter("status");
     *     if ("URGENT".equals(status)) {
     *         DynamicUIHelper.applyCustomStyling(
     *             pageContext,
     *             webBean,
     *             "StatusField",
     *             "#FF0000",  // Red background
     *             "#FFFFFF",  // White text
     *             "12pt"      // Larger font
     *         );
     *     }
     *     
     *     // Pattern 7: Make fields read-only if approved
     *     if ("APPROVED".equals(status)) {
     *         String[] editableFields = {"Amount", "Description", "Justification"};
     *         DynamicUIHelper.setFieldsReadOnly(
     *             pageContext,
     *             webBean,
     *             editableFields,
     *             true  // read-only
     *         );
     *     }
     * }
     * </pre>
     */
    public static void exampleControllerUsage() {
        // This is documentation only - see JavaDoc above
    }
    
    /**
     * Best Practices Summary
     * =====================
     * 
     * 1. RESOURCE MANAGEMENT:
     *    - ALWAYS close RowSetIterator after use
     *    - Use try-finally blocks for cleanup
     *    - Don't create excessive components
     * 
     * 2. PERFORMANCE:
     *    - Create dynamic UI in processRequest(), not processFormRequest()
     *    - Cache LOV queries - don't execute repeatedly
     *    - Limit number of dynamic components (< 50)
     *    - Test with production data volumes
     * 
     * 3. MAINTAINABILITY:
     *    - Use meaningful IDs for dynamic components
     *    - Document which components are dynamic
     *    - Provide fallback for missing LOV data
     *    - Log component creation for debugging
     * 
     * 4. USER EXPERIENCE:
     *    - Don't create too many radio buttons (> 10 use dropdown)
     *    - Provide default selections
     *    - Use consistent styling
     *    - Test accessibility (screen readers)
     * 
     * 5. SECURITY:
     *    - Validate LOV data before creating UI
     *    - Sanitize display values (XSS prevention)
     *    - Check user permissions before showing fields
     *    - Verify field IDs exist before manipulation
     * 
     * 6. ERROR HANDLING:
     *    - Handle null VOImport gracefully
     *    - Provide meaningful error messages
     *    - Don't fail entire page if one component fails
     *    - Log errors for debugging
     * 
     * Common Use Cases:
     * ================
     * ✅ Assessment forms with dynamic criteria
     * ✅ Approval workflows with dynamic actions
     * ✅ Configurable reports with user-selected columns
     * ✅ Status-based field visibility/editability
     * ✅ Role-based UI customization
     * ✅ Conditional styling for data visualization
     * 
     * Common Mistakes to Avoid:
     * =========================
     * ❌ Creating UI in processFormRequest() (causes duplication)
     * ❌ Not closing RowSetIterator (memory leak)
     * ❌ Excessive dynamic components (slow page load)
     * ❌ Not handling null/missing LOV data
     * ❌ Hardcoding IDs without constants
     * ❌ Not testing with various data sets
     * ❌ Forgetting to set view bindings
     * ❌ Applying styles to wrong bean type
     */
}
