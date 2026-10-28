package oracle.apps.xxcust.oaf.codebrain.validation;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.jbo.Row;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Data Validation Utilities for OAF
 * 
 * Comprehensive validation methods for common data types ensuring
 * data compatibility and integrity in Oracle Application Framework.
 * 
 * All validation methods throw OAException with proper message codes:
 * - Application Short Name: XXVAL (Custom Validation Messages)
 * - Message Pattern: XXVAL_<VALIDATION_TYPE>_<ERROR_CODE>
 * 
 * Message codes must be registered in FND_MESSAGES table.
 * 
 * Data Types Covered:
 * - String: Required, length, pattern, format validation
 * - Number: Range, positive/negative, decimal validation
 * - Date: Range, past/future, format validation
 * - Email: Format and domain validation
 * - Phone/Mobile: Format validation (Saudi Arabia, International)
 * - URL: Format and protocol validation
 * - IQAMA: Saudi National ID validation
 * - Custom: Business-specific validation patterns
 * 
 * Layer: Model - Validation
 * Complexity: Intermediate
 * Version: 1.3.5
 * 
 * @author OAF Code Brain
 * @version 1.3.5
 */
public class DataValidation {

    // Application Short Name for validation messages
    private static final String APP_SHORT_NAME = "XXVAL";

    // ========================================
    // STRING VALIDATION
    // ========================================

    /**
     * USE CASE 1: Validate Required String
     * 
     * Check if string is not null and not empty (after trimming).
     * 
     * When to use:
     * - Mandatory form fields
     * - Required API parameters
     * - Database NOT NULL columns
     * 
     * Message Code: XXVAL_REQUIRED_FIELD
     * Message Text: &FIELD_NAME is required.
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateRequired(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_REQUIRED_FIELD");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 2: Validate String Length
     * 
     * Check if string length is within specified range.
     * 
     * When to use:
     * - Database column constraints (VARCHAR2(100))
     * - Form field character limits
     * - API payload size restrictions
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param minLength Minimum allowed length (inclusive)
     * @param maxLength Maximum allowed length (inclusive)
     * @throws OAException if validation fails
     */
    public static void validateLength(String value, String fieldName, 
                                      int minLength, int maxLength) {
        if (value != null) {
            int length = value.length();
            
            if (length < minLength) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MIN_LENGTH");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            if (length > maxLength) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MAX_LENGTH");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 3: Validate String Pattern (Regex)
     * 
     * Check if string matches specified regular expression pattern.
     * 
     * When to use:
     * - Employee number format (EMP-12345)
     * - License plate format
     * - Custom code formats
     * - Alphanumeric-only fields
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param regex Regular expression pattern
     * @param exampleFormat Example of valid format for error message
     * @throws OAException if validation fails
     */
    public static void validatePattern(String value, String fieldName, 
                                       String regex, String exampleFormat) {
        if (value != null && !value.trim().isEmpty()) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            
            if (!matcher.matches()) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_PATTERN");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 4: Validate Alphanumeric Only
     * 
     * Check if string contains only letters and numbers (no special characters).
     * 
     * When to use:
     * - Username fields
     * - Product codes
     * - Reference numbers
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateAlphanumeric(String value, String fieldName) {
        if (value != null && !value.trim().isEmpty() && !value.matches("^[a-zA-Z0-9]+$")) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_ALPHANUMERIC_ONLY");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 5: Validate No Special Characters
     * 
     * Check if string contains only letters, numbers, spaces, and basic punctuation.
     * 
     * When to use:
     * - Name fields
     * - Address fields
     * - Description fields
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateNoSpecialChars(String value, String fieldName) {
        if (value != null && !value.trim().isEmpty() && 
            !value.matches("^[a-zA-Z0-9\\s.,'/\\-]+$")) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_SPECIAL_CHARS");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 23: Validate String Contains
     * 
     * Check if string contains a specific substring (case-insensitive).
     * 
     * When to use:
     * - Search validation
     * - Keyword validation
     * - Content filtering
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param requiredSubstring Required substring
     * @throws OAException if validation fails
     */
    public static void validateContains(String value, String fieldName, String requiredSubstring) {
        if (value != null && requiredSubstring != null && 
            !value.toLowerCase().contains(requiredSubstring.toLowerCase())) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_CONTAIN");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 24: Validate String Starts With
     * 
     * Check if string starts with a specific prefix.
     * 
     * When to use:
     * - Code prefixes (EMP-, DEPT-)
     * - Category validation
     * - Hierarchical codes
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param prefix Required prefix
     * @throws OAException if validation fails
     */
    public static void validateStartsWith(String value, String fieldName, String prefix) {
        if (value != null && prefix != null && !value.startsWith(prefix)) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_START_WITH");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 25: Validate String Case
     * 
     * Check if string is in uppercase or lowercase.
     * 
     * When to use:
     * - Code standardization
     * - Username policies
     * - Data normalization
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param uppercase True for uppercase, false for lowercase
     * @throws OAException if validation fails
     */
    public static void validateCase(String value, String fieldName, boolean uppercase) {
        if (value != null && !value.trim().isEmpty()) {
            if (uppercase && !value.equals(value.toUpperCase())) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_UPPERCASE");
                error.setApplicationModule(fieldName);
                throw error;
            } else if (!uppercase && !value.equals(value.toLowerCase())) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_LOWERCASE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 26: Validate String Not Contains
     * 
     * Check if string does NOT contain forbidden characters or words.
     * 
     * When to use:
     * - SQL injection prevention
     * - XSS prevention
     * - Profanity filtering
     * 
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @param forbiddenStrings Array of forbidden strings
     * @throws OAException if validation fails
     */
    public static void validateNotContains(String value, String fieldName, String[] forbiddenStrings) {
        if (value != null && forbiddenStrings != null) {
            String lowerValue = value.toLowerCase();
            for (String forbidden : forbiddenStrings) {
                if (lowerValue.contains(forbidden.toLowerCase())) {
                    OAException error = new OAException(APP_SHORT_NAME, "XXVAL_FORBIDDEN_CONTENT");
                    error.setApplicationModule(fieldName);
                    throw error;
                }
            }
        }
    }

    // ========================================
    // NUMBER VALIDATION
    // ========================================

    /**
     * USE CASE 6: Validate Number Range
     * 
     * Check if number is within specified range.
     * 
     * When to use:
     * - Age validation (0-150)
     * - Quantity validation (1-9999)
     * - Percentage validation (0-100)
     * - Rating validation (1-5)
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @param min Minimum allowed value (inclusive)
     * @param max Maximum allowed value (inclusive)
     * @throws OAException if validation fails
     */
    public static void validateNumberRange(Number value, String fieldName, 
                                           double min, double max) {
        if (value != null) {
            double numValue = value.doubleValue();
            
            if (numValue < min || numValue > max) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_NUM_RANGE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 7: Validate Positive Number
     * 
     * Check if number is greater than zero.
     * 
     * When to use:
     * - Price fields
     * - Quantity fields
     * - Amount fields
     * - Salary fields
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validatePositive(Number value, String fieldName) {
        if (value != null) {
            double numValue = value.doubleValue();
            
            if (numValue <= 0) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_POSITIVE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 8: Validate Non-Negative Number
     * 
     * Check if number is zero or greater.
     * 
     * When to use:
     * - Discount fields (can be 0)
     * - Stock quantity (can be 0)
     * - Optional amount fields
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateNonNegative(Number value, String fieldName) {
        if (value != null) {
            double numValue = value.doubleValue();
            
            if (numValue < 0) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_CANNOT_BE_NEGATIVE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 9: Validate Decimal Places
     * 
     * Check if number has specified maximum decimal places.
     * 
     * When to use:
     * - Currency fields (2 decimal places)
     * - Weight fields (3 decimal places)
     * - Percentage fields (2 decimal places)
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @param maxDecimals Maximum allowed decimal places
     * @throws OAException if validation fails
     */
    public static void validateDecimalPlaces(Number value, String fieldName, 
                                             int maxDecimals) {
        if (value != null) {
            String valueStr = value.toString();
            
            if (valueStr.contains(".")) {
                String[] parts = valueStr.split("\\.");
                if (parts.length > 1 && parts[1].length() > maxDecimals) {
                    OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MAX_DECIMALS");
                    error.setApplicationModule(fieldName);
                    throw error;
                }
            }
        }
    }

    /**
     * USE CASE 10: Validate Integer Only
     * 
     * Check if value is a whole number (no decimals).
     * 
     * When to use:
     * - Quantity fields
     * - Count fields
     * - ID fields
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateInteger(Number value, String fieldName) {
        if (value != null) {
            double numValue = value.doubleValue();
            
            if (numValue != Math.floor(numValue)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_INTEGER");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 27: Validate Even Number
     * 
     * Check if number is even.
     * 
     * When to use:
     * - Pair requirements
     * - Even-numbered seats
     * - Batch processing (even batch sizes)
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateEven(Number value, String fieldName) {
        if (value != null) {
            long numValue = value.longValue();
            if (numValue % 2 != 0) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_EVEN");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 28: Validate Odd Number
     * 
     * Check if number is odd.
     * 
     * When to use:
     * - Odd-numbered seats
     * - Specific business rules
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateOdd(Number value, String fieldName) {
        if (value != null) {
            long numValue = value.longValue();
            if (numValue % 2 == 0) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MUST_BE_ODD");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 29: Validate Percentage
     * 
     * Check if number is a valid percentage (0-100).
     * 
     * When to use:
     * - Discount percentage
     * - Tax rate
     * - Completion percentage
     * - Score percentage
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validatePercentage(Number value, String fieldName) {
        if (value != null) {
            double numValue = value.doubleValue();
            if (numValue < 0 || numValue > 100) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_PERCENTAGE_RANGE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 30: Validate Divisible By
     * 
     * Check if number is divisible by a specific value.
     * 
     * When to use:
     * - Batch size validation
     * - Package quantity validation
     * - Multiple requirements
     * 
     * @param value Number to validate
     * @param fieldName Name of field for error message
     * @param divisor Number must be divisible by this value
     * @throws OAException if validation fails
     */
    public static void validateDivisibleBy(Number value, String fieldName, int divisor) {
        if (value != null && divisor != 0) {
            long numValue = value.longValue();
            if (numValue % divisor != 0) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DIVISIBLE_BY");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // DATE VALIDATION
    // ========================================

    /**
     * USE CASE 11: Validate Date Range
     * 
     * Check if date is within specified range.
     * 
     * When to use:
     * - Birth date (not in future)
     * - Event date (within year)
     * - Contract date (between start and end)
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @param minDate Minimum allowed date (inclusive)
     * @param maxDate Maximum allowed date (inclusive)
     * @throws OAException if validation fails
     */
    public static void validateDateRange(Date value, String fieldName, 
                                         Date minDate, Date maxDate) {
        if (value != null) {
            if (minDate != null && value.before(minDate)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_BEFORE");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            if (maxDate != null && value.after(maxDate)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_AFTER");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 12: Validate Date Not in Future
     * 
     * Check if date is today or in the past.
     * 
     * When to use:
     * - Birth date
     * - Hire date
     * - Transaction date
     * - Historical records
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @param currentDate Current date from database
     * @throws OAException if validation fails
     */
    public static void validateNotFuture(Date value, String fieldName, Date currentDate) {
        if (value != null && currentDate != null && value.after(currentDate)) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_FUTURE");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 13: Validate Date Not in Past
     * 
     * Check if date is today or in the future.
     * 
     * When to use:
     * - Event date
     * - Delivery date
     * - Expiry date
     * - Scheduled date
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @param currentDate Current date from database
     * @throws OAException if validation fails
     */
    public static void validateNotPast(Date value, String fieldName, Date currentDate) {
        if (value != null && currentDate != null && value.before(currentDate)) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_PAST");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 14: Validate Date Sequence
     * 
     * Check if end date is after start date.
     * 
     * When to use:
     * - Contract start/end dates
     * - Project start/end dates
     * - Leave from/to dates
     * - Period start/end dates
     * 
     * @param startDate Start date
     * @param endDate End date
     * @param startFieldName Name of start date field
     * @param endFieldName Name of end date field
     * @throws OAException if validation fails
     */
    public static void validateDateSequence(Date startDate, Date endDate,
                                           String startFieldName, String endFieldName) {
        if (startDate != null && endDate != null && endDate.before(startDate)) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_SEQUENCE");
            error.setApplicationModule(endFieldName);
            throw error;
        }
    }

    /**
     * USE CASE 15: Validate Minimum Age
     * 
     * Check if person is at least specified age based on birth date.
     * 
     * When to use:
     * - Employee hire (minimum 18 years)
     * - Legal consent requirements
     * - Service eligibility
     * 
     * @param birthDate Birth date
     * @param fieldName Name of field for error message
     * @param minAge Minimum required age in years
     * @param currentDate Current date from database
     * @throws OAException if validation fails
     */
    public static void validateMinimumAge(Date birthDate, String fieldName,
                                          int minAge, Date currentDate) {
        if (birthDate != null && currentDate != null) {
            // Calculate age in years
            long diffInMillis = currentDate.getTime() - birthDate.getTime();
            long ageInYears = diffInMillis / (1000L * 60 * 60 * 24 * 365);
            
            if (ageInYears < minAge) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_MINIMUM_AGE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 31: Validate Business Day
     * 
     * Check if date falls on a weekday (Monday-Friday).
     * 
     * When to use:
     * - Delivery date validation
     * - Meeting date validation
     * - Working day scheduling
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateBusinessDay(Date value, String fieldName) {
        if (value != null) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(value);
            int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
            
            // 1 = Sunday, 7 = Saturday
            if (dayOfWeek == java.util.Calendar.SUNDAY || dayOfWeek == java.util.Calendar.SATURDAY) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_BUSINESS_DAY");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 32: Validate Weekend Day
     * 
     * Check if date falls on a weekend (Saturday or Sunday).
     * 
     * When to use:
     * - Weekend event scheduling
     * - Off-day validation
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateWeekendDay(Date value, String fieldName) {
        if (value != null) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(value);
            int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
            
            if (dayOfWeek != java.util.Calendar.SUNDAY && dayOfWeek != java.util.Calendar.SATURDAY) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_WEEKEND_DAY");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 33: Validate Date Within Days
     * 
     * Check if date is within specified number of days from current date.
     * 
     * When to use:
     * - Expiry date validation
     * - Near-future date validation
     * - Recent date validation
     * 
     * @param value Date to validate
     * @param fieldName Name of field for error message
     * @param days Number of days (positive for future, negative for past)
     * @param currentDate Current date from database
     * @throws OAException if validation fails
     */
    public static void validateDateWithinDays(Date value, String fieldName, int days, Date currentDate) {
        if (value != null && currentDate != null) {
            long diffInMillis = value.getTime() - currentDate.getTime();
            long diffInDays = diffInMillis / (1000L * 60 * 60 * 24);
            
            if (days > 0 && diffInDays > days) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_WITHIN_FUTURE");
                error.setApplicationModule(fieldName);
                throw error;
            } else if (days < 0 && diffInDays < days) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_DATE_WITHIN_PAST");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // EMAIL VALIDATION
    // ========================================

    /**
     * USE CASE 16: Validate Email Format
     * 
     * Check if email follows standard format (user@domain.com).
     * 
     * When to use:
     * - User registration
     * - Contact information
     * - Email notification setup
     * 
     * @param email Email address to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateEmail(String email, String fieldName) {
        if (email != null && !email.trim().isEmpty()) {
            // RFC 5322 simplified email regex
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                               "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            
            if (!matcher.matches()) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_EMAIL");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 17: Validate Email Domain
     * 
     * Check if email belongs to allowed domain(s).
     * 
     * When to use:
     * - Corporate email validation
     * - Restrict to company domain
     * - Partner email validation
     * 
     * @param email Email address to validate
     * @param fieldName Name of field for error message
     * @param allowedDomains Array of allowed domains (e.g., ["company.com", "partner.com"])
     * @throws OAException if validation fails
     */
    public static void validateEmailDomain(String email, String fieldName, 
                                           String[] allowedDomains) {
        if (email != null && !email.trim().isEmpty() && allowedDomains != null) {
            String domain = email.substring(email.indexOf('@') + 1).toLowerCase();
            
            boolean validDomain = false;
            for (String allowedDomain : allowedDomains) {
                if (domain.equalsIgnoreCase(allowedDomain)) {
                    validDomain = true;
                    break;
                }
            }
            
            if (!validDomain) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_EMAIL_DOMAIN");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // PHONE VALIDATION
    // ========================================

    /**
     * USE CASE 18: Validate Phone Number
     * 
     * Check if phone number matches expected format.
     * 
     * When to use:
     * - Contact information
     * - SMS notification setup
     * - Emergency contact
     * 
     * Formats supported:
     * - (123) 456-7890
     * - 123-456-7890
     * - 1234567890
     * - +1 123 456 7890
     * 
     * @param phone Phone number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validatePhone(String phone, String fieldName) {
        if (phone != null && !phone.trim().isEmpty()) {
            // Remove common separators for validation
            String cleanPhone = phone.replaceAll("[\\s\\-\\(\\)\\+]", "");
            
            // Check if contains only digits and is reasonable length (10-15 digits)
            if (!cleanPhone.matches("^\\d{10,15}$")) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_PHONE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 34: Validate Mobile Number (Saudi Arabia)
     * 
     * Check if mobile number follows Saudi Arabia format (05XXXXXXXX).
     * 
     * When to use:
     * - Saudi mobile validation
     * - SMS notification (SA)
     * - Contact information (SA)
     * 
     * Formats supported:
     * - 05XXXXXXXX (10 digits starting with 05)
     * - +9665XXXXXXXX (with country code)
     * - 009665XXXXXXXX (with international prefix)
     * 
     * @param mobile Mobile number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateSaudiMobile(String mobile, String fieldName) {
        if (mobile != null && !mobile.trim().isEmpty()) {
            // Remove spaces, dashes, and parentheses
            String cleanMobile = mobile.replaceAll("[\\s\\-\\(\\)]", "");
            
            // Check various Saudi mobile formats
            boolean isValid = false;
            
            // Format: 05XXXXXXXX (10 digits)
            if (cleanMobile.matches("^05\\d{8}$")) {
                isValid = true;
            }
            // Format: +9665XXXXXXXX or 9665XXXXXXXX
            else if (cleanMobile.matches("^\\+?9665\\d{8}$")) {
                isValid = true;
            }
            // Format: 009665XXXXXXXX
            else if (cleanMobile.matches("^009665\\d{8}$")) {
                isValid = true;
            }
            
            if (!isValid) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_SAUDI_MOBILE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 35: Validate International Mobile
     * 
     * Check if mobile number follows international format.
     * 
     * When to use:
     * - International contact
     * - Multi-country support
     * - Global SMS validation
     * 
     * @param mobile Mobile number to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateInternationalMobile(String mobile, String fieldName) {
        if (mobile != null && !mobile.trim().isEmpty()) {
            // Remove spaces, dashes, and parentheses
            String cleanMobile = mobile.replaceAll("[\\s\\-\\(\\)]", "");
            
            // International format: +CountryCode followed by 6-14 digits
            // Examples: +966512345678, +14155551234, +442071234567
            if (!cleanMobile.matches("^\\+\\d{7,15}$")) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_INTL_MOBILE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // URL VALIDATION
    // ========================================

    /**
     * USE CASE 19: Validate URL Format
     * 
     * Check if URL is properly formatted.
     * 
     * When to use:
     * - Website fields
     * - Document links
     * - API endpoints
     * 
     * @param url URL to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateURL(String url, String fieldName) {
        if (url != null && !url.trim().isEmpty()) {
            String urlRegex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$";
            
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(url);
            
            if (!matcher.matches()) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_URL");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 36: Validate HTTPS URL Only
     * 
     * Check if URL uses secure HTTPS protocol.
     * 
     * When to use:
     * - Secure payment links
     * - Sensitive data endpoints
     * - Security policy enforcement
     * 
     * @param url URL to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateHTTPSURL(String url, String fieldName) {
        if (url != null && !url.trim().isEmpty()) {
            if (!url.toLowerCase().startsWith("https://")) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_HTTPS_REQUIRED");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            // Also validate URL format
            String urlRegex = "^https://[^\\s/$.?#].[^\\s]*$";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(url);
            
            if (!matcher.matches()) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_HTTPS_URL");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 37: Validate URL Domain
     * 
     * Check if URL belongs to allowed domain(s).
     * 
     * When to use:
     * - Restrict to corporate domains
     * - Partner website validation
     * - Whitelist verification
     * 
     * @param url URL to validate
     * @param fieldName Name of field for error message
     * @param allowedDomains Array of allowed domains
     * @throws OAException if validation fails
     */
    public static void validateURLDomain(String url, String fieldName, String[] allowedDomains) {
        if (url != null && !url.trim().isEmpty() && allowedDomains != null) {
            boolean validDomain = false;
            
            for (String domain : allowedDomains) {
                // Check if URL contains the allowed domain
                if (url.toLowerCase().contains(domain.toLowerCase())) {
                    validDomain = true;
                    break;
                }
            }
            
            if (!validDomain) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_URL_DOMAIN");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // CUSTOM BUSINESS VALIDATIONS
    // ========================================

    /**
     * USE CASE 20: Validate SSN Format (US)
     * 
     * Check if SSN follows US format (XXX-XX-XXXX).
     * 
     * When to use:
     * - Employee SSN
     * - Tax ID validation
     * 
     * @param ssn Social Security Number
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateSSN(String ssn, String fieldName) {
        if (ssn != null && !ssn.trim().isEmpty() && !ssn.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_SSN");
            error.setApplicationModule(fieldName);
            throw error;
        }
    }

    /**
     * USE CASE 21: Validate Credit Card Number (Luhn Algorithm)
     * 
     * Check if credit card number is valid using Luhn algorithm.
     * 
     * When to use:
     * - Payment processing
     * - Credit card validation
     * 
     * @param cardNumber Credit card number
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateCreditCard(String cardNumber, String fieldName) {
        if (cardNumber != null && !cardNumber.trim().isEmpty()) {
            // Remove spaces and dashes
            String cleanCard = cardNumber.replaceAll("[\\s\\-]", "");
            
            // Check if only digits and reasonable length (13-19 digits)
            if (!cleanCard.matches("^\\d{13,19}$")) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_CREDIT_CARD");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            // Luhn algorithm validation
            if (!isValidLuhn(cleanCard)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_CREDIT_CARD_CHECKSUM");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 22: Validate Postal Code
     * 
     * Check if postal code matches country-specific format.
     * 
     * When to use:
     * - Address validation
     * - Shipping information
     * 
     * @param postalCode Postal code
     * @param fieldName Name of field for error message
     * @param countryCode Country code (US, CA, UK, etc.)
     * @throws OAException if validation fails
     */
    public static void validatePostalCode(String postalCode, String fieldName, 
                                          String countryCode) {
        if (postalCode != null && !postalCode.trim().isEmpty()) {
            String regex = null;
            
            if ("US".equalsIgnoreCase(countryCode)) {
                // US ZIP: 12345 or 12345-6789
                regex = "^\\d{5}(-\\d{4})?$";
            } else if ("CA".equalsIgnoreCase(countryCode)) {
                // Canada: A1A 1A1
                regex = "^[A-Z]\\d[A-Z]\\s?\\d[A-Z]\\d$";
            } else if ("UK".equalsIgnoreCase(countryCode)) {
                // UK: SW1A 1AA
                regex = "^[A-Z]{1,2}\\d{1,2}[A-Z]?\\s?\\d[A-Z]{2}$";
            }
            
            if (regex != null && !postalCode.matches(regex)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_INVALID_POSTAL_CODE");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 38: Validate IQAMA Number (Saudi Arabia National ID)
     * 
     * Check if IQAMA number follows Saudi Arabia format.
     * 
     * Saudi IQAMA Format Rules:
     * - Exactly 10 digits
     * - First digit: 1 (Saudi National) or 2 (Resident/Expat)
     * - Remaining 9 digits: Sequential number
     * 
     * When to use:
     * - Employee registration (Saudi Arabia)
     * - National ID validation
     * - Resident permit validation
     * - Government services integration
     * 
     * Examples:
     * - 1234567890 (Saudi National)
     * - 2123456789 (Resident/Expat)
     * 
     * @param iqama IQAMA number
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateIqamaNumber(String iqama, String fieldName) {
        if (iqama != null && !iqama.trim().isEmpty()) {
            // Remove spaces and dashes if any
            String cleanIqama = iqama.replaceAll("[\\s\\-]", "");
            
            // Check if exactly 10 digits
            if (!cleanIqama.matches("^\\d{10}$")) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_IQAMA_LENGTH");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            // Check if starts with 1 or 2
            char firstDigit = cleanIqama.charAt(0);
            if (firstDigit != '1' && firstDigit != '2') {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_IQAMA_START_DIGIT");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 39: Validate IQAMA Number with Checksum
     * 
     * Validate IQAMA with Luhn algorithm checksum verification.
     * 
     * When to use:
     * - High-security validation
     * - Government integration
     * - Critical identity verification
     * 
     * @param iqama IQAMA number
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateIqamaNumberWithChecksum(String iqama, String fieldName) {
        // First do basic format validation
        validateIqamaNumber(iqama, fieldName);
        
        if (iqama != null && !iqama.trim().isEmpty()) {
            String cleanIqama = iqama.replaceAll("[\\s\\-]", "");
            
            // Apply Luhn algorithm for checksum validation
            if (!isValidLuhn(cleanIqama)) {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_IQAMA_CHECKSUM");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    /**
     * USE CASE 40: Validate Saudi National ID vs Resident
     * 
     * Validate and distinguish between Saudi National (1) and Resident (2) IQAMA.
     * 
     * When to use:
     * - Nationality-specific processing
     * - Benefits eligibility
     * - Service restrictions
     * 
     * @param iqama IQAMA number
     * @param fieldName Name of field for error message
     * @param mustBeSaudi True if must be Saudi National, false if must be Resident
     * @throws OAException if validation fails
     */
    public static void validateIqamaType(String iqama, String fieldName, boolean mustBeSaudi) {
        validateIqamaNumber(iqama, fieldName);
        
        if (iqama != null && !iqama.trim().isEmpty()) {
            String cleanIqama = iqama.replaceAll("[\\s\\-]", "");
            char firstDigit = cleanIqama.charAt(0);
            
            if (mustBeSaudi && firstDigit != '1') {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_IQAMA_MUST_BE_SAUDI");
                error.setApplicationModule(fieldName);
                throw error;
            }
            
            if (!mustBeSaudi && firstDigit != '2') {
                OAException error = new OAException(APP_SHORT_NAME, "XXVAL_IQAMA_MUST_BE_RESIDENT");
                error.setApplicationModule(fieldName);
                throw error;
            }
        }
    }

    // ========================================
    // HELPER METHODS
    // ========================================

    /**
     * Helper: Luhn algorithm for credit card validation
     */
    private static boolean isValidLuhn(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            
            sum += digit;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }

    /**
     * BEST PRACTICES SUMMARY
     * 
     * String Validation:
     * - Always trim before checking isEmpty()
     * - Use regex for complex patterns
     * - Provide clear error messages with examples
     * - Consider internationalization (i18n)
     * 
     * Number Validation:
     * - Check for null before converting to primitive
     * - Use double for range checks (handles all number types)
     * - Consider precision for decimal validation
     * - Validate before database insert to prevent SQL errors
     * 
     * Date Validation:
     * - Always use database current date (pageContext.getCurrentDBDate())
     * - Consider timezone implications
     * - Validate date sequences (start before end)
     * - Use SQL Date type, not java.util.Date
     * 
     * Email Validation:
     * - Use standard regex patterns (RFC 5322)
     * - Consider case-insensitive comparison
     * - Validate domain for corporate emails
     * - Trim whitespace before validation
     * 
     * Common Mistakes to Avoid:
     * 1. ❌ Not checking for null before validation
     * 2. ❌ Using client-side date instead of database date
     * 3. ❌ Not trimming strings before validation
     * 4. ❌ Overly complex regex patterns (maintainability)
     * 5. ❌ Not providing helpful error messages
     * 6. ❌ Validating after database operation (validate first!)
     * 
     * Usage Pattern:
     * try {
     *     DataValidation.validateRequired(empName, "Employee Name");
     *     DataValidation.validateEmail(email, "Email");
     *     DataValidation.validatePositive(salary, "Salary");
     *     // Continue with business logic
     * } catch (OAException e) {
     *     // Handle validation error
     *     throw e;
     * }
     */
}
