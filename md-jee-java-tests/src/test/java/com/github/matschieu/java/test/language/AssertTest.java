package com.github.matschieu.java.test.language;

import org.junit.Test;

public class AssertTest {

	@Test(expected = AssertionError.class)
	public void testAssertKo() {
		final String str = null;
		assert str != null : "Null variable";
	}

	@Test
	public void testAssertOk() {
		final String str = "";
		assert str != null : "Null variable";
	}

}
