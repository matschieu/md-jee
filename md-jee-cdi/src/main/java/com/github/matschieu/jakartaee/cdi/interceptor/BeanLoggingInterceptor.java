package com.github.matschieu.jakartaee.cdi.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@BeanLogging
public class BeanLoggingInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("Called method: " + ctx.getMethod().getName());
		System.out.println("Input = " + ctx.getParameters()[0]);

		final Object output = ctx.proceed();

		System.out.println("Output = " + output);

		return output;
	}

}
