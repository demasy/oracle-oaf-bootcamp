# Oracle Application Framework (OAF) Roadmap

Two learning paths for Oracle E-Business Suite OAF developers. **Building** takes you from your first page to production. **Customizing** shows you how to change delivered pages while accounting for support and upgrade impact. Every step is one course, with its sections, lectures and levels. It is part of the [Oracle Application Framework (OAF) BootCamp](../README.md).

<br>

## Contents

- [How to read the roadmap](#how-to-read-the-roadmap)
- [Building roadmap](#building-roadmap)
  - [Step 1: Oracle OAF Building BootCamp 101](#step-1-oracle-oaf-building-bootcamp-101)
  - [Step 2: Oracle OAF Building BootCamp 102](#step-2-oracle-oaf-building-bootcamp-102)
  - [Step 3: Oracle OAF Building BootCamp 103](#step-3-oracle-oaf-building-bootcamp-103)
- [Customizing roadmap](#customizing-roadmap)
  - [Step 1: Oracle OAF Customizing BootCamp 101](#step-1-oracle-oaf-customizing-bootcamp-101)
  - [Step 2: Oracle OAF Customizing BootCamp 102](#step-2-oracle-oaf-customizing-bootcamp-102)

<br>

## How to read the roadmap

This is a **curriculum roadmap**: formats name planned teaching approaches. Follow the displayed module order; identifiers remain stable rather than being renumbered. Required/elective labels indicate assessment scope. Level badges summarize **module** difficulty; the course pages give individual lecture ratings, hours, outcomes and prerequisites. See [curriculum conventions](../bootcamp/CURRICULUM.md).

<img src="legend.svg" width="700" alt="Legend: Foundation, Core, Advanced, Expert">

<br>

## Building Roadmap

**Path:** Beginner → Advanced → Ninja

Build OAF pages, business components and applications, from the first page to production.

<img src="../bootcamp/assets/levels-building.svg" width="520" alt="Building path: OAF-B-101 Beginner, OAF-B-102 Advanced, OAF-B-103 Ninja">

| Step | Course | Level | Sections | Lectures | Focus |
| --: | :-- | :-: | :-: | :-: | :-- |
| 1 | [OAF-B-101](#step-1-oracle-oaf-building-bootcamp-101) | Beginner | 15 | 95 | MVC, setup, BC4J model, declarative pages, GET/POST, messages, master-detail, security, deployment and Jobs/Positions design |
| 2 | [OAF-B-102](#step-2-oracle-oaf-building-bootcamp-102) | Advanced | 20 | 97 | PPR, LOVs, advanced tables, model validation, recoverable navigation, accessibility and interactive request design |
| 3 | [OAF-B-103](#step-3-oracle-oaf-building-bootcamp-103) | Ninja | 17 | 80 | MDS/BC4J deployment, diagnostics, R12.2 patching, state/security analysis and bounded sales/inventory design |

<br>

### Step 1: Oracle OAF Building BootCamp 101

Step 1 of 3 · Beginner · [OAF-B-101 course](../bootcamp/courses/building/101/README.md) · 15 sections · 95 lectures

![Building step 1: Beginner](building-1.svg)

<details>
<summary>Topics as text</summary>

- **B101-001 BootCamp Orientation and Success Path (Required)** (Difficulty ★)
  - Introducing the OAF BootCamp (Video, Foundation)
  - Understanding the BootCamp Structure and Learning Model (Video, Foundation)
  - Joining the Learning Community (Video, Foundation)
  - Setting Goals and Success Strategies (Workshop, Foundation)
- **B101-002 OAF Architecture and MVC Paradigms (Required)** (Difficulty ★)
  - Learning OAF Terminology (Video, Foundation)
  - Tracing the Evolution from Oracle Forms to OAF (Video, Foundation)
  - Choosing When and Why to Use OAF (Video, Foundation)
  - Integrating OAF with E-Business Suite (Video, Foundation)
  - Separating Model, View and Controller in OAF (Video, Foundation)
  - Understanding BC4J and UIX Architecture (Video, Foundation)
  - Examining OAF Page Anatomy (Video, Foundation)
  - Understanding the Layered Application Architecture (Video, Foundation)
  - Mapping the Database Layer to Base and TL Tables (Video, Foundation)
  - Querying System Catalog Views for OAF Metadata (Video, Foundation)
- **B101-003 IDE Setup and Project Topology (Required)** (Difficulty ★)
  - Navigating the JDeveloper IDE (Video, Foundation)
  - Downloading OA Extension from Oracle Support (Video, Foundation)
  - Configuring the Development Environment (Video, Foundation)
  - Using JDeveloper Tools and Shortcuts (Video, Foundation)
  - Using the Structure Pane, Inspector and UML Modeler (Lab, Foundation)
  - Configuring DBC Files and Database Connections (Video, Foundation)
  - Establishing Database Connectivity (Video, Foundation)
  - Registering Short Names and Responsibility Keys (Lab, Foundation)
  - Building the First Hello World OAF Page (Lab, Foundation)
  - Organizing Workspaces and Version Control in JDeveloper (Video, Foundation)
- **B101-004 Application Module Construction (Required)** (Difficulty ★★)
  - Managing Business Data with BC4J (Video, Foundation)
  - Designing Application Modules (Video, Foundation)
  - Building and Testing an Application Module (Lab, Foundation)
  - Accessing OADBTransaction from the Application Module (Lab, Foundation)
  - Managing Transactions and Connection Pooling (Video, Foundation)
- **B101-006 Entity Object and DML Layer (Required)** (Difficulty ★★)
  - Understanding Entity Object Fundamentals (Video, Foundation)
  - Creating Entity Objects from Tables (Lab, Foundation)
  - Defining Primary Keys and Attribute Validation (Lab, Foundation)
  - Defining Entity Associations Between Entity Objects (Lab, Foundation)
  - Writing Entity-Level and Cross-Attribute Validation (Lab, Foundation)
- **B101-005 View Object Development (Required)** (Difficulty ★★)
  - Choosing Between Read-Only and Updatable View Objects (Video, Foundation)
  - Building Read-Only View Objects with SQL (Lab, Foundation)
  - Building Updatable View Objects for CRUD (Lab, Foundation)
  - Configuring Bind Variables and View Criteria (Lab, Foundation)
  - Linking View Objects with View Links and Associations (Video, Foundation)
- **B101-007 Declarative Page Layouts (Required)** (Difficulty ★★)
  - Composing Pages from UIX Components (Video, Foundation)
  - Structuring UI Components in the Workspace (Video, Foundation)
  - Building Pages and Regions (Video, Foundation)
  - Creating and Reusing Shared Regions, Pages and Items (Lab, Foundation)
  - Configuring Standard Web Widgets and Their Properties (Lab, Foundation)
  - Designing Page Layouts and Advanced Regions (Lab, Foundation)
  - Building Forms with messageComponentLayout (Lab, Foundation)
  - Applying Look-and-Feel Standards (Video, Foundation)
  - Using Poplists, Radio Groups, Checkboxes and Spin Boxes (Lab, Foundation)
  - Using Buttons, Page Button Bars and Content Footers (Lab, Foundation)
  - Adding Images, Spacers, Separators and Static Text (Lab, Foundation)
  - Passing Form Parameters and Form Values (Lab, Foundation)
  - Applying CSS Styling and Reusable Attribute Sets (Video, Foundation)
  - Implementing Navigation with Breadcrumbs and Menus (Video, Foundation)
- **B101-009 Controller Request Processing (Required)** (Difficulty ★★)
  - Understanding Controller Architecture and User Actions (Video, Foundation)
  - Handling GET Requests and Page Initialization (Video, Foundation)
  - Using the Controller API for pageContext and WebBeans (Video, Foundation)
  - Creating Controller Classes with OAControllerImpl (Lab, Foundation)
  - Handling Basic Form Submissions with processFormRequest (Lab, Foundation)
  - Providing Validation Messages with OAException (Video, Foundation)
  - Applying Safe CRUD and Transaction Boundaries (Workshop, Foundation)
  - Comparing Parameter Passing Strategies (Video, Foundation)
  - Using Request Parameters for Single-Page Scope (Lab, Foundation)
  - Managing Transaction Parameters Across Pages (Lab, Foundation)
  - Storing User State in Session Parameters (Lab, Foundation)
- **B101-010 Master-Detail Relationships (Required)** (Difficulty ★★)
  - Understanding Master-Detail with View Links (Video, Foundation)
  - Implementing Master-Detail User Interfaces (Lab, Foundation)
- **B101-011 JDeveloper Debugging (Required)** (Difficulty ★★)
  - Using Console and Logging Debugging Tools (Video, Foundation)
  - Debugging with the JDeveloper Debugger (Lab, Foundation)
- **B101-012 Security Implementation (Required)** (Difficulty ★★)
  - Distinguishing Authentication from Authorization in OAF (Video, Foundation)
  - Implementing Function Security for Page Access (Lab, Foundation)
  - Applying Data Security for Row-Level Protection (Video, Foundation)
  - Understanding Built-In HTML Tampering Protection (Video, Foundation)
  - Testing Protection Against HTML Tampering (Lab, Foundation)
- **B101-013 Development Standards and Best Practices (Required)** (Difficulty ★)
  - Understanding Why Development Standards Matter (Video, Foundation)
  - Following OAF Coding Standards and Terminology (Video, Foundation)
  - Comparing Oracle, Project and Industry Standards (Video, Foundation)
  - Organizing Files and Packages in OAF Projects (Video, Foundation)
  - Understanding the OAF Directory Structure (Video, Foundation)
  - Using Import and Export Utilities for Code Management (Lab, Foundation)
  - Designing Common Page Patterns and Use Cases (Video, Foundation)
- **B101-014 OAF Application Deployment (Required)** (Difficulty ★★)
  - Planning OAF Deployment from Build to Validation (Video, Foundation)
  - Comparing R12.1 and R12.2 Deployment Boundaries (Video, Foundation)
  - Planning OAF Deployment on R12.2 (Lab, Foundation)
  - Completing Post-Deployment Configuration (Lab, Foundation)
- **B101-015 Jobs and Positions Management Capstone (Required)** (Difficulty ★★★)
  - Creating Database Objects and Entities (Lab, Core)
  - Building View Objects and the Application Module (Lab, Core)
  - Building Job Search and Job Details Pages (Lab, Core)
  - Implementing Position Maintenance (Master-Detail) (Lab, Core)
  - Testing the Application and Deploying It to EBS (Lab, Core)
  - Assessing the Capstone Against the 100-Point Rubric (Workshop, Core)
- **B101-008 Reusable UI Components (Elective)** (Difficulty ★★★)
  - Building Smart Poplists with LOV Choice Lists (Lab, Core)
  - Reviewing Reusable UI Composition Decisions (Workshop, Core)
  - Designing Parameter Contracts for Shared Regions (Lab, Core)
  - Reviewing Look-and-Feel Consistency Across Pages (Workshop, Core)
  - Designing Reusable Page Button Bars (Lab, Core)

</details>

<br>

### Step 2: Oracle OAF Building BootCamp 102

Step 2 of 3 · Advanced · [OAF-B-102 course](../bootcamp/courses/building/102/README.md) · 20 sections · 97 lectures

![Building step 2: Advanced](building-2.svg)

<details>
<summary>Topics as text</summary>

- **B102-001 Form Event Handling Lifecycle (Required)** (Difficulty ★★★)
  - Analyzing Form Submission and Validation Order (Video, Core)
  - Applying Common Controller Patterns Across Multi-Page Flows (Video, Core)
  - Reading Request Data with processFormData (Lab, Core)
- **B102-004 Enterprise Exception Framework (Required)** (Difficulty ★★★)
  - Handling Exceptions with the OAF Exception Hierarchy (Video, Core)
  - Applying Exception Severity Levels and Inline Messages (Lab, Core)
  - Raising Bundle/Multiple Error Messages (Lab, Core)
- **B102-005 Modal Dialogs and Page Navigation (Required)** (Difficulty ★★★)
  - Providing User Feedback with Messages and Dialog Pages (Video, Core)
  - Controlling Page Flow with Dialog Pages (Lab, Core)
- **B102-010 Configuration and Defaults (Required)** (Difficulty ★★)
  - Setting Default Values (Lab, Foundation)
  - Querying Page Metadata in the MDS Repository (Video, Foundation)
  - Configuring Important Profile Options (Video, Foundation)
- **B102-008 Advanced Model and Server-Side Features (Required)** (Difficulty ★★★)
  - Selecting Declarative or Programmatic View Objects (Video, Core)
  - Creating Dynamic View Objects Programmatically (Lab, Core)
  - Adding Attributes to View Objects Programmatically (Lab, Core)
  - Executing SQL Statements (Lab, Core)
  - Calling PL/SQL Functions and Procedures (Lab, Core)
  - Applying Server-Side Best Practices (Video, Core)
  - Developing Validation View Objects (Lab, Core)
  - Applying Multi-Org Context to View Objects and Pages (Lab, Core)
- **B102-009 Data Formatting and Validation (Required)** (Difficulty ★★★)
  - Manipulating and Formatting Dates (Lab, Core)
  - Formatting Numbers (Lab, Core)
  - Implementing Data Validations (Lab, Core)
  - Implementing Validation Using Entity Expert (Lab, Core)
  - Building Date Pickers and Calendar Fields (Lab, Core)
- **B102-002 Asynchronous UI via PPR (Required)** (Difficulty ★★★)
  - Enabling Partial Page Rendering (PPR) for Dynamic UI (Lab, Core)
  - Handling PPR Events on the Server (Lab, Core)
- **B102-003 List of Values (LOV) Engineering (Required)** (Difficulty ★★★)
  - Configuring List of Values (LOV) for Data Selection (Lab, Core)
  - Building Dependent (Cascading) LOVs (Lab, Core)
  - Enabling LOV Auto-Completion and Look-Ahead (Lab, Core)
  - Wiring LOV Action Buttons and Mappings (Lab, Core)
  - Using Lookup Codes and Value Sets as LOV and Poplist Sources (Lab, Core)
- **B102-006 Advanced Table Operations (Required)** (Difficulty ★★★)
  - Implementing Advanced Table Region (Lab, Core)
  - Creating and Deleting Table Rows Programmatically (Lab, Core)
  - Building Updateable Summary Pages with Batch Actions (Lab, Core)
- **B102-018 Internationalization, Accessibility and Usability (Required)** (Difficulty ★★★)
  - Supporting Multiple Languages and Internationalization (Lab, Core)
  - Enabling Screen Reader Mode, Row Headers and Hot Keys (Lab, Core)
  - Warning on Unsaved Changes with the Enhanced Save Model (Lab, Core)
  - Auditing Accessibility Compliance of a Page (Lab, Core)
  - Adding Context-Sensitive and Page Help (Video, Core)
- **B102-019 Advanced Debugging (Required)** (Difficulty ★★★)
  - Evaluating Debugging Utilities and Dependencies (Workshop, Core)
  - Applying Advanced Debugging Techniques (Lab, Core)
  - Using the About This Page and OAInfo.jsp Diagnostics (Lab, Core)
  - Unit Testing and Automating OAF Components (Video, Core)
- **B102-017 Navigation, Workflow and Background Processing (Required)** (Difficulty ★★★)
  - Applying Back Button Recovery to Multi-Page Flows (Lab, Core)
  - Building Workflow-Enabled OAF Applications (Elective) (Lab, Core)
  - Implementing Deep Links and Bookmarkable URLs (Lab, Core)
  - Designing Concurrent Request Submission and Monitoring (Video, Core)
  - Raising and Subscribing to Business Events (Elective) (Lab, Core)
  - Submitting Concurrent Requests Programmatically (Lab, Core)
- **B102-020 Projects and Final Assessment (Required)** (Difficulty ★★★★)
  - Planning the Interactive Application Assessment (Workshop, Advanced)
  - Designing an Items Approval Scenario (Workshop, Advanced)
  - Defining the Final Assessment Scope (Workshop, Advanced)
  - Specifying an HR Request Application (Option A) (Workshop, Advanced)
  - Specifying a Procurement Request Application (Option B) (Workshop, Advanced)
  - Applying the Assessment Criteria and Deliverables (Workshop, Advanced)
- **B102-007 Dynamic UI Control and Focus (Elective)** (Difficulty ★★★★)
  - Creating Web Beans Programmatically (Lab, Advanced)
  - Creating Items Programmatically (Lab, Advanced)
  - Creating Regions Programmatically (Lab, Advanced)
  - Adding Regions to OAF Pages Programmatically (Lab, Advanced)
  - Creating Submit Button Programmatically (Lab, Advanced)
  - Controlling Focus and Dynamic Bean Properties (Lab, Advanced)
  - Switching Content with the Switcher Component (Lab, Advanced)
- **B102-011 Layout and Container Regions (Elective)** (Difficulty ★★★)
  - Implementing Hide/Show Region (Lab, Core)
  - Implementing Flow Layout Region (Lab, Core)
  - Implementing Advanced Layout Region (Lab, Core)
  - Implementing Content Container Region (Lab, Core)
  - Implementing Panel Splitter and Layered Layout (Lab, Core)
  - Building Custom Grids with tableLayout and cellFormat (Lab, Core)
  - Switching layeredLayout Between Two Modes (Lab, Core)
- **B102-012 Data Regions, Grids and Charts (Elective)** (Difficulty ★★★★)
  - Implementing Query Region (Advanced) (Lab, Advanced)
  - Implementing HGrid Region (Lab, Advanced)
  - Implementing Charts and Graphs (Lab, Advanced)
  - Implementing Bulleted Lists (Lab, Advanced)
  - Implementing Auto-Repeating Layouts (Lab, Advanced)
- **B102-013 Wizards, Rich Inputs and Configurable Pages (Elective)** (Difficulty ★★★★)
  - Implementing Train Region (Lab, Advanced)
  - Implementing Shuttle Region (Lab, Advanced)
  - Implementing Multi-Step Create and Update Flows (Lab, Advanced)
  - Building Rich Text, Color Picker and Rating Bar Inputs (Lab, Advanced)
  - Building Configurable Pages with flexibleLayout (Lab, Advanced)
- **B102-014 Flexfields, SPEL and Forms Integration (Elective)** (Difficulty ★★★★)
  - Configuring a Key Flexfield Region (Lab, Advanced)
  - Configuring a Descriptive Flexfield Region (Lab, Advanced)
  - Changing Item Properties Using SPEL (Lab, Advanced)
  - Adding Custom HTML Code (Lab, Advanced)
  - Launching Oracle Forms from OAF (Lab, Advanced)
  - Launching OAF Pages from Oracle Forms (Lab, Advanced)
  - Mapping Flexfield Segments with flexMap (Lab, Advanced)
- **B102-015 Client-Side Scripting and Page Modes (Elective)** (Difficulty ★★★)
  - Using JavaScript in OAF (Lab, Core)
  - Implementing Read-Only Page (Lab, Core)
- **B102-016 Files, Documents and Data Exchange (Elective)** (Difficulty ★★★★)
  - Enabling Attachments in Pages (Lab, Advanced)
  - Enabling File Upload in Pages (Lab, Advanced)
  - Building Import Data Functionality (Lab, Advanced)
  - Building Export Data Functionality (Lab, Advanced)
  - Publishing Documents to the Document Catalog (Lab, Advanced)
  - Displaying PDFs Inline and Downloading Files Securely (Lab, Advanced)
  - Generating Reports with XML Publisher and BI Publisher (Lab, Advanced)
  - Comparing Native Table Export and Web ADI Integration (Lab, Advanced)
  - Uploading Spreadsheet Data with Web ADI (Lab, Advanced)

</details>

<br>

### Step 3: Oracle OAF Building BootCamp 103

Step 3 of 3 · Ninja · [OAF-B-103 course](../bootcamp/courses/building/103/README.md) · 17 sections · 80 lectures

![Building step 3: Ninja](building-3.svg)

<details>
<summary>Topics as text</summary>

- **B103-001 MDS and BC4J Deployment (Required)** (Difficulty ★★★)
  - Deploying Pages with XMLImporter (Lab, Core)
  - Registering BC4J Configuration with JPXImporter (Lab, Core)
- **B103-002 AOL Security and Page Registration (Required)** (Difficulty ★★★)
  - Defining Form Functions for OAF Pages (Lab, Core)
  - Configuring Menus and Responsibilities (Lab, Core)
- **B103-003 Enterprise Instrumentation and Log Management (Required)** (Difficulty ★★★★)
  - Configuring the FND_LOG Framework and Profile Options (Lab, Advanced)
  - Writing Diagnostics from Code (Lab, Advanced)
  - Purging Logs with FNDLGPRG (Lab, Advanced)
  - Tracing SQL with Event 10046 (Lab, Advanced)
  - Tuning View Object Queries: Range Size and Fetch Strategy (Lab, Advanced)
- **B103-004 R12.2 Online Patching and Packaging (Required)** (Difficulty ★★★★)
  - Using Online Patching (adop) Fundamentals (Video, Advanced)
  - Packaging Custom Java with adcgnjar (Lab, Advanced)
  - Designing Repeatable Deployment and Recovery (Lab, Advanced)
- **B103-014 State Management, Back Button and Security (Required)** (Difficulty ★★★★)
  - Analyzing Entity Posting Order and Transient State (Lab, Advanced)
  - Building PL/SQL Entity Objects (Lab, Advanced)
  - Managing State Retention and Pooling (Video, Advanced)
  - Applying Resource Swapping and Memory Caching (Video, Advanced)
  - Supporting the Browser Back Button (Lab, Advanced)
  - Analyzing Function and Data Security Boundaries (Lab, Advanced)
  - Planning Input Trust Boundaries (Workshop, Advanced)
  - Applying Polymorphic Entity Objects (Lab, Advanced)
- **B103-015 Security Hardening (Required)** (Difficulty ★★★★)
  - Tracking Page Access (Lab, Advanced)
  - Scanning Pages for Cross-Site Scripting (Lab, Advanced)
  - Applying Frame Busting Protection (Lab, Advanced)
  - Scanning Uploaded Files for Viruses (Lab, Advanced)
- **B103-005 Project Setup and Planning (Required)** (Difficulty ★★★)
  - Defining the Capstone Environment and Delivery Boundaries (Workshop, Core)
  - Planning Version Control and Release Reviews (Workshop, Core)
  - Designing Capstone Workspaces and Module Boundaries (Workshop, Core)
  - Planning Environment Connectivity and Configuration (Workshop, Core)
  - Designing Capstone Database Objects and Migration (Workshop, Core)
- **B103-006 Store Management Module (Required)** (Difficulty ★★★)
  - Implementing Store Query Page (SELECT) (Lab, Core)
  - Implementing Store Drill-Down Page (SELECT) (Lab, Core)
  - Implementing Store Create Page (INSERT) (Lab, Core)
  - Implementing Store Delete Page (DELETE) (Lab, Core)
  - Implementing Store Update Page (UPDATE) (Lab, Core)
- **B103-007 Product and Branch Management (Required)** (Difficulty ★★★★)
  - Explaining the Practice Assignment (Workshop, Advanced)
  - Implementing Product CRUD Functionality (Lab, Advanced)
  - Reviewing Product Design Alternatives (Workshop, Advanced)
  - Implementing Branch Page (Master-Details) (Lab, Advanced)
- **B103-008 Sales and Transactions Module (Required)** (Difficulty ★★★★)
  - Processing Sales Transactions (Lab, Advanced)
  - Managing Inventory (Lab, Advanced)
  - Reporting and Analytics (Lab, Advanced)
- **B103-009 Advanced Features and Polish (Required)** (Difficulty ★★★★)
  - Reviewing Enterprise Quality Requirements (Workshop, Advanced)
  - Optimizing Performance (Lab, Advanced)
  - Handling Errors and Logging (Lab, Advanced)
- **B103-010 Deployment and Presentation (Required)** (Difficulty ★★★★)
  - Defining the Production Deployment and Rollback Plan (Workshop, Advanced)
  - Writing Documentation (Workshop, Advanced)
  - Presenting the Project (Workshop, Advanced)
  - Mentoring and Code Review (Workshop, Advanced)
- **B103-011 Final Assessment (Required)** (Difficulty ★★★★)
  - Applying the Comprehensive Evaluation Criteria (Workshop, Advanced)
  - Assessing Code Quality (Workshop, Advanced)
  - Reviewing Architecture and Design (Workshop, Advanced)
  - Reviewing Professional Deliverables (Workshop, Advanced)
  - Reviewing Security and Professional Communication (Workshop, Advanced)
  - Reviewing the Ninja Completion Criteria (Workshop, Advanced)
- **B103-012 Advanced Tables, Grids and Visualization (Elective)** (Difficulty ★★★★)
  - Designing Nested and Grouped Advanced Tables (Lab, Advanced)
  - Migrating from Classic Tables (Video, Advanced)
  - Implementing Rich Table Interactions (Lab, Advanced)
  - Exporting Table Data (Lab, Advanced)
  - Building HGrid and Tree Regions (Lab, Advanced)
  - Comparing Charts, Graphs and Infotiles (Lab, Advanced)
  - Building Masonry Layout Dashboards (Lab, Advanced)
  - Building Gantt Charts (Lab, Advanced)
- **B103-013 Advanced Search and Navigation (Elective)** (Difficulty ★★★★)
  - Designing the Search Architecture (Lab, Advanced)
  - Implementing the List Search Framework (Lab, Advanced)
  - Implementing Infotile-Driven Search (Lab, Advanced)
  - Implementing Quick Search and Side Navigation Search (Lab, Advanced)
  - Choosing Navigation Components for Complex Flows (Lab, Advanced)
  - Implementing Declarative Page Flows (Lab, Advanced)
  - Building Accordion Navigation (Lab, Advanced)
  - Building Sub Tabs and Sliding Sub Tab Layouts (Lab, Advanced)
- **B103-016 REST and Product Integration (Elective)** (Difficulty ★★★★)
  - Using the OAF REST Servlet (Lab, Advanced)
  - Using Application Web Services (Video, Advanced)
  - Consuming External SOAP and REST Services (Lab, Advanced)
  - Comparing Forms and Workflow Integration Boundaries (Lab, Advanced)
  - Designing Embedded Analytics Context (Video, Advanced)
  - Reviewing and Approving Workflow Notifications from OAF (Lab, Advanced)
  - Embedding Oracle JET Components and Third-Party Web Apps (Lab, Advanced)
- **B103-017 Portal, Analytics and Service Testing (Elective)** (Difficulty ★★★★)
  - Publishing OAF Regions as Portlets (Lab, Advanced)
  - Embedding OBIEE Analytics (Lab, Advanced)
  - Defining BSO API Tester Service Scenarios (Lab, Advanced)

</details>

<br>

## Customizing Roadmap

**Path:** Beginner → Advanced

Personalize and extend delivered Oracle E-Business Suite pages while accounting for support and upgrade impact. Customizing 101 follows Building 101, and Customizing 102 requires Building 102, Customizing 101 and the Building 103 deployment core (B103-001 through B103-004).

<img src="../bootcamp/assets/levels-customizing.svg" width="520" alt="Customizing path: OAF-C-101 Beginner, OAF-C-102 Advanced">

| Step | Course | Level | Sections | Lectures | Focus |
| --: | :-- | :-: | :-: | :-: | :-- |
| 1 | [OAF-C-101](#step-1-oracle-oaf-customizing-bootcamp-101) | Beginner | 5 | 19 | Personalization levels, supported property/region/LOV changes, migration, diagnostics and back-out |
| 2 | [OAF-C-102](#step-2-oracle-oaf-customizing-bootcamp-102) | Advanced | 6 | 19 | Extension architecture, model/controller contracts, BC4J substitution, packaging, synchronization and recovery |

<br>

### Step 1: Oracle OAF Customizing BootCamp 101

Step 1 of 2 · Beginner · [OAF-C-101 course](../bootcamp/courses/customizing/101/README.md) · 5 sections · 19 lectures

![Customizing step 1: Beginner](customizing-1.svg)

<details>
<summary>Topics as text</summary>

- **C101-001 Upgrade Preservation Principles (Required)** (Difficulty ★)
  - Comparing Personalization, Extension and Modification (Video, Foundation)
  - Preserving Personalizations Through Upgrades (Video, Foundation)
  - Understanding the MDS Repository Architecture (Video, Foundation)
  - Implementing Personalizations in OAF (Video, Foundation)
- **C101-002 Personalization Hierarchy and Administration (Required)** (Difficulty ★★)
  - Applying Personalization Levels and Precedence (Lab, Foundation)
  - Enabling Personalization (Lab, Foundation)
  - Clearing MDS Caches (Lab, Foundation)
  - Resolving Personalization Precedence Across Levels (Lab, Foundation)
- **C101-003 Declarative Customization of Pages, Regions and LOVs (Required)** (Difficulty ★★)
  - Creating End-User Personalizations (Lab, Foundation)
  - Applying Declarative Page Personalizations (Lab, Foundation)
  - Personalizing Flexfields and Tables (Lab, Foundation)
  - Injecting Regions Declaratively (Lab, Foundation)
  - Personalizing LOVs (Lab, Foundation)
- **C101-004 Personalization Migration (Required)** (Difficulty ★★★)
  - Exporting Personalizations with XMLExporter (Lab, Core)
  - Using MDS Management Tools (Lab, Core)
  - Inspecting MDS Content (Lab, Core)
- **C101-005 Diagnostics, Translation and Assessment (Required)** (Difficulty ★★)
  - Using About This Page Diagnostics (Lab, Foundation)
  - Managing Translated Personalizations (Elective) (Video, Foundation)
  - Completing the Personalization Project (Workshop, Foundation)

</details>

<br>

### Step 2: Oracle OAF Customizing BootCamp 102

Step 2 of 2 · Advanced · [OAF-C-102 course](../bootcamp/courses/customizing/102/README.md) · 6 sections · 19 lectures

![Customizing step 2: Advanced](customizing-2.svg)

<details>
<summary>Topics as text</summary>

- **C102-005 Extension Architecture and Standards (Required)** (Difficulty ★★★)
  - Applying Extension Standards (Video, Core)
  - Choosing Extension Touchpoints (Video, Core)
  - Placing Custom Code (Video, Core)
  - Evaluating Extension Support and Upgrade Impact (Workshop, Core)
- **C102-002 Business Component Extensions (Required)** (Difficulty ★★★★)
  - Extending View Objects (Lab, Advanced)
  - Extending Entity Objects (Lab, Advanced)
  - Extending Application Modules (Lab, Advanced)
- **C102-001 Controller and LOV Extensions (Required)** (Difficulty ★★★★)
  - Extending Controllers (Lab, Advanced)
  - Extending LOVs Programmatically (Lab, Advanced)
- **C102-003 Substitution and Troubleshooting (Required)** (Difficulty ★★★★)
  - Understanding the Substitution Mechanism (Video, Advanced)
  - Deploying Substitutions (Lab, Advanced)
  - Troubleshooting Extensions (Lab, Advanced)
- **C102-004 Extension Packaging and R12.2 Synchronization (Required)** (Difficulty ★★★★)
  - Packaging Archives with adcgnjar (Lab, Advanced)
  - Packaging Extensions for Deployment (Lab, Advanced)
  - Synchronizing the R12.2 File Systems (Lab, Advanced)
- **C102-006 Release, Promotion and Assessment (Required)** (Difficulty ★★★★)
  - Using Import Tools (Lab, Advanced)
  - Registering Functions and Menus (Lab, Advanced)
  - Promoting Customizations Between Environments (Video, Advanced)
  - Completing the Extension Project (Workshop, Advanced)

</details>

<br>
