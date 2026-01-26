package oracle.apps.fnd.framework.foundation.utilities;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAApplicationModule;

/**
 * TransactionHelper - Generic transaction management utility.
 * 
 * Provides reusable patterns for transaction operations.
 * Simplifies commit/rollback logic and savepoint management.
 * 
 * USAGE:
 * <pre>
 * // In Application Module
 * TransactionHelper.commit(getOADBTransaction());
 * 
 * // With savepoint
 * String savepoint = TransactionHelper.setSavepoint(txn, "BeforeUpdate");
 * try {
 *     // Do updates
 *     TransactionHelper.commit(txn);
 * } catch (Exception e) {
 *     TransactionHelper.rollbackToSavepoint(txn, savepoint);
 * }
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class TransactionHelper {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    /**
     * Private constructor - utility class.
     */
    private TransactionHelper() {
    }
    
    /**
     * Commits the transaction.
     * 
     * @param txn the database transaction
     */
    public static void commit(OADBTransaction txn) {
        if (txn != null) {
            txn.commit();
        }
    }
    
    /**
     * Rolls back the transaction.
     * 
     * @param txn the database transaction
     */
    public static void rollback(OADBTransaction txn) {
        if (txn != null) {
            txn.rollback();
        }
    }
    
    /**
     * Validates pending changes without committing.
     * 
     * @param txn the database transaction
     * @throws oracle.apps.fnd.framework.OAException if validation fails
     */
    public static void validate(OADBTransaction txn) {
        if (txn != null) {
            txn.validate();
        }
    }
    
    /**
     * Sets a savepoint for partial rollback.
     * 
     * @param txn the database transaction
     * @param savepointName the savepoint name
     * @return the savepoint name
     */
    public static String setSavepoint(OADBTransaction txn, String savepointName) {
        if (txn != null) {
            txn.setSavepoint(savepointName);
        }
        return savepointName;
    }
    
    /**
     * Rolls back to a specific savepoint.
     * 
     * @param txn the database transaction
     * @param savepointName the savepoint name
     */
    public static void rollbackToSavepoint(OADBTransaction txn, String savepointName) {
        if (txn != null) {
            txn.rollback(savepointName);
        }
    }
    
    /**
     * Checks if transaction is dirty (has pending changes).
     * 
     * @param txn the database transaction
     * @return true if transaction has uncommitted changes
     */
    public static boolean isDirty(OADBTransaction txn) {
        return (txn != null) && txn.isDirty();
    }
    
    /**
     * Gets the database transaction from an AM.
     * 
     * @param am the application module
     * @return the OADBTransaction
     */
    public static OADBTransaction getTransaction(OAApplicationModule am) {
        return (OADBTransaction) am.getOADBTransaction();
    }
}
