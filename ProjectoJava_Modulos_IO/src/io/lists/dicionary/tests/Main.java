package io.lists.dicionary.tests;

import io.bundle.properties.BundlePath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		//INITIALIZE PATH
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathInputDicionary = bundle.displayValue(supportedLocales, "pathInputDicionary");
		
		//READER
		BufferedReader reader = new BufferedReader(new FileReader(new File(pathInputDicionary)));
		String inputLine = null;
		
		//LIST
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		//Map dictionary = new Hashtable();
		
		while((inputLine = reader.readLine()) != null) {
			// Split the input line.
			String[] words = inputLine.split("\\s+");
			
			// Ignore empty lines.
			if(inputLine.equals(""))
				continue;
			
			for(String word: words) {
				// Remove any commas and dots.
				word = word.replace(".", "");
				word = word.replace(",", "");
				
				if(dictionary.containsKey(word)) {
					Integer val = (Integer) dictionary.get(word);
					dictionary.put(word, val + 1);
				}
				else
					dictionary.put(word, 1);
			}
		}
		
		// Printing all words stored in the map.
		for(Object key: dictionary.keySet())
			System.out.println(key + ": " + dictionary.get(key));
		
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
