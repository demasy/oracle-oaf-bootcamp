package oracle.apps.xxcust.oaf.codebrain.security;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.security.PolicyContext;

/**
 * Security Implementation Patterns
 * 
 * Function security, data security, menu security, and custom authorization.
 * 
 * Layer: Security / Cross-cutting
 * Complexity: Advanced
 * Syllabus: Level 102 Section 8
 * 
 * @author OAF Code Brain
 * @version 1.3
 */
public class SecurityPatterns {

    /**
     * USE CASE 1: Check Function Security
     * 
     * Verify user has access to specific function.
     * 
     * When to use:
     * - Protect page access
     * - Button visibility
     * - Action authorization
     * - Feature enablement
     * 
     * Best Practice:
     * - Check in processRequest
     * - Redirect if no access
     * - Clear error messages
     * - Log access attempts
     */
    public boolean checkFunctionSecurity(OAPageContext pageContext, String functionName) {
        // Check if user has access to function
        boolean hasAccess = pageContext.isResFunctionRegistered(functionName);
        
        if (!hasAccess) {
            System.out.println("User does not have access to function: " + functionName);
            
            // Throw exception or redirect
            throw new OAException(
                "You do not have permission to access this page",
                OAException.ERROR
            );
        }
        
        System.out.println("User has access to function: " + functionName);
        return hasAccess;
    }

    /**
     * USE CASE 2: Conditional Rendering Based on Function Security
     * 
     * Show/hide UI elements based on function access.
     * 
     * When to use:
     * - Conditional buttons
     * - Role-based UI
     * - Feature flags
     * - Permission-based display
     */
    public void conditionalRenderingByFunction(OAPageContext pageContext, 
                                               OAWebBean webBean,
                                               String buttonId,
                                               String functionName) {
        // Find button
        OAWebBean button = webBean.findChildRecursive(buttonId);
        
        if (button != null) {
            // Check function access
            boolean hasAccess = pageContext.isResFunctionRegistered(functionName);
            
            // Set rendered property
            button.setRendered(hasAccess);
            
            System.out.println("Button " + buttonId + " rendered: " + hasAccess);
        }
    }

    /**
     * USE CASE 3: Data Security - Filter by Organization
     * 
     * Restrict data visibility based on user's organization.
     * 
     * When to use:
     * - Multi-org applications
     * - Tenant isolation
     * - Organization-based access
     * - Data segregation
     */
    public void applyDataSecurityByOrg(OAPageContext pageContext, 
                                       OADBTransaction txn,
                                       OAViewObject vo) {
        // Get user's organization ID
        Number orgId = (Number) pageContext.getProfile("ORG_ID");
        
        if (orgId != null) {
            // Apply where clause to filter by org
            String existingWhere = vo.getWhereClause();
            String orgFilter = "org_id = :orgId";
            
            String newWhere = (existingWhere != null && !existingWhere.isEmpty()) ?
                existingWhere + " AND " + orgFilter : orgFilter;
            
            vo.setWhereClause(newWhere);
            vo.setWhereClauseParam("orgId", orgId);
            
            System.out.println("Data filtered by organization: " + orgId);
        }
    }

    /**
     * USE CASE 4: Check Responsibility
     * 
     * Verify user's current responsibility.
     * 
     * When to use:
     * - Responsibility-specific logic
     * - Role-based workflows
     * - Conditional processing
     * - Access validation
     */
    public boolean checkResponsibility(OAPageContext pageContext, String respKey) {
        // Get current responsibility key
        String currentRespKey = pageContext.getResponsibilityKey();
        
        boolean matches = respKey.equals(currentRespKey);
        
        if (!matches) {
            System.out.println("Responsibility mismatch: " + currentRespKey + 
                             " != " + respKey);
        }
        
        return matches;
    }

    /**
     * USE CASE 5: Custom Authorization Logic
     * 
     * Implement custom business rule for authorization.
     * 
     * When to use:
     * - Complex authorization rules
     * - Business-specific security
     * - Multi-criteria access
     * - Dynamic permissions
     */
    public boolean customAuthorizationCheck(OAPageContext pageContext,
                                            OADBTransaction txn,
                                            String recordId) {
        // Get current user ID
        Number userId = pageContext.getUserId();
        
        // Check if user is record owner or manager
        OAViewObject vo = (OAViewObject) txn.getApplicationModule()
            .findViewObject("SecurityCheckVO");
        
        if (vo != null) {
            vo.setWhereClause("record_id = :1 AND (created_by = :2 OR manager_id = :2)");
            vo.setWhereClauseParams(null);
            vo.setWhereClauseParam(0, recordId);
            vo.setWhereClauseParam(1, userId);
            vo.executeQuery();
            
            boolean authorized = vo.hasNext();
            
            if (!authorized) {
                throw new OAException(
                    "You are not authorized to access this record",
                    OAException.ERROR
                );
            }
            
            return authorized;
        }
        
        return false;
    }

    /**
     * USE CASE 6: Audit Trail - Track User Actions
     * 
     * Log user actions for audit purposes.
     * 
     * When to use:
     * - Security auditing
     * - Compliance tracking
     * - Change history
     * - Access monitoring
     */
    public void auditUserAction(OAPageContext pageContext,
                               OADBTransaction txn,
                               String action,
                               String recordType,
                               String recordId,
                               String details) {
        try {
            // Get audit VO
            OAViewObject auditVO = (OAViewObject) txn.getApplicationModule()
                .findViewObject("AuditTrailVO");
            
            if (auditVO != null) {
                // Create audit record
                oracle.jbo.Row row = auditVO.createRow();
                
                row.setAttribute("UserId", pageContext.getUserId());
                row.setAttribute("UserName", pageContext.getUserName());
                row.setAttribute("ResponsibilityId", pageContext.getResponsibilityId());
                row.setAttribute("Action", action);
                row.setAttribute("RecordType", recordType);
                row.setAttribute("RecordId", recordId);
                row.setAttribute("Details", details);
                row.setAttribute("ActionDate", pageContext.getCurrentDBDate());
                row.setAttribute("IpAddress", pageContext.getRenderingContext()
                    .getServletRequest().getRemoteAddr());
                
                auditVO.insertRow(row);
                
                System.out.println("Audit logged: " + action + " on " + recordType);
            }
            
        } catch (Exception e) {
            // Don't fail transaction due to audit error
            System.err.println("Error logging audit: " + e.getMessage());
        }
    }

    /**
     * USE CASE 7: Field-Level Security
     * 
     * Show/hide or enable/disable fields based on permissions.
     * 
     * When to use:
     * - Sensitive field protection
     * - Role-based field access
     * - Data classification
     * - PII protection
     */
    public void applyFieldLevelSecurity(OAPageContext pageContext,
                                       OAWebBean webBean) {
        // Check if user can view salary
        boolean canViewSalary = pageContext.isResFunctionRegistered("XXCUST_VIEW_SALARY");
        
        OAWebBean salaryField = webBean.findChildRecursive("Salary");
        if (salaryField != null) {
            salaryField.setRendered(canViewSalary);
        }
        
        // Check if user can edit status
        boolean canEditStatus = pageContext.isResFunctionRegistered("XXCUST_EDIT_STATUS");
        
        OAWebBean statusField = webBean.findChildRecursive("Status");
        if (statusField != null && !canEditStatus) {
            statusField.setAttributeValue("readOnly", Boolean.TRUE);
        }
        
        System.out.println("Field-level security applied");
    }

    /**
     * USE CASE 8: Best Practices Summary
     */
    public void securityBestPractices() {
        String practices =
            "Security Implementation Best Practices:\n" +
            "======================================\n" +
            "\n" +
            "Function Security:\n" +
            "- Check in processRequest\n" +
            "- Use isResFunctionRegistered()\n" +
            "- Redirect on unauthorized access\n" +
            "- Log access attempts\n" +
            "\n" +
            "Data Security:\n" +
            "- Filter by organization/responsibility\n" +
            "- Apply row-level security\n" +
            "- Use bind variables\n" +
            "- Test with different users\n" +
            "\n" +
            "Authorization:\n" +
            "- Implement custom business rules\n" +
            "- Check ownership/manager relationship\n" +
            "- Validate before actions\n" +
            "- Clear error messages\n" +
            "\n" +
            "Auditing:\n" +
            "- Log all sensitive actions\n" +
            "- Capture user, timestamp, details\n" +
            "- Don't fail on audit error\n" +
            "- Comply with regulations\n" +
            "\n" +
            "Field Security:\n" +
            "- Hide sensitive fields\n" +
            "- Make read-only when appropriate\n" +
            "- Protect PII\n" +
            "- Test thoroughly";
        
        System.out.println(practices);
    }
}
