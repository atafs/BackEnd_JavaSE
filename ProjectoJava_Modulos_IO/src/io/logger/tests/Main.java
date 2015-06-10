package io.logger.tests;

import io.logger.properties.LogMessage;

public class Main {

	public static void main(String[] args) {

		//INSTANTIATE
		LogMessage logger = new LogMessage();
		
		/* START */
		System.err.println("---------------------LOGGER---------------------");
		System.err.println("Hello MORPHIS!!!");	
		logger.getLog().info("APP STARTED...\n");
			

		logger.getLog().trace("Trace Message!");
		logger.getLog().debug("Debug Message!");
		logger.getLog().info("Info Message!");
		logger.getLog().warn("Warn Message!");
		logger.getLog().error("Error Message!");
			
		/* TEST: see if the number is an Integer */
		String number = "5x";
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			paragraph();
			System.err.println("---------------------LOGGER - EXCEPTION---------------------");
			logger.getLog().error("ERROR: Cannot format " + number + " to a number!!", e);
		}
		
		/* FINISHED */
		paragraph();
		System.err.println("---------------------END LOGGER---------------------");
		logger.getLog().info("\nAPP FINISHED WITH SUCCESS...");
	}
	
	//PARAGRAPH
	public static void paragraph() {
		System.out.println();
	}

}
