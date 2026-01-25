package oracle.apps.xx.emp.controller;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.jbo.domain.BlobDomain;
import oracle.cabo.ui.data.DataObject;
import oracle.apps.xx.common.utils.MessageHelper;
import oracle.apps.xx.common.constants.MessageConstants;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * File Upload Controller with processFormData()
 * Demonstrates CSV import, PDF validation, and multiple file handling
 * @author Oracle OAF Expert
 * @version 1.4.0
 */
public class FileUploadCO extends OAControllerImpl {
    
    /**
     * processFormData() - CSV Import Pattern
     * Handle CSV file upload and parsing
     */
    public void processFormData(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormData(pageContext, webBean);
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        DataObject csvFile = pageContext.getNamedDataObject("CSVFile");
        
        if (csvFile != null) {
            String fileName = (String)csvFile.selectValue(null, "UPLOAD_FILE_NAME");
            BlobDomain content = (BlobDomain)csvFile.selectValue(null, csvFile);
            
            // Validate CSV file extension
            if (!fileName.toLowerCase().endsWith(".csv")) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_INVALID_FILE_FORMAT,
                    new String[]{"CSV"}
                );
            }
            
            // Validate file size (max 10MB for CSV)
            if (content.getLength() > 10 * 1024 * 1024) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_FILE_TOO_LARGE,
                    new String[]{"10MB"}
                );
            }
            
            try {
                // Convert BLOB to String for parsing
                InputStream is = content.getInputStream();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, "UTF-8")
                );
                
                // Parse CSV headers
                String headerLine = reader.readLine();
                if (headerLine == null) {
                    throw new OAException("CSV file is empty");
                }
                
                String[] headers = headerLine.split(",");
                validateCSVHeaders(headers);
                
                // Parse data rows
                ArrayList<HashMap> records = new ArrayList<HashMap>();
                String dataLine;
                int lineNumber = 1;
                int successCount = 0;
                int errorCount = 0;
                StringBuilder errors = new StringBuilder();
                
                while ((dataLine = reader.readLine()) != null) {
                    lineNumber++;
                    
                    try {
                        String[] values = dataLine.split(",");
                        
                        // Create record map
                        HashMap<String, String> record = new HashMap<String, String>();
                        for (int i = 0; i < headers.length && i < values.length; i++) {
                            record.put(headers[i].trim(), values[i].trim());
                        }
                        
                        // Validate record
                        validateCSVRecord(record, lineNumber);
                        
                        // Import record via AM
                        am.invokeMethod("importEmployeeFromCSV", new Object[]{record});
                        successCount++;
                        
                    } catch (Exception e) {
                        errorCount++;
                        errors.append("Line ").append(lineNumber)
                              .append(": ").append(e.getMessage()).append("\n");
                    }
                }
                
                reader.close();
                
                // Commit successful imports
                if (successCount > 0) {
                    getOADBTransaction().commit();
                }
                
                // Prepare summary message
                String summary = successCount + " records imported successfully.";
                if (errorCount > 0) {
                    summary += " " + errorCount + " records failed.\n" + errors.toString();
                }
                
                pageContext.putSessionValue("ImportSummary", summary);
                
            } catch (IOException e) {
                throw new OAException("Error reading CSV file: " + e.getMessage());
            } catch (Exception e) {
                getOADBTransaction().rollback();
                throw new OAException("CSV import failed: " + e.getMessage());
            }
        }
    }
    
    /**
     * Validate CSV headers
     */
    private void validateCSVHeaders(String[] headers) {
        String[] requiredHeaders = {"Employee Number", "Name", "Email", "Department"};
        
        for (String required : requiredHeaders) {
            boolean found = false;
            for (String header : headers) {
                if (required.equalsIgnoreCase(header.trim())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_MISSING_CSV_COLUMN,
                    new String[]{required}
                );
            }
        }
    }
    
    /**
     * Validate individual CSV record
     */
    private void validateCSVRecord(HashMap<String, String> record, int lineNumber) {
        // Validate required fields
        if (record.get("Employee Number") == null || 
            record.get("Employee Number").isEmpty()) {
            throw new OAException(
                "Employee Number is required (Line " + lineNumber + ")"
            );
        }
        
        // Validate email format
        String email = record.get("Email");
        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new OAException(
                "Invalid email format (Line " + lineNumber + ")"
            );
        }
    }
}
