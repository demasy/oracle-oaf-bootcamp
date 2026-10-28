# Oracle OAF Customizing BootCamp 102

**Code:** DL-OAF-C-102 | **Level:** Advanced | **Duration:** 10-15 days | **Scaffolding:** 40% guidance | **Certification milestone:** Master Customization Architect

## Course Goals

- Apply extension standards and place custom code correctly
- Extend view, entity and application module objects
- Deploy substitutions and extended controllers
- Package, deploy and promote customizations across environments

## Curriculum

| Section | Module | Title | Path | Lectures |
| :-: | :-- | :-- | :-: | :-: |
| [1] | C102-001 | [Controller and LOV Extensions](#1-controller-and-lov-extensions) | Core | 4 |
| [2] | C102-002 | [Business Component Extensions](#2-business-component-extensions) | Core | 6 |
| [3] | C102-003 | [Substitution and Troubleshooting](#3-substitution-and-troubleshooting) | Core | 3 |
| [4] | C102-004 | [Packaging and R12.2 Synchronization](#4-packaging-and-r122-synchronization) | Core | 3 |
| [5] | C102-005 | [Extension Architecture and Standards](#5-extension-architecture-and-standards) | Required | 4 |
| [6] | C102-006 | [Release, Promotion and Assessment](#6-release-promotion-and-assessment) | Required | 5 |

## [1] Controller and LOV Extensions

**Module:** C102-001 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-001.001 | Extending Controllers | Lab | Project | Extending `processRequest` and `processFormRequest`, attaching through personalization |
| C102-001.002 | Extending LOVs Programmatically | Lab | Project | LOV controller extensions, VO substitution for LOV queries |
| C102-001.003 | Practicing LOV Extensions with View Object Substitution | Lab | Project | Extending LOVs with a controller extension and view object substitution |
| C102-001.004 | Extending Controllers with Custom Event Handling | Lab | Project | Extending controllers, super calls to processRequest and processFormRequest |

## [2] Business Component Extensions

**Module:** C102-002 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-002.001 | Extending View Objects | Lab | Project | Transient and mapped attributes, SQL changes, query overrides |
| C102-002.002 | Extending Entity Objects | Lab | Project | Default values, custom validation rules |
| C102-002.003 | Extending Application Modules | Lab | Project | Custom transaction methods, nested AM extensions |
| C102-002.004 | Extending View Objects with Custom Queries | Lab | Project | Extending view objects: SQL changes, bind parameters and transient attributes |
| C102-002.005 | Extending Entity Objects with Custom Validation | Lab | Project | Extending entity objects: extra columns, validation and DML overrides |
| C102-002.006 | Extending Application Modules with Custom Methods | Lab | Project | Extending application modules with custom transaction methods |

## [3] Substitution and Troubleshooting

**Module:** C102-003 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-003.001 | Understanding the Substitution Mechanism | Video | Diagram | How MDS substitutions replace parent objects at runtime |
| C102-003.002 | Deploying Substitutions | Lab | Guide | JPX files, `jpximport`, verifying active substitutions; extension-specific steps, tooling basics are in Dev 103 |
| C102-003.003 | Troubleshooting Extensions | Lab | Checklist | Classloader conflicts, substitution load failures, casting exceptions |

## [4] Packaging and R12.2 Synchronization

**Module:** C102-004 | **Path:** Core  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-004.001 | Packaging Archives with adcgnjar | Lab | Guide | $AD_TOP/bin/adcgnjar, customall.jar, manifest files, signed archives; applies the Dev 103 tooling to extensions |
| C102-004.002 | Packaging Extensions for Deployment | Lab | Guide | Classes, XML pages and MDS documents under `$JAVA_TOP`; extension-specific steps, tooling basics are in Dev 103 |
| C102-004.003 | Synchronizing the R12.2 File Systems | Lab | Guide | adop cycle, dual file systems, adop_sync_drv.tmp custom driver entries |

## [5] Extension Architecture and Standards

**Module:** C102-005 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-005.001 | Applying Extension Standards | Video | Guide | `xx` prefixes, package structure, extension log |
| C102-005.002 | Choosing Extension Touchpoints | Video | Diagram | Model object extensions versus controller extensions |
| C102-005.003 | Placing Custom Code | Video | Guide | APPS versus custom schema, grants and synonyms under Edition-Based Redefinition |
| C102-005.004 | Creating Extensions for Oracle Pages | Video | Patterns | Extending Oracle pages, custom extensions, upgrade-safe mods |

## [6] Release, Promotion and Assessment

**Module:** C102-006 | **Path:** Required  

| Code | Lecture | Format | Resource | Notes |
| :-- | :-------- | :-: | :-- | :---- |
| C102-006.001 | Using Import Tools | Lab | Guide | XMLImporter for pages and regions, attribute sets |
| C102-006.002 | Registering Functions and Menus | Lab | Guide | Register functions, attach to menus, assign responsibilities |
| C102-006.003 | Promoting Customizations Between Environments | Video | Guide | Dev, test and production migration, patching, version control |
| C102-006.004 | Promoting Customizations Through Test and Production | Lab | Checklist | Promoting customizations with migration steps, verification and rollback |
| C102-006.005 | Completing the Extension Project | Workshop | Rubric | Extend a seeded page with a substitution and a controller, then deploy it. Proposed criteria: extension correctness 35, substitution and JPX deployment 25, packaging and adop synchronization 20, troubleshooting log 10, documentation 10 |
