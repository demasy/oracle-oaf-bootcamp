package oracle.apps.xx.doc.controller;

import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.cabo.ui.data.DataObject;
import oracle.apps.xx.common.utils.MessageHelper;
import oracle.apps.xx.common.constants.MessageConstants;
import java.io.*;
import java.util.HashMap;

/**
 * PDF Upload Controller with Transaction Rollback
 * Demonstrates advanced file validation and savepoint pattern
 * @author Oracle OAF Expert
 * @version 1.4.0
 */
public class PDFUploadCO extends OAControllerImpl {
    
    /**
     * processFormData() - PDF Upload with Validation and Rollback
     */
    public void processFormData(OAPageContext pageContext, OAWebBean webBean) {
        super.processFormData(pageContext, webBean);
        
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        OADBTransaction txn = getOADBTransaction();
        
        // Create savepoint for rollback
        txn.createSavepoint("FileUploadSavepoint");
        
        try {
            // Get uploaded file
            DataObject uploadedFile = pageContext.getNamedDataObject("DocumentFile");
            
            if (uploadedFile != null) {
                String fileName = (String)uploadedFile.selectValue(null, "UPLOAD_FILE_NAME");
                String mimeType = (String)uploadedFile.selectValue(null, "UPLOAD_FILE_MIME_TYPE");
                BlobDomain content = (BlobDomain)uploadedFile.selectValue(null, uploadedFile);
                
                // Validate file
                validateUploadedFile(fileName, mimeType, content);
                
                // Get additional form parameters
                String documentType = pageContext.getParameter("DocumentType");
                String description = pageContext.getParameter("Description");
                String referenceId = pageContext.getParameter("ReferenceId");
                
                // Validate required parameters
                if (documentType == null || documentType.trim().isEmpty()) {
                    throw MessageHelper.createFieldRequiredError("Document Type");
                }
                
                if (referenceId == null || referenceId.trim().isEmpty()) {
                    throw MessageHelper.createFieldRequiredError("Reference ID");
                }
                
                // Check if reference entity exists
                boolean entityExists = (Boolean)am.invokeMethod(
                    "checkEntityExists",
                    new Object[]{referenceId}
                );
                
                if (!entityExists) {
                    throw MessageHelper.createRecordNotFoundError(
                        "Reference entity with ID: " + referenceId
                    );
                }
                
                // Save file metadata to database
                Number documentId = (Number)am.invokeMethod("saveDocumentMetadata", new Object[]{
                    documentType,
                    fileName,
                    mimeType,
                    content.getLength(),
                    description,
                    new Number(referenceId)
                });
                
                // Save file content (BLOB)
                am.invokeMethod("saveDocumentContent", new Object[]{
                    documentId,
                    content
                });
                
                // Update reference entity with document ID
                am.invokeMethod("linkDocumentToEntity", new Object[]{
                    new Number(referenceId),
                    documentId
                });
                
                // Commit transaction
                txn.commit();
                
                // Store success message
                pageContext.putSessionValue(
                    "UploadSuccess",
                    "Document uploaded and linked successfully: " + fileName
                );
                
            } else {
                throw MessageHelper.createFieldRequiredError("Document File");
            }
            
        } catch (Exception e) {
            // Rollback to savepoint on any error
            try {
                txn.rollbackSavepoint("FileUploadSavepoint");
            } catch (Exception rollbackEx) {
                // Log rollback error
            }
            
            // Re-throw original exception
            if (e instanceof OAException) {
                throw (OAException)e;
            } else {
                throw new OAException(
                    "File upload failed: " + e.getMessage(),
                    OAException.ERROR
                );
            }
        }
    }
    
    /**
     * Validate uploaded file
     */
    private void validateUploadedFile(String fileName, String mimeType, BlobDomain content) 
        throws IOException {
        // Validate file name
        if (fileName == null || fileName.trim().isEmpty()) {
            throw MessageHelper.createFieldRequiredError("File Name");
        }
        
        // Validate file extension
        String[] allowedExtensions = {".pdf", ".doc", ".docx", ".xls", ".xlsx", ".jpg", ".png"};
        boolean validExtension = false;
        
        for (String ext : allowedExtensions) {
            if (fileName.toLowerCase().endsWith(ext)) {
                validExtension = true;
                break;
            }
        }
        
        if (!validExtension) {
            throw MessageHelper.createError(
                MessageConstants.ERR_INVALID_FILE_TYPE,
                new String[]{"PDF, DOC, DOCX, XLS, XLSX, JPG, PNG"}
            );
        }
        
        // Validate file size (max 25MB)
        if (content.getLength() > 25 * 1024 * 1024) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FILE_TOO_LARGE,
                new String[]{"25MB"}
            );
        }
        
        // Validate PDF magic number if PDF file
        if (fileName.endsWith(".pdf")) {
            byte[] header = new byte[4];
            InputStream is = content.getInputStream();
            is.read(header);
            is.close();
            
            // PDF files start with %PDF
            String headerStr = new String(header);
            if (!headerStr.startsWith("%PDF")) {
                throw MessageHelper.createError(
                    MessageConstants.ERR_CORRUPTED_FILE,
                    new String[]{"Not a valid PDF file"}
                );
            }
        }
        
        // Validate MIME type matches extension
        if (!isMimeTypeMatchingExtension(fileName, mimeType)) {
            throw MessageHelper.createError(
                MessageConstants.ERR_FILE_TYPE_MISMATCH,
                new String[]{fileName, mimeType}
            );
        }
    }
    
    /**
     * Check if MIME type matches file extension
     */
    private boolean isMimeTypeMatchingExtension(String fileName, String mimeType) {
        if (fileName.endsWith(".pdf") && "application/pdf".equals(mimeType)) return true;
        if (fileName.endsWith(".doc") && "application/msword".equals(mimeType)) return true;
        if (fileName.endsWith(".xls") && "application/vnd.ms-excel".equals(mimeType)) return true;
        if ((fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) && 
            "image/jpeg".equals(mimeType)) return true;
        if (fileName.endsWith(".png") && "image/png".equals(mimeType)) return true;
        
        return false;
    }
}
