# Oracle Application Framework (OAF) BootCamp

**Version 1.4.0** - Production-Ready Code Brain with Centralized Message Management

A comprehensive collection of Oracle Application Framework (OAF) patterns, utilities, and best practices. Features 12,800+ lines of production-ready code with 240+ use cases covering all MVC layers, validation utilities, and multi-language message support.

## 🎯 What's New in v1.4.0

**Centralized Message Management** - Zero hardcoded error messages!
- ✅ **MessageConstants.java** - 60+ centralized message codes
- ✅ **MessageHelper.java** - Reusable error creation utilities
- ✅ **MESSAGE_REGISTRATION.sql** - Complete FND_MESSAGES setup
- ✅ **Multi-language (i18n)** - Support for all languages via database
- ✅ **Production-ready** - Message changes without code deployment

## About this BootCamp

This repository provides comprehensive training materials and production-ready code for Oracle E-Business Suite OA Framework development. The **code-brain** directory contains extensively documented Java patterns covering Entity Objects, View Objects, Application Modules, Controllers, Integration (Excel/PL/SQL), Security, and more.

**Key Features:**
- 📚 Complete MVC layer implementations
- 🔧 Reusable validation utilities (48 XXVAL_* message codes)
- 🌍 Multi-language message support (XX, XXVAL, XXLAB applications)
- 📊 3 complete lab exercises with step-by-step solutions
- 🛡️ Security patterns and best practices
- 📈 Production-tested code with comprehensive JavaDoc

<br>

## 📚 Code Brain Structure

The **code-brain** directory contains production-ready OAF code organized by layer:

### Model Layer
- **Entity Objects** - Database entity patterns, validation, DML operations
- **View Objects** - Query patterns, WHERE clause building, dynamic SQL
- **Application Modules** - Transaction management, nested AM patterns
- **Validation** - DataValidation.java with 40 reusable methods (v1.3.5)

### View Layer  
- **Tables** - Advanced table patterns, PPR, row selection
- **LOV** - List of Values patterns with validation
- **Flexfields** - DFF/KFF implementation patterns

### Controller Layer
- **Core Controllers** - CRUD operations, navigation, dialogs
- **Advanced Controllers** - File upload/download, PPR, dynamic forms
- **Lab Exercises** - 3 complete labs with solutions

### Integration & Utilities
- **Excel Integration** - Upload/download with Apache POI
- **PL/SQL Integration** - Functions, procedures, batch operations
- **Message Management** - MessageConstants + MessageHelper (v1.4.0)
- **Security** - Access control, function security

**Statistics:**
- **Total Lines**: 12,800+
- **Use Cases**: 240+
- **Message Codes**: 100+ (XX, XXVAL, XXLAB)
- **Lab Exercises**: 3 complete implementations

## 🚀 Quick Start - Message Management

**Step 1: Register Messages**
```sql
-- Run MESSAGE_REGISTRATION.sql in your database
@MESSAGE_REGISTRATION.sql
-- Then load messages via Application Developer responsibility
-- Tools > Load Messages from File (FND_NEW_MESSAGES)
```

**Step 2: Use MessageHelper in Your Code**
```java
import oracle.apps.xxcust.oaf.codebrain.constants.MessageConstants;
import oracle.apps.xxcust.oaf.codebrain.utils.MessageHelper;

// Instead of hardcoded errors
// throw new OAException("Employee Name is required", OAException.ERROR);

// Use MessageHelper
throw MessageHelper.createError(MessageConstants.ERR_EMP_NAME_REQUIRED, "EmployeeName");

// Or for validation
throw MessageHelper.createValidationError(
    MessageConstants.ERR_FIELD_REQUIRED, 
    fieldName
);
```

**Benefits:**
- ✅ Multi-language support without code changes
- ✅ Message updates via database (no redeployment)
- ✅ Centralized message management
- ✅ Token substitution for dynamic messages
- ✅ Consistent error handling patterns

## 📖 Documentation

- **[COURSE.md](COURSE.md)** - Full course outline: Level, Section, Module, Lecture  
- **[ROADMAP.md](ROADMAP.md)** - BootCamp roadmap: course map, syllabus completion plan and phases  
- **[CHANGELOG.md](CHANGELOG.md)** - Version history and migration guides  
- **[MESSAGEHELPER_GUIDE.md](MESSAGEHELPER_GUIDE.md)** - Complete MessageHelper usage guide (v1.4.0)  
- **[MESSAGE_REGISTRATION.sql](MESSAGE_REGISTRATION.sql)** - FND_MESSAGES setup for XX/XXVAL/XXLAB (v1.4.0)  
- **[MESSAGE_CODES.md](code-brain/model-layer/validation/MESSAGE_CODES.md)** - XXVAL validation messages (v1.3.5)  
- **[USAGE_EXAMPLES.md](code-brain/model-layer/validation/USAGE_EXAMPLES.md)** - DataValidation utilities guide (v1.3.5)  
- **[code-brain/README.md](code-brain/README.md)** - Complete code brain documentation  

<br>

## OA Framework BootCamp Levels

| Code       | Lecture Title                         | Level     | Subscribe  |   Notes |
| :-:         | :--------                             | :-:       | :-:        |     :----   |
| DL-OAF-B-101        | <a href="https://github.com/demasylabs/Oracle-OAF-BootCamp/tree/master/building-101">Oracle OAF Building BootCamp 101</a>      | Beginner  |  N/A       | -|
| DL-OAF-B-102        | <a href="SYLLABUS_102.md">Oracle OAF Building BootCamp 102</a>      | Advanced  |  N/A       | -|
| DL-OAF-B-103       | <a href="SYLLABUS_103.md">Oracle OAF Building BootCamp 103</a>      | Ninja     |  N/A       | -|
| DL-OAF-C-101        | <a href="SYLLABUS_CUST_101.md">Oracle OAF Customizing BootCamp 101</a>   | Beginner  |  N/A       | -|
| DL-OAF-C-102        | <a href="SYLLABUS_CUST_102.md">Oracle OAF Customizing BootCamp 102</a>   | Advanced  |  N/A       | -|

<br>

## Target Audience

- Oracle Technical Consultant (Apps Developer)
- Oracle Apps Developer Course attended
- Oracle Developer
- Java Developer
- Oracle Techno Functional

<br>

## Prerequisites & Requirements 

- Java Programming
- Oracle database SQL & PL/SQL
- 3 months of Oracle developing experience on e-Business Suite applications
- Oracle E-Business Suite Virtual Machine
- Toad for Oracle or SQL Developer

<br>

## **About the Instructor**
My name is <a href="https://github.com/demasy">Ahmed El-Demasy</a> , I have more than 13 years of experience in Oracle technology and Oracle applications; 11 years in ERP development using JAVA and ORACLE tools specialist in OA framework development (OAF).

Currently holding a position of Principal Technical Consultant, responsible for implementation, enhancement, and support for Oracle e-Business Suite applications (ERP); coaching development team, leading projects and vendor resources coordination.

Practical experience in coaching and teaching Oracle courses such as Oracle SQL, Oracle PL/SQL, Java SE, Oracle OA framework (OAF), Oracle workflow, and etc.

For more information about my experiences and professional career. please visit my LinkedIn profile <a href="https://www.linkedin.com/in/demasy/">here</a>

<br>


## How can get this BootCamp!

###### Online BootCamps for individuals buy these BootCamps via udemy.com
> <a href="#">udemy.com</a>

###### Live BootCamps for enterprise ONLY
> <a href="#">Schedule call with us via Calendly</a>

<br>


## Suggestions & Issues
If you find any issue or have a great idea in mind please create an issue on <a href="https://github.com/demasylabs/Oracle-OAF-BootCamp/issues">GitHub</a>.

<br>

## Contributing

We welcome contributions from the community! Whether you're fixing a bug, adding a new code example, improving documentation, or creating new lab exercises, your contributions help make this bootcamp better for everyone.

### How to Contribute

1. **Fork the Repository**: Create your own fork of the repository
2. **Create a Branch**: Create a feature branch for your changes
3. **Make Changes**: Follow our [Code Quality Guidelines](.github/instructions/codacy.instructions.md)
4. **Submit a PR**: Submit a pull request with a clear description of your changes

For detailed guidelines, please read our [Contributing Guide](.github/CONTRIBUTING.md).

### Areas Where You Can Contribute

- **Code Examples**: Add new OAF patterns and use cases to the [code-brain](code-brain/) directory
- **Documentation**: Improve existing documentation or fix errors
- **Lab Exercises**: Create new hands-on labs and exercises
- **Course Content**: Enhance syllabus content and learning materials
- **Bug Fixes**: Fix issues in existing code or documentation

### Code of Conduct

This project follows a Code of Conduct to ensure a welcoming and inclusive environment. By participating, you agree to be respectful, inclusive, and constructive in all interactions.

<br>

## Repository Structure

```
Oracle-OAF-BootCamp/
├── code-brain/              # Comprehensive OAF code examples and patterns
│   ├── code-brain.json      # Metadata for all code examples
│   ├── README.md            # Documentation for code-brain
│   ├── view-object-operations/
│   ├── error-handling/
│   ├── controller-patterns/
│   └── ...                  # Other code categories
├── SYLLABUS.md              # Main syllabus overview
├── SYLLABUS_101.md          # Level 101 (Beginner) detailed syllabus
├── SYLLABUS_102.md          # Level 102 (Advanced) detailed syllabus
├── SYLLABUS_103.md          # Level 103 (Ninja) detailed syllabus
├── LABS.md                  # All lab exercises and activities
├── INSTRUCTOR_SYLLABUS.md   # Instructor-specific content
├── PROJECT_LEVEL_101.md     # Capstone project details
├── .github/                 # GitHub configuration
│   ├── CONTRIBUTING.md      # Contribution guidelines
│   ├── PULL_REQUEST_TEMPLATE.md
│   ├── ISSUE_TEMPLATE/      # Issue templates
│   ├── instructions/        # Quality and coding guidelines
│   └── workflows/           # CI/CD workflows
└── README.md                # This file
```

<br> 
<br>

<p align="center">
Made with love ❤️ in Egypt by <a href="https://github.com/demasylabs"> Demasy Labs </a>
</p>
