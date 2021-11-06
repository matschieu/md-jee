package com.github.matschieu.jee.interceptor.dummy;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class MyServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(MyService.class, MyServiceImpl.class).activate().inject(this).build();

    @Inject
    private MyService myService;

	@Test
	public void testMyService() {
		Assert.assertEquals(2, myService.getInt());
		Assert.assertEquals(Integer.valueOf(2), myService.getInteger());
		Assert.assertEquals("{[MyString]}", myService.getString());
		Assert.assertEquals("{[MyOtherString]}", myService.getOtherString());
	}
}
