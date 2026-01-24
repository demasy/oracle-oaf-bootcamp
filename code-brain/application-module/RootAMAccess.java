/*===========================================================================+
 | Oracle Applications Framework (OAF) - Root Application Module Access
 | 
 | USE CASE: Access Root AM from Controller to invoke business logic
 | LOCATION: Controller
 | COMPLEXITY: Basic
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.webui;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;

public class RootAMAccess {
    
    /**
     * Get Root Application Module - Basic Method
     * Use Case: Access root AM to invoke methods
     */
    public void getRootAMBasic(OAPageContext pageContext) {
        // Get root application module
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        // Null check is critical
        if (rootAM != null) {
            // Now you can invoke AM methods
            System.out.println("Root AM Name: " + rootAM.getApplicationModuleDefName());
        }
    }
    
    /**
     * Invoke AM method using invokeMethod()
     * Use Case: Call custom method in Application Module (BEST PRACTICE)
     */
    public void invokeAMMethod(OAPageContext pageContext, String jobName) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            // Method signature in AM: public void createJob(String jobName)
            // Using invokeMethod is safer than casting
            rootAM.invokeMethod("createJob", new Object[]{jobName});
        }
    }
    
    /**
     * Invoke AM method with return value
     * Use Case: Get data from AM method
     */
    public String invokeAMMethodWithReturn(OAPageContext pageContext, Number jobId) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        String jobName = null;
        
        if (rootAM != null) {
            // Method signature in AM: public String getJobName(Number jobId)
            Object result = rootAM.invokeMethod("getJobName", new Object[]{jobId});
            
            if (result != null) {
                jobName = (String)result;
            }
        }
        
        return jobName;
    }
    
    /**
     * Invoke AM method with multiple parameters
     * Use Case: Complex business logic invocation
     */
    public void invokeAMMethodMultipleParams(OAPageContext pageContext, 
                                            String jobName, 
                                            Number headCount, 
                                            String startDate) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            // Method signature in AM: 
            // public void createJobWithDetails(String name, Number count, String date)
            rootAM.invokeMethod("createJobWithDetails", 
                              new Object[]{jobName, headCount, startDate});
        }
    }
    
    /**
     * Access nested Application Module
     * Use Case: Access child AM from root AM
     */
    public void accessNestedAM(OAPageContext pageContext) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            // Get nested AM instance
            // Assuming PositionAM is nested under root AM with instance name "PositionAM1"
            OAApplicationModule nestedAM = 
                (OAApplicationModule)rootAM.findApplicationModule("PositionAM1");
            
            if (nestedAM != null) {
                nestedAM.invokeMethod("refreshPositions");
            }
        }
    }
    
    /**
     * Get Application Module with error handling
     * Use Case: Safe AM access with exception handling
     */
    public void getRootAMWithErrorHandling(OAPageContext pageContext) {
        try {
            OAApplicationModule rootAM = pageContext.getRootApplicationModule();
            
            if (rootAM == null) {
                throw new OAException("Application Module not found", 
                                    OAException.ERROR);
            }
            
            // Invoke AM method
            rootAM.invokeMethod("processJobs");
            
            // Success message
            OAException msg = new OAException("Jobs processed successfully", 
                                             OAException.CONFIRMATION);
            pageContext.putDialogMessage(msg);
            
        } catch (Exception e) {
            OAException error = new OAException("Error processing jobs: " + 
                                               e.getMessage(), 
                                               OAException.ERROR);
            throw error;
        }
    }
    
    /**
     * Commit transaction using Root AM
     * Use Case: Save changes to database
     */
    public void commitTransaction(OAPageContext pageContext) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            try {
                // Commit the transaction
                rootAM.invokeMethod("commit");
                
                // Success message
                OAException msg = new OAException("Changes saved successfully", 
                                                 OAException.CONFIRMATION);
                pageContext.putDialogMessage(msg);
                
            } catch (Exception e) {
                // Rollback on error
                rootAM.invokeMethod("rollback");
                
                throw new OAException("Error saving changes: " + e.getMessage(), 
                                    OAException.ERROR);
            }
        }
    }
    
    /**
     * Rollback transaction using Root AM
     * Use Case: Cancel changes
     */
    public void rollbackTransaction(OAPageContext pageContext) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            // Rollback the transaction
            rootAM.invokeMethod("rollback");
            
            // Confirmation message
            OAException msg = new OAException("Changes cancelled", 
                                             OAException.CONFIRMATION);
            pageContext.putDialogMessage(msg);
        }
    }
    
    /**
     * Check if AM method exists before invoking
     * Use Case: Safe method invocation
     */
    public void safeInvokeAMMethod(OAPageContext pageContext) {
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            try {
                // Invoke method - will throw exception if method doesn't exist
                rootAM.invokeMethod("customBusinessLogic");
                
            } catch (oracle.jbo.JboException jbe) {
                // Method not found or execution error
                OAException error = new OAException("Business logic error: " + 
                                                   jbe.getMessage(), 
                                                   OAException.ERROR);
                throw error;
            }
        }
    }
    
    /**
     * Access AM in processRequest (page initialization)
     * Use Case: Initialize data when page loads
     */
    public void processRequestExample(OAPageContext pageContext, OAWebBean webBean) {
        // In Controller's processRequest method
        OAApplicationModule rootAM = pageContext.getRootApplicationModule();
        
        if (rootAM != null) {
            // Initialize data
            rootAM.invokeMethod("initializeJobList");
        }
    }
    
    /**
     * Access AM in processFormRequest (button click)
     * Use Case: Handle user action
     */
    public void processFormRequestExample(OAPageContext pageContext, OAWebBean webBean) {
        // In Controller's processFormRequest method
        if (pageContext.getParameter("CreateJob") != null) {
            OAApplicationModule rootAM = pageContext.getRootApplicationModule();
            
            if (rootAM != null) {
                // Get form values
                String jobName = pageContext.getParameter("JobName");
                
                // Invoke AM method
                rootAM.invokeMethod("createJob", new Object[]{jobName});
                
                // Redirect or show message
                OAException msg = new OAException("Job created successfully", 
                                                 OAException.CONFIRMATION);
                pageContext.putDialogMessage(msg);
            }
        }
    }
}
