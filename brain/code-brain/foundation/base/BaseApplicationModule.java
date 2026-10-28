package oracle.apps.fnd.framework.foundation.base;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * BaseApplicationModule - Foundation base class for all OAF Application Modules.
 * 
 * Provides centralized, reusable AM functionality including:
 * - Generic VO execution patterns (no hardcoded VO names)
 * - Standardized transaction management
 * - PLSQL procedure/function integration
 * - Exception handling framework
 * - Logging and diagnostics
 * - Common business logic patterns
 * 
 * USAGE:
 * All custom AMs should extend BaseApplicationModule instead of OAApplicationModuleImpl:
 * 
 * <pre>
 * public class EmployeeAMImpl extends BaseApplicationModule {
 *     // Use generic VO helpers instead of hardcoded references
 *     public void searchEmployees(String searchCriteria) {
 *         OAViewObject vo = findVO("EmployeeSearchVO");
 *         vo.setWhereClause("EMPLOYEE_NAME LIKE :1");
 *         vo.setWhereClauseParams(new Object[]{searchCriteria + "%"});
 *         executeVO(vo);
 *     }
 * }
 * </pre>
 * 
 * BENEFITS:
 * - Eliminates hardcoded VO names (use findVO instead of getEmployeeVO1())
 * - Consistent error handling across all AMs
 * - Reduces code duplication
 * - Simplifies testing (no casting required)
 * - Framework-wide logging and diagnostics
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 * @see oracle.apps.fnd.framework.server.OAApplicationModuleImpl
 */
public class BaseApplicationModule extends OAApplicationModuleImpl {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Default constructor.
     */
    public BaseApplicationModule() {
        super();
    }
    
    // ========================================================================
    // VIEW OBJECT ACCESS - Generic helpers (no hardcoded names)
    // ========================================================================
    
    /**
     * Finds a View Object by name within this AM.
     * Eliminates need for getEmployeeVO1() hardcoded methods.
     * 
     * @param voName the view object instance name
     * @return the OAViewObject or null if not found
     */
    protected OAViewObject findVO(String voName) {
        try {
            return (OAViewObject) findViewObject(voName);
        } catch (Exception e) {
            logException("findVO", "Could not find VO: " + voName, e);
            return null;
        }
    }
    
    /**
     * Gets a View Object by name. Throws exception if not found.
     * 
     * @param voName the view object instance name
     * @return the OAViewObject
     * @throws OAException if VO not found
     */
    protected OAViewObject getVO(String voName) {
        OAViewObject vo = findVO(voName);
        if (vo == null) {
            throw new OAException("FND", "View Object '" + voName + "' not found in AM");
        }
        return vo;
    }
    
    /**
     * Executes a View Object query.
     * 
     * @param voName the view object name
     */
    protected void executeVO(String voName) {
        OAViewObject vo = getVO(voName);
        if (vo != null) {
            vo.executeQuery();
            logDebug("executeVO", "Executed query for VO: " + voName);
        }
    }
    
    /**
     * Executes a View Object query (overloaded for direct VO reference).
     * 
     * @param vo the view object
     */
    protected void executeVO(OAViewObject vo) {
        if (vo != null) {
            vo.executeQuery();
            logDebug("executeVO", "Executed query for VO: " + vo.getName());
        }
    }
    
    /**
     * Resets a View Object (clears query and removes rows).
     * 
     * @param voName the view object name
     */
    protected void resetVO(String voName) {
        OAViewObject vo = findVO(voName);
        if (vo != null) {
            vo.reset();
            logDebug("resetVO", "Reset VO: " + voName);
        }
    }
    
    /**
     * Clears a View Object's WHERE clause and parameters.
     * 
     * @param voName the view object name
     */
    protected void clearVOWhereClause(String voName) {
        OAViewObject vo = getVO(voName);
        if (vo != null) {
            vo.setWhereClause(null);
            vo.setWhereClauseParams(null);
            logDebug("clearVOWhereClause", "Cleared WHERE clause for VO: " + voName);
        }
    }
    
    /**
     * Sets WHERE clause with bind variables (SQL injection safe).
     * 
     * @param voName the view object name
     * @param whereClause the WHERE clause with :1, :2 bind variables
     * @param params the parameter values
     */
    protected void setVOWhereClause(String voName, String whereClause, Object[] params) {
        OAViewObject vo = getVO(voName);
        if (vo != null) {
            vo.setWhereClause(whereClause);
            if (params != null && params.length > 0) {
                vo.setWhereClauseParams(params);
            }
            logDebug("setVOWhereClause", "Set WHERE clause for VO: " + voName);
        }
    }
    
    // ========================================================================
    // ROW OPERATIONS - Generic row handling
    // ========================================================================
    
    /**
     * Gets current row from a VO.
     * 
     * @param voName the view object name
     * @return the current Row or null
     */
    protected Row getCurrentRow(String voName) {
        OAViewObject vo = getVO(voName);
        return (vo != null) ? vo.getCurrentRow() : null;
    }
    
    /**
     * Creates a new row in a VO.
     * 
     * @param voName the view object name
     * @return the new Row
     */
    protected Row createRow(String voName) {
        OAViewObject vo = getVO(voName);
        if (vo != null) {
            Row row = vo.createRow();
            vo.insertRow(row);
            vo.setCurrentRow(row);
            logDebug("createRow", "Created new row in VO: " + voName);
            return row;
        }
        return null;
    }
    
    /**
     * Deletes current row from a VO.
     * 
     * @param voName the view object name
     */
    protected void deleteCurrentRow(String voName) {
        Row row = getCurrentRow(voName);
        if (row != null) {
            row.remove();
            logDebug("deleteCurrentRow", "Deleted row from VO: " + voName);
        }
    }
    
    /**
     * Gets row count from a VO.
     * 
     * @param voName the view object name
     * @return the row count
     */
    protected int getRowCount(String voName) {
        OAViewObject vo = getVO(voName);
        return (vo != null) ? vo.getRowCount() : 0;
    }
    
    /**
     * Checks if a VO has rows.
     * 
     * @param voName the view object name
     * @return true if VO has at least one row
     */
    protected boolean hasRows(String voName) {
        return getRowCount(voName) > 0;
    }
    
    /**
     * Iterates through all rows in a VO.
     * Returns RowSetIterator for safe iteration.
     * IMPORTANT: Always close iterator after use!
     * 
     * @param voName the view object name
     * @return RowSetIterator (must be closed)
     */
    protected RowSetIterator getRowIterator(String voName) {
        OAViewObject vo = getVO(voName);
        return (vo != null) ? vo.createRowSetIterator(null) : null;
    }
    
    // ========================================================================
    // TRANSACTION MANAGEMENT - Commit/Rollback helpers
    // ========================================================================
    
    /**
     * Gets the database transaction.
     * 
     * @return the OADBTransaction
     */
    protected OADBTransaction getDBTransaction() {
        return (OADBTransaction) getOADBTransaction();
    }
    
    /**
     * Commits the transaction.
     */
    protected void commitTransaction() {
        getDBTransaction().commit();
        logDebug("commitTransaction", "Transaction committed successfully");
    }
    
    /**
     * Rolls back the transaction.
     */
    protected void rollbackTransaction() {
        getDBTransaction().rollback();
        logDebug("rollbackTransaction", "Transaction rolled back");
    }
    
    /**
     * Validates all pending changes before commit.
     * 
     * @throws OAException if validation fails
     */
    protected void validatePendingChanges() {
        try {
            getDBTransaction().validate();
            logDebug("validatePendingChanges", "Validation successful");
        } catch (Exception e) {
            logException("validatePendingChanges", "Validation failed", e);
            throw new OAException("FND", "Validation failed: " + e.getMessage());
        }
    }
    
    // ========================================================================
    // PLSQL INTEGRATION - CallableStatement helpers
    // ========================================================================
    
    /**
     * Executes a PLSQL procedure with no return value.
     * 
     * @param procedureName the procedure name (e.g., "xx_pkg.my_procedure")
     * @param inParams array of IN parameter values
     * @throws OAException if execution fails
     */
    protected void executeProcedure(String procedureName, Object[] inParams) {
        CallableStatement cs = null;
        try {
            // Build PLSQL call syntax
            StringBuilder callSyntax = new StringBuilder("{call " + procedureName + "(");
            if (inParams != null && inParams.length > 0) {
                for (int i = 0; i < inParams.length; i++) {
                    callSyntax.append(i == 0 ? "?" : ",?");
                }
            }
            callSyntax.append(")}");
            
            // Prepare and execute
            cs = getDBTransaction().createCallableStatement(callSyntax.toString(), 1);
            
            // Set IN parameters
            if (inParams != null) {
                for (int i = 0; i < inParams.length; i++) {
                    cs.setObject(i + 1, inParams[i]);
                }
            }
            
            cs.execute();
            logDebug("executeProcedure", "Executed: " + procedureName);
            
        } catch (SQLException e) {
            logException("executeProcedure", "Error executing: " + procedureName, e);
            throw new OAException("FND", "PLSQL execution failed: " + e.getMessage());
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
    
    /**
     * Executes a PLSQL function that returns a value.
     * 
     * @param functionName the function name
     * @param returnType the SQL type of return value (e.g., java.sql.Types.VARCHAR)
     * @param inParams array of IN parameter values
     * @return the function return value
     * @throws OAException if execution fails
     */
    protected Object executeFunction(String functionName, int returnType, Object[] inParams) {
        CallableStatement cs = null;
        try {
            // Build PLSQL call syntax for function
            StringBuilder callSyntax = new StringBuilder("{? = call " + functionName + "(");
            if (inParams != null && inParams.length > 0) {
                for (int i = 0; i < inParams.length; i++) {
                    callSyntax.append(i == 0 ? "?" : ",?");
                }
            }
            callSyntax.append(")}");
            
            cs = getDBTransaction().createCallableStatement(callSyntax.toString(), 1);
            
            // Register return value
            cs.registerOutParameter(1, returnType);
            
            // Set IN parameters (starting at position 2)
            if (inParams != null) {
                for (int i = 0; i < inParams.length; i++) {
                    cs.setObject(i + 2, inParams[i]);
                }
            }
            
            cs.execute();
            Object result = cs.getObject(1);
            logDebug("executeFunction", "Executed function: " + functionName);
            return result;
            
        } catch (SQLException e) {
            logException("executeFunction", "Error executing: " + functionName, e);
            throw new OAException("FND", "PLSQL function failed: " + e.getMessage());
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
    
    /**
     * Executes a procedure with OUT parameters.
     * 
     * @param procedureName the procedure name
     * @param inParams array of IN parameter values
     * @param outTypes array of SQL types for OUT parameters
     * @return array of OUT parameter values
     * @throws OAException if execution fails
     */
    protected Object[] executeProcedureWithOutParams(String procedureName, 
                                                      Object[] inParams, 
                                                      int[] outTypes) {
        CallableStatement cs = null;
        try {
            int totalParams = (inParams != null ? inParams.length : 0) + 
                             (outTypes != null ? outTypes.length : 0);
            
            StringBuilder callSyntax = new StringBuilder("{call " + procedureName + "(");
            for (int i = 0; i < totalParams; i++) {
                callSyntax.append(i == 0 ? "?" : ",?");
            }
            callSyntax.append(")}");
            
            cs = getDBTransaction().createCallableStatement(callSyntax.toString(), 1);
            
            // Set IN parameters
            int paramIndex = 1;
            if (inParams != null) {
                for (int i = 0; i < inParams.length; i++) {
                    cs.setObject(paramIndex++, inParams[i]);
                }
            }
            
            // Register OUT parameters
            if (outTypes != null) {
                for (int i = 0; i < outTypes.length; i++) {
                    cs.registerOutParameter(paramIndex++, outTypes[i]);
                }
            }
            
            cs.execute();
            
            // Retrieve OUT parameters
            Object[] outValues = null;
            if (outTypes != null) {
                outValues = new Object[outTypes.length];
                paramIndex = (inParams != null ? inParams.length : 0) + 1;
                for (int i = 0; i < outTypes.length; i++) {
                    outValues[i] = cs.getObject(paramIndex++);
                }
            }
            
            logDebug("executeProcedureWithOutParams", "Executed: " + procedureName);
            return outValues;
            
        } catch (SQLException e) {
            logException("executeProcedureWithOutParams", "Error executing: " + procedureName, e);
            throw new OAException("FND", "PLSQL execution failed: " + e.getMessage());
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
    
    // ========================================================================
    // SEQUENCE GENERATION - Generic sequence helpers
    // ========================================================================
    
    /**
     * Gets next value from a database sequence.
     * 
     * @param sequenceName the sequence name
     * @return the next sequence value
     */
    protected Number getNextSequenceValue(String sequenceName) {
        OADBTransaction txn = getDBTransaction();
        return txn.getSequenceValue(sequenceName);
    }
    
    // ========================================================================
    // LOGGING & DIAGNOSTICS - Framework logging
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
                      method + ": " + message);
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
                      method + ": " + message + " - " + exception.getMessage());
        }
    }
    
    /**
     * Logs procedure entry.
     * 
     * @param method the method name
     */
    protected void logProcedureEntry(String method) {
        if (isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE)) {
            logMessage(oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE,
                      method + "() - BEGIN");
        }
    }
    
    /**
     * Logs procedure exit.
     * 
     * @param method the method name
     */
    protected void logProcedureExit(String method) {
        if (isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE)) {
            logMessage(oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE,
                      method + "() - END");
        }
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
     * @param min minimum value
     * @param max maximum value
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
     * @param minDate minimum date
     * @param maxDate maximum date
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
}
