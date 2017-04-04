package com.carlos.ble.tdd.ejemplos.nunit;

public class Calendar {

	private CalendarService calendarService;

	private int year;
	private int month;
	private String townCode;
	private int[] holidays;

	public Calendar(CalendarService calendarService) {
		this.calendarService = calendarService;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the townCode
	 */
	public String getTownCode() {
		return townCode;
	}

	/**
	 * @param townCode
	 *            the townCode to set
	 */
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	/**
	 * @return the holidays
	 */
	public int[] getHolidays() {
		return holidays;
	}

	/**
	 * @param holidays
	 *            the holidays to set
	 */
	public void setHolidays(int[] holidays) {
		this.holidays = holidays;
	}

	public void drawMonth() {
		this.setHolidays(this.calendarService.getHolidays(year, month, townCode));
	}

}
