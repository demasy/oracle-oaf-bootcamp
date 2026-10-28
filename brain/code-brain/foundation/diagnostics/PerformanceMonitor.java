package oracle.apps.fnd.framework.foundation.diagnostics;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.server.OAViewObject;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

/**
 * PerformanceMonitor - Performance monitoring and profiling utility.
 * 
 * Provides patterns for measuring execution time and identifying performance bottlenecks.
 * Helps optimize slow queries and heavy operations.
 * 
 * USAGE:
 * <pre>
 * // Measure execution time
 * long startTime = PerformanceMonitor.startTimer();
 * // ... execute operation ...
 * long elapsed = PerformanceMonitor.stopTimer(startTime, "Search operation");
 * 
 * // Log VO query performance
 * PerformanceMonitor.logVOQueryTime(vo);
 * 
 * // Log row count
 * PerformanceMonitor.logRowCount(vo, "EmployeeSearchVO");
 * </pre>
 * 
 * @version 1.0.0
 * @since OAF Foundation Framework 1.0
 */
public class PerformanceMonitor {
    
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED = VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
    
    // Performance thresholds (milliseconds)
    private static final long SLOW_QUERY_THRESHOLD = 1000;  // 1 second
    private static final long WARNING_THRESHOLD = 3000;      // 3 seconds
    
    /**
     * Private constructor - utility class.
     */
    private PerformanceMonitor() {
    }
    
    /**
     * Starts a performance timer.
     * 
     * @return the start time in milliseconds
     */
    public static long startTimer() {
        return System.currentTimeMillis();
    }
    
    /**
     * Stops the timer and logs elapsed time.
     * 
     * @param startTime the start time from startTimer()
     * @param operationName the operation name for logging
     * @return elapsed time in milliseconds
     */
    public static long stopTimer(long startTime, String operationName) {
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        String severity = (elapsed > WARNING_THRESHOLD) ? "WARNING" :
                         (elapsed > SLOW_QUERY_THRESHOLD) ? "INFO" : "DEBUG";
        
        System.out.println(severity + ": " + operationName + " took " + elapsed + "ms");
        return elapsed;
    }
    
    /**
     * Logs VO query execution time.
     * 
     * @param vo the view object
     * @return elapsed time in milliseconds
     */
    public static long logVOQueryTime(OAViewObject vo) {
        if (vo != null) {
            long startTime = startTimer();
            vo.executeQuery();
            return stopTimer(startTime, "VO Query: " + vo.getName());
        }
        return 0;
    }
    
    /**
     * Logs row count for a VO.
     * 
     * @param vo the view object
     * @param voName the VO name for logging
     */
    public static void logRowCount(OAViewObject vo, String voName) {
        if (vo != null) {
            int rowCount = vo.getRowCount();
            System.out.println("INFO: " + voName + " returned " + rowCount + " rows");
            
            if (rowCount > 1000) {
                System.out.println("WARNING: Large result set (" + rowCount + 
                                 " rows) - consider pagination");
            }
        }
    }
    
    /**
     * Measures time to iterate through all rows.
     * 
     * @param vo the view object
     * @return elapsed time in milliseconds
     */
    public static long measureRowIterationTime(OAViewObject vo) {
        if (vo == null) {
            return 0;
        }
        
        long startTime = startTimer();
        RowSetIterator iter = vo.createRowSetIterator(null);
        try {
            int count = 0;
            while (iter.hasNext()) {
                Row row = iter.next();
                count++;
            }
            return stopTimer(startTime, "Iterated " + count + " rows");
        } finally {
            iter.closeRowSetIterator();
        }
    }
    
    /**
     * Logs SQL query from VO.
     * 
     * @param vo the view object
     */
    public static void logGeneratedSQL(OAViewObject vo) {
        if (vo != null) {
            String sql = vo.getQuery();
            System.out.println("DEBUG: Generated SQL for " + vo.getName() + ":");
            System.out.println(sql);
        }
    }
    
    /**
     * Checks if operation exceeded performance threshold.
     * 
     * @param elapsed elapsed time in milliseconds
     * @return true if operation is slow
     */
    public static boolean isSlow(long elapsed) {
        return elapsed > SLOW_QUERY_THRESHOLD;
    }
    
    /**
     * Gets current memory usage (for debugging memory issues).
     * 
     * @return memory usage information
     */
    public static String getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        return "Memory: " + (usedMemory / 1024 / 1024) + "MB used, " +
               (freeMemory / 1024 / 1024) + "MB free, " +
               (totalMemory / 1024 / 1024) + "MB total";
    }
}
