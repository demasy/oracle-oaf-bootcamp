# Oracle Application Framework (OAF) BootCamp

## 🧩 Cust 102: Oracle OAF Customizing BootCamp (Advanced)

**Code:** DL-OAF-C-102  
**Duration:** 10-15 Days (proposed, to be confirmed)  
**Level:** Advanced  
**Prerequisites:** Level 102, Cust 101, the Dev 103 production-readiness core (DEV103-1 to DEV103-7) and advanced Java  
**Scaffolding Level:** Moderate (40% guidance)

### Cust 102 Learning Outcomes

Upon completion of Cust 102, students will be able to:
- **LOC2.1:** Apply extension standards and place custom code correctly
- **LOC2.2:** Extend view, entity and application module objects
- **LOC2.3:** Deploy substitutions and extended controllers
- **LOC2.4:** Package, deploy and promote customizations across environments


<br>

## [1] Extension Architecture and Standards
**Duration:** 2 Days | **Level**: Advanced

### Learning Objectives
- Follow naming and packaging standards
- Choose the right extension touchpoint

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 1.1 | Extension Standards | Video | ✓ | Guide | `xx` prefixes, package structure, extension log |
| 1.2 | Extension Touchpoints | Video | ✓ | Diagram | Model object extensions versus controller extensions |
| 1.3 | Custom Code Placement | Video | ✓ | Guide | APPS versus custom schema, grants and synonyms under Edition-Based Redefinition |

<br>

## [2] BC4J Model Object Extensions
**Duration:** 3 Days | **Level**: Advanced

### Learning Objectives
- Extend view objects, entity objects and application modules

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 2.1 | Extending View Objects | Lab | ✓ | Project | Transient and mapped attributes, SQL changes, query overrides |
| 2.2 | Extending Entity Objects | Lab | ✓ | Project | Default values, custom validation rules |
| 2.3 | Extending Application Modules | Lab | ✓ | Project | Custom transaction methods, nested AM extensions |

<br>

## [3] Substitutions and Controller Extensions
**Duration:** 3 Days | **Level**: Advanced

### Learning Objectives
- Replace base BC4J objects at runtime without changing page metadata
- Extend controller behaviour

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 3.1 | Substitution Mechanism | Video | ✓ | Diagram | How MDS substitutions replace parent objects at runtime |
| 3.2 | Deploying Substitutions | Lab | ✓ | Guide | JPX files, `jpximport`, verifying active substitutions; extension-specific steps, tooling basics are in Dev 103 |
| 3.3 | Controller Extensions | Lab | ✓ | Project | Extending `processRequest` and `processFormRequest`, attaching through personalization |
| 3.4 | Troubleshooting Extensions | Lab | ✓ | Checklist | Classloader conflicts, substitution load failures, casting exceptions |
| 3.5 | Programmatic LOV Extensions | Lab | ✓ | Project | LOV controller extensions, VO substitution for LOV queries |

<br>

## [4] Deployment, Packaging and Lifecycle
**Duration:** 2 Days | **Level**: Advanced

### Learning Objectives
- Package and promote customizations safely

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 4.1 | Deployment Packaging | Lab | ✓ | Guide | Classes, XML pages and MDS documents under `$JAVA_TOP`; extension-specific steps, tooling basics are in Dev 103 |
| 4.2 | Import Tools | Lab | ✓ | Guide | XMLImporter for pages and regions, attribute sets |
| 4.3 | Function and Menu Registration | Lab | ✓ | Guide | Register functions, attach to menus, assign responsibilities |
| 4.4 | Environment Promotion | Video | ✓ | Guide | Dev, test and production migration, patching, version control |
| 4.5 | Archive Packaging with adcgnjar | Lab | ✓ | Guide | $AD_TOP/bin/adcgnjar, customall.jar, manifest files, signed archives; applies the Dev 103 tooling to extensions |
| 4.6 | R12.2 Filesystem Synchronization | Lab | ✓ | Guide | adop cycle, dual file systems, adop_sync_drv.tmp custom driver entries |

<br>

## [5] Cust 102 Assessment
**Duration:** 2 Days | **Level**: Advanced

### Learning Objectives
- Extend a seeded page without modifying base code
- Deploy and package the extension for R12.2
- Diagnose a seeded extension failure

### Lectures

| Code | Lecture Title | Format | Practice | Resource | Notes |
| :- | :-------- | :-: | :-: | :-: | :---- |
| 5.1 | Extension Project | Workshop | ✓ | Rubric | Extend a seeded page with a substitution and a controller, then deploy it. Proposed criteria: extension correctness 35, substitution and JPX deployment 25, packaging and adop synchronization 20, troubleshooting log 10, documentation 10 |

### Certification Milestone
**Master Customization Architect**: BC4J extensions, JPX substitutions, controller overrides, XMLImporter deployment, lifecycle governance.
