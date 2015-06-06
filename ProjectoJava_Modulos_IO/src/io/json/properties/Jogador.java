package io.json.properties;

import java.io.Serializable;


public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private Long pontuacao;
	
	public Jogador(String nome, Long pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getPontuacao() {
		return pontuacao;
	}
	
	@Override
	public String toString() {
		return pontuacao + " - " + nome;
	}
}
