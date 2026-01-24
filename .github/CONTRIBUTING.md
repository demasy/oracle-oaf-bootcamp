# Contributing to Oracle OAF BootCamp

Thank you for your interest in contributing to the Oracle Application Framework (OAF) BootCamp! This document provides guidelines for contributing to this educational repository.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Code Quality Standards](#code-quality-standards)
- [Pull Request Process](#pull-request-process)
- [Issue Guidelines](#issue-guidelines)

## Code of Conduct

This project follows a Code of Conduct to ensure a welcoming and inclusive environment for all contributors. By participating, you agree to:

- Be respectful and inclusive
- Accept constructive criticism gracefully
- Focus on what is best for the community
- Show empathy towards others

## How Can I Contribute?

### Reporting Bugs

If you find a bug in the code examples or documentation:

1. Check if the issue already exists in [GitHub Issues](https://github.com/demasylabs/Oracle-OAF-BootCamp/issues)
2. If not, create a new issue with:
   - Clear, descriptive title
   - Steps to reproduce the issue
   - Expected vs actual behavior
   - Code snippets if applicable
   - Your environment details (JDeveloper version, etc.)

### Suggesting Enhancements

We welcome suggestions for:
- New code examples
- Additional use cases
- Documentation improvements
- Lab exercises
- Teaching resources

Please create an issue with the "enhancement" label describing your suggestion.

### Contributing Code Examples

You can contribute:
- New OAF code patterns
- Additional use cases for existing patterns
- Bug fixes in existing examples
- Performance optimizations
- Documentation improvements

## Getting Started

### Prerequisites

Before contributing, ensure you have:
- Oracle JDeveloper 10g/11g with OA Extension
- Access to Oracle E-Business Suite instance (for testing)
- Git installed on your system
- Basic understanding of OAF development

### Setting Up Your Development Environment

1. **Fork the Repository**
   ```bash
   # Navigate to https://github.com/demasylabs/Oracle-OAF-BootCamp
   # Click "Fork" button
   ```

2. **Clone Your Fork**
   ```bash
   git clone https://github.com/YOUR-USERNAME/Oracle-OAF-BootCamp.git
   cd Oracle-OAF-BootCamp
   ```

3. **Add Upstream Remote**
   ```bash
   git remote add upstream https://github.com/demasylabs/Oracle-OAF-BootCamp.git
   ```

4. **Create a Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

## Development Workflow

### 1. Before Making Changes

```bash
# Update your fork with latest changes
git checkout main
git pull upstream main
git push origin main

# Create a feature branch
git checkout -b feature/add-new-pattern
```

### 2. Making Changes

- Follow the [Code Quality Guidelines](.github/instructions/codacy.instructions.md)
- Write clear, documented code
- Add comprehensive JavaDoc comments
- Include use case descriptions
- Test your code examples

### 3. Committing Changes

```bash
# Stage your changes
git add .

# Commit with a descriptive message
git commit -m "Add new pattern for file upload functionality

- Add FileUploadPatterns.java with 5 use cases
- Update code-brain.json metadata
- Add documentation in code-brain README
- Includes examples for single/multiple file upload"
```

**Commit Message Guidelines:**
- Use present tense ("Add feature" not "Added feature")
- Use imperative mood ("Move cursor to..." not "Moves cursor to...")
- First line should be descriptive and under 50 characters
- Reference issue numbers if applicable (#123)
- Provide detailed description in commit body if needed

### 4. Pushing Changes

```bash
# Push to your fork
git push origin feature/add-new-pattern
```

### 5. Creating a Pull Request

1. Go to your fork on GitHub
2. Click "New Pull Request"
3. Fill in the PR template with:
   - Clear description of changes
   - Related issue numbers
   - Testing performed
   - Screenshots if applicable

## Code Quality Standards

All contributions must adhere to the [Code Quality Guidelines](.github/instructions/codacy.instructions.md). Key requirements:

### Code Structure

```java
/*===========================================================================+
 | Oracle Applications Framework (OAF) - Component Name
 | 
 | USE CASE: Brief description
 | LOCATION: Controller/AM/EO/VO
 | COMPLEXITY: Basic/Intermediate/Advanced
 +===========================================================================*/

package oracle.apps.xx.module.layer;

import oracle.apps.fnd.framework.OAException;
// Other imports...

public class YourClassName {
    
    /**
     * Method description
     * Use Case: Specific scenario
     * 
     * @param param1 Description
     * @return Description
     */
    public void yourMethod(String param1) {
        // Implementation with comments
    }
}
```

### Documentation Requirements

- [ ] File header with use case and complexity
- [ ] JavaDoc for all public methods
- [ ] Inline comments for complex logic
- [ ] Usage examples in documentation
- [ ] Update code-brain.json metadata
- [ ] Update code-brain README.md

### Testing Requirements

- [ ] Code compiles without errors
- [ ] Manual testing completed
- [ ] No security vulnerabilities introduced
- [ ] Performance considerations addressed

## Pull Request Process

### PR Checklist

Before submitting a PR, ensure:

- [ ] Code follows the style guidelines
- [ ] Documentation is complete and accurate
- [ ] All automated checks pass
- [ ] Code has been manually tested
- [ ] Commit messages are clear and descriptive
- [ ] PR description explains what and why
- [ ] Related issues are referenced
- [ ] No merge conflicts with main branch

### Review Process

1. **Automated Checks**: Your PR will be automatically checked for:
   - Code style compliance
   - Security vulnerabilities
   - Documentation completeness

2. **Peer Review**: At least one maintainer will review your code for:
   - Correctness and clarity
   - Adherence to standards
   - Educational value
   - Security considerations

3. **Feedback**: Reviewers may:
   - Approve the PR
   - Request changes
   - Ask questions for clarification

4. **Merging**: Once approved, a maintainer will merge your PR

### After Your PR is Merged

- Your contribution will be acknowledged in release notes
- Delete your feature branch
- Update your fork with the latest changes

```bash
git checkout main
git pull upstream main
git push origin main
git branch -d feature/your-feature-name
```

## Issue Guidelines

### Creating Issues

Use the appropriate issue template:
- **Bug Report**: For code errors or incorrect examples
- **Feature Request**: For new patterns or enhancements
- **Documentation**: For documentation improvements
- **Question**: For clarification or help

### Issue Labels

- `bug`: Something isn't working correctly
- `enhancement`: New feature or improvement
- `documentation`: Documentation updates
- `good first issue`: Suitable for newcomers
- `help wanted`: Extra attention needed
- `question`: Further information requested
- `duplicate`: Issue already exists
- `wontfix`: Will not be addressed

## Types of Contributions

### 1. Code Examples

**What to contribute:**
- New OAF patterns not in the repository
- Additional use cases for existing patterns
- Real-world implementation examples
- Performance optimization examples

**Where to add:**
- Create new directory under `code-brain/` for new categories
- Add to existing directory for additional use cases
- Update `code-brain.json` metadata
- Update `code-brain/README.md`

### 2. Documentation

**What to contribute:**
- Clarify existing documentation
- Add missing information
- Fix typos or errors
- Translate content
- Add diagrams or visuals

**Where to add:**
- Update relevant README files
- Improve inline code comments
- Enhance syllabus content
- Update lab instructions

### 3. Labs and Exercises

**What to contribute:**
- New lab exercises
- Additional practice scenarios
- Solution walkthroughs
- Testing checklists

**Where to add:**
- Update `LABS.md`
- Create lab instructions
- Add starter code if needed

### 4. Syllabus Content

**What to contribute:**
- New lecture topics
- Enhanced learning objectives
- Additional resources
- Updated course structure

**Where to add:**
- Update appropriate SYLLABUS_*.md files
- Maintain consistency across levels
- Align with existing structure

## Recognition

Contributors will be recognized through:
- Acknowledgment in release notes
- Contributor list in README
- Community highlights
- Optional LinkedIn recommendations

## Questions?

If you have questions about contributing:
- Check existing issues and documentation
- Create a new issue with the "question" label
- Contact the maintainers
- Join community discussions

## License

By contributing, you agree that your contributions will be licensed under the same license as the project (see LICENSE.md).

---

Thank you for contributing to Oracle OAF BootCamp! Your contributions help create better learning resources for the OAF development community.

**Happy Coding! 🚀**
