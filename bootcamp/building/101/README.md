# Oracle OAF Building BootCamp 101

**Code:** DL-OAF-B-101 | **Level:** Beginner | **Duration:** 28-32 days | **Scaffolding:** 60% guidance | **Certification milestone:** Associate OAF Developer

**Path:** Core is the required reference path; Required is content the exit depends on; Extended is optional depth.  
**Entry:** Basic Java, SQL, PL/SQL and HTML. No OAF experience needed.  
**Exit:** Learner builds a master-detail CRUD application on BC4J, runs it locally and deploys it to a training instance.  
**Assessment:** Jobs & Positions capstone, graded out of 100: functionality 40, code quality 30, UI 20, documentation 10.

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
| [1] | B101-001 | [BootCamp Orientation and Success Path](#1-bootcamp-orientation-and-success-path) | Extended | 4 |
| [2] | B101-002 | [OAF Architecture and MVC Paradigms](#2-oaf-architecture-and-mvc-paradigms) | Core | 9 |
| [3] | B101-003 | [IDE Setup and Project Topology](#3-ide-setup-and-project-topology) | Core | 10 |
| [4] | B101-004 | [Application Module Construction](#4-application-module-construction) | Core | 5 |
| [5] | B101-005 | [View Object Development](#5-view-object-development) | Core | 5 |
| [6] | B101-006 | [Entity Object and DML Layer](#6-entity-object-and-dml-layer) | Core | 3 |
| [7] | B101-007 | [Declarative Page Layouts](#7-declarative-page-layouts) | Core | 14 |
| [8] | B101-008 | [Reusable UI Components](#8-reusable-ui-components) | Extended | 5 |
| [9] | B101-009 | [Controller Request Processing](#9-controller-request-processing) | Core | 7 |
| [10] | B101-010 | [Master-Detail Relationships](#10-master-detail-relationships) | Required | 2 |
| [11] | B101-011 | [JDeveloper Debugging](#11-jdeveloper-debugging) | Required | 2 |
| [12] | B101-012 | [Security Implementation](#12-security-implementation) | Extended | 5 |
| [13] | B101-013 | [Development Standards and Best Practices](#13-development-standards-and-best-practices) | Extended | 7 |
| [14] | B101-014 | [OAF Application Deployment](#14-oaf-application-deployment) | Required | 4 |
| [15] | B101-015 | [Jobs and Positions Management Capstone](#15-jobs-and-positions-management-capstone) | Required | 6 |

## [1] BootCamp Orientation and Success Path

**Module:** B101-001 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-001.001 | Introducing the OAF BootCamp | Video | Guide | Transformation roadmap, success stories, instructor intro |
| B101-001.002 | Understanding the BootCamp Structure and Learning Model | Video | Guide | Three-level progression, scaffolding approach, assessment |
| B101-001.003 | Joining the Learning Community | Video | Guide | Study groups, code review, forums, peer learning |
| B101-001.004 | Setting Goals and Success Strategies | Workshop | Template | SMART goals, time management, growth mindset |

## [2] OAF Architecture and MVC Paradigms

**Module:** B101-002 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-002.001 | Learning OAF Terminology | Video | Reference | Vocabulary, naming conventions, EBS context |
| B101-002.002 | Tracing the Evolution from Oracle Forms to OAF | Video | Diagram | Technology shift, migration strategies, use cases |
| B101-002.003 | Choosing When and Why to Use OAF | Video | Diagram | Advantages, limitations, business case |
| B101-002.004 | Integrating OAF with E-Business Suite | Video | Guide | Evolution, Oracle's direction, EBS integration |
| B101-002.005 | Separating Model, View and Controller in OAF | Video | Diagram | Model-View-Controller, separation of concerns |
| B101-002.006 | Understanding BC4J and UIX Architecture | Video | Guide | BC4J, UIX, lifecycle, metadata repository |
| B101-002.007 | Examining OAF Page Anatomy | Video | Reference | AM, VO, EO, Pages, Regions, Controllers |
| B101-002.008 | Understanding the Layered Application Architecture | Video | Diagram | Layered application architecture: database, entity object, view object and AM, shared region and page layers |
| B101-002.009 | Mapping the Database Layer to Base and TL Tables | Video | Reference | Database layer: _B and _TL tables, sequences, packages and WHO columns |

## [3] IDE Setup and Project Topology

**Module:** B101-003 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-003.001 | Navigating the JDeveloper IDE | Video | Reference | IDE layout, panels, workspace organization |
| B101-003.002 | Downloading OA Extension from Oracle Support | Video | Guide | MOS portal, version matrix, download process |
| B101-003.003 | Configuring the Development Environment | Video | Checklist | Installation, OA Extension, configuration, DBC; directories (jdevbin, jdevhome, jdevdoc), JDEV_USER_HOME and JDEV_JAVA_HOME |
| B101-003.004 | Using JDeveloper Tools and Shortcuts | Video | Reference | Interface customization, shortcuts, templates |
| B101-003.005 | Using the Structure Pane, Inspector and UML Modeler | Lab | Guide | Hierarchy navigation, property sheets, UML modeling of business components, local debugging tools |
| B101-003.006 | Configuring DBC Files and Database Connections | Video | Guide | DBC setup, connection parameters, validation |
| B101-003.007 | Establishing Database Connectivity | Video | Guide | Connection setup, pooling, multi-environment; setup verification with test_fwktutorial.jsp |
| B101-003.008 | Registering Short Names and Responsibility Keys | Lab | Guide | Application short name, responsibility key, FWK_TBX_TUTORIAL setup for local testing |
| B101-003.009 | Building the First Hello World OAF Page | Lab | Tutorial | First page, AM, layout, components, run |
| B101-003.010 | Organizing Workspaces and Version Control in JDeveloper | Video | Template | Workspace organization, naming, version control |

## [4] Application Module Construction

**Module:** B101-004 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-004.001 | Managing Business Data with BC4J | Video | Guide | Understanding BC4J, MVC role, component ecosystem |
| B101-004.002 | Designing Application Modules | Video | Guide | AM structure, transactions, pooling, patterns |
| B101-004.003 | Building and Testing an Application Module | Lab | Guide | Step-by-step creation, testing, debugging |
| B101-004.004 | Accessing OADBTransaction from the Application Module | Lab | Guide | Database connection access, transaction commit/rollback, server-side utilities |
| B101-004.005 | Managing Transactions and Connection Pooling | Video | Patterns | Connection pooling, commits, locking, tuning |

## [5] View Object Development

**Module:** B101-005 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-005.001 | Choosing Between Read-Only and Updatable View Objects | Video | Guide | SQL queries, read-only vs updatable, performance |
| B101-005.002 | Building Updatable View Objects for CRUD | Lab | Tutorial | VO-EO linking, attribute mapping, CRUD testing |
| B101-005.003 | Building Read-Only View Objects with SQL | Lab | Tutorial | SQL-based VOs, expert mode, joins, optimization |
| B101-005.004 | Configuring Bind Variables and View Criteria | Lab | Tutorial | Named bind variables, view criteria, dynamic WHERE clauses, search pages, preventing SQL injection |
| B101-005.005 | Linking View Objects with View Links and Associations | Video | Reference | Master-detail, FK relationships, domains, entity associations (composite and non-composite) |

## [6] Entity Object and DML Layer

**Module:** B101-006 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-006.001 | Understanding Entity Object Fundamentals | Video | Reference | Table mapping, validation, DML, associations |
| B101-006.002 | Creating Entity Objects from Tables | Lab | Tutorial | Wizard creation, attributes, validation rules |
| B101-006.003 | Defining Primary Keys and Attribute Validation | Lab | Tutorial | Primary key identification, attribute-level validation routines, entity-level validation |

## [7] Declarative Page Layouts

**Module:** B101-007 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-007.001 | Composing Pages from UIX Components | Video | Guide | Framework basics, component hierarchy, metadata |
| B101-007.002 | Structuring UI Components in the Workspace | Video | Guide | Workspace organization, naming, packages, reusable |
| B101-007.003 | Building Pages and Regions | Video | Guide | Page structure, region types, hierarchy, containers |
| B101-007.004 | Creating and Reusing Shared Regions, Pages and Items | Lab | Tutorial | Shared regions, shared pages, shared items, reuse across page contexts, sharing logistics |
| B101-007.005 | Configuring Standard Web Widgets and Their Properties | Lab | Reference | All standard UI widgets and their properties |
| B101-007.006 | Designing Page Layouts and Advanced Regions | Lab | Patterns | Layouts, headers, buttons, query regions |
| B101-007.007 | Building Forms with messageComponentLayout | Lab | Reference | messageComponentLayout columns and rows, stack layouts; default* form layouts are deprecated in 12.2; messageLayout for non-message beans, labeledFieldLayout |
| B101-007.008 | Applying Look-and-Feel Standards | Video | Guide | Oracle look-and-feel standards, BLAF guidelines, Redwood look and feel, choosing and applying a look and feel *(verify)* |
| B101-007.009 | Using Poplists, Radio Groups, Checkboxes and Spin Boxes | Lab | Reference | messageChoice, messageLovChoice, messageRadioGroup, messageCheckBox, messageSpinBox, default values; messageRadioButton |
| B101-007.010 | Using Buttons, Page Button Bars and Content Footers | Lab | Reference | button, submitButton, resetButton, selectionButton, exportButton, link, pageButtonBar, contentFooter; page footer (copyright and privacy links); contentFooter is deprecated; link variants (GET/POST, external URL, mailto, JavaScript) |
| B101-007.011 | Adding Images, Spacers, Separators and Static Text | Lab | Reference | image, spacer, separator, tip, instructionText, styledText, formattedText; messageStyledText, staticStyledText, rawText, dynamic images from BLOB columns |
| B101-007.012 | Passing Form Parameters and Form Values | Lab | Guide | formParameter, formValue, servletInclude, urlInclude; passing hidden values |
| B101-007.013 | Applying CSS Styling and Reusable Attribute Sets | Video | Guide | CSS styling, attribute sets, theming |
| B101-007.014 | Implementing Navigation with Breadcrumbs and Menus | Video | Guide | Breadcrumb configuration, menu integration; locator element |

## [8] Reusable UI Components

**Module:** B101-008 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-008.001 | Building Smart Poplists with LOV Choice Lists | Lab | Tutorial | Smart poplist, messageLovChoice, combining a searchable LOV with a customizable poplist |
| B101-008.002 | Spacing Layouts with Spacers, Separators and Images | Lab | Tutorial | Spacers, separators and images placed in forms and regions |
| B101-008.003 | Passing Form Parameters Between Pages | Lab | Tutorial | formParameter, formValue and servletInclude in a multi-page flow |
| B101-008.004 | Applying a Look and Feel to a Page | Lab | Guide | Look-and-feel standards applied to a finished page, BLAF checks |
| B101-008.005 | Adding Page Button Bars to Forms | Lab | Tutorial | pageButtonBar with Save, Apply and Cancel actions and submit handling |

## [9] Controller Request Processing

**Module:** B101-009 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-009.001 | Understanding Controller Architecture and User Actions | Video | Guide | MVC role, lifecycle, structure, best practices |
| B101-009.002 | Handling GET Requests and Page Initialization | Video | Patterns | processRequest(), initialization, default values |
| B101-009.003 | Using the Controller API for pageContext and WebBeans | Video | Reference | pageContext, attributes, WebBeans, transactions |
| B101-009.004 | Comparing Parameter Passing Strategies | Video | Diagram | Request, Transaction, Session scopes comparison |
| B101-009.005 | Using Request Parameters for Single-Page Scope | Lab | Tutorial | Token-based, navigation, lifecycle, examples |
| B101-009.006 | Managing Transaction Parameters Across Pages | Lab | Tutorial | Multi-page flow, retention, cleanup |
| B101-009.007 | Storing User State in Session Parameters | Lab | Tutorial | Session scope, persistence, memory, best practices |

## [10] Master-Detail Relationships

**Module:** B101-010 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-010.001 | Understanding Master-Detail with View Links | Video | Guide | Parent-child relationships, View Links, use cases |
| B101-010.002 | Implementing Master-Detail User Interfaces | Lab | Tutorial | Region configuration, synchronization, cascading |

## [11] JDeveloper Debugging

**Module:** B101-011 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-011.001 | Using Console and Logging Debugging Tools | Video | Guide | Console output, log files, diagnostic logging |
| B101-011.002 | Debugging with the JDeveloper Debugger | Lab | Tutorial | Breakpoints, step-through, variables, remote |

## [12] Security Implementation

**Module:** B101-012 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-012.001 | Distinguishing Authentication from Authorization in OAF | Video | Guide | Authentication, authorization, function security, EBS login flow and session timeouts |
| B101-012.002 | Implementing Function Security for Page Access | Lab | Tutorial | Function registration, menu setup, responsibilities |
| B101-012.003 | Applying Data Security for Row-Level Protection | Video | Patterns | Multi-Org, row-level security, VPD, filtering, data security grants on a search page |
| B101-012.004 | Understanding Built-In HTML Tampering Protection | Video | Guide | Automatic guards against HTML tampering and common hacking vectors, what the framework protects by default |
| B101-012.005 | Testing Protection Against HTML Tampering | Lab | Checklist | Tampering attempts on hidden fields and URLs, verifying HTML tampering protection |

## [13] Development Standards and Best Practices

**Module:** B101-013 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-013.001 | Understanding Why Development Standards Matter | Video | Guide | Maintainability, team collaboration, Oracle support, upgrades |
| B101-013.002 | Following OAF Coding Standards and Terminology | Video | Guide | Naming conventions, package structure, comments, organization |
| B101-013.003 | Comparing Oracle, Project and Industry Standards | Video | Diagram | Oracle standards, project-specific, industry best practices |
| B101-013.004 | Organizing Files and Packages in OAF Projects | Video | Reference | File types (.xml, .java, .class), package naming, MDS structure |
| B101-013.005 | Understanding the OAF Directory Structure | Video | Diagram | $JAVA_TOP structure, workspace organization, resource files |
| B101-013.006 | Using Import and Export Utilities for Code Management | Lab | Tutorial | Code extraction from database, importing to JDeveloper, version control; JDeveloper-level only, command-line importers are covered in Dev 103 |
| B101-013.007 | Designing Common Page Patterns and Use Cases | Video | Patterns | Search pages, Create/Update pages, Detail/drill-down, List pages |

## [14] OAF Application Deployment

**Module:** B101-014 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-014.001 | Following the OAF Deployment Steps from Build to Bounce | Video | Checklist | Compilation, packaging, file transfer, import to MDS, bounce Apache |
| B101-014.002 | Deploying an OAF Application on R12.1.x | Lab | Tutorial | Step-by-step deployment, file locations, import commands, verification |
| B101-014.003 | Deploying an OAF Application on R12.2.x | Lab | Tutorial | Deployment differences on R12.2 for a training instance; the dual file system, adop and online patching are covered in Dev 103 |
| B101-014.004 | Completing Post-Deployment Configuration | Lab | Guide | Function registration, menu setup, responsibility assignment, testing |

## [15] Jobs and Positions Management Capstone

**Module:** B101-015 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B101-015.001 | Creating Database Objects and Entities | Lab | Scripts | Tables, sequences, entity objects, WHO columns |
| B101-015.002 | Building View Objects and the Application Module | Lab | Project | Job and position VOs, view link, root AM |
| B101-015.003 | Building Job Search and Job Details Pages | Lab | Project | Search page, create/update page, controllers |
| B101-015.004 | Implementing Position Maintenance (Master-Detail) | Lab | Project | Detail table, add/delete rows, validation |
| B101-015.005 | Testing the Application and Deploying It to EBS | Lab | Checklist | Test plan, deployment to EBS, reflection |
| B101-015.006 | Assessing the Capstone Against the 100-Point Rubric | Workshop | Rubric | 100 points: functionality 40, code quality 30, UI 20, documentation 10 |
