# Oracle Application Framework (OAF) BootCamp

A hands-on Oracle Application Framework (OAF) BootCamp for Oracle E-Business Suite developers and implementers. Five courses take you from your first OAF page to production deployment and upgrade-safe customization, covering the model, view and controller layers, integration, security, personalization and extension.

## About this BootCamp

A structured, hands-on path through Oracle Application Framework (OAF) for Oracle E-Business Suite, from first page to production deployment and upgrade-safe customization. The BootCamp has **five courses**, **63 modules** and **293 lectures**, and every OAF capability it teaches is indexed in [CAPABILITIES.md](bootcamp/CAPABILITIES.md) (164 capabilities across 13 areas).

**How it is organized**

- **Level**: a course, for example Building 101.
- **Section**: a module of a course, numbered in order (`B101-001`).
- **Lecture**: a lesson inside a section (`B101-001.001`), delivered as a Video, Lab or Workshop.

Each lecture and module carries a **Difficulty** rating from 1 to 5 stars (Beginner, Elementary, Intermediate, Advanced, Expert).

**Two tracks**

| Track | Course | Modules | Lectures | What you learn |
| :-- | :-- | :-: | :-: | :-- |
| Building | [101](bootcamp/building/101/README.md) | 15 | 92 | Architecture, MVC, JDeveloper setup, application modules, view and entity objects, pages, controllers, master-detail, debugging, security, deployment and a capstone |
| Building | [102](bootcamp/building/102/README.md) | 20 | 85 | Event handling, PPR, LOVs, exception framework, dialogs, advanced tables, flexfields, scripting, internationalization and advanced debugging |
| Building | [103](bootcamp/building/103/README.md) | 17 | 78 | MDS and BC4J deployment, AOL security, instrumentation, R12.2 online patching, REST integration and a point-of-sale capstone |
| Customizing | [101](bootcamp/customizing/101/README.md) | 5 | 19 | Personalization hierarchy, declarative customization of pages, regions and LOVs, migration and diagnostics |
| Customizing | [102](bootcamp/customizing/102/README.md) | 6 | 19 | Controller, LOV and business component extensions, substitution, packaging and R12.2 synchronization |

**Capability areas covered**: Architecture, Model Layer, View Layer, Controller Layer, Framework, Localization, Integration, Security, Errors and diagnostics, Personalization, Extension, Deployment and OA Framework Standards, plus a UI Component Layout Index that maps each component to the capability that uses it.

Start with Building 101 unless you already build OAF pages. Customizing 101 needs Building 101 and EBS system administration, and Customizing 102 builds on Building 102 and 103.

## OA Framework BootCamp Levels

<p align="center"><img src="bootcamp/assets/levels.svg" width="720" alt="Beginner > Advanced > Ninja"></p>

| Code       | Lecture Title                         | Level     | Subscribe  |   Notes |
| :-:         | :--------                             | :-:       | :-:        |     :----   |
| OAF-B-101        | <a href="https://github.com/demasylabs/Oracle-OAF-BootCamp/tree/master/building-101">Oracle OAF Building BootCamp 101</a>      | Beginner  |  N/A       | -|
| OAF-B-102        | <a href="SYLLABUS_102.md">Oracle OAF Building BootCamp 102</a>      | Advanced  |  N/A       | -|
| OAF-B-103       | <a href="SYLLABUS_103.md">Oracle OAF Building BootCamp 103</a>      | Ninja     |  N/A       | -|
| OAF-C-101        | <a href="SYLLABUS_CUST_101.md">Oracle OAF Customizing BootCamp 101</a>   | Beginner  |  N/A       | -|
| OAF-C-102        | <a href="SYLLABUS_CUST_102.md">Oracle OAF Customizing BootCamp 102</a>   | Advanced  |  N/A       | -|

<br>

## Target Audience

- Oracle Technical Consultant (Apps Developer)
- Oracle Apps Developer Course attended
- Oracle Developer
- Java Developer
- Oracle Techno Functional

<br>

## Prerequisites & Requirements 

- Java Programming
- Oracle database SQL & PL/SQL
- 3 months of Oracle developing experience on e-Business Suite applications
- Oracle E-Business Suite Virtual Machine
- Toad for Oracle or SQL Developer

<br>

## **About the Instructor**
My name is <a href="https://github.com/demasy">Ahmed El-Demasy</a> , I have more than 13 years of experience in Oracle technology and Oracle applications; 11 years in ERP development using JAVA and ORACLE tools specialist in OA framework development (OAF).

Currently holding a position of Principal Technical Consultant, responsible for implementation, enhancement, and support for Oracle e-Business Suite applications (ERP); coaching development team, leading projects and vendor resources coordination.

Practical experience in coaching and teaching Oracle courses such as Oracle SQL, Oracle PL/SQL, Java SE, Oracle OA framework (OAF), Oracle workflow, and etc.

For more information about my experiences and professional career. please visit my LinkedIn profile <a href="https://www.linkedin.com/in/demasy/">here</a>

<br>


## How can get this BootCamp!

###### Online BootCamps for individuals buy these BootCamps via udemy.com
> <a href="#">udemy.com</a>

###### Live BootCamps for enterprise ONLY
> <a href="#">Schedule call with us via Calendly</a>

<br>


## Suggestions & Issues
If you find any issue or have a great idea in mind please create an issue on <a href="https://github.com/demasylabs/Oracle-OAF-BootCamp/issues">GitHub</a>.

<br>

## Contributing

We welcome contributions from the community! Whether you're fixing a bug, adding a new code example, improving documentation, or creating new lab exercises, your contributions help make this bootcamp better for everyone.

### How to Contribute

1. **Fork the Repository**: Create your own fork of the repository
2. **Create a Branch**: Create a feature branch for your changes
3. **Make Changes**: Follow our [Code Quality Guidelines](.github/instructions/codacy.instructions.md)
4. **Submit a PR**: Submit a pull request with a clear description of your changes

For detailed guidelines, please read our [Contributing Guide](.github/CONTRIBUTING.md).

### Areas Where You Can Contribute

- **Code Examples**: Add new OAF patterns and use cases to the [code-brain](code-brain/) directory
- **Documentation**: Improve existing documentation or fix errors
- **Lab Exercises**: Create new hands-on labs and exercises
- **Course Content**: Enhance syllabus content and learning materials
- **Bug Fixes**: Fix issues in existing code or documentation

### Code of Conduct

This project follows a Code of Conduct to ensure a welcoming and inclusive environment. By participating, you agree to be respectful, inclusive, and constructive in all interactions.

<br>

## Repository Structure

```
Oracle-OAF-BootCamp/
├── code-brain/              # Comprehensive OAF code examples and patterns
│   ├── code-brain.json      # Metadata for all code examples
│   ├── README.md            # Documentation for code-brain
│   ├── view-object-operations/
│   ├── error-handling/
│   ├── controller-patterns/
│   └── ...                  # Other code categories
├── SYLLABUS.md              # Main syllabus overview
├── SYLLABUS_101.md          # Level 101 (Beginner) detailed syllabus
├── SYLLABUS_102.md          # Level 102 (Advanced) detailed syllabus
├── SYLLABUS_103.md          # Level 103 (Ninja) detailed syllabus
├── LABS.md                  # All lab exercises and activities
├── INSTRUCTOR_SYLLABUS.md   # Instructor-specific content
├── PROJECT_LEVEL_101.md     # Capstone project details
├── .github/                 # GitHub configuration
│   ├── CONTRIBUTING.md      # Contribution guidelines
│   ├── PULL_REQUEST_TEMPLATE.md
│   ├── ISSUE_TEMPLATE/      # Issue templates
│   ├── instructions/        # Quality and coding guidelines
│   └── workflows/           # CI/CD workflows
└── README.md                # This file
```

<br> 
<br>

<p align="center">
Made with love ❤️ in Egypt by <a href="https://github.com/demasylabs"> Demasy Labs </a>
</p>
