package cts.framework.exception;

/**
 * This is the application specific exception class which is used as a base
 * class of all types of application exceptions.This acts as as a wrapper class.
 */
public class ConcurrentUpdateException extends ApplicationException {

	/**
	 * Holds the error code for the concurrent update exception.
	 */
	public static final String CONCURRENT_EXCEPTION_ERROR = "Concurrent Exception occured";

	/**
	 * 
	 * @param errorCode
	 *            String Variable.
	 * @param throwable
	 *            Instance of Throwable.
	 */
	public ConcurrentUpdateException(final String errorCode, Throwable throwable) {
		super(errorCode, throwable);
	}

	/**
	 * Deafult Consturctor.
	 * 
	 */
	public ConcurrentUpdateException() {
		super();
	}
}
