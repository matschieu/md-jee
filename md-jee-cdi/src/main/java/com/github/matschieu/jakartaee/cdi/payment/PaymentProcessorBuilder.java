package com.github.matschieu.jakartaee.cdi.payment;

import com.github.matschieu.jakartaee.cdi.common.Asynchronous;
import com.github.matschieu.jakartaee.cdi.common.Synchronous;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

public class PaymentProcessorBuilder {

	private static boolean synchronous;

	public static void setSynchronous(boolean value) {
		synchronous = value;
	}

	public static boolean isSynchronous() {
		return synchronous;
	}

	// This method is called to build the instance of the bean to inject
	@Produces
	public PaymentProcessor getPaymentProcessor(@Synchronous PaymentProcessor sync, @Asynchronous PaymentProcessor async) {
	    return isSynchronous() ? sync : async;
	}

	// A disposer method must have a producer (with same qualifiers) associated
	public void disposePaymentProcessor(@Disposes PaymentProcessor pp) {
	}

}
