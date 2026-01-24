package oracle.apps.xxcust.oaf.codebrain.integration.plsql;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.OAException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.sql.SQLException;
import oracle.jbo.domain.Number;

/**
 * PL/SQL Integration Patterns (Integration Layer)
 * 
 * Comprehensive patterns for calling PL/SQL functions and procedures from OAF.
 * Function calls with return values, procedure calls with OUT parameters,
 * exception handling, and batch processing.
 * 
 * Layer: Integration Layer
 * Complexity: Intermediate to Advanced
 * Syllabus: Level 102 Section 12.1, 12.2
 * 
 * @author OAF Code Brain
 * @version 1.3
 */
public class PLSQLIntegration {

    /**
     * USE CASE 1: Call PL/SQL Function with Return Value
     * 
     * Execute PL/SQL function and get return value.
     * 
     * When to use:
     * - Business logic in database
     * - Calculations in PL/SQL
     * - Validation functions
     * - Lookup functions
     * 
     * Best Practice:
     * - Use CallableStatement
     * - Register OUT parameter
     * - Close statement
     * - Handle SQL exceptions
     * 
     * Common Mistakes:
     * - Not registering OUT parameter
     * - Wrong parameter index
     * - Not closing statement
     * - Ignoring exceptions
     * 
     * Example: Function returns employee full name
     * CREATE FUNCTION get_emp_full_name(p_emp_id NUMBER) RETURN VARCHAR2
     */
    public String callFunctionWithReturn(OADBTransaction txn, Number empId) {
        CallableStatement cs = null;
        String fullName = null;
        
        try {
            // Get JDBC connection
            Connection conn = txn.getJdbcConnection();
            
            // Prepare callable statement
            // ? = function return value
            // Parameter 1 = function input
            cs = conn.prepareCall("{? = call xxcust_emp_pkg.get_emp_full_name(?)}");
            
            // Register OUT parameter (return value)
            cs.registerOutParameter(1, Types.VARCHAR);
            
            // Set IN parameter
            cs.setInt(2, empId.intValue());
            
            // Execute function
            cs.execute();
            
            // Get return value
            fullName = cs.getString(1);
            
            System.out.println("Function returned: " + fullName);
            
        } catch (SQLException e) {
            throw new OAException("Error calling PL/SQL function: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            // Close statement
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                // Log but don't throw
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        
        return fullName;
    }

    /**
     * USE CASE 2: Call PL/SQL Procedure with OUT Parameters
     * 
     * Execute PL/SQL procedure with OUT parameters.
     * 
     * When to use:
     * - Multiple return values
     * - Complex business logic
     * - Validation with details
     * - Data processing
     * 
     * Best Practice:
     * - Register all OUT parameters
     * - Set correct SQL types
     * - Check for null returns
     * - Handle exceptions properly
     * 
     * Common Mistakes:
     * - Wrong parameter order
     * - Not registering OUT params
     * - Wrong SQL types
     * - Not handling nulls
     * 
     * Example: Procedure validates employee and returns status
     * CREATE PROCEDURE validate_employee(
     *   p_emp_id IN NUMBER,
     *   x_valid OUT VARCHAR2,
     *   x_message OUT VARCHAR2,
     *   x_error_code OUT NUMBER
     * )
     */
    public EmployeeValidation callProcedureWithOUTParams(OADBTransaction txn, Number empId) {
        CallableStatement cs = null;
        EmployeeValidation result = new EmployeeValidation();
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            // Prepare callable statement
            cs = conn.prepareCall("{call xxcust_emp_pkg.validate_employee(?, ?, ?, ?)}");
            
            // Set IN parameter
            cs.setInt(1, empId.intValue());
            
            // Register OUT parameters
            cs.registerOutParameter(2, Types.VARCHAR);  // x_valid
            cs.registerOutParameter(3, Types.VARCHAR);  // x_message
            cs.registerOutParameter(4, Types.NUMERIC);  // x_error_code
            
            // Execute procedure
            cs.execute();
            
            // Get OUT parameter values
            result.valid = cs.getString(2);
            result.message = cs.getString(3);
            result.errorCode = cs.getInt(4);
            
            System.out.println("Validation result: " + result.valid);
            System.out.println("Message: " + result.message);
            
        } catch (SQLException e) {
            throw new OAException("Error calling PL/SQL procedure: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        
        return result;
    }

    /**
     * USE CASE 3: Call PL/SQL Function with Multiple Parameters
     * 
     * Execute function with multiple IN parameters.
     * 
     * When to use:
     * - Complex calculations
     * - Multi-criteria validation
     * - Business rule evaluation
     * - Price/amount calculations
     * 
     * Best Practice:
     * - Pass all required parameters
     * - Use correct parameter types
     * - Handle null inputs
     * - Validate before call
     * 
     * Example: Calculate employee salary with benefits
     * CREATE FUNCTION calculate_total_compensation(
     *   p_emp_id NUMBER,
     *   p_base_salary NUMBER,
     *   p_bonus_pct NUMBER,
     *   p_benefits_flag VARCHAR2
     * ) RETURN NUMBER
     */
    public Double calculateTotalCompensation(OADBTransaction txn, 
                                             Number empId,
                                             Double baseSalary,
                                             Double bonusPct,
                                             String benefitsFlag) {
        CallableStatement cs = null;
        Double totalComp = null;
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            cs = conn.prepareCall("{? = call xxcust_emp_pkg.calculate_total_compensation(?, ?, ?, ?)}");
            
            // Register return value
            cs.registerOutParameter(1, Types.NUMERIC);
            
            // Set IN parameters
            cs.setInt(2, empId.intValue());
            cs.setDouble(3, baseSalary);
            cs.setDouble(4, bonusPct);
            cs.setString(5, benefitsFlag);
            
            // Execute
            cs.execute();
            
            // Get return value
            totalComp = cs.getDouble(1);
            
            System.out.println("Total compensation: " + totalComp);
            
        } catch (SQLException e) {
            throw new OAException("Error calculating compensation: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        
        return totalComp;
    }

    /**
     * USE CASE 4: Handle PL/SQL Exceptions
     * 
     * Catch and handle PL/SQL exceptions raised by functions/procedures.
     * 
     * When to use:
     * - PL/SQL raises application errors
     * - Business rule violations
     * - Data validation failures
     * - Custom error handling
     * 
     * Best Practice:
     * - Catch SQLException
     * - Extract error code
     * - Map to business errors
     * - Provide clear messages
     * 
     * Example: PL/SQL raises exception
     * RAISE_APPLICATION_ERROR(-20001, 'Employee not found');
     */
    public void callWithExceptionHandling(OADBTransaction txn, Number empId) {
        CallableStatement cs = null;
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            cs = conn.prepareCall("{call xxcust_emp_pkg.update_employee_status(?)}");
            cs.setInt(1, empId.intValue());
            cs.execute();
            
            System.out.println("Employee status updated successfully");
            
        } catch (SQLException e) {
            // Get error code
            int errorCode = e.getErrorCode();
            String errorMsg = e.getMessage();
            
            // Handle specific error codes
            if (errorCode == 20001) {
                throw new OAException("Employee not found: " + empId,
                    OAException.ERROR);
            } else if (errorCode == 20002) {
                throw new OAException("Employee status cannot be changed",
                    OAException.ERROR);
            } else if (errorCode == 20003) {
                throw new OAException("Employee has active assignments",
                    OAException.ERROR);
            } else {
                // Generic error
                throw new OAException("Database error: " + errorMsg,
                    OAException.ERROR);
            }
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    /**
     * USE CASE 5: Call PL/SQL Procedure with IN OUT Parameters
     * 
     * Execute procedure with IN OUT parameters that serve as both input and output.
     * 
     * When to use:
     * - Parameter modified by procedure
     * - Accumulator patterns
     * - Counter/sequence generation
     * - Data transformation
     * 
     * Best Practice:
     * - Register as OUT parameter
     * - Set as IN parameter
     * - Read modified value
     * - Handle type conversions
     * 
     * Example: Procedure increments counter
     * CREATE PROCEDURE process_employee(
     *   p_emp_id IN NUMBER,
     *   p_counter IN OUT NUMBER
     * )
     */
    public int callProcedureWithINOUT(OADBTransaction txn, Number empId, int initialCounter) {
        CallableStatement cs = null;
        int finalCounter = initialCounter;
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            cs = conn.prepareCall("{call xxcust_emp_pkg.process_employee(?, ?)}");
            
            // Set IN parameters
            cs.setInt(1, empId.intValue());
            cs.setInt(2, initialCounter);
            
            // Register IN OUT parameter as OUT
            cs.registerOutParameter(2, Types.NUMERIC);
            
            // Execute
            cs.execute();
            
            // Get modified value
            finalCounter = cs.getInt(2);
            
            System.out.println("Counter: " + initialCounter + " -> " + finalCounter);
            
        } catch (SQLException e) {
            throw new OAException("Error calling procedure: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        
        return finalCounter;
    }

    /**
     * USE CASE 6: Batch Processing with PL/SQL
     * 
     * Process multiple records using PL/SQL procedure in loop.
     * 
     * When to use:
     * - Bulk operations
     * - Mass updates
     * - Batch validation
     * - Large dataset processing
     * 
     * Best Practice:
     * - Commit in batches
     * - Handle errors per record
     * - Use bulk operations when possible
     * - Log progress
     */
    public void batchProcessWithPLSQL(OADBTransaction txn, Number[] employeeIds) {
        CallableStatement cs = null;
        int successCount = 0;
        int errorCount = 0;
        int batchSize = 100;
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            // Prepare once, execute multiple times
            cs = conn.prepareCall("{call xxcust_emp_pkg.process_single_employee(?, ?, ?)}");
            
            for (int i = 0; i < employeeIds.length; i++) {
                try {
                    // Set IN parameter
                    cs.setInt(1, employeeIds[i].intValue());
                    
                    // Register OUT parameters
                    cs.registerOutParameter(2, Types.VARCHAR); // status
                    cs.registerOutParameter(3, Types.VARCHAR); // message
                    
                    // Execute
                    cs.execute();
                    
                    // Get results
                    String status = cs.getString(2);
                    String message = cs.getString(3);
                    
                    if ("SUCCESS".equals(status)) {
                        successCount++;
                    } else {
                        errorCount++;
                        System.err.println("Error processing " + employeeIds[i] + 
                                         ": " + message);
                    }
                    
                    // Commit every batch
                    if ((i + 1) % batchSize == 0) {
                        txn.commit();
                        System.out.println("Committed batch: " + (i + 1) + " records");
                    }
                    
                } catch (SQLException e) {
                    errorCount++;
                    System.err.println("Error processing employee " + employeeIds[i] + 
                                     ": " + e.getMessage());
                }
            }
            
            // Final commit
            txn.commit();
            
            System.out.println("Batch processing complete:");
            System.out.println("Success: " + successCount);
            System.out.println("Errors: " + errorCount);
            
        } catch (SQLException e) {
            throw new OAException("Error in batch processing: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    /**
     * USE CASE 7: Call PL/SQL from Application Module
     * 
     * Integrate PL/SQL call within AM method.
     * 
     * When to use:
     * - Part of business transaction
     * - Called from controller
     * - Transaction management needed
     * - Business logic encapsulation
     * 
     * Best Practice:
     * - Use getOADBTransaction()
     * - Handle exceptions
     * - Commit/rollback in AM
     * - Return values to controller
     * 
     * Example AM method:
     */
    public String processEmployeeInAM(OAApplicationModuleImpl am, Number empId) {
        // Get transaction
        OADBTransaction txn = am.getOADBTransaction();
        
        String result = null;
        
        try {
            // Call PL/SQL function
            result = callFunctionWithReturn(txn, empId);
            
            // Perform additional business logic
            // ...
            
            // Commit if successful
            txn.commit();
            
            System.out.println("Employee processed successfully in AM");
            
        } catch (Exception e) {
            // Rollback on error
            txn.rollback();
            
            throw new OAException("Error processing employee: " + e.getMessage(),
                OAException.ERROR);
        }
        
        return result;
    }

    /**
     * USE CASE 8: Execute Anonymous PL/SQL Block
     * 
     * Execute anonymous PL/SQL block without creating stored procedure.
     * 
     * When to use:
     * - One-time operations
     * - Dynamic PL/SQL
     * - Testing/debugging
     * - Simple operations
     * 
     * Best Practice:
     * - Use for simple operations only
     * - Prefer stored procedures
     * - Handle exceptions
     * - Use bind variables
     */
    public void executeAnonymousBlock(OADBTransaction txn, Number empId, String newStatus) {
        CallableStatement cs = null;
        
        try {
            Connection conn = txn.getJdbcConnection();
            
            // Build anonymous block
            String plsqlBlock = 
                "BEGIN " +
                "  UPDATE xxcust_employees " +
                "  SET status = :1, " +
                "      last_update_date = SYSDATE, " +
                "      last_updated_by = :2 " +
                "  WHERE employee_id = :3; " +
                "  " +
                "  IF SQL%ROWCOUNT = 0 THEN " +
                "    RAISE_APPLICATION_ERROR(-20001, 'Employee not found'); " +
                "  END IF; " +
                "END;";
            
            cs = conn.prepareCall(plsqlBlock);
            
            // Set bind variables
            cs.setString(1, newStatus);
            cs.setInt(2, txn.getUserId().intValue());
            cs.setInt(3, empId.intValue());
            
            // Execute
            cs.execute();
            
            System.out.println("Anonymous block executed successfully");
            
        } catch (SQLException e) {
            throw new OAException("Error executing anonymous block: " + e.getMessage(),
                OAException.ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    /**
     * USE CASE 9: Best Practices Summary
     */
    public void plsqlBestPractices() {
        String practices =
            "PL/SQL Integration Best Practices:\n" +
            "==================================\n" +
            "\n" +
            "Function Calls:\n" +
            "- Register OUT parameter for return value\n" +
            "- Use correct SQL types\n" +
            "- Close CallableStatement\n" +
            "- Handle null returns\n" +
            "\n" +
            "Procedure Calls:\n" +
            "- Register all OUT parameters\n" +
            "- Set IN parameters in correct order\n" +
            "- Handle IN OUT parameters properly\n" +
            "- Check for null OUT values\n" +
            "\n" +
            "Exception Handling:\n" +
            "- Catch SQLException\n" +
            "- Extract error code and message\n" +
            "- Map to business exceptions\n" +
            "- Provide user-friendly messages\n" +
            "- Log technical details\n" +
            "\n" +
            "Performance:\n" +
            "- Prepare statement once for batch\n" +
            "- Commit in batches (100-1000 records)\n" +
            "- Use bulk operations when possible\n" +
            "- Close resources in finally block\n" +
            "\n" +
            "Transaction Management:\n" +
            "- Use OADBTransaction\n" +
            "- Commit on success\n" +
            "- Rollback on error\n" +
            "- Handle within AM methods\n" +
            "\n" +
            "Security:\n" +
            "- Use bind variables (never concatenate)\n" +
            "- Validate all inputs\n" +
            "- Check permissions\n" +
            "- Audit sensitive operations";
        
        System.out.println(practices);
    }

    /**
     * Helper class for employee validation result
     */
    public static class EmployeeValidation {
        public String valid;
        public String message;
        public int errorCode;
    }
}
