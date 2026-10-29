# Oracle OAF BootCamp Capabilities

Every OAF capability covered by the five courses, with its Level, the courses that teach it and up to five lectures (lectures that name the capability come first).

**Courses:** [Dev 101](../courses/building/101/README.md), [Dev 102](../courses/building/102/README.md), [Dev 103](../courses/building/103/README.md), [Cust 101](../courses/customizing/101/README.md), [Cust 102](../courses/customizing/102/README.md).

**Level** shows how advanced a capability is, taken from the lowest course that teaches it.

| <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" align="absmiddle"> **Foundation** | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" align="absmiddle"> **Core** | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" align="absmiddle"> **Advanced** | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" align="absmiddle"> **Expert** |
| :-: | :-: | :-: | :-: |

**Courses** lists every course that teaches the capability.

<table>
<tr><th align="left">Summary</th><th align="left">Statistics</th></tr>
<tr><td valign="top">

| Area | Capabilities |
| :-- | :-: |
| **[Architecture](#architecture)** | **12** |
| ↳ [Concepts and Layers](#concepts-and-layers) | 6 |
| ↳ [Runtime and Data Foundations](#runtime-and-data-foundations) | 6 |
| **[Model Layer](#model-layer)** | **17** |
| ↳ [Business Components](#business-components) | 10 |
| ↳ [Validation and Server-Side Logic](#validation-and-server-side-logic) | 7 |
| **[View Layer](#view-layer)** | **45** |
| ↳ [Layout Containers](#layout-containers) | 11 |
| ↳ [Navigation and Page Structure](#navigation-and-page-structure) | 10 |
| ↳ [Tables, Search and Visualization](#tables-search-and-visualization) | 10 |
| ↳ [Widgets, Items and Forms](#widgets-items-and-forms) | 14 |
| **[Controller Layer](#controller-layer)** | **18** |
| ↳ [Request Processing](#request-processing) | 7 |
| ↳ [State and Navigation](#state-and-navigation) | 6 |
| ↳ [Dynamic and Programmatic UI](#dynamic-and-programmatic-ui) | 5 |
| [Framework](#framework) | 7 |
| [Localization](#localization) | 5 |
| **[Integration](#integration)** | **17** |
| ↳ [Files and Data Exchange](#files-and-data-exchange) | 6 |
| ↳ [Services and APIs](#services-and-apis) | 4 |
| ↳ [EBS Products and Processes](#ebs-products-and-processes) | 7 |
| [Security](#security) | 9 |
| [Errors and diagnostics](#errors-and-diagnostics) | 9 |
| [Personalization](#personalization) | 10 |
| [Extension](#extension) | 7 |
| [Deployment](#deployment) | 6 |
| **[OA Framework Standards](#oa-framework-standards)** | **15** |
| ↳ [Coding and Naming Standards](#coding-and-naming-standards) | 6 |
| ↳ [Project and Code Management](#project-and-code-management) | 4 |
| ↳ [Quality and Extension Practice](#quality-and-extension-practice) | 5 |
| **Total** | **177** |

</td><td valign="top">

<img src="../assets/stats-areas.svg" width="560" alt="Capabilities per area by level: 13 areas, 17 sub-areas, 177 capabilities. View Layer 45; Controller Layer 18; Model Layer 17; Integration 17; OA Framework Standards 15; Architecture 12; Personalization 10; Security 9; Errors and diagnostics 9; Framework 7; Extension 7; Deployment 6; Localization 5">

<img src="../assets/stats-courses.svg" width="560" alt="Capabilities by course: Dev 101 62; Dev 102 84; Dev 103 69; Cust 101 17; Cust 102 25">

</td></tr>
</table>

## Architecture

### Concepts and Layers

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| MVC pattern | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-002.005, B101-004.001, B101-009.001, B103-011.003 |
| UIX and MDS metadata | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Cust 101, Cust 102 | B101-002.006, B101-007.001, B102-010.002, C101-001.003, C101-002.003 |
| OAF terminology and page anatomy | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-002.001, B101-002.007 |
| OAF in context (when to use, EBS integration) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-002.003, B101-002.004 |
| Layered application architecture | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-002.008 |
| Object-oriented reuse | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-007.004, B102-009.004 |

### Runtime and Data Foundations

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| BC4J (business components) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-002.006, B101-004.001, B103-001.002 |
| JDeveloper and OA Extension | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-003.001, B101-003.004, B101-003.010, B101-011.002, B101-013.006 |
| State and connection management (AM pooling, retention, passivation) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B103-014.003, B101-004.005, B101-003.007, B101-004.002, B101-009.006 |
| Enterprise performance (resource swapping and caching) | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-014.004, B103-009.002 |
| Database layer (_B and _TL tables) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-002.009 |
| System catalog views | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-002.010 |

## Model Layer

### Business Components

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Entity objects | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103, Cust 102 | B101-006.001, B101-006.002, B101-006.004, B103-014.002, B103-014.008 |
| View objects, bind variables and criteria | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-005.004, B103-003.005 |
| Updatable and read-only view objects | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-005.001, B101-005.002, B101-005.003 |
| View links | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-005.005, B101-010.001, B101-015.002 |
| Application modules and OADBTransaction | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103, Cust 102 | B101-004.004, B101-004.002, B101-004.003, B101-015.002, C102-002.003 |
| Master-detail pages | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-010.001, B101-010.002, B101-015.004, B103-007.004, B101-005.005 |
| Entity associations | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-006.004 |
| Polymorphic entity objects | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-014.008, B103-014.001 |
| Multi-Org (operating unit) context | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B102-008.008, B101-012.003 |
| View object query performance | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-003.005 |

### Validation and Server-Side Logic

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Validation view objects | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-008.007 |
| Entity expert validation | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-009.004 |
| Attribute validation and primary keys | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-006.003, B101-006.005, B102-009.003 |
| Cross-attribute validation | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-006.005 |
| SQL and PL/SQL calls from OAF | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-008.004, B102-008.005 |
| PL/SQL entity objects | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-014.002 |
| Programmatic view objects | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-008.001, B102-008.002, B102-008.003 |

## View Layer

### Layout Containers

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Pages and regions | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Cust 102 | B101-007.003, C102-006.001 |
| messageComponentLayout | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.007 |
| Stack, flow, table, row and cell layouts | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-011.006, B102-011.002 |
| Panel splitter and layered layout | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-011.005 |
| Layered layout modes (redirect and form submission) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-011.007 |
| Auto-repeating layout | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-012.005 |
| Bulleted list | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-012.004 |
| Flexible layout and configurable pages | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-013.005 |
| Masonry layout | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-012.007 |
| Advanced layout and content container regions | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-011.003, B102-011.004 |
| Section headers, hide/show regions and footers | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-007.010, B102-011.001 |

### Navigation and Page Structure

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Sub tabs and navigation components | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B103-013.005, B102-011.001, B103-013.008, B103-012.003, B103-013.007 |
| Train and wizards | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-013.001, B102-013.003, B103-013.005 |
| Shuttle | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-013.002, B103-007.004, B103-013.005 |
| Accordions | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-013.007, B103-013.005 |
| Popups | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-013.005 |
| Breadcrumbs and menus | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-007.014, B103-006.002 |
| Look-and-feel standards | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.008, B101-008.004 |
| Attribute sets and CSS | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Cust 102 | B101-007.013, C102-006.001 |
| Shared regions and pages | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.004 |
| Switcher | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-007.007 |

### Tables, Search and Visualization

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Advanced tables | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-006.001, B103-012.001, B102-006.002, B103-007.004, B103-012.002 |
| Table columns, totals and row selection | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-006.001, B102-006.002, B103-012.001 |
| Rich table features (resize, reorder, freeze, detach) | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-012.003 |
| HGrid and tree | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-012.002, B103-012.005 |
| Infotiles | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-012.006, B103-013.003 |
| Charts and graphs | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-012.003, B103-012.006, B103-012.008, B103-008.003 |
| Gantt charts | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-012.008, B103-012.006 |
| Query region, list search and saved search | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103 | B102-012.001, B103-013.002, B101-007.006, B103-013.001 |
| Quick search | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-013.004 |
| CRUD pages (query, create, update, delete) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 103 | B103-006.001, B103-006.002, B103-006.003, B103-006.004, B103-006.005 |

### Widgets, Items and Forms

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Standard web widgets | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.005 |
| Form inputs and selection controls (radio, checkbox, spin box) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.009 |
| Text and display items | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-007.011, B102-014.004 |
| Images, spacers and separators | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.011, B101-008.002 |
| Buttons and button bars | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.010, B101-008.005 |
| Form parameters and includes | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-007.012, B101-008.003 |
| LOV auto-completion, dependent LOV and look-ahead | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-003.002, B102-003.003, B102-003.004, B102-003.001 |
| Smart poplists (LOV choice) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-008.001, B101-007.009, B102-003.005 |
| Lookup codes and value sets | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-003.005 |
| Date picker and calendar fields | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-009.005 |
| Rich text, color picker and rating bar | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-013.004 |
| Flexfields (DFF and KFF) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Cust 101 | B102-014.001, B102-014.002, B102-014.007, C101-003.003 |
| Dynamic item properties (SPEL) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-014.003, B102-007.007 |
| Attachment mapping | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-016.001 |

## Controller Layer

### Request Processing

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| processRequest (GET) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Cust 102 | B101-009.002, C102-001.001 |
| processFormRequest (POST) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Cust 102 | B102-001.001, B102-001.003, B102-002.002, C102-001.001 |
| Partial page rendering (PPR) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-002.001, B102-002.002, B102-011.001, B103-007.004 |
| Page context and web bean API | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103 | B101-009.003, B102-005.002, B103-003.002 |
| Common controller patterns | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-001.002 |
| processFormData | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-001.003 |
| Controller classes (OAControllerImpl) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-009.008 |

### State and Navigation

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Parameter passing | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103, Cust 101, Cust 102 | B101-007.012, B101-008.003, B101-009.004, B101-009.005, B101-009.006 |
| Session parameters and user state | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-009.007 |
| Dialog pages | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-005.001, B102-005.002 |
| Back button | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-017.001, B103-014.005 |
| Deep links | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-017.003 |
| Declarative page flows | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-013.006 |

### Dynamic and Programmatic UI

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Programmatic beans | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-007.001, B102-007.002, B102-007.003, B102-007.004, B102-007.005 |
| Dynamic focus and bean properties | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-007.006, B103-012.005 |
| Table row actions | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-006.002, B102-006.003 |
| JavaScript | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B102-015.001, B101-007.010, B102-014.004 |
| Read-only pages and page modes | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-015.002 |

## Framework

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Accessibility | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Cust 101 | B102-018.004, C101-003.003 |
| Accelerator (hot) keys | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-018.002 |
| Screen reader support | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-018.002 |
| Enhanced save model | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-018.003 |
| Profile options | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103, Cust 101 | B102-010.003, B103-003.001, C101-002.002, C101-005.001 |
| Default values | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Cust 102 | B102-010.001, B101-007.009, B101-009.002, C102-002.002 |
| Context-sensitive help | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-018.005 |

## Localization

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Multi-language support | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-018.001, B103-009.001 |
| Right-to-left layouts | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-018.001 |
| Timezones | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-009.001, B102-018.001 |
| Date formats | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-009.001 |
| Number and currency formats | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-009.002 |

## Integration

### Files and Data Exchange

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Attachments | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-016.001, B103-009.001, B103-016.002 |
| File upload and download | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-016.002, B102-016.006, B102-016.009, B103-015.004, B102-016.005 |
| Import and export data | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-016.003, B102-016.004 |
| Export to Excel and PDF | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B103-011.005, B103-012.004, B102-016.003, B102-016.004, B102-016.008 |
| XML Publisher and BI Publisher output | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-016.007, B102-012.003 |
| Web ADI integration | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-016.008, B102-016.009 |

### Services and APIs

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| REST and web services | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-016.001, B103-016.002 |
| BSO tester | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-017.003, B103-016.001 |
| External SOAP and REST services | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-016.003 |
| Embedded JET and third-party content | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-016.007 |

### EBS Products and Processes

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Workflow and notifications | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B103-016.006, B102-017.002, B103-016.004, B102-005.002, B102-017.005 |
| Business events | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-017.005 |
| Oracle Forms interoperability | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102 | B101-002.002, B102-014.005, B102-014.006 |
| Portal and portlets | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-017.001, B103-016.005 |
| Concurrent requests | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B102-017.004, B102-017.006, B103-003.003, B103-006.005 |
| Programmatic concurrent request submission | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-017.006 |
| OBIEE analytics | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-017.002, B103-016.005 |

## Security

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Function security | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-012.002, B101-012.001, B103-014.006 |
| Data security | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-012.003 |
| Authentication and authorization | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-012.001 |
| XSS scanning | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-014.007, B103-015.002 |
| AntiSamy filtering | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B103-014.007, B103-015.002, B102-016.005 |
| Virus scanning | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Dev 103 | B103-015.004, B102-016.005, B103-014.007 |
| Frame busting | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-015.003, B103-014.007 |
| Built-in protection against HTML tampering | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-012.004, B101-012.005 |
| Page access tracking | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-014.006, B103-015.001 |

## Errors and diagnostics

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| OAException and severities | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-004.002, B102-004.001 |
| Bundled exceptions | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-004.003, B102-004.002 |
| Debugger and logging | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-011.001, B101-011.002, B103-009.003, B103-003.002 |
| About This Page | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102, Cust 101 | B102-019.003, C101-005.001 |
| OAInfo.jsp | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-019.003 |
| FND_LOG and writeDiagnostics | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-003.001, B103-003.002, B103-003.003 |
| SQL trace (event 10046) | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-003.004, B103-003.002 |
| Log purge (FNDLGPRG) | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-003.003 |
| Advanced debugging techniques | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-019.001, B102-019.002 |

## Personalization

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Customization concepts | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-001.001 |
| Personalization levels | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-002.001 |
| Personalization precedence (user level highest) | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-002.004 |
| Durable personalizations | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-001.002 |
| Region injection | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-003.004 |
| LOV personalization | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-003.005 |
| XMLExporter and XMLImporter | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 103, Cust 101, Cust 102 | B103-001.001, C101-004.001, C101-004.002, C101-005.002, C101-005.003 |
| Translated personalizations | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-005.002 |
| End-user and declarative page personalization | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-001.004, C101-003.001, C101-003.002 |
| MDS content inspection | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Cust 101 | C101-004.003 |

## Extension

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Controller extension | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-001.001 |
| View object extension | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-002.001 |
| Entity object extension | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-002.002 |
| Application module extension | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-002.003 |
| Substitution and JPX | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103, Cust 102 | B103-001.002, C102-003.001, C102-003.002, C102-001.002, C102-003.003 |
| LOV extension | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-001.002 |
| Extension touchpoints and Oracle page extensions | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-005.002, C102-005.004 |

## Deployment

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Deployment to EBS | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103, Cust 102 | B101-014.001, B101-014.004, B103-004.003, C102-004.002, B101-014.002 |
| adop and R12.2 patching | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103, Cust 102 | B103-004.001, B101-014.003, C102-004.003, C102-006.004 |
| adcgnjar and customall.jar | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103, Cust 102 | B103-004.002, C102-004.001 |
| AOL functions, menus and responsibilities | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103, Cust 101, Cust 102 | B101-003.008, B103-002.001, B103-002.002, B101-012.002, B101-014.004 |
| Scripted deployment | <img src="../assets/level-expert.svg" width="20" height="20" alt="Expert" title="Expert" align="absmiddle"> | Dev 103 | B103-004.003 |
| Environment promotion | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-006.003 |

## OA Framework Standards

### Coding and Naming Standards

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Why development standards matter | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.001 |
| Coding standards and naming conventions | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.002 |
| Oracle, project and industry standards | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.003 |
| File types and package naming | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.004 |
| Directory structure ($JAVA_TOP) | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.005 |
| Common page patterns | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101 | B101-013.007 |

### Project and Code Management

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Workspace and project organization | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B101-003.010, B101-007.002, B103-005.003, B101-003.001, B101-013.005 |
| Code management and version control | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103, Cust 102 | B101-003.010, B101-013.006, B103-005.002, B102-020.001, B103-006.005 |
| Project documentation and delivery | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Dev 103 | B103-010.001, B103-010.002, B103-010.003 |
| Mentoring and code review | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 103 | B103-010.004, B101-001.003 |

### Quality and Extension Practice

| Capability | Level | Courses | Lectures |
| :-- | :-: | :-- | :-- |
| Extension standards | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-005.001 |
| Custom code placement | <img src="../assets/level-advanced.svg" width="20" height="20" alt="Advanced" title="Advanced" align="absmiddle"> | Cust 102 | C102-005.003 |
| Server-side best practices | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-008.006 |
| Unit and automated testing | <img src="../assets/level-core.svg" width="20" height="20" alt="Core" title="Core" align="absmiddle"> | Dev 102 | B102-019.004 |
| Code quality and standards compliance | <img src="../assets/level-foundation.svg" width="20" height="20" alt="Foundation" title="Foundation" align="absmiddle"> | Dev 101, Dev 102, Dev 103 | B103-011.002, B101-015.006, B102-020.006 |

## UI Component Layout Index

Bean-level OAF component names for each capability that has them, grouped by OAF component category. Look up the lectures in the capability's row.

| # | Group | Capability | # | Component |
| :-- | :-- | :-- | :-- | :-- |
| C01 | Layout containers | Pages and regions | C01.001<br>C01.002<br>C01.003<br>C01.004 | page<br>pageLayout<br>attributeSet<br>package |
| C02 |  | messageComponentLayout | C02.001<br>C02.002<br>C02.003<br>C02.004<br>C02.005 | messageComponentLayout<br>messageLayout<br>labeledFieldLayout<br>defaultSingleColumn<br>defaultDoubleColumn |
| C03 |  | Stack, flow, table, row and cell layouts | C03.001<br>C03.002<br>C03.003<br>C03.004<br>C03.005 | stackLayout<br>flowLayout<br>rowLayout<br>tableLayout<br>cellFormat |
| C04 |  | Panel splitter and layered layout | C04.001<br>C04.002 | panelSplitter<br>layeredLayout |
| C05 |  | Flexible layout and configurable pages | C05.001<br>C05.002<br>C05.003 | flexibleLayout<br>flexibleContent<br>flexibleContentList |
| C06 |  | Advanced layout and content container regions | C06.001<br>C06.002 | contentContainer<br>richContainer |
| C07 |  | Section headers, hide/show regions and footers | C07.001<br>C07.002<br>C07.003<br>C07.004 | header<br>hideShowHeader<br>footer<br>contentFooter |
| C08 | Data presentation | Bulleted list | C08.001 | bulletedList |
| C09 |  | Advanced tables | C09.001<br>C09.002 | table<br>advancedTable |
| C10 |  | Table columns, totals and row selection | C10.001<br>C10.002<br>C10.003<br>C10.004<br>C10.005<br>C10.006 | columnGroup<br>sortableHeader<br>totalRow<br>addTableRow<br>singleSelection<br>multipleSelection |
| C11 |  | HGrid and tree | C11.001<br>C11.002<br>C11.003<br>C11.004 | HGrid<br>tree<br>nodeDef<br>childNode |
| C12 |  | Infotiles | C12.001 | infotile |
| C13 | Navigation and page flow | Sub tabs and navigation components | C13.001<br>C13.002<br>C13.003 | subTabLayout<br>subTabBar<br>hideShowSubTabLayout |
| C14 |  | Train and wizards | C14.001 | train |
| C15 |  | Breadcrumbs and menus | C15.001<br>C15.002<br>C15.003<br>C15.004<br>C15.005 | menu<br>menuItem<br>breadcrumbs<br>locator<br>navigationBar |
| C16 | Input and item controls | Shuttle | C16.001 | shuttle |
| C17 |  | Popups | C17.001 | popUp |
| C18 |  | Form inputs and selection controls (radio, checkbox, spin box) | C18.001<br>C18.002<br>C18.003<br>C18.004<br>C18.005<br>C18.006<br>C18.007 | messageTextInput<br>messageChoice<br>messageLovChoice<br>messageRadioButton<br>messageRadioGroup<br>messageCheckBox<br>messageSpinBox |
| C19 |  | Text and display items | C19.001<br>C19.002<br>C19.003<br>C19.004<br>C19.005<br>C19.006 | styledText<br>formattedText<br>instructionText<br>messageStyledText<br>staticStyledText<br>rawText |
| C20 |  | Images, spacers and separators | C20.001<br>C20.002<br>C20.003<br>C20.004 | image<br>spacer<br>separator<br>tip |
| C21 |  | Buttons and button bars | C21.001<br>C21.002<br>C21.003<br>C21.004<br>C21.005<br>C21.006<br>C21.007 | button<br>submitButton<br>resetButton<br>selectionButton<br>exportButton<br>link<br>pageButtonBar |
| C22 |  | Form parameters and includes | C22.001<br>C22.002<br>C22.003<br>C22.004 | formParameter<br>formValue<br>servletInclude<br>urlInclude |
| C23 |  | LOV auto-completion, dependent LOV and look-ahead | C23.001<br>C23.002<br>C23.003<br>C23.004<br>C23.005 | listOfValues<br>messageLovInput<br>lovMap<br>lovActionButton<br>lovActionMap |
| C24 |  | Rich text, color picker and rating bar | C24.001<br>C24.002<br>C24.003 | richTextEditor<br>colorPicker<br>messageRatingBar |
| C25 |  | Flexfields (DFF and KFF) | C25.001<br>C25.002 | flex<br>flexMap |
| C26 |  | Dialog pages | C26.001 | dialogPage |
| C27 | Attachment and file controls | Attachment mapping | C27.001<br>C27.002<br>C27.003<br>C27.004<br>C27.005<br>C27.006<br>C27.007 | attachmentTable<br>attachmentLink<br>attachmentImage<br>messageInlineAttachment<br>entityMap<br>categoryMap<br>primaryKey |
| C28 |  | File upload and download | C28.001<br>C28.002 | messageFileUpload<br>messageDownload |
| C29 | Analytics and charts | Charts and graphs | C29.001<br>C29.002<br>C29.003 | graphTable<br>graph<br>graphData |
| C30 |  | Gantt charts | C30.001 | Gantt |

## Notes

- A capability counts as covered when a lecture name or note names it. This shows where a topic is taught, not how deeply.
- The list is built from the capability catalogs supplied for this course, not from an official Oracle list.
- Levels are derived from where lectures name each capability (a few basics are set by hand), so they are not an official Oracle grading.
- The content has not been reviewed by an instructor.
