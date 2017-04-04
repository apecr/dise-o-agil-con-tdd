package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalendarTest {

	@Mock
	private CalendarService calendarService;
	@Spy
	private CalendarServiceImpl calendarServiceStub;

	@Test
	public void drawHolidaysWithMock() {
		// Arrange
		int year = 2009;
		int month = 2;
		String townCode = "b002";
		Calendar calendar = new Calendar(this.calendarService);
		calendar.setTownCode(townCode);
		calendar.setMonth(month);
		calendar.setYear(year);
		// Act
		when(this.calendarService.getHolidays(year, month, townCode)).thenReturn(new int[] { 1, 5 });
		calendar.drawMonth();
		// Assert
		verify(this.calendarService).getHolidays(year, month, townCode);
		assertEquals(1, calendar.getHolidays()[0]);
		assertEquals(5, calendar.getHolidays()[1]);
	}

	@Test
	public void ClientAsksCalendarServiceStub() {
		// Arrange
		int year = 2009;
		int month = 2;
		String townCode = "b002";
		Calendar calendar = new Calendar(this.calendarServiceStub);
		calendar.setTownCode(townCode);
		calendar.setMonth(month);
		calendar.setYear(year);
		// Act
		when(this.calendarServiceStub.getHolidays(year, month, townCode)).thenReturn(new int[] { 1, 5 });
		calendar.drawMonth();
		// Assert
		verify(this.calendarServiceStub).getHolidays(year, month, townCode);
		assertEquals(1, calendar.getHolidays()[0]);
		assertEquals(5, calendar.getHolidays()[1]);
	}

}
