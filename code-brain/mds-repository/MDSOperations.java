package oracle.apps.xxcust.oaf.codebrain.mds;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MDS (Metadata Service) Repository Operations
 * 
 * The MDS repository stores all OAF page definitions, regions, personalizations,
 * and extensions in database tables. Understanding MDS structure is crucial for
 * troubleshooting, reporting, and advanced operations.
 * 
 * MDS Tables:
 * - JDR_PATHS: Document paths and parent-child relationships
 * - JDR_COMPONENTS: Components on pages/regions
 * - JDR_ATTRIBUTES: Attribute values of components
 * - JDR_ATTRIBUTES_TRANS: Translated attribute values
 * 
 * Source: OAF Reference - By Mostafa EL-Ruby.docx
 * Category: Infrastructure - Advanced
 * Complexity: Advanced
 * 
 * @author OAF Code Brain
 * @version 1.0
 */
public class MDSOperations extends OAApplicationModuleImpl {

    /**
     * USE CASE 1: Query Page Hierarchy from JDR_PATHS
     * 
     * Find all pages and their parent-child relationships.
     * 
     * When to use:
     * - Analyzing page structure
     * - Finding all pages for a module
     * - Documentation/reporting
     * 
     * Best Practice:
     * - Use JDR_UTILS package for MDS operations
     * - Cache results if querying frequently
     * - Be aware of personalization layers
     * 
     * Common Mistakes:
     * - Querying too frequently (performance)
     * - Not filtering by relevant criteria
     * - Ignoring personalization context
     */
    public void queryPageHierarchy(String modulePath) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql = 
            "SELECT path_docid, path_name, path_type, " +
            "       parent_docid, comp_docid " +
            "FROM jdr_paths " +
            "WHERE path_name LIKE ? " +
            "ORDER BY path_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, modulePath + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Page Hierarchy for: " + modulePath);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String pathName = rs.getString("path_name");
            String pathType = rs.getString("path_type");
            long pathDocId = rs.getLong("path_docid");
            long parentDocId = rs.getLong("parent_docid");
            
            System.out.println("Path: " + pathName);
            System.out.println("  Type: " + pathType);
            System.out.println("  Doc ID: " + pathDocId);
            System.out.println("  Parent ID: " + parentDocId);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 2: Query Page Components from JDR_COMPONENTS
     * 
     * Find all components (regions, items) on a specific page.
     * 
     * When to use:
     * - Analyzing page structure
     * - Finding specific components
     * - Impact analysis
     * 
     * Best Practice:
     * - Join with JDR_PATHS for context
     * - Filter by path for specific pages
     * - Consider component types
     * 
     * Common Mistakes:
     * - Not understanding component hierarchy
     * - Ignoring component state
     * - Not checking personalization
     */
    public void queryPageComponents(String pagePath) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT p.path_name, c.comp_name, c.comp_class, " +
            "       c.comp_docid, c.comp_seq " +
            "FROM jdr_paths p, jdr_components c " +
            "WHERE p.path_name = ? " +
            "  AND p.path_docid = c.path_docid " +
            "ORDER BY c.comp_seq";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, pagePath);
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Components on page: " + pagePath);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String compName = rs.getString("comp_name");
            String compClass = rs.getString("comp_class");
            int compSeq = rs.getInt("comp_seq");
            
            System.out.println("Component: " + compName);
            System.out.println("  Class: " + compClass);
            System.out.println("  Sequence: " + compSeq);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 3: Query Component Attributes from JDR_ATTRIBUTES
     * 
     * Get all attributes and values for a specific component.
     * 
     * When to use:
     * - Debugging component configuration
     * - Comparing environments
     * - Documentation
     * 
     * Best Practice:
     * - Join all MDS tables for complete picture
     * - Check both base and personalized values
     * - Consider translated attributes
     * 
     * Common Mistakes:
     * - Not checking attribute scope
     * - Ignoring personalization layers
     * - Not handling null values
     */
    public void queryComponentAttributes(String componentName) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT c.comp_name, a.att_name, a.att_value, " +
            "       a.att_scope, a.att_lang " +
            "FROM jdr_components c, jdr_attributes a " +
            "WHERE c.comp_name = ? " +
            "  AND c.comp_docid = a.comp_docid " +
            "ORDER BY a.att_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, componentName);
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Attributes for component: " + componentName);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String attName = rs.getString("att_name");
            String attValue = rs.getString("att_value");
            String attScope = rs.getString("att_scope");
            String attLang = rs.getString("att_lang");
            
            System.out.println("Attribute: " + attName);
            System.out.println("  Value: " + attValue);
            System.out.println("  Scope: " + attScope);
            System.out.println("  Language: " + (attLang != null ? attLang : "N/A"));
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 4: Find All Personalizations for a Page
     * 
     * Query personalized attributes across all layers.
     * 
     * When to use:
     * - Troubleshooting personalization issues
     * - Migration/deployment
     * - Audit/compliance
     * 
     * Best Practice:
     * - Understand personalization layers (Site, Resp, User)
     * - Check effective values
     * - Document personalization strategy
     * 
     * Common Mistakes:
     * - Not considering layer precedence
     * - Missing user-level personalizations
     * - Not checking effective values
     */
    public void findPagePersonalizations(String pagePath) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT p.path_name, c.comp_name, a.att_name, " +
            "       a.att_value, a.att_scope, a.att_customize_level " +
            "FROM jdr_paths p, jdr_components c, jdr_attributes a " +
            "WHERE p.path_name LIKE ? " +
            "  AND p.path_docid = c.path_docid " +
            "  AND c.comp_docid = a.comp_docid " +
            "  AND a.att_customize_level IS NOT NULL " +
            "ORDER BY p.path_name, c.comp_name, a.att_customize_level";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, pagePath + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Personalizations for: " + pagePath);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String pathName = rs.getString("path_name");
            String compName = rs.getString("comp_name");
            String attName = rs.getString("att_name");
            String attValue = rs.getString("att_value");
            String customLevel = rs.getString("att_customize_level");
            
            System.out.println("Path: " + pathName);
            System.out.println("  Component: " + compName);
            System.out.println("  Attribute: " + attName);
            System.out.println("  Value: " + attValue);
            System.out.println("  Level: " + customLevel);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 5: Find All Pages Using Specific AM
     * 
     * Identify all pages that reference a particular Application Module.
     * 
     * When to use:
     * - Impact analysis before AM changes
     * - Understanding AM usage
     * - Migration planning
     * 
     * Best Practice:
     * - Check both root and nested AM references
     * - Document dependencies
     * - Test all affected pages
     * 
     * Common Mistakes:
     * - Missing nested AM references
     * - Not checking personalized AM properties
     * - Incomplete impact analysis
     */
    public void findPagesUsingAM(String amDefinition) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT DISTINCT p.path_name, c.comp_name, a.att_value " +
            "FROM jdr_paths p, jdr_components c, jdr_attributes a " +
            "WHERE p.path_docid = c.path_docid " +
            "  AND c.comp_docid = a.comp_docid " +
            "  AND (a.att_name = 'applicationModuleDefName' " +
            "       OR a.att_name = 'applicationModuleName') " +
            "  AND a.att_value LIKE ? " +
            "ORDER BY p.path_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + amDefinition + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Pages using AM: " + amDefinition);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String pathName = rs.getString("path_name");
            String compName = rs.getString("comp_name");
            String attValue = rs.getString("att_value");
            
            System.out.println("Page: " + pathName);
            System.out.println("  Region: " + compName);
            System.out.println("  AM Reference: " + attValue);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 6: Query Translated Attributes
     * 
     * Find translated attribute values from JDR_ATTRIBUTES_TRANS.
     * 
     * When to use:
     * - Multi-language implementations
     * - Translation verification
     * - Localization testing
     * 
     * Best Practice:
     * - Check all required languages
     * - Verify translation completeness
     * - Test in target language context
     * 
     * Common Mistakes:
     * - Missing translations
     * - Wrong language codes
     * - Not testing in actual language context
     */
    public void queryTranslatedAttributes(String componentName, String language) 
            throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT c.comp_name, at.att_name, at.trans_value, " +
            "       at.lang " +
            "FROM jdr_components c, jdr_attributes_trans at " +
            "WHERE c.comp_name = ? " +
            "  AND c.comp_docid = at.comp_docid " +
            "  AND at.lang = ? " +
            "ORDER BY at.att_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, componentName);
        stmt.setString(2, language);
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Translated attributes for: " + componentName);
        System.out.println("Language: " + language);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String attName = rs.getString("att_name");
            String transValue = rs.getString("trans_value");
            
            System.out.println("Attribute: " + attName);
            System.out.println("  Translation: " + transValue);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 7: Find All Controllers in Module
     * 
     * List all controller classes used in a module.
     * 
     * When to use:
     * - Documentation
     * - Code review
     * - Migration planning
     * 
     * Best Practice:
     * - Document controller hierarchy
     * - Check for duplicate controllers
     * - Verify controller packages
     * 
     * Common Mistakes:
     * - Not checking extended controllers
     * - Missing personalized controllers
     * - Incomplete inventory
     */
    public void findControllersInModule(String modulePath) throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT DISTINCT p.path_name, c.comp_name, a.att_value " +
            "FROM jdr_paths p, jdr_components c, jdr_attributes a " +
            "WHERE p.path_name LIKE ? " +
            "  AND p.path_docid = c.path_docid " +
            "  AND c.comp_docid = a.comp_docid " +
            "  AND a.att_name = 'controllerClass' " +
            "  AND a.att_value IS NOT NULL " +
            "ORDER BY p.path_name, c.comp_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, modulePath + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Controllers in module: " + modulePath);
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            String pathName = rs.getString("path_name");
            String compName = rs.getString("comp_name");
            String controller = rs.getString("att_value");
            
            System.out.println("Page: " + pathName);
            System.out.println("  Region: " + compName);
            System.out.println("  Controller: " + controller);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 8: Using JDR_UTILS PL/SQL Package
     * 
     * Example of using JDR_UTILS package for MDS operations.
     * More efficient and supported than direct table queries.
     * 
     * When to use:
     * - Maintenance operations
     * - Bulk operations
     * - Supported MDS operations
     * 
     * Best Practice:
     * - Use JDR_UTILS for maintenance
     * - Check package documentation
     * - Test in non-production first
     * 
     * Common Mistakes:
     * - Direct table manipulation
     * - Not using transactions properly
     * - Skipping backups before changes
     */
    public void useJDRUtils() {
        // Example: This would be called via PL/SQL
        // Can be invoked from Java using callable statement
        
        String examplePLSQL = 
            "-- Example JDR_UTILS usage (run in SQL*Plus):\n" +
            "\n" +
            "-- 1. List all documents\n" +
            "BEGIN\n" +
            "  JDR_UTILS.listDocuments('/oracle/apps/fnd%');\n" +
            "END;\n" +
            "\n" +
            "-- 2. Export document\n" +
            "BEGIN\n" +
            "  JDR_UTILS.exportDocument(\n" +
            "    '/oracle/apps/fnd/framework/toolbox/tutorial/webui/HelloWorldPG',\n" +
            "    '/tmp/HelloWorldPG.xml'\n" +
            "  );\n" +
            "END;\n" +
            "\n" +
            "-- 3. Import document\n" +
            "BEGIN\n" +
            "  JDR_UTILS.importDocument(\n" +
            "    '/tmp/HelloWorldPG.xml',\n" +
            "    '/oracle/apps/fnd/framework/toolbox/tutorial/webui/HelloWorldPG'\n" +
            "  );\n" +
            "END;\n" +
            "\n" +
            "-- 4. Delete document\n" +
            "BEGIN\n" +
            "  JDR_UTILS.deleteDocument(\n" +
            "    '/oracle/apps/fnd/framework/toolbox/tutorial/webui/HelloWorldPG'\n" +
            "  );\n" +
            "END;";
        
        System.out.println(examplePLSQL);
        
        // To call from Java:
        // CallableStatement stmt = conn.prepareCall(
        //     "{call JDR_UTILS.listDocuments(?)}"
        // );
        // stmt.setString(1, "/oracle/apps/fnd%");
        // stmt.execute();
    }

    /**
     * USE CASE 9: Find Orphaned Components
     * 
     * Identify components that reference non-existent resources.
     * 
     * When to use:
     * - Cleanup operations
     * - Quality assurance
     * - Pre-migration validation
     * 
     * Best Practice:
     * - Run regularly for housekeeping
     * - Backup before cleanup
     * - Verify before deletion
     * 
     * Common Mistakes:
     * - Deleting referenced components
     * - Not checking all references
     * - Skipping impact analysis
     */
    public void findOrphanedComponents() throws SQLException {
        Connection conn = getOADBTransaction().getJdbcConnection();
        
        String sql =
            "SELECT c.comp_docid, c.comp_name, c.comp_class " +
            "FROM jdr_components c " +
            "WHERE NOT EXISTS ( " +
            "  SELECT 1 FROM jdr_paths p " +
            "  WHERE p.path_docid = c.path_docid " +
            ") " +
            "ORDER BY c.comp_name";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Orphaned Components:");
        System.out.println("----------------------------------------");
        
        while (rs.next()) {
            long compDocId = rs.getLong("comp_docid");
            String compName = rs.getString("comp_name");
            String compClass = rs.getString("comp_class");
            
            System.out.println("Component ID: " + compDocId);
            System.out.println("  Name: " + compName);
            System.out.println("  Class: " + compClass);
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }

    /**
     * USE CASE 10: MDS Cache and Performance
     * 
     * Understanding MDS cache behavior for performance optimization.
     * 
     * When to use:
     * - Performance troubleshooting
     * - Cache tuning
     * - Understanding page load
     * 
     * Best Practice:
     * - Monitor cache hit ratio
     * - Understand cache invalidation
     * - Consider personalization impact
     * 
     * Common Mistakes:
     * - Excessive personalization layers
     * - Not understanding cache behavior
     * - Unnecessary bounces
     */
    public void understandMDSCache() {
        String explanation =
            "MDS Cache Behavior:\n" +
            "==================\n" +
            "\n" +
            "1. First Access:\n" +
            "   - Page definition loaded from JDR tables\n" +
            "   - Cached in middle-tier memory\n" +
            "   - Subsequent access from cache\n" +
            "\n" +
            "2. Cache Invalidation:\n" +
            "   - Bouncing Apache clears cache\n" +
            "   - Functional Administrator > Invalidate Cache\n" +
            "   - Personalization changes invalidate automatically\n" +
            "\n" +
            "3. Performance Impact:\n" +
            "   - First load slower (DB query)\n" +
            "   - Cached loads very fast\n" +
            "   - Too many personalizations slow cache\n" +
            "\n" +
            "4. Best Practices:\n" +
            "   - Minimize personalization layers\n" +
            "   - Use Admin-level for site-wide changes\n" +
            "   - Test cache behavior during development\n" +
            "   - Monitor cache usage in production\n" +
            "\n" +
            "5. Troubleshooting:\n" +
            "   - Clear cache if personalization not appearing\n" +
            "   - Check JDR tables if cache clear doesn't help\n" +
            "   - Verify MDS import completed successfully\n" +
            "   - Check for concurrent modification issues";
        
        System.out.println(explanation);
    }
}
