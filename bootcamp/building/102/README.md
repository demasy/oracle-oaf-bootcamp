# Oracle OAF Building BootCamp 102

**Code:** DL-OAF-B-102 | **Level:** Advanced | **Duration:** 20-25 days | **Scaffolding:** 40% guidance | **Certification milestone:** Professional OAF Developer

## Course Goals

- Intercept user interactions and execute post-back processing with processFormRequest
- Update specific page regions with partial page rendering
- Build lists of values, including dependent LOVs
- Implement exception handling and user messaging
- Manage confirmation workflows with dialog pages
- Build advanced tables with inline record creation and deletion
- Change web bean state dynamically during the page lifecycle

## Curriculum

| Section | Module | Title | Path | Lectures |
| :-: | :-- | :-- | :-: | :-: |
| [1] | B102-1 | [Form Event Handling Lifecycle](#1-form-event-handling-lifecycle) | Core | 2 |
| [2] | B102-2 | [Asynchronous UI via PPR](#2-asynchronous-ui-via-ppr) | Core | 2 |
| [3] | B102-3 | [List of Values (LOV) Engineering](#3-list-of-values-lov-engineering) | Core | 4 |
| [4] | B102-4 | [Enterprise Exception Framework](#4-enterprise-exception-framework) | Core | 3 |
| [5] | B102-5 | [Modal Dialogs and Page Navigation](#5-modal-dialogs-and-page-navigation) | Core | 2 |
| [6] | B102-6 | [Advanced Table Operations](#6-advanced-table-operations) | Core | 3 |
| [7] | B102-7 | [Dynamic UI Control and Focus](#7-dynamic-ui-control-and-focus) | Core | 6 |
| [8] | B102-8 | [Advanced Model and Server-Side Features](#8-advanced-model-and-server-side-features) | Extended | 6 |
| [9] | B102-9 | [Layout and Container Regions](#9-layout-and-container-regions) | Extended | 7 |
| [10] | B102-10 | [Data Regions, Grids and Charts](#10-data-regions-grids-and-charts) | Extended | 7 |
| [11] | B102-11 | [Wizards, Rich Inputs and Configurable Pages](#11-wizards-rich-inputs-and-configurable-pages) | Extended | 7 |
| [12] | B102-12 | [Flexfields, SPEL and Forms Integration](#12-flexfields-spel-and-forms-integration) | Extended | 7 |
| [13] | B102-13 | [Client-Side Scripting and Page Modes](#13-client-side-scripting-and-page-modes) | Extended | 2 |
| [14] | B102-14 | [Data Formatting and Validation](#14-data-formatting-and-validation) | Extended | 5 |
| [15] | B102-15 | [Configuration and Defaults](#15-configuration-and-defaults) | Extended | 3 |
| [16] | B102-16 | [Files, Documents and Data Exchange](#16-files-documents-and-data-exchange) | Extended | 6 |
| [17] | B102-17 | [Navigation, Workflow and Background Processing](#17-navigation-workflow-and-background-processing) | Extended | 5 |
| [18] | B102-18 | [Internationalization, Accessibility and Usability](#18-internationalization-accessibility-and-usability) | Extended | 7 |
| [19] | B102-19 | [Advanced Debugging](#19-advanced-debugging) | Extended | 4 |
| [20] | B102-20 | [Projects and Final Assessment](#20-projects-and-final-assessment) | Required | 6 |

## [1] Form Event Handling Lifecycle

**Module:** B102-1 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-1.1 | Handling Form Submissions with processFormRequest | Video | Examples | processFormRequest(), button clicks, validation |
| B102-1.2 | Implementing Common Controller Patterns | Video | Patterns | Parameters, form values, navigation, messages |

## [2] Asynchronous UI via PPR

**Module:** B102-2 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-2.1 | Enabling Partial Page Rendering (PPR) for Dynamic UI | Lab | Tutorial | AJAX in OAF, PPR events, dynamic updates |
| B102-2.2 | Handling PPR Events on the Server | Lab | Tutorial | PPR event triggers, dynamic target regions, processFormRequest handling of PPR events |

## [3] List of Values (LOV) Engineering

**Module:** B102-3 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-3.1 | Implementing List of Values (LOV) for Data Selection | Lab | Tutorial | Standard, dependent, and external LOVs; listOfValues region, lovMap criteria and result mapping, messageLovInput |
| B102-3.2 | Implementing Dependent (Cascading) LOVs | Lab | Tutorial | Parent-child LOVs, criteria items, dynamic result mapping, clearing dependent fields |
| B102-3.3 | Implementing LOV Auto-Completion and Look-Ahead | Lab | Tutorial | Foreign key validation, look-ahead dropdowns, auto-completion, popup LOV fallback |
| B102-3.4 | Implementing LOV Action Buttons and Mappings | Lab | Tutorial | lovActionButton, lovActionMap, lovMap return values, actions inside the LOV window |

## [4] Enterprise Exception Framework

**Module:** B102-4 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-4.1 | Handling Exceptions with the OAF Exception Hierarchy | Video | Guide | OAException, checked/unchecked, propagation |
| B102-4.2 | Applying Exception Severity Levels and Inline Messages | Lab | Guide | OAException severities (ERROR, WARNING, INFORMATION, CONFIRMATION), inline message rendering; OAAttrValException, OARowValException and bundled exceptions |
| B102-4.3 | Raising Bundle/Multiple Error Messages | Lab | Examples | Message bundles, multiple validation errors, user-friendly messages, i18n |

## [5] Modal Dialogs and Page Navigation

**Module:** B102-5 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-5.1 | Providing User Feedback with Messages and Dialog Pages | Video | Reference | Error messages, dialogs, tokens, i18n |
| B102-5.2 | Controlling Page Flow with Dialog Pages | Lab | Tutorial | OADialogPage, putDialogMessage(), pageContext.forwardImmediately(), confirmation workflows |

## [6] Advanced Table Operations

**Module:** B102-6 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-6.1 | Implementing Advanced Table Region | Lab | Tutorial | Selection, sorting, filtering, row actions, footer calculations, performance; tableFooter; singleSelection and multipleSelection row selection items |
| B102-6.2 | Creating and Deleting Table Rows Programmatically | Lab | Project | Advanced table row creation, dynamic row deletion, single and multiple row selection, table events |
| B102-6.3 | Building Updateable Summary Pages with Batch Row Actions | Lab | Project | Multi-row table updates, row duplication, batch delete, partial commit handling |

## [7] Dynamic UI Control and Focus

**Module:** B102-7 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-7.1 | Creating Web Beans Programmatically | Lab | Tutorial | WebBean hierarchy, OAWebBeanFactory, component properties, page structure |
| B102-7.2 | Creating Items Programmatically | Lab | Examples | Text fields, buttons, LOVs, all widget types |
| B102-7.3 | Creating Regions Programmatically | Lab | Tutorial | Region types, layout configuration, nested regions |
| B102-7.4 | Adding Regions to OAF Pages Programmatically | Lab | Examples | Dynamic page composition, runtime UI modification, use cases |
| B102-7.5 | Creating Submit Button Programmatically | Lab | Tutorial | Button properties, event handlers, action binding |
| B102-7.6 | Controlling Focus and Dynamic Bean Properties | Lab | Tutorial | OABodyBean.setInitialFocusId(), dynamic read-only and rendered states, runtime bean changes |

## [8] Advanced Model and Server-Side Features

**Module:** B102-8 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-8.1 | Developing Programmatic View Objects Dynamically | Lab | Examples | Dynamic VOs, runtime attributes, use cases |
| B102-8.2 | Creating Dynamic View Objects Programmatically | Lab | Tutorial | ViewObjectImpl methods, dynamic queries, adding to AM, use cases |
| B102-8.3 | Adding Attributes to View Objects Programmatically | Lab | Examples | AttributeDef creation, data types, calculated & transient attributes |
| B102-8.4 | Executing SQL Statements | Lab | Tutorial | Using JDBC in OAF, PreparedStatement, handling result sets, connections |
| B102-8.5 | Calling PL/SQL Functions and Procedures | Lab | Examples | CallableStatement usage, IN/OUT parameters, function returns, error handling |
| B102-8.6 | Applying Server-Side Best Practices | Video | Patterns | PL/SQL vs Java, performance considerations, transaction management |

## [9] Layout and Container Regions

**Module:** B102-9 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-9.1 | Implementing Hide/Show Region | Lab | Tutorial | Conditional rendering, PPR for dynamic display, UX considerations |
| B102-9.2 | Implementing Flow Layout Region | Lab | Examples | Flow vs other layouts, component arrangement, responsive design |
| B102-9.3 | Implementing Advanced Layout Region | Lab | Patterns | Table/Row/Cell layouts, nested layouts, complex forms |
| B102-9.4 | Implementing Content Container Region | Lab | Examples | Tab-based navigation, hiding/showing tabs, dynamic tab generation; richContainer |
| B102-9.5 | Implementing Panel Splitter and Layered Layout | Lab | Tutorial | panelSplitter, layeredLayout, adjustable panels, multi-mode pages |
| B102-9.6 | Building Custom Grids with tableLayout and cellFormat | Lab | Tutorial | Explicit rows and cells, columnSpan, rowSpan, hAlign, vAlign, width and height |
| B102-9.7 | Practicing Panel Splitter and Layered Layouts | Lab | Tutorial | panelSplitter and layeredLayout with adjustable panels and multi-mode pages |

## [10] Data Regions, Grids and Charts

**Module:** B102-10 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-10.1 | Implementing Query Region (Advanced) | Lab | Guide | Construction modes, results-based search, auto-customization, configuration |
| B102-10.2 | Implementing HGrid Region | Lab | Tutorial | Hierarchical data, expandable nodes, tree navigation, performance; tree, nodeDef and childNode definitions |
| B102-10.3 | Implementing Charts and Graphs | Lab | Tutorial | Chart types, data binding, interactive charts, BI Publisher integration |
| B102-10.4 | Implementing Bulleted Lists | Lab | Tutorial | bulletedList, multi-column lists, dynamic list content |
| B102-10.5 | Implementing Auto-Repeating Layouts | Lab | Tutorial | Repeating regions generated from view object rows, dynamic sections, per-row content |
| B102-10.6 | Practicing Auto-Repeating Layouts | Lab | Tutorial | Auto-repeating regions generated from view object rows |
| B102-10.7 | Building Bulleted Lists from View Rows | Lab | Tutorial | bulletedList with up to three columns bound to view rows |

## [11] Wizards, Rich Inputs and Configurable Pages

**Module:** B102-11 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-11.1 | Implementing Train Region | Lab | Examples | Multi-step processes, train stops, navigation, validation, progress tracking |
| B102-11.2 | Implementing Shuttle Region | Lab | Tutorial | Dual-list selection, moving items, ordering, search functionality |
| B102-11.3 | Implementing Multi-Step Create and Update Flows | Lab | Project | Train-based wizards, transaction state across steps, iterative versus single-submit updates |
| B102-11.4 | Implementing Rich Text Editor, Color Picker and Rating Bar | Lab | Tutorial | richTextEditor, messageRichTextEditor, colorPicker, messageRatingBar |
| B102-11.5 | Building Configurable Pages with flexibleLayout | Lab | Project | flexibleLayout, flexibleContent, flexibleContentList, user and admin dashboard tiles |
| B102-11.6 | Practicing Configurable Pages with flexibleContent | Lab | Project | flexibleLayout, flexibleContent and flexibleContentList tiles for users and administrators |
| B102-11.7 | Practicing Rich Inputs in Forms | Lab | Tutorial | Rich text editor, color picker and rating bar bound to a form |

## [12] Flexfields, SPEL and Forms Integration

**Module:** B102-12 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-12.1 | Implementing Key Flexfield Region | Lab | Tutorial | KFF configuration, binding to page, validation, capturing values |
| B102-12.2 | Implementing Descriptive Flexfield Region | Lab | Tutorial | DFF configuration, context-sensitive DFF, EO integration, querying |
| B102-12.3 | Changing Item Properties Using SPEL | Lab | Examples | SPEL syntax, conditional properties, dynamic rendering, performance |
| B102-12.4 | Adding Custom HTML Code | Lab | Guide | RawText component, JavaScript integration, security, best practices |
| B102-12.5 | Launching Oracle Forms from OAF | Lab | Tutorial | Form function call, parameter passing, integration patterns |
| B102-12.6 | Launching OAF Pages from Oracle Forms | Lab | Guide | ICX integration, URL construction, SSO considerations |
| B102-12.7 | Mapping Flexfield Segments with flexMap | Lab | Tutorial | flex and flexMap regions for DFF and KFF, mapping segments to page items |

## [13] Client-Side Scripting and Page Modes

**Module:** B102-13 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-13.1 | Using JavaScript in OAF | Lab | Guide | Client-side validation, UI enhancements, calling Java, security |
| B102-13.2 | Implementing Read-Only Page | Lab | Tutorial | Disabling inputs, visual indicators, conditional read-only mode |

## [14] Data Formatting and Validation

**Module:** B102-14 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-14.1 | Manipulating and Formatting Dates | Lab | Tutorial | Date comparisons, Oracle date formats, timezone handling, calculations |
| B102-14.2 | Formatting Numbers | Lab | Examples | Number formats, currency display, locale considerations, decimal precision |
| B102-14.3 | Implementing Data Validations | Lab | Guide | Field-level validation, cross-field validation, business rule validation |
| B102-14.4 | Implementing Validation Using Entity Expert | Lab | Tutorial | Entity Expert pattern, reusable validation, complex business rules, messages |
| B102-14.5 | Implementing Entity Expert Validation Rules | Lab | Tutorial | Entity expert, shared validation rules and error messages across pages |

## [15] Configuration and Defaults

**Module:** B102-15 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-15.1 | Setting Default Values | Lab | Tutorial | Text fields, number fields, date fields, techniques and best practices |
| B102-15.2 | Understanding MDS Repository | Video | Guide | How page metadata is stored and queried, from a developer view; MDS architecture and administration are covered in Cust 101 |
| B102-15.3 | Configuring Important Profile Options | Video | Reference | Key profile options, impact on behavior, setting programmatically |

## [16] Files, Documents and Data Exchange

**Module:** B102-16 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-16.1 | Implementing Attachments Functionality | Lab | Tutorial | FND_ATTACHED_DOCUMENTS, configuration, UI integration, file storage; attachmentTable, attachmentLink, attachmentImage, messageInlineAttachment, entityMap, categoryMap, primaryKey |
| B102-16.2 | Implementing Upload Files Functionality | Lab | Tutorial | File upload component, server-side handling, validation, storage options; messageFileUpload |
| B102-16.3 | Implementing Import Data Functionality | Lab | Examples | CSV/Excel import, data validation, batch processing, error handling |
| B102-16.4 | Implementing Export Data Functionality | Lab | Tutorial | Export formats (CSV, Excel, PDF), large data sets, streaming, performance |
| B102-16.5 | Publishing Documents to the Document Catalog | Lab | Guide | Document set upload, catalog publishing, AntiSamy filtering and virus scanning on upload |
| B102-16.6 | Displaying PDFs Inline and Downloading Files Securely | Lab | Tutorial | Rendering PDFs inline, streaming binary files, secure download handling; messageDownload |

## [17] Navigation, Workflow and Background Processing

**Module:** B102-17 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-17.1 | Handling Browser Back Button | Lab | Guide | Back button issues, prevention techniques, transaction integrity |
| B102-17.2 | Building Workflow-Enabled OAF Applications | Lab | Tutorial | Launching workflow, passing parameters, monitoring, embedding OAF in notification |
| B102-17.3 | Implementing Deep Links and Bookmarkable URLs | Lab | Guide | RF.jsp, OA.jsp and OAD.jsp URLs, passing parameters, security of direct page access |
| B102-17.4 | Submitting Concurrent Requests from OAF Pages | Lab | Tutorial | Declarative request submission, monitoring requests, passing parameters |
| B102-17.5 | Implementing Deep Links with Parameters | Lab | Tutorial | RF.jsp and OA.jsp deep links, passing parameters, securing direct access |

## [18] Internationalization, Accessibility and Usability

**Module:** B102-18 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-18.1 | Supporting Multiple Languages and Internationalization | Lab | Guide | MLS and _TL tables, timezone conversion, client character encoding, right-to-left alignment |
| B102-18.2 | Implementing Screen Reader Mode, Row Headers and Hot Keys | Lab | Checklist | Screen reader optimized mode, rowheadercol, keyboard accelerator keys |
| B102-18.3 | Warning on Unsaved Changes with the Enhanced Save Model | Lab | Tutorial | Detecting uncommitted changes, warning before navigating away, save and discard flows |
| B102-18.4 | Handling Right-to-Left Layouts and Timezones | Lab | Guide | Right-to-left alignment, timezone conversion, client character encoding |
| B102-18.5 | Testing Screen Reader and Hot Key Support | Lab | Checklist | Screen reader mode, row headers, accelerator hot keys tested on a page |
| B102-18.6 | Practicing the Enhanced Save Model | Lab | Tutorial | Save model warnings on unsaved changes, save and discard flows |
| B102-18.7 | Auditing Accessibility Compliance of a Page | Lab | Checklist | Accessibility audit of labels, row headers, keyboard access and contrast |

## [19] Advanced Debugging

**Module:** B102-19 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-19.1 | Using demasy-oaf Libraries for Debugging | Lab | Tutorial | Library overview, installation, debug utilities, performance profiling |
| B102-19.2 | Applying Advanced Debugging Techniques | Lab | Guide | Remote debugging, production debugging, log analysis, performance profiling |
| B102-19.3 | Using the About This Page and OAInfo.jsp Diagnostics | Lab | Guide | Page inspector, OAInfo.jsp, technology stack and profile option inspection, regionMap.xml |
| B102-19.4 | Diagnosing Pages with OAInfo.jsp | Lab | Guide | OAInfo.jsp, technology stack, profile options and page diagnosis |

## [20] Projects and Final Assessment

**Module:** B102-20 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B102-20.1 | Kicking Off and Planning Project 101 | Workshop | Guide | Setting up project structure, Git version control, database design, project planning, team collaboration setup; applied to Project 102 (the POS system is the Dev 103 capstone) (Duration: 2.5 Days) |
| B102-20.2 | Building Project 102: Items with an Approval Cycle | Lab | Project | Multi-step approval workflow, complex business logic, workflow integration, advanced UI features, item creation form, multi-level approvals, email notifications, approval history, advanced search and reporting (Duration: 5 Days) |
| B102-20.3 | Selecting the Final Assessment Project | Workshop | Guide | Comprehensive project requirements, choosing between Option A (Advanced HR Management System) or Option B (Procurement Request System), planning and timeline |
| B102-20.4 | Building the Advanced HR Management System (Option A) | Lab | Project | Employee self-service portal, manager approval workflows, workflow integration, reports and dashboards, complete HRIS functionality |
| B102-20.5 | Building the Procurement Request System (Option B) | Lab | Project | Purchase requisition creation, multi-level approval process, budget validation logic, PO integration, procurement workflow |
| B102-20.6 | Applying the Assessment Criteria and Deliverables | Workshop | Rubric | All Level 102 concepts (40%), Code quality and standards (25%), Architecture and design (20%), Documentation (10%), Innovation and extras (5%) |
