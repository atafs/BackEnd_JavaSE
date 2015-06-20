package io.json.tests;

import java.util.Locale;

import io.bundle.properties.BundlePath;
import io.json.properties.TaskJSON;
import io.json.properties.SubTaskJSON;

public class Main {

	public static void main(String[] args) {
		
		//INITIALIZE
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathJSONFromTestsWrite = bundle.displayValue(supportedLocales, "pathJSONFromTestsWrite");
		String pathJSONFromTestsRead = bundle.displayValue(supportedLocales, "pathJSONFromTestsRead");
		
		TaskJSON task = new TaskJSON();
		
		//READ FROM
		task.leFicheiroJSON(pathJSONFromTestsRead);
		System.out.println("-----------READ FROM JSON--------------");
		System.out.println(task.getListaJogadores());
		
		//SLEEP
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//WRITE TO
		//ADD NEW TASK
		task.adicionaJogador(new SubTaskJSON("Ana", new Long(60)));
		System.err.println("\n-----------WRITE TO JSON--------------");
		System.err.println(task.getListaJogadores());
		
		task.escreveFicheiroJSON(pathJSONFromTestsWrite);
	}
}
