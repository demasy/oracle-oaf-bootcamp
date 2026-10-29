# Curriculum Conventions and Release Scope

This repository specifies the Oracle Application Framework (OAF) BootCamp curriculum. It contains course structure, lecture topics, intended learning outcomes, prerequisites, estimated workload, assessment designs and visual roadmaps. Video, Lab and Workshop are planned delivery formats; Guide, Tutorial, Scripts, Project and similar labels name intended resource types. They do not indicate that recordings, lab instructions, application code or solutions are supplied here.

## Authoritative Curriculum

The five course READMEs under [courses/](courses/) are the source of truth for module and lecture content, teaching order, required/elective paths, hours and assessments:

| Course | Curriculum | Entry dependency |
| :-- | :-- | :-- |
| OAF-B-101 | [Building 101](courses/building/101/README.md) | Java, SQL, PL/SQL reading, HTML and EBS familiarity |
| OAF-B-102 | [Building 102](courses/building/102/README.md) | Building 101 exit competencies |
| OAF-B-103 | [Building 103](courses/building/103/README.md) | Building 102 required-path exit competencies |
| OAF-C-101 | [Customizing 101](courses/customizing/101/README.md) | Building 101 exit competencies and EBS administration concepts |
| OAF-C-102 | [Customizing 102](courses/customizing/102/README.md) | Building 102, Customizing 101, Building 103 modules B103-001 through B103-004, and Java subclassing |

Equivalent prior experience can satisfy an entry dependency through the published readiness check. A course title alone does not establish readiness.

The root README summarizes these courses. The [roadmap](../roadmap/README.md), [capability index](capabilities/CAPABILITIES.md), CSV and SVG statistics are derived views. An ignored local `brain/` folder, where present, is private reference material and is not part of the published curriculum or an alternative syllabus.

## Identifiers and Teaching Order

Course codes are `OAF-B-101`, `OAF-B-102`, `OAF-B-103`, `OAF-C-101` and `OAF-C-102`. Module identifiers use `B101-001`; lecture identifiers use `B101-001.001`. Existing identifiers remain stable when a topic is clarified or moved within a course. Follow the **Teaching step** column and displayed section order, not numeric ID order. The same rule applies to reordered lectures inside a module.

Each module has a measurable outcome and prerequisites. Course outcome IDs such as `B101-LO03` connect modules to assessment criteria. Earlier topic treatments are foundations; later treatments must state what additional reasoning, context or failure analysis they add.

## Required, Elective and Conditional Scope

- **Required:** contributes to the course exit competencies and assessment. A required outcome must be reachable through course entry competencies and the required path.
- **Elective:** specialist depth that can be skipped without losing required competencies or assessment marks. Check its additional module/product prerequisites before selecting it.
- **Conditional elective:** a product-specific or version-dependent integration whose exact supported combination or implementation approach has not been established for a delivery environment. It has no required assessment marks and no scheduled hours until its scope is confirmed.

Module headings show Required or Elective so roadmaps retain that distinction. A required module may contain an explicitly marked elective extension; the following entire lectures are optional within otherwise required modules:

| Lecture | Elective extension | Scheduling rule |
| :-- | :-- | :-- |
| B102-017.002 | Oracle Workflow automation | Requires Workflow knowledge and configured product integration; application-level approval states remain required |
| B102-017.005 | Business Event System integration | Requires event/subscription knowledge and a configured product environment |
| C101-005.002 | Translated personalizations | Requires translation administration and configured languages |

Their hours are excluded from the required schedule and set when selected. Optional feature portions mentioned in a required lecture are comparisons, not mandatory implementations. For example, the basic look-and-feel outcome in B101-007.008 does not require a Redwood deployment.

The capability index includes required, elective and conditional topics. Its keyword matching locates potential coverage; it is not an outcome-to-assessment map, a completeness guarantee or an official Oracle competency framework. Use each course's Outcomes and Coverage table to establish required competency.

## Difficulty and Workload

| Rating | Meaning | Typical prerequisite and cognitive demand |
| :-- | :-- | :-- |
| ★ | Beginner | Recognize vocabulary, identify framework roles or describe a straightforward process |
| ★★ | Elementary | Apply one established pattern with limited dependencies |
| ★★★ | Intermediate | Coordinate components, compare alternatives or explain lifecycle and validation decisions |
| ★★★★ | Advanced | Analyze cross-layer behavior, security, integration, release or recovery trade-offs |
| ★★★★★ | Expert | Reason about specialized framework mechanics such as polymorphic entities, passivation or resource swapping |

Ratings are editorial judgments based on the task, not automatic increases for Lab or Workshop formats. A module rating describes its central task; a specialized lecture may differ. Roadmap level badges summarize module ratings: Foundation = 1–2, Core = 3, Advanced = 4, Expert = 5. Capability-index levels instead describe the earliest course that names a topic; these two views answer different questions.

Each module estimates instruction, independent study and assessment preparation separately in hours. They are additive. Assessment time includes the planned capstone analysis/review or future implementation expectation, as specified by that course; it is not hidden inside instruction time. Alternative assessment scenarios share one allowance. Do not add both alternatives or count capstone time twice.

Course totals cover that course's selected modules only. Add missing prerequisite-course/elective time when planning an individual route. Elective extensions within required modules and conditional integrations remain unscheduled until selected and scoped. Estimates are curriculum planning assumptions, not pilot measurements, guaranteed completion times or production-delivery estimates. Refine them after a future course pilot.

## Assessment Policy

Every course defines a bounded scenario, weighted criteria totaling 100%, evidence connected to required outcomes, an overall threshold and critical criteria. All criteria require at least 70%; Building 103 also requires at least 85/100 overall. The other course thresholds are stated on their pages. A critical failure cannot be offset by optional features or presentation marks.

The common scoring anchors are 0% absent/incorrect, 50% partly correct with substantial gaps, 70% meets requirements with minor gaps, 85% correct and justified with failure-case reasoning, and 100% complete and precise with convincing trade-off analysis. Reassessment addresses the affected evidence and critical criteria. This defines assessment design only; it does not publish an assignment or require production access.

A curriculum review may use design defenses, lifecycle traces and scenario analysis. A delivered implementation course should also require its declared demonstrations before certifying implementation competence. Completion titles, including Ninja/Master Class, are provider-defined course milestones and are not Oracle certifications.

## Release Applicability and References

The principal context is **Oracle E-Business Suite Release 12.2**. R12.1 appears only as a historical deployment comparison. The curriculum does not declare every feature available on every 12.2 patch level and does not prescribe a universal JDeveloper/JDK combination. A future delivery selects its target EBS/OAF patch level and the matching OA Extension/JDK from the corresponding Oracle documentation and support notes.

The following references establish curriculum coverage boundaries. Documentation confirmation is not runtime validation of this repository.

| Topic | Curriculum treatment and boundary | Primary reference |
| :-- | :-- | :-- |
| Core OAF development | MVC, BC4J, page/controller lifecycle, deployment and framework components; consult the guide matching the delivery release | [OAF Developer's Guide 12.2.12](https://docs.oracle.com/cd/F21816_01/infoportal/oafdg/12212_OAFDevGuide.pdf) |
| Redwood look and feel | Documented for OAF 12.2.13/12.2.14, with accessibility caveats; this establishes documented availability, not an earliest introduction version or a required theme | [Oracle OAF accessibility report](https://docs.oracle.com/en/corporate/accessibility/templates/t2-12687.html) |
| Native Excel/PDF table export | Properties are documented in the component references; availability and behavior depend on the component/release. Do not equate native export with Web ADI | [OAF Component Reference 12.2.10](https://docs.oracle.com/cd/F21816_01/infoportal/oafcr/12210_OAFCompRefGuide.pdf), [12.2.14 reference](https://docs.oracle.com/cd/F21816_01/infoportal/oafcr/12214_OAFCompRefGuide.pdf) |
| Masonry layout | Documented from 12.2.9; elective layout selection with component-specific device/accessibility behavior | [OAF Developer's Guide 12.2.10, Masonry Layout](https://docs.oracle.com/cd/F21816_01/infoportal/oafdg/12210_OAFDevGuide.pdf) |
| Infotiles and component personalization | Documented component-specific behavior; elective comparison rather than a promise of a generic BI-to-JET migration | [Personalization considerations by component](https://docs.oracle.com/cd/E26401_01/doc.122/e22031/T406873T673082.htm) |
| External rich content | richContainer/OARichContainerBean supports external content; a specific embedded JET application remains a conditional integration requiring its own support and authentication analysis | [OAF Component Reference 12.2.9, richContainer](https://docs.oracle.com/cd/F21816_01/infoportal/oafcr/1229_OAFCompRefGuide.pdf) |
| Personalization layering | Later applicable layers overlay earlier ones; distinguish hierarchy position from effective override precedence and component restrictions | [Personalization Framework overview](https://docs.oracle.com/cd/E26401_01/doc.122/e22031/T401443T401448.htm) |
| Declarative injection and LOV limits | Respect Add Indexed Children, supported levels/styles and component caveats; customization is not authorization | [Personalization pages](https://docs.oracle.com/cd/E26401_01/doc.122/e22031/T406873T407693.htm), [component caveats](https://docs.oracle.com/cd/E26401_01/doc.122/e22031/T406873T673082.htm) |
| R12.2 customizations | Editioning, registered schemas, APPS synonyms, synchronization and recovery are required deployment concerns | [EBS Developer's Guide: online patching customizations](https://docs.oracle.com/cd/E26401_01/doc.122/e22961/T302934T584446.htm) |
| Product-specific Web ADI, OBIEE, portlets and CRM/JTT integration | Conditional where the exact integration combination is unspecified; name target product/version, supported mechanism and prerequisites before scheduling | [EBS Developer's Guide](https://docs.oracle.com/cd/E26401_01/doc.122/e22961/toc.htm); the selected product's corresponding integration documentation is additionally required |

The active customization synchronization driver and supplied template serve different roles; course deployment planning distinguishes `adop_sync_drv.txt` from `adop_sync_drv.tmp`. The authoritative deployment procedure is the release-matched Oracle guidance, including My Oracle Support document 1577661.1 referenced by the EBS Developer's Guide. No direct edits to a supplied template are implied.

## Curriculum Maintenance

1. Edit the authoritative course README, retaining existing IDs where their meaning remains compatible.
2. Check prerequisites and outcome/assessment coverage before changing required/elective scope.
3. Update counts, workload summaries, root navigation and release references together.
4. Refresh the existing capability and roadmap outputs after content changes. Preserve curriculum-only scope notes in those views and use actual lecture ratings when reviewing difficulty.
5. Review local paths/anchors, unique IDs, weighted totals and module prerequisites. No lab or application-code implementation is part of this maintenance process.

[BootCamp overview](../README.md)
