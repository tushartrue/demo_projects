package cts.framework.exception;

public class SystemException extends RuntimeException {

    /**
     * Holds the error code for the system exception.
     */
    public static final String SYSTEM_EXCEPTION_ERROR = "System Exception occured";

    /**
     * Holds the error code for the IllegalAccessException.
     */
    public static final String ILLEGAL_ACCESS_EXCEPTION_ERROR = "IllegalAccessException Exception occured";

    /**
     * Holds the error code for the InvocationTargetException.
     */
    public static final String INVOCATION_TARGET_EXCEPTION_ERROR = "InvocationTargetException Exception occured";

    /**
     * 
     * @param errorCode
     *            String Variable.
     * @param throwable
     *            Instance of Throwable.
     */
    public SystemException(final String errorCode, final Throwable throwable) {
        super(errorCode, throwable);
    }

    /**
     * Constructor.
     * 
     * @param errorMessage
     *          String var.
     */
    public SystemException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * DEfault Constructor.
     * 
     */
    public SystemException() {
        super();
    }
}