package io;

import io.nodes.properties.NodeJira;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class NWriter {
	
	//ATTRIBUTES
		private File nodeFile;
		
	// CONSTRUCTOR
	public NWriter(File nodeFile) {
		this.nodeFile = nodeFile;
	}

	public NWriter() {
		// NOT NEEDED THIS VARIABLE IF CALLED THIS WAY
		//this.nodeFile = null;
	}

	// GETTER
	public File getNodeFile() {
		return nodeFile;
	}
	
	//WRITE TO EXCEL 
	public void writeToExcel(String path, ArrayList<Object> cells) {
		try {
			//EXCEL
			WritableWorkbook workbook = Workbook.createWorkbook(new File(path));
			WritableSheet sheet =workbook.createSheet("MorphisSheet", 0);
			
			//ADDING CELLS
			for (Object cell : cells) {
				sheet.addCell((WritableCell) cell);
			}
			
			//WRITE
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//WRITE TO TXT
	public void writePrintWriter(String pathPrintWriter, NodeJira node) {

		File file = new File(pathPrintWriter);
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(pathPrintWriter);
			
			//PRINT TO FILE TXT
			for (String string : node.getNodeList()) {
				printWriter.println(string);
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//PARAGRAPH
	public void paragraph() {
		System.out.println();
	}
	
}
