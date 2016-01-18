package io.bytes.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileBytes {

	//MAIN
	public static void main(String[] args) {
		//CREATE FILE (path of it)
		File path = new File("txt//FileByte.txt");
		
		//PRINT INFO OF FILE
		System.err.println("---------------ReadFileBytes--------------------");
		System.err.println("We got a file: \t\t" + path.getAbsolutePath());
		System.err.println("Does it exist? \t\t" + path.exists()); 
		System.err.println("Is it a Directory? \t" + path.isDirectory());
		
		try {
			//IN: READER
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			
			//DATA: FIRST LINE
			String firstLine = reader.readLine();
			
			//PRINT
			System.out.println("READS: \t\t\t" + firstLine);
			
			//CLOSE
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
