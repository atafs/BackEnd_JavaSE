package io.bytes.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReaderURL {
	
	// MAIN
	public static void main(String[] args) {
		try {
			// URL: Uniform Resource Locator (its location on a computer network)
			URL url = new URL("https://en.wikipedia.org/wiki/Main_Page");
			InputStream stream = url.openStream();
			
			// IN: READER
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			// DATA
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			// PRINT
			System.out.println("DONE READING WITH SUCCESS!!");

			// CLOSE
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
