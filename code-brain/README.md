# OAF Code Brain Repository v1.3

Comprehensive layer-based MVC architecture for Oracle Application Framework (OAF) - Enhanced with View Layer, Integration (Excel/PL-SQL), Security patterns, and Complete Lab Exercises.

## 📚 Overview

This repository contains **21 pattern files** organized by MVC architecture layers with **200+ use cases**, providing practical, production-ready implementations for OAF development plus complete lab exercises from R12 Building OAF Applications course.

### Statistics
- **Total Files**: 21 Java files (18 patterns + 3 complete labs)
- **Total Lines**: ~11,500 lines of code
- **Total Use Cases**: 200+ patterns and examples
- **Lab Exercises**: 3 complete hands-on labs
- **Architecture**: Layer-based MVC (Model/View/Controller/Integration/Security/Cross-cutting/Labs)
- **Version**: 1.3
- **Last Updated**: 2026-01-25

## 🏗️ Architecture

Code organized by architectural layers for clear separation of concerns:

```
code-brain/
├── model-layer/              # Data and business logic
│   ├── view-objects/         # VO query patterns
│   ├── entity-objects/       # EO validation patterns
│   ├── application-modules/  # AM patterns
│   └── validation/           # Validation logic
├── view-layer/               # UI components
│   ├── tables/               # Table patterns
│   ├── lov/                  # LOV patterns
│   ├── ppr/                  # PPR patterns
│   ├── flexfields/           # KFF/DFF patterns
│   └── layouts/              # Layout patterns
├── controller-layer/         # Event handling
│   ├── core/                 # Core controller patterns
│   ├── advanced/             # Advanced patterns
│   ├── dialogs/              # Dialog patterns
│   └── navigation/           # Navigation patterns
├── integration/              # External systems
│   ├── excel/                # Excel import/export
│   ├── plsql/                # PL/SQL integration
│   └── files/                # File operations
├── security/                 # Access control
├── labs/                     # Complete lab exercises ⭐ NEW
└── cross-cutting/            # Cross-cutting concerns
    ├── error-handling/       # Exception handling
    ├── session/              # Session management
    ├── configuration/        # Profile options
    └── metadata/             # MDS operations
```

## 🗂️ Pattern Categories by Layer

### Model Layer

#### 1. View Object Operations
**Directory**: `model-layer/view-objects/`  
**File**: `ExecuteVO.java` (161 lines, 7 use cases)

**Use Cases**:
- Execute VO without parameters
- Execute VO with where clause
- Execute VO with multiple parameters
- Execute VO and reset filters
- Execute VO with ORDER BY clause
- Execute VO and iterate through rows
- Execute VO with dynamic query

#### 2. Entity Object Patterns
**Directory**: `model-layer/entity-objects/`  
**File**: `EntityObjectPatterns.java` (14 use cases)

#### 3. Application Module Patterns
**Directory**: `model-layer/application-modules/`  
**Files**: `RootAMAccess.java`, `NestedAMPatterns.java`

#### 4. Validation Patterns
**Directory**: `model-layer/validation/`  
**File**: `ValidationPatterns.java` (18 use cases)

---

### View Layer ⭐ NEW

#### 5. Table Patterns
**Directory**: `view-layer/tables/`  
**File**: `TablePatterns.java` (557 lines, 12 use cases)

**Use Cases**:
- Configure basic table
- Advanced table with single/multiple selection
- Add action columns (Update/Delete buttons)
- Handle row selection in controller
- Configure sortable columns
- Add/delete rows dynamically
- Configure Excel export
- Table footer with totals
- Best practices

**Key Patterns**:
```java
OATableBean, OAAdvancedTableBean
setSelectionMode(SINGLE_SELECTION/MULTIPLE_SELECTION)
vo.getFilteredRows("SelectFlag", "Y")
vo.createRow(), vo.insertRow()
setExportSupport(true)
```

#### 6. LOV Patterns
**Directory**: `view-layer/lov/`  
**File**: `LOVPatterns.java` (450 lines, 10 use cases)

**Use Cases**:
- Configure standard LOV
- Configure dependent LOV (cascading)
- Handle PPR events for dependent LOVs
- Programmatically launch LOV
- Configure auto-clear behavior
- Validate LOV selection
- Configure custom criteria
- Handle return values
- Configure query limits
- Best practices

**Key Patterns**:
```java
OAMessageLovInputBean
setExternalListOfValues()
addToLovMapping()
FIRE_PARTIAL_ACTION_ATTR
PARTIAL_TRIGGERS_ATTR
```

---

### Controller Layer

#### 7. Controller Patterns
**Directory**: `controller-layer/core/`  
**File**: `ControllerPatterns.java` (11 use cases)

#### 8. Advanced Controller
**Directory**: `controller-layer/advanced/`  
**File**: `AdvancedControllerPatterns.java` (19 use cases)

#### 9. Dialog Patterns
**Directory**: `controller-layer/dialogs/`  
**File**: `DialogPageExamples.java` (12 use cases)

#### 10. Navigation
**Directory**: `controller-layer/navigation/`  
**File**: `NavigationPatterns.java` (10 use cases)

---

### Integration Layer ⭐ NEW

#### 11. Excel Operations
**Directory**: `integration/excel/`  
**File**: `ExcelOperations.java` (580 lines, 8 use cases)

**Use Cases**:
- Import Excel - Upload and parse using Apache POI
- Parse Excel sheet and extract data
- Validate Excel data before insert
- Insert Excel data to database
- Export data to Excel - Query and format
- Stream Excel file to browser
- Handle large Excel files (streaming)
- Best practices

**Key Patterns**:
```java
WorkbookFactory.create(inputStream)
HSSFWorkbook, HSSFSheet, HSSFRow
sheet.getRow(i).getCell(j)
row.createCell(col).setCellValue()
response.setContentType("application/vnd.ms-excel")
```

**Dependencies**: Apache POI (poi-3.9.jar, poi-ooxml-3.9.jar)

#### 12. PL/SQL Integration
**Directory**: `integration/plsql/`  
**File**: `PLSQLIntegration.java` (650 lines, 9 use cases)

**Use Cases**:
- Call PL/SQL function with return value
- Call PL/SQL procedure with OUT parameters
- Function with multiple parameters
- Handle PL/SQL exceptions
- IN OUT parameters
- Batch processing with PL/SQL
- Call from Application Module
- Execute anonymous PL/SQL block
- Best practices

**Key Patterns**:
```java
CallableStatement cs = conn.prepareCall("{? = call pkg.func(?)}")
cs.registerOutParameter(1, Types.VARCHAR)
cs.setInt(2, value)
cs.execute()
String result = cs.getString(1)
```

---

### Security Layer ⭐ NEW

#### 13. Security Patterns
**Directory**: `security/`  
**File**: `SecurityPatterns.java` (385 lines, 8 use cases)

**Use Cases**:
- Check function security
- Conditional rendering based on function access
- Data security - Filter by organization
- Check responsibility
- Custom authorization logic
- Audit trail - Track user actions
- Field-level security
- Best practices

**Key Patterns**:
```java
pageContext.isResFunctionRegistered(functionName)
pageContext.getProfile("ORG_ID")
pageContext.getResponsibilityKey()
webBean.setRendered(hasAccess)
```

---

### Cross-cutting Concerns

#### 14. Error Handling
**Directory**: `cross-cutting/error-handling/`  
**File**: `OAExceptionHandling.java` (13 use cases)

#### 15. Session Management
**Directory**: `cross-cutting/session/`  
**File**: `SessionManagement.java` (14 use cases)

#### 16. Configuration
**Directory**: `cross-cutting/configuration/`  
**File**: `ProfileOptionPatterns.java` (11 use cases)

#### 17. Metadata Operations
**Directory**: `cross-cutting/metadata/`  
**File**: `MDSOperations.java` (10 use cases)

---

## 🎓 Complete Lab Exercises ⭐ NEW

### Lab 1: Query Page with Search
**Directory**: `labs/`  
**File**: `Lab1-QueryPage.java` (~290 lines, 4 exercises + bonus)

**Lab Objectives**:
- Create search page with multiple criteria
- Build dynamic WHERE clause with bind variables
- Execute query and display results in table
- Handle Clear button and reset functionality
- Navigate to detail page on row selection

**Exercises**:
1. Initialize Query Page (processRequest)
2. Handle Search Button Click (processFormRequest)
3. Clear Search Functionality
4. BONUS: Add Row Selection Handler

**What You'll Learn**:
- Application Module access patterns
- View Object query execution
- Parameter capture and validation
- Dynamic WHERE clause construction
- Search patterns and best practices

**Key Lab Patterns**:
```java
OAApplicationModule am = pageContext.getApplicationModule(webBean)
OAViewObject vo = am.findViewObject("EmployeeSearchVO")
vo.setWhereClause("EMPLOYEE_NUMBER = :1 AND UPPER(FULL_NAME) LIKE :2")
vo.setWhereClauseParam(0, empNumber)
vo.executeQuery()
```

**Testing Checklist**:
- ✓ Page loads without initial results
- ✓ Search with single/multiple criteria
- ✓ LIKE operator for partial name match
- ✓ Clear button resets form
- ✓ No results message displays
- ✓ Row selection navigates correctly

---

### Lab 2: Create and Update Page (CRUD)
**Directory**: `labs/`  
**File**: `Lab2-CreateUpdatePage.java` (~335 lines, 5 exercises)

**Lab Objectives**:
- Implement complete CRUD operations
- Distinguish CREATE vs UPDATE modes
- Validate user input with business rules
- Handle database errors gracefully
- Implement Cancel and Delete operations

**Exercises**:
1. Initialize Page for Create or Update mode
2. Handle Apply (Save) Button with validation
3. Validate Employee Data (business rules)
4. Handle Cancel Operation (rollback)
5. BONUS: Handle Delete Operation

**What You'll Learn**:
- Row creation and initialization
- Field validation techniques
- Transaction commit and rollback
- Error handling patterns
- WHO column management

**Key Lab Patterns**:
```java
// CREATE MODE
Row row = vo.createRow()
row.setAttribute("Status", "ACTIVE")
row.setAttribute("CreatedBy", pageContext.getUserId())
vo.insertRow(row)

// UPDATE MODE
vo.setWhereClause("EMPLOYEE_ID = :1")
vo.executeQuery()
Row row = vo.first()

// COMMIT
am.getTransaction().commit()

// ROLLBACK
am.getTransaction().rollback()
```

**Validation Rules Implemented**:
- Employee Number: Required, unique
- Full Name: Required
- Email: Required, valid format (@, .)
- Salary: Positive number, max 999,999
- Hire Date: Cannot be future date

**Testing Checklist**:
- ✓ Create new employee successfully
- ✓ Update existing employee
- ✓ All validation rules work
- ✓ Duplicate check prevents constraint violation
- ✓ Cancel discards changes
- ✓ Delete removes record
- ✓ Success/error messages display

---

### Lab 3: Master-Detail Page
**Directory**: `labs/`  
**File**: `Lab3-MasterDetailPage.java` (~340 lines, 6 exercises)

**Lab Objectives**:
- Implement master-detail relationship
- Synchronize master and detail queries
- Handle master row selection
- Create and delete detail records
- Maintain referential integrity

**Exercises**:
1. Initialize Master-Detail Page
2. Handle Master Row Selection (PPR)
3. Load Job History for Selected Employee
4. Clear Job History Display
5. Add New Job History Record
6. Delete Job History Record

**Scenario**:
- Master: Employee list
- Detail: Job history for selected employee
- When employee selected, job history auto-refreshes
- Add/Delete job history for current employee

**What You'll Learn**:
- Master-detail query coordination
- View Link relationships
- Foreign key management
- PPR (Partial Page Rendering)
- Detail record lifecycle

**Key Lab Patterns**:
```java
// Initialize empty detail
detailVO.setWhereClause("1=2")
detailVO.executeQuery()

// Load detail for master
detailVO.setWhereClause("EMPLOYEE_ID = :1")
detailVO.setWhereClauseParam(0, empId)
detailVO.setOrderByClause("START_DATE DESC")
detailVO.executeQuery()

// Create detail record
Row newRow = detailVO.createRow()
newRow.setAttribute("EmployeeId", empId) // Foreign key
detailVO.insertRow(newRow)

// Delete detail record
Row rowToDelete = detailVO.getFilteredRows("JobHistoryId", jobHistId)[0]
rowToDelete.remove()
am.getTransaction().commit()
```

**Architecture Notes**:
- Master VO: Independent query (all employees)
- Detail VO: Filtered by foreign key (job history)
- View Link: Defines master-detail relationship in BC4J
- One master row → Many detail rows

**Testing Checklist**:
- ✓ Master query loads successfully
- ✓ Detail empty on initial load
- ✓ Detail refreshes on master selection
- ✓ Add new job history works
- ✓ Foreign key set automatically
- ✓ Delete job history works
- ✓ PPR works without full page refresh
- ✓ No orphan records created

---

## 📖 Lab Enhancements (Try on Your Own)

Each lab includes suggested enhancements for additional practice:

**Lab 1 Enhancements**:
- Add date range search (hire date from/to)
- Add sorting functionality
- Add export to Excel button
- Add pagination for large result sets
- Add "Advanced Search" with more criteria

**Lab 2 Enhancements**:
- Add confirmation dialog before delete
- Add "Save and New" button
- Add field-level validation (onSubmit)
- Add duplicate check before save
- Add attachment functionality

**Lab 3 Enhancements**:
- Add search/filter in master region
- Add pagination for master records
- Add inline edit in detail table
- Add summary/aggregate (total years)
- Add multiple detail sections
- Add drill-down to third level

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

### 9. Nested Application Module (Advanced)
**Directory**: `nested-am/`  
**File**: `NestedAMPatterns.java` (521 lines, 11 methods)

**Use Cases**:
- Create root AM via JNDI
- Create nested AM from parent
- Find nested AM by instance name
- List all nested AMs
- Get root AM transaction from nested AM
- Find nested AM with system-generated name
- Get root AM from controller
- Access nested AM from controller
- Verify nested AM definition match
- Understand nested AM transaction scope
- Debug nested AM hierarchy

**Key Patterns**:
```java
ApplicationModuleHome.create()
parentAM.createApplicationModule()
parentAM.findApplicationModule()
parentAM.getApplicationModuleNames()
getOADBTransaction()
pageContext.getRootApplicationModule()
```

---

### 10. MDS Repository Operations (Advanced)
**Directory**: `mds-repository/`  
**File**: `MDSOperations.java` (558 lines, 10 methods)

**Use Cases**:
- Query page hierarchy from JDR_PATHS
- Query page components from JDR_COMPONENTS
- Query component attributes from JDR_ATTRIBUTES
- Find all personalizations for a page
- Find all pages using specific AM
- Query translated attributes
- Find all controllers in module
- Using JDR_UTILS PL/SQL package
- Find orphaned components
- Understand MDS cache and performance

**Key Patterns**:
```java
JDR_PATHS table queries
JDR_COMPONENTS table queries
JDR_ATTRIBUTES table queries
JDR_UTILS PL/SQL package
MDS cache behavior
```

---

### 11. Session Management (Intermediate to Advanced)
**Directory**: `session-management/`  
**File**: `SessionManagement.java` (487 lines, 10 methods)

**Use Cases**:
- Access HTTP/Servlet session
- Access ICX session (Oracle Apps session)
- Understand session timeouts (HTTP vs ICX)
- Query ICX_SESSIONS table
- Store data in HTTP session
- Understand JVM cache behavior
- Get session values from page context
- Understand session state vs database state
- Invalidate HTTP session programmatically
- Session management best practices

**Key Patterns**:
```java
pageContext.getHttpSession()
pageContext.getWebAppsContext()
ICX_SESSIONS table
session.setAttribute()/getAttribute()
Profile options for timeouts
session.invalidate()
```

---

### 12. Profile Options (Beginner to Intermediate)
**Directory**: `profile-options/`  
**File**: `ProfileOptionPatterns.java` (678 lines, 13 methods)

**Use Cases**:
- Read profile option value (Controller)
- Read profile option value (Application Module)
- Use FND_Diagnostics profile
- Write diagnostics in controller
- Write diagnostics in AM
- Check personalization enabled
- Check region link enabled
- Check personalization disabled
- Get personalization root path
- Create custom profile option
- Understand profile option hierarchy
- Common profile options reference
- Profile options best practices

**Key Patterns**:
```java
pageContext.getProfile()
getOADBTransaction().getProfile()
pageContext.writeDiagnostics()
getOADBTransaction().writeDiagnostics()
Profile option hierarchy (User > Resp > App > Site)
```

---

### 13. Advanced Controller Patterns (Advanced)
**Directory**: `advanced-controller/`  
**File**: `AdvancedControllerPatterns.java` (593 lines, 14 methods)

**Use Cases**:
- Block form submission (setBlockOnEverySubmit)
- Block specific button with JavaScript
- Disable global buttons
- Set initial focus on field
- Handle Enter key press on field
- Handle browser back button
- End transaction unit before navigation
- Wrap text in read-only text area
- Check if form submission
- Get event and source parameters
- Set field values programmatically
- Release database lock
- Controller extension pattern
- Advanced controller best practices

**Key Patterns**:
```java
OABodyBean.setBlockOnEverySubmit()
JavaScript button disabling
OAGlobalButtonBarBean.setRendered()
OABodyBean.setInitialFocusId()
OABoundValueEnterOnKeyPress
TransactionUnitHelper.startTransactionUnit()
pageContext.isBackNavigationFired()
pageContext.isFormSubmission()
OAWebBeanConstants.EVENT_PARAM
OAWebBeanConstants.SOURCE_PARAM
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

### v1.2 (2026-01-26)
- Added Advanced Controller Patterns category
- 14 advanced use cases covering UI manipulation
- Form submission blocking patterns (setBlockOnEverySubmit, JavaScript)
- Focus and event management
- Browser back button handling with TransactionUnitHelper
- Global button control
- Controller extension patterns
- 593 new lines of code with detailed examples
- Total: 13 categories, 13 files, 5,191 lines, 149 methods, 138 use cases
- Source: OAF Reference - By Mostafa EL-Ruby.docx

### v1.1 (2026-01-26)
- Added 4 new advanced categories from OAF Reference documentation
- Nested Application Module patterns (11 use cases, 521 lines)
- MDS Repository operations (10 use cases, 558 lines)
- Session Management patterns (10 use cases, 487 lines)
- Profile Options patterns (13 use cases, 678 lines)
- Total: 12 categories, 12 files, 4,598 lines, 135 methods, 124 use cases
- Enhanced documentation with advanced concepts
- Source: OAF Reference - By Mostafa EL-Ruby.docx

### v1.0 (2026-01-25)
- Initial code-brain creation
- 8 categories with comprehensive examples
- 8 Java files with 1,943 lines of code
- 91 methods demonstrating 80 use cases
- Complete documentation with best practices

---

## 📚 Enhancement Sources

This code repository has been enhanced with patterns and examples from:
- **OAF Reference - By Mostafa EL-Ruby.docx**: Official Oracle Application Framework reference documentation covering architecture, MDS repository, session management, profile options, nested AM concepts, naming standards, and more.
- **Oracle OAF Developer's Guide**: Official Oracle documentation
- **BC4J Developer's Guide**: Business Components for Java documentation
- **Project brain-repo**: Accumulated knowledge from various OAF resources

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
- See [brain-repo/OAF/](../demasylabs-barin/brain-repo/OAF/) for additional resources

---

**Created**: 2026-01-25  
**Last Updated**: 2026-01-26  
**Version**: 1.2  
**Maintained By**: Oracle OAF BootCamp Team
