package oracle.apps.fnd.framework.foundation.base;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

/**
 * BaseViewObject - Foundation base class for all OAF View Objects.
 * 
 * Provides centralized, reusable VO functionality including:
 * - Secure search patterns with ViewCriteria (SQL injection prevention)
 * - Generic row operations
 * - Standardized attribute access
 * - Query optimization helpers
 * - Logging and diagnostics
 * 
 * USAGE:
 * All custom VOs should extend BaseViewObject instead of OAViewObjectImpl:
 * 
 * <pre>
 * public class EmployeeVOImpl extends BaseViewObject {
 *     // Use inherited secure search methods
 *     public void searchByName(String name) {
 *         applyViewCriteria("EmployeeNameVC", new Object[]{name});
 *     }
 * }
 * </pre>
 * 
 * BENEFITS:
 * - Prevents SQL injection through ViewCriteria patterns
 * - Consistent row handling across all VOs
 * - Reduces code duplication
 * - Simplifies debugging with built-in logging
 * - Framework-wide performance optimizations
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 * @see oracle.apps.fnd.framework.server.OAViewObjectImpl
 */
public class BaseViewObject extends OAViewObjectImpl {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Default constructor.
     */
    public BaseViewObject() {
        super();
    }
    
    // ========================================================================
    // SECURE SEARCH - ViewCriteria patterns (SQL injection safe)
    // ========================================================================
    
    /**
     * Applies a named ViewCriteria with bind variable values.
     * This is the SECURE way to filter VOs - never use setWhereClause with concatenation!
     * 
     * @param criteriaName the ViewCriteria name
     * @param bindValues array of bind variable values
     */
    protected void applyViewCriteria(String criteriaName, Object[] bindValues) {
        try {
            oracle.jbo.ViewCriteria vc = getViewCriteria(criteriaName);
            if (vc != null) {
                // Set bind variable values
                if (bindValues != null && bindValues.length > 0) {
                    oracle.jbo.ViewCriteriaRow vcRow = (oracle.jbo.ViewCriteriaRow) vc.first();
                    if (vcRow != null) {
                        for (int i = 0; i < bindValues.length; i++) {
                            vcRow.setAttribute(i, bindValues[i]);
                        }
                    }
                }
                applyViewCriteria(vc);
                executeQuery();
                logDebug("applyViewCriteria", "Applied criteria: " + criteriaName);
            } else {
                throw new OAException("FND", "ViewCriteria '" + criteriaName + "' not found");
            }
        } catch (Exception e) {
            logException("applyViewCriteria", "Error applying criteria: " + criteriaName, e);
            throw new OAException("FND", "Search failed: " + e.getMessage());
        }
    }
    
    /**
     * Removes all applied ViewCriteria and resets the VO.
     */
    protected void clearViewCriteria() {
        removeApplyViewCriteriaName(getApplyViewCriteriaName());
        reset();
        logDebug("clearViewCriteria", "Cleared all view criteria");
    }
    
    /**
     * Creates a dynamic ViewCriteria programmatically.
     * Use this when criteria cannot be defined declaratively.
     * 
     * @param criteriaName the criteria name
     * @return the created ViewCriteria
     */
    protected oracle.jbo.ViewCriteria createDynamicCriteria(String criteriaName) {
        return createViewCriteria();
    }
    
    // ========================================================================
    // ROW OPERATIONS - Generic row handling
    // ========================================================================
    
    /**
     * Gets the current row with proper casting.
     * 
     * @return the current OAViewRowImpl or null
     */
    protected OAViewRowImpl getCurrentOARow() {
        return (OAViewRowImpl) getCurrentRow();
    }
    
    /**
     * Gets the first row in the result set.
     * 
     * @return the first Row or null
     */
    protected Row getFirstRow() {
        first();
        return getCurrentRow();
    }
    
    /**
     * Checks if there is a next row.
     * 
     * @return true if next row exists
     */
    protected boolean hasNextRow() {
        return hasNext();
    }
    
    /**
     * Gets the next row and moves cursor.
     * 
     * @return the next Row or null
     */
    protected Row getNextRow() {
        next();
        return getCurrentRow();
    }
    
    /**
     * Iterates through all rows safely.
     * IMPORTANT: Always close the iterator after use!
     * 
     * Example:
     * <pre>
     * RowSetIterator iter = getAllRows();
     * try {
     *     Row row = null;
     *     while ((row = iter.next()) != null) {
     *         // Process row
     *     }
     * } finally {
     *     iter.closeRowSetIterator();
     * }
     * </pre>
     * 
     * @return RowSetIterator (must be closed!)
     */
    protected RowSetIterator getAllRows() {
        return createRowSetIterator(null);
    }
    
    /**
     * Gets total row count (fetches all rows if needed).
     * Use with caution for large result sets.
     * 
     * @return the total row count
     */
    protected int getTotalRowCount() {
        return getRowCount();
    }
    
    /**
     * Gets fetched row count (without fetching all rows).
     * 
     * @return the fetched row count
     */
    protected int getFetchedRowCount() {
        return getFetchedRowCount();
    }
    
    /**
     * Checks if the VO has any rows.
     * 
     * @return true if at least one row exists
     */
    protected boolean hasRows() {
        return getRowCount() > 0;
    }
    
    // ========================================================================
    // ROW CREATION & DELETION
    // ========================================================================
    
    /**
     * Creates a new row and inserts it at the end.
     * 
     * @return the newly created Row
     */
    protected Row createAndInsertRow() {
        Row row = createRow();
        insertRow(row);
        setCurrentRow(row);
        logDebug("createAndInsertRow", "Created new row in VO: " + getName());
        return row;
    }
    
    /**
     * Creates a new row and inserts it at a specific index.
     * 
     * @param index the insertion index
     * @return the newly created Row
     */
    protected Row createAndInsertRowAtIndex(int index) {
        Row row = createRow();
        insertRowAtRangeIndex(index, row);
        setCurrentRow(row);
        logDebug("createAndInsertRowAtIndex", "Created row at index: " + index);
        return row;
    }
    
    /**
     * Deletes the current row.
     */
    protected void deleteCurrentRow() {
        Row row = getCurrentRow();
        if (row != null) {
            row.remove();
            logDebug("deleteCurrentRow", "Deleted current row from VO: " + getName());
        }
    }
    
    /**
     * Deletes all rows from the VO.
     */
    protected void deleteAllRows() {
        RowSetIterator iter = getAllRows();
        try {
            Row row = null;
            int count = 0;
            while ((row = iter.next()) != null) {
                row.remove();
                count++;
            }
            logDebug("deleteAllRows", "Deleted " + count + " rows from VO: " + getName());
        } finally {
            iter.closeRowSetIterator();
        }
    }
    
    // ========================================================================
    // ATTRIBUTE ACCESS - Generic attribute helpers
    // ========================================================================
    
    /**
     * Gets an attribute value from current row.
     * 
     * @param attributeName the attribute name
     * @return the attribute value or null
     */
    protected Object getAttributeValue(String attributeName) {
        Row row = getCurrentRow();
        return (row != null) ? row.getAttribute(attributeName) : null;
    }
    
    /**
     * Sets an attribute value on current row.
     * 
     * @param attributeName the attribute name
     * @param value the value to set
     */
    protected void setAttributeValue(String attributeName, Object value) {
        Row row = getCurrentRow();
        if (row != null) {
            row.setAttribute(attributeName, value);
        }
    }
    
    /**
     * Gets a String attribute value from current row.
     * 
     * @param attributeName the attribute name
     * @return the String value or null
     */
    protected String getStringAttribute(String attributeName) {
        Object value = getAttributeValue(attributeName);
        return (value != null) ? value.toString() : null;
    }
    
    /**
     * Gets a Number attribute value from current row.
     * 
     * @param attributeName the attribute name
     * @return the Number value or null
     */
    protected Number getNumberAttribute(String attributeName) {
        return (Number) getAttributeValue(attributeName);
    }
    
    /**
     * Gets a Date attribute value from current row.
     * 
     * @param attributeName the attribute name
     * @return the Date value or null
     */
    protected Date getDateAttribute(String attributeName) {
        return (Date) getAttributeValue(attributeName);
    }
    
    // ========================================================================
    // QUERY OPTIMIZATION - Performance helpers
    // ========================================================================
    
    /**
     * Sets the maximum number of rows to fetch.
     * Use this to limit large result sets.
     * 
     * @param maxRows the maximum row count
     */
    protected void setMaxRowsToFetch(int maxRows) {
        setMaxFetchSize(maxRows);
        logDebug("setMaxRowsToFetch", "Set max rows to: " + maxRows);
    }
    
    /**
     * Sets the fetch size for query optimization.
     * Higher values reduce round trips but use more memory.
     * 
     * @param fetchSize the fetch size (default is 1)
     */
    protected void setQueryFetchSize(int fetchSize) {
        setRangeSize(fetchSize);
        logDebug("setQueryFetchSize", "Set fetch size to: " + fetchSize);
    }
    
    /**
     * Enables/disables forward-only mode for better performance.
     * Use for large result sets that are processed once.
     * 
     * @param forwardOnly true to enable forward-only mode
     */
    protected void setForwardOnlyMode(boolean forwardOnly) {
        setForwardOnly(forwardOnly);
        logDebug("setForwardOnlyMode", "Forward-only mode: " + forwardOnly);
    }
    
    // ========================================================================
    // WHERE CLAUSE - Bind variable patterns (use ViewCriteria instead!)
    // ========================================================================
    
    /**
     * Sets WHERE clause with bind variables.
     * NOTE: Prefer ViewCriteria for better SQL injection prevention!
     * 
     * @param whereClause the WHERE clause with :1, :2 bind variables
     * @param bindValues array of bind variable values
     */
    protected void setSecureWhereClause(String whereClause, Object[] bindValues) {
        setWhereClause(whereClause);
        if (bindValues != null && bindValues.length > 0) {
            setWhereClauseParams(bindValues);
        }
        logDebug("setSecureWhereClause", "Set WHERE clause: " + whereClause);
    }
    
    /**
     * Appends to existing WHERE clause with AND.
     * 
     * @param additionalClause the clause to append
     * @param bindValues additional bind variable values
     */
    protected void appendWhereClause(String additionalClause, Object[] bindValues) {
        String existingClause = getWhereClause();
        String newClause = (existingClause != null && existingClause.length() > 0)
                          ? existingClause + " AND " + additionalClause
                          : additionalClause;
        setSecureWhereClause(newClause, bindValues);
    }
    
    /**
     * Clears the WHERE clause.
     */
    protected void clearWhereClause() {
        setWhereClause(null);
        setWhereClauseParams(null);
        logDebug("clearWhereClause", "Cleared WHERE clause");
    }
    
    // ========================================================================
    // SORTING & ORDERING
    // ========================================================================
    
    /**
     * Sets the ORDER BY clause.
     * 
     * @param orderByClause the ORDER BY clause (e.g., "EMPLOYEE_NAME ASC, HIRE_DATE DESC")
     */
    protected void setOrderByClause(String orderByClause) {
        setOrderByClause(orderByClause);
        logDebug("setOrderByClause", "Set ORDER BY: " + orderByClause);
    }
    
    /**
     * Clears the ORDER BY clause.
     */
    protected void clearOrderByClause() {
        setOrderByClause(null);
        logDebug("clearOrderByClause", "Cleared ORDER BY clause");
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
                      "[" + getName() + "] " + method + ": " + message);
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
                      "[" + getName() + "] " + method + ": " + message + 
                      " - " + exception.getMessage());
        }
    }
    
    /**
     * Gets the generated SQL query for debugging.
     * Useful for performance tuning.
     * 
     * @return the SQL query string
     */
    protected String getGeneratedSQL() {
        return getQuery();
    }
}
