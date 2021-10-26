package com.github.md.jee.test.jse.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public class MiscTest {

	public Boolean bool;
	public String str;

	public static void main(String[] args) throws Exception {
		List<Class<?>> primitiveObjects = Arrays.asList(new Class<?>[] {Integer.class, Short.class, Long.class, Double.class, Float.class, Boolean.class});

		Field fbool = MiscTest.class.getField("bool");
		Field fstr = MiscTest.class.getField("str");

		System.out.println(primitiveObjects.contains(fbool.getType()));
		System.out.println(primitiveObjects.contains(fstr.getType()));

		MiscTest miscTest = new MiscTest();

		System.out.println(miscTest.bool);
		System.out.println(miscTest.str);

		Method method = fbool.getType().getMethod("valueOf", String.class);
		try {
			Object value = method.invoke(null, "true");
			fbool.set(miscTest, value);
			fstr.set(miscTest, "TrUe");
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println(miscTest.bool);
		System.out.println(miscTest.str);
	}

}
