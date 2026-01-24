/*===========================================================================+
 | Oracle Applications Framework (OAF) - Entity Object Patterns
 | 
 | USE CASE: WHO column population, sequence generation, validation
 | LOCATION: Entity Object Implementation
 | COMPLEXITY: Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.server;

import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.AttributeDefImpl;

public class EntityObjectPatterns extends OAEntityImpl {
    
    /**
     * Populate WHO columns and sequence on create
     * Use Case: Standard pattern for new record creation
     */
    @Override
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
        // Get DB transaction
        OADBTransaction transaction = (OADBTransaction)getOADBTransaction();
        
        // 1. Generate primary key using sequence
        SequenceImpl seq = new SequenceImpl("XX_JOB_ID_SEQ", getDBTransaction());
        Number jobId = seq.getSequenceNumber();
        setJobId(jobId);
        
        // 2. Populate WHO columns for creation
        Number userId = transaction.getUserId();
        Date currentDate = transaction.getCurrentDBDate();
        Number loginId = transaction.getUserLoginId();
        
        setCreatedBy(userId);
        setCreationDate(currentDate);
        setLastUpdatedBy(userId);
        setLastUpdateDate(currentDate);
        setLastUpdateLogin(loginId);
    }
    
    /**
     * Update WHO columns before DML
     * Use Case: Track last update information
     */
    @Override
    protected void doDML(int operation, oracle.jbo.server.TransactionEvent e) {
        OADBTransaction transaction = (OADBTransaction)getOADBTransaction();
        
        if (operation == DML_UPDATE || operation == DML_INSERT) {
            // Update WHO columns
            Number userId = transaction.getUserId();
            Date currentDate = transaction.getCurrentDBDate();
            Number loginId = transaction.getUserLoginId();
            
            setLastUpdatedBy(userId);
            setLastUpdateDate(currentDate);
            setLastUpdateLogin(loginId);
        }
        
        super.doDML(operation, e);
    }
    
    /**
     * Entity-level validation
     * Use Case: Complex validation involving multiple attributes
     */
    @Override
    protected void validateEntity() {
        super.validateEntity();
        
        // Validate date range
        Date startDate = getEffectiveStartDate();
        Date endDate = getEffectiveEndDate();
        
        if (startDate != null && endDate != null) {
            if (endDate.compareTo(startDate) < 0) {
                throw new OAException("XX", "INVALID_DATE_RANGE",
                                    null, OAException.ERROR, null);
            }
        }
        
        // Validate head count
        Number headCount = getJobHeadCount();
        if (headCount != null && headCount.intValue() <= 0) {
            throw new OAException("XX", "INVALID_HEAD_COUNT",
                                null, OAException.ERROR, null);
        }
        
        // Validate job name is not empty
        String jobName = getJobName();
        if (jobName == null || jobName.trim().length() == 0) {
            throw new OAException("XX", "JOB_NAME_REQUIRED",
                                null, OAException.ERROR, null);
        }
    }
    
    /**
     * Attribute-level validation - Setter override
     * Use Case: Validate individual attribute when set
     */
    public void setJobName(String value) {
        // Validate before setting
        if (value != null) {
            // Trim whitespace
            value = value.trim();
            
            // Check length
            if (value.length() > 240) {
                throw new OAException("XX", "JOB_NAME_TOO_LONG",
                                    null, OAException.ERROR, null);
            }
            
            // Check for invalid characters
            if (value.matches(".*[<>\"'].*")) {
                throw new OAException("XX", "JOB_NAME_INVALID_CHARS",
                                    null, OAException.ERROR, null);
            }
        }
        
        setAttributeInternal(JOBNAME, value);
    }
    
    /**
     * Validate attribute using AttributeDefImpl
     * Use Case: Add programmatic validation to attribute
     */
    public void addAttributeValidation() {
        // This would typically be in entity definition, shown for reference
        AttributeDefImpl attr = (AttributeDefImpl)getAttributeDef(JOBHEADCOUNT);
        
        // Set as mandatory
        attr.setMandatory(true);
        
        // Set precision
        attr.setPrecision(10);
    }
    
    /**
     * Custom business logic before remove
     * Use Case: Validation or cascading delete before removing record
     */
    @Override
    public void remove() {
        // Check if job has positions
        Number jobId = getJobId();
        
        OADBTransaction transaction = (OADBTransaction)getOADBTransaction();
        
        // Query to check for positions
        String sql = "SELECT COUNT(*) FROM XX_POSITIONS WHERE JOB_ID = :1";
        Object[] params = {jobId};
        
        // Execute query
        Number count = (Number)transaction.executeFunction(sql, params);
        
        if (count != null && count.intValue() > 0) {
            throw new OAException("XX", "CANNOT_DELETE_JOB_WITH_POSITIONS",
                                null, OAException.ERROR, null);
        }
        
        super.remove();
    }
    
    /**
     * Calculate derived attribute
     * Use Case: Compute value based on other attributes
     */
    public Number getTotalPositions() {
        Number jobId = getJobId();
        
        if (jobId != null) {
            OADBTransaction transaction = (OADBTransaction)getOADBTransaction();
            
            String sql = "SELECT COUNT(*) FROM XX_POSITIONS WHERE JOB_ID = :1";
            Object[] params = {jobId};
            
            Number count = (Number)transaction.executeFunction(sql, params);
            return count;
        }
        
        return new Number(0);
    }
    
    /**
     * Post changes to database (for EO not based on DB table)
     * Use Case: Custom persistence logic
     */
    @Override
    public void postChanges(oracle.jbo.server.TransactionEvent e) {
        super.postChanges(e);
        
        // Custom logic after database changes
        // For example: Update cache, call API, etc.
    }
    
    /**
     * Refresh entity from database
     * Use Case: Reload entity with latest DB values
     */
    public void refreshFromDatabase() {
        // Refresh the entity
        refresh(REFRESH_WITH_DB_FORGET_CHANGES);
    }
    
    /**
     * Check if attribute has changed
     * Use Case: Conditional logic based on attribute modification
     */
    public void checkAttributeChange() {
        if (isAttributeChanged(JOBNAME)) {
            // Job name was modified
            // Perform additional logic
            String oldValue = (String)getPostedAttribute(JOBNAME);
            String newValue = getJobName();
            
            System.out.println("Job name changed from '" + oldValue + 
                             "' to '" + newValue + "'");
        }
    }
    
    // Attribute constant declarations (auto-generated by JDeveloper)
    public static final int JOBID = 0;
    public static final int JOBNAME = 1;
    public static final int JOBHEADCOUNT = 2;
    public static final int EFFECTIVESTARTDATE = 3;
    public static final int EFFECTIVEENDDATE = 4;
    public static final int CREATEDBY = 5;
    public static final int CREATIONDATE = 6;
    public static final int LASTUPDATEDBY = 7;
    public static final int LASTUPDATEDATE = 8;
    public static final int LASTUPDATELOGIN = 9;
    
    // Getter/Setter methods (abbreviated for example)
    public Number getJobId() {
        return (Number)getAttributeInternal(JOBID);
    }
    
    public void setJobId(Number value) {
        setAttributeInternal(JOBID, value);
    }
    
    public String getJobName() {
        return (String)getAttributeInternal(JOBNAME);
    }
    
    public Number getJobHeadCount() {
        return (Number)getAttributeInternal(JOBHEADCOUNT);
    }
    
    public void setJobHeadCount(Number value) {
        setAttributeInternal(JOBHEADCOUNT, value);
    }
    
    public Date getEffectiveStartDate() {
        return (Date)getAttributeInternal(EFFECTIVESTARTDATE);
    }
    
    public void setEffectiveStartDate(Date value) {
        setAttributeInternal(EFFECTIVESTARTDATE, value);
    }
    
    public Date getEffectiveEndDate() {
        return (Date)getAttributeInternal(EFFECTIVEENDDATE);
    }
    
    public void setEffectiveEndDate(Date value) {
        setAttributeInternal(EFFECTIVEENDDATE, value);
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
}
