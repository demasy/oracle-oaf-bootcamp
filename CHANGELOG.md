# Changelog

All notable changes to Oracle OAF BootCamp will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.4.0] - 2025-01-30

### Added
- **MessageConstants.java**: Centralized message code management with 60+ constants
- **MessageHelper.java**: Reusable utility for creating OAF exceptions with proper message codes
- **MESSAGE_REGISTRATION.sql**: Complete SQL script for registering all XX_* message codes in FND_MESSAGES

### Changed
- **Global Refactoring**: All code-brain files now use MessageConstants instead of hardcoded error messages
- **Error Handling**: Migrated from inline error strings to FND_MESSAGES pattern for multi-language support
- **Reusability**: Eliminated special-case error handling across all layers (Model, View, Controller, Integration)

### Features
- Multi-language support (i18n) for all error messages
- Message changes without code deployment
- Centralized message management across 21 code-brain files
- Token substitution support for dynamic error messages
- Consistent error handling patterns

### Technical Details
**Files Updated**: 21+ code-brain Java files across all layers
- Model Layer: Entity Objects, View Objects, Application Modules, Validation
- View Layer: Tables, LOV, PPR
- Controller Layer: Core, Advanced, Labs
- Integration: Excel, PL/SQL
- Security: Access control
- Cross-cutting: Error handling, Constants, Utilities

**Message Applications**:
- **XX**: General application messages (60+ codes)
- **XXVAL**: Validation messages (48 codes from v1.3.5)
- **XXLAB**: Lab exercise messages

**Pattern Standardization**:
```java
// Before v1.4.0
throw new OAException("Employee Name is required", OAException.ERROR);

// After v1.4.0
throw MessageHelper.createError(MessageConstants.ERR_EMP_NAME_REQUIRED, fieldName);
```

### Impact
- **Zero hardcoded error messages** in production code
- **100% reusable** error handling components
- **Production-ready** multi-language support
- **Maintainable** - message updates via database, no code changes

---

## [1.3.5] - 2025-01-30

### Added
- **DataValidation.java**: Comprehensive validation utilities (1,339 lines, 40 methods)
  - Email validation (RFC 5322 compliant)
  - Date range validation with timezone support
  - Number range validation with null handling
  - String length/format validation (alphanumeric, max length)
  - Mandatory field validation
  - Duplicate record checking
  - Business rule validation (job constraints, position constraints, transfer constraints)
  - Salary validation (min/max, pay period ranges)

- **MESSAGE_CODES.md**: Complete documentation for XXVAL_* message codes
  - SQL registration script for 48 validation messages
  - Multi-language example (Arabic)
  - FND_NEW_MESSAGES Load instructions

- **USAGE_EXAMPLES.md**: Comprehensive guide for using validation utilities
  - Controller integration patterns
  - Error handling best practices
  - Real-world validation scenarios
  - Token substitution examples

### Changed
- **code-brain/README.md**: Updated statistics and validation section
  - Total lines: 12,800+
  - Use cases: 240+
  - New validation utilities section

### Features
- 48 validation message codes (XXVAL_*)
- Multi-language support ready
- Token substitution for dynamic messages
- Reusable validation methods across all layers

### Technical Details
**Validation Categories**:
1. Email Validation (4 methods)
2. Date Validation (6 methods)
3. Number Validation (5 methods)
4. String Validation (4 methods)
5. Mandatory Field Validation (3 methods)
6. Duplicate Checking (3 methods)
7. Business Rules (15 methods)
   - Employee validation
   - Job validation
   - Position validation
   - Transfer validation
   - Salary validation

**Message Code Pattern**:
```java
OAException error = new OAException("XXVAL", "XXVAL_E_EMAIL_INVALID");
error.setApplicationModule(fieldName);
throw error;
```

---

## [1.3.0] - Previous Release

### Added
- Initial code-brain structure with 21 Java files
- Model layer patterns (Entity Objects, View Objects, Application Modules)
- View layer patterns (Tables, LOV, PPR, Flexfields)
- Controller layer patterns (Core, Advanced, Dialogs, Navigation)
- Integration patterns (Excel, PL/SQL, Files)
- Security patterns
- Lab exercises (3 complete labs)

### Features
- 200+ Oracle ADF/OAF code patterns
- Production-ready examples
- Best practices documentation
- Comprehensive JavaDoc

---

## Future Roadmap

### [1.5.0] - Planned
- **Advanced Validation**: Complex cross-field validation patterns
- **Workflow Integration**: AME/OAWorkflow examples
- **Performance Optimization**: Caching strategies, bulk operations
- **Testing Framework**: JUnit tests for all utilities

### [1.6.0] - Planned
- **Advanced Integration**: Web services, REST API examples
- **Reporting**: XML Publisher/BI Publisher integration
- **Concurrent Programs**: Request submission patterns

---

## Migration Guide

### Migrating to v1.4.0 from v1.3.5

**Step 1: Update Error Handling**
```java
// Old pattern (v1.3.5)
throw new OAException("Error message", OAException.ERROR);

// New pattern (v1.4.0)
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;

throw MessageHelper.createError(MessageConstants.ERR_MESSAGE_CODE);
```

**Step 2: Register Message Codes**
- Run MESSAGE_REGISTRATION.sql in your database
- Execute FND_NEW_MESSAGES Load for each application (XX, XXVAL, XXLAB)

**Step 3: Update Imports**
Add to your Java files:
```java
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;
```

**Step 4: Replace Hardcoded Messages**
Use MessageHelper methods instead of direct OAException instantiation:
- `MessageHelper.createError(messageCode)`
- `MessageHelper.createError(messageCode, token)`
- `MessageHelper.createValidationError(messageCode, fieldName)`
- `MessageHelper.createWarning(messageCode)`
- `MessageHelper.createInformation(messageCode)`

### Benefits of Migration
✅ Multi-language support without code changes
✅ Message updates via database (no redeployment)
✅ Centralized message management
✅ Consistent error handling
✅ Better maintainability
✅ Production best practices

---

## Support

For questions or issues:
- GitHub: [demasylabs/Oracle-OAF-BootCamp](https://github.com/demasylabs/Oracle-OAF-BootCamp)
- Documentation: See README.md and code-brain/README.md
- Message Codes: See MESSAGE_CODES.md and MESSAGE_REGISTRATION.sql

## License

See [LICENSE.md](LICENSE.md) for details.
