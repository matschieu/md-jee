package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerTest {

	@Test
	void testIntegerEquality() {
		final Integer a = Integer.valueOf(100);
		final Integer b = Integer.valueOf(100);
		final Integer c = Integer.valueOf(1000);
		final Integer d = Integer.valueOf(1000);

		Assertions.assertSame(a, b);
		Assertions.assertNotSame(c, d);

		for(int i = 250; i < 260; i++) {
			final Integer a_ = Integer.valueOf(i);
			final Integer b_ = Integer.valueOf(i);

			Assertions.assertNotSame(a_, b_);
		}
	}

}
