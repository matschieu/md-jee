package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LongTest {

	@Test
	public void testParseLongOK() {
		Assert.assertEquals(12, Long.parseLong("12"));
		Assert.assertEquals(12, Long.parseLong("012"));
	}

	@Test(expected = NumberFormatException.class)
	@Parameters({"toto", "", "null"})
	public void testParseLongKO(String value) {
		Long.parseLong("null".equals(value) ? null : value);
	}

}
