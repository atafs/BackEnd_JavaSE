package io.scanner.ex2;

import java.util.Comparator;

import io.scanner.ex1.Car;

public class ComparatorOfCarByYear implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		if (c1.getYearOfConstruction() == c2.getYearOfConstruction())
			return c1.getPlate().compareTo(c2.getPlate());		
		return c1.getYearOfConstruction() - c2.getYearOfConstruction();
	}
	// …
}