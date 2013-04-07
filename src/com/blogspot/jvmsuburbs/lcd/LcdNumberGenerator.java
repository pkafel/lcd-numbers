package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<String, String> numbersRepresentation = new HashMap<String, String>();
	
	static {
		 numbersRepresentation.put("1", "   \n" + "  |'n" + "  |");
		 numbersRepresentation.put("2", " _ \n" + " _|\n" + "|_ ");
	}
	
	public static String generateRepresentationFor(String numberToRepresent) {

		return numbersRepresentation.get(numberToRepresent);
	}
}
