package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerTest {

	@Test
	public void testIntegerEquality() {
		final Integer a = Integer.valueOf(100);
		final Integer b = Integer.valueOf(100);
		final Integer c = Integer.valueOf(1000);
		final Integer d = Integer.valueOf(1000);

		Assertions.assertTrue(a == b);
		Assertions.assertFalse(a != b);
		Assertions.assertFalse(c == d);
		Assertions.assertTrue(c != d);

		for(int i = 250; i < 260; i++) {
			final Integer a_ = Integer.valueOf(i);
			final Integer b_ = Integer.valueOf(i);

			Assertions.assertFalse(a_ == b_);
			Assertions.assertTrue(a_ != b_);
		}
	}

}
