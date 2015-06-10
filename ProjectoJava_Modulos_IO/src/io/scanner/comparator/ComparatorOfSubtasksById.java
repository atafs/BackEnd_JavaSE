package io.scanner.comparator;

import java.util.Comparator;

import io.scanner.properties.SubTaskJiraWithScanner;

public class ComparatorOfSubtasksById implements Comparator<SubTaskJiraWithScanner> {

	@Override
	public int compare(SubTaskJiraWithScanner c1, SubTaskJiraWithScanner c2) {
		if (c1.getId() == c2.getId() )
			return c1.getTitle().compareTo(c2.getTitle());		
		return c1.getId().compareTo(c2.getId()) ;
	}
}