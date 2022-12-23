package com.github.matschieu.jee.cdi.startup;

import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.jee.cdi.WeldTest;

import jakarta.inject.Inject;

@EnableWeld
public class ObserverBeanTest extends WeldTest {

	@Inject
	private ObserverBean observerBean1;

	@Inject
	private ObserverBean observerBean2;

	@Test
	public void testIniAndDestroyBean() {
		// Because ObserverBean is an observer, it is a singleton by default
		Assertions.assertTrue(this.observerBean1 == this.observerBean2);

		Assertions.assertTrue(this.observerBean1.isInit());
		Assertions.assertFalse(this.observerBean1.isDestroyed());
	}

}
