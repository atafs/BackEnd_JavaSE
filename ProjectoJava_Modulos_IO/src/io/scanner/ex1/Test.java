package io.scanner.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.scanner.ex2.ComparatorOfCarByYear;

public class Test {

	// Teste para os exercícios 1 e 2
	public static void main(String[] args) {
		List<Car> carros = new ArrayList<Car>(); 
		carros.add(new Car("CC-11-22", 2009));
		carros.add(new Car("BB-11-22", 2000));
		carros.add(new Car("AA-11-22", 2005));
		carros.add(new Car("DD-11-22", 2000));
		
		System.out.println(carros);
		
		Collections.sort(carros, new ComparatorOfCarByYear());
		
		System.out.println(carros);
		
	}

}
