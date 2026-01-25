package oracle.apps.xx.hrms.model.server;

import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.TransactionEvent;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.xx.common.utils.MessageHelper;
import oracle.apps.xx.common.constants.MessageConstants;

/**
 * Expert Entity Object Implementation for Job Management
 * Demonstrates all lifecycle methods and advanced patterns
 * @author Oracle ADF/OAF Expert
 * @version 1.4.0
 */
public class JobEOExpertImpl extends OAEntityImpl {
    
    // Attribute indices
    public static final int JOBID = 0;
    public static final int JOBNAME = 1;
    public static final int JOBTYPE = 2;
    public static final int DEPARTMENTID = 3;
    public static final int STARTDATE = 4;
    public static final int ENDDATE = 5;
    public static final int ACTIVEFLAG = 6;
    public static final int CREATEDBY = 7;
    public static final int CREATIONDATE = 8;
    public static final int LASTUPDATEDBY = 9;
    public static final int LASTUPDATEDATE = 10;
    public static final int LASTUPDATELOGIN = 11;
    public static final int POSITIONS = 12; // Association
    
    /**
     * create() - Called when new row is created
     * Purpose: Initialize defaults, set WHO columns, generate PK
     */
    @Override
    protected void create(AttributeList al) {
        super.create(al);
        
        OADBTransaction txn = getOADBTransaction();
        
        // Generate primary key using sequence
        Number newId = txn.getSequenceValue("XX_JOBS_S");
        setJobId(newId);
        
        // Set WHO columns for INSERT
        Number userId = txn.getUserId();
        Date now = txn.getCurrentDBDate();
        
        setCreatedBy(userId);
        setCreationDate(now);
        setLastUpdatedBy(userId);
        setLastUpdateDate(now);
        setLastUpdateLogin(txn.getSessionId());
        
        // Set business defaults
        setActiveFlag("Y");
        setStartDate(now);
    }
    
    /**
     * doDML() - Called before INSERT/UPDATE/DELETE
     * Purpose: Update WHO columns, perform pre-DML validations
     */
    @Override
    protected void doDML(int operation, TransactionEvent e) {
        
        // Update WHO columns for UPDATE operations
        if (operation == DML_UPDATE) {
            OADBTransaction txn = getOADBTransaction();
            setLastUpdatedBy(txn.getUserId());
            setLastUpdateDate(txn.getCurrentDBDate());
            setLastUpdateLogin(txn.getSessionId());
        }
        
        // Call super to perform actual DML
        super.doDML(operation, e);
        
        // Post-DML logic if needed
        if (operation == DML_INSERT) {
            // Log audit trail or trigger workflow
            logAuditEvent("INSERT", getJobId());
        }
    }
    
    /**
     * validateEntity() - Cross-field business validations
     * Called automatically before commit
     */
    @Override
    protected void validateEntity() {
        super.validateEntity();
        
        // Validate required fields
        if (getJobName() == null || getJobName().trim().isEmpty()) {
            throw MessageHelper.createFieldRequiredError("Job Name");
        }
        
        if (getStartDate() == null) {
            throw MessageHelper.createFieldRequiredError("Start Date");
        }
        
        // Validate end date after start date
        Date startDate = getStartDate();
        Date endDate = getEndDate();
        if (endDate != null && endDate.compareTo(startDate) < 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_END_DATE_BEFORE_START,
                new String[]{"Job"}
            );
        }
        
        // Check duplicate job name
        if (isDuplicateJobName()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_DUPLICATE_JOB_NAME,
                new String[]{getJobName()}
            );
        }
        
        // Validate active positions if end date is set
        if (endDate != null) {
            validateActivePositions(endDate);
        }
    }
    
    /**
     * beforeRemove() - Pre-delete validation
     * Purpose: Prevent deletion if business rules violated
     */
    @Override
    protected void beforeRemove() {
        
        // Check for child positions
        RowSet positions = (RowSet)getPositions();
        if (positions != null) {
            int positionCount = positions.getEstimatedRowCount();
            if (positionCount > 0) {
                throw MessageHelper.createDeleteRestrictedError(
                    "Job",
                    positionCount + " active position(s) exist"
                );
            }
        }
        
        super.beforeRemove();
    }
    
    /**
     * lock() - Custom locking strategy
     * Purpose: Implement optimistic or pessimistic locking
     */
    @Override
    public void lock() {
        super.lock();
        
        // Check if record was modified by another user
        Date currentLastUpdateDate = getLastUpdateDate();
        Date postedLastUpdateDate = (Date)getPostedAttribute(LASTUPDATEDATE);
        
        if (postedLastUpdateDate != null && 
            currentLastUpdateDate.compareTo(postedLastUpdateDate) != 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_RECORD_MODIFIED_BY_ANOTHER_USER,
                new String[]{getJobName()}
            );
        }
    }
    
    // ============ Private Helper Methods ============
    
    /**
     * Check for duplicate job name
     */
    private boolean isDuplicateJobName() {
        String sql = "SELECT COUNT(*) FROM XX_JOBS " +
                    "WHERE UPPER(JOB_NAME) = :1 AND JOB_ID <> :2";
        
        OADBTransaction txn = getOADBTransaction();
        Object[] params = new Object[]{
            getJobName().toUpperCase(),
            getJobId()
        };
        
        Number count = (Number)txn.getFirstValueFromQuery(sql, params);
        return (count != null && count.intValue() > 0);
    }
    
    /**
     * Validate that no positions extend beyond job end date
     */
    private void validateActivePositions(Date jobEndDate) {
        RowSet positions = (RowSet)getPositions();
        if (positions == null) return;
        
        positions.reset();
        while (positions.hasNext()) {
            PositionEOImpl position = (PositionEOImpl)positions.next();
            Date posEndDate = position.getEndDate();
            
            if (posEndDate == null || posEndDate.compareTo(jobEndDate) > 0) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_POSITION_EXTENDS_BEYOND_JOB,
                    new String[]{position.getPositionName(), getJobName()}
                );
            }
        }
    }
    
    /**
     * Audit event logging
     */
    private void logAuditEvent(String operation, Number jobId) {
        // Implementation for audit trail
        // Could write to audit table or log file
    }
    
    /**
     * Check if job name was changed
     */
    public boolean isJobNameChanged() {
        String currentName = getJobName();
        String postedName = (String)getPostedAttribute(JOBNAME);
        
        if (currentName == null && postedName == null) return false;
        if (currentName == null || postedName == null) return true;
        
        return !currentName.equals(postedName);
    }
    
    /**
     * Cascade delete to all child positions
     */
    public void cascadeDeletePositions() {
        RowSet positions = (RowSet)getPositions();
        if (positions == null) return;
        
        positions.reset();
        while (positions.hasNext()) {
            PositionEOImpl position = (PositionEOImpl)positions.next();
            position.remove(); // Cascade delete
        }
    }
    
    /**
     * Cascade update end date to all positions
     */
    public void cascadeEndDateToPositions(Date newEndDate) {
        RowSet positions = (RowSet)getPositions();
        if (positions == null) return;
        
        positions.reset();
        while (positions.hasNext()) {
            PositionEOImpl position = (PositionEOImpl)positions.next();
            Date posEndDate = position.getEndDate();
            
            // Update position end date if it's beyond new job end date
            if (posEndDate == null || posEndDate.compareTo(newEndDate) > 0) {
                position.setEndDate(newEndDate);
            }
        }
    }
    
    // ============ Generated Getters/Setters ============
    
    public Number getJobId() {
        return (Number)getAttributeInternal(JOBID);
    }
    public void setJobId(Number value) {
        setAttributeInternal(JOBID, value);
    }
    
    public String getJobName() {
        return (String)getAttributeInternal(JOBNAME);
    }
    public void setJobName(String value) {
        setAttributeInternal(JOBNAME, value);
    }
    
    public String getJobType() {
        return (String)getAttributeInternal(JOBTYPE);
    }
    public void setJobType(String value) {
        setAttributeInternal(JOBTYPE, value);
    }
    
    public Number getDepartmentId() {
        return (Number)getAttributeInternal(DEPARTMENTID);
    }
    public void setDepartmentId(Number value) {
        setAttributeInternal(DEPARTMENTID, value);
    }
    
    public Date getStartDate() {
        return (Date)getAttributeInternal(STARTDATE);
    }
    public void setStartDate(Date value) {
        setAttributeInternal(STARTDATE, value);
    }
    
    public Date getEndDate() {
        return (Date)getAttributeInternal(ENDDATE);
    }
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
    }
    
    public String getActiveFlag() {
        return (String)getAttributeInternal(ACTIVEFLAG);
    }
    public void setActiveFlag(String value) {
        setAttributeInternal(ACTIVEFLAG, value);
    }
    
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }
    
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }
    
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }
    
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }
    
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }
    
    /**
     * Association accessor for child positions
     */
    public RowIterator getPositions() {
        return (RowIterator)getAttributeInternal(POSITIONS);
    }
}
