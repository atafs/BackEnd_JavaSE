package io.file_reader.tests;

import io.Reader;

public class Main {
	
	//ATTRIBUTES: INPUT DATA ----------------------------------------------------------------
	private static final String path = "src/main/java/com/sebasi/jira/io/file_reader/properties/config.properties";
	//-----------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		Reader reader = new Reader();
		System.err.println(reader.readFileReader(path, "JIRA_URL"));
		System.err.println(reader.readFileReader(path, "JIRA_ADMIN_USERNAME"));
		
	}
	
	//PARAGRAPH
	public static void paragraph() {
		System.out.println();
	}

}
