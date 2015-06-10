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
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import io.excel.properties.SubTaskJira;
import io.scanner.properties.SubTaskJiraWithScanner;

public class NReader {
	
	//ATTRIBUTES 
	private String inputFile;
	private SubTaskJira subTask;
	private List<SubTaskJira> subTaskJiraList = new ArrayList<SubTaskJira>();
	
	//CONSTRUCTOR
	public NReader(String inputFile) {
		this.inputFile = inputFile;
	}
	
	public NReader() {
		inputFile = null;
	}

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
	
	//READ FROM EXCEL FILE
	public void readExcel() throws IOException {
		
		File inputWoorkbook = new File(inputFile);
		Workbook w;
		
		try {
			w = Workbook.getWorkbook(inputWoorkbook);
			
			//SET THE FIRST SHEET
			Sheet sheet = w.getSheet(0);
			Cell[] rowExcel = new Cell[3];
			
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns()+1; j++) {
					
					//CHANGE ROW
					if (j == 3) {
						//AVOID EMPTY ROW
						if (rowExcel[0].getContents() == "") {
							break;
						}
						//CREATE AND KEEP IN LIST
						subTask = new SubTaskJira(rowExcel[0].getContents(), rowExcel[1].getContents(), rowExcel[2].getContents());
						subTaskJiraList.add(subTask);
						break;
					}
					
					//CELL
					Cell cell = sheet.getCell(j,i);
					rowExcel[j] = cell;
					CellType type = cell.getType();
					//CONDITION
					if (type == CellType.LABEL) {
						System.err.println("I got a label " + cell.getContents());
					}
					if (type == CellType.NUMBER) {
						System.out.println("I got a number " + cell.getContents());
					}
					
					//PAUSE IN PRINT TO CONSOLE
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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

	public SubTaskJira getSubTask() {
		return subTask;
	}

	public List<SubTaskJira> getSubTaskJiraList() {
		return subTaskJiraList;
	}

	//PARAGRAPH
	public void paragraph() {
		System.out.println();
	}
}
