package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DoubleTest {

	@Test
	void testParseDoubleOK() {
		Assertions.assertEquals(-12.0, Double.parseDouble("-12"), 0.0);
		Assertions.assertEquals(-12.0, Double.parseDouble("-12.0"), 0.0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"N", ""})
	void testParseDoubleKO(String value) {
		Assertions.assertThrows(NumberFormatException.class, () -> Double.parseDouble(value));
	}

	@Test
	void testParseDoubleKO() {
		Assertions.assertThrows(NullPointerException.class, () -> Double.parseDouble(null));
	}

}
