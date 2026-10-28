# Oracle Application Framework (OAF) BootCamp

## 🛠️ Cust 101: Oracle OAF Customizing BootCamp (Beginner)

**Code:** DL-OAF-C-101  
**Duration:** 10-15 Days (proposed, to be confirmed)  
**Level:** Beginner  
**Prerequisites:** Level 101 and basic EBS system administration  
**Scaffolding Level:** High (60% guidance)

### Cust 101 Learning Outcomes

Upon completion of Cust 101, students will be able to:
- **LOC1.1:** Explain personalization, extension and modification, and when to use each
- **LOC1.2:** Describe how personalizations are stored in the MDS repository
- **LOC1.3:** Create and manage personalizations at every level
- **LOC1.4:** Inspect, export, import and delete MDS content


<br>

## [1] Customization Concepts and MDS Architecture
**Duration:** 3 Days | **Level**: Beginner

### Learning Objectives
- Distinguish personalization, extension and modification
- Understand durable personalizations
- Understand the MDS repository

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 1.1 | Customization Hierarchy | Video | ✓ | Diagram | Personalization, extension, modification; what is supported |
| 1.2 | Durable Personalizations | Video | ✓ | Diagram | Delta overlays stored apart from base metadata, survival across patches |
| 1.3 | MDS Repository | Video | ✓ | Guide | Repository tables, document paths (`/oracle/apps/...`), XML documents |
| 1.4 | Personalization Levels and Precedence | Lab | ✓ | Guide | Function, organization, responsibility, site and localization levels |

<br>

## [2] End-User and Administrative Personalizations
**Duration:** 5 Days | **Level**: Beginner

### Learning Objectives
- Configure personalization for users and administrators
- Personalize pages declaratively

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 2.1 | End-User Personalizations | Lab | ✓ | Guide | Personalized views, saved queries, column order, hiding fields |
| 2.2 | Enabling Personalization | Lab | ✓ | Guide | Personalization profile options, Functional Administrator responsibility |
| 2.3 | Declarative Page Personalizations | Lab | ✓ | Project | Show/hide, reorder, labels, required and rendered, defaults, item styles |
| 2.4 | Flexfield and Table Personalizations | Lab | ✓ | Guide | DFF/KFF rendering, row counts, export buttons, accessibility columns |
| 2.5 | Declarative Region Injection | Lab | ✓ | Project | Inject stack layouts, tables, buttons and extended regions into seeded pages |
| 2.6 | LOV Personalization | Lab | ✓ | Guide | Restrict LOV result sets, change list parameters, alter displays declaratively |

<br>

## [3] MDS Inspection and Maintenance
**Duration:** 3 Days | **Level**: Beginner

### Learning Objectives
- Diagnose pages and their personalizations
- Move personalizations between environments

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 3.1 | "About This Page" Diagnostics | Lab | ✓ | Guide | Page context, active personalizations, technology stack, profile options |
| 3.2 | Inspecting MDS Content | Lab | ✓ | Guide | Region map, printing region XML, listing personalizations |
| 3.3 | MDS Management Tools | Lab | ✓ | Guide | Export to file system, XMLImporter import, delete site or user personalizations |
| 3.4 | Translated Personalizations | Video | ✓ | Guide | Managing translated personalization content |
| 3.5 | Clearing MDS Caches | Lab | ✓ | Guide | Functional Administrator cache invalidation, seeing personalization changes immediately |
| 3.6 | Exporting Personalizations with XMLExporter | Lab | ✓ | Guide | Extract personalization XML from MDS, migrate between environments with XMLImporter |

<br>

## [4] Cust 101 Assessment
**Duration:** 2 Days | **Level**: Beginner

### Learning Objectives
- Apply personalizations at more than one level and explain the precedence result
- Migrate personalizations between environments
- Document the changes made and how to back them out

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 4.1 | Personalization Project | Workshop | ✓ | Rubric | Personalize a seeded page at two levels and promote it with XMLImporter. Proposed criteria: personalization correctness 40, level targeting and precedence 20, migration with XMLExporter and XMLImporter 25, documentation 15 |

### Certification Milestone
**Certified Personalization Specialist**: declarative personalizations across levels, MDS auditing and import/export maintenance.
