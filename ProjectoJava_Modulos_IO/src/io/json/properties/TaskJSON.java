package io.json.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TaskJSON {

	private ArrayList<SubTaskJSON> lista;

	public TaskJSON() {
		lista = new ArrayList<SubTaskJSON>();
	}

	public void adicionaSubTask(SubTaskJSON jogador) {
		lista.add(jogador);
	}

	@Override
	public String toString() {
		String toReturn = "";

		for (SubTaskJSON jogador : lista) {
			toReturn += jogador.toString() + "\n";
		}

		return toReturn;
	}

	// alinea b).
	public void escreveFicheiroSerializado(String nomeFicheiro){
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
			try {
				output.writeObject(lista);
			} finally {
				output.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void leFicheiroSerializado(String nomeFicheiro) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(nomeFicheiro));
			try {
				lista = (ArrayList)input.readObject();
			} finally {
				input.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// alinea c)
	public void leFicheiroJSON(String nomeFicheiro) {
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = 
					(JSONArray) parser.parse(new BufferedReader(new FileReader(nomeFicheiro)));
		
			for (Object object : array) {
				JSONObject jsonObject = (JSONObject) object;
				String nome = (String)jsonObject.get("nome");
				Long pontuacao = (Long)jsonObject.get("pontuacao");
				
				SubTaskJSON jogador = new SubTaskJSON(nome, pontuacao);
				lista.add(jogador);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void escreveFicheiroJSON(String nomeFicheiro) {
		try {
			PrintWriter writer = new PrintWriter(new File(nomeFicheiro));
			try {
				String str = "[\n";
				for (SubTaskJSON jogador : lista) {
					str += "\t{\"nome\": ";
					str += "\"" + jogador.getNome() + "\"";
					
					str += ", \"pontuacao\": ";
					str += jogador.getPontuacao() + "}";

					if(lista.get( lista.size() -1 ) != jogador){
						str += ",\n";
					}
				}
				str += "\n]";
				
				writer.println(str);
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
