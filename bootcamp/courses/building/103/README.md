# Oracle OAF Building BootCamp 103

**Code:** `OAF-B-103` &nbsp;·&nbsp; **Level:** Ninja

**Curriculum specification only.** Lecture formats and resources describe planned teaching approaches. See the [curriculum conventions](../../../CURRICULUM.md) for scope, difficulty, workload and release applicability.

## Purpose and Audience

Evaluate production-readiness risks and plan an operable R12.2 application with repeatable deployment and recovery.

**Audience:** Experienced OAF developers preparing to review architecture, diagnostics, deployment and release decisions.

## Prerequisites

- Building 102 required-path exit competencies
- Basic Git, database design and EBS application administration vocabulary
- Electives have additional product and module prerequisites listed below

**Readiness check:** Explain PPR and LOV lifecycle behavior, multi-row transaction failure and a recoverable request flow; distinguish function access from row-level access.

## Course Goals

- Plan MDS/BC4J deployment, function registration, packaging, adop synchronization and reversible promotion.
- Interpret a diagnostics and SQL-trace scenario and justify query-fetch and log-retention decisions.
- Analyze posting order, state retention, concurrency, authorization and input-trust boundaries.
- Design a bounded sales/inventory application with atomic transactions, auditability and explicit performance targets.
- Defend release and recovery decisions, communicate evidence and provide actionable peer review.

## Outcomes and Coverage

Required outcomes define the exit competencies. Elective outcomes extend them and carry no compulsory assessment marks.

| Outcome | Path | Modules | Observable capability |
| :-- | :-- | :-- | :-- |
| B103-LO01 | Required | [B103-001](#1-mds-and-bc4j-deployment-required), [B103-002](#2-aol-security-and-page-registration-required), [B103-004](#4-r122-online-patching-and-packaging-required) | Plan MDS/BC4J deployment, function registration, packaging, adop synchronization and reversible promotion. |
| B103-LO02 | Required | [B103-003](#3-enterprise-instrumentation-and-log-management-required) | Interpret a diagnostics and SQL-trace scenario and justify query-fetch and log-retention decisions. |
| B103-LO03 | Required | [B103-014](#14-state-management-back-button-and-security-required), [B103-015](#15-security-hardening-required) | Analyze posting order, state retention, concurrency, authorization and input-trust boundaries. |
| B103-LO04 | Required | [B103-005](#5-project-setup-and-planning-required), [B103-006](#6-store-management-module-required), [B103-007](#7-product-and-branch-management-required), [B103-008](#8-sales-and-transactions-module-required), [B103-009](#9-advanced-features-and-polish-required) | Design a bounded sales/inventory application with atomic transactions, auditability and explicit performance targets. |
| B103-LO05 | Required | [B103-010](#10-deployment-and-presentation-required), [B103-011](#11-final-assessment-required) | Defend release and recovery decisions, communicate evidence and provide actionable peer review. |
| B103-LOE1 | Elective | [B103-012](#12-advanced-tables-grids-and-visualization-elective), [B103-013](#13-advanced-search-and-navigation-elective) | Evaluate specialist table, search, navigation and visualization choices against complexity and release constraints. |
| B103-LOE2 | Elective | [B103-016](#16-rest-and-product-integration-elective), [B103-017](#17-portal-analytics-and-service-testing-elective) | Evaluate REST/BSO, external services, rich content, portlets and analytics within supported product boundaries. |

## Learning Path and Workload

Follow the table from top to bottom and skip electives unless their outcomes are needed. Module and lecture IDs are stable references, so their numeric order can differ from the teaching order. The module prerequisites below explain the dependencies.

| Path | Instruction h | Independent study h | Assessment preparation h | Total h |
| :-- | --: | --: | --: | --: |
| Required | 28 | 12 | 44 | 84 |
| Elective additions | 12 | 9.5 | 0 | 21.5 |

At **10 hours a week**, the required path is approximately **8.4 weeks**. These are editorial estimates pending pilot data; instruction, study and assessment time are additive and counted once. Alternative project options share the same assessment allowance. Elective extensions inside required modules are excluded from required assessment and from scheduled hours; their additional time is set when selected. Fully elective module hours are shown separately. Conditional product-specific topics are unscheduled until scoped.

**Difficulty:** ★ Beginner · ★★ Elementary · ★★★ Intermediate · ★★★★ Advanced · ★★★★★ Expert. Ratings describe prerequisite depth and reasoning complexity, independently of Video/Lab/Workshop format. Module difficulty represents its central task; individual lectures can differ.

## Curriculum

| Teaching step | Module | Title | Path | Difficulty | Lectures | Instruction h | Study h | Assessment h |
| --: | :-- | :-- | :-- | :-- | --: | --: | --: | --: |
| 1 | B103-001 | [MDS and BC4J Deployment](#1-mds-and-bc4j-deployment-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 2 | 2 | 1.5 | 0 |
| 2 | B103-002 | [AOL Security and Page Registration](#2-aol-security-and-page-registration-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 2 | 1 | 1 | 0 |
| 3 | B103-003 | [Enterprise Instrumentation and Log Management](#3-enterprise-instrumentation-and-log-management-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 5 | 3 | 2.5 | 0 |
| 4 | B103-004 | [R12.2 Online Patching and Packaging](#4-r122-online-patching-and-packaging-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 | 3 | 2.5 | 0 |
| 5 | B103-014 | [State Management, Back Button and Security](#14-state-management-back-button-and-security-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 8 | 4 | 3 | 0 |
| 6 | B103-015 | [Security Hardening](#15-security-hardening-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 4 | 2 | 1.5 | 0 |
| 7 | B103-005 | [Project Setup and Planning](#5-project-setup-and-planning-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 5 | 2 | 0 | 4 |
| 8 | B103-006 | [Store Management Module](#6-store-management-module-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 5 | 2 | 0 | 6 |
| 9 | B103-007 | [Product and Branch Management](#7-product-and-branch-management-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 4 | 2 | 0 | 8 |
| 10 | B103-008 | [Sales and Transactions Module](#8-sales-and-transactions-module-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 | 2 | 0 | 12 |
| 11 | B103-009 | [Advanced Features and Polish](#9-advanced-features-and-polish-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 | 1.5 | 0 | 8 |
| 12 | B103-010 | [Deployment and Presentation](#10-deployment-and-presentation-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 4 | 1.5 | 0 | 4 |
| 13 | B103-011 | [Final Assessment](#11-final-assessment-required) | Required | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 6 | 2 | 0 | 2 |
| 14 | B103-012 | [Advanced Tables, Grids and Visualization](#12-advanced-tables-grids-and-visualization-elective) | Elective | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 8 | 4 | 3 | 0 |
| 15 | B103-013 | [Advanced Search and Navigation](#13-advanced-search-and-navigation-elective) | Elective | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 8 | 3 | 2.5 | 0 |
| 16 | B103-016 | [REST and Product Integration](#16-rest-and-product-integration-elective) | Elective | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 7 | 3 | 2.5 | 0 |
| 17 | B103-017 | [Portal, Analytics and Service Testing](#17-portal-analytics-and-service-testing-elective) | Elective | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 | 2 | 1.5 | 0 |

## Coverage Statistics

<img src="../../../assets/stats-b103-areas.svg" width="560" alt="Building 103 planned capability coverage by area">

<img src="../../../assets/stats-b103-modules.svg" width="560" alt="Building 103 planned capability coverage by module">

The [capability index](../../../capabilities/CAPABILITIES.md) locates planned topics, including electives. Counts do not measure competency or implementation availability.

<a id="1-mds-and-bc4j-deployment"></a>

## [1] MDS and BC4J Deployment (Required)

**Module:** B103-001 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** Course entry criteria.

**Module outcome:** Distinguish page metadata import from BC4J/substitution registration.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-001.001 | Deploying Pages with XMLImporter | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | -rootdir, -username, -password, -dbconnection parameters, $JAVA_TOP layout |
| B103-001.002 | Registering BC4J Configuration with JPXImporter | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | .jpx project files, classpath specifications, repository registration |

<a id="2-aol-security-and-page-registration"></a>

## [2] AOL Security and Page Registration (Required)

**Module:** B103-002 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-001](#1-mds-and-bc4j-deployment-required).

**Module outcome:** Explain function/menu/responsibility registration and negative access checks.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-002.001 | Defining Form Functions for OAF Pages | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | SSWA jsp function, page path and parameters |
| B103-002.002 | Configuring Menus and Responsibilities | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Attaching functions to menus, assigning responsibilities, testing access |

<a id="3-enterprise-instrumentation-and-log-management"></a>

## [3] Enterprise Instrumentation and Log Management (Required)

**Module:** B103-003 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-001](#1-mds-and-bc4j-deployment-required).

**Module outcome:** Interpret diagnostic/trace evidence and justify fetch strategy and log retention.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-003.001 | Configuring the FND_LOG Framework and Profile Options | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | FND: Debug Log Enabled, FND: Debug Log Level, FND_LOG_MESSAGES |
| B103-003.002 | Writing Diagnostics from Code | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Tutorial | FND_LOG and pageContext.writeDiagnostics(), diagnostic levels and correlation; SQL trace interpretation is a separate lecture |
| B103-003.003 | Purging Logs with FNDLGPRG | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Concurrent program schedule, FND_LOG_ADMIN package, table storage and size checks |
| B103-003.004 | Tracing SQL with Event 10046 | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | SQL trace with event 10046, reading trace output, finding slow statements |
| B103-003.005 | Tuning View Object Queries: Range Size and Fetch Strategy | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Tutorial | Tuning view object queries, range size, fetch mode, bind variables, SQL plans, row-fetch limits |

<a id="4-r122-online-patching-and-packaging"></a>

## [4] R12.2 Online Patching and Packaging (Required)

**Module:** B103-004 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-001](#1-mds-and-bc4j-deployment-required), [B103-002](#2-aol-security-and-page-registration-required), [B103-003](#3-enterprise-instrumentation-and-log-management-required).

**Module outcome:** Plan archive generation, edition selection, synchronization and reversible deployment.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-004.001 | Using Online Patching (adop) Fundamentals | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Diagram | Run edition versus patch edition, patch phases, classpath configuration |
| B103-004.002 | Packaging Custom Java with adcgnjar | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Separate compilation from archive generation; adcgnjar generates/signs customall.jar; target edition and classpath dependencies |
| B103-004.003 | Designing Repeatable Deployment and Recovery | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Scripted deployment design, environment variables such as $AD_APPS_JDBC_URL, prechecks, backups and rollback; custom synchronization driver adop_sync_drv.txt and its template distinction |

<a id="14-state-management-back-button-and-security"></a>

## [14] State Management, Back Button and Security (Required)

**Module:** B103-014 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-003](#3-enterprise-instrumentation-and-log-management-required).

**Module outcome:** Analyze posting, passivation, Back Button failures, data isolation and trust boundaries.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-014.001 | Analyzing Entity Posting Order and Transient State | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Parent/child posting order and transient attributes; polymorphic entity objects are treated separately in B103-014.008 |
| B103-014.002 | Building PL/SQL Entity Objects | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Wrapping legacy PL/SQL table APIs, key generation, locking, error mapping |
| B103-014.003 | Managing State Retention and Pooling | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Retention levels, passivation, session limits, connection pool monitoring |
| B103-014.004 | Applying Resource Swapping and Memory Caching | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | AM pooling and resource swapping, JDBC pool tuning, memory caching, resource conservation |
| B103-014.005 | Supporting the Browser Back Button | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Analyze failures involving page instance IDs, transaction units, retention and stale data; builds on B102-017 basic Back Button recovery |
| B103-014.006 | Analyzing Function and Data Security Boundaries | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Explain why hidden/read-only controls are not authorization; assess function security, data grants and multi-org isolation; page access tracking follows in B103-015 |
| B103-014.007 | Planning Input Trust Boundaries | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Identify XSS, unsafe HTML, uploads and framing risks; select control boundaries before the specific AntiSamy, virus scanning and frame busting topics in B103-015 |
| B103-014.008 | Applying Polymorphic Entity Objects | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Polymorphic entity objects with subtype-specific validation |

<a id="15-security-hardening"></a>

## [15] Security Hardening (Required)

**Module:** B103-015 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-014](#14-state-management-back-button-and-security-required).

**Module outcome:** Select XSS, filtering, upload, framing and access-tracking controls with release prerequisites.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-015.001 | Tracking Page Access | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Page access tracking, reviewing who opened which page |
| B103-015.002 | Scanning Pages for Cross-Site Scripting | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Checklist | XSS scanning, AntiSamy HTML filtering and fixing findings |
| B103-015.003 | Applying Frame Busting Protection | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Frame busting against clickjacking and framed pages |
| B103-015.004 | Scanning Uploaded Files for Viruses | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Virus scanning on file upload, rejecting infected files |

<a id="5-project-setup-and-planning"></a>

## [5] Project Setup and Planning (Required)

**Module:** B103-005 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-004](#4-r122-online-patching-and-packaging-required), [B103-014](#14-state-management-back-button-and-security-required), [B103-015](#15-security-hardening-required).

**Module outcome:** Define capstone scope, architecture, release assumptions and database migration boundaries.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-005.001 | Defining the Capstone Environment and Delivery Boundaries | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Specify target EBS release, responsibilities, data volume, stakeholders and exclusions; reuse setup knowledge from B101-003 |
| B103-005.002 | Planning Version Control and Release Reviews | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Tutorial | Apply existing Git knowledge to release branches, review gates, change history and promotion; Git installation belongs to introductory setup |
| B103-005.003 | Designing Capstone Workspaces and Module Boundaries | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Template | Package structure, ownership and dependencies for stores, products, branches and sales; compare cohesion and reuse |
| B103-005.004 | Planning Environment Connectivity and Configuration | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Development versus deployment connection needs, pooling and environment separation; production configuration decisions rather than first connection setup |
| B103-005.005 | Designing Capstone Database Objects and Migration | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Scripts | Database schema, keys, WHO columns, constraints and sample-data plan; editioning and migration considerations |

<a id="6-store-management-module"></a>

## [6] Store Management Module (Required)

**Module:** B103-006 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-005](#5-project-setup-and-planning-required).

**Module outcome:** Apply prior CRUD competencies to store requirements rather than reteach CRUD.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-006.001 | Implementing Store Query Page (SELECT) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Apply prior CRUD knowledge to a store query page; multiple criteria, results, pagination and scoped data access; Excel export is optional |
| B103-006.002 | Implementing Store Drill-Down Page (SELECT) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Master-detail display, related information, navigation, breadcrumbs |
| B103-006.003 | Implementing Store Create Page (INSERT) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Data entry form, validation, confirmation, success message |
| B103-006.004 | Implementing Store Delete Page (DELETE) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Confirmation dialog, business rule validation, cascade delete handling, audit trail |
| B103-006.005 | Implementing Store Update Page (UPDATE) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Edit form, version control, concurrent update handling, change tracking |

<a id="7-product-and-branch-management"></a>

## [7] Product and Branch Management (Required)

**Module:** B103-007 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-006](#6-store-management-module-required).

**Module outcome:** Explain product reuse and branch/master-detail boundaries.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-007.001 | Explaining the Practice Assignment | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Requirements specification, business rules, acceptance criteria, deliverables |
| B103-007.002 | Implementing Product CRUD Functionality | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Query page, create page, update page, delete functionality, drill-down details |
| B103-007.003 | Reviewing Product Design Alternatives | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Rubric | Review criteria and alternative product CRUD designs, reuse and maintainability; curriculum discussion without supplied solution files |
| B103-007.004 | Implementing Branch Page (Master-Details) | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Master branch details; store and employee assignments using a basic master-detail table; shuttle and PPR refinements are optional extensions |

<a id="8-sales-and-transactions-module"></a>

## [8] Sales and Transactions Module (Required)

**Module:** B103-008 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-007](#7-product-and-branch-management-required).

**Module outcome:** Specify atomic sales and inventory updates with concurrency and audit rules.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-008.001 | Processing Sales Transactions | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Bounded sales transaction design: product, quantity, pricing, discount rules, atomic posting and receipt summary; exclude real payment gateways, tax certification and offline terminals |
| B103-008.002 | Managing Inventory | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Inventory adjustments and branch transfers, concurrent updates and overselling prevention; replenishment automation is optional |
| B103-008.003 | Reporting and Analytics | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Basic sales and inventory summary requirements; optional charts, BI Publisher and external analytics require their elective prerequisites |

<a id="9-advanced-features-and-polish"></a>

## [9] Advanced Features and Polish (Required)

**Module:** B103-009 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-008](#8-sales-and-transactions-module-required).

**Module outcome:** Review the bounded design against performance, security and observability requirements.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-009.001 | Reviewing Enterprise Quality Requirements | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Required: authorization, validation, audit trail and localization decisions. Attachments, workflow automation and multilingual implementation are elective extensions |
| B103-009.002 | Optimizing Performance | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Compare query plans and define a response-time budget and data volume; assess resource swapping and caching trade-offs using B103-003 and B103-014 |
| B103-009.003 | Handling Errors and Logging | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Comprehensive error messages, debug logging, production monitoring, user help system |

<a id="10-deployment-and-presentation"></a>

## [10] Deployment and Presentation (Required)

**Module:** B103-010 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-009](#9-advanced-features-and-polish-required).

**Module outcome:** Defend the release/recovery plan and communicate an actionable design review.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-010.001 | Defining the Production Deployment and Rollback Plan | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Specify package contents, installation order, target edition, synchronization, rollback trigger and post-deployment evidence; production release remains a scenario |
| B103-010.002 | Writing Documentation | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Template | Technical documentation, user manual, installation guide, troubleshooting guide |
| B103-010.003 | Presenting the Project | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Demo preparation, presentation to stakeholders, Q&A handling |
| B103-010.004 | Mentoring and Code Review | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Reviewing a peer implementation, giving actionable feedback, coaching a junior developer through a defect, review checklist |

<a id="11-final-assessment"></a>

## [11] Final Assessment (Required)

**Module:** B103-011 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Required

**Prerequisites:** [B103-010](#10-deployment-and-presentation-required).

**Module outcome:** Evaluate all required outcomes using explicit thresholds and critical criteria.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-011.001 | Applying the Comprehensive Evaluation Criteria | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Rubric | Curriculum assessment criterion: functional integrity 25%; stores, products, branches, sales and inventory with defined boundaries |
| B103-011.002 | Assessing Code Quality | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Curriculum assessment criterion: architecture and maintainability 20%; model boundaries, reuse, concurrency and code-review rationale |
| B103-011.003 | Reviewing Architecture and Design | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Patterns | Curriculum assessment criterion: performance and diagnostics 20%; defined data volume and budget, SQL trace interpretation, logging and recovery |
| B103-011.004 | Reviewing Professional Deliverables | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Checklist | Curriculum assessment criterion: deployment and recovery 20%; package manifest, adop, synchronization, rollback and validation plan |
| B103-011.005 | Reviewing Security and Professional Communication | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Curriculum assessment criterion: security and communication 15%; access-denial cases, design defense and actionable peer review; optional extras carry no required marks |
| B103-011.006 | Reviewing the Ninja Completion Criteria | Workshop | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Rubric | Overall score at least 85/100, each criterion at least 70%, and all critical integrity/security/recovery criteria satisfied; course milestone, not Oracle certification |

<a id="12-advanced-tables-grids-and-visualization"></a>

## [12] Advanced Tables, Grids and Visualization (Elective)

**Module:** B103-012 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Elective

**Prerequisites:** [B103-003](#3-enterprise-instrumentation-and-log-management-required), [B103-014](#14-state-management-back-button-and-security-required). Relevant component introductions in B102-011 to B102-014 are prerequisite elective preparation; include their hours if not already studied.

**Module outcome:** Evaluate specialist table/hierarchy/visualization choices and their release applicability.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-012.001 | Designing Nested and Grouped Advanced Tables | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Build on B102-006 table operations: column groups, sortable headers, total rows, detail disclosure and table-in-table design trade-offs |
| B103-012.002 | Migrating from Classic Tables | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Comparison with advanced tables, usage limits, migration strategy |
| B103-012.003 | Implementing Rich Table Interactions | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Resize, reorder, freeze, hide/show columns, scrolling; touch-device optimizations |
| B103-012.004 | Exporting Table Data | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective: native enableExcelExport and enablePDFExport are documented in the 12.2.10 and 12.2.14 component guides; format, row limits and transient columns follow the selected component/release |
| B103-012.005 | Building HGrid and Tree Regions | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | OAHGridBean, OATreeBean, focus and hierarchy columns, child row retrieval |
| B103-012.006 | Comparing Charts, Graphs and Infotiles | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective: BI beans, charts, Gantt and infotile behavior in the selected OAF release; any BI-bean-to-JET migration remains conditional and is not assumed |
| B103-012.007 | Building Masonry Layout Dashboards | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective: Masonry layout and tiles documented from OAF 12.2.9; compare device layout behavior and accessibility; no blanket guarantee of responsive behavior for all components |
| B103-012.008 | Building Gantt Charts | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Gantt chart region bound to project schedule data |

<a id="13-advanced-search-and-navigation"></a>

## [13] Advanced Search and Navigation (Elective)

**Module:** B103-013 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Elective

**Prerequisites:** [B103-014](#14-state-management-back-button-and-security-required). Relevant component introductions in B102-011 to B102-014 are prerequisite elective preparation; include their hours if not already studied.

**Module outcome:** Choose search/navigation architecture for a complex flow rather than repeat component introduction.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-013.001 | Designing the Search Architecture | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Query regions, simple and advanced search, results-based search |
| B103-013.002 | Implementing the List Search Framework | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Filter panels, saved searches, quick and keyword search |
| B103-013.003 | Implementing Infotile-Driven Search | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Summary tiles with metric counts that filter a results table |
| B103-013.004 | Implementing Quick Search and Side Navigation Search | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Compact quick search inputs in global headers and side navigation |
| B103-013.005 | Choosing Navigation Components for Complex Flows | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Compare trains, subtabs, accordions, hide/show, popups and shuttles for navigation architecture; component introduction remains in B102 |
| B103-013.006 | Implementing Declarative Page Flows | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Destination function and workflow page flows, transaction state, save for later |
| B103-013.007 | Building Accordion Navigation | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Accordion regions and hide/show navigation containers |
| B103-013.008 | Building Sub Tabs and Sliding Sub Tab Layouts | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | subTabLayout, subTabBar and hideShowSubTabLayout with slide-out content panels |

<a id="16-rest-and-product-integration"></a>

## [16] REST and Product Integration (Elective)

**Module:** B103-016 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Elective

**Prerequisites:** [B103-004](#4-r122-online-patching-and-packaging-required), [B103-014](#14-state-management-back-button-and-security-required), [B103-015](#15-security-hardening-required). Service-contract and HTTP concepts are prerequisite; portal/analytics portions additionally require the selected product configuration.

**Module outcome:** Compare service contracts, authentication and external-content integration boundaries.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-016.001 | Using the OAF REST Servlet | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Exposing AM methods, service data objects, testing business service objects; BSO API tester |
| B103-016.002 | Using Application Web Services | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Business service objects, attachments service, home page service |
| B103-016.003 | Consuming External SOAP and REST Services | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Calling external services from application module code, error handling, timeouts |
| B103-016.004 | Comparing Forms and Workflow Integration Boundaries | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective: Forms launch context and Workflow notification integration; compare product ownership and transaction boundaries; CRM/JTT-specific integration requires a separately scoped product extension |
| B103-016.005 | Designing Embedded Analytics Context | Video | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective architecture comparison: context passing, authentication and authorization for external analytics; portlet and OBIEE specifics belong to B103-017 |
| B103-016.006 | Reviewing and Approving Workflow Notifications from OAF | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Notification pages, approve and reject actions, worklist review |
| B103-016.007 | Embedding Oracle JET Components and Third-Party Web Apps | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Tutorial | Conditional elective: richContainer/OARichContainerBean supports external rich content; an embedded Oracle JET application or third-party web application needs a supported target product/version and authentication design; no general JET migration promise |

<a id="17-portal-analytics-and-service-testing"></a>

## [17] Portal, Analytics and Service Testing (Elective)

**Module:** B103-017 | **Difficulty:** <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | **Path:** Elective

**Prerequisites:** [B103-016](#16-rest-and-product-integration-elective). Service-contract and HTTP concepts are prerequisite; portal/analytics portions additionally require the selected product configuration.

**Module outcome:** Evaluate product-dependent portal/analytics and service-testing scenarios.

| Code | Lecture | Format | Difficulty | Planned resource | Curriculum scope |
| :-- | :-- | :-: | :-- | :-- | :-- |
| B103-017.001 | Publishing OAF Regions as Portlets | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Portlet publishing to WebCenter Portal and WSRP portals |
| B103-017.002 | Embedding OBIEE Analytics | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Conditional elective: OBIEE analytics embedding requires selected OBIEE and EBS versions, documented integration mechanism and authentication configuration; excluded from required assessment |
| B103-017.003 | Defining BSO API Tester Service Scenarios | Lab | <img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Elective: BSO tester service contract, authorization and failure cases; OAF REST servlet introduction remains in B103-016 |

## Assessment Design

**Scenario:** Bounded Point-of-Sale and Inventory Capstone. Stores, products, branches, sales posting and inventory adjustments. Require concurrency, authorization, diagnostics, performance targets and deployment/recovery planning. Excludes payment-provider integration, fiscal certification, offline terminals and a complete retail ERP. Optional dashboards and product integrations are not pass requirements.

This specifies assessment coverage and evidence for future delivery. It does not supply assignments, lab instructions, solution code or a production deployment. Evidence may combine a design explanation, lifecycle trace, scenario analysis and, when a delivered course requires it, an implementation demonstration.

| Criterion | Weight | Outcomes | Expected evidence |
| :-- | --: | :-- | :-- |
| Functional integrity | 25% | B103-LO03, B103-LO04 | Bounded stores/products/branches/sales/inventory; atomic posting, concurrent updates and auditability. |
| Architecture and maintainability | 20% | B103-LO03, B103-LO04 | Model boundaries, reuse, state management and justified integration exclusions. |
| Performance and diagnostics | 20% | B103-LO02 | Declared data volume and response-time budget; trace interpretation, fetch and log-retention decisions. |
| Deployment and recovery | 20% | B103-LO01, B103-LO05 | Manifest, target edition, adop synchronization, failure trigger, back-out and validation sequence. |
| Security and communication | 15% | B103-LO03, B103-LO05 | Access-denial cases, trust-boundary controls, design defense and actionable peer review. |

**Completion threshold:** at least **85/100 overall**, at least **70% within each criterion**, and every critical criterion below satisfied. Optional features cannot replace required evidence.

**Critical criteria:** No overselling or partial sales posting is accepted; unauthorized actions are denied; the release plan specifies a credible recovery and post-recovery verification sequence.

**Scoring anchors:** 0% = absent or incorrect; 50% = partly correct with substantial gaps; 70% = meets the stated requirement with minor gaps; 85% = correct, justified and supported by failure-case reasoning; 100% = complete and precise with convincing trade-off analysis. A failed critical criterion requires revision and reassessment of the affected evidence.

## Exit Competencies and Next Step

Completion means the learner can demonstrate every **Required** outcome above within the stated scenario and assessment threshold. Course titles and completion milestones are provider-defined; they do not confer Oracle certification or establish production competence without supervised delivery experience.

**Next:** Customizing 102 after Customizing 101, or architecture and release-review responsibilities with supervised delivery experience.

[BootCamp overview](../../../../README.md) · [Curriculum conventions and references](../../../CURRICULUM.md) · [Roadmap](../../../../roadmap/README.md)
