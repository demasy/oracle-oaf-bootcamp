package oracle.apps.fnd.framework.foundation.diagnostics;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.OAFwkConstants;

/**
 * DiagnosticsLogger - Centralized logging utility for OAF applications.
 * 
 * Provides standardized logging patterns with different severity levels.
 * Simplifies diagnostic logging across Controllers, AMs, VOs, and EOs.
 * 
 * USAGE:
 * <pre>
 * // In Controller
 * DiagnosticsLogger.logProcedure(pageContext, this, "processRequest", "BEGIN");
 * DiagnosticsLogger.logStatement(pageContext, this, "Employee ID: " + empId);
 * DiagnosticsLogger.logException(pageContext, this, "Search failed", exception);
 * 
 * // In AM/VO/EO
 * DiagnosticsLogger.logDebug(this, "executeQuery", "Executing search...");
 * </pre>
 * 
 * LOG LEVELS (in order):
 * - PROCEDURE: Method entry/exit
 * - STATEMENT: Detailed execution flow
 * - EXCEPTION: Error conditions
 * - UNEXPECTED: Unexpected behavior
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class DiagnosticsLogger {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private DiagnosticsLogger() {
    }
    
    // ========================================================================
    // CONTROLLER LOGGING - With OAPageContext
    // ========================================================================
    
    /**
     * Logs procedure-level message (method entry/exit).
     * 
     * @param pageContext the page context
     * @param source the source object (usually 'this')
     * @param method the method name
     * @param message the log message
     */
    public static void logProcedure(OAPageContext pageContext, Object source, 
                                   String method, String message) {
        if (pageContext.isLoggingEnabled(OAFwkConstants.PROCEDURE)) {
            pageContext.writeDiagnostics(source, method + "() - " + message, 
                                        OAFwkConstants.PROCEDURE);
        }
    }
    
    /**
     * Logs statement-level message (detailed execution flow).
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param message the log message
     */
    public static void logStatement(OAPageContext pageContext, Object source, String message) {
        if (pageContext.isLoggingEnabled(OAFwkConstants.STATEMENT)) {
            pageContext.writeDiagnostics(source, message, OAFwkConstants.STATEMENT);
        }
    }
    
    /**
     * Logs exception with full stack trace.
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param message the error message
     * @param exception the exception
     */
    public static void logException(OAPageContext pageContext, Object source, 
                                   String message, Exception exception) {
        if (pageContext.isLoggingEnabled(OAFwkConstants.EXCEPTION)) {
            String fullMessage = message + " - " + 
                               (exception != null ? exception.getMessage() : "null");
            pageContext.writeDiagnostics(source, fullMessage, OAFwkConstants.EXCEPTION);
            if (exception != null) {
                exception.printStackTrace();
            }
        }
    }
    
    /**
     * Logs unexpected behavior (warnings).
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param message the warning message
     */
    public static void logUnexpected(OAPageContext pageContext, Object source, String message) {
        if (pageContext.isLoggingEnabled(OAFwkConstants.UNEXPECTED)) {
            pageContext.writeDiagnostics(source, message, OAFwkConstants.UNEXPECTED);
        }
    }
    
    // ========================================================================
    // SERVER-SIDE LOGGING - For AM/VO/EO (without OAPageContext)
    // ========================================================================
    
    /**
     * Logs debug message from server-side component.
     * 
     * @param source the source object (AM, VO, or EO)
     * @param method the method name
     * @param message the log message
     */
    public static void logDebug(Object source, String method, String message) {
        String className = source.getClass().getName();
        String fullMessage = "[" + className + "] " + method + ": " + message;
        System.out.println("DEBUG: " + fullMessage);
    }
    
    /**
     * Logs error message from server-side component.
     * 
     * @param source the source object
     * @param method the method name
     * @param message the error message
     * @param exception the exception
     */
    public static void logError(Object source, String method, String message, Exception exception) {
        String className = source.getClass().getName();
        String fullMessage = "[" + className + "] " + method + ": " + message;
        System.err.println("ERROR: " + fullMessage);
        if (exception != null) {
            exception.printStackTrace();
        }
    }
    
    // ========================================================================
    // CONVENIENCE METHODS
    // ========================================================================
    
    /**
     * Logs method entry.
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param method the method name
     */
    public static void logMethodEntry(OAPageContext pageContext, Object source, String method) {
        logProcedure(pageContext, source, method, "BEGIN");
    }
    
    /**
     * Logs method exit.
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param method the method name
     */
    public static void logMethodExit(OAPageContext pageContext, Object source, String method) {
        logProcedure(pageContext, source, method, "END");
    }
    
    /**
     * Logs parameter values for debugging.
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param paramName the parameter name
     * @param paramValue the parameter value
     */
    public static void logParameter(OAPageContext pageContext, Object source, 
                                   String paramName, Object paramValue) {
        logStatement(pageContext, source, "Parameter [" + paramName + "] = " + paramValue);
    }
    
    /**
     * Logs SQL query for debugging.
     * 
     * @param pageContext the page context
     * @param source the source object
     * @param sql the SQL query
     */
    public static void logSQL(OAPageContext pageContext, Object source, String sql) {
        logStatement(pageContext, source, "SQL: " + sql);
    }
    
    /**
     * Checks if logging is enabled at STATEMENT level.
     * 
     * @param pageContext the page context
     * @return true if statement logging enabled
     */
    public static boolean isDebugEnabled(OAPageContext pageContext) {
        return pageContext.isLoggingEnabled(OAFwkConstants.STATEMENT);
    }
}
