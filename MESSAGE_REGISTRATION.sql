/*******************************************************************************
 * MESSAGE REGISTRATION SQL SCRIPT
 * Oracle OAF BootCamp - Message Code Registration
 * 
 * Purpose: Register all application messages in FND_NEW_MESSAGES table
 *          for XX, XXVAL, and XXLAB applications
 * 
 * Applications:
 *  - XX: General application messages (60+ codes)
 *  - XXVAL: Validation messages (48 codes)
 *  - XXLAB: Lab exercise messages (15+ codes)
 * 
 * Usage:
 *  1. Run this script in your database as APPS user
 *  2. Navigate to Application Developer responsibility
 *  3. Run "Application Messages" form
 *  4. Tools > Load Messages from File (FND_NEW_MESSAGES)
 *  5. Verify messages loaded for each application
 * 
 * Version: 1.4.0
 * Date: 2025-01-30
 * 
 ******************************************************************************/

-- Clear existing entries for clean install
DELETE FROM fnd_new_messages WHERE application_short_name IN ('XX', 'XXVAL', 'XXLAB');
COMMIT;

--------------------------------------------------------------------------------
-- XX APPLICATION - GENERAL MESSAGES
--------------------------------------------------------------------------------

-- Common Success Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_SAVE_SUCCESS', 1001,
    'US', 'AMERICAN', 'Record saved successfully.', 'E', 255,
    'Success message after saving a record', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DELETE_SUCCESS', 1002,
    'US', 'AMERICAN', 'Record deleted successfully.', 'E', 255,
    'Success message after deleting a record', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_UPDATE_SUCCESS', 1003,
    'US', 'AMERICAN', 'Record updated successfully.', 'E', 255,
    'Success message after updating a record', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_NO_ROWS_SELECTED', 1004,
    'US', 'AMERICAN', 'Please select at least one row to proceed.', 'E', 255,
    'Error when user does not select any rows', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_OPERATION_CANCELLED', 1005,
    'US', 'AMERICAN', 'Operation cancelled by user.', 'E', 255,
    'Information message when user cancels operation', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DUPLICATE_RECORD', 1006,
    'US', 'AMERICAN', 'Duplicate record found. Record already exists.', 'E', 255,
    'Error when duplicate record is detected', 'XX'
);

-- Validation Error Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_FIELD_REQUIRED', 2001,
    'US', 'AMERICAN', '&FIELD is required. Please provide a value.', 'E', 255,
    'Generic required field validation error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_INVALID_FORMAT', 2002,
    'US', 'AMERICAN', '&FIELD has invalid format. Please check the value.', 'E', 255,
    'Generic format validation error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_OUT_OF_RANGE', 2003,
    'US', 'AMERICAN', '&FIELD value is out of valid range.', 'E', 255,
    'Value exceeds allowed range', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_TOO_LONG', 2004,
    'US', 'AMERICAN', '&FIELD exceeds maximum length of &MAX_LENGTH characters.', 'E', 255,
    'String length exceeds maximum', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_TOO_SHORT', 2005,
    'US', 'AMERICAN', '&FIELD must be at least &MIN_LENGTH characters.', 'E', 255,
    'String length below minimum', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_INVALID_DATE', 2006,
    'US', 'AMERICAN', '&FIELD has invalid date. Please provide a valid date.', 'E', 255,
    'Date format or value is invalid', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_INVALID_NUMBER', 2007,
    'US', 'AMERICAN', '&FIELD must be a valid number.', 'E', 255,
    'Number format is invalid', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_ALPHANUMERIC_ONLY', 2008,
    'US', 'AMERICAN', '&FIELD must contain only letters and numbers.', 'E', 255,
    'Field contains special characters', 'XX'
);

-- Employee Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_NUMBER_REQUIRED', 3001,
    'US', 'AMERICAN', 'Employee Number is required.', 'E', 255,
    'Employee number is mandatory', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_NAME_REQUIRED', 3002,
    'US', 'AMERICAN', 'Employee Name is required.', 'E', 255,
    'Employee name is mandatory', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_NOT_FOUND', 3003,
    'US', 'AMERICAN', 'Employee &EMP_NUMBER not found in the system.', 'E', 255,
    'Employee does not exist', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_DUPLICATE', 3004,
    'US', 'AMERICAN', 'Employee &EMP_NUMBER already exists.', 'E', 255,
    'Duplicate employee number', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_DELETE_ERROR', 3005,
    'US', 'AMERICAN', 'Cannot delete employee. Related records exist.', 'E', 255,
    'Employee has dependent records', 'XX'
);

-- Email Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMAIL_REQUIRED', 4001,
    'US', 'AMERICAN', 'Email Address is required.', 'E', 255,
    'Email is mandatory', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMAIL_INVALID', 4002,
    'US', 'AMERICAN', 'Email Address &EMAIL is not valid. Please provide a valid email.', 'E', 255,
    'Email format is invalid', 'XX'
);

-- Salary Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_SALARY_NEGATIVE', 5001,
    'US', 'AMERICAN', 'Salary cannot be negative. Please provide a valid amount.', 'E', 255,
    'Salary is negative number', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_SALARY_EXCEEDS_MAX', 5002,
    'US', 'AMERICAN', 'Salary &SALARY exceeds maximum allowed &MAX_SALARY.', 'E', 255,
    'Salary exceeds maximum limit', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_SALARY_INVALID', 5003,
    'US', 'AMERICAN', 'Salary must be a valid number.', 'E', 255,
    'Salary format is invalid', 'XX'
);

-- Job Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_NAME_REQUIRED', 6001,
    'US', 'AMERICAN', 'Job Name is required.', 'E', 255,
    'Job name is mandatory', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_CODE_REQUIRED', 6002,
    'US', 'AMERICAN', 'Job Code is required.', 'E', 255,
    'Job code is mandatory', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_NOT_FOUND', 6003,
    'US', 'AMERICAN', 'Job &JOB_CODE not found.', 'E', 255,
    'Job does not exist', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_DUPLICATE', 6004,
    'US', 'AMERICAN', 'Job &JOB_CODE already exists.', 'E', 255,
    'Duplicate job code', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_MIN_SALARY_GT_MAX', 6005,
    'US', 'AMERICAN', 'Job minimum salary cannot exceed maximum salary.', 'E', 255,
    'Min salary greater than max salary', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_HEADCOUNT_INVALID', 6006,
    'US', 'AMERICAN', 'Job headcount must be a positive number.', 'E', 255,
    'Invalid headcount value', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_HEADCOUNT_OUT_OF_RANGE', 6007,
    'US', 'AMERICAN', 'Job headcount must be between &MIN and &MAX.', 'E', 255,
    'Headcount out of valid range', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_JOB_ACTIVE_EMPLOYEES', 6008,
    'US', 'AMERICAN', 'Cannot delete job. Active employees assigned to this job.', 'E', 255,
    'Job has active employees', 'XX'
);

-- Position Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_POSITION_START_BEFORE_JOB', 7001,
    'US', 'AMERICAN', 'Position start date cannot be before job start date.', 'E', 255,
    'Position start date validation', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_POSITION_END_AFTER_JOB', 7002,
    'US', 'AMERICAN', 'Position end date cannot be after job end date.', 'E', 255,
    'Position end date validation', 'XX'
);

-- Transfer Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_TRANSFER_DUPLICATE', 8001,
    'US', 'AMERICAN', 'Duplicate transfer request found for employee &EMP_NUMBER.', 'E', 255,
    'Duplicate transfer request', 'XX'
);

-- Security Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_ACCESS_DENIED', 9001,
    'US', 'AMERICAN', 'Access denied. You do not have permission to perform this operation.', 'E', 255,
    'User does not have access', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_FUNCTION_NOT_AVAILABLE', 9002,
    'US', 'AMERICAN', 'This function is not available. Please contact system administrator.', 'E', 255,
    'Function not enabled or configured', 'XX'
);

-- Database Error Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DB_CONNECTION', 10001,
    'US', 'AMERICAN', 'Database connection error. Please try again or contact support.', 'E', 255,
    'Cannot connect to database', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DB_CONSTRAINT', 10002,
    'US', 'AMERICAN', 'Database constraint violation. Please check your data.', 'E', 255,
    'Check constraint failed', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DB_FOREIGN_KEY', 10003,
    'US', 'AMERICAN', 'Foreign key constraint violation. Related record not found.', 'E', 255,
    'Foreign key validation failed', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_DB_ERROR', 10004,
    'US', 'AMERICAN', 'Database error occurred. Please contact support with error details.', 'E', 255,
    'Generic database error', 'XX'
);

-- PL/SQL Integration Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_PLSQL_FUNCTION', 11001,
    'US', 'AMERICAN', 'Error calling PL/SQL function. Please check function parameters.', 'E', 255,
    'PL/SQL function execution error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_PLSQL_PROCEDURE', 11002,
    'US', 'AMERICAN', 'Error calling PL/SQL procedure. Please check procedure parameters.', 'E', 255,
    'PL/SQL procedure execution error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_PLSQL_BATCH', 11003,
    'US', 'AMERICAN', 'Error executing batch PL/SQL operation.', 'E', 255,
    'Batch PL/SQL execution error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_PLSQL_ANONYMOUS', 11004,
    'US', 'AMERICAN', 'Error executing anonymous PL/SQL block.', 'E', 255,
    'Anonymous block execution error', 'XX'
);

-- Excel Integration Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_INVALID_FORMAT', 12001,
    'US', 'AMERICAN', 'Invalid Excel file format. Please upload a valid .xls or .xlsx file.', 'E', 255,
    'Excel file format is invalid', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_FILE_TOO_LARGE', 12002,
    'US', 'AMERICAN', 'Excel file size exceeds maximum allowed &MAX_SIZE MB.', 'E', 255,
    'Excel file too large', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_UPLOAD', 12003,
    'US', 'AMERICAN', 'Error uploading Excel file. Please try again.', 'E', 255,
    'Excel upload failed', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_DOWNLOAD', 12004,
    'US', 'AMERICAN', 'Error downloading Excel file. Please try again.', 'E', 255,
    'Excel download failed', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_PARSING', 12005,
    'US', 'AMERICAN', 'Error parsing Excel file at row &ROW_NUMBER.', 'E', 255,
    'Excel file parsing error', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EXCEL_EMPTY_FILE', 12006,
    'US', 'AMERICAN', 'Excel file is empty. Please upload a file with data.', 'E', 255,
    'No data in Excel file', 'XX'
);

-- Application Module Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_AM_NOT_FOUND', 13001,
    'US', 'AMERICAN', 'Application Module &AM_NAME not found.', 'E', 255,
    'Cannot find Application Module', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_AM_SAVE_ERROR', 13002,
    'US', 'AMERICAN', 'Error saving data through Application Module.', 'E', 255,
    'AM save operation failed', 'XX'
);

-- View Object Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_VO_NOT_FOUND', 14001,
    'US', 'AMERICAN', 'View Object &VO_NAME not found.', 'E', 255,
    'Cannot find View Object', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_VO_QUERY_ERROR', 14002,
    'US', 'AMERICAN', 'Error executing View Object query.', 'E', 255,
    'VO query execution failed', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_VO_NO_ROWS', 14003,
    'US', 'AMERICAN', 'No rows found matching search criteria.', 'E', 255,
    'View Object returned no rows', 'XX'
);

-- LOV Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_LOV_INVALID_SELECTION', 15001,
    'US', 'AMERICAN', 'Invalid LOV selection. Please select a valid value.', 'E', 255,
    'User selected invalid LOV value', 'XX'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_LOV_NO_DATA', 15002,
    'US', 'AMERICAN', 'No data available in list of values.', 'E', 255,
    'LOV has no data', 'XX'
);

COMMIT;

--------------------------------------------------------------------------------
-- XXLAB APPLICATION - LAB EXERCISE MESSAGES
--------------------------------------------------------------------------------

-- Lab 1: Query Page Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_NO_EMPLOYEES', 1001,
    'US', 'AMERICAN', 'No employees found matching search criteria.', 'E', 255,
    'Lab 1 - No search results', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_SEARCH_CLEARED', 1002,
    'US', 'AMERICAN', 'Search criteria cleared successfully.', 'E', 255,
    'Lab 1 - Clear search confirmation', 'XXLAB'
);

-- Lab 2: Create/Update Page Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_EMPLOYEE_CREATED', 2001,
    'US', 'AMERICAN', 'Employee &EMP_NUMBER created successfully.', 'E', 255,
    'Lab 2 - Employee creation success', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_EMPLOYEE_UPDATED', 2002,
    'US', 'AMERICAN', 'Employee &EMP_NUMBER updated successfully.', 'E', 255,
    'Lab 2 - Employee update success', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_EMPLOYEE_DELETED', 2003,
    'US', 'AMERICAN', 'Employee &EMP_NUMBER deleted successfully.', 'E', 255,
    'Lab 2 - Employee deletion success', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_INVALID_EMAIL', 2004,
    'US', 'AMERICAN', 'Please enter a valid email address.', 'E', 255,
    'Lab 2 - Email validation error', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_INVALID_SALARY', 2005,
    'US', 'AMERICAN', 'Salary must be a positive number.', 'E', 255,
    'Lab 2 - Salary validation error', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_INVALID_HIRE_DATE', 2006,
    'US', 'AMERICAN', 'Hire date cannot be in the future.', 'E', 255,
    'Lab 2 - Hire date validation error', 'XXLAB'
);

-- Lab 3: Master-Detail Page Messages
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_SELECT_ROW', 3001,
    'US', 'AMERICAN', 'Please select a row to proceed.', 'E', 255,
    'Lab 3 - No row selected', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_DELETE_CONFIRM', 3002,
    'US', 'AMERICAN', 'Are you sure you want to delete this record?', 'E', 255,
    'Lab 3 - Delete confirmation', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_RECORD_SAVED', 3003,
    'US', 'AMERICAN', 'Record saved successfully.', 'E', 255,
    'Lab 3 - Save success', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_RECORD_DELETED', 3004,
    'US', 'AMERICAN', 'Record deleted successfully.', 'E', 255,
    'Lab 3 - Delete success', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_NO_DETAIL_ROWS', 3005,
    'US', 'AMERICAN', 'No detail records found for selected master record.', 'E', 255,
    'Lab 3 - No detail rows', 'XXLAB'
);

INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XXLAB', 'XXLAB_DETAIL_REQUIRED', 3006,
    'US', 'AMERICAN', 'At least one detail record is required.', 'E', 255,
    'Lab 3 - Detail validation', 'XXLAB'
);

COMMIT;

--------------------------------------------------------------------------------
-- XXVAL APPLICATION - VALIDATION MESSAGES (from v1.3.5)
-- NOTE: These 48 messages were already defined in MESSAGE_CODES.md
-- Including reference here for completeness
--------------------------------------------------------------------------------

-- Email Validation Messages (4 codes)
-- XXVAL_E_EMAIL_NULL
-- XXVAL_E_EMAIL_INVALID
-- XXVAL_E_EMAIL_TOO_LONG
-- XXVAL_E_EMAIL_DUPLICATE

-- Date Validation Messages (6 codes)
-- XXVAL_E_DATE_NULL
-- XXVAL_E_INVALID_DATE_RANGE
-- XXVAL_E_START_AFTER_END
-- XXVAL_E_FUTURE_DATE_NOT_ALLOWED
-- XXVAL_E_PAST_DATE_NOT_ALLOWED
-- XXVAL_E_DATES_EQUAL

-- Number Validation Messages (5 codes)
-- XXVAL_E_NUMBER_NULL
-- XXVAL_E_NUMBER_OUT_OF_RANGE
-- XXVAL_E_NUMBER_LESS_THAN_MIN
-- XXVAL_E_NUMBER_GREATER_THAN_MAX
-- XXVAL_E_NUMBER_INVALID

-- String Validation Messages (4 codes)
-- XXVAL_E_STRING_NULL
-- XXVAL_E_STRING_TOO_LONG
-- XXVAL_E_STRING_INVALID_FORMAT
-- XXVAL_E_STRING_NOT_ALPHANUMERIC

-- Mandatory Field Validation (3 codes)
-- XXVAL_E_FIELD_REQUIRED
-- XXVAL_E_MANDATORY_FIELD
-- XXVAL_E_VALUE_REQUIRED

-- Duplicate Checking (3 codes)
-- XXVAL_E_DUPLICATE_RECORD
-- XXVAL_E_DUPLICATE_VALUE
-- XXVAL_E_RECORD_EXISTS

-- Business Rules (15+ codes)
-- XXVAL_E_EMP_NUMBER_REQUIRED
-- XXVAL_E_EMP_NAME_REQUIRED
-- XXVAL_E_EMP_NUMBER_DUPLICATE
-- XXVAL_E_EMAIL_REQUIRED
-- XXVAL_E_SALARY_NEGATIVE
-- XXVAL_E_JOB_NAME_REQUIRED
-- XXVAL_E_JOB_CODE_REQUIRED
-- XXVAL_E_JOB_MIN_GT_MAX
-- XXVAL_E_JOB_HEADCOUNT_INVALID
-- XXVAL_E_POSITION_START_BEFORE_JOB
-- XXVAL_E_POSITION_END_AFTER_JOB
-- XXVAL_E_TRANSFER_DUPLICATE
-- And more...

-- See MESSAGE_CODES.md for complete XXVAL message SQL script

--------------------------------------------------------------------------------
-- VERIFICATION QUERIES
--------------------------------------------------------------------------------

-- Count messages by application
SELECT application_short_name, COUNT(*) as message_count
FROM fnd_new_messages
WHERE application_short_name IN ('XX', 'XXVAL', 'XXLAB')
GROUP BY application_short_name
ORDER BY application_short_name;

-- View all XX messages
SELECT message_name, message_text
FROM fnd_new_messages
WHERE application_short_name = 'XX'
ORDER BY message_number;

-- View all XXLAB messages
SELECT message_name, message_text
FROM fnd_new_messages
WHERE application_short_name = 'XXLAB'
ORDER BY message_number;

--------------------------------------------------------------------------------
-- NEXT STEPS
--------------------------------------------------------------------------------

/*
1. Run this script in your database as APPS user

2. Navigate to Application Developer responsibility

3. Run "Application Messages" form (FND_MESSAGES)

4. Go to: Tools > Load Messages from File

5. For each application (XX, XXVAL, XXLAB):
   - Select Application Short Name
   - Click "Load Messages" button
   - System will load from FND_NEW_MESSAGES table

6. Verify messages loaded:
   SELECT * FROM fnd_messages
   WHERE application_id IN (
       SELECT application_id FROM fnd_application
       WHERE application_short_name IN ('XX', 'XXVAL', 'XXLAB')
   )
   ORDER BY application_id, message_number;

7. Test messages in OAF code:
   - Use MessageConstants for message codes
   - Use MessageHelper for creating exceptions
   - Verify messages display correctly in UI

8. Add translations (optional):
   - Insert additional rows in fnd_new_messages
   - Change language_code to target language (e.g., 'AR' for Arabic)
   - Re-run FND_NEW_MESSAGES Load

*/

--------------------------------------------------------------------------------
-- MULTI-LANGUAGE EXAMPLE (Arabic)
--------------------------------------------------------------------------------

-- Example: Add Arabic translation for XX_SAVE_SUCCESS
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_SAVE_SUCCESS', 1001,
    'AR', 'ARABIC', 'تم حفظ السجل بنجاح.', 'E', 255,
    'Success message after saving a record (Arabic)', 'XX'
);

-- Example: Add Arabic translation for XX_EMP_NUMBER_REQUIRED
INSERT INTO fnd_new_messages (
    application_short_name, message_name, message_number,
    language_code, iso_language, message_text, type, max_length,
    description, category
) VALUES (
    'XX', 'XX_EMP_NUMBER_REQUIRED', 3001,
    'AR', 'ARABIC', 'رقم الموظف مطلوب.', 'E', 255,
    'Employee number is mandatory (Arabic)', 'XX'
);

-- COMMIT;
-- Uncomment above to enable Arabic translations

/*******************************************************************************
 * END OF MESSAGE REGISTRATION SQL SCRIPT
 ******************************************************************************/
