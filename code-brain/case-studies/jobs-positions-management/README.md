# Jobs & Positions Management System
## Complete OAF Case Study - Master-Detail Implementation

**Version**: 1.4.0  
**Based on**: demasylabs-barin/brain-repo/docs/Getting Started - OAF Project Scripts  
**Complexity**: Advanced  
**Learning Outcomes**: Master-detail relationships, Entity Associations, Complex Validations, WHO columns  

---

## 📋 Overview

This case study demonstrates a complete OAF implementation of a Jobs and Positions Management System with master-detail relationships. It's based on real-world training materials from the demasylabs-barin brain repository and follows Oracle OAF Framework best practices.

### Business Scenario

An organization needs to manage its job structure and positions hierarchy:
- **Jobs** represent roles in the organization (e.g., Oracle Technical Consultant, Java Developer)
- **Positions** represent levels within each job (e.g., Junior, Senior, Team Leader)
- Each job can have multiple positions (1:N relationship)
- Business rules enforce data integrity and date range validations

### Key Features

✅ **Master-Detail Relationship**: Jobs (Master) → Positions (Detail)  
✅ **Entity Associations**: Bidirectional navigation between Job and Position  
✅ **Complex Validations**: Date ranges, head counts, referential integrity  
✅ **WHO Columns**: Audit trail (Created By, Last Updated By, etc.)  
✅ **Sequence Management**: Auto-generated primary keys  
✅ **MessageHelper Integration**: Centralized error messages (v1.4.0)  
✅ **Production-Ready Code**: Comprehensive JavaDoc, error handling  

---

## 📁 Case Study Structure

```
jobs-positions-management/
├── JobEOImpl.java                  # Job Entity Object (Master)
├── PositionEOImpl.java             # Position Entity Object (Detail)
├── XX_JOB_POSITIONS_DDL.sql        # Database schema (tables, sequences, constraints)
├── XX_JOB_POSITIONS_DML.sql        # Sample data (8 jobs, 25 positions)
├── README.md                        # This file
└── (Additional files to be added)
    ├── JobVOImpl.java              # Job View Object
    ├── PositionVOImpl.java         # Position View Object
    ├── JobPositionVLImpl.java      # View Link
    ├── JobMgmtAMImpl.java          # Application Module
    └── Controllers/                # Page controllers
```

---

## 🗄️ Database Schema

### Tables

**XX_JOBS** (Master Table)
```sql
JOB_ID                 NUMBER        PK (from sequence)
JOB_NAME               VARCHAR2(200) NOT NULL UNIQUE
JOB_HEAD_COUNT         NUMBER        CHECK (> 0)
EFFECTIVE_START_DATE   DATE          NOT NULL
EFFECTIVE_END_DATE     DATE          NULL (NULL = active)
-- WHO columns (5)
```

**XX_POSITIONS** (Detail Table)
```sql
POSITION_ID            NUMBER        PK (from sequence)
JOB_ID                 NUMBER        FK to XX_JOBS (CASCADE DELETE)
POSITION_NAME          VARCHAR2(200) NOT NULL
POSITION_HEAD_COUNT    NUMBER        CHECK (> 0)
EFFECTIVE_START_DATE   DATE          NOT NULL
EFFECTIVE_END_DATE     DATE          NULL
-- WHO columns (5)
```

### Sequences

- `XX_JOB_ID_SEQ` - Auto-increment for Job IDs
- `XX_POSITION_ID_SEQ` - Auto-increment for Position IDs

### Constraints

- **Primary Keys**: On JOB_ID and POSITION_ID
- **Foreign Key**: POSITION.JOB_ID → JOB.JOB_ID (ON DELETE CASCADE)
- **Unique**: JOB_NAME must be unique
- **Check**: Head counts > 0, End Date >= Start Date

---

## 📊 Sample Data

### Jobs (8 records)

| Job ID | Job Name | Head Count | Status |
|--------|----------|------------|--------|
| 1 | Oracle Technical Consultant | 50 | Active |
| 2 | Oracle Functional Consultant | 40 | Active |
| 3 | Java Developer | 30 | Active |
| 4 | Database Administrator | 20 | Active |
| 5 | Business Analyst | 25 | Active |
| 6 | Project Manager | 15 | Active |
| 7 | Quality Assurance Engineer | 20 | Active |
| 8 | System Administrator | 10 | Inactive (ended 2023-12-31) |

### Positions (25+ records)

**Example: Oracle Technical Consultant (Job ID 1)**
- Junior Oracle Technical Consultant (15 headcount)
- Experienced Oracle Technical Consultant (20 headcount)
- Senior Oracle Technical Consultant (10 headcount)
- Technical Team Leader (5 headcount)

Each job has 3-4 position levels with varying headcounts totaling up to the job's total headcount.

---

## 🔧 Installation & Setup

### Step 1: Create Database Objects

```sql
-- Run DDL script as APPS user
@XX_JOB_POSITIONS_DDL.sql

-- Verify table creation
SELECT table_name, num_rows FROM user_tables 
WHERE table_name IN ('XX_JOBS', 'XX_POSITIONS');
```

### Step 2: Load Sample Data

```sql
-- Run DML script
@XX_JOB_POSITIONS_DML.sql

-- Verify data
SELECT COUNT(*) FROM XX_JOBS;      -- Should return 8
SELECT COUNT(*) FROM XX_POSITIONS;  -- Should return 25+
```

### Step 3: Register Message Codes

```sql
-- Run from main repository root
@MESSAGE_REGISTRATION.sql

-- Load messages via Application Developer responsibility
-- Navigate to: Tools > Load Messages from File (FND_NEW_MESSAGES)
```

### Step 4: Create JDeveloper Project

1. Create new OA Workspace: `JobMgmt`
2. Create new OA Project: `JobMgmtModel`
3. Import Entity Objects:
   - JobEOImpl.java
   - PositionEOImpl.java
4. Create Entity Association: `JobPositionAssoc`
5. Continue with View Objects and AM...

---

## 💡 Business Rules

### Job Entity Rules

1. **Mandatory Fields**
   - Job Name (must be unique)
   - Effective Start Date

2. **Validations**
   - Job Head Count > 0 (range: 1-9999)
   - End Date >= Start Date (if provided)
   - Cannot have head count less than existing active positions

3. **Delete Restrictions**
   - Cannot delete job if active positions exist
   - Cascade delete applies if all positions are inactive

### Position Entity Rules

1. **Mandatory Fields**
   - Position Name
   - Job ID (must exist in XX_JOBS)
   - Effective Start Date

2. **Validations**
   - Position Head Count > 0 (range: 1-999)
   - End Date >= Start Date
   - **Date Range Constraint**: Position dates must be within Job's effective date range
     * Position Start Date >= Job Start Date
     * Position End Date <= Job End Date

3. **Referential Integrity**
   - Must be associated with a valid Job
   - If Job is deleted, positions are cascade deleted

---

## 📖 Code Highlights

### JobEOImpl.java (440+ lines)

**Key Methods**:
- `setJobName()` - Validates uniqueness and format
- `setJobHeadCount()` - Validates against existing positions
- `validateBeforeDelete()` - Prevents deletion with active positions
- `create()` - Sets WHO columns and generates PK from sequence
- `doDML()` - Updates WHO columns on every DML operation

**Features**:
- Bidirectional association with Positions
- Complex business rule validation
- Integration with MessageHelper for i18n errors
- Production-ready error handling

### PositionEOImpl.java (400+ lines)

**Key Methods**:
- `setJobId()` - Validates FK existence
- `validatePositionDateAgainstJob()` - Enforces date range constraint
- `setEffectiveStartDate/EndDate()` - Cross-field validation
- Association navigation to parent Job

**Features**:
- Master-detail integrity enforcement
- Date range validation against parent Job
- Automatic sequence number generation
- WHO columns management

---

## 🎓 Learning Objectives

After studying this case study, you will understand:

1. **Entity Objects**
   - Creating EOs from database tables
   - Implementing WHO columns
   - Writing custom validation logic
   - Overriding framework methods (create, doDML, validateEntity)

2. **Entity Associations**
   - 1:N relationships (Job to Positions)
   - Bidirectional navigation
   - Cascade delete behavior
   - Foreign key enforcement

3. **Validation Patterns**
   - Mandatory field validation
   - Cross-field validation
   - Range validation
   - Uniqueness validation
   - Date range validation
   - Parent-child date constraint validation

4. **Sequence Management**
   - Using Oracle sequences for PKs
   - SequenceImpl class usage
   - Auto-generation in create() method

5. **WHO Columns**
   - Standard audit columns
   - Setting values in create() and doDML()
   - Using transaction context

6. **Error Handling**
   - MessageHelper integration
   - MessageConstants usage
   - Token substitution in error messages
   - Multi-language support

---

## 🚀 Next Steps

### Recommended Order of Implementation

1. ✅ **Entity Objects** (COMPLETED)
   - JobEOImpl.java
   - PositionEOImpl.java
   - Database scripts

2. **View Objects** (TODO)
   - JobVOImpl.java - Updatable VO based on JobEO
   - PositionVOImpl.java - Updatable VO based on PositionEO
   - Custom queries for search functionality

3. **View Link** (TODO)
   - JobPositionVLImpl.java - Links JobVO and PositionVO
   - Master-detail coordination

4. **Application Module** (TODO)
   - JobMgmtAMImpl.java
   - CRUD methods for Jobs and Positions
   - Transaction management
   - Business logic methods

5. **Controllers** (TODO)
   - JobSearchCO.java - Search page with advanced queries
   - JobDetailsCO.java - CRUD operations
   - PositionMaintCO.java - Master-detail UI

6. **Pages** (TODO)
   - JobSearchPG - Table with search criteria
   - JobDetailsPG - Form for create/update
   - PositionMaintPG - Master-detail layout

---

## 📚 Related Documentation

- **[MessageHelper Guide](../../../MESSAGEHELPER_GUIDE.md)** - Error handling patterns
- **[MESSAGE_REGISTRATION.sql](../../../MESSAGE_REGISTRATION.sql)** - Message codes setup
- **[CHANGELOG.md](../../../CHANGELOG.md)** - Version 1.4.0 features
- **[code-brain README](../../README.md)** - Complete code brain documentation

---

## 🧪 Testing Scenarios

### Unit Tests

1. **Job Creation**
   - Create job with valid data
   - Validate mandatory fields
   - Test unique job name constraint
   - Test head count validation

2. **Position Creation**
   - Create position with valid job ID
   - Test date range against job dates
   - Test invalid job ID
   - Test head count validation

3. **Master-Detail Operations**
   - Create job with positions
   - Update job dates and validate positions
   - Delete job (should fail with active positions)
   - Delete job (should succeed with no positions)

4. **WHO Columns**
   - Verify creation timestamps
   - Verify update timestamps
   - Check user IDs populated correctly

### Integration Tests

1. **Search Functionality**
   - Search jobs by name
   - Search by effective dates
   - Search positions by job

2. **CRUD Operations**
   - Create → Read → Update → Delete cycle
   - Rollback scenarios
   - Concurrent updates

3. **Business Rules**
   - Position dates within job dates
   - Head count constraints
   - Cascade delete behavior

---

## 🐛 Troubleshooting

### Common Issues

**Issue**: ORA-02291 - Integrity constraint violated (POSITION.FK to JOB)  
**Solution**: Ensure Job ID exists before creating Position

**Issue**: Job deletion fails with "Active positions exist"  
**Solution**: Delete or inactivate all positions first

**Issue**: "Position Start Date before Job Start Date"  
**Solution**: Adjust job dates or position dates to be consistent

**Issue**: Message codes not found  
**Solution**: Run MESSAGE_REGISTRATION.sql and load via FND_NEW_MESSAGES

---

## 📞 Support

For questions or issues:
- **GitHub**: [Oracle-OAF-BootCamp Issues](https://github.com/demasylabs/Oracle-OAF-BootCamp/issues)
- **Reference**: demasylabs-barin/brain-repo/docs/Getting Started
- **Documentation**: See main README.md

---

## 🏆 Success Criteria

You've successfully completed this case study when you can:

✅ Explain the master-detail relationship between Jobs and Positions  
✅ Create entity objects with complex validations  
✅ Implement WHO columns and sequence generation  
✅ Write business rules that enforce data integrity  
✅ Use MessageHelper for centralized error handling  
✅ Navigate entity associations bidirectionally  
✅ Understand cascade delete behavior  
✅ Build on this foundation to create View Objects and Controllers  

---

**Status**: Foundation Complete (Entity Objects & Database)  
**Next Phase**: View Objects, View Links, Application Module  
**Version**: 1.4.0  
**Last Updated**: 2026-01-25
