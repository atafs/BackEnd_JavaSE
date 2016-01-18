package io.bytes.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFileBytes {
	
	//MAIN
	public static void main(String[] args) {
		//CREATE FILE (path of it)
		File path = new File("txt//FileByte.txt");
		
		//PRINT INFO OF FILE
		System.out.println("-------------WriteFileBytes----------------");
		System.out.println("We got a file: \t\t" + path.getAbsolutePath());
		System.out.println("Does it exist? \t\t" + path.exists()); 
		System.out.println("Is it a Directory? \t" + path.isDirectory());
		
		//DATA
		String contentToWrite = "Hello World of Strings!!";
		
		//OUT: WRITER
		try {
			OutputStream outputStream = new FileOutputStream(path);
			outputStream.write(contentToWrite.getBytes());
			System.err.println("WROTE IN BYTES: \t" + contentToWrite);
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
