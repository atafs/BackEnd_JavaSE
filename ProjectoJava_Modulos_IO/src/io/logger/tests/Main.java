package io.logger.tests;

import io.logger.properties.LogMessage;

public class Main {

	public static void main(String[] args) {

		//INSTANTIATE
		LogMessage logger = new LogMessage();
		
		/* START */
		System.out.println("---------------------PRINT---------------------");
		logger.getLog().info("\nAPP STARTED...\n");
		System.out.println("Hello Rebis!!!");		

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
			logger.getLog().error("ERROR: Cannot format " + number + " to a number!!", e);
		}
		
		/* FINISHED */
		logger.getLog().info("\nAPP FINISHED...\n");
		System.out.println("---------------------PRINT---------------------");


	}

}
