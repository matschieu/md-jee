package com.github.matschieu.jee.cdi.startup;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.github.matschieu.jee.cdi.WeldTest;

public class ObserverBeanTest extends WeldTest {

	@Inject
	private ObserverBean observerBean1;

	@Inject
	private ObserverBean observerBean2;

	@Test
	public void testIniAndDestroyBean() {
		// Because ObserverBean is an observer, it is a singleton by default
		Assert.assertTrue(this.observerBean1 == this.observerBean2);

		Assert.assertTrue(this.observerBean1.isInit());
		Assert.assertFalse(this.observerBean1.isDestroyed());
	}

}
