package com.github.matschieu.jee.interceptor.dummy;

import static org.assertj.core.api.Assertions.assertThat;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableWeld
class MyServiceTest {

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.from(MyService.class, MyServiceImpl.class).build();

	@Inject
	private MyService myService;

	@Test
	void testMyService() {
		assertThat(this.myService.getInt()).isEqualTo(2);
		assertThat(this.myService.getInteger()).isEqualTo(Integer.valueOf(2));
		assertThat(this.myService.getString()).isEqualTo("{[MyString]}");
		assertThat(this.myService.getOtherString()).isEqualTo("{[MyOtherString]}");
	}

}
