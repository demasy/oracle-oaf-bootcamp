# Oracle Application Framework (OAF) BootCamp

A hands-on Oracle Application Framework (OAF) BootCamp for Oracle E-Business Suite developers and implementers. Five courses take you from your first OAF page to production deployment and upgrade-safe customization, covering the model, view and controller layers, integration, security, personalization and extension.

## Contents

- [About this BootCamp](#about-this-bootcamp)
- [Levels](#oracle-oaf-bootcamp-levels)
- [Master Class](#oracle-oaf-master-class)
- [Target Audience](#target-audience)
- [Prerequisites & Requirements](#prerequisites--requirements)
- [About the Instructor](#about-the-instructor)
- [How to Get this BootCamp](#how-to-get-this-bootcamp)
- [Contributing](#contributing)

## About this BootCamp

The BootCamp has **five courses**, **63 modules** and **307 lectures**. Every OAF capability it teaches is indexed in [CAPABILITIES.md](bootcamp/CAPABILITIES.md) (177 capabilities across 13 areas).

**How it is organized** (course levels are Beginner, Advanced and Ninja)

- **Course**: one of the five courses, identified by a code such as `OAF-B-101`.
- **Section**: a module of a course, numbered in order (`B101-001`).
- **Lecture**: a lesson inside a section (`B101-001.001`), delivered as a Video, Lab or Workshop.

Each lecture and module carries a **Difficulty** rating from 1 to 5 stars (Beginner, Elementary, Intermediate, Advanced, Expert).

**Capability areas covered**: Architecture, Model Layer, View Layer, Controller Layer, Framework, Localization, Integration, Security, Errors and diagnostics, Personalization, Extension, Deployment and OA Framework Standards, plus a UI Component Layout Index that maps each component to the capability that uses it.

## Oracle OAF BootCamp Levels

### Oracle OAF Building BootCamp

**Path:** Beginner → Advanced → Ninja

<img src="bootcamp/assets/levels-building.svg" width="520" alt="Building path: OAF-B-101 Beginner, OAF-B-102 Advanced, OAF-B-103 Ninja">

| Code | Course | Level | Difficulty | Modules | Lectures | What you learn |
| :-: | :-- | :-: | :-: | :-: | :-: | :-- |
| OAF-B-101 | <a href="bootcamp/building/101/README.md">Oracle OAF Building BootCamp 101</a> | Beginner | <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> – <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 15 | 92 | Architecture, MVC, JDeveloper setup, application modules, view and entity objects, pages, controllers, master-detail, debugging, security, deployment and a capstone |
| OAF-B-102 | <a href="bootcamp/building/102/README.md">Oracle OAF Building BootCamp 102</a> | Advanced | <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> – <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 20 | 97 | Event handling, PPR, LOVs, exception framework, dialogs, advanced tables, flexfields, scripting, internationalization and advanced debugging |
| OAF-B-103 | <a href="bootcamp/building/103/README.md">Oracle OAF Building BootCamp 103</a> | Ninja | <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> – <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 17 | 80 | MDS and BC4J deployment, AOL security, instrumentation, R12.2 online patching, REST integration and a point-of-sale capstone |
| | **Total: 3 courses** | | | **52** | **269** | |

### Oracle OAF Customizing BootCamp

**Path:** Beginner → Advanced

<img src="bootcamp/assets/levels-customizing.svg" width="520" alt="Customizing path: OAF-C-101 Beginner, OAF-C-102 Advanced">

| Code | Course | Level | Difficulty | Modules | Lectures | What you learn |
| :-: | :-- | :-: | :-: | :-: | :-: | :-- |
| OAF-C-101 | <a href="bootcamp/customizing/101/README.md">Oracle OAF Customizing BootCamp 101</a> | Beginner | <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> – <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 5 | 19 | Personalization hierarchy, declarative customization of pages, regions and LOVs, migration and diagnostics |
| OAF-C-102 | <a href="bootcamp/customizing/102/README.md">Oracle OAF Customizing BootCamp 102</a> | Advanced | <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> – <img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="bootcamp/assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 6 | 19 | Controller, LOV and business component extensions, substitution, packaging and R12.2 synchronization |
| | **Total: 2 courses** | | | **11** | **38** | |

## Oracle OAF Master Class

<img src="bootcamp/assets/master-class.svg" width="700" alt="Oracle OAF Master Class, with a ninja character: the Building path (OAF-B-101 Beginner, OAF-B-102 Advanced, OAF-B-103 Ninja) and the Customizing path (OAF-C-101 Beginner, OAF-C-102 Advanced) combine into the Master Class. Customizing 101 follows Building 101 and Customizing 102 follows Building 102.">

<br>

## Target Audience

| Who you are | What you get | Start with |
| :-- | :-- | :-- |
| Oracle Apps Technical Consultant, Oracle Developer or Java Developer | Build OAF pages, regions and business components from scratch, then take them to production | [OAF-B-101](bootcamp/building/101/README.md) |
| Oracle Techno-Functional Consultant | Learn the OAF basics, then personalize pages, regions and LOVs without code and migrate personalizations safely | [OAF-B-101](bootcamp/building/101/README.md), then [OAF-C-101](bootcamp/customizing/101/README.md) |
| Senior OAF Developer | Advanced UI, integration, R12.2 online patching, security hardening and extension of delivered code | [OAF-B-102](bootcamp/building/102/README.md), then [OAF-B-103](bootcamp/building/103/README.md) and [OAF-C-102](bootcamp/customizing/102/README.md) (after [OAF-B-101](bootcamp/building/101/README.md)) |
| EBS Support and Upgrade Team | Diagnose OAF issues and keep personalizations upgrade-safe | [OAF-B-101](bootcamp/building/101/README.md), then [OAF-C-101](bootcamp/customizing/101/README.md) |

<br>

## Prerequisites & Requirements

**Knowledge**

| Track | Course | You should have |
| :-- | :-- | :-- |
| Building | [OAF-B-101](bootcamp/building/101/README.md) | Basic Java programming, SQL, PL/SQL and HTML. Familiarity with Oracle E-Business Suite. No prior OAF experience needed |
| | [OAF-B-102](bootcamp/building/102/README.md) | OAF-B-101 completed: you can build and deploy a CRUD application |
| | [OAF-B-103](bootcamp/building/103/README.md) | OAF-B-102 completed: you can build an interactive application |
| Customizing | [OAF-C-101](bootcamp/customizing/101/README.md) | OAF-B-101 completed and EBS system administration |
| | [OAF-C-102](bootcamp/customizing/102/README.md) | OAF-B-102, OAF-C-101 and OAF-B-103 modules 1-4 completed. Advanced Java, enough to extend controllers and business components |

**Environment**

| Track | You need |
| :-- | :-- |
| Building | Oracle E-Business Suite Virtual Machine, Toad for Oracle or SQL Developer, and an Oracle Support account to download OA Extension<br>[OAF-B-101](bootcamp/building/101/README.md) teaches installing and configuring JDeveloper with OA Extension (module 3) |
| Customizing | Oracle E-Business Suite Virtual Machine. [OAF-C-102](bootcamp/customizing/102/README.md) requires OAF-B-102, so the Building track environment applies to it |

<br>

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

## How to Get this BootCamp

| Option | Who it is for | How to join |
| :-- | :-- | :-- |
| **Online** | Individuals learning at their own pace | <a href="#">Enroll on udemy.com</a> (Not Available now) |
| **Live** | Enterprise teams, instructor-led | <a href="#">Schedule a call via Calendly</a> |

See the [course levels](#oracle-oaf-bootcamp-levels) for what each course covers.

<br>

## Suggestions & Issues

If you find any issue or have a great idea in mind please create an issue on <a href="https://github.com/demasylabs/Oracle-OAF-BootCamp/issues">GitHub</a>.

<br>

## Contributing

New Oracle technical contributors are welcome. Read [Contributing](.github/CONTRIBUTING.md) to learn how to report issues, suggest enhancements, contribute code examples and how review works. For anything else, contact founder@demasy.io.

<br>

### Contributors

| Author | GitHub & LinkedIn account |
| :-  | :---- |
| <div align="center"> <img src="https://github.com/demasy.png" width="100px;" alt="Ahmed El-Demasy"/> <br> **Ahmed El-Demasy** (Creator & Maintainer) <br> Oracle Solutions Architect <br> Oracle ACE </div> | <div align="center"> <a href="https://github.com/demasy">Github</a> & <a href="https://www.linkedin.com/in/demasy">LinkedIn</a> </div> |

<br>
<br>

<p align="center">
Made with love ❤️ in Egypt by <a href="https://github.com/demasylabs"> Demasy Labs </a>
</p>
