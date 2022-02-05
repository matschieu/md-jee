package com.github.matschieu.java.test.api;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;


public class GregorianCalendarTest {

	@Test
	public void testCalendar() {
		final GregorianCalendar gc = new GregorianCalendar(2016, 9, 20, 18, 00);

		Assert.assertEquals("2016.10.20 18:00:00", (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss")).format(gc.getTime()));
	}
}
