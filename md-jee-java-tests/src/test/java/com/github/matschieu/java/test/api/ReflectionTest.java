package com.github.matschieu.java.test.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ReflectionTest {

	public Boolean bool;
	public String str;

	@Test
	void testReflection() throws Exception {
		final List<Class<?>> primitiveObjects = Arrays.asList(new Class<?>[] {Integer.class, Short.class, Long.class, Double.class, Float.class, Boolean.class});

		final Field fbool = ReflectionTest.class.getField("bool");
		final Field fstr = ReflectionTest.class.getField("str");

		Assertions.assertTrue(primitiveObjects.contains(fbool.getType()));
		Assertions.assertFalse(primitiveObjects.contains(fstr.getType()));

		final ReflectionTest miscTest = new ReflectionTest();

		Assertions.assertNull(miscTest.bool);
		Assertions.assertNull(miscTest.str);

		final Method method = fbool.getType().getMethod("valueOf", String.class);
		try {
			final Object value = method.invoke(null, "true");
			fbool.set(miscTest, value);
			fstr.set(miscTest, "TrUe");
		} catch(final NumberFormatException e) {
			e.printStackTrace();
		}

		Assertions.assertTrue(miscTest.bool);
		Assertions.assertEquals("TrUe", miscTest.str);
	}

	@Test
	void testFieldAccess() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		@SuppressWarnings("unused")
		final Object obj = new Object() {
			private static final Integer STATIC_VALUE = 01;
			private final Integer value = 10;
		};

		Field valueField = obj.getClass().getDeclaredField("value");
		Assertions.assertTrue(valueField.canAccess(obj));
		Assertions.assertEquals(10, valueField.get(obj));

		valueField = obj.getClass().getDeclaredField("STATIC_VALUE");
		valueField.setAccessible(false);
		System.out.println(valueField.canAccess(null));
		Assertions.assertTrue(valueField.canAccess(null));
		Assertions.assertEquals(1, valueField.get(null));
	}

}
