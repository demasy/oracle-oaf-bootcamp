/*******************************************************************************
 * JOBS & POSITIONS MANAGEMENT SYSTEM
 * Database DDL Script
 * 
 * Purpose: Create tables, sequences, and indexes for Jobs & Positions
 *          Management System case study
 * 
 * Based on: demasylabs-barin/brain-repo/docs/Getting Started
 *          OAF Project DDL Script.sql
 * 
 * Tables Created:
 *  - XX_JOBS: Master table for organizational jobs
 *  - XX_POSITIONS: Detail table for positions within jobs
 * 
 * Sequences Created:
 *  - XX_JOB_ID_SEQ: Primary key sequence for XX_JOBS
 *  - XX_POSITION_ID_SEQ: Primary key sequence for XX_POSITIONS
 * 
 * Version: 1.4.0
 * Date: 2026-01-25
 * 
 ******************************************************************************/

-- Drop existing objects (clean install)
DROP SEQUENCE XX_POSITION_ID_SEQ;
DROP SEQUENCE XX_JOB_ID_SEQ;
DROP TABLE XX_POSITIONS CASCADE CONSTRAINTS PURGE;
DROP TABLE XX_JOBS CASCADE CONSTRAINTS PURGE;

--------------------------------------------------------------------------------
-- TABLE: XX_JOBS (Master Table)
--------------------------------------------------------------------------------

CREATE TABLE XX_JOBS (
    JOB_ID                  NUMBER          NOT NULL,
    JOB_NAME                VARCHAR2(200)   NOT NULL,
    JOB_HEAD_COUNT          NUMBER,
    EFFECTIVE_START_DATE    DATE            NOT NULL,
    EFFECTIVE_END_DATE      DATE,
    -- WHO Columns
    LAST_UPDATE_DATE        DATE            NOT NULL,
    LAST_UPDATED_BY         NUMBER          NOT NULL,
    LAST_UPDATE_LOGIN       NUMBER,
    CREATED_BY              NUMBER          NOT NULL,
    CREATION_DATE           DATE            NOT NULL
) TABLESPACE APPS_TS_TX_DATA;

-- Primary Key
ALTER TABLE XX_JOBS ADD CONSTRAINT XX_JOBS_PK 
    PRIMARY KEY (JOB_ID)
    USING INDEX TABLESPACE APPS_TS_TX_IDX;

-- Unique Constraint on Job Name
ALTER TABLE XX_JOBS ADD CONSTRAINT XX_JOBS_UK1 
    UNIQUE (JOB_NAME)
    USING INDEX TABLESPACE APPS_TS_TX_IDX;

-- Check Constraints
ALTER TABLE XX_JOBS ADD CONSTRAINT XX_JOBS_CHK1 
    CHECK (JOB_HEAD_COUNT > 0);

ALTER TABLE XX_JOBS ADD CONSTRAINT XX_JOBS_CHK2 
    CHECK (EFFECTIVE_END_DATE IS NULL OR EFFECTIVE_END_DATE >= EFFECTIVE_START_DATE);

-- Comments
COMMENT ON TABLE XX_JOBS IS 'Jobs & Positions Management System - Master table for organizational jobs';
COMMENT ON COLUMN XX_JOBS.JOB_ID IS 'Primary key - Job unique identifier';
COMMENT ON COLUMN XX_JOBS.JOB_NAME IS 'Job name (must be unique)';
COMMENT ON COLUMN XX_JOBS.JOB_HEAD_COUNT IS 'Number of positions allowed for this job';
COMMENT ON COLUMN XX_JOBS.EFFECTIVE_START_DATE IS 'Job effective start date';
COMMENT ON COLUMN XX_JOBS.EFFECTIVE_END_DATE IS 'Job effective end date (NULL = no end date)';

--------------------------------------------------------------------------------
-- TABLE: XX_POSITIONS (Detail Table)
--------------------------------------------------------------------------------

CREATE TABLE XX_POSITIONS (
    POSITION_ID             NUMBER          NOT NULL,
    JOB_ID                  NUMBER          NOT NULL,
    POSITION_NAME           VARCHAR2(200)   NOT NULL,
    POSITION_HEAD_COUNT     NUMBER,
    EFFECTIVE_START_DATE    DATE            NOT NULL,
    EFFECTIVE_END_DATE      DATE,
    -- WHO Columns
    LAST_UPDATE_DATE        DATE            NOT NULL,
    LAST_UPDATED_BY         NUMBER          NOT NULL,
    LAST_UPDATE_LOGIN       NUMBER,
    CREATED_BY              NUMBER          NOT NULL,
    CREATION_DATE           DATE            NOT NULL
) TABLESPACE APPS_TS_TX_DATA;

-- Primary Key
ALTER TABLE XX_POSITIONS ADD CONSTRAINT XX_POSITIONS_PK 
    PRIMARY KEY (POSITION_ID)
    USING INDEX TABLESPACE APPS_TS_TX_IDX;

-- Foreign Key to XX_JOBS
ALTER TABLE XX_POSITIONS ADD CONSTRAINT XX_POSITIONS_FK1 
    FOREIGN KEY (JOB_ID) REFERENCES XX_JOBS(JOB_ID)
    ON DELETE CASCADE;

-- Check Constraints
ALTER TABLE XX_POSITIONS ADD CONSTRAINT XX_POSITIONS_CHK1 
    CHECK (POSITION_HEAD_COUNT > 0);

ALTER TABLE XX_POSITIONS ADD CONSTRAINT XX_POSITIONS_CHK2 
    CHECK (EFFECTIVE_END_DATE IS NULL OR EFFECTIVE_END_DATE >= EFFECTIVE_START_DATE);

-- Indexes for performance
CREATE INDEX XX_POSITIONS_N1 ON XX_POSITIONS(JOB_ID)
    TABLESPACE APPS_TS_TX_IDX;

CREATE INDEX XX_POSITIONS_N2 ON XX_POSITIONS(EFFECTIVE_START_DATE, EFFECTIVE_END_DATE)
    TABLESPACE APPS_TS_TX_IDX;

-- Comments
COMMENT ON TABLE XX_POSITIONS IS 'Jobs & Positions Management System - Detail table for positions within jobs';
COMMENT ON COLUMN XX_POSITIONS.POSITION_ID IS 'Primary key - Position unique identifier';
COMMENT ON COLUMN XX_POSITIONS.JOB_ID IS 'Foreign key to XX_JOBS table';
COMMENT ON COLUMN XX_POSITIONS.POSITION_NAME IS 'Position name (e.g., Junior, Senior, Team Leader)';
COMMENT ON COLUMN XX_POSITIONS.POSITION_HEAD_COUNT IS 'Number of employees allowed for this position';
COMMENT ON COLUMN XX_POSITIONS.EFFECTIVE_START_DATE IS 'Position effective start date';
COMMENT ON COLUMN XX_POSITIONS.EFFECTIVE_END_DATE IS 'Position effective end date (NULL = no end date)';

--------------------------------------------------------------------------------
-- SEQUENCES
--------------------------------------------------------------------------------

-- Job ID Sequence
CREATE SEQUENCE XX_JOB_ID_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Position ID Sequence
CREATE SEQUENCE XX_POSITION_ID_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

--------------------------------------------------------------------------------
-- GRANTS
--------------------------------------------------------------------------------

-- Grant privileges to APPS schema
GRANT SELECT, INSERT, UPDATE, DELETE ON XX_JOBS TO APPS;
GRANT SELECT, INSERT, UPDATE, DELETE ON XX_POSITIONS TO APPS;
GRANT SELECT ON XX_JOB_ID_SEQ TO APPS;
GRANT SELECT ON XX_POSITION_ID_SEQ TO APPS;

-- Create synonyms in APPS schema
CREATE OR REPLACE SYNONYM APPS.XX_JOBS FOR XX_JOBS;
CREATE OR REPLACE SYNONYM APPS.XX_POSITIONS FOR XX_POSITIONS;
CREATE OR REPLACE SYNONYM APPS.XX_JOB_ID_SEQ FOR XX_JOB_ID_SEQ;
CREATE OR REPLACE SYNONYM APPS.XX_POSITION_ID_SEQ FOR XX_POSITION_ID_SEQ;

--------------------------------------------------------------------------------
-- VERIFICATION QUERIES
--------------------------------------------------------------------------------

-- Verify table creation
SELECT table_name, tablespace_name, num_rows
FROM user_tables
WHERE table_name IN ('XX_JOBS', 'XX_POSITIONS')
ORDER BY table_name;

-- Verify constraints
SELECT constraint_name, constraint_type, table_name, status
FROM user_constraints
WHERE table_name IN ('XX_JOBS', 'XX_POSITIONS')
ORDER BY table_name, constraint_type;

-- Verify indexes
SELECT index_name, table_name, uniqueness, status
FROM user_indexes
WHERE table_name IN ('XX_JOBS', 'XX_POSITIONS')
ORDER BY table_name, index_name;

-- Verify sequences
SELECT sequence_name, min_value, max_value, increment_by, cache_size, last_number
FROM user_sequences
WHERE sequence_name IN ('XX_JOB_ID_SEQ', 'XX_POSITION_ID_SEQ')
ORDER BY sequence_name;

/*******************************************************************************
 * VALIDATION QUERIES
 ******************************************************************************/

-- Test Job insertion
INSERT INTO XX_JOBS (
    JOB_ID, JOB_NAME, JOB_HEAD_COUNT, EFFECTIVE_START_DATE,
    LAST_UPDATE_DATE, LAST_UPDATED_BY, CREATED_BY, CREATION_DATE
) VALUES (
    XX_JOB_ID_SEQ.NEXTVAL, 
    'Test Job', 
    10, 
    SYSDATE,
    SYSDATE, 
    -1, 
    -1, 
    SYSDATE
);

-- Test Position insertion
INSERT INTO XX_POSITIONS (
    POSITION_ID, JOB_ID, POSITION_NAME, POSITION_HEAD_COUNT, EFFECTIVE_START_DATE,
    LAST_UPDATE_DATE, LAST_UPDATED_BY, CREATED_BY, CREATION_DATE
) VALUES (
    XX_POSITION_ID_SEQ.NEXTVAL,
    (SELECT MAX(JOB_ID) FROM XX_JOBS),
    'Test Position',
    5,
    SYSDATE,
    SYSDATE,
    -1,
    -1,
    SYSDATE
);

-- Verify master-detail relationship
SELECT 
    j.job_id,
    j.job_name,
    j.job_head_count,
    COUNT(p.position_id) as position_count,
    SUM(NVL(p.position_head_count, 0)) as total_position_headcount
FROM xx_jobs j
LEFT JOIN xx_positions p ON j.job_id = p.job_id
GROUP BY j.job_id, j.job_name, j.job_head_count;

-- Clean up test data
DELETE FROM XX_POSITIONS WHERE POSITION_NAME = 'Test Position';
DELETE FROM XX_JOBS WHERE JOB_NAME = 'Test Job';
COMMIT;

/*******************************************************************************
 * ADDITIONAL OBJECTS (OPTIONAL)
 ******************************************************************************/

-- Materialized View for reporting (optional)
CREATE MATERIALIZED VIEW XX_JOB_SUMMARY_MV
BUILD IMMEDIATE
REFRESH COMPLETE ON DEMAND
AS
SELECT 
    j.job_id,
    j.job_name,
    j.job_head_count,
    j.effective_start_date as job_start_date,
    j.effective_end_date as job_end_date,
    COUNT(p.position_id) as total_positions,
    SUM(CASE WHEN p.effective_end_date IS NULL OR p.effective_end_date >= SYSDATE 
             THEN 1 ELSE 0 END) as active_positions,
    SUM(NVL(p.position_head_count, 0)) as total_position_headcount
FROM xx_jobs j
LEFT JOIN xx_positions p ON j.job_id = p.job_id
GROUP BY j.job_id, j.job_name, j.job_head_count, 
         j.effective_start_date, j.effective_end_date;

-- Create index on MV
CREATE INDEX XX_JOB_SUMMARY_MV_N1 ON XX_JOB_SUMMARY_MV(JOB_ID);

-- Grant access
GRANT SELECT ON XX_JOB_SUMMARY_MV TO APPS;

/*******************************************************************************
 * END OF DDL SCRIPT
 ******************************************************************************/
