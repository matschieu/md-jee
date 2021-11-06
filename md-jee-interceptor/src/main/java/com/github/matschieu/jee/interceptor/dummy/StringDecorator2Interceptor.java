package com.github.matschieu.jee.interceptor.dummy;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class StringDecorator2Interceptor {

	@AroundInvoke
	public Object interceptOrder(InvocationContext ctx) throws Exception {
		System.out.println(this.getClass().getSimpleName() + ": Intercept " + ctx.getMethod().getName());
		Object output = ctx.proceed();
		if (output instanceof String) {
			return "[" + output + "]";
		}
		return output;
	}

}
