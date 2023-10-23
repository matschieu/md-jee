package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutoboxingTest {

	@Test
	void testNullAutoboxing() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			final Integer a = null;
			@SuppressWarnings({ "null", "unused" })
			final int b = a;
		});
	}

	@Test
	void testAutoboxing() {
		final Integer a = 1;
		final int b = a;
		Assertions.assertEquals(1, b);
	}

}
