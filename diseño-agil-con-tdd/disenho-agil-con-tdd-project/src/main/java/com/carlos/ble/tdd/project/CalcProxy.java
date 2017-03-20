package com.carlos.ble.tdd.project;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalcProxy {

	private Calculator calculator;
	private LimitsValidator limitsValidator;

	public CalcProxy(LimitsValidator limitsValidator, Calculator calculator) {
		this.calculator = calculator;
		this.limitsValidator = limitsValidator;
	}

	public int binaryOperation(Method method, int i, int j) {
		this.limitsValidator.validateParams(i, j);
		int result = 0;
		for (Method calculatorMethod : this.calculator.getClass().getMethods()){
			if (calculatorMethod.equals(method)){
				result = callRealCalculatorMethod(i, j, result, calculatorMethod);
			}
		}
		this.limitsValidator.validateResult(result);
		return result;
	}

	private int callRealCalculatorMethod(int i, int j, int result, Method calculatorMethod) {
		try {
			result = (int) calculatorMethod.invoke(this.calculator, i, j);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

}
