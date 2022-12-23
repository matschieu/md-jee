package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LongTest {

	@Test
	public void testParseLongOK() {
		Assertions.assertEquals(12, Long.parseLong("12"));
		Assertions.assertEquals(12, Long.parseLong("012"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"toto", "", "null"})
	public void testParseLongKO(String value) {
		Assertions.assertThrows(NumberFormatException.class, () -> Long.parseLong("null".equals(value) ? null : value));
	}

}
