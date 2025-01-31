package io.bundle.tests;

import java.util.Locale;
import io.bundle.properties.Bundle;


public class Main {

	/** MAIN */
	public static void main(String[] args) {

		//INITIALIZE
		Bundle bundle = new Bundle();
		Locale[] supportedLocales = { Locale.ITALIAN, Locale.GERMAN, Locale.ENGLISH };

		//CONSOLE
		System.out.println("\n-----------PRINT S1--------------");
		for (int i = 0; i < supportedLocales.length; i++) {
			bundle.displayValue(supportedLocales[i], "s1");
		}

		System.out.println("\n-----------PRINT S2--------------");
		for (int i = 0; i < supportedLocales.length; i++) {
			bundle.displayValue(supportedLocales[i], "s2");
		}

		System.out.println("\n-----------PRINT S3--------------");
		for (int i = 0; i < supportedLocales.length; i++) {
			bundle.displayValue(supportedLocales[i], "s3");
		}

		System.out.println("\n-----------PRINT ITALIAN--------------");
		bundle.iterateKeys(supportedLocales[0]);

	}

}
