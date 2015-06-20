package io.excel.jira_single_tab.tests;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import io.NReader_jiraTabs;
import io.bundle.properties.BundlePath;
import io.excel.jira_single_tab.properties.SubTaskJiraFinal;
import io.excel.multiple_tab.properties.SubTaskJiraMultiple;

public class MainJiraTab {
	
		//MAIN
		public static void main(String[] args) throws IOException {
			
			//INITIALIZE PATH
			BundlePath bundle = new BundlePath();
			Locale supportedLocales = Locale.ENGLISH;
//			String pathWriteToExcel = bundle.displayValue(supportedLocales, "pathWriteToExcelMultiple");
			String pathReadFromExcelMultipleJira = bundle.displayValue(supportedLocales, "pathReadFromExcelMultipleJira");

			//READER
			NReader_jiraTabs reader = new NReader_jiraTabs(pathReadFromExcelMultipleJira);
			Map<String, List<SubTaskJiraFinal>> mapExcel = reader.readExcelAllTabs();
			

	
			System.out.println("\n--------------PRINT CELLS: 1-READER: Read From HashMap------------------");

			//ITERATE HASHMAP_VERSION03
			for ( Entry<String, List<SubTaskJiraFinal>> entry : mapExcel.entrySet()) {
			    for (SubTaskJiraFinal subtask : entry.getValue()) {
			    	System.out.println(subtask);
				}
			}
			
			/*///////////////////////////////////////////////////////////////////// */

			System.err.println("\n--------------ENDED WITH SUCCESS------------------");
			System.err.println("Hello World of MORPHIS ;-)");
			


			
//			create1SubTask( project, client,  "TEST456", "277029", "Validate that all fields appear in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//			create1SubTask( project, client,  "TEST456", "277030", "Insert a new record with Exempt Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//			create1SubTask( project, client,  "TEST456", "277031", "Insert a new record with Given Verification Status in the page Additional ID Verification (GKAADIV)", "functional_test", "General - Solution Centers", "AUSTRALIA" );
//			create1SubTask( project, client,  "TEST456", "277032", "Insert a new record with Refused Verification Status in the page Additional ID Verification (GKAADIV", "functional_test", "General - Solution Centers", "AUSTRALIA" );
		}

}
