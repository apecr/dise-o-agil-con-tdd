package com.carlos.ble.tdd.project;

public class LimitsValidator {

	private int lowerLimit;
	private int upperLimit;

	public LimitsValidator(int lowerLimit, int upperLimit) {
		super();
		this.setLowerLimit(lowerLimit);
		this.setUpperLimit(upperLimit);
	}

	public void validateParams(Integer i, Integer j) {
		breakIfOverFlow(i, "First argument exceeds limits");
		breakIfOverFlow(j, "Second argument exceeds limits");
	}

	private void breakIfOverFlow(Integer argumentToComprobe, String message) {
		if (valueExceedsLimits(argumentToComprobe)) {
			throw new ArithmeticException(message);
		}
	}

	private boolean valueExceedsLimits(Integer argumentToComprobe) {
		return argumentToComprobe > this.getUpperLimit() || argumentToComprobe < this.getLowerLimit();
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

	public void validateResult(int result) {
		breakIfOverFlow(result, "Result exceeds limits");
	}

}
