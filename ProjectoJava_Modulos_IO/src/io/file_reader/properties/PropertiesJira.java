package io.file_reader.properties;


import io.Reader;

//DAO CLASS
public class PropertiesJira {
	
	//ATTRIBUTES: INPUT DATA ----------------------------------------------------------------
	private static final String path = "src/main/java/com/sebasi/jira/io/file_reader/properties/config.properties";
	//-----------------------------------------------------------------------------------------------------
	private Reader reader;
	
	//PROPERTIES
	private String JIRA_URL = "";
	private String JIRA_ADMIN_USERNAME = "";
	private String JIRA_ADMIN_PASSWORD = "";
	private String PROJECT = "";
	private String ATTACH_DIR = "";
	private String FORM_ID = "";
	private String MIGRATION_COMPLEXITY_ID = "";
	private String STRUCTURAL_COMPLEXITY_ID = "";
	private String SOLUTION_CENTER_ID = "";
	private String BANNER_MODULE_ID = "";
	private String BANNER_MODULE = "";
	private String SOLUTION_CENTER = "";
	private String ISSUE_TYPE = "";
	private String SUBTASK_ISSUE_TYPE = "";

	//CONTRUCTOR
	public PropertiesJira() {
		reader = new Reader();
		JIRA_URL = reader.readFileReader(path, "JIRA_URL");
		JIRA_ADMIN_USERNAME = reader.readFileReader(path, "JIRA_ADMIN_USERNAME");
		JIRA_ADMIN_PASSWORD = reader.readFileReader(path, "JIRA_ADMIN_PASSWORD");
		PROJECT = reader.readFileReader(path, "PROJECT");
		ATTACH_DIR = reader.readFileReader(path, "ATTACH_DIR");
		FORM_ID = reader.readFileReader(path, "FORM_ID");
		MIGRATION_COMPLEXITY_ID = reader.readFileReader(path, "MIGRATION_COMPLEXITY_ID");
		STRUCTURAL_COMPLEXITY_ID = reader.readFileReader(path, "STRUCTURAL_COMPLEXITY_ID");
		SOLUTION_CENTER_ID = reader.readFileReader(path, "SOLUTION_CENTER_ID");
		BANNER_MODULE_ID = reader.readFileReader(path, "BANNER_MODULE_ID");
		BANNER_MODULE = reader.readFileReader(path, "BANNER_MODULE");
		SOLUTION_CENTER = reader.readFileReader(path, "SOLUTION_CENTER");
		ISSUE_TYPE = reader.readFileReader(path, "ISSUE_TYPE");
		SUBTASK_ISSUE_TYPE = reader.readFileReader(path, "SUBTASK_ISSUE_TYPE");
	}
	
	//GETTERS AND SETTERS
	public String getJIRA_URL() {
		return JIRA_URL;
	}

	public static String getPath() {
		return path;
	}

	public Reader getReader() {
		return reader;
	}

	public String getJIRA_ADMIN_USERNAME() {
		return JIRA_ADMIN_USERNAME;
	}

	public String getJIRA_ADMIN_PASSWORD() {
		return JIRA_ADMIN_PASSWORD;
	}

	public String getPROJECT() {
		return PROJECT;
	}

	public String getATTACH_DIR() {
		return ATTACH_DIR;
	}

	public String getFORM_ID() {
		return FORM_ID;
	}

	public String getMIGRATION_COMPLEXITY_ID() {
		return MIGRATION_COMPLEXITY_ID;
	}

	public String getSTRUCTURAL_COMPLEXITY_ID() {
		return STRUCTURAL_COMPLEXITY_ID;
	}

	public String getSOLUTION_CENTER_ID() {
		return SOLUTION_CENTER_ID;
	}

	public String getBANNER_MODULE_ID() {
		return BANNER_MODULE_ID;
	}

	public String getBANNER_MODULE() {
		return BANNER_MODULE;
	}

	public String getSOLUTION_CENTER() {
		return SOLUTION_CENTER;
	}

	public String getISSUE_TYPE() {
		return ISSUE_TYPE;
	}

	public String getSUBTASK_ISSUE_TYPE() {
		return SUBTASK_ISSUE_TYPE;
	}

	

	
	

}
