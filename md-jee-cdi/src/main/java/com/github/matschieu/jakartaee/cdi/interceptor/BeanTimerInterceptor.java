package com.github.matschieu.jakartaee.cdi.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@BeanTimer
public class BeanTimerInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		final long startTime = System.currentTimeMillis();

		final Object output = ctx.proceed();

		System.out.println("Exec time = " + (System.currentTimeMillis() - startTime));

		return output;
	}

}
