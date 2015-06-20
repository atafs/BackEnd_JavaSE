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
import io.excel.jira_single_tab.properties.SubTaskJiraFinal;
import io.excel.multiple_tab.properties.SubTaskJiraMultiple;

public class NReader_jiraTabs {
	
	//ATTRIBUTES 
	private String inputFile;
	private SubTaskJiraFinal subTask;
	//LISTS
	private List<SubTaskJiraFinal> subTaskJiraList = new ArrayList<SubTaskJiraFinal>();
	//private List<Integer> columnExcelList = new ArrayList<Integer>();
	private Map<String, List<SubTaskJiraFinal>> mapExcel = new HashMap<String, List<SubTaskJiraFinal>>();
	private String[] sheetNames;
	
	//CONSTRUCTOR
	public NReader_jiraTabs(String inputFile) {
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
	
	// AUX METHOD
	public Map<String, List<SubTaskJiraFinal>> readExcelAllTabs() {
				
		Workbook workBook;
		List<SubTaskJiraFinal> subTaskJiraListTabs;
		try {
			//INSTANTIATE: Workbook;
			workBook = Workbook.getWorkbook(new File(inputFile));
			sheetNames = workBook.getSheetNames();
			//columnExcelList = readExcelSelectThreeColumns();
			Sheet sheet;
			
			for (int sheetNumber = 0; sheetNumber < sheetNames.length; sheetNumber++) {
				// INSTANTIATE: Sheet, Cell;
				sheet = workBook.getSheet(sheetNumber);
				Cell[] rowExcel = new Cell[4];
				subTaskJiraListTabs = new ArrayList<SubTaskJiraFinal>();

				// READ AND KEEP IN JAVA CLASS ALL CELLS FROM SHEET
				for (int i = 0; i < sheet.getRows(); i++) {
					for (int j = 0; j < sheet.getColumns() + 1; j++) {

						// CHANGE ROW
						if (j == 4) {
							// AVOID EMPTY ROW
							if (rowExcel[0].getContents() == "") {
								break;
							}
							subTask = new SubTaskJiraFinal(				
									rowExcel[0].getContents(),
									rowExcel[1].getContents(),
									rowExcel[2].getContents(),
									rowExcel[3].getContents(),
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
						subTask = new SubTaskJiraFinal(rowExcel[0].getContents(), rowExcel[1].getContents(), rowExcel[2].getContents(), rowExcel[3].getContents(), rowExcel[3].getContents());
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
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	} 
	
	//GETTERS
	public String getInputFile() {
		return inputFile;
	}

	public SubTaskJiraFinal getSubTask() {
		return subTask;
	}

	public List<SubTaskJiraFinal> getSubTaskJiraList() {
		return subTaskJiraList;
	}

	public Map<String, List<SubTaskJiraFinal>> getMapExcel() {
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
