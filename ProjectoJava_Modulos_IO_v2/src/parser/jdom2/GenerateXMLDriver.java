package parser.jdom2;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class GenerateXMLDriver {
	
	//ATTRIBUTES
	static String[][] tutorials = {
		{"Abstract Factory", "Factory Method"},
		{"Point to Point", "Publish / Subscribe"}
	};
	
	//MAIN
	public static void main(String[] args) {
		System.err.println(GenerateXMLDriver.generateChannelXML());
	}
	
	/** STATIC FUNCTION: */
	public static String generateChannelXML() {
		//DOCUMENT
		Document document = new Document();
		
		//ELEMENTS
		Element channelElement = new Element("channel");
		document.setRootElement(channelElement);
		
		Element nameElement = new Element("name");
		nameElement.addContent("Zane Academy");
		channelElement.addContent(nameElement);
		
		//GENERATE
		generateChannelXML(channelElement, "Object Oriented Design Pattern", tutorials[0]);
		generateChannelXML(channelElement, "Java Message Service", tutorials[1]);

		//RETURN
		return (new XMLOutputter(Format.getPrettyFormat())).outputString(document);
	}
	
	/** STATIC PROCEDURE: */
	public static void generateChannelXML(Element channelElement, String topicName, String[] topicTutorials) {
		Element topicElement = new Element("topic");
		channelElement.addContent(topicElement);
		
		Element nameElement = new Element("name");
		nameElement.addContent(topicName);
		topicElement.addContent(nameElement);
		
		//LOOP
		int i = 0;
		while (i < topicTutorials.length) {
			nameElement = new Element("tutorial");
			nameElement.addContent(topicTutorials[i++]);
			topicElement.addContent(nameElement);
		}
	}

}
