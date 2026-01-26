package oracle.apps.fnd.framework.foundation.utilities;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAPageContext;

import java.util.HashMap;
import java.util.Map;

/**
 * ParameterHelper - Generic parameter handling utility.
 * 
 * Provides reusable patterns for request parameter access without hardcoded names.
 * Simplifies parameter validation and type conversion.
 * 
 * USAGE:
 * <pre>
 * // In Controller processFormRequest
 * String empId = ParameterHelper.getRequiredParameter(pageContext, "empId");
 * String deptId = ParameterHelper.getParameter(pageContext, "deptId", "10");
 * 
 * // Get all parameters as Map
 * Map params = ParameterHelper.getAllParameters(pageContext);
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class ParameterHelper {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private ParameterHelper() {
    }
    
    /**
     * Gets a required parameter. Throws exception if not found.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @return the parameter value
     * @throws oracle.apps.fnd.framework.OAException if parameter is null or empty
     */
    public static String getRequiredParameter(OAPageContext pageContext, String paramName) {
        String value = pageContext.getParameter(paramName);
        if (value == null || value.trim().length() == 0) {
            throw new oracle.apps.fnd.framework.OAException("FND", 
                "Required parameter '" + paramName + "' is missing");
        }
        return value;
    }
    
    /**
     * Gets an optional parameter with default value.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @param defaultValue the default value if parameter not found
     * @return the parameter value or default
     */
    public static String getParameter(OAPageContext pageContext, String paramName, String defaultValue) {
        String value = pageContext.getParameter(paramName);
        return (value != null && value.trim().length() > 0) ? value : defaultValue;
    }
    
    /**
     * Gets a parameter as integer.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @param defaultValue the default value if parameter not found or invalid
     * @return the integer value
     */
    public static int getIntParameter(OAPageContext pageContext, String paramName, int defaultValue) {
        try {
            String value = pageContext.getParameter(paramName);
            return (value != null && value.trim().length() > 0) ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * Gets a parameter as boolean.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @param defaultValue the default value if parameter not found
     * @return the boolean value
     */
    public static boolean getBooleanParameter(OAPageContext pageContext, String paramName, boolean defaultValue) {
        String value = pageContext.getParameter(paramName);
        if (value == null || value.trim().length() == 0) {
            return defaultValue;
        }
        return "Y".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value) || "1".equals(value);
    }
    
    /**
     * Gets all parameters as a Map.
     * 
     * @param pageContext the page context
     * @return Map of parameter names to values
     */
    public static Map getAllParameters(OAPageContext pageContext) {
        Map params = new HashMap();
        String[] paramNames = pageContext.getParameterNames();
        if (paramNames != null) {
            for (int i = 0; i < paramNames.length; i++) {
                params.put(paramNames[i], pageContext.getParameter(paramNames[i]));
            }
        }
        return params;
    }
    
    /**
     * Checks if a parameter exists.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @return true if parameter exists and is not empty
     */
    public static boolean hasParameter(OAPageContext pageContext, String paramName) {
        String value = pageContext.getParameter(paramName);
        return (value != null && value.trim().length() > 0);
    }
    
    /**
     * Gets multiple parameters with a common prefix.
     * Useful for handling dynamic form fields.
     * 
     * @param pageContext the page context
     * @param prefix the parameter name prefix
     * @return Map of parameter names (without prefix) to values
     */
    public static Map getParametersByPrefix(OAPageContext pageContext, String prefix) {
        Map params = new HashMap();
        String[] paramNames = pageContext.getParameterNames();
        if (paramNames != null) {
            for (int i = 0; i < paramNames.length; i++) {
                if (paramNames[i].startsWith(prefix)) {
                    String key = paramNames[i].substring(prefix.length());
                    params.put(key, pageContext.getParameter(paramNames[i]));
                }
            }
        }
        return params;
    }
}
