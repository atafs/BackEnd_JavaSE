package io.bundle.properties;

import java.util.*;

public class BundleResources {

	/** METHOD: */
	public void displayValue(Locale currentLocale, String key) {

		ResourceBundle labels = ResourceBundle.getBundle("bundle/LabelsBundle", currentLocale);
		String value = labels.getString(key);
		System.out.println("Locale = " + currentLocale.toString() + ", "
				+ "key = " + key + ", " + "value = " + value);

	} // displayValue

	/** METHOD: */
	public void iterateKeys(Locale currentLocale) {

		ResourceBundle labels = ResourceBundle.getBundle("bundle/LabelsBundle", currentLocale);

		@SuppressWarnings("rawtypes")
		Enumeration bundleKeys = labels.getKeys();

		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			String value = labels.getString(key);
			System.out.println("key = " + key + ", " + "value = " + value);
		}

	} // iterateKeys


}
