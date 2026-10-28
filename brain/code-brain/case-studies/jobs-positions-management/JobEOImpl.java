package oracle.apps.xx.jobmgmt.schema.server;

import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

/**
 * Job Entity Object Implementation
 * 
 * Represents a Job in the organization hierarchy. This is the master entity in a 
 * master-detail relationship with Positions.
 * 
 * Table: XX_JOBS
 * 
 * Business Rules:
 * - Job Name is mandatory and must be unique
 * - Head Count must be positive integer
 * - Effective Start Date is mandatory
 * - Effective End Date must be after Start Date (if provided)
 * - Cannot delete job if active positions exist
 * 
 * Associations:
 * - One Job to Many Positions (JobPositionAssoc)
 * 
 * Case Study: Jobs & Positions Management System
 * Layer: Model - Entity Object
 * Complexity: Advanced
 * Version: 1.4.0
 * 
 * Based on: demasylabs-barin/brain-repo/docs - OAF Project DDL Script
 * 
 * @author OAF Code Brain - Case Studies
 * @version 1.4.0
 */
public class JobEOImpl extends OAEntityImpl {
    
    // Attribute indices
    public static final int JOBID = 0;
    public static final int JOBNAME = 1;
    public static final int JOBHEADCOUNT = 2;
    public static final int EFFECTIVESTARTDATE = 3;
    public static final int EFFECTIVEENDDATE = 4;
    public static final int LASTUPDATEDATE = 5;
    public static final int LASTUPDATEDBY = 6;
    public static final int LASTUPDATELOGIN = 7;
    public static final int CREATEDBY = 8;
    public static final int CREATIONDATE = 9;
    
    // Association accessor constant
    public static final int POSITIONEO = 10;
    
    /**
     * Get Job ID (Primary Key)
     */
    public Number getJobId() {
        return (Number) getAttributeInternal(JOBID);
    }
    
    /**
     * Set Job ID (Primary Key)
     */
    public void setJobId(Number value) {
        setAttributeInternal(JOBID, value);
    }
    
    /**
     * Get Job Name
     */
    public String getJobName() {
        return (String) getAttributeInternal(JOBNAME);
    }
    
    /**
     * Set Job Name with validation
     * 
     * Business Rules:
     * - Mandatory field
     * - Max length 200 characters
     * - Must be unique across all jobs
     * - Cannot contain special characters
     */
    public void setJobName(String value) {
        // Mandatory validation
        if (value == null || value.trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Job Name"
            );
        }
        
        // Length validation
        if (value.length() > 200) {
            String[] tokens = {"Job Name", "200"};
            throw MessageHelper.createError(
                MessageConstants.ERR_TOO_LONG,
                tokens
            );
        }
        
        // Check for duplicate job name
        if (isDuplicateJobName(value)) {
            throw MessageHelper.createError(
                MessageConstants.ERR_JOB_DUPLICATE,
                value
            );
        }
        
        setAttributeInternal(JOBNAME, value.trim());
    }
    
    /**
     * Get Job Head Count
     */
    public Number getJobHeadCount() {
        return (Number) getAttributeInternal(JOBHEADCOUNT);
    }
    
    /**
     * Set Job Head Count with validation
     * 
     * Business Rules:
     * - Must be positive integer
     * - Range: 1 to 9999
     * - Cannot be less than existing position count
     */
    public void setJobHeadCount(Number value) {
        if (value != null) {
            // Positive number validation
            if (value.intValue() <= 0) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_JOB_HEADCOUNT_INVALID
                );
            }
            
            // Range validation
            if (value.intValue() < 1 || value.intValue() > 9999) {
                String[] tokens = {"1", "9999"};
                throw MessageHelper.createError(
                    MessageConstants.ERR_JOB_HEADCOUNT_OUT_OF_RANGE,
                    tokens
                );
            }
            
            // Validate against existing positions
            if (!isNewEntity()) {
                int positionCount = getActivePositionCount();
                if (value.intValue() < positionCount) {
                    String[] tokens = {
                        String.valueOf(positionCount),
                        value.toString()
                    };
                    throw MessageHelper.createError(
                        MessageConstants.APP_XX,
                        "XX_JOB_HEADCOUNT_LT_POSITIONS",
                        tokens
                    );
                }
            }
        }
        
        setAttributeInternal(JOBHEADCOUNT, value);
    }
    
    /**
     * Get Effective Start Date
     */
    public Date getEffectiveStartDate() {
        return (Date) getAttributeInternal(EFFECTIVESTARTDATE);
    }
    
    /**
     * Set Effective Start Date with validation
     */
    public void setEffectiveStartDate(Date value) {
        if (value == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Effective Start Date"
            );
        }
        
        // Validate against end date if exists
        Date endDate = getEffectiveEndDate();
        if (endDate != null && value.compareTo(endDate) > 0) {
            throw MessageHelper.createValidationError(
                MessageConstants.APP_XXVAL,
                "XXVAL_E_START_AFTER_END"
            );
        }
        
        setAttributeInternal(EFFECTIVESTARTDATE, value);
    }
    
    /**
     * Get Effective End Date
     */
    public Date getEffectiveEndDate() {
        return (Date) getAttributeInternal(EFFECTIVEENDDATE);
    }
    
    /**
     * Set Effective End Date with validation
     */
    public void setEffectiveEndDate(Date value) {
        if (value != null) {
            Date startDate = getEffectiveStartDate();
            if (startDate != null && value.compareTo(startDate) < 0) {
                throw MessageHelper.createValidationError(
                    MessageConstants.APP_XXVAL,
                    "XXVAL_E_INVALID_DATE_RANGE"
                );
            }
        }
        
        setAttributeInternal(EFFECTIVEENDDATE, value);
    }
    
    /**
     * Get associated Positions (1:N relationship)
     */
    public RowIterator getPositionEO() {
        return (RowIterator) getAttributeInternal(POSITIONEO);
    }
    
    // WHO Columns
    public Date getLastUpdateDate() {
        return (Date) getAttributeInternal(LASTUPDATEDATE);
    }
    
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }
    
    public Number getLastUpdatedBy() {
        return (Number) getAttributeInternal(LASTUPDATEDBY);
    }
    
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }
    
    public Number getLastUpdateLogin() {
        return (Number) getAttributeInternal(LASTUPDATELOGIN);
    }
    
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }
    
    public Number getCreatedBy() {
        return (Number) getAttributeInternal(CREATEDBY);
    }
    
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }
    
    public Date getCreationDate() {
        return (Date) getAttributeInternal(CREATIONDATE);
    }
    
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }
    
    /**
     * Framework method - Called before entity is created
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
        // Set default values
        OADBTransaction txn = getOADBTransaction();
        Number userId = txn.getUserId();
        Date currentDate = txn.getCurrentDBDate();
        
        setCreatedBy(userId);
        setCreationDate(currentDate);
        setLastUpdatedBy(userId);
        setLastUpdateDate(currentDate);
        setLastUpdateLogin(txn.getUserId());
        
        // Generate primary key from sequence
        if (getJobId() == null) {
            Number newId = getNextJobId();
            setJobId(newId);
        }
    }
    
    /**
     * Framework method - Called before DML operations
     */
    protected void doDML(int operation, oracle.jbo.server.TransactionEvent e) {
        // Update WHO columns
        if (operation == DML_UPDATE || operation == DML_INSERT) {
            OADBTransaction txn = getOADBTransaction();
            setLastUpdatedBy(txn.getUserId());
            setLastUpdateDate(txn.getCurrentDBDate());
            setLastUpdateLogin(txn.getUserId());
        }
        
        // Validate before delete
        if (operation == DML_DELETE) {
            validateBeforeDelete();
        }
        
        super.doDML(operation, e);
    }
    
    /**
     * Validate entity before commit
     */
    protected void validateEntity() {
        super.validateEntity();
        
        // Mandatory field validations
        if (getJobName() == null || getJobName().trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_JOB_NAME_REQUIRED,
                "Job Name"
            );
        }
        
        if (getEffectiveStartDate() == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Effective Start Date"
            );
        }
        
        // Business rule validations
        if (getJobHeadCount() != null && getJobHeadCount().intValue() <= 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_JOB_HEADCOUNT_INVALID
            );
        }
    }
    
    /**
     * Check if job name already exists
     */
    private boolean isDuplicateJobName(String jobName) {
        if (jobName == null || jobName.trim().isEmpty()) {
            return false;
        }
        
        OADBTransaction txn = getOADBTransaction();
        Number currentJobId = getJobId();
        
        // Query to check duplicate
        String sql = "SELECT COUNT(*) FROM xx_jobs " +
                     "WHERE UPPER(job_name) = UPPER(:1) " +
                     "AND (:2 IS NULL OR job_id != :2)";
        
        Object[] params = {jobName.trim(), currentJobId};
        
        Number count = (Number) txn.executeSQL(sql, params);
        return (count != null && count.intValue() > 0);
    }
    
    /**
     * Get count of active positions for this job
     */
    private int getActivePositionCount() {
        RowIterator positions = getPositionEO();
        if (positions == null) {
            return 0;
        }
        
        int count = 0;
        positions.reset();
        
        while (positions.hasNext()) {
            PositionEOImpl position = (PositionEOImpl) positions.next();
            Date endDate = position.getEffectiveEndDate();
            
            // Count active positions (no end date or future end date)
            if (endDate == null || endDate.compareTo(getCurrentDate()) >= 0) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Validate before delete - prevent deletion if active positions exist
     */
    private void validateBeforeDelete() {
        int activePositions = getActivePositionCount();
        
        if (activePositions > 0) {
            throw MessageHelper.createError(
                MessageConstants.ERR_JOB_ACTIVE_EMPLOYEES,
                String.valueOf(activePositions)
            );
        }
    }
    
    /**
     * Get next Job ID from sequence
     */
    private Number getNextJobId() {
        OADBTransaction txn = getOADBTransaction();
        oracle.jbo.server.SequenceImpl sequence = 
            new oracle.jbo.server.SequenceImpl("XX_JOB_ID_SEQ", txn);
        return sequence.getSequenceNumber();
    }
    
    /**
     * Get current database date
     */
    private Date getCurrentDate() {
        return getOADBTransaction().getCurrentDBDate();
    }
    
    /**
     * Get database transaction
     */
    protected OADBTransaction getOADBTransaction() {
        return (OADBTransaction) getDBTransaction();
    }
    
    /**
     * Check if entity is new (not yet persisted)
     */
    private boolean isNewEntity() {
        return (getEntityState() == STATUS_NEW || getEntityState() == STATUS_INITIALIZED);
    }
}
