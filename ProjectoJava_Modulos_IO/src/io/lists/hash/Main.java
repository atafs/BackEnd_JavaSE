package io.lists.hash;

import io.bundle.properties.BundlePath;
import io.json.properties.SubTaskJSON;
import io.json.properties.TaskJSON;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		//INITIALIZE PATH
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathListHash = bundle.displayValue(supportedLocales, "pathListHash");
		
		TaskJSON task = new TaskJSON();
		
		//READ FROM
		task.leFicheiroJSON(pathListHash);
		System.out.println("-----------READ FROM JSON--------------");
		System.err.println(task.getListaJogadores());
		
		//LISTS
		Map<String, List<SubTaskJSON>> mapExcelHash = new HashMap<String, List<SubTaskJSON>>();
		List<SubTaskJSON> mapExcelList = task.getListaJogadores();
		for (int i = 0; i < mapExcelList.size(); i++) {
			mapExcelHash.put(i + "", mapExcelList);
		}

		System.out.println("\n-----------READ FROM HASHMAP--------------");
		//ITERATE HASHMAP_VERSION02
		for (Entry<String, List<SubTaskJSON>> entry : mapExcelHash.entrySet()) {
			System.err.println("key="+entry.getKey());
			System.err.println("List="+entry.getValue());
			

			List<SubTaskJSON> sheet = entry.getValue();
			// do something with key and/or tab
		}
		
//		//ITERATE HASHMAP_VERSION03
//		for ( Map.Entry<String, List<SubTaskJira>> entry : mapExcel.entrySet()) {
//		    for (SubTaskJira subtask : entry.getValue()) {
//		    	System.err.println(subtask);
//			}
//		}
	}

}
