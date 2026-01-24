/*===========================================================================+
 | Oracle Applications Framework (OAF) - Validation Patterns
 | 
 | USE CASE: Attribute, Entity, and Transaction level validations
 | LOCATION: Entity Object, Application Module
 | COMPLEXITY: Intermediate
 +===========================================================================*/

package oracle.apps.xx.jobmgmt.validation;

import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

public class ValidationPatterns {
    
    /**
     * ATTRIBUTE-LEVEL VALIDATION
     * Location: Entity Object setter method
     * Use Case: Validate single attribute when value is set
     */
    public static class AttributeLevelValidation extends OAEntityImpl {
        
        // Validate Job Name
        public void setJobName(String value) {
            // Required check
            if (value == null || value.trim().isEmpty()) {
                throw new OAException("XX", "JOB_NAME_REQUIRED",
                                    null, OAException.ERROR, null);
            }
            
            // Length check
            if (value.length() > 240) {
                throw new OAException("XX", "JOB_NAME_TOO_LONG",
                                    null, OAException.ERROR, null);
            }
            
            // Format check
            if (!value.matches("^[a-zA-Z0-9 ]+$")) {
                throw new OAException("XX", "JOB_NAME_INVALID_FORMAT",
                                    null, OAException.ERROR, null);
            }
            
            // Set the value
            setAttributeInternal(JOBNAME, value.trim());
        }
        
        // Validate Head Count
        public void setJobHeadCount(Number value) {
            if (value != null) {
                // Range check
                if (value.intValue() < 1 || value.intValue() > 999) {
                    throw new OAException("XX", "HEADCOUNT_OUT_OF_RANGE",
                                        null, OAException.ERROR, null);
                }
            }
            
            setAttributeInternal(JOBHEADCOUNT, value);
        }
        
        // Validate Effective Start Date
        public void setEffectiveStartDate(Date value) {
            if (value != null) {
                OADBTransaction txn = getOADBTransaction();
                Date today = txn.getCurrentDBDate();
                
                // Cannot be in the past
                if (value.compareTo(today) < 0) {
                    throw new OAException("XX", "START_DATE_IN_PAST",
                                        null, OAException.ERROR, null);
                }
            }
            
            setAttributeInternal(EFFECTIVESTARTDATE, value);
        }
        
        private static final int JOBNAME = 0;
        private static final int JOBHEADCOUNT = 1;
        private static final int EFFECTIVESTARTDATE = 2;
    }
    
    /**
     * ENTITY-LEVEL VALIDATION
     * Location: Entity Object validateEntity() method
     * Use Case: Validate multiple attributes together
     */
    public static class EntityLevelValidation extends OAEntityImpl {
        
        @Override
        protected void validateEntity() {
            super.validateEntity();
            
            // 1. Date Range Validation
            validateDateRange();
            
            // 2. Business Rule Validation
            validateBusinessRules();
            
            // 3. Database Uniqueness Check
            validateUniqueness();
        }
        
        private void validateDateRange() {
            Date startDate = getEffectiveStartDate();
            Date endDate = getEffectiveEndDate();
            
            if (startDate != null && endDate != null) {
                // End date must be after start date
                if (endDate.compareTo(startDate) <= 0) {
                    throw new OAException("XX", "END_DATE_BEFORE_START",
                                        null, OAException.ERROR, null);
                }
                
                // Date range cannot exceed 10 years
                long diffMillis = endDate.getValue() - startDate.getValue();
                long diffDays = diffMillis / (1000 * 60 * 60 * 24);
                if (diffDays > 3650) {
                    throw new OAException("XX", "DATE_RANGE_TOO_LONG",
                                        null, OAException.ERROR, null);
                }
            }
        }
        
        private void validateBusinessRules() {
            Number headCount = getJobHeadCount();
            Number currentPositionCount = getCurrentPositionCount();
            
            // Head count must be >= existing positions
            if (headCount != null && currentPositionCount != null) {
                if (headCount.intValue() < currentPositionCount.intValue()) {
                    OAException error = new OAException("XX", 
                        "HEADCOUNT_LESS_THAN_POSITIONS");
                    error.setMessageToken("HEADCOUNT", headCount.toString());
                    error.setMessageToken("POSITIONS", currentPositionCount.toString());
                    throw error;
                }
            }
        }
        
        private void validateUniqueness() {
            String jobName = getJobName();
            Number jobId = getJobId();
            
            if (jobName != null) {
                OADBTransaction txn = getOADBTransaction();
                
                String sql = "SELECT COUNT(*) FROM XX_JOBS " +
                           "WHERE UPPER(JOB_NAME) = UPPER(:1) " +
                           "AND (:2 IS NULL OR JOB_ID != :2)";
                           
                Object[] params = {jobName, jobId};
                Number count = (Number)txn.executeFunction(sql, params);
                
                if (count != null && count.intValue() > 0) {
                    OAException error = new OAException("XX", "DUPLICATE_JOB_NAME");
                    error.setMessageToken("JOB_NAME", jobName);
                    throw error;
                }
            }
        }
        
        private Date getEffectiveStartDate() {
            return (Date)getAttributeInternal(0);
        }
        
        private Date getEffectiveEndDate() {
            return (Date)getAttributeInternal(1);
        }
        
        private Number getJobHeadCount() {
            return (Number)getAttributeInternal(2);
        }
        
        private String getJobName() {
            return (String)getAttributeInternal(3);
        }
        
        private Number getJobId() {
            return (Number)getAttributeInternal(4);
        }
        
        private Number getCurrentPositionCount() {
            // Logic to get current position count
            return new Number(0);
        }
    }
    
    /**
     * TRANSACTION-LEVEL VALIDATION
     * Location: Application Module custom method
     * Use Case: Validate across multiple entities or complex business logic
     */
    public static class TransactionLevelValidation extends OAApplicationModuleImpl {
        
        public void validateJobTransfer(Number sourceJobId, 
                                       Number targetJobId,
                                       Number positionCount) {
            
            // 1. Validate source job exists and is active
            validateJobActive(sourceJobId, "Source");
            
            // 2. Validate target job exists and is active
            validateJobActive(targetJobId, "Target");
            
            // 3. Validate source has enough positions
            validateSufficientPositions(sourceJobId, positionCount);
            
            // 4. Validate target has capacity
            validateTargetCapacity(targetJobId, positionCount);
            
            // 5. Validate no duplicate transfers in progress
            validateNoDuplicateTransfer(sourceJobId, targetJobId);
        }
        
        private void validateJobActive(Number jobId, String jobType) {
            OADBTransaction txn = getOADBTransaction();
            
            String sql = "SELECT COUNT(*) FROM XX_JOBS " +
                       "WHERE JOB_ID = :1 " +
                       "AND SYSDATE BETWEEN EFFECTIVE_START_DATE AND " +
                       "NVL(EFFECTIVE_END_DATE, SYSDATE + 1)";
                       
            Object[] params = {jobId};
            Number count = (Number)txn.executeFunction(sql, params);
            
            if (count == null || count.intValue() == 0) {
                OAException error = new OAException("XX", "JOB_NOT_ACTIVE");
                error.setMessageToken("JOB_TYPE", jobType);
                error.setMessageToken("JOB_ID", jobId.toString());
                throw error;
            }
        }
        
        private void validateSufficientPositions(Number jobId, Number requiredCount) {
            OADBTransaction txn = getOADBTransaction();
            
            String sql = "SELECT COUNT(*) FROM XX_POSITIONS " +
                       "WHERE JOB_ID = :1 AND STATUS = 'ACTIVE'";
                       
            Object[] params = {jobId};
            Number availableCount = (Number)txn.executeFunction(sql, params);
            
            if (availableCount.intValue() < requiredCount.intValue()) {
                OAException error = new OAException("XX", "INSUFFICIENT_POSITIONS");
                error.setMessageToken("AVAILABLE", availableCount.toString());
                error.setMessageToken("REQUIRED", requiredCount.toString());
                throw error;
            }
        }
        
        private void validateTargetCapacity(Number jobId, Number additionalPositions) {
            OADBTransaction txn = getOADBTransaction();
            
            String sql = "SELECT JOB_HEAD_COUNT, " +
                       "(SELECT COUNT(*) FROM XX_POSITIONS WHERE JOB_ID = j.JOB_ID) " +
                       "AS CURRENT_COUNT " +
                       "FROM XX_JOBS j WHERE JOB_ID = :1";
                       
            Object[] params = {jobId};
            Object[] result = (Object[])txn.executeFunction(sql, params);
            
            Number headCount = (Number)result[0];
            Number currentCount = (Number)result[1];
            
            int newTotal = currentCount.intValue() + additionalPositions.intValue();
            
            if (newTotal > headCount.intValue()) {
                OAException error = new OAException("XX", "EXCEEDS_HEAD_COUNT");
                error.setMessageToken("NEW_TOTAL", String.valueOf(newTotal));
                error.setMessageToken("HEAD_COUNT", headCount.toString());
                throw error;
            }
        }
        
        private void validateNoDuplicateTransfer(Number sourceJobId, Number targetJobId) {
            OADBTransaction txn = getOADBTransaction();
            
            String sql = "SELECT COUNT(*) FROM XX_POSITION_TRANSFERS " +
                       "WHERE SOURCE_JOB_ID = :1 " +
                       "AND TARGET_JOB_ID = :2 " +
                       "AND STATUS = 'PENDING'";
                       
            Object[] params = {sourceJobId, targetJobId};
            Number count = (Number)txn.executeFunction(sql, params);
            
            if (count != null && count.intValue() > 0) {
                throw new OAException("XX", "DUPLICATE_TRANSFER_EXISTS",
                                    null, OAException.ERROR, null);
            }
        }
    }
    
    /**
     * CROSS-FIELD VALIDATION
     * Use Case: Validate dependent fields
     */
    public static class CrossFieldValidation {
        
        public static void validatePositionDates(Date positionStart, 
                                                Date positionEnd,
                                                Date jobStart,
                                                Date jobEnd) {
            
            // Position dates must be within job dates
            if (positionStart.compareTo(jobStart) < 0) {
                throw new OAException("XX", "POSITION_START_BEFORE_JOB",
                                    null, OAException.ERROR, null);
            }
            
            if (jobEnd != null && positionEnd != null) {
                if (positionEnd.compareTo(jobEnd) > 0) {
                    throw new OAException("XX", "POSITION_END_AFTER_JOB",
                                        null, OAException.ERROR, null);
                }
            }
        }
    }
    
    /**
     * CONDITIONAL VALIDATION
     * Use Case: Validation based on other field values
     */
    public static class ConditionalValidation extends OAEntityImpl {
        
        @Override
        protected void validateEntity() {
            super.validateEntity();
            
            String jobType = getJobType();
            
            if ("PERMANENT".equals(jobType)) {
                // Permanent jobs must have end date
                Date endDate = getEffectiveEndDate();
                if (endDate == null) {
                    throw new OAException("XX", "END_DATE_REQUIRED_FOR_PERMANENT",
                                        null, OAException.ERROR, null);
                }
            } else if ("TEMPORARY".equals(jobType)) {
                // Temporary jobs must have head count <= 10
                Number headCount = getJobHeadCount();
                if (headCount != null && headCount.intValue() > 10) {
                    throw new OAException("XX", "TEMP_JOB_HEADCOUNT_LIMIT",
                                        null, OAException.ERROR, null);
                }
            }
        }
        
        private String getJobType() {
            return (String)getAttributeInternal(0);
        }
        
        private Date getEffectiveEndDate() {
            return (Date)getAttributeInternal(1);
        }
        
        private Number getJobHeadCount() {
            return (Number)getAttributeInternal(2);
        }
    }
}
