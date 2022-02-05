package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

abstract class GenericA<T, U> {

	private final Class<?> tClass = (Class<?>)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	public GenericA() { }

	String getTClass() {
		return tClass.getSimpleName();
	}
}

class GenericB extends GenericA<Short, String> {
	public GenericB() {
		super();
	}
}

public class GenericsTest {

	@Test
	public void testGenerics() {
		Assert.assertEquals("Short", new GenericB().getTClass());
	}
}
