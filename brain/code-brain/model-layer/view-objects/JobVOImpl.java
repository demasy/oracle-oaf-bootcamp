package oracle.apps.xx.hrms.model.server;

import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.xx.common.utils.MessageHelper;
import oracle.apps.xx.common.constants.MessageConstants;
import java.util.ArrayList;

/**
 * View Object Implementation for Job Management
 * Demonstrates createRow patterns and query methods
 * @author Oracle OAF Expert
 * @version 1.4.0
 */
public class JobVOImpl extends OAViewObjectImpl {
    
    /**
     * Creates a new row in the View Object
     * @return Row - newly created row
     */
    public Row createRow() {
        Row row = super.createRow();
        row.setNewRowState(Row.STATUS_INITIALIZED);
        return row;
    }
    
    /**
     * Creates a new row with default values
     * @return JobRowImpl - newly created row with defaults
     */
    public JobRowImpl createRowWithDefaults() {
        JobRowImpl row = (JobRowImpl)super.createRow();
        row.setNewRowState(Row.STATUS_INITIALIZED);
        
        // Set default values
        OADBTransaction txn = getOADBTransaction();
        row.setCreatedBy(txn.getUserId());
        row.setCreationDate(txn.getCurrentDBDate());
        row.setActiveFlag("Y");
        row.setEnabledFlag("Y");
        
        return row;
    }
    
    /**
     * Creates a new row with specified parameters
     * @param jobName - Job name
     * @param jobType - Job type code
     * @param departmentId - Department identifier
     * @return JobRowImpl - newly created row
     */
    public JobRowImpl createRow(String jobName, String jobType, Number departmentId) {
        JobRowImpl row = (JobRowImpl)super.createRow();
        row.setNewRowState(Row.STATUS_INITIALIZED);
        
        // Set parameters
        row.setJobName(jobName);
        row.setJobType(jobType);
        row.setDepartmentId(departmentId);
        
        // Set WHO columns
        OADBTransaction txn = getOADBTransaction();
        row.setCreatedBy(txn.getUserId());
        row.setCreationDate(txn.getCurrentDBDate());
        row.setLastUpdatedBy(txn.getUserId());
        row.setLastUpdateDate(txn.getCurrentDBDate());
        
        return row;
    }
    
    /**
     * Creates a new job row with validation
     * @param jobName - Job name (required)
     * @param startDate - Start date (required)
     * @param endDate - End date (optional)
     * @return JobRowImpl - validated new row
     */
    public JobRowImpl createRowWithValidation(String jobName, Date startDate, Date endDate) {
        // Validate required parameters
        if (jobName == null || jobName.trim().isEmpty()) {
            throw MessageHelper.createFieldRequiredError("Job Name");
        }
        if (startDate == null) {
            throw MessageHelper.createFieldRequiredError("Start Date");
        }
        
        // Validate end date after start date
        if (endDate != null && endDate.compareTo(startDate) < 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_END_DATE_BEFORE_START,
                new String[]{"Job"}
            );
        }
        
        // Create row
        JobRowImpl row = (JobRowImpl)super.createRow();
        row.setNewRowState(Row.STATUS_INITIALIZED);
        
        row.setJobName(jobName);
        row.setStartDate(startDate);
        row.setEndDate(endDate);
        
        // Set WHO columns and defaults
        OADBTransaction txn = getOADBTransaction();
        row.setCreatedBy(txn.getUserId());
        row.setCreationDate(txn.getCurrentDBDate());
        row.setActiveFlag("Y");
        
        return row;
    }
    
    /**
     * Creates and inserts a new job row
     * @param jobName - Job name
     * @param jobType - Job type
     */
    public void createNewJob(String jobName, String jobType) {
        // Create row with parameters
        JobRowImpl newRow = createRow(jobName, jobType, null);
        
        // Insert row into RowSet
        insertRow(newRow);
        
        // Set current row
        setCurrentRow(newRow);
        
        // Execute query to refresh
        executeQuery();
    }
    
    /**
     * Find jobs by department and status
     * @param departmentId - Department identifier
     * @param activeFlag - Active status (Y/N)
     */
    public void findJobsByDepartment(Number departmentId, String activeFlag) {
        if (departmentId == null) {
            throw MessageHelper.createFieldRequiredError("Department");
        }
        
        // Set WHERE clause with bind variables
        String whereClause = "DEPARTMENT_ID = :1 AND ACTIVE_FLAG = :2";
        Object[] params = new Object[]{departmentId, activeFlag};
        
        setWhereClause(whereClause);
        setWhereClauseParams(params);
        
        // Set ORDER BY
        setOrderByClause("JOB_NAME ASC");
        
        // Execute query
        executeQuery();
    }
    
    /**
     * Search jobs with dynamic criteria
     * @param jobName - Job name (optional, wildcard search)
     * @param jobType - Job type (optional)
     * @param departmentId - Department ID (optional)
     * @param startDateFrom - Start date range from (optional)
     * @param startDateTo - Start date range to (optional)
     */
    public void searchJobs(String jobName, String jobType, Number departmentId,
                           Date startDateFrom, Date startDateTo) {
        StringBuilder whereClause = new StringBuilder();
        ArrayList paramList = new ArrayList();
        int paramIndex = 1;
        
        // Job name with wildcard
        if (jobName != null && !jobName.trim().isEmpty()) {
            whereClause.append("UPPER(JOB_NAME) LIKE :1");
            paramList.add("%" + jobName.toUpperCase() + "%");
            paramIndex++;
        }
        
        // Job type
        if (jobType != null && !jobType.trim().isEmpty()) {
            if (whereClause.length() > 0) whereClause.append(" AND ");
            whereClause.append("JOB_TYPE = :").append(paramIndex);
            paramList.add(jobType);
            paramIndex++;
        }
        
        // Department
        if (departmentId != null) {
            if (whereClause.length() > 0) whereClause.append(" AND ");
            whereClause.append("DEPARTMENT_ID = :").append(paramIndex);
            paramList.add(departmentId);
            paramIndex++;
        }
        
        // Date range
        if (startDateFrom != null) {
            if (whereClause.length() > 0) whereClause.append(" AND ");
            whereClause.append("START_DATE >= :").append(paramIndex);
            paramList.add(startDateFrom);
            paramIndex++;
        }
        if (startDateTo != null) {
            if (whereClause.length() > 0) whereClause.append(" AND ");
            whereClause.append("START_DATE <= :").append(paramIndex);
            paramList.add(startDateTo);
        }
        
        // Apply WHERE clause
        if (whereClause.length() > 0) {
            setWhereClause(whereClause.toString());
            setWhereClauseParams(paramList.toArray());
        } else {
            setWhereClause(null);
        }
        
        executeQuery();
    }
    
    /**
     * Initialize query with defaults
     */
    @Override
    protected void initQuery() {
        super.initQuery();
        
        // Set default ORDER BY
        setOrderByClause("JOB_NAME ASC");
        
        // Set default fetch size for performance
        setMaxFetchSize(100);
    }
}
