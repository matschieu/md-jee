package com.github.matschieu.jee.cdi.dfault;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.github.matschieu.jee.cdi.WeldTest;

public class HelloServiceTest extends WeldTest {

	@Inject
	private HelloService helloService;

	@Test
	public void testWithContainer() {
		this.initContainer();

		final HelloService helloService = this.getContainer().select(HelloService.class).get();

		Assert.assertEquals("Bonjour", helloService.sayHello());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Bonjour", this.helloService.sayHello());
	}
}
