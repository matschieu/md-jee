package com.github.matschieu.java.test.api;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;



public class PatternTest {

	@Test
	public void testMatchesOK() {
		final Pattern pattern = Pattern.compile("[a-zA-Z]{1,2}");

		Assert.assertTrue(pattern.matcher("M").matches());
		Assert.assertFalse(pattern.matcher("M1").matches());
		Assert.assertTrue(pattern.matcher("MD").matches());
		Assert.assertFalse(pattern.matcher("toto").matches());
		Assert.assertFalse(pattern.matcher("1234").matches());
		Assert.assertFalse(pattern.matcher("").matches());
	}

	@Test(expected = NullPointerException.class)
	public void testMatchesKO() {
		Pattern.compile("[a-zA-Z]{1,2}").matcher(null).matches();
	}
}
