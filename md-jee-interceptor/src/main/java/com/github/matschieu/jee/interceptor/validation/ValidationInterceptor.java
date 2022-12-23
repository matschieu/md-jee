package com.github.matschieu.jee.interceptor.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
public class ValidationInterceptor {

	private void checkObject(final Object obj) throws Exception {
		if ((obj == null) || (obj instanceof String)) {
			return;
		}

		for (final Field field : obj.getClass().getDeclaredFields()) {
			if (field.getType().isPrimitive()) {
				continue;
			}

			field.setAccessible(true);
			System.out.println(field.getName() + " = " + field.get(obj));
			this.checkFieldAnnotation(field.getName(), field.getAnnotations(), field.get(obj));
		}
	}

	private void checkFieldAnnotation(final String fieldName, final Annotation[] annotations, final Object value) throws Exception {
		for (final Annotation annotation : annotations) {
			if (annotation.annotationType() == NotNullElement.class && value == null) {
				throw new NullElementException(fieldName + " is null");
			}
		}
	}

	@AroundInvoke
	public Object interceptOrder(final InvocationContext ctx) throws Exception {
		final Object[] inputs = ctx.getParameters();
		final Parameter[] params = ctx.getMethod().getParameters();

		for (int i = 0; i < params.length; i++) {
			System.out.println(params[i].getName() + " = " + inputs[i]);
			this.checkFieldAnnotation(params[i].getName(), params[i].getAnnotations(), inputs[i]);
			this.checkObject(inputs[i]);
		}

		return ctx.proceed();
	}

}
