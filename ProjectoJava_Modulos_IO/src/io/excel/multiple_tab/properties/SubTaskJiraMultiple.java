package io.excel.multiple_tab.properties;

//DAO CLASS
public class SubTaskJiraMultiple {

	// ATTRIBUTES
	private String id;
	private String title;
	private String description;
	private String sheet;

	// CONSTRUCTOR
	public SubTaskJiraMultiple(String sheet, String id, String title, String description) {
		this.sheet = sheet;
		this.id = id;
		this.title = title;
		this.description = description;
	}

	// GETTERS
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "SHEET -> " + sheet + "\n";
		toReturn += "   - id -> " + id + "\n";
		toReturn += "   - title -> " + title + "\n";
		toReturn += "   - description -> " + description;
		return toReturn;
	}
	
	// GETTERS
}




