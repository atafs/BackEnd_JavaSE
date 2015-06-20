package io.excel.single_tab.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import io.NReader;
import io.NWriter;
import io.bundle.properties.BundlePath;
import io.excel.single_tab.properties.SubTaskJira;
import io.json.properties.TaskJSON;
import jxl.write.Label;
import jxl.write.Number;


public class Main {

	//ATTRIBUTES: INPUT DATA ----------------------------------------------------------------
	//private static final String pathWriteTo = "C:\\ellucian_jira\\JiraCreate\\Workspace\\jira-rest-java-client-parent\\src\\main\\java\\com\\sebasi\\jira\\io\\excel\\properties\\writeToFile.xls";
	//private static final String pathReadFrom = "C:\\ellucian_jira\\JiraCreate\\Workspace\\jira-rest-java-client-parent\\src\\main\\java\\com\\sebasi\\jira\\io\\excel\\properties\\readFromFile.xls";
	
	//private static final String pathWriteTo = "src/main/java/com/sebasi/jira/io/excel/properties/writeToFile.xls";
	//private static final String pathReadFrom = "src/main/java/com/sebasi/jira/io/excel/properties/readFromFile.xls";
	//-----------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
		
		//INITIALIZE PATH
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathWriteToExcel = bundle.displayValue(supportedLocales, "pathWriteToExcel");
		String pathReadFromExcel = bundle.displayValue(supportedLocales, "pathReadFromExcel");
		String pathWriteFromExcelToJSON = bundle.displayValue(supportedLocales, "pathWriteFromExcelToJSON");

		
		//INSTANTIATE
		NWriter writer = new NWriter();
		TaskJSON task = new TaskJSON();
		
		//LIST
		ArrayList<Object> list = new ArrayList<Object>();
		
		//INSERT DATA IN EXCEL
		for (int i = 0; i < 5; i++) {
			list.add(new Label(0, i, "SUCESS WITH MORPHIS" + i + ": a new record"));
			list.add(new Number(1, i, i));	
		}
			
		//CONSOLE
		System.out.println("--------------PRINT CELLS: WRITER------------------");
		for (Object cell : list) {
			System.out.println(cell.getClass());
		}
		
		//WRITE
		writer.writeToExcel(pathWriteToExcel, list);

		
		System.out.println("\n--------------PRINT CELLS: 1-READER------------------");
		NReader reader = new NReader(pathReadFromExcel);
		reader.readExcel();
		
		System.out.println("\n--------------PRINT CELLS: 2-READER------------------");
		for (SubTaskJira subTask : reader.getSubTaskJiraList()) {
			System.out.println(subTask.toString() + "\n");
		}
		
		System.err.println("\n-----------PRINT CELLS: 2-WRITE_JSON--------------");
		task.setLista(reader.getSubTaskJiraList());
		task.escreveFicheiroJSONThreeColumns(pathWriteFromExcelToJSON);
		System.err.println("DONE WITH SUCCESS");
		
	
		/*///////////////////////////////////////////////////////////////////// */

		System.err.println("\n--------------ENDED WITH SUCCESS------------------");
		System.err.println("\nVery Nice ;-)");
		

//		create1SubTask( project, client,  "TEST456", "277029", "Validate that all fields appear in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277030", "Insert a new record with Exempt Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277031", "Insert a new record with Given Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//		create1SubTask( project, client,  "TEST456", "277032", "Insert a new record with Refused Verification Status in the page Additional ID Verification (GKAADIV", "functional_test", "General - Solution Centers", "AUSTRALIA" );
	}
}
