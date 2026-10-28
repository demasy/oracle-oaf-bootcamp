package oracle.apps.xx.common.integration.plsql;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * PLSQL Integration Patterns using CallableStatement
 * 
 * This class demonstrates PROPER patterns for calling PLSQL procedures and
 * functions from OAF. Based on real-world analysis of JDEV codebase.
 * 
 * ANTI-PATTERN (Found in production Controllers):
 * <pre>
 * // In XxDailyCO.java - JDBC directly in Controller!
 * conn = pageContext.getAM().getOADBTransaction().getJdbcConnection();
 * stat = conn.prepareStatement(query);
 * </pre>
 * 
 * CORRECT PATTERN (This implementation):
 * - Encapsulate PLSQL calls in Helper classes or AM methods
 * - Use CallableStatement via OADBTransaction
 * - Proper exception wrapping
 * - Resource cleanup in finally blocks
 * 
 * Source: Analyzed from demasylabs-barin/brain-repo/code/JDEV
 * Files: LetterDocumentHelper.java, TmzApLCHeadersAMImpl.java
 * 
 * @author OAF Code Brain - Based on Real-World Production Code
 * @version 1.5.0
 */
public class PLSQLIntegrationHelper {
    
    /**
     * PATTERN 1: Call PLSQL Procedure (No Return Value)
     * 
     * Execute a procedure that performs operations but doesn't return values.
     * Example: Workflow initiation, data validation, logging
     * 
     * Found in: TmzApLCHeadersAMImpl.initiateApproval()
     * 
     * @param am Application Module (for transaction access)
     * @param transactionId Transaction ID to process
     * @throws OAException if procedure execution fails
     */
    public static void launchWorkflowApproval(
            OAApplicationModuleImpl am,
            String transactionId) {
        
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new OAException("Transaction ID is required for workflow initiation",
                OAException.ERROR);
        }
        
        CallableStatement cs = null;
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            // Create CallableStatement
            String sql = "BEGIN TMZ_AP_LC_REQUEST_WF_API.LAUNCH_WORKFLOW_APPROVAL(:1); END;";
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // Set IN parameter
            cs.setString(1, transactionId);
            
            // Execute procedure
            cs.execute();
            
            System.out.println("Workflow approval launched for transaction: " + transactionId);
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            // CRITICAL: Close statement to prevent resource leak
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    // Log but don't throw in finally block
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * PATTERN 2: Call PLSQL Function with Single OUT Parameter
     * 
     * Execute a function that returns a single value via OUT parameter.
     * 
     * Found in: LetterDocumentHelper.getOperationUnit()
     * 
     * @param am Application Module
     * @param orgId Organization ID
     * @return Organization name
     */
    public static String getOperatingUnitName(
            OAApplicationModuleImpl am,
            String orgId) {
        
        if (orgId == null) {
            return null;
        }
        
        String orgName = null;
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            // Function call syntax: :1 := FUNCTION(:2)
            String sql = "BEGIN :1 := TMZ_FND_OPERATING_UNITS_API.GET_OU_NAME(:2); END;";
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // Register OUT parameter (function return value)
            cs.registerOutParameter(1, Types.VARCHAR);
            
            // Set IN parameter
            cs.setString(2, orgId);
            
            // Execute
            cs.execute();
            
            // Retrieve OUT parameter
            orgName = cs.getString(1);
            
            System.out.println("Retrieved OU name: " + orgName + " for OrgId: " + orgId);
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
        
        return orgName;
    }
    
    /**
     * PATTERN 3: Call PLSQL Procedure with Multiple OUT Parameters
     * 
     * Execute a procedure that returns multiple values.
     * Use a value object or separate method calls for clarity.
     * 
     * @param am Application Module
     * @param employeeId Employee ID
     * @return Array: [0]=Full Name, [1]=Job Title, [2]=Department
     */
    public static String[] getEmployeeDetails(
            OAApplicationModuleImpl am,
            String employeeId) {
        
        if (employeeId == null) {
            return null;
        }
        
        String[] result = new String[3];
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            String sql = 
                "BEGIN " +
                "  XX_HR_EMPLOYEE_API.GET_EMPLOYEE_DETAILS(" +
                "    P_EMPLOYEE_ID => :1, " +
                "    X_FULL_NAME => :2, " +
                "    X_JOB_TITLE => :3, " +
                "    X_DEPARTMENT => :4" +
                "  ); " +
                "END;";
            
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // IN parameter
            cs.setString(1, employeeId);
            
            // OUT parameters
            cs.registerOutParameter(2, Types.VARCHAR); // Full Name
            cs.registerOutParameter(3, Types.VARCHAR); // Job Title
            cs.registerOutParameter(4, Types.VARCHAR); // Department
            
            cs.execute();
            
            // Retrieve results
            result[0] = cs.getString(2);
            result[1] = cs.getString(3);
            result[2] = cs.getString(4);
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
        
        return result;
    }
    
    /**
     * PATTERN 4: Call PLSQL with IN/OUT Parameter
     * 
     * Handle parameters that are both input and output.
     * Common for validation procedures that modify values.
     * 
     * @param am Application Module
     * @param amount Original amount
     * @return Validated/adjusted amount
     */
    public static Number validateAndAdjustAmount(
            OAApplicationModuleImpl am,
            Number amount) {
        
        if (amount == null) {
            return null;
        }
        
        Number adjustedAmount = null;
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            String sql = 
                "BEGIN " +
                "  XX_AP_VALIDATION_PKG.VALIDATE_AMOUNT(:1); " +
                "END;";
            
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // IN/OUT parameter - both register and set
            cs.registerOutParameter(1, Types.NUMERIC);
            cs.setBigDecimal(1, amount.bigDecimalValue());
            
            cs.execute();
            
            // Retrieve modified value
            java.math.BigDecimal result = cs.getBigDecimal(1);
            if (result != null) {
                adjustedAmount = new Number(result);
            }
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
        
        return adjustedAmount;
    }
    
    /**
     * PATTERN 5: Call PLSQL with Date Parameters
     * 
     * Proper handling of oracle.jbo.domain.Date type.
     * 
     * @param am Application Module
     * @param employeeId Employee ID
     * @param startDate Period start
     * @param endDate Period end
     * @return Total hours worked
     */
    public static Number calculateWorkingHours(
            OAApplicationModuleImpl am,
            String employeeId,
            Date startDate,
            Date endDate) {
        
        Number totalHours = null;
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            String sql = 
                "BEGIN " +
                "  :1 := XX_TIME_TRACKING_PKG.CALCULATE_HOURS(" +
                "    P_EMPLOYEE_ID => :2, " +
                "    P_START_DATE => :3, " +
                "    P_END_DATE => :4" +
                "  ); " +
                "END;";
            
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // OUT parameter for return value
            cs.registerOutParameter(1, Types.NUMERIC);
            
            // IN parameters
            cs.setString(2, employeeId);
            
            // Convert JBO Date to java.sql.Date
            if (startDate != null) {
                cs.setDate(3, new java.sql.Date(startDate.getValue().getTime()));
            } else {
                cs.setNull(3, Types.DATE);
            }
            
            if (endDate != null) {
                cs.setDate(4, new java.sql.Date(endDate.getValue().getTime()));
            } else {
                cs.setNull(4, Types.DATE);
            }
            
            cs.execute();
            
            java.math.BigDecimal result = cs.getBigDecimal(1);
            if (result != null) {
                totalHours = new Number(result);
            }
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
        
        return totalHours;
    }
    
    /**
     * PATTERN 6: Call PLSQL Table Type (Array) Parameter
     * 
     * Advanced: Pass arrays to PLSQL using oracle.sql.ARRAY.
     * Requires Oracle type definition.
     * 
     * @param am Application Module
     * @param employeeIds Array of employee IDs
     * @return Number of employees processed
     */
    public static Number processBatchEmployees(
            OAApplicationModuleImpl am,
            String[] employeeIds) {
        
        if (employeeIds == null || employeeIds.length == 0) {
            return new Number(0);
        }
        
        Number processedCount = null;
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            // Requires PLSQL type: CREATE TYPE EMP_ID_TABLE AS TABLE OF VARCHAR2(30);
            String sql = 
                "BEGIN " +
                "  :1 := XX_HR_BATCH_PKG.PROCESS_EMPLOYEES(:2); " +
                "END;";
            
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            
            // OUT parameter
            cs.registerOutParameter(1, Types.NUMERIC);
            
            // IN parameter - ARRAY type
            // Note: This requires oracle.sql.ArrayDescriptor and oracle.sql.ARRAY
            // For simplicity, this is a placeholder - actual implementation needs oracle.sql.*
            
            // Alternative: Use comma-separated string if PLSQL accepts it
            String empIdList = String.join(",", employeeIds);
            cs.setString(2, empIdList);
            
            cs.execute();
            
            java.math.BigDecimal result = cs.getBigDecimal(1);
            if (result != null) {
                processedCount = new Number(result);
            }
            
        } catch (SQLException e) {
            throw OAException.wrapperException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
        
        return processedCount;
    }
    
    /**
     * PATTERN 7: Error Handling from PLSQL
     * 
     * Capture and handle application errors raised in PLSQL.
     * PLSQL uses RAISE_APPLICATION_ERROR(-20xxx, 'message').
     * 
     * @param am Application Module
     * @param documentId Document ID to validate
     * @return true if valid, throws exception if invalid
     */
    public static boolean validateDocument(
            OAApplicationModuleImpl am,
            String documentId) {
        
        CallableStatement cs = null;
        
        try {
            OADBTransaction txn = am.getOADBTransaction();
            
            // PLSQL will raise -20001 if document is invalid
            String sql = 
                "BEGIN " +
                "  XX_DOCUMENT_VALIDATION_PKG.VALIDATE_DOCUMENT(:1); " +
                "END;";
            
            cs = txn.createCallableStatement(sql, OADBTransaction.DEFAULT);
            cs.setString(1, documentId);
            cs.execute();
            
            return true; // If we reach here, validation passed
            
        } catch (SQLException e) {
            // Check for application error codes
            int errorCode = e.getErrorCode();
            if (errorCode == 20001) {
                // Custom application error from PLSQL
                throw new OAException("Document validation failed: " + e.getMessage(),
                    OAException.ERROR);
            } else {
                // Other SQL errors
                throw OAException.wrapperException(e);
            }
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing CallableStatement: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * PATTERN 8: Call from PageContext (in Controller)
     * 
     * How to call these helper methods from a Controller.
     * 
     * ANTI-PATTERN: Direct JDBC in Controller
     * CORRECT: Call helper method via AM
     * 
     * Example usage in XXSomeCO.processFormRequest():
     * <pre>
     * public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
     *     super.processFormRequest(pageContext, webBean);
     *     
     *     if ("approve".equals(pageContext.getParameter("event"))) {
     *         OAApplicationModuleImpl am = 
     *             (OAApplicationModuleImpl) pageContext.getApplicationModule(webBean);
     *         
     *         String transactionId = pageContext.getParameter("transactionId");
     *         
     *         // Call helper method
     *         PLSQLIntegrationHelper.launchWorkflowApproval(am, transactionId);
     *         
     *         throw new OAException("Workflow approval initiated successfully",
     *             OAException.CONFIRMATION);
     *     }
     * }
     * </pre>
     */
    public static void exampleControllerUsage() {
        // This is documentation only - see JavaDoc above
    }
    
    /**
     * Best Practices Summary
     * =====================
     * 
     * 1. ENCAPSULATION:
     *    - Never call PLSQL directly in Controllers
     *    - Use Helper classes or AM methods
     *    - Keep JDBC code out of View/Controller layers
     * 
     * 2. RESOURCE MANAGEMENT:
     *    - ALWAYS close CallableStatement in finally block
     *    - Use try-finally or try-with-resources (Java 7+)
     *    - One statement per call - don't reuse
     * 
     * 3. PARAMETER HANDLING:
     *    - Register OUT parameters before execute()
     *    - Set IN parameters with correct JDBC types
     *    - Handle NULL values explicitly
     *    - Use named parameters in PLSQL for readability
     * 
     * 4. ERROR HANDLING:
     *    - Catch SQLException and wrap with OAException
     *    - Check error codes for application errors (-20xxx)
     *    - Provide meaningful error messages
     *    - Don't swallow exceptions
     * 
     * 5. DATA TYPE CONVERSION:
     *    - oracle.jbo.domain.Date → java.sql.Date
     *    - oracle.jbo.domain.Number → BigDecimal
     *    - Handle NULL values properly
     *    - Use Types.* constants for JDBC types
     * 
     * 6. PERFORMANCE:
     *    - Don't call PLSQL in loops - use batch operations
     *    - Consider bulk collect/forall in PLSQL
     *    - Commit at appropriate intervals
     *    - Monitor execution time
     * 
     * 7. TESTING:
     *    - Test with NULL parameters
     *    - Test error scenarios (invalid data)
     *    - Test with production data volumes
     *    - Verify resource cleanup (no connection leaks)
     * 
     * Common Mistakes to Avoid:
     * =========================
     * ❌ Calling PLSQL directly in Controller
     * ❌ Not closing CallableStatement
     * ❌ Swallowing SQLExceptions
     * ❌ Not handling NULL values
     * ❌ Wrong parameter order
     * ❌ Forgetting to register OUT parameters
     * ❌ Type conversion errors (Date, Number)
     * ❌ Not validating input parameters
     */
}
