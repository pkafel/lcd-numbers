package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcdNumbersTest {

	@Test
	public void getRepresentationOf1() {

		// When
		String number = LcdNumbers.ONE.getRepresentation();

		// Then
		assertEquals(LcdNumberExpectedRepresentation.one, number);
	}

	@Test
	public void getRepresentationOf2() {

		// When
		String number = LcdNumbers.TWO.getRepresentation();

		// Then
		assertEquals(LcdNumberExpectedRepresentation.two, number);
	}
	
	@Test
	public void getRepresentationOf8() {

		// When
		String number = LcdNumbers.EIGHT.getRepresentation();

		// Then
		assertEquals(LcdNumberExpectedRepresentation.eight, number);
	}
}
