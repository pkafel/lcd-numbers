package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class LcdNumbersTest {

	private final Map<LcdDigit, String> testCases = new HashMap<LcdDigit, String>();
	
	@Before
	public void setUp(){
		
		testCases.put(LcdDigit.ONE, LcdNumberExpectedRepresentation.one);
		testCases.put(LcdDigit.TWO, LcdNumberExpectedRepresentation.two);
		testCases.put(LcdDigit.EIGHT, LcdNumberExpectedRepresentation.eight);
	}
	
	@Test
	public void shouldReturnCorrectRepresentationForSimpleNumbers() {

		for(Entry<LcdDigit, String> testEntry : testCases.entrySet()){
			
			assertEquals(testEntry.getValue(), testEntry.getKey().getRepresentation().toString());
		}
	}
}
