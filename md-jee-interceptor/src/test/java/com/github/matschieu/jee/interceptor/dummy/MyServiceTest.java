package com.github.matschieu.jee.interceptor.dummy;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableWeld
public class MyServiceTest {

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.from(MyService.class, MyServiceImpl.class).build();

	@Inject
	private MyService myService;

	@Test
	public void testMyService() {
		Assertions.assertEquals(2, this.myService.getInt());
		Assertions.assertEquals(Integer.valueOf(2), this.myService.getInteger());
		Assertions.assertEquals("{[MyString]}", this.myService.getString());
		Assertions.assertEquals("{[MyOtherString]}", this.myService.getOtherString());
	}
}
