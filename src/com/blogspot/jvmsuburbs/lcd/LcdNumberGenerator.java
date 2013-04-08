package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<String, LcdNumbers> numbersRepresentation = new HashMap<String, LcdNumbers>();
	
	static {
		 numbersRepresentation.put("1", LcdNumbers.ONE);
		 numbersRepresentation.put("2", LcdNumbers.TWO);
		 numbersRepresentation.put("8", LcdNumbers.EIGHT);
	}
	
	public static String generateRepresentationFor(String numberToRepresent) {

		if (!isValid(numberToRepresent)){

			throw new IllegalArgumentException("Invalid input String. Expect number.");
		}

		if(numberToRepresent.equals("128")){
			
			return "   " + " _ " + " _ \n" +
					   "  |" + " _|" + "|_|\n" +
					   "  |" + "|_ " + "|_|\n";
		}
		
		return numbersRepresentation.get(numberToRepresent).getRepresentation();
	}

	private static boolean isValid(String numberToRepresent) {

		try {

			Integer.parseInt(numberToRepresent);
			return true;
		} catch (RuntimeException e) {

			return false;
		}
	}
}
