package parser.itextpdf._3readerPDF;

import java.io.FileInputStream;

import com.itextpdf.text.pdf.PdfReader;

public class ReaderPDF {
	
	//MAIN
	public static void main(String[] args) {
		
		try {
			PdfReader reader = new PdfReader(new FileInputStream(".\\pdf\\_2changeSizePDF.pdf"));
			
			//PRINT PROPERTIES OF READER
			System.out.println("PDF Version: \t\t\t" + reader.getPdfVersion());
			System.out.println("Number of Pages: \t\t" + reader.getNumberOfPages());
			System.out.println("File Length: \t\t\t" + reader.getFileLength());
			System.out.println("Is it encrypted: \t\t" + reader.isEncrypted());
			
			System.out.println("With of page 1: \t\t" + reader.getPageSize(1).getWidth());
			System.out.println("Height of page 1: \t\t" + reader.getPageSize(1).getHeight());
			System.out.println("Rotation of page 1: \t\t" + reader.getPageSize(1).getRotation());
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
