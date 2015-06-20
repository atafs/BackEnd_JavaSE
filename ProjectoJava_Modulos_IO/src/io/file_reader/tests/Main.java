package io.file_reader.tests;

import io.NReader;
import io.PropertiesJira;

public class Main {
	
	//ATTRIBUTES: INPUT DATA ----------------------------------------------------------------
	//private static final String path = "properties/config.properties";
	//private static final String path = "src/main/java/com/sebasi/jira/io/file_reader/properties/config.properties";
	//-----------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		//INSTANTIATE
		PropertiesJira path = new PropertiesJira();
		NReader reader = new NReader();
		
		//CONSOLE
		System.err.println(reader.readFileReader(path.getPath(), "JIRA_URL"));
		System.err.println(reader.readFileReader(path.getPath(), "JIRA_ADMIN_USERNAME"));
		
	}
	
	//PARAGRAPH
	public static void paragraph() {
		System.out.println();
	}

}
