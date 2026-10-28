# Oracle OAF BootCamp: Course Outline

The full course in four tiers:

```
Level
 └─ Section
     └─ Module
         └─ Lecture
```

**Structure.** Each course has three kinds of module. **Core** modules are the seven per course from the reference curriculum (`B101-1` to `B101-7`, and so on). **Required** modules are repository content that the level's exit competencies or outcomes depend on, such as capstones, assessments, master-detail, debugging and deployment in Dev 101. **Extended** modules are optional depth. The required path is core plus required. Core modules are placed in each level to follow the reference curriculum, so a few lectures moved between levels (see below).

**Codes.** Modules use their reference IDs. Lectures read `<module id>.<lecture>`, for example `B101-4.3`. The *Syllabus* column gives the lecture's number in the `SYLLABUS_*.md` file for tracing; the syllabi keep their older section numbering and are the source for format, practice, resource and notes.

**Moves between levels.** The reference curriculum teaches PPR, LOVs, form (POST) processing, exceptions and dialog pages in Dev 102. Those six Dev 101 lectures now sit in Dev 102 core modules (B102-1 to B102-5): *Processing POST Requests: Form Submissions*, *Implementing Common Controller Patterns*, *Enabling Partial Page Rendering (PPR) for Dynamic UI*, *Implementing List of Values (LOV) for Data Selection*, *Understanding OAF Exception Framework & Hierarchy* and *Providing User Feedback: Messages & Dialog Pages*.

**Dev 103.** Its core is the production-readiness course (deployment, diagnostics, R12.2 patching). The POS capstone and the advanced enterprise topics are extended modules.

**Durations.** Module days are planned: a module's lectures divided by the level's pace in lectures a day (see Duration Check). Capstones given in weeks run alongside and carry no days. Lectures marked *(verify)* need confirming against Oracle 12.2 documentation before delivery.


## Summary

| Level | Course | Sections | Modules | Core | Required | Extended | Lectures | Formats |
| :-: | :-- | :-: | :-: | :-: | :-: | :-: | :-: | :-- |
| 101 | Dev 101: Oracle OAF Building BootCamp (Beginner) | 6 | 14 | 7 | 4 | 3 | 80 | Video 45, Lab 33, Workshop 2 |
| 102 | Dev 102: Oracle OAF Building BootCamp (Advanced) | 7 | 17 | 7 | 1 | 9 | 81 | Lab 71, Video 7, Workshop 3 |
| 103 | Dev 103: Oracle OAF Building BootCamp (Ninja) | 3 | 19 | 7 | 8 | 4 | 66 | Lab 49, Workshop 11, Video 6 |
| C101 | Cust 101: Oracle OAF Customizing BootCamp (Beginner) | 3 | 9 | 7 | 1 | 1 | 18 | Lab 12, Video 5, Workshop 1 |
| C102 | Cust 102: Oracle OAF Customizing BootCamp (Advanced) | 4 | 10 | 7 | 3 | 0 | 19 | Lab 12, Video 6, Workshop 1 |
| | **Total** | **23** | **69** | **35** | **17** | **17** | **264** | Lab 177, Video 69, Workshop 18 |

## Level Boundaries

What each level covers, what it deliberately leaves out, and what a learner can do on exit. A lecture belongs to the lowest level whose entry criteria it needs. Dev 102 and Dev 103 intentionally cover some of the same components at different depth: Dev 102 teaches how to build them, Dev 103 covers interactions, state and mastery. The in-scope and extended module lists, the counts and the lecture moves are computed from the structure above; the check row is computed from the rules listed under Boundary Check.

### 101: Dev 101: Oracle OAF Building BootCamp (Beginner)

| Aspect | Boundary |
| :-- | :-- |
| Purpose | Build and run a basic OAF application end to end: model, page, controller, deploy. |
| Audience | Junior developers, technical consultants, application analysts. Target role: Associate OAF Developer. |
| Entry criteria | Basic Java, SQL, PL/SQL and HTML. No OAF experience needed. |
| Entry check | Proposed check: writes a Java class with inheritance and exceptions; writes SQL joins and DML; reads a PL/SQL procedure; writes a basic HTML form. |
| In scope (core modules) | B101-1 OAF Architecture & MVC Paradigms; B101-2 IDE Setup & Project Topology; B101-3 Application Module Construction; B101-4 View Object Development; B101-5 Entity Object & DML Layer; B101-6 Declarative Page Layouts; B101-7 Controller Request Processing |
| Key artifacts (core) | J2EE MVC, Tier Separation, MDS Architecture; JDeveloper Setup, .jws/.jpr Specs, DBC Connections; OAApplicationModuleImpl, OADBTransaction, Root AM; OAViewObjectImpl, SQL Bind Variables, View Links; OAEntityImpl, Validation Logic, Primary Keys; Page Definitions (.xml), UIX Web Beans, Region Types; OAControllerImpl, processRequest(), OAPageContext |
| Required additions | B101-8 Master-Detail Relationships; B101-9 Debugging in JDeveloper; B101-12 Deploying OA Framework Applications; B101-13 Jobs & Positions Management Capstone |
| Extended content (optional) | B101-0 BootCamp Orientation & Success Path; B101-10 Security Implementation; B101-11 Development Standards and Best Practices |
| Outputs (learner produces) | Configured workspace, project and DBC connection with a running Hello World page; BC4J model: root application module, view objects, entity objects, view links; Declarative pages with a controller for the initial request; Master-detail pages; Application deployed to a training instance with function, menu and responsibility; Jobs & Positions application: DDL scripts, code, test plan and documentation |
| Outcomes (learner can do) | Cognitive level: Remember, Understand, Apply. 6 syllabus outcomes, 6 reached on the required path. |
| Hands-on deliverable | Jobs & Positions master-detail application (100-point rubric). |
| Out of scope (belongs elsewhere) | Programmatic view objects and programmatic beans, PPR, LOVs, the exception framework and dialog pages (Dev 102); command-line deployment, adop and packaging (Dev 103); personalization and extensions (Cust 101, Cust 102). |
| Exit criteria | Learner builds a master-detail CRUD application on BC4J, runs it locally and deploys it to a training instance. Master-detail, debugging, deployment and the capstone are required modules, so the exit is reachable on the required path. |
| Scaffolding and length | 60% guidance. 28-32 days for the required path (core, required modules and the capstone alongside); extended modules are optional and add to this. |
| Size | 80 lectures in 14 modules; required path 59 lectures, 31.1 days at 1.9 lectures a day; extended 15 lectures, 7.9 days |
| Focus mix | Model 14, View 16, Controller 7, Integration 0, Security 4, Other 39 |
| Lectures moved in | none |
| Lectures moved out | Processing POST Requests: Form Submissions, Implementing Common Controller Patterns, Enabling Partial Page Rendering (PPR) for Dynamic UI, Implementing List of Values (LOV) for Data Selection, Understanding OAF Exception Framework & Hierarchy, Providing User Feedback: Messages & Dialog Pages, Developing Programmatic View Objects Dynamically, Implementing Personalizations in OAF, Creating Extensions for Oracle Pages |
| Boundary check | Pass: no out-of-scope topics found |
| Next step | Dev 102 for interactive pages, or Cust 101 for declarative personalization. |

### 102: Dev 102: Oracle OAF Building BootCamp (Advanced)

| Aspect | Boundary |
| :-- | :-- |
| Purpose | Handle user events and build interactive pages: form processing, PPR, LOVs, messages, tables and dynamic UI. |
| Audience | Application developers, technical lead consultants. Target role: Professional OAF Developer. |
| Entry criteria | Dev 101 complete: can build and deploy a CRUD application. |
| Entry check | Proposed check: explains MVC; builds a view object, entity object and application module; deploys a simple page (the Dev 101 exit). |
| In scope (core modules) | B102-1 Form Event Handling Lifecycle; B102-2 Asynchronous UI via PPR; B102-3 List of Values (LOV) Engineering; B102-4 Enterprise Exception Framework; B102-5 Modal Dialogs & Page Navigation; B102-6 Advanced Table Operations; B102-7 Dynamic UI Control & Focus |
| Key artifacts (core) | processFormRequest(), Event Source Identification; Partial Page Rendering, Target Controls, Event Loops; LOV Input Beans, Dependent LOVs, Dynamic Mapping; OAException, Severity Levels, Inline Message Boxes; OADialogPage, putDialogMessage(), Page Forwards; OAAdvancedTableBean, Row Iterators, Dynamic CRUD; OABodyBean, setInitialFocusId(), Property Overrides |
| Required additions | B102-17 Projects and Final Assessment |
| Extended content (optional) | B102-8 Advanced Model and Server-Side Features; B102-9 Layout and Container Regions; B102-10 Data Regions, Grids and Charts; B102-11 Wizards, Rich Inputs and Configurable Pages; B102-12 Flexfields, SPEL and Forms Integration; B102-13 Client-Side Scripting and Page Modes; B102-14 Data Formatting and Validation; B102-15 Advanced Features and Integrations; B102-16 Advanced Debugging |
| Outputs (learner produces) | Pages with form event handling, PPR and LOVs; Message and dialog flows using OAException and OADialogPage; Advanced table page with dynamic row create and delete; Dynamic UI that changes bean state at runtime; Project 102: items with an approval cycle, and the final assessment application (HR system or Procurement) with documentation |
| Outcomes (learner can do) | Cognitive level: Apply, Analyze, Evaluate. 14 syllabus outcomes, 7 reached on the required path. |
| Hands-on deliverable | Items with an approval cycle (Project 102) and a final assessment project (HR system or Procurement). |
| Out of scope (belongs elsewhere) | Deployment tooling, adop, logging infrastructure and production readiness (Dev 103); REST services and security hardening (Dev 103 extended); personalization and extensions (Cust 101, Cust 102). |
| Exit criteria | Learner delivers an application with events, PPR, LOVs, exception handling and advanced tables. |
| Scaffolding and length | 40% guidance. 20-25 days for the required path; extended modules are optional and add to this. |
| Size | 81 lectures in 17 modules; required path 28 lectures, 21.5 days at 1.3 lectures a day; extended 53 lectures, 40.8 days |
| Focus mix | Model 8, View 34, Controller 18, Integration 10, Security 0, Other 11 |
| Lectures moved in | B102-1.1 Processing POST Requests: Form Submissions, B102-1.2 Implementing Common Controller Patterns, B102-2.1 Enabling Partial Page Rendering (PPR) for Dynamic UI, B102-3.1 Implementing List of Values (LOV) for Data Selection, B102-4.1 Understanding OAF Exception Framework & Hierarchy, B102-5.1 Providing User Feedback: Messages & Dialog Pages, B102-8.1 Developing Programmatic View Objects Dynamically |
| Lectures moved out | none |
| Boundary check | Pass: no out-of-scope topics found |
| Next step | Dev 103 for production readiness, or Cust 102 after Cust 101. |

### 103: Dev 103: Oracle OAF Building BootCamp (Ninja)

| Aspect | Boundary |
| :-- | :-- |
| Purpose | Take an application to production: deploy to MDS, register in EBS, instrument, patch on R12.2 and package. |
| Audience | Senior technical consultants, OAF architects. Target role: Master OAF Developer. |
| Entry criteria | Dev 102 complete: can build an interactive application. |
| Entry check | Proposed check: builds a page with form processing, PPR and an LOV; handles exceptions with the OAF framework (the Dev 102 exit). |
| In scope (core modules) | B103-1 MDS Repository Deployment; B103-2 BC4J Configuration Upload; B103-3 AOL Security & Page Registration; B103-4 Enterprise Instrumentation; B103-5 Log Management & Maintenance; B103-6 EBS R12.2 Online Patching; B103-7 Automated Packaging & Scripting |
| Key artifacts (core) | XMLImporter, Database Connections, $JAVA_TOP; JPXImporter, .jpx Project Files, Classpath Specs; Form Functions, Menus, Responsibilities, SSWA Parameters; FND_LOG, writeDiagnostics(), FND_LOG_MESSAGES; FNDLGPRG Concurrent Program, FND_LOG_ADMIN Package; adop Cycle, Dual File Systems, Patch Synchronization; adcgnjar, customall.jar, $AD_APPS_JDBC_URL |
| Required additions | B103-8 Project Setup and Planning; B103-9 Store Management Module; B103-10 Product Management Module; B103-11 Branch Management (Master-Detail); B103-12 Sales and Transactions Module; B103-13 Advanced Features and Polish; B103-14 Deployment and Presentation; B103-15 Final Assessment |
| Extended content (optional) | B103-16 Advanced Tables, Grids and Visualization; B103-17 Advanced Search and Navigation; B103-18 State Management, Back Button and Security; B103-19 REST and Product Integration |
| Outputs (learner produces) | Pages deployed to MDS with XMLImporter and BC4J configuration registered with JPXImporter; Registered form functions, menus and responsibilities; Instrumented application and a log purge schedule; Signed customall.jar and a scripted deployment using environment variables; POS system (stores, products, branches, sales) with deployment package, documentation and presentation |
| Outcomes (learner can do) | Cognitive level: Evaluate, Create. 7 syllabus outcomes, 5 reached on the required path. |
| Hands-on deliverable | POS capstone with an 85% Ninja gate; scripted deployment of the capstone on R12.2. |
| Out of scope (belongs elsewhere) | Customizing seeded Oracle pages through personalization or extension (Cust 101, Cust 102). |
| Exit criteria | Learner deploys and operates an application on R12.2 with scripted, repeatable packaging and diagnostics. |
| Scaffolding and length | 20% guidance. 20-30 days for the required path (production-readiness core plus the POS capstone); the advanced topics are optional. |
| Size | 66 lectures in 19 modules; required path 40 lectures, 26.7 days at 1.5 lectures a day; extended 26 lectures, 17.3 days |
| Focus mix | Model 2, View 12, Controller 4, Integration 6, Security 4, Other 38 |
| Lectures moved in | none |
| Lectures moved out | none |
| Boundary check | Pass: no out-of-scope topics found |
| Next step | Cust 102 (requires the Dev 103 core), or lead delivery projects. |

### C101: Cust 101: Oracle OAF Customizing BootCamp (Beginner)

| Aspect | Boundary |
| :-- | :-- |
| Purpose | Tailor seeded pages declaratively without changing code, and keep changes upgrade-safe. |
| Audience | EBS administrators, functional and technical consultants. Target role: Certified Personalization Specialist. |
| Entry criteria | Dev 101 and EBS system administration. |
| Entry check | Proposed check: navigates EBS responsibilities and profile options; uses the Dev 101 vocabulary (page, region, item, attribute set). |
| In scope (core modules) | C101-1 Upgrade Preservation Principles; C101-2 Personalization Hierarchy; C101-3 Functional Administrator Tool; C101-4 UI Component Personalization; C101-5 Declarative Region Injections; C101-6 Personalization Migration; C101-7 LOV Declarative Alteration |
| Key artifacts (core) | Personalization Layering, MDS Repository, Maintenance; Site, Application, Responsibility, and User Levels; Administer Personalizations UI, MDS Cache Invalidation; Visual Attributes, Rendered Flags, Read-Only Enforcement; Stack Layouts, Buttons, Static Region Extensions; XMLExporter, XMLImporter, Customization XML Files; LOV Region Personalization, Where Clause Overrides |
| Required additions | C101-9 Cust 101 Assessment |
| Extended content (optional) | C101-8 Diagnostics and Translation |
| Outputs (learner produces) | Personalizations at two or more levels on a seeded page; Region injection and LOV personalization; Exported personalization package imported into a second environment; Change log and back-out notes |
| Outcomes (learner can do) | Cognitive level: Understand, Apply (proposed). 4 syllabus outcomes, 4 reached on the required path. |
| Hands-on deliverable | Personalization project: two levels, promoted with XMLExporter and XMLImporter (proposed criteria). |
| Out of scope (belongs elsewhere) | Any Java extension, BC4J substitution or JPX registration (Cust 102); building new pages (Dev 101 to 103). |
| Exit criteria | Learner personalizes a seeded page at two levels, explains the precedence result and migrates the change between environments. |
| Scaffolding and length | 60% guidance. 10-15 days (proposed). |
| Size | 18 lectures in 9 modules; required path 16 lectures, 12.3 days at 1.3 lectures a day; extended 2 lectures, 1.5 days |
| Focus mix | Model 0, View 5, Controller 0, Integration 0, Security 0, Other 13 |
| Lectures moved in | C101-1.4 Implementing Personalizations in OAF |
| Lectures moved out | none |
| Boundary check | Pass: no out-of-scope topics found |
| Next step | Cust 102 for programmatic extensions. |

### C102: Cust 102: Oracle OAF Customizing BootCamp (Advanced)

| Aspect | Boundary |
| :-- | :-- |
| Purpose | Extend seeded behaviour in code: controller and BC4J extensions, substitution, packaging and R12.2 synchronization. |
| Audience | Senior customization engineers, solution architects. Target role: Master Customization Architect. |
| Entry criteria | Dev 102, Cust 101, the Dev 103 production-readiness core (B103-1 to B103-7) and advanced Java. |
| Entry check | Proposed check: subclasses Java classes, reads stack traces, uses JDeveloper; has completed the Dev 103 core (B103-1 to B103-7). |
| In scope (core modules) | C102-1 Controller Class Extensions; C102-2 Business Component Extensions; C102-6 Programmatic LOV Extensions; C102-3 BC4J Substitution Registration; C102-4 Archive Packaging & Utilities; C102-5 R12.2 Filesystem Synchronization; C102-7 Extension Troubleshooting |
| Key artifacts (core) | OAControllerImpl Subclassing, super Calls, Events; View Object Extensions, Entity Object Inheritance; LOV Controller Extensions, VO Substitution Integration; JPX Substitution Files, JPXImporter, Repository Rules; $AD_TOP/bin/adcgnjar, customall.jar, Manifest Files; adop Cycle, Dual File Systems, adop_sync_drv.tmp; MDS Cache Invalidation, Classloader Tracing, JPX Audits |
| Required additions | C102-8 Extension Architecture and Standards; C102-9 Release and Environment Promotion; C102-10 Cust 102 Assessment |
| Extended content (optional) | none |
| Outputs (learner produces) | Extended controller class; Extended view, entity and application module objects; JPX substitution file registered with JPXImporter; Signed customall.jar and adop sync driver entries; Troubleshooting log for a seeded failure |
| Outcomes (learner can do) | Cognitive level: Apply, Analyze (proposed). 4 syllabus outcomes, 4 reached on the required path. |
| Hands-on deliverable | Extension project: substitution plus extended controller, packaged and deployed on R12.2 (proposed criteria). |
| Out of scope (belongs elsewhere) | Declarative personalization (Cust 101); building new applications from scratch (Dev 101 to 103); generic deployment tooling beyond the extension-specific steps (Dev 103). |
| Exit criteria | Learner extends a seeded page without touching base code, packages and deploys it on R12.2, and diagnoses a failure. |
| Scaffolding and length | 40% guidance. 10-15 days (proposed). |
| Size | 19 lectures in 10 modules; required path 19 lectures, 12.7 days at 1.5 lectures a day; extended 0 lectures, 0 days |
| Focus mix | Model 5, View 0, Controller 2, Integration 0, Security 0, Other 12 |
| Lectures moved in | C102-8.4 Creating Extensions for Oracle Pages |
| Lectures moved out | none |
| Boundary check | Pass: no out-of-scope topics found |
| Next step | Lead customization projects; no further course. |

### Exit Criteria Traceability

Which modules deliver each exit competency, and whether the learner reaches it on the required path. *Required path* means every delivering module is core or required. *Extended only* means every delivering module is optional. *Required and extended* means the competency needs both.

| Level | Exit competency | Delivered by | Path |
| :-: | :-- | :-- | :-: |
| 101 | Build a BC4J model (application module, view objects, entity objects) | B101-3, B101-4, B101-5 | Required path |
| 101 | Build declarative pages and a controller for the initial request | B101-6, B101-7 | Required path |
| 101 | Build a master-detail CRUD application | B101-8 | Required path |
| 101 | Run locally and deploy to a training instance | B101-2, B101-12 | Required path |
| 101 | Pass the Jobs & Positions capstone | B101-13 | Required path |
| 102 | Process form events | B102-1 | Required path |
| 102 | Update regions with PPR | B102-2 | Required path |
| 102 | Build LOVs and dependent LOVs | B102-3 | Required path |
| 102 | Handle exceptions and dialog pages | B102-4, B102-5 | Required path |
| 102 | Build advanced tables with dynamic CRUD | B102-6 | Required path |
| 102 | Change bean state dynamically | B102-7 | Required path |
| 102 | Pass the final assessment | B102-17 | Required path |
| 103 | Deploy pages to MDS from the command line | B103-1, B103-2 | Required path |
| 103 | Register pages in EBS | B103-3 | Required path |
| 103 | Instrument and maintain diagnostics | B103-4, B103-5 | Required path |
| 103 | Patch and package on R12.2 | B103-6, B103-7 | Required path |
| 103 | Pass the POS capstone (85% gate) | B103-8, B103-9, B103-10, B103-11, B103-12, B103-13, B103-14, B103-15 | Required path |
| C101 | Personalize a page at more than one level | C101-2, C101-4 | Required path |
| C101 | Explain the precedence result | C101-2 | Required path |
| C101 | Migrate personalizations between environments | C101-6 | Required path |
| C101 | Pass the personalization project | C101-9 | Required path |
| C102 | Extend a controller | C102-1 | Required path |
| C102 | Extend and substitute business components | C102-2, C102-3 | Required path |
| C102 | Package and deploy on R12.2 | C102-4, C102-5 | Required path |
| C102 | Diagnose an extension failure | C102-7 | Required path |
| C102 | Pass the extension project | C102-10 | Required path |

26 of 26 exit competencies are reached on the required path.

### Prerequisite Chain

Each level's entry criteria against what the course delivers. A prerequisite marked *external* is not taught here and needs a placement check.

| Level | Requires | Satisfied by | Status |
| :-: | :-- | :-- | :-: |
| 101 | Basic Java, SQL, PL/SQL, HTML | Not taught in this course | External |
| 102 | Dev 101 exit competencies | Dev 101 modules B101-1 to B101-8 | Covered |
| 103 | Dev 102 exit competencies | Dev 102 core modules B102-1 to B102-7 | Covered |
| C101 | Dev 101 | Dev 101 core modules B101-1 to B101-7 | Covered |
| C101 | EBS system administration | Not taught in this course | External |
| C102 | Dev 102 | Dev 102 core modules B102-1 to B102-7 | Covered |
| C102 | Cust 101 | C101-1 to C101-7 | Covered |
| C102 | Dev 103 production-readiness core | B103-1 to B103-7 | Covered |
| C102 | Advanced Java | Not taught in this course | External |

### Where Excluded Topics Are Taught

Each topic a level leaves out, and the module that teaches it.

| Topic | Left out of | Taught in |
| :-- | :-: | :-- |
| Form event processing | 101 | B102-1 Form Event Handling Lifecycle |
| Partial page rendering | 101 | B102-2 Asynchronous UI via PPR |
| LOV engineering | 101 | B102-3 List of Values (LOV) Engineering |
| Exception framework and dialog pages | 101 | B102-4 Enterprise Exception Framework, B102-5 Modal Dialogs & Page Navigation |
| Programmatic view objects and beans | 101 | B102-8 Advanced Model and Server-Side Features, B102-7 Dynamic UI Control & Focus |
| Command-line deployment and importers | 101, 102 | B103-1 MDS Repository Deployment, B103-2 BC4J Configuration Upload |
| adop and packaging | 101, 102 | B103-6 EBS R12.2 Online Patching, B103-7 Automated Packaging & Scripting |
| Logging and diagnostics infrastructure | 102 | B103-4 Enterprise Instrumentation, B103-5 Log Management & Maintenance |
| REST services and security hardening | 102 | B103-19 REST and Product Integration, B103-18 State Management, Back Button and Security |
| Personalization | 101, 102, 103, C102 | C101-4 UI Component Personalization, C101-2 Personalization Hierarchy |
| Controller and BC4J extensions | 101, 102, 103, C101 | C102-1 Controller Class Extensions, C102-2 Business Component Extensions |
| Building a full application | C101, C102 | B101-13 Jobs & Positions Management Capstone, B103-9 Store Management Module |

### Outputs

What a learner produces at each level, where it is produced and how it is assessed. Grading weights come from the syllabi and project specifications; Customizing criteria are proposals.

| Level | Output | Produced in | Assessed by |
| :-: | :-- | :-- | :-- |
| 101 | Configured workspace, project and DBC connection with a running Hello World page | B101-2 | Page runs locally |
| 101 | BC4J model: root application module, view objects, entity objects, view links | B101-3, B101-4, B101-5 | BC4J tester |
| 101 | Declarative pages with a controller for the initial request | B101-6, B101-7 | Pages render with data |
| 101 | Master-detail pages | B101-8 | Master-detail labs |
| 101 | Application deployed to a training instance with function, menu and responsibility | B101-12 | Post-deployment checklist |
| 101 | Jobs & Positions application: DDL scripts, code, test plan and documentation | B101-13 | 100-point capstone rubric: functionality 40, code quality 30, UI 20, documentation 10 |
| 102 | Pages with form event handling, PPR and LOVs | B102-1, B102-2, B102-3 | Labs |
| 102 | Message and dialog flows using OAException and OADialogPage | B102-4, B102-5 | Labs |
| 102 | Advanced table page with dynamic row create and delete | B102-6 | Labs |
| 102 | Dynamic UI that changes bean state at runtime | B102-7 | Labs |
| 102 | Project 102: items with an approval cycle, and the final assessment application (HR system or Procurement) with documentation | B102-17 | Project requirements and the assessment criteria and deliverables lecture |
| 103 | Pages deployed to MDS with XMLImporter and BC4J configuration registered with JPXImporter | B103-1, B103-2 | Verified in the repository |
| 103 | Registered form functions, menus and responsibilities | B103-3 | Access test |
| 103 | Instrumented application and a log purge schedule | B103-4, B103-5 | Log output |
| 103 | Signed customall.jar and a scripted deployment using environment variables | B103-6, B103-7 | Repeatable run on R12.2 |
| 103 | POS system (stores, products, branches, sales) with deployment package, documentation and presentation | B103-8, B103-9, B103-10, B103-11, B103-12, B103-13, B103-14, B103-15 | Ninja gate: functional 30, code quality 25, architecture 20, deliverables 15, innovation 10; pass at 85% |
| C101 | Personalizations at two or more levels on a seeded page | C101-2, C101-4 | Personalization project (proposed criteria) |
| C101 | Region injection and LOV personalization | C101-5, C101-7 | Personalization project (proposed criteria) |
| C101 | Exported personalization package imported into a second environment | C101-6 | Migration check |
| C101 | Change log and back-out notes | C101-9 | Proposed criteria: documentation 15 |
| C102 | Extended controller class | C102-1 | Extension project (proposed criteria) |
| C102 | Extended view, entity and application module objects | C102-2 | Extension project (proposed criteria) |
| C102 | JPX substitution file registered with JPXImporter | C102-3 | Extension project (proposed criteria) |
| C102 | Signed customall.jar and adop sync driver entries | C102-4, C102-5 | Extension project (proposed criteria) |
| C102 | Troubleshooting log for a seeded failure | C102-7 | Proposed criteria: troubleshooting log 10 |

### Outcomes

The learning outcomes in each syllabus, the modules that deliver them, and whether a learner reaches them on the required path. The required path is core plus required modules.

| Level | Cognitive level | Outcome | Delivered by | Path |
| :-: | :-- | :-- | :-- | :-: |
| 101 | Remember, Understand, Apply | Set up and configure OAF development environment | B101-2 | Required path |
| 101 |  | Create basic OAF pages using Model-View-Controller pattern | B101-1, B101-6, B101-7 | Required path |
| 101 |  | Implement standard web widgets and UI components | B101-6 | Required path |
| 101 |  | Build CRUD (Create, Read, Update, Delete) functionality | B101-4, B101-5, B101-7 | Required path |
| 101 |  | Deploy OAF applications to Oracle E-Business Suite | B101-12 | Required path |
| 101 |  | Debug and test basic OAF applications | B101-9 | Required path |
| 102 | Apply, Analyze, Evaluate | LO2.1: Intercept user interactions and execute post-back processing with processFormRequest | B102-1 | Required path |
| 102 |  | LO2.2: Update specific page regions with partial page rendering | B102-2 | Required path |
| 102 |  | LO2.3: Build lists of values, including dependent LOVs | B102-3 | Required path |
| 102 |  | LO2.4: Implement exception handling and user messaging | B102-4 | Required path |
| 102 |  | LO2.5: Manage confirmation workflows with dialog pages | B102-5 | Required path |
| 102 |  | LO2.6: Build advanced tables with inline record creation and deletion | B102-6 | Required path |
| 102 |  | LO2.7: Change web bean state dynamically during the page lifecycle | B102-7 | Required path |
| 102 |  | LO2.8: Create dynamic View Objects programmatically | B102-8 | Extended only |
| 102 |  | LO2.9: Execute SQL statements and call PL/SQL procedures from OAF | B102-8 | Extended only |
| 102 |  | LO2.10: Implement advanced UI components (HGrid, Train, Shuttle, etc.) | B102-10, B102-11 | Extended only |
| 102 |  | LO2.11: Integrate Flexfields (Key and Descriptive) in OAF pages | B102-12 | Extended only |
| 102 |  | LO2.12: Implement file upload/download and data import/export | B102-15 | Extended only |
| 102 |  | LO2.13: Build workflow-enabled OAF applications | B102-15 | Extended only |
| 102 |  | LO2.14: Implement advanced debugging techniques | B102-16 | Extended only |
| 103 | Evaluate, Create | LO3.1: Design and architect complete enterprise applications | B103-8 | Required path |
| 103 |  | LO3.2: Build production-ready OAF systems from scratch | B103-9, B103-10, B103-11, B103-12 | Required path |
| 103 |  | LO3.3: Implement complex business logic and workflows | B103-12, B103-19 | Required and extended |
| 103 |  | LO3.4: Apply advanced design patterns and best practices | B103-13 | Required path |
| 103 |  | LO3.5: Optimize performance of large-scale applications | B103-13, B103-18 | Required and extended |
| 103 |  | LO3.6: Lead OAF development projects | B103-14, B103-15 | Required path |
| 103 |  | LO3.7: Mentor junior developers | B103-14 | Required path |
| C101 | Understand, Apply (proposed) | LOC1.1: Explain personalization, extension and modification, and when to use each | C101-1 | Required path |
| C101 |  | LOC1.2: Describe how personalizations are stored in the MDS repository | C101-1 | Required path |
| C101 |  | LOC1.3: Create and manage personalizations at every level | C101-2, C101-3, C101-4, C101-5, C101-7 | Required path |
| C101 |  | LOC1.4: Inspect, export, import and delete MDS content | C101-6 | Required path |
| C102 | Apply, Analyze (proposed) | LOC2.1: Apply extension standards and place custom code correctly | C102-8 | Required path |
| C102 |  | LOC2.2: Extend view, entity and application module objects | C102-2 | Required path |
| C102 |  | LOC2.3: Deploy substitutions and extended controllers | C102-3, C102-1 | Required path |
| C102 |  | LOC2.4: Package, deploy and promote customizations across environments | C102-4, C102-5, C102-9 | Required path |

26 of 35 syllabus outcomes are reached on the required path, 9 depend on extended modules and 0 has no module. The Dev 102 outcomes are now split into core outcomes (events, PPR, LOVs, messages, dialogs, tables, dynamic UI), which the core modules deliver, and extended outcomes, which optional modules deliver.

### Core Module Outcomes

The learning outcome of each core module, from the reference curriculum. These are what every learner reaches on the core path.

| Level | Module | Title | Learning outcome |
| :-: | :-- | :-- | :-- |
| 101 | B101-1 | OAF Architecture & MVC Paradigms | Analyze the execution flow across Model, View, and Controller layers. |
| 101 | B101-2 | IDE Setup & Project Topology | Configure standardized local development environments linked to EBS. |
| 101 | B101-3 | Application Module Construction | Construct transactional containers for BC4J component management. |
| 101 | B101-4 | View Object Development | Develop declarative and dynamic data query components for UI rendering. |
| 101 | B101-5 | Entity Object & DML Layer | Build persistent data access objects that enforce business constraints. |
| 101 | B101-6 | Declarative Page Layouts | Construct structured UI hierarchies using standard JRAD components. |
| 101 | B101-7 | Controller Request Processing | Implement controller logic for initial page rendering and query setup. |
| 102 | B102-1 | Form Event Handling Lifecycle | Intercept user interactions and execute complex post-back processing. |
| 102 | B102-2 | Asynchronous UI via PPR | Eliminate full page refreshes by updating specific UI regions. |
| 102 | B102-3 | List of Values (LOV) Engineering | Build interactive selection dialogs and cascading field pickers. |
| 102 | B102-4 | Enterprise Exception Framework | Implement standard exception handling and user messaging. |
| 102 | B102-5 | Modal Dialogs & Page Navigation | Manage confirmation workflows using system dialog pages. |
| 102 | B102-6 | Advanced Table Operations | Implement tabular data grids with inline record creation and deletion. |
| 102 | B102-7 | Dynamic UI Control & Focus | Dynamically modify web bean states during page lifecycle execution. |
| 103 | B103-1 | MDS Repository Deployment | Deploy XML page definitions directly to the MDS database repository. |
| 103 | B103-2 | BC4J Configuration Upload | Register global business component configurations in the repository. |
| 103 | B103-3 | AOL Security & Page Registration | Secure custom OAF pages within standard Oracle EBS menu structures. |
| 103 | B103-4 | Enterprise Instrumentation | Implement real-time system diagnostics and performance tracing. |
| 103 | B103-5 | Log Management & Maintenance | Automate log purging and manage diagnostic table storage. |
| 103 | B103-6 | EBS R12.2 Online Patching | Align application deployments with Oracle R12.2 patching rules. |
| 103 | B103-7 | Automated Packaging & Scripting | Build repeatable deployment scripts using dynamic environment variables. |
| C101 | C101-1 | Upgrade Preservation Principles | Implement UI changes while preserving system upgrade paths. |
| C101 | C101-2 | Personalization Hierarchy | Target declarative personalizations to specific user contexts. |
| C101 | C101-3 | Functional Administrator Tool | Execute real-time UI modifications and administer MDS memory. |
| C101 | C101-4 | UI Component Personalization | Modify default properties of standard Oracle interface controls. |
| C101 | C101-5 | Declarative Region Injections | Inject supplementary UI elements into standard Oracle pages. |
| C101 | C101-6 | Personalization Migration | Migrate personalization packages between EBS database instances. |
| C101 | C101-7 | LOV Declarative Alteration | Restrict data selection queries in seeded search dialogs declaratively. |
| C102 | C102-1 | Controller Class Extensions | Inject custom event handling into standard Oracle page flows. |
| C102 | C102-2 | Business Component Extensions | Extend seeded SQL queries and table validation logic safely. |
| C102 | C102-6 | Programmatic LOV Extensions | Implement custom business logic inside standard selection dialogs. |
| C102 | C102-3 | BC4J Substitution Registration | Substitute standard business components globally at runtime. |
| C102 | C102-4 | Archive Packaging & Utilities | Package custom Java code into signed, enterprise-ready JAR archives. |
| C102 | C102-5 | R12.2 Filesystem Synchronization | Synchronize custom class extensions across dual EBS file systems. |
| C102 | C102-7 | Extension Troubleshooting | Identify and resolve runtime class conflicts and substitution errors. |

### Placement Checks

The external prerequisites need a check at enrolment. These are specifications; the exercises are not yet written.

| Level | Prerequisite | Check | Pass | If not met |
| :-: | :-- | :-- | :-: | :-- |
| 101 | Basic Java, SQL, PL/SQL, HTML | Written exercise, 60 minutes: extend a Java class and handle an exception; write a join and an insert in SQL; read a PL/SQL procedure and state what it returns; write an HTML form with three inputs | 70% or higher | Java, SQL and HTML refresher before day 1 |
| C101 | EBS system administration | Practical in a training instance, 30 minutes: switch responsibility, set a profile option at two levels, find a function on a menu | All three tasks | EBS administration primer before Cust 101 |
| C102 | Advanced Java | Practical, 60 minutes: subclass a class, override a method and call super, read a stack trace and find the failing line, explain classpath and classloader order | 70% or higher | Advanced Java refresher before Cust 102 |

### Review Status

Which boundary decisions are proposals and who should confirm them. Nothing in this section has been reviewed by an instructor or subject-matter expert.

| Decision | Reviewer needed | Status |
| :-- | :-- | :-- |
| Scope lines and out-of-scope lists | Course owner | Proposed, not reviewed |
| Entry checks for all five levels | Instructor | Proposed, not reviewed |
| Required-path module promotions | Course owner | Proposed, not reviewed |
| Planned days and pace per level (the Dev 103 pace is assumed) | Instructor | Proposed, not reviewed |
| Dev 101 length restated to 28-32 days | Course owner | Proposed |
| Outputs and outcome-to-module mapping | Instructor | Proposed, not reviewed |
| Cust 101 and Cust 102 durations, assessment criteria and the Cust 102 prerequisite | Subject-matter expert | Proposed, not reviewed |
| Placement checks | Instructor | Specified, not yet written |

## Scaffolding

Support is highest at the start and fades as competence grows: across levels, and within each level from its first module to its last.

**Model.** Every module follows I Do, We Do, You Do. *I Do* is instructor modeling (Video lectures). *We Do* is guided practice with checkpoints (Lab lectures). *You Do* is independent practice (Labs with optional hints, and Workshops).

**Scaffold types.** Procedural scaffolds (templates, checklists, step-by-step guides) fade by Dev 103. Conceptual scaffolds (diagrams, references) stay throughout. Strategic scaffolds (problem-solving and debugging frameworks) are taught, then internalized. Metacognitive scaffolds (reflection prompts, self-monitoring) shift responsibility to the learner over time.

**Source of the percentages.** The syllabi and the instructor guide set guidance at 60% (Dev 101), 40% (Dev 102) and 20% (Dev 103), with the Customizing courses at 60% and 40%. [LABS.md](LABS.md) describes it differently (60% for early Dev 101, 40% for late Dev 101, 20% for Dev 102 and 103), so it needs updating to match.

### Scaffold by Level

| Level | Guided | Independent | Support level | What the learner receives | Help model | Solutions | Assessment mode |
| :-: | :-: | :-: | :-: | :-- | :-- | :-- | :-- |
| 101 | 60% | 40% | Maximum | Detailed step-by-step instructions; code templates provided; frequent checkpoints | Immediate instructor help | Solution code provided after an attempt | Guided labs and a scaffolded project |
| 102 | 40% | 60% | Moderate | High-level instructions; partial templates; milestone checkpoints | Self-service help resources | Solution code provided after completion | Semi-independent labs and a project |
| 103 | 20% | 80% | Minimal | Requirements only; architecture guidance only; major milestone reviews | On-demand consultation | No solution code (real-world simulation) | Autonomous capstone project |
| C101 | 60% | 40% | Maximum | Step-by-step walkthroughs on a seeded page; checklists for each personalization level | Immediate instructor help | Worked solution after an attempt | Guided personalization project |
| C102 | 40% | 60% | Moderate | High-level instructions; partial extension templates; milestone checkpoints | Self-service help resources | Solution code after completion | Semi-independent extension project |

### Planned Fade Within Each Level

Guidance steps down linearly from the first module to the last, ten points above the level target at the start and ten below at the end, so the average equals the level target. The format columns count each module's lectures: Video for I Do, Lab for We Do and You Do, Workshop for You Do.

#### 101: Dev 101: Oracle OAF Building BootCamp (Beginner)

| Module | Title | Type | Video (I Do) | Lab (We Do, You Do) | Workshop (You Do) | Planned guidance |
| :-- | :-- | :-: | :-: | :-: | :-: | :-: |
| B101-0 | BootCamp Orientation & Success Path | Extended | 3 | 0 | 1 | 70% |
| B101-1 | OAF Architecture & MVC Paradigms | Core | 7 | 0 | 0 | 68% |
| B101-2 | IDE Setup & Project Topology | Core | 7 | 3 | 0 | 67% |
| B101-3 | Application Module Construction | Core | 3 | 2 | 0 | 65% |
| B101-4 | View Object Development | Core | 2 | 3 | 0 | 64% |
| B101-5 | Entity Object & DML Layer | Core | 1 | 2 | 0 | 62% |
| B101-8 | Master-Detail Relationships | Required | 1 | 1 | 0 | 61% |
| B101-6 | Declarative Page Layouts | Core | 6 | 8 | 0 | 59% |
| B101-7 | Controller Request Processing | Core | 4 | 3 | 0 | 58% |
| B101-9 | Debugging in JDeveloper | Required | 1 | 1 | 0 | 56% |
| B101-10 | Security Implementation | Extended | 3 | 1 | 0 | 55% |
| B101-11 | Development Standards and Best Practices | Extended | 6 | 1 | 0 | 53% |
| B101-12 | Deploying OA Framework Applications | Required | 1 | 3 | 0 | 52% |
| B101-13 | Jobs & Positions Management Capstone | Required | 0 | 5 | 1 | 50% |
| | **Level total** | | **45** (56%) | **33** (41%) | **2** (2%) | **60% average** |

#### 102: Dev 102: Oracle OAF Building BootCamp (Advanced)

| Module | Title | Type | Video (I Do) | Lab (We Do, You Do) | Workshop (You Do) | Planned guidance |
| :-- | :-- | :-: | :-: | :-: | :-: | :-: |
| B102-1 | Form Event Handling Lifecycle | Core | 2 | 0 | 0 | 50% |
| B102-2 | Asynchronous UI via PPR | Core | 0 | 2 | 0 | 49% |
| B102-3 | List of Values (LOV) Engineering | Core | 0 | 4 | 0 | 48% |
| B102-4 | Enterprise Exception Framework | Core | 1 | 2 | 0 | 46% |
| B102-5 | Modal Dialogs & Page Navigation | Core | 1 | 1 | 0 | 45% |
| B102-6 | Advanced Table Operations | Core | 0 | 3 | 0 | 44% |
| B102-7 | Dynamic UI Control & Focus | Core | 0 | 6 | 0 | 42% |
| B102-8 | Advanced Model and Server-Side Features | Extended | 1 | 5 | 0 | 41% |
| B102-9 | Layout and Container Regions | Extended | 0 | 6 | 0 | 40% |
| B102-10 | Data Regions, Grids and Charts | Extended | 0 | 5 | 0 | 39% |
| B102-11 | Wizards, Rich Inputs and Configurable Pages | Extended | 0 | 5 | 0 | 38% |
| B102-12 | Flexfields, SPEL and Forms Integration | Extended | 0 | 6 | 0 | 36% |
| B102-13 | Client-Side Scripting and Page Modes | Extended | 0 | 2 | 0 | 35% |
| B102-14 | Data Formatting and Validation | Extended | 0 | 4 | 0 | 34% |
| B102-15 | Advanced Features and Integrations | Extended | 2 | 14 | 0 | 32% |
| B102-16 | Advanced Debugging | Extended | 0 | 3 | 0 | 31% |
| B102-17 | Projects and Final Assessment | Required | 0 | 3 | 3 | 30% |
| | **Level total** | | **7** (9%) | **71** (88%) | **3** (4%) | **40% average** |

#### 103: Dev 103: Oracle OAF Building BootCamp (Ninja)

| Module | Title | Type | Video (I Do) | Lab (We Do, You Do) | Workshop (You Do) | Planned guidance |
| :-- | :-- | :-: | :-: | :-: | :-: | :-: |
| B103-1 | MDS Repository Deployment | Core | 0 | 1 | 0 | 30% |
| B103-2 | BC4J Configuration Upload | Core | 0 | 1 | 0 | 29% |
| B103-3 | AOL Security & Page Registration | Core | 0 | 2 | 0 | 28% |
| B103-4 | Enterprise Instrumentation | Core | 0 | 2 | 0 | 27% |
| B103-5 | Log Management & Maintenance | Core | 0 | 1 | 0 | 26% |
| B103-6 | EBS R12.2 Online Patching | Core | 1 | 0 | 0 | 24% |
| B103-7 | Automated Packaging & Scripting | Core | 0 | 2 | 0 | 23% |
| B103-8 | Project Setup and Planning | Required | 0 | 5 | 0 | 22% |
| B103-9 | Store Management Module | Required | 0 | 5 | 0 | 21% |
| B103-10 | Product Management Module | Required | 0 | 1 | 2 | 20% |
| B103-11 | Branch Management (Master-Detail) | Required | 0 | 1 | 0 | 19% |
| B103-12 | Sales and Transactions Module | Required | 0 | 3 | 0 | 18% |
| B103-13 | Advanced Features and Polish | Required | 0 | 3 | 0 | 17% |
| B103-14 | Deployment and Presentation | Required | 0 | 1 | 3 | 16% |
| B103-15 | Final Assessment | Required | 0 | 0 | 6 | 14% |
| B103-16 | Advanced Tables, Grids and Visualization | Extended | 1 | 6 | 0 | 13% |
| B103-17 | Advanced Search and Navigation | Extended | 0 | 6 | 0 | 12% |
| B103-18 | State Management, Back Button and Security | Extended | 2 | 5 | 0 | 11% |
| B103-19 | REST and Product Integration | Extended | 2 | 4 | 0 | 10% |
| | **Level total** | | **6** (9%) | **49** (74%) | **11** (17%) | **20% average** |

#### C101: Cust 101: Oracle OAF Customizing BootCamp (Beginner)

| Module | Title | Type | Video (I Do) | Lab (We Do, You Do) | Workshop (You Do) | Planned guidance |
| :-- | :-- | :-: | :-: | :-: | :-: | :-: |
| C101-1 | Upgrade Preservation Principles | Core | 4 | 0 | 0 | 70% |
| C101-2 | Personalization Hierarchy | Core | 0 | 1 | 0 | 68% |
| C101-3 | Functional Administrator Tool | Core | 0 | 2 | 0 | 65% |
| C101-4 | UI Component Personalization | Core | 0 | 3 | 0 | 62% |
| C101-5 | Declarative Region Injections | Core | 0 | 1 | 0 | 60% |
| C101-6 | Personalization Migration | Core | 0 | 3 | 0 | 58% |
| C101-7 | LOV Declarative Alteration | Core | 0 | 1 | 0 | 55% |
| C101-8 | Diagnostics and Translation | Extended | 1 | 1 | 0 | 52% |
| C101-9 | Cust 101 Assessment | Required | 0 | 0 | 1 | 50% |
| | **Level total** | | **5** (28%) | **12** (67%) | **1** (6%) | **60% average** |

#### C102: Cust 102: Oracle OAF Customizing BootCamp (Advanced)

| Module | Title | Type | Video (I Do) | Lab (We Do, You Do) | Workshop (You Do) | Planned guidance |
| :-- | :-- | :-: | :-: | :-: | :-: | :-: |
| C102-1 | Controller Class Extensions | Core | 0 | 1 | 0 | 50% |
| C102-2 | Business Component Extensions | Core | 0 | 3 | 0 | 48% |
| C102-6 | Programmatic LOV Extensions | Core | 0 | 1 | 0 | 46% |
| C102-3 | BC4J Substitution Registration | Core | 1 | 1 | 0 | 43% |
| C102-4 | Archive Packaging & Utilities | Core | 0 | 2 | 0 | 41% |
| C102-5 | R12.2 Filesystem Synchronization | Core | 0 | 1 | 0 | 39% |
| C102-7 | Extension Troubleshooting | Core | 0 | 1 | 0 | 37% |
| C102-8 | Extension Architecture and Standards | Required | 4 | 0 | 0 | 34% |
| C102-9 | Release and Environment Promotion | Required | 1 | 2 | 0 | 32% |
| C102-10 | Cust 102 Assessment | Required | 0 | 0 | 1 | 30% |
| | **Level total** | | **6** (32%) | **12** (63%) | **1** (5%) | **40% average** |

### Scaffold Assets

What each level needs to deliver its scaffold, and what exists in the repository today. Status is my reading of the repository contents.

| Level | Asset | Status | Evidence or gap |
| :-: | :-- | :-: | :-- |
| 101 | Step-by-step labs | Exists | LABS.md sections 2-10 with scaffold levels |
| 101 | Code templates and starters | Partial | code-brain labs (Lab1 to Lab3) and the Jobs & Positions entity examples; no starter project per module |
| 101 | Frequent checkpoints | Partial | Defined for the capstone schedule only |
| 101 | Solutions after an attempt | Partial | Case-study entity classes only; no full solution set |
| 101 | Instructor guide | Partial | Sections 2-5 and the capstone |
| 102 | Labs | Exists | LABS.md sections 11-17, numbered differently from the syllabus |
| 102 | Partial templates | Partial | code-brain pattern files cover most sections |
| 102 | Milestone checkpoints | Missing | Not defined per module |
| 102 | Solutions after completion | Partial | Pattern examples only |
| 102 | Instructor guide | Missing | No Level 102 teaching guide |
| 103 | Requirements-only briefs | Partial | Capstone sections describe modules; no briefs per module |
| 103 | Architecture guidance | Missing | No reference architecture for the POS capstone |
| 103 | Milestone reviews | Partial | Assessment criteria exist; review points are not scheduled |
| 103 | Labs | Missing | LABS.md sections 18-20 do not match the capstone or the production-readiness core |
| 103 | Instructor guide | Missing | No Level 103 teaching guide |
| C101 | Seeded practice page and checklists | Missing | No seeded page or per-level checklist |
| C101 | Labs and instructor guide | Missing | None |
| C102 | Extension templates | Missing | No extension templates; code-brain has none |
| C102 | Labs and instructor guide | Missing | None |

## Boundary Check

An automated scan of each level's lectures (title and notes) for topics that belong to another level. A lecture whose notes explicitly hand the topic to another level is allowed.

| Level | Out-of-scope terms searched | Findings |
| :-: | :-- | :-: |
| 101 | personaliz, extension, substitut, jpx, adop, importer, programmatic | 0 |
| 102 | adop, adcgnjar, importer, jpx, substitut, fnd_log, personaliz | 0 |
| 103 | personaliz, substitut, controller extension | 0 |
| C101 | controller extension, substitut, jpx, adcgnjar | 0 |
| C102 | declarative page personaliz | 0 |

## Duration Check

Planned days are lectures divided by the level's pace. The required path is core plus required modules; it is compared with the stated level length. Extended days are optional and come on top. A capstone given in weeks runs alongside and carries no days. Cust lengths and the Dev 101 restatement are proposals.

| Level | Stated length | Pace (lectures a day) | Required path lectures | Required path days | Extended lectures | Extended days | Required path vs stated |
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-- |
| 101 | 28-32 days | 1.9 | 59 | 31.1 | 15 | 7.9 | Within range |
| 102 | 20-25 days | 1.3 | 28 | 21.5 | 53 | 40.8 | Within range |
| 103 | 20-30 days | 1.5 | 40 | 26.7 | 26 | 17.3 | Within range |
| C101 | 10-15 days | 1.3 | 16 | 12.3 | 2 | 1.5 | Within range |
| C102 | 10-15 days | 1.5 | 19 | 12.7 | 0 | 0 | Within range |

| Level | Source of the pace |
| :-: | :-- |
| 101 | Observed in the syllabi (1.7 to 1.9) |
| 102 | Observed in the syllabi (1.3) |
| 103 | Assumed. The capstone section durations imply 1.0, which contradicts the stated 20-30 days |
| C101 | Observed in the syllabi (1.3) |
| C102 | Observed in the syllabi (1.5) |

Dev 101 was stated at 20-25 days, but its required path of 59 lectures needs about 31.1 days at the syllabi's own pace, so the stated length is restated to 28-32 days.

## Gaps by Level

| Level | Modules without a lab reference | Modules without code-brain examples | Open gap |
| :-: | :-: | :-: | :-- |
| 101 | 1 of 14 | 3 of 14 | Capstone assessment is the only graded item; instructor guide covers only part of the level. |
| 102 | 1 of 17 | 0 of 17 | Labs are numbered 11-17 in LABS.md; the extended outcomes (LO2.8 to LO2.14) rest on optional modules. |
| 103 | 18 of 19 | 14 of 19 | Core and capstone have no labs or code-brain examples. |
| C101 | 8 of 9 | 5 of 9 | Assessment criteria are proposals; no labs or instructor guide. |
| C102 | 9 of 10 | 9 of 10 | Assessment criteria are proposals; no labs, code examples or instructor guide. |

## Contents

- [Level 101](#level-101-dev-101-oracle-oaf-building-bootcamp-beginner)
- [Level 102](#level-102-dev-102-oracle-oaf-building-bootcamp-advanced)
- [Level 103](#level-103-dev-103-oracle-oaf-building-bootcamp-ninja)
- [Level C101](#level-c101-cust-101-oracle-oaf-customizing-bootcamp-beginner)
- [Level C102](#level-c102-cust-102-oracle-oaf-customizing-bootcamp-advanced)
- [Level Boundaries](#level-boundaries)
- [Scaffolding](#scaffolding)
- [Boundary Check](#boundary-check)
- [Duration Check](#duration-check)
- [Gaps by Level](#gaps-by-level)
- [Component and Capability Catalog](#component-and-capability-catalog)
- [Use Case Coverage](#use-case-coverage)
- [Open items](#open-items)

## Level 101: Dev 101: Oracle OAF Building BootCamp (Beginner)

**Code:** DL-OAF-B-101 | **Syllabus:** [SYLLABUS_101.md](SYLLABUS_101.md)  
28-32 days | 60% scaffolding | Prerequisite: basic Java and SQL | Milestone: Associate OAF Developer

**Learning outcomes**

- Set up and configure OAF development environment
- Create basic OAF pages using Model-View-Controller pattern
- Implement standard web widgets and UI components
- Build CRUD (Create, Read, Update, Delete) functionality
- Deploy OAF applications to Oracle E-Business Suite
- Debug and test basic OAF applications

**Modules at a glance**

| Module | Title | Type | Section | Lectures | Days |
| :-- | :-- | :-: | :-- | :-: | :-: |
| B101-0 | BootCamp Orientation & Success Path | Extended | 1. Orientation | 4 | 2.1 |
| B101-1 | OAF Architecture & MVC Paradigms | Core | 2. Foundations | 7 | 3.7 |
| B101-2 | IDE Setup & Project Topology | Core | 2. Foundations | 10 | 5.3 |
| B101-3 | Application Module Construction | Core | 3. Model Layer | 5 | 2.6 |
| B101-4 | View Object Development | Core | 3. Model Layer | 5 | 2.6 |
| B101-5 | Entity Object & DML Layer | Core | 3. Model Layer | 3 | 1.6 |
| B101-8 | Master-Detail Relationships | Required | 3. Model Layer | 2 | 1.1 |
| B101-6 | Declarative Page Layouts | Core | 4. View and Controller | 14 | 7.4 |
| B101-7 | Controller Request Processing | Core | 4. View and Controller | 7 | 3.7 |
| B101-9 | Debugging in JDeveloper | Required | 5. Quality, Security and Delivery | 2 | 1.1 |
| B101-10 | Security Implementation | Extended | 5. Quality, Security and Delivery | 4 | 2.1 |
| B101-11 | Development Standards and Best Practices | Extended | 5. Quality, Security and Delivery | 7 | 3.7 |
| B101-12 | Deploying OA Framework Applications | Required | 5. Quality, Security and Delivery | 4 | 2.1 |
| B101-13 | Jobs & Positions Management Capstone | Required | 6. Capstone | 6 | alongside |

### Section 101.1: Orientation

**Modules:** 1 | **Days:** 2.1

#### Module B101-0: BootCamp Orientation & Success Path

**Type:** Extended | **Days:** 2.1  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-0.1 | Welcome to Your OAF Journey | Video | ✓ | PDF | Transformation roadmap, success stories, instructor intro | 101§1.1 |
| B101-0.2 | BootCamp Architecture & Learning Framework | Video | ✓ | PDF | Three-level progression, scaffolding approach, assessment | 101§1.2 |
| B101-0.3 | Building Your Learning Community | Video | ✓ | Guide | Study groups, code review, forums, peer learning | 101§1.3 |
| B101-0.4 | Setting Goals & Success Strategies | Workshop | ✓ | Template | SMART goals, time management, growth mindset | 101§1.4 |

### Section 101.2: Foundations

**Modules:** 2 | **Days:** 8.9

#### Module B101-1: OAF Architecture & MVC Paradigms

**Type:** Core | **Days:** 3.7 | **Labs:** [LABS.md](LABS.md), Section 2  
**Technical focus:** J2EE MVC, Tier Separation, MDS Architecture  
**Learning outcome:** Analyze the execution flow across Model, View, and Controller layers.  
**Code-brain examples:** [BaseController.java](code-brain/foundation/base/BaseController.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-1.1 | OAF Terminology: Speaking the Language | Video | ✓ | Glossary | Vocabulary, naming conventions, EBS context | 101§2.1 |
| B101-1.2 | Evolution: From Oracle Forms to OA Framework | Video | ✓ | Comparison Chart | Technology shift, migration strategies, use cases | 101§2.2 |
| B101-1.3 | Strategic Value: When and Why to Use OAF | Video | ✓ | Decision Matrix | Advantages, limitations, business case | 101§2.3 |
| B101-1.4 | OAF Ecosystem: Integration with E-Business Suite | Video | - | Whitepaper | Evolution, Oracle's direction, EBS integration | 101§2.4 |
| B101-1.5 | MVC Pattern Mastery: The Foundation of OAF | Video | ✓ | Diagram | Model-View-Controller, separation of concerns | 101§2.5 |
| B101-1.6 | OAF Architecture Deep Dive: BC4J and UIX | Video | ✓ | Architecture Guide | BC4J, UIX, lifecycle, metadata repository | 101§2.6 |
| B101-1.7 | Page Anatomy: Understanding OAF Components | Video | ✓ | Reference Poster | AM, VO, EO, Pages, Regions, Controllers | 101§2.7 |

#### Module B101-2: IDE Setup & Project Topology

**Type:** Core | **Days:** 5.3 | **Labs:** [LABS.md](LABS.md), Section 3  
**Technical focus:** JDeveloper Setup, .jws/.jpr Specs, DBC Connections  
**Learning outcome:** Configure standardized local development environments linked to EBS.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-2.1 | Mastering JDeveloper IDE: Your Development Command Center | Video | ✓ | Quick Ref | IDE layout, panels, workspace organization | 101§3.1 |
| B101-2.2 | Downloading OA Extension from Oracle Support Portal | Video | - | Guide | MOS portal, version matrix, download process | 101§3.2 |
| B101-2.3 | Complete Environment Configuration & Setup | Video | ✓ | Checklist | Installation, OA Extension, configuration, DBC; directories (jdevbin, jdevhome, jdevdoc), JDEV_USER_HOME and JDEV_JAVA_HOME | 101§3.3 |
| B101-2.4 | Boosting Productivity: JDeveloper Tools & Shortcuts | Video | ✓ | Shortcut Card | Interface customization, shortcuts, templates | 101§3.4 |
| B101-2.5 | Using the Structure Pane, Property Inspector and UML Modeler | Lab | ✓ | Guide | Hierarchy navigation, property sheets, UML modeling of business components, local debugging tools | 101§3.10 |
| B101-2.6 | Configuring DBC Files & Database Connections | Video | ✓ | Troubleshoot Guide | DBC setup, connection parameters, validation | 101§3.5 |
| B101-2.7 | Establishing Database Connectivity | Video | ✓ | Connection Guide | Connection setup, pooling, multi-environment; setup verification with test_fwktutorial.jsp | 101§3.8 |
| B101-2.8 | Registering Application Short Names and Responsibility Keys | Lab | ✓ | Guide | Application short name, responsibility key, FWK_TBX_TUTORIAL setup for local testing | 101§3.9 |
| B101-2.9 | Building Your First "Hello World!" OAF Page | Lab | ✓ | Step-by-step | First page, AM, layout, components, run | 101§3.6 |
| B101-2.10 | Organizing Projects: Structure & Best Practices | Video | ✓ | Template | Workspace organization, naming, version control | 101§3.7 |

### Section 101.3: Model Layer

**Modules:** 4 | **Days:** 7.9

#### Module B101-3: Application Module Construction

**Type:** Core | **Days:** 2.6 | **Labs:** [LABS.md](LABS.md), Section 4  
**Technical focus:** OAApplicationModuleImpl, OADBTransaction, Root AM  
**Learning outcome:** Construct transactional containers for BC4J component management.  
**Code-brain examples:** [JobMgmtAMImpl.java](code-brain/model-layer/application-modules/JobMgmtAMImpl.java), [EntityObjectPatterns.java](code-brain/model-layer/entity-objects/EntityObjectPatterns.java), [JobVOImpl.java](code-brain/model-layer/view-objects/JobVOImpl.java), [ExecuteVO.java](code-brain/model-layer/view-objects/ExecuteVO.java), [BaseViewObject.java](code-brain/foundation/base/BaseViewObject.java), [TransactionHelper.java](code-brain/foundation/utilities/TransactionHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-3.1 | Understanding BC4J: The Data Management Engine | Video | ✓ | Overview | Understanding BC4J, MVC role, component ecosystem | 101§4.1 |
| B101-3.2 | Designing Application Modules: Orchestrating Business Logic | Video | ✓ | Design Guide | AM structure, transactions, pooling, patterns | 101§4.2 |
| B101-3.3 | Building & Testing Your First Application Module | Lab | ✓ | Wizard Guide | Step-by-step creation, testing, debugging | 101§4.3 |
| B101-3.4 | Accessing OADBTransaction from the Application Module | Lab | ✓ | Guide | Database connection access, transaction commit/rollback, server-side utilities | 101§4.13 |
| B101-3.5 | Managing Database Transactions & Connection Pooling | Video | ✓ | Best Practices | Connection pooling, commits, locking, tuning | 101§4.11 |

#### Module B101-4: View Object Development

**Type:** Core | **Days:** 2.6 | **Labs:** [LABS.md](LABS.md), Section 4  
**Technical focus:** OAViewObjectImpl, SQL Bind Variables, View Links  
**Learning outcome:** Develop declarative and dynamic data query components for UI rendering.  
**Code-brain examples:** [JobMgmtAMImpl.java](code-brain/model-layer/application-modules/JobMgmtAMImpl.java), [EntityObjectPatterns.java](code-brain/model-layer/entity-objects/EntityObjectPatterns.java), [JobVOImpl.java](code-brain/model-layer/view-objects/JobVOImpl.java), [ExecuteVO.java](code-brain/model-layer/view-objects/ExecuteVO.java), [BaseViewObject.java](code-brain/foundation/base/BaseViewObject.java), [TransactionHelper.java](code-brain/foundation/utilities/TransactionHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-4.1 | View Objects Explained: Query-Based Data Views | Video | ✓ | VO Guide | SQL queries, read-only vs updatable, performance | 101§4.6 |
| B101-4.2 | Building Updatable View Objects for CRUD Operations | Lab | ✓ | Tutorial | VO-EO linking, attribute mapping, CRUD testing | 101§4.7 |
| B101-4.3 | Implementing Read-Only View Objects with SQL | Lab | ✓ | Tutorial | SQL-based VOs, expert mode, joins, optimization | 101§4.8 |
| B101-4.4 | Configuring Bind Variables and View Criteria | Lab | ✓ | Tutorial | Named bind variables, view criteria, dynamic WHERE clauses, preventing SQL injection | 101§4.12 |
| B101-4.5 | Mastering View Links & Entity Associations | Video | ✓ | Reference | Master-detail, FK relationships, domains | 101§4.10 |

#### Module B101-5: Entity Object & DML Layer

**Type:** Core | **Days:** 1.6 | **Labs:** [LABS.md](LABS.md), Section 4  
**Technical focus:** OAEntityImpl, Validation Logic, Primary Keys  
**Learning outcome:** Build persistent data access objects that enforce business constraints.  
**Code-brain examples:** [JobMgmtAMImpl.java](code-brain/model-layer/application-modules/JobMgmtAMImpl.java), [EntityObjectPatterns.java](code-brain/model-layer/entity-objects/EntityObjectPatterns.java), [JobVOImpl.java](code-brain/model-layer/view-objects/JobVOImpl.java), [ExecuteVO.java](code-brain/model-layer/view-objects/ExecuteVO.java), [BaseViewObject.java](code-brain/foundation/base/BaseViewObject.java), [TransactionHelper.java](code-brain/foundation/utilities/TransactionHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-5.1 | Entity Objects Fundamentals: Your Database Gateway | Video | ✓ | EO Reference | Table mapping, validation, DML, associations | 101§4.4 |
| B101-5.2 | Creating Entity Objects: Table-to-Object Mapping | Lab | ✓ | Tutorial | Wizard creation, attributes, validation rules | 101§4.5 |
| B101-5.3 | Defining Primary Keys and Attribute Validation in Entity Objects | Lab | ✓ | Tutorial | Primary key identification, attribute-level validation routines, entity-level validation | 101§4.14 |

#### Module B101-8: Master-Detail Relationships

**Type:** Required | **Days:** 1.1 | **Labs:** [LABS.md](LABS.md), Section 6B  
**Code-brain examples:** [MasterDetailPatternsAM.java](code-brain/model-layer/application-modules/MasterDetailPatternsAM.java), [Lab3MasterDetailPageCO.java](code-brain/labs/Lab3MasterDetailPageCO.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-8.1 | Understanding Master-Detail Pattern with View Links | Video | ✓ | Guide | Parent-child relationships, View Links, use cases | 101§6B.1 |
| B101-8.2 | Implementing Master-Detail User Interfaces | Lab | ✓ | Tutorial | Region configuration, synchronization, cascading | 101§6B.2 |

### Section 101.4: View and Controller

**Modules:** 2 | **Days:** 11.1

#### Module B101-6: Declarative Page Layouts

**Type:** Core | **Days:** 7.4 | **Labs:** [LABS.md](LABS.md), Section 5  
**Technical focus:** Page Definitions (.xml), UIX Web Beans, Region Types  
**Learning outcome:** Construct structured UI hierarchies using standard JRAD components.  
**Code-brain examples:** [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-6.1 | Understanding UIX: Component-Based UI Architecture | Video | ✓ | UIX Guide | Framework basics, component hierarchy, metadata | 101§5.1 |
| B101-6.2 | Structuring UI Components in Your Workspace | Video | ✓ | Structure Guide | Workspace organization, naming, packages, reusable | 101§5.2 |
| B101-6.3 | Building Pages & Regions: Core Fundamentals | Video | ✓ | Layout Guide | Page structure, region types, hierarchy, containers | 101§5.3 |
| B101-6.4 | Creating and Reusing Shared Regions, Pages and Items | Lab | ✓ | Tutorial | Shared regions, shared pages, shared items, reuse across page contexts, sharing logistics | 101§5.15 |
| B101-6.5 | Working with Standard Web Widgets & Components | Lab | ✓ | Widget Reference | All standard UI widgets and their properties | 101§5.4 |
| B101-6.6 | Designing Professional Page Layouts & Advanced Regions | Lab | ✓ | Layout Patterns | Layouts, headers, buttons, query regions | 101§5.6 |
| B101-6.7 | Building Forms with messageComponentLayout and Default Layouts | Lab | ✓ | Widget Reference | messageComponentLayout columns and rows, stack layouts; default* form layouts are deprecated in 12.2; messageLayout for non-message beans, labeledFieldLayout | 101§5.10 |
| B101-6.8 | Look-and-Feel Standards: BLAF and Redwood *(verify)* | Video | ✓ | Style Guide | Oracle look-and-feel standards, BLAF guidelines, Redwood look and feel, choosing and applying a look and feel *(verify)* | 101§5.16 |
| B101-6.9 | Selection Controls: Poplists, Radio Groups, Checkboxes and Spin Boxes | Lab | ✓ | Widget Reference | messageChoice, messageLovChoice, messageRadioGroup, messageCheckBox, messageSpinBox, default values; messageRadioButton | 101§5.11 |
| B101-6.10 | Buttons, Page Button Bars and Content Footers | Lab | ✓ | Widget Reference | button, submitButton, resetButton, selectionButton, exportButton, link, pageButtonBar, contentFooter; page footer (copyright and privacy links); contentFooter is deprecated; link variants (GET/POST, external URL, mailto, JavaScript) | 101§5.12 |
| B101-6.11 | Images, Spacers, Separators, Tips and Static Text | Lab | ✓ | Widget Reference | image, spacer, separator, tip, instructionText, styledText, formattedText; messageStyledText, staticStyledText, rawText, dynamic images from BLOB columns | 101§5.13 |
| B101-6.12 | Form Parameters, Form Values and Includes | Lab | ✓ | Guide | formParameter, formValue, servletInclude, urlInclude; passing hidden values | 101§5.14 |
| B101-6.13 | Applying CSS Styling & Reusable Attribute Sets | Video | ✓ | Style Guide | CSS styling, attribute sets, theming | 101§5.7 |
| B101-6.14 | Implementing Navigation: Breadcrumbs & Menus | Video | ✓ | Nav Guide | Breadcrumb configuration, menu integration; locator element | 101§5.9 |

#### Module B101-7: Controller Request Processing

**Type:** Core | **Days:** 3.7 | **Labs:** [LABS.md](LABS.md), Section 6  
**Technical focus:** OAControllerImpl, processRequest(), OAPageContext  
**Learning outcome:** Implement controller logic for initial page rendering and query setup.  
**Code-brain examples:** [ControllerPatterns.java](code-brain/controller-layer/core/ControllerPatterns.java), [JobMgmtCO.java](code-brain/controller-layer/JobMgmtCO.java), [ParameterHelper.java](code-brain/foundation/utilities/ParameterHelper.java), [SessionManagement.java](code-brain/cross-cutting/session/SessionManagement.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-7.1 | Understanding Controller Architecture & User Actions | Video | ✓ | CO Guide | MVC role, lifecycle, structure, best practices | 101§6.1 |
| B101-7.2 | Handling GET Requests: Page Initialization Logic | Video | ✓ | Pattern Library | processRequest(), initialization, default values | 101§6.2 |
| B101-7.3 | Leveraging Controller API: pageContext & WebBeans | Video | ✓ | API Reference | pageContext, attributes, WebBeans, transactions | 101§6.5 |
| B101-7.4 | Comparing Parameter Passing Strategies | Video | ✓ | Decision Tree | Request, Transaction, Session scopes comparison | 101§6.6 |
| B101-7.5 | Using Request Parameters for Single-Page Scope | Lab | ✓ | Tutorial | Token-based, navigation, lifecycle, examples | 101§6.7 |
| B101-7.6 | Managing Transaction Parameters Across Pages | Lab | ✓ | Tutorial | Multi-page flow, retention, cleanup | 101§6.8 |
| B101-7.7 | Implementing Session Parameters for User State | Lab | ✓ | Tutorial | Session scope, persistence, memory, best practices | 101§6.9 |

### Section 101.5: Quality, Security and Delivery

**Modules:** 4 | **Days:** 8.9

#### Module B101-9: Debugging in JDeveloper

**Type:** Required | **Days:** 1.1 | **Labs:** [LABS.md](LABS.md), Section 7  
**Code-brain examples:** [OAExceptionHandling.java](code-brain/cross-cutting/error-handling/OAExceptionHandling.java), [MessageHelper.java](code-brain/cross-cutting/utils/MessageHelper.java), [MessageConstants.java](code-brain/cross-cutting/constants/MessageConstants.java), [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [DialogPageExamples.java](code-brain/controller-layer/dialogs/DialogPageExamples.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-9.1 | Using Debugging Tools: Console & Logging | Video | ✓ | Debug Guide | Console output, log files, diagnostic logging | 101§7.3 |
| B101-9.2 | Mastering JDeveloper Debugger: Step-Through Analysis | Lab | ✓ | Debug Tutorial | Breakpoints, step-through, variables, remote | 101§7.4 |

#### Module B101-10: Security Implementation

**Type:** Extended | **Days:** 2.1 | **Labs:** [LABS.md](LABS.md), Section 8  
**Code-brain examples:** [SecurityPatterns.java](code-brain/security/SecurityPatterns.java), [SecurityValidator.java](code-brain/foundation/security/SecurityValidator.java), [UserContextHelper.java](code-brain/foundation/security/UserContextHelper.java), [SecureSearchVO.java](code-brain/model-layer/view-objects/SecureSearchVO.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-10.1 | Understanding OAF Security: Authentication & Authorization | Video | ✓ | Security Guide | Authentication, authorization, function security | 101§8.1 |
| B101-10.2 | Implementing Function Security to Control Page Access | Lab | ✓ | Tutorial | Function registration, menu setup, responsibilities | 101§8.2 |
| B101-10.3 | Applying Data Security: Row-Level Protection | Video | ✓ | Best Practices | Multi-Org, row-level security, VPD, filtering | 101§8.3 |
| B101-10.4 | Built-In Protection Against HTML Tampering | Video | ✓ | Guide | Automatic guards against HTML tampering and common hacking vectors, what the framework protects by default | 101§8.4 |

#### Module B101-11: Development Standards and Best Practices

**Type:** Extended | **Days:** 3.7 | **Labs:** [LABS.md](LABS.md), Section 9  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java), [ProfileOptionPatterns.java](code-brain/cross-cutting/configuration/ProfileOptionPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-11.1 | Understanding Why Development Standards Matter | Video | ✓ | Guide | Maintainability, team collaboration, Oracle support, upgrades | 101§9.1 |
| B101-11.2 | Following OAF Coding Standards & Terminology | Video | ✓ | Standards Doc | Naming conventions, package structure, comments, organization | 101§9.2 |
| B101-11.3 | Comparing Oracle, Project & Industry Standards | Video | ✓ | Comparison | Oracle standards, project-specific, industry best practices | 101§9.3 |
| B101-11.4 | Organizing Files & Packages in OAF Projects | Video | ✓ | Reference | File types (.xml, .java, .class), package naming, MDS structure | 101§9.4 |
| B101-11.5 | Understanding OAF Directory Structure | Video | ✓ | Diagram | $JAVA_TOP structure, workspace organization, resource files | 101§9.5 |
| B101-11.6 | Using Import/Export Utilities for Code Management | Lab | ✓ | Tutorial | Code extraction from database, importing to JDeveloper, version control; JDeveloper-level only, command-line importers are covered in Dev 103 | 101§9.6 |
| B101-11.7 | Designing Common Page Patterns & Use Cases | Video | ✓ | Patterns | Search pages, Create/Update pages, Detail/drill-down, List pages | 101§9.9 |

#### Module B101-12: Deploying OA Framework Applications

**Type:** Required | **Days:** 2.1 | **Labs:** [LABS.md](LABS.md), Section 10  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-12.1 | Understanding the OAF Deployment Process | Video | ✓ | Checklist | Compilation, packaging, file transfer, import to MDS, bounce Apache | 101§10.1 |
| B101-12.2 | Deploying Your OAF Application on R12.1.x | Lab | ✓ | Tutorial | Step-by-step deployment, file locations, import commands, verification | 101§10.2 |
| B101-12.3 | Deploying Your OAF Application on R12.2.x | Lab | ✓ | Tutorial | Deployment differences on R12.2 for a training instance; the dual file system, adop and online patching are covered in Dev 103 | 101§10.3 |
| B101-12.4 | Completing Post-Deployment Configuration Tasks | Lab | ✓ | Guide | Function registration, menu setup, responsibility assignment, testing | 101§10.4 |

### Section 101.6: Capstone

**Modules:** 1 | **Days:** alongside

#### Module B101-13: Jobs & Positions Management Capstone

**Type:** Required | **Days:** alongside | **Labs:** [LABS.md](LABS.md), Level 101 Capstone Project (20-day schedule)  
**Code-brain examples:** [JobEOImpl.java](code-brain/case-studies/jobs-positions-management/JobEOImpl.java), [PositionEOImpl.java](code-brain/case-studies/jobs-positions-management/PositionEOImpl.java), [JobMgmtAMImpl.java](code-brain/model-layer/application-modules/JobMgmtAMImpl.java), [JobMgmtCO.java](code-brain/controller-layer/JobMgmtCO.java), [Lab1QueryPageCO.java](code-brain/labs/Lab1QueryPageCO.java), [Lab2CreateUpdatePageCO.java](code-brain/labs/Lab2CreateUpdatePageCO.java), [Lab3MasterDetailPageCO.java](code-brain/labs/Lab3MasterDetailPageCO.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B101-13.1 | Database Objects and Entities | Lab | ✓ | Scripts | Tables, sequences, entity objects, WHO columns | 101§11.1 |
| B101-13.2 | View Objects and Application Module | Lab | ✓ | Project | Job and position VOs, view link, root AM | 101§11.2 |
| B101-13.3 | Job Search and Job Details Pages | Lab | ✓ | Project | Search page, create/update page, controllers | 101§11.3 |
| B101-13.4 | Position Maintenance (Master-Detail) | Lab | ✓ | Project | Detail table, add/delete rows, validation | 101§11.4 |
| B101-13.5 | Testing and Deployment | Lab | ✓ | Checklist | Test plan, deployment to EBS, reflection | 101§11.5 |
| B101-13.6 | Capstone Assessment | Workshop | ✓ | Rubric | 100 points: functionality 40, code quality 30, UI 20, documentation 10 | 101§11.6 |

## Level 102: Dev 102: Oracle OAF Building BootCamp (Advanced)

**Code:** DL-OAF-B-102 | **Syllabus:** [SYLLABUS_102.md](SYLLABUS_102.md)  
20-25 days | 40% scaffolding | Prerequisite: Dev 101 | Milestone: Professional OAF Developer

**Learning outcomes**

- **LO2.1:** Intercept user interactions and execute post-back processing with processFormRequest
- **LO2.2:** Update specific page regions with partial page rendering
- **LO2.3:** Build lists of values, including dependent LOVs
- **LO2.4:** Implement exception handling and user messaging
- **LO2.5:** Manage confirmation workflows with dialog pages
- **LO2.6:** Build advanced tables with inline record creation and deletion
- **LO2.7:** Change web bean state dynamically during the page lifecycle
- **LO2.8:** Create dynamic View Objects programmatically
- **LO2.9:** Execute SQL statements and call PL/SQL procedures from OAF
- **LO2.10:** Implement advanced UI components (HGrid, Train, Shuttle, etc.)
- **LO2.11:** Integrate Flexfields (Key and Descriptive) in OAF pages
- **LO2.12:** Implement file upload/download and data import/export
- **LO2.13:** Build workflow-enabled OAF applications
- **LO2.14:** Implement advanced debugging techniques

**Modules at a glance**

| Module | Title | Type | Section | Lectures | Days |
| :-- | :-- | :-: | :-- | :-: | :-: |
| B102-1 | Form Event Handling Lifecycle | Core | 1. Events, PPR and LOVs | 2 | 1.5 |
| B102-2 | Asynchronous UI via PPR | Core | 1. Events, PPR and LOVs | 2 | 1.5 |
| B102-3 | List of Values (LOV) Engineering | Core | 1. Events, PPR and LOVs | 4 | 3.1 |
| B102-4 | Enterprise Exception Framework | Core | 2. Messages and Dialogs | 3 | 2.3 |
| B102-5 | Modal Dialogs & Page Navigation | Core | 2. Messages and Dialogs | 2 | 1.5 |
| B102-6 | Advanced Table Operations | Core | 3. Tables and Dynamic UI | 3 | 2.3 |
| B102-7 | Dynamic UI Control & Focus | Core | 3. Tables and Dynamic UI | 6 | 4.6 |
| B102-8 | Advanced Model and Server-Side Features | Extended | 4. Advanced Model and Server-Side | 6 | 4.6 |
| B102-9 | Layout and Container Regions | Extended | 5. Advanced View Components | 6 | 4.6 |
| B102-10 | Data Regions, Grids and Charts | Extended | 5. Advanced View Components | 5 | 3.8 |
| B102-11 | Wizards, Rich Inputs and Configurable Pages | Extended | 5. Advanced View Components | 5 | 3.8 |
| B102-12 | Flexfields, SPEL and Forms Integration | Extended | 5. Advanced View Components | 6 | 4.6 |
| B102-13 | Client-Side Scripting and Page Modes | Extended | 6. Controller, Data and Integration | 2 | 1.5 |
| B102-14 | Data Formatting and Validation | Extended | 6. Controller, Data and Integration | 4 | 3.1 |
| B102-15 | Advanced Features and Integrations | Extended | 6. Controller, Data and Integration | 16 | 12.3 |
| B102-16 | Advanced Debugging | Extended | 7. Debugging, Projects and Assessment | 3 | 2.3 |
| B102-17 | Projects and Final Assessment | Required | 7. Debugging, Projects and Assessment | 6 | 4.6 |

### Section 102.1: Events, PPR and LOVs

**Modules:** 3 | **Days:** 6.2

#### Module B102-1: Form Event Handling Lifecycle

**Type:** Core | **Days:** 1.5 | **Labs:** [LABS.md](LABS.md), Section 6  
**Technical focus:** processFormRequest(), Event Source Identification  
**Learning outcome:** Intercept user interactions and execute complex post-back processing.  
**Code-brain examples:** [ControllerPatterns.java](code-brain/controller-layer/core/ControllerPatterns.java), [JobMgmtCO.java](code-brain/controller-layer/JobMgmtCO.java), [ParameterHelper.java](code-brain/foundation/utilities/ParameterHelper.java), [SessionManagement.java](code-brain/cross-cutting/session/SessionManagement.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-1.1 | Processing POST Requests: Form Submissions | Video | ✓ | Examples | processFormRequest(), button clicks, validation | 101§6.3 (moved) |
| B102-1.2 | Implementing Common Controller Patterns | Video | ✓ | Cookbook | Parameters, form values, navigation, messages | 101§6.4 (moved) |

#### Module B102-2: Asynchronous UI via PPR

**Type:** Core | **Days:** 1.5 | **Labs:** [LABS.md](LABS.md), Section 5; Section 13  
**Technical focus:** Partial Page Rendering, Target Controls, Event Loops  
**Learning outcome:** Eliminate full page refreshes by updating specific UI regions.  
**Code-brain examples:** [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-2.1 | Enabling Partial Page Rendering (PPR) for Dynamic UI | Lab | ✓ | PPR Tutorial | AJAX in OAF, PPR events, dynamic updates | 101§5.8 (moved) |
| B102-2.2 | Handling PPR Events on the Server | Lab | ✓ | Tutorial | PPR event triggers, dynamic target regions, processFormRequest handling of PPR events | 102§3.18 |

#### Module B102-3: List of Values (LOV) Engineering

**Type:** Core | **Days:** 3.1 | **Labs:** [LABS.md](LABS.md), Section 5; Section 13  
**Technical focus:** LOV Input Beans, Dependent LOVs, Dynamic Mapping  
**Learning outcome:** Build interactive selection dialogs and cascading field pickers.  
**Code-brain examples:** [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-3.1 | Implementing List of Values (LOV) for Data Selection | Lab | ✓ | LOV Tutorial | Standard, dependent, and external LOVs; listOfValues region, lovMap criteria and result mapping, messageLovInput | 101§5.5 (moved) |
| B102-3.2 | Implementing Dependent (Cascading) LOVs | Lab | ✓ | Tutorial | Parent-child LOVs, criteria items, dynamic result mapping, clearing dependent fields | 102§3.17 |
| B102-3.3 | Implementing LOV Auto-Completion and Look-Ahead | Lab | ✓ | Tutorial | Foreign key validation, look-ahead dropdowns, auto-completion, popup LOV fallback | 102§3.24 |
| B102-3.4 | LOV Action Buttons and Mappings | Lab | ✓ | Tutorial | lovActionButton, lovActionMap, lovMap return values, actions inside the LOV window | 102§3.27 |

### Section 102.2: Messages and Dialogs

**Modules:** 2 | **Days:** 3.8

#### Module B102-4: Enterprise Exception Framework

**Type:** Core | **Days:** 2.3 | **Labs:** [LABS.md](LABS.md), Section 7; Section 17  
**Technical focus:** OAException, Severity Levels, Inline Message Boxes  
**Learning outcome:** Implement standard exception handling and user messaging.  
**Code-brain examples:** [OAExceptionHandling.java](code-brain/cross-cutting/error-handling/OAExceptionHandling.java), [MessageHelper.java](code-brain/cross-cutting/utils/MessageHelper.java), [MessageConstants.java](code-brain/cross-cutting/constants/MessageConstants.java), [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [DialogPageExamples.java](code-brain/controller-layer/dialogs/DialogPageExamples.java), [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-4.1 | Understanding OAF Exception Framework & Hierarchy | Video | ✓ | Exception Guide | OAException, checked/unchecked, propagation | 101§7.1 (moved) |
| B102-4.2 | Exception Severity Levels and Inline Messages | Lab | ✓ | Guide | OAException severities (ERROR, WARNING, INFORMATION, CONFIRMATION), inline message rendering; OAAttrValException, OARowValException and bundled exceptions | 102§7.4 |
| B102-4.3 | Raising Bundle/Multiple Error Messages | Lab | ✓ | Examples | Message bundles, multiple validation errors, user-friendly messages, i18n | 102§7.2 |

#### Module B102-5: Modal Dialogs & Page Navigation

**Type:** Core | **Days:** 1.5 | **Labs:** [LABS.md](LABS.md), Section 7; Section 17  
**Technical focus:** OADialogPage, putDialogMessage(), Page Forwards  
**Learning outcome:** Manage confirmation workflows using system dialog pages.  
**Code-brain examples:** [OAExceptionHandling.java](code-brain/cross-cutting/error-handling/OAExceptionHandling.java), [MessageHelper.java](code-brain/cross-cutting/utils/MessageHelper.java), [MessageConstants.java](code-brain/cross-cutting/constants/MessageConstants.java), [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [DialogPageExamples.java](code-brain/controller-layer/dialogs/DialogPageExamples.java), [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-5.1 | Providing User Feedback: Messages & Dialog Pages | Video | ✓ | Message Library | Error messages, dialogs, tokens, i18n | 101§7.2 (moved) |
| B102-5.2 | Dialog Pages and Flow Control | Lab | ✓ | Tutorial | OADialogPage, putDialogMessage(), pageContext.forwardImmediately(), confirmation workflows | 102§7.5 |

### Section 102.3: Tables and Dynamic UI

**Modules:** 2 | **Days:** 6.9

#### Module B102-6: Advanced Table Operations

**Type:** Core | **Days:** 2.3 | **Labs:** [LABS.md](LABS.md), Section 13; Section 14  
**Technical focus:** OAAdvancedTableBean, Row Iterators, Dynamic CRUD  
**Learning outcome:** Implement tabular data grids with inline record creation and deletion.  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java), [AdvancedControllerPatterns.java](code-brain/controller-layer/advanced/AdvancedControllerPatterns.java), [NavigationPatterns.java](code-brain/controller-layer/navigation/NavigationPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-6.1 | Implementing Advanced Table Region | Lab | ✓ | Tutorial | Selection, sorting, filtering, row actions, footer calculations, performance; tableFooter; singleSelection and multipleSelection row selection items | 102§3.4 |
| B102-6.2 | Creating and Deleting Table Rows Programmatically | Lab | ✓ | Project | Advanced table row creation, dynamic row deletion, single and multiple row selection, table events | 102§4.9 |
| B102-6.3 | Updateable Summary Pages: Batch Update, Duplicate and Delete Rows | Lab | ✓ | Project | Multi-row table updates, row duplication, batch delete, partial commit handling | 102§4.10 |

#### Module B102-7: Dynamic UI Control & Focus

**Type:** Core | **Days:** 4.6 | **Labs:** [LABS.md](LABS.md), Section 14  
**Technical focus:** OABodyBean, setInitialFocusId(), Property Overrides  
**Learning outcome:** Dynamically modify web bean states during page lifecycle execution.  
**Code-brain examples:** [AdvancedControllerPatterns.java](code-brain/controller-layer/advanced/AdvancedControllerPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java), [NavigationPatterns.java](code-brain/controller-layer/navigation/NavigationPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-7.1 | WebBean Creation Programmatically | Lab | ✓ | Tutorial | WebBean hierarchy, OAWebBeanFactory, component properties, page structure | 102§4.1 |
| B102-7.2 | Create Items Programmatically | Lab | ✓ | Examples | Text fields, buttons, LOVs, all widget types | 102§4.2 |
| B102-7.3 | Create Regions Programmatically | Lab | ✓ | Tutorial | Region types, layout configuration, nested regions | 102§4.3 |
| B102-7.4 | Add Region to OAF Page Programmatically | Lab | ✓ | Examples | Dynamic page composition, runtime UI modification, use cases | 102§4.4 |
| B102-7.5 | Creating Submit Button Programmatically | Lab | ✓ | Tutorial | Button properties, event handlers, action binding | 102§4.5 |
| B102-7.6 | Controlling Focus and Dynamic Bean Properties | Lab | ✓ | Tutorial | OABodyBean.setInitialFocusId(), dynamic read-only and rendered states, runtime bean changes | 102§4.8 |

### Section 102.4: Advanced Model and Server-Side

**Modules:** 1 | **Days:** 4.6

#### Module B102-8: Advanced Model and Server-Side Features

**Type:** Extended | **Days:** 4.6 | **Labs:** [LABS.md](LABS.md), Section 4; Section 11; Section 12  
**Code-brain examples:** [JobMgmtAMImpl.java](code-brain/model-layer/application-modules/JobMgmtAMImpl.java), [EntityObjectPatterns.java](code-brain/model-layer/entity-objects/EntityObjectPatterns.java), [JobVOImpl.java](code-brain/model-layer/view-objects/JobVOImpl.java), [ExecuteVO.java](code-brain/model-layer/view-objects/ExecuteVO.java), [BaseViewObject.java](code-brain/foundation/base/BaseViewObject.java), [TransactionHelper.java](code-brain/foundation/utilities/TransactionHelper.java), [VOExecutor.java](code-brain/foundation/utilities/VOExecutor.java), [PLSQLIntegration.java](code-brain/integration/plsql/PLSQLIntegration.java), [PLSQLIntegrationHelper.java](code-brain/integration/plsql/PLSQLIntegrationHelper.java), [BindVariableHelper.java](code-brain/foundation/utilities/BindVariableHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-8.1 | Developing Programmatic View Objects Dynamically | Lab | ✓ | Examples | Dynamic VOs, runtime attributes, use cases | 101§4.9 (moved) |
| B102-8.2 | Creating Dynamic View Objects Programmatically | Lab | ✓ | Tutorial | ViewObjectImpl methods, dynamic queries, adding to AM, use cases | 102§1.1 |
| B102-8.3 | Adding Attributes to View Objects Programmatically | Lab | ✓ | Examples | AttributeDef creation, data types, calculated & transient attributes | 102§1.2 |
| B102-8.4 | Executing SQL Statements | Lab | ✓ | Tutorial | Using JDBC in OAF, PreparedStatement, handling result sets, connections | 102§2.1 |
| B102-8.5 | Calling PL/SQL Functions and Procedures | Lab | ✓ | Examples | CallableStatement usage, IN/OUT parameters, function returns, error handling | 102§2.2 |
| B102-8.6 | Best Practices | Video | ✓ | Best Practices | PL/SQL vs Java, performance considerations, transaction management | 102§2.3 |

### Section 102.5: Advanced View Components

**Modules:** 4 | **Days:** 16.9

#### Module B102-9: Layout and Container Regions

**Type:** Extended | **Days:** 4.6 | **Labs:** [LABS.md](LABS.md), Section 13  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-9.1 | Implementing Hide/Show Region | Lab | ✓ | Tutorial | Conditional rendering, PPR for dynamic display, UX considerations | 102§3.1 |
| B102-9.2 | Implementing Flow Layout Region | Lab | ✓ | Examples | Flow vs other layouts, component arrangement, responsive design | 102§3.2 |
| B102-9.3 | Implementing Advanced Layout Region | Lab | ✓ | Patterns | Table/Row/Cell layouts, nested layouts, complex forms | 102§3.7 |
| B102-9.4 | Implementing Content Container Region | Lab | ✓ | Examples | Tab-based navigation, hiding/showing tabs, dynamic tab generation; richContainer | 102§3.9 |
| B102-9.5 | Implementing Panel Splitter and Layered Layout | Lab | ✓ | Tutorial | panelSplitter, layeredLayout, adjustable panels, multi-mode pages | 102§3.19 |
| B102-9.6 | Building Custom Grids with tableLayout, rowLayout and cellFormat | Lab | ✓ | Tutorial | Explicit rows and cells, columnSpan, rowSpan, hAlign, vAlign, width and height | 102§3.25 |

#### Module B102-10: Data Regions, Grids and Charts

**Type:** Extended | **Days:** 3.8 | **Labs:** [LABS.md](LABS.md), Section 13  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-10.1 | Implementing Query Region (Advanced) | Lab | ✓ | Guide | Construction modes, results-based search, auto-customization, configuration | 102§3.3 |
| B102-10.2 | Implementing HGrid Region | Lab | ✓ | Tutorial | Hierarchical data, expandable nodes, tree navigation, performance; tree, nodeDef and childNode definitions | 102§3.8 |
| B102-10.3 | Implementing Charts and Graphs | Lab | ✓ | Tutorial | Chart types, data binding, interactive charts, BI Publisher integration | 102§3.10 |
| B102-10.4 | Implementing Bulleted Lists | Lab | ✓ | Tutorial | bulletedList, multi-column lists, dynamic list content | 102§3.21 |
| B102-10.5 | Implementing Auto-Repeating Layouts | Lab | ✓ | Tutorial | Repeating regions generated from view object rows, dynamic sections, per-row content | 102§3.26 |

#### Module B102-11: Wizards, Rich Inputs and Configurable Pages

**Type:** Extended | **Days:** 3.8 | **Labs:** [LABS.md](LABS.md), Section 13  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-11.1 | Implementing Train Region | Lab | ✓ | Examples | Multi-step processes, train stops, navigation, validation, progress tracking | 102§3.5 |
| B102-11.2 | Implementing Shuttle Region | Lab | ✓ | Tutorial | Dual-list selection, moving items, ordering, search functionality | 102§3.6 |
| B102-11.3 | Multi-Step Create and Update Flows | Lab | ✓ | Project | Train-based wizards, transaction state across steps, iterative versus single-submit updates | 102§3.23 |
| B102-11.4 | Implementing Rich Inputs: Rich Text Editor, Color Picker and Rating Bar | Lab | ✓ | Tutorial | richTextEditor, messageRichTextEditor, colorPicker, messageRatingBar | 102§3.20 |
| B102-11.5 | Configurable Pages with flexibleLayout and flexibleContent | Lab | ✓ | Project | flexibleLayout, flexibleContent, flexibleContentList, user and admin dashboard tiles | 102§3.22 |

#### Module B102-12: Flexfields, SPEL and Forms Integration

**Type:** Extended | **Days:** 4.6 | **Labs:** [LABS.md](LABS.md), Section 13  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [LOVPatterns.java](code-brain/view-layer/lov/LOVPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-12.1 | Implementing Key Flexfield Region | Lab | ✓ | Tutorial | KFF configuration, binding to page, validation, capturing values | 102§3.12 |
| B102-12.2 | Implementing Descriptive Flexfield Region | Lab | ✓ | Tutorial | DFF configuration, context-sensitive DFF, EO integration, querying | 102§3.13 |
| B102-12.3 | Changing Item Properties Using SPEL | Lab | ✓ | Examples | SPEL syntax, conditional properties, dynamic rendering, performance | 102§3.14 |
| B102-12.4 | Adding Custom HTML Code | Lab | ✓ | Guide | RawText component, JavaScript integration, security, best practices | 102§3.11 |
| B102-12.5 | Launching Oracle Forms from OAF | Lab | ✓ | Tutorial | Form function call, parameter passing, integration patterns | 102§3.15 |
| B102-12.6 | Launching OAF Pages from Oracle Forms | Lab | ✓ | Guide | ICX integration, URL construction, SSO considerations | 102§3.16 |

### Section 102.6: Controller, Data and Integration

**Modules:** 3 | **Days:** 16.9

#### Module B102-13: Client-Side Scripting and Page Modes

**Type:** Extended | **Days:** 1.5 | **Labs:** [LABS.md](LABS.md), Section 14  
**Code-brain examples:** [AdvancedControllerPatterns.java](code-brain/controller-layer/advanced/AdvancedControllerPatterns.java), [DynamicUIHelper.java](code-brain/view-layer/dynamic-ui/DynamicUIHelper.java), [NavigationPatterns.java](code-brain/controller-layer/navigation/NavigationPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-13.1 | Using JavaScript in OA Framework | Lab | ✓ | Guide | Client-side validation, UI enhancements, calling Java, security | 102§4.6 |
| B102-13.2 | Implementing Read-Only Page | Lab | ✓ | Tutorial | Disabling inputs, visual indicators, conditional read-only mode | 102§4.7 |

#### Module B102-14: Data Formatting and Validation

**Type:** Extended | **Days:** 3.1 | **Labs:** [LABS.md](LABS.md), Section 15  
**Code-brain examples:** [DataValidation.java](code-brain/model-layer/validation/DataValidation.java), [ValidationPatterns.java](code-brain/model-layer/validation/ValidationPatterns.java), [JobEOExpertImpl.java](code-brain/model-layer/entity-objects/JobEOExpertImpl.java), [ValidationHelper.java](code-brain/foundation/utilities/ValidationHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-14.1 | Date Manipulation & Formatting | Lab | ✓ | Tutorial | Date comparisons, Oracle date formats, timezone handling, calculations | 102§5.1 |
| B102-14.2 | Formatting Numbers | Lab | ✓ | Examples | Number formats, currency display, locale considerations, decimal precision | 102§5.2 |
| B102-14.3 | Data Validations | Lab | ✓ | Guide | Field-level validation, cross-field validation, business rule validation | 102§5.3 |
| B102-14.4 | Implementing Validation Using Entity Expert | Lab | ✓ | Tutorial | Entity Expert pattern, reusable validation, complex business rules, messages | 102§5.4 |

#### Module B102-15: Advanced Features and Integrations

**Type:** Extended | **Days:** 12.3 | **Labs:** [LABS.md](LABS.md), Section 16  
**Code-brain examples:** [FileUploadCO.java](code-brain/controller-layer/FileUploadCO.java), [PDFUploadCO.java](code-brain/controller-layer/PDFUploadCO.java), [ExcelOperations.java](code-brain/integration/excel/ExcelOperations.java), [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java), [ProfileOptionPatterns.java](code-brain/cross-cutting/configuration/ProfileOptionPatterns.java), [NavigationPatterns.java](code-brain/controller-layer/navigation/NavigationPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-15.1 | Setting Default Values | Lab | ✓ | Tutorial | Text fields, number fields, date fields, techniques and best practices | 102§6.1 |
| B102-15.2 | Understanding MDS Repository | Video | ✓ | Guide | How page metadata is stored and queried, from a developer view; MDS architecture and administration are covered in Cust 101 | 102§6.2 |
| B102-15.3 | Important Profile Options | Video | ✓ | Reference | Key profile options, impact on behavior, setting programmatically | 102§6.3 |
| B102-15.4 | Implementing Attachments Functionality | Lab | ✓ | Tutorial | FND_ATTACHED_DOCUMENTS, configuration, UI integration, file storage; attachmentTable, attachmentLink, attachmentImage, messageInlineAttachment, entityMap, categoryMap, primaryKey | 102§6.4 |
| B102-15.5 | Implementing Upload Files Functionality | Lab | ✓ | Tutorial | File upload component, server-side handling, validation, storage options; messageFileUpload | 102§6.5 |
| B102-15.6 | Implementing Import Data Functionality | Lab | ✓ | Examples | CSV/Excel import, data validation, batch processing, error handling | 102§6.6 |
| B102-15.7 | Implementing Export Data Functionality | Lab | ✓ | Tutorial | Export formats (CSV, Excel, PDF), large data sets, streaming, performance | 102§6.7 |
| B102-15.8 | Publishing Documents to the Document Catalog | Lab | ✓ | Guide | Document set upload, catalog publishing, AntiSamy filtering and virus scanning on upload | 102§6.13 |
| B102-15.9 | Inline PDF Viewing and Secure File Download | Lab | ✓ | Tutorial | Rendering PDFs inline, streaming binary files, secure download handling; messageDownload | 102§6.14 |
| B102-15.10 | Handling Browser Back Button | Lab | ✓ | Guide | Back button issues, prevention techniques, transaction integrity | 102§6.8 |
| B102-15.11 | Workflow in OA Framework | Lab | ✓ | Tutorial | Launching workflow, passing parameters, monitoring, embedding OAF in notification | 102§6.9 |
| B102-15.12 | Deep Linking and Bookmarkable URLs | Lab | ✓ | Guide | RF.jsp, OA.jsp and OAD.jsp URLs, passing parameters, security of direct page access | 102§6.15 |
| B102-15.13 | Submitting Concurrent Requests from OAF Pages | Lab | ✓ | Tutorial | Declarative request submission, monitoring requests, passing parameters | 102§6.10 |
| B102-15.14 | Multi-Language Support and Internationalization | Lab | ✓ | Guide | MLS and _TL tables, timezone conversion, client character encoding, right-to-left alignment | 102§6.11 |
| B102-15.15 | Accessibility: Screen Reader Mode, Row Headers and Accelerator Keys | Lab | ✓ | Checklist | Screen reader optimized mode, rowheadercol, keyboard accelerator keys | 102§6.12 |
| B102-15.16 | Enhanced Save Model: Warning on Unsaved Changes | Lab | ✓ | Tutorial | Detecting uncommitted changes, warning before navigating away, save and discard flows | 102§6.16 |

### Section 102.7: Debugging, Projects and Assessment

**Modules:** 2 | **Days:** 6.9

#### Module B102-16: Advanced Debugging

**Type:** Extended | **Days:** 2.3 | **Labs:** [LABS.md](LABS.md), Section 17  
**Code-brain examples:** [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java), [OAExceptionHandling.java](code-brain/cross-cutting/error-handling/OAExceptionHandling.java), [MessageHelper.java](code-brain/cross-cutting/utils/MessageHelper.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-16.1 | Using demasy-oaf Libraries for Debugging | Lab | ✓ | Tutorial | Library overview, installation, debug utilities, performance profiling | 102§7.1 |
| B102-16.2 | Advanced Debugging Techniques | Lab | ✓ | Guide | Remote debugging, production debugging, log analysis, performance profiling | 102§7.3 |
| B102-16.3 | Diagnostic Pages: About This Page and OAInfo.jsp | Lab | ✓ | Guide | Page inspector, OAInfo.jsp, technology stack and profile option inspection, regionMap.xml | 102§7.6 |

#### Module B102-17: Projects and Final Assessment

**Type:** Required | **Days:** 4.6  
**Code-brain examples:** [JobEOImpl.java](code-brain/case-studies/jobs-positions-management/JobEOImpl.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B102-17.1 | Project 101: Project Kickoff and Planning | Workshop | ✓ | Project Guide | Setting up project structure, Git version control, database design, project planning, team collaboration setup; applied to Project 102 (the POS system is the Dev 103 capstone) (Duration: 2.5 Days) | 102§8.1 |
| B102-17.2 | Project 102: Items Creation with Approval Cycle | Lab | ✓ | Requirements | Multi-step approval workflow, complex business logic, workflow integration, advanced UI features, item creation form, multi-level approvals, email notifications, approval history, advanced search and reporting (Duration: 5 Days) | 102§8.2 |
| B102-17.3 | Final Assessment Overview and Project Selection | Workshop | ✓ | Assessment Guide | Comprehensive project requirements, choosing between Option A (Advanced HR Management System) or Option B (Procurement Request System), planning and timeline | 102§9.1 |
| B102-17.4 | Option A: Advanced HR Management System | Lab | ✓ | Project Spec | Employee self-service portal, manager approval workflows, workflow integration, reports and dashboards, complete HRIS functionality | 102§9.2 |
| B102-17.5 | Option B: Procurement Request System | Lab | ✓ | Project Spec | Purchase requisition creation, multi-level approval process, budget validation logic, PO integration, procurement workflow | 102§9.3 |
| B102-17.6 | Assessment Criteria and Deliverables | Workshop | ✓ | Rubric | All Level 102 concepts (40%), Code quality and standards (25%), Architecture and design (20%), Documentation (10%), Innovation and extras (5%) | 102§9.4 |

## Level 103: Dev 103: Oracle OAF Building BootCamp (Ninja)

**Code:** DL-OAF-B-103 | **Syllabus:** [SYLLABUS_103.md](SYLLABUS_103.md)  
20-30 days | 20% scaffolding | Prerequisite: Dev 102 | 85% pass gate | Milestone: Master OAF Developer

**Learning outcomes**

- **LO3.1:** Design and architect complete enterprise applications
- **LO3.2:** Build production-ready OAF systems from scratch
- **LO3.3:** Implement complex business logic and workflows
- **LO3.4:** Apply advanced design patterns and best practices
- **LO3.5:** Optimize performance of large-scale applications
- **LO3.6:** Lead OAF development projects
- **LO3.7:** Mentor junior developers

**Modules at a glance**

| Module | Title | Type | Section | Lectures | Days |
| :-- | :-- | :-: | :-- | :-: | :-: |
| B103-1 | MDS Repository Deployment | Core | 1. Production Readiness | 1 | 0.7 |
| B103-2 | BC4J Configuration Upload | Core | 1. Production Readiness | 1 | 0.7 |
| B103-3 | AOL Security & Page Registration | Core | 1. Production Readiness | 2 | 1.3 |
| B103-4 | Enterprise Instrumentation | Core | 1. Production Readiness | 2 | 1.3 |
| B103-5 | Log Management & Maintenance | Core | 1. Production Readiness | 1 | 0.7 |
| B103-6 | EBS R12.2 Online Patching | Core | 1. Production Readiness | 1 | 0.7 |
| B103-7 | Automated Packaging & Scripting | Core | 1. Production Readiness | 2 | 1.3 |
| B103-8 | Project Setup and Planning | Required | 2. POS Capstone Project | 5 | 3.3 |
| B103-9 | Store Management Module | Required | 2. POS Capstone Project | 5 | 3.3 |
| B103-10 | Product Management Module | Required | 2. POS Capstone Project | 3 | 2 |
| B103-11 | Branch Management (Master-Detail) | Required | 2. POS Capstone Project | 1 | 0.7 |
| B103-12 | Sales and Transactions Module | Required | 2. POS Capstone Project | 3 | 2 |
| B103-13 | Advanced Features and Polish | Required | 2. POS Capstone Project | 3 | 2 |
| B103-14 | Deployment and Presentation | Required | 2. POS Capstone Project | 4 | 2.7 |
| B103-15 | Final Assessment | Required | 2. POS Capstone Project | 6 | 4 |
| B103-16 | Advanced Tables, Grids and Visualization | Extended | 3. Advanced Enterprise Topics | 7 | 4.7 |
| B103-17 | Advanced Search and Navigation | Extended | 3. Advanced Enterprise Topics | 6 | 4 |
| B103-18 | State Management, Back Button and Security | Extended | 3. Advanced Enterprise Topics | 7 | 4.7 |
| B103-19 | REST and Product Integration | Extended | 3. Advanced Enterprise Topics | 6 | 4 |

### Section 103.1: Production Readiness

**Modules:** 7 | **Days:** 6.7

#### Module B103-1: MDS Repository Deployment

**Type:** Core | **Days:** 0.7  
**Technical focus:** XMLImporter, Database Connections, $JAVA_TOP  
**Learning outcome:** Deploy XML page definitions directly to the MDS database repository.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-1.1 | Deploying Pages with XMLImporter | Lab | ✓ | Guide | -rootdir, -username, -password, -dbconnection parameters, $JAVA_TOP layout | 103§13.1 |

#### Module B103-2: BC4J Configuration Upload

**Type:** Core | **Days:** 0.7  
**Technical focus:** JPXImporter, .jpx Project Files, Classpath Specs  
**Learning outcome:** Register global business component configurations in the repository.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-2.1 | Registering BC4J Configuration with JPXImporter | Lab | ✓ | Guide | .jpx project files, classpath specifications, repository registration | 103§13.2 |

#### Module B103-3: AOL Security & Page Registration

**Type:** Core | **Days:** 1.3  
**Technical focus:** Form Functions, Menus, Responsibilities, SSWA Parameters  
**Learning outcome:** Secure custom OAF pages within standard Oracle EBS menu structures.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-3.1 | Defining Form Functions for OAF Pages | Lab | ✓ | Guide | SSWA jsp function, page path and parameters | 103§14.1 |
| B103-3.2 | Menus and Responsibilities | Lab | ✓ | Guide | Attaching functions to menus, assigning responsibilities, testing access | 103§14.2 |

#### Module B103-4: Enterprise Instrumentation

**Type:** Core | **Days:** 1.3  
**Technical focus:** FND_LOG, writeDiagnostics(), FND_LOG_MESSAGES  
**Learning outcome:** Implement real-time system diagnostics and performance tracing.  
**Code-brain examples:** [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-4.1 | FND_LOG Framework and Profile Options | Lab | ✓ | Guide | FND: Debug Log Enabled, FND: Debug Log Level, FND_LOG_MESSAGES | 103§15.1 |
| B103-4.2 | Writing Diagnostics from Code | Lab | ✓ | Tutorial | pageContext.writeDiagnostics(), screen logging, performance tracing; SQL trace with event 10046 | 103§15.2 |

#### Module B103-5: Log Management & Maintenance

**Type:** Core | **Days:** 0.7  
**Technical focus:** FNDLGPRG Concurrent Program, FND_LOG_ADMIN Package  
**Learning outcome:** Automate log purging and manage diagnostic table storage.  
**Code-brain examples:** [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java), [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-5.1 | Purging Logs with FNDLGPRG | Lab | ✓ | Guide | Concurrent program, FND_LOG_ADMIN package, table storage | 103§15.3 |

#### Module B103-6: EBS R12.2 Online Patching

**Type:** Core | **Days:** 0.7  
**Technical focus:** adop Cycle, Dual File Systems, Patch Synchronization  
**Learning outcome:** Align application deployments with Oracle R12.2 patching rules.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-6.1 | Online Patching (adop) Fundamentals | Video | ✓ | Diagram | Run edition versus patch edition, patch phases, classpath configuration | 103§16.1 |

#### Module B103-7: Automated Packaging & Scripting

**Type:** Core | **Days:** 1.3  
**Technical focus:** adcgnjar, customall.jar, $AD_APPS_JDBC_URL  
**Learning outcome:** Build repeatable deployment scripts using dynamic environment variables.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-7.1 | Compiling and Archiving with adcgnjar | Lab | ✓ | Guide | $AD_TOP/bin/adcgnjar, customall.jar, signed archives under $JAVA_TOP | 103§16.2 |
| B103-7.2 | Scripted Deployment | Lab | ✓ | Project | Environment variables such as $AD_APPS_JDBC_URL in place of hardcoded connection strings | 103§16.3 |

### Section 103.2: POS Capstone Project

**Modules:** 8 | **Days:** 20

#### Module B103-8: Project Setup and Planning

**Type:** Required | **Days:** 3.3  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-8.1 | Setting-Up Development Environment | Lab | ✓ | Guide | Professional workspace setup, team collaboration tools, code repository structure | 103§1.1 |
| B103-8.2 | Installing Git (Version Control System) | Lab | ✓ | Tutorial | Git fundamentals, branching strategy, commit conventions, pull requests | 103§1.2 |
| B103-8.3 | Create Workspaces and Projects | Lab | ✓ | Template | Project structure, naming conventions, module organization | 103§1.3 |
| B103-8.4 | Create & Test Database Connection | Lab | ✓ | Guide | Development database, connection pooling, testing connectivity | 103§1.4 |
| B103-8.5 | Installing the Database Objects | Lab | ✓ | Scripts | Database schema design, tables and relationships, sequences and triggers, sample data | 103§1.5 |

#### Module B103-9: Store Management Module

**Type:** Required | **Days:** 3.3  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-9.1 | Implementing Store Query Page (SELECT) | Lab | ✓ | Project | Search functionality, multiple criteria, results table, pagination, export to Excel | 103§2.1 |
| B103-9.2 | Implementing Store Drill-Down Page (SELECT) | Lab | ✓ | Project | Master-detail display, related information, navigation, breadcrumbs | 103§2.2 |
| B103-9.3 | Implementing Store Create Page (INSERT) | Lab | ✓ | Project | Data entry form, validation, confirmation, success message | 103§2.3 |
| B103-9.4 | Implementing Store Delete Page (DELETE) | Lab | ✓ | Project | Confirmation dialog, business rule validation, cascade delete handling, audit trail | 103§2.4 |
| B103-9.5 | Implementing Store Update Page (UPDATE) | Lab | ✓ | Project | Edit form, version control, concurrent update handling, change tracking | 103§2.5 |

#### Module B103-10: Product Management Module

**Type:** Required | **Days:** 2  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-10.1 | Explaining the Practice Assignment | Workshop | ✓ | Requirements | Requirements specification, business rules, acceptance criteria, deliverables | 103§3.1 |
| B103-10.2 | Implementing Product CRUD Functionality | Lab | ✓ | Project | Query page, create page, update page, delete functionality, drill-down details | 103§3.2 |
| B103-10.3 | Explaining the Practice Solution | Workshop | ✓ | Review | Solution walkthrough, best practices applied, alternative approaches, lessons learned | 103§3.3 |

#### Module B103-11: Branch Management (Master-Detail)

**Type:** Required | **Days:** 0.7  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-11.1 | Implementing Branch Page (Master-Details) | Lab | ✓ | Project | Master: Branch info, address, contact, hours; Detail 1: Store assignments with shuttle; Detail 2: Employee assignments with advanced table; Detail 3: Inventory summary with PPR | 103§4.1 |

#### Module B103-12: Sales and Transactions Module

**Type:** Required | **Days:** 2  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-12.1 | Sales Transaction Processing | Lab | ✓ | Project | POS interface, product selection, quantity and pricing, discounts, payment, receipts | 103§5.1 |
| B103-12.2 | Inventory Management | Lab | ✓ | Project | Stock tracking, reorder alerts, transfer between stores, inventory reports | 103§5.2 |
| B103-12.3 | Reporting and Analytics | Lab | ✓ | Project | Sales reports, inventory reports, employee performance, charts and graphs, export | 103§5.3 |

#### Module B103-13: Advanced Features and Polish

**Type:** Required | **Days:** 2 | **Labs:** [LABS.md](LABS.md), Sections 18-20 (partly related)  
**Code-brain examples:** [PerformanceMonitor.java](code-brain/foundation/diagnostics/PerformanceMonitor.java), [DiagnosticsLogger.java](code-brain/foundation/diagnostics/DiagnosticsLogger.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-13.1 | Advanced Features | Lab | ✓ | Project | Attachments for documents, workflow integration, audit trail, security, multi-language support | 103§6.1 |
| B103-13.2 | Performance Optimization | Lab | ✓ | Project | Query optimization, caching strategies, large data set handling, response time improvement | 103§6.2 |
| B103-13.3 | Error Handling and Logging | Lab | ✓ | Project | Comprehensive error messages, debug logging, production monitoring, user help system | 103§6.3 |

#### Module B103-14: Deployment and Presentation

**Type:** Required | **Days:** 2.7  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-14.1 | Deployment to Production | Lab | ✓ | Guide | Deployment package creation, installation instructions, production deployment, post-deployment validation | 103§7.1 |
| B103-14.2 | Documentation | Workshop | ✓ | Templates | Technical documentation, user manual, installation guide, troubleshooting guide | 103§7.2 |
| B103-14.3 | Project Presentation | Workshop | ✓ | Guide | Demo preparation, presentation to stakeholders, Q&A handling | 103§7.3 |
| B103-14.4 | Mentoring and Code Review | Workshop | ✓ | Guide | Reviewing a peer implementation, giving actionable feedback, coaching a junior developer through a defect, review checklist | 103§7.4 |

#### Module B103-15: Final Assessment

**Type:** Required | **Days:** 4  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-15.1 | Comprehensive Evaluation Criteria | Workshop | ✓ | Rubric | Functional Completeness (30%): All modules working, business rules implemented, no critical bugs | 103§8.1 |
| B103-15.2 | Code Quality Assessment | Workshop | ✓ | Standards Guide | Code Quality (25%): Standards compliance, maintainability, documentation, test coverage | 103§8.2 |
| B103-15.3 | Architecture & Design Review | Workshop | ✓ | Design Patterns | Architecture & Design (20%): MVC implementation, scalability, reusability, performance | 103§8.3 |
| B103-15.4 | Professional Deliverables Review | Workshop | ✓ | Checklist | Professional Deliverables (15%): Complete documentation, deployment package, user manual, presentation | 103§8.4 |
| B103-15.5 | Innovation & Excellence Showcase | Workshop | ✓ | Portfolio | Innovation & Excellence (10%): Creative solutions, additional features, problem-solving, exceeding requirements | 103§8.5 |
| B103-15.6 | Ninja Level Certification | Workshop | ✓ | Success Criteria | Success Criteria: Score ≥ 85% on all criteria, production-ready application, professional presentation, complete documentation, demonstrates mastery | 103§8.6 |

### Section 103.3: Advanced Enterprise Topics

**Modules:** 4 | **Days:** 17.3

#### Module B103-16: Advanced Tables, Grids and Visualization

**Type:** Extended | **Days:** 4.7  
**Code-brain examples:** [TablePatterns.java](code-brain/view-layer/tables/TablePatterns.java), [ExcelOperations.java](code-brain/integration/excel/ExcelOperations.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-16.1 | Advanced Tables | Lab | ✓ | Guide | Column groups, sortable headers, selection, total rows, detail disclosure, table-in-table | 103§9.1 |
| B103-16.2 | Classic Tables and Migration | Video | ✓ | Guide | Comparison with advanced tables, usage limits, migration strategy | 103§9.2 |
| B103-16.3 | Rich Table Interactions | Lab | ✓ | Guide | Resize, reorder, freeze, hide/show columns, scrolling; touch-device optimizations | 103§9.3 |
| B103-16.4 | Exporting Table Data *(verify)* | Lab | ✓ | Guide | Excel and PDF export, transient columns, export limits *(verify)* | 103§9.4 |
| B103-16.5 | HGrid and Tree | Lab | ✓ | Project | OAHGridBean, OATreeBean, focus and hierarchy columns, child row retrieval | 103§9.5 |
| B103-16.6 | Charts, Graphs and Infotiles *(verify)* | Lab | ✓ | Guide | BI beans and JET transition, Gantt, Infotiles *(verify)* | 103§9.6 |
| B103-16.7 | Masonry Layout Dashboards | Lab | ✓ | Guide | Grid-based responsive dashboards, status tiles, KPI cards *(verify)* | 103§9.7 |

#### Module B103-17: Advanced Search and Navigation

**Type:** Extended | **Days:** 4  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-17.1 | Search Architecture | Lab | ✓ | Guide | Query regions, simple and advanced search, results-based search | 103§10.1 |
| B103-17.2 | List Search Framework | Lab | ✓ | Guide | Filter panels, saved searches, quick and keyword search | 103§10.2 |
| B103-17.3 | Infotile-Driven Search | Lab | ✓ | Project | Summary tiles with metric counts that filter a results table | 103§10.5 |
| B103-17.4 | Quick Search and Side Navigation Search | Lab | ✓ | Guide | Compact search inputs in global headers and side navigation | 103§10.6 |
| B103-17.5 | Navigation Components | Lab | ✓ | Guide | Trains, subtabs, accordions, hide/show, popups, shuttles | 103§10.3 |
| B103-17.6 | Declarative Page Flows | Lab | ✓ | Guide | Destination function and workflow page flows, transaction state | 103§10.4 |

#### Module B103-18: State Management, Back Button and Security

**Type:** Extended | **Days:** 4.7  
**Code-brain examples:** [EntityObjectPatterns.java](code-brain/model-layer/entity-objects/EntityObjectPatterns.java), [PLSQLIntegration.java](code-brain/integration/plsql/PLSQLIntegration.java), [SecurityPatterns.java](code-brain/security/SecurityPatterns.java), [SecurityValidator.java](code-brain/foundation/security/SecurityValidator.java), [NavigationPatterns.java](code-brain/controller-layer/navigation/NavigationPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-18.1 | Advanced Entity Mechanics | Lab | ✓ | Guide | Polymorphic entities, parent/child posting order, transient attributes | 103§11.1 |
| B103-18.2 | PL/SQL Entity Objects | Lab | ✓ | Guide | Wrapping PL/SQL table APIs, key generation, locking, error mapping | 103§11.2 |
| B103-18.3 | State Retention and Pooling | Video | ✓ | Guide | Retention levels, passivation, session limits, connection pool monitoring | 103§11.3 |
| B103-18.4 | Resource Swapping and Memory Caching | Video | ✓ | Guide | AM pooling and resource swapping, JDBC pool tuning, memory caching, resource conservation | 103§11.7 |
| B103-18.5 | Browser Back Button Support | Lab | ✓ | Guide | Page instance IDs, transaction units, back-button detection | 103§11.4 |
| B103-18.6 | Page, Function and Data Security | Lab | ✓ | Guide | Function security, data grants, page access tracking | 103§11.5 |
| B103-18.7 | Input Hardening | Lab | ✓ | Guide | XSS scanning, AntiSamy HTML filtering, virus scanning, frame busting | 103§11.6 |

#### Module B103-19: REST and Product Integration

**Type:** Extended | **Days:** 4  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| B103-19.1 | OAF REST Servlet | Lab | ✓ | Guide | Exposing AM methods, service data objects, testing business service objects; BSO API tester | 103§12.1 |
| B103-19.2 | Application Web Services | Video | ✓ | Guide | Business service objects, attachments service, home page service | 103§12.2 |
| B103-19.3 | Consuming External SOAP and REST Services | Lab | ✓ | Project | Calling external services from application module code, error handling, timeouts | 103§12.6 |
| B103-19.4 | Forms and Workflow Integration | Lab | ✓ | Guide | Launching Forms from OAF and back, worklist notifications; JTT application launch and parameter passing *(verify the term and scope)* | 103§12.3 |
| B103-19.5 | Portal and Analytics Embedding *(verify)* | Video | ✓ | Guide | Portlet integration, embedding analytics *(verify)*; OBIEE analytics embedding | 103§12.4 |
| B103-19.6 | Reviewing and Approving Workflow Notifications from OAF | Lab | ✓ | Guide | Notification pages, approve and reject actions, worklist review | 103§12.5 |

## Level C101: Cust 101: Oracle OAF Customizing BootCamp (Beginner)

**Code:** DL-OAF-C-101 | **Syllabus:** [SYLLABUS_CUST_101.md](SYLLABUS_CUST_101.md)  
10-15 days (proposed) | 60% scaffolding | Prerequisite: Dev 101 and EBS system administration | Milestone: Certified Personalization Specialist

**Learning outcomes**

- **LOC1.1:** Explain personalization, extension and modification, and when to use each
- **LOC1.2:** Describe how personalizations are stored in the MDS repository
- **LOC1.3:** Create and manage personalizations at every level
- **LOC1.4:** Inspect, export, import and delete MDS content

**Modules at a glance**

| Module | Title | Type | Section | Lectures | Days |
| :-- | :-- | :-: | :-- | :-: | :-: |
| C101-1 | Upgrade Preservation Principles | Core | 1. Upgrade-Safe Foundations | 4 | 3.1 |
| C101-2 | Personalization Hierarchy | Core | 1. Upgrade-Safe Foundations | 1 | 0.8 |
| C101-3 | Functional Administrator Tool | Core | 1. Upgrade-Safe Foundations | 2 | 1.5 |
| C101-4 | UI Component Personalization | Core | 2. Declarative Customization and Migration | 3 | 2.3 |
| C101-5 | Declarative Region Injections | Core | 2. Declarative Customization and Migration | 1 | 0.8 |
| C101-6 | Personalization Migration | Core | 2. Declarative Customization and Migration | 3 | 2.3 |
| C101-7 | LOV Declarative Alteration | Core | 2. Declarative Customization and Migration | 1 | 0.8 |
| C101-8 | Diagnostics and Translation | Extended | 3. Diagnostics and Assessment | 2 | 1.5 |
| C101-9 | Cust 101 Assessment | Required | 3. Diagnostics and Assessment | 1 | 0.8 |

### Section C101.1: Upgrade-Safe Foundations

**Modules:** 3 | **Days:** 5.4

#### Module C101-1: Upgrade Preservation Principles

**Type:** Core | **Days:** 3.1 | **Labs:** [LABS.md](LABS.md), Section 9  
**Technical focus:** Personalization Layering, MDS Repository, Maintenance  
**Learning outcome:** Implement UI changes while preserving system upgrade paths.  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java), [ProfileOptionPatterns.java](code-brain/cross-cutting/configuration/ProfileOptionPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-1.1 | Customization Hierarchy | Video | ✓ | Diagram | Personalization, extension, modification; what is supported | C101§1.1 |
| C101-1.2 | Durable Personalizations | Video | ✓ | Diagram | Delta overlays stored apart from base metadata, survival across patches | C101§1.2 |
| C101-1.3 | MDS Repository | Video | ✓ | Guide | Repository tables, document paths (`/oracle/apps/...`), XML documents | C101§1.3 |
| C101-1.4 | Implementing Personalizations in OAF | Video | ✓ | Guide | User-level, admin-level customization, personalization limits | 101§9.7 (moved) |

#### Module C101-2: Personalization Hierarchy

**Type:** Core | **Days:** 0.8  
**Technical focus:** Site, Application, Responsibility, and User Levels  
**Learning outcome:** Target declarative personalizations to specific user contexts.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-2.1 | Personalization Levels and Precedence | Lab | ✓ | Guide | Function, organization, responsibility, site and localization levels | C101§1.4 |

#### Module C101-3: Functional Administrator Tool

**Type:** Core | **Days:** 1.5  
**Technical focus:** Administer Personalizations UI, MDS Cache Invalidation  
**Learning outcome:** Execute real-time UI modifications and administer MDS memory.  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-3.1 | Enabling Personalization | Lab | ✓ | Guide | Personalization profile options, Functional Administrator responsibility | C101§2.2 |
| C101-3.2 | Clearing MDS Caches | Lab | ✓ | Guide | Functional Administrator cache invalidation, seeing personalization changes immediately | C101§3.5 |

### Section C101.2: Declarative Customization and Migration

**Modules:** 4 | **Days:** 6.2

#### Module C101-4: UI Component Personalization

**Type:** Core | **Days:** 2.3  
**Technical focus:** Visual Attributes, Rendered Flags, Read-Only Enforcement  
**Learning outcome:** Modify default properties of standard Oracle interface controls.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-4.1 | End-User Personalizations | Lab | ✓ | Guide | Personalized views, saved queries, column order, hiding fields | C101§2.1 |
| C101-4.2 | Declarative Page Personalizations | Lab | ✓ | Project | Show/hide, reorder, labels, required and rendered, defaults, item styles | C101§2.3 |
| C101-4.3 | Flexfield and Table Personalizations | Lab | ✓ | Guide | DFF/KFF rendering, row counts, export buttons, accessibility columns | C101§2.4 |

#### Module C101-5: Declarative Region Injections

**Type:** Core | **Days:** 0.8  
**Technical focus:** Stack Layouts, Buttons, Static Region Extensions  
**Learning outcome:** Inject supplementary UI elements into standard Oracle pages.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-5.1 | Declarative Region Injection | Lab | ✓ | Project | Inject stack layouts, tables, buttons and extended regions into seeded pages | C101§2.5 |

#### Module C101-6: Personalization Migration

**Type:** Core | **Days:** 2.3  
**Technical focus:** XMLExporter, XMLImporter, Customization XML Files  
**Learning outcome:** Migrate personalization packages between EBS database instances.  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-6.1 | Exporting Personalizations with XMLExporter | Lab | ✓ | Guide | Extract personalization XML from MDS, migrate between environments with XMLImporter | C101§3.6 |
| C101-6.2 | MDS Management Tools | Lab | ✓ | Guide | Export to file system, XMLImporter import, delete site or user personalizations | C101§3.3 |
| C101-6.3 | Inspecting MDS Content | Lab | ✓ | Guide | Region map, printing region XML, listing personalizations | C101§3.2 |

#### Module C101-7: LOV Declarative Alteration

**Type:** Core | **Days:** 0.8  
**Technical focus:** LOV Region Personalization, Where Clause Overrides  
**Learning outcome:** Restrict data selection queries in seeded search dialogs declaratively.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-7.1 | LOV Personalization | Lab | ✓ | Guide | Restrict LOV result sets, change list parameters, alter displays declaratively | C101§2.6 |

### Section C101.3: Diagnostics and Assessment

**Modules:** 2 | **Days:** 2.3

#### Module C101-8: Diagnostics and Translation

**Type:** Extended | **Days:** 1.5  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-8.1 | "About This Page" Diagnostics | Lab | ✓ | Guide | Page context, active personalizations, technology stack, profile options | C101§3.1 |
| C101-8.2 | Translated Personalizations | Video | ✓ | Guide | Managing translated personalization content | C101§3.4 |

#### Module C101-9: Cust 101 Assessment

**Type:** Required | **Days:** 0.8  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C101-9.1 | Personalization Project | Workshop | ✓ | Rubric | Personalize a seeded page at two levels and promote it with XMLImporter. Proposed criteria: personalization correctness 40, level targeting and precedence 20, migration with XMLExporter and XMLImporter 25, documentation 15 | C101§4.1 |

## Level C102: Cust 102: Oracle OAF Customizing BootCamp (Advanced)

**Code:** DL-OAF-C-102 | **Syllabus:** [SYLLABUS_CUST_102.md](SYLLABUS_CUST_102.md)  
10-15 days (proposed) | 40% scaffolding | Prerequisite: Dev 102, Cust 101, Dev 103 production-readiness core, advanced Java | Milestone: Master Customization Architect

**Learning outcomes**

- **LOC2.1:** Apply extension standards and place custom code correctly
- **LOC2.2:** Extend view, entity and application module objects
- **LOC2.3:** Deploy substitutions and extended controllers
- **LOC2.4:** Package, deploy and promote customizations across environments

**Modules at a glance**

| Module | Title | Type | Section | Lectures | Days |
| :-- | :-- | :-: | :-- | :-: | :-: |
| C102-1 | Controller Class Extensions | Core | 1. Extending Controllers and Business Components | 1 | 0.7 |
| C102-2 | Business Component Extensions | Core | 1. Extending Controllers and Business Components | 3 | 2 |
| C102-6 | Programmatic LOV Extensions | Core | 1. Extending Controllers and Business Components | 1 | 0.7 |
| C102-3 | BC4J Substitution Registration | Core | 2. Substitution, Packaging and Deployment | 2 | 1.3 |
| C102-4 | Archive Packaging & Utilities | Core | 2. Substitution, Packaging and Deployment | 2 | 1.3 |
| C102-5 | R12.2 Filesystem Synchronization | Core | 2. Substitution, Packaging and Deployment | 1 | 0.7 |
| C102-7 | Extension Troubleshooting | Core | 3. Troubleshooting | 1 | 0.7 |
| C102-8 | Extension Architecture and Standards | Required | 4. Standards, Release and Assessment | 4 | 2.7 |
| C102-9 | Release and Environment Promotion | Required | 4. Standards, Release and Assessment | 3 | 2 |
| C102-10 | Cust 102 Assessment | Required | 4. Standards, Release and Assessment | 1 | 0.7 |

### Section C102.1: Extending Controllers and Business Components

**Modules:** 3 | **Days:** 3.3

#### Module C102-1: Controller Class Extensions

**Type:** Core | **Days:** 0.7  
**Technical focus:** OAControllerImpl Subclassing, super Calls, Events  
**Learning outcome:** Inject custom event handling into standard Oracle page flows.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-1.1 | Controller Extensions | Lab | ✓ | Project | Extending `processRequest` and `processFormRequest`, attaching through personalization | C102§3.3 |

#### Module C102-2: Business Component Extensions

**Type:** Core | **Days:** 2  
**Technical focus:** View Object Extensions, Entity Object Inheritance  
**Learning outcome:** Extend seeded SQL queries and table validation logic safely.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-2.1 | Extending View Objects | Lab | ✓ | Project | Transient and mapped attributes, SQL changes, query overrides | C102§2.1 |
| C102-2.2 | Extending Entity Objects | Lab | ✓ | Project | Default values, custom validation rules | C102§2.2 |
| C102-2.3 | Extending Application Modules | Lab | ✓ | Project | Custom transaction methods, nested AM extensions | C102§2.3 |

#### Module C102-6: Programmatic LOV Extensions

**Type:** Core | **Days:** 0.7  
**Technical focus:** LOV Controller Extensions, VO Substitution Integration  
**Learning outcome:** Implement custom business logic inside standard selection dialogs.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-6.1 | Programmatic LOV Extensions | Lab | ✓ | Project | LOV controller extensions, VO substitution for LOV queries | C102§3.5 |

### Section C102.2: Substitution, Packaging and Deployment

**Modules:** 3 | **Days:** 3.3

#### Module C102-3: BC4J Substitution Registration

**Type:** Core | **Days:** 1.3  
**Technical focus:** JPX Substitution Files, JPXImporter, Repository Rules  
**Learning outcome:** Substitute standard business components globally at runtime.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-3.1 | Substitution Mechanism | Video | ✓ | Diagram | How MDS substitutions replace parent objects at runtime | C102§3.1 |
| C102-3.2 | Deploying Substitutions | Lab | ✓ | Guide | JPX files, `jpximport`, verifying active substitutions; extension-specific steps, tooling basics are in Dev 103 | C102§3.2 |

#### Module C102-4: Archive Packaging & Utilities

**Type:** Core | **Days:** 1.3  
**Technical focus:** $AD_TOP/bin/adcgnjar, customall.jar, Manifest Files  
**Learning outcome:** Package custom Java code into signed, enterprise-ready JAR archives.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-4.1 | Archive Packaging with adcgnjar | Lab | ✓ | Guide | $AD_TOP/bin/adcgnjar, customall.jar, manifest files, signed archives; applies the Dev 103 tooling to extensions | C102§4.5 |
| C102-4.2 | Deployment Packaging | Lab | ✓ | Guide | Classes, XML pages and MDS documents under `$JAVA_TOP`; extension-specific steps, tooling basics are in Dev 103 | C102§4.1 |

#### Module C102-5: R12.2 Filesystem Synchronization

**Type:** Core | **Days:** 0.7  
**Technical focus:** adop Cycle, Dual File Systems, adop_sync_drv.tmp  
**Learning outcome:** Synchronize custom class extensions across dual EBS file systems.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-5.1 | R12.2 Filesystem Synchronization | Lab | ✓ | Guide | adop cycle, dual file systems, adop_sync_drv.tmp custom driver entries | C102§4.6 |

### Section C102.3: Troubleshooting

**Modules:** 1 | **Days:** 0.7

#### Module C102-7: Extension Troubleshooting

**Type:** Core | **Days:** 0.7  
**Technical focus:** MDS Cache Invalidation, Classloader Tracing, JPX Audits  
**Learning outcome:** Identify and resolve runtime class conflicts and substitution errors.  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-7.1 | Troubleshooting Extensions | Lab | ✓ | Checklist | Classloader conflicts, substitution load failures, casting exceptions | C102§3.4 |

### Section C102.4: Standards, Release and Assessment

**Modules:** 3 | **Days:** 5.3

#### Module C102-8: Extension Architecture and Standards

**Type:** Required | **Days:** 2.7 | **Labs:** [LABS.md](LABS.md), Section 9  
**Code-brain examples:** [MDSOperations.java](code-brain/cross-cutting/metadata/MDSOperations.java), [ProfileOptionPatterns.java](code-brain/cross-cutting/configuration/ProfileOptionPatterns.java)

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-8.1 | Extension Standards | Video | ✓ | Guide | `xx` prefixes, package structure, extension log | C102§1.1 |
| C102-8.2 | Extension Touchpoints | Video | ✓ | Diagram | Model object extensions versus controller extensions | C102§1.2 |
| C102-8.3 | Custom Code Placement | Video | ✓ | Guide | APPS versus custom schema, grants and synonyms under Edition-Based Redefinition | C102§1.3 |
| C102-8.4 | Creating Extensions for Oracle Pages | Video | ✓ | Best Practices | Extending Oracle pages, custom extensions, upgrade-safe mods | 101§9.8 (moved) |

#### Module C102-9: Release and Environment Promotion

**Type:** Required | **Days:** 2  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-9.1 | Import Tools | Lab | ✓ | Guide | XMLImporter for pages and regions, attribute sets | C102§4.2 |
| C102-9.2 | Function and Menu Registration | Lab | ✓ | Guide | Register functions, attach to menus, assign responsibilities | C102§4.3 |
| C102-9.3 | Environment Promotion | Video | ✓ | Guide | Dev, test and production migration, patching, version control | C102§4.4 |

#### Module C102-10: Cust 102 Assessment

**Type:** Required | **Days:** 0.7  

| Code | Lecture Title | Format | Practice | Resource | Notes | Syllabus |
| :-- | :-- | :-: | :-: | :-: | :-- | :-: |
| C102-10.1 | Extension Project | Workshop | ✓ | Rubric | Extend a seeded page with a substitution and a controller, then deploy it. Proposed criteria: extension correctness 35, substitution and JPX deployment 25, packaging and adop synchronization 20, troubleshooting log 10, documentation 10 | C102§5.1 |

## Component and Capability Catalog

Every OAF user interface component and core capability, with the lectures that teach it. Component names follow the Oracle Application Framework Component Reference. A blank cell would mean a gap; this table has none.

| Area | Component or capability | Type | Lectures |
| :-- | :-- | :-: | :-- |
| Structural | attributeSet, package | Components | B101-6.13 |
| Structural | page | Components | B101-6.3 |
| Structural | Look-and-feel standards (BLAF, Redwood) | Capabilities | B101-6.8 |
| Layout containers | pageLayout | Components | B101-6.3, B101-6.6 |
| Layout containers | header, hideShowHeader | Components | B102-9.1 |
| Layout containers | messageComponentLayout, default* layouts (deprecated in 12.2) | Components | B101-6.7 |
| Layout containers | stackLayout, flowLayout | Components | B102-9.2, B102-9.3 |
| Layout containers | tableLayout, rowLayout, cellFormat | Components | B102-9.6 |
| Layout containers | messageLayout, labeledFieldLayout | Components | B101-6.7 |
| Layout containers | footer (copyright, privacy links) | Components | B101-6.10 |
| Layout containers | Auto-Repeating Layout (ARL) | Components | B102-10.5 |
| Layout containers | flexibleLayout, flexibleContent, flexibleContentList | Components | B102-11.5 |
| Layout containers | contentContainer, richContainer | Components | B102-9.4 |
| Layout containers | panelSplitter, layeredLayout | Components | B102-9.5 |
| Data presentation | table, advancedTable | Components | B102-6.1, B103-16.1, B103-16.2 |
| Data presentation | columnGroup, sortableHeader, totalRow, addTableRow | Components | B103-16.1, B102-6.2 |
| Data presentation | HGrid, tree, nodeDef, childNode | Components | B102-10.2, B103-16.5 |
| Data presentation | bulletedList | Components | B102-10.4 |
| Data presentation | infotile | Components | B103-16.6 |
| Navigation and page flow | train | Components | B102-11.1, B103-17.5 |
| Navigation and page flow | subTabLayout, subTabBar, hideShowSubTabLayout | Components | B103-17.5 |
| Navigation and page flow | menu, menuItem, breadcrumbs, locator | Components | B101-6.14 |
| Navigation and page flow | pageButtonBar, contentFooter | Components | B101-6.10 |
| Input and item controls | Text and labeled inputs (messageTextInput, styledText, formattedText, instructionText) | Components | B101-6.5, B101-6.11 |
| Input and item controls | messageChoice, messageLovChoice, radio, checkbox, spinBox | Components | B101-6.9 |
| Input and item controls | shuttle | Components | B102-11.2 |
| Input and item controls | richTextEditor, colorPicker, messageRatingBar | Components | B102-11.4 |
| Input and item controls | button, submitButton, resetButton, selectionButton, exportButton, link | Components | B101-6.10, B102-7.5 |
| Input and item controls | LOV auto-completion | Capabilities | B102-3.3 |
| Input and item controls | Smart poplist (LOV choice list) | Capabilities | B101-6.9 |
| Input and item controls | lovActionButton, lovActionMap | Components | B102-3.4 |
| Input and item controls | messageStyledText, staticStyledText, rawText | Components | B101-6.11, B102-12.4 |
| Input and item controls | singleSelection, multipleSelection (table row selection) | Components | B102-6.1, B103-16.1 |
| Input and item controls | messageFileUpload, messageDownload | Components | B102-15.5, B102-15.9 |
| Input and item controls | entityMap, categoryMap, primaryKey (attachment mapping) | Components | B102-15.4 |
| Input and item controls | listOfValues, messageLovInput, lovMap | Components | B102-3.1, B102-3.2 |
| Input and item controls | popUp, dialogPage | Components | B102-5.1, B102-5.2, B103-17.5 |
| Input and item controls | flex, flexMap (DFF and KFF) | Components | B102-12.1, B102-12.2 |
| Input and item controls | attachmentTable, attachmentLink, attachmentImage, messageInlineAttachment | Components | B102-15.4 |
| Input and item controls | image, spacer, separator, tip | Components | B101-6.11 |
| Input and item controls | formParameter, formValue, servletInclude, urlInclude | Components | B101-6.12 |
| Analytics and charts | Gantt, graphTable, graph, graphData | Components | B102-10.3, B103-16.6 |
| Architecture and runtime | Model-View-Controller pattern | Capabilities | B101-1.5 |
| Architecture and runtime | Partial Page Rendering (PPR) | Capabilities | B102-2.1, B102-2.2 |
| Architecture and runtime | State and connection management (AM pooling, retention, passivation) | Capabilities | B101-3.5, B103-18.3 |
| Architecture and runtime | Enterprise performance (AM and JDBC pooling, resource swapping, caching) | Capabilities | B101-3.5, B103-18.3, B103-18.4 |
| Architecture and runtime | Development environment (JDeveloper, property sheets, hierarchy navigator, UML) | Capabilities | B101-2.1, B101-2.5 |
| Architecture and runtime | Enhanced save model (unsaved changes warning) | Capabilities | B102-15.16 |
| Personalization and customization | Durable personalizations and MDS | Capabilities | C101-1.2, C101-1.3, C101-4.2 |
| Personalization and customization | BC4J substitutions and extensions | Capabilities | C102-3.1, C102-3.2, C102-1.1 |
| Personalization and customization | Configurable pages | Capabilities | B102-11.5 |
| Personalization and customization | Multi-level personalization precedence (site, organization, responsibility, function, user) | Capabilities | C101-2.1 |
| Personalization and customization | Object-oriented reuse (central EO validation, shared regions) | Capabilities | B101-5.3, B102-14.4, B101-6.4 |
| Search and rich tables | Query regions, list search, saved searches, infotiles | Capabilities | B102-10.1, B103-17.1, B103-17.2 |
| Search and rich tables | Rich table features (resize, reorder, freeze, detach) | Capabilities | B103-16.3 |
| Security | Function security, data security | Capabilities | B101-10.2, B101-10.3, B103-18.6 |
| Security | XSS scanning, AntiSamy, virus scanning, frame busting | Capabilities | B103-18.7 |
| Security | Built-in protection against HTML tampering | Capabilities | B101-10.4 |
| Integration and export | REST and web services, BSO tester | Capabilities | B103-19.1, B103-19.2 |
| Integration and export | Export to Excel and PDF | Capabilities | B102-15.7, B103-16.4 |
| Integration and export | Forms, portal and workflow interoperability | Capabilities | B102-12.5, B102-12.6, B103-19.4 |
| Integration and export | Concurrent processing | Capabilities | B102-15.13 |
| Internationalization, accessibility and diagnostics | Multi-language support, timezones, right-to-left | Capabilities | B102-15.14 |
| Internationalization, accessibility and diagnostics | Accessibility | Capabilities | B102-15.15 |
| Internationalization, accessibility and diagnostics | Accelerator (hot) keys | Capabilities | B102-15.15 |
| Internationalization, accessibility and diagnostics | About This Page, OAInfo.jsp, FND Logging, MDS inspection | Capabilities | C101-8.1, B102-16.3, B103-4.1, C101-6.3 |

66 catalog entries, all mapped.

## Use Case Coverage

Typical OAF application use cases, with the lectures that teach them. Titles are resolved to lecture codes when the file is built, so a missing or ambiguous title stops the build.

| Group | Use case | Lectures |
| :-- | :-- | :-- |
| Transactional and data entry | Single-step create | B103-9.3, B101-4.2 |
| Transactional and data entry | Multi-step create (wizard with train) | B102-11.1, B102-11.3 |
| Transactional and data entry | Single-step update (iterative or single submit) | B103-9.5, B102-11.3 |
| Transactional and data entry | Multi-step update | B102-11.3 |
| Transactional and data entry | Delete with confirmation dialog | B103-9.4, B102-5.2 |
| Transactional and data entry | Master-detail processing | B101-8.1, B101-8.2, B103-11.1 |
| Transactional and data entry | Updateable summary pages (batch update, duplicate, delete rows) | B102-6.3, B102-6.2 |
| Search, inquiry and filtering | Simple search and results | B103-9.1 |
| Search, inquiry and filtering | Advanced search (AND/OR, query by example) | B102-10.1, B103-17.1 |
| Search, inquiry and filtering | List search and faceted filtering, saved searches | B103-17.2 |
| Search, inquiry and filtering | Infotile-driven search | B103-17.3 |
| Search, inquiry and filtering | Quick search and side navigation search | B103-17.4 |
| Search, inquiry and filtering | LOV auto-completion and look-ahead | B102-3.3 |
| Dashboards, analytics and visualization | Configurable dashboard pages | B102-11.5 |
| Dashboards, analytics and visualization | Masonry layout dashboards | B103-16.7 |
| Dashboards, analytics and visualization | Analytics and stock or trend graphs | B102-10.3, B103-16.6 |
| Dashboards, analytics and visualization | Project scheduling with Gantt | B103-16.6 |
| Dashboards, analytics and visualization | Hierarchical tree and org structure display | B102-10.2, B103-16.5 |
| Files, documents and attachments | Inline attachment upload and viewing | B102-15.4 |
| Files, documents and attachments | Bulk file upload and document publishing | B102-15.5, B102-15.8, B103-18.7 |
| Files, documents and attachments | Data export to Excel and PDF | B102-15.7, B103-16.4 |
| Files, documents and attachments | Inline PDF viewing and secure download | B102-15.9 |
| Extensibility and personalization | Declarative admin and user personalization | C101-4.1, C101-4.2 |
| Extensibility and personalization | BC4J business logic substitution | C102-3.1, C102-2.2, C102-2.1, C102-2.3 |
| Extensibility and personalization | Controller extension | C102-1.1 |
| Extensibility and personalization | Flexfield integration (DFF and KFF) | B102-12.1, B102-12.2 |
| Workflow, approval and interoperability | Workflow worklist and notification review | B103-19.6 |
| Workflow, approval and interoperability | Declarative workflow page flows, save for later | B103-17.6, B102-15.11 |
| Workflow, approval and interoperability | Oracle Forms and OAF interoperability | B102-12.5, B102-12.6 |
| Workflow, approval and interoperability | RESTful and SOAP web services | B103-19.1, B103-19.2, B103-19.3 |
| Workflow, approval and interoperability | Portal and portlet publishing | B103-19.5 |
| Workflow, approval and interoperability | Concurrent request submission and monitoring | B102-15.13 |
| Session state and navigation control | Browser back button navigation | B102-15.10, B103-18.5 |
| Session state and navigation control | Deep linking and bookmarkable URLs | B102-15.12 |

34 use cases, all mapped.

## Open items

- **Scaffolding:** [LABS.md](LABS.md) states different guidance percentages from the syllabi (see Scaffolding). Milestone checkpoints, templates per module and instructor guides are missing for most of Dev 102, Dev 103 and both Customizing courses (see Scaffold Assets).
- **Labs:** [LABS.md](LABS.md) still numbers Level 102 sections 11-17 and Level 103 sections 18-20 (performance, security, extensions). Level 103 core and the Customizing courses have no matching labs yet.
- **Capstones:** the POS project appears in Dev 102 (Project 101), in Dev 103 (extended capstone) and in `building-project-101/`. Confirm one name and one home.
- **Instructor guide:** [INSTRUCTOR_SYLLABUS.md](INSTRUCTOR_SYLLABUS.md) covers Level 101 sections 2-5 and the Jobs & Positions capstone only.
- **Syllabus files:** the `SYLLABUS_*.md` files still use their older section numbering and still place the six moved lectures in Dev 101. They need renumbering to match this outline.
- **Customizing durations and assessments:** C101 and C102 durations and assessment criteria are proposals and need sign-off.
- **Code-brain coverage:** see the Gaps by Level table. REST, charts and Infotiles have no examples at all.
- **Review:** the boundary decisions are proposals that no instructor or subject-matter expert has reviewed (see Review Status). The placement checks are specified but not written.
- **Verification:** lectures marked *(verify)* depend on the EBS 12.2 patch level.

