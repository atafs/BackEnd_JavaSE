package io.bundle.tests;

import java.util.Locale;

import io.bundle.properties.BundlePath;

public class MainPath {

	public static void main(String[] args) {
		
		//INITIALIZE
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;

		//CONSOLE
		System.out.println("\n-----------PRINT S1--------------");
		String bundle1 = bundle.displayValue(supportedLocales, "pathWriteToExcel");
		System.out.println(bundle1);
		

		System.out.println("\n-----------PRINT S2--------------");
		String bundle2 = bundle.displayValue(supportedLocales, "pathReadFromExcel");
		System.out.println(bundle2);
		
		System.out.println("\n-----------PRINT S3--------------");
		String bundle3 = bundle.displayValue(supportedLocales, "pathJSONFromTestsRead");
		System.out.println(bundle3);
	}

}
