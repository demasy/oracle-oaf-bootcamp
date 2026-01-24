/*===========================================================================+
 | Oracle Applications Framework (OAF) - Exception Handling Examples
 | 
 | USE CASE: Proper error handling and user message display in OAF
 | LOCATION: Controller, Application Module, Entity Object
 | COMPLEXITY: Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.webui;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAApplicationModule;

public class OAExceptionHandling {
    
    /**
     * Throw a simple error message
     * Use Case: Display error to user when validation fails
     */
    public void throwSimpleError(OAPageContext pageContext) {
        throw new OAException("Job Name cannot be empty", 
                            OAException.ERROR);
    }
    
    /**
     * Throw error with message dictionary
     * Use Case: Use centralized message for internationalization
     */
    public void throwMessageDictionaryError(OAPageContext pageContext) {
        // Message defined in FND_NEW_MESSAGES table
        // Product: XX
        // Message Name: INVALID_JOB_NAME
        throw new OAException("XX", "INVALID_JOB_NAME");
    }
    
    /**
     * Throw error with message tokens
     * Use Case: Dynamic error messages with variable values
     */
    public void throwErrorWithTokens(OAPageContext pageContext, String jobName) {
        // Message text in dictionary: "Job '{JOB_NAME}' already exists"
        OAException errorMsg = new OAException("XX", "DUPLICATE_JOB_NAME");
        errorMsg.setApplicationModule(null);
        
        // Set token values
        errorMsg.setMessageToken("JOB_NAME", jobName);
        
        throw errorMsg;
    }
    
    /**
     * Display warning message
     * Use Case: Inform user without stopping execution
     */
    public void displayWarning(OAPageContext pageContext) {
        OAException warning = new OAException("This job has no positions assigned", 
                                             OAException.WARNING);
        pageContext.putDialogMessage(warning);
    }
    
    /**
     * Display confirmation message
     * Use Case: Show success message after operation
     */
    public void displayConfirmation(OAPageContext pageContext, String jobName) {
        OAException confirmation = new OAException("Job '" + jobName + "' created successfully", 
                                                  OAException.CONFIRMATION);
        pageContext.putDialogMessage(confirmation);
    }
    
    /**
     * Display information message
     * Use Case: Provide helpful information to user
     */
    public void displayInformation(OAPageContext pageContext) {
        OAException info = new OAException("Please fill all required fields", 
                                          OAException.INFORMATION);
        pageContext.putDialogMessage(info);
    }
    
    /**
     * Handle exceptions from Application Module
     * Use Case: Catch and handle database or business logic exceptions
     */
    public void handleAMException(OAPageContext pageContext, OAApplicationModule am) {
        try {
            // Call AM method that might throw exception
            am.invokeMethod("createJob", new Object[]{"Test Job"});
            
            // Success message
            OAException msg = new OAException("Job created successfully", 
                                             OAException.CONFIRMATION);
            pageContext.putDialogMessage(msg);
            
        } catch (OAException oe) {
            // OAF exception - display to user
            pageContext.putDialogMessage(oe);
            
        } catch (Exception e) {
            // Generic exception - wrap in OAException
            OAException errorMsg = new OAException("An unexpected error occurred: " + 
                                                   e.getMessage(), 
                                                   OAException.ERROR);
            pageContext.putDialogMessage(errorMsg);
        }
    }
    
    /**
     * Throw exception with severity
     * Use Case: Control how message is displayed (inline vs popup)
     */
    public void throwExceptionWithSeverity(OAPageContext pageContext) {
        OAException error = new OAException("XX", "INVALID_DATE_RANGE");
        
        // Set severity - determines display style
        // ERROR: Red exclamation mark
        // WARNING: Yellow warning icon
        // CONFIRMATION: Green checkmark
        // INFORMATION: Blue info icon
        error.setApplicationModule(null);
        
        throw error;
    }
    
    /**
     * Add multiple messages to page
     * Use Case: Show multiple validation errors at once
     */
    public void addMultipleMessages(OAPageContext pageContext) {
        // First error
        OAException error1 = new OAException("Job Name is required", 
                                            OAException.ERROR);
        pageContext.putDialogMessage(error1);
        
        // Second error
        OAException error2 = new OAException("Effective Start Date is required", 
                                            OAException.ERROR);
        pageContext.putDialogMessage(error2);
        
        // Note: Multiple messages will be displayed together
    }
    
    /**
     * Throw exception to stop processing
     * Use Case: Critical error that requires immediate attention
     */
    public void throwCriticalError(OAPageContext pageContext) {
        // This will stop all processing and display error
        throw new OAException("Critical Error: Unable to connect to database", 
                            OAException.ERROR);
    }
    
    /**
     * Custom exception handling in Entity Object
     * Use Case: Validation in Model layer
     */
    public void entityValidationError() {
        // In Entity Object validateEntity() method
        throw new OAException("XX", "INVALID_JOB_HEADCOUNT", 
                            null, OAException.ERROR, null);
    }
    
    /**
     * Handle SQL exceptions
     * Use Case: Database constraint violations
     */
    public void handleSQLException(OAPageContext pageContext) {
        try {
            // Database operation
            // ...
        } catch (java.sql.SQLException sqle) {
            String sqlError = sqle.getMessage();
            
            // Check for specific errors
            if (sqlError.contains("ORA-00001")) {
                // Unique constraint violation
                throw new OAException("XX", "DUPLICATE_RECORD");
            } else if (sqlError.contains("ORA-02291")) {
                // Foreign key constraint violation
                throw new OAException("XX", "INVALID_REFERENCE");
            } else {
                // Generic database error
                throw new OAException("Database error: " + sqlError, 
                                    OAException.ERROR);
            }
        }
    }
    
    /**
     * Throw exception with detail message
     * Use Case: Provide technical details for troubleshooting
     */
    public void throwExceptionWithDetails(OAPageContext pageContext, Exception e) {
        OAException error = new OAException("Operation failed");
        
        // Add detail message (shown in "Show Details" link)
        OAException detail = new OAException(e.getMessage());
        error.addDetailException(detail);
        
        throw error;
    }
}
