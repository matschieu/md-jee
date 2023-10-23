package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NullTest {

	private boolean foo(NullTest o) {
		return o == this;
	}

	@Test
	void testNull() {
		final NullTest tn = new NullTest();
		Assertions.assertTrue(tn.foo(tn));
		Assertions.assertFalse(tn.foo(null));
		Assertions.assertNotNull(tn);
		Assertions.assertNotEquals("", null);
	}

}
