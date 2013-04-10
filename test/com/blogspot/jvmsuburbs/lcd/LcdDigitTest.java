package com.blogspot.jvmsuburbs.lcd;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LcdDigitTest {

	private static final Map<LcdDigit, String> testCasesForSize1 = new LinkedHashMap<LcdDigit, String>();
	
	private static final Map<LcdDigit, String> testCasesForSize2 = new LinkedHashMap<LcdDigit, String>();
	
	@BeforeClass
	public static void setUp(){
		
		testCasesForSize1.put(LcdDigit.ZERO, LcdNumberExpectedRepresentation.WithSize1.zero);
		testCasesForSize1.put(LcdDigit.ONE, LcdNumberExpectedRepresentation.WithSize1.one);
		testCasesForSize1.put(LcdDigit.TWO, LcdNumberExpectedRepresentation.WithSize1.two);
		testCasesForSize1.put(LcdDigit.THREE, LcdNumberExpectedRepresentation.WithSize1.three);
		testCasesForSize1.put(LcdDigit.FOUR, LcdNumberExpectedRepresentation.WithSize1.four);
		testCasesForSize1.put(LcdDigit.FIVE, LcdNumberExpectedRepresentation.WithSize1.five);
		testCasesForSize1.put(LcdDigit.SIX, LcdNumberExpectedRepresentation.WithSize1.six);
		testCasesForSize1.put(LcdDigit.SEVEN, LcdNumberExpectedRepresentation.WithSize1.seven);
		testCasesForSize1.put(LcdDigit.EIGHT, LcdNumberExpectedRepresentation.WithSize1.eight);
		testCasesForSize1.put(LcdDigit.NINE, LcdNumberExpectedRepresentation.WithSize1.nine);
		
		testCasesForSize2.put(LcdDigit.ZERO, LcdNumberExpectedRepresentation.WithSize2.zero);
		testCasesForSize2.put(LcdDigit.ONE, LcdNumberExpectedRepresentation.WithSize2.one);
		testCasesForSize2.put(LcdDigit.TWO, LcdNumberExpectedRepresentation.WithSize2.two);
		testCasesForSize2.put(LcdDigit.THREE, LcdNumberExpectedRepresentation.WithSize2.three);
		testCasesForSize2.put(LcdDigit.FOUR, LcdNumberExpectedRepresentation.WithSize2.four);
		testCasesForSize2.put(LcdDigit.FIVE, LcdNumberExpectedRepresentation.WithSize2.five);
		testCasesForSize2.put(LcdDigit.SIX, LcdNumberExpectedRepresentation.WithSize2.six);
		testCasesForSize2.put(LcdDigit.SEVEN, LcdNumberExpectedRepresentation.WithSize2.seven);
		testCasesForSize2.put(LcdDigit.EIGHT, LcdNumberExpectedRepresentation.WithSize2.eight);
		testCasesForSize2.put(LcdDigit.NINE, LcdNumberExpectedRepresentation.WithSize2.nine);
	}
	
	@Test
	public void shouldReturnCorrectRepresentationWithSize1(){
		
		shouldReturnCorrectRepresentation(testCasesForSize1, 1);
	}
	
	@Test
	public void shouldReturnCorrectRepresentationWithSize2(){
		
		shouldReturnCorrectRepresentation(testCasesForSize2, 2);
	}
	
	public void shouldReturnCorrectRepresentation(Map<LcdDigit, String> testCases, int size) {
		
		for(Entry<LcdDigit, String> testEntry : testCases.entrySet()){

			LcdDigit lcdDigit = testEntry.getKey();
			Assert.assertEquals(testEntry.getValue(), lcdDigit.getRepresentationForSize(size).toString());
		}
	}
}
