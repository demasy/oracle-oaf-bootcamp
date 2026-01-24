/*===========================================================================+
 | Oracle Applications Framework (OAF) - Navigation Patterns
 | 
 | USE CASE: Page navigation, parameter passing, breadcrumbs
 | LOCATION: Controller
 | COMPLEXITY: Basic to Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.webui;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import java.util.HashMap;

public class NavigationPatterns {
    
    /**
     * Forward to another page immediately
     * Use Case: Redirect after save/delete
     */
    public void forwardImmediately(OAPageContext pageContext) {
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
            null,                                      // Function name (null = none)
            OAWebBeanConstants.KEEP_MENU_CONTEXT,     // Keep menu context
            null,                                      // Menu name (null = current)
            null,                                      // Parameters (HashMap)
            true,                                      // Retain AM
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);   // No breadcrumb
    }
    
    /**
     * Forward with parameters
     * Use Case: Pass data to next page
     */
    public void forwardWithParameters(OAPageContext pageContext, 
                                     String jobId, 
                                     String mode) {
        HashMap params = new HashMap();
        params.put("jobId", jobId);
        params.put("mode", mode);
        
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            params,                                    // Pass parameters
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);  // Add breadcrumb
    }
    
    /**
     * Forward with URL parameters
     * Use Case: Simple parameter passing in URL
     */
    public void forwardWithURLParams(OAPageContext pageContext, 
                                    String jobId) {
        String url = "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG" +
                    "&jobId=" + jobId +
                    "&mode=UPDATE";
        
        pageContext.forwardImmediately(
            url,
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);
    }
    
    /**
     * Set forward URL (deferred navigation)
     * Use Case: Navigate after current processing completes
     */
    public void setForwardURL(OAPageContext pageContext, String jobId) {
        pageContext.setForwardURL(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG&jobId=" + jobId,
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,                                      // Retain AM
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
            OAWebBeanConstants.IGNORE_MESSAGES);       // Don't clear messages
    }
    
    /**
     * Navigate with breadcrumb
     * Use Case: Add page to navigation trail
     */
    public void navigateWithBreadcrumb(OAPageContext pageContext, 
                                      String jobName) {
        HashMap params = new HashMap();
        params.put("jobId", "123");
        
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            params,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);  // Creates breadcrumb
        
        // Breadcrumb label can be customized in page properties
    }
    
    /**
     * Navigate without retaining AM
     * Use Case: Clear state when navigating
     */
    public void navigateWithoutRetainAM(OAPageContext pageContext) {
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            false,                                     // Don't retain AM
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
    
    /**
     * Return to calling page
     * Use Case: Cancel operation and go back
     */
    public void returnToCallingPage(OAPageContext pageContext) {
        // Get return page from parameter
        String returnPage = pageContext.getParameter("retPage");
        
        if (returnPage != null && returnPage.length() > 0) {
            pageContext.forwardImmediately(
                returnPage,
                null,
                OAWebBeanConstants.KEEP_MENU_CONTEXT,
                null,
                null,
                true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
        } else {
            // Default return location
            pageContext.forwardImmediately(
                "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
                null,
                OAWebBeanConstants.KEEP_MENU_CONTEXT,
                null,
                null,
                true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
        }
    }
    
    /**
     * Navigate with function call
     * Use Case: Navigate through menu function
     */
    public void navigateWithFunction(OAPageContext pageContext) {
        pageContext.forwardImmediately(
            null,
            "XX_JOBS_SEARCH",                         // Function name
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);
    }
    
    /**
     * Navigate to external URL
     * Use Case: Redirect to external website or servlet
     */
    public void navigateToExternalURL(OAPageContext pageContext, String url) {
        pageContext.sendRedirect(url);
    }
    
    /**
     * Navigate with message preservation
     * Use Case: Keep messages when navigating
     */
    public void navigatePreserveMessages(OAPageContext pageContext) {
        pageContext.setForwardURL(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobSearchPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
            OAWebBeanConstants.IGNORE_MESSAGES);       // Preserve messages
    }
    
    /**
     * Navigate to self (refresh page)
     * Use Case: Reload current page with new state
     */
    public void refreshCurrentPage(OAPageContext pageContext) {
        String currentPage = pageContext.getCurrentOAPage();
        
        pageContext.forwardImmediately(
            "OA.jsp?page=" + currentPage,
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
    
    /**
     * Navigate based on condition
     * Use Case: Dynamic navigation based on business logic
     */
    public void conditionalNavigation(OAPageContext pageContext, 
                                     String userRole) {
        String targetPage;
        
        if ("MANAGER".equals(userRole)) {
            targetPage = "/oracle/apps/xx/jobmgmt/webui/JobApprovalPG";
        } else if ("EMPLOYEE".equals(userRole)) {
            targetPage = "/oracle/apps/xx/jobmgmt/webui/JobSearchPG";
        } else {
            targetPage = "/oracle/apps/xx/jobmgmt/webui/JobReadOnlyPG";
        }
        
        pageContext.forwardImmediately(
            "OA.jsp?page=" + targetPage,
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);
    }
    
    /**
     * Pass complex object between pages
     * Use Case: Transfer data using session storage
     */
    public void passComplexObject(OAPageContext pageContext, Object dataObject) {
        // Store in session
        pageContext.putSessionValue("JobData", dataObject);
        
        // Navigate to next page
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobReviewPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);
    }
    
    /**
     * Retrieve object from session on target page
     * Use Case: Get data stored by previous page
     */
    public Object retrieveComplexObject(OAPageContext pageContext) {
        // Get from session
        Object dataObject = pageContext.getSessionValue("JobData");
        
        // Clean up session after retrieval
        if (dataObject != null) {
            pageContext.removeSessionValue("JobData");
        }
        
        return dataObject;
    }
    
    /**
     * Navigate with custom breadcrumb label
     * Use Case: Override default breadcrumb text
     */
    public void navigateWithCustomBreadcrumb(OAPageContext pageContext, 
                                            String jobName) {
        // Set custom breadcrumb text
        pageContext.putBreadCrumbTitle("Job: " + jobName);
        
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES);
    }
}
