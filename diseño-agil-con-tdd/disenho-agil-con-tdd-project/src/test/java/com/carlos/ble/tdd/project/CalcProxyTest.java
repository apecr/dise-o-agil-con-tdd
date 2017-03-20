package com.carlos.ble.tdd.project;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalcProxyTest {

	private Calculator calculator;
	private LimitsValidator limitsValidator;
	private CalcProxy calcProxy;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		this.calculator = new Calculator();
		this.limitsValidator = new LimitsValidator(-100, 100);
		this.calcProxy = new CalcProxy(this.limitsValidator, this.calculator);
	}

	@Test
	public void add() throws NoSuchMethodException, SecurityException {
		int i = 1;
		int j = 3;
		// Act
		int result = this.calcProxy
				.binaryOperation(this.calculator.getClass().getMethod("add", Integer.class, Integer.class), i, j);
		// Assert
		assertEquals(4, result);
	}

	@Test
	public void addWithDifferentArguments() throws NoSuchMethodException, SecurityException {
		int i = 2;
		int j = 5;
		// Act
		int result = this.calcProxy
				.binaryOperation(this.calculator.getClass().getMethod("add", Integer.class, Integer.class), i, j);
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void substract() throws NoSuchMethodException, SecurityException {
		int i = 5;
		int j = 3;
		// Act
		int result = this.calcProxy
				.binaryOperation(this.calculator.getClass().getMethod("substract", Integer.class, Integer.class), i, j);
		// Assert
		assertEquals(2, result);
	}

	@Test
	public void substractReturningNegative() throws NoSuchMethodException, SecurityException {
		int i = 3;
		int j = 5;
		// Act
		int result = this.calcProxy
				.binaryOperation(this.calculator.getClass().getMethod("substract", Integer.class, Integer.class), i, j);
		// Assert
		assertEquals(-2, result);
	}

	@Test
	public void addArgumentsExceedLimits() throws NoSuchMethodException, SecurityException {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("First argument exceeds limits"));
		// Act
		this.calcProxy.binaryOperation(this.calculator.getClass().getMethod("add", Integer.class, Integer.class),
				this.limitsValidator.getUpperLimit() + 1, this.limitsValidator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void substractSecondArgumentExceedLimits() throws NoSuchMethodException, SecurityException {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Second argument exceeds limits"));
		// Act
		this.calcProxy.binaryOperation(this.calculator.getClass().getMethod("substract", Integer.class, Integer.class),
				this.limitsValidator.getUpperLimit(), this.limitsValidator.getLowerLimit() - 1);
		// Assert
		fail();
	}

	@Test
	public void substractExcedingLowerLimit() throws NoSuchMethodException, SecurityException {
		// Arrange
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage(is("Result exceeds limits"));
		// Act
		this.calcProxy.binaryOperation(this.calculator.getClass().getMethod("substract", Integer.class, Integer.class),
				10, -96);
		// Assert
		fail();
	}

}
