package com.github.matschieu.jee.test.jse.misc;
import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

public class BeanFieldLogTest {

	public static void main(String[] args) throws Exception {
		//new Test().a();
		Bean bean = new Bean();
		
		System.out.println(Logger.logBeanFields(bean, "a,b,bean.bean.a,bean.bean.addition()"));
		
		/*
		for(Method method : bean.getClass().getDeclaredMethods()) {
			if (method.getName().startsWith("get")) {
				System.out.println(method.getName() + " = " + method.invoke(bean, new Object[0]));
			}
		}
		*/
	}
	
	public void a() { b(); }

	public void b() { c(); }
	
	public void c() { Logger.log("toto"); }

}

class Logger {

	public static void log(String message) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		System.out.println(String.format("[%s] [%s] %s", ste.getClassName(), ste.getMethodName(), message));
	}

	public static String logBeanFields(Object input, String fields) throws NoSuchMethodException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException {
		StringBuffer strBuffer = new StringBuffer(); 
		
		for(String field : fields.split("\\,")) {
			if (strBuffer.length() > 0) {
				strBuffer.append(", ");
			}
			
			strBuffer.append(getObjectFieldLog(input, field));
		}
		
		return strBuffer.toString();
	}
	
	private static String getObjectFieldLog(Object obj, String fields) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String result = null; 
		
		for(String field : fields.split("\\,")) {
			if (field.contains(".")) {
				String[] subFields = fields.split("\\.", 2);
				
				String methodName = String.format("get%s%s", subFields[0].substring(0, 1).toUpperCase(), subFields[0].substring(1, subFields[0].length()));  
				Object returnedObject = obj.getClass().getMethod(methodName, new Class[0]).invoke(obj, new Object[0]);
				
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
				
				String returnedValue = obj.getClass().getMethod(methodName, new Class[0]).invoke(obj, new Object[0]).toString();
				
				result = String.format("%s: %s", fieldName, returnedValue);
			}
		}
		
		return result;
	}
		
}

class Bean {

	private static int cpt = 0;
	
	private int a, b;
	
	private Bean bean;
	
	public Bean() {
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
