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
| [1] | C101-1 | [Upgrade Preservation Principles](#1-upgrade-preservation-principles) | Core | 4 |
| [2] | C101-2 | [Personalization Hierarchy and Administration](#2-personalization-hierarchy-and-administration) | Core | 3 |
| [3] | C101-3 | [Declarative Customization of Pages, Regions and LOVs](#3-declarative-customization-of-pages-regions-and-lovs) | Core | 5 |
| [4] | C101-4 | [Personalization Migration](#4-personalization-migration) | Core | 3 |
| [5] | C101-5 | [Diagnostics, Translation and Assessment](#5-diagnostics-translation-and-assessment) | Required | 3 |

## [1] Upgrade Preservation Principles

**Module:** C101-1 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-1.1 | Distinguishing Personalization, Extension and Modification | Video | Diagram | Personalization, extension, modification; what is supported |
| C101-1.2 | Preserving Personalizations Through Upgrades | Video | Diagram | Delta overlays stored apart from base metadata, survival across patches |
| C101-1.3 | Understanding the MDS Repository | Video | Guide | Repository tables, document paths (`/oracle/apps/...`), XML documents |
| C101-1.4 | Implementing Personalizations in OAF | Video | Guide | User-level, admin-level customization, personalization limits |

## [2] Personalization Hierarchy and Administration

**Module:** C101-2 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-2.1 | Applying Personalization Levels and Precedence | Lab | Guide | Function, organization, responsibility, site and localization levels |
| C101-2.2 | Enabling Personalization | Lab | Guide | Personalization profile options, Functional Administrator responsibility |
| C101-2.3 | Clearing MDS Caches | Lab | Guide | Functional Administrator cache invalidation, seeing personalization changes immediately |

## [3] Declarative Customization of Pages, Regions and LOVs

**Module:** C101-3 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-3.1 | Creating End-User Personalizations | Lab | Guide | Personalized views, saved queries, column order, hiding fields |
| C101-3.2 | Applying Declarative Page Personalizations | Lab | Project | Show/hide, reorder, labels, required and rendered, defaults, item styles |
| C101-3.3 | Personalizing Flexfields and Tables | Lab | Guide | DFF/KFF rendering, row counts, export buttons, accessibility columns |
| C101-3.4 | Injecting Regions Declaratively | Lab | Project | Inject stack layouts, tables, buttons and extended regions into seeded pages |
| C101-3.5 | Personalizing LOVs | Lab | Guide | Restrict LOV result sets, change list parameters, alter displays declaratively |

## [4] Personalization Migration

**Module:** C101-4 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-4.1 | Exporting Personalizations with XMLExporter | Lab | Guide | Extract personalization XML from MDS, migrate between environments with XMLImporter |
| C101-4.2 | Using MDS Management Tools | Lab | Guide | Export to file system, XMLImporter import, delete site or user personalizations |
| C101-4.3 | Inspecting MDS Content | Lab | Guide | Region map, printing region XML, listing personalizations |

## [5] Diagnostics, Translation and Assessment

**Module:** C101-5 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C101-5.1 | Using About This Page Diagnostics | Lab | Guide | Page context, active personalizations, technology stack, profile options |
| C101-5.2 | Managing Translated Personalizations | Video | Guide | Managing translated personalization content |
| C101-5.3 | Completing the Personalization Project | Workshop | Rubric | Personalize a seeded page at two levels and promote it with XMLImporter. Proposed criteria: personalization correctness 40, level targeting and precedence 20, migration with XMLExporter and XMLImporter 25, documentation 15 |
