package io.json.tests;

import io.json.properties.HighScores;
import io.json.properties.Jogador;

public class Main {

	public static void main(String[] args) {
		HighScores highScores = new HighScores();
		
		highScores.leFicheiroJSON("src/io/json/properties/readFromJSON.json");
		System.out.println(highScores);
		
		
		highScores.adicionaJogador(new Jogador("Ana", new Long(60)));
		System.out.println(highScores);
		
		highScores.escreveFicheiroJSON("src/io/json/properties/writeToJSON.json");
	}
}
