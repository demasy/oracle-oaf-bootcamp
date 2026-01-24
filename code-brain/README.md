# OAF Code Brain Repository

Comprehensive collection of Oracle Application Framework (OAF) code examples and patterns for the Oracle OAF BootCamp.

## 📚 Overview

This repository contains **8 categories** of OAF code examples with **80+ use cases**, providing practical, copy-paste-ready implementations for common OAF development tasks.

### Statistics
- **Total Files**: 8 Java files
- **Total Lines**: 1,943 lines of code
- **Total Methods**: 91 methods
- **Total Use Cases**: 80 patterns and examples

## 🗂️ Code Categories

### 1. View Object Operations
**Directory**: `view-object-operations/`  
**File**: `ExecuteVO.java` (161 lines, 7 methods)

**Use Cases**:
- Execute VO without parameters
- Execute VO with where clause
- Execute VO with multiple parameters
- Execute VO and reset filters
- Execute VO with ORDER BY clause
- Execute VO and iterate through rows
- Execute VO with dynamic query

**Key Patterns**:
```java
vo.executeQuery()
vo.setWhereClause()
vo.setWhereClauseParams()
vo.setOrderByClause()
vo.first() / vo.next()
```

---

### 2. Error Handling
**Directory**: `error-handling/`  
**File**: `OAExceptionHandling.java` (172 lines, 13 methods)

**Use Cases**:
- Throw simple/dictionary/tokenized error messages
- Display warning/confirmation/information messages
- Handle AM and SQL exceptions
- Add multiple messages to page
- Exception with detail messages

**Key Patterns**:
```java
OAException(message, severity)
OAException(product, messageName)
setMessageToken()
pageContext.putDialogMessage()
```

---

### 3. Application Module
**Directory**: `application-module/`  
**File**: `RootAMAccess.java` (158 lines, 11 methods)

**Use Cases**:
- Get Root Application Module
- Invoke AM methods with/without return values
- Invoke AM methods with multiple parameters
- Access nested Application Modules
- Commit/rollback transactions
- Access AM in processRequest/processFormRequest

**Key Patterns**:
```java
pageContext.getRootApplicationModule()
rootAM.invokeMethod(methodName, params)
rootAM.invokeMethod("commit")
rootAM.invokeMethod("rollback")
```

---

### 4. Dialog Pages
**Directory**: `dialog-pages/`  
**File**: `DialogPageExamples.java` (311 lines, 11 methods)

**Use Cases**:
- Simple/custom confirmation dialogs
- Yes/No dialogs with custom labels
- Handle dialog responses
- Warning/error/information dialogs
- Dialog with detail messages
- Dialog with navigation and parameters
- Complete dialog flow with response handling

**Key Patterns**:
```java
OADialogPage(severity, message, detail, okDest, noDest)
dialogPage.setOkButtonItemName()
dialogPage.setFormParameters(Hashtable)
pageContext.redirectToDialogPage()
```

---

### 5. Entity Objects
**Directory**: `entity-objects/`  
**File**: `EntityObjectPatterns.java` (243 lines, 9 methods)

**Use Cases**:
- Populate WHO columns and sequences on create
- Update WHO columns before DML
- Entity-level and attribute-level validation
- Custom business logic before remove
- Calculate derived attributes
- Refresh entity from database
- Check attribute changes

**Key Patterns**:
```java
create(AttributeList)
doDML(operation, TransactionEvent)
validateEntity()
setAttributeInternal()
SequenceImpl(sequenceName, transaction)
```

---

### 6. Controller Patterns
**Directory**: `controller-patterns/`  
**File**: `ControllerPatterns.java` (282 lines, 12 methods)

**Use Cases**:
- processRequest for page initialization
- processFormRequest for form submissions
- Handle Save/Cancel/Delete/Apply/Search/Clear buttons
- Show confirmation dialogs
- Validate form data
- Set default values
- Handle table row actions

**Key Patterns**:
```java
processRequest(pageContext, webBean)
processFormRequest(pageContext, webBean)
pageContext.getParameter()
am.invokeMethod()
pageContext.forwardImmediately()
```

---

### 7. Validation
**Directory**: `validation/`  
**File**: `ValidationPatterns.java` (349 lines, 5 classes)

**Use Cases**:
- Attribute-level validation (setter methods)
- Entity-level validation (validateEntity)
- Transaction-level validation (AM methods)
- Date range and business rule validation
- Database uniqueness checks
- Cross-field and conditional validation

**Key Patterns**:
```java
// Attribute level
public void setJobName(String value) { /* validate */ }

// Entity level
protected void validateEntity() { /* validate */ }

// Transaction level
public void validateJobTransfer() { /* validate */ }
```

---

### 8. Navigation
**Directory**: `navigation/`  
**File**: `NavigationPatterns.java` (267 lines, 14 methods)

**Use Cases**:
- Forward immediately/deferred navigation
- Forward with HashMap/URL parameters
- Navigate with/without breadcrumbs
- Navigate with/without retaining AM
- Return to calling page
- Navigate to external URLs
- Conditional navigation
- Pass complex objects between pages

**Key Patterns**:
```java
pageContext.forwardImmediately()
pageContext.setForwardURL()
HashMap for parameters
OAWebBeanConstants.ADD_BREAD_CRUMB_YES/NO
pageContext.putSessionValue()/getSessionValue()
```

---

## 🎯 Usage Guidelines

### For Students
1. Browse by category to find relevant examples
2. Study use cases that match your current task
3. Copy and adapt patterns to your project
4. Understand key patterns before implementing
5. Reference prerequisite sections if concepts are unclear

### For Instructors
1. Use as teaching examples in lectures
2. Reference in lab exercises
3. Point students to specific examples during troubleshooting
4. Demonstrate best practices vs anti-patterns
5. Assign specific patterns for practice exercises

### For Developers
1. Quick reference for common tasks
2. Copy-paste starting points
3. Best practice validation
4. Pattern library for code reviews
5. Template for new implementations

---

## ✅ Best Practices

### View Objects
- ✅ Always check VO for null before executing
- ✅ Use bind variables in where clauses
- ✅ Reset VO state before applying new filters
- ✅ Use setOrderByClause instead of SQL ORDER BY

### Error Handling
- ✅ Use message dictionary for all user messages
- ✅ Include message tokens for dynamic values
- ✅ Choose appropriate severity level
- ✅ Never expose SQL errors directly to users

### Application Module
- ✅ Always check rootAM for null
- ✅ Use invokeMethod() instead of casting
- ✅ Commit in AM, never in Controller
- ✅ Rollback on exceptions

### Entity Objects
- ✅ Always populate WHO columns
- ✅ Use SequenceImpl for primary keys
- ✅ Validate in validateEntity() for multi-attribute checks
- ✅ Never perform UI operations in EO

### Controllers
- ✅ Initialize data in processRequest
- ✅ Handle events in processFormRequest
- ✅ Never put business logic in Controller
- ✅ Always validate before invoking AM methods

---

## ❌ Common Mistakes

### View Objects
- ❌ Forgetting to call executeQuery() after setting where clause
- ❌ Not resetting VO before applying new filters
- ❌ Using SQL syntax instead of bind variables

### Error Handling
- ❌ Hardcoding error messages
- ❌ Using generic Exception instead of OAException
- ❌ Not setting appropriate severity level

### Application Module
- ❌ Casting to custom AM instead of using invokeMethod()
- ❌ Not checking rootAM for null
- ❌ Committing in Controller instead of AM

### Entity Objects
- ❌ Not populating WHO columns
- ❌ Forgetting to call super.create() or super.doDML()
- ❌ Putting business logic in EO instead of AM

### Controllers
- ❌ Putting business logic in Controller
- ❌ Using processRequest for form submissions
- ❌ Using processFormRequest for page initialization

---

## 📖 Related Resources

### Syllabi
- [SYLLABUS_101.md](../SYLLABUS_101.md) - Level 101 (Beginner)
- [SYLLABUS_102.md](../SYLLABUS_102.md) - Level 102 (Advanced)
- [SYLLABUS_103.md](../SYLLABUS_103.md) - Level 103 (Ninja)

### Brain Files
- [.ai-brain.json](../demasylabs-barin/.ai-brain.json) - Main project brain
- [ANALYSIS_REPORT.md](../demasylabs-barin/ANALYSIS_REPORT.md) - Brain analysis
- [code-brain.json](code-brain.json) - This repository's metadata

### Oracle Documentation
- OA Framework Developer's Guide
- BC4J Developer's Guide
- Doc ID 416708.1 - JDeveloper version compatibility

---

## 🚀 Future Enhancements

### Planned Categories
- Advanced View Object operations
- Personalization examples
- Flexfield handling
- Attachment handling
- Export to Excel
- Advanced table operations
- Partial page rendering (PPR)
- LOV patterns
- Master-Detail implementations
- Search page patterns

### Planned Features
- Video demonstrations
- Interactive code playground
- Unit tests for all examples
- Performance optimization tips
- Debugging guide per category

---

## 📝 Code Standards

### Documentation
- Header required with use case, location, complexity
- JavaDoc comments for all methods
- Inline comments for non-obvious logic

### Naming
- Descriptive class names ending in Patterns/Examples
- Clear verb-noun format for methods
- Meaningful variable names

### Error Handling
- Always use OAException with appropriate severity
- Never use generic Exception or printStackTrace()
- Include message dictionary references

### Architecture
- Validation in Entity Object layer
- Business logic in Application Module
- UI logic in Controller only
- Strict MVC separation of concerns

---

## 📊 Version History

### v1.0 (2026-01-25)
- Initial code-brain creation
- 8 categories with comprehensive examples
- 8 Java files with 1,943 lines of code
- 91 methods demonstrating 80 use cases
- Complete documentation with best practices

---

## 🤝 Contributing

When adding new code examples:
1. Follow the established directory structure
2. Include comprehensive JavaDoc comments
3. Provide multiple use cases per file
4. Update code-brain.json metadata
5. Follow Oracle OAF naming conventions
6. Include best practices and common mistakes

---

## 📞 Support

For questions or clarification:
- Refer to the main project [.ai-brain.json](../demasylabs-barin/.ai-brain.json)
- Check the [ANALYSIS_REPORT.md](../demasylabs-barin/ANALYSIS_REPORT.md)
- Review course syllabi for context

---

**Created**: 2026-01-25  
**Last Updated**: 2026-01-25  
**Version**: 1.0  
**Maintained By**: Oracle OAF BootCamp Team
