package oracle.apps.fnd.framework.foundation.utilities;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.server.OAViewObject;

/**
 * BindVariableHelper - Generic bind variable utility for ViewObjects.
 * 
 * Provides SQL injection-safe patterns for setting bind variables in WHERE clauses.
 * Eliminates hardcoded bind variable handling.
 * 
 * USAGE:
 * <pre>
 * // Set single bind variable
 * BindVariableHelper.setBindVariable(vo, ":1", employeeId);
 * 
 * // Set multiple bind variables
 * BindVariableHelper.setBindVariables(vo, new Object[]{empId, deptId});
 * 
 * // Clear bind variables
 * BindVariableHelper.clearBindVariables(vo);
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class BindVariableHelper {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private BindVariableHelper() {
    }
    
    /**
     * Sets bind variables for a VO's WHERE clause.
     * 
     * @param vo the view object
     * @param bindValues array of bind variable values
     */
    public static void setBindVariables(OAViewObject vo, Object[] bindValues) {
        if (vo != null && bindValues != null && bindValues.length > 0) {
            vo.setWhereClauseParams(bindValues);
        }
    }
    
    /**
     * Sets a single bind variable.
     * 
     * @param vo the view object
     * @param value the bind variable value
     */
    public static void setBindVariable(OAViewObject vo, Object value) {
        if (vo != null && value != null) {
            vo.setWhereClauseParams(new Object[]{value});
        }
    }
    
    /**
     * Clears all bind variables.
     * 
     * @param vo the view object
     */
    public static void clearBindVariables(OAViewObject vo) {
        if (vo != null) {
            vo.setWhereClauseParams(null);
        }
    }
    
    /**
     * Sets WHERE clause with bind variables (SQL injection safe).
     * 
     * @param vo the view object
     * @param whereClause the WHERE clause with :1, :2 placeholders
     * @param bindValues array of bind variable values
     */
    public static void setWhereClauseWithBinds(OAViewObject vo, String whereClause, Object[] bindValues) {
        if (vo != null) {
            vo.setWhereClause(whereClause);
            if (bindValues != null && bindValues.length > 0) {
                vo.setWhereClauseParams(bindValues);
            }
        }
    }
    
    /**
     * Appends to existing WHERE clause with bind variables.
     * 
     * @param vo the view object
     * @param additionalClause the clause to append (with :1, :2 placeholders)
     * @param bindValues array of bind variable values
     */
    public static void appendWhereClause(OAViewObject vo, String additionalClause, Object[] bindValues) {
        if (vo != null) {
            String existingClause = vo.getWhereClause();
            String newClause = (existingClause != null && existingClause.length() > 0)
                              ? existingClause + " AND " + additionalClause
                              : additionalClause;
            vo.setWhereClause(newClause);
            if (bindValues != null && bindValues.length > 0) {
                vo.setWhereClauseParams(bindValues);
            }
        }
    }
}
