package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.ApplicationScopedBean;
import com.github.matschieu.jakartaee.cdi.bean.Bean;

import jakarta.inject.Inject;

class ScopeTest extends WeldTest {

	@Inject
	private Bean dependentBean1;

	@Inject
	private Bean dependentBean2;

	@Inject
	private ApplicationScopedBean appBean1;

	@Inject
	private ApplicationScopedBean appBean2;

	@Test
	void testDependentScoped() {
		Assertions.assertNotNull(dependentBean1);
		Assertions.assertNotNull(dependentBean2);
		// dependent is the scope by default for any bean
		// When injected, a new instance of the dependent beane is created
		Assertions.assertNotEquals(dependentBean1, dependentBean2);
	}

	@Test
	void testApplicationScoped() {
		Assertions.assertNotNull(appBean1);
		Assertions.assertNotNull(appBean2);
		// ApplicationScoped beans are instanciated once for the whole application
		Assertions.assertEquals(appBean1, appBean2);
	}

}
