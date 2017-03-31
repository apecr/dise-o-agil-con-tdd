package com.carlos.ble.tdd.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ParserTest {

	@Test
	public void getTokens() {
		MathParser parser = generateParser();
		// When
		List<MathToken> tokens = parser.getTokens("2 + 2");
		// Then
		assertEquals(3, tokens.size());
		assertEquals("2", tokens.get(0).getToken());
		assertEquals("+", tokens.get(1).getToken());
		assertEquals("2", tokens.get(2).getToken());
	}

	@Test
	public void validateSimpleExpression() {
		// Given
		MathParser parser = generateParser();
		String expression = "2 + 2";
		// When
		boolean isExpressionOK = parser.isExpressionValid(expression);
		// Then
		assertTrue(isExpressionOK);
	}

	@Test
	public void validateSimpleExpressionMoreThanOneDigit() {
		// Given
		MathParser parser = generateParser();
		String expression = "356 + 23";
		// When
		boolean isExpressionOK = parser.isExpressionValid(expression);
		// Then
		assertTrue(isExpressionOK);
	}

	@Test
	public void validateSimpleExpressionWithAllOperators() {
		// Given
		MathParser parser = generateParser();
		String operators = "+-*/";
		String expression = "";
		// When - Then
		for (String operator : operators.split("")){
			expression = "2 " + operator + " 2";
			assertTrue("Error al resolver "  + expression, parser.isExpressionValid(expression));
		}
	}
	
	@Test
	public void validateSimpleExpressionWithWhiteSpaces() {
		// Given
		MathParser parser = generateParser();
		String expression = "2     +      2";
		// When
		boolean isExpressionOK = parser.isExpressionValid(expression);
		// Then
		assertTrue(isExpressionOK);
	}
	
	@Test
	public void validateSimpleExpressionWithoutWhiteSpaces() {
		// Given
		MathParser parser = generateParser();
		String expression = "2+2";
		// When
		boolean isExpressionOK = parser.isExpressionValid(expression);
		// Then
		assertFalse(isExpressionOK);
	}
	
	
	@Test
	public void validateComplexExpression() {
		// Given
		MathParser parser = generateParser();
		String expression = "2 + 7 - 2 * 4";
		// When
		boolean isExpressionOK = parser.isExpressionValid(expression);
		// Then
		assertTrue(isExpressionOK);
	}

	private MathParser generateParser() {
		return new MathParser();
	}

}
