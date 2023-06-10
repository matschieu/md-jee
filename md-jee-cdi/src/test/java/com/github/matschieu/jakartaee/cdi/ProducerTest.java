package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.ProducedBean;
import com.github.matschieu.jakartaee.cdi.payment.AsynchronousPaymentProcessor;
import com.github.matschieu.jakartaee.cdi.payment.PaymentProcessor;
import com.github.matschieu.jakartaee.cdi.payment.PaymentProcessorBuilder;
import com.github.matschieu.jakartaee.cdi.payment.SynchronousPaymentProcessor;
import com.github.matschieu.jakartaee.cdi.primitive.Null;
import com.github.matschieu.jakartaee.cdi.primitive.Random;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class ProducerTest extends WeldTest {

	@Inject
	@Random
	private Integer randomInteger;

	@Inject
	@Random
	private int randomInt;

	@Inject
	@Random
	private double randomDouble;

	@Inject
	@Null
	private Integer nullInteger;

	@Inject
	@Null
	private int nullInt;

	@Inject
	private Instance<PaymentProcessor> paymentProcessor;

	@Inject
	@Named("ProducedBean")
	private Instance<ProducedBean> producedBeanInstance;

	@Test
	public void testPrimitiveProducer() {
		// Use the producer to get a random integer
		Assertions.assertNotNull(randomInteger);
		Assertions.assertNotEquals(0, randomInteger.intValue());
		// Use the producer to get a random integer converted to int by autoboxing
		Assertions.assertNotEquals(0, randomInt);
		Assertions.assertNull(nullInteger);
		// The producer returns a null so the container inject the primitive type’s default value to avoid NPE
		Assertions.assertEquals(0, nullInt);
		// The producer can simply return a primitive type
		Assertions.assertNotEquals(0.0, randomDouble);
	}

	@Test
	public void testProducer() {
		PaymentProcessorBuilder.setSynchronous(true);
		Assertions.assertInstanceOf(SynchronousPaymentProcessor.class, paymentProcessor.get());

		PaymentProcessorBuilder.setSynchronous(false);
		Assertions.assertInstanceOf(AsynchronousPaymentProcessor.class, paymentProcessor.get());
	}

	@Test
	public void testDisposer() {
		// When instanciated outside the container, producer and disposer are not called
		ProducedBean localBean = new ProducedBean();
		Assertions.assertFalse(localBean.isProduced());
		Assertions.assertFalse(localBean.isDisposed());

		producedBeanInstance.destroy(localBean);

		// The producer is called when injecting the bean
		ProducedBean bean = producedBeanInstance.get();
		Assertions.assertNotNull(bean);
		Assertions.assertTrue(bean.isProduced());
		Assertions.assertFalse(bean.isDisposed());

		// The container destroy the bean, the disposer is called
		producedBeanInstance.destroy(bean);
		Assertions.assertTrue(bean.isDisposed());

		// Do nothing, the bean has already been destroyed by the container
		// The instance of bean is still existing in memory but is not managed anymore by the container
		producedBeanInstance.destroy(bean);

	}

}
