package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<Character, LcdDigit> numbersRepresentation = new HashMap<Character, LcdDigit>();
	
	static {
		 numbersRepresentation.put('1', LcdDigit.ONE);
		 numbersRepresentation.put('2', LcdDigit.TWO);
		 numbersRepresentation.put('8', LcdDigit.EIGHT);
	}
	
	public static String getRepresentationFor(String numberToRepresent) {

		return getRepresentationFor(numberToRepresent, 1);
	}
	
	public static String getRepresentationFor(String numberToRepresent, int size) {
		
		if (!isValid(numberToRepresent)){
			
			throw new IllegalArgumentException("Invalid input String. Expect number.");
		}
		
		return getRepresentation(numberToRepresent, size);		
	}
	
	private static String getRepresentation(String number, int size){
		
		LcdTemplate lcdNumber = getLcdTemplateFor(number.charAt(0), size);
		
		for(int i = 1; i < number.length(); i++){
			
			LcdTemplate numberLcdTemplate = getLcdTemplateFor(number.charAt(i), size);
			lcdNumber = lcdNumber.concatenateWithTemplate(numberLcdTemplate);
		}
		
		return lcdNumber.toString(); 
	}
	
	private static LcdTemplate getLcdTemplateFor(char digit, int size){
		
		return numbersRepresentation.get(digit).getRepresentationForSize(size);
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
