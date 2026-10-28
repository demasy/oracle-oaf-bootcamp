# Oracle OAF BootCamp Roadmap

This roadmap sequences the work needed to make the BootCamp syllabus set complete, consistent and the single source of truth. Syllabus work comes first; repository hygiene, code-brain alignment and delivery follow.

## 1. Course Map

Five courses, built in order. Codes follow the README (`DL-OAF-B-*` for Building, `DL-OAF-C-*` for Customizing). The Customizing courses are referred to as **Cust 101 / Cust 102**; the "Level 201/202" wording in the old `SYLLABUS.md` is retired.

| Code | Course | Audience | Duration | Scaffolding | Prerequisites | Capstone / Assessment | Certification milestone |
| :-- | :-- | :-- | :-: | :-: | :-- | :-- | :-- |
| DL-OAF-B-101 | Dev 101 (Beginner) | Junior developers, technical consultants | 28-32 days | 60% | Basic Java, SQL, PL/SQL, HTML | Jobs & Positions ([PROJECT_LEVEL_101.md](PROJECT_LEVEL_101.md)) | Associate OAF Developer |
| DL-OAF-B-102 | Dev 102 (Advanced) | Application developers, technical leads | 20-25 days | 40% | Dev 101 | POS / Items approval projects, final assessment | Professional OAF Developer |
| DL-OAF-B-103 | Dev 103 (Ninja) | Senior consultants, architects | 20-30 days | 20% | Dev 102 | POS capstone, 85% pass gate | Master OAF Developer |
| DL-OAF-C-101 | Cust 101 | EBS administrators, functional/technical consultants | To be set | To be set | Dev 101, EBS system administration | To be defined | Certified Personalization Specialist |
| DL-OAF-C-102 | Cust 102 | Senior customization engineers, architects | To be set | To be set | Dev 102, Cust 101, advanced Java | To be defined | Master Customization Architect |

## 2. Where We Are

| Area | State |
| :-- | :-- |
| [SYLLABUS_101.md](SYLLABUS_101.md), [SYLLABUS_102.md](SYLLABUS_102.md), [SYLLABUS_103.md](SYLLABUS_103.md) | Complete, per-level numbering |
| [SYLLABUS.md](SYLLABUS.md) | Old monolith; superseded but not marked deprecated |
| [INSTRUCTOR_SYLLABUS.md](INSTRUCTOR_SYLLABUS.md) | Sections 2-5 and the capstone teaching guide written; Sections 6-10 listed as next steps |
| [LABS.md](LABS.md) | Complete, but uses the old global [1]-[24] numbering and a different Level 103 scope |
| [PROJECT_LEVEL_101.md](PROJECT_LEVEL_101.md) | Complete, but not referenced from `SYLLABUS_101.md` |
| [SYLLABUS_CUST_101.md](SYLLABUS_CUST_101.md), [SYLLABUS_CUST_102.md](SYLLABUS_CUST_102.md) | Scaffolded; durations and assessment criteria still to be confirmed |
| `building-101`, `building-102`, `building-project-101` | 2021-era outlines with duplicate codes and placeholder titles |
| `building-103` | One-line stub |
| [code-brain/](code-brain/) | Foundation Framework v2.0.0 and pattern library; docs live in `code-brain.json` |

The full four-tier outline (Level, Section, Module, Lecture) is in [COURSE.md](COURSE.md).

## 3. Phases

### Phase 1: Decide and align

Goal: one mapping of topics to levels, one numbering scheme.

- [ ] Assign every topic in the reference curriculum to exactly one level. Dev 103 is a POS capstone in the repo but an advanced-topics course in the reference; some topics (HGrid, train, shuttle, workflow) currently sit in Dev 102.
- [ ] Settle capstone naming: Jobs & Positions (101), POS and Items approval (102), POS capstone (103).
- [x] Mark `SYLLABUS.md` as deprecated and point to the per-level files.
- [x] Mark the `building-*` READMEs as legacy outlines superseded by the `SYLLABUS_*` files.
- [ ] Renumber `LABS.md` to match the `SYLLABUS_10x.md` sections and the Level 103 content.

Done when: a topic appears in one level only, and `LABS.md` sections map one-to-one to syllabus sections.

### Phase 2: Complete the syllabus set

Goal: every course has a syllabus, and every syllabus has an instructor guide.

- [x] Add the Jobs & Positions capstone to `SYLLABUS_101.md` and link `PROJECT_LEVEL_101.md`.
- [x] Add the missing Dev 103 topics: Advanced Tables, HGrid and search, REST and BSO, Back Button support, security (XSS, page access tracking), data visualization.
- [x] Write `SYLLABUS_CUST_101.md`: customization concepts and MDS, end-user and admin personalizations, MDS inspection and maintenance.
- [x] Write `SYLLABUS_CUST_102.md`: extension standards, BC4J object extensions, substitutions (JPX) and controller extensions, deployment and lifecycle.
- [ ] Finish `INSTRUCTOR_SYLLABUS.md` Sections 6-10, then add guides for Levels 102, 103 and the Cust courses.
- [x] Resolve `building-103/README.md`: fold into `SYLLABUS_103.md` or remove.
- [x] Add a certification table to each syllabus.
- [x] Restructure [COURSE.md](COURSE.md) around the 35 reference modules (seven core modules per course, remaining content as extended modules); six Dev 101 lectures moved to Dev 102.
- [ ] Renumber the `SYLLABUS_*.md` files and `LABS.md` to match the restructured outline.
- [x] Fill topic gaps against the second reference curriculum: bind variables and view criteria, OADBTransaction, dependent LOVs, server-side PPR, dialog pages, region injection, XMLExporter, adcgnjar, adop filesystem sync, FND_LOG diagnostics, and a Dev 103 Production Readiness Track (sections 13-16).

Done when: five syllabi exist, each with outcomes, duration, scaffolding, prerequisites, assessment and certification milestone.

### Phase 3: Repository hygiene

- [ ] Update `README.md` from v1.4.0 to v2.0.0, add the Foundation Framework, link this roadmap, and fill the level table links.
- [ ] Remove or repair README links to deleted files (`CHANGELOG.md`, `MESSAGEHELPER_GUIDE.md`, `MESSAGE_REGISTRATION.sql`, `code-brain/README.md` and the two validation docs).
- [ ] Fix the repository-structure tree in the README.
- [ ] Fix `.github` link paths and the quality-check workflow, which requires `LICENSE.md` and `code-brain/README.md`.
- [ ] Rename `demasylabs-barin/` and the `building-project-101/ setting-up-environment.md` file with its leading space.
- [ ] Repair `building-101/instructions-101/file-standards.md`: CO extension, LOV example, empty Shared Region examples, typos.

### Phase 4: Code-brain alignment

- [ ] Map each syllabus section to the code-brain files that demonstrate it.
- [ ] Add the three planned case studies beyond Jobs & Positions.
- [ ] Refactor the remaining 34 hardcoded errors listed in `code-brain.json`.
- [ ] Decide on a customer namespace for the Foundation package instead of `oracle.apps.fnd.*`.

### Phase 5: Delivery

- [ ] Replace the `#` placeholders for Udemy and Calendly.
- [ ] Publish the cohort schedule and certification criteria.

## 4. Open Questions

- Durations, scaffolding and assessment for Cust 101 and Cust 102.
- Final level for each topic that appears in both Dev 102 and the reference Dev 103.
- Reference-curriculum claims to confirm against Oracle 12.2 documentation before publishing: Redwood, the JET transition, the 12.2.11+ export features, and Infotiles.
