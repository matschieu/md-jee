package com.github.matschieu.jee.cdi.dfault;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class HelloServiceTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(FrenchHelloService.class, EnglishHelloService.class).activate().inject(this).build();

	@Inject
	private HelloService helloService;

	@Test
	public void testWithContainer() {
		final Weld weld = new Weld();
		final WeldContainer container = weld.initialize();
		final HelloService helloService = container.select(HelloService.class).get();

		Assert.assertEquals("Bonjour", helloService.sayHello());

		container.shutdown();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Bonjour", this.helloService.sayHello());
	}
}
