package com.github.matschieu.jee.interceptor.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ValidationInterceptor {

	private void checkObject(Object obj) throws Exception {
		if (obj == null) {
			return;
		}
		if (obj instanceof String) {
			return;
		}

		for(Field field : obj.getClass().getDeclaredFields()) {
			if (field.getType().isPrimitive()) {
				continue;
			}

			field.setAccessible(true);
			System.out.println(field.getName() + " = " + field.get(obj));
			checkFieldAnnotation(field.getName(), field.getAnnotations(), field.get(obj));
		}
	}

	private void checkFieldAnnotation(String fieldName, Annotation[] annotations, Object value) throws Exception {
		for(Annotation annotation : annotations) {
			if(annotation.annotationType() == NotNullElement.class && value == null) {
				throw new NullElementException(fieldName + " is null");
			}
		}
	}

	@AroundInvoke
	public Object interceptOrder(InvocationContext ctx) throws Exception {
		Object[] inputs = ctx.getParameters();
		Parameter[] params = ctx.getMethod().getParameters();

		for(int i = 0; i < params.length; i++) {
			System.out.println(params[i].getName() + " = " + inputs[i]);
			checkFieldAnnotation(params[i].getName(), params[i].getAnnotations(), inputs[i]);
			checkObject(inputs[i]);
		}

		return ctx.proceed();
	}

}
