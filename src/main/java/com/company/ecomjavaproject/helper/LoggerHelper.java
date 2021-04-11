package com.company.ecomjavaproject.helper;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Arvind.Kumar
 *
 */

public class LoggerHelper {

	private static boolean root=false;
	
	@SuppressWarnings("rawtypes")
	public static  Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("./configuration\\log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("logger is configured");
		log.info("logger is configured");
		log.info("logger is configured");
		
	}
}
