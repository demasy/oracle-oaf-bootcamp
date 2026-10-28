# Oracle OAF Building BootCamp 103

**Code:** DL-OAF-B-103 | **Level:** Ninja | **Duration:** 20-30 days | **Scaffolding:** 20% guidance | **Certification milestone:** Master OAF Developer

## Course Goals

- Design and architect complete enterprise applications
- Build production-ready OAF systems from scratch
- Implement complex business logic and workflows
- Apply advanced design patterns and best practices
- Optimize performance of large-scale applications
- Lead OAF development projects
- Mentor junior developers

## Curriculum

| Section | Module | Title | Path | Lectures |
| :-: | :-- | :-- | :-: | :-: |
| [1] | B103-1 | [MDS Repository Deployment](#1-mds-repository-deployment) | Core | 1 |
| [2] | B103-2 | [BC4J Configuration Upload](#2-bc4j-configuration-upload) | Core | 1 |
| [3] | B103-3 | [AOL Security and Page Registration](#3-aol-security-and-page-registration) | Core | 2 |
| [4] | B103-4 | [Enterprise Instrumentation](#4-enterprise-instrumentation) | Core | 2 |
| [5] | B103-5 | [Log Management and Maintenance](#5-log-management-and-maintenance) | Core | 1 |
| [6] | B103-6 | [EBS R12.2 Online Patching](#6-ebs-r122-online-patching) | Core | 1 |
| [7] | B103-7 | [Automated Packaging and Scripting](#7-automated-packaging-and-scripting) | Core | 2 |
| [8] | B103-8 | [Project Setup and Planning](#8-project-setup-and-planning) | Required | 5 |
| [9] | B103-9 | [Store Management Module](#9-store-management-module) | Required | 5 |
| [10] | B103-10 | [Product Management Module](#10-product-management-module) | Required | 3 |
| [11] | B103-11 | [Branch Management (Master-Detail)](#11-branch-management-master-detail) | Required | 1 |
| [12] | B103-12 | [Sales and Transactions Module](#12-sales-and-transactions-module) | Required | 3 |
| [13] | B103-13 | [Advanced Features and Polish](#13-advanced-features-and-polish) | Required | 3 |
| [14] | B103-14 | [Deployment and Presentation](#14-deployment-and-presentation) | Required | 4 |
| [15] | B103-15 | [Final Assessment](#15-final-assessment) | Required | 6 |
| [16] | B103-16 | [Advanced Tables, Grids and Visualization](#16-advanced-tables-grids-and-visualization) | Extended | 7 |
| [17] | B103-17 | [Advanced Search and Navigation](#17-advanced-search-and-navigation) | Extended | 6 |
| [18] | B103-18 | [State Management, Back Button and Security](#18-state-management-back-button-and-security) | Extended | 7 |
| [19] | B103-19 | [REST and Product Integration](#19-rest-and-product-integration) | Extended | 6 |

## [1] MDS Repository Deployment

**Module:** B103-1 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-1.1 | Deploying Pages with XMLImporter | Lab | Guide | -rootdir, -username, -password, -dbconnection parameters, $JAVA_TOP layout |

## [2] BC4J Configuration Upload

**Module:** B103-2 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-2.1 | Registering BC4J Configuration with JPXImporter | Lab | Guide | .jpx project files, classpath specifications, repository registration |

## [3] AOL Security and Page Registration

**Module:** B103-3 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-3.1 | Defining Form Functions for OAF Pages | Lab | Guide | SSWA jsp function, page path and parameters |
| B103-3.2 | Configuring Menus and Responsibilities | Lab | Guide | Attaching functions to menus, assigning responsibilities, testing access |

## [4] Enterprise Instrumentation

**Module:** B103-4 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-4.1 | Configuring the FND_LOG Framework and Profile Options | Lab | Guide | FND: Debug Log Enabled, FND: Debug Log Level, FND_LOG_MESSAGES |
| B103-4.2 | Writing Diagnostics from Code | Lab | Tutorial | pageContext.writeDiagnostics(), screen logging, performance tracing; SQL trace with event 10046 |

## [5] Log Management and Maintenance

**Module:** B103-5 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-5.1 | Purging Logs with FNDLGPRG | Lab | Guide | Concurrent program, FND_LOG_ADMIN package, table storage |

## [6] EBS R12.2 Online Patching

**Module:** B103-6 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-6.1 | Using Online Patching (adop) Fundamentals | Video | Diagram | Run edition versus patch edition, patch phases, classpath configuration |

## [7] Automated Packaging and Scripting

**Module:** B103-7 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-7.1 | Compiling and Archiving with adcgnjar | Lab | Guide | $AD_TOP/bin/adcgnjar, customall.jar, signed archives under $JAVA_TOP |
| B103-7.2 | Scripting Repeatable Deployments | Lab | Project | Environment variables such as $AD_APPS_JDBC_URL in place of hardcoded connection strings |

## [8] Project Setup and Planning

**Module:** B103-8 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-8.1 | Setting-Up Development Environment | Lab | Guide | Professional workspace setup, team collaboration tools, code repository structure |
| B103-8.2 | Installing Git (Version Control System) | Lab | Tutorial | Git fundamentals, branching strategy, commit conventions, pull requests |
| B103-8.3 | Creating Workspaces and Projects | Lab | Template | Project structure, naming conventions, module organization |
| B103-8.4 | Creating and Testing a Database Connection | Lab | Guide | Development database, connection pooling, testing connectivity |
| B103-8.5 | Installing the Database Objects | Lab | Scripts | Database schema design, tables and relationships, sequences and triggers, sample data |

## [9] Store Management Module

**Module:** B103-9 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-9.1 | Implementing Store Query Page (SELECT) | Lab | Project | Search functionality, multiple criteria, results table, pagination, export to Excel |
| B103-9.2 | Implementing Store Drill-Down Page (SELECT) | Lab | Project | Master-detail display, related information, navigation, breadcrumbs |
| B103-9.3 | Implementing Store Create Page (INSERT) | Lab | Project | Data entry form, validation, confirmation, success message |
| B103-9.4 | Implementing Store Delete Page (DELETE) | Lab | Project | Confirmation dialog, business rule validation, cascade delete handling, audit trail |
| B103-9.5 | Implementing Store Update Page (UPDATE) | Lab | Project | Edit form, version control, concurrent update handling, change tracking |

## [10] Product Management Module

**Module:** B103-10 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-10.1 | Explaining the Practice Assignment | Workshop | Requirements | Requirements specification, business rules, acceptance criteria, deliverables |
| B103-10.2 | Implementing Product CRUD Functionality | Lab | Project | Query page, create page, update page, delete functionality, drill-down details |
| B103-10.3 | Explaining the Practice Solution | Workshop | Review | Solution walkthrough, best practices applied, alternative approaches, lessons learned |

## [11] Branch Management (Master-Detail)

**Module:** B103-11 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-11.1 | Implementing Branch Page (Master-Details) | Lab | Project | Master: Branch info, address, contact, hours; Detail 1: Store assignments with shuttle; Detail 2: Employee assignments with advanced table; Detail 3: Inventory summary with PPR |

## [12] Sales and Transactions Module

**Module:** B103-12 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-12.1 | Processing Sales Transactions | Lab | Project | POS interface, product selection, quantity and pricing, discounts, payment, receipts |
| B103-12.2 | Managing Inventory | Lab | Project | Stock tracking, reorder alerts, transfer between stores, inventory reports |
| B103-12.3 | Reporting and Analytics | Lab | Project | Sales reports, inventory reports, employee performance, charts and graphs, export |

## [13] Advanced Features and Polish

**Module:** B103-13 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-13.1 | Implementing Advanced Features | Lab | Project | Attachments for documents, workflow integration, audit trail, security, multi-language support |
| B103-13.2 | Optimizing Performance | Lab | Project | Query optimization, caching strategies, large data set handling, response time improvement |
| B103-13.3 | Handling Errors and Logging | Lab | Project | Comprehensive error messages, debug logging, production monitoring, user help system |

## [14] Deployment and Presentation

**Module:** B103-14 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-14.1 | Deploying to Production | Lab | Guide | Deployment package creation, installation instructions, production deployment, post-deployment validation |
| B103-14.2 | Writing Documentation | Workshop | Templates | Technical documentation, user manual, installation guide, troubleshooting guide |
| B103-14.3 | Presenting the Project | Workshop | Guide | Demo preparation, presentation to stakeholders, Q&A handling |
| B103-14.4 | Mentoring and Code Review | Workshop | Guide | Reviewing a peer implementation, giving actionable feedback, coaching a junior developer through a defect, review checklist |

## [15] Final Assessment

**Module:** B103-15 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-15.1 | Applying the Comprehensive Evaluation Criteria | Workshop | Rubric | Functional Completeness (30%): All modules working, business rules implemented, no critical bugs |
| B103-15.2 | Assessing Code Quality | Workshop | Standards Guide | Code Quality (25%): Standards compliance, maintainability, documentation, test coverage |
| B103-15.3 | Reviewing Architecture and Design | Workshop | Design Patterns | Architecture & Design (20%): MVC implementation, scalability, reusability, performance |
| B103-15.4 | Reviewing Professional Deliverables | Workshop | Checklist | Professional Deliverables (15%): Complete documentation, deployment package, user manual, presentation |
| B103-15.5 | Showcasing Innovation and Excellence | Workshop | Portfolio | Innovation & Excellence (10%): Creative solutions, additional features, problem-solving, exceeding requirements |
| B103-15.6 | Earning Ninja Level Certification | Workshop | Success Criteria | Success Criteria: Score ≥ 85% on all criteria, production-ready application, professional presentation, complete documentation, demonstrates mastery |

## [16] Advanced Tables, Grids and Visualization

**Module:** B103-16 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-16.1 | Building Advanced Tables | Lab | Guide | Column groups, sortable headers, selection, total rows, detail disclosure, table-in-table |
| B103-16.2 | Migrating from Classic Tables | Video | Guide | Comparison with advanced tables, usage limits, migration strategy |
| B103-16.3 | Implementing Rich Table Interactions | Lab | Guide | Resize, reorder, freeze, hide/show columns, scrolling; touch-device optimizations |
| B103-16.4 | Exporting Table Data | Lab | Guide | Excel and PDF export, transient columns, export limits *(verify)* |
| B103-16.5 | Building HGrid and Tree Regions | Lab | Project | OAHGridBean, OATreeBean, focus and hierarchy columns, child row retrieval |
| B103-16.6 | Building Charts, Graphs and Infotiles | Lab | Guide | BI beans and JET transition, Gantt, Infotiles *(verify)* |
| B103-16.7 | Building Masonry Layout Dashboards | Lab | Guide | Grid-based responsive dashboards, status tiles, KPI cards *(verify)* |

## [17] Advanced Search and Navigation

**Module:** B103-17 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-17.1 | Designing the Search Architecture | Lab | Guide | Query regions, simple and advanced search, results-based search |
| B103-17.2 | Implementing the List Search Framework | Lab | Guide | Filter panels, saved searches, quick and keyword search |
| B103-17.3 | Implementing Infotile-Driven Search | Lab | Project | Summary tiles with metric counts that filter a results table |
| B103-17.4 | Implementing Quick Search and Side Navigation Search | Lab | Guide | Compact search inputs in global headers and side navigation |
| B103-17.5 | Using Navigation Components | Lab | Guide | Trains, subtabs, accordions, hide/show, popups, shuttles |
| B103-17.6 | Implementing Declarative Page Flows | Lab | Guide | Destination function and workflow page flows, transaction state |

## [18] State Management, Back Button and Security

**Module:** B103-18 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-18.1 | Applying Advanced Entity Mechanics | Lab | Guide | Polymorphic entities, parent/child posting order, transient attributes |
| B103-18.2 | Building PL/SQL Entity Objects | Lab | Guide | Wrapping PL/SQL table APIs, key generation, locking, error mapping |
| B103-18.3 | Managing State Retention and Pooling | Video | Guide | Retention levels, passivation, session limits, connection pool monitoring |
| B103-18.4 | Applying Resource Swapping and Memory Caching | Video | Guide | AM pooling and resource swapping, JDBC pool tuning, memory caching, resource conservation |
| B103-18.5 | Supporting the Browser Back Button | Lab | Guide | Page instance IDs, transaction units, back-button detection |
| B103-18.6 | Securing Pages, Functions and Data | Lab | Guide | Function security, data grants, page access tracking |
| B103-18.7 | Hardening Input Against Attacks | Lab | Guide | XSS scanning, AntiSamy HTML filtering, virus scanning, frame busting |

## [19] REST and Product Integration

**Module:** B103-19 | **Path:** Extended  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| B103-19.1 | Using the OAF REST Servlet | Lab | Guide | Exposing AM methods, service data objects, testing business service objects; BSO API tester |
| B103-19.2 | Using Application Web Services | Video | Guide | Business service objects, attachments service, home page service |
| B103-19.3 | Consuming External SOAP and REST Services | Lab | Project | Calling external services from application module code, error handling, timeouts |
| B103-19.4 | Integrating Forms and Workflow | Lab | Guide | Launching Forms from OAF and back, worklist notifications; JTT application launch and parameter passing *(verify the term and scope)* |
| B103-19.5 | Embedding Portal Content and Analytics | Video | Guide | Portlet integration, embedding analytics *(verify)*; OBIEE analytics embedding |
| B103-19.6 | Reviewing and Approving Workflow Notifications from OAF | Lab | Guide | Notification pages, approve and reject actions, worklist review |
