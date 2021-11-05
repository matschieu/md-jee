package com.github.matschieu.jee.interceptor;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.github.matschieu.jee.interceptor.dummy.MyService;
import com.github.matschieu.jee.interceptor.dummy.MyServiceImpl;

public class MyServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(MyService.class, MyServiceImpl.class).activate().inject(this).build();

    @Inject
    private MyService myService;

	@Test
	public void testMyService() {
		Assert.assertEquals(2, this.myService.getInt());
		Assert.assertEquals(Integer.valueOf(2), this.myService.getInteger());
		Assert.assertEquals("{MyString}", this.myService.getString());
		Assert.assertEquals("{MyOtherString}", this.myService.getOtherString());
	}
}
