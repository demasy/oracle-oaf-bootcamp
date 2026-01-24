package oracle.apps.xxcust.oaf.codebrain.profileoptions;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.common.VersionInfo;

/**
 * Profile Option Patterns
 * 
 * Profile options control application behavior at various levels:
 * - Site: Applies to entire installation
 * - Application: Specific application
 * - Responsibility: Per responsibility
 * - User: Per user
 * 
 * Common OAF Profile Options:
 * - FND_Diagnostics: Enable diagnostic logging
 * - Personalize Self-Service Defn: Enable personalization
 * - FND: Personalization Region Link Enabled: Show personalize links
 * - Disable Self-Service Personalization: Disable all personalization
 * - FND: Personalization Document Root Path: Import/export directory
 * 
 * Source: OAF Reference - By Mostafa EL-Ruby.docx
 * Category: Configuration - Core
 * Complexity: Beginner to Intermediate
 * 
 * @author OAF Code Brain
 * @version 1.0
 */
public class ProfileOptionPatterns extends OAApplicationModuleImpl {

    /**
     * USE CASE 1: Read Profile Option Value (Controller)
     * 
     * Get profile option value from page context.
     * Returns value based on hierarchy: User > Resp > App > Site
     * 
     * When to use:
     * - Need profile value in controller
     * - Conditional behavior based on setting
     * - User preferences
     * - Security/feature flags
     * 
     * Best Practice:
     * - Cache if used multiple times
     * - Check for null (may not be set)
     * - Document which profiles are used
     * - Use profile options for configuration
     * 
     * Common Mistakes:
     * - Wrong profile name
     * - Not handling null
     * - Repeated calls (inefficient)
     * - Hardcoding values instead
     * 
     * @param pageContext Current page context
     * @param profileName Internal profile name
     */
    public String getProfileValue(OAPageContext pageContext, String profileName) {
        // Get profile value using page context
        String profileValue = pageContext.getProfile(profileName);
        
        if (profileValue != null) {
            System.out.println("Profile " + profileName + " = " + profileValue);
        } else {
            System.out.println("Profile " + profileName + " not set");
        }
        
        return profileValue;
    }

    /**
     * USE CASE 2: Read Profile Option Value (Application Module)
     * 
     * Get profile value from AM using transaction object.
     * 
     * When to use:
     * - Need profile in AM method
     * - Business logic configuration
     * - Validation rules
     * - Data processing flags
     * 
     * Best Practice:
     * - Same as controller pattern
     * - Use for business logic decisions
     * - Document dependencies
     * 
     * Common Mistakes:
     * - Same as controller pattern
     * 
     * @param profileName Internal profile name
     */
    public String getProfileValueInAM(String profileName) {
        // Get transaction from AM
        OADBTransaction txn = getOADBTransaction();
        
        // Get profile value
        String profileValue = txn.getProfile(profileName);
        
        if (profileValue != null) {
            System.out.println("Profile " + profileName + " = " + profileValue);
        } else {
            System.out.println("Profile " + profileName + " not set");
        }
        
        return profileValue;
    }

    /**
     * USE CASE 3: FND_Diagnostics Profile
     * 
     * Enable diagnostic logging for troubleshooting.
     * 
     * When to use:
     * - Development/debugging
     * - Production troubleshooting
     * - Performance analysis
     * - Support investigations
     * 
     * Best Practice:
     * - Set at User level for specific testing
     * - Disable when not needed (performance)
     * - Use writeDiagnostics in code
     * - Set to "Y" to enable
     * 
     * Common Mistakes:
     * - Leaving enabled in production (performance)
     * - Not checking if enabled before logging
     * - Too much diagnostic output
     * - Not using structured logging
     */
    public void useFNDDiagnostics(OAPageContext pageContext) {
        // Check if diagnostics enabled
        String diagnostics = pageContext.getProfile("FND_DIAGNOSTICS");
        
        if ("Y".equalsIgnoreCase(diagnostics)) {
            // Diagnostics enabled
            System.out.println("Diagnostics enabled");
            
            // Write diagnostic messages in controller
            pageContext.writeDiagnostics(this, 
                "This is a diagnostic message from controller", 
                OAFwkConstants.STATEMENT);
            
            // In Application Module:
            // getOADBTransaction().writeDiagnostics(this,
            //     "This is a diagnostic message from AM",
            //     OAFwkConstants.STATEMENT);
            
            // Diagnostic levels:
            // OAFwkConstants.STATEMENT = 1 (most detailed)
            // OAFwkConstants.PROCEDURE = 2
            // OAFwkConstants.EVENT = 3
            // OAFwkConstants.EXCEPTION = 4 (least detailed)
        } else {
            System.out.println("Diagnostics disabled");
        }
    }

    /**
     * USE CASE 4: Write Diagnostics in Controller
     * 
     * Proper way to add diagnostic logging in controller code.
     * 
     * When to use:
     * - Debugging controller logic
     * - Tracking user actions
     * - Performance monitoring
     * - Support troubleshooting
     * 
     * Best Practice:
     * - Check diagnostics profile first (optional)
     * - Use appropriate level
     * - Include context information
     * - Don't log sensitive data
     * 
     * Common Mistakes:
     * - Excessive logging
     * - Wrong log level
     * - Missing context
     * - Logging passwords/credit cards
     * 
     * @param pageContext Current page context
     */
    public void writeDiagnosticsInController(OAPageContext pageContext) {
        // Framework checks FND_DIAGNOSTICS automatically
        // No need to check manually unless you want to avoid
        // string concatenation overhead
        
        // Log at different levels
        pageContext.writeDiagnostics(this, 
            "Entering processRequest method", 
            1); // STATEMENT level
        
        pageContext.writeDiagnostics(this,
            "Processing user action: " + pageContext.getParameter(EVENT_PARAM),
            2); // PROCEDURE level
        
        pageContext.writeDiagnostics(this,
            "Button clicked: Apply",
            3); // EVENT level
    }

    /**
     * USE CASE 5: Write Diagnostics in Application Module
     * 
     * Proper way to add diagnostic logging in AM code.
     * 
     * When to use:
     * - Debugging business logic
     * - SQL execution tracking
     * - Performance analysis
     * - Complex calculations
     * 
     * Best Practice:
     * - Same as controller
     * - Log SQL parameters
     * - Log method entry/exit
     * - Log business rule results
     * 
     * Common Mistakes:
     * - Same as controller
     */
    public void writeDiagnosticsInAM() {
        OADBTransaction txn = getOADBTransaction();
        
        // Log method entry
        txn.writeDiagnostics(this,
            "Entering createSupplierRecord method",
            1);
        
        // Log SQL execution
        txn.writeDiagnostics(this,
            "Executing query on SuppliersVO with param: 12345",
            1);
        
        // Log business logic
        txn.writeDiagnostics(this,
            "Validation passed for supplier",
            2);
        
        // Log method exit
        txn.writeDiagnostics(this,
            "Exiting createSupplierRecord - success",
            1);
    }

    /**
     * USE CASE 6: Personalize Self-Service Defn Profile
     * 
     * Enable/disable personalization functionality.
     * 
     * When to use:
     * - Control who can personalize
     * - Development vs production settings
     * - Security controls
     * 
     * Best Practice:
     * - Enable for admins/developers
     * - Disable in production (usually)
     * - Set at User/Resp level
     * - Document who can personalize
     * 
     * Common Mistakes:
     * - Leaving enabled for all users
     * - Not controlling personalization access
     * - Confusion with region link profile
     */
    public void checkPersonalizationEnabled(OAPageContext pageContext) {
        String personalize = pageContext.getProfile("PERSONALIZE_SELFSERVICE_DEFN");
        
        if ("Y".equalsIgnoreCase(personalize)) {
            System.out.println("Personalization enabled for this user");
            // User can access Personalize page
        } else {
            System.out.println("Personalization disabled");
            // Personalize links won't work even if visible
        }
    }

    /**
     * USE CASE 7: FND: Personalization Region Link Enabled Profile
     * 
     * Show/hide "Personalize Region" links on pages.
     * 
     * When to use:
     * - Control link visibility
     * - Development vs production
     * - User experience customization
     * 
     * Best Practice:
     * - Set to Yes for developers
     * - Set to No for end users
     * - Works with Personalize Self-Service Defn
     * - Links appear above each region
     * 
     * Common Mistakes:
     * - Showing links when personalization disabled
     * - Not setting for developers
     * - Confusing with main personalize profile
     */
    public void checkRegionLinkEnabled(OAPageContext pageContext) {
        String regionLink = 
            pageContext.getProfile("FND_PERSONALIZATION_REGION_LINK_ENABLED");
        
        if ("Y".equalsIgnoreCase(regionLink)) {
            System.out.println("Personalize Region links will be visible");
            // Links appear above regions (if personalization enabled)
        } else {
            System.out.println("Personalize Region links hidden");
            // Links not visible (cleaner UI for end users)
        }
    }

    /**
     * USE CASE 8: Disable Self-Service Personalization Profile
     * 
     * Master switch to disable all personalization.
     * 
     * When to use:
     * - Lock down production system
     * - Emergency disable
     * - Troubleshooting personalization issues
     * 
     * Best Practice:
     * - Set at Site level for complete lockdown
     * - Document why disabled
     * - Test changes before re-enabling
     * - Overrides other personalization profiles
     * 
     * Common Mistakes:
     * - Forgetting it's disabled
     * - Not documenting decision
     * - Wrong level of setting
     */
    public void checkPersonalizationDisabled(OAPageContext pageContext) {
        String disabled = 
            pageContext.getProfile("DISABLE_SELF_SERVICE_PERSONAL");
        
        if ("Yes".equalsIgnoreCase(disabled)) {
            System.out.println("All personalization DISABLED");
            // No personalization will work
            // Overrides other settings
        } else {
            System.out.println("Personalization controls active");
            // Other personalization profiles apply
        }
    }

    /**
     * USE CASE 9: FND: Personalization Document Root Path Profile
     * 
     * Directory for personalization import/export files.
     * 
     * When to use:
     * - Setting up personalization migration
     * - Import/export operations
     * - Development to production moves
     * 
     * Best Practice:
     * - Set at Site level
     * - Use server directory path
     * - Ensure proper permissions
     * - Document directory structure
     * 
     * Common Mistakes:
     * - Wrong directory path
     * - Permission issues
     * - Not set (import/export fails)
     * - Different paths per environment
     */
    public void getPersonalizationRootPath(OAPageContext pageContext) {
        String rootPath = 
            pageContext.getProfile("FND_PERSONALIZATION_DOC_ROOT_PATH");
        
        if (rootPath != null && rootPath.length() > 0) {
            System.out.println("Personalization root path: " + rootPath);
            // Use this path for import/export
            // Example: /u01/oracle/apps/personalizations
        } else {
            System.out.println("Personalization root path not set");
            // Import/export may not work
        }
    }

    /**
     * USE CASE 10: Create Custom Profile Option
     * 
     * Steps to create your own profile option.
     * 
     * When to use:
     * - Custom configuration needs
     * - User preferences
     * - Feature flags
     * - Environment-specific settings
     * 
     * Best Practice:
     * - Use XX prefix for custom profiles
     * - Document purpose clearly
     * - Set appropriate levels (Site/Resp/User)
     * - Provide validation if needed
     * 
     * Common Mistakes:
     * - Not using XX prefix
     * - Wrong internal name
     * - Missing documentation
     * - Incorrect hierarchy levels
     */
    public void createCustomProfileExample() {
        String steps =
            "Creating Custom Profile Option:\n" +
            "================================\n" +
            "\n" +
            "1. Navigate:\n" +
            "   System Administrator > Profile > System\n" +
            "\n" +
            "2. Create New Profile:\n" +
            "   Profile: XXCUST_ENABLE_FEATURE\n" +
            "   User Profile Name: XXCUST: Enable Custom Feature\n" +
            "   Description: Enables custom feature XYZ\n" +
            "\n" +
            "3. Set Levels:\n" +
            "   [√] Site\n" +
            "   [√] Responsibility  \n" +
            "   [√] User\n" +
            "   [ ] Server (if needed)\n" +
            "\n" +
            "4. Set Values (optional):\n" +
            "   Validation: None (or select value set)\n" +
            "   Default Value: N\n" +
            "\n" +
            "5. Save\n" +
            "\n" +
            "6. Set Values:\n" +
            "   System Administrator > Profile > System Values\n" +
            "   Profile: XXCUST: Enable Custom Feature\n" +
            "   Level: Site, Value: Y\n" +
            "\n" +
            "7. Use in Code:\n" +
            "   String enabled = pageContext.getProfile(\"XXCUST_ENABLE_FEATURE\");\n" +
            "   if (\"Y\".equalsIgnoreCase(enabled)) {\n" +
            "       // Feature enabled\n" +
            "   }\n" +
            "\n" +
            "Best Practices:\n" +
            "- Internal name: XXCUST_PROFILE_NAME\n" +
            "- User name: XXCUST: User Friendly Name\n" +
            "- Document in design docs\n" +
            "- Test hierarchy (User overrides Resp overrides Site)\n" +
            "- Consider value set for validation";
        
        System.out.println(steps);
    }

    /**
     * USE CASE 11: Profile Option Hierarchy
     * 
     * Understanding how profile values are resolved.
     * 
     * When to use:
     * - Setting profile values
     * - Troubleshooting profile issues
     * - Understanding effective value
     * 
     * Best Practice:
     * - User level highest priority
     * - Site level lowest priority
     * - Document which level to use
     * - Test priority behavior
     * 
     * Common Mistakes:
     * - Wrong level set
     * - Not understanding priority
     * - Conflicting values
     */
    public void understandProfileHierarchy() {
        String hierarchy =
            "Profile Option Hierarchy:\n" +
            "=========================\n" +
            "\n" +
            "Priority (Highest to Lowest):\n" +
            "1. User Level\n" +
            "   - Specific to one user\n" +
            "   - Overrides all other levels\n" +
            "   - Example: User 12345 = 'Y'\n" +
            "\n" +
            "2. Responsibility Level\n" +
            "   - Specific to responsibility\n" +
            "   - Overrides Application and Site\n" +
            "   - Example: System Administrator = 'Y'\n" +
            "\n" +
            "3. Application Level\n" +
            "   - Specific to application\n" +
            "   - Overrides Site\n" +
            "   - Example: Application Object Library = 'Y'\n" +
            "\n" +
            "4. Site Level\n" +
            "   - Applies to entire installation\n" +
            "   - Default for all users\n" +
            "   - Example: Site = 'N'\n" +
            "\n" +
            "Resolution Example:\n" +
            "- Site level = 'N' (default)\n" +
            "- Resp level = 'Y' (for Admin resp)\n" +
            "- User level = 'N' (for User 12345)\n" +
            "\n" +
            "Result:\n" +
            "- Regular user: 'N' (Site level)\n" +
            "- Admin user (not 12345): 'Y' (Resp level)\n" +
            "- User 12345 with Admin: 'N' (User level wins)\n" +
            "\n" +
            "Best Practices:\n" +
            "- Set Site level for defaults\n" +
            "- Set Resp level for role-based\n" +
            "- Set User level for exceptions\n" +
            "- Document your strategy\n" +
            "- Test with different users";
        
        System.out.println(hierarchy);
    }

    /**
     * USE CASE 12: Common Profile Options Reference
     * 
     * Quick reference for commonly used OAF profiles.
     */
    public void commonProfilesReference() {
        String reference =
            "Common OAF Profile Options:\n" +
            "===========================\n" +
            "\n" +
            "1. FND_DIAGNOSTICS\n" +
            "   Purpose: Enable diagnostic logging\n" +
            "   Values: Y/N\n" +
            "   Usage: Debugging, troubleshooting\n" +
            "   Default: N\n" +
            "\n" +
            "2. PERSONALIZE_SELFSERVICE_DEFN\n" +
            "   Purpose: Allow personalization\n" +
            "   Values: Y/N\n" +
            "   Usage: Control who can personalize\n" +
            "   Default: N\n" +
            "\n" +
            "3. FND_PERSONALIZATION_REGION_LINK_ENABLED\n" +
            "   Purpose: Show personalize region links\n" +
            "   Values: Y/N\n" +
            "   Usage: Developer convenience\n" +
            "   Default: N\n" +
            "\n" +
            "4. DISABLE_SELF_SERVICE_PERSONAL\n" +
            "   Purpose: Master disable for personalization\n" +
            "   Values: Yes/No\n" +
            "   Usage: Emergency lockdown\n" +
            "   Default: No\n" +
            "\n" +
            "5. FND_PERSONALIZATION_DOC_ROOT_PATH\n" +
            "   Purpose: Import/export directory\n" +
            "   Values: Directory path\n" +
            "   Usage: Personalization migration\n" +
            "   Default: Not set\n" +
            "\n" +
            "6. ICX: Limit Time\n" +
            "   Purpose: Max session length\n" +
            "   Values: Hours\n" +
            "   Usage: Session management\n" +
            "   Default: Varies\n" +
            "\n" +
            "7. ICX: Session Timeout\n" +
            "   Purpose: Max idle time\n" +
            "   Values: Minutes\n" +
            "   Usage: Session timeout\n" +
            "   Default: 30\n" +
            "\n" +
            "8. ICX: Language\n" +
            "   Purpose: User language\n" +
            "   Values: Language code\n" +
            "   Usage: Localization\n" +
            "   Default: American English\n" +
            "\n" +
            "9. ICX: Date Format Mask\n" +
            "   Purpose: Date display format\n" +
            "   Values: Format mask\n" +
            "   Usage: Regional formatting\n" +
            "   Default: DD-MON-YYYY\n" +
            "\n" +
            "10. FND: View Object Max Fetch Size\n" +
            "    Purpose: VO query row limit\n" +
            "    Values: Number\n" +
            "    Usage: Performance tuning\n" +
            "    Default: 100";
        
        System.out.println(reference);
    }

    /**
     * USE CASE 13: Profile Options Best Practices
     * 
     * Comprehensive guidelines for using profile options.
     */
    public void profileOptionsBestPractices() {
        String practices =
            "Profile Options Best Practices:\n" +
            "================================\n" +
            "\n" +
            "Reading Profiles:\n" +
            "- Cache if used multiple times\n" +
            "- Check for null\n" +
            "- Use correct method (pageContext vs transaction)\n" +
            "- Document dependencies\n" +
            "\n" +
            "Creating Custom Profiles:\n" +
            "- Use XX prefix\n" +
            "- Clear, descriptive names\n" +
            "- Set appropriate levels\n" +
            "- Provide good defaults\n" +
            "- Document thoroughly\n" +
            "\n" +
            "Setting Values:\n" +
            "- Use lowest level possible\n" +
            "- Site for defaults\n" +
            "- Resp for role-based\n" +
            "- User for exceptions\n" +
            "- Document strategy\n" +
            "\n" +
            "Diagnostics:\n" +
            "- Enable only when needed\n" +
            "- Use at User level for testing\n" +
            "- Disable in production\n" +
            "- Include context in messages\n" +
            "\n" +
            "Personalization:\n" +
            "- Control access carefully\n" +
            "- Enable for admins/developers\n" +
            "- Disable for end users\n" +
            "- Test in non-production first\n" +
            "\n" +
            "Performance:\n" +
            "- Don't query profiles repeatedly\n" +
            "- Cache when appropriate\n" +
            "- Use for configuration not data\n" +
            "- Consider impact of lookups\n" +
            "\n" +
            "Security:\n" +
            "- Control sensitive profiles\n" +
            "- Audit profile changes\n" +
            "- Document security implications\n" +
            "- Test access controls\n" +
            "\n" +
            "Testing:\n" +
            "- Test all hierarchy levels\n" +
            "- Test null/not set cases\n" +
            "- Test with different users\n" +
            "- Verify effective values";
        
        System.out.println(practices);
    }
}
