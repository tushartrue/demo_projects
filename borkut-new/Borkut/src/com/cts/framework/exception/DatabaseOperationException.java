package com.cts.framework.exception;

/**
 * This class represents system exceptions related to database operations. This
 * acts as as a wrapper class.
 * 
 */
public class DatabaseOperationException extends SystemException {

    /**
     * This constant will represent the condition where records could not be
     * retrieved.
     */
    public static final String DB_OPER_EXCEPTION_NOT_RETRIEVED_CODE = null;

    /**
     * This constant will represent the condition where stored procedure could
     * not be executed.
     */
    public static final String STORED_PROC_INVOCATION_EXCEPTION = "Stored Procedure could not be executed properly";

    /**
     * This constant will represent the condition wherein the connection could
     * not be closed.
     */
    public static final String CLEAN_EXIT_FAILURE = null;

    /**
     * Constructs an DatabaseOperationException with the specified error code.
     * 
     */
    public DatabaseOperationException() {
        super();
    }

    /**
     * Constructs an DatabaseOperationException with the specified error code.
     * 
     * @param errorCode -
     *            error code for the error description.
     * @param throwable
     *            Instance of Throwable.
     */
    public DatabaseOperationException(final String errorCode,
            final Throwable throwable) {
        super(errorCode, throwable);
    }

    /**
     * Constructs an DatabaseOperationException with the specified error code.
     * 
     * @param errorCode -
     *            error code for the error description.
     */
    public DatabaseOperationException(String errorCode) {
        super(errorCode);
    }

}
