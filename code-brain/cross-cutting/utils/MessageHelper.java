package oracle.apps.xxcust.oaf.codebrain.utils;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;

/**
 * Message Helper Utility - Reusable Error Message Creation
 * 
 * Provides centralized methods for creating OAF exceptions with proper
 * message codes from FND_MESSAGES table. Eliminates hardcoded error
 * messages and ensures consistent error handling across the application.
 * 
 * Benefits:
 * - Multi-language support (i18n)
 * - Centralized message management
 * - No code changes for message updates
 * - Token substitution support
 * - Consistent error handling
 * 
 * Usage Pattern:
 * Instead of: throw new OAException("Employee Name is required", OAException.ERROR);
 * Use: throw MessageHelper.createError(MessageConstants.ERR_EMP_NAME_REQUIRED, fieldName);
 * 
 * Layer: Cross-cutting - Utilities
 * Complexity: Intermediate
 * Version: 1.4.0
 * 
 * @author OAF Code Brain
 * @version 1.4.0
 */
public class MessageHelper {
    
    /**
     * Create error exception with message code (no tokens)
     * 
     * @param messageCode Message code from MessageConstants
     * @return OAException with error severity
     */
    public static OAException createError(String messageCode) {
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.ERROR, null);
    }
    
    /**
     * Create error exception with message code and single token
     * 
     * @param messageCode Message code from MessageConstants
     * @param token1 First token value (replaces &TOKEN1 in message)
     * @return OAException with error severity
     */
    public static OAException createError(String messageCode, String token1) {
        OAException error = new OAException(MessageConstants.APP_XX, messageCode);
        error.setApplicationModule(token1);
        return error;
    }
    
    /**
     * Create error exception with message code and multiple tokens
     * 
     * @param messageCode Message code from MessageConstants
     * @param tokens Array of token values
     * @return OAException with error severity
     */
    public static OAException createError(String messageCode, String[] tokens) {
        return new OAException(MessageConstants.APP_XX, messageCode, tokens, 
                             OAException.ERROR, null);
    }
    
    /**
     * Create error exception with custom application short name
     * 
     * @param appShortName Application short name (XX, XXVAL, XXLAB)
     * @param messageCode Message code
     * @return OAException with error severity
     */
    public static OAException createError(String appShortName, String messageCode) {
        return new OAException(appShortName, messageCode, null, 
                             OAException.ERROR, null);
    }
    
    /**
     * Create error exception with custom application and token
     * 
     * @param appShortName Application short name
     * @param messageCode Message code
     * @param token1 Token value
     * @return OAException with error severity
     */
    public static OAException createError(String appShortName, String messageCode, 
                                         String token1) {
        OAException error = new OAException(appShortName, messageCode);
        error.setApplicationModule(token1);
        return error;
    }
    
    /**
     * Create warning exception with message code
     * 
     * @param messageCode Message code from MessageConstants
     * @return OAException with warning severity
     */
    public static OAException createWarning(String messageCode) {
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.WARNING, null);
    }
    
    /**
     * Create warning exception with message code and token
     * 
     * @param messageCode Message code from MessageConstants
     * @param token1 Token value
     * @return OAException with warning severity
     */
    public static OAException createWarning(String messageCode, String token1) {
        OAException error = new OAException(MessageConstants.APP_XX, messageCode);
        error.setApplicationModule(token1);
        return error;
    }
    
    /**
     * Create confirmation exception with message code
     * 
     * @param messageCode Message code from MessageConstants
     * @return OAException with confirmation severity
     */
    public static OAException createConfirmation(String messageCode) {
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.CONFIRMATION, null);
    }
    
    /**
     * Create confirmation exception with message code and token
     * 
     * @param messageCode Message code from MessageConstants
     * @param token1 Token value
     * @return OAException with confirmation severity
     */
    public static OAException createConfirmation(String messageCode, String token1) {
        OAException error = new OAException(MessageConstants.APP_XX, messageCode);
        error.setApplicationModule(token1);
        return error;
    }
    
    /**
     * Create information exception with message code
     * 
     * @param messageCode Message code from MessageConstants
     * @return OAException with information severity
     */
    public static OAException createInformation(String messageCode) {
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.INFORMATION, null);
    }
    
    /**
     * Create information exception with message code and token
     * 
     * @param messageCode Message code from MessageConstants
     * @param token1 Token value
     * @return OAException with information severity
     */
    public static OAException createInformation(String messageCode, String token1) {
        OAException error = new OAException(MessageConstants.APP_XX, messageCode);
        error.setApplicationModule(token1);
        return error;
    }
    
    /**
     * Create validation error for DataValidation utilities
     * 
     * @param messageCode Validation message code (XXVAL_*)
     * @param fieldName Field name for token substitution
     * @return OAException with error severity
     */
    public static OAException createValidationError(String messageCode, String fieldName) {
        OAException error = new OAException(MessageConstants.APP_XXVAL, messageCode);
        error.setApplicationModule(fieldName);
        return error;
    }
    
    /**
     * Create lab exercise error
     * 
     * @param messageCode Lab message code (XXLAB_*)
     * @return OAException with error severity
     */
    public static OAException createLabError(String messageCode) {
        return new OAException(MessageConstants.APP_XXLAB, messageCode, null, 
                             OAException.ERROR, null);
    }
    
    /**
     * Create lab exercise information message
     * 
     * @param messageCode Lab message code (XXLAB_*)
     * @return OAException with information severity
     */
    public static OAException createLabInfo(String messageCode) {
        return new OAException(MessageConstants.APP_XXLAB, messageCode, null, 
                             OAException.INFORMATION, null);
    }
    
    /**
     * Wrap SQLException with proper OAF exception
     * 
     * @param sqlCode SQL error code
     * @param originalException Original SQLException
     * @return OAException with appropriate message code
     */
    public static OAException createDatabaseError(int sqlCode, Exception originalException) {
        String messageCode;
        
        // Map common SQL error codes to message codes
        if (sqlCode == 1) {
            messageCode = MessageConstants.ERR_DUPLICATE_RECORD;
        } else if (sqlCode == 2291 || sqlCode == 2292) {
            messageCode = MessageConstants.ERR_DB_FOREIGN_KEY;
        } else if (sqlCode >= 2290 && sqlCode <= 2299) {
            messageCode = MessageConstants.ERR_DB_CONSTRAINT;
        } else {
            messageCode = MessageConstants.ERR_DB_ERROR;
        }
        
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.ERROR, originalException);
    }
    
    /**
     * Create PL/SQL error with original exception
     * 
     * @param messageCode Message code (ERR_PLSQL_*)
     * @param originalException Original exception
     * @return OAException wrapping original exception
     */
    public static OAException createPLSQLError(String messageCode, 
                                               Exception originalException) {
        return new OAException(MessageConstants.APP_XX, messageCode, null, 
                             OAException.ERROR, originalException);
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private MessageHelper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}
