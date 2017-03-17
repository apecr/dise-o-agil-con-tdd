package com.carlos.ble.tdd.project;

public class Calculator {

	private int lowerLimit;
	private int upperLimit;

	public Calculator(int upperLimit, int lowerLimit) {
		this.setUpperLimit(upperLimit);
		this.setLowerLimit(lowerLimit);
	}

	public int add(int i, int j) {
		validateParams(i, j);
		int result = i + j;
		if (result > this.getUpperLimit()){
			throw new ArithmeticException("Result raise upper limit");
		}
		return result;
	}

	private void validateParams(int i, int j) {
		if (i > this.getUpperLimit()){
			throw new ArithmeticException("First argument exceeds upper limit");
		}
		if (i < this.getLowerLimit()){
			throw new ArithmeticException("First argument exceeds lower limit");
		}
		if (j < this.getLowerLimit()){
			throw new ArithmeticException("Second argument exceeds lower limit");
		}
		if (j > this.getUpperLimit()){
			throw new ArithmeticException("Second argument exceeds upper limit");
		}
	}

	public int substract(int i, int j) {
		validateParams(i, j);
		int result = i - j;
		if (result < this.getLowerLimit()) {
			throw new ArithmeticException("Result below lower limit");
		}
		return result;
	}

	/**
	 * @return the lowerLimit
	 */
	public int getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * @param lowerLimit
	 *            the lowerLimit to set
	 */
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	/**
	 * @return the upperLimit
	 */
	public int getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param upperLimit
	 *            the upperLimit to set
	 */
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

}
