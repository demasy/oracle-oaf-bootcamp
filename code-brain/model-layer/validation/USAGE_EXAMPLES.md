# DataValidation.java - Usage Examples

## Version 1.3.5 - OAF Message Code Pattern

All validation methods now use proper Oracle Application Framework message codes that reference FND_MESSAGES table.

---

## Error Message Pattern

### OLD Pattern (v1.3.4 and earlier) ❌
```java
// Inline error messages - NOT production ready
throw new OAException(
    fieldName + " is required",
    OAException.ERROR
);
```

### NEW Pattern (v1.3.5) ✅
```java
// Message code pattern - Production ready
OAException error = new OAException("XXVAL", "XXVAL_REQUIRED_FIELD");
error.setApplicationModule(fieldName);
throw error;
```

**Benefits**:
- ✅ Multi-language support (i18n)
- ✅ Centralized message management
- ✅ No code changes for message updates
- ✅ Oracle Application Framework standard
- ✅ Token substitution support

---

## Complete Usage Examples

### 1. String Validation

#### Required Field
```java
// In your controller processFormRequest()
public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    String empName = pageContext.getParameter("EmployeeName");
    
    try {
        DataValidation.validateRequired(empName, "Employee Name");
        // Continue processing...
    } catch (OAException e) {
        // Message from FND_MESSAGES: "Employee Name is required."
        throw e;
    }
}
```

#### String Length
```java
String username = pageContext.getParameter("Username");
DataValidation.validateLength(username, "Username", 6, 30);
// Min: 6, Max: 30 characters
// Message codes: XXVAL_MIN_LENGTH, XXVAL_MAX_LENGTH
```

#### Pattern Matching
```java
String empNumber = pageContext.getParameter("EmpNumber");
DataValidation.validatePattern(
    empNumber, 
    "Employee Number", 
    "^EMP-\\d{5}$", 
    "EMP-12345"
);
// Message code: XXVAL_INVALID_PATTERN
```

#### Alphanumeric Only
```java
String productCode = pageContext.getParameter("ProductCode");
DataValidation.validateAlphanumeric(productCode, "Product Code");
// Message code: XXVAL_ALPHANUMERIC_ONLY
```

#### Contains Substring
```java
String email = pageContext.getParameter("Email");
DataValidation.validateContains(email, "Email", "@");
// Message code: XXVAL_MUST_CONTAIN
```

#### Starts With Prefix
```java
String departmentCode = pageContext.getParameter("DeptCode");
DataValidation.validateStartsWith(departmentCode, "Department Code", "DEPT-");
// Message code: XXVAL_MUST_START_WITH
```

#### Case Validation
```java
String countryCode = pageContext.getParameter("CountryCode");
DataValidation.validateCase(countryCode, "Country Code", true); // Uppercase
// Message codes: XXVAL_MUST_BE_UPPERCASE, XXVAL_MUST_BE_LOWERCASE
```

#### Forbidden Content
```java
String description = pageContext.getParameter("Description");
String[] forbidden = {"<script>", "DROP TABLE", "javascript:"};
DataValidation.validateNotContains(description, "Description", forbidden);
// Message code: XXVAL_FORBIDDEN_CONTENT
```

---

### 2. Number Validation

#### Number Range
```java
Number age = pageContext.getParameter("Age");
DataValidation.validateNumberRange(age, "Age", 18, 65);
// Message code: XXVAL_NUM_RANGE
```

#### Positive Number
```java
Number salary = pageContext.getParameter("Salary");
DataValidation.validatePositive(salary, "Salary");
// Message code: XXVAL_MUST_BE_POSITIVE
```

#### Non-Negative
```java
Number discount = pageContext.getParameter("Discount");
DataValidation.validateNonNegative(discount, "Discount");
// Message code: XXVAL_CANNOT_BE_NEGATIVE
```

#### Decimal Places
```java
Number price = pageContext.getParameter("Price");
DataValidation.validateDecimalPlaces(price, "Price", 2);
// Max 2 decimals for currency
// Message code: XXVAL_MAX_DECIMALS
```

#### Integer Only
```java
Number quantity = pageContext.getParameter("Quantity");
DataValidation.validateInteger(quantity, "Quantity");
// Message code: XXVAL_MUST_BE_INTEGER
```

#### Even Number
```java
Number seats = pageContext.getParameter("Seats");
DataValidation.validateEven(seats, "Seats");
// Message code: XXVAL_MUST_BE_EVEN
```

#### Odd Number
```java
Number ticketNumber = pageContext.getParameter("TicketNumber");
DataValidation.validateOdd(ticketNumber, "Ticket Number");
// Message code: XXVAL_MUST_BE_ODD
```

#### Percentage
```java
Number discountRate = pageContext.getParameter("DiscountRate");
DataValidation.validatePercentage(discountRate, "Discount Rate");
// Must be 0-100
// Message code: XXVAL_PERCENTAGE_RANGE
```

#### Divisible By
```java
Number batchSize = pageContext.getParameter("BatchSize");
DataValidation.validateDivisibleBy(batchSize, "Batch Size", 10);
// Must be divisible by 10
// Message code: XXVAL_DIVISIBLE_BY
```

---

### 3. Date Validation

#### Date Range
```java
Date birthDate = pageContext.getParameter("BirthDate");
Date minDate = new Date(System.currentTimeMillis() - (100L * 365 * 24 * 60 * 60 * 1000)); // 100 years ago
Date maxDate = pageContext.getCurrentDBDate();

DataValidation.validateDateRange(birthDate, "Birth Date", minDate, maxDate);
// Message codes: XXVAL_DATE_BEFORE, XXVAL_DATE_AFTER
```

#### Not in Future
```java
Date hireDate = pageContext.getParameter("HireDate");
DataValidation.validateNotFuture(hireDate, "Hire Date", pageContext.getCurrentDBDate());
// Message code: XXVAL_DATE_FUTURE
```

#### Not in Past
```java
Date deliveryDate = pageContext.getParameter("DeliveryDate");
DataValidation.validateNotPast(deliveryDate, "Delivery Date", pageContext.getCurrentDBDate());
// Message code: XXVAL_DATE_PAST
```

#### Date Sequence
```java
Date startDate = pageContext.getParameter("StartDate");
Date endDate = pageContext.getParameter("EndDate");
DataValidation.validateDateSequence(startDate, endDate, "Start Date", "End Date");
// Message code: XXVAL_DATE_SEQUENCE
```

#### Minimum Age
```java
Date birthDate = pageContext.getParameter("BirthDate");
DataValidation.validateMinimumAge(birthDate, "Birth Date", 18, pageContext.getCurrentDBDate());
// Message code: XXVAL_MINIMUM_AGE
```

#### Business Day (Monday-Friday)
```java
Date meetingDate = pageContext.getParameter("MeetingDate");
DataValidation.validateBusinessDay(meetingDate, "Meeting Date");
// Message code: XXVAL_BUSINESS_DAY
```

#### Weekend Day (Saturday-Sunday)
```java
Date eventDate = pageContext.getParameter("EventDate");
DataValidation.validateWeekendDay(eventDate, "Event Date");
// Message code: XXVAL_WEEKEND_DAY
```

#### Date Within Days
```java
Date expiryDate = pageContext.getParameter("ExpiryDate");
DataValidation.validateDateWithinDays(expiryDate, "Expiry Date", 30, pageContext.getCurrentDBDate());
// Within 30 days from today
// Message codes: XXVAL_DATE_WITHIN_FUTURE, XXVAL_DATE_WITHIN_PAST
```

---

### 4. Email Validation

#### Email Format
```java
String email = pageContext.getParameter("Email");
DataValidation.validateEmail(email, "Email");
// Message code: XXVAL_INVALID_EMAIL
```

#### Email Domain Restriction
```java
String corpEmail = pageContext.getParameter("CorporateEmail");
String[] allowedDomains = {"company.com", "partner.com"};
DataValidation.validateEmailDomain(corpEmail, "Corporate Email", allowedDomains);
// Message code: XXVAL_EMAIL_DOMAIN
```

---

### 5. Phone/Mobile Validation

#### Phone Number
```java
String phone = pageContext.getParameter("Phone");
DataValidation.validatePhone(phone, "Phone Number");
// Accepts: (123) 456-7890, 123-456-7890, +1 123 456 7890
// Message code: XXVAL_INVALID_PHONE
```

#### Saudi Mobile Number
```java
String mobile = pageContext.getParameter("Mobile");
DataValidation.validateSaudiMobile(mobile, "Mobile Number");
// Accepts: 0512345678, +966512345678, 00966512345678
// Message code: XXVAL_INVALID_SAUDI_MOBILE
```

#### International Mobile
```java
String intlMobile = pageContext.getParameter("InternationalMobile");
DataValidation.validateInternationalMobile(intlMobile, "International Mobile");
// Format: +CountryCodeNumber (+14155551234, +442071234567)
// Message code: XXVAL_INVALID_INTL_MOBILE
```

---

### 6. URL Validation

#### URL Format
```java
String website = pageContext.getParameter("Website");
DataValidation.validateURL(website, "Website");
// Message code: XXVAL_INVALID_URL
```

#### HTTPS Only
```java
String paymentLink = pageContext.getParameter("PaymentLink");
DataValidation.validateHTTPSURL(paymentLink, "Payment Link");
// Message codes: XXVAL_HTTPS_REQUIRED, XXVAL_INVALID_HTTPS_URL
```

#### URL Domain Restriction
```java
String partnerUrl = pageContext.getParameter("PartnerURL");
String[] allowedDomains = {"company.com", "partner.com"};
DataValidation.validateURLDomain(partnerUrl, "Partner URL", allowedDomains);
// Message code: XXVAL_URL_DOMAIN
```

---

### 7. Business Validation

#### SSN (US Format)
```java
String ssn = pageContext.getParameter("SSN");
DataValidation.validateSSN(ssn, "SSN");
// Format: XXX-XX-XXXX
// Message code: XXVAL_INVALID_SSN
```

#### Credit Card (with Luhn Algorithm)
```java
String cardNumber = pageContext.getParameter("CardNumber");
DataValidation.validateCreditCard(cardNumber, "Card Number");
// Message codes: XXVAL_INVALID_CREDIT_CARD, XXVAL_CREDIT_CARD_CHECKSUM
```

#### Postal Code
```java
String zipCode = pageContext.getParameter("ZipCode");
DataValidation.validatePostalCode(zipCode, "ZIP Code", "US");
// Country codes: US, CA, UK
// Message code: XXVAL_INVALID_POSTAL_CODE
```

---

### 8. IQAMA (Saudi National ID) Validation

#### Basic IQAMA Format
```java
String iqama = pageContext.getParameter("IqamaNumber");
DataValidation.validateIqamaNumber(iqama, "IQAMA Number");
// Format: 1XXXXXXXXX (Saudi) or 2XXXXXXXXX (Resident)
// 10 digits total
// Message codes: XXVAL_IQAMA_LENGTH, XXVAL_IQAMA_START_DIGIT
```

#### IQAMA with Checksum
```java
String iqama = pageContext.getParameter("IqamaNumber");
DataValidation.validateIqamaNumberWithChecksum(iqama, "IQAMA Number");
// Includes Luhn algorithm validation
// Message code: XXVAL_IQAMA_CHECKSUM
```

#### IQAMA Type Validation
```java
// Must be Saudi National
String saudiId = pageContext.getParameter("SaudiNationalId");
DataValidation.validateIqamaType(saudiId, "Saudi National ID", true);
// Message code: XXVAL_IQAMA_MUST_BE_SAUDI

// Must be Resident
String residentId = pageContext.getParameter("ResidentId");
DataValidation.validateIqamaType(residentId, "Resident ID", false);
// Message code: XXVAL_IQAMA_MUST_BE_RESIDENT
```

---

## Complete Controller Example

```java
package oracle.apps.xxcust.oaf.controller;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.OAWebBeanConstants;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.xxcust.oaf.codebrain.validation.DataValidation;

public class EmployeeRegisterCO extends OAControllerImpl {
    
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        if ("SUBMIT".equals(pageContext.getParameter("event"))) {
            try {
                // Get parameters
                String empName = pageContext.getParameter("EmpName");
                String empNumber = pageContext.getParameter("EmpNumber");
                String email = pageContext.getParameter("Email");
                String mobile = pageContext.getParameter("Mobile");
                String iqama = pageContext.getParameter("Iqama");
                Number salary = pageContext.getParameter("Salary");
                Date birthDate = pageContext.getParameter("BirthDate");
                Date joinDate = pageContext.getParameter("JoinDate");
                
                // Validate all fields
                DataValidation.validateRequired(empName, "Employee Name");
                DataValidation.validateLength(empName, "Employee Name", 2, 100);
                
                DataValidation.validateRequired(empNumber, "Employee Number");
                DataValidation.validatePattern(empNumber, "Employee Number", 
                    "^EMP-\\d{5}$", "EMP-12345");
                
                DataValidation.validateRequired(email, "Email");
                DataValidation.validateEmail(email, "Email");
                
                DataValidation.validateRequired(mobile, "Mobile");
                DataValidation.validateSaudiMobile(mobile, "Mobile");
                
                DataValidation.validateRequired(iqama, "IQAMA Number");
                DataValidation.validateIqamaNumberWithChecksum(iqama, "IQAMA Number");
                
                DataValidation.validateRequired(salary, "Salary");
                DataValidation.validatePositive(salary, "Salary");
                DataValidation.validateNumberRange(salary, "Salary", 3000, 50000);
                
                DataValidation.validateRequired(birthDate, "Birth Date");
                DataValidation.validateNotFuture(birthDate, "Birth Date", 
                    pageContext.getCurrentDBDate());
                DataValidation.validateMinimumAge(birthDate, "Birth Date", 18, 
                    pageContext.getCurrentDBDate());
                
                DataValidation.validateRequired(joinDate, "Join Date");
                DataValidation.validateNotFuture(joinDate, "Join Date", 
                    pageContext.getCurrentDBDate());
                
                // All validations passed - proceed with business logic
                // Call AM method to save employee
                // ...
                
                pageContext.putDialogMessage(
                    new OAException("Employee registered successfully", 
                    OAException.CONFIRMATION)
                );
                
            } catch (OAException e) {
                // Validation error - message will be displayed automatically
                // Error messages come from FND_MESSAGES table
                throw e;
            }
        }
    }
}
```

---

## Message Registration in Database

Before using these validations in production, register all messages in FND_MESSAGES:

```sql
-- See MESSAGE_CODES.md for complete SQL script
-- Example:
INSERT INTO FND_NEW_MESSAGES (
    APPLICATION_SHORT_NAME, MESSAGE_NAME, LANGUAGE_CODE, MESSAGE_TEXT
) VALUES (
    'XXVAL', 'XXVAL_REQUIRED_FIELD', 'US', '&FIELD_NAME is required.'
);

-- Run concurrent program: "FND_NEW_MESSAGES Load"
```

---

## Multi-Language Support

```sql
-- English
INSERT INTO FND_NEW_MESSAGES VALUES (
    'XXVAL', 'XXVAL_REQUIRED_FIELD', 'US', '&FIELD_NAME is required.'
);

-- Arabic
INSERT INTO FND_NEW_MESSAGES VALUES (
    'XXVAL', 'XXVAL_REQUIRED_FIELD', 'AR', '&FIELD_NAME مطلوب.'
);

-- French
INSERT INTO FND_NEW_MESSAGES VALUES (
    'XXVAL', 'XXVAL_REQUIRED_FIELD', 'F', '&FIELD_NAME est requis.'
);
```

User will see messages in their preferred language automatically!

---

## Best Practices

1. **Always validate in Controller** (not in AM or VO)
2. **Use database current date**: `pageContext.getCurrentDBDate()`
3. **Validate before database operations** to prevent SQL errors
4. **Provide clear field names** for better error messages
5. **Register all messages in FND_MESSAGES** before deployment
6. **Test in multiple languages** if supporting i18n
7. **Handle exceptions properly** - let OAF display the message
8. **Validate required fields first** before format validation

---

## Migration from v1.3.4 to v1.3.5

### No Code Changes Required ✅

Your existing validation calls work exactly the same:

```java
// v1.3.4 code
DataValidation.validateRequired(empName, "Employee Name");
DataValidation.validateEmail(email, "Email");

// v1.3.5 code (SAME!)
DataValidation.validateRequired(empName, "Employee Name");
DataValidation.validateEmail(email, "Email");
```

### Database Changes Required ✅

1. Register XXVAL application (if not exists)
2. Insert 48 messages into FND_NEW_MESSAGES
3. Run "FND_NEW_MESSAGES Load" concurrent program

See `MESSAGE_CODES.md` for complete SQL script.

---

## Support

For questions or issues:
- Review `MESSAGE_CODES.md` for message registration
- Check `CHANGELOG.md` for version history
- See OAF Developer Guide for FND_MESSAGES usage
