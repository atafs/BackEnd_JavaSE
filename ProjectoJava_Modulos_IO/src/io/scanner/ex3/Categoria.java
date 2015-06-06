package io.scanner.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Categoria {
	
	private String nome;
	private Categoria base;
	private List<String> descrição;

	public Categoria(String nome, Categoria base, List<String> descricção) {
		super();
		this.nome = nome;
		this.base = base;
		this.descrição = descricção;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getBase() {
		return base;
	}

	public List<String> getDescricção() {
		return descrição;
	}

	public static List<Categoria> lerCategorias(String nomeFicheiro) throws FileNotFoundException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Scanner s = new Scanner(new File(nomeFicheiro));
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] tokens = line.split(";");
			categorias.add(new Categoria(tokens[0], categoriaDadoNome(tokens[1], categorias), getDescricoes(tokens)));
		}
		s.close();
		return categorias;
	}

	private static List<String> getDescricoes(String[] tokens) {
		// Caso não soubesse esta solução poderia fazer de outra maneira
		List<String> list = Arrays.asList(tokens);
		list = list.subList(2, list.size());
		return list;
	}

	private static Categoria categoriaDadoNome(String nome,
			List<Categoria> categorias) {
		for (Categoria c: categorias)
			if (nome.equals(c.getNome()))
				return c;
		return null;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ( base != null ?", base=" + base.getNome() : "" ) + ", descrição="
				+ descrição + "]";
	}
	
}
