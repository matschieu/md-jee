package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoboxingTest {

	@Test
	public void testNullAutoboxing() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			final Integer a = null;
			@SuppressWarnings({ "null", "unused" })
			final int b = a;
		});
	}

	@Test
	public void testAutoboxing() {
		final Integer a = 1;
		final int b = a;
		Assertions.assertEquals(1, b);
	}

}
