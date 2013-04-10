package com.blogspot.jvmsuburbs.lcd;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LcdDigitTest {

	private final Map<LcdDigit, String> testCases = new LinkedHashMap<LcdDigit, String>();
	
	@Before
	public void setUp(){
		
		testCases.put(LcdDigit.ZERO, LcdNumberExpectedRepresentation.zero);
		testCases.put(LcdDigit.ONE, LcdNumberExpectedRepresentation.one);
		testCases.put(LcdDigit.TWO, LcdNumberExpectedRepresentation.two);
		testCases.put(LcdDigit.THREE, LcdNumberExpectedRepresentation.three);
		testCases.put(LcdDigit.FOUR, LcdNumberExpectedRepresentation.four);
		testCases.put(LcdDigit.FIVE, LcdNumberExpectedRepresentation.five);
		testCases.put(LcdDigit.SIX, LcdNumberExpectedRepresentation.six);
		testCases.put(LcdDigit.SEVEN, LcdNumberExpectedRepresentation.seven);
		testCases.put(LcdDigit.EIGHT, LcdNumberExpectedRepresentation.eight);
		testCases.put(LcdDigit.NINE, LcdNumberExpectedRepresentation.nine);
	}
	
	@Test
	public void shouldReturnCorrectRepresentationForSimpleNumbersWithSize1() {
		
		for(Entry<LcdDigit, String> testEntry : testCases.entrySet()){

			LcdDigit lcdDigit = testEntry.getKey();
			Assert.assertEquals(testEntry.getValue(), lcdDigit.getRepresentationForSize().toString());
		}
	}
}
