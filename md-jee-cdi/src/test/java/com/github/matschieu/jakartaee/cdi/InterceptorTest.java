package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.interceptor.InterceptedBean;

import jakarta.inject.Inject;

@Order(11)
public class InterceptorTest extends WeldTest {

	@Inject
	private InterceptedBean bean;

	@Test
	public void testInterceptor() {
		Assertions.assertEquals("raBooF", bean.reverseString("FooBar"));
	}
}
