# Oracle Application Framework (OAF) BootCamp

## 🚀 Level 102: Oracle OAF Building BootCamp (Advanced)

**Duration:** 20-25 Days  
**Level:** Advanced  
**Prerequisites:** Completion of Level 101 or equivalent experience  
**Scaffolding Level:** Moderate (40% guidance, 60% independence)

### Level 102 Learning Outcomes

Upon completion of Level 102, students will be able to:

**Note:** At this level, scaffolding is significantly reduced. Students receive high-level guidance and must independently implement solutions with occasional checkpoints.
**Core outcomes**
- **LO2.1:** Intercept user interactions and execute post-back processing with processFormRequest
- **LO2.2:** Update specific page regions with partial page rendering
- **LO2.3:** Build lists of values, including dependent LOVs
- **LO2.4:** Implement exception handling and user messaging
- **LO2.5:** Manage confirmation workflows with dialog pages
- **LO2.6:** Build advanced tables with inline record creation and deletion
- **LO2.7:** Change web bean state dynamically during the page lifecycle

**Extended outcomes**
- **LO2.8:** Create dynamic View Objects programmatically
- **LO2.9:** Execute SQL statements and call PL/SQL procedures from OAF
- **LO2.10:** Implement advanced UI components (HGrid, Train, Shuttle, etc.)
- **LO2.11:** Integrate Flexfields (Key and Descriptive) in OAF pages
- **LO2.12:** Implement file upload/download and data import/export
- **LO2.13:** Build workflow-enabled OAF applications
- **LO2.14:** Implement advanced debugging techniques


<br>

## [1] Advanced Model Implementation
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Create View Objects dynamically at runtime
- Add attributes to VOs programmatically
- Implement complex query logic

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 1.1 | Creating Dynamic View Objects Programmatically | Lab | ✓ | Tutorial | ViewObjectImpl methods, dynamic queries, adding to AM, use cases |
| 1.2 | Adding Attributes to View Objects Programmatically | Lab | ✓ | Examples | AttributeDef creation, data types, calculated & transient attributes |

<br>

## [2] Server-Side Features
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Execute SQL statements from Java
- Call PL/SQL functions and procedures
- Handle database interactions efficiently
- Implement business logic in AM

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 2.1 | Executing SQL Statements | Lab | ✓ | Tutorial | Using JDBC in OAF, PreparedStatement, handling result sets, connections |
| 2.2 | Calling PL/SQL Functions and Procedures | Lab | ✓ | Examples | CallableStatement usage, IN/OUT parameters, function returns, error handling |
| 2.3 | Best Practices | Video | ✓ | Best Practices | PL/SQL vs Java, performance considerations, transaction management |

<br>

## [3] Advanced View Components
**Duration:** 10 Days | **Level**: Advanced

### Learning Objectives
- Implement all advanced UI regions
- Create dynamic hide/show functionality
- Build query regions with advanced features
- Implement tables with advanced features
- Create multi-step train pages
- Integrate Flexfields

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 3.1 | Implementing Hide/Show Region | Lab | ✓ | Tutorial | Conditional rendering, PPR for dynamic display, UX considerations |
| 3.2 | Implementing Flow Layout Region | Lab | ✓ | Examples | Flow vs other layouts, component arrangement, responsive design |
| 3.3 | Implementing Query Region (Advanced) | Lab | ✓ | Guide | Construction modes, results-based search, auto-customization, configuration |
| 3.4 | Implementing Advanced Table Region | Lab | ✓ | Tutorial | Selection, sorting, filtering, row actions, footer calculations, performance; tableFooter; singleSelection and multipleSelection row selection items |
| 3.5 | Implementing Train Region | Lab | ✓ | Examples | Multi-step processes, train stops, navigation, validation, progress tracking |
| 3.6 | Implementing Shuttle Region | Lab | ✓ | Tutorial | Dual-list selection, moving items, ordering, search functionality |
| 3.7 | Implementing Advanced Layout Region | Lab | ✓ | Patterns | Table/Row/Cell layouts, nested layouts, complex forms |
| 3.8 | Implementing HGrid Region | Lab | ✓ | Tutorial | Hierarchical data, expandable nodes, tree navigation, performance; tree, nodeDef and childNode definitions |
| 3.9 | Implementing Content Container Region | Lab | ✓ | Examples | Tab-based navigation, hiding/showing tabs, dynamic tab generation; richContainer |
| 3.10 | Implementing Charts and Graphs | Lab | ✓ | Tutorial | Chart types, data binding, interactive charts, BI Publisher integration |
| 3.11 | Adding Custom HTML Code | Lab | ✓ | Guide | RawText component, JavaScript integration, security, best practices |
| 3.12 | Implementing Key Flexfield Region | Lab | ✓ | Tutorial | KFF configuration, binding to page, validation, capturing values |
| 3.13 | Implementing Descriptive Flexfield Region | Lab | ✓ | Tutorial | DFF configuration, context-sensitive DFF, EO integration, querying |
| 3.14 | Changing Item Properties Using SPEL | Lab | ✓ | Examples | SPEL syntax, conditional properties, dynamic rendering, performance |
| 3.15 | Launching Oracle Forms from OAF | Lab | ✓ | Tutorial | Form function call, parameter passing, integration patterns |
| 3.16 | Launching OAF Pages from Oracle Forms | Lab | ✓ | Guide | ICX integration, URL construction, SSO considerations |
| 3.17 | Implementing Dependent (Cascading) LOVs | Lab | ✓ | Tutorial | Parent-child LOVs, criteria items, dynamic result mapping, clearing dependent fields |
| 3.18 | Handling PPR Events on the Server | Lab | ✓ | Tutorial | PPR event triggers, dynamic target regions, processFormRequest handling of PPR events |
| 3.19 | Implementing Panel Splitter and Layered Layout | Lab | ✓ | Tutorial | panelSplitter, layeredLayout, adjustable panels, multi-mode pages |
| 3.20 | Implementing Rich Inputs: Rich Text Editor, Color Picker and Rating Bar | Lab | ✓ | Tutorial | richTextEditor, messageRichTextEditor, colorPicker, messageRatingBar |
| 3.21 | Implementing Bulleted Lists | Lab | ✓ | Tutorial | bulletedList, multi-column lists, dynamic list content |
| 3.22 | Configurable Pages with flexibleLayout and flexibleContent | Lab | ✓ | Project | flexibleLayout, flexibleContent, flexibleContentList, user and admin dashboard tiles |
| 3.23 | Multi-Step Create and Update Flows | Lab | ✓ | Project | Train-based wizards, transaction state across steps, iterative versus single-submit updates |
| 3.24 | Implementing LOV Auto-Completion and Look-Ahead | Lab | ✓ | Tutorial | Foreign key validation, look-ahead dropdowns, auto-completion, popup LOV fallback |
| 3.25 | Building Custom Grids with tableLayout, rowLayout and cellFormat | Lab | ✓ | Tutorial | Explicit rows and cells, columnSpan, rowSpan, hAlign, vAlign, width and height |
| 3.26 | Implementing Auto-Repeating Layouts | Lab | ✓ | Tutorial | Repeating regions generated from view object rows, dynamic sections, per-row content |
| 3.27 | LOV Action Buttons and Mappings | Lab | ✓ | Tutorial | lovActionButton, lovActionMap, lovMap return values, actions inside the LOV window |

<br>

## [4] Advanced Controller and Programmatic UI
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Create UI components programmatically
- Build dynamic pages at runtime
- Implement JavaScript integration
- Create read-only pages dynamically

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 4.1 | WebBean Creation Programmatically | Lab | ✓ | Tutorial | WebBean hierarchy, OAWebBeanFactory, component properties, page structure |
| 4.2 | Create Items Programmatically | Lab | ✓ | Examples | Text fields, buttons, LOVs, all widget types |
| 4.3 | Create Regions Programmatically | Lab | ✓ | Tutorial | Region types, layout configuration, nested regions |
| 4.4 | Add Region to OAF Page Programmatically | Lab | ✓ | Examples | Dynamic page composition, runtime UI modification, use cases |
| 4.5 | Creating Submit Button Programmatically | Lab | ✓ | Tutorial | Button properties, event handlers, action binding |
| 4.6 | Using JavaScript in OA Framework | Lab | ✓ | Guide | Client-side validation, UI enhancements, calling Java, security |
| 4.7 | Implementing Read-Only Page | Lab | ✓ | Tutorial | Disabling inputs, visual indicators, conditional read-only mode |
| 4.8 | Controlling Focus and Dynamic Bean Properties | Lab | ✓ | Tutorial | OABodyBean.setInitialFocusId(), dynamic read-only and rendered states, runtime bean changes |
| 4.9 | Creating and Deleting Table Rows Programmatically | Lab | ✓ | Project | Advanced table row creation, dynamic row deletion, single and multiple row selection, table events |
| 4.10 | Updateable Summary Pages: Batch Update, Duplicate and Delete Rows | Lab | ✓ | Project | Multi-row table updates, row duplication, batch delete, partial commit handling |

<br>

## [5] Data Manipulation and Validation
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Format dates and numbers properly
- Implement data validation
- Use Entity Experts for complex validation

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 5.1 | Date Manipulation & Formatting | Lab | ✓ | Tutorial | Date comparisons, Oracle date formats, timezone handling, calculations |
| 5.2 | Formatting Numbers | Lab | ✓ | Examples | Number formats, currency display, locale considerations, decimal precision |
| 5.3 | Data Validations | Lab | ✓ | Guide | Field-level validation, cross-field validation, business rule validation |
| 5.4 | Implementing Validation Using Entity Expert | Lab | ✓ | Tutorial | Entity Expert pattern, reusable validation, complex business rules, messages |

<br>

## [6] Advanced Features and Integrations
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Implement attachments functionality
- Build file upload/download features
- Create data import/export functionality
- Handle browser back button
- Integrate with Oracle Workflow

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 6.1 | Setting Default Values | Lab | ✓ | Tutorial | Text fields, number fields, date fields, techniques and best practices |
| 6.2 | Understanding MDS Repository | Video | ✓ | Guide | How page metadata is stored and queried, from a developer view; MDS architecture and administration are covered in Cust 101 |
| 6.3 | Important Profile Options | Video | ✓ | Reference | Key profile options, impact on behavior, setting programmatically |
| 6.4 | Implementing Attachments Functionality | Lab | ✓ | Tutorial | FND_ATTACHED_DOCUMENTS, configuration, UI integration, file storage; attachmentTable, attachmentLink, attachmentImage, messageInlineAttachment, entityMap, categoryMap, primaryKey |
| 6.5 | Implementing Upload Files Functionality | Lab | ✓ | Tutorial | File upload component, server-side handling, validation, storage options; messageFileUpload |
| 6.6 | Implementing Import Data Functionality | Lab | ✓ | Examples | CSV/Excel import, data validation, batch processing, error handling |
| 6.7 | Implementing Export Data Functionality | Lab | ✓ | Tutorial | Export formats (CSV, Excel, PDF), large data sets, streaming, performance |
| 6.8 | Handling Browser Back Button | Lab | ✓ | Guide | Back button issues, prevention techniques, transaction integrity |
| 6.9 | Workflow in OA Framework | Lab | ✓ | Tutorial | Launching workflow, passing parameters, monitoring, embedding OAF in notification |
| 6.10 | Submitting Concurrent Requests from OAF Pages | Lab | ✓ | Tutorial | Declarative request submission, monitoring requests, passing parameters |
| 6.11 | Multi-Language Support and Internationalization | Lab | ✓ | Guide | MLS and _TL tables, timezone conversion, client character encoding, right-to-left alignment |
| 6.12 | Accessibility: Screen Reader Mode, Row Headers and Accelerator Keys | Lab | ✓ | Checklist | Screen reader optimized mode, rowheadercol, keyboard accelerator keys |
| 6.13 | Publishing Documents to the Document Catalog | Lab | ✓ | Guide | Document set upload, catalog publishing, AntiSamy filtering and virus scanning on upload |
| 6.14 | Inline PDF Viewing and Secure File Download | Lab | ✓ | Tutorial | Rendering PDFs inline, streaming binary files, secure download handling; messageDownload |
| 6.15 | Deep Linking and Bookmarkable URLs | Lab | ✓ | Guide | RF.jsp, OA.jsp and OAD.jsp URLs, passing parameters, security of direct page access |
| 6.16 | Enhanced Save Model: Warning on Unsaved Changes | Lab | ✓ | Tutorial | Detecting uncommitted changes, warning before navigating away, save and discard flows |

<br>

## [7] Advanced Debugging and Error Handling
**Duration:** 2.5 Days | **Level**: Ninja

### Learning Objectives
- Use advanced debugging techniques
- Implement custom logging
- Handle multiple error messages
- Debug production issues

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 7.1 | Using demasy-oaf Libraries for Debugging | Lab | ✓ | Tutorial | Library overview, installation, debug utilities, performance profiling |
| 7.2 | Raising Bundle/Multiple Error Messages | Lab | ✓ | Examples | Message bundles, multiple validation errors, user-friendly messages, i18n |
| 7.3 | Advanced Debugging Techniques | Lab | ✓ | Guide | Remote debugging, production debugging, log analysis, performance profiling |
| 7.4 | Exception Severity Levels and Inline Messages | Lab | ✓ | Guide | OAException severities (ERROR, WARNING, INFORMATION, CONFIRMATION), inline message rendering; OAAttrValException, OARowValException and bundled exceptions |
| 7.5 | Dialog Pages and Flow Control | Lab | ✓ | Tutorial | OADialogPage, putDialogMessage(), pageContext.forwardImmediately(), confirmation workflows |
| 7.6 | Diagnostic Pages: About This Page and OAInfo.jsp | Lab | ✓ | Guide | Page inspector, OAInfo.jsp, technology stack and profile option inspection, regionMap.xml |

<br>

## [8] Level 102 Projects
**Duration:** 7.5 Days | **Level**: Advanced

### Learning Objectives
- Apply all Level 102 concepts in practical projects
- Build complex multi-module applications
- Implement approval workflows and business logic
- Create professional project documentation
- Use version control effectively
- Deliver production-ready applications

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 8.1 | Project 101: Project Kickoff and Planning | Workshop | ✓ | Project Guide | Setting up project structure, Git version control, database design, project planning, team collaboration setup; applied to Project 102 (the POS system is the Dev 103 capstone) (Duration: 2.5 Days) |
| 8.2 | Project 102: Items Creation with Approval Cycle | Lab | ✓ | Requirements | Multi-step approval workflow, complex business logic, workflow integration, advanced UI features, item creation form, multi-level approvals, email notifications, approval history, advanced search and reporting (Duration: 5 Days) |

<br>

## [9] Level 102 Final Assessment
**Duration:** 10 Days | **Level**: Advanced

### Learning Objectives
- Demonstrate mastery of all Level 102 concepts
- Design and implement comprehensive enterprise application
- Apply advanced OAF patterns and best practices
- Create production-ready deliverables
- Present professional project documentation

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 9.1 | Final Assessment Overview and Project Selection | Workshop | ✓ | Assessment Guide | Comprehensive project requirements, choosing between Option A (Advanced HR Management System) or Option B (Procurement Request System), planning and timeline |
| 9.2 | Option A: Advanced HR Management System | Lab | ✓ | Project Spec | Employee self-service portal, manager approval workflows, workflow integration, reports and dashboards, complete HRIS functionality |
| 9.3 | Option B: Procurement Request System | Lab | ✓ | Project Spec | Purchase requisition creation, multi-level approval process, budget validation logic, PO integration, procurement workflow |
| 9.4 | Assessment Criteria and Deliverables | Workshop | ✓ | Rubric | All Level 102 concepts (40%), Code quality and standards (25%), Architecture and design (20%), Documentation (10%), Innovation and extras (5%) |

### Certification Milestone
**Professional OAF Developer**: BC4J model design (EO/VO/AM), complex UI construction, LOV and flexfield integration, exception handling.
