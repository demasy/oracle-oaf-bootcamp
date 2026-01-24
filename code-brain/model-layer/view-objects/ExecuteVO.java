/*===========================================================================+
 | Oracle Applications Framework (OAF) - View Object Execution Example
 | 
 | USE CASE: Execute a View Object with dynamic where clause and parameters
 | LOCATION: Application Module or Controller
 | COMPLEXITY: Basic
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.server;

import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;

public class ExecuteVOExample {
    
    /**
     * Execute a View Object without parameters
     * Use Case: Simple query execution without filtering
     */
    public void executeVOBasic(OAApplicationModuleImpl am) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            // Execute the query
            vo.executeQuery();
            
            // Optional: Get row count
            int rowCount = vo.getRowCount();
            System.out.println("Rows fetched: " + rowCount);
        }
    }
    
    /**
     * Execute a View Object with where clause
     * Use Case: Filter data based on specific criteria
     */
    public void executeVOWithWhereClause(OAApplicationModuleImpl am, String jobName) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            // Set where clause
            String whereClause = "JOB_NAME LIKE :1";
            Object[] params = {jobName + "%"};
            
            // Apply where clause and parameters
            vo.setWhereClause(whereClause);
            vo.setWhereClauseParams(params);
            
            // Execute the query
            vo.executeQuery();
        }
    }
    
    /**
     * Execute a View Object with multiple parameters
     * Use Case: Complex filtering with multiple conditions
     */
    public void executeVOWithMultipleParams(OAApplicationModuleImpl am, 
                                           String jobName, 
                                           String startDate) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            // Set where clause with multiple bind variables
            String whereClause = "JOB_NAME LIKE :1 AND EFFECTIVE_START_DATE >= :2";
            Object[] params = {jobName + "%", startDate};
            
            vo.setWhereClause(whereClause);
            vo.setWhereClauseParams(params);
            vo.executeQuery();
        }
    }
    
    /**
     * Execute a View Object and reset filters
     * Use Case: Clear previous filters and execute fresh query
     */
    public void executeVOReset(OAApplicationModuleImpl am) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            // Clear previous where clause
            vo.setWhereClause(null);
            vo.setWhereClauseParams(null);
            
            // Reset and execute
            vo.reset();
            vo.executeQuery();
        }
    }
    
    /**
     * Execute a View Object with ORDER BY clause
     * Use Case: Sort results in specific order
     */
    public void executeVOWithOrderBy(OAApplicationModuleImpl am) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            // Set order by clause
            vo.setOrderByClause("JOB_NAME ASC, EFFECTIVE_START_DATE DESC");
            vo.executeQuery();
        }
    }
    
    /**
     * Execute a View Object and iterate through rows
     * Use Case: Process each row after query execution
     */
    public void executeVOAndIterate(OAApplicationModuleImpl am) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            vo.executeQuery();
            
            // Get the first row
            oracle.jbo.Row row = vo.first();
            
            while (row != null) {
                // Process row
                String jobName = (String)row.getAttribute("JobName");
                Number jobId = (Number)row.getAttribute("JobId");
                
                System.out.println("Job: " + jobName + " (ID: " + jobId + ")");
                
                // Move to next row
                row = vo.next();
            }
        }
    }
    
    /**
     * Execute a View Object with dynamic query
     * Use Case: Build query dynamically at runtime
     */
    public void executeVODynamic(OAApplicationModuleImpl am, 
                                String searchType, 
                                String searchValue) {
        OAViewObjectImpl vo = (OAViewObjectImpl)am.findViewObject("JobVO1");
        
        if (vo != null) {
            String whereClause = null;
            Object[] params = null;
            
            if ("NAME".equals(searchType)) {
                whereClause = "UPPER(JOB_NAME) LIKE UPPER(:1)";
                params = new Object[]{"%" + searchValue + "%"};
            } else if ("ID".equals(searchType)) {
                whereClause = "JOB_ID = :1";
                params = new Object[]{searchValue};
            }
            
            if (whereClause != null) {
                vo.setWhereClause(whereClause);
                vo.setWhereClauseParams(params);
            }
            
            vo.executeQuery();
        }
    }
}
