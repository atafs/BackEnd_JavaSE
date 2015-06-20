package io.nodes.properties;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.NWriter;

public class NodeJira {
	
	//ATTRIBUTES
	private List<String> nodeList = new ArrayList<String>();
	private HashMap<String, String> nodeMap = new HashMap<String, String>();
	
	//GETTER
	public List<String> getNodeList() {
		return nodeList;
	}

	public HashMap<String, String> getNodeMap() {
		return nodeMap;
	}

	//PRINT THE FOLDERS RECURSIVELY
	public void displayIt(File node, NWriter writer, String pathPrintWriter) {

//		//CLEAN PATH
//		String stringNome;
//		try {
//			stringNome = node.getCanonicalFile().toString();
//			System.out.println(stringNome);
//			stringNome = stringNome.replace("D:\\clouds\\Drive Ilimitado\\", "");
//			System.err.println(stringNome);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		System.out.println(node.getAbsoluteFile());
		nodeList.add(node.getAbsoluteFile().toString());

//		//TODELETE
//		try {
//			String string = node.getCanonicalFile().toString();
//			string = string.replace(".png", "");
//			string = string.replace(".jpg", "");
//			string = string.replace(".pdf", "");
//			string = string.replace("D:\\", "");
//			string = string.replace("clouds\\Drive Ilimitado\\0_Americo Tomas", "");
//			
//			System.err.println(string + "\n");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				
				File file = new File(node, filename);
				String fileName = file.getName();
				fileName = fileName.substring(fileName.lastIndexOf("/")+1);
				
				//TODELETE
				System.err.println(fileName);
				
				String count = nodeMap.get(filename.toString());
				if(count == null){
					count = "";
				}
				
				nodeMap.put(filename.toString(), "list");
//				for (Map.Entry<String,ArrayList<String>> entry : nodeMap.entrySet()) {
//					(nodeMap.put(entry.getKey(), entry.getValue());
//				}

				displayIt(file, writer, pathPrintWriter);
			}
		}

	}

}
