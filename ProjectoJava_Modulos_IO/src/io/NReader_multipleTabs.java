package io;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import io.excel.properties.SubTaskJira;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import io.bundle.properties.BundlePath;
import io.scanner.properties.SubTaskJiraWithScanner;
import io.excel.multiple_tab.properties.SubTaskJiraMultiple;

public class NReader_multipleTabs {
	
	//ATTRIBUTES 
	private String inputFile;
	private SubTaskJiraMultiple subTask;
	//LISTS
	private List<SubTaskJiraMultiple> subTaskJiraList = new ArrayList<SubTaskJiraMultiple>();
	//private List<Integer> columnExcelList = new ArrayList<Integer>();
	private Map<String, List<SubTaskJiraMultiple>> mapExcel = new HashMap<String, List<SubTaskJiraMultiple>>();
	private String[] sheetNames;
	
	//CONSTRUCTOR
	public NReader_multipleTabs(String inputFile) {
		this.inputFile = inputFile;
	}
	
//	public NReader_v2() {
//		//inputFile = null;
//	}

	//READ FROM FILE READER PROPERTIES
	public String readFileReader(String path, String string) {
		String toReturn = "";
		try{
			FileReader reader = new FileReader(path);
			Properties properties = new Properties();
			properties.load(reader);
			toReturn = properties.getProperty(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
//	//AUX METHOD
//	//TODELETE
//	public  List<Integer> readExcelSelectThreeColumns() {
//		//INITIALIZE
//		BundlePath bundle = new BundlePath();
//		Locale supportedLocale = Locale.ENGLISH;
//		
//		//CREATE AND GET INTEGER OF COLUMN TO EXCEL FROM BUNDLE
//		String columnId = bundle.displayValue(supportedLocale, "Id");
//		String columnTitle = bundle.displayValue(supportedLocale, "Title");
//		String columnDescription = bundle.displayValue(supportedLocale, "Description");
//		String columnSize = bundle.displayValue(supportedLocale, "Size");
//		
//		//ADD TO LIST
//		columnExcelList.add(Integer.parseInt(columnId));
//		columnExcelList.add(Integer.parseInt(columnTitle));
//		columnExcelList.add(Integer.parseInt(columnDescription));
//		columnExcelList.add(Integer.parseInt(columnSize));
//		
//		return columnExcelList;
//	}
	
	// AUX METHOD
	public Map<String, List<SubTaskJiraMultiple>> readExcelAllTabs() {
				
		Workbook workBook;
		List<SubTaskJiraMultiple> subTaskJiraListTabs;
		try {
			//INSTANTIATE: Workbook;
			workBook = Workbook.getWorkbook(new File(inputFile));
			sheetNames = workBook.getSheetNames();
			//columnExcelList = readExcelSelectThreeColumns();
			Sheet sheet;
			
			for (int sheetNumber = 0; sheetNumber < sheetNames.length; sheetNumber++) {
				// INSTANTIATE: Sheet, Cell;
				sheet = workBook.getSheet(sheetNumber);
				Cell[] rowExcel = new Cell[3];
				subTaskJiraListTabs = new ArrayList<SubTaskJiraMultiple>();

				// READ AND KEEP IN JAVA CLASS ALL CELLS FROM SHEET
				for (int i = 0; i < sheet.getRows(); i++) {
					for (int j = 0; j < sheet.getColumns() + 1; j++) {

						// CHANGE ROW
						if (j == 3) {
							// AVOID EMPTY ROW
							if (rowExcel[0].getContents() == "") {
								break;
							}
							subTask = new SubTaskJiraMultiple(				
									rowExcel[0].getContents(),
									rowExcel[1].getContents(),
									rowExcel[2].getContents(),
									sheetNames[sheetNumber] 
							);
							subTaskJiraListTabs.add(subTask);
							break;
						}

						// CELL
						Cell cell = sheet.getCell(j, i);
						rowExcel[j] = cell;
						CellType type = cell.getType();
						// CONDITION
						if (type == CellType.LABEL) {
							System.err.println("I got a label "
									+ cell.getContents());
						}
						if (type == CellType.NUMBER) {
							System.out.println("I got a number "
									+ cell.getContents());
						}

//						// TODELETE: PAUSE IN PRINT TO CONSOLE
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}

					}
				}
				// SAVE TO LIST
				mapExcel.put(sheetNames[sheetNumber], subTaskJiraListTabs);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mapExcel;
	}
	
	//READ FROM EXCEL FILE
	public void readExcelAllTabsPrintConsole() throws IOException {
	
		try {
			
			//ADD TO MAP ALL DATA TO EXCEL
			mapExcel = readExcelAllTabs();
			
//			//ITERATE HASHMAP_VERSION01
//			Iterator it = mapExcel.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pair = (Map.Entry)it.next();
//		        System.out.println(pair.getKey() + " = " + pair.getValue());
//		        it.remove(); // avoids a ConcurrentModificationException
//		    }
		    
//		  //ITERATE HASHMAP_VERSION02
//			for (Map.Entry<String, List<SubTaskJira>> entry : mapExcel.entrySet()) {
//				String key = entry.getKey();
//				System.err.println("entry.getValue()"+entry.getValue());
//				System.err.println("key"+entry.getKey());
//
//				List<SubTaskJira> sheet = entry.getValue();
//				// do something with key and/or tab
//			}
			
//			//ITERATE HASHMAP_VERSION03
//			for ( Map.Entry<String, List<SubTaskJira>> entry : mapExcel.entrySet()) {
//			    for (SubTaskJira subtask : entry.getValue()) {
//			    	System.err.println(subtask);
//				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	//READ FROM EXCEL FILE
	public void readExcelOneTabThreeColumns() throws IOException {
		
		File inputWoorkbook = new File(inputFile);
		Workbook w;
		
		//CALL THE BUNDLE INDEX OF EXCEL
		//columnExcelList = readExcelSelectThreeColumns();
		
		try {
			w = Workbook.getWorkbook(inputWoorkbook);
			
			//SET THE FIRST SHEET
			Sheet sheet = w.getSheet(0);
			Cell[] rowExcel = new Cell[5];
			//Cell[] rowExcel = new Cell[columnExcelList.get(20)];
			
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns()+1; j++) {
					
					//CHANGE ROW
					//if (j == columnExcelList.get(3)) {
					if (j == 5) {

						//AVOID EMPTY ROW
						if (rowExcel[0].getContents() == "") {
							break;
						}
						//subTask = new SubTaskJira(rowExcel[columnExcelList.get(0)].getContents(), rowExcel[columnExcelList.get(7)].getContents(), rowExcel[columnExcelList.get(13)].getContents());
						subTask = new SubTaskJiraMultiple(rowExcel[0].getContents(), rowExcel[1].getContents(), rowExcel[2].getContents(), rowExcel[3].getContents());
						subTaskJiraList.add(subTask);
						break;
					}
					
					//CELL
					Cell cell = sheet.getCell(j,i);
					rowExcel[j] = cell;
					CellType type = cell.getType();
					
					//PRINT TO CONSOLE
					if (type == CellType.LABEL) {
						System.err.println("I got a label " + cell.getContents());
					}
					if (type == CellType.NUMBER) {
						System.out.println("I got a number " + cell.getContents());
					}
					
//					//TODELETE: PAUSE IN PRINT TO CONSOLE
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	} 
	
	//READ FROM FILE WITH SCANNER
	public  List<SubTaskJiraWithScanner> readWithScanner(String nomeFicheiro) throws FileNotFoundException {
		List<SubTaskJiraWithScanner> subtasks = new ArrayList<SubTaskJiraWithScanner>();
		Scanner s = new Scanner(new File(nomeFicheiro));
		
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] tokens = line.split(";");
			
			//CHECK FOR THE THREE VALUES NEEDED
			subtasks.add(new SubTaskJiraWithScanner(tokens[0], tokens[1],  tokens[2]));
		}
		s.close();
		return subtasks;
	}
	
	//GETTERS
	public String getInputFile() {
		return inputFile;
	}

	public SubTaskJiraMultiple getSubTask() {
		return subTask;
	}

	public List<SubTaskJiraMultiple> getSubTaskJiraList() {
		return subTaskJiraList;
	}

	public Map<String, List<SubTaskJiraMultiple>> getMapExcel() {
		return mapExcel;
	}

	public String[] getSheetNames() {
		return sheetNames;
	}

	//PARAGRAPH
	public void paragraph() {
		System.out.println();
	}
}
