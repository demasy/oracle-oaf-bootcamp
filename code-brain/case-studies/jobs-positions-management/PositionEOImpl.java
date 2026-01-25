package oracle.apps.xx.jobmgmt.schema.server;

import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

/**
 * Position Entity Object Implementation
 * 
 * Represents a Position within a Job. This is the detail entity in a 
 * master-detail relationship with Jobs.
 * 
 * Table: XX_POSITIONS
 * 
 * Business Rules:
 * - Position Name is mandatory
 * - Must be associated with a valid Job (FK constraint)
 * - Head Count must be positive
 * - Position dates must be within Job's effective date range
 * - Effective Start Date is mandatory
 * - Effective End Date must be after Start Date (if provided)
 * 
 * Associations:
 * - Many Positions to One Job (JobPositionAssoc)
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
public class PositionEOImpl extends OAEntityImpl {
    
    // Attribute indices
    public static final int POSITIONID = 0;
    public static final int JOBID = 1;
    public static final int POSITIONNAME = 2;
    public static final int POSITIONHEADCOUNT = 3;
    public static final int EFFECTIVESTARTDATE = 4;
    public static final int EFFECTIVEENDDATE = 5;
    public static final int LASTUPDATEDATE = 6;
    public static final int LASTUPDATEDBY = 7;
    public static final int LASTUPDATELOGIN = 8;
    public static final int CREATEDBY = 9;
    public static final int CREATIONDATE = 10;
    
    // Association accessor constant
    public static final int JOBEO = 11;
    
    /**
     * Get Position ID (Primary Key)
     */
    public Number getPositionId() {
        return (Number) getAttributeInternal(POSITIONID);
    }
    
    /**
     * Set Position ID (Primary Key)
     */
    public void setPositionId(Number value) {
        setAttributeInternal(POSITIONID, value);
    }
    
    /**
     * Get Job ID (Foreign Key to XX_JOBS)
     */
    public Number getJobId() {
        return (Number) getAttributeInternal(JOBID);
    }
    
    /**
     * Set Job ID with validation
     */
    public void setJobId(Number value) {
        if (value == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Job"
            );
        }
        
        // Validate Job exists
        if (!isValidJobId(value)) {
            throw MessageHelper.createError(
                MessageConstants.ERR_JOB_NOT_FOUND,
                value.toString()
            );
        }
        
        setAttributeInternal(JOBID, value);
    }
    
    /**
     * Get Position Name
     */
    public String getPositionName() {
        return (String) getAttributeInternal(POSITIONNAME);
    }
    
    /**
     * Set Position Name with validation
     */
    public void setPositionName(String value) {
        // Mandatory validation
        if (value == null || value.trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Position Name"
            );
        }
        
        // Length validation
        if (value.length() > 200) {
            String[] tokens = {"Position Name", "200"};
            throw MessageHelper.createError(
                MessageConstants.ERR_TOO_LONG,
                tokens
            );
        }
        
        setAttributeInternal(POSITIONNAME, value.trim());
    }
    
    /**
     * Get Position Head Count
     */
    public Number getPositionHeadCount() {
        return (Number) getAttributeInternal(POSITIONHEADCOUNT);
    }
    
    /**
     * Set Position Head Count with validation
     */
    public void setPositionHeadCount(Number value) {
        if (value != null) {
            // Positive number validation
            if (value.intValue() <= 0) {
                throw MessageHelper.createError(
                    MessageConstants.APP_XX,
                    "XX_POSITION_HEADCOUNT_INVALID"
                );
            }
            
            // Range validation
            if (value.intValue() < 1 || value.intValue() > 999) {
                String[] tokens = {"1", "999"};
                throw MessageHelper.createError(
                    MessageConstants.ERR_OUT_OF_RANGE,
                    tokens
                );
            }
        }
        
        setAttributeInternal(POSITIONHEADCOUNT, value);
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
        
        // Validate against end date
        Date endDate = getEffectiveEndDate();
        if (endDate != null && value.compareTo(endDate) > 0) {
            throw MessageHelper.createValidationError(
                MessageConstants.APP_XXVAL,
                "XXVAL_E_START_AFTER_END"
            );
        }
        
        // Validate against Job's date range
        validatePositionDateAgainstJob(value, "start");
        
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
            
            // Validate against Job's date range
            validatePositionDateAgainstJob(value, "end");
        }
        
        setAttributeInternal(EFFECTIVEENDDATE, value);
    }
    
    /**
     * Get associated Job (N:1 relationship)
     */
    public JobEOImpl getJobEO() {
        return (JobEOImpl) getAttributeInternal(JOBEO);
    }
    
    /**
     * Set associated Job
     */
    public void setJobEO(JobEOImpl value) {
        setAttributeInternal(JOBEO, value);
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
        if (getPositionId() == null) {
            Number newId = getNextPositionId();
            setPositionId(newId);
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
        
        super.doDML(operation, e);
    }
    
    /**
     * Validate entity before commit
     */
    protected void validateEntity() {
        super.validateEntity();
        
        // Mandatory validations
        if (getPositionName() == null || getPositionName().trim().isEmpty()) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Position Name"
            );
        }
        
        if (getJobId() == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Job"
            );
        }
        
        if (getEffectiveStartDate() == null) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FIELD_REQUIRED,
                "Effective Start Date"
            );
        }
    }
    
    /**
     * Validate if Job ID exists
     */
    private boolean isValidJobId(Number jobId) {
        if (jobId == null) {
            return false;
        }
        
        OADBTransaction txn = getOADBTransaction();
        String sql = "SELECT COUNT(*) FROM xx_jobs WHERE job_id = :1";
        Object[] params = {jobId};
        
        Number count = (Number) txn.executeSQL(sql, params);
        return (count != null && count.intValue() > 0);
    }
    
    /**
     * Validate Position dates against Job's effective date range
     * 
     * Business Rule: Position dates must be within Job's date range
     */
    private void validatePositionDateAgainstJob(Date positionDate, String dateType) {
        if (positionDate == null) {
            return;
        }
        
        JobEOImpl job = getJobEO();
        if (job == null && getJobId() != null) {
            // If association not loaded, query job dates directly
            OADBTransaction txn = getOADBTransaction();
            String sql = "SELECT effective_start_date, effective_end_date " +
                         "FROM xx_jobs WHERE job_id = :1";
            Object[] params = {getJobId()};
            
            Object[] result = (Object[]) txn.executeSQL(sql, params);
            if (result != null && result.length >= 2) {
                Date jobStartDate = (Date) result[0];
                Date jobEndDate = (Date) result[1];
                
                validateDateRange(positionDate, jobStartDate, jobEndDate, dateType);
            }
        } else if (job != null) {
            validateDateRange(positionDate, 
                            job.getEffectiveStartDate(), 
                            job.getEffectiveEndDate(), 
                            dateType);
        }
    }
    
    /**
     * Validate date range against job dates
     */
    private void validateDateRange(Date positionDate, Date jobStartDate, 
                                    Date jobEndDate, String dateType) {
        if ("start".equals(dateType) && jobStartDate != null) {
            if (positionDate.compareTo(jobStartDate) < 0) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_POSITION_START_BEFORE_JOB
                );
            }
        }
        
        if ("end".equals(dateType) && jobEndDate != null) {
            if (positionDate.compareTo(jobEndDate) > 0) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_POSITION_END_AFTER_JOB
                );
            }
        }
    }
    
    /**
     * Get next Position ID from sequence
     */
    private Number getNextPositionId() {
        OADBTransaction txn = getOADBTransaction();
        oracle.jbo.server.SequenceImpl sequence = 
            new oracle.jbo.server.SequenceImpl("XX_POSITION_ID_SEQ", txn);
        return sequence.getSequenceNumber();
    }
    
    /**
     * Get database transaction
     */
    protected OADBTransaction getOADBTransaction() {
        return (OADBTransaction) getDBTransaction();
    }
}
