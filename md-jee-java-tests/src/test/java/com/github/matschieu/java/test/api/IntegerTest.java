package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;

public class IntegerTest {

	@Test
	public void testIntegerEquality() {
		final Integer a = Integer.valueOf(100);
		final Integer b = Integer.valueOf(100);
		final Integer c = Integer.valueOf(1000);
		final Integer d = Integer.valueOf(1000);

		Assert.assertTrue(a == b);
		Assert.assertFalse(a != b);
		Assert.assertFalse(c == d);
		Assert.assertTrue(c != d);

		for(int i = 250; i < 260; i++) {
			final Integer a_ = Integer.valueOf(i);
			final Integer b_ = Integer.valueOf(i);

			Assert.assertFalse(a_ == b_);
			Assert.assertTrue(a_ != b_);
		}
	}

}
