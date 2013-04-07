package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcdNumbersTest {

	@Test
	public void getRepresentationOf1() {
		
		String number = LcdNumbers.ONE.getRepresentation();
		
		// Then
		String expectedRepresentation = "   \n" + "  |'n" + "  |\n"; 
		assertEquals(expectedRepresentation, number);
	}
}
