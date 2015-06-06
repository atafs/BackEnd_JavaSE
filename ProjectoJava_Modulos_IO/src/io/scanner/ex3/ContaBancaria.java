package io.scanner.ex3;

import java.util.LinkedList;
import java.util.List;

public abstract class ContaBancaria {
	private String id;
	private String nomeCliente;
	private List<Movimento> linhasDeMovimentos = new LinkedList<Movimento>();
	// ...
	
	public abstract double saldoMédioEstimado();

	public String getId() {
		return id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public List<Movimento> getLinhasDeMovimentos() {
		return linhasDeMovimentos;
	}

	public void addMovimento(Movimento movimento) {
		linhasDeMovimentos.add(movimento);		
	}
	
}