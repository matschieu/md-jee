package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void testIndexOf() {
		final String str = "my.value";

		Assertions.assertEquals("value", str.substring(str.indexOf('.') + 1));
		Assertions.assertEquals(".value", str.substring(str.indexOf('.')));

	}

	@Test
	void testSplit() {
		final String[] array = "aa;aa;;aa".split(";");

		Assertions.assertEquals(4, array.length);

		for(int i = 0; i < array.length; i++) {
			Assertions.assertNotNull(array[i]);
			Assertions.assertNotNull(array[i].trim());
		}

		Assertions.assertEquals(4, array.length);
	}

	@Test
	void testStringCopy() {
		String s1 = "s1";
		final String s2 = s1;
		s1 = "s1.1";

		Assertions.assertNotSame(s1, s2);
		Assertions.assertNotEquals(s1, s2);
	}

	@Test
	void testFormat() {
		final String format = String.format("%%0%dd", 2);

		Assertions.assertEquals("%02d", format);

		for (int i = 0; i < 4; i++) {
			Assertions.assertEquals("0" + i, String.format(format, i));
		}
	}

	@Test
	void testValueOf() {
		Assertions.assertEquals("S", String.valueOf('S'));
	}

}
