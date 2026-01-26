package oracle.apps.fnd.framework.foundation.utilities;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

/**
 * VOExecutor - Generic View Object execution utility.
 * 
 * Provides reusable patterns for VO operations without hardcoded VO names.
 * Eliminates the need for AM-specific getEmployeeVO1() methods.
 * 
 * USAGE:
 * <pre>
 * // In Application Module
 * OAViewObject vo = VOExecutor.findVO(this, "EmployeeSearchVO");
 * VOExecutor.executeQuery(vo);
 * 
 * // With WHERE clause
 * VOExecutor.executeWithWhereClause(vo, "EMPLOYEE_ID = :1", new Object[]{empId});
 * 
 * // Reset VO
 * VOExecutor.resetVO(this, "EmployeeSearchVO");
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class VOExecutor {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private VOExecutor() {
    }
    
    /**
     * Finds a VO by name within an AM.
     * 
     * @param am the application module
     * @param voName the VO instance name
     * @return the OAViewObject or null
     */
    public static OAViewObject findVO(OAApplicationModule am, String voName) {
        try {
            return (OAViewObject) am.findViewObject(voName);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Gets a VO by name. Throws exception if not found.
     * 
     * @param am the application module
     * @param voName the VO instance name
     * @return the OAViewObject
     * @throws OAException if VO not found
     */
    public static OAViewObject getVO(OAApplicationModule am, String voName) {
        OAViewObject vo = findVO(am, voName);
        if (vo == null) {
            throw new OAException("FND", "View Object '" + voName + "' not found");
        }
        return vo;
    }
    
    /**
     * Executes a VO query.
     * 
     * @param vo the view object
     */
    public static void executeQuery(OAViewObject vo) {
        if (vo != null) {
            vo.executeQuery();
        }
    }
    
    /**
     * Executes a VO with WHERE clause and bind variables.
     * 
     * @param vo the view object
     * @param whereClause the WHERE clause with :1, :2 bind variables
     * @param bindValues array of bind variable values
     */
    public static void executeWithWhereClause(OAViewObject vo, String whereClause, Object[] bindValues) {
        if (vo != null) {
            vo.setWhereClause(whereClause);
            if (bindValues != null && bindValues.length > 0) {
                vo.setWhereClauseParams(bindValues);
            }
            vo.executeQuery();
        }
    }
    
    /**
     * Resets a VO (clears query and removes rows).
     * 
     * @param am the application module
     * @param voName the VO instance name
     */
    public static void resetVO(OAApplicationModule am, String voName) {
        OAViewObject vo = findVO(am, voName);
        if (vo != null) {
            vo.reset();
        }
    }
    
    /**
     * Clears WHERE clause and parameters.
     * 
     * @param vo the view object
     */
    public static void clearWhereClause(OAViewObject vo) {
        if (vo != null) {
            vo.setWhereClause(null);
            vo.setWhereClauseParams(null);
        }
    }
    
    /**
     * Gets row count from a VO.
     * 
     * @param vo the view object
     * @return the row count
     */
    public static int getRowCount(OAViewObject vo) {
        return (vo != null) ? vo.getRowCount() : 0;
    }
    
    /**
     * Checks if VO has rows.
     * 
     * @param vo the view object
     * @return true if VO has at least one row
     */
    public static boolean hasRows(OAViewObject vo) {
        return getRowCount(vo) > 0;
    }
    
    /**
     * Gets current row from a VO.
     * 
     * @param vo the view object
     * @return the current Row or null
     */
    public static Row getCurrentRow(OAViewObject vo) {
        return (vo != null) ? vo.getCurrentRow() : null;
    }
    
    /**
     * Creates a new row in a VO.
     * 
     * @param vo the view object
     * @return the new Row
     */
    public static Row createRow(OAViewObject vo) {
        if (vo != null) {
            Row row = vo.createRow();
            vo.insertRow(row);
            vo.setCurrentRow(row);
            return row;
        }
        return null;
    }
    
    /**
     * Deletes current row from a VO.
     * 
     * @param vo the view object
     */
    public static void deleteCurrentRow(OAViewObject vo) {
        Row row = getCurrentRow(vo);
        if (row != null) {
            row.remove();
        }
    }
    
    /**
     * Iterates through all rows in a VO.
     * IMPORTANT: Always close iterator after use!
     * 
     * @param vo the view object
     * @return RowSetIterator (must be closed)
     */
    public static RowSetIterator getRowIterator(OAViewObject vo) {
        return (vo != null) ? vo.createRowSetIterator(null) : null;
    }
}
