package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.CallbackBean;

import jakarta.inject.Inject;

class CallbackTest extends WeldTest {

	@Inject
	private CallbackBean bean1;

	@Inject
	private CallbackBean bean2;

	@Inject
	private CallbackBean bean3;

	@BeforeAll
	static void checkCallbackState() {
		// At this step the container is not started, it has created no instance and the counter is 0
		assertThat(CallbackBean.getAliveInstances()).isZero();
	}

	@Test
	void testPostConstruct() {
		// At this step the container has created 3 instances
		assertThat(CallbackBean.getAliveInstances()).isEqualTo(3);

		CallbackBean bean = new CallbackBean();
		// A "new" only process the constructor, not the @PostConstruct method managed by the container
		// So instance number is not initialized and the counter of alive instance is not incremented
		assertThat(bean.getInstanceNumber()).isNull();
		assertThat(CallbackBean.getAliveInstances()).isEqualTo(3);

		// The container manage the bean and process the @PostConstruct method (after the constructor)
		// so each injected bean has an instance number (injection are done in the order of field declarations)
		assertThat(bean1.getInstanceNumber()).isNotNull().isEqualTo(0);
		assertThat(bean2.getInstanceNumber()).isNotNull().isEqualTo(1);
		assertThat(bean3.getInstanceNumber()).isNotNull().isEqualTo(2);
	}

	@AfterAll
	static void validatePreDestroy() {
		// Her is the proof that PreDestroy method has been called when the cointainer was stopped
		// Each predestroy has decreased the counter of alive instances
		// The container has created 3 instances and destroyed the sames
		assertThat(CallbackBean.getAliveInstances()).isZero();
	}

}
