package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class AutoboxingTest {

	@Test(expected = NullPointerException.class)
	public void testNullAutoboxing() {
		final Integer a = null;
		@SuppressWarnings("null")
		final int b = a;
	}

	@Test
	public void testAutoboxing() {
		final Integer a = 1;
		final int b = a;
		Assert.assertEquals(1, b);
	}

}
