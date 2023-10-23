package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
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
		Assertions.assertInstanceOf(SynchronousPaymentProcessor.class, syncPaymentProcessor);
		Assertions.assertInstanceOf(AsynchronousPaymentProcessor.class, asyncPaymentProcessor);
		Assertions.assertInstanceOf(SynchronousPaymentProcessor.class, reliablePaymentProcessor);
		Assertions.assertInstanceOf(SynchronousPaymentProcessor.class, reliableSynchronousPaymentProcessor);
	}

}
