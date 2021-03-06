package com.github.matschieu.java.test.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class ReflectionTest {

	public Boolean bool;
	public String str;

	@Test
	public void testReflection() throws Exception {
		final List<Class<?>> primitiveObjects = Arrays.asList(new Class<?>[] {Integer.class, Short.class, Long.class, Double.class, Float.class, Boolean.class});

		final Field fbool = ReflectionTest.class.getField("bool");
		final Field fstr = ReflectionTest.class.getField("str");

		Assert.assertTrue(primitiveObjects.contains(fbool.getType()));
		Assert.assertFalse(primitiveObjects.contains(fstr.getType()));

		final ReflectionTest miscTest = new ReflectionTest();

		Assert.assertNull(miscTest.bool);
		Assert.assertNull(miscTest.str);

		final Method method = fbool.getType().getMethod("valueOf", String.class);
		try {
			final Object value = method.invoke(null, "true");
			fbool.set(miscTest, value);
			fstr.set(miscTest, "TrUe");
		} catch(final NumberFormatException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(miscTest.bool);
		Assert.assertEquals("TrUe", miscTest.str);
	}

}
