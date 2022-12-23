package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NullTest {

	private boolean foo(NullTest o) {
		return o == this;
	}

	@Test
	public void testNull() {
		final NullTest tn = new NullTest();
		Assertions.assertTrue(tn.foo(tn));
		Assertions.assertFalse(tn.foo(null));
		Assertions.assertFalse(tn == null);
		Assertions.assertFalse("".equals(null));
	}

}
