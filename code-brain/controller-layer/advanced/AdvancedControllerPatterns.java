package oracle.apps.xxcust.oaf.codebrain.advancedcontroller;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAPageLayoutBean;
import oracle.apps.fnd.framework.webui.beans.nav.OAGlobalButtonBarBean;
import oracle.apps.fnd.framework.webui.beans.OABodyBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;
import oracle.apps.fnd.framework.webui.OABoundValueEnterOnKeyPress;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import java.util.Hashtable;

/**
 * Advanced Controller Patterns
 * 
 * Advanced controller techniques for OA Framework including:
 * - Programmatic UI manipulation
 * - Button state management
 * - Form submission blocking
 * - Focus management
 * - Browser back button handling
 * - Global button control
 * - Advanced event handling
 * 
 * Source: OAF Reference - By Mostafa EL-Ruby.docx
 * Category: Controller - Advanced
 * Complexity: Advanced
 * 
 * @author OAF Code Brain
 * @version 1.0
 */
public class AdvancedControllerPatterns {

    /**
     * USE CASE 1: Block Form Submission (setBlockOnEverySubmit)
     * 
     * Prevent user from clicking submit buttons multiple times.
     * Shows hourglass cursor during processing.
     * 
     * When to use:
     * - Creating accounts/transactions
     * - Generating reports
     * - Long-running operations
     * - Prevent duplicate submissions
     * 
     * Best Practice:
     * - Enable at page level if all buttons need blocking
     * - For selective blocking, use JavaScript solution
     * - Default enabled for PPR events only
     * - Consider OAProcessingPage for very long operations
     * 
     * Common Mistakes:
     * - Not enabling when needed (duplicate transactions)
     * - Enabling when not needed (poor UX)
     * - Not providing user feedback
     * - Not handling timeout scenarios
     * 
     * @param pageContext Current page context
     * @param webBean Page layout web bean
     */
    public void blockFormSubmission(OAPageContext pageContext, OAWebBean webBean) {
        // Call from processRequest
        // Get the root web bean (body)
        OAWebBean body = pageContext.getRootWebBean();
        
        // Check if it's an OABodyBean
        if (body instanceof OABodyBean) {
            // Enable block on every submit
            ((OABodyBean)body).setBlockOnEverySubmit(true);
            
            // Now when user clicks submit button:
            // - Cursor becomes hourglass
            // - Subsequent clicks blocked
            // - Page disabled until response
        }
        
        // Note: This blocks ALL submit actions on the page
        // For selective blocking, see next use case
    }

    /**
     * USE CASE 2: Block Specific Button with JavaScript
     * 
     * Block only specific button, not entire page.
     * Uses JavaScript to disable button on click.
     * 
     * When to use:
     * - Multiple buttons, want to block only one
     * - Standard setBlockOnEverySubmit too broad
     * - Need fine-grained control
     * - Mobile browsers (OAProcessingPage issues)
     * 
     * Best Practice:
     * - Use Button bean, not Submit Button bean
     * - Set destination URI to JavaScript
     * - Remove parameter after processing
     * - Re-enable button if validation fails
     * 
     * Common Mistakes:
     * - Using pageContext.getParameter() in R12
     * - Not removing parameter from request
     * - Not re-enabling button on error
     * - Forgetting to handle Cancel action
     * 
     * Implementation:
     * 1. In JDeveloper:
     *    - Create Button bean (not Submit Button)
     *    - Set ID = "SaveBtn"
     *    - Set Destination URI property to:
     *      javascript:document.getElementById('SaveBtn').disabled=true;
     *                submitForm('DefaultFormName',0,{'XXX':'Y'});
     * 
     * 2. In processFormRequest:
     */
    public void blockSpecificButtonProcessFormRequest(
            OAPageContext pageContext, 
            OAWebBean webBean) {
        
        // Don't use pageContext.getParameter() in R12
        // It validates JS parameters and may fail
        
        // Get parameter directly from HTTP request instead
        String buttonParam = pageContext.getRenderingContext()
                                       .getServletRequest()
                                       .getParameter("XXX");
        
        if (buttonParam != null && "Y".equals(buttonParam)) {
            // Button was clicked
            System.out.println("Save button clicked");
            
            try {
                // Your business logic here
                // AM method invocation
                // Validation
                // Commit
                
                // Success - navigate away or show message
                
            } catch (Exception e) {
                // Error - button will be re-enabled automatically
                // because page will re-render
                throw new OAException(e.getMessage());
            } finally {
                // Remove parameter from HTTP request
                pageContext.removeParameter("XXX");
            }
        }
    }

    /**
     * USE CASE 3: Disable Global Buttons
     * 
     * Hide or disable the global button bar (Home, Personalize, etc.)
     * 
     * When to use:
     * - Wizard pages
     * - Modal-like flows
     * - Restricted navigation scenarios
     * - Custom navigation only
     * 
     * Best Practice:
     * - Call from processRequest
     * - Call prepareForRendering first
     * - Document why buttons disabled
     * - Provide alternative navigation
     * 
     * Common Mistakes:
     * - Forgetting prepareForRendering
     * - Not providing alternate navigation
     * - Disabling on regular pages (poor UX)
     * - Not re-enabling when appropriate
     * 
     * @param pageContext Current page context
     */
    public void disableGlobalButtons(OAPageContext pageContext) {
        // Call from processRequest
        
        // Get page layout bean
        OAPageLayoutBean pageLayout = pageContext.getPageLayoutBean();
        
        // Important: Prepare for rendering first
        pageLayout.prepareForRendering(pageContext);
        
        // Get global buttons
        OAGlobalButtonBarBean globalButtons = 
            (OAGlobalButtonBarBean) pageLayout.getGlobalButtons();
        
        if (globalButtons != null) {
            // Hide global buttons completely
            globalButtons.setRendered(false);
            
            System.out.println("Global buttons disabled");
        }
        
        // Alternative: Disable specific buttons
        // globalButtons.setHomeRendered(false);
        // globalButtons.setPersonalizeRendered(false);
    }

    /**
     * USE CASE 4: Set Initial Focus on Field
     * 
     * Automatically focus cursor on specific field when page loads.
     * 
     * When to use:
     * - Forms with primary input field
     * - Search pages
     * - Data entry pages
     * - Improve user experience
     * 
     * Best Practice:
     * - Focus on most commonly used field
     * - Don't focus on read-only fields
     * - Consider tab order
     * - Test on all browsers
     * 
     * Common Mistakes:
     * - Wrong field ID
     * - Focusing on disabled field
     * - Not testing user workflow
     * - Focusing on hidden field
     * 
     * @param pageContext Current page context
     * @param fieldId ID of field to focus
     */
    public void setInitialFocus(OAPageContext pageContext, String fieldId) {
        // Call from processRequest
        
        // Get root web bean (body)
        OAWebBean rootBean = pageContext.getRootWebBean();
        
        if (rootBean instanceof OABodyBean) {
            OABodyBean bodyBean = (OABodyBean) rootBean;
            
            // Set initial focus to specified field
            bodyBean.setInitialFocusId(fieldId);
            
            System.out.println("Initial focus set to: " + fieldId);
        }
        
        // Example field IDs:
        // - "EmployeeName" for text input
        // - "ProjectType1" for LOV
        // - "SearchField" for search box
    }

    /**
     * USE CASE 5: Handle Enter Key Press on Field
     * 
     * Trigger button action when user presses Enter in a field.
     * Typically used with LOV fields or search boxes.
     * 
     * When to use:
     * - LOV fields with auto-search
     * - Search boxes
     * - Quick data entry forms
     * - Improve keyboard navigation
     * 
     * Best Practice:
     * - Use with LOV or text input fields
     * - Trigger search or Go button
     * - Document behavior for users
     * - Test thoroughly
     * 
     * Common Mistakes:
     * - Wrong button parameter name
     * - Not setting up hashtable correctly
     * - Using on wrong field types
     * - Breaking normal form submission
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void handleEnterKeyPress(OAPageContext pageContext, OAWebBean webBean) {
        // Call from processRequest
        
        // Find the LOV field by ID
        OAMessageLovInputBean lovBean = 
            (OAMessageLovInputBean) webBean.findIndexedChildRecursive("SelectVersion");
        
        if (lovBean != null) {
            // Create parameters to pass to form submission
            Hashtable params = new Hashtable();
            
            // "Go" is the name of the button whose action should execute
            params.put("Go", "true");
            
            // Set the enter key handler
            lovBean.setAttributeValue(
                OAWebBeanConstants.ON_KEY_PRESS_ATTR,
                new OABoundValueEnterOnKeyPress(
                    pageContext,
                    "DefaultFormName",  // Form name
                    params,             // Parameters to pass
                    true,               // submitForm
                    true                // validate form
                )
            );
            
            System.out.println("Enter key handler configured for SelectVersion");
        }
        
        // In processFormRequest, handle the "Go" parameter:
        // if (pageContext.getParameter("Go") != null) {
        //     // Handle the search/action
        // }
    }

    /**
     * USE CASE 6: Handle Browser Back Button
     * 
     * Detect and handle browser back button navigation.
     * Protect transaction state from back button issues.
     * 
     * When to use:
     * - Multi-page transactions
     * - Wizard flows
     * - Shopping cart scenarios
     * - Protect data integrity
     * 
     * Best Practice:
     * - Use TransactionUnitHelper
     * - Start transaction in processRequest
     * - End transaction before navigation
     * - Show clear error message
     * 
     * Common Mistakes:
     * - Not handling back button at all
     * - Wrong transaction unit name
     * - Not ending transaction unit
     * - Generic error messages
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void handleBackButtonProcessRequest(
            OAPageContext pageContext, 
            OAWebBean webBean) {
        
        // Transaction unit name - must be unique per flow
        String txnUnitName = "xxcust.order.createOrderTxn";
        
        // Check if back navigation was fired
        if (!pageContext.isBackNavigationFired(false)) {
            // Normal forward navigation
            
            // Start transaction unit
            TransactionUnitHelper.startTransactionUnit(
                pageContext, 
                txnUnitName
            );
            
            // All your processRequest logic here
            System.out.println("Transaction unit started: " + txnUnitName);
            
            // Initialize page
            // Load data
            // Set defaults
            
        } else {
            // Back button was pressed
            System.out.println("Back button detected");
            
            // Check if transaction unit is still in progress
            if (!TransactionUnitHelper.isTransactionUnitInProgress(
                    pageContext, 
                    txnUnitName, 
                    true)) {
                
                // Transaction unit lost - show error
                OADialogPage dialogPage = new OADialogPage(
                    OAException.ERROR
                );
                
                dialogPage.setTitle("Navigation Error");
                dialogPage.setMessage("Your transaction state has been lost. " +
                                    "Please start over.");
                
                pageContext.redirectToDialogPage(dialogPage);
            }
        }
    }

    /**
     * USE CASE 7: Handle Back Button - End Transaction
     * 
     * End transaction unit before navigation.
     * Call from processFormRequest before forwarding.
     * 
     * @param pageContext Current page context
     */
    public void handleBackButtonProcessFormRequest(OAPageContext pageContext) {
        // Transaction unit name - same as in processRequest
        String txnUnitName = "xxcust.order.createOrderTxn";
        
        // Before navigating to different page or submitting form
        if (pageContext.getParameter("Submit") != null) {
            // Process the form submission
            
            // After successful processing, end transaction unit
            TransactionUnitHelper.endTransactionUnit(
                pageContext, 
                txnUnitName
            );
            
            System.out.println("Transaction unit ended: " + txnUnitName);
            
            // Now safe to navigate
            // pageContext.forwardImmediately(...);
        }
    }

    /**
     * USE CASE 8: Wrap Text in Read-Only Text Area
     * 
     * Enable text wrapping in message text areas.
     * 
     * When to use:
     * - Long text display
     * - Comments/descriptions
     * - Read-only text areas
     * - Improve readability
     * 
     * Best Practice:
     * - Use SOFT_WRAP for user-friendly display
     * - Set appropriate width
     * - Test with various text lengths
     * - Consider browser compatibility
     * 
     * Common Mistakes:
     * - Not setting wrap property
     * - Using wrong wrap constant
     * - Not setting appropriate width
     * - Using on editable fields
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void wrapTextInTextArea(OAPageContext pageContext, OAWebBean webBean) {
        // Call from processRequest
        
        // Find the text area bean
        OAMessageTextInputBean textBean = 
            (OAMessageTextInputBean) webBean.findChildRecursive("Comments");
        
        if (textBean != null) {
            // Enable soft wrap (wraps at word boundaries)
            textBean.setWrap(OAWebBeanConstants.SOFT_WRAP);
            
            // Alternative: HARD_WRAP (wraps at exact width)
            // textBean.setWrap(OAWebBeanConstants.HARD_WRAP);
            
            // Set maximum width if needed
            textBean.setMaximumLength(2000);
            
            System.out.println("Text wrapping enabled for Comments field");
        }
    }

    /**
     * USE CASE 9: Check if Form Submission
     * 
     * Determine if current request is a form submission.
     * Used to avoid re-initializing data on POST.
     * 
     * When to use:
     * - Conditional initialization in processRequest
     * - Avoid re-querying on form submit
     * - Preserve user input
     * - Optimize performance
     * 
     * Best Practice:
     * - Initialize only on first load (GET)
     * - Don't re-query on POST
     * - Preserve form state
     * - Common pattern in OAF
     * 
     * Common Mistakes:
     * - Re-initializing on every request
     * - Losing user input
     * - Performance issues from re-querying
     * - Wrong conditional logic
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void checkFormSubmission(OAPageContext pageContext, OAWebBean webBean) {
        // Call from processRequest
        
        // Check if this is a form submission (POST)
        if (!pageContext.isFormSubmission()) {
            // First time page load (GET request)
            // Initialize data, set defaults, execute queries
            
            System.out.println("First page load - initializing data");
            
            // Get AM
            // OAApplicationModule am = pageContext.getApplicationModule(webBean);
            
            // Initialize data
            // am.invokeMethod("initializeData", null);
            
            // Set default values
            // am.invokeMethod("setDefaults", null);
            
        } else {
            // Form submission (POST request)
            // Don't re-initialize, preserve user input
            
            System.out.println("Form submission - preserving state");
        }
    }

    /**
     * USE CASE 10: Get Event and Source Parameters
     * 
     * Identify which component fired the event.
     * 
     * When to use:
     * - Multiple buttons on page
     * - Dynamic event handling
     * - Complex forms
     * - Conditional processing
     * 
     * Best Practice:
     * - Check event and source together
     * - Use meaningful source IDs
     * - Document event handling logic
     * - Consider using button names instead
     * 
     * Common Mistakes:
     * - Not checking source
     * - Assuming event parameter exists
     * - Complex conditional logic
     * - Not handling all events
     * 
     * @param pageContext Current page context
     */
    public void getEventAndSource(OAPageContext pageContext) {
        // Call from processFormRequest
        
        // Get the event parameter (action taken)
        String event = pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM);
        
        // Get the source parameter (component that fired event)
        String source = pageContext.getParameter(OAWebBeanConstants.SOURCE_PARAM);
        
        System.out.println("Event: " + event);
        System.out.println("Source: " + source);
        
        // Example usage:
        if ("update".equals(event)) {
            System.out.println("Update event fired");
            
            // Check source to determine which update button
            if ("UpdateBtn1".equals(source)) {
                // Handle update from button 1
            } else if ("UpdateBtn2".equals(source)) {
                // Handle update from button 2
            }
        }
        
        // Common events:
        // - "update" - Update button clicked
        // - "delete" - Delete button clicked
        // - "add" - Add button clicked
        // - Custom events from fire action
    }

    /**
     * USE CASE 11: Programmatically Set Field Values
     * 
     * Set field values programmatically in controller.
     * 
     * When to use:
     * - Setting defaults
     * - Calculated fields
     * - Cross-field updates
     * - Dynamic values
     * 
     * Best Practice:
     * - Set in processRequest for display
     * - Use AM for data changes
     * - Don't bypass validation
     * - Document side effects
     * 
     * Common Mistakes:
     * - Setting in processFormRequest
     * - Bypassing business logic
     * - Not handling null values
     * - Overwriting user input
     * 
     * @param pageContext Current page context
     * @param webBean Current web bean
     */
    public void setFieldValuesProgrammatically(
            OAPageContext pageContext, 
            OAWebBean webBean) {
        
        // Find the field by ID
        OAMessageTextInputBean textField = 
            (OAMessageTextInputBean) webBean.findChildRecursive("EmployeeName");
        
        if (textField != null) {
            // Set value programmatically
            textField.setValue(pageContext, "John Doe");
            
            // Set other properties
            textField.setRequired("yes");
            textField.setMaximumLength(100);
            
            System.out.println("Field value set to: John Doe");
        }
        
        // Note: For data changes, use AM methods instead
        // This approach is for UI-only changes
    }

    /**
     * USE CASE 12: Release Database Lock
     * 
     * Set locking mode to LOCK_NONE for read-only operations.
     * 
     * When to use:
     * - Read-only pages
     * - Reporting
     * - Search pages
     * - Avoid unnecessary locks
     * 
     * Best Practice:
     * - Set in AM initialization
     * - Use for read-only operations
     * - Don't use if updates needed
     * - Improves concurrency
     * 
     * Common Mistakes:
     * - Using on update pages
     * - Not setting early enough
     * - Forgetting to set back
     * - Causing concurrency issues
     */
    public void releaseDatabaseLock() {
        // Call from AM method
        // Example in ApplicationModuleImpl:
        
        // Get DB transaction
        // OADBTransaction txn = getOADBTransaction();
        
        // Set locking mode to NONE
        // txn.setLockingMode(OADBTransaction.LOCK_NONE);
        
        System.out.println("Database locking disabled");
        
        // Use case: Read-only search page
        // No updates will be made
        // Improves concurrent access
    }

    /**
     * USE CASE 13: Advanced Controller Extension Pattern
     * 
     * Extend seeded Oracle controller with custom logic.
     * 
     * When to use:
     * - Extending seeded pages
     * - Adding custom functionality
     * - Personalization not sufficient
     * - Need programmatic control
     * 
     * Best Practice:
     * - Call super methods first
     * - Document extension purpose
     * - Test after patches
     * - Minimize changes
     * 
     * Common Mistakes:
     * - Not calling super
     * - Overriding too much
     * - Breaking after patches
     * - No documentation
     * 
     * Implementation:
     * 1. Create custom controller extending seeded controller
     * 2. Override processRequest or processFormRequest
     * 3. Call super method first
     * 4. Add custom logic
     * 5. Use personalization to set custom controller on region
     */
    public void controllerExtensionPattern() {
        String example =
            "Controller Extension Example:\n" +
            "=============================\n" +
            "\n" +
            "// 1. Create custom controller\n" +
            "public class XXCustomCO extends oracle.apps.fnd.framework.webui.OAControllerImpl {\n" +
            "  \n" +
            "  // 2. Override processRequest\n" +
            "  public void processRequest(OAPageContext pageContext, OAWebBean webBean) {\n" +
            "    // 3. ALWAYS call super first\n" +
            "    super.processRequest(pageContext, webBean);\n" +
            "    \n" +
            "    // 4. Add custom logic\n" +
            "    System.out.println(\"Custom controller logic\");\n" +
            "    \n" +
            "    // Example: Hide a field based on profile\n" +
            "    String profile = pageContext.getProfile(\"XXCUST_HIDE_FIELD\");\n" +
            "    if (\"Y\".equals(profile)) {\n" +
            "      OAWebBean field = webBean.findChildRecursive(\"FieldId\");\n" +
            "      if (field != null) {\n" +
            "        field.setRendered(false);\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "  \n" +
            "  // Override processFormRequest if needed\n" +
            "  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {\n" +
            "    super.processFormRequest(pageContext, webBean);\n" +
            "    // Custom form handling\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "// 5. Use Personalization:\n" +
            "// - Navigate to page\n" +
            "// - Click Personalize Page\n" +
            "// - Find the region\n" +
            "// - Set Controller Class to: xxcust.oracle.apps.fnd.custom.XXCustomCO\n" +
            "// - Apply and test";
        
        System.out.println(example);
    }

    /**
     * USE CASE 14: Best Practices Summary
     * 
     * Comprehensive best practices for advanced controller patterns.
     */
    public void advancedControllerBestPractices() {
        String practices =
            "Advanced Controller Best Practices:\n" +
            "====================================\n" +
            "\n" +
            "Form Submission Blocking:\n" +
            "- Use setBlockOnEverySubmit for page-wide blocking\n" +
            "- Use JavaScript for selective button blocking\n" +
            "- Always provide user feedback (cursor, message)\n" +
            "- Consider OAProcessingPage for very long operations\n" +
            "- Test timeout scenarios\n" +
            "\n" +
            "Focus Management:\n" +
            "- Set initial focus on primary input field\n" +
            "- Don't focus on disabled/hidden fields\n" +
            "- Test tab order thoroughly\n" +
            "- Consider user workflow\n" +
            "\n" +
            "Back Button Handling:\n" +
            "- Use TransactionUnitHelper for flows\n" +
            "- Start in processRequest\n" +
            "- End before navigation\n" +
            "- Show clear error messages\n" +
            "- Test thoroughly\n" +
            "\n" +
            "Event Handling:\n" +
            "- Check event and source parameters\n" +
            "- Use meaningful component IDs\n" +
            "- Document event handling logic\n" +
            "- Handle all possible events\n" +
            "\n" +
            "Controller Extension:\n" +
            "- Always call super methods first\n" +
            "- Minimize changes to seeded code\n" +
            "- Document extension purpose\n" +
            "- Test after patches\n" +
            "- Consider personalization first\n" +
            "\n" +
            "Performance:\n" +
            "- Check isFormSubmission before initializing\n" +
            "- Don't re-query on POST\n" +
            "- Release locks when appropriate\n" +
            "- Minimize processRequest logic\n" +
            "\n" +
            "Security:\n" +
            "- Validate all user input\n" +
            "- Check permissions\n" +
            "- Don't expose sensitive data\n" +
            "- Log security events\n" +
            "\n" +
            "Debugging:\n" +
            "- Use FND_DIAGNOSTICS profile\n" +
            "- Log entry/exit of methods\n" +
            "- Log event parameters\n" +
            "- Include context in messages";
        
        System.out.println(practices);
    }
}
