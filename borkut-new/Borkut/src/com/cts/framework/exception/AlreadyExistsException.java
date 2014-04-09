package com.cts.framework.exception;

/**
 * @author Cognizant Technology Solutions.
 * 
 */
public class AlreadyExistsException extends ApplicationException {
    /**
     * Default Constructor.
     * 
     */
    public AlreadyExistsException() {
        super();
    }

    /**
     * Constructor.
     * 
     *            String Variable.
     * @param throwable
     *            Instance of Throwable.
     */
    public AlreadyExistsException(final String errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

}
