package oracle.apps.xxcust.oaf.codebrain.constants;

/**
 * OAF Message Constants - Centralized Message Code Management
 * 
 * All error messages should use message codes from FND_MESSAGES table
 * instead of hardcoded strings. This class provides constants for all
 * message codes used across the Code Brain application.
 * 
 * Message Registration Required:
 * All message codes must be registered in FND_MESSAGES table before use.
 * See MESSAGE_REGISTRATION.sql for complete SQL script.
 * 
 * Pattern: XX_<CATEGORY>_<ERROR_TYPE>
 * Example: XX_EMP_REQUIRED, XX_VAL_INVALID_FORMAT
 * 
 * Application Short Names:
 * - XX: Custom Application Messages (General)
 * - XXVAL: Validation Messages (DataValidation.java)
 * - XXLAB: Lab Exercise Messages
 * 
 * Layer: Cross-cutting - Constants
 * Version: 1.4.0
 * 
 * @author OAF Code Brain
 * @version 1.4.0
 */
public class MessageConstants {
    
    // ========================================
    // APPLICATION SHORT NAMES
    // ========================================
    
    /** General application messages */
    public static final String APP_XX = "XX";
    
    /** Validation-specific messages */
    public static final String APP_XXVAL = "XXVAL";
    
    /** Lab exercise messages */
    public static final String APP_XXLAB = "XXLAB";
    
    // ========================================
    // COMMON MESSAGES
    // ========================================
    
    /** Record saved successfully */
    public static final String MSG_SAVE_SUCCESS = "XX_SAVE_SUCCESS";
    
    /** Record deleted successfully */
    public static final String MSG_DELETE_SUCCESS = "XX_DELETE_SUCCESS";
    
    /** Changes have been rolled back */
    public static final String MSG_ROLLBACK_SUCCESS = "XX_ROLLBACK_SUCCESS";
    
    /** No rows selected */
    public static final String MSG_NO_ROWS_SELECTED = "XX_NO_ROWS_SELECTED";
    
    /** Please select at least one row */
    public static final String MSG_SELECT_ONE_ROW = "XX_SELECT_ONE_ROW";
    
    /** Record not found */
    public static final String MSG_RECORD_NOT_FOUND = "XX_RECORD_NOT_FOUND";
    
    // ========================================
    // VALIDATION ERROR MESSAGES
    // ========================================
    
    /** Field is required */
    public static final String ERR_FIELD_REQUIRED = "XX_FIELD_REQUIRED";
    
    /** Invalid format */
    public static final String ERR_INVALID_FORMAT = "XX_INVALID_FORMAT";
    
    /** Value out of range */
    public static final String ERR_OUT_OF_RANGE = "XX_OUT_OF_RANGE";
    
    /** Duplicate record exists */
    public static final String ERR_DUPLICATE_RECORD = "XX_DUPLICATE_RECORD";
    
    /** Invalid date range */
    public static final String ERR_INVALID_DATE_RANGE = "XX_INVALID_DATE_RANGE";
    
    /** Date cannot be in future */
    public static final String ERR_DATE_IN_FUTURE = "XX_DATE_IN_FUTURE";
    
    /** Date cannot be in past */
    public static final String ERR_DATE_IN_PAST = "XX_DATE_IN_PAST";
    
    /** End date before start date */
    public static final String ERR_END_BEFORE_START = "XX_END_BEFORE_START";
    
    // ========================================
    // EMPLOYEE MESSAGES
    // ========================================
    
    /** Employee number is required */
    public static final String ERR_EMP_NUMBER_REQUIRED = "XX_EMP_NUMBER_REQUIRED";
    
    /** Employee name is required */
    public static final String ERR_EMP_NAME_REQUIRED = "XX_EMP_NAME_REQUIRED";
    
    /** Employee not found */
    public static final String ERR_EMP_NOT_FOUND = "XX_EMP_NOT_FOUND";
    
    /** Invalid employee status */
    public static final String ERR_EMP_INVALID_STATUS = "XX_EMP_INVALID_STATUS";
    
    /** Employee has active assignments */
    public static final String ERR_EMP_HAS_ASSIGNMENTS = "XX_EMP_HAS_ASSIGNMENTS";
    
    // ========================================
    // EMAIL MESSAGES
    // ========================================
    
    /** Email is required */
    public static final String ERR_EMAIL_REQUIRED = "XX_EMAIL_REQUIRED";
    
    /** Invalid email format */
    public static final String ERR_EMAIL_INVALID = "XX_EMAIL_INVALID";
    
    // ========================================
    // SALARY/COMPENSATION MESSAGES
    // ========================================
    
    /** Salary cannot be negative */
    public static final String ERR_SALARY_NEGATIVE = "XX_SALARY_NEGATIVE";
    
    /** Salary exceeds maximum */
    public static final String ERR_SALARY_EXCEEDS_MAX = "XX_SALARY_EXCEEDS_MAX";
    
    /** Invalid salary value */
    public static final String ERR_SALARY_INVALID = "XX_SALARY_INVALID";
    
    // ========================================
    // JOB MESSAGES
    // ========================================
    
    /** Job name is required */
    public static final String ERR_JOB_NAME_REQUIRED = "XX_JOB_NAME_REQUIRED";
    
    /** Job name too long */
    public static final String ERR_JOB_NAME_TOO_LONG = "XX_JOB_NAME_TOO_LONG";
    
    /** Job name contains invalid characters */
    public static final String ERR_JOB_NAME_INVALID_CHARS = "XX_JOB_NAME_INVALID_CHARS";
    
    /** Job name invalid format */
    public static final String ERR_JOB_NAME_INVALID_FORMAT = "XX_JOB_NAME_INVALID_FORMAT";
    
    /** Headcount out of range */
    public static final String ERR_JOB_HEADCOUNT_OUT_OF_RANGE = "XX_JOB_HEADCOUNT_OUT_OF_RANGE";
    
    /** Cannot delete job with positions */
    public static final String ERR_JOB_CANNOT_DELETE_WITH_POSITIONS = "XX_JOB_CANNOT_DELETE_WITH_POSITIONS";
    
    /** Temporary job headcount limit */
    public static final String ERR_JOB_TEMP_HEADCOUNT_LIMIT = "XX_JOB_TEMP_HEADCOUNT_LIMIT";
    
    /** End date required for permanent job */
    public static final String ERR_JOB_END_DATE_REQUIRED = "XX_JOB_END_DATE_REQUIRED";
    
    // ========================================
    // POSITION MESSAGES
    // ========================================
    
    /** Position start date before job start */
    public static final String ERR_POSITION_START_BEFORE_JOB = "XX_POSITION_START_BEFORE_JOB";
    
    /** Position end date after job end */
    public static final String ERR_POSITION_END_AFTER_JOB = "XX_POSITION_END_AFTER_JOB";
    
    // ========================================
    // TRANSFER MESSAGES
    // ========================================
    
    /** Duplicate transfer exists */
    public static final String ERR_TRANSFER_DUPLICATE = "XX_TRANSFER_DUPLICATE";
    
    // ========================================
    // SECURITY MESSAGES
    // ========================================
    
    /** Access denied - insufficient privileges */
    public static final String ERR_ACCESS_DENIED = "XX_ACCESS_DENIED";
    
    /** Function not available */
    public static final String ERR_FUNCTION_NOT_AVAILABLE = "XX_FUNCTION_NOT_AVAILABLE";
    
    // ========================================
    // DATABASE ERROR MESSAGES
    // ========================================
    
    /** Database connection error */
    public static final String ERR_DB_CONNECTION = "XX_DB_CONNECTION";
    
    /** Database constraint violation */
    public static final String ERR_DB_CONSTRAINT = "XX_DB_CONSTRAINT";
    
    /** Foreign key violation */
    public static final String ERR_DB_FOREIGN_KEY = "XX_DB_FOREIGN_KEY";
    
    /** Database error occurred */
    public static final String ERR_DB_ERROR = "XX_DB_ERROR";
    
    // ========================================
    // PLSQL INTEGRATION MESSAGES
    // ========================================
    
    /** Error calling PL/SQL function */
    public static final String ERR_PLSQL_FUNCTION = "XX_PLSQL_FUNCTION";
    
    /** Error calling PL/SQL procedure */
    public static final String ERR_PLSQL_PROCEDURE = "XX_PLSQL_PROCEDURE";
    
    /** Error in batch processing */
    public static final String ERR_PLSQL_BATCH = "XX_PLSQL_BATCH";
    
    /** Error executing anonymous block */
    public static final String ERR_PLSQL_ANONYMOUS = "XX_PLSQL_ANONYMOUS";
    
    // ========================================
    // EXCEL INTEGRATION MESSAGES
    // ========================================
    
    /** Invalid Excel file format */
    public static final String ERR_EXCEL_INVALID_FORMAT = "XX_EXCEL_INVALID_FORMAT";
    
    /** File size exceeds limit */
    public static final String ERR_EXCEL_FILE_TOO_LARGE = "XX_EXCEL_FILE_TOO_LARGE";
    
    /** Error uploading Excel file */
    public static final String ERR_EXCEL_UPLOAD = "XX_EXCEL_UPLOAD";
    
    /** No data to export */
    public static final String ERR_EXCEL_NO_DATA = "XX_EXCEL_NO_DATA";
    
    /** Error exporting to Excel */
    public static final String ERR_EXCEL_EXPORT = "XX_EXCEL_EXPORT";
    
    /** Error streaming Excel file */
    public static final String ERR_EXCEL_STREAM = "XX_EXCEL_STREAM";
    
    // ========================================
    // APPLICATION MODULE MESSAGES
    // ========================================
    
    /** Application Module not found */
    public static final String ERR_AM_NOT_FOUND = "XX_AM_NOT_FOUND";
    
    /** Error saving changes */
    public static final String ERR_AM_SAVE_ERROR = "XX_AM_SAVE_ERROR";
    
    // ========================================
    // VIEW OBJECT MESSAGES
    // ========================================
    
    /** View Object not found */
    public static final String ERR_VO_NOT_FOUND = "XX_VO_NOT_FOUND";
    
    /** Row not found */
    public static final String ERR_VO_ROW_NOT_FOUND = "XX_VO_ROW_NOT_FOUND";
    
    // ========================================
    // LOV MESSAGES
    // ========================================
    
    /** Invalid LOV selection */
    public static final String ERR_LOV_INVALID_SELECTION = "XX_LOV_INVALID_SELECTION";
    
    /** LOV value required */
    public static final String ERR_LOV_VALUE_REQUIRED = "XX_LOV_VALUE_REQUIRED";
    
    // ========================================
    // LAB MESSAGES
    // ========================================
    
    /** No employees found */
    public static final String LAB_NO_EMPLOYEES_FOUND = "XXLAB_NO_EMPLOYEES";
    
    /** Search criteria cleared */
    public static final String LAB_SEARCH_CLEARED = "XXLAB_SEARCH_CLEARED";
    
    /** Please select employee first */
    public static final String LAB_SELECT_EMPLOYEE_FIRST = "XXLAB_SELECT_EMPLOYEE";
    
    /** Please select job history record */
    public static final String LAB_SELECT_JOB_HISTORY = "XXLAB_SELECT_JOB_HISTORY";
    
    /** Job history record not found */
    public static final String LAB_JOB_HISTORY_NOT_FOUND = "XXLAB_JOB_HISTORY_NOT_FOUND";
    
    /**
     * Private constructor to prevent instantiation
     */
    private MessageConstants() {
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
}
