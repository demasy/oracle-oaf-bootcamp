package oracle.apps.fnd.framework.foundation.security;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.jbo.domain.Number;

/**
 * UserContextHelper - User session and security context utility.
 * 
 * Provides easy access to user information from OA Framework context.
 * Simplifies user ID, responsibility, and session data retrieval.
 * 
 * USAGE:
 * <pre>
 * // Get current user ID
 * Number userId = UserContextHelper.getUserId(pageContext);
 * 
 * // Get user name
 * String userName = UserContextHelper.getUserName(pageContext);
 * 
 * // Get responsibility ID
 * Number respId = UserContextHelper.getResponsibilityId(pageContext);
 * 
 * // Check if user has specific responsibility
 * boolean hasResp = UserContextHelper.hasResponsibility(pageContext, respId);
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class UserContextHelper {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private UserContextHelper() {
    }
    
    /**
     * Gets the current user ID.
     * 
     * @param pageContext the page context
     * @return the user ID
     */
    public static Number getUserId(OAPageContext pageContext) {
        return (Number) pageContext.getUserId();
    }
    
    /**
     * Gets the current user name.
     * 
     * @param pageContext the page context
     * @return the user name
     */
    public static String getUserName(OAPageContext pageContext) {
        return pageContext.getUserName();
    }
    
    /**
     * Gets the current responsibility ID.
     * 
     * @param pageContext the page context
     * @return the responsibility ID
     */
    public static Number getResponsibilityId(OAPageContext pageContext) {
        return (Number) pageContext.getResponsibilityId();
    }
    
    /**
     * Gets the current responsibility application ID.
     * 
     * @param pageContext the page context
     * @return the responsibility application ID
     */
    public static Number getResponsibilityApplicationId(OAPageContext pageContext) {
        return (Number) pageContext.getResponsibilityApplicationId();
    }
    
    /**
     * Gets the current organization ID.
     * 
     * @param pageContext the page context
     * @return the organization ID or null
     */
    public static String getOrgId(OAPageContext pageContext) {
        return pageContext.getProfile("ORG_ID");
    }
    
    /**
     * Gets the current session ID.
     * 
     * @param pageContext the page context
     * @return the session ID
     */
    public static String getSessionId(OAPageContext pageContext) {
        return pageContext.getSessionId();
    }
    
    /**
     * Gets the login ID from transaction.
     * 
     * @param txn the database transaction
     * @return the login ID
     */
    public static Number getLoginId(OADBTransaction txn) {
        return txn.getLoginId();
    }
    
    /**
     * Gets a user profile option value.
     * 
     * @param pageContext the page context
     * @param profileName the profile option name
     * @return the profile value or null
     */
    public static String getProfileValue(OAPageContext pageContext, String profileName) {
        return pageContext.getProfile(profileName);
    }
    
    /**
     * Checks if user has a specific responsibility.
     * 
     * @param pageContext the page context
     * @param responsibilityId the responsibility ID to check
     * @return true if user has the responsibility
     */
    public static boolean hasResponsibility(OAPageContext pageContext, Number responsibilityId) {
        Number currentRespId = getResponsibilityId(pageContext);
        return (currentRespId != null && responsibilityId != null && 
                currentRespId.compareTo(responsibilityId) == 0);
    }
    
    /**
     * Gets the current language code.
     * 
     * @param pageContext the page context
     * @return the language code (e.g., "US", "AR")
     */
    public static String getLanguageCode(OAPageContext pageContext) {
        return pageContext.getLanguageCode();
    }
    
    /**
     * Checks if current session is in debug mode.
     * 
     * @param pageContext the page context
     * @return true if diagnostics enabled
     */
    public static boolean isDebugMode(OAPageContext pageContext) {
        String debugFlag = getProfileValue(pageContext, "FND_DIAGNOSTICS");
        return "Y".equalsIgnoreCase(debugFlag);
    }
}
