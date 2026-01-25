package oracle.apps.xx.hrms.controller;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.apps.xx.common.utils.MessageHelper;
import java.util.HashMap;

/**
 * Expert Controller for Job Management
 * Demonstrates complete lifecycle: processRequest, processFormRequest, processFormData
 * @author Oracle ADF/OAF Expert
 * @version 1.4.0
 */
public class JobMgmtCO extends OAControllerImpl {
    
    /**
     * processRequest() - Initialize page - Called when page first loads
     * Purpose: Load data, set UI properties, handle navigation parameters
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        
        // Check if edit mode
        String mode = pageContext.getParameter("mode");
        if ("edit".equals(mode)) {
            // Load record for editing
            String jobId = pageContext.getParameter("jobId");
            if (jobId != null) {
                am.invokeMethod("loadJobForEdit", 
                               new Object[]{new Number(jobId)});
            }
        } else if ("create".equals(mode)) {
            // Initialize new record
            am.invokeMethod("initializeNewJob");
        } else {
            // Search mode - execute query
            am.invokeMethod("executeJobSearch");
        }
        
        // Set UI properties based on user permissions
        boolean isManager = "Y".equals(pageContext.getProfile("XX_IS_MANAGER"));
        if (!isManager) {
            // Hide delete button for non-managers
            OAWebBean deleteBtn = webBean.findChildRecursive("DeleteBtn");
            if (deleteBtn != null) {
                deleteBtn.setAttributeValue(RENDERED_ATTR, Boolean.FALSE);
            }
        }
    }
    
    /**
     * processFormRequest() - Handle form submission and button clicks
     * Purpose: Validate input, call AM methods, navigate to other pages
     */
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        String event = pageContext.getParameter(EVENT_PARAM);
        
        // Save button
        if ("save".equals(event)) {
            handleSave(pageContext, am);
        }
        // Delete button
        else if ("delete".equals(event)) {
            handleDelete(pageContext, am);
        }
        // Search button
        else if ("search".equals(event)) {
            handleSearch(pageContext, am);
        }
        // Cancel button
        else if ("cancel".equals(event)) {
            handleCancel(pageContext, am);
        }
        // Update with PPR
        else if ("updatePPR".equals(event)) {
            handlePartialPageRefresh(pageContext, am);
        }
    }
    
    /**
     * Handle save operation
     */
    private void handleSave(OAPageContext pageContext, OAApplicationModule am) {
        // Get form parameters
        String jobName = pageContext.getParameter("JobName");
        String jobType = pageContext.getParameter("JobType");
        String deptId = pageContext.getParameter("DepartmentId");
        String startDate = pageContext.getParameter("StartDate");
        String endDate = pageContext.getParameter("EndDate");
        
        // Validate required fields
        if (jobName == null || jobName.trim().isEmpty()) {
            throw MessageHelper.createFieldRequiredError("Job Name");
        }
        
        // Call AM method
        am.invokeMethod("createJob", new Object[]{
            jobName,
            jobType,
            deptId == null ? null : new Number(deptId),
            startDate == null ? null : new Date(startDate),
            endDate == null ? null : new Date(endDate)
        });
        
        // Navigate back to search page
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/hrms/webui/JobSearchPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO
        );
    }
    
    /**
     * Handle delete with confirmation dialog
     */
    private void handleDelete(OAPageContext pageContext, OAApplicationModule am) {
        String jobId = pageContext.getParameter("JobId");
        
        if (jobId == null) {
            throw MessageHelper.createRecordNotFoundError("Job");
        }
        
        // Check if confirmation dialog shown
        String dialogParam = pageContext.getParameter("DeleteConfirm");
        
        if ("yes".equals(dialogParam)) {
            // User confirmed - perform delete
            am.invokeMethod("deleteJob", new Object[]{new Number(jobId)});
            
            // Navigate to search
            pageContext.forwardImmediately(
                "OA.jsp?page=/oracle/apps/xx/hrms/webui/JobSearchPG",
                null,
                OAWebBeanConstants.KEEP_MENU_CONTEXT,
                null,
                null,
                true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO
            );
        } else {
            // Show confirmation dialog
            MessageHelper.showConfirmationDialog(
                pageContext,
                "Are you sure you want to delete this job?",
                "DeleteConfirm"
            );
        }
    }
    
    /**
     * Handle search with dynamic criteria
     */
    private void handleSearch(OAPageContext pageContext, OAApplicationModule am) {
        String jobName = pageContext.getParameter("SearchJobName");
        String jobType = pageContext.getParameter("SearchJobType");
        String deptId = pageContext.getParameter("SearchDeptId");
        
        am.invokeMethod("searchJobs", new Object[]{
            jobName,
            jobType,
            deptId == null ? null : new Number(deptId),
            null
        });
    }
    
    /**
     * Handle cancel - rollback and navigate
     */
    private void handleCancel(OAPageContext pageContext, OAApplicationModule am) {
        am.invokeMethod("rollbackChanges");
        
        pageContext.forwardImmediately(
            "OA.jsp?page=/oracle/apps/xx/hrms/webui/JobSearchPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO
        );
    }
    
    /**
     * Handle PPR - update dependent fields
     */
    private void handlePartialPageRefresh(OAPageContext pageContext,
                                         OAApplicationModule am) {
        String deptId = pageContext.getParameter("DepartmentId");
        
        // Update dependent LOV based on department
        am.invokeMethod("updateJobTypeLOV", new Object[]{new Number(deptId)});
        
        // No navigation - PPR will refresh the region
    }
}
