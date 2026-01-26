package oracle.apps.xx.common.model.server;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

/**
 * Master-Detail Relationship Management Patterns
 * 
 * This class demonstrates PRODUCTION-READY patterns for handling master-detail
 * relationships in Oracle OAF. Based on real-world analysis of JDEV codebase,
 * particularly Letter of Credit (LC) system with header-line architecture.
 * 
 * Key Patterns Covered:
 * - Automatic line number generation and management
 * - Header-line amount validation
 * - Cascading operations (create, update, delete)
 * - Batch line creation from templates
 * - Detail navigation and row management
 * 
 * Source: Analyzed from demasylabs-barin/brain-repo/code/JDEV
 * Files: TmzApLCHeadersAMImpl.java, LCHeadersVOImpl.java, LCLinesVOImpl.java
 * 
 * @author OAF Code Brain - Based on Real-World Production Code
 * @version 1.5.0
 */
public class MasterDetailPatternsAM extends OAApplicationModuleImpl {
    
    /**
     * PATTERN 1: Create Detail Row with Auto-Increment Line Number
     * 
     * Automatically assigns next line number when creating detail rows.
     * Standard pattern in Order Entry, Invoice Entry, Purchase Orders, etc.
     * 
     * Found in: TmzApLCHeadersAMImpl.createRow()
     * 
     * Algorithm:
     * 1. Get current master row
     * 2. Access detail VO via View Link
     * 3. Find maximum existing line number
     * 4. Create new row with line_number = max + 1
     * 5. Set foreign key to master
     * 
     * @param masterVOName Master VO name (e.g., "HeadersVO1")
     * @param detailVOName Detail VO name (e.g., "LinesVO")
     * @param masterKeyAttr Master PK attribute (e.g., "HeaderId")
     * @param lineNumAttr Line number attribute (e.g., "LineNum")
     */
    public void createDetailRowWithAutoLineNumber(
            String masterVOName,
            String detailVOName,
            String masterKeyAttr,
            String lineNumAttr) {
        
        // Get master VO
        OAViewObjectImpl masterVO = (OAViewObjectImpl) findViewObject(masterVOName);
        if (masterVO == null) {
            throw new OAException("Master VO not found: " + masterVOName,
                OAException.ERROR);
        }
        
        // Get current master row
        OAViewRowImpl masterRow = (OAViewRowImpl) masterVO.getCurrentRow();
        if (masterRow == null) {
            throw new OAException("No master row selected. Please select a header.",
                OAException.ERROR);
        }
        
        // Get master key value
        Object masterKey = masterRow.getAttribute(masterKeyAttr);
        if (masterKey == null) {
            throw new OAException("Master key is null - cannot create detail row",
                OAException.ERROR);
        }
        
        // Get detail VO
        OAViewObjectImpl detailVO = (OAViewObjectImpl) findViewObject(detailVOName);
        if (detailVO == null) {
            throw new OAException("Detail VO not found: " + detailVOName,
                OAException.ERROR);
        }
        
        // Calculate next line number
        int nextLineNum = 1; // Default first line
        
        if (detailVO.getRowCount() > 0) {
            // Find maximum line number in existing rows
            RowSetIterator iter = detailVO.createRowSetIterator("LineNumIterator");
            try {
                iter.reset();
                
                while (iter.hasNext()) {
                    Row row = iter.next();
                    Object lineNumObj = row.getAttribute(lineNumAttr);
                    
                    if (lineNumObj != null) {
                        int lineNum;
                        if (lineNumObj instanceof Number) {
                            lineNum = ((Number) lineNumObj).intValue();
                        } else {
                            lineNum = Integer.parseInt(lineNumObj.toString());
                        }
                        
                        if (lineNum >= nextLineNum) {
                            nextLineNum = lineNum + 1;
                        }
                    }
                }
            } finally {
                iter.closeRowSetIterator();
            }
        }
        
        // Create new detail row
        Row newRow = detailVO.createRow();
        
        // Set line number
        newRow.setAttribute(lineNumAttr, new Number(nextLineNum));
        
        // Set foreign key to master
        newRow.setAttribute(masterKeyAttr, masterKey);
        
        // Insert row
        detailVO.insertRow(newRow);
        
        // Set as current row
        detailVO.setCurrentRow(newRow);
        
        System.out.println("Created detail row with line number: " + nextLineNum);
    }
    
    /**
     * PATTERN 2: Validate Header-Line Amount Totals
     * 
     * Ensure sum of line amounts doesn't exceed header amount.
     * Common validation in financial documents.
     * 
     * Found in: TmzApLCHeadersAMImpl.validateLinesAmount()
     * 
     * @param headerVOName Header VO name
     * @param linesVOName Lines VO name
     * @param headerAmountAttr Header amount attribute
     * @param lineAmountAttr Line amount attribute
     * @throws OAException if line total exceeds header amount
     */
    public void validateHeaderLineAmounts(
            String headerVOName,
            String linesVOName,
            String headerAmountAttr,
            String lineAmountAttr) {
        
        // Get header VO and current row
        OAViewObjectImpl headerVO = (OAViewObjectImpl) findViewObject(headerVOName);
        OAViewRowImpl headerRow = (OAViewRowImpl) headerVO.getCurrentRow();
        
        if (headerRow == null) {
            return; // No header - nothing to validate
        }
        
        // Get header amount
        Object headerAmountObj = headerRow.getAttribute(headerAmountAttr);
        if (headerAmountObj == null) {
            return; // No header amount set - skip validation
        }
        
        Number headerAmount = (Number) headerAmountObj;
        double headerAmountValue = headerAmount.doubleValue();
        
        // Calculate sum of line amounts
        OAViewObjectImpl linesVO = (OAViewObjectImpl) findViewObject(linesVOName);
        double lineAmountTotal = 0.0;
        
        RowSetIterator iter = linesVO.createRowSetIterator("AmountSumIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row lineRow = iter.next();
                Object lineAmountObj = lineRow.getAttribute(lineAmountAttr);
                
                if (lineAmountObj != null) {
                    Number lineAmount = (Number) lineAmountObj;
                    lineAmountTotal += lineAmount.doubleValue();
                }
            }
        } finally {
            iter.closeRowSetIterator();
        }
        
        // Validate
        if (lineAmountTotal > headerAmountValue) {
            throw new OAException(
                "Line amounts total (" + lineAmountTotal + 
                ") exceeds header amount (" + headerAmountValue + ")",
                OAException.ERROR
            );
        }
        
        System.out.println("Amount validation passed: Header=" + headerAmountValue + 
                         ", Lines=" + lineAmountTotal);
    }
    
    /**
     * PATTERN 3: Cascade Delete - Validate Before Delete Header
     * 
     * Prevent deletion of header if detail lines exist.
     * Alternative: Implement cascade delete to remove all lines.
     * 
     * @param headerVOName Header VO name
     * @param linesVOName Lines VO name
     * @param headerId Header ID to delete
     * @param cascadeDelete true to delete lines, false to prevent deletion
     * @throws OAException if lines exist and cascadeDelete is false
     */
    public void deleteHeaderWithValidation(
            String headerVOName,
            String linesVOName,
            Object headerId,
            boolean cascadeDelete) {
        
        // Get lines VO
        OAViewObjectImpl linesVO = (OAViewObjectImpl) findViewObject(linesVOName);
        
        // Check if lines exist
        int lineCount = linesVO.getRowCount();
        
        if (lineCount > 0 && !cascadeDelete) {
            throw new OAException(
                "Cannot delete header - " + lineCount + " detail lines exist. " +
                "Delete lines first or use cascade delete.",
                OAException.ERROR
            );
        }
        
        if (lineCount > 0 && cascadeDelete) {
            // Delete all lines first
            RowSetIterator iter = linesVO.createRowSetIterator("DeleteIterator");
            try {
                iter.reset();
                
                while (iter.hasNext()) {
                    Row lineRow = iter.next();
                    lineRow.remove(); // Mark for deletion
                    System.out.println("Marked line for deletion");
                }
            } finally {
                iter.closeRowSetIterator();
            }
        }
        
        // Now delete header
        OAViewObjectImpl headerVO = (OAViewObjectImpl) findViewObject(headerVOName);
        OAViewRowImpl headerRow = (OAViewRowImpl) headerVO.getCurrentRow();
        
        if (headerRow != null) {
            headerRow.remove();
            System.out.println("Marked header for deletion");
        }
        
        // Commit changes
        getOADBTransaction().commit();
        
        System.out.println("Header and " + lineCount + " lines deleted successfully");
    }
    
    /**
     * PATTERN 4: Batch Create Lines from Template/Selection
     * 
     * Create multiple detail lines from PO lines, template, or other source.
     * Common in copy operations, template-based entry.
     * 
     * @param masterVOName Master VO name
     * @param detailVOName Detail VO name
     * @param sourceVOName Source VO with template data
     * @param masterKeyAttr Master PK attribute
     */
    public void batchCreateLinesFromSource(
            String masterVOName,
            String detailVOName,
            String sourceVOName,
            String masterKeyAttr) {
        
        // Get master row
        OAViewObjectImpl masterVO = (OAViewObjectImpl) findViewObject(masterVOName);
        OAViewRowImpl masterRow = (OAViewRowImpl) masterVO.getCurrentRow();
        
        if (masterRow == null) {
            throw new OAException("No master row selected",
                OAException.ERROR);
        }
        
        Object masterKey = masterRow.getAttribute(masterKeyAttr);
        
        // Get detail VO
        OAViewObjectImpl detailVO = (OAViewObjectImpl) findViewObject(detailVOName);
        
        // Get starting line number
        int lineNum = detailVO.getRowCount() + 1;
        
        // Get source VO
        OAViewObjectImpl sourceVO = (OAViewObjectImpl) findViewObject(sourceVOName);
        
        int createdCount = 0;
        RowSetIterator iter = sourceVO.createRowSetIterator("BatchCreateIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row sourceRow = iter.next();
                
                // Check if row is selected (if using selection)
                Object selectFlag = sourceRow.getAttribute("SelectFlag");
                if (selectFlag == null || !"Y".equals(selectFlag.toString())) {
                    continue; // Skip unselected rows
                }
                
                // Create new detail row
                Row newRow = detailVO.createRow();
                
                // Set line number
                newRow.setAttribute("LineNum", new Number(lineNum++));
                
                // Set master FK
                newRow.setAttribute(masterKeyAttr, masterKey);
                
                // Copy attributes from source
                newRow.setAttribute("ItemId", sourceRow.getAttribute("ItemId"));
                newRow.setAttribute("ItemDescription", sourceRow.getAttribute("Description"));
                newRow.setAttribute("Quantity", sourceRow.getAttribute("Quantity"));
                newRow.setAttribute("UnitPrice", sourceRow.getAttribute("UnitPrice"));
                
                // Calculate line amount
                Object qty = sourceRow.getAttribute("Quantity");
                Object price = sourceRow.getAttribute("UnitPrice");
                if (qty != null && price != null) {
                    double amount = ((Number) qty).doubleValue() * 
                                   ((Number) price).doubleValue();
                    newRow.setAttribute("Amount", new Number(amount));
                }
                
                detailVO.insertRow(newRow);
                createdCount++;
                
                // Clear selection flag
                sourceRow.setAttribute("SelectFlag", null);
            }
        } finally {
            iter.closeRowSetIterator();
        }
        
        System.out.println("Batch created " + createdCount + " detail lines");
    }
    
    /**
     * PATTERN 5: Navigate to Specific Detail Line
     * 
     * Set current row in detail VO based on line number.
     * Useful for drill-down navigation.
     * 
     * @param detailVOName Detail VO name
     * @param lineNumber Line number to navigate to
     * @return true if row found and set, false otherwise
     */
    public boolean navigateToDetailLine(String detailVOName, int lineNumber) {
        OAViewObjectImpl detailVO = (OAViewObjectImpl) findViewObject(detailVOName);
        
        RowSetIterator iter = detailVO.createRowSetIterator("NavigateIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row row = iter.next();
                Object lineNumObj = row.getAttribute("LineNum");
                
                if (lineNumObj != null) {
                    int rowLineNum;
                    if (lineNumObj instanceof Number) {
                        rowLineNum = ((Number) lineNumObj).intValue();
                    } else {
                        rowLineNum = Integer.parseInt(lineNumObj.toString());
                    }
                    
                    if (rowLineNum == lineNumber) {
                        detailVO.setCurrentRow(row);
                        System.out.println("Navigated to line: " + lineNumber);
                        return true;
                    }
                }
            }
        } finally {
            iter.closeRowSetIterator();
        }
        
        System.err.println("Line number not found: " + lineNumber);
        return false;
    }
    
    /**
     * PATTERN 6: Resequence Line Numbers After Delete
     * 
     * After deleting a line, renumber remaining lines sequentially.
     * Ensures no gaps in line numbers.
     * 
     * @param detailVOName Detail VO name
     * @param lineNumAttr Line number attribute
     */
    public void resequenceLineNumbers(String detailVOName, String lineNumAttr) {
        OAViewObjectImpl detailVO = (OAViewObjectImpl) findViewObject(detailVOName);
        
        int newLineNum = 1;
        RowSetIterator iter = detailVO.createRowSetIterator("ResequenceIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row row = iter.next();
                row.setAttribute(lineNumAttr, new Number(newLineNum++));
            }
        } finally {
            iter.closeRowSetIterator();
        }
        
        System.out.println("Resequenced " + (newLineNum - 1) + " lines");
    }
    
    /**
     * PATTERN 7: Copy Master-Detail to New Document
     * 
     * Clone header and all lines to create new document.
     * Common in "Copy" or "Duplicate" functionality.
     * 
     * @param headerVOName Header VO name
     * @param linesVOName Lines VO name
     * @param sourceHeaderId Source header ID to copy from
     * @return New header ID
     */
    public Object copyMasterDetail(
            String headerVOName,
            String linesVOName,
            Object sourceHeaderId) {
        
        OADBTransaction txn = getOADBTransaction();
        
        // Get source header
        OAViewObjectImpl headerVO = (OAViewObjectImpl) findViewObject(headerVOName);
        OAViewRowImpl sourceHeader = (OAViewRowImpl) headerVO.findByKey(
            new oracle.jbo.Key(new Object[]{sourceHeaderId}), 1)[0];
        
        if (sourceHeader == null) {
            throw new OAException("Source header not found: " + sourceHeaderId,
                OAException.ERROR);
        }
        
        // Create new header
        Row newHeader = headerVO.createRow();
        
        // Get new header ID from sequence
        Number newHeaderId = txn.getSequenceValue("XX_HEADERS_S");
        newHeader.setAttribute("HeaderId", newHeaderId);
        
        // Copy attributes (except PK, WHO columns, Status)
        newHeader.setAttribute("Description", 
            sourceHeader.getAttribute("Description") + " (Copy)");
        newHeader.setAttribute("Amount", sourceHeader.getAttribute("Amount"));
        newHeader.setAttribute("CurrencyCode", sourceHeader.getAttribute("CurrencyCode"));
        newHeader.setAttribute("Status", "DRAFT"); // New document starts as draft
        
        headerVO.insertRow(newHeader);
        headerVO.setCurrentRow(newHeader);
        
        // Copy lines
        OAViewObjectImpl linesVO = (OAViewObjectImpl) findViewObject(linesVOName);
        
        // Query source lines
        linesVO.setWhereClause("HEADER_ID = :1");
        linesVO.setWhereClauseParams(null);
        linesVO.setWhereClauseParam(0, sourceHeaderId);
        linesVO.executeQuery();
        
        RowSetIterator iter = linesVO.createRowSetIterator("CopyLinesIterator");
        try {
            iter.reset();
            
            while (iter.hasNext()) {
                Row sourceLine = iter.next();
                
                // Create new line
                Row newLine = linesVO.createRow();
                
                // Copy attributes
                newLine.setAttribute("HeaderId", newHeaderId); // New FK
                newLine.setAttribute("LineNum", sourceLine.getAttribute("LineNum"));
                newLine.setAttribute("ItemId", sourceLine.getAttribute("ItemId"));
                newLine.setAttribute("Quantity", sourceLine.getAttribute("Quantity"));
                newLine.setAttribute("UnitPrice", sourceLine.getAttribute("UnitPrice"));
                newLine.setAttribute("Amount", sourceLine.getAttribute("Amount"));
                
                linesVO.insertRow(newLine);
            }
        } finally {
            iter.closeRowSetIterator();
        }
        
        // Clear WHERE clause for future queries
        linesVO.setWhereClause(null);
        
        System.out.println("Copied header " + sourceHeaderId + " to " + newHeaderId);
        
        return newHeaderId;
    }
    
    /**
     * Best Practices Summary
     * =====================
     * 
     * 1. LINE NUMBER MANAGEMENT:
     *    - Always auto-calculate next line number
     *    - Use integer increments (10, 20, 30 for flexibility)
     *    - Resequence after deletions if gaps are undesired
     *    - Never let users manually enter line numbers
     * 
     * 2. VALIDATION:
     *    - Validate header-line relationships before commit
     *    - Check totals match (amounts, quantities)
     *    - Prevent orphan lines (enforce FK constraints)
     *    - Validate before delete (check dependencies)
     * 
     * 3. CASCADE OPERATIONS:
     *    - Implement cascade delete OR prevent deletion
     *    - Warn user before cascade operations
     *    - Use database cascade constraints when possible
     *    - Log cascade operations for audit
     * 
     * 4. PERFORMANCE:
     *    - Use RowSetIterator with proper cleanup
     *    - Batch operations instead of single-row processing
     *    - Commit at appropriate intervals
     *    - Test with production data volumes
     * 
     * 5. USER EXPERIENCE:
     *    - Show line numbers to users
     *    - Provide "Add Line" button in detail region
     *    - Enable "Copy" functionality for reuse
     *    - Support batch line creation from templates
     * 
     * 6. DATA INTEGRITY:
     *    - Use View Links for master-detail association
     *    - Enforce FK constraints in database
     *    - Handle WHO columns in both header and lines
     *    - Validate data types and ranges
     * 
     * Common Mistakes to Avoid:
     * =========================
     * ❌ Not closing RowSetIterator (memory leak)
     * ❌ Hardcoding line numbers instead of auto-calculating
     * ❌ Not validating header-line totals
     * ❌ Forgetting FK when creating lines
     * ❌ Cascade delete without warning
     * ❌ Not resequencing after delete
     * ❌ Processing too many lines without commit batching
     * ❌ Not handling null attributes
     */
}
