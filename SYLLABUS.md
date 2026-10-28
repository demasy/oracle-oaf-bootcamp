# Oracle Application Framework (OAF) BootCamp

> **Deprecated.** This monolithic syllabus is superseded by [SYLLABUS_101.md](SYLLABUS_101.md), [SYLLABUS_102.md](SYLLABUS_102.md), [SYLLABUS_103.md](SYLLABUS_103.md), [SYLLABUS_CUST_101.md](SYLLABUS_CUST_101.md) and [SYLLABUS_CUST_102.md](SYLLABUS_CUST_102.md). Kept for reference.

## 🎓 Level 101: Oracle OAF Building BootCamp (Beginner)

**Duration:** 20-25 Days  
**Level:** Beginner  
**Prerequisites:** Basic Java and SQL  

### Level 101 Learning Outcomes

Upon completion of Level 101, students will be able to:
- **LO1.1:** Set up and configure OAF development environment
- **LO1.2:** Create basic OAF pages using Model-View-Controller pattern
- **LO1.3:** Implement standard web widgets and UI components
- **LO1.4:** Build CRUD (Create, Read, Update, Delete) functionality
- **LO1.5:** Deploy OAF applications to Oracle E-Business Suite
- **LO1.6:** Debug and test basic OAF applications


## [1] BootCamp Orientation & Your Success Path
**Duration:** 2.5 Days | **Level**: Beginner

### Learning Objectives
- Navigate bootcamp structure, resources, and support system
- Understand assessment criteria and success strategies
- Connect with learning community and set personal goals
- Establish productive learning habits and mindset

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 1.1 | Welcome to Your OAF Journey | Video | ✓ | PDF | Transformation roadmap, success stories, instructor intro |
| 1.2 | BootCamp Architecture & Learning Framework | Video | ✓ | PDF | Three-level progression, scaffolding approach, assessment |
| 1.3 | Building Your Learning Community | Video | ✓ | Guide | Study groups, code review, forums, peer learning |
| 1.4 | Setting Goals & Success Strategies | Workshop | ✓ | Template | SMART goals, time management, growth mindset |


## [2] OAF Foundations - Architecture & Design Patterns
**Duration:** 5 Days | **Level**: Beginner

### Learning Objectives
- Master OAF terminology to communicate effectively with teams
- Evaluate when to use OAF versus alternative technologies
- Apply MVC design pattern principles to application architecture
- Identify and explain all OAF architectural components
- Articulate the strategic value of OAF in enterprise environments

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 2.1 | OAF Terminology: Speaking the Language | Video | ✓ | Glossary | Vocabulary, naming conventions, EBS context |
| 2.2 | Evolution: From Oracle Forms to OA Framework | Video | ✓ | Comparison Chart | Technology shift, migration strategies, use cases |
| 2.3 | Strategic Value: When and Why to Use OAF | Video | ✓ | Decision Matrix | Advantages, limitations, business case |
| 2.4 | OAF Ecosystem: Integration with E-Business Suite | Video | - | Whitepaper | Evolution, Oracle's direction, EBS integration |
| 2.5 | MVC Pattern Mastery: The Foundation of OAF | Video | ✓ | Diagram | Model-View-Controller, separation of concerns |
| 2.6 | OAF Architecture Deep Dive: BC4J and UIX | Video | ✓ | Architecture Guide | BC4J, UIX, lifecycle, metadata repository |
| 2.7 | Page Anatomy: Understanding OAF Components | Video | ✓ | Reference Poster | AM, VO, EO, Pages, Regions, Controllers |


## [3] Development Environment Setup & Your First Page
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Install and configure production-ready OAF development environment
- Master JDeveloper IDE navigation and productivity features
- Create and run your first working "Hello World" OAF page
- Establish professional workspace organization standards
- Troubleshoot common environment and connectivity issues

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 3.1 | JDeveloper IDE: Your Development Command Center | Video | ✓ | Quick Ref | IDE layout, panels, workspace organization |
| 3.2 | Acquiring OA Extension from Oracle Support | Video | - | Guide | MOS portal, version matrix, download process |
| 3.3 | Environment Configuration: Step-by-Step Setup | Video | ✓ | Checklist | Installation, OA Extension, configuration, DBC |
| 3.4 | JDeveloper Productivity: Tools & Shortcuts | Video | ✓ | Shortcut Card | Interface customization, shortcuts, templates |
| 3.5 | Essential Configuration: DBC Files & Connections | Video | ✓ | Troubleshoot Guide | DBC setup, connection parameters, validation |
| 3.6 | Milestone Achievement: Building "Hello World!" | Lab | ✓ | Step-by-step | First page, AM, layout, components, run |
| 3.7 | Project Structure Best Practices | Video | ✓ | Template | Workspace organization, naming, version control |
| 3.8 | Database Connectivity Essentials | Video | ✓ | Connection Guide | Connection setup, pooling, multi-environment |


## [4] The Model Layer - Business Logic with BC4J
**Duration:** 7.5 Days | **Level**: Advanced

### Learning Objectives
- Design and implement complete BC4J Model layer components
- Create Application Modules that manage business transactions
- Build Entity Objects that enforce business rules at database level
- Develop View Objects (updatable, read-only, and programmatic)
- Test Model components independently using BC4J tester
- Understand transaction management and database interaction patterns

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 4.1 | BC4J Framework: The Data Management Engine | Video | ✓ | Overview | Understanding BC4J, MVC role, component ecosystem |
| 4.2 | Application Modules: Orchestrating Business Logic | Video | ✓ | Design Guide | AM structure, transactions, pooling, patterns |
| 4.3 | Hands-On: Creating & Testing Application Modules | Lab | ✓ | Wizard Guide | Step-by-step creation, testing, debugging |
| 4.4 | Entity Objects: Your Database Gateway | Video | ✓ | EO Reference | Table mapping, validation, DML, associations |
| 4.5 | Building Entity Objects: Mapping to Reality | Lab | ✓ | Tutorial | Wizard creation, attributes, validation rules |
| 4.6 | View Objects: Query-Based Data Views | Video | ✓ | VO Guide | SQL queries, read-only vs updatable, performance |
| 4.7 | Creating Updatable View Objects | Lab | ✓ | Tutorial | VO-EO linking, attribute mapping, CRUD testing |
| 4.8 | Creating Read-Only View Objects | Lab | ✓ | Tutorial | SQL-based VOs, expert mode, joins, optimization |
| 4.9 | Creating Programmatic View Objects | Lab | ✓ | Examples | Dynamic VOs, runtime attributes, use cases |
| 4.10 | Advanced BC4J: View Links & Associations | Video | ✓ | Reference | Master-detail, FK relationships, domains |
| 4.11 | Database Interactions: Transactions & Pooling | Video | ✓ | Best Practices | Connection pooling, commits, locking, tuning |


## [5] The View Layer - Building Modern User Interfaces
**Duration:** 7.5 Days | **Level**: Advanced

### Learning Objectives
- Master all standard OAF web widgets and UI components
- Design professional page layouts using regions and hierarchies
- Implement List of Values (LOV) with search capabilities
- Apply CSS styling and reusable attribute sets
- Enable dynamic user experiences with Partial Page Rendering (PPR)
- Build intuitive navigation with breadcrumbs and menus
- Create accessible, user-friendly interfaces

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 5.1 | UIX Framework: Component-Based UI Architecture | Video | ✓ | UIX Guide | Framework basics, component hierarchy, metadata |
| 5.2 | Organizing UI Components: Workspace Structure | Video | ✓ | Structure Guide | Workspace organization, naming, packages, reusable |
| 5.3 | Pages and Regions: Fundamentals | Video | ✓ | Layout Guide | Page structure, region types, hierarchy, containers |
| 5.4 | Standard Web Widgets: Input & Display Components | Lab | ✓ | Widget Reference | All standard UI widgets and their properties |
| 5.5 | List of Values (LOV): Search & Select | Lab | ✓ | LOV Tutorial | Standard, dependent, and external LOVs |
| 5.6 | Page Layouts & Advanced Regions | Lab | ✓ | Layout Patterns | Layouts, headers, buttons, query regions |
| 5.7 | Styling & Customization: CSS & Attribute Sets | Video | ✓ | Style Guide | CSS styling, attribute sets, theming |
| 5.8 | Partial Page Rendering (PPR): Dynamic UI | Lab | ✓ | PPR Tutorial | AJAX in OAF, PPR events, dynamic updates |
| 5.9 | Navigation: Breadcrumbs & Menus | Video | ✓ | Nav Guide | Breadcrumb configuration, menu integration |


## [6] The Controller Layer - Handling User Events
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Implement Controller logic for HTTP GET and POST requests
- Handle user events: button clicks, form submissions, navigation
- Pass parameters between pages using three scoping strategies
- Execute common controller patterns and tasks
- Navigate programmatically and manage page flow
- Call Model layer methods from Controller
- Display messages and manage user feedback

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 6.1 | Controller Architecture: Processing User Actions | Video | ✓ | CO Guide | MVC role, lifecycle, structure, best practices |
| 6.2 | GET Requests: Page Initialization Logic | Video | ✓ | Pattern Library | processRequest(), initialization, default values |
| 6.3 | POST Requests: Form Submission Handling | Video | ✓ | Examples | processFormRequest(), button clicks, validation |
| 6.4 | Common Controller Patterns & Tasks | Video | ✓ | Cookbook | Parameters, form values, navigation, messages |
| 6.5 | Controller API: pageContext & WebBeans | Video | ✓ | API Reference | pageContext, attributes, WebBeans, transactions |
| 6.6 | Parameter Passing Strategies: Overview | Video | ✓ | Decision Tree | Request, Transaction, Session scopes comparison |
| 6.7 | Request Parameters: Single-Page Scope | Lab | ✓ | Tutorial | Token-based, navigation, lifecycle, examples |
| 6.8 | Transaction Parameters: Task Flow Scope | Lab | ✓ | Tutorial | Multi-page flow, retention, cleanup |
| 6.9 | Session Parameters: User Session Management | Lab | ✓ | Tutorial | Session scope, persistence, memory, best practices |


## [6B] Master-Detail Relationships - Hierarchical Data
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Implement master-detail relationships using View Links
- Display and navigate hierarchical parent-child data
- Coordinate updates between master and detail records
- Handle cascading operations and dependencies

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 6B.1 | Master-Detail Pattern: View Links Explained | Video | ✓ | Guide | Parent-child relationships, View Links, use cases |
| 6B.2 | Building Master-Detail User Interfaces | Lab | ✓ | Tutorial | Region configuration, synchronization, cascading |


## [7] Error Handling & Debugging Excellence
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Implement robust exception handling strategies
- Master OA Framework exception types and hierarchy
- Debug OAF applications using multiple techniques
- Troubleshoot common issues systematically
- Provide user-friendly error messages
- Use professional debugging tools effectively

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 7.1 | OAF Exception Framework: Types & Hierarchy | Video | ✓ | Exception Guide | OAException, checked/unchecked, propagation |
| 7.2 | User Feedback: Messages & Dialog Pages | Video | ✓ | Message Library | Error messages, dialogs, tokens, i18n |
| 7.3 | Debugging Toolkit: Console & Logging | Video | ✓ | Debug Guide | Console output, log files, diagnostic logging |
| 7.4 | JDeveloper Debugger: Step-Through Analysis | Lab | ✓ | Debug Tutorial | Breakpoints, step-through, variables, remote |


## [8] Security Implementation - Protecting Your Application
**Duration:** 2.5 Days | **Level**: Beginner

### Learning Objectives
- Understand OAF security model and EBS integration
- Implement function security to control page access
- Configure menu entries and responsibility assignments
- Apply data-level security for multi-org environments
- Test security configurations thoroughly
- Follow security best practices

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 8.1 | OAF Security Model: Authentication & Authorization | Video | ✓ | Security Guide | Authentication, authorization, function security |
| 8.2 | Function Security: Controlling Page Access | Lab | ✓ | Tutorial | Function registration, menu setup, responsibilities |
| 8.3 | Data Security: Row-Level Protection | Video | ✓ | Best Practices | Multi-Org, row-level security, VPD, filtering |


## [9] Development Standards and Best Practices
**Duration:** 2.5 Days | **Level**: Beginner

### Learning Objectives
- Follow Oracle OAF coding standards
- Organize code and files properly
- Understand directory structure
- Use import/export utilities
- Distinguish between Personalizations and Extensions

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 9.1 | Why Standards Matter | Video | ✓ | Guide | Maintainability, team collaboration, Oracle support, upgrades |
| 9.2 | Coding Standards and Terminology | Video | ✓ | Standards Doc | Naming conventions, package structure, comments, organization |
| 9.3 | Different Standards | Video | ✓ | Comparison | Oracle standards, project-specific, industry best practices |
| 9.4 | Files and Packages | Video | ✓ | Reference | File types (.xml, .java, .class), package naming, MDS structure |
| 9.5 | Directory Structure | Video | ✓ | Diagram | $JAVA_TOP structure, workspace organization, resource files |
| 9.6 | export.bat, import.bat, JPXImporter | Lab | ✓ | Tutorial | Code extraction from database, importing to JDeveloper, version control |
| 9.7 | Personalizations | Video | ✓ | Guide | User-level, admin-level customization, personalization limits |
| 9.8 | Extensions | Video | ✓ | Best Practices | Extending Oracle pages, custom extensions, upgrade-safe mods |
| 9.9 | Common Page Use Cases | Video | ✓ | Patterns | Search pages, Create/Update pages, Detail/drill-down, List pages |


## [10] Deploying OA Framework Applications
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Deploy OAF applications to E-Business Suite
- Understand deployment differences between versions
- Troubleshoot deployment issues
- Register pages in E-Business Suite

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 10.1 | Deployment Process Overview | Video | ✓ | Checklist | Compilation, packaging, file transfer, import to MDS, bounce Apache |
| 10.2 | Deploy Your OAF Application on R12.1.x | Lab | ✓ | Tutorial | Step-by-step deployment, file locations, import commands, verification |
| 10.3 | Deploy Your OAF Application on R12.2.x | Lab | ✓ | Tutorial | Deployment differences, dual file system, ADOP, online patching |
| 10.4 | Post-Deployment Tasks | Lab | ✓ | Guide | Function registration, menu setup, responsibility assignment, testing |


## 🚀 Level 102: Oracle OAF Building BootCamp (Advanced)

**Duration:** 20-25 Days  
**Level:** Advanced  
**Prerequisites:** Completion of Level 101 or equivalent experience  
**Scaffolding Level:** Moderate (40% guidance, 60% independence)

### Level 102 Learning Outcomes

Upon completion of Level 102, students will be able to:

**Note:** At this level, scaffolding is significantly reduced. Students receive high-level guidance and must independently implement solutions with occasional checkpoints.
- **LO2.1:** Create dynamic View Objects programmatically
- **LO2.2:** Execute SQL statements and call PL/SQL procedures from OAF
- **LO2.3:** Implement advanced UI components (HGrid, Train, Shuttle, etc.)
- **LO2.4:** Integrate Flexfields (Key and Descriptive) in OAF pages
- **LO2.5:** Implement file upload/download and data import/export
- **LO2.6:** Build workflow-enabled OAF applications
- **LO2.7:** Create dynamic UI components programmatically
- **LO2.8:** Optimize performance and implement advanced debugging


## [11] Advanced Model Implementation
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Create View Objects dynamically at runtime
- Add attributes to VOs programmatically
- Implement complex query logic

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 11.1 | Creating Dynamic View Objects Programmatically | Lab | ✓ | Tutorial | ViewObjectImpl methods, dynamic queries, adding to AM, use cases |
| 11.2 | Adding Attributes to View Objects Programmatically | Lab | ✓ | Examples | AttributeDef creation, data types, calculated & transient attributes |


## [12] Server-Side Features
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Execute SQL statements from Java
- Call PL/SQL functions and procedures
- Handle database interactions efficiently
- Implement business logic in AM

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 12.1 | Executing SQL Statements | Lab | ✓ | Tutorial | Using JDBC in OAF, PreparedStatement, handling result sets, connections |
| 12.2 | Calling PL/SQL Functions and Procedures | Lab | ✓ | Examples | CallableStatement usage, IN/OUT parameters, function returns, error handling |
| 12.3 | Best Practices | Video | ✓ | Best Practices | PL/SQL vs Java, performance considerations, transaction management |


## [13] Advanced View Components
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
| 13.1 | Implementing Hide/Show Region | Lab | ✓ | Tutorial | Conditional rendering, PPR for dynamic display, UX considerations |
| 13.2 | Implementing Flow Layout Region | Lab | ✓ | Examples | Flow vs other layouts, component arrangement, responsive design |
| 13.3 | Implementing Query Region (Advanced) | Lab | ✓ | Guide | Construction modes, results-based search, auto-customization, configuration |
| 13.4 | Implementing Advanced Table Region | Lab | ✓ | Tutorial | Selection, sorting, filtering, row actions, footer calculations, performance |
| 13.5 | Implementing Train Region | Lab | ✓ | Examples | Multi-step processes, train stops, navigation, validation, progress tracking |
| 13.6 | Implementing Shuttle Region | Lab | ✓ | Tutorial | Dual-list selection, moving items, ordering, search functionality |
| 13.7 | Implementing Advanced Layout Region | Lab | ✓ | Patterns | Table/Row/Cell layouts, nested layouts, complex forms |
| 13.8 | Implementing HGrid Region | Lab | ✓ | Tutorial | Hierarchical data, expandable nodes, tree navigation, performance |
| 13.9 | Implementing Content Container Region | Lab | ✓ | Examples | Tab-based navigation, hiding/showing tabs, dynamic tab generation |
| 13.10 | Implementing Charts and Graphs | Lab | ✓ | Tutorial | Chart types, data binding, interactive charts, BI Publisher integration |
| 13.11 | Adding Custom HTML Code | Lab | ✓ | Guide | RawText component, JavaScript integration, security, best practices |
| 13.12 | Implementing Key Flexfield Region | Lab | ✓ | Tutorial | KFF configuration, binding to page, validation, capturing values |
| 13.13 | Implementing Descriptive Flexfield Region | Lab | ✓ | Tutorial | DFF configuration, context-sensitive DFF, EO integration, querying |
| 13.14 | Changing Item Properties Using SPEL | Lab | ✓ | Examples | SPEL syntax, conditional properties, dynamic rendering, performance |
| 13.15 | Launching Oracle Forms from OAF | Lab | ✓ | Tutorial | Form function call, parameter passing, integration patterns |
| 13.16 | Launching OAF Pages from Oracle Forms | Lab | ✓ | Guide | ICX integration, URL construction, SSO considerations |


## [14] Advanced Controller and Programmatic UI
**Duration:** 5 Days | **Level**: Advanced

### Learning Objectives
- Create UI components programmatically
- Build dynamic pages at runtime
- Implement JavaScript integration
- Create read-only pages dynamically

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 14.1 | WebBean Creation Programmatically | Lab | ✓ | Tutorial | WebBean hierarchy, OAWebBeanFactory, component properties, page structure |
| 14.2 | Create Items Programmatically | Lab | ✓ | Examples | Text fields, buttons, LOVs, all widget types |
| 14.3 | Create Regions Programmatically | Lab | ✓ | Tutorial | Region types, layout configuration, nested regions |
| 14.4 | Add Region to OAF Page Programmatically | Lab | ✓ | Examples | Dynamic page composition, runtime UI modification, use cases |
| 14.5 | Creating Submit Button Programmatically | Lab | ✓ | Tutorial | Button properties, event handlers, action binding |
| 14.6 | Using JavaScript in OA Framework | Lab | ✓ | Guide | Client-side validation, UI enhancements, calling Java, security |
| 14.7 | Implementing Read-Only Page | Lab | ✓ | Tutorial | Disabling inputs, visual indicators, conditional read-only mode |


## [15] Data Manipulation and Validation
**Duration:** 2.5 Days | **Level**: Advanced

### Learning Objectives
- Format dates and numbers properly
- Implement data validation
- Use Entity Experts for complex validation

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 15.1 | Date Manipulation & Formatting | Lab | ✓ | Tutorial | Date comparisons, Oracle date formats, timezone handling, calculations |
| 15.2 | Formatting Numbers | Lab | ✓ | Examples | Number formats, currency display, locale considerations, decimal precision |
| 15.3 | Data Validations | Lab | ✓ | Guide | Field-level validation, cross-field validation, business rule validation |
| 15.4 | Implementing Validation Using Entity Expert | Lab | ✓ | Tutorial | Entity Expert pattern, reusable validation, complex business rules, messages |


## [16] Advanced Features and Integrations
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
| 16.1 | Setting Default Values | Lab | ✓ | Tutorial | Text fields, number fields, date fields, techniques and best practices |
| 16.2 | Understanding MDS Repository | Video | ✓ | Guide | Metadata storage, MDS queries, import/export, cleanup |
| 16.3 | Important Profile Options | Video | ✓ | Reference | Key profile options, impact on behavior, setting programmatically |
| 16.4 | Implementing Attachments Functionality | Lab | ✓ | Tutorial | FND_ATTACHED_DOCUMENTS, configuration, UI integration, file storage |
| 16.5 | Implementing Upload Files Functionality | Lab | ✓ | Tutorial | File upload component, server-side handling, validation, storage options |
| 16.6 | Implementing Import Data Functionality | Lab | ✓ | Examples | CSV/Excel import, data validation, batch processing, error handling |
| 16.7 | Implementing Export Data Functionality | Lab | ✓ | Tutorial | Export formats (CSV, Excel, PDF), large data sets, streaming, performance |
| 16.8 | Handling Browser Back Button | Lab | ✓ | Guide | Back button issues, prevention techniques, transaction integrity |
| 16.9 | Workflow in OA Framework | Lab | ✓ | Tutorial | Launching workflow, passing parameters, monitoring, embedding OAF in notification |


## [17] Advanced Debugging and Error Handling
**Duration:** 2.5 Days | **Level**: Ninja

### Learning Objectives
- Use advanced debugging techniques
- Implement custom logging
- Handle multiple error messages
- Debug production issues

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 17.1 | Using demasy-oaf Libraries for Debugging | Lab | ✓ | Tutorial | Library overview, installation, debug utilities, performance profiling |
| 17.2 | Raising Bundle/Multiple Error Messages | Lab | ✓ | Examples | Message bundles, multiple validation errors, user-friendly messages, i18n |
| 17.3 | Advanced Debugging Techniques | Lab | ✓ | Guide | Remote debugging, production debugging, log analysis, performance profiling |


### Level 102 Projects

#### Project 101: Point-Of-Sale System (Introduction)
**Duration:** 2.5 Days

- Setting up project structure
- Git version control
- Database design
- Project planning

#### Project 102: Items Creation with Approval Cycle
**Duration:** 5 Days

**Objectives:**
- Multi-step approval workflow
- Complex business logic
- Integration with workflow
- Advanced UI features

**Requirements:**
1. Item creation form with all details
2. Submit for approval
3. Multi-level approval workflow
4. Email notifications
5. Approval history tracking
6. Advanced search and reporting

**Deliverables:**
- Functional application
- Git repository
- Technical documentation
- User guide
- Test results


### Level 102 Final Assessment

**Comprehensive Project: Choose One**

**Option A: Advanced HR Management System**
- Employee self-service
- Manager approvals
- Integration with workflow
- Reports and dashboards

**Option B: Procurement Request System**
- Purchase requisition creation
- Multi-level approval
- Budget validation
- PO integration

**Assessment Criteria:**
- All Level 102 concepts implemented (40%)
- Code quality and standards (25%)
- Architecture and design (20%)
- Documentation (10%)
- Innovation and extras (5%)


## 🥷 Level 103: Oracle OAF Building BootCamp (Ninja)

**Duration:** 20-30 Days  
**Level:** Expert/Ninja  
**Prerequisites:** Completion of Level 102 with good understanding  
**Scaffolding Level:** Minimal (20% guidance, 80% autonomous work)

### Level 103 Learning Outcomes

**Learning Model:** At this level, scaffolds are almost completely removed. Students work autonomously on real-world projects with occasional milestone reviews and on-demand consultation only.

Upon completion of Level 103, students will be able to:
- **LO3.1:** Design and architect complete enterprise applications
- **LO3.2:** Build production-ready OAF systems from scratch
- **LO3.3:** Implement complex business logic and workflows
- **LO3.4:** Apply advanced design patterns and best practices
- **LO3.5:** Optimize performance of large-scale applications
- **LO3.6:** Lead OAF development projects
- **LO3.7:** Mentor junior developers


### Capstone Project 101: Complete Point-Of-Sale System

**Duration:** 20-30 Days  
**Project Type:** Real-world, production-grade application

#### Project Overview

Build a complete, enterprise-grade Point-of-Sale (POS) system using Oracle Application Framework. This project synthesizes all concepts from Levels 101 and 102.


## [18] Project Setup and Planning
**Duration:** 2.5 Days | **Level**: Ninja

### Learning Objectives
- Set up professional development environment
- Configure version control
- Design database architecture
- Plan application structure

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 18.1 | Setting-Up Development Environment | Lab | ✓ | Guide | Professional workspace setup, team collaboration tools, code repository structure |
| 18.2 | Installing Git (Version Control System) | Lab | ✓ | Tutorial | Git fundamentals, branching strategy, commit conventions, pull requests |
| 18.3 | Create Workspaces and Projects | Lab | ✓ | Template | Project structure, naming conventions, module organization |
| 18.4 | Create & Test Database Connection | Lab | ✓ | Guide | Development database, connection pooling, testing connectivity |
| 18.5 | Installing the Database Objects | Lab | ✓ | Scripts | Database schema design, tables and relationships, sequences and triggers, sample data |


## [19] Store Management Module (CRUD Operations)
**Duration:** 7.5 Days | **Level**: Ninja

### Learning Objectives
- Implement complete CRUD functionality
- Apply all Level 101 concepts
- Build professional UI
- Implement proper error handling

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 19.1 | Implementing Store Query Page (SELECT) | Lab | ✓ | Project | Search functionality, multiple criteria, results table, pagination, export to Excel |
| 19.2 | Implementing Store Drill-Down Page (SELECT) | Lab | ✓ | Project | Master-detail display, related information, navigation, breadcrumbs |
| 19.3 | Implementing Store Create Page (INSERT) | Lab | ✓ | Project | Data entry form, validation, confirmation, success message |
| 19.4 | Implementing Store Delete Page (DELETE) | Lab | ✓ | Project | Confirmation dialog, business rule validation, cascade delete handling, audit trail |
| 19.5 | Implementing Store Update Page (UPDATE) | Lab | ✓ | Project | Edit form, version control, concurrent update handling, change tracking |


## [20] Product Management Module (Practice Assignment)
**Duration:** 5 Days | **Level**: Ninja

### Learning Objectives
- Independent implementation
- Apply learned patterns
- Problem-solving
- Self-assessment

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 20.1 | Explaining the Practice Assignment | Workshop | ✓ | Requirements | Requirements specification, business rules, acceptance criteria, deliverables |
| 20.2 | Implementing Product CRUD Functionality | Lab | ✓ | Project | Query page, create page, update page, delete functionality, drill-down details |
| 20.3 | Explaining the Practice Solution | Workshop | ✓ | Review | Solution walkthrough, best practices applied, alternative approaches, lessons learned |


## [21] Branch Management (Master-Detail Complexity)
**Duration:** 7.5 Days | **Level**: Ninja

### Learning Objectives
- Implement complex master-detail relationships
- Handle hierarchical data
- Coordinate multiple regions
- Advanced transaction management

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 21.1 | Implementing Branch Page (Master-Details) | Lab | ✓ | Project | Master: Branch info, address, contact, hours; Detail 1: Store assignments with shuttle; Detail 2: Employee assignments with advanced table; Detail 3: Inventory summary with PPR |


## [22] Sales and Transactions Module
**Duration:** 7.5 Days | **Level**: Ninja

### Learning Objectives
- Design and implement transaction processing
- Build inventory management system
- Create reporting and analytics features
- Apply all advanced concepts independently

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 22.1 | Sales Transaction Processing | Lab | ✓ | Project | POS interface, product selection, quantity and pricing, discounts, payment, receipts |
| 22.2 | Inventory Management | Lab | ✓ | Project | Stock tracking, reorder alerts, transfer between stores, inventory reports |
| 22.3 | Reporting and Analytics | Lab | ✓ | Project | Sales reports, inventory reports, employee performance, charts and graphs, export |


## [23] Advanced Features and Polish
**Duration:** 5 Days | **Level**: Ninja

### Learning Objectives
- Implement advanced enterprise features
- Optimize application performance
- Establish comprehensive error handling
- Prepare for production deployment

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 23.1 | Advanced Features | Lab | ✓ | Project | Attachments for documents, workflow integration, audit trail, security, multi-language support |
| 23.2 | Performance Optimization | Lab | ✓ | Project | Query optimization, caching strategies, large data set handling, response time improvement |
| 23.3 | Error Handling and Logging | Lab | ✓ | Project | Comprehensive error messages, debug logging, production monitoring, user help system |


## [24] Deployment and Presentation
**Duration:** 2.5 Days | **Level**: Ninja

### Learning Objectives
- Deploy application to production environment
- Create comprehensive documentation
- Present project to stakeholders professionally
- Demonstrate mastery of OAF development

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 24.1 | Deployment to Production | Lab | ✓ | Guide | Deployment package creation, installation instructions, production deployment, post-deployment validation |
| 24.2 | Documentation | Workshop | ✓ | Templates | Technical documentation, user manual, installation guide, troubleshooting guide |
| 24.3 | Project Presentation | Workshop | ✓ | Guide | Demo preparation, presentation to stakeholders, Q&A handling |


### Level 103 Final Assessment

**Comprehensive Evaluation:**

1. **Functional Completeness (30%)**
   - All modules working
   - Business rules implemented
   - No critical bugs

2. **Code Quality (25%)**
   - Standards compliance
   - Maintainability
   - Documentation
   - Test coverage

3. **Architecture & Design (20%)**
   - MVC implementation
   - Scalability
   - Reusability
   - Performance

4. **Professional Deliverables (15%)**
   - Complete documentation
   - Deployment package
   - User manual
   - Presentation

5. **Innovation & Excellence (10%)**
   - Creative solutions
   - Additional features
   - Problem-solving approach
   - Going beyond requirements

**Success Criteria for Ninja Level:**
- Score ≥ 85% on all criteria
- Production-ready application
- Professional presentation
- Complete documentation
- Demonstrates mastery


## 📚 Customization Track (Optional)

## Level 201: Oracle OAF Customizing BootCamp (Beginner)

**Duration:** 2-3 Weeks  
**Prerequisites:** Level 101 or equivalent

### Learning Outcomes
- Understand personalizations vs. extensions
- Customize existing OAF pages
- Extend seeded functionality
- Maintain customizations through upgrades

### Topics (To Be Detailed)
- Introduction to OAF Customization
- Personalization Framework
- Admin-level Personalizations
- Function-level Personalizations
- Extension Framework
- Extending Controllers
- Extending Views
- Extending Model
- Best Practices for Customizations
- Upgrade Considerations


## Level 202: Oracle OAF Customizing BootCamp (Advanced)

**Duration:** 2-3 Weeks  
**Prerequisites:** Level 201

### Learning Outcomes
- Implement complex customizations
- Extend Oracle-delivered applications
- Maintain upgrade-safe customizations
- Troubleshoot customization issues

### Topics (To Be Detailed)
- Advanced Personalization Techniques
- Complex Extension Scenarios
- Substituting EOs and VOs
- Custom Validation in Extensions
- Performance Impact of Customizations
- Debugging Customizations
- Migration and Deployment
- Real-world Customization Projects


## 📊 Scaffolding Summary by Level

### Visual Progression of Support

```
Level 101: ████████████░░░░░░░░  60% Support | 40% Independence
Level 102: ████████░░░░░░░░░░░░  40% Support | 60% Independence  
Level 103: ████░░░░░░░░░░░░░░░░  20% Support | 80% Independence
```

### Support Type by Level

| Support Type | Level 101 | Level 102 | Level 103 |
|-------------|-----------|-----------|----------|
| **Step-by-Step Instructions** | ✅ Always | ⚠️ Sometimes | ❌ Rarely |
| **Code Templates** | ✅ Provided | ⚠️ Partial | ❌ None |
| **Detailed Walkthroughs** | ✅ Every Lab | ⚠️ Key Concepts | ❌ Minimal |
| **Guided Practice** | ✅ 60% of Time | ⚠️ 40% of Time | ⚠️ 20% of Time |
| **Checkpoints** | ✅ Frequent | ⚠️ Milestones | ⚠️ Major Only |
| **Hints Available** | ✅ Multiple Levels | ⚠️ On Request | ⚠️ Limited |
| **Solution Code** | ✅ After Attempt | ⚠️ After Completion | ❌ Never |
| **Instructor Demos** | ✅ Detailed | ⚠️ Conceptual | ⚠️ Brief |
| **Independent Work** | ⚠️ 40% | ✅ 60% | ✅ 80% |
| **On-Demand Help** | ✅ Immediate | ✅ Available | ⚠️ Scheduled |

### Scaffolding Fade Timeline

**Weeks 1-5 (Level 101):**
- Heavy use of templates and guides
- "I Do, We Do, You Do" in every section
- Frequent instructor intervention
- Multiple hints and supports

**Weeks 6-10 (Level 102):**
- Templates become optional
- More "You Do," less "We Do"
- Checkpoint reviews instead of constant guidance
- Students must attempt before requesting help

**Weeks 11-16 (Level 103):**
- Professional project simulation
- Requirements and architecture only
- Milestone reviews (not step reviews)
- Consultation by appointment
- Real-world independence

### Student Readiness Indicators

**Ready for Level 102 when you can:**
- Complete labs with hints only (no step-by-step)
- Debug independently for 20+ minutes before asking
- Design simple solutions without templates
- Explain code to peers

**Ready for Level 103 when you can:**
- Complete projects from requirements alone
- Debug complex issues independently
- Design architecture without guidance
- Mentor Level 101 students


## 🎯 Learning Support and Resources

### Office Hours
- Weekly Q&A sessions
- Code review sessions
- Troubleshooting help
- Career guidance

### Community Support
- Discussion forum
- Peer study groups
- Code sharing platform
- Project showcase

### Additional Resources
- Video tutorials for each lecture
- Code templates and samples
- Quick reference guides
- Troubleshooting database
- Interview preparation guide

### Mentorship Program
- Pair programming sessions
- One-on-one mentoring
- Career advice
- Portfolio development


## 📊 Progress Tracking

### Student Dashboard
- Completion percentage
- Lab results
- Project scores
- Time spent
- Areas for improvement

### Milestones & Badges
- 🏅 Environment Setup Master
- 🏅 MVC Champion
- 🏅 UI/UX Expert
- 🏅 Controller Guru
- 🏅 Deployment Specialist
- 🏅 Level 101 Graduate
- 🏅 Advanced Developer
- 🏅 Ninja Certified
- 🏅 Project Completed


## 🎓 Certification

### Level 101 Certificate
**Requirements:**
- Complete all labs
- Pass final assessment
- Deploy working application

### Level 102 Certificate
**Requirements:**
- Complete Level 101
- Complete all advanced labs
- Pass advanced project
- Code review approval

### Level 103 Ninja Certification
**Requirements:**
- Complete Level 102
- Complete POS capstone project
- Score ≥ 85% on all criteria
- Professional presentation
- Demonstrate mastery


## 📋 Course Policies

### Time Commitment
- **Level 101:** 10-15 hours/week for 4-5 weeks
- **Level 102:** 12-18 hours/week for 4-5 weeks
- **Level 103:** 15-20 hours/week for 4-6 weeks

### Prerequisites Enforcement
- Self-assessment before each level
- Prerequisite quiz
- Instructor approval for level skip

### Code of Conduct
- Respect and professionalism
- Collaboration encouraged, copying forbidden
- Help others learn
- Give credit for shared code

### Assessment Policies
- Multiple attempts allowed for quizzes
- Projects have defined deadlines
- Late submission policy: 10% penalty per week
- Code must be your own work


## 🔄 Continuous Improvement

This syllabus is a living document and will be updated based on:
- Student feedback
- Industry changes
- Oracle updates
- Best practice evolution
- Learning outcome data

### Feedback Channels
- End-of-section surveys
- Mid-course evaluation
- Final course evaluation
- Alumni feedback
- Industry advisory board


## 📞 Contact and Support

### Instructor
- Email: instructor@demasylabs.com
- Office Hours: [Schedule]
- Response Time: 24-48 hours

### Technical Support
- Email: support@demasylabs.com
- Forum: [URL]
- Emergency: [Contact]

### Course Administration
- Email: admin@demasylabs.com
- Enrollment questions
- Certificate requests


## 🚀 Getting Started

### Your Next Steps:

1. ✅ **Review this syllabus completely**
2. ✅ **Complete pre-course survey**
3. ✅ **Join course community forum**
4. ✅ **Set up development environment** (Section 3)
5. ✅ **Attend orientation session**
6. ✅ **Start Section 1: Welcome!**

### Success Tips:

- **Practice daily** - Even 30 minutes helps
- **Don't skip labs** - Hands-on practice is essential
- **Ask questions** - No question is too basic
- **Help others** - Teaching reinforces learning
- **Build projects** - Apply what you learn
- **Stay consistent** - Regular practice beats cramming
- **Enjoy the journey** - Have fun building!


**Welcome to the Oracle OAF BootCamp!**  
**Let's build something amazing together! 🚀**


*Version 1.0 | Last Updated: January 24, 2026 | Demasy Labs*
