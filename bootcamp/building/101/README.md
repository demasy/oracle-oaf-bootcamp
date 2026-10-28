# Oracle OAF Building BootCamp 101

**Code:** DL-OAF-B-101 | **Level:** Beginner | **Duration:** 28-32 days | **Scaffolding:** 60% guidance | **Certification milestone:** Associate OAF Developer

## Course Goals

- Set up and configure OAF development environment
- Create basic OAF pages using Model-View-Controller pattern
- Implement standard web widgets and UI components
- Build CRUD (Create, Read, Update, Delete) functionality
- Deploy OAF applications to Oracle E-Business Suite
- Debug and test basic OAF applications
- Complete the Jobs & Positions master-detail application and deploy it to a training instance

## Curriculum

| Section | Module | Title | Path | Lectures |
| :-: | :-- | :-- | :-: | :-: |
| [1] | B101-1 | [BootCamp Orientation and Success Path](#1-bootcamp-orientation-and-success-path) | Extended | 4 |
| [2] | B101-2 | [OAF Architecture and MVC Paradigms](#2-oaf-architecture-and-mvc-paradigms) | Core | 7 |
| [3] | B101-3 | [IDE Setup and Project Topology](#3-ide-setup-and-project-topology) | Core | 10 |
| [4] | B101-4 | [Application Module Construction](#4-application-module-construction) | Core | 5 |
| [5] | B101-5 | [View Object Development](#5-view-object-development) | Core | 5 |
| [6] | B101-6 | [Entity Object and DML Layer](#6-entity-object-and-dml-layer) | Core | 3 |
| [7] | B101-7 | [Declarative Page Layouts](#7-declarative-page-layouts) | Core | 14 |
| [8] | B101-8 | [Controller Request Processing](#8-controller-request-processing) | Core | 7 |
| [9] | B101-9 | [Master-Detail Relationships](#9-master-detail-relationships) | Required | 2 |
| [10] | B101-10 | [JDeveloper Debugging](#10-jdeveloper-debugging) | Required | 2 |
| [11] | B101-11 | [Security Implementation](#11-security-implementation) | Extended | 4 |
| [12] | B101-12 | [Development Standards and Best Practices](#12-development-standards-and-best-practices) | Extended | 7 |
| [13] | B101-13 | [OAF Application Deployment](#13-oaf-application-deployment) | Required | 4 |
| [14] | B101-14 | [Jobs and Positions Management Capstone](#14-jobs-and-positions-management-capstone) | Required | 6 |

## [1] BootCamp Orientation and Success Path

**Module:** B101-1 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-1.1 | Introducing the OAF BootCamp | Video | PDF | Transformation roadmap, success stories, instructor intro |
| B101-1.2 | Understanding the BootCamp Structure and Learning Framework | Video | PDF | Three-level progression, scaffolding approach, assessment |
| B101-1.3 | Joining the Learning Community | Video | Guide | Study groups, code review, forums, peer learning |
| B101-1.4 | Setting Goals and Success Strategies | Workshop | Template | SMART goals, time management, growth mindset |

## [2] OAF Architecture and MVC Paradigms

**Module:** B101-2 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-2.1 | Learning OAF Terminology | Video | Glossary | Vocabulary, naming conventions, EBS context |
| B101-2.2 | Tracing the Evolution from Oracle Forms to OAF | Video | Comparison Chart | Technology shift, migration strategies, use cases |
| B101-2.3 | Choosing When and Why to Use OAF | Video | Decision Matrix | Advantages, limitations, business case |
| B101-2.4 | Integrating OAF with E-Business Suite | Video | Whitepaper | Evolution, Oracle's direction, EBS integration |
| B101-2.5 | Separating Model, View and Controller in OAF | Video | Diagram | Model-View-Controller, separation of concerns |
| B101-2.6 | Understanding BC4J and UIX Architecture | Video | Architecture Guide | BC4J, UIX, lifecycle, metadata repository |
| B101-2.7 | Examining OAF Page Anatomy | Video | Reference Poster | AM, VO, EO, Pages, Regions, Controllers |

## [3] IDE Setup and Project Topology

**Module:** B101-3 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-3.1 | Navigating the JDeveloper IDE | Video | Quick Ref | IDE layout, panels, workspace organization |
| B101-3.2 | Downloading OA Extension from Oracle Support | Video | Guide | MOS portal, version matrix, download process |
| B101-3.3 | Configuring the Development Environment | Video | Checklist | Installation, OA Extension, configuration, DBC; directories (jdevbin, jdevhome, jdevdoc), JDEV_USER_HOME and JDEV_JAVA_HOME |
| B101-3.4 | Using JDeveloper Tools and Shortcuts | Video | Shortcut Card | Interface customization, shortcuts, templates |
| B101-3.5 | Using the Structure Pane, Property Inspector and UML Modeler | Lab | Guide | Hierarchy navigation, property sheets, UML modeling of business components, local debugging tools |
| B101-3.6 | Configuring DBC Files and Database Connections | Video | Troubleshoot Guide | DBC setup, connection parameters, validation |
| B101-3.7 | Establishing Database Connectivity | Video | Connection Guide | Connection setup, pooling, multi-environment; setup verification with test_fwktutorial.jsp |
| B101-3.8 | Registering Application Short Names and Responsibility Keys | Lab | Guide | Application short name, responsibility key, FWK_TBX_TUTORIAL setup for local testing |
| B101-3.9 | Building the First Hello World OAF Page | Lab | Step-by-step | First page, AM, layout, components, run |
| B101-3.10 | Organizing Workspaces and Version Control in JDeveloper | Video | Template | Workspace organization, naming, version control |

## [4] Application Module Construction

**Module:** B101-4 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-4.1 | Managing Business Data with BC4J | Video | Overview | Understanding BC4J, MVC role, component ecosystem |
| B101-4.2 | Designing Application Modules | Video | Design Guide | AM structure, transactions, pooling, patterns |
| B101-4.3 | Building and Testing an Application Module | Lab | Wizard Guide | Step-by-step creation, testing, debugging |
| B101-4.4 | Accessing OADBTransaction from the Application Module | Lab | Guide | Database connection access, transaction commit/rollback, server-side utilities |
| B101-4.5 | Managing Transactions and Connection Pooling | Video | Best Practices | Connection pooling, commits, locking, tuning |

## [5] View Object Development

**Module:** B101-5 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-5.1 | Choosing Between Read-Only and Updatable View Objects | Video | VO Guide | SQL queries, read-only vs updatable, performance |
| B101-5.2 | Building Updatable View Objects for CRUD | Lab | Tutorial | VO-EO linking, attribute mapping, CRUD testing |
| B101-5.3 | Implementing Read-Only View Objects with SQL | Lab | Tutorial | SQL-based VOs, expert mode, joins, optimization |
| B101-5.4 | Configuring Bind Variables and View Criteria | Lab | Tutorial | Named bind variables, view criteria, dynamic WHERE clauses, preventing SQL injection |
| B101-5.5 | Linking View Objects with View Links and Associations | Video | Reference | Master-detail, FK relationships, domains |

## [6] Entity Object and DML Layer

**Module:** B101-6 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-6.1 | Understanding Entity Object Fundamentals | Video | EO Reference | Table mapping, validation, DML, associations |
| B101-6.2 | Creating Entity Objects from Tables | Lab | Tutorial | Wizard creation, attributes, validation rules |
| B101-6.3 | Defining Primary Keys and Attribute Validation | Lab | Tutorial | Primary key identification, attribute-level validation routines, entity-level validation |

## [7] Declarative Page Layouts

**Module:** B101-7 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-7.1 | Composing Pages from UIX Components | Video | UIX Guide | Framework basics, component hierarchy, metadata |
| B101-7.2 | Structuring UI Components in the Workspace | Video | Structure Guide | Workspace organization, naming, packages, reusable |
| B101-7.3 | Building Pages and Regions | Video | Layout Guide | Page structure, region types, hierarchy, containers |
| B101-7.4 | Creating and Reusing Shared Regions, Pages and Items | Lab | Tutorial | Shared regions, shared pages, shared items, reuse across page contexts, sharing logistics |
| B101-7.5 | Configuring Standard Web Widgets and Their Properties | Lab | Widget Reference | All standard UI widgets and their properties |
| B101-7.6 | Designing Page Layouts and Advanced Regions | Lab | Layout Patterns | Layouts, headers, buttons, query regions |
| B101-7.7 | Building Forms with messageComponentLayout | Lab | Widget Reference | messageComponentLayout columns and rows, stack layouts; default* form layouts are deprecated in 12.2; messageLayout for non-message beans, labeledFieldLayout |
| B101-7.8 | Applying Look-and-Feel Standards | Video | Style Guide | Oracle look-and-feel standards, BLAF guidelines, Redwood look and feel, choosing and applying a look and feel *(verify)* |
| B101-7.9 | Using Poplists, Radio Groups, Checkboxes and Spin Boxes | Lab | Widget Reference | messageChoice, messageLovChoice, messageRadioGroup, messageCheckBox, messageSpinBox, default values; messageRadioButton |
| B101-7.10 | Using Buttons, Page Button Bars and Content Footers | Lab | Widget Reference | button, submitButton, resetButton, selectionButton, exportButton, link, pageButtonBar, contentFooter; page footer (copyright and privacy links); contentFooter is deprecated; link variants (GET/POST, external URL, mailto, JavaScript) |
| B101-7.11 | Adding Images, Spacers, Separators, Tips and Static Text | Lab | Widget Reference | image, spacer, separator, tip, instructionText, styledText, formattedText; messageStyledText, staticStyledText, rawText, dynamic images from BLOB columns |
| B101-7.12 | Passing Form Parameters and Form Values | Lab | Guide | formParameter, formValue, servletInclude, urlInclude; passing hidden values |
| B101-7.13 | Applying CSS Styling and Reusable Attribute Sets | Video | Style Guide | CSS styling, attribute sets, theming |
| B101-7.14 | Implementing Navigation with Breadcrumbs and Menus | Video | Nav Guide | Breadcrumb configuration, menu integration; locator element |

## [8] Controller Request Processing

**Module:** B101-8 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-8.1 | Understanding Controller Architecture and User Actions | Video | CO Guide | MVC role, lifecycle, structure, best practices |
| B101-8.2 | Handling GET Requests and Page Initialization | Video | Pattern Library | processRequest(), initialization, default values |
| B101-8.3 | Using the Controller API: pageContext and WebBeans | Video | API Reference | pageContext, attributes, WebBeans, transactions |
| B101-8.4 | Comparing Parameter Passing Strategies | Video | Decision Tree | Request, Transaction, Session scopes comparison |
| B101-8.5 | Using Request Parameters for Single-Page Scope | Lab | Tutorial | Token-based, navigation, lifecycle, examples |
| B101-8.6 | Managing Transaction Parameters Across Pages | Lab | Tutorial | Multi-page flow, retention, cleanup |
| B101-8.7 | Implementing Session Parameters for User State | Lab | Tutorial | Session scope, persistence, memory, best practices |

## [9] Master-Detail Relationships

**Module:** B101-9 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-9.1 | Understanding Master-Detail with View Links | Video | Guide | Parent-child relationships, View Links, use cases |
| B101-9.2 | Implementing Master-Detail User Interfaces | Lab | Tutorial | Region configuration, synchronization, cascading |

## [10] JDeveloper Debugging

**Module:** B101-10 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-10.1 | Using Console and Logging Debugging Tools | Video | Debug Guide | Console output, log files, diagnostic logging |
| B101-10.2 | Debugging with the JDeveloper Debugger | Lab | Debug Tutorial | Breakpoints, step-through, variables, remote |

## [11] Security Implementation

**Module:** B101-11 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-11.1 | Distinguishing Authentication from Authorization in OAF | Video | Security Guide | Authentication, authorization, function security |
| B101-11.2 | Implementing Function Security for Page Access | Lab | Tutorial | Function registration, menu setup, responsibilities |
| B101-11.3 | Applying Data Security for Row-Level Protection | Video | Best Practices | Multi-Org, row-level security, VPD, filtering |
| B101-11.4 | Understanding Built-In Protection Against HTML Tampering | Video | Guide | Automatic guards against HTML tampering and common hacking vectors, what the framework protects by default |

## [12] Development Standards and Best Practices

**Module:** B101-12 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-12.1 | Understanding Why Development Standards Matter | Video | Guide | Maintainability, team collaboration, Oracle support, upgrades |
| B101-12.2 | Following OAF Coding Standards and Terminology | Video | Standards Doc | Naming conventions, package structure, comments, organization |
| B101-12.3 | Comparing Oracle, Project and Industry Standards | Video | Comparison | Oracle standards, project-specific, industry best practices |
| B101-12.4 | Organizing Files and Packages in OAF Projects | Video | Reference | File types (.xml, .java, .class), package naming, MDS structure |
| B101-12.5 | Understanding the OAF Directory Structure | Video | Diagram | $JAVA_TOP structure, workspace organization, resource files |
| B101-12.6 | Using Import and Export Utilities for Code Management | Lab | Tutorial | Code extraction from database, importing to JDeveloper, version control; JDeveloper-level only, command-line importers are covered in Dev 103 |
| B101-12.7 | Designing Common Page Patterns and Use Cases | Video | Patterns | Search pages, Create/Update pages, Detail/drill-down, List pages |

## [13] OAF Application Deployment

**Module:** B101-13 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-13.1 | Following the OAF Deployment Steps from Build to Bounce | Video | Checklist | Compilation, packaging, file transfer, import to MDS, bounce Apache |
| B101-13.2 | Deploying an OAF Application on R12.1.x | Lab | Tutorial | Step-by-step deployment, file locations, import commands, verification |
| B101-13.3 | Deploying an OAF Application on R12.2.x | Lab | Tutorial | Deployment differences on R12.2 for a training instance; the dual file system, adop and online patching are covered in Dev 103 |
| B101-13.4 | Completing Post-Deployment Configuration | Lab | Guide | Function registration, menu setup, responsibility assignment, testing |

## [14] Jobs and Positions Management Capstone

**Module:** B101-14 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-14.1 | Creating Database Objects and Entities | Lab | Scripts | Tables, sequences, entity objects, WHO columns |
| B101-14.2 | Building View Objects and the Application Module | Lab | Project | Job and position VOs, view link, root AM |
| B101-14.3 | Building Job Search and Job Details Pages | Lab | Project | Search page, create/update page, controllers |
| B101-14.4 | Implementing Position Maintenance (Master-Detail) | Lab | Project | Detail table, add/delete rows, validation |
| B101-14.5 | Testing the Application and Deploying It to EBS | Lab | Checklist | Test plan, deployment to EBS, reflection |
| B101-14.6 | Assessing the Capstone Against the 100-Point Rubric | Workshop | Rubric | 100 points: functionality 40, code quality 30, UI 20, documentation 10 |
