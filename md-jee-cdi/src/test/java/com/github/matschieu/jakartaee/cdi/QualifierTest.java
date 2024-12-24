package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.common.Asynchronous;
import com.github.matschieu.jakartaee.cdi.common.Synchronous;
import com.github.matschieu.jakartaee.cdi.payment.AsynchronousPaymentProcessor;
import com.github.matschieu.jakartaee.cdi.payment.PaymentProcessor;
import com.github.matschieu.jakartaee.cdi.payment.Reliable;
import com.github.matschieu.jakartaee.cdi.payment.SynchronousPaymentProcessor;

import jakarta.inject.Inject;

class QualifierTest extends WeldTest {

	@Inject
	@Synchronous
	PaymentProcessor syncPaymentProcessor;

	@Inject
	@Asynchronous
	PaymentProcessor asyncPaymentProcessor;

	@Inject
	@Reliable
	PaymentProcessor reliablePaymentProcessor;

	@Inject
	@Reliable
	@Synchronous
	PaymentProcessor reliableSynchronousPaymentProcessor;

	@Test
	void testInjectionWithQualifier() {
		assertThat(syncPaymentProcessor).isInstanceOf(SynchronousPaymentProcessor.class);
		assertThat(asyncPaymentProcessor).isInstanceOf(AsynchronousPaymentProcessor.class);
		assertThat(reliablePaymentProcessor).isInstanceOf(SynchronousPaymentProcessor.class);
		assertThat(reliableSynchronousPaymentProcessor).isInstanceOf(SynchronousPaymentProcessor.class);
	}

}
