package io.bundle.properties;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePath {
	
	/** METHOD: */
	public String displayValue(Locale currentLocale, String key) {

		ResourceBundle labels = ResourceBundle.getBundle("bundle/paths", currentLocale);
		String value = labels.getString(key);
		return value;

	} // displayValue

	/** METHOD: */
	public void iterateKeys(Locale currentLocale) {

		ResourceBundle labels = ResourceBundle.getBundle("bundle/paths", currentLocale);

		@SuppressWarnings("rawtypes")
		Enumeration bundleKeys = labels.getKeys();

		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			String value = labels.getString(key);
			System.out.println("key = " + key + ", " + "value = " + value);
		}

	} // iterateKeys

}
