package oracle.apps.fnd.framework.foundation.base;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.form.OASubmitButtonBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAHeaderBean;
import oracle.apps.fnd.framework.server.OAApplicationModule;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseController - Foundation base class for all OAF Controllers.
 * 
 * Provides centralized, reusable controller functionality including:
 * - Generic parameter handling (no hardcoded names)
 * - Standardized navigation patterns
 * - Transaction management
 * - Exception handling framework
 * - Logging and diagnostics
 * - Security context integration
 * - Component state management
 * 
 * USAGE:
 * All custom controllers should extend BaseController instead of OAControllerImpl:
 * 
 * <pre>
 * public class EmployeeCO extends BaseController {
 *     public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
 *         super.processRequest(pageContext, webBean);
 *         // Custom logic here
 *     }
 *     
 *     public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
 *         super.processFormRequest(pageContext, webBean);
 *         if (isEvent(pageContext, "search")) {
 *             handleSearch(pageContext);
 *         }
 *     }
 * }
 * </pre>
 * 
 * BENEFITS:
 * - Reduces code duplication across controllers
 * - Enforces Oracle best practices
 * - Provides consistent error handling
 * - Simplifies testing and maintenance
 * - Enables framework-wide enhancements
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 * @see oracle.apps.fnd.framework.webui.OAControllerImpl
 */
public class BaseController extends oracle.apps.fnd.framework.webui.OAControllerImpl {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    // Component state constants
    private static final String COMP_STATE_PREFIX = "BaseController_";
    private static final String NAVIGATION_STATE = COMP_STATE_PREFIX + "NavState";
    
    /**
     * Default constructor.
     */
    public BaseController() {
        super();
    }
    
    // ========================================================================
    // LIFECYCLE METHODS - Override in subclasses
    // ========================================================================
    
    /**
     * Handles initial page processing with standardized logging and exception handling.
     * Subclasses should call super.processRequest() first, then add custom logic.
     * 
     * @param pageContext the current OA page context
     * @param webBean the root web bean of the page
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        
        // Log page entry for diagnostics
        logPageEntry(pageContext, "processRequest");
        
        // Initialize page state if needed
        initializePageState(pageContext);
    }
    
    /**
     * Handles form submission events with standardized exception handling.
     * Subclasses should call super.processFormRequest() first, then handle events.
     * 
     * @param pageContext the current OA page context
     * @param webBean the root web bean of the page
     */
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        // Log form submission for diagnostics
        logPageEntry(pageContext, "processFormRequest");
    }
    
    // ========================================================================
    // PARAMETER HANDLING - Generic, no hardcoded names
    // ========================================================================
    
    /**
     * Gets a required parameter value. Throws exception if not found.
     * 
     * @param pageContext the page context
     * @param paramName the parameter name
     * @return the parameter value
     * @throws OAException if parameter is null or empty
     */
    protected String getRequiredParameter(OAPageContext pageContext, String paramName) {
        String value = pageContext.getParameter(paramName);
        if (value == null || value.trim().length() == 0) {
            throw new OAException("FND", "Required parameter '" + paramName + "' is missing");
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
    protected String getParameter(OAPageContext pageContext, String paramName, String defaultValue) {
        String value = pageContext.getParameter(paramName);
        return (value != null && value.trim().length() > 0) ? value : defaultValue;
    }
    
    /**
     * Gets all parameters as a Map for easy processing.
     * 
     * @param pageContext the page context
     * @return Map of parameter names to values
     */
    protected Map getParameterMap(OAPageContext pageContext) {
        Map params = new HashMap();
        String[] paramNames = pageContext.getParameterNames();
        if (paramNames != null) {
            for (int i = 0; i < paramNames.length; i++) {
                params.put(paramNames[i], pageContext.getParameter(paramNames[i]));
            }
        }
        return params;
    }
    
    // ========================================================================
    // EVENT HANDLING - Simplified event detection
    // ========================================================================
    
    /**
     * Checks if a specific event occurred.
     * 
     * @param pageContext the page context
     * @param eventName the event name to check
     * @return true if event occurred
     */
    protected boolean isEvent(OAPageContext pageContext, String eventName) {
        return eventName.equals(pageContext.getParameter(EVENT_PARAM));
    }
    
    /**
     * Gets the current event name.
     * 
     * @param pageContext the page context
     * @return the event name or null
     */
    protected String getEventName(OAPageContext pageContext) {
        return pageContext.getParameter(EVENT_PARAM);
    }
    
    // ========================================================================
    // APPLICATION MODULE ACCESS - Generic helpers
    // ========================================================================
    
    /**
     * Gets the root application module with proper casting.
     * 
     * @param pageContext the page context
     * @return the root AM
     */
    protected OAApplicationModule getRootAM(OAPageContext pageContext) {
        return pageContext.getRootApplicationModule();
    }
    
    /**
     * Gets the transaction object.
     * 
     * @param pageContext the page context
     * @return the database transaction
     */
    protected OADBTransaction getTransaction(OAPageContext pageContext) {
        return (OADBTransaction) getRootAM(pageContext).getOADBTransaction();
    }
    
    // ========================================================================
    // NAVIGATION HELPERS - Standardized navigation patterns
    // ========================================================================
    
    /**
     * Navigates forward to another page with parameters.
     * 
     * @param pageContext the page context
     * @param functionName the destination function name
     * @param params HashMap of parameter name-value pairs
     * @param retainAM true to retain AM, false to release
     * @param addBreadCrumb true to add breadcrumb
     */
    protected void forwardToPage(OAPageContext pageContext, String functionName, 
                                  HashMap params, boolean retainAM, boolean addBreadCrumb) {
        pageContext.setForwardURL(functionName, null, 
                                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                  null, params, retainAM,
                                  addBreadCrumb ? OAWebBeanConstants.ADD_BREAD_CRUMB_YES 
                                                : OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
                                  OAWebBeanConstants.IGNORE_MESSAGES);
    }
    
    /**
     * Returns to the calling page (breadcrumb navigation).
     * 
     * @param pageContext the page context
     * @param retainAM true to retain AM
     */
    protected void returnToCallingPage(OAPageContext pageContext, boolean retainAM) {
        pageContext.forwardImmediately("OA.jsp?akRegionCode=FWK_TBX_T_FUNCTION_NAV",
                                      null,
                                      OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                      null, null, retainAM,
                                      OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
    
    /**
     * Navigates to a function with minimal parameters.
     * 
     * @param pageContext the page context
     * @param functionName the function name
     */
    protected void navigateToFunction(OAPageContext pageContext, String functionName) {
        forwardToPage(pageContext, functionName, null, false, true);
    }
    
    // ========================================================================
    // TRANSACTION MANAGEMENT - Commit/Rollback helpers
    // ========================================================================
    
    /**
     * Commits the transaction with success message.
     * 
     * @param pageContext the page context
     * @param messageCode the success message code (e.g., "FND_RECORD_SAVED")
     */
    protected void commitWithMessage(OAPageContext pageContext, String messageCode) {
        getTransaction(pageContext).commit();
        showConfirmationMessage(pageContext, messageCode);
    }
    
    /**
     * Rolls back the transaction with error message.
     * 
     * @param pageContext the page context
     * @param messageCode the error message code
     */
    protected void rollbackWithMessage(OAPageContext pageContext, String messageCode) {
        getTransaction(pageContext).rollback();
        showErrorMessage(pageContext, messageCode);
    }
    
    // ========================================================================
    // MESSAGE HANDLING - Standardized user feedback
    // ========================================================================
    
    /**
     * Shows a confirmation message.
     * 
     * @param pageContext the page context
     * @param messageCode the message code
     */
    protected void showConfirmationMessage(OAPageContext pageContext, String messageCode) {
        OAException message = new OAException("FND", messageCode, null, 
                                             OAException.CONFIRMATION, null);
        pageContext.putDialogMessage(message);
    }
    
    /**
     * Shows an error message.
     * 
     * @param pageContext the page context
     * @param messageCode the message code
     */
    protected void showErrorMessage(OAPageContext pageContext, String messageCode) {
        OAException message = new OAException("FND", messageCode, null, 
                                             OAException.ERROR, null);
        pageContext.putDialogMessage(message);
    }
    
    /**
     * Shows a warning message.
     * 
     * @param pageContext the page context
     * @param messageCode the message code
     */
    protected void showWarningMessage(OAPageContext pageContext, String messageCode) {
        OAException message = new OAException("FND", messageCode, null, 
                                             OAException.WARNING, null);
        pageContext.putDialogMessage(message);
    }
    
    /**
     * Shows a confirmation dialog with Yes/No buttons.
     * 
     * @param pageContext the page context
     * @param messageCode the message code
     * @param yesURL the URL to navigate on Yes
     * @param noURL the URL to navigate on No (can be null)
     */
    protected void showConfirmationDialog(OAPageContext pageContext, String messageCode,
                                          String yesURL, String noURL) {
        OAException message = new OAException("FND", messageCode);
        OADialogPage dialog = new OADialogPage(OAException.WARNING, message, 
                                              yesURL, noURL, null);
        pageContext.redirectToDialogPage(dialog);
    }
    
    // ========================================================================
    // COMPONENT ACCESS - Generic web bean helpers
    // ========================================================================
    
    /**
     * Finds a web bean by ID within the page hierarchy.
     * 
     * @param webBean the parent web bean
     * @param beanId the bean ID to find
     * @return the web bean or null
     */
    protected OAWebBean findWebBean(OAWebBean webBean, String beanId) {
        return webBean.findChildRecursive(beanId);
    }
    
    /**
     * Sets a component as required.
     * 
     * @param webBean the web bean
     * @param beanId the bean ID
     * @param required true to make required
     */
    protected void setRequired(OAWebBean webBean, String beanId, boolean required) {
        OAWebBean bean = findWebBean(webBean, beanId);
        if (bean != null && bean instanceof OAMessageTextInputBean) {
            ((OAMessageTextInputBean) bean).setRequired(required ? "yes" : "no");
        }
    }
    
    /**
     * Sets a component as rendered (visible).
     * 
     * @param webBean the web bean
     * @param beanId the bean ID
     * @param rendered true to render
     */
    protected void setRendered(OAWebBean webBean, String beanId, boolean rendered) {
        OAWebBean bean = findWebBean(webBean, beanId);
        if (bean != null) {
            bean.setRendered(rendered);
        }
    }
    
    /**
     * Sets a component as read-only.
     * 
     * @param webBean the web bean
     * @param beanId the bean ID
     * @param readOnly true to make read-only
     */
    protected void setReadOnly(OAWebBean webBean, String beanId, boolean readOnly) {
        OAWebBean bean = findWebBean(webBean, beanId);
        if (bean != null && bean instanceof OAMessageTextInputBean) {
            ((OAMessageTextInputBean) bean).setReadOnly(readOnly);
        }
    }
    
    // ========================================================================
    // LOGGING & DIAGNOSTICS - Framework logging
    // ========================================================================
    
    /**
     * Logs page entry for diagnostics.
     * 
     * @param pageContext the page context
     * @param method the method name
     */
    protected void logPageEntry(OAPageContext pageContext, String method) {
        if (pageContext.isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE)) {
            pageContext.writeDiagnostics(this, method + "() - BEGIN", 
                                        oracle.apps.fnd.framework.OAFwkConstants.PROCEDURE);
        }
    }
    
    /**
     * Logs debug information.
     * 
     * @param pageContext the page context
     * @param message the debug message
     */
    protected void logDebug(OAPageContext pageContext, String message) {
        if (pageContext.isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.STATEMENT)) {
            pageContext.writeDiagnostics(this, message, 
                                        oracle.apps.fnd.framework.OAFwkConstants.STATEMENT);
        }
    }
    
    /**
     * Logs exception details.
     * 
     * @param pageContext the page context
     * @param exception the exception to log
     */
    protected void logException(OAPageContext pageContext, Exception exception) {
        if (pageContext.isLoggingEnabled(oracle.apps.fnd.framework.OAFwkConstants.EXCEPTION)) {
            pageContext.writeDiagnostics(this, "Exception: " + exception.getMessage(), 
                                        oracle.apps.fnd.framework.OAFwkConstants.EXCEPTION);
        }
    }
    
    // ========================================================================
    // STATE MANAGEMENT - Session/Component state
    // ========================================================================
    
    /**
     * Initializes page-specific state.
     * Override in subclasses for custom initialization.
     * 
     * @param pageContext the page context
     */
    protected void initializePageState(OAPageContext pageContext) {
        // Default implementation - override in subclasses
    }
    
    /**
     * Stores a value in session scope.
     * 
     * @param pageContext the page context
     * @param key the key
     * @param value the value
     */
    protected void putSessionValue(OAPageContext pageContext, String key, Serializable value) {
        pageContext.putSessionValue(key, value);
    }
    
    /**
     * Gets a value from session scope.
     * 
     * @param pageContext the page context
     * @param key the key
     * @return the value or null
     */
    protected Serializable getSessionValue(OAPageContext pageContext, String key) {
        return pageContext.getSessionValue(key);
    }
    
    /**
     * Removes a value from session scope.
     * 
     * @param pageContext the page context
     * @param key the key
     */
    protected void removeSessionValue(OAPageContext pageContext, String key) {
        pageContext.removeSessionValue(key);
    }
}
