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
 * Data Types Covered:
 * - String: Required, length, pattern, format validation
 * - Number: Range, positive/negative, decimal validation
 * - Date: Range, past/future, format validation
 * - Email: Format and domain validation
 * - Phone: Format validation
 * - URL: Format and protocol validation
 * - Custom: Business-specific validation patterns
 * 
 * Layer: Model - Validation
 * Complexity: Intermediate
 * Version: 1.3.2
 * 
 * @author OAF Code Brain
 * @version 1.3.2
 */
public class DataValidation {

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
     * @param value String to validate
     * @param fieldName Name of field for error message
     * @throws OAException if validation fails
     */
    public static void validateRequired(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new OAException(
                fieldName + " is required",
                OAException.ERROR
            );
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
                throw new OAException(
                    fieldName + " must be at least " + minLength + " characters",
                    OAException.ERROR
                );
            }
            
            if (length > maxLength) {
                throw new OAException(
                    fieldName + " cannot exceed " + maxLength + " characters",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " format is invalid. Expected format: " + exampleFormat,
                    OAException.ERROR
                );
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
            throw new OAException(
                fieldName + " must contain only letters and numbers",
                OAException.ERROR
            );
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
            throw new OAException(
                fieldName + " contains invalid characters",
                OAException.ERROR
            );
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
                throw new OAException(
                    fieldName + " must be between " + min + " and " + max,
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " must be greater than zero",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " cannot be negative",
                    OAException.ERROR
                );
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
                    throw new OAException(
                        fieldName + " cannot have more than " + maxDecimals + " decimal places",
                        OAException.ERROR
                    );
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
                throw new OAException(
                    fieldName + " must be a whole number",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " cannot be before " + formatDate(minDate),
                    OAException.ERROR
                );
            }
            
            if (maxDate != null && value.after(maxDate)) {
                throw new OAException(
                    fieldName + " cannot be after " + formatDate(maxDate),
                    OAException.ERROR
                );
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
            throw new OAException(
                fieldName + " cannot be in the future",
                OAException.ERROR
            );
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
            throw new OAException(
                fieldName + " cannot be in the past",
                OAException.ERROR
            );
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
            throw new OAException(
                endFieldName + " must be after " + startFieldName,
                OAException.ERROR
            );
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
                throw new OAException(
                    "Age must be at least " + minAge + " years",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " is not a valid email address",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " must belong to an authorized domain",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " is not a valid phone number",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " is not a valid URL",
                    OAException.ERROR
                );
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
            throw new OAException(
                fieldName + " must be in format XXX-XX-XXXX",
                OAException.ERROR
            );
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
                throw new OAException(
                    fieldName + " is not a valid credit card number",
                    OAException.ERROR
                );
            }
            
            // Luhn algorithm validation
            if (!isValidLuhn(cleanCard)) {
                throw new OAException(
                    fieldName + " failed validation check",
                    OAException.ERROR
                );
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
                throw new OAException(
                    fieldName + " format is invalid for " + countryCode,
                    OAException.ERROR
                );
            }
        }
    }

    // ========================================
    // HELPER METHODS
    // ========================================

    /**
     * Helper: Format date for display in error messages
     */
    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

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
