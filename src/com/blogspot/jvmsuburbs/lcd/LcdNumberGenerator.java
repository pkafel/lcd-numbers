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

		return numbersRepresentation.get(numberToRepresent).getRepresentation();
	}
}
