# Oracle Application Framework (OAF) BootCamp

A five-course curriculum for Oracle E-Business Suite developers, technical consultants and administrators. The Building path progresses from OAF foundations to production-readiness decisions; the Customizing path covers declarative personalization and supported extensions.

**Repository scope: course curriculum only.** This repository publishes course structure, lecture topics, outcomes, prerequisites, workload estimates and assessment designs. Video, Lab and Workshop are planned delivery formats; resource labels describe intended teaching materials. Recordings, lab instructions, application code and solutions are outside this repository's scope.

## Contents

- [About this BootCamp](#about-this-bootcamp)
- [Course levels](#oracle-oaf-bootcamp-levels)
- [Workload and learning paths](#workload-and-learning-paths)
- [Roadmap](#roadmap)
- [Target audience](#target-audience)
- [Prerequisites and requirements](#prerequisites--requirements)
- [About the instructor](#about-the-instructor)
- [Delivery status](#delivery-status)
- [Contributing](#contributing)

## About this BootCamp

**Five courses · 63 modules · 310 planned lectures · 177 indexed capabilities across 13 areas.** The five [course READMEs](bootcamp/CURRICULUM.md#authoritative-curriculum) are authoritative; the roadmap and capability index are supporting views.

- **Course:** identified by a code such as `OAF-B-101`.
- **Module:** a stable reference such as `B101-001`.
- **Lecture:** a stable reference such as `B101-001.001`.
- **Teaching step:** recommended learning order, which can differ from identifier order.
- **Path:** required competencies versus optional specialist depth. Conditional integrations remain unscheduled until a supported product/release scope is selected.

Each course defines measurable outcomes, module prerequisites, instruction/study/assessment hours, a bounded assessment scenario and exit criteria. See [curriculum conventions and release references](bootcamp/CURRICULUM.md) for the difficulty rubric, assessment policy and version-dependent boundaries.

The [capability index](bootcamp/capabilities/CAPABILITIES.md) locates planned topics, including electives and conditional integrations; counts do not establish mastery or delivery readiness.

## Oracle OAF BootCamp Levels

### Oracle OAF Building BootCamp

**Path:** Beginner → Advanced → Ninja

<img src="bootcamp/assets/levels-building.svg" width="520" alt="Building course progression">

| Code | Course | Level | Difficulty | Modules | Lectures | Required focus |
| :-- | :-- | :-- | :-- | --: | --: | :-- |
| OAF-B-101 | [Building BootCamp 101](bootcamp/courses/building/101/README.md) | Beginner | ★–★★★ | 15 | 95 | MVC, setup, BC4J model, declarative pages, GET/POST, messages, master-detail, security, deployment and Jobs/Positions design |
| OAF-B-102 | [Building BootCamp 102](bootcamp/courses/building/102/README.md) | Advanced | ★★–★★★★ | 20 | 97 | PPR, LOVs, advanced tables, model validation, recoverable navigation, accessibility and interactive request design |
| OAF-B-103 | [Building BootCamp 103](bootcamp/courses/building/103/README.md) | Ninja | ★★★–★★★★★ | 17 | 80 | MDS/BC4J deployment, diagnostics, R12.2 patching, state/security analysis and bounded sales/inventory design |

### Oracle OAF Customizing BootCamp

**Path:** Beginner → Advanced

<img src="bootcamp/assets/levels-customizing.svg" width="520" alt="Customizing course progression">

| Code | Course | Level | Difficulty | Modules | Lectures | Required focus |
| :-- | :-- | :-- | :-- | --: | --: | :-- |
| OAF-C-101 | [Customizing BootCamp 101](bootcamp/courses/customizing/101/README.md) | Beginner | ★–★★★ | 5 | 19 | Personalization levels, supported property/region/LOV changes, migration, diagnostics and back-out |
| OAF-C-102 | [Customizing BootCamp 102](bootcamp/courses/customizing/102/README.md) | Advanced | ★★★–★★★★ | 6 | 19 | Extension architecture, model/controller contracts, BC4J substitution, packaging, synchronization and recovery |

### Oracle OAF Master Class

<img src="bootcamp/assets/master-class.svg" width="700" alt="Master Class combines the Building and Customizing curricula; Customizing 102 also requires the Building 103 deployment core">

Master Class and Ninja describe provider-defined curriculum milestones. They are not Oracle certifications.

## Workload and Learning Paths

| Course | Required lectures | Elective lectures | Instruction h | Study h | Assessment h | Required total h | Scheduled elective additions h |
| :-- | --: | --: | --: | --: | --: | --: | --: |
| OAF-B-101 | 90 | 5 | 32.5 | 25 | 20 | 77.5 | 3.5 |
| OAF-B-102 | 53 | 44 | 28.5 | 22 | 24 | 74.5 | 36.5 |
| OAF-B-103 | 54 | 26 | 28 | 12 | 44 | 84 | 21.5 |
| OAF-C-101 | 18 | 1 | 10 | 7 | 6 | 23 | 0 |
| OAF-C-102 | 19 | 0 | 13 | 8.5 | 10 | 31.5 | 0 |

Hours are editorial planning estimates, not measured completion times. Instruction, study and assessment time are additive; capstone time is counted once. Scheduled elective additions cover fully elective modules; optional extensions inside required modules and conditional product integrations receive an additional time estimate only when selected. The required Building path totals **236 hours**; completing all five required course paths totals **290.5 hours**, without repeating shared prerequisites.

For each course, follow its Teaching step column and module prerequisites. Customizing 101 follows Building 101. Customizing 102 requires Building 102, Customizing 101 and Building 103 modules **B103-001 through B103-004**; the full Building 103 capstone is not an entry requirement. Equivalent experience is evaluated through each course's readiness check.

## Roadmap

The [OAF roadmap](roadmap/README.md) presents both paths with their planned modules and lectures. Required/elective labels come from course headings; level badges summarize module difficulty. Consult the course pages for individual lecture difficulty, prerequisite details and assessment scope.

## Target Audience

| Audience | Intended curriculum outcome | Suggested route |
| :-- | :-- | :-- |
| Oracle Apps technical consultants and Java/SQL developers | Explain and design OAF applications through release planning | Building 101 → 102 → 103 |
| Techno-functional consultants and EBS administrators | Select supported declarative personalizations and plan migration | Building 101 → Customizing 101 |
| Experienced OAF developers | Evaluate interactions, state, diagnostics, security and release decisions | Readiness check → Building 102/103 |
| Seeded-page customization and upgrade teams | Review extension contracts, substitutions and lifecycle risks | Customizing 101 + Building 102 + Building 103 deployment core → Customizing 102 |

## Prerequisites & Requirements

| Course | Entry requirements |
| :-- | :-- |
| [Building 101](bootcamp/courses/building/101/README.md) | Java classes/inheritance/exceptions, SQL/DML, PL/SQL reading, HTML and EBS familiarity |
| [Building 102](bootcamp/courses/building/102/README.md) | Building 101 exit competencies, including basic CRUD, GET/POST, validation and transactions |
| [Building 103](bootcamp/courses/building/103/README.md) | Building 102 required outcomes and basic Git/database design concepts |
| [Customizing 101](bootcamp/courses/customizing/101/README.md) | Building 101 exit competencies and EBS administration concepts |
| [Customizing 102](bootcamp/courses/customizing/102/README.md) | Building 102, Customizing 101, Building 103 modules 1–4 and Java subclassing |

**For curriculum review:** read the published outlines and linked documentation. **For future practical delivery:** select a target EBS/OAF 12.2 patch level, matching JDeveloper OA Extension/JDK, development database access, appropriate responsibilities and permitted Oracle Support downloads. Product-dependent electives require their named integrations. These are delivery prerequisites described by the curriculum, not an environment supplied by this repository.

## About the Instructor

<img src="https://github.com/demasy.png" width="100px" align="left" alt="Ahmed El-Demasy" hspace="16">

**<a href="https://github.com/demasy">Ahmed El-Demasy</a>**<br>
Oracle Solution Architect · Technical Track Lead · Oracle ACE Associate

I have more than 17 years of experience delivering enterprise Oracle and HR digital transformation programs across Saudi Arabia and the GCC, and for 11 of those years I have developed ERP solutions with Java and Oracle tools, specializing in Oracle Application Framework (OAF).

<br clear="left">

| Focus | What I do |
| :-- | :-- |
| **Delivery** | Large-scale enterprise Oracle and HR digital transformation programs, including self-service platforms and automated services across web, mobile and kiosk channels |
| **Technical expertise** | Oracle E-Business Suite with OAF, ADF, SQL, PL/SQL, Forms, Reports, Workflow, AME and BI Publisher, plus REST/SOAP APIs, SOA Gateway and enterprise integration |
| **Architecture** | Solution architecture, enterprise integration, Oracle Cloud and Oracle Fusion Cloud HCM |
| **Leadership** | Leading and mentoring Oracle development teams, with architecture governance, code quality and Agile delivery standards |
| **Teaching** | Oracle SQL, Oracle PL/SQL, Java SE, Oracle Application Framework (OAF) and Oracle Workflow |
| **Credentials** | Oracle ACE Associate, OCI-certified, plus TOGAF and ITIL foundations |

<a href="https://github.com/demasy">GitHub</a> · <a href="https://www.linkedin.com/in/demasy/">LinkedIn</a>

<br>

## Delivery Status

This repository publishes the curriculum specification. Enrollment, recordings, live-cohort schedules and delivery-platform links have not been published here. For curriculum or delivery enquiries, contact founder@demasy.io.

## Suggestions & Issues

Report curriculum issues through [GitHub Issues](https://github.com/demasylabs/Oracle-OAF-BootCamp/issues). Include the course/module/lecture ID, the current wording and a concrete correction or supporting reference.

## Contributing

Curriculum contributions are welcome: clarify outcomes, repair prerequisite order, improve workload estimates, refine assessment criteria or supply authoritative release references. Keep changes within the curriculum scope and follow [curriculum maintenance conventions](bootcamp/CURRICULUM.md#curriculum-maintenance). Update supporting views when course content changes.

### Contributors

**Ahmed El-Demasy** — Creator and maintainer · [GitHub](https://github.com/demasy) · [LinkedIn](https://www.linkedin.com/in/demasy/)

<p align="center">Made with love ❤️ in Egypt by <a href="https://github.com/demasylabs">Demasy Labs</a></p>
