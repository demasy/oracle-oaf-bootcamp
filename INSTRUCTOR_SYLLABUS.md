# Oracle Application Framework (OAF) BootCamp
## Instructor Syllabus - Detailed Lecture Content

---

## About This Document

This instructor syllabus provides **detailed lecture content breakdowns** for each lecture in the OAF BootCamp. It is designed to help instructors:

- **Prepare lecture materials** with comprehensive topic coverage
- **Plan teaching activities** aligned with learning outcomes
- **Ensure consistency** across different teaching sections
- **Identify key concepts** that must be covered
- **Design assessments** based on lecture content

### Document Structure

For each lecture, you'll find:
- **Lecture Code & Title** - Quick reference identifier
- **Bullet-point topic list** - Specific concepts to cover
- **Content depth indicators** - How deep to go with each topic
- **Practical examples** - Real-world scenarios to illustrate concepts

### How to Use This Document

1. **Before Teaching:** Review detailed content for upcoming lectures
2. **During Preparation:** Develop slides, demos, and exercises based on topics
3. **During Teaching:** Use as a checklist to ensure complete coverage
4. **After Teaching:** Reflect on what was covered and adjust for next session

---

## Course Overview

**Course Title:** Oracle Application Framework (OAF) BootCamp  
**Institution:** Demasy Labs  
**Duration:** 12-16 Weeks (Self-paced)  
**Delivery Mode:** Hands-on, Project-Based Learning  
**Course Level:** Progressive (Beginner → Advanced → Expert)

### Pedagogical Approach

**Scaffold-Oriented Learning:**
- "I Do, We Do, You Do" progression in every section
- Gradual release of responsibility
- Progressive complexity with decreasing support
- Level 101 (60% guided), Level 102 (40% guided), Level 103 (20% guided)

---

## Level 101: Oracle OAF Building BootCamp (Beginner)

---

## Section 2: OAF Foundations - Architecture & Design Patterns

**Duration:** 1 Week | **Bloom's Level:** Remember, Understand

### Detailed Lecture Content

#### **2.1 OAF Terminology: Speaking the Language**
- Essential vocabulary for OAF developers
- Component naming conventions and standards
- Oracle E-Business Suite integration context
- Reading and understanding Oracle documentation

**Teaching Notes:**
- Start with a vocabulary assessment to gauge prior knowledge
- Use analogies from familiar technologies (e.g., compare to MVC in web frameworks)
- Create a glossary handout students can reference throughout the course
- Emphasize that learning the language accelerates understanding

**Key Terms to Cover:**
- Application Module (AM), View Object (VO), Entity Object (EO)
- Controller (CO), OA Framework (OAF), BC4J
- UIX, Metadata, JDeveloper, OA Extension
- DBC file, Personalization, Extension
- MDS (Metadata Services), Region, Page

---

#### **2.2 Evolution: From Oracle Forms to OA Framework**
- Technology shift: Client-server to web-based architecture
- Development paradigm comparison
- Migration strategies and considerations
- Real-world use case analysis
- When each technology is the right choice

**Teaching Notes:**
- If students have Forms background, highlight parallels and differences
- Use side-by-side comparison to show architectural differences
- Discuss why Oracle invested in OAF (web-based future)
- Address common concerns about Forms vs. OAF

**Key Comparisons:**
- Client-server (Forms) vs. web-based (OAF)
- PL/SQL-based logic vs. Java-based logic
- Forms triggers vs. OAF Controllers
- Blocks/Items vs. View Objects/Attributes
- Deployment models and maintenance implications

---

#### **2.3 Strategic Value: When and Why to Use OAF**
- Competitive advantages: Web-based, MVC, reusability, scalability
- Understanding the limitations: Complexity and learning curve
- Decision matrix: OAF vs. Forms vs. other technologies
- Business case for OAF adoption
- Oracle's strategic roadmap

**Teaching Notes:**
- Present real decision scenarios where technology choice mattered
- Discuss total cost of ownership considerations
- Address the "steep learning curve" concern head-on
- Help students articulate OAF value to stakeholders

**Decision Factors:**
- Nature of application (simple vs. complex)
- User base (internal vs. external/web)
- Integration requirements
- Development team skills
- Long-term maintenance considerations
- Oracle's strategic direction

---

#### **2.4 OAF Ecosystem: Integration with E-Business Suite**
- Historical evolution and market positioning
- Oracle's technology direction and investment
- Deep integration with EBS infrastructure
- Framework capabilities and boundaries

**Teaching Notes:**
- Position OAF within Oracle's broader product strategy
- Explain why OAF is tightly coupled with EBS
- Discuss Oracle's investment in OAF vs. other technologies
- Set realistic expectations about framework capabilities

**Integration Points:**
- AOL (Application Object Library) foundation services
- Concurrent processing integration
- Workflow integration
- Security and responsibility model
- Menu and function security
- Profile options and flexfields

---

#### **2.5 MVC Pattern Mastery: The Foundation of OAF**
- Model layer: Business logic and data management
- View layer: User interface presentation and experience
- Controller layer: User interaction and event handling
- Separation of concerns: Benefits and best practices
- Real-world analogies for understanding MVC

**Teaching Notes:**
- Use concrete analogies (restaurant: kitchen=Model, dining room=View, waiter=Controller)
- Draw diagrams showing data flow between layers
- Explain why separation of concerns matters for maintenance
- Show what happens when MVC is violated (bad examples)

**Teaching Approach:**
1. Start with a simple scenario (e.g., employee management)
2. Show how each layer handles different responsibilities
3. Trace a user action through all three layers
4. Discuss benefits of this separation

---

#### **2.6 OAF Architecture Deep Dive: BC4J and UIX**
- BC4J Framework: The data management engine
- UIX Framework: Metadata-driven user interfaces
- Request/Response lifecycle visualization
- Component interaction and communication patterns
- Metadata repository and dynamic behavior

**Teaching Notes:**
- Use diagrams heavily - architecture is visual
- Walk through a complete request/response cycle step-by-step
- Explain metadata concept with examples (XML descriptors)
- Show how metadata enables personalization without code changes

**Key Architectural Components:**
- BC4J (Business Components for Java) - Model layer framework
- UIX (User Interface XML) - View layer framework
- Metadata repository (MDS) - Component definitions
- OA Framework runtime - Request processing engine
- Application Object Library (AOL) - EBS foundation

**Request Lifecycle:**
1. User action triggers HTTP request
2. OA Framework servlet receives request
3. Page metadata loaded from MDS
4. Application Module instantiated (or reused from pool)
5. View Objects execute queries
6. Page components rendered with data
7. HTML response sent to browser

---

#### **2.7 Page Anatomy: Understanding OAF Components**
- Application Module (AM): Your business logic container
- View Objects (VO): Query-based data access
- Entity Objects (EO): Database table representation
- Pages and Regions: UI structure and hierarchy
- Controllers (CO): Event handling and navigation
- How components collaborate in a running application

**Teaching Notes:**
- Use a working OAF page as example to deconstruct
- Show the XML files that define each component
- Explain component relationships with a dependency diagram
- Demonstrate how to navigate JDeveloper to find each component type

**Component Breakdown:**

**Application Module (AM):**
- Manages transaction state and data
- Contains View Object instances
- Provides connection pooling
- Root of the data model hierarchy

**View Objects (VO):**
- Encapsulate SQL queries
- Represent data for UI consumption
- Can be read-only or updatable
- Bind to UI components

**Entity Objects (EO):**
- Map to database tables
- Enforce business validation rules
- Handle DML operations (INSERT/UPDATE/DELETE)
- Define entity associations (relationships)

**Pages and Regions:**
- Page: Top-level container (URL endpoint)
- Region: Reusable UI component
- Hierarchy: Pages contain regions, regions contain items
- Layout regions: Organize visual structure

**Controllers (CO):**
- Handle user events (button clicks, field changes)
- Implement navigation logic
- Programmatic data manipulation
- Custom business logic

---

## Section 3: Development Environment Setup & Your First Page

**Duration:** 1 Week | **Bloom's Level:** Apply

### Detailed Lecture Content

#### **3.1 JDeveloper IDE: Your Development Command Center**
- Oracle's integrated development environment for OAF
- Workspace and project organization strategies
- Understanding the IDE layout and key components
- Essential panels: Navigator, Editor, Properties, Structure
- Productivity features that accelerate development

**Teaching Notes:**
- Give students a guided tour before they try it themselves
- Show how to customize the IDE for OAF development
- Demonstrate keyboard shortcuts that save time
- Create a "JDeveloper cheat sheet" for quick reference

**IDE Components to Cover:**
- Application Navigator: Workspace/project hierarchy
- Structure Window: XML/code structure visualization
- Property Inspector: Component configuration
- Editor Area: Code and visual editors
- Log Window: Debugging and error messages
- Toolbar Customization: Adding frequently used actions

---

#### **3.2 Acquiring OA Extension from Oracle Support**
- Navigating My Oracle Support (MOS) portal
- Identifying correct version for your EBS release
- Download process and file verification
- Version compatibility matrix and dependencies
- License and access considerations

**Teaching Notes:**
- Walk through MOS navigation if students have access
- Emphasize version compatibility importance
- Provide pre-downloaded patches if MOS access is limited
- Explain patch numbering system

**Key Points:**
- MOS requires valid Oracle support contract
- OA Extension version must match EBS version
- Check certification matrix before downloading
- Verify patch checksums after download
- Keep documentation of versions used

---

#### **3.3 Environment Configuration: Step-by-Step Setup**
- Pre-installation requirements and system check
- JDeveloper installation process (all platforms)
- Applying OA Extension patch correctly
- Essential configuration and preferences
- Environment variables and system settings
- DBC file setup and configuration

**Teaching Notes:**
- Provide detailed installation document with screenshots
- Common errors: Dedicate time to troubleshooting
- Have backup environments ready if student setups fail
- Configuration checklist for verification

**Installation Steps:**
1. Verify Java JDK version compatibility
2. Install JDeveloper base software
3. Apply OA Extension patch
4. Configure jdev.conf (memory settings)
5. Set required environment variables
6. Configure project defaults
7. Test basic functionality

---

#### **3.4 JDeveloper Productivity: Tools & Shortcuts**
- Complete interface tour and customization
- Essential keyboard shortcuts for efficiency
- Toolbars, menus, and quick access features
- Code templates and snippets
- Workspace layout optimization
- Time-saving tips from experienced developers

**Teaching Notes:**
- Create a "productivity tips" handout
- Demonstrate shortcuts during live coding
- Encourage students to customize their workspace
- Share expert productivity tricks

**Essential Shortcuts:**
- Ctrl+Shift+N: Quick navigation to class
- Ctrl+Space: Code completion
- Ctrl+/: Comment/uncomment lines
- Ctrl+Shift+F: Format code
- Alt+Shift+F10: Run configuration
- F9: Compile project

---

#### **3.5 Essential Configuration: DBC Files & Connections**
- Understanding DBC files and their role
- Initial configuration checklist
- Database connection setup and validation
- Connection parameters explained
- Troubleshooting connection issues
- Managing multiple environment connections

**Teaching Notes:**
- Explain what DBC files contain (connection info)
- Show how to extract DBC from EBS instance
- Common connection errors and solutions
- Security considerations for DBC files

**DBC File Contents:**
- Database connection parameters (host, port, SID)
- Apps username and password (encrypted)
- JDBC connection string
- Guest user credentials
- Jserv settings

**Connection Troubleshooting:**
- "Unable to connect" - Network/firewall issues
- "Invalid credentials" - Password changes
- "TNS error" - Database connectivity
- "ClassNotFound" - JDBC driver missing

---

#### **3.6 Milestone Achievement: Building "Hello World!"**
- Your first OAF page: Complete walkthrough
- Creating workspace and project structure
- Building Application Module (AM)
- Designing simple page layout
- Adding UI components
- Running in embedded OC4J server
- Celebrating your first success

**Teaching Notes:**
- This is the "aha moment" - make it memorable
- Go slowly and verify each step
- Celebrate when page runs successfully
- Troubleshoot common first-time errors
- Use this as template for future pages

**Step-by-Step Process:**
1. Create workspace and project
2. Create Application Module (BC4J wizard)
3. Create Page (OA Components wizard)
4. Add static text region
5. Set message "Hello World!"
6. Configure run/debug settings
7. Run page in embedded server
8. View result in browser

**Common First-Time Errors:**
- Missing AM instance on page
- Incorrect package naming
- DBC file not configured
- Server ports in use
- Classpath issues

---

#### **3.7 Project Structure Best Practices**
- Professional workspace organization
- Package naming conventions (Oracle standards)
- Separating POC from production code
- Project folder hierarchy
- Version control integration preparation

**Teaching Notes:**
- Show real production project structures
- Emphasize naming convention importance
- Explain why organization matters for maintenance
- Demonstrate refactoring poorly organized code

**Oracle Naming Standards:**
- Package: oracle.apps.[product].[module].webui
- AM: [Module]AM
- CO: [Page]CO
- VO: [Entity]VO
- EO: [Table]EO
- Page: [Module][Function]PG

**Folder Structure:**
```
Workspace/
├── Project/
│   ├── src/
│   │   └── oracle/apps/[product]/[module]/
│   │       ├── server/ (BC4J components)
│   │       └── webui/ (Pages and Controllers)
│   └── classes/ (compiled)
```

---

#### **3.8 Database Connectivity Essentials**
- Creating and testing database connections
- Connection pooling and management
- Multiple environment setup (DEV/TEST/PROD)
- Security best practices
- Troubleshooting connectivity problems

**Teaching Notes:**
- Test connectivity before proceeding with development
- Explain connection pooling benefits
- Show how to manage multiple environments
- Security: Never hardcode credentials

**Connection Best Practices:**
- Use JNDI connections (not direct JDBC)
- Leverage BC4J connection pooling
- Separate connections by environment
- Test connectivity regularly
- Monitor connection usage
- Close connections properly

---

## Section 4: The Model Layer - Business Logic with BC4J

**Duration:** 1.5 Weeks | **Bloom's Level:** Apply, Analyze

### Detailed Lecture Content

#### **4.1 BC4J Framework: The Data Management Engine**
- Understanding Business Components for Java (BC4J)
- BC4J's role in MVC architecture: The "M" in Model
- Component ecosystem: EO, VO, AM, and their relationships
- Metadata-driven approach and XML descriptors
- Why Oracle chose BC4J for OAF

**Teaching Notes:**
- Position BC4J as Oracle's answer to data access layers
- Compare to other frameworks (Hibernate, JPA) if students familiar
- Emphasize metadata benefits: personalization, flexibility
- Show XML descriptors early so they understand what wizards create

**BC4J Architecture:**
- **Entity Objects (EO):** Database table mappings
- **View Objects (VO):** Query results
- **Application Modules (AM):** Transaction containers
- **View Links:** Master-detail relationships
- **Associations:** EO relationships

**Why Metadata?**
- Dynamic behavior without recompilation
- Personalization without code changes
- Declarative vs. programmatic approach
- Easier to maintain and extend

---

#### **4.2 Application Modules: Orchestrating Business Logic**
- AM purpose: Transaction boundary and data container
- Application Module structure and hierarchy
- Root AM vs. nested AM patterns
- Transaction management and commit coordination
- Connection pooling and performance optimization
- When to create new AM vs. extending existing

**Teaching Notes:**
- Use analogy: AM is like a shopping cart (holds data during transaction)
- Explain pooling: Why AMs are reused, not recreated each time
- Show passivation/activation cycle
- Common mistake: Creating too many AMs

**AM Responsibilities:**
- Manage database connections
- Coordinate transactions (commit/rollback)
- Contain View Object instances
- Provide business service methods
- Handle AM-level validation
- Manage state across requests

**AM Lifecycle:**
1. AM requested from pool
2. State activated (if passivated)
3. Methods invoked to access data
4. Transaction committed or rolled back
5. AM returned to pool (state passivated)

---

#### **4.3 Hands-On: Creating & Testing Application Modules**
- Step-by-step AM creation using wizards
- Adding View Objects to AM data model
- Configuring AM properties and settings
- Testing with BC4J tester (standalone testing)
- Debugging AM issues and common pitfalls
- Best practices for AM design

**Teaching Notes:**
- Live demo: Create AM from scratch
- Students follow along on their machines
- Emphasize BC4J tester for testing without UI
- Show how to debug AM initialization issues

**Creation Steps:**
1. Right-click project → New → Business Tier → ADF Business Components → Application Module
2. Name: [Module]AM
3. Package: oracle.apps.[product].[module].server
4. Add View Objects to Data Model tab
5. Configure tuning settings
6. Test with BC4J tester

**Testing Checklist:**
- AM instantiates without errors
- VOs appear in tester
- Queries execute successfully
- Data displays correctly
- Transactions commit properly

---

#### **4.4 Entity Objects: Your Database Gateway**
- EO fundamentals: Mapping to database tables
- Understanding EO attributes and database columns
- Business validation logic at the Model layer
- DML operations: Insert, Update, Delete
- Entity Associations: Relationships between EOs
- When to use EOs vs. direct SQL

**Teaching Notes:**
- Compare EO to object-relational mapping (ORM) concepts
- Emphasize validation at EO level (business rules)
- Show generated methods (doDML, create, remove)
- Explain when NOT to use EOs (reporting queries)

**EO Benefits:**
- Centralized validation logic
- Automatic DML generation
- Change tracking and dirty checking
- Relationship management
- Reusability across VOs

**Validation Locations:**
- **Attribute Level:** Data type, required, range
- **Entity Level:** Cross-attribute validation
- **Transaction Level:** Multi-entity consistency

---

#### **4.5 Building Entity Objects: Mapping to Reality**
- Wizard-driven EO creation process
- Attribute configuration and data types
- Implementing validation rules in EOs
- Business logic in EO methods
- Composite keys and complex mappings
- EO inheritance and reuse

**Teaching Notes:**
- Step-by-step wizard walkthrough
- Show how wizard reverse-engineers from database
- Demonstrate adding validation rules
- Code examples: Overriding create() and validateEntity()

**EO Creation Wizard:**
1. Select database connection
2. Choose schema and table
3. Select attributes to include
4. Define primary key
5. Configure attribute properties
6. Add validation rules
7. Generate and review code

**Custom Validation Example:**
```java
protected void validateEntity() {
  super.validateEntity();
  Number salary = getSalary();
  if (salary != null && salary.doubleValue() < 0) {
    throw new OAAttrValException(OAException.TYP_ENTITY_OBJECT,
      getEntityDef().getFullName(),
      getPrimaryKey(),
      "SALARY",
      salary,
      "FWK_TBX_T_EMP_SAL_NEGATIVE"
    );
  }
}
```

---

#### **4.6 View Objects: Query-Based Data Views**
- VO fundamentals: SQL queries as Java objects
- Read-only vs. updatable View Objects
- VO-EO relationships: When to link them
- Custom SQL queries and expert mode
- Performance implications of VO design
- Calculated and transient attributes

**Teaching Notes:**
- Explain VO as "query with Java wrapper"
- Show difference between EO-based and SQL-based VOs
- Discuss performance: Fetch size, row limits
- Calculated attributes: When to use them

**VO Types:**

1. **Entity-Based (Updatable):**
   - Based on Entity Objects
   - Full CRUD capability
   - Validation from EO
   - Use for data entry

2. **Read-Only (SQL-Based):**
   - Custom SQL queries
   - No EO association
   - Better performance for reports
   - Use for display-only data

3. **Programmatic:**
   - No database query
   - Attributes defined in code
   - Data populated programmatically
   - Use for calculated/transient data

---

#### **4.7 Creating Updatable View Objects**
- Building VO based on Entity Object
- Attribute mapping between VO and EO
- WHERE clause customization
- Testing updatable VOs for CRUD operations
- Handling updates and data persistence
- Validation flow from VO to EO

**Teaching Notes:**
- Wizard demo: Entity-based VO creation
- Show attribute mapping (VO attr → EO attr)
- Test CRUD: Insert, query, update, delete
- Explain validation cascade: VO → EO

**Creation Steps:**
1. New → Business Tier → ADF Business Components → View Object
2. Select "Entity Objects" radio button
3. Choose Entity Object(s)
4. Select attributes to include
5. Customize WHERE clause (optional)
6. Define bind variables if needed
7. Test with BC4J tester

**CRUD Testing:**
- **Create:** executeEmptyRow(), setters, commit
- **Read:** executeQuery(), iterate rows
- **Update:** Find row, setters, commit
- **Delete:** remove(), commit

---

#### **4.8 Creating Read-Only View Objects**
- SQL-based VOs without EO association
- Expert mode: Writing custom SQL queries
- Calculated attributes and complex expressions
- Performance optimization for read-only data
- Joins and multi-table queries
- When to use read-only vs. updatable

**Teaching Notes:**
- Show SQL expert mode for complex queries
- Demonstrate JOINs and aggregations
- Performance: SELECT only needed columns
- Read-only for reporting and LOVs

**SQL-Based VO Use Cases:**
- Complex joins (multiple tables)
- Aggregated data (SUM, AVG, COUNT)
- List of Values (LOV) data
- Reporting queries
- Performance-critical displays

**Expert Mode SQL Example:**
```sql
SELECT 
  e.employee_id,
  e.first_name || ' ' || e.last_name AS full_name,
  d.department_name,
  j.job_title,
  e.salary
FROM 
  employees e
  INNER JOIN departments d ON e.department_id = d.department_id
  INNER JOIN jobs j ON e.job_id = j.job_id
WHERE 
  e.active_flag = 'Y'
ORDER BY 
  e.last_name, e.first_name
```

---

#### **4.9 Creating Programmatic View Objects**
- Building VOs dynamically at runtime
- Defining attributes programmatically in code
- Populating data without database queries
- Use cases: Dynamic columns, calculated data
- Memory management considerations
- Advanced scenarios and examples

**Teaching Notes:**
- Less common but powerful technique
- Use cases: Dynamic reporting, calculated summaries
- Memory warning: No database backing
- Code examples essential

**Use Cases:**
- Dynamic pivot tables
- Calculated summary rows
- Temporary data structures
- API result wrapping
- In-memory data manipulation

**Code Example:**
```java
// Define attributes programmatically
ViewObject vo = am.createViewObject("TempVO", "oracle.jbo.ViewObject");
vo.addAttribute("empId", Integer.class);
vo.addAttribute("empName", String.class);
vo.addAttribute("salary", Number.class);

// Create and populate rows
Row row = vo.createRow();
row.setAttribute("empId", 1001);
row.setAttribute("empName", "John Doe");
row.setAttribute("salary", 50000);
vo.insertRow(row);
```

---

#### **4.10 Advanced BC4J: View Links & Associations**
- View Links: Implementing master-detail relationships
- Entity Associations: FK relationships in EOs
- Domain objects: Reusable data types
- Type converters: Custom data transformations
- Advanced querying capabilities

**Teaching Notes:**
- View Links = VO relationships (UI coordination)
- Associations = EO relationships (data integrity)
- Show master-detail example (Orders → Order Lines)
- Explain cascade delete and referential integrity

**View Links:**
- Connect master VO to detail VO
- Define link condition (FK relationship)
- Automatic query coordination
- Detail query filters based on master row

**Entity Associations:**
- Define FK relationships between EOs
- Implement referential integrity
- Cascade operations (optional)
- Accessor methods for related entities

**Domain Objects:**
- Custom data types with validation
- Reusable across multiple EOs
- Format masks and converters
- Example: Email domain, Phone domain

---

#### **4.11 Database Interactions: Transactions & Pooling**
- Understanding BC4J connection pooling
- Transaction handling: Commit and rollback patterns
- Integration with database triggers
- Sequence generation for primary keys
- Pessimistic vs. optimistic locking strategies
- Performance tuning at Model layer

**Teaching Notes:**
- Connection pooling: Why it matters for scalability
- Transaction boundaries: When to commit
- Locking strategies: Trade-offs
- Performance: Batch operations, fetch size

**Connection Pooling:**
- Pool maintains ready-to-use connections
- AMs checked out from pool
- Passivation: State saved when returned
- Activation: State restored when reused
- Tuning: Pool size, timeout settings

**Transaction Management:**
- **commit():** Save all changes
- **rollback():** Discard all changes
- Transaction scope = AM scope
- Multiple AMs = separate transactions

**Primary Key Generation:**
- Database sequences preferred
- DBSequence domain type
- Populated on create()
- Alternative: Trigger-generated

**Locking Strategies:**
- **Optimistic:** Check on commit (better concurrency)
- **Pessimistic:** Lock on read (prevents conflicts)
- Default: Optimistic
- Configure per EO or VO

---

## Section 5: The View Layer - Building Modern User Interfaces

**Duration:** 1.5 Weeks | **Bloom's Level:** Apply, Analyze

### Detailed Lecture Content

#### **5.1 UIX Framework: Component-Based UI Architecture**
- Framework basics, component hierarchy, metadata
- Component-based architecture benefits
- Understanding the UIX component tree
- Metadata-driven rendering process
- Personalization capabilities through metadata

**Teaching Notes:**
- UIX = User Interface XML (Oracle's pre-ADF technology)
- Component tree = hierarchy of UI elements
- Metadata enables runtime customization
- Show XML descriptors for pages and regions

**UIX Fundamentals:**
- Declarative UI definition (XML)
- Component reusability
- Automatic rendering (HTML generation)
- Built-in accessibility support
- Internationalization ready

**Component Hierarchy:**
```
Page
└── PageLayout Region
    ├── Header Region
    ├── Content Region
    │   ├── Table Region
    │   ├── Form Region
    │   └── Button Region
    └── Footer Region
```

---

#### **5.2 Organizing UI Components: Workspace Structure**
- Organizing UI components
- Naming conventions
- Package structure
- Reusable components

**Teaching Notes:**
- Separate webui package from server package
- Page naming conventions consistent
- Region reusability strategy
- Version control organization

**Package Structure:**
```
oracle.apps.[product].[module].webui/
├── [ModuleName]PG (pages)
├── [ModuleName]CO (controllers)
└── Reusable regions
```

**Naming Conventions:**
- Pages: [Function]PG (e.g., EmployeeSearchPG)
- Controllers: [Page/Region]CO (e.g., EmployeeSearchCO)
- Regions: [Purpose]RN (e.g., SearchResultsRN)

---

#### **5.3 Standard Web Widgets: Your UI Toolkit**
- Text input, message text input
- Message choice (dropdown), checkbox
- Button, submit button, link
- Image, separator, spacer
- Message styled text, formatted text
- Best practices for widget selection

**Teaching Notes:**
- Demo each widget type in simple page
- Explain when to use each widget
- Accessibility considerations
- Styling and CSS application

**Common Widgets:**

1. **messageTextInput:** Editable field with label
2. **messageStyledText:** Display-only formatted text
3. **messageChoice:** Dropdown selection
4. **button:** Standard action button
5. **submitButton:** Form submission
6. **image:** Display images
7. **link:** Navigation links
8. **checkbox:** Boolean selection

---

#### **5.4 Building Page Layouts: Regions & Hierarchy**
- Understanding region types and purposes
- Page layout regions: header, content, footer
- Hierarchical region structure
- Stack layout vs. flow layout
- Nesting regions effectively

**Teaching Notes:**
- Visual diagrams of region layouts
- Show how regions nest and contain each other
- Common layout patterns (search, results, detail)
- Responsive design considerations

**Region Types:**

1. **pageLayout:** Top-level page container
2. **header:** Page title and global actions
3. **messageComponentLayout:** Standard form layout
4. **stackLayout/flowLayout:** Component arrangement
5. **tableLayout:** Grid-based layout
6. **advancedTable:** Data grid with features

---

#### **5.5 Working with Tables: Displaying Data Effectively**
- Table region configuration
- Column definition and attributes
- Sortable columns
- Row selection (single/multiple)
- Table actions and buttons
- Performance optimization

**Teaching Notes:**
- Most common UI component in OAF
- Step-by-step table creation
- Binding to View Object
- Action buttons in tables

**Table Features:**
- **Sorting:** Click column headers
- **Selection:** Single or multiple row selection
- **Actions:** Add, Update, Delete buttons
- **Pagination:** Automatic for large datasets
- **Export:** Excel export capability
- **Totals:** Column totals and subtotals

---

#### **5.6 Implementing Search Forms: User Input**
- Search region design patterns
- Bind variables for query parameters
- Go button and query execution
- Clear button functionality
- Advanced search options
- Search results coordination

**Teaching Notes:**
- Common pattern: Search form + results table
- Bind variables crucial for parameterized queries
- Performance: Limit search results
- User experience: Clear visual feedback

**Search Pattern:**
1. User enters search criteria
2. Click "Go" button
3. Controller captures inputs
4. Sets bind variables on VO
5. Executes query
6. Results display in table

---

#### **5.7 List of Values (LOV): Searchable Dropdowns**
- LOV component configuration
- External and internal LOV types
- Search and select functionality
- Multi-select LOV
- LOV performance considerations
- Custom LOV regions

**Teaching Notes:**
- LOV = enhanced dropdown with search
- External LOV: Popup window with search
- Internal LOV: Inline dropdown
- Create LOV View Object first
- Map attributes correctly

**LOV Types:**

1. **External LOV:**
   - Popup search window
   - Multiple search criteria
   - Results table with selection
   - Better for large datasets

2. **Internal LOV:**
   - Inline dropdown
   - Fixed list of values
   - Better for small datasets
   - Simpler UX

---

#### **5.8 Advanced UI: PPR & Dynamic Behavior**
- Partial Page Rendering (PPR) fundamentals
- Dependent field updates
- Dynamic show/hide logic
- Client-side validation
- AJAX-like behavior in OAF
- Performance implications

**Teaching Notes:**
- PPR = Update part of page without full refresh
- Use sparingly (performance impact)
- Common use case: Dependent dropdowns
- Requires careful event handling

**PPR Use Cases:**
- Dependent LOVs (Country → State → City)
- Calculated fields (Quantity × Price = Total)
- Conditional field visibility
- Dynamic validation messages
- Progressive disclosure

**PPR Implementation:**
1. Enable PPR on source component
2. Configure fire action event
3. Add PPR targets (components to update)
4. Handle event in controller
5. Update target component values

---

#### **5.9 Styling with CSS: Professional Look & Feel**
- OAF default styles and themes
- Custom CSS application
- Style classes and inline styles
- Corporate branding
- Accessibility and styling
- Style best practices

**Teaching Notes:**
- OAF has default BLAF (Browser Look and Feel)
- Custom CSS for branding
- Accessibility: Don't rely only on color
- Test across browsers

**Styling Options:**

1. **Default BLAF Styles:**
   - Oracle's standard look and feel
   - Consistent across EBS
   - Accessibility compliant

2. **Custom CSS:**
   - Corporate branding
   - Custom colors and fonts
   - Style classes
   - Inline styles (use sparingly)

**Best Practices:**
- Use style classes over inline styles
- Test accessibility (color contrast, screen readers)
- Maintain consistency across pages
- Consider internationalization (RTL languages)

---

## Next Steps

This instructor syllabus continues with detailed lecture content for:

- **Section 6:** Controller Layer - Handling User Interactions
- **Section 6B:** Master-Detail Relationships
- **Section 7:** Error Handling & User Feedback
- **Section 8:** Security & Data Protection
- **Section 9:** Professional Development Standards
- **Section 10:** Deployment Mastery

---

## Teaching the Level 101 Capstone: Jobs & Positions Management System

### Progressive Project Development Guide (20-Day Schedule)

This section provides comprehensive guidance for teaching the Jobs & Positions Management System capstone project using scaffold-oriented pedagogy.

#### Week 1: Database Foundation & Entity Layer (Days 1-5)

**Day 1-2: Database Setup & Understanding**

**Learning Objective:** Students understand the master-detail relationship and can query the data

**Instructor Activities:**
1. **"I Do" - Live Demonstration (30 mins):**
   - Execute DDL script, explain each table column
   - Load DML script, show sample data
   - Draw ER diagram on board: Jobs (1) → Positions (M)
   - Execute SQL queries to show relationship

2. **"We Do" - Guided Practice (45 mins):**
   - Students execute scripts in their environments
   - Instructor circulates, helps with connection issues
   - Together, write SQL queries to answer business questions:
     ```sql
     -- How many positions for each job?
     SELECT j.job_name, COUNT(p.position_id)
     FROM xx_jobs j
     LEFT JOIN xx_positions p ON j.job_id = p.job_id
     GROUP BY j.job_name;
     ```

3. **"You Do" - Independent Practice (30 mins):**
   - Write 3 more SQL queries (provided prompts)
   - Verify understanding of FK relationship
   - Document table structure in notes

**Checkpoint:**
- [ ] Tables created successfully
- [ ] Sample data loaded (2 jobs, 8 positions)
- [ ] Can write JOIN query successfully
- [ ] Understands PK/FK relationship

**Common Issues & Solutions:**
| Issue | Solution |
|-------|----------|
| "Table already exists" | DROP tables first or use CREATE OR REPLACE |
| Sequence starts wrong | ALTER SEQUENCE to set starting value |
| FK constraint fails | Ensure job_id exists before inserting positions |

---

**Day 3-5: Entity Objects with Association**

**Learning Objective:** Students can create EOs with validation and entity associations

**Day 3 - JobEO Creation:**

**"I Do" (20 mins):**
- Live demo: Create JobEO using wizard
- Explain each wizard step (show on projector)
- Show generated XML and Java files
- Override create() method to add sequence

```java
// Code to show and explain
protected void create(AttributeList attributeList) {
    super.create(attributeList);
    SequenceImpl seq = new SequenceImpl("XX_JOB_ID_SEQ", getDBTransaction());
    setJobId(seq.getSequenceNumber());
    // WHO columns
    setCreatedBy(getOADBTransaction().getUserId());
    setCreationDate(getOADBTransaction().getCurrentDBDate());
}
```

**"We Do" (40 mins):**
- Students create JobEO following step-by-step guide
- Pause at each wizard screen for questions
- Together, add validation for head count > 0

**"You Do" (45 mins):**
- Add date validation (start < end)
- Test with BC4J tester
- Try to break it (negative values, invalid dates)

**Day 4 - PositionEO & Association:**

**"I Do" (20 mins):**
- Create PositionEO
- Create Entity Association (JobEO → PositionEO)
- Explain composition vs. association
- Show accessor methods generated

**"We Do" (40 mins):**
- Students create PositionEO
- Students create association
- Test in BC4J tester: Create job, add positions

**"You Do" (45 mins):**
- Add validation: position headcount <= job headcount
- Requires using accessor to get parent JobEO

**Day 5 - Testing & Debugging:**

**Focus:** Mastery of BC4J tester

**Activities:**
- Comprehensive testing scenarios (provided list)
- Try to violate each validation rule
- Verify WHO columns populated correctly
- Test cascade behavior (what happens if...)

**Checkpoint:**
- [ ] JobEO created and tested
- [ ] PositionEO created and tested
- [ ] Association works (can navigate from position to job)
- [ ] All validations fire correctly
- [ ] Sequences generate IDs

---

#### Week 2: View Objects & Application Module & First UI (Days 6-10)

**Day 6-7: View Objects & View Link**

**Scaffold Level:** Moderate (provide SQL, high-level steps)

**Activities:**
1. Create JobVO (updatable, based on JobEO)
2. Create PositionVO (updatable, based on PositionEO)
3. Create View Link: JobPositionVL

**Teaching Focus:**
- Difference between EO and VO
- When to use updatable vs. read-only
- View Link = UI coordination, Association = data integrity

**"I Do" (15 mins):**
- Create JobVO, explain attribute mapping
- Show WHERE clause customization

**"We Do" (30 mins):**
- Create PositionVO together
- Create View Link (critical for master-detail)
  - Source: JobVO.JobId
  - Destination: PositionVO.JobId
  - Test query coordination

**"You Do" (60 mins):**
- Test various scenarios
- Write custom WHERE clause for active jobs only
- Add calculated attribute (fullName = first + last)

**Day 8: Application Module**

**Activities:**
- Create JobMgmtAM
- Add JobVO and PositionVO to data model
- Create custom AM methods (if needed)

**"I Do" (20 mins):**
- Create AM with wizard
- Add VOs to data model
- Show AM pooling concept

**"We Do" (30 mins):**
- Students create AM
- Add instance: JobVO1, PositionVO1
- Set View Link instance

**"You Do" (30 mins):**
- Test complete BC4J model
- Execute queries, CRUD operations
- Verify master-detail coordination

**Major Checkpoint - End of Week 2:**
- [ ] Complete BC4J model working
- [ ] Can perform all CRUD in BC4J tester
- [ ] Master-detail relationship tested
- [ ] Ready to build UI

---

**Day 9-10: First UI Page (JobSearchPG)**

**Scaffold Level:** Moderate (UI layout diagram, component reference)

**Activities:**
- Create JobSearchPG
- Add search criteria fields
- Add results table
- Create JobSearchCO (controller)

**"I Do" (25 mins):**
- Create page using wizard
- Add pageLayout region
- Add messageComponentLayout
- Add messageTextInput for search field

**"We Do" (45 mins):**
- Add search button
- Add results table (advancedTable)
- Set table columns
- Bind to JobVO

**"You Do" (90 mins):**
- Add more search criteria (effective dates)
- Format table columns
- Add table actions (View, Edit, Delete buttons)

**Day 10 Checkpoint:**
- [ ] JobSearchPG created and displays
- [ ] Can see data in table
- [ ] Search button exists (even if not functional yet)

---

#### Week 3: Controllers & CRUD Operations (Days 11-15)

**Scaffold Level:** Reducing - Code patterns provided, no complete solutions

**Day 11-12: Search & Create Operations**

**Focus:** Controller event handling

**"I Do" (20 mins):**
- Show controller processFormRequest structure
- Demonstrate getting parameters
- Show how to invoke AM methods

```java
public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processFormRequest(pageContext, webBean);
    
    if ("search".equals(pageContext.getParameter("event"))) {
        String jobName = pageContext.getParameter("SearchJobName");
        OAApplicationModule am = pageContext.getRootApplicationModule();
        am.invokeMethod("executeJobSearch", new Object[]{jobName});
    }
}
```

**"We Do" (60 mins):**
- Implement search functionality together
- Create JobDetailsPG (create/update form)
- Implement create operation

**"You Do" (Days 12-13):**
- Complete create functionality
- Add field validations
- Test thoroughly
- Handle errors gracefully

**Day 14-15: Update & Delete**

**Scaffold Level:** Low - Requirements only, hints available

**Requirements Provided:**
- Update: Navigate to detail page with jobId, populate fields, save changes
- Delete: Show confirmation dialog, check for positions, delete if allowed

**Hints Available (if requested):**
- Hint 1: How to pass parameters between pages
- Hint 2: Dialog page example code
- Hint 3: How to check for child records

**Student Activities:**
- Design the approach (write pseudocode)
- Implement update functionality
- Implement delete with confirmation
- Test edge cases

**End of Week 3 Checkpoint:**
- [ ] Search works
- [ ] Create works
- [ ] Update works  
- [ ] Delete works with validation
- [ ] All basic CRUD complete

---

#### Week 4: Master-Detail, Testing & Deployment (Days 16-20)

**Day 16-18: PositionMaintPG (Master-Detail)**

**Scaffold Level:** Minimal - Architecture guidance only

**Architecture Guidance Provided:**
- Page should show job details at top (read-only)
- Table below shows positions for that job
- Buttons: Add Position, Update, Delete
- Use View Link for automatic coordination

**Student Activities:**
- Design page layout
- Implement master-detail UI
- Wire up controller logic
- Test master-detail coordination

**Challenge:** How do you ensure the positions table only shows positions for the selected job?
**Answer:** View Link handles this automatically when configured correctly

**Day 19: Testing & Bug Fixing**

**Testing Checklist Provided:**
- [ ] Can search jobs by name
- [ ] Can create new job
- [ ] Can update existing job
- [ ] Can delete job (when no positions)
- [ ] Cannot delete job with positions
- [ ] Can view positions for a job
- [ ] Can add position to job
- [ ] Can update position
- [ ] Can delete position
- [ ] All validations work
- [ ] Error messages are user-friendly
- [ ] No console errors

**Activities:**
- Execute full test suite
- Fix any bugs found
- Peer testing (swap computers)
- Document test results

**Day 20: Deployment**

**Deployment Checklist Provided:**
- [ ] Export project to .jpx file
- [ ] Transfer files to server
- [ ] Import to MDS
- [ ] Bounce Apache
- [ ] Register functions
- [ ] Test in EBS environment

**Deliverables Due:**
- Source code
- Documentation
- Test results
- Reflection paper

---

### Assessment & Grading Guide

#### How to Grade the Project

**Automated Checks (Use Script):**
```sql
-- Check tables exist
SELECT * FROM user_tables WHERE table_name IN ('XX_JOBS', 'XX_POSITIONS');

-- Check data loaded
SELECT COUNT(*) FROM xx_jobs; -- Should be >= 2
SELECT COUNT(*) FROM xx_positions; -- Should be >= 8
```

**Functional Testing (Manual):**
Create a testing spreadsheet with test cases:

| Test Case | Steps | Expected Result | Pass/Fail | Points |
|-----------|-------|-----------------|-----------|--------|
| TC01 | Search for "Oracle" | Shows 2 jobs | | 2 |
| TC02 | Create new job "DBA" | Job created, ID assigned | | 3 |
| TC03 | Update job name | Name changed successfully | | 3 |
| TC04 | Delete job with positions | Error message displayed | | 3 |
| TC05 | Delete job without positions | Job deleted | | 3 |
| ... | ... | ... | | ... |

**Code Review Checklist:**
```
Naming Conventions:
[ ] Package: oracle.apps.xx.jobmgmt.*
[ ] EO names: JobEO, PositionEO
[ ] VO names: JobVO, PositionVO
[ ] Page names: JobSearchPG, JobDetailsPG
[ ] CO names: JobSearchCO, JobDetailsCO

Code Quality:
[ ] No TODO comments left
[ ] Methods have JavaDoc
[ ] Proper exception handling
[ ] No System.out.println (use OAException)
[ ] No hardcoded strings for messages

Architecture:
[ ] Business logic in AM methods
[ ] Controllers only handle events
[ ] Validations in EO, not page
[ ] Proper VO-EO relationships
```

**Documentation Review:**
- Technical design: Does it explain the architecture?
- Deployment guide: Can another student follow it?
- Test results: Are they comprehensive?
- Reflection: Is it thoughtful and insightful?

---

### Common Student Mistakes & How to Address Them

#### 1. Entity Association Issues

**Mistake:** Students create association with wrong cardinality or forget FK attribute

**Symptoms:**
- Cannot navigate from position to job
- Validation fails when trying to access parent
- BC4J tester shows no relationship

**Solution:**
- Show ER diagram again
- Verify FK column in PositionEO
- Check association properties in wizard
- Test with BC4J tester immediately

**Prevention:** Day 4 checkpoint must verify association works

---

#### 2. View Link Configuration Errors

**Mistake:** Wrong source/destination attributes or missing WHERE clause

**Symptoms:**
- Master-detail shows all positions, not just for selected job
- Selecting different job doesn't update positions

**Solution:**
```
Check View Link properties:
Source: JobVO1.JobId
Destination: PositionVO1.JobId (note: instance names, not VO names)
```

**Teaching Moment:** Explain View Link vs. Association difference

---

#### 3. Controller Anti-Patterns

**Mistake:** Business logic in controller, direct database access

**Bad Code:**
```java
// DON'T DO THIS
public void processFormRequest(...) {
    if ("create".equals(event)) {
        // Creating rows directly in controller
        ViewObject vo = am.findViewObject("JobVO1");
        Row row = vo.createRow();
        row.setAttribute("JobName", jobName);
        vo.insertRow(row);
        am.getTransaction().commit();  // Committing in controller!
    }
}
```

**Good Code:**
```java
// DO THIS
public void processFormRequest(...) {
    if ("create".equals(event)) {
        String jobName = pageContext.getParameter("JobName");
        OAApplicationModule am = pageContext.getRootApplicationModule();
        am.invokeMethod("createJob", new Object[]{jobName});
        // AM method handles all logic and commit
    }
}
```

**Teaching Strategy:**
- Code review at Week 3 checkpoint
- Show bad vs. good examples
- Explain MVC responsibilities clearly

---

#### 4. Forgetting WHO Columns

**Mistake:** Not populating WHO columns in create()

**Impact:** Data audit fails, production issues

**Solution - Show Template:**
```java
protected void create(AttributeList attributeList) {
    super.create(attributeList);
    
    OADBTransaction txn = getOADBTransaction();
    setCreatedBy(txn.getUserId());
    setCreationDate(txn.getCurrentDBDate());
    setLastUpdatedBy(txn.getUserId());
    setLastUpdateDate(txn.getCurrentDBDate());
    setLastUpdateLogin(txn.getUserLoginId());
}
```

**Verification:** BC4J tester should show WHO columns populated

---

#### 5. Validation Placement

**Mistake:** Validations in wrong layer (controller or page instead of EO)

**Wrong:**
```java
// In Controller - DON'T DO THIS
if (headCount < 0) {
    throw new OAException("Head count must be positive");
}
```

**Right:**
```java
// In JobEO - DO THIS
protected void validateEntity() {
    super.validateEntity();
    Number count = getJobHeadCount();
    if (count != null && count.intValue() < 0) {
        throw new OAAttrValException(...);
    }
}
```

**Teaching Point:** Validations belong in Model layer for reusability

---

### Differentiation Strategies

#### For Struggling Students

**Additional Scaffolds:**
1. Provide more detailed pseudocode
2. Offer one-on-one sessions
3. Break project into smaller milestones
4. Extend deadline with alternate assignment

**Extra Support:**
- Recorded video walkthroughs
- Pre-built partial solutions
- Debugging sessions
- Simplified requirements (remove some features)

#### For Advanced Students

**Extensions:**
1. Add XX_DEPARTMENTS table (3-level hierarchy)
2. Implement inline table editing
3. Add Excel export functionality
4. Create dashboard with charts (headcount by job)
5. Implement approval workflow

**Challenges:**
- Build without looking at any guides
- Optimize for performance (caching, lazy loading)
- Add advanced features (PPR, AJAX)

---

##Code Examples Library for Instructors

### Example 1: Dialog Page for Confirmation

**Use Case:** Confirm before deleting a job

**Teaching Context:** Section 7 (Error Handling), Day 15 (Delete operation)

**Complete Working Code:**

```java
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAApplicationModule;

public class JobSearchCO extends OAControllerImpl {
    
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        // Delete button clicked
        if ("delete".equals(pageContext.getParameter("event"))) {
            String jobId = pageContext.getParameter("jobId");
            String jobName = pageContext.getParameter("jobName");
            
            // Create confirmation message
            OAException confirmMsg = new OAException(
                "XX",  // Product short name
                "XX_CONFIRM_DELETE_JOB",  // Message name
                null,  // Tokens (if message has {0}, {1})
                OAException.CONFIRMATION,
                null
            );
            
            // Message text in database:
            // "Are you sure you want to delete job {0}?"
            
            // Create dialog page
            OADialogPage dialogPage = new OADialogPage(
                OAException.CONFIRMATION,  // Dialog type
                confirmMsg,  // Message to display
                null,  // Detail message (optional)
                "",   // OK button destination (empty = return to calling page)
                ""    // NO button destination
            );
            
            // Configure buttons
            String yesLabel = pageContext.getMessage("FND", "YES", null);
            String noLabel = pageContext.getMessage("FND", "NO", null);
            
            dialogPage.setOkButtonItemName("DeleteYesButton");  // Event name when Yes clicked
            dialogPage.setOkButtonLabel(yesLabel);
            dialogPage.setOkButtonToPost(true);  // POST instead of GET
            
            dialogPage.setNoButtonLabel(noLabel);
            dialogPage.setNoButtonToPost(true);
            
            dialogPage.setPostToCallingPage(true);  // Return to this page
            
            // Pass parameters back
            java.util.Hashtable params = new java.util.Hashtable();
            params.put("jobId", jobId);
            params.put("jobName", jobName);
            dialogPage.setFormParameters(params);
            
            // Show dialog
            pageContext.redirectToDialogPage(dialogPage);
        }
        
        // User clicked Yes on dialog
        if ("DeleteYesButton".equals(pageContext.getParameter("event"))) {
            String jobId = pageContext.getParameter("jobId");
            
            try {
                // Check for child positions first
                OAApplicationModule am = pageContext.getRootApplicationModule();
                Boolean hasPositions = (Boolean)am.invokeMethod("checkJobHasPositions", 
                                                                new Object[]{jobId});
                
                if (hasPositions) {
                    // Show error - cannot delete
                    OAException errorMsg = new OAException(
                        "XX",
                        "XX_JOB_HAS_POSITIONS",
                        null,
                        OAException.ERROR,
                        null
                    );
                    pageContext.putDialogMessage(errorMsg);
                } else {
                    // Delete the job
                    am.invokeMethod("deleteJob", new Object[]{jobId});
                    
                    // Show success message
                    OAException successMsg = new OAException(
                        "XX",
                        "XX_JOB_DELETED_SUCCESS",
                        null,
                        OAException.INFORMATION,
                        null
                    );
                    pageContext.putDialogMessage(successMsg);
                }
            } catch (Exception e) {
                throw new OAException("Error deleting job: " + e.getMessage(),
                                     OAException.ERROR);
            }
        }
    }
}
```

**Teaching Points:**

1. **Dialog Types:**
   - CONFIRMATION: Yes/No questions
   - WARNING: Alerts with OK/Cancel
   - ERROR: Error messages with OK
   - INFORMATION: Success messages with OK

2. **Button Configuration:**
   - setOkButtonItemName: Event name to check in processFormRequest
   - setOkButtonToPost: Use POST for data modifications
   - setPostToCallingPage: Return to same page vs. navigate away

3. **Parameter Passing:**
   - Use Hashtable to pass data through dialog
   - Retrieve with pageContext.getParameter() after dialog

4. **Message Dictionary:**
   - Messages stored in FND_NEW_MESSAGES table
   - Never hardcode user-facing text
   - Supports internationalization

**Common Mistakes:**
- Forgetting to check event name for dialog response
- Not passing parameters through dialog (data lost)
- Using hardcoded strings instead of message dictionary
- Not handling exceptions

**Lab Exercise:**
"Add a confirmation dialog before updating a job. Show the current and new values in the message."

---

### Example 2: Accessing Root Application Module

**Use Case:** Execute search query from controller

**Teaching Context:** Section 6 (Controllers), Day 11-12

**Complete Working Code:**

```java
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.jbo.ViewObject;
import oracle.jbo.Row;

public class JobSearchCO extends OAControllerImpl {
    
    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);
        
        if ("search".equals(pageContext.getParameter("event"))) {
            
            // Get search criteria from page
            String jobName = pageContext.getParameter("SearchJobName");
            String startDate = pageContext.getParameter("SearchStartDate");
            
            // Get root Application Module
            OAApplicationModule rootAM = 
                (OAApplicationModule)pageContext.getRootApplicationModule();
            
            if (rootAM != null) {
                
                // Method 1: Invoke custom AM method (BEST PRACTICE)
                rootAM.invokeMethod("executeJobSearch", 
                                   new Object[]{jobName, startDate});
                
                /* Alternative Method 2: Direct VO access (use sparingly)
                ViewObject jobVO = rootAM.findViewObject("JobVO1");
                if (jobVO != null) {
                    // Set WHERE clause parameters
                    jobVO.setWhereClause("job_name LIKE :1 OR :1 IS NULL");
                    jobVO.setWhereClauseParam(0, jobName != null ? "%" + jobName + "%" : null);
                    
                    // Execute query
                    jobVO.executeQuery();
                    
                    // Optional: Navigate to first row
                    jobVO.first();
                }
                */
                
            } else {
                throw new OAException("Unable to get Application Module");
            }
        }
        
        // Create new job
        if ("create".equals(pageContext.getParameter("event"))) {
            OAApplicationModule am = pageContext.getRootApplicationModule();
            
            if (am != null) {
                // Call AM method to create empty row
                am.invokeMethod("createJob");
                
                // Navigate to detail page
                pageContext.setForwardURL(
                    "OA.jsp?page=/oracle/apps/xx/jobmgmt/webui/JobDetailsPG",
                    null,  // No transaction token needed
                    OAWebBeanConstants.KEEP_MENU_CONTEXT,
                    null,  // No parameters
                    null,  // No hash map
                    true,  // Retain AM
                    OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
                    OAWebBeanConstants.IGNORE_MESSAGES
                );
            }
        }
    }
}
```

**In Application Module (JobMgmtAMImpl.java):**

```java
public void executeJobSearch(String jobName, String startDate) {
    ViewObject vo = getJobVO1();  // Getter method for VO instance
    
    if (vo != null) {
        // Build dynamic WHERE clause
        StringBuilder whereClause = new StringBuilder();
        whereClause.append("1=1");  // Always true base
        
        if (jobName != null && jobName.trim().length() > 0) {
            whereClause.append(" AND UPPER(job_name) LIKE UPPER(:1)");
            vo.setWhereClauseParam(0, "%" + jobName + "%");
        }
        
        if (startDate != null && startDate.trim().length() > 0) {
            whereClause.append(" AND effective_start_date >= :2");
            vo.setWhereClauseParam(1, startDate);
        }
        
        vo.setWhereClause(whereClause.toString());
        vo.executeQuery();
    }
}

public void createJob() {
    ViewObject vo = getJobVO1();
    Row row = vo.createRow();
    vo.insertRow(row);
    vo.setCurrentRow(row);
    // EO.create() will set sequence and WHO columns
}
```

**Teaching Points:**

1. **Why invokeMethod?**
   - Avoids direct AM casting
   - Works with AM pooling/passivation
   - Follows Oracle best practices
   - Type-safe with Object[] parameters

2. **When to Access AM:**
   - Query execution
   - Create/Update/Delete operations
   - Custom business logic
   - Transaction management (commit/rollback)

3. **What NOT to do in Controller:**
   - Business logic (belongs in AM)
   - Direct database access
   - Complex calculations
   - Data validation (belongs in EO)

4. **Best Practices:**
   - Always check for null AM
   - Keep controllers thin (orchestration only)
   - Use AM methods for all business logic
   - Handle exceptions properly

**Common Patterns:**

| Use Case | Controller Code | AM Method |
|----------|-----------------|-----------|
| Search | `am.invokeMethod("executeSearch", params)` | `executeSearch(String criteria)` |
| Create | `am.invokeMethod("createRow")` | `createRow()` - returns Row |
| Update | `am.invokeMethod("updateRow", params)` | `updateRow(String id, values)` |
| Delete | `am.invokeMethod("deleteRow", params)` | `deleteRow(String id)` |
| Commit | `am.invokeMethod("commit")` | `getTransaction().commit()` |

**Lab Exercise:**
"Implement a search with multiple criteria (job name, date range, head count range). Create the AM method and call it from the controller."

---

### Example 3: Programmatic View Object for Summary

**Use Case:** Create dashboard showing job statistics

**Teaching Context:** Section 4.9 (Programmatic VOs), Advanced topic

**Complete Working Code:**

```java
// In Application Module (JobMgmtAMImpl.java)

import oracle.jbo.ViewObject;
import oracle.jbo.Row;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public void createJobSummaryVO() {
    
    // Create programmatic VO (no XML definition needed)
    ViewObject summaryVO = createViewObject(
        "JobSummaryVO",  // Instance name
        "oracle.jbo.ViewObject"  // Use base VO class
    );
    
    // Define structure (attributes)
    summaryVO.addDynamicAttribute("JobName");  // String by default
    summaryVO.addDynamicAttribute("TotalPositions");  // Number
    summaryVO.addDynamicAttribute("TotalHeadCount");  // Number
    summaryVO.addDynamicAttribute("AvgHeadCount");  // Number
    
    try {
        // Execute custom SQL query
        String sql = 
            "SELECT j.job_name, " +
            "       COUNT(p.position_id) as total_positions, " +
            "       SUM(NVL(p.position_head_count, 0)) as total_headcount, " +
            "       ROUND(AVG(NVL(p.position_head_count, 0)), 2) as avg_headcount " +
            "FROM xx_jobs j " +
            "LEFT JOIN xx_positions p ON j.job_id = p.job_id " +
            "WHERE j.effective_end_date > SYSDATE " +  // Active jobs only
            "GROUP BY j.job_name " +
            "ORDER BY total_positions DESC";
        
        PreparedStatement stmt = getDBTransaction().createPreparedStatement(sql, 1);
        ResultSet rs = stmt.executeQuery();
        
        // Populate VO with query results
        while (rs.next()) {
            Row row = summaryVO.createRow();
            row.setAttribute("JobName", rs.getString("job_name"));
            row.setAttribute("TotalPositions", rs.getInt("total_positions"));
            row.setAttribute("TotalHeadCount", rs.getInt("total_headcount"));
            row.setAttribute("AvgHeadCount", rs.getDouble("avg_headcount"));
            summaryVO.insertRow(row);
        }
        
        // Important: Close resources
        rs.close();
        stmt.close();
        
    } catch (Exception e) {
        throw new OAException("Error creating summary: " + e.getMessage());
    }
    
    // Reset to first row
    summaryVO.first();
}
```

**Using in Page:**

```java
// In Controller (DashboardCO.java)
public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
    super.processRequest(pageContext, webBean);
    
    OAApplicationModule am = pageContext.getRootApplicationModule();
    
    // Create and populate the summary VO
    am.invokeMethod("createJobSummaryVO");
}
```

**Page XML (for table binding):**

```xml
<advancedTable id="SummaryTable" viewInstance="JobSummaryVO">
    <column id="col1">
        <sortableHeader text="Job Name" />
        <messageStyledText item="JobName" />
    </column>
    <column id="col2">
        <sortableHeader text="Total Positions" />
        <messageStyledText item="TotalPositions" />
    </column>
    <!-- More columns -->
</advancedTable>
```

**Teaching Points:**

1. **When to Use Programmatic VOs:**
   - Dynamic/calculated data
   - Complex SQL not suitable for expert mode
   - Temporary data structures
   - API results wrapping

2. **Advantages:**
   - No XML definition needed
   - Highly flexible
   - Can use any SQL
   - Easy to modify at runtime

3. **Disadvantages:**
   - No automatic CRUD
   - Data only in memory
   - Must repopulate on each request
   - No caching

4. **Alternative: SQL-Based Expert Mode VO**
   - Easier for simple cases
   - Better for production
   - Can cache results
   - Supports sorting/filtering

**Performance Considerations:**
- Limit rows returned (add WHERE filter)
- Use for read-only displays only
- Consider caching if data doesn't change often
- Clean up (remove) when done to free memory

**Lab Exercise:**
"Create a programmatic VO showing position statistics: position name, job name, required headcount, current headcount (from future XX_EMPLOYEES table)"

---

###Example 4: Sequence Generation in Entity Object

**Use Case:** Auto-generate primary key on row creation

**Teaching Context:** Section 4.5 (Building Entity Objects), Day 3

**Complete Working Code:**

```java
// In JobEOImpl.java

import oracle.jbo.server.SequenceImpl;
import oracle.jbo.AttributeList;
import oracle.apps.fnd.framework.server.OAEntityImpl;

public class JobEOImpl extends OAEntityImpl {
    
    /**
     * Override create() to set primary key and WHO columns
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
        // Generate primary key from sequence
        SequenceImpl seq = new SequenceImpl("XX_JOB_ID_SEQ", getDBTransaction());
        Number newJobId = seq.getSequenceNumber();
        setJobId(newJobId);
        
        // Set WHO columns for audit
        OADBTransaction txn = getOADBTransaction();
        setCreatedBy(txn.getUserId());
        setCreationDate(txn.getCurrentDBDate());
        setLastUpdatedBy(txn.getUserId());
        setLastUpdateDate(txn.getCurrentDBDate());
        setLastUpdateLogin(txn.getUserLoginId());
    }
    
    /**
     * Override doDML to update WHO columns on update
     */
    protected void doDML(int operation, TransactionEvent e) {
        
        // On UPDATE, refresh WHO columns
        if (operation == DML_UPDATE) {
            OADBTransaction txn = getOADBTransaction();
            setLastUpdatedBy(txn.getUserId());
            setLastUpdateDate(txn.getCurrentDBDate());
            setLastUpdateLogin(txn.getUserLoginId());
        }
        
        super.doDML(operation, e);
    }
    
    // Attribute getters and setters generated by wizard...
}
```

**Alternative: Using DBSequence Domain**

```xml
<!-- In JobEO.xml -->
<Attribute
    Name="JobId"
    Precision="15"
    Scale="0"
    Type="oracle.jbo.domain.DBSequence"
    ColumnName="JOB_ID"
    SQLType="NUMERIC"
    IsNotNull="true"
    IsUpdateable="false"  /* Can't update PK */
    PrimaryKey="true">
    <Properties>
        <SchemaBasedProperties>
            <LABEL>Job ID</LABEL>
            <SequenceName>XX_JOB_ID_SEQ</SequenceName>
        </SchemaBasedProperties>
    </Properties>
</Attribute>
```

**Teaching Points:**

1. **Two Approaches:**
   - Manual in create(): More control, explicit
   - DBSequence domain: Automatic, declarative

2. **When to Use Each:**
   - Manual: Need custom logic, multiple sequences
   - DBSequence: Simple case, Oracle recommends

3. **WHO Columns:**
   - Essential for audit trail
   - Always populate in EBS
   - Set in create(), update in doDML()
   - Get from OADBTransaction

4. **Common Issues:**
   - Sequence not created
   - Wrong sequence name
   - Forgetting to call super.create()
   - Not handling WHO columns

**Verification:**

```sql
-- Check sequence exists
SELECT * FROM user_sequences WHERE sequence_name = 'XX_JOB_ID_SEQ';

-- Check WHO columns populated
SELECT job_id, created_by, creation_date, last_updated_by, last_update_date
FROM xx_jobs
WHERE job_id = <newly_created_id>;
```

**Lab Exercise:**
"Add a second sequence for a TRANSACTION_ID field. This should be auto-populated but different from the primary key."

---

## Document Maintenance

**Last Updated:** January 24, 2026  
**Version:** 2.0 (Enhanced with barin directory content)  
**Author:** Demasy Labs Instructional Team

**Changelog:**
- v2.0 (2026-01-24): Added Jobs & Positions project teaching guide, code examples library
- v1.0 (2026-01-24): Initial release with Sections 2-5 detailed content

---

## Next Steps

This instructor syllabus will be expanded with detailed lecture content for:

- **Section 6:** Controller Layer - Handling User Interactions
- **Section 6B:** Master-Detail Relationships  
- **Section 7:** Error Handling & User Feedback
- **Section 8:** Security & Data Protection
- **Section 9:** Professional Development Standards
- **Section 10:** Deployment Mastery

### Document Maintenance

**Last Updated:** January 24, 2026  
**Version:** 1.0  
**Author:** Demasy Labs Instructional Team

---

## Feedback and Contributions

Instructors are encouraged to:
- **Add teaching notes** from classroom experience
- **Share successful examples** and demonstrations
- **Document common student questions** and clarifications
- **Suggest improvements** to content depth and sequence

Please submit feedback through the course repository.

---

## Additional Resources for Instructors

### Suggested Teaching Materials
- **Slide decks** for each lecture (to be developed)
- **Demo scripts** with step-by-step instructions
- **Assessment rubrics** for graded activities
- **Lab solution files** for reference

### Professional Development
- Oracle OAF Developer Certification
- Instructional design workshops
- Peer teaching observations
- Student feedback analysis

---

*This document is a living resource and will be continuously updated based on teaching experience and student feedback.*
