# Code Quality Guidelines for Oracle OAF BootCamp

## Overview

This document provides code quality standards and best practices for the Oracle Application Framework (OAF) BootCamp repository. These guidelines ensure consistency, maintainability, and educational value across all code examples and implementations.

## Purpose

1. **Educational Excellence**: Code examples must be clear, well-documented, and follow industry best practices
2. **Consistency**: All code should follow the same patterns and conventions
3. **Maintainability**: Code should be easy to understand, modify, and extend
4. **Quality Assurance**: Automated checks help maintain high standards

## Code Quality Standards

### 1. Java Code Standards

#### Naming Conventions

**Classes:**
- Use descriptive names ending in `Patterns`, `Examples`, `CO` (Controller), `AM` (Application Module), `VO` (View Object), or `EO` (Entity Object)
- Follow PascalCase: `EmployeeSearchCO`, `JobManagementAM`, `EmployeeVO`
- Use package structure: `oracle.apps.xx.{module}.{layer}`

**Methods:**
- Use clear verb-noun format: `executeQuery()`, `handleSaveButton()`, `validateJobName()`
- Follow camelCase convention
- Method names should describe their purpose

**Variables:**
- Use meaningful names: `rootAM`, `dialogPage`, `errorMsg`, `whereClause`
- Follow camelCase convention
- Avoid single-letter variables except in loops

#### Documentation Requirements

**File Header:**
```java
/*===========================================================================+
 | Oracle Applications Framework (OAF) - [Component Name]
 | 
 | USE CASE: [Brief description of what this code demonstrates]
 | LOCATION: [Where this code would be used - Controller/AM/EO/VO]
 | COMPLEXITY: [Basic/Intermediate/Advanced]
 +===========================================================================*/
```

**Method Documentation:**
```java
/**
 * [Brief description of what the method does]
 * Use Case: [Specific scenario where this pattern is used]
 * 
 * @param param1 Description of parameter
 * @return Description of return value
 * @throws OAException Description of when exception is thrown
 */
```

**Inline Comments:**
- Explain non-obvious logic
- Describe why something is done, not just what
- Keep comments up-to-date with code changes

#### Code Structure

**Imports:**
- Group imports logically (standard Java, OAF framework, custom)
- Remove unused imports
- Use specific imports, avoid wildcard imports where possible

**Error Handling:**
```java
// ✅ Good - Use OAException with appropriate severity
throw new OAException("Invalid job name", OAException.ERROR);

// ❌ Bad - Generic exceptions
throw new Exception("Error");

// ❌ Bad - printStackTrace
catch (Exception e) {
    e.printStackTrace();
}
```

**Null Checks:**
```java
// ✅ Always check for null before operations
OAApplicationModuleImpl rootAM = pageContext.getRootApplicationModule();
if (rootAM != null) {
    rootAM.invokeMethod("commit");
}

// ❌ No null check
rootAM.invokeMethod("commit"); // May throw NullPointerException
```

### 2. MVC Architecture Standards

#### Model Layer (BC4J)

**Entity Objects:**
- ✅ Always populate WHO columns (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE)
- ✅ Use `SequenceImpl` for primary key generation
- ✅ Implement validation in `validateEntity()` for multi-attribute checks
- ✅ Override setter methods for single-attribute validation
- ❌ Never perform UI operations in Entity Objects
- ❌ Don't put business logic in EO (use AM instead)

**View Objects:**
- ✅ Use bind variables in WHERE clauses
- ✅ Check VO for null before operations
- ✅ Use `setWhereClause()` and `setWhereClauseParams()` together
- ✅ Use `setOrderByClause()` for sorting
- ❌ Never concatenate user input into SQL (SQL injection risk)

**Application Modules:**
- ✅ Business logic belongs in Application Module methods
- ✅ Use `invokeMethod()` instead of casting to custom AM class
- ✅ Always commit/rollback through the AM
- ❌ Never commit in Controller layer

#### View Layer (UI Pages)

- ✅ Define pages declaratively using JDeveloper
- ✅ Use standard OAF components
- ✅ Follow Oracle UI guidelines
- ❌ Don't create UI programmatically unless necessary

#### Controller Layer

- ✅ Initialize data in `processRequest()`
- ✅ Handle events in `processFormRequest()`
- ✅ Validate user input before calling AM methods
- ❌ No business logic in controllers (delegate to AM)
- ❌ No direct database access from controllers
- ❌ Don't use `processRequest()` for form submissions

### 3. Security Standards

**Input Validation:**
```java
// ✅ Validate all user inputs
String jobName = pageContext.getParameter("jobName");
if (jobName == null || jobName.trim().isEmpty()) {
    throw new OAException("Job name is required", OAException.ERROR);
}

// ✅ Use bind variables to prevent SQL injection
vo.setWhereClause("JOB_NAME = :1");
vo.setWhereClauseParams(new Object[]{jobName});

// ❌ Never concatenate user input into SQL
vo.setWhereClause("JOB_NAME = '" + jobName + "'"); // SQL INJECTION RISK!
```

**Sensitive Data:**
- ❌ Never hardcode credentials, API keys, or sensitive data
- ❌ Never log sensitive information
- ✅ Use profile options for configuration values
- ✅ Implement proper authorization checks

### 4. Performance Best Practices

**Database Operations:**
- ✅ Fetch only required columns
- ✅ Use appropriate fetch size
- ✅ Close resources when done
- ❌ Avoid N+1 query problems
- ❌ Don't fetch large result sets without pagination

**Memory Management:**
- ✅ Clear large collections when done
- ✅ Use proper scope for variables
- ❌ Don't keep references to large objects unnecessarily

### 5. Error Handling Standards

**Message Dictionary Usage:**
```java
// ✅ Use message dictionary for all user-facing messages
OAException ex = new OAException(
    "FND",                    // Product code
    "FND_INVALID_VALUE",      // Message name
    null,                     // Token names array
    OAException.ERROR,        // Severity
    null                      // Params
);

// ✅ Use message tokens for dynamic values
ex.setApplicationModule(am);
ex.setMessageToken("FIELD_NAME", "Job Name");
ex.setMessageToken("VALUE", jobName);
throw ex;
```

**Exception Handling:**
```java
// ✅ Catch specific exceptions
try {
    // Database operations
} catch (SQLException sqle) {
    throw new OAException("Database error: " + sqle.getMessage(), OAException.ERROR);
}

// ✅ Always clean up in finally block
try {
    // Operations
} finally {
    // Cleanup code
}
```

## Code Review Checklist

### For All Code

- [ ] Code follows naming conventions
- [ ] All classes and methods have proper documentation
- [ ] No unused imports or variables
- [ ] Proper error handling implemented
- [ ] Security considerations addressed
- [ ] Performance optimizations applied where needed
- [ ] Code is readable and maintainable

### For OAF Specific Code

- [ ] MVC separation maintained
- [ ] Proper use of OAException
- [ ] WHO columns populated in EOs
- [ ] Bind variables used for SQL parameters
- [ ] Null checks before operations
- [ ] Appropriate use of processRequest vs processFormRequest
- [ ] Business logic in AM, not in Controller
- [ ] Message dictionary used for user messages

### For Educational Examples

- [ ] Use case clearly documented
- [ ] Complexity level indicated
- [ ] Code is self-explanatory or well-commented
- [ ] Example demonstrates best practices
- [ ] Common mistakes avoided
- [ ] Related to course syllabus section

## Automated Code Quality Checks

### Static Analysis

The repository uses automated tools to check:
- Code style and formatting
- Potential bugs and code smells
- Security vulnerabilities
- Complexity metrics
- Documentation coverage

### Pre-Commit Checks

Before committing code:
1. Ensure all files compile without errors
2. Run any existing tests
3. Verify documentation is complete
4. Check for security issues
5. Review against this checklist

## Common Issues and Solutions

### Issue: NullPointerException

**Cause:** Not checking for null before operations

**Solution:**
```java
// ✅ Always check for null
if (rootAM != null) {
    rootAM.invokeMethod("commit");
}
```

### Issue: SQL Injection Vulnerability

**Cause:** Concatenating user input into SQL

**Solution:**
```java
// ✅ Use bind variables
vo.setWhereClause("STATUS = :1");
vo.setWhereClauseParams(new Object[]{status});
```

### Issue: Memory Leaks

**Cause:** Not releasing resources

**Solution:**
```java
// ✅ Release resources in finally block
try {
    // Use resources
} finally {
    if (vo != null) {
        vo.reset();
    }
}
```

### Issue: Poor Error Messages

**Cause:** Using generic or hardcoded messages

**Solution:**
```java
// ✅ Use message dictionary with meaningful names
throw new OAException("XX", "XX_JOB_NAME_REQUIRED", OAException.ERROR);
```

## Resources

### Oracle Documentation
- [OA Framework Developer's Guide](https://docs.oracle.com/cd/E18727_01/doc.121/e13809/toc.htm)
- [BC4J Developer's Guide](https://docs.oracle.com/cd/E15586_01/web.1111/b31974/toc.htm)
- [Oracle Coding Standards](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

### Internal Resources
- [code-brain.json](../../code-brain/code-brain.json) - Code pattern metadata
- [code-brain/README.md](../../code-brain/README.md) - Code examples documentation
- Course syllabi (SYLLABUS_101.md, SYLLABUS_102.md, SYLLABUS_103.md)

## Enforcement

### Review Process

1. **Self-Review**: Developer reviews their own code against this checklist
2. **Peer Review**: At least one other developer reviews the code
3. **Automated Review**: Static analysis tools check for issues
4. **Instructor Review**: Final review for educational content

### Quality Gates

Code must pass these gates before merging:
- ✅ All automated checks pass
- ✅ Documentation is complete
- ✅ Code follows all standards
- ✅ Security review completed
- ✅ Educational value verified

## Updates and Maintenance

This document is a living guideline and will be updated as:
- New patterns and best practices emerge
- Student feedback identifies areas for improvement
- Industry standards evolve
- Oracle releases new OAF versions

**Last Updated:** January 24, 2026  
**Version:** 1.0  
**Maintained By:** Oracle OAF BootCamp Team

## Questions and Feedback

For questions about these guidelines or to suggest improvements:
- Open an issue on GitHub
- Contact the instructional team
- Discuss in the developer forum

---

**Remember**: High-quality code is not just about making it work—it's about making it maintainable, secure, and valuable for learning.
