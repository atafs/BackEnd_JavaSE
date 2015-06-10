package io;

import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Writer {
	
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
	
	//PARAGRAPH
	public void paragraph() {
		System.out.println();
	}
	
}
