package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<Character, LcdNumbers> numbersRepresentation = new HashMap<Character, LcdNumbers>();
	
	static {
		 numbersRepresentation.put('1', LcdNumbers.ONE);
		 numbersRepresentation.put('2', LcdNumbers.TWO);
		 numbersRepresentation.put('8', LcdNumbers.EIGHT);
	}
	
	public static String generateRepresentationFor(String numberToRepresent) {

		if (!isValid(numberToRepresent)){

			throw new IllegalArgumentException("Invalid input String. Expect number.");
		}

		LcdNumberTemplate lcdNumber = numbersRepresentation.get(
				numberToRepresent.charAt(0)).getRepresentation();
		for(int i = 1; i < numberToRepresent.length(); i++){
			
			char number = numberToRepresent.charAt(i);
			lcdNumber = lcdNumber.concatenateNumber(numbersRepresentation.get(
					number).getRepresentation());
		}
		
		return lcdNumber.toString();
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
