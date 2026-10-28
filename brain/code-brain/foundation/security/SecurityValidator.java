package oracle.apps.fnd.framework.foundation.security;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;

/**
 * SecurityValidator - Input validation and SQL injection prevention utility.
 * 
 * Provides security validation patterns to prevent common vulnerabilities:
 * - SQL injection prevention
 * - XSS (Cross-Site Scripting) prevention
 * - Input sanitization
 * - Dangerous character detection
 * 
 * USAGE:
 * <pre>
 * // Validate user input before using in SQL
 * String safeInput = SecurityValidator.sanitizeInput(userInput);
 * 
 * // Check for SQL injection patterns
 * if (SecurityValidator.containsSQLInjection(userInput)) {
 *     throw new OAException("Invalid input detected");
 * }
 * 
 * // Validate against whitelist
 * SecurityValidator.validateAlphanumeric(employeeNumber, "Employee Number");
 * </pre>
 * 
 * BEST PRACTICE:
 * Always use ViewCriteria or bind variables instead of concatenating user input into SQL.
 * Use this class as an additional layer of defense.
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class SecurityValidator {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    // SQL injection patterns to detect
    private static final String[] SQL_INJECTION_PATTERNS = {
        "--", ";", "/*", "*/", "xp_", "sp_", "exec", "execute", 
        "select", "insert", "update", "delete", "drop", "create",
        "alter", "union", "script", "javascript", "vbscript"
    };
    
    // XSS patterns to detect
    private static final String[] XSS_PATTERNS = {
        "<script", "</script", "javascript:", "onerror=", "onload=",
        "<iframe", "<object", "<embed", "eval("
    };
    
    /**
     * Private constructor - utility class.
     */
    private SecurityValidator() {
    }
    
    /**
     * Sanitizes user input by removing dangerous characters.
     * WARNING: Prefer bind variables over sanitization!
     * 
     * @param input the user input
     * @return sanitized input
     */
    public static String sanitizeInput(String input) {
        if (input == null || input.trim().length() == 0) {
            return input;
        }
        
        // Remove common SQL injection characters
        String sanitized = input.replaceAll("'", "''")  // Escape single quotes
                                .replaceAll(";", "")     // Remove semicolons
                                .replaceAll("--", "");   // Remove SQL comments
        
        return sanitized;
    }
    
    /**
     * Checks if input contains potential SQL injection patterns.
     * 
     * @param input the user input
     * @return true if SQL injection pattern detected
     */
    public static boolean containsSQLInjection(String input) {
        if (input == null || input.trim().length() == 0) {
            return false;
        }
        
        String lowerInput = input.toLowerCase();
        for (int i = 0; i < SQL_INJECTION_PATTERNS.length; i++) {
            if (lowerInput.indexOf(SQL_INJECTION_PATTERNS[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if input contains potential XSS patterns.
     * 
     * @param input the user input
     * @return true if XSS pattern detected
     */
    public static boolean containsXSS(String input) {
        if (input == null || input.trim().length() == 0) {
            return false;
        }
        
        String lowerInput = input.toLowerCase();
        for (int i = 0; i < XSS_PATTERNS.length; i++) {
            if (lowerInput.indexOf(XSS_PATTERNS[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Validates that input contains only alphanumeric characters.
     * 
     * @param input the user input
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateAlphanumeric(String input, String fieldName) {
        if (input != null && !input.matches("^[a-zA-Z0-9]+$")) {
            throw new OAException("FND", fieldName + " must contain only letters and numbers");
        }
    }
    
    /**
     * Validates that input contains only alphanumeric characters and spaces.
     * 
     * @param input the user input
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateAlphanumericWithSpaces(String input, String fieldName) {
        if (input != null && !input.matches("^[a-zA-Z0-9 ]+$")) {
            throw new OAException("FND", fieldName + " must contain only letters, numbers, and spaces");
        }
    }
    
    /**
     * Validates that input contains only numeric characters.
     * 
     * @param input the user input
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateNumeric(String input, String fieldName) {
        if (input != null && !input.matches("^[0-9]+$")) {
            throw new OAException("FND", fieldName + " must contain only numbers");
        }
    }
    
    /**
     * Validates input against SQL injection and throws exception if detected.
     * 
     * @param input the user input
     * @param fieldName the field name for error message
     * @throws OAException if SQL injection detected
     */
    public static void validateNoSQLInjection(String input, String fieldName) {
        if (containsSQLInjection(input)) {
            throw new OAException("FND", "Invalid characters detected in " + fieldName);
        }
    }
    
    /**
     * Validates input against XSS and throws exception if detected.
     * 
     * @param input the user input
     * @param fieldName the field name for error message
     * @throws OAException if XSS detected
     */
    public static void validateNoXSS(String input, String fieldName) {
        if (containsXSS(input)) {
            throw new OAException("FND", "Invalid characters detected in " + fieldName);
        }
    }
    
    /**
     * Encodes HTML special characters to prevent XSS.
     * 
     * @param input the user input
     * @return HTML-encoded string
     */
    public static String encodeHTML(String input) {
        if (input == null || input.trim().length() == 0) {
            return input;
        }
        
        return input.replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;")
                    .replaceAll("'", "&#x27;");
    }
    
    /**
     * Validates that input length is within acceptable limits.
     * Prevents buffer overflow and DOS attacks.
     * 
     * @param input the user input
     * @param maxLength maximum allowed length
     * @param fieldName the field name for error message
     * @throws OAException if length exceeds maximum
     */
    public static void validateMaxLength(String input, int maxLength, String fieldName) {
        if (input != null && input.length() > maxLength) {
            throw new OAException("FND", fieldName + " exceeds maximum length of " + maxLength);
        }
    }
}
