package oracle.apps.fnd.framework.foundation.utilities;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

/**
 * ValidationHelper - Generic validation utility.
 * 
 * Provides reusable validation patterns for common business rules.
 * Centralizes validation logic to ensure consistency across the application.
 * 
 * USAGE:
 * <pre>
 * // In Entity Object or Application Module
 * ValidationHelper.validateRequired(employeeName, "Employee Name");
 * ValidationHelper.validateRange(salary, 0, 999999, "Salary");
 * ValidationHelper.validateEmail(email, "Email Address");
 * ValidationHelper.validateDateRange(hireDate, minDate, maxDate, "Hire Date");
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class ValidationHelper {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private ValidationHelper() {
    }
    
    /**
     * Validates that a value is not null or empty.
     * 
     * @param value the value to validate
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateRequired(Object value, String fieldName) {
        if (value == null || (value instanceof String && ((String)value).trim().length() == 0)) {
            throw new OAException("FND", fieldName + " is required");
        }
    }
    
    /**
     * Validates that a number is within range.
     * 
     * @param value the number value
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateRange(Number value, int min, int max, String fieldName) {
        if (value != null) {
            int intValue = value.intValue();
            if (intValue < min || intValue > max) {
                throw new OAException("FND", fieldName + " must be between " + min + " and " + max);
            }
        }
    }
    
    /**
     * Validates that a date is within range.
     * 
     * @param value the date value
     * @param minDate minimum date (can be null)
     * @param maxDate maximum date (can be null)
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateDateRange(Date value, Date minDate, Date maxDate, String fieldName) {
        if (value != null) {
            if ((minDate != null && value.compareTo(minDate) < 0) ||
                (maxDate != null && value.compareTo(maxDate) > 0)) {
                throw new OAException("FND", fieldName + " must be between " + 
                                     minDate + " and " + maxDate);
            }
        }
    }
    
    /**
     * Validates string length.
     * 
     * @param value the string value
     * @param maxLength maximum allowed length
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateLength(String value, int maxLength, String fieldName) {
        if (value != null && value.length() > maxLength) {
            throw new OAException("FND", fieldName + " must be " + maxLength + " characters or less");
        }
    }
    
    /**
     * Validates that a string matches a pattern.
     * 
     * @param value the string value
     * @param pattern the regex pattern
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validatePattern(String value, String pattern, String fieldName) {
        if (value != null && !value.matches(pattern)) {
            throw new OAException("FND", fieldName + " format is invalid");
        }
    }
    
    /**
     * Validates email address format.
     * 
     * @param email the email address
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateEmail(String email, String fieldName) {
        if (email != null && email.trim().length() > 0) {
            String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (!email.matches(emailPattern)) {
                throw new OAException("FND", fieldName + " must be a valid email address");
            }
        }
    }
    
    /**
     * Validates phone number format (digits and hyphens only).
     * 
     * @param phone the phone number
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validatePhone(String phone, String fieldName) {
        if (phone != null && phone.trim().length() > 0) {
            String phonePattern = "^[0-9-()+ ]+$";
            if (!phone.matches(phonePattern)) {
                throw new OAException("FND", fieldName + " must contain only numbers and hyphens");
            }
        }
    }
    
    /**
     * Validates that a number is positive.
     * 
     * @param value the number value
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validatePositive(Number value, String fieldName) {
        if (value != null && value.intValue() <= 0) {
            throw new OAException("FND", fieldName + " must be a positive number");
        }
    }
    
    /**
     * Validates that a number is non-negative.
     * 
     * @param value the number value
     * @param fieldName the field name for error message
     * @throws OAException if validation fails
     */
    public static void validateNonNegative(Number value, String fieldName) {
        if (value != null && value.intValue() < 0) {
            throw new OAException("FND", fieldName + " must be non-negative");
        }
    }
    
    /**
     * Validates that value1 <= value2.
     * 
     * @param value1 the first value
     * @param value2 the second value
     * @param field1Name the first field name
     * @param field2Name the second field name
     * @throws OAException if validation fails
     */
    public static void validateFromToRange(Number value1, Number value2, 
                                          String field1Name, String field2Name) {
        if (value1 != null && value2 != null) {
            if (value1.compareTo(value2) > 0) {
                throw new OAException("FND", field1Name + " must be less than or equal to " + field2Name);
            }
        }
    }
    
    /**
     * Validates that date1 <= date2.
     * 
     * @param date1 the first date
     * @param date2 the second date
     * @param field1Name the first field name
     * @param field2Name the second field name
     * @throws OAException if validation fails
     */
    public static void validateFromToDateRange(Date date1, Date date2,
                                               String field1Name, String field2Name) {
        if (date1 != null && date2 != null) {
            if (date1.compareTo(date2) > 0) {
                throw new OAException("FND", field1Name + " must be before or equal to " + field2Name);
            }
        }
    }
}
