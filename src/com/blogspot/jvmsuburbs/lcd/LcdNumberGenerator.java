package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<String, String> numbersRepresentation = new HashMap<String, String>();
	
	static {
		 numbersRepresentation.put("1", "   \n" + "  |\n" + "  |\n");
		 numbersRepresentation.put("2", " _ \n" + " _|\n" + "|_ \n");
		 numbersRepresentation.put("8", getRepresentationFor8());
	}
	
	public static String generateRepresentationFor(String numberToRepresent) {

		return numbersRepresentation.get(numberToRepresent);
	}
	
	private static String getRepresentationFor8(){
		
		return transformTemplateIntoString(getTemplate());
	}
	
	private static String transformTemplateIntoString(String[][] template) {
		
		StringBuilder builder = new StringBuilder();
		
		for(String[] templateLineElements : template){
			
			for(String lineElement : templateLineElements){
				
				builder.append(lineElement);
			}
			
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	private static String[][] getTemplate(){
		
		return new String[][] {{" ", "_", " "}, {"|", "_", "|"}, {"|", "_", "|"}};
	}
}
