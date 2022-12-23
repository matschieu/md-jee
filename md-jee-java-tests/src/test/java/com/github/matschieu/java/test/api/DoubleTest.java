package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DoubleTest {

	@Test
	public void testParseDoubleOK() {
		Assertions.assertEquals(-12.0, Double.parseDouble("-12"), 0.0);
		Assertions.assertEquals(-12.0, Double.parseDouble("-12.0"), 0.0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"N", ""})
	public void testParseDoubleKO(String value) {
		Assertions.assertThrows(NumberFormatException.class, () -> Double.parseDouble(value));
	}

	@Test
	public void testParseDoubleKO() {
		Assertions.assertThrows(NullPointerException.class, () -> Double.parseDouble(null));
	}

}
