# Oracle Application Framework (OAF) BootCamp
## Labs & Activities Guide

**Institution:** Demasy Labs  
**Document Version:** 1.0  
**Last Updated:** January 24, 2026

---

## About This Document

This document contains all hands-on **labs, activities, and exercises** for the Oracle OAF BootCamp. Each activity is designed to reinforce lecture concepts through practical, scaffolded learning experiences.

### Document Organization

Labs are organized by course sections following the "I Do, We Do, You Do" progression:
- **"I Do"** - Instructor demonstrations and walkthroughs
- **"We Do"** - Guided practice with instructor support
- **"You Do"** - Independent practice with optional scaffolding

### Scaffold Levels

- **Maximum (60% guided):** Level 101 early sections - Step-by-step instructions, templates, frequent checkpoints
- **Moderate (40% guided):** Level 101 later sections - High-level guidance, architecture diagrams, milestone reviews
- **Minimal (20% guided):** Level 102-103 - Requirements only, optional hints, self-directed implementation

---

## Level 101: Oracle OAF Building BootCamp (Beginner)

---

### Section 2: OAF Foundations - Architecture & Design Patterns

#### Activities

- 📊 Create comparison chart: Forms vs. OAF
- 🎨 Diagram MVC pattern for sample scenario
- 🔍 Explore existing OAF pages in E-Business Suite
- 💬 Discussion: When to use OAF?

---

### Section 3: Development Environment Setup & Your First Page

#### Activities (Scaffold Level: Maximum)

**"I Do" - Instructor Demonstration:**
- 📺 Watch: Complete environment setup walkthrough
- 📺 Watch: "Hello World" page creation live demo
- 📄 Review: Annotated screenshots with explanations

**"We Do" - Guided Practice:**
- 🔧 **Lab 1:** Install and configure development environment (step-by-step guide provided)
  - ✅ Checkpoint 1: JDeveloper installed
  - ✅ Checkpoint 2: OA Extension configured
  - ✅ Checkpoint 3: Connection successful
- 🔧 **Lab 2:** Create "Hello World" page (instructor-guided with pauses)
  - ✅ Checkpoint 1: Workspace created
  - ✅ Checkpoint 2: Page created
  - ✅ Checkpoint 3: Page runs successfully

**"You Do" - Independent Practice:**
- 🔧 **Lab 3:** Create workspace and project structure (instructions with optional hints)
  - Hint 1 available if stuck on naming
  - Hint 2 available if stuck on structure
  - Solution available after 30 minutes or completion
- 📸 Screenshot: Your first OAF page running
- 🐛 Troubleshooting: Common setup errors (reference guide provided)

**Scaffolding Tools Provided:**
- ✔️ Complete installation checklist
- ✔️ Configuration template
- ✔️ Troubleshooting decision tree
- ✔️ Visual reference guide
- ✔️ Video tutorials (rewatchable)

---

### Section 4: The Model Layer - Business Logic with BC4J

#### Activities (Scaffold Level: High → Moderate)

**"I Do" - Instructor Demonstration:**
- 📺 Live Demo: Creating complete BC4J model
- 📺 Watch: Testing with BC4J tester walkthrough
- 📄 Study: Annotated code with explanation comments

**"We Do" - Guided Practice:**
- 🔧 **Lab 4:** Create Application Module (step-by-step with instructor)
  - ✅ Checkpoint: AM created and configured
- 🔧 **Lab 5:** Create Entity Object for EMPLOYEES table (guided)
  - ✅ Checkpoint: EO attributes mapped
  - ✅ Checkpoint: Validation rules added
- 🔧 **Lab 6:** Create updatable View Object (with template)
  - ✅ Checkpoint: VO based on EO
  - ✅ Checkpoint: Query tested

**"You Do" - Independent Practice:**
- 🔧 **Lab 7:** Create read-only View Object with custom query (high-level instructions)
  - 💡 Hint available: SQL syntax reference
  - 💡 Hint available: Attribute definition
- 🔧 **Lab 8:** Test all components using BC4J tester (checklist provided)
  - Self-validate against testing checklist
- 📊 **Exercise:** Design BC4J model for a simple scenario (requirements only)
  - Scaffold option: Architecture diagram template
  - Challenge option: No template
- 🐛 **Debugging:** Fix 3 broken EO/VO examples (decreasing hints)
  - Problem 1: Hints available
  - Problem 2: Minimal hints
  - Problem 3: No hints

**Scaffolding Tools Provided:**
- ✔️ BC4J creation wizard guide
- ✔️ EO/VO template examples
- ✔️ Testing checklist
- ✔️ Common errors reference
- ⚠️ Code solutions available after attempt

---

### Section 5: The View Layer - Building Modern User Interfaces

#### Activities (Scaffold Level: Moderate)

- 🔧 **Lab 9:** Create form with all standard widgets
- 🔧 **Lab 10:** Implement LOV with search functionality
- 🔧 **Lab 11:** Build query region with results
- 🔧 **Lab 12:** Implement PPR for dynamic field updates
- 🔧 **Lab 13:** Create multi-region page with proper layout
- 🎨 **Design Exercise:** UI mockup to OAF implementation
- 🐛 **Debugging:** UI rendering issues

---

### Section 6: The Controller Layer - Handling User Events

#### Activities (Scaffold Level: Moderate → Minimal)

**"I Do" - Instructor Demonstration:**
- 📺 Live Coding: Complete controller implementation
- 📺 Watch: Debugging controller execution flow
- 📄 Study: Controller pattern library with examples

**"We Do" - Guided Practice:**
- 🔧 **Lab 14:** Create controller with button click handler (paired work)
  - Work with partner, instructor circulates
  - ✅ Checkpoint: processFormRequest implemented
  - ✅ Checkpoint: Navigation working
- 🔧 **Lab 15:** Implement page navigation with parameters (semi-guided)
  - Framework provided, implementation independent
  - ✅ Checkpoint: Parameters passed correctly

**"You Do" - Independent Practice:**
- 🔧 **Lab 16:** Build multi-page flow with data passing (minimal guidance)
  - Requirements and architecture diagram only
  - 💡 Optional: Parameter types reference
  - Self-test against acceptance criteria
- 🔧 **Lab 17:** Implement form validation in controller (independent)
  - Validation requirements listed
  - Choose your approach
  - Peer review before submission
- 💻 **Coding Exercise:** Implement 5 common controller patterns
  - Pattern 1: Fully guided example
  - Pattern 2-3: Partial guidance
  - Pattern 4-5: Independent implementation
- 🐛 **Debugging Challenge:** Fix controller bugs (minimal scaffolding)
  - Bug descriptions only
  - Use debugging framework learned
  - Document your debugging process

**Scaffolding Tools Provided:**
- ✔️ Controller method reference card
- ✔️ Parameter passing decision tree
- ✔️ Common patterns library
- ⚠️ Hints available on request (try first!)
- ⚠️ Solutions after completion only

---

### Section 6B: Master-Detail Relationships

#### Activities

- 🔧 **Lab 18:** Create master-detail page (Orders → Line Items)
- 🔧 **Lab 19:** Implement View Link coordination
- 📊 **Exercise:** Design master-detail for different scenarios
- 🐛 **Debugging:** Fix master-detail synchronization issues

---

### Section 7: Error Handling & Debugging Excellence

#### Activities

- 🔧 **Lab 20:** Implement exception handling
- 🔧 **Lab 21:** Debug existing page with errors
- 🐛 **Exercise:** Fix 5 buggy code samples
- 📋 **Checklist:** Common errors and solutions

---

### Section 8: Security Implementation - Protecting Your Application

#### Activities

- 🔧 **Lab 22:** Register function and add to menu
- 🔧 **Lab 23:** Test security with different users
- 📋 **Exercise:** Security checklist for your pages

---

### Section 9: Development Standards and Best Practices

#### Activities

- 📋 **Checklist:** Review your code against standards
- 🔧 **Lab 24:** Export and import page
- 📝 **Exercise:** Refactor code to meet standards
- 💬 **Discussion:** Personalizations vs. Extensions

---

### Section 10: Deploying OA Framework Applications

#### Activities

- 🔧 **Lab 25:** Deploy Hello World page to R12
- 🔧 **Lab 26:** Register and test deployed page
- 📋 **Checklist:** Deployment verification steps
- 🐛 **Troubleshooting:** Common deployment issues

---

## Level 102: Advanced OAF Development

---

### Section 11: Advanced Model Implementation

#### Activities (Scaffold Level: Minimal)

**"I Do" - Brief Demonstration:**
- 📺 Concept Demo: Dynamic VO creation (15 min overview)
- 📄 Reference: Code examples available

**"You Do" - Semi-Independent Work:**
- 🔧 **Lab 27:** Create VO dynamically based on user input (requirements + architecture only)
  - 💡 Reference: ViewObjectImpl API documentation
  - Milestone checkpoint at 50%
- 🔧 **Lab 28:** Add calculated attributes at runtime (minimal guidance)
  - Use case scenarios provided
  - Implement your approach
  - Peer review recommended
- 💻 **Coding Exercise:** Build flexible search functionality (independent)
  - Business requirements only
  - Design your own solution
  - Optional: Consult with instructor on architecture

**Scaffolding Available (On Request):**
- ⚠️ Code snippets (if stuck > 30 min)
- ⚠️ Architecture consultation
- ⚠️ Debugging support

---

### Section 12: Server-Side Features

#### Activities

- 🔧 **Lab 29:** Execute dynamic SQL query
- 🔧 **Lab 30:** Call PL/SQL procedure with parameters
- 🔧 **Lab 31:** Call function and process return value
- 💻 **Exercise:** Implement complex business logic

---

### Section 13: Advanced View Components

#### Activities (Scaffold Level: Moderate)

- 🔧 **Lab 32:** Implement hide/show with PPR
- 🔧 **Lab 33:** Build advanced query region
- 🔧 **Lab 34:** Create advanced table with all features
- 🔧 **Lab 35:** Implement 3-step train page
- 🔧 **Lab 36:** Build shuttle for assignment functionality
- 🔧 **Lab 37:** Create HGrid for organizational hierarchy
- 🔧 **Lab 38:** Integrate Key Flexfield
- 🔧 **Lab 39:** Integrate Descriptive Flexfield
- 🔧 **Lab 40:** Implement chart visualization
- 🎨 **Design Challenge:** Complex multi-region page

---

### Section 14: Advanced Controller and Programmatic UI

#### Activities

- 🔧 **Lab 41:** Create complete form programmatically
- 🔧 **Lab 42:** Build dynamic table at runtime
- 🔧 **Lab 43:** Implement JavaScript validation
- 🔧 **Lab 44:** Create read-only mode toggle
- 💻 **Challenge:** Build page generator utility

---

### Section 15: Data Manipulation and Validation

#### Activities

- 🔧 **Lab 45:** Implement date comparisons
- 🔧 **Lab 46:** Format currency fields
- 🔧 **Lab 47:** Create Entity Expert for validation
- 💻 **Exercise:** Comprehensive validation scenarios

---

### Section 16: Advanced Features and Integrations

#### Activities

- 🔧 **Lab 48:** Implement attachments
- 🔧 **Lab 49:** Build file upload feature
- 🔧 **Lab 50:** Create CSV import functionality
- 🔧 **Lab 51:** Implement Excel export
- 🔧 **Lab 52:** Launch workflow from OAF
- 🔧 **Lab 53:** Embed OAF in workflow notification
- 💻 **Integration Project:** Complete attachment system

---

### Section 17: Advanced Debugging and Error Handling

#### Activities

- 🔧 **Lab 54:** Install and use demasy-oaf library
- 🔧 **Lab 55:** Implement multiple error messages
- 🐛 **Challenge:** Debug complex production issue
- 📋 **Create:** Personal debugging checklist

---

## Level 103: Expert OAF Development (Ninja)

---

### Section 18: Performance Optimization and Tuning

#### Activities (Scaffold Level: Minimal)

- 🔧 **Lab 56:** Profile application performance
- 🔧 **Lab 57:** Optimize slow-running queries
- 🔧 **Lab 58:** Implement caching strategies
- 💻 **Challenge:** Optimize complex application

---

### Section 19: Advanced Security Patterns

#### Activities

- 🔧 **Lab 59:** Implement custom security handlers
- 🔧 **Lab 60:** Build data security policies
- 📋 **Exercise:** Security audit of existing application

---

### Section 20: OAF Extensions and Personalizations

#### Activities

- 🔧 **Lab 61:** Extend standard OAF page
- 🔧 **Lab 62:** Create personalization layer
- 💻 **Project:** Extension framework design

---

## Level 101 Capstone Project: Jobs & Positions Management System

### Project Labs (20-Day Schedule)

#### Week 1: Database Foundation & Entity Layer (Days 1-5)

**Day 1-2: Database Setup & Understanding**
- 🔧 **Lab CP-01:** Execute DDL/DML scripts
- 📊 **Exercise:** Write SQL queries to explore data
- ✅ Checkpoint: Tables created, data loaded

**Day 3-5: Entity Objects with Association**
- 🔧 **Lab CP-02:** Create JobEO with sequence and validations
- 🔧 **Lab CP-03:** Create PositionEO with validations
- 🔧 **Lab CP-04:** Create Entity Association
- 🔧 **Lab CP-05:** Test in BC4J tester
- ✅ Checkpoint: All EOs working with validations

#### Week 2: View Objects & Application Module & First UI (Days 6-10)

**Day 6-7: View Objects & View Link**
- 🔧 **Lab CP-06:** Create JobVO (updatable)
- 🔧 **Lab CP-07:** Create PositionVO (updatable)
- 🔧 **Lab CP-08:** Create JobPositionVL
- ✅ Checkpoint: View Link coordinates master-detail

**Day 8: Application Module**
- 🔧 **Lab CP-09:** Create JobMgmtAM
- 🔧 **Lab CP-10:** Add VOs to data model
- ✅ Checkpoint: Complete BC4J model tested

**Day 9-10: First UI Page (JobSearchPG)**
- 🔧 **Lab CP-11:** Create page with search region
- 🔧 **Lab CP-12:** Add results table
- ✅ Checkpoint: Page displays data

#### Week 3: Controllers & CRUD Operations (Days 11-15)

**Day 11-12: Search & Create Operations**
- 🔧 **Lab CP-13:** Implement search functionality
- 🔧 **Lab CP-14:** Create JobDetailsPG (form)
- 🔧 **Lab CP-15:** Implement create operation
- ✅ Checkpoint: Search and Create work

**Day 14-15: Update & Delete**
- 🔧 **Lab CP-16:** Implement update functionality
- 🔧 **Lab CP-17:** Implement delete with confirmation dialog
- ✅ Checkpoint: All CRUD operations complete

#### Week 4: Master-Detail, Testing & Deployment (Days 16-20)

**Day 16-18: PositionMaintPG (Master-Detail)**
- 🔧 **Lab CP-18:** Design master-detail page
- 🔧 **Lab CP-19:** Implement master-detail UI
- 🔧 **Lab CP-20:** Wire controller logic
- ✅ Checkpoint: Master-detail works

**Day 19: Testing & Bug Fixing**
- 🐛 **Lab CP-21:** Execute comprehensive test suite
- 🐛 **Lab CP-22:** Fix all identified bugs
- ✅ Checkpoint: All tests pass

**Day 20: Deployment**
- 🔧 **Lab CP-23:** Export project
- 🔧 **Lab CP-24:** Deploy to EBS
- 🔧 **Lab CP-25:** Register and test in EBS
- ✅ Final Checkpoint: Application running in production

---

## Lab Resources and Support

### Getting Help

**Tier 1: Self-Service**
- Check lab instructions and hints
- Review lecture notes and code examples
- Search course documentation
- Consult reference materials

**Tier 2: Peer Support**
- Ask classmates in discussion forum
- Form study groups
- Peer code review sessions

**Tier 3: Instructor Support**
- Office hours (scheduled times)
- Discussion forum posts
- Email for specific questions
- One-on-one consultations

### Lab Submission Guidelines

**What to Submit:**
1. Source code (.jpr or .jpx export)
2. Screenshots of working functionality
3. Test results documentation
4. Brief reflection (what learned, challenges faced)

**Grading Criteria:**
- Functionality: Does it work as specified?
- Code Quality: Follows standards and best practices?
- Architecture: Proper MVC separation?
- Documentation: Code comments and README?

### Common Lab Issues

| Issue | Solution |
|-------|----------|
| Can't create workspace | Check JDeveloper installation, verify OA Extension |
| Database connection fails | Verify DBC file configuration, check network |
| Page doesn't run | Check AM attached to page, verify package names |
| Build errors | Check all imports, verify library dependencies |
| Runtime errors | Check logs, add debug statements, use BC4J tester |

---

## Additional Practice Resources

### Optional Challenge Labs

For students seeking additional practice:
- **Challenge Lab 1:** Build a complete Departments module (Level 101)
- **Challenge Lab 2:** Add approval workflow to Jobs module (Level 102)
- **Challenge Lab 3:** Implement dashboard with charts (Level 102)
- **Challenge Lab 4:** Build audit trail functionality (Level 103)

### Real-World Scenarios

Practice labs based on real business scenarios:
- **Scenario 1:** Expense Report Entry System
- **Scenario 2:** Inventory Management Portal
- **Scenario 3:** Supplier Onboarding Workflow
- **Scenario 4:** Sales Order Processing

---

## Lab Completion Tracking

### Level 101 Progress Checklist

**Section 3 Labs:**
- [ ] Lab 1: Environment setup
- [ ] Lab 2: Hello World page
- [ ] Lab 3: Workspace structure

**Section 4 Labs:**
- [ ] Lab 4: Application Module
- [ ] Lab 5: Entity Object
- [ ] Lab 6: Updatable View Object
- [ ] Lab 7: Read-only View Object
- [ ] Lab 8: BC4J testing

**Section 5 Labs:**
- [ ] Lab 9: Form with widgets
- [ ] Lab 10: LOV implementation
- [ ] Lab 11: Query region
- [ ] Lab 12: PPR implementation
- [ ] Lab 13: Multi-region page

**Section 6 Labs:**
- [ ] Lab 14: Controller with button handler
- [ ] Lab 15: Page navigation
- [ ] Lab 16: Multi-page flow
- [ ] Lab 17: Form validation
- [ ] Lab 18: Master-detail page
- [ ] Lab 19: View Link coordination

**Section 7-10 Labs:**
- [ ] Lab 20: Exception handling
- [ ] Lab 21: Debugging
- [ ] Lab 22: Security registration
- [ ] Lab 23: Security testing
- [ ] Lab 24: Export/import
- [ ] Lab 25-26: Deployment

**Capstone Project:**
- [ ] Labs CP-01 through CP-25 (all 25 labs)

---

**Total Labs: 80+ hands-on activities across all levels**

---

*This document is continuously updated based on student feedback and industry best practices.*

**Document Maintenance:**  
Last Updated: January 24, 2026  
Version: 1.0  
Author: Demasy Labs Instructional Team
