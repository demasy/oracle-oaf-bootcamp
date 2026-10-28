/*===========================================================================+
 | Oracle Applications Framework (OAF) - Controller Common Patterns
 | 
 | USE CASE: processRequest, processFormRequest, event handling
 | LOCATION: Controller
 | COMPLEXITY: Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import java.io.Serializable;

public class ControllerPatterns extends OAControllerImpl {
    
    public static final String RCS_ID="$Header$";
    public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * processRequest - Page Initialization
     * Use Case: Initialize page when it loads (GET request)
     */
    @Override
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Get Application Module
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Check page mode
        String mode = pageContext.getParameter("mode");
        
        if ("CREATE".equals(mode)) {
            // Initialize for create mode
            am.invokeMethod("initializeForCreate");
            
        } else if ("UPDATE".equals(mode)) {
            // Initialize for update mode
            String jobId = pageContext.getParameter("jobId");
            am.invokeMethod("initializeForUpdate", new Object[]{jobId});
            
        } else if ("VIEW".equals(mode)) {
            // Initialize for view mode
            String jobId = pageContext.getParameter("jobId");
            am.invokeMethod("initializeForView", new Object[]{jobId});
            
            // Make fields read-only in view mode
            // (Set in personalization or programmatically)
        }
        
        // Set default values
        if ("CREATE".equals(mode)) {
            setDefaultValues(pageContext, webBean);
        }
    }
    
    /**
     * processFormRequest - Handle Form Submissions
     * Use Case: Handle button clicks and form submissions (POST request)
     */
    @Override
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Save button clicked
        if (pageContext.getParameter("Save") != null) {
            handleSave(pageContext, am);
        }
        // Cancel button clicked
        else if (pageContext.getParameter("Cancel") != null) {
            handleCancel(pageContext, am);
        }
        // Delete button clicked
        else if (pageContext.getParameter("Delete") != null) {
            handleDelete(pageContext, am);
        }
        // Apply button clicked
        else if (pageContext.getParameter("Apply") != null) {
            handleApply(pageContext, am);
        }
        // Search button clicked
        else if (pageContext.getParameter("Search") != null) {
            handleSearch(pageContext, am);
        }
        // Clear button clicked
        else if (pageContext.getParameter("Clear") != null) {
            handleClear(pageContext, am);
        }
    }
    
    /**
     * Handle Save button
     * Use Case: Validate and commit changes
     */
    private void handleSave(OAPageContext pageContext, OAApplicationModule am) {
        try {
            // Validate data
            if (!validateData(pageContext)) {
                return;
            }
            
            // Save to database
            am.invokeMethod("apply");
            am.invokeMethod("commit");
            
            // Show success message
            OAException msg = new OAException("Changes saved successfully",
                                             OAException.CONFIRMATION);
            pageContext.putDialogMessage(msg);
            
            // Navigate to search page
            pageContext.forwardImmediately(
                "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
                null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, null, true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
            
        } catch (Exception e) {
            // Rollback on error
            am.invokeMethod("rollback");
            
            OAException error = new OAException("Error saving: " + e.getMessage(),
                                               OAException.ERROR);
            throw error;
        }
    }
    
    /**
     * Handle Cancel button
     * Use Case: Discard changes and navigate away
     */
    private void handleCancel(OAPageContext pageContext, OAApplicationModule am) {
        // Rollback any pending changes
        am.invokeMethod("rollback");
        
        // Navigate back to search page
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
            null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, null, true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
    
    /**
     * Handle Delete button with confirmation
     * Use Case: Delete record with user confirmation
     */
    private void handleDelete(OAPageContext pageContext, OAApplicationModule am) {
        // Check if confirmation received
        if (pageContext.getParameter("DeleteConfirm") != null) {
            // User confirmed - perform delete
            String jobId = pageContext.getParameter("jobId");
            
            try {
                am.invokeMethod("deleteJob", new Object[]{jobId});
                am.invokeMethod("commit");
                
                OAException msg = new OAException("Job deleted successfully",
                                                 OAException.CONFIRMATION);
                pageContext.putDialogMessage(msg);
                
                // Navigate away
                pageContext.forwardImmediately(
                    "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
                    null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, null, true,
                    OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
                    
            } catch (Exception e) {
                am.invokeMethod("rollback");
                throw new OAException("Error deleting: " + e.getMessage(),
                                    OAException.ERROR);
            }
        } else {
            // Show confirmation dialog
            showDeleteConfirmation(pageContext);
        }
    }
    
    /**
     * Show delete confirmation dialog
     * Use Case: Prompt user before destructive action
     */
    private void showDeleteConfirmation(OAPageContext pageContext) {
        String jobName = pageContext.getParameter("JobName");
        
        OAException msg = new OAException("Delete job '" + jobName + "'?");
        oracle.apps.fnd.framework.webui.OADialogPage dialog = 
            new oracle.apps.fnd.framework.webui.OADialogPage(
                OAException.CONFIRMATION, msg, null, "", "");
        
        dialog.setOkButtonItemName("DeleteConfirm");
        dialog.setOkButtonToPost(true);
        dialog.setNoButtonToPost(true);
        dialog.setPostToCallingPage(true);
        
        String yes = pageContext.getMessage("FND", "YES", null);
        String no = pageContext.getMessage("FND", "NO", null);
        dialog.setOkButtonLabel(yes);
        dialog.setNoButtonLabel(no);
        
        // Pass job info through dialog
        java.util.Hashtable params = new java.util.Hashtable();
        params.put("jobId", pageContext.getParameter("jobId"));
        dialog.setFormParameters(params);
        
        pageContext.redirectToDialogPage(dialog);
    }
    
    /**
     * Handle Apply button
     * Use Case: Save without navigation
     */
    private void handleApply(OAPageContext pageContext, OAApplicationModule am) {
        try {
            if (!validateData(pageContext)) {
                return;
            }
            
            am.invokeMethod("apply");
            am.invokeMethod("commit");
            
            OAException msg = new OAException("Changes applied successfully",
                                             OAException.CONFIRMATION);
            pageContext.putDialogMessage(msg);
            
            // Stay on same page
            
        } catch (Exception e) {
            am.invokeMethod("rollback");
            throw new OAException("Error applying changes: " + e.getMessage(),
                                OAException.ERROR);
        }
    }
    
    /**
     * Handle Search button
     * Use Case: Execute search query
     */
    private void handleSearch(OAPageContext pageContext, OAApplicationModule am) {
        // Get search criteria
        String jobName = pageContext.getParameter("SearchJobName");
        String startDate = pageContext.getParameter("SearchStartDate");
        
        // Invoke search method
        am.invokeMethod("searchJobs", new Object[]{jobName, startDate});
    }
    
    /**
     * Handle Clear button
     * Use Case: Reset search form
     */
    private void handleClear(OAPageContext pageContext, OAApplicationModule am) {
        // Clear search results
        am.invokeMethod("clearSearch");
        
        // Redirect to clear form fields
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
            null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, null, true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
    
    /**
     * Validate form data
     * Use Case: Client-side-style validation in controller
     */
    private boolean validateData(OAPageContext pageContext) {
        boolean isValid = true;
        
        String jobName = pageContext.getParameter("JobName");
        if (jobName == null || jobName.trim().length() == 0) {
            OAException error = new OAException("Job Name is required",
                                               OAException.ERROR);
            pageContext.putDialogMessage(error);
            isValid = false;
        }
        
        String headCount = pageContext.getParameter("HeadCount");
        if (headCount != null && headCount.trim().length() > 0) {
            try {
                int count = Integer.parseInt(headCount);
                if (count <= 0) {
                    OAException error = new OAException("Head Count must be positive",
                                                       OAException.ERROR);
                    pageContext.putDialogMessage(error);
                    isValid = false;
                }
            } catch (NumberFormatException e) {
                OAException error = new OAException("Invalid Head Count",
                                                   OAException.ERROR);
                pageContext.putDialogMessage(error);
                isValid = false;
            }
        }
        
        return isValid;
    }
    
    /**
     * Set default values for new record
     * Use Case: Initialize fields with default values
     */
    private void setDefaultValues(OAPageContext pageContext, OAWebBean webBean) {
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Set default effective start date to today
        String today = pageContext.getCurrentDBDate().toString();
        am.invokeMethod("setDefaultStartDate", new Object[]{today});
    }
    
    /**
     * Handle table row action (e.g., update icon clicked)
     * Use Case: Navigate with parameters from table row
     */
    public void handleTableRowAction(OAPageContext pageContext, String eventName) {
        // Get selected row parameters
        String jobId = pageContext.getParameter("jobId");
        String jobName = pageContext.getParameter("jobName");
        
        if ("UPDATE".equals(eventName)) {
            // Navigate to update page with parameters
            pageContext.setForwardURL(
                "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG" +
                "&mode=UPDATE&jobId=" + jobId,
                null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, 
                null, true, OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
                OAWebBeanConstants.IGNORE_MESSAGES);
        }
    }
}
