package io.excel.jira_single_tab.properties;

//DAO CLASS
public class SubTaskJiraFinal {
	
	//ATTRIBUTES
	private String moduleType;
	private String moduleName;
	private String structuralComplexity; 
	private String migrationComplexity;
	private String sheet;
	
	//CONSTRUCTOR
	public SubTaskJiraFinal(String sheet, String moduleType, String moduleName) {
		this.sheet = "ONLY ONE SHEET";
		this.moduleName = moduleName;
	}
	
	public SubTaskJiraFinal(String sheet, String moduleType, String moduleName, String structuralComplexity, String migrationComplexity) {
		this(sheet, moduleType, moduleName);
		this.structuralComplexity = structuralComplexity;
		this.migrationComplexity = migrationComplexity;
		
	}

	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "SHEET -> " + sheet + "\n";
		toReturn += "   - moduleType -> " + moduleType + "\n";
		toReturn += "   - moduleName -> " + moduleName + "\n";
		toReturn += "   - structuralComplexity -> " + structuralComplexity + "\n";
		toReturn += "   - migrationComplexity -> " + migrationComplexity + "\n";
		return toReturn;
	}

	
	//GETTERS
	public String getModuleName() {
		return moduleName;
	}

	public String getStructuralComplexity() {
		return structuralComplexity;
	}

	public String getMigrationComplexity() {
		return migrationComplexity;
	}

	public String getSheet() {
		return sheet;
	}

	public String getModuleType() {
		return moduleType;
	}
}
