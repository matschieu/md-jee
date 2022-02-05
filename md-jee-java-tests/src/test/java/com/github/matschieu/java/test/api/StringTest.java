package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

	@Test
	public void testIndexOf() {
		final String str = "my.value";

		Assert.assertEquals("value", str.substring(str.indexOf('.') + 1));
		Assert.assertEquals(".value", str.substring(str.indexOf('.')));

	}

	@Test
	public void testSplit() {
		final String[] array = "aa;aa;;aa".split(";");

		Assert.assertEquals(4, array.length);

		for(int i = 0; i < array.length; i++) {
			Assert.assertNotNull(array[i]);
			Assert.assertNotNull(array[i].trim());
		}

		Assert.assertEquals(4, array.length);
	}

	@Test
	public void testStringCopy() {
		String s1 = "s1";
		final String s2 = s1;
		s1 = "s1.1";

		Assert.assertFalse(s1 == s2);
		Assert.assertNotEquals(s1, s2);
	}

	@Test
	public void testFormat() {
		final String format = String.format("%%0%dd", 2);

		Assert.assertEquals("%02d", format);

		for (int i = 0; i < 4; i++) {
			Assert.assertEquals("0" + i, String.format(format, i));
		}
	}

	@Test
	public void testValueOf() {
		Assert.assertEquals("S", String.valueOf('S'));
	}

}
