# Oracle OAF Customizing BootCamp 101

**Code:** `OAF-C-101` &nbsp;·&nbsp; **Level:** Beginner

**Difficulty**

| <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> |
| :-: | :-: | :-: | :-: | :-: |
| **Beginner** | **Elementary** | **Intermediate** | **Advanced** | **Expert** |

## Prerequisites

- Completed Building BootCamp 101
- EBS system administration

## Course Goals

- Explain personalization, extension and modification, and when to use each
- Describe how personalizations are stored in the MDS repository
- Create and manage personalizations at every level
- Inspect, export, import and delete MDS content

## Curriculum

| Section | Module | Title | Difficulty | Lectures |
| :-: | :-- | :-- | :-- | :-: |
| [1] | C101-001 | [Upgrade Preservation Principles](#1-upgrade-preservation-principles) | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 4 |
| [2] | C101-002 | [Personalization Hierarchy and Administration](#2-personalization-hierarchy-and-administration) | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 4 |
| [3] | C101-003 | [Declarative Customization of Pages, Regions and LOVs](#3-declarative-customization-of-pages-regions-and-lovs) | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 5 |
| [4] | C101-004 | [Personalization Migration](#4-personalization-migration) | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 |
| [5] | C101-005 | [Diagnostics, Translation and Assessment](#5-diagnostics-translation-and-assessment) | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | 3 |

## [1] Upgrade Preservation Principles

**Module:** C101-001 | **Difficulty:** <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">  

| Code | Lecture | Format | Difficulty | Resource | Notes |
| :-- | :-------- | :-: | :-- | :-- | :---- |
| C101-001.001 | Comparing Personalization, Extension and Modification | Video | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Diagram | Personalization, extension, modification; what is supported |
| C101-001.002 | Preserving Personalizations Through Upgrades | Video | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Diagram | Delta overlays stored apart from base metadata, survival across patches |
| C101-001.003 | Understanding the MDS Repository Architecture | Video | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Repository tables, document paths (`/oracle/apps/...`), XML documents |
| C101-001.004 | Implementing Personalizations in OAF | Video | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | User-level, admin-level customization, personalization limits |

## [2] Personalization Hierarchy and Administration

**Module:** C101-002 | **Difficulty:** <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">  

| Code | Lecture | Format | Difficulty | Resource | Notes |
| :-- | :-------- | :-: | :-- | :-- | :---- |
| C101-002.001 | Applying Personalization Levels and Precedence | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Function, localization, responsibility, organization or location, site and user levels |
| C101-002.002 | Enabling Personalization | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Personalization profile options, Functional Administrator responsibility |
| C101-002.003 | Clearing MDS Caches | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Functional Administrator cache invalidation, seeing personalization changes immediately |
| C101-002.004 | Resolving Personalization Precedence Across Levels | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | User level has highest precedence, then the admin levels, with conflict examples |

## [3] Declarative Customization of Pages, Regions and LOVs

**Module:** C101-003 | **Difficulty:** <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">  

| Code | Lecture | Format | Difficulty | Resource | Notes |
| :-- | :-------- | :-: | :-- | :-- | :---- |
| C101-003.001 | Creating End-User Personalizations | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Personalized views, saved queries, column order, hiding fields |
| C101-003.002 | Applying Declarative Page Personalizations | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Show/hide, reorder, labels, required and rendered, defaults, item styles |
| C101-003.003 | Personalizing Flexfields and Tables | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | DFF/KFF rendering, row counts, export buttons, accessibility columns |
| C101-003.004 | Injecting Regions Declaratively | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Project | Inject stack layouts, tables, buttons and extended regions into seeded pages |
| C101-003.005 | Personalizing LOVs | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Restrict LOV result sets, change list parameters, alter displays declaratively |

## [4] Personalization Migration

**Module:** C101-004 | **Difficulty:** <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">  

| Code | Lecture | Format | Difficulty | Resource | Notes |
| :-- | :-------- | :-: | :-- | :-- | :---- |
| C101-004.001 | Exporting Personalizations with XMLExporter | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Extract personalization XML from MDS, migrate between environments with XMLImporter |
| C101-004.002 | Using MDS Management Tools | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Export to file system, XMLImporter import, delete site or user personalizations |
| C101-004.003 | Inspecting MDS Content | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Region map, printing region XML, listing personalizations |

## [5] Diagnostics, Translation and Assessment

**Module:** C101-005 | **Difficulty:** <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">  

| Code | Lecture | Format | Difficulty | Resource | Notes |
| :-- | :-------- | :-: | :-- | :-- | :---- |
| C101-005.001 | Using About This Page Diagnostics | Lab | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Page context, active personalizations, technology stack, profile options |
| C101-005.002 | Managing Translated Personalizations | Video | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Guide | Managing translated personalization content, export and import with XMLExporter and XMLImporter |
| C101-005.003 | Completing the Personalization Project | Workshop | <img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"><img src="../../assets/difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle"> | Rubric | Personalize a seeded page at two levels and promote it with XMLImporter. Proposed criteria: personalization correctness 40, level targeting and precedence 20, migration with XMLExporter and XMLImporter 25, documentation 15 |
