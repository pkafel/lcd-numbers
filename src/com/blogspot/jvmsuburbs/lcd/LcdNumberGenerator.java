package com.blogspot.jvmsuburbs.lcd;

import java.util.HashMap;
import java.util.Map;

public class LcdNumberGenerator {

	private static final Map<Character, LcdDigit> numbersRepresentation = new HashMap<Character, LcdDigit>();

	static {

		numbersRepresentation.put('0', LcdDigit.ZERO);
		numbersRepresentation.put('1', LcdDigit.ONE);
		numbersRepresentation.put('2', LcdDigit.TWO);
		numbersRepresentation.put('3', LcdDigit.THREE);
		numbersRepresentation.put('4', LcdDigit.FOUR);
		numbersRepresentation.put('5', LcdDigit.FIVE);
		numbersRepresentation.put('6', LcdDigit.SIX);
		numbersRepresentation.put('7', LcdDigit.SEVEN);
		numbersRepresentation.put('8', LcdDigit.EIGHT);
		numbersRepresentation.put('9', LcdDigit.NINE);
	}

	public static String getRepresentationFor(String numberToRepresent) {

		return getRepresentationFor(numberToRepresent, 1);
	}

	public static String getRepresentationFor(String numberToRepresent, int size) {

		if (!isValid(numberToRepresent)) {

			throw new IllegalArgumentException(
					"Invalid input String. Expect number.");
		}

		return getRepresentation(numberToRepresent, size);
	}

	private static String getRepresentation(String number, int size) {

		LcdTemplate lcdNumber = getLcdTemplateFor(number.charAt(0), size);

		for (int i = 1; i < number.length(); i++) {

			LcdTemplate numberLcdTemplate = getLcdTemplateFor(number.charAt(i),
					size);
			lcdNumber = lcdNumber.concatenateWithTemplate(numberLcdTemplate);
		}

		return lcdNumber.toString();
	}

	private static LcdTemplate getLcdTemplateFor(char digit, int size) {

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
