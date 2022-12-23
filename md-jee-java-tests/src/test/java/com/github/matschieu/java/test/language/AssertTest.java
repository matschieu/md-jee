package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertTest {

	@Test
	public void testAssertKo() {
		Assertions.assertThrows(AssertionError.class, () -> {
			final String str = null;
			assert str != null : "Null variable";
		});
	}

	@Test
	public void testAssertOk() {
		final String str = "";
		assert str != null : "Null variable";
	}

}
