package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class DoubleTest {

	@Test
	public void testParseDoubleOK() {
		Assert.assertEquals(-12.0, Double.parseDouble("-12"), 0.0);
		Assert.assertEquals(-12.0, Double.parseDouble("-12.0"), 0.0);
	}

	@Test(expected = NumberFormatException.class)
	@Parameters({"N", ""})
	public void testParseDoubleKO(String value) {
		Double.parseDouble(value);
	}

	@Test(expected = NullPointerException.class)
	public void testParseDoubleKO() {
		Double.parseDouble(null);
	}

}
