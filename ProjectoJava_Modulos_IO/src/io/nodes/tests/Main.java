package io.nodes.tests;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import io.NWriter;
import io.PropertiesJira;
import io.bundle.properties.BundlePath;
import io.json.properties.SubTaskJSON;
import io.nodes.properties.NodeJira;

public class Main {

	//MAIN
	public static void main(String args[])  {
		
		//INSTANTIATE JIRA_PROPERTIES
		PropertiesJira jira = new PropertiesJira();
		
		//INSTANTIATE NODES
		NodeJira node = new NodeJira();
		//File nodeFile = new File("C:\\ellucian_jira\\JiraCreate\\3.createUseCases\\Tests\\General - Solution Centers");
		File nodeFile = new File("D:\\clouds\\Drive Ilimitado\\BackEnd_JavaSE_IO\\ProjectoJava_Modulos_IO\\src\\io\\nodes\\tree");
		
		//INSTANTIATE
		NWriter writer = new NWriter(nodeFile);
		
		//INITIALIZE PATH TO WRITE TO FILE
		BundlePath bundle = new BundlePath();
		Locale supportedLocales = Locale.ENGLISH;
		String pathPrintWriter = bundle.displayValue(supportedLocales, "pathPrintWriter");
		
		//PRINT TO CONSOLE 
		node.displayIt(nodeFile, writer, pathPrintWriter);
		
		//PRINT TO FILE TXT
		writer.writePrintWriter(pathPrintWriter, node);
		
		//PRINT HASH
		for (Entry<String, String> entry : node.getNodeMap().entrySet()) {
			System.err.println("key="+entry.getKey());
			System.err.println("List="+entry.getValue());
		}
	}
}
