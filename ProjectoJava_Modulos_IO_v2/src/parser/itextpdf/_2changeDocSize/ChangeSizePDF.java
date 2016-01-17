package parser.itextpdf._2changeDocSize;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ChangeSizePDF {

	//MAIN
	public static void main(String[] args) {
		//DOCUMENT
		Document document = new Document();
		
		//OR
//		Rectangle rect = new Rectangle(PageSize.LETTER.rotate());
//		document.setPageSize(rect);
		//OR
		document.setPageSize(PageSize.A6.rotate());
		
		try {
			//CREATE DOCUMENT
			PdfWriter.getInstance(document, new FileOutputStream(".\\pdf\\_2changeSizePDF.pdf"));
			
			//OPEN AND USE DOCUMENT
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("THIS IS A SUPER PDF changeSizePDF!!");
			document.add(paragraph);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		
		//PRINT
		System.err.println("ENDED WITH SUCCESS!!");
	}
}