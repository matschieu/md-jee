package com.github.matschieu.java.test.api;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatternTest {

	@Test
	public void testMatchesOK() {
		final Pattern pattern = Pattern.compile("[a-zA-Z]{1,2}");

		Assertions.assertTrue(pattern.matcher("M").matches());
		Assertions.assertFalse(pattern.matcher("M1").matches());
		Assertions.assertTrue(pattern.matcher("MD").matches());
		Assertions.assertFalse(pattern.matcher("toto").matches());
		Assertions.assertFalse(pattern.matcher("1234").matches());
		Assertions.assertFalse(pattern.matcher("").matches());
	}

	@Test
	public void testMatchesKO() {
		Assertions.assertThrows(NullPointerException.class, () -> Pattern.compile("[a-zA-Z]{1,2}").matcher(null).matches());
	}
}
