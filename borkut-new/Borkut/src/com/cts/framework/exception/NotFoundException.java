package com.cts.framework.exception;

/**
 * Title: NotFoundException.java Description: This is the application specific
 * exception class which extends application exception. This exception is thrown
 * when the requested value or file is not found. Copyright (c) 2006 - 2007
 * Novartis. All Rights Reserved.
 * 
 */
public class NotFoundException extends ApplicationException {

    /**
     * Holds the error code for the not found exception.
     */
    public static final String NOT_FOUND_EXCEPTION = "Not found Exception occured";

    /**
     * Holds the error code for the not found exception.
     */
    public static final String NF1 = "Not found exception occured due to no prior planning period exists.";

    /**
     * Holds the error code for the not found exception.
     */
    public static final String NF2 = "Not found exception occured due to no data found in prior planning period exists.";

    /**
     * Default Constructor.
     * 
     */
    public NotFoundException() {
        super();
    }

    /**
     * 
     * @param errorCode
     *            String Variable.
     * @param throwable
     *            Instance of Throwable.
     */
    public NotFoundException(final String errorCode, final Throwable throwable) {
        super(errorCode, throwable);
    }
}
