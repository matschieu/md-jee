package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.CallbackBean;

import jakarta.inject.Inject;

public class CallbackTest extends WeldTest {

	@Inject
	private CallbackBean bean1;

	@Inject
	private CallbackBean bean2;

	@Inject
	private CallbackBean bean3;

	@BeforeAll
	public static void checkCallbackState() {
		// At this step the container is not started, it has created no instance and the counter is 0
		Assertions.assertEquals(0, CallbackBean.getAliveInstances());
	}

	@Test
	public void testPostConstruct() {
		// At this step the container has created 3 instances
		Assertions.assertEquals(3, CallbackBean.getAliveInstances());

		CallbackBean bean = new CallbackBean();
		// A "new" only process the constructor, not the @PostConstruct method managed by the container
		// So instance number is not initialized and the counter of alive instance is not incremented
		Assertions.assertNull(bean.getInstanceNumber());
		Assertions.assertEquals(3, CallbackBean.getAliveInstances());

		// The container manage the bean and process the @PostConstruct method (after the constructor)
		// so each injected bean has an instance number (injection are done in the order of field declarations)
		Assertions.assertNotNull(bean1.getInstanceNumber());
		Assertions.assertNotNull(bean2.getInstanceNumber());
		Assertions.assertNotNull(bean3.getInstanceNumber());
		Assertions.assertEquals(0, bean1.getInstanceNumber());
		Assertions.assertEquals(1, bean2.getInstanceNumber());
		Assertions.assertEquals(2, bean3.getInstanceNumber());
	}

	@AfterAll
	public static void validatePreDestroy() {
		// Her is the proof that PreDestroy method has been called when the cointainer was stopped
		// Each predestroy has decreased the counter of alive instances
		// The container has created 3 instances and destroyed the sames
		Assertions.assertEquals(0, CallbackBean.getAliveInstances());
	}

}
