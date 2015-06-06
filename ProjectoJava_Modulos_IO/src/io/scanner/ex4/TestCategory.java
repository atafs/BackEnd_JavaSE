package io.scanner.ex4;

import java.io.FileNotFoundException;
import java.util.List;

import  io.scanner.ex3.Categoria;

public class TestCategory {

	public static void main(String[] args) {
		try {
			List<Categoria> categorias = Categoria.lerCategorias("src/io/scanner/properties/readFromFile.txt");
			System.out.println(categorias);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
