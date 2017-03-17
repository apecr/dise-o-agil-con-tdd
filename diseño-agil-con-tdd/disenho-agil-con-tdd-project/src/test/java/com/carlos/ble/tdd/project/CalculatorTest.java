package com.carlos.ble.tdd.project;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	private Calculator calculator;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		this.calculator = new Calculator(100, -100);
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

	@Test
	public void setAndGetLimits() {
		// Act
		this.calculator = new Calculator(200, -200);
		// Assert
		assertEquals(200, this.calculator.getUpperLimit());
		assertEquals(-200, this.calculator.getLowerLimit());
	}

	@Test
	public void substractExcedingLowerLimit() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Result below lower limit"));
		// Act
		this.calculator.substract(-10, 96);
		// Assert
		fail();
	}

	@Test
	public void addExcedingUpperLimit() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Result raise upper limit"));
		// Act
		this.calculator.add(10, 98);
		// Assert
		fail();
	}

	@Test
	public void argumentsExceedLimits() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds upper limit"));
		// Act
		this.calculator.add(this.calculator.getUpperLimit() + 1, this.calculator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void secondArgumentExceedLimits() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Second argument exceeds lower limit"));
		// Act
		this.calculator.add(this.calculator.getUpperLimit(), this.calculator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void argumentsExceedLimitsInverse() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds lower limit"));
		// Act
		this.calculator.add(this.calculator.getLowerLimit() - 1, this.calculator.getUpperLimit() + 1);
		// Assert
		fail();
	}
	
	@Test
	public void secondArgumentExceedLimitsInverse() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Second argument exceeds upper limit"));
		// Act
		this.calculator.add(this.calculator.getLowerLimit(), this.calculator.getUpperLimit() + 1);
		// Assert
		fail();
	}
	
	@Test
	public void argumentsExceedLimitsOnSubstract() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds upper limit"));
		// Act
		this.calculator.substract(this.calculator.getUpperLimit() + 1, this.calculator.getLowerLimit() - 1);
		// Assert
		fail();
	}
	
	@Test
	public void substractArgumentsExceedLimits() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds upper limit"));
		// Act
		this.calculator.substract(this.calculator.getUpperLimit() + 1, this.calculator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void substractSecondArgumentExceedLimits() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Second argument exceeds lower limit"));
		// Act
		this.calculator.substract(this.calculator.getUpperLimit(), this.calculator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void substractArgumentsExceedLimitsInverse() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds lower limit"));
		// Act
		this.calculator.substract(this.calculator.getLowerLimit() - 1, this.calculator.getUpperLimit() + 1);
		// Assert
		fail();
	}
	
	@Test
	public void substractSecondArgumentExceedLimitsInverse() {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Second argument exceeds upper limit"));
		// Act
		this.calculator.substract(this.calculator.getLowerLimit(), this.calculator.getUpperLimit() + 1);
		// Assert
		fail();
	}
	
	@Test
	public void substractIsUsingValidator(){
		
	}

}
