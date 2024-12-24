package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

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

class ProducerTest extends WeldTest {

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
	void testPrimitiveProducer() {
		// Use the producer to get a random integer
		assertThat(randomInteger).isNotNull();
		assertThat(randomInteger.intValue()).isNotZero();
		// Use the producer to get a random integer converted to int by autoboxing
		assertThat(randomInt).isNotZero();
		assertThat(nullInteger).isNull();
		// The producer returns a null so the container inject the primitive type’s default value to avoid NPE
		assertThat(nullInt).isZero();
		// The producer can simply return a primitive type
		assertThat(randomDouble).isNotEqualTo(0.0);
	}

	@Test
	void testProducer() {
		PaymentProcessorBuilder.setSynchronous(true);
		assertThat(paymentProcessor.get()).isInstanceOf(SynchronousPaymentProcessor.class);

		PaymentProcessorBuilder.setSynchronous(false);
		assertThat(paymentProcessor.get()).isInstanceOf(AsynchronousPaymentProcessor.class);
	}

	@Test
	void testDisposer() {
		// When instanciated outside the container, producer and disposer are not called
		ProducedBean localBean = new ProducedBean();
		assertThat(localBean.isProduced()).isFalse();
		assertThat(localBean.isDisposed()).isFalse();

		producedBeanInstance.destroy(localBean);

		// The producer is called when injecting the bean
		ProducedBean bean = producedBeanInstance.get();
		assertThat(bean).isNotNull();
		assertThat(bean.isProduced()).isTrue();
		assertThat(bean.isDisposed()).isFalse();

		// The container destroy the bean, the disposer is called
		producedBeanInstance.destroy(bean);
		assertThat(bean.isDisposed()).isTrue();

		// Do nothing, the bean has already been destroyed by the container
		// The instance of bean is still existing in memory but is not managed anymore by the container
		producedBeanInstance.destroy(bean);

	}

}
