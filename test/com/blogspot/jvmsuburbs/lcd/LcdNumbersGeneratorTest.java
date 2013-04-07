package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.BeforeClass;
import org.junit.Test;

public class LcdNumbersGeneratorTest {

	private static final Map<String, String> testCases = new HashMap<String, String>();
	
	@BeforeClass
	public static void setUp(){
		testCases.put("1", LcdNumberExpectedRepresentation.one);
		testCases.put("2", LcdNumberExpectedRepresentation.two);
		testCases.put("8", LcdNumberExpectedRepresentation.eight);
	}
	
	@Test
	public void shouldReturnRepresentationOf1() {
		
		for(Entry<String, String> testEntry : testCases.entrySet()){
			
			String numberRepresentation = LcdNumberGenerator
					.generateRepresentationFor(testEntry.getKey());
			assertEquals(testEntry.getValue(), numberRepresentation);
		}
	}
}
