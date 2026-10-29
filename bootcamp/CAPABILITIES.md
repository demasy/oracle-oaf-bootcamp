# Oracle OAF BootCamp Capabilities

Every OAF capability covered by the five courses, with the levels that teach it and up to five lectures (lectures that name the capability come first).

**Courses:** [Dev 101](building/101/README.md), [Dev 102](building/102/README.md), [Dev 103](building/103/README.md), [Cust 101](customizing/101/README.md), [Cust 102](customizing/102/README.md).

## Summary

| Area | Capabilities |
| :-- | :-: |
| Architecture | 11 |
| **Model Layer** | **13** |
| ↳ Business Components | 8 |
| ↳ Validation and Server-Side Logic | 5 |
| **View Layer** | **42** |
| ↳ Layout and Navigation | 20 |
| ↳ Tables, Search and Visualization | 10 |
| ↳ Widgets, Items and Forms | 12 |
| **Controller Layer** | **17** |
| ↳ Request Processing | 6 |
| ↳ State and Navigation | 6 |
| ↳ Dynamic and Programmatic UI | 5 |
| Framework | 6 |
| Localization | 5 |
| **Integration** | **12** |
| ↳ Files and Data Exchange | 4 |
| ↳ Services and APIs | 3 |
| ↳ EBS Products and Processes | 5 |
| Security | 9 |
| Errors and diagnostics | 9 |
| Personalization | 9 |
| Extension | 7 |
| Deployment | 6 |
| **OA Framework Standards** | **14** |
| ↳ Coding and Naming Standards | 6 |
| ↳ Project and Code Management | 4 |
| ↳ Quality and Extension Practice | 4 |
| **Total** | **160** |

## Architecture

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| MVC pattern | Dev 101, Dev 103 | B101-002.005, B101-004.001, B101-009.001, B103-011.003 |
| BC4J (business components) | Dev 101, Dev 103 | B101-002.006, B101-004.001, B103-001.002 |
| UIX and MDS metadata | Dev 101, Dev 102, Cust 101, Cust 102 | B101-002.006, B101-007.001, B102-010.002, C101-001.003, C101-002.003 |
| JDeveloper and OA Extension | Dev 101 | B101-003.001, B101-003.004, B101-003.010, B101-011.002, B101-013.006 |
| AM pooling, retention and passivation | Dev 101, Dev 103 | B103-014.003, B101-004.005, B101-003.007, B101-004.002, B101-009.006 |
| Resource swapping and caching | Dev 103 | B103-014.004, B103-009.002 |
| OAF terminology and page anatomy | Dev 101 | B101-002.001, B101-002.007 |
| OAF in context (when to use, EBS integration) | Dev 101 | B101-002.003, B101-002.004 |
| Layered application architecture | Dev 101 | B101-002.008 |
| Database layer (_B and _TL tables) | Dev 101 | B101-002.009 |
| Object-oriented reuse | Dev 101, Dev 102 | B101-007.004, B102-009.004 |

## Model Layer

### Business Components

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Entity objects | Dev 101, Dev 103, Cust 102 | B101-006.001, B101-006.002, B103-014.002, B103-014.008, C102-002.002 |
| View objects, bind variables and criteria | Dev 101 | B101-005.004 |
| Updatable and read-only view objects | Dev 101 | B101-005.001, B101-005.002, B101-005.003 |
| View links | Dev 101 | B101-005.005, B101-010.001, B101-015.002 |
| Application modules and OADBTransaction | Dev 101, Dev 103, Cust 102 | B101-004.004, B101-004.002, B101-004.003, B101-015.002, C102-002.003 |
| Master-detail pages | Dev 101, Dev 103 | B101-010.001, B101-010.002, B101-015.004, B103-007.004, B101-005.005 |
| Entity associations | Dev 101 | B101-005.005 |
| Polymorphic entity objects | Dev 103 | B103-014.008, B103-014.001 |

### Validation and Server-Side Logic

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Entity expert validation | Dev 102 | B102-009.004 |
| Attribute validation and primary keys | Dev 101, Dev 102 | B101-006.003, B102-009.003 |
| SQL and PL/SQL calls from OAF | Dev 102 | B102-008.004, B102-008.005 |
| PL/SQL entity objects | Dev 103 | B103-014.002 |
| Programmatic view objects | Dev 102 | B102-008.001, B102-008.002, B102-008.003 |

## View Layer

### Layout and Navigation

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Pages and regions | Dev 101, Cust 102 | B101-007.003, C102-006.001 |
| messageComponentLayout | Dev 101 | B101-007.007 |
| Stack, flow, table, row and cell layouts | Dev 102 | B102-011.006, B102-011.002 |
| Panel splitter and layered layout | Dev 102 | B102-011.005 |
| Auto-repeating layout | Dev 102 | B102-012.005 |
| Bulleted list | Dev 102 | B102-012.004 |
| Flexible layout and configurable pages | Dev 102 | B102-013.005 |
| Masonry layout | Dev 103 | B103-012.007 |
| Advanced layout and content container regions | Dev 102 | B102-011.003, B102-011.004 |
| Layered layout modes (redirect and form submission) | Dev 102 | B102-011.005 |
| Section headers, hide/show regions and footers | Dev 101, Dev 102 | B101-007.010, B102-011.001 |
| Sub tabs and navigation components | Dev 102, Dev 103 | B103-013.005, B102-011.001, B103-013.008, B103-012.003, B103-013.007 |
| Train and wizards | Dev 102, Dev 103 | B102-013.001, B102-013.003, B103-013.005 |
| Shuttle | Dev 102, Dev 103 | B102-013.002, B103-007.004, B103-013.005 |
| Accordions | Dev 103 | B103-013.007, B103-013.005 |
| Popups | Dev 103 | B103-013.005 |
| Breadcrumbs and menus | Dev 101, Dev 103 | B101-007.014, B103-006.002 |
| Look-and-feel standards | Dev 101 | B101-007.008, B101-008.004 |
| Attribute sets and CSS | Dev 101, Cust 102 | B101-007.013, C102-006.001 |
| Shared regions and pages | Dev 101 | B101-007.004 |

### Tables, Search and Visualization

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Advanced tables | Dev 102, Dev 103 | B102-006.001, B103-012.001, B102-006.002, B103-007.004, B103-012.002 |
| Table columns, totals and row selection | Dev 102, Dev 103 | B102-006.001, B102-006.002, B103-012.001 |
| Rich table features (resize, reorder, freeze, detach) | Dev 103 | B103-012.003 |
| HGrid and tree | Dev 102, Dev 103 | B102-012.002, B103-012.005 |
| Infotiles | Dev 103 | B103-012.006, B103-013.003 |
| Charts and graphs | Dev 102, Dev 103 | B102-012.003, B103-012.006, B103-012.008, B103-008.003 |
| Gantt charts | Dev 103 | B103-012.008, B103-012.006 |
| Query region, list search and saved search | Dev 101, Dev 102, Dev 103 | B102-012.001, B103-013.002, B101-007.006, B103-013.001 |
| Quick search | Dev 103 | B103-013.004 |
| CRUD pages (query, create, update, delete) | Dev 103 | B103-006.001, B103-006.002, B103-006.003, B103-006.004, B103-006.005 |

### Widgets, Items and Forms

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Standard web widgets | Dev 101 | B101-007.005 |
| Form inputs and selection controls | Dev 101 | B101-007.009 |
| Text and display items | Dev 101, Dev 102 | B101-007.011, B102-014.004 |
| Images, spacers and separators | Dev 101 | B101-007.011, B101-008.002 |
| Buttons and button bars | Dev 101 | B101-007.010, B101-008.005 |
| Form parameters and includes | Dev 101 | B101-007.012, B101-008.003 |
| LOV, dependent LOV and look-ahead | Dev 102 | B102-003.002, B102-003.003, B102-003.004, B102-003.001 |
| Smart poplists (LOV choice) | Dev 101 | B101-008.001, B101-007.009 |
| Rich text, color picker and rating bar | Dev 102 | B102-013.004 |
| Flexfields (DFF and KFF) | Dev 102, Cust 101 | B102-014.001, B102-014.002, B102-014.007, C101-003.003 |
| Dynamic item properties (SPEL) | Dev 102 | B102-014.003 |
| Attachment mapping | Dev 102 | B102-016.001 |

## Controller Layer

### Request Processing

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| processRequest (GET) | Dev 101, Cust 102 | B101-009.002, C102-001.001 |
| processFormRequest (POST) | Dev 102, Cust 102 | B102-001.001, B102-002.002, C102-001.001 |
| Partial page rendering (PPR) | Dev 102, Dev 103 | B102-002.001, B102-002.002, B102-011.001, B103-007.004 |
| Page context and web bean API | Dev 101, Dev 102, Dev 103 | B101-009.003, B102-005.002, B103-003.002 |
| Common controller patterns | Dev 102 | B102-001.002 |
| processFormData | Dev 102 | B102-001.001 |

### State and Navigation

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Parameter passing | Dev 101, Dev 102, Dev 103, Cust 101, Cust 102 | B101-007.012, B101-008.003, B101-009.004, B101-009.005, B101-009.006 |
| Session parameters and user state | Dev 101 | B101-009.007 |
| Dialog pages | Dev 102 | B102-005.001, B102-005.002 |
| Back button | Dev 102, Dev 103 | B102-017.001, B103-014.005 |
| Deep links | Dev 102 | B102-017.003 |
| Declarative page flows | Dev 103 | B103-013.006 |

### Dynamic and Programmatic UI

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Programmatic beans | Dev 102 | B102-007.001, B102-007.002, B102-007.003, B102-007.004, B102-007.005 |
| Dynamic focus and bean properties | Dev 102, Dev 103 | B102-007.006, B103-012.005 |
| Table row actions | Dev 102 | B102-006.002, B102-006.003 |
| JavaScript | Dev 101, Dev 102 | B102-015.001, B101-007.010, B102-014.004 |
| Read-only pages and page modes | Dev 102 | B102-015.002 |

## Framework

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Accessibility | Dev 102, Cust 101 | B102-018.004, C101-003.003 |
| Hot keys | Dev 102 | B102-018.002 |
| Screen reader support | Dev 102 | B102-018.002 |
| Enhanced save model | Dev 102 | B102-018.003 |
| Profile options | Dev 102, Dev 103, Cust 101 | B102-010.003, B103-003.001, C101-002.002, C101-005.001 |
| Default values | Dev 101, Dev 102, Cust 102 | B102-010.001, B101-007.009, B101-009.002, C102-002.002 |

## Localization

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Multi-language support | Dev 102, Dev 103 | B102-018.001, B103-009.001 |
| Right-to-left layouts | Dev 102 | B102-018.001 |
| Timezones | Dev 102 | B102-009.001, B102-018.001 |
| Date formats | Dev 102 | B102-009.001 |
| Number and currency formats | Dev 102 | B102-009.002 |

## Integration

### Files and Data Exchange

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Attachments | Dev 102, Dev 103 | B102-016.001, B103-009.001, B103-016.002 |
| File upload and download | Dev 102, Dev 103 | B102-016.002, B102-016.006, B103-015.004, B102-016.005 |
| Import and export data | Dev 102 | B102-016.003, B102-016.004 |
| Export to Excel and PDF | Dev 102, Dev 103 | B103-011.005, B103-012.004, B102-016.003, B102-016.004, B103-006.001 |

### Services and APIs

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| REST and web services | Dev 103 | B103-016.001, B103-016.002 |
| BSO tester | Dev 103 | B103-017.003, B103-016.001 |
| External SOAP and REST services | Dev 103 | B103-016.003 |

### EBS Products and Processes

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Workflow and notifications | Dev 102, Dev 103 | B103-016.006, B102-017.002, B103-016.004, B102-005.002, B102-020.002 |
| Oracle Forms interoperability | Dev 101, Dev 102 | B101-002.002, B102-014.005, B102-014.006 |
| Portlets | Dev 103 | B103-017.001, B103-016.005 |
| Concurrent requests | Dev 102, Dev 103 | B102-017.004, B103-003.003, B103-006.005 |
| OBIEE analytics | Dev 103 | B103-017.002, B103-016.005 |

## Security

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Function security | Dev 101, Dev 103 | B101-012.002, B101-012.001, B103-014.006 |
| Data security | Dev 101 | B101-012.003 |
| Authentication and authorization | Dev 101 | B101-012.001 |
| XSS scanning | Dev 103 | B103-014.007, B103-015.002 |
| AntiSamy filtering | Dev 102, Dev 103 | B103-014.007, B103-015.002, B102-016.005 |
| Virus scanning | Dev 102, Dev 103 | B103-015.004, B102-016.005, B103-014.007 |
| Frame busting | Dev 103 | B103-015.003, B103-014.007 |
| HTML tampering protection | Dev 101 | B101-012.004, B101-012.005 |
| Page access tracking | Dev 103 | B103-014.006, B103-015.001 |

## Errors and diagnostics

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| OAException and severities | Dev 102 | B102-004.002, B102-004.001 |
| Bundled exceptions | Dev 102 | B102-004.003, B102-004.002 |
| Debugger and logging | Dev 101, Dev 103 | B101-011.001, B101-011.002, B103-009.003, B103-003.002 |
| About This Page | Dev 102, Cust 101 | B102-019.003, C101-005.001 |
| OAInfo.jsp | Dev 102 | B102-019.003 |
| FND_LOG and writeDiagnostics | Dev 103 | B103-003.001, B103-003.002, B103-003.003 |
| SQL trace (event 10046) | Dev 103 | B103-003.004, B103-003.002 |
| Log purge (FNDLGPRG) | Dev 103 | B103-003.003 |
| Advanced debugging techniques | Dev 102 | B102-019.001, B102-019.002 |

## Personalization

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Customization concepts | Cust 101 | C101-001.001 |
| Personalization levels | Cust 101 | C101-002.001 |
| Durable personalizations | Cust 101 | C101-001.002 |
| Region injection | Cust 101 | C101-003.004 |
| LOV personalization | Cust 101 | C101-003.005 |
| XMLExporter and XMLImporter | Dev 103, Cust 101, Cust 102 | B103-001.001, C101-004.001, C101-004.002, C101-005.002, C101-005.003 |
| Translated personalizations | Cust 101 | C101-005.002 |
| End-user and declarative page personalization | Cust 101 | C101-001.004, C101-003.001, C101-003.002 |
| MDS content inspection | Cust 101 | C101-004.003 |

## Extension

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Controller extension | Cust 102 | C102-001.001 |
| View object extension | Cust 102 | C102-002.001 |
| Entity object extension | Cust 102 | C102-002.002 |
| Application module extension | Cust 102 | C102-002.003 |
| Substitution and JPX | Dev 103, Cust 102 | B103-001.002, C102-003.001, C102-003.002, C102-001.002, C102-003.003 |
| LOV extension | Cust 102 | C102-001.002 |
| Extension touchpoints and Oracle page extensions | Cust 102 | C102-005.002, C102-005.004 |

## Deployment

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Deployment to EBS | Dev 101, Dev 103, Cust 102 | B101-014.001, B101-014.004, B103-004.003, C102-004.002, B101-014.002 |
| adop and R12.2 patching | Dev 101, Dev 103, Cust 102 | B103-004.001, B101-014.003, C102-004.003, C102-006.004 |
| adcgnjar and customall.jar | Dev 103, Cust 102 | B103-004.002, C102-004.001 |
| AOL functions, menus and responsibilities | Dev 101, Dev 102, Dev 103, Cust 101, Cust 102 | B101-003.008, B103-002.001, B103-002.002, B101-012.002, B101-014.004 |
| Scripted deployment | Dev 103 | B103-004.003 |
| Environment promotion | Cust 102 | C102-006.003 |

## OA Framework Standards

### Coding and Naming Standards

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Why development standards matter | Dev 101 | B101-013.001 |
| Coding standards and naming conventions | Dev 101 | B101-013.002 |
| Oracle, project and industry standards | Dev 101 | B101-013.003 |
| File types and package naming | Dev 101 | B101-013.004 |
| Directory structure ($JAVA_TOP) | Dev 101 | B101-013.005 |
| Common page patterns | Dev 101 | B101-013.007 |

### Project and Code Management

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Workspace and project organization | Dev 101, Dev 103 | B101-003.010, B101-007.002, B103-005.003, B101-003.001, B101-013.005 |
| Code management and version control | Dev 101, Dev 102, Dev 103, Cust 102 | B101-003.010, B101-013.006, B103-005.002, B102-020.001, B103-006.005 |
| Project documentation and delivery | Dev 103 | B103-010.001, B103-010.002, B103-010.003 |
| Mentoring and code review | Dev 101, Dev 103 | B103-010.004, B101-001.003 |

### Quality and Extension Practice

| Capability | Level | Lectures |
| :-- | :-- | :-- |
| Extension standards | Cust 102 | C102-005.001 |
| Custom code placement | Cust 102 | C102-005.003 |
| Server-side best practices | Dev 102 | B102-008.006 |
| Code quality and standards compliance | Dev 101, Dev 102, Dev 103 | B103-011.002, B101-015.006, B102-020.006 |

## UI Component Layout Index

Bean-level OAF component names for each capability that has them, grouped by OAF component category. Look up the lectures in the capability's row.

| Group | Capability | Component |
| :-- | :-- | :-- |
| Layout containers | Pages and regions | page<br>pageLayout<br>attributeSet<br>package |
|  | messageComponentLayout | messageComponentLayout<br>messageLayout<br>labeledFieldLayout<br>defaultSingleColumn<br>defaultDoubleColumn |
|  | Stack, flow, table, row and cell layouts | stackLayout<br>flowLayout<br>rowLayout<br>tableLayout<br>cellFormat |
|  | Panel splitter and layered layout | panelSplitter<br>layeredLayout |
|  | Flexible layout and configurable pages | flexibleLayout<br>flexibleContent<br>flexibleContentList |
|  | Advanced layout and content container regions | contentContainer<br>richContainer |
|  | Section headers, hide/show regions and footers | header<br>hideShowHeader<br>footer<br>contentFooter |
| Data presentation | Bulleted list | bulletedList |
|  | Advanced tables | table<br>advancedTable |
|  | Table columns, totals and row selection | columnGroup<br>sortableHeader<br>totalRow<br>addTableRow<br>singleSelection<br>multipleSelection |
|  | HGrid and tree | HGrid<br>tree<br>nodeDef<br>childNode |
|  | Infotiles | infotile |
| Navigation and page flow | Sub tabs and navigation components | subTabLayout<br>subTabBar<br>hideShowSubTabLayout |
|  | Train and wizards | train |
|  | Breadcrumbs and menus | menu<br>menuItem<br>breadcrumbs<br>locator<br>navigationBar |
| Input and item controls | Shuttle | shuttle |
|  | Popups | popUp |
|  | Form inputs and selection controls | messageTextInput<br>messageChoice<br>messageLovChoice<br>messageRadioButton<br>messageRadioGroup<br>messageCheckBox<br>messageSpinBox |
|  | Text and display items | styledText<br>formattedText<br>instructionText<br>messageStyledText<br>staticStyledText<br>rawText |
|  | Images, spacers and separators | image<br>spacer<br>separator<br>tip |
|  | Buttons and button bars | button<br>submitButton<br>resetButton<br>selectionButton<br>exportButton<br>link<br>pageButtonBar |
|  | Form parameters and includes | formParameter<br>formValue<br>servletInclude<br>urlInclude |
|  | LOV, dependent LOV and look-ahead | listOfValues<br>messageLovInput<br>lovMap<br>lovActionButton<br>lovActionMap |
|  | Rich text, color picker and rating bar | richTextEditor<br>colorPicker<br>messageRatingBar |
|  | Flexfields (DFF and KFF) | flex<br>flexMap |
|  | Dialog pages | dialogPage |
| Attachment and file controls | Attachment mapping | attachmentTable<br>attachmentLink<br>attachmentImage<br>messageInlineAttachment<br>entityMap<br>categoryMap<br>primaryKey |
|  | File upload and download | messageFileUpload<br>messageDownload |
| Analytics and charts | Charts and graphs | graphTable<br>graph<br>graphData |
|  | Gantt charts | Gantt |

## Notes

- A capability counts as covered when a lecture name or note names it. This shows where a topic is taught, not how deeply.
- The list is built from the capability catalogs supplied for this course, not from an official Oracle list.
- The content has not been reviewed by an instructor.
