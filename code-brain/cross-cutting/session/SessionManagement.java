package oracle.apps.xxcust.oaf.codebrain.session;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBean;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.common.WebAppsContext;
import javax.servlet.http.HttpSession;

/**
 * Session Management Patterns
 * 
 * Understanding and working with different session types in OAF:
 * - JVM Cache: Shared across all HTTP sessions in same JVM
 * - HTTP/Servlet Session: Browser session, configurable timeout
 * - ICX Session (Oracle Apps Session): Longer-lived, tied to user login
 * 
 * Key Concepts:
 * - JVM cache is shared and persistent until server restart
 * - HTTP session times out based on web server settings
 * - ICX session has separate timeout from HTTP session
 * - ICX session can survive HTTP session timeout
 * 
 * Source: OAF Reference - By Mostafa EL-Ruby.docx
 * Category: Infrastructure - Core
 * Complexity: Intermediate to Advanced
 * 
 * @author OAF Code Brain
 * @version 1.0
 */
public class SessionManagement extends OAApplicationModuleImpl {

    /**
     * USE CASE 1: Access HTTP/Servlet Session
     * 
     * Get the browser session object for storing temporary data.
     * 
     * When to use:
     * - Storing user-specific data across requests
     * - Shopping cart scenarios
     * - Temporary workflow data
     * 
     * Best Practice:
     * - Keep session data minimal
     * - Clean up when no longer needed
     * - Don't store large objects
     * - Session times out automatically
     * 
     * Common Mistakes:
     * - Storing too much data (memory issues)
     * - Not cleaning up (memory leak)
     * - Expecting session to last forever
     * - Not handling session timeout
     * 
     * @param pageContext Current page context
     */
    public void accessHttpSession(OAPageContext pageContext) {
        // Get HTTP session from page context
        HttpSession httpSession = pageContext.getHttpSession();
        
        if (httpSession != null) {
            // Session exists
            System.out.println("HTTP Session ID: " + httpSession.getId());
            System.out.println("Creation Time: " + 
                             new java.util.Date(httpSession.getCreationTime()));
            System.out.println("Last Accessed: " + 
                             new java.util.Date(httpSession.getLastAccessedTime()));
            System.out.println("Max Inactive Interval: " + 
                             httpSession.getMaxInactiveInterval() + " seconds");
            
            // Store data in session
            httpSession.setAttribute("userPreference", "someValue");
            
            // Retrieve data from session
            String value = (String) httpSession.getAttribute("userPreference");
            System.out.println("Retrieved value: " + value);
            
            // Remove data when no longer needed
            // httpSession.removeAttribute("userPreference");
        }
    }

    /**
     * USE CASE 2: Access ICX Session (Oracle Apps Session)
     * 
     * Get Oracle Applications user session context.
     * Contains user, responsibility, org context, etc.
     * 
     * When to use:
     * - Need user ID, responsibility
     * - Organization context
     * - Security context
     * - Profile option values
     * 
     * Best Practice:
     * - ICX session longer-lived than HTTP session
     * - Don't modify ICX session directly
     * - Use profile options for user preferences
     * - Understand session timeout settings
     * 
     * Common Mistakes:
     * - Confusing with HTTP session
     * - Not understanding timeout difference
     * - Assuming always available
     * - Direct modification attempts
     * 
     * @param pageContext Current page context
     */
    public void accessICXSession(OAPageContext pageContext) {
        // Get WebAppsContext (ICX session)
        WebAppsContext webAppsCtx = pageContext.getWebAppsContext();
        
        if (webAppsCtx != null) {
            // Get user information
            String userName = webAppsCtx.getUserName();
            Number userId = webAppsCtx.getUserId();
            Number responsibilityId = webAppsCtx.getResponsibilityId();
            String responsibilityName = webAppsCtx.getResponsibilityName();
            
            System.out.println("ICX Session Information:");
            System.out.println("  User: " + userName + " (ID: " + userId + ")");
            System.out.println("  Responsibility: " + responsibilityName + 
                             " (ID: " + responsibilityId + ")");
            
            // Get organization context
            Number orgId = webAppsCtx.getOrgId();
            System.out.println("  Org ID: " + orgId);
            
            // Get session ID (primary key in ICX_SESSIONS table)
            Number sessionId = webAppsCtx.getSessionId();
            System.out.println("  Session ID: " + sessionId);
            
            // Get language code
            String langCode = webAppsCtx.getLanguageCode();
            System.out.println("  Language: " + langCode);
        }
    }

    /**
     * USE CASE 3: Understanding Session Timeouts
     * 
     * ICX Session vs HTTP Session timeout behavior.
     * 
     * Profile Options:
     * - ICX: Limit Time - Maximum session length in hours
     * - ICX: Session Timeout - Maximum idle time in minutes
     * - Apache JServ Session Timeout - HTTP session timeout in milliseconds
     * 
     * When to use:
     * - Configuring session timeouts
     * - Troubleshooting timeout issues
     * - Understanding session lifecycle
     * 
     * Best Practice:
     * - Sync ICX and JServ timeouts (Oracle recommendation)
     * - Default JServ: 30 minutes (1800000 ms)
     * - Don't set JServ > 30 minutes (JVM memory)
     * - Implement passivation for long transactions
     * 
     * Common Mistakes:
     * - Mismatched timeouts (confusing UX)
     * - Too long JServ timeout (memory issues)
     * - Not handling session expiry
     * - Expecting transaction to survive timeout
     */
    public void understandSessionTimeouts() {
        String explanation =
            "Session Timeout Behavior:\n" +
            "========================\n" +
            "\n" +
            "Scenario 1: HTTP Session Times Out First\n" +
            "- User idle beyond JServ timeout (default 30 min)\n" +
            "- HTTP session destroyed\n" +
            "- ICX session still valid\n" +
            "- User sees login page\n" +
            "- After login, can resume (if ICX not expired)\n" +
            "- Middle-tier state lost, must re-query\n" +
            "\n" +
            "Scenario 2: ICX Session Times Out First\n" +
            "- User idle beyond ICX timeout\n" +
            "- ICX session invalidated\n" +
            "- HTTP session may still be valid\n" +
            "- User sees login page\n" +
            "- Transaction context lost\n" +
            "\n" +
            "Scenario 3: Both Time Out\n" +
            "- User idle beyond both timeouts\n" +
            "- Complete session loss\n" +
            "- User must login\n" +
            "- All state lost\n" +
            "\n" +
            "Best Practice:\n" +
            "- Set ICX: Session Timeout = Apache JServ timeout\n" +
            "- Default both to 30 minutes\n" +
            "- Warn users before timeout\n" +
            "- Save work frequently\n" +
            "- Implement auto-save for long forms\n" +
            "\n" +
            "Configuration:\n" +
            "- Profile: ICX: Session Timeout (minutes)\n" +
            "- File: $IAS_ORACLE_HOME/Apache/Jserv/etc/zone.properties\n" +
            "- Property: session.timeout=1800000 (30 min in ms)\n" +
            "- Restart Apache after changes";
        
        System.out.println(explanation);
    }

    /**
     * USE CASE 4: Get ICX Session Information from Database
     * 
     * Query ICX_SESSIONS table for session details.
     * 
     * When to use:
     * - Monitoring active sessions
     * - Support/troubleshooting
     * - Security auditing
     * - Session cleanup
     * 
     * Best Practice:
     * - Use views not direct table
     * - Filter by session ID or user
     * - Check disabled_flag
     * - Monitor session counts
     * 
     * Common Mistakes:
     * - Deleting active sessions
     * - Not checking disabled_flag
     * - Missing session cleanup
     * - Direct table modification
     */
    public void queryICXSession(OAPageContext pageContext) {
        // Get current session ID
        Number sessionId = pageContext.getSessionId();
        
        String sql =
            "SELECT session_id, user_id, responsibility_id, " +
            "       org_id, disabled_flag, created, last_access, " +
            "       time_out, pseudo_flag " +
            "FROM icx_sessions " +
            "WHERE session_id = :1 " +
            "  AND disabled_flag = 'N'";
        
        // Execute query using JDBC
        // Result shows session details from database
        
        System.out.println("Query ICX_SESSIONS for session: " + sessionId);
        System.out.println("SQL: " + sql);
        
        // In production code:
        // OAViewObject vo = (OAViewObject) findViewObject("SessionVO");
        // vo.setWhereClause("session_id = :1");
        // vo.setWhereClauseParam(0, sessionId);
        // vo.executeQuery();
    }

    /**
     * USE CASE 5: Store Data in HTTP Session
     * 
     * Properly store and retrieve data from HTTP session.
     * 
     * When to use:
     * - Multi-step wizards
     * - Shopping cart
     * - Temporary user preferences
     * - Cross-page data
     * 
     * Best Practice:
     * - Use serializable objects
     * - Namespace your keys
     * - Clean up after use
     * - Document session attributes
     * - Keep data size minimal
     * 
     * Common Mistakes:
     * - Storing non-serializable objects
     * - Key naming conflicts
     * - Memory leaks (not cleaning up)
     * - Storing too much data
     */
    public void storeDataInSession(OAPageContext pageContext) {
        HttpSession session = pageContext.getHttpSession();
        
        // Store simple data
        session.setAttribute("xxcust.wizard.step", Integer.valueOf(2));
        session.setAttribute("xxcust.wizard.data", "some value");
        
        // Store complex data (must be serializable)
        java.util.HashMap wizardData = new java.util.HashMap();
        wizardData.put("field1", "value1");
        wizardData.put("field2", "value2");
        session.setAttribute("xxcust.wizard.allData", wizardData);
        
        // Retrieve data
        Integer step = (Integer) session.getAttribute("xxcust.wizard.step");
        String data = (String) session.getAttribute("xxcust.wizard.data");
        
        System.out.println("Current wizard step: " + step);
        System.out.println("Wizard data: " + data);
        
        // Clean up when done (e.g., wizard completion)
        // session.removeAttribute("xxcust.wizard.step");
        // session.removeAttribute("xxcust.wizard.data");
        // session.removeAttribute("xxcust.wizard.allData");
    }

    /**
     * USE CASE 6: Understand JVM Cache Behavior
     * 
     * JVM cache is shared across all sessions.
     * 
     * When to use:
     * - Understanding cache scope
     * - Singleton patterns
     * - Application-level caching
     * - Performance optimization
     * 
     * Best Practice:
     * - JVM cache survives session timeouts
     * - Cleared only by bounce or code
     * - Use for application-wide data
     * - Thread-safe implementation required
     * 
     * Common Mistakes:
     * - Thinking cache is per-session
     * - Not thread-safe implementation
     * - Excessive caching (memory)
     * - Not invalidating when needed
     */
    public void understandJVMCache() {
        String explanation =
            "JVM Cache Characteristics:\n" +
            "=========================\n" +
            "\n" +
            "Scope:\n" +
            "- Shared across ALL HTTP sessions\n" +
            "- Shared across ALL ICX sessions\n" +
            "- Per JVM instance (multiple JVMs if clustered)\n" +
            "- Survives session timeouts\n" +
            "- Cleared only by:\n" +
            "  * Apache/JVM restart\n" +
            "  * Explicit programmatic invalidation\n" +
            "  * Functional Admin > Invalidate Cache\n" +
            "\n" +
            "Common Uses:\n" +
            "- MDS page definitions (cached after first load)\n" +
            "- Profile option values\n" +
            "- Lookup values\n" +
            "- Application-level configuration\n" +
            "- Singleton objects\n" +
            "\n" +
            "Implications:\n" +
            "- First user loads data into cache\n" +
            "- All subsequent users see cached data\n" +
            "- Changes require cache invalidation\n" +
            "- Memory usage accumulates\n" +
            "- Thread safety critical\n" +
            "\n" +
            "Best Practices:\n" +
            "- Cache read-only/infrequent-change data\n" +
            "- Implement cache invalidation strategy\n" +
            "- Monitor memory usage\n" +
            "- Use weak references for large objects\n" +
            "- Document cached items\n" +
            "\n" +
            "Example Cached Items:\n" +
            "- Page layout definitions (MDS)\n" +
            "- User session context\n" +
            "- Profile option values\n" +
            "- Application properties\n" +
            "- Static reference data";
        
        System.out.println(explanation);
    }

    /**
     * USE CASE 7: Get Session Values from Page Context
     * 
     * Quick access to common session values.
     * 
     * When to use:
     * - Need user context quickly
     * - Security checks
     * - Audit logging
     * - Business logic
     * 
     * Best Practice:
     * - Use pageContext methods
     * - Cache if used multiple times
     * - Check for null
     * - Log for troubleshooting
     * 
     * Common Mistakes:
     * - Repeated calls (inefficient)
     * - Not checking null
     * - Wrong method for data needed
     */
    public void getSessionValues(OAPageContext pageContext) {
        // User information
        String userName = pageContext.getUserName();
        Number userId = pageContext.getUserId();
        
        // Responsibility
        Number respId = pageContext.getResponsibilityId();
        String respName = pageContext.getResponsibilityName();
        
        // Organization
        Number orgId = pageContext.getOrgId();
        
        // Session
        Number sessionId = pageContext.getSessionId();
        
        // Language
        String language = pageContext.getLanguageCode();
        
        // Profile options (more in ProfileOptions class)
        String diagnostics = pageContext.getProfile("FND_DIAGNOSTICS");
        
        System.out.println("Session Values:");
        System.out.println("  User: " + userName + " (ID: " + userId + ")");
        System.out.println("  Responsibility: " + respName + " (ID: " + respId + ")");
        System.out.println("  Org: " + orgId);
        System.out.println("  Session: " + sessionId);
        System.out.println("  Language: " + language);
        System.out.println("  Diagnostics: " + diagnostics);
    }

    /**
     * USE CASE 8: Session State vs Database State
     * 
     * Understanding difference between cached and persisted data.
     * 
     * When to use:
     * - Transaction design
     * - Understanding data flow
     * - Troubleshooting data issues
     * 
     * Best Practice:
     * - Commit to persist
     * - Rollback to discard
     * - Understand cache scope
     * - Test session timeout scenarios
     * 
     * Common Mistakes:
     * - Thinking cached = saved
     * - Not committing changes
     * - Expecting data after timeout
     * - Not handling rollback
     */
    public void understandSessionVsDBState() {
        String explanation =
            "Session State vs Database State:\n" +
            "================================\n" +
            "\n" +
            "Entity Object Cache (Session State):\n" +
            "- Changes stored in memory\n" +
            "- View objects query populates cache\n" +
            "- User edits modify cache\n" +
            "- Validation runs on cache\n" +
            "- NOT persisted until commit\n" +
            "- Lost on session timeout\n" +
            "- Visible within same root AM\n" +
            "\n" +
            "Database State:\n" +
            "- Data in database tables\n" +
            "- Persisted and permanent\n" +
            "- Survives session timeouts\n" +
            "- Visible to all users (after commit)\n" +
            "- Subject to database locks\n" +
            "\n" +
            "Workflow:\n" +
            "1. Query: DB → EO Cache\n" +
            "2. Edit: Cache modified\n" +
            "3. Validate: Cache validated\n" +
            "4. Commit: Cache → DB\n" +
            "5. Rollback: Cache discarded\n" +
            "\n" +
            "Common Scenarios:\n" +
            "- User enters data (cache only)\n" +
            "- User clicks Save (validation)\n" +
            "- Commit issued (DB updated)\n" +
            "- Session timeout before commit (lost)\n" +
            "- Another user queries (sees old until commit)\n" +
            "\n" +
            "Best Practices:\n" +
            "- Commit frequently in long transactions\n" +
            "- Save user work periodically\n" +
            "- Implement auto-save\n" +
            "- Warn before timeout\n" +
            "- Test timeout scenarios";
        
        System.out.println(explanation);
    }

    /**
     * USE CASE 9: Invalidate HTTP Session Programmatically
     * 
     * Force session invalidation for security or cleanup.
     * 
     * When to use:
     * - User logout
     * - Security violations
     * - Force re-authentication
     * - Cleanup after operation
     * 
     * Best Practice:
     * - Redirect after invalidation
     * - Clean up resources first
     * - Log the action
     * - Don't access session after
     * 
     * Common Mistakes:
     * - Not redirecting
     * - Accessing session after invalidation
     * - Not cleaning up resources
     * - Forgetting to log
     */
    public void invalidateSession(OAPageContext pageContext) {
        HttpSession session = pageContext.getHttpSession();
        
        if (session != null) {
            // Clean up any session attributes first
            // session.removeAttribute("xxcust.tempData");
            
            // Log the action
            System.out.println("Invalidating session: " + session.getId());
            
            // Invalidate session
            session.invalidate();
            
            // Redirect to login or home page
            // pageContext.forwardImmediately(
            //     "OA.jsp?page=/oracle/apps/fnd/framework/navigate/webui/HomePG",
            //     null,
            //     OAWebBeanConstants.KEEP_MENU_CONTEXT,
            //     null,
            //     null,
            //     false,
            //     OAWebBeanConstants.ADD_BREAD_CRUMB_NO
            // );
        }
    }

    /**
     * USE CASE 10: Best Practices Summary
     * 
     * Comprehensive guide for session management.
     */
    public void sessionManagementBestPractices() {
        String guide =
            "Session Management Best Practices:\n" +
            "==================================\n" +
            "\n" +
            "1. HTTP Session:\n" +
            "   - Store minimal data\n" +
            "   - Clean up after use\n" +
            "   - Use namespaced keys\n" +
            "   - Handle timeout gracefully\n" +
            "\n" +
            "2. ICX Session:\n" +
            "   - Read context values as needed\n" +
            "   - Don't modify directly\n" +
            "   - Understand timeout settings\n" +
            "   - Sync with HTTP timeout\n" +
            "\n" +
            "3. JVM Cache:\n" +
            "   - Cache expensive operations\n" +
            "   - Implement invalidation\n" +
            "   - Thread-safe access\n" +
            "   - Monitor memory usage\n" +
            "\n" +
            "4. Timeouts:\n" +
            "   - Set ICX = JServ timeout\n" +
            "   - Default: 30 minutes\n" +
            "   - Warn users before expiry\n" +
            "   - Auto-save long transactions\n" +
            "\n" +
            "5. State Management:\n" +
            "   - Commit to persist\n" +
            "   - Understand cache scope\n" +
            "   - Test timeout scenarios\n" +
            "   - Don't rely on session state\n" +
            "\n" +
            "6. Security:\n" +
            "   - Invalidate on logout\n" +
            "   - Verify session validity\n" +
            "   - Log security events\n" +
            "   - Handle hijacking attempts\n" +
            "\n" +
            "7. Performance:\n" +
            "   - Minimize session data\n" +
            "   - Use AM passivation\n" +
            "   - Monitor session counts\n" +
            "   - Clean up expired sessions\n" +
            "\n" +
            "8. Troubleshooting:\n" +
            "   - Log session events\n" +
            "   - Monitor ICX_SESSIONS table\n" +
            "   - Check timeout settings\n" +
            "   - Test with different scenarios";
        
        System.out.println(guide);
    }
}
