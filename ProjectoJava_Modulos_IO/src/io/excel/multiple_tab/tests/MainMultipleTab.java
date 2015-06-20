package io.excel.multiple_tab.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import jxl.write.Label;
import jxl.write.Number;
import io.NReader;
import io.NReader_multipleTabs;
import io.NWriter;
import io.bundle.properties.BundlePath;
import io.excel.single_tab.properties.SubTaskJira;

public class MainMultipleTab {
	
		//MAIN
		public static void main(String[] args) throws IOException {
			
			//INITIALIZE PATH
			BundlePath bundle = new BundlePath();
			Locale supportedLocales = Locale.ENGLISH;
//			String pathWriteToExcel = bundle.displayValue(supportedLocales, "pathWriteToExcelMultiple");
			String pathReadFromExcelMultiple = bundle.displayValue(supportedLocales, "pathReadFromExcelMultiple");

//			//INSTANTIATE
//			NWriter writer = new NWriter();
//			
//			//LIST
//			ArrayList<Object> list = new ArrayList<Object>();
//			
//			//INSERT DATA IN EXCEL
//			for (int i = 0; i < 5; i++) {
//				list.add(new Label(0, i, "SUCESS WITH MORPHIS" + i + ": a new record"));
//				list.add(new Number(1, i, i));	
//			}
//				
//			//CONSOLE
//			System.out.println("--------------PRINT CELLS: WRITER------------------");
//			for (Object cell : list) {
//				System.out.println(cell.getClass());
//			}
//			
//			//WRITE
//			writer.writeToExcel(pathWriteToExcel, list);

			
			System.out.println("\n--------------PRINT CELLS: 1-READER: AllTabAllColumns------------------");
			NReader_multipleTabs reader = new NReader_multipleTabs(pathReadFromExcelMultiple);
			reader.readExcelAllTabsPrintConsole(
);
			
			System.out.println("\n--------------PRINT CELLS: 2-READER: Read From HashMap------------------");
			//ITERATE HASHMAP_VERSION01
			Iterator it = reader.getMapExcel().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue() + "\n");
		        it.remove(); // avoids a ConcurrentModificationException
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
