package parser.itextpdf._1createDocument;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class CreatePDF {

	//MAIN
	public static void main(String[] args) {
		//DOCUMENT
		Document document = new Document();
		try {
			//CREATE DOCUMENT
			PdfWriter.getInstance(document, new FileOutputStream(".\\pdf\\_1createPDF.pdf"));
			
			//OPEN AND USE DOCUMENT
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("THIS IS A SUPER PDF 1createPDF.pdf!!");
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