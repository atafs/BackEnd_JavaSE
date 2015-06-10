package io.scanner.tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import io.NReader;
import io.bundle.properties.BundlePath;
import io.scanner.comparator.ComparatorOfSubtaskByName;
import io.scanner.comparator.ComparatorOfSubtasksById;
import io.scanner.properties.SubTaskJiraWithScanner;

public class Main {

	//MAIN
	public static void main(String[] args) {
		
		//INITIALIZE PATH
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathScannerRead = bundle.displayValue(supportedLocales, "pathScannerRead");
		
		//READER
		NReader reader = new NReader();
		
		//LISTS
		List<SubTaskJiraWithScanner> subtasks = new ArrayList<SubTaskJiraWithScanner>(); 
		List<SubTaskJiraWithScanner> subtasks_02 = new ArrayList<SubTaskJiraWithScanner>(); 
		
		//ADD TO LIST FROM HARDCODING
		subtasks = new ArrayList<SubTaskJiraWithScanner>(); 
		subtasks.add(new SubTaskJiraWithScanner("14567", "Subtask01", "aaaaaaaaaaaaaaaa"));
		subtasks.add(new SubTaskJiraWithScanner("45687", "Subtask02", "bbbbbbbbbbbbbbbb"));
		subtasks.add(new SubTaskJiraWithScanner("96547", "Subtask03", "cccccccccccccccc"));
		subtasks.add(new SubTaskJiraWithScanner("21478", "Subtask04", "dddddddddddddddd"));
		
		//ADD TO LIST FROM FILE TXT
		try {
			subtasks_02 = reader.readWithScanner(pathScannerRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//CONSOLE
		System.err.println("--------------------SCANNER: HARDCODED IN MAIN--------------------");
		for (SubTaskJiraWithScanner subTaskJiraWithScanner : subtasks) {
			System.err.println(subTaskJiraWithScanner);
		}
		sleepFor(500);
		System.err.println();
		
		//SORT
		Collections.sort(subtasks, new ComparatorOfSubtasksById());
		System.out.println("--------------------SCANNER: HARDCODED IN MAIN - SORTED--------------------");
		for (SubTaskJiraWithScanner subTaskJiraWithScanner : subtasks) {
			System.out.println(subTaskJiraWithScanner);
		}
		sleepFor(500);
		System.out.println();
		
		System.err.println("--------------------SCANNER: IN MAIN FROM FILE--------------------");
		for (SubTaskJiraWithScanner subTaskJiraWithScanner : subtasks_02) {
			System.err.println(subTaskJiraWithScanner);
		}
		sleepFor(500);
		System.err.println();
		
		//SORT
		System.out.println("--------------------SCANNER: IN MAIN FROM FILE - SORTED---------------------");
		Collections.sort(subtasks_02, new ComparatorOfSubtaskByName());
		for (SubTaskJiraWithScanner subTaskJiraWithScanner : subtasks_02) {
			System.out.println(subTaskJiraWithScanner);
		}
		sleepFor(500);
		System.out.println();
	}
	
	//SLEEP
	public static void sleepFor(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
