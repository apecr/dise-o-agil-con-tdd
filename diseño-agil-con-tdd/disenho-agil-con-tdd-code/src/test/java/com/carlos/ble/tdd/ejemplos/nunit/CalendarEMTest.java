package com.carlos.ble.tdd.ejemplos.nunit;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalendarEMTest {

	private CalendarService calendarService;
	@Mock
	private CalendarServiceImpl calendarServiceStub;

	@Test
	public void drawHolidaysWithMock() {
		// Arrange
		int year = 2009;
		int month = 2;
		String townCode = "b002";
		this.calendarService = createMock(CalendarService.class);
		expect(this.calendarService.getHolidays(year, month, townCode)).andReturn(new int[]{1,5});
		replay(this.calendarService);
		
		Calendar calendar = new Calendar(this.calendarService);
		calendar.setTownCode(townCode);
		calendar.setMonth(month);
		calendar.setYear(year);
		// Act
		calendar.drawMonth();
		// Assert
		verify(this.calendarService);
	}

	@Test
	public void clientAsksCalendarServiceStub() {
		// Arrange
		int year = 2009;
		int month = 2;
		String townCode = "b002";
		Calendar calendar = new Calendar(this.calendarServiceStub);
		calendar.setTownCode(townCode);
		calendar.setMonth(month);
		calendar.setYear(year);
		// Act
		Mockito.when(this.calendarServiceStub.getHolidays(year, month, townCode)).thenReturn(new int[] { 1, 5 });
		calendar.drawMonth();
		// Assert
		Mockito.verify(this.calendarServiceStub).getHolidays(year, month, townCode);
		assertEquals(1, calendar.getHolidays()[0]);
		assertEquals(5, calendar.getHolidays()[1]);
	}

}
