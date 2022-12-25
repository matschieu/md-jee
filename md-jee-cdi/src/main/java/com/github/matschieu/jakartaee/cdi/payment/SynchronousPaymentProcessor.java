package com.github.matschieu.jakartaee.cdi.payment;

import com.github.matschieu.jakartaee.cdi.common.Synchronous;

// Any bean may declare multiple qualifier types
@Synchronous
@Reliable
public class SynchronousPaymentProcessor implements PaymentProcessor {

}
