package com.github.matschieu.java.test.functional;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Bean {

	private static int cpt = 0;

	private int a, b;

	private Bean bean;

	Bean() {
		this.a = 1;
		this.b = 2;
		if (cpt++ < 2) this.bean = new Bean();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}

	public int addition() {
		return a + b;
	}

}

class Logger {

	static String log(String message) {
		final StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		return String.format("[%s] [%s] %s", ste.getClassName(), ste.getMethodName(), message);
	}

	static String logBeanFields(Object input, String fields) throws NoSuchMethodException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException {
		final StringBuffer strBuffer = new StringBuffer();

		for(final String field : fields.split("\\,")) {
			if (strBuffer.length() > 0) {
				strBuffer.append(", ");
			}

			strBuffer.append(getObjectFieldLog(input, field));
		}

		return strBuffer.toString();
	}

	private static String getObjectFieldLog(Object obj, String fields) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String result = null;

		for(final String field : fields.split("\\,")) {
			if (field.contains(".")) {
				final String[] subFields = fields.split("\\.", 2);

				final String methodName = String.format("get%s%s", subFields[0].substring(0, 1).toUpperCase(), subFields[0].substring(1, subFields[0].length()));
				final Object returnedObject = obj.getClass().getMethod(methodName, new Class[0]).invoke(obj, new Object[0]);

				result = String.format("%s.%s", subFields[0], getObjectFieldLog(returnedObject, subFields[1]));
			} else {
				String methodName = null;
				String fieldName = null;

				if (field.endsWith("()")) {
					fieldName = field.substring(0, field.length() - 2);
					methodName = String.format("%s", fieldName);
				} else {
					fieldName = field;
					methodName = String.format("get%s%s", field.substring(0, 1).toUpperCase(), field.substring(1, field.length()));
				}

				final String returnedValue = obj.getClass().getMethod(methodName, new Class[0]).invoke(obj, new Object[0]).toString();

				result = String.format("%s: %s", fieldName, returnedValue);
			}
		}

		return result;
	}

}

class BeanFieldLogTest {

	@Test
	void testLogging() throws Exception {
		final Bean bean = new Bean();
		Assertions.assertEquals("a: 1, b: 2, bean.bean.a: 1, bean.bean.addition: 3", Logger.logBeanFields(bean, "a,b,bean.bean.a,bean.bean.addition()"));
		Assertions.assertEquals(String.format("[%s] [testLogging] this is a message!", this.getClass().getName()), Logger.log("this is a message!"));
	}

}

