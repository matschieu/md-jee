package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CastTest {

	@Test
	void testCast() {
		final String str = null;
		final Object obj = str;

		Assertions.assertEquals(1, (int)1.625);
		Assertions.assertNull(obj);
		Assertions.assertNull(obj);
	}

	@ParameterizedTest
	@ValueSource(strings = {"toto"})
	void testBadCast(Object o) {
		Assertions.assertThrows(ClassCastException.class, () -> {
			@SuppressWarnings("unused")
			Integer i = (Integer)o;
		});

	}

}
