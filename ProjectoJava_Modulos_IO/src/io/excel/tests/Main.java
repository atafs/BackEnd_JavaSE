package io.excel.tests;

import java.io.IOException;
import java.util.ArrayList;

import io.Reader;
import io.Writer;
import io.excel.properties.SubTaskJira;
import jxl.write.Label;
import jxl.write.Number;


public class Main {

	//ATTRIBUTES: INPUT DATA ----------------------------------------------------------------
	//private static final String pathWriteTo = "C:\\ellucian_jira\\JiraCreate\\Workspace\\jira-rest-java-client-parent\\src\\main\\java\\com\\sebasi\\jira\\io\\excel\\properties\\writeToFile.xls";
	//private static final String pathReadFrom = "C:\\ellucian_jira\\JiraCreate\\Workspace\\jira-rest-java-client-parent\\src\\main\\java\\com\\sebasi\\jira\\io\\excel\\properties\\readFromFile.xls";
	
	private static final String pathWriteTo = "src/io/excel/properties/writeToFile.xls";
	private static final String pathReadFrom = "src/io/excel/properties/readFromFile.xls";
	//-----------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
		
		//INSTANTIATE
		Writer writer = new Writer();
		
		//LIST
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Label(0, 0, "SUCESS: a new record"));
		list.add(new Number(0, 1, 40));		
		
		//CONSOLE
		System.out.println("--------------PRINT CELLS: WRITER------------------");
		for (Object cell : list) {
			System.out.println(cell.getClass());
		}
		
		//WRITE
		writer.writeToExcel(pathWriteTo, list);

		
		System.out.println("\n--------------PRINT CELLS: 1-READER------------------");
		Reader reader = new Reader(pathReadFrom);
		reader.readExcel();
		
		System.out.println("\n--------------PRINT CELLS: 2-READER------------------");
		for (SubTaskJira subTask : reader.getSubTaskJiraList()) {
			System.out.println(subTask.toString() + "\n");
		}
		
		/*///////////////////////////////////////////////////////////////////// */

		System.err.println("\n--------------ENDED WITH SUCCESS------------------");
		System.err.println("\nVery Nice ;-)");
		

//		create1SubTask( project, client,  "TEST456", "277029", "Validate that all fields appear in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277030", "Insert a new record with Exempt Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277031", "Insert a new record with Given Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277032", "Insert a new record with Refused Verification Status in the page Additional ID Verification (GKAADIV", "functional_test", "General - Solution Centers", "AUSTRALIA" );
	}
}
