package oracle.apps.fnd.framework.foundation.base;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.AttributeList;

/**
 * BaseEntityObject - Foundation base class for all OAF Entity Objects.
 * 
 * Provides centralized, reusable EO functionality including:
 * - Standardized validation framework
 * - Automatic audit column management (WHO columns)
 * - Sequence generation helpers
 * - Business rule enforcement patterns
 * - Exception handling
 * - Logging and diagnostics
 * 
 * USAGE:
 * All custom EOs should extend BaseEntityObject instead of OAEntityImpl:
 * 
 * <pre>
 * public class EmployeeEOImpl extends BaseEntityObject {
 *     // Override validation methods
 *     protected void validateEntity() {
 *         super.validateEntity();
 *         validateRequired(getEmployeeName(), "Employee Name");
 *         validateRange(getSalary(), 0, 999999, "Salary");
 *     }
 *     
 *     // Override for auto-sequence population
 *     protected String getSequenceName() {
 *         return "XX_EMPLOYEES_S";
 *     }
 * }
 * </pre>
 * 
 * BENEFITS:
 * - Automatic WHO column population (created_by, last_updated_by, etc.)
 * - Consistent validation patterns across all EOs
 * - Reduces code duplication
 * - Enforces Oracle EBS audit standards
 * - Framework-wide business rule enforcement
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 * @see oracle.apps.fnd.framework.server.OAEntityImpl
 */
public class BaseEntityObject extends OAEntityImpl {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    // WHO column attribute names (Oracle EBS standard)
    protected static final String ATTR_CREATED_BY = "CreatedBy";
    protected static final String ATTR_CREATION_DATE = "CreationDate";
    protected static final String ATTR_LAST_UPDATED_BY = "LastUpdatedBy";
    protected static final String ATTR_LAST_UPDATE_DATE = "LastUpdateDate";
    protected static final String ATTR_LAST_UPDATE_LOGIN = "LastUpdateLogin";
    
    /**
     * Default constructor.
     */
    public BaseEntityObject() {
        super();
    }
    
    // ========================================================================
    // LIFECYCLE METHODS - Override for custom logic
    // ========================================================================
    
    /**
     * Called when entity is created (INSERT).
     * Automatically populates WHO columns and primary key sequence.
     * 
     * @param attributeList initial attribute values
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
        // Auto-populate primary key from sequence
        String sequenceName = getSequenceName();
        if (sequenceName != null && sequenceName.length() > 0) {
            String pkAttr = getPrimaryKeyAttributeName();
            if (pkAttr != null) {
                Number nextVal = getNextSequenceValue(sequenceName);
                setAttribute(pkAttr, nextVal);
                logDebug("create", "Set " + pkAttr + " = " + nextVal + " from sequence: " + sequenceName);
            }
        }
        
        // Populate WHO columns for new record
        populateWHOColumnsOnCreate();
    }
    
    /**
     * Called before entity is posted to database.
     * Updates WHO columns automatically.
     * 
     * @param operation the DML operation (INSERT, UPDATE, DELETE)
     */
    protected void doDML(int operation, oracle.jbo.TransactionEvent e) {
        // Update WHO columns before DML
        if (operation == DML_INSERT) {
            populateWHOColumnsOnCreate();
        } else if (operation == DML_UPDATE) {
            populateWHOColumnsOnUpdate();
        }
        
        super.doDML(operation, e);
        logDebug("doDML", "Executed DML operation: " + getDMLOperationName(operation));
    }
    
    /**
     * Validates the entity before commit.
     * Override in subclasses to add custom validations.
     */
    protected void validateEntity() {
        super.validateEntity();
        
        // Subclasses should override and add business validations here
        logDebug("validateEntity", "Entity validation completed");
    }
    
    // ========================================================================
    // WHO COLUMN MANAGEMENT - Automatic audit trail
    // ========================================================================
    
    /**
     * Populates WHO columns on INSERT.
     * Called automatically from create() and doDML().
     */
    protected void populateWHOColumnsOnCreate() {
        OADBTransaction txn = getOADBTransaction();
        Number userId = txn.getUserId();
        Date sysDate = txn.getCurrentDBDate();
        Number loginId = txn.getLoginId();
        
        // Set creation WHO columns
        setAttributeIfExists(ATTR_CREATED_BY, userId);
        setAttributeIfExists(ATTR_CREATION_DATE, sysDate);
        setAttributeIfExists(ATTR_LAST_UPDATED_BY, userId);
        setAttributeIfExists(ATTR_LAST_UPDATE_DATE, sysDate);
        setAttributeIfExists(ATTR_LAST_UPDATE_LOGIN, loginId);
        
        logDebug("populateWHOColumnsOnCreate", "Set WHO columns for new record");
    }
    
    /**
     * Populates WHO columns on UPDATE.
     * Called automatically from doDML().
     */
    protected void populateWHOColumnsOnUpdate() {
        OADBTransaction txn = getOADBTransaction();
        Number userId = txn.getUserId();
        Date sysDate = txn.getCurrentDBDate();
        Number loginId = txn.getLoginId();
        
        // Update WHO columns (do not modify Created* columns)
        setAttributeIfExists(ATTR_LAST_UPDATED_BY, userId);
        setAttributeIfExists(ATTR_LAST_UPDATE_DATE, sysDate);
        setAttributeIfExists(ATTR_LAST_UPDATE_LOGIN, loginId);
        
        logDebug("populateWHOColumnsOnUpdate", "Updated WHO columns");
    }
    
    /**
     * Sets an attribute value only if the attribute exists.
     * Prevents errors when EO doesn't have all WHO columns.
     * 
     * @param attrName the attribute name
     * @param value the value to set
     */
    protected void setAttributeIfExists(String attrName, Object value) {
        try {
            if (getAttributeDef(attrName) != null) {
                setAttribute(attrName, value);
            }
        } catch (Exception e) {
            // Attribute doesn't exist - ignore silently
        }
    }
    
    // ========================================================================
    // SEQUENCE GENERATION - Primary key auto-population
    // ========================================================================
    
    /**
     * Gets the sequence name for primary key generation.
     * Override in subclasses to enable auto-sequence population.
     * 
     * Example:
     * <pre>
     * protected String getSequenceName() {
     *     return "XX_EMPLOYEES_S";
     * }
     * </pre>
     * 
     * @return the sequence name or null to disable auto-sequence
     */
    protected String getSequenceName() {
        return null; // Override in subclasses
    }
    
    /**
     * Gets the primary key attribute name.
     * Override in subclasses if PK attribute name differs from default.
     * Default implementation returns the first attribute name.
     * 
     * @return the primary key attribute name
     */
    protected String getPrimaryKeyAttributeName() {
        oracle.jbo.Key key = getKey();
        if (key != null && key.getAttributeCount() > 0) {
            Object[] attrs = key.getAttributeValues();
            if (attrs != null && attrs.length > 0) {
                // Return first PK attribute name
                return getEntityDef().getAttributeDefs()[0].getName();
            }
        }
        return null;
    }
    
    /**
     * Gets next value from sequence.
     * 
     * @param sequenceName the sequence name
     * @return the next sequence value
     */
    protected Number getNextSequenceValue(String sequenceName) {
        OADBTransaction txn = getOADBTransaction();
        return txn.getSequenceValue(sequenceName);
    }
    
    // ========================================================================
    // ATTRIBUTE ACCESS - Generic helpers
    // ========================================================================
    
    /**
     * Gets an attribute value with type safety.
     * 
     * @param attrName the attribute name
     * @return the attribute value or null
     */
    protected Object getAttributeValue(String attrName) {
        return getAttribute(attrName);
    }
    
    /**
     * Sets an attribute value.
     * 
     * @param attrName the attribute name
     * @param value the value to set
     */
    protected void setAttributeValue(String attrName, Object value) {
        setAttribute(attrName, value);
    }
    
    /**
     * Gets a String attribute value.
     * 
     * @param attrName the attribute name
     * @return the String value or null
     */
    protected String getStringAttribute(String attrName) {
        Object value = getAttributeValue(attrName);
        return (value != null) ? value.toString() : null;
    }
    
    /**
     * Gets a Number attribute value.
     * 
     * @param attrName the attribute name
     * @return the Number value or null
     */
    protected Number getNumberAttribute(String attrName) {
        return (Number) getAttributeValue(attrName);
    }
    
    /**
     * Gets a Date attribute value.
     * 
     * @param attrName the attribute name
     * @return the Date value or null
     */
    protected Date getDateAttribute(String attrName) {
        return (Date) getAttributeValue(attrName);
    }
    
    // ========================================================================
    // VALIDATION HELPERS - Common validation patterns
    // ========================================================================
    
    /**
     * Validates that a value is not null or empty.
     * 
     * @param value the value to validate
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    protected void validateRequired(Object value, String fieldName) {
        if (value == null || (value instanceof String && ((String)value).trim().length() == 0)) {
            throw new OAException("FND", fieldName + " is required");
        }
    }
    
    /**
     * Validates that a number is within range.
     * 
     * @param value the number value
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    protected void validateRange(Number value, int min, int max, String fieldName) {
        if (value != null) {
            int intValue = value.intValue();
            if (intValue < min || intValue > max) {
                throw new OAException("FND", fieldName + " must be between " + min + " and " + max);
            }
        }
    }
    
    /**
     * Validates that a date is within range.
     * 
     * @param value the date value
     * @param minDate minimum date (can be null)
     * @param maxDate maximum date (can be null)
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    protected void validateDateRange(Date value, Date minDate, Date maxDate, String fieldName) {
        if (value != null) {
            if ((minDate != null && value.compareTo(minDate) < 0) ||
                (maxDate != null && value.compareTo(maxDate) > 0)) {
                throw new OAException("FND", fieldName + " must be between " + 
                                     minDate + " and " + maxDate);
            }
        }
    }
    
    /**
     * Validates that a string matches a pattern.
     * 
     * @param value the string value
     * @param pattern the regex pattern
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    protected void validatePattern(String value, String pattern, String fieldName) {
        if (value != null && !value.matches(pattern)) {
            throw new OAException("FND", fieldName + " format is invalid");
        }
    }
    
    /**
     * Validates string length.
     * 
     * @param value the string value
     * @param maxLength maximum allowed length
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    protected void validateLength(String value, int maxLength, String fieldName) {
        if (value != null && value.length() > maxLength) {
            throw new OAException("FND", fieldName + " must be " + maxLength + " characters or less");
        }
    }
    
    /**
     * Validates that a value is unique (no duplicates in database).
     * Override in subclasses to implement custom uniqueness checks.
     * 
     * @param attrName the attribute name to check
     * @param fieldName the field name for error message
     * @throws OAException if duplicate found
     */
    protected void validateUnique(String attrName, String fieldName) {
        // Subclasses should override with custom SQL query
        // This is a placeholder for the pattern
        logDebug("validateUnique", "Uniqueness validation for: " + attrName);
    }
    
    // ========================================================================
    // BUSINESS RULE HELPERS
    // ========================================================================
    
    /**
     * Checks if entity is newly created (INSERT operation).
     * 
     * @return true if entity is new
     */
    protected boolean isNewEntity() {
        return getEntityState() == STATUS_NEW;
    }
    
    /**
     * Checks if entity has been modified.
     * 
     * @return true if entity has unsaved changes
     */
    protected boolean isModified() {
        return getEntityState() == STATUS_MODIFIED;
    }
    
    /**
     * Checks if a specific attribute has been modified.
     * 
     * @param attrName the attribute name
     * @return true if attribute changed
     */
    protected boolean isAttributeModified(String attrName) {
        return isAttributeChanged(attrName);
    }
    
    /**
     * Gets the original value of an attribute before modification.
     * 
     * @param attrName the attribute name
     * @return the original value or null
     */
    protected Object getOriginalAttributeValue(String attrName) {
        return getPostedAttribute(attrName);
    }
    
    // ========================================================================
    // TRANSACTION HELPERS
    // ========================================================================
    
    /**
     * Gets the database transaction.
     * 
     * @return the OADBTransaction
     */
    protected OADBTransaction getOADBTransaction() {
        return (OADBTransaction) getDBTransaction();
    }
    
    /**
     * Gets current user ID from transaction context.
     * 
     * @return the user ID
     */
    protected Number getCurrentUserId() {
        return getOADBTransaction().getUserId();
    }
    
    /**
     * Gets current database date from transaction context.
     * 
     * @return the current database date
     */
    protected Date getCurrentDBDate() {
        return getOADBTransaction().getCurrentDBDate();
    }
    
    // ========================================================================
    // LOGGING & DIAGNOSTICS
    // ========================================================================
    
    /**
     * Logs debug information.
     * 
     * @param method the method name
     * @param message the debug message
     */
    protected void logDebug(String method, String message) {
        if (isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.STATEMENT)) {
            logMessage(oracle.apps.fnd.framework.OAFwkConstants.STATEMENT,
                      "[" + getEntityDef().getName() + "] " + method + ": " + message);
        }
    }
    
    /**
     * Logs exception details.
     * 
     * @param method the method name
     * @param message the error message
     * @param exception the exception
     */
    protected void logException(String method, String message, Exception exception) {
        if (isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.EXCEPTION)) {
            logMessage(oracle.apps.fnd.framework.OAFwkConstants.EXCEPTION,
                      "[" + getEntityDef().getName() + "] " + method + ": " + message + 
                      " - " + exception.getMessage());
        }
    }
    
    /**
     * Gets DML operation name for logging.
     * 
     * @param operation the DML operation code
     * @return the operation name
     */
    protected String getDMLOperationName(int operation) {
        switch (operation) {
            case DML_INSERT: return "INSERT";
            case DML_UPDATE: return "UPDATE";
            case DML_DELETE: return "DELETE";
            default: return "UNKNOWN";
        }
    }
}
