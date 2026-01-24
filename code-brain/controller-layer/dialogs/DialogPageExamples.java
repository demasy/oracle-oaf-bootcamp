/*===========================================================================+
 | Oracle Applications Framework (OAF) - Dialog Page Examples
 | 
 | USE CASE: Display confirmation, warning, error, and information dialogs
 | LOCATION: Controller
 | COMPLEXITY: Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.webui;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAApplicationModule;
import java.util.Hashtable;

public class DialogPageExamples {
    
    /**
     * Simple Confirmation Dialog
     * Use Case: Ask user for confirmation before action
     */
    public void simpleConfirmationDialog(OAPageContext pageContext, String jobName) {
        // Create main message
        OAException mainMessage = new OAException("Are you sure you want to delete job '" + 
                                                 jobName + "'?");
        
        // Create dialog page
        OADialogPage dialogPage = new OADialogPage(
            OAException.CONFIRMATION,  // Message type
            mainMessage,                // Main message
            null,                       // Detail message (optional)
            "",                        // OK button destination
            ""                         // No button destination
        );
        
        // Redirect to dialog
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Confirmation Dialog with Yes/No buttons
     * Use Case: Yes/No confirmation with custom labels
     */
    public void confirmationDialogYesNo(OAPageContext pageContext, 
                                       String jobName, 
                                       Number jobId) {
        OAException mainMessage = new OAException("Do you want to delete job '" + 
                                                 jobName + "'?");
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.CONFIRMATION,
            mainMessage,
            null,
            "",
            ""
        );
        
        // Get Yes/No labels from message dictionary
        String yes = pageContext.getMessage("FND", "YES", null);
        String no = pageContext.getMessage("FND", "NO", null);
        
        // Set button labels
        dialogPage.setOkButtonLabel(yes);
        dialogPage.setNoButtonLabel(no);
        
        // Set button names for identification in processFormRequest
        dialogPage.setOkButtonItemName("YesButton");
        
        // Post back to calling page to handle response
        dialogPage.setOkButtonToPost(true);
        dialogPage.setNoButtonToPost(true);
        dialogPage.setPostToCallingPage(true);
        
        // Pass parameters through dialog
        Hashtable formParams = new Hashtable(1);
        formParams.put("jobId", jobId.toString());
        formParams.put("jobName", jobName);
        dialogPage.setFormParameters(formParams);
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Handle Dialog Response in processFormRequest
     * Use Case: Process user's choice from dialog
     */
    public void handleDialogResponse(OAPageContext pageContext, OAWebBean webBean) {
        // Check if Yes button was clicked
        if (pageContext.getParameter("YesButton") != null) {
            // User clicked Yes - perform action
            String jobId = pageContext.getParameter("jobId");
            String jobName = pageContext.getParameter("jobName");
            
            OAApplicationModule am = pageContext.getRootApplicationModule();
            if (am != null) {
                // Delete the job
                am.invokeMethod("deleteJob", new Object[]{jobId});
                
                // Show success message
                OAException msg = new OAException("Job '" + jobName + "' deleted successfully",
                                                 OAException.CONFIRMATION);
                pageContext.putDialogMessage(msg);
            }
        } else {
            // User clicked No - do nothing or show cancellation message
            OAException msg = new OAException("Deletion cancelled", 
                                             OAException.INFORMATION);
            pageContext.putDialogMessage(msg);
        }
    }
    
    /**
     * Warning Dialog
     * Use Case: Warn user about potential issue
     */
    public void warningDialog(OAPageContext pageContext) {
        OAException mainMessage = new OAException("This job has positions assigned. " +
                                                 "Deleting it will remove all positions.");
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.WARNING,  // Warning type
            mainMessage,
            null,
            "",
            ""
        );
        
        // Set button labels
        dialogPage.setOkButtonLabel("Continue");
        dialogPage.setNoButtonLabel("Cancel");
        
        dialogPage.setOkButtonToPost(true);
        dialogPage.setNoButtonToPost(true);
        dialogPage.setPostToCallingPage(true);
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Error Dialog
     * Use Case: Display error information
     */
    public void errorDialog(OAPageContext pageContext, String errorMsg) {
        OAException mainMessage = new OAException("An error occurred: " + errorMsg);
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.ERROR,
            mainMessage,
            null,
            "",
            ""
        );
        
        // Error dialogs typically have only OK button
        dialogPage.setOkButtonLabel("OK");
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Information Dialog
     * Use Case: Display informational message
     */
    public void informationDialog(OAPageContext pageContext) {
        OAException mainMessage = new OAException("Job created successfully. " +
                                                 "You can now add positions.");
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.INFORMATION,
            mainMessage,
            null,
            "",
            ""
        );
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Dialog with Detail Message
     * Use Case: Show additional information in expandable section
     */
    public void dialogWithDetails(OAPageContext pageContext, String errorDetail) {
        OAException mainMessage = new OAException("Failed to create job");
        OAException detailMessage = new OAException("Technical Details: " + errorDetail);
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.ERROR,
            mainMessage,
            detailMessage,  // Detail message shown in expandable section
            "",
            ""
        );
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Dialog with Navigation
     * Use Case: Navigate to different page after confirmation
     */
    public void dialogWithNavigation(OAPageContext pageContext) {
        OAException mainMessage = new OAException("Job created successfully");
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.CONFIRMATION,
            mainMessage,
            null,
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",  // OK destination
            null  // No button destination
        );
        
        // Navigation will happen automatically after OK click
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Dialog with Multiple Form Parameters
     * Use Case: Pass multiple values through dialog
     */
    public void dialogWithMultipleParams(OAPageContext pageContext, 
                                        Number jobId,
                                        String jobName,
                                        String action) {
        OAException mainMessage = new OAException("Confirm action: " + action);
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.CONFIRMATION,
            mainMessage,
            null,
            "",
            ""
        );
        
        // Set buttons
        dialogPage.setOkButtonItemName("ConfirmButton");
        dialogPage.setOkButtonToPost(true);
        dialogPage.setNoButtonToPost(true);
        dialogPage.setPostToCallingPage(true);
        
        // Pass multiple parameters
        Hashtable formParams = new Hashtable();
        formParams.put("jobId", jobId.toString());
        formParams.put("jobName", jobName);
        formParams.put("action", action);
        formParams.put("timestamp", String.valueOf(System.currentTimeMillis()));
        dialogPage.setFormParameters(formParams);
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Dialog with Message Dictionary
     * Use Case: Use centralized messages for internationalization
     */
    public void dialogWithMessageDict(OAPageContext pageContext, String jobName) {
        // Message from FND_NEW_MESSAGES: "Do you want to delete job {JOB_NAME}?"
        OAException mainMessage = new OAException("XX", "CONFIRM_DELETE_JOB");
        mainMessage.setApplicationModule(null);
        mainMessage.setMessageToken("JOB_NAME", jobName);
        
        OADialogPage dialogPage = new OADialogPage(
            OAException.CONFIRMATION,
            mainMessage,
            null,
            "",
            ""
        );
        
        // Get button labels from message dictionary
        String yes = pageContext.getMessage("FND", "YES", null);
        String no = pageContext.getMessage("FND", "NO", null);
        
        dialogPage.setOkButtonLabel(yes);
        dialogPage.setNoButtonLabel(no);
        dialogPage.setOkButtonToPost(true);
        dialogPage.setNoButtonToPost(true);
        dialogPage.setPostToCallingPage(true);
        
        pageContext.redirectToDialogPage(dialogPage);
    }
    
    /**
     * Complete Dialog Flow Example
     * Use Case: Full dialog implementation with response handling
     */
    public void completeDialogFlow(OAPageContext pageContext, 
                                   OAWebBean webBean,
                                   String eventName) {
        // In processFormRequest
        
        if ("DELETE".equals(eventName)) {
            // Show confirmation dialog
            String jobId = pageContext.getParameter("jobId");
            String jobName = pageContext.getParameter("jobName");
            
            OAException msg = new OAException("Delete job '" + jobName + "'?");
            OADialogPage dialog = new OADialogPage(
                OAException.CONFIRMATION, msg, null, "", "");
            
            dialog.setOkButtonItemName("DeleteConfirm");
            dialog.setOkButtonToPost(true);
            dialog.setNoButtonToPost(true);
            dialog.setPostToCallingPage(true);
            
            Hashtable params = new Hashtable();
            params.put("jobIdToDelete", jobId);
            params.put("jobNameToDelete", jobName);
            dialog.setFormParameters(params);
            
            pageContext.redirectToDialogPage(dialog);
            
        } else if (pageContext.getParameter("DeleteConfirm") != null) {
            // Handle confirmation response
            String jobId = pageContext.getParameter("jobIdToDelete");
            String jobName = pageContext.getParameter("jobNameToDelete");
            
            OAApplicationModule am = pageContext.getRootApplicationModule();
            if (am != null) {
                try {
                    am.invokeMethod("deleteJob", new Object[]{jobId});
                    
                    OAException success = new OAException(
                        "Job '" + jobName + "' deleted", 
                        OAException.CONFIRMATION);
                    pageContext.putDialogMessage(success);
                    
                } catch (Exception e) {
                    OAException error = new OAException(
                        "Error deleting job: " + e.getMessage(),
                        OAException.ERROR);
                    pageContext.putDialogMessage(error);
                }
            }
        }
    }
}
