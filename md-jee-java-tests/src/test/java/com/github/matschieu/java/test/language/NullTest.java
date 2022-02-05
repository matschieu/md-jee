package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class NullTest {

	private boolean foo(NullTest o) {
		return o == this;
	}

	@Test
	public void testNull() {
		final NullTest tn = new NullTest();
		Assert.assertTrue(tn.foo(tn));
		Assert.assertFalse(tn.foo(null));
		Assert.assertFalse(tn == null);
		Assert.assertFalse("".equals(null));
	}

}
