# Level 101 Capstone Project
## Jobs & Positions Management System

**Project Type:** Scaffolded Capstone Project  
**Level:** Beginner (Level 101)  
**Duration:** 4-5 Weeks  
**Scaffolding Support:** Maximum (60% guided, 40% independent)  
**Assessment Weight:** 25% of Level 101 Grade

---

## 📋 Project Overview

### Business Context

Build a complete master-detail OAF application to manage organizational jobs and positions. This project demonstrates your mastery of all Level 101 concepts in a real-world scenario.

**Master-Detail Relationship:**
- **Master:** Jobs (e.g., "Oracle Technical Consultant", "Oracle Functional Consultant")
- **Detail:** Positions under each job (e.g., "Junior Consultant", "Senior Consultant", "Team Leader")

### Learning Objectives

By completing this project, you will demonstrate ability to:
- ✅ Design and implement complete database schema with relationships
- ✅ Build Entity Objects with proper validations
- ✅ Create View Objects (updatable and read-only)
- ✅ Implement View Links for master-detail coordination
- ✅ Design professional user interfaces with all standard widgets
- ✅ Implement complete CRUD operations (Create, Read, Update, Delete)
- ✅ Handle user events with Controller logic
- ✅ Deploy OAF application to E-Business Suite
- ✅ Test and debug application thoroughly

---

## 🗄️ Database Schema

### Tables Design

#### Table 1: XX_JOBS (Master Table)

Stores job definitions with head count tracking and effective dating.

**Columns:**

| Column Name | Data Type | Null? | Description |
|------------|-----------|-------|-------------|
| JOB_ID | NUMBER | NOT NULL | Primary Key, populated from sequence |
| JOB_NAME | VARCHAR2(240) | NOT NULL | Job title (unique) |
| JOB_HEAD_COUNT | NUMBER | NOT NULL | Total positions allowed for this job |
| EFFECTIVE_START_DATE | DATE | NOT NULL | Job becomes active from this date |
| EFFECTIVE_END_DATE | DATE | NULL | Job expires on this date (null = active) |
| CREATED_BY | NUMBER | NOT NULL | WHO column - user who created record |
| CREATION_DATE | DATE | NOT NULL | WHO column - when record was created |
| LAST_UPDATED_BY | NUMBER | NOT NULL | WHO column - user who last updated |
| LAST_UPDATE_DATE | DATE | NOT NULL | WHO column - when last updated |
| LAST_UPDATE_LOGIN | NUMBER | NULL | WHO column - login session ID |

**Constraints:**
- Primary Key: JOB_ID
- Unique Key: JOB_NAME
- Check: EFFECTIVE_START_DATE <= EFFECTIVE_END_DATE (if END_DATE not null)
- Check: JOB_HEAD_COUNT >= 0

#### Table 2: XX_POSITIONS (Detail Table)

Stores individual positions under each job with their own head counts.

**Columns:**

| Column Name | Data Type | Null? | Description |
|------------|-----------|-------|-------------|
| POSITION_ID | NUMBER | NOT NULL | Primary Key, populated from sequence |
| JOB_ID | NUMBER | NOT NULL | Foreign Key to XX_JOBS |
| POSITION_NAME | VARCHAR2(240) | NOT NULL | Position title |
| POSITION_HEAD_COUNT | NUMBER | NOT NULL | Number of openings for this position |
| EFFECTIVE_START_DATE | DATE | NOT NULL | Position becomes active from this date |
| EFFECTIVE_END_DATE | DATE | NULL | Position expires on this date |
| CREATED_BY | NUMBER | NOT NULL | WHO column - user who created record |
| CREATION_DATE | DATE | NOT NULL | WHO column - when record was created |
| LAST_UPDATED_BY | NUMBER | NOT NULL | WHO column - user who last updated |
| LAST_UPDATE_DATE | DATE | NOT NULL | WHO column - when last updated |
| LAST_UPDATE_LOGIN | NUMBER | NULL | WHO column - login session ID |

**Constraints:**
- Primary Key: POSITION_ID
- Foreign Key: JOB_ID references XX_JOBS(JOB_ID)
- Unique Key: (JOB_ID, POSITION_NAME)
- Check: EFFECTIVE_START_DATE <= EFFECTIVE_END_DATE (if END_DATE not null)
- Check: POSITION_HEAD_COUNT >= 0

### Sequences

```sql
-- Sequence for XX_JOBS.JOB_ID
CREATE SEQUENCE XX_JOB_ID_SEQ
  START WITH 1000
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

-- Sequence for XX_POSITIONS.POSITION_ID
CREATE SEQUENCE XX_POSITION_ID_SEQ
  START WITH 1000
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
```

### Database Scripts

#### DDL Script (Create Tables)

```sql
-- =====================================================
-- Level 101 Capstone Project: Jobs & Positions
-- DDL Script - Table Creation
-- =====================================================

-- Drop existing tables (if recreating)
DROP TABLE XX_POSITIONS CASCADE CONSTRAINTS;
DROP TABLE XX_JOBS CASCADE CONSTRAINTS;
DROP SEQUENCE XX_JOB_ID_SEQ;
DROP SEQUENCE XX_POSITION_ID_SEQ;

-- Create XX_JOBS table (Master)
CREATE TABLE XX_JOBS (
    JOB_ID                NUMBER          NOT NULL,
    JOB_NAME              VARCHAR2(240)   NOT NULL,
    JOB_HEAD_COUNT        NUMBER          NOT NULL,
    EFFECTIVE_START_DATE  DATE            NOT NULL,
    EFFECTIVE_END_DATE    DATE            NULL,
    CREATED_BY            NUMBER          NOT NULL,
    CREATION_DATE         DATE            NOT NULL,
    LAST_UPDATED_BY       NUMBER          NOT NULL,
    LAST_UPDATE_DATE      DATE            NOT NULL,
    LAST_UPDATE_LOGIN     NUMBER          NULL,
    CONSTRAINT XX_JOBS_PK PRIMARY KEY (JOB_ID),
    CONSTRAINT XX_JOBS_UK1 UNIQUE (JOB_NAME),
    CONSTRAINT XX_JOBS_CHK1 CHECK (JOB_HEAD_COUNT >= 0),
    CONSTRAINT XX_JOBS_CHK2 CHECK (
        EFFECTIVE_END_DATE IS NULL OR 
        EFFECTIVE_START_DATE <= EFFECTIVE_END_DATE
    )
);

-- Create XX_POSITIONS table (Detail)
CREATE TABLE XX_POSITIONS (
    POSITION_ID           NUMBER          NOT NULL,
    JOB_ID                NUMBER          NOT NULL,
    POSITION_NAME         VARCHAR2(240)   NOT NULL,
    POSITION_HEAD_COUNT   NUMBER          NOT NULL,
    EFFECTIVE_START_DATE  DATE            NOT NULL,
    EFFECTIVE_END_DATE    DATE            NULL,
    CREATED_BY            NUMBER          NOT NULL,
    CREATION_DATE         DATE            NOT NULL,
    LAST_UPDATED_BY       NUMBER          NOT NULL,
    LAST_UPDATE_DATE      DATE            NOT NULL,
    LAST_UPDATE_LOGIN     NUMBER          NULL,
    CONSTRAINT XX_POSITIONS_PK PRIMARY KEY (POSITION_ID),
    CONSTRAINT XX_POSITIONS_FK1 FOREIGN KEY (JOB_ID) 
        REFERENCES XX_JOBS(JOB_ID) ON DELETE CASCADE,
    CONSTRAINT XX_POSITIONS_UK1 UNIQUE (JOB_ID, POSITION_NAME),
    CONSTRAINT XX_POSITIONS_CHK1 CHECK (POSITION_HEAD_COUNT >= 0),
    CONSTRAINT XX_POSITIONS_CHK2 CHECK (
        EFFECTIVE_END_DATE IS NULL OR 
        EFFECTIVE_START_DATE <= EFFECTIVE_END_DATE
    )
);

-- Create Sequences
CREATE SEQUENCE XX_JOB_ID_SEQ
  START WITH 1000
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE XX_POSITION_ID_SEQ
  START WITH 1000
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

-- Create Indexes for Performance
CREATE INDEX XX_POSITIONS_N1 ON XX_POSITIONS(JOB_ID);
CREATE INDEX XX_JOBS_N1 ON XX_JOBS(JOB_NAME);

COMMIT;
```

#### DML Script (Sample Data)

```sql
-- =====================================================
-- Level 101 Capstone Project: Jobs & Positions
-- DML Script - Sample Data
-- =====================================================

-- Insert Jobs (Master Records)
INSERT INTO XX_JOBS (
    JOB_ID, JOB_NAME, JOB_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_JOB_ID_SEQ.NEXTVAL,
    'Oracle Technical Consultant',
    10,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_JOBS (
    JOB_ID, JOB_NAME, JOB_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_JOB_ID_SEQ.NEXTVAL,
    'Oracle Functional Consultant',
    8,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_JOBS (
    JOB_ID, JOB_NAME, JOB_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_JOB_ID_SEQ.NEXTVAL,
    'Database Administrator',
    5,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

-- Insert Positions for Technical Consultant (Detail Records)
INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Oracle Technical Consultant'),
    'Junior Technical Consultant',
    4,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Oracle Technical Consultant'),
    'Senior Technical Consultant',
    4,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Oracle Technical Consultant'),
    'Technical Team Lead',
    2,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

-- Insert Positions for Functional Consultant
INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Oracle Functional Consultant'),
    'Junior Functional Consultant',
    3,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Oracle Functional Consultant'),
    'Senior Functional Consultant',
    5,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

-- Insert Positions for Database Administrator
INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Database Administrator'),
    'Junior DBA',
    2,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT,
    EFFECTIVE_START_DATE, EFFECTIVE_END_DATE,
    CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT JOB_ID FROM XX_JOBS WHERE JOB_NAME = 'Database Administrator'),
    'Senior DBA',
    3,
    SYSDATE,
    NULL,
    0, SYSDATE, 0, SYSDATE
);

COMMIT;

-- Verification Queries
SELECT 'Total Jobs:', COUNT(*) FROM XX_JOBS;
SELECT 'Total Positions:', COUNT(*) FROM XX_POSITIONS;

SELECT j.job_name, COUNT(p.position_id) as position_count
FROM XX_JOBS j
LEFT JOIN XX_POSITIONS p ON j.job_id = p.job_id
GROUP BY j.job_name
ORDER BY j.job_name;
```

---

## 🏗️ Application Architecture

### Package Structure

```
oracle.apps.xx.jobmgmt
├── server/
│   ├── JobEO.xml                    # Entity Object for XX_JOBS
│   ├── JobEOImpl.java
│   ├── PositionEO.xml               # Entity Object for XX_POSITIONS
│   ├── PositionEOImpl.java
│   ├── JobVO.xml                    # View Object for Jobs (updatable)
│   ├── JobVOImpl.java
│   ├── PositionVO.xml               # View Object for Positions (updatable)
│   ├── PositionVOImpl.java
│   ├── JobPositionVL.xml            # View Link (Master-Detail)
│   └── JobMgmtAM.xml                # Application Module
│       └── JobMgmtAMImpl.java
└── webui/
    ├── JobSearchPG.xml              # Search Page
    ├── JobSearchCO.java             # Search Controller
    ├── JobDetailsPG.xml             # Create/Update Page
    ├── JobDetailsCO.java            # Details Controller
    ├── PositionMaintPG.xml          # Master-Detail Page
    └── PositionMaintCO.java         # Master-Detail Controller
```

### Naming Conventions

Follow Oracle OAF naming standards:

- **Entity Objects:** `<Entity>EO` (e.g., JobEO, PositionEO)
- **View Objects:** `<Entity>VO` (e.g., JobVO, PositionVO)
- **View Links:** `<Master><Detail>VL` (e.g., JobPositionVL)
- **Application Module:** `<Module>AM` (e.g., JobMgmtAM)
- **Pages:** `<Function>PG` (e.g., JobSearchPG, JobDetailsPG)
- **Controllers:** `<Function>CO` (e.g., JobSearchCO, JobDetailsCO)

### Component Relationships

```
JobMgmtAM (Application Module)
├── JobVO (View Object - Master)
│   └── Based on: JobEO (Entity Object)
└── PositionVO (View Object - Detail)
    ├── Based on: PositionEO (Entity Object)
    └── Linked via: JobPositionVL (View Link on JOB_ID)
```

---

## 📝 Functional Requirements

### Module 1: Job Search & Browse

**Page:** JobSearchPG  
**Function:** Search and list all jobs with basic details

**Features:**
1. **Search Region:**
   - Job Name (text input with partial match)
   - Effective Date Range (from/to date fields)
   - Search button
   - Clear button

2. **Results Table:**
   - Job Name (clickable link to details)
   - Job Head Count
   - Effective Start Date
   - Effective End Date
   - Total Positions (count of related positions)
   - Actions: Edit, Delete

3. **Actions:**
   - Create Job button (navigates to JobDetailsPG in create mode)
   - Export to Excel button

### Module 2: Job Details (Create/Update)

**Page:** JobDetailsPG  
**Function:** Create new job or update existing job

**Features:**
1. **Form Fields:**
   - Job Name (required, text input, max 240 chars)
   - Job Head Count (required, number input, min 0)
   - Effective Start Date (required, date picker, default today)
   - Effective End Date (optional, date picker)

2. **Validations:**
   - Job Name must be unique
   - Job Head Count >= 0
   - End Date must be >= Start Date (if provided)
   - All required fields must be filled

3. **Actions:**
   - Apply button (save and stay on page)
   - Save and Close button (save and return to search)
   - Cancel button (return without saving)

4. **Messages:**
   - Success: "Job '<Name>' has been saved successfully"
   - Error: Display appropriate error messages

### Module 3: Position Maintenance (Master-Detail)

**Page:** PositionMaintPG  
**Function:** Maintain positions under a specific job

**Features:**
1. **Master Section (Read-Only):**
   - Display selected Job details
   - Job Name
   - Job Head Count
   - Effective Dates

2. **Detail Section (Editable Table):**
   - Position Name (required)
   - Position Head Count (required, number)
   - Effective Start Date (required)
   - Effective End Date (optional)
   - Actions: Add Row, Delete Row

3. **Validations:**
   - Position Name must be unique within the job
   - Position Head Count >= 0
   - Sum of all position head counts should not exceed job head count (warning)
   - End Date >= Start Date

4. **Actions:**
   - Add Position button
   - Delete Position button (with confirmation)
   - Save All button
   - Cancel button

### Business Rules

1. **Job Deletion:**
   - Can only delete job if no active positions exist
   - Display confirmation dialog before deletion
   - Cascade delete positions if forcing deletion

2. **Date Validation:**
   - Cannot create position with dates outside job's date range
   - Warning if position remains active after job expires

3. **Head Count:**
   - Display warning if total position head count exceeds job head count
   - Allow override with warning acknowledgment

4. **Concurrency:**
   - Handle concurrent updates with optimistic locking
   - Display message if record changed by another user

---

## 🛠️ Implementation Phases (20-Day Schedule)

### Week 1: Database Foundation & Entity Layer (Days 1-5)

#### Day 1-2: Database Setup & Understanding
**Scaffold Level: Maximum**

**Tasks:**
- Execute DDL script to create tables and sequences
- Execute DML script to load sample data
- Write and execute SQL queries to explore data
- Understand table relationships and constraints

**Deliverables:**
- ✅ Tables created successfully
- ✅ Sample data loaded
- ✅ SQL queries document (SELECT, JOIN examples)
- ✅ Screenshot of data in SQL Developer

**Scaffolding Provided:**
- Complete DDL/DML scripts provided above
- Sample SQL queries for reference
- Database diagram
- Step-by-step setup guide

---

#### Day 3-5: Entity Objects with Association
**Scaffold Level: High**

**Tasks:**
- Create JobEO mapped to XX_JOBS table
- Implement sequence population for JOB_ID
- Add validations (required fields, date range, head count >= 0)
- Create PositionEO mapped to XX_POSITIONS table
- Implement sequence population for POSITION_ID
- Add validations
- Create Entity Association between JobEO and PositionEO
- Test all EOs using BC4J tester

**Deliverables:**
- ✅ JobEO created with all validations
- ✅ PositionEO created with all validations
- ✅ Entity Association defined
- ✅ BC4J tester results showing CRUD operations

**Scaffolding Provided:**
- EO creation wizard guide
- Validation code templates
- Association setup steps
- Testing checklist

**Common Issues to Avoid:**
- Forgetting to set sequence as DBSequence
- Not mapping WHO columns correctly
- Missing required validations

---

### Week 2: View Objects & Application Module & First UI (Days 6-10)

#### Day 6-7: View Objects & View Link
**Scaffold Level: High → Moderate**

**Tasks:**
- Create JobVO (updatable, based on JobEO)
- Configure query for active jobs
- Create PositionVO (updatable, based on PositionEO)
- Create JobPositionVL (View Link) for master-detail
- Configure master-detail coordination
- Test View Link in BC4J tester

**Deliverables:**
- ✅ JobVO created and tested
- ✅ PositionVO created and tested
- ✅ View Link coordinates master-detail correctly
- ✅ Test results showing position filtering by job

**Scaffolding Provided:**
- VO creation wizard guide
- View Link setup instructions
- Master-detail testing scenarios

---

#### Day 8: Application Module
**Scaffold Level: Moderate**

**Tasks:**
- Create JobMgmtAM
- Add JobVO to data model
- Add PositionVO to data model
- Configure View Link in AM
- Test complete model in BC4J tester

**Deliverables:**
- ✅ JobMgmtAM created
- ✅ All VOs added to data model
- ✅ Complete model tested successfully

**Scaffolding Provided:**
- AM creation checklist
- Data model configuration guide
- Comprehensive testing scenarios

---

#### Day 9-10: First UI Page (JobSearchPG)
**Scaffold Level: Moderate**

**Tasks:**
- Create JobSearchPG page
- Add query region with search fields
- Add results table with job columns
- Attach JobMgmtAM to page
- Bind UI components to VO attributes
- Run page and verify data displays

**Deliverables:**
- ✅ JobSearchPG displays job data
- ✅ Search region visible (functionality later)
- ✅ Results table shows all jobs
- ✅ Screenshot of running page

**Scaffolding Provided:**
- Page creation wizard guide
- Region layout templates
- Attribute binding examples
- Troubleshooting guide

---

### Week 3: Controllers & CRUD Operations (Days 11-15)

#### Day 11-12: Search & Create Operations
**Scaffold Level: Moderate → Minimal**

**Tasks:**
- Create JobSearchCO controller
- Implement search functionality (processFormRequest)
- Add Create button navigation
- Create JobDetailsPG (form page)
- Add form fields for job attributes
- Create JobDetailsCO controller
- Implement create/insert logic
- Add Save and Cancel buttons

**Deliverables:**
- ✅ Search functionality working
- ✅ Create new job working
- ✅ Navigation between pages working
- ✅ Data saves to database

**Scaffolding Provided:**
- Controller method templates
- Navigation patterns
- Parameter passing examples
- Partial code snippets

---

#### Day 13: Update Functionality
**Scaffold Level: Minimal**

**Tasks:**
- Add Edit link/button in search results
- Pass JOB_ID to details page
- Load existing job data in JobDetailsPG
- Implement update logic in controller
- Handle WHO columns for updates
- Test update functionality

**Deliverables:**
- ✅ Edit navigation working
- ✅ Form populates with existing data
- ✅ Updates save correctly
- ✅ WHO columns updated properly

**Scaffolding Provided:**
- High-level steps only
- Parameter passing reference
- WHO column update pattern

---

#### Day 14-15: Delete Functionality
**Scaffold Level: Minimal**

**Tasks:**
- Add Delete button in search results
- Implement confirmation dialog
- Check for dependent positions before delete
- Implement delete logic in controller
- Handle exceptions and errors
- Display success/error messages

**Deliverables:**
- ✅ Delete button with confirmation dialog
- ✅ Business rule validation (check positions)
- ✅ Delete working correctly
- ✅ Appropriate messages displayed

**Scaffolding Provided:**
- Confirmation dialog example
- Exception handling pattern
- Message display reference

---

### Week 4: Master-Detail, Testing & Deployment (Days 16-20)

#### Day 16-18: PositionMaintPG (Master-Detail)
**Scaffold Level: Minimal**

**Tasks:**
- Design master-detail page layout
- Create PositionMaintPG with two regions:
  - Master region (job details, read-only)
  - Detail region (positions table, editable)
- Configure View Link for coordination
- Create PositionMaintCO controller
- Implement add position functionality
- Implement delete position functionality
- Implement save all positions
- Handle validations (unique name, head count, dates)

**Deliverables:**
- ✅ Master-detail page working
- ✅ View Link coordinates data correctly
- ✅ Add/Delete positions working
- ✅ All validations enforced
- ✅ Save functionality complete

**Scaffolding Provided:**
- Architecture guidance
- View Link reference
- Optional consultation sessions

---

#### Day 19: Comprehensive Testing & Bug Fixing
**Scaffold Level: Independent**

**Tasks:**
- Execute all test scenarios
- Test CRUD operations for jobs
- Test CRUD operations for positions
- Test master-detail coordination
- Test validations and business rules
- Test error handling
- Test concurrent user scenarios
- Document and fix all bugs

**Deliverables:**
- ✅ Test execution report
- ✅ Bug list with fixes
- ✅ All test cases passing
- ✅ Testing documentation

**Test Scenarios Provided:**
- Comprehensive test case list
- Expected results
- Edge cases to test

---

#### Day 20: Deployment to E-Business Suite
**Scaffold Level: Guided**

**Tasks:**
- Export project to .jpx file
- Deploy to EBS environment
- Create function definitions
- Add to menu
- Assign to responsibility
- Test in EBS environment
- Document deployment steps

**Deliverables:**
- ✅ Application deployed to EBS
- ✅ Function accessible from menu
- ✅ All functionality works in EBS
- ✅ Deployment documentation

**Scaffolding Provided:**
- Deployment step-by-step guide
- Function registration instructions
- Troubleshooting checklist

---

## ✅ Testing & Quality Assurance

### Test Scenarios

#### Job Management Tests

| Test ID | Scenario | Expected Result | Status |
|---------|----------|-----------------|--------|
| T01 | Create new job with valid data | Job saved successfully, message displayed | ☐ |
| T02 | Create job with duplicate name | Error message: "Job name already exists" | ☐ |
| T03 | Create job with negative head count | Error message: "Head count must be >= 0" | ☐ |
| T04 | Create job with end date < start date | Error message: "End date must be after start date" | ☐ |
| T05 | Update existing job | Changes saved, WHO columns updated | ☐ |
| T06 | Delete job with no positions | Job deleted successfully | ☐ |
| T07 | Delete job with active positions | Error or warning displayed | ☐ |
| T08 | Search jobs by name (partial match) | Matching jobs displayed | ☐ |
| T09 | Search jobs by date range | Jobs within range displayed | ☐ |
| T10 | Navigate from search to create | JobDetailsPG opens in create mode | ☐ |

#### Position Management Tests

| Test ID | Scenario | Expected Result | Status |
|---------|----------|-----------------|--------|
| T11 | Add new position to job | Position saved and appears in table | ☐ |
| T12 | Add position with duplicate name | Error: "Position name must be unique" | ☐ |
| T13 | Add position with negative head count | Error: "Head count must be >= 0" | ☐ |
| T14 | Delete position | Position removed from table | ☐ |
| T15 | Update position details | Changes saved correctly | ☐ |
| T16 | Master-detail coordination | Positions filter by selected job | ☐ |
| T17 | Total head count exceeds job | Warning message displayed | ☐ |
| T18 | Position dates outside job dates | Warning or error displayed | ☐ |

#### System Tests

| Test ID | Scenario | Expected Result | Status |
|---------|----------|-----------------|--------|
| T19 | Concurrent job update | Second user sees appropriate message | ☐ |
| T20 | Cancel without saving | No data changes persisted | ☐ |
| T21 | Required field validation | Error if required field empty | ☐ |
| T22 | WHO columns population | Correct user ID and timestamps | ☐ |
| T23 | Navigation breadcrumbs | Breadcrumb trail displays correctly | ☐ |
| T24 | Error message display | User-friendly messages shown | ☐ |

### Quality Checklist

**Code Quality:**
- [ ] Follows Oracle OAF naming conventions
- [ ] Proper package structure
- [ ] Code comments for complex logic
- [ ] No hardcoded values (use constants)
- [ ] Exception handling implemented
- [ ] WHO columns maintained correctly

**Functionality:**
- [ ] All CRUD operations work
- [ ] Validations enforced
- [ ] Business rules implemented
- [ ] Master-detail coordination working
- [ ] Navigation flows correctly

**UI/UX:**
- [ ] Professional layout and alignment
- [ ] Consistent styling
- [ ] Clear labels and instructions
- [ ] Appropriate messages
- [ ] Responsive design

**Documentation:**
- [ ] Code comments
- [ ] README file
- [ ] Test results document
- [ ] Deployment instructions

---

## 📊 Assessment & Grading

### Grading Rubric (100 Points Total)

#### 1. Functionality (40 points)
- **Job CRUD Operations (15 points)**
  - Create: 5 points
  - Update: 4 points
  - Delete: 3 points
  - Search: 3 points

- **Position Management (15 points)**
  - Add positions: 5 points
  - Update positions: 4 points
  - Delete positions: 3 points
  - Master-detail coordination: 3 points

- **Validations (10 points)**
  - Field validations: 5 points
  - Business rules: 5 points

#### 2. Code Quality (30 points)
- **Architecture (10 points)**
  - Proper MVC separation
  - Component organization
  - Package structure

- **Standards (10 points)**
  - Naming conventions
  - Code formatting
  - No hardcoded values

- **Best Practices (10 points)**
  - Exception handling
  - Transaction management
  - Reusable code

#### 3. User Interface (20 points)
- **Layout & Design (10 points)**
  - Professional appearance
  - Consistent styling
  - Proper alignment

- **Usability (10 points)**
  - Intuitive navigation
  - Clear labels
  - Helpful messages

#### 4. Documentation (10 points)
- **Code Comments (5 points)**
- **Test Documentation (3 points)**
- **README File (2 points)**

### Grading Scale

| Score | Grade | Performance Level |
|-------|-------|-------------------|
| 90-100 | A | Excellent - Exceeds expectations |
| 80-89 | B | Good - Meets all requirements |
| 70-79 | C | Satisfactory - Meets most requirements |
| 60-69 | D | Needs Improvement - Missing key features |
| <60 | F | Unsatisfactory - Significant issues |

---

## 📚 Resources & Support

### Reference Materials

1. **Oracle Documentation:**
   - OAF Developer's Guide
   - JDeveloper 10g Documentation
   - BC4J Framework Guide

2. **Course Materials:**
   - Section 2-6 Lecture Notes
   - Lab exercises from previous sections
   - Code examples library

3. **Sample Code:**
   - Hello World page
   - Simple CRUD example
   - Master-detail example from Section 6B

### Getting Help

**Tier 1: Self-Service (Try First)**
- Review course lecture notes
- Check LABS.md for similar exercises
- Search Oracle documentation
- Review previous lab solutions

**Tier 2: Peer Support**
- Form study groups
- Code review sessions
- Discussion forum
- Pair programming

**Tier 3: Instructor Support**
- Office hours (scheduled)
- Email questions (24-48hr response)
- Architecture review sessions
- Debugging assistance

**Support Guidelines:**
- Try independently first (growth mindset)
- Document what you've tried before asking
- Be specific with questions
- Share code snippets for debugging help

---

## 🎯 Success Tips

### Time Management

**Week 1 (Database & Model):**
- Don't rush - solid foundation is critical
- Test each EO thoroughly before proceeding
- Understand relationships before coding

**Week 2 (View Layer):**
- Reference Section 5 materials extensively
- Test VOs independently before UI
- Master-detail is key - spend time here

**Week 3 (Controller Logic):**
- Review Section 6 controller patterns
- Code incrementally - test each feature
- Handle errors gracefully

**Week 4 (Testing & Deployment):**
- Start testing early, not just Day 19
- Fix bugs as you find them
- Document deployment steps as you go

### Common Pitfalls to Avoid

1. **Skipping BC4J Testing:** Always test model independently before UI
2. **Hardcoded Values:** Use constants and configuration
3. **Poor Error Handling:** Always handle exceptions
4. **Ignoring WHO Columns:** Critical for audit trail
5. **Weak Validations:** Enforce all business rules
6. **Inconsistent Naming:** Follow standards religiously
7. **Last-Minute Testing:** Test continuously throughout

### Study Group Recommendations

- Meet 2-3 times per week
- Code reviews before major milestones
- Share debugging strategies
- Practice explaining your code
- Mock presentations for final demo

---

## 📤 Submission Requirements

### What to Submit

1. **Source Code Package:**
   - Complete project export (.jpx file)
   - All Java files (.java)
   - All XML files (.xml)
   - README.md with setup instructions

2. **Database Scripts:**
   - DDL script (table creation)
   - DML script (sample data)
   - Any custom scripts you created

3. **Documentation:**
   - Test execution report (all test cases)
   - Bug fix log (issues found and resolved)
   - Deployment guide (step-by-step)
   - Brief reflection (1-2 pages)

4. **Screenshots/Demo:**
   - Key pages running (4-5 screenshots)
   - Video demo (5-10 minutes, optional but recommended)

### Submission Format

```
StudentName_Level101_JobsPositions/
├── source/
│   ├── JobMgmt.jpx
│   └── oracle/apps/xx/jobmgmt/
│       ├── server/
│       └── webui/
├── database/
│   ├── DDL_XX_JOBS_POSITIONS.sql
│   └── DML_XX_JOBS_POSITIONS.sql
├── docs/
│   ├── README.md
│   ├── TestReport.pdf
│   ├── DeploymentGuide.pdf
│   └── Reflection.pdf
├── screenshots/
│   ├── JobSearchPage.png
│   ├── JobDetailsPage.png
│   ├── PositionMaintPage.png
│   └── ...
└── demo/ (optional)
    └── project_demo.mp4
```

### Submission Checklist

- [ ] All source code included
- [ ] Database scripts tested and working
- [ ] README with clear setup instructions
- [ ] All test cases documented
- [ ] Screenshots included
- [ ] Reflection completed
- [ ] Code follows naming conventions
- [ ] No syntax errors or warnings
- [ ] Application deploys successfully
- [ ] All CRUD operations work

### Deadline

**Due Date:** End of Week 4 (Day 20)  
**Late Policy:** 10% deduction per day, maximum 3 days

---

## 🎓 Learning Reflection

After completing the project, reflect on these questions:

1. **Technical Growth:**
   - What OAF concepts are you most confident with now?
   - What areas need more practice?
   - What was the most challenging technical aspect?

2. **Problem-Solving:**
   - Describe a significant bug you encountered and how you solved it
   - What debugging techniques were most effective?
   - How did you approach unfamiliar problems?

3. **Best Practices:**
   - Which coding standards were hardest to follow? Why?
   - How did proper architecture help (or hurt) development?
   - What would you do differently next time?

4. **Collaboration:**
   - How did peer support help your learning?
   - What role did you play in your study group?
   - How did you contribute to others' learning?

5. **Next Steps:**
   - What advanced topics are you excited to learn?
   - How will you apply this knowledge?
   - What additional practice do you need?

---

## 📞 Contact & Support

**Project Coordinator:** Demasy Labs Instructional Team  
**Office Hours:** Posted in LMS  
**Email:** support@demasylabs.com  
**Discussion Forum:** Available in course portal

---

**Good luck with your capstone project! This is your opportunity to showcase everything you've learned in Level 101. Take it seriously, ask for help when needed, and be proud of what you build!** 🚀

---

*Last Updated: January 24, 2026*  
*Version: 1.0*  
*Document: PROJECT_LEVEL_101.md*
