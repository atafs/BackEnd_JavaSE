package io.scanner.comparator;

import java.util.Comparator;

import io.scanner.properties.SubTaskJiraWithScanner;

public class ComparatorOfSubtaskByName implements Comparator<SubTaskJiraWithScanner> {

	@Override
	public int compare(SubTaskJiraWithScanner c1, SubTaskJiraWithScanner c2) {
		if (c1.getTitle()== c2.getTitle() )
			return c1.getDescription().compareTo(c2.getDescription());		
		return c1.getTitle().compareTo(c2.getTitle()) ;
	}
}


