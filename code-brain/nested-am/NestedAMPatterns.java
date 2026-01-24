package oracle.apps.xxcust.oaf.codebrain.nestedam;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.jbo.ApplicationModule;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

/**
 * Nested Application Module Patterns
 * 
 * Advanced patterns for working with nested Application Modules in OA Framework.
 * Nested AMs share transaction context with root AM and provide modular business logic.
 * 
 * Source: OAF Reference - By Mostafa EL-Ruby.docx
 * Category: Application Module - Advanced
 * Complexity: Advanced
 * 
 * @author OAF Code Brain
 * @version 1.0
 */
public class NestedAMPatterns extends OAApplicationModuleImpl {

    /**
     * USE CASE 1: Create Root Application Module via JNDI
     * 
     * Root AM provides transaction context for all nested AMs.
     * Created through JNDI lookup and create() call.
     * 
     * When to use:
     * - Programmatically creating AM instances
     * - Testing business logic outside web context
     * - Background jobs requiring transaction context
     * 
     * Best Practice:
     * - Always release AM back to pool when done
     * - Use try-finally to ensure cleanup
     * - Configure environment properly
     * 
     * Common Mistakes:
     * - Not releasing AM (causes pool exhaustion)
     * - Wrong JNDI name (causes lookup failure)
     * - Missing environment configuration
     */
    public ApplicationModule createRootAMViaJNDI() throws Exception {
        // Prepare environment for JNDI lookup
        Hashtable env = new Hashtable();
        
        // Add environment entries
        // In real scenario, configure these properly
        env.put(Context.INITIAL_CONTEXT_FACTORY, 
                "oracle.jbo.common.JboInitialContextFactory");
        
        // Create initial context
        Context ic = new InitialContext(env);
        
        // JNDI name for the application module definition
        // Format: <package>.<AMName>
        String defName = "oracle.apps.fnd.framework.toolbox.tutorial.server.PoSummaryAM";
        
        // Lookup and create AM
        oracle.jbo.ApplicationModuleHome home = 
            (oracle.jbo.ApplicationModuleHome) ic.lookup(defName);
        ApplicationModule rootAM = home.create();
        
        // Use the AM...
        // Don't forget to release when done
        // rootAM.remove();
        
        return rootAM;
    }

    /**
     * USE CASE 2: Create Nested Application Module from Parent AM
     * 
     * Nested AMs are created from parent AM and share transaction context.
     * 
     * When to use:
     * - Modular business logic organization
     * - Reusable business components
     * - Complex pages with multiple data contexts
     * 
     * Best Practice:
     * - Use meaningful instance names
     * - Document nested AM hierarchy
     * - Don't create unnecessary nesting
     * 
     * Common Mistakes:
     * - Creating too many nested AMs (performance)
     * - Not reusing existing instances
     * - Circular dependencies
     */
    public ApplicationModule createNestedAM(ApplicationModule parentAM) {
        // AM definition name
        String amDefName = "oracle.apps.fnd.framework.toolbox.tutorial.server.PoSummaryAM";
        
        // Instance name for the nested AM
        String instanceName = "PoSummaryAM1";
        
        // Create nested AM
        ApplicationModule nestedAM = 
            parentAM.createApplicationModule(instanceName, amDefName);
        
        return nestedAM;
    }

    /**
     * USE CASE 3: Find Nested AM by Instance Name
     * 
     * Retrieve existing nested AM instance by its name.
     * 
     * When to use:
     * - Accessing nested AM created declaratively
     * - Extension/personalization scenarios
     * - Multi-region pages
     * 
     * Best Practice:
     * - Check for null return value
     * - Know the instance name from region properties
     * - Document expected nested AM structure
     * 
     * Common Mistakes:
     * - Wrong instance name
     * - Assuming AM exists without checking
     * - Not handling null case
     */
    public ApplicationModule findNestedAMByName(
            ApplicationModule parentAM, 
            String instanceName) {
        
        // Find nested AM instance
        ApplicationModule nestedAM = parentAM.findApplicationModule(instanceName);
        
        if (nestedAM != null) {
            // AM found, use it
            System.out.println("Found nested AM: " + instanceName);
        } else {
            // AM not found, handle appropriately
            System.out.println("Nested AM not found: " + instanceName);
        }
        
        return nestedAM;
    }

    /**
     * USE CASE 4: List All Nested Application Modules
     * 
     * Get array of all nested AM names for debugging/inspection.
     * Useful for understanding AM hierarchy and troubleshooting.
     * 
     * When to use:
     * - Debugging nested AM issues
     * - Understanding page structure
     * - Documentation/analysis
     * 
     * Best Practice:
     * - Use during development/debugging
     * - Log AM hierarchy for support
     * - Verify expected AMs exist
     * 
     * Common Mistakes:
     * - Using in production code (performance)
     * - Not checking array length
     * - Assuming specific order
     */
    public void listAllNestedAMs(ApplicationModule parentAM) {
        // Get names of all nested AMs
        String[] nestedAMNames = parentAM.getApplicationModuleNames();
        
        System.out.println("Found " + nestedAMNames.length + " nested AMs:");
        
        // Iterate and access each nested AM
        for (int i = 0; i < nestedAMNames.length; i++) {
            String amName = nestedAMNames[i];
            ApplicationModule nestedAM = parentAM.findApplicationModule(amName);
            
            if (nestedAM != null) {
                System.out.println((i + 1) + ". " + amName + 
                                 " [Definition: " + nestedAM.getDefFullName() + "]");
            }
        }
    }

    /**
     * USE CASE 5: Get Root AM from Nested AM (Transaction Access)
     * 
     * From any AM level, get transaction object which always comes from root AM.
     * 
     * When to use:
     * - Commit/rollback from nested AM
     * - Logging/diagnostics
     * - Sequence value generation
     * 
     * Best Practice:
     * - Use getOADBTransaction() consistently
     * - Transaction is shared across all AMs
     * - Commit affects all nested AMs
     * 
     * Common Mistakes:
     * - Thinking nested AMs have separate transactions
     * - Not understanding commit scope
     * - Committing too frequently
     */
    public void accessTransactionFromNestedAM() {
        // From any AM (root or nested), get transaction
        // getOADBTransaction() internally finds root AM
        oracle.apps.fnd.framework.server.OADBTransaction txn = getOADBTransaction();
        
        // Use transaction for various operations
        txn.writeDiagnostics(this, "Accessing transaction from nested AM", 1);
        
        // Get sequence value
        oracle.jbo.domain.Number seqValue = 
            txn.getSequenceValue("FWK_TBX_SUPPLIERS_S");
        
        // Commit (affects all AMs under same root)
        // txn.commit();
    }

    /**
     * USE CASE 6: Find Nested AM with System-Generated Name
     * 
     * When AM Definition is specified without AM Instance,
     * OAF generates instance name automatically.
     * 
     * Generated name format:
     * <RegionCode>_<AppId>_<RegionId>_<AMDefName>
     * 
     * When to use:
     * - Extension of seeded pages
     * - When you don't know instance name
     * - Debugging AM hierarchy
     * 
     * Best Practice:
     * - First try to get AM by definition
     * - Log system-generated names for reference
     * - Prefer explicit instance names in custom code
     * 
     * Common Mistakes:
     * - Hardcoding system-generated names
     * - Not checking if AM already exists
     * - Creating duplicate instances
     */
    public ApplicationModule findNestedAMByDefinition(
            ApplicationModule parentAM,
            String amDefName) {
        
        // First, list all nested AMs to see system-generated names
        String[] nestedAMNames = parentAM.getApplicationModuleNames();
        
        // Search for AM matching the definition
        for (String amName : nestedAMNames) {
            ApplicationModule nestedAM = parentAM.findApplicationModule(amName);
            if (nestedAM != null && 
                nestedAM.getDefFullName().equals(amDefName)) {
                System.out.println("Found nested AM with definition: " + amDefName);
                System.out.println("System-generated instance name: " + amName);
                return nestedAM;
            }
        }
        
        System.out.println("No nested AM found for definition: " + amDefName);
        return null;
    }

    /**
     * USE CASE 7: Get Root AM from Page Context (Controller)
     * 
     * From controller, access root AM of the page.
     * Most common pattern in OAF development.
     * 
     * When to use:
     * - Every controller processRequest/processFormRequest
     * - Accessing page's main business logic
     * - Standard OAF pattern
     * 
     * Best Practice:
     * - Get AM at start of controller method
     * - Cast to specific AM interface/impl if needed
     * - Use AM methods instead of direct VO access
     * 
     * Common Mistakes:
     * - Getting AM multiple times unnecessarily
     * - Not casting to correct type
     * - Bypassing AM to access VOs directly
     */
    public void getRootAMFromController(
            OAPageContext pageContext, 
            OAWebBean webBean) {
        
        // Get root application module
        OAApplicationModuleImpl rootAM = 
            (OAApplicationModuleImpl) pageContext.getApplicationModule(webBean);
        
        // Can also get and cast to specific AM type
        // PoSummaryAMImpl poAM = (PoSummaryAMImpl) pageContext.getRootApplicationModule();
        
        // Now use AM methods
        // rootAM.invokeMethod("someBusinessMethod", params);
    }

    /**
     * USE CASE 8: Access Nested AM from Controller
     * 
     * From controller, navigate to nested AM attached to lower region.
     * 
     * When to use:
     * - Extension scenarios
     * - Accessing region-specific business logic
     * - Complex page hierarchies
     * 
     * Best Practice:
     * - Know the AM hierarchy
     * - Check region properties for AM instance name
     * - Handle null case
     * 
     * Common Mistakes:
     * - Assuming nested AM exists
     * - Wrong instance name
     * - Not checking definition mismatch
     */
    public void accessNestedAMFromController(
            OAPageContext pageContext,
            OAWebBean webBean) {
        
        // First get root AM
        OAApplicationModuleImpl rootAM = 
            (OAApplicationModuleImpl) pageContext.getApplicationModule(webBean);
        
        // Then find nested AM
        // Instance name comes from region's AM Instance property
        String nestedAMInstance = "PoSummaryAM1";
        ApplicationModule nestedAM = 
            rootAM.findApplicationModule(nestedAMInstance);
        
        if (nestedAM != null) {
            // Use nested AM
            // Can invoke methods, access VOs, etc.
            System.out.println("Nested AM found: " + nestedAMInstance);
        } else {
            System.out.println("Nested AM not found: " + nestedAMInstance);
        }
    }

    /**
     * USE CASE 9: Verify Nested AM Definition Match
     * 
     * When both AM Instance and AM Definition are specified,
     * verify they match to avoid runtime exceptions.
     * 
     * When to use:
     * - Extension development
     * - Troubleshooting AM issues
     * - Validation during development
     * 
     * Best Practice:
     * - Always verify in extensions
     * - Log mismatches for support
     * - Fail fast with clear messages
     * 
     * Common Mistakes:
     * - Not validating definition
     * - Generic error messages
     * - Allowing mismatch to propagate
     */
    public boolean verifyNestedAMDefinition(
            ApplicationModule parentAM,
            String instanceName,
            String expectedDefName) {
        
        // Find the nested AM
        ApplicationModule nestedAM = 
            parentAM.findApplicationModule(instanceName);
        
        if (nestedAM == null) {
            System.out.println("ERROR: Nested AM not found: " + instanceName);
            return false;
        }
        
        // Get actual definition
        String actualDefName = nestedAM.getDefFullName();
        
        // Verify match
        if (!actualDefName.equals(expectedDefName)) {
            System.out.println("ERROR: AM definition mismatch!");
            System.out.println("  Instance: " + instanceName);
            System.out.println("  Expected: " + expectedDefName);
            System.out.println("  Actual: " + actualDefName);
            
            // In real code, throw OAException
            // throw new OAException("AM definition mismatch");
            return false;
        }
        
        System.out.println("AM definition verified: " + instanceName);
        return true;
    }

    /**
     * USE CASE 10: Understand Nested AM Transaction Scope
     * 
     * Demonstrates that all nested AMs share same transaction.
     * Changes in one AM are visible to others, commit affects all.
     * 
     * When to use:
     * - Understanding transaction boundaries
     * - Multi-AM coordination
     * - Complex business flows
     * 
     * Best Practice:
     * - Document transaction scope
     * - Coordinate commits carefully
     * - Understand entity cache sharing
     * 
     * Common Mistakes:
     * - Thinking nested AMs have separate transactions
     * - Partial commits (not possible)
     * - Not understanding cache visibility
     */
    public void demonstrateTransactionSharing(ApplicationModule rootAM) {
        // Create/find two nested AMs
        ApplicationModule nestedAM1 = 
            rootAM.findApplicationModule("NestedAM1");
        ApplicationModule nestedAM2 = 
            rootAM.findApplicationModule("NestedAM2");
        
        if (nestedAM1 != null && nestedAM2 != null) {
            // Both share same transaction
            // Changes made through nestedAM1 are visible to nestedAM2
            // Single commit affects both
            
            System.out.println("Both nested AMs share transaction:");
            System.out.println("  Root AM Transaction: " + 
                             rootAM.getDBTransaction().hashCode());
            System.out.println("  Nested AM1 Transaction: " + 
                             nestedAM1.getDBTransaction().hashCode());
            System.out.println("  Nested AM2 Transaction: " + 
                             nestedAM2.getDBTransaction().hashCode());
            
            // All three will have same hashCode
        }
    }

    /**
     * USE CASE 11: Debug Nested AM Hierarchy
     * 
     * Print complete nested AM hierarchy for troubleshooting.
     * 
     * When to use:
     * - Development/debugging
     * - Understanding page structure
     * - Support/troubleshooting
     * 
     * Best Practice:
     * - Use during development
     * - Include in diagnostic logging
     * - Document expected hierarchy
     * 
     * Common Mistakes:
     * - Using in production (performance)
     * - Not removing debug code
     * - Too verbose output
     */
    public void debugAMHierarchy(ApplicationModule rootAM, int level) {
        // Indentation for hierarchy visualization
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        
        // Print current AM
        System.out.println(indent + "AM: " + rootAM.getDefFullName());
        System.out.println(indent + "  Instance: " + 
                         (rootAM.getApplicationModuleName() != null ? 
                          rootAM.getApplicationModuleName() : "ROOT"));
        
        // Get and print nested AMs
        String[] nestedNames = rootAM.getApplicationModuleNames();
        if (nestedNames.length > 0) {
            System.out.println(indent + "  Nested AMs (" + nestedNames.length + "):");
            for (String name : nestedNames) {
                ApplicationModule nested = rootAM.findApplicationModule(name);
                if (nested != null) {
                    debugAMHierarchy(nested, level + 1);
                }
            }
        }
    }
}
