package com.blogspot.jvmsuburbs.lcd;

import org.junit.Assert;
import org.junit.Test;

public class LcdTemplateTest {

	@Test
	public void shouldBuildCorrectTemplateWithSize1(){
		// Given
		
		// When
		LcdTemplate template = new LcdTemplate.Builder().build();
		
		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.eight, template.toString());
	}
	
	@Test
	public void shouldBuildAnotherCorrectTemplateWithSize1(){
		// Given
		
		// When
		LcdTemplate template = new LcdTemplate.Builder()
				.withoutMiddleLeftSide().withoutMiddleCenterSide()
				.withoutDownLeftSide().withoutDownCenterSide().build();

		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.seven, template.toString());
	}
	
	@Test
	public void shouldAddTwoTemplates(){
		// Given
		LcdTemplate.Builder builder = new LcdTemplate.Builder();
		LcdTemplate t1 = builder.withoutTopCenterSide()
				.withoutTopCenterSide().withoutMiddleLeftSide()
				.withoutMiddleCenterSide().withoutDownLeftSide()
				.withoutDownCenterSide().build();
		LcdTemplate t2 = builder.withoutMiddleLeftSide()
				.withoutDownRightSide().build();
		LcdTemplate t3 = builder.build();

		// When
		LcdTemplate template = t1.concatenateWithTemplate(t2).concatenateWithTemplate(t3);
		
		// Then
		String correctRepresentation = "   " + " _ " + " _ \n" +
				   					   "  |" + " _|" + "|_|\n" +
				   					   "  |" + "|_ " + "|_|\n";
		Assert.assertEquals(correctRepresentation, template.toString());
	}
	
	@Test
	public void shouldBuildCorrectSimpleTemplateWithSize2(){
		// Given
		int size = 2;
		
		// When
		LcdTemplate template = new LcdTemplate.Builder(size).build();
		
		// Then
		String expectedResult = " __ \n" + 
								"|  |\n" +
								"|__|\n" +
								"|  |\n" + 
								"|__|\n";
		Assert.assertEquals(expectedResult, template.toString());
	}
	
	@Test
	public void shouldBuildCorrectComplexTemplateWithSize2(){
		// Given
		int size = 2;
		
		// When
		LcdTemplate template = new LcdTemplate.Builder(size)
				.withoutMiddleLeftSide().withoutDownRightSide().build();
		
		// Then
		String expectedResult = " __ \n" + 
								"   |\n" +
								" __|\n" +
								"|   \n" + 
								"|__ \n";
		Assert.assertEquals(expectedResult, template.toString());
	}
	
	@Test
	public void shouldAddTwoComplexTemplatesWithSize2(){
		// Given
		LcdTemplate.Builder builder = new LcdTemplate.Builder(2);
		LcdTemplate t1 = builder.withoutTopCenterSide()
				.withoutTopCenterSide().withoutMiddleLeftSide()
				.withoutMiddleCenterSide().withoutDownLeftSide()
				.withoutDownCenterSide().build();
		LcdTemplate t2 = builder.withoutMiddleLeftSide()
				.withoutDownRightSide().build();
		
		// When
		LcdTemplate template = t1.concatenateWithTemplate(t2);

		// Then
		String expectedResult = "    " + " __ \n" + 
								"   |" + "   |\n" +
								"   |" + " __|\n" +
								"   |" + "|   \n" + 
								"   |" + "|__ \n";
		Assert.assertEquals(expectedResult, template.toString());
	}
}
