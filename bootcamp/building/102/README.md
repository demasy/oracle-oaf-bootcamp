# Oracle OAF Building BootCamp 102

**Code:** DL-OAF-B-102 | **Level:** Advanced | **Duration:** 20-25 days | **Scaffolding:** 40% guidance | **Certification milestone:** Professional OAF Developer

**Path:** Core is the required reference path; Required is content the exit depends on; Extended is optional depth.  
**Entry:** Dev 101 complete: can build and deploy a CRUD application.  
**Exit:** Learner delivers an application with events, PPR, LOVs, exception handling and advanced tables.  
**Assessment:** Final assessment project, either the Advanced HR Management System or the Procurement Request System, after Project 102.

## Course Goals

- Intercept user interactions and execute post-back processing with processFormRequest
- Update specific page regions with partial page rendering
- Build lists of values, including dependent LOVs
- Implement exception handling and user messaging
- Manage confirmation workflows with dialog pages
- Build advanced tables with inline record creation and deletion
- Change web bean state dynamically during the page lifecycle

## Curriculum

| Section | Module | Title | Path | Track | Lectures |
| :-: | :-- | :-- | :-: | :-- | :-: |
| [1] | B102-001 | [Form Event Handling Lifecycle](#1-form-event-handling-lifecycle) | Core | Core Path | 2 |
| [2] | B102-002 | [Asynchronous UI via PPR](#2-asynchronous-ui-via-ppr) | Core | Core Path | 2 |
| [3] | B102-003 | [List of Values (LOV) Engineering](#3-list-of-values-lov-engineering) | Core | Core Path | 4 |
| [4] | B102-004 | [Enterprise Exception Framework](#4-enterprise-exception-framework) | Core | Core Path | 3 |
| [5] | B102-005 | [Modal Dialogs and Page Navigation](#5-modal-dialogs-and-page-navigation) | Core | Core Path | 2 |
| [6] | B102-006 | [Advanced Table Operations](#6-advanced-table-operations) | Core | Core Path | 3 |
| [7] | B102-007 | [Dynamic UI Control and Focus](#7-dynamic-ui-control-and-focus) | Core | Core Path | 6 |
| [8] | B102-008 | [Advanced Model and Server-Side Features](#8-advanced-model-and-server-side-features) | Extended | Advanced Model and Data | 6 |
| [9] | B102-009 | [Data Formatting and Validation](#9-data-formatting-and-validation) | Extended | Advanced Model and Data | 4 |
| [10] | B102-010 | [Configuration and Defaults](#10-configuration-and-defaults) | Extended | Advanced Model and Data | 3 |
| [11] | B102-011 | [Layout and Container Regions](#11-layout-and-container-regions) | Extended | Advanced UI Components | 6 |
| [12] | B102-012 | [Data Regions, Grids and Charts](#12-data-regions-grids-and-charts) | Extended | Advanced UI Components | 5 |
| [13] | B102-013 | [Wizards, Rich Inputs and Configurable Pages](#13-wizards-rich-inputs-and-configurable-pages) | Extended | Advanced UI Components | 5 |
| [14] | B102-014 | [Flexfields, SPEL and Forms Integration](#14-flexfields-spel-and-forms-integration) | Extended | Advanced UI Components | 7 |
| [15] | B102-015 | [Client-Side Scripting and Page Modes](#15-client-side-scripting-and-page-modes) | Extended | Advanced UI Components | 2 |
| [16] | B102-016 | [Files, Documents and Data Exchange](#16-files-documents-and-data-exchange) | Extended | Integration, Platform and Diagnostics | 6 |
| [17] | B102-017 | [Navigation, Workflow and Background Processing](#17-navigation-workflow-and-background-processing) | Extended | Integration, Platform and Diagnostics | 4 |
| [18] | B102-018 | [Internationalization, Accessibility and Usability](#18-internationalization-accessibility-and-usability) | Extended | Integration, Platform and Diagnostics | 4 |
| [19] | B102-019 | [Advanced Debugging](#19-advanced-debugging) | Extended | Integration, Platform and Diagnostics | 3 |
| [20] | B102-020 | [Projects and Final Assessment](#20-projects-and-final-assessment) | Required | Core Path | 6 |

## [1] Form Event Handling Lifecycle

**Module:** B102-001 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-001.001 | Handling Form Submissions with processFormRequest | Video | Examples | processFormRequest(), processFormData(), button clicks, validation |
| B102-001.002 | Applying Common Controller Patterns | Video | Patterns | Parameters, form values, navigation, messages |

## [2] Asynchronous UI via PPR

**Module:** B102-002 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-002.001 | Enabling Partial Page Rendering (PPR) for Dynamic UI | Lab | Tutorial | AJAX in OAF, PPR events, dynamic updates |
| B102-002.002 | Handling PPR Events on the Server | Lab | Tutorial | PPR event triggers, dynamic target regions, processFormRequest handling of PPR events |

## [3] List of Values (LOV) Engineering

**Module:** B102-003 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-003.001 | Configuring List of Values (LOV) for Data Selection | Lab | Tutorial | Standard, dependent, and external LOVs; listOfValues region, lovMap criteria and result mapping, messageLovInput |
| B102-003.002 | Building Dependent (Cascading) LOVs | Lab | Tutorial | Parent-child LOVs, criteria items, dynamic result mapping, clearing dependent fields |
| B102-003.003 | Enabling LOV Auto-Completion and Look-Ahead | Lab | Tutorial | Foreign key validation, look-ahead dropdowns, auto-completion, popup LOV fallback |
| B102-003.004 | Wiring LOV Action Buttons and Mappings | Lab | Tutorial | lovActionButton, lovActionMap, lovMap return values, actions inside the LOV window |

## [4] Enterprise Exception Framework

**Module:** B102-004 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-004.001 | Handling Exceptions with the OAF Exception Hierarchy | Video | Guide | OAException, checked/unchecked, propagation |
| B102-004.002 | Applying Exception Severity Levels and Inline Messages | Lab | Guide | OAException severities (ERROR, WARNING, INFORMATION, CONFIRMATION), inline message rendering; OAAttrValException, OARowValException and bundled exceptions |
| B102-004.003 | Raising Bundle/Multiple Error Messages | Lab | Examples | Message bundles, multiple validation errors, user-friendly messages, i18n |

## [5] Modal Dialogs and Page Navigation

**Module:** B102-005 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-005.001 | Providing User Feedback with Messages and Dialog Pages | Video | Reference | Error messages, dialogs, tokens, i18n |
| B102-005.002 | Controlling Page Flow with Dialog Pages | Lab | Tutorial | OADialogPage, putDialogMessage(), pageContext.forwardImmediately(), confirmation workflows |

## [6] Advanced Table Operations

**Module:** B102-006 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-006.001 | Implementing Advanced Table Region | Lab | Tutorial | Selection, sorting, filtering, row actions, footer calculations, performance; tableFooter; singleSelection and multipleSelection row selection items |
| B102-006.002 | Creating and Deleting Table Rows Programmatically | Lab | Project | Advanced table row creation, dynamic row deletion, single and multiple row selection, table events |
| B102-006.003 | Building Updateable Summary Pages with Batch Actions | Lab | Project | Multi-row table updates, row duplication, batch delete, partial commit handling |

## [7] Dynamic UI Control and Focus

**Module:** B102-007 | **Path:** Core | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-007.001 | Creating Web Beans Programmatically | Lab | Tutorial | WebBean hierarchy, OAWebBeanFactory, component properties, page structure |
| B102-007.002 | Creating Items Programmatically | Lab | Examples | Text fields, buttons, LOVs, all widget types |
| B102-007.003 | Creating Regions Programmatically | Lab | Tutorial | Region types, layout configuration, nested regions |
| B102-007.004 | Adding Regions to OAF Pages Programmatically | Lab | Examples | Dynamic page composition, runtime UI modification, use cases |
| B102-007.005 | Creating Submit Button Programmatically | Lab | Tutorial | Button properties, event handlers, action binding |
| B102-007.006 | Controlling Focus and Dynamic Bean Properties | Lab | Tutorial | OABodyBean.setInitialFocusId(), dynamic read-only and rendered states, runtime bean changes |

## [8] Advanced Model and Server-Side Features

**Module:** B102-008 | **Path:** Extended | **Track:** Advanced Model and Data  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-008.001 | Developing Programmatic View Objects Dynamically | Lab | Examples | Dynamic VOs, runtime attributes, use cases |
| B102-008.002 | Creating Dynamic View Objects Programmatically | Lab | Tutorial | ViewObjectImpl methods, dynamic queries, adding to AM, use cases |
| B102-008.003 | Adding Attributes to View Objects Programmatically | Lab | Examples | AttributeDef creation, data types, calculated & transient attributes |
| B102-008.004 | Executing SQL Statements | Lab | Tutorial | Using JDBC in OAF, PreparedStatement, handling result sets, connections |
| B102-008.005 | Calling PL/SQL Functions and Procedures | Lab | Examples | CallableStatement usage, IN/OUT parameters, function returns, error handling |
| B102-008.006 | Applying Server-Side Best Practices | Video | Patterns | PL/SQL vs Java, performance considerations, transaction management |

## [9] Data Formatting and Validation

**Module:** B102-009 | **Path:** Extended | **Track:** Advanced Model and Data  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-009.001 | Manipulating and Formatting Dates | Lab | Tutorial | Date comparisons, Oracle date formats, timezone handling, calculations |
| B102-009.002 | Formatting Numbers | Lab | Examples | Number formats, currency display, locale considerations, decimal precision |
| B102-009.003 | Implementing Data Validations | Lab | Guide | Field-level validation, cross-field validation, business rule validation |
| B102-009.004 | Implementing Validation Using Entity Expert | Lab | Tutorial | Entity Expert pattern, shared validation rules across pages, complex business rules, messages |

## [10] Configuration and Defaults

**Module:** B102-010 | **Path:** Extended | **Track:** Advanced Model and Data  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-010.001 | Setting Default Values | Lab | Tutorial | Text fields, number fields, date fields, techniques and best practices |
| B102-010.002 | Querying Page Metadata in the MDS Repository | Video | Guide | How page metadata is stored and queried, from a developer view; MDS architecture and administration are covered in Cust 101 |
| B102-010.003 | Configuring Important Profile Options | Video | Reference | Key profile options, impact on behavior, setting programmatically |

## [11] Layout and Container Regions

**Module:** B102-011 | **Path:** Extended | **Track:** Advanced UI Components  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-011.001 | Implementing Hide/Show Region | Lab | Tutorial | Conditional rendering, PPR for dynamic display, UX considerations |
| B102-011.002 | Implementing Flow Layout Region | Lab | Examples | Flow vs other layouts, component arrangement, responsive design |
| B102-011.003 | Implementing Advanced Layout Region | Lab | Patterns | Table/Row/Cell layouts, nested layouts, complex forms |
| B102-011.004 | Implementing Content Container Region | Lab | Examples | Tab-based navigation, hiding/showing tabs, dynamic tab generation; richContainer |
| B102-011.005 | Implementing Panel Splitter and Layered Layout | Lab | Tutorial | panelSplitter, layeredLayout, adjustable panels, Redirect Mode and Form Submission Mode |
| B102-011.006 | Building Custom Grids with tableLayout and cellFormat | Lab | Tutorial | Explicit rows and cells, columnSpan, rowSpan, hAlign, vAlign, width and height |

## [12] Data Regions, Grids and Charts

**Module:** B102-012 | **Path:** Extended | **Track:** Advanced UI Components  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-012.001 | Implementing Query Region (Advanced) | Lab | Guide | Construction modes, results-based search, auto-customization, configuration |
| B102-012.002 | Implementing HGrid Region | Lab | Tutorial | Hierarchical data, expandable nodes, tree navigation, performance; tree, nodeDef and childNode definitions |
| B102-012.003 | Implementing Charts and Graphs | Lab | Tutorial | Chart types, data binding, interactive charts, BI Publisher integration |
| B102-012.004 | Implementing Bulleted Lists | Lab | Tutorial | bulletedList, multi-column lists (up to three columns), bound to view rows |
| B102-012.005 | Implementing Auto-Repeating Layouts | Lab | Tutorial | Auto-repeating regions generated from view object rows, dynamic sections, per-row content |

## [13] Wizards, Rich Inputs and Configurable Pages

**Module:** B102-013 | **Path:** Extended | **Track:** Advanced UI Components  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-013.001 | Implementing Train Region | Lab | Examples | Multi-step processes, train stops, navigation, validation, progress tracking |
| B102-013.002 | Implementing Shuttle Region | Lab | Tutorial | Dual-list selection, moving items, ordering, search functionality |
| B102-013.003 | Implementing Multi-Step Create and Update Flows | Lab | Project | Train-based wizards, transaction state across steps, iterative versus single-submit updates |
| B102-013.004 | Building Rich Text, Color Picker and Rating Bar Inputs | Lab | Tutorial | richTextEditor, messageRichTextEditor, colorPicker, messageRatingBar bound to a form |
| B102-013.005 | Building Configurable Pages with flexibleLayout | Lab | Project | flexibleLayout, flexibleContent, flexibleContentList, user and admin dashboard tiles |

## [14] Flexfields, SPEL and Forms Integration

**Module:** B102-014 | **Path:** Extended | **Track:** Advanced UI Components  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-014.001 | Configuring a Key Flexfield Region | Lab | Tutorial | KFF configuration, binding to page, validation, capturing values |
| B102-014.002 | Configuring a Descriptive Flexfield Region | Lab | Tutorial | DFF configuration, context-sensitive DFF, EO integration, querying |
| B102-014.003 | Changing Item Properties Using SPEL | Lab | Examples | SPEL syntax, conditional properties, dynamic rendering, performance |
| B102-014.004 | Adding Custom HTML Code | Lab | Guide | RawText component, JavaScript integration, security, best practices |
| B102-014.005 | Launching Oracle Forms from OAF | Lab | Tutorial | Form function call, parameter passing, integration patterns |
| B102-014.006 | Launching OAF Pages from Oracle Forms | Lab | Guide | ICX integration, URL construction, SSO considerations |
| B102-014.007 | Mapping Flexfield Segments with flexMap | Lab | Tutorial | flex and flexMap regions for DFF and KFF, mapping segments to page items |

## [15] Client-Side Scripting and Page Modes

**Module:** B102-015 | **Path:** Extended | **Track:** Advanced UI Components  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-015.001 | Using JavaScript in OAF | Lab | Guide | Client-side validation, UI enhancements, calling Java, security |
| B102-015.002 | Implementing Read-Only Page | Lab | Tutorial | Disabling inputs, visual indicators, conditional read-only mode |

## [16] Files, Documents and Data Exchange

**Module:** B102-016 | **Path:** Extended | **Track:** Integration, Platform and Diagnostics  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-016.001 | Enabling Attachments in Pages | Lab | Tutorial | FND_ATTACHED_DOCUMENTS, configuration, UI integration, file storage; attachmentTable, attachmentLink, attachmentImage, messageInlineAttachment, entityMap, categoryMap, primaryKey |
| B102-016.002 | Enabling File Upload in Pages | Lab | Tutorial | File upload component, server-side handling, validation, storage options; messageFileUpload |
| B102-016.003 | Building Import Data Functionality | Lab | Examples | CSV/Excel import, data validation, batch processing, error handling |
| B102-016.004 | Building Export Data Functionality | Lab | Tutorial | Export formats (CSV, Excel, PDF), large data sets, streaming, performance |
| B102-016.005 | Publishing Documents to the Document Catalog | Lab | Guide | Document set upload, catalog publishing, AntiSamy filtering and virus scanning on upload |
| B102-016.006 | Displaying PDFs Inline and Downloading Files Securely | Lab | Tutorial | Rendering PDFs inline, streaming binary files, secure download handling; messageDownload |

## [17] Navigation, Workflow and Background Processing

**Module:** B102-017 | **Path:** Extended | **Track:** Integration, Platform and Diagnostics  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-017.001 | Handling Browser Back Button | Lab | Guide | Back button issues, prevention techniques, transaction integrity |
| B102-017.002 | Building Workflow-Enabled OAF Applications | Lab | Tutorial | Launching workflow, passing parameters, monitoring, embedding OAF in notification |
| B102-017.003 | Implementing Deep Links and Bookmarkable URLs | Lab | Guide | RF.jsp, OA.jsp and OAD.jsp URLs, passing parameters, security of direct page access |
| B102-017.004 | Submitting Concurrent Requests from OAF Pages | Lab | Tutorial | Declarative request submission, monitoring requests, passing parameters |

## [18] Internationalization, Accessibility and Usability

**Module:** B102-018 | **Path:** Extended | **Track:** Integration, Platform and Diagnostics  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-018.001 | Supporting Multiple Languages and Internationalization | Lab | Guide | MLS and _TL tables, timezone conversion, client character encoding, right-to-left alignment |
| B102-018.002 | Enabling Screen Reader Mode, Row Headers and Hot Keys | Lab | Checklist | Screen reader optimized mode, rowheadercol, accelerator hot keys, tested on a page |
| B102-018.003 | Warning on Unsaved Changes with the Enhanced Save Model | Lab | Tutorial | Detecting uncommitted changes, warning before navigating away, save and discard flows |
| B102-018.004 | Auditing Accessibility Compliance of a Page | Lab | Checklist | Accessibility audit of labels, row headers, keyboard access and contrast |

## [19] Advanced Debugging

**Module:** B102-019 | **Path:** Extended | **Track:** Integration, Platform and Diagnostics  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-019.001 | Using demasy-oaf Libraries for Debugging | Lab | Tutorial | Library overview, installation, debug utilities, performance profiling |
| B102-019.002 | Applying Advanced Debugging Techniques | Lab | Guide | Remote debugging, production debugging, log analysis, performance profiling |
| B102-019.003 | Using the About This Page and OAInfo.jsp Diagnostics | Lab | Guide | Page inspector, OAInfo.jsp, technology stack and profile option inspection, regionMap.xml |

## [20] Projects and Final Assessment

**Module:** B102-020 | **Path:** Required | **Track:** Core Path  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-020.001 | Kicking Off and Planning Project 101 | Workshop | Guide | Setting up project structure, Git version control, database design, project planning, team collaboration setup; applied to Project 102 (the POS system is the Dev 103 capstone) (Duration: 2.5 Days) |
| B102-020.002 | Building Project 102 for Items with an Approval Cycle | Lab | Project | Multi-step approval workflow, complex business logic, workflow integration, advanced UI features, item creation form, multi-level approvals, email notifications, approval history, advanced search and reporting (Duration: 5 Days) |
| B102-020.003 | Selecting the Final Assessment Project | Workshop | Guide | Comprehensive project requirements, choosing between Option A (Advanced HR Management System) or Option B (Procurement Request System), planning and timeline |
| B102-020.004 | Building the Advanced HR Management System (Option A) | Lab | Project | Employee self-service portal, manager approval workflows, workflow integration, reports and dashboards, complete HRIS functionality |
| B102-020.005 | Building the Procurement Request System (Option B) | Lab | Project | Purchase requisition creation, multi-level approval process, budget validation logic, PO integration, procurement workflow |
| B102-020.006 | Applying the Assessment Criteria and Deliverables | Workshop | Rubric | All Level 102 concepts (40%), Code quality and standards (25%), Architecture and design (20%), Documentation (10%), Innovation and extras (5%) |
