package com.github.matschieu.java.test.api;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateTest {

	@Test
	void testDateFromTimestamp() {
		final long timestamp = 1644233703655L; // Feb 7, 2022, 11:35:03 AM
		final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.FRANCE);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		Assertions.assertEquals("07-02-2022 12:35:03", dateFormat.format(new Date(timestamp)));
		Assertions.assertEquals("07-02-2022 13:35:03", dateFormat.format(new Date(timestamp + 1000 * 60 * 60))); // + 1h
	}

}
