package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(dependentBean1).isNotNull();
		assertThat(dependentBean2).isNotNull();
		// dependent is the scope by default for any bean
		// When injected, a new instance of the dependent beane is created
		assertThat(dependentBean1).isNotEqualTo(dependentBean2);
	}

	@Test
	void testApplicationScoped() {
		assertThat(appBean1).isNotNull();
		assertThat(appBean2).isNotNull();
		// ApplicationScoped beans are instanciated once for the whole application
		assertThat(appBean1).isEqualTo(appBean2);
	}

}
