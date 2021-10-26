package com.github.md.jee.test.jse.language;

abstract class GenericA<T, U> {

	private final Class<?> tClass = (Class<?>)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	public GenericA() {
	}

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

	public static void main(String[] args) {
		System.out.println(new GenericB().getTClass());
	}
}
