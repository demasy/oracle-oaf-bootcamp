# Oracle OAF Customizing BootCamp 101

**Code:** DL-OAF-C-101 | **Level:** Beginner | **Duration:** 10-15 days | **Scaffolding:** 60% guidance | **Certification milestone:** Certified Personalization Specialist

## Course Goals

- Explain personalization, extension and modification, and when to use each
- Describe how personalizations are stored in the MDS repository
- Create and manage personalizations at every level
- Inspect, export, import and delete MDS content

## Curriculum

| Section | Module | Title | Path | Lectures |
| :-: | :-- | :-- | :-: | :-: |
| [1] | C101-001 | [Upgrade Preservation Principles](#1-upgrade-preservation-principles) | Core | 4 |
| [2] | C101-002 | [Personalization Hierarchy and Administration](#2-personalization-hierarchy-and-administration) | Core | 4 |
| [3] | C101-003 | [Declarative Customization of Pages, Regions and LOVs](#3-declarative-customization-of-pages-regions-and-lovs) | Core | 7 |
| [4] | C101-004 | [Personalization Migration](#4-personalization-migration) | Core | 3 |
| [5] | C101-005 | [Diagnostics, Translation and Assessment](#5-diagnostics-translation-and-assessment) | Required | 4 |

## [1] Upgrade Preservation Principles

**Module:** C101-001 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-001.001 | Distinguishing Personalization, Extension and Modification | Video | Diagram | Personalization, extension, modification; what is supported |
| C101-001.002 | Preserving Personalizations Through Upgrades | Video | Diagram | Delta overlays stored apart from base metadata, survival across patches |
| C101-001.003 | Understanding the MDS Repository | Video | Guide | Repository tables, document paths (`/oracle/apps/...`), XML documents |
| C101-001.004 | Implementing Personalizations in OAF | Video | Guide | User-level, admin-level customization, personalization limits |

## [2] Personalization Hierarchy and Administration

**Module:** C101-002 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-002.001 | Applying Personalization Levels and Precedence | Lab | Guide | Function, organization, responsibility, site and localization levels |
| C101-002.002 | Enabling Personalization | Lab | Guide | Personalization profile options, Functional Administrator responsibility |
| C101-002.003 | Clearing MDS Caches | Lab | Guide | Functional Administrator cache invalidation, seeing personalization changes immediately |
| C101-002.004 | Practicing Personalization Levels | Lab | Tutorial | Personalization levels applied at site, responsibility and user with precedence results |

## [3] Declarative Customization of Pages, Regions and LOVs

**Module:** C101-003 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-003.001 | Creating End-User Personalizations | Lab | Guide | Personalized views, saved queries, column order, hiding fields |
| C101-003.002 | Applying Declarative Page Personalizations | Lab | Project | Show/hide, reorder, labels, required and rendered, defaults, item styles |
| C101-003.003 | Personalizing Flexfields and Tables | Lab | Guide | DFF/KFF rendering, row counts, export buttons, accessibility columns |
| C101-003.004 | Injecting Regions Declaratively | Lab | Project | Inject stack layouts, tables, buttons and extended regions into seeded pages |
| C101-003.005 | Personalizing LOVs | Lab | Guide | Restrict LOV result sets, change list parameters, alter displays declaratively |
| C101-003.006 | Practicing Injecting Regions into Seeded Pages | Lab | Project | Injecting regions with stack layouts and buttons into a seeded page |
| C101-003.007 | Practicing Personalizing LOVs in Seeded Pages | Lab | Tutorial | Personalizing LOVs: restricting results and changing list parameters |

## [4] Personalization Migration

**Module:** C101-004 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-004.001 | Exporting Personalizations with XMLExporter | Lab | Guide | Extract personalization XML from MDS, migrate between environments with XMLImporter |
| C101-004.002 | Using MDS Management Tools | Lab | Guide | Export to file system, XMLImporter import, delete site or user personalizations |
| C101-004.003 | Inspecting MDS Content | Lab | Guide | Region map, printing region XML, listing personalizations |

## [5] Diagnostics, Translation and Assessment

**Module:** C101-005 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-005.001 | Using About This Page Diagnostics | Lab | Guide | Page context, active personalizations, technology stack, profile options |
| C101-005.002 | Managing Translated Personalizations | Video | Guide | Managing translated personalization content |
| C101-005.003 | Practicing Translated Personalizations | Lab | Guide | Translated personalizations exported and imported with XMLExporter and XMLImporter |
| C101-005.004 | Completing the Personalization Project | Workshop | Rubric | Personalize a seeded page at two levels and promote it with XMLImporter. Proposed criteria: personalization correctness 40, level targeting and precedence 20, migration with XMLExporter and XMLImporter 25, documentation 15 |
