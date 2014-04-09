package cts.framework.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * This class is for reading values from properties files.
 * 
 * @author Cognizant Technology Solutions
 */
public final class PropertyFileReader {

	/**
	 * Holds reference to the logger instance.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(PropertyFileReader.class);

	/**
	 * This is the hidden constructor.
	 */
	private PropertyFileReader() {
		super();
	}

	/*
	 * Loads the properties from the current class loader instance if the file
	 * is not already loaded.
	 */
	private static final ResourceBundle STORED_PROC_PROPERTYFILE = ResourceBundle
			.getBundle(ApplicationConstants.QUERIES_PROPERTIES_FILE);

	/*
	 * Loads the properties from the current class loader instance if the file
	 * is not already loaded.
	 */
	private static final ResourceBundle SERVLET_CONFIG_PROPERTYFILE = ResourceBundle
			.getBundle(ApplicationConstants.SERVLET_PROPERTIES_FILE);

	/*
	 * Loads the properties from the current class loader instance if the file
	 * is not already loaded.
	 */
	private static final ResourceBundle MESSAGE_CONFIG_PROPERTYFILE = ResourceBundle
			.getBundle(ApplicationConstants.MESSAGE_PROPERTIES_FILE);

	/**
	 * This method will return the value from the properties file based on the
	 * key passed to this method.
	 * 
	 * @param propertyKey
	 *            key whose value from the properties has to be read.
	 * @return the value of the property in the properties file.
	 */
	public static String getQuery(final String propertyKey) {
		String propertyValue = null;
		try {
			// Fetches the property from the properties file.
			propertyValue = STORED_PROC_PROPERTYFILE.getString(propertyKey);

		} catch (MissingResourceException missingResourceException) {
			LOGGER.error("Exception caught during getting property",
					missingResourceException);
		}
		return propertyValue;
	}

	/**
	 * This method will return the value from the properties file based on the
	 * key passed to this method.
	 * 
	 * @param propertyKey
	 *            key whose value from the properties has to be read.
	 * @return the value of the property in the properties file.
	 */
	public static String getServletName(final String propertyKey) {
		String propertyValue = null;
		try {
			// Fetches the property from the properties file.
			propertyValue = SERVLET_CONFIG_PROPERTYFILE.getString(propertyKey);

		} catch (MissingResourceException missingResourceException) {
			LOGGER.error("Exception caught during getting property",
					missingResourceException);
		}
		return propertyValue;
	}

	/**
	 * This method will return the value from the properties file based on the
	 * key passed to this method.
	 * 
	 * @param propertyKey
	 *            key whose value from the properties has to be read.
	 * @return the value of the property in the properties file.
	 */
	public static String getMessageString(final String propertyKey) {
		String propertyValue = null;
		try {
			// Fetches the property from the properties file.
			propertyValue = MESSAGE_CONFIG_PROPERTYFILE.getString(propertyKey);

		} catch (MissingResourceException missingResourceException) {
			LOGGER.error("Exception caught during getting property",
					missingResourceException);
		}
		return propertyValue;
	}
}
