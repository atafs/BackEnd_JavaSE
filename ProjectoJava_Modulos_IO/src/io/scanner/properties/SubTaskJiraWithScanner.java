package io.scanner.properties;

//DAO CLASS
public class SubTaskJiraWithScanner {
	
	//ATTRIBUTES
	private String id;
	private String title;
	private String description;
	
	//CONSTRUCTOR
	public SubTaskJiraWithScanner(String id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	//GETTERS
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "id -> " + id + "; ";
		toReturn += "title -> " + title + "; ";
		toReturn += "description -> " + description + "; ";
		return toReturn;
	}
}
