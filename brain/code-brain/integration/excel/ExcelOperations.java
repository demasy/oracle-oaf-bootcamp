package oracle.apps.xxcust.oaf.codebrain.integration.excel;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.apps.fnd.framework.server.OARow;
import oracle.apps.fnd.framework.OAException;
import oracle.jbo.Row;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import oracle.cabo.ui.data.DataObject;
import oracle.apps.fnd.framework.webui.beans.form.OAFormValueBean;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * Excel Import/Export Operations (Integration Layer)
 * 
 * Comprehensive patterns for Excel file import and export using Apache POI.
 * Import: Upload, parse, validate, insert to database
 * Export: Query, format, generate Excel, stream to browser
 * 
 * Layer: Integration Layer
 * Complexity: Advanced
 * Syllabus: Level 102 Section 16.2
 * 
 * Prerequisites:
 * - Apache POI library in classpath
 * - File upload bean configured in page
 * 
 * @author OAF Code Brain
 * @version 1.3
 */
public class ExcelOperations {

    /**
     * USE CASE 1: Import Excel File - Upload and Parse
     * 
     * Handle Excel file upload and parse content using Apache POI.
     * 
     * When to use:
     * - Bulk data import
     * - Mass upload from Excel
     * - Data migration
     * - Template-based entry
     * 
     * Best Practice:
     * - Validate file format
     * - Check file size limit
     * - Parse in memory for small files
     * - Stream for large files
     * 
     * Common Mistakes:
     * - Not validating file type
     * - Memory issues with large files
     * - No error handling
     * - Not closing streams
     * 
     * @param pageContext Current page context
     * @param fileBean File upload bean containing Excel
     */
    public void importExcelFileUpload(OAPageContext pageContext, DataObject fileBean) {
        try {
            // Get uploaded file input stream
            InputStream inputStream = (InputStream) fileBean.selectValue(null, "UPLOAD_FILE_NAME");
            
            // Get file name
            String fileName = (String) fileBean.selectValue(null, "UPLOAD_FILE_NAME");
            
            // Validate file extension
            if (fileName == null || (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx"))) {
                throw new OAException("Please upload a valid Excel file (.xls or .xlsx)",
                    OAException.ERROR);
            }
            
            // Get file size
            Long fileSize = (Long) fileBean.selectValue(null, "UPLOAD_FILE_SIZE");
            
            // Validate file size (e.g., max 10MB)
            if (fileSize != null && fileSize > 10 * 1024 * 1024) {
                throw new OAException("File size exceeds maximum limit of 10MB",
                    OAException.ERROR);
            }
            
            // Create workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
            
            // Get first sheet
            Sheet sheet = workbook.getSheetAt(0);
            
            System.out.println("Excel file uploaded: " + fileName);
            System.out.println("Total rows: " + sheet.getLastRowNum());
            
            // Parse and process rows
            parseExcelSheet(pageContext, sheet);
            
            // Close workbook
            workbook.close();
            inputStream.close();
            
        } catch (Exception e) {
            throw new OAException("Error uploading Excel file: " + e.getMessage(),
                OAException.ERROR);
        }
    }

    /**
     * USE CASE 2: Parse Excel Sheet and Extract Data
     * 
     * Read Excel rows and extract cell values.
     * 
     * When to use:
     * - After file upload
     * - Extract employee data
     * - Read template data
     * - Parse formatted Excel
     * 
     * Best Practice:
     * - Skip header row
     * - Handle empty cells
     * - Validate data types
     * - Log parsing errors
     */
    private void parseExcelSheet(OAPageContext pageContext, Sheet sheet) {
        int successCount = 0;
        int errorCount = 0;
        
        // Iterate through rows (skip header row 0)
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            
            if (row == null) continue;
            
            try {
                // Extract cell values
                String employeeNumber = getCellValueAsString(row.getCell(0));
                String employeeName = getCellValueAsString(row.getCell(1));
                
                // Validate required fields first
                if (employeeNumber == null || employeeName == null) {
                    System.err.println("Row " + (rowIndex + 1) + ": Missing required fields");
                    errorCount++;
                    continue;
                }
                
                // Extract optional fields after validation
                String email = getCellValueAsString(row.getCell(2));
                String department = getCellValueAsString(row.getCell(3));
                Double salary = getCellValueAsDouble(row.getCell(4));
                
                // Store data (will be inserted later)
                // For now, just log
                System.out.println("Parsed: " + employeeNumber + " - " + employeeName);
                successCount++;
                
            } catch (Exception e) {
                System.err.println("Error parsing row " + (rowIndex + 1) + ": " + e.getMessage());
                errorCount++;
            }
        }
        
        System.out.println("Parsing complete: " + successCount + " success, " + errorCount + " errors");
    }

    /**
     * USE CASE 3: Validate Excel Data Before Insert
     * 
     * Validate parsed Excel data against business rules.
     * 
     * When to use:
     * - Before database insert
     * - Check data integrity
     * - Validate business rules
     * - Prevent bad data
     * 
     * Best Practice:
     * - Validate all required fields
     * - Check data types and formats
     * - Verify foreign key references
     * - Collect all errors before stopping
     */
    public boolean validateExcelRow(int rowNum, String empNum, String empName, 
                                    String email, String dept, Double salary) {
        StringBuilder errors = new StringBuilder();
        
        // Validate employee number
        validateEmployeeNumber(empNum, errors);
        
        // Validate employee name
        validateEmployeeName(empName, errors);
        
        // Validate email format
        validateEmail(email, errors);
        
        // Validate salary
        validateSalary(salary, errors);
        
        // If errors found, log and return false
        if (errors.length() > 0) {
            System.err.println("Row " + rowNum + " validation errors: " + errors.toString());
            return false;
        }
        
        return true;
    }
    
    /**
     * Helper: Validate employee number
     */
    private void validateEmployeeNumber(String empNum, StringBuilder errors) {
        if (empNum == null || empNum.trim().isEmpty()) {
            errors.append("Employee Number is required; ");
        } else if (empNum.length() > 20) {
            errors.append("Employee Number too long; ");
        }
    }
    
    /**
     * Helper: Validate employee name
     */
    private void validateEmployeeName(String empName, StringBuilder errors) {
        if (empName == null || empName.trim().isEmpty()) {
            errors.append("Employee Name is required; ");
        }
    }
    
    /**
     * Helper: Validate email format
     */
    private void validateEmail(String email, StringBuilder errors) {
        if (email != null && !email.contains("@")) {
            errors.append("Invalid email format; ");
        }
    }
    
    /**
     * Helper: Validate salary
     */
    private void validateSalary(Double salary, StringBuilder errors) {
        if (salary != null && salary < 0) {
            errors.append("Salary cannot be negative; ");
        }
    }

    /**
     * USE CASE 4: Insert Excel Data to Database
     * 
     * Insert validated Excel data into database using View Object.
     * 
     * When to use:
     * - After validation passes
     * - Bulk insert operation
     * - Mass data entry
     * - Import from template
     * 
     * Best Practice:
     * - Insert in batches
     * - Commit in batches
     * - Handle duplicates
     * - Rollback on error
     */
    public void insertExcelDataToDB(OAPageContext pageContext, OAWebBean webBean,
                                    String empNum, String empName, String email,
                                    String dept, Double salary) {
        // Get view object
        OAViewObject empVO = (OAViewObject) 
            pageContext.getApplicationModule(webBean)
            .findViewObject("EmployeeVO");
        
        if (empVO != null) {
            // Check for duplicate
            empVO.setWhereClause("EMPLOYEE_NUMBER = :1");
            empVO.setWhereClauseParams(null);
            empVO.setWhereClauseParam(0, empNum);
            empVO.executeQuery();
            
            if (empVO.hasNext()) {
                System.err.println("Duplicate employee number: " + empNum);
                return;
            }
            
            // Create new row
            OARow row = (OARow) empVO.createRow();
            
            // Set attributes
            row.setAttribute("EmployeeNumber", empNum);
            row.setAttribute("EmployeeName", empName);
            row.setAttribute("Email", email);
            row.setAttribute("Department", dept);
            row.setAttribute("Salary", salary);
            
            // Set WHO columns
            row.setAttribute("CreatedBy", pageContext.getUserId());
            row.setAttribute("CreationDate", pageContext.getCurrentDBDate());
            row.setAttribute("LastUpdatedBy", pageContext.getUserId());
            row.setAttribute("LastUpdateDate", pageContext.getCurrentDBDate());
            
            // Insert row
            empVO.insertRow(row);
            
            System.out.println("Inserted employee: " + empName);
        }
    }

    /**
     * USE CASE 5: Export Data to Excel - Query and Format
     * 
     * Query data from View Object and create Excel file.
     * 
     * When to use:
     * - Export search results
     * - Download report as Excel
     * - Data extraction
     * - Offline analysis
     * 
     * Best Practice:
     * - Query only required data
     * - Format headers properly
     * - Set appropriate column widths
     * - Handle large datasets
     */
    public void exportDataToExcel(OAPageContext pageContext, OAWebBean webBean) {
        try {
            // Get view object with data to export
            OAViewObject empVO = (OAViewObject)
                pageContext.getApplicationModule(webBean)
                .findViewObject("EmployeeVO");
            
            if (empVO == null) {
                throw new OAException("No data available to export", OAException.ERROR);
            }
            
            // Create workbook
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees");
            
            // Create header row
            HSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Employee Number");
            headerRow.createCell(1).setCellValue("Employee Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Department");
            headerRow.createCell(4).setCellValue("Salary");
            
            // Set column widths
            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 5000);
            sheet.setColumnWidth(4, 4000);
            
            // Execute query
            empVO.executeQuery();
            
            // Iterate through rows and add to Excel
            int rowIndex = 1;
            while (empVO.hasNext()) {
                OARow row = (OARow) empVO.next();
                
                HSSFRow excelRow = sheet.createRow(rowIndex++);
                excelRow.createCell(0).setCellValue(
                    row.getAttribute("EmployeeNumber") != null ? 
                    row.getAttribute("EmployeeNumber").toString() : "");
                excelRow.createCell(1).setCellValue(
                    row.getAttribute("EmployeeName") != null ? 
                    row.getAttribute("EmployeeName").toString() : "");
                excelRow.createCell(2).setCellValue(
                    row.getAttribute("Email") != null ? 
                    row.getAttribute("Email").toString() : "");
                excelRow.createCell(3).setCellValue(
                    row.getAttribute("Department") != null ? 
                    row.getAttribute("Department").toString() : "");
                
                // Handle numeric salary
                if (row.getAttribute("Salary") != null) {
                    excelRow.createCell(4).setCellValue(
                        Double.parseDouble(row.getAttribute("Salary").toString()));
                }
            }
            
            System.out.println("Excel file created with " + (rowIndex - 1) + " rows");
            
            // Stream to browser
            streamExcelToBrowser(pageContext, workbook, "EmployeeList.xls");
            
        } catch (Exception e) {
            throw new OAException("Error exporting to Excel: " + e.getMessage(),
                OAException.ERROR);
        }
    }

    /**
     * USE CASE 6: Stream Excel File to Browser
     * 
     * Send generated Excel file to browser for download.
     * 
     * When to use:
     * - After Excel generation
     * - Download functionality
     * - Export completion
     * - File delivery
     * 
     * Best Practice:
     * - Set correct MIME type
     * - Set Content-Disposition
     * - Clear response buffer
     * - Close streams properly
     */
    public void streamExcelToBrowser(OAPageContext pageContext, 
                                     HSSFWorkbook workbook, 
                                     String fileName) {
        try {
            // Get HTTP response
            HttpServletResponse response = 
                (HttpServletResponse) pageContext.getRenderingContext()
                .getServletResponse();
            
            // Set content type for Excel
            response.setContentType("application/vnd.ms-excel");
            
            // Set content disposition for download
            response.setHeader("Content-Disposition", 
                "attachment; filename=\"" + fileName + "\"");
            
            // Get output stream
            OutputStream outputStream = response.getOutputStream();
            
            // Write workbook to stream
            workbook.write(outputStream);
            
            // Flush and close
            outputStream.flush();
            outputStream.close();
            workbook.close();
            
            System.out.println("Excel file streamed to browser: " + fileName);
            
        } catch (Exception e) {
            throw new OAException("Error streaming Excel file: " + e.getMessage(),
                OAException.ERROR);
        }
    }

    /**
     * USE CASE 7: Handle Large Excel Files (Streaming)
     * 
     * Process large Excel files using streaming approach.
     * 
     * When to use:
     * - Files > 10,000 rows
     * - Memory constraints
     * - Large data imports
     * - Performance critical
     * 
     * Best Practice:
     * - Process in batches
     * - Commit in batches (e.g., every 1000 rows)
     * - Use SXSSF for large exports
     * - Monitor memory usage
     */
    public void processLargeExcelFile(OAPageContext pageContext, OAWebBean webBean,
                                      Sheet sheet) {
        int batchSize = 1000;
        int processedCount = 0;
        
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) continue;
            
            try {
                // Parse and insert row
                String empNum = getCellValueAsString(row.getCell(0));
                String empName = getCellValueAsString(row.getCell(1));
                String email = getCellValueAsString(row.getCell(2));
                String dept = getCellValueAsString(row.getCell(3));
                Double salary = getCellValueAsDouble(row.getCell(4));
                
                // Validate and insert
                if (validateExcelRow(rowIndex + 1, empNum, empName, email, dept, salary)) {
                    insertExcelDataToDB(pageContext, webBean, empNum, empName, 
                                       email, dept, salary);
                    processedCount++;
                }
                
                // Commit every batch
                if (processedCount % batchSize == 0) {
                    pageContext.getApplicationModule(webBean)
                        .getTransaction().commit();
                    System.out.println("Committed batch: " + processedCount + " rows");
                }
                
            } catch (Exception e) {
                System.err.println("Error processing row " + (rowIndex + 1) + 
                                 ": " + e.getMessage());
            }
        }
        
        // Final commit
        pageContext.getApplicationModule(webBean).getTransaction().commit();
        System.out.println("Total processed: " + processedCount + " rows");
    }

    /**
     * Helper method: Get cell value as String
     */
    private String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return null;
        }
    }

    /**
     * Helper method: Get cell value as Double
     */
    private Double getCellValueAsDouble(Cell cell) {
        if (cell == null) return null;
        
        try {
            if (cell.getCellType() == CellType.NUMERIC) {
                return cell.getNumericCellValue();
            } else if (cell.getCellType() == CellType.STRING) {
                return Double.parseDouble(cell.getStringCellValue());
            }
        } catch (Exception e) {
            System.err.println("Error converting cell to double: " + e.getMessage());
        }
        
        return null;
    }

    /**
     * USE CASE 8: Best Practices Summary
     */
    public void excelBestPractices() {
        String practices =
            "Excel Operations Best Practices:\n" +
            "=================================\n" +
            "\n" +
            "Import:\n" +
            "- Validate file type and size\n" +
            "- Use template with headers\n" +
            "- Validate data before insert\n" +
            "- Process in batches (1000 rows)\n" +
            "- Commit in batches\n" +
            "- Handle errors per row\n" +
            "- Provide error report\n" +
            "\n" +
            "Export:\n" +
            "- Query only required columns\n" +
            "- Format headers clearly\n" +
            "- Set appropriate column widths\n" +
            "- Handle large datasets (SXSSF)\n" +
            "- Set correct MIME type\n" +
            "- Use meaningful file names\n" +
            "\n" +
            "Performance:\n" +
            "- Batch processing for large files\n" +
            "- Stream for very large exports\n" +
            "- Monitor memory usage\n" +
            "- Use indexes for validation queries\n" +
            "- Close streams and workbooks\n" +
            "\n" +
            "Error Handling:\n" +
            "- Try-catch around operations\n" +
            "- Log all errors with row numbers\n" +
            "- Provide summary report\n" +
            "- Rollback on critical errors\n" +
            "- Don't stop on single row error";
        
        System.out.println(practices);
    }
}
