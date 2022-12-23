package com.github.matschieu.jee.interceptor.dummy;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
public class StringDecorator2Interceptor {

	@AroundInvoke
	public Object interceptOrder(final InvocationContext ctx) throws Exception {
		System.out.println(this.getClass().getSimpleName() + ": Intercept " + ctx.getMethod().getName());
		final Object output = ctx.proceed();
		if (output instanceof String) {
			return "[" + output + "]";
		}
		return output;
	}

}
