package br.com.selenium.for_beginners.utils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cucumber.api.Scenario;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ErrorLog {

	public final static boolean DEBUG = true;  
	static Logger logger = Logger.getLogger(ErrorLog.class);
	static final String path = "src/resources/log4j.properties";
	
	 public void log(Exception e) {
		
		 PropertyConfigurator.configure(path);
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		  if (DEBUG) {
		    String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		    String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
	        logger.error("\n");
	        logger.error(timestamp.toString() + " - Classe Error: " + className);
	        logger.error("Metodo Error: " + e.getStackTrace()[2].getMethodName());
	        logger.error("Message Error: " + e.getMessage());
	        logger.error("Line Error: " + e.getStackTrace()[3].getLineNumber());
		  }
	 }
	 
	 public void message(Scenario scenario) {
			
		 PropertyConfigurator.configure(path);
		
		  if (DEBUG) {
			  Field field =  FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
			   ((AccessibleObject) field).setAccessible(true);
			   try {
			       @SuppressWarnings("unchecked")
				ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
			       for (Result result : results) {
			           if (result.getError() != null)
			        	   logger.error("Error Feature, Scenario: \n" + scenario.getId(), result.getError());
			       }
			   } catch (Exception e) {
				   logger.error("Error while logging error", e);
			   }
		  }
	 }
}