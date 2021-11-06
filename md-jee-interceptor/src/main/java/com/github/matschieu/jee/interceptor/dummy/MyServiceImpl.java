package com.github.matschieu.jee.interceptor.dummy;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.interceptor.Interceptors;

@Default
@ApplicationScoped
@Interceptors({StringDecorator1Interceptor.class, StringDecorator2Interceptor.class})
public class MyServiceImpl implements MyService {

	@PostConstruct
	public void init() {
	}

	@Interceptors(IntIncrementInterceptor.class)
	@Override
	public int getInt() {
		return 1;
	}

	@Interceptors(IntIncrementInterceptor.class)
	@Override
	public Integer getInteger() {
		return Integer.valueOf(1);
	}

	@Override
	public String getString() {
		return "MyString";
	}

	@Override
	public String getOtherString() {
		return "MyOtherString";
	}

	@Override
	public void doNothing() {
	}

}
