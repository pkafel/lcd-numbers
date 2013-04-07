package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class LcdNumbersTest {

	private final Map<LcdNumbers, String> testCases = new HashMap<LcdNumbers, String>();
	
	@Before
	public void setUp(){
		
		testCases.put(LcdNumbers.ONE, LcdNumberExpectedRepresentation.one);
		testCases.put(LcdNumbers.TWO, LcdNumberExpectedRepresentation.two);
		testCases.put(LcdNumbers.EIGHT, LcdNumberExpectedRepresentation.eight);
	}
	
	@Test
	public void shouldReturnCorrectRepresentationForSimpleNumbers() {

		for(Entry<LcdNumbers, String> testEntry : testCases.entrySet()){
			
			assertEquals(testEntry.getValue(), testEntry.getKey().getRepresentation());
		}
	}
}
