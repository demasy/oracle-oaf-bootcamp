package oracle.apps.xx.hrms.model.server;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.apps.xx.common.utils.MessageHelper;
import oracle.apps.xx.common.constants.MessageConstants;

/**
 * Expert Application Module for Job Management
 * Demonstrates complete transaction management and business logic
 * @author Oracle ADF/OAF Expert
 * @version 1.4.0
 */
public class JobMgmtAMImpl extends OAApplicationModuleImpl {
    
    /**
     * Initialize AM and perform startup tasks
     */
    @Override
    protected void prepareForExecution(OADBTransaction txn) {
        super.prepareForExecution(txn);
        // Initialize default settings
        initializeDefaults();
    }
    
    // ============ VO Accessor Methods ============
    
    /**
     * Get Job View Object instance
     */
    public JobVOImpl getJobVO() {
        return (JobVOImpl)findViewObject("JobVO1");
    }
    
    /**
     * Get Position View Object instance
     */
    public PositionVOImpl getPositionVO() {
        return (PositionVOImpl)findViewObject("PositionVO1");
    }
    
    // ============ Business Methods - CREATE ============
    
    /**
     * Create new job with validation
     */
    public void createJob(String jobName, String jobType, Number departmentId,
                         Date startDate, Date endDate) {
        // Validate input
        if (jobName == null || jobName.trim().isEmpty()) {
            throw MessageHelper.createFieldRequiredError("Job Name");
        }
        
        // Get VO and create row
        JobVOImpl vo = getJobVO();
        JobRowImpl newRow = (JobRowImpl)vo.createRow();
        
        // Set attributes
        newRow.setJobName(jobName);
        newRow.setJobType(jobType);
        newRow.setDepartmentId(departmentId);
        newRow.setStartDate(startDate);
        newRow.setEndDate(endDate);
        
        // Insert and commit
        vo.insertRow(newRow);
        getOADBTransaction().commit();
        
        // Show success message
        throw MessageHelper.createSaveSuccessMessage();
    }
    
    /**
     * Create position under job with master-detail validation
     */
    public void createPosition(Number jobId, String positionName,
                              Date startDate, Date endDate) {
        // Find parent job
        JobVOImpl jobVO = getJobVO();
        JobRowImpl job = findJobById(jobId);
        if (job == null) {
            throw MessageHelper.createRecordNotFoundError("Job");
        }
        
        // Validate dates against parent job
        Date jobStartDate = job.getStartDate();
        Date jobEndDate = job.getEndDate();
        
        if (startDate.compareTo(jobStartDate) < 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_POSITION_START_BEFORE_JOB,
                new String[]{positionName, job.getJobName()}
            );
        }
        
        // Create position
        PositionVOImpl posVO = getPositionVO();
        PositionRowImpl newPos = (PositionRowImpl)posVO.createRow();
        newPos.setJobId(jobId);
        newPos.setPositionName(positionName);
        newPos.setStartDate(startDate);
        newPos.setEndDate(endDate);
        
        posVO.insertRow(newPos);
        getOADBTransaction().commit();
    }
    
    // ============ Business Methods - UPDATE ============
    
    /**
     * Update job with validation
     */
    public void updateJob(Number jobId, String jobName, String jobType,
                         Date startDate, Date endDate) {
        JobRowImpl job = findJobById(jobId);
        if (job == null) {
            throw MessageHelper.createRecordNotFoundError("Job");
        }
        
        // Update attributes
        job.setJobName(jobName);
        job.setJobType(jobType);
        job.setStartDate(startDate);
        job.setEndDate(endDate);
        
        // Commit
        getOADBTransaction().commit();
        throw MessageHelper.createUpdateSuccessMessage();
    }
    
    // ============ Business Methods - DELETE ============
    
    /**
     * Delete job with cascade check
     */
    public void deleteJob(Number jobId) {
        JobRowImpl job = findJobById(jobId);
        if (job == null) {
            throw MessageHelper.createRecordNotFoundError("Job");
        }
        
        // Check for child positions
        if (hasActivePositions(jobId)) {
            throw MessageHelper.createDeleteRestrictedError(
                "Job",
                "Active positions exist"
            );
        }
        
        // Delete
        job.remove();
        getOADBTransaction().commit();
        
        throw MessageHelper.createDeleteSuccessMessage();
    }
    
    // ============ Query/Search Methods ============
    
    /**
     * Search jobs with multiple criteria
     */
    public void searchJobs(String jobName, String jobType, Number deptId,
                          String activeFlag) {
        JobVOImpl vo = getJobVO();
        vo.searchJobs(jobName, jobType, deptId, null, null);
    }
    
    /**
     * Find positions by job
     */
    public void findPositionsByJob(Number jobId) {
        PositionVOImpl vo = getPositionVO();
        vo.setWhereClause("JOB_ID = :1");
        vo.setWhereClauseParams(new Object[]{jobId});
        vo.executeQuery();
    }
    
    // ============ Helper Methods ============
    
    /**
     * Find job by ID
     */
    private JobRowImpl findJobById(Number jobId) {
        JobVOImpl vo = getJobVO();
        vo.setWhereClause("JOB_ID = :1");
        vo.setWhereClauseParams(new Object[]{jobId});
        vo.executeQuery();
        
        if (vo.hasNext()) {
            return (JobRowImpl)vo.first();
        }
        return null;
    }
    
    /**
     * Check if job has active positions
     */
    private boolean hasActivePositions(Number jobId) {
        String sql = "SELECT COUNT(*) FROM XX_POSITIONS " +
                    "WHERE JOB_ID = :1 AND ACTIVE_FLAG = 'Y'";
        
        Number count = (Number)getOADBTransaction()
            .getFirstValueFromQuery(sql, new Object[]{jobId});
        
        return (count != null && count.intValue() > 0);
    }
    
    /**
     * Initialize default settings
     */
    private void initializeDefaults() {
        // Set default query settings
        JobVOImpl jobVO = getJobVO();
        if (jobVO != null) {
            jobVO.setMaxFetchSize(100);
        }
    }
    
    /**
     * Batch update salaries with commit batching
     */
    public void batchUpdateSalaries(Number departmentId, Number increasePercent) {
        EmployeeVOImpl vo = getEmployeeVO();
        vo.setWhereClause("DEPARTMENT_ID = :1");
        vo.setWhereClauseParams(new Object[]{departmentId});
        vo.executeQuery();
        
        int batchSize = 100;
        int count = 0;
        
        RowSetIterator iter = vo.createRowSetIterator("BatchIter");
        while (iter.hasNext()) {
            EmployeeRowImpl emp = (EmployeeRowImpl)iter.next();
            
            // Calculate new salary
            Number currentSalary = emp.getSalary();
            double newSalary = currentSalary.doubleValue() * 
                              (1 + increasePercent.doubleValue() / 100);
            emp.setSalary(new Number(newSalary));
            
            count++;
            
            // Commit in batches
            if (count % batchSize == 0) {
                getOADBTransaction().commit();
            }
        }
        
        // Final commit
        getOADBTransaction().commit();
        iter.closeRowSetIterator();
    }
    
    // ============ Transaction Management ============
    
    /**
     * Commit with validation
     */
    public void commitChanges() {
        try {
            getOADBTransaction().commit();
        } catch (Exception e) {
            getOADBTransaction().rollback();
            throw new OAException("Commit failed: " + e.getMessage());
        }
    }
    
    /**
     * Rollback changes
     */
    public void rollbackChanges() {
        getOADBTransaction().rollback();
    }
    
    /**
     * Get root Application Module
     */
    public OAApplicationModuleImpl getRootAM() {
        return (OAApplicationModuleImpl)getRootApplicationModule();
    }
}
