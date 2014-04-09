package cts.framework.exception;
/**
 * This is the application specific exception class which is used as a base
 * class of all types of application exceptions.This acts as as a wrapper class.
 */
public class ApplicationException extends Exception 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	private String errorCode;
    /**
     * Default Constructor.
     * 
     */
    public ApplicationException() {
        super();
    }

    /**
     * 
     * @param errorCode
     *            String Variable.
     * @param throwable
     *            Instance of Throwable.
     */
    public ApplicationException(final String code, Throwable throwable) {
        super(code, throwable);
        this.errorCode=code;
    }
    
    public ApplicationException(final String code) {
        super(code);
        this.errorCode=code;
    }

	/**
	 * @return Returns the errorCode.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode The errorCode to set.
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
