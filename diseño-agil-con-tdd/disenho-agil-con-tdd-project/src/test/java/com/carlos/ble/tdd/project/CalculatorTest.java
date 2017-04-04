package com.carlos.ble.tdd.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	public void addTwoAndTwo() {
		// Act
		int result = this.calculator.add(2, 2);
		// Assert
		assertEquals(4, result);
	}

	@Test
	public void addTwoAndFive() {
		// Act
		int result = this.calculator.add(2, 5);
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void substractFourToTwo() {
		// Act
		int result = this.calculator.substract(4, 2);
		// Assert
		assertEquals(2, result);
	}

	@Test
	public void substractFiveToTwo() {
		// Act
		int result = this.calculator.substract(5, 2);
		// Assert
		assertEquals(3, result);
	}

	@Test
	public void substractTwoToFive() {
		// Act
		int result = this.calculator.substract(2, 5);
		// Assert
		assertEquals(-3, result);
	}

	@Test
	public void substractSettingLimitValues() {
		// Arrange
		// Act
		int result = this.calculator.substract(5, 10);
		// Assert
		assertEquals(-5, result);
	}
}
