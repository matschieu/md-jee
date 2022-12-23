package com.github.matschieu.jee.cdi.dfault;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.jee.cdi.WeldTest;

import jakarta.inject.Inject;

public class HelloServiceTest extends WeldTest {

	@Inject
	private HelloService helloService;

	@Test
	public void testWithContainer() {
		this.initContainer();

		final HelloService helloService = this.getContainer().select(HelloService.class).get();

		Assertions.assertEquals("Bonjour", helloService.sayHello());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assertions.assertEquals("Bonjour", this.helloService.sayHello());
	}
}
