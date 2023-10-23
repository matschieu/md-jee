package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class GenericA<T, U> {

	private final Class<?> tClass = (Class<?>)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	GenericA() { }

	String getTClass() {
		return tClass.getSimpleName();
	}
}

class GenericB extends GenericA<Short, String> {
	GenericB() {
		super();
	}
}

class GenericsTest {

	@Test
	void testGenerics() {
		Assertions.assertEquals("Short", new GenericB().getTClass());
	}
}
