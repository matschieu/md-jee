package com.github.matschieu.jakartaee.cdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.AmbigousBean;
import com.github.matschieu.jakartaee.cdi.bean.Bean;
import com.github.matschieu.jakartaee.cdi.bean.InitializedBean;
import com.github.matschieu.jakartaee.cdi.bean.NotVetoedBean;
import com.github.matschieu.jakartaee.cdi.bean.SingletonBean;
import com.github.matschieu.jakartaee.cdi.bean.VetoedBean;
import com.github.matschieu.jakartaee.cdi.common.Asynchronous;
import com.github.matschieu.jakartaee.cdi.payment.Reliable;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@Order(2)
public class InjectionTest extends WeldTest {

	@Inject
	private Bean bean1;

	@Inject
	private Bean bean2;

	@Inject
	private Instance<Bean> bean1Instance;

	@Inject
	private Instance<Bean> bean2Instance;

	@Inject
	private SingletonBean singletonBean1;

	@Inject
	private SingletonBean singletonBean2;

	@Inject
	private InitializedBean initBean;

	@Inject
	private Instance<AmbigousBean> ambigousBean;

	@Inject
	private NotVetoedBean notVetoedBean;

	@Inject
	private Instance<VetoedBean> vetoedBean;

	@Test
	public void testInjectionUsingAnnotation() {
		Assertions.assertInstanceOf(Bean.class, bean1);
		Assertions.assertInstanceOf(Bean.class, bean2);
		// Each injection of a bean create a new instance
		Assertions.assertNotEquals(bean1, bean2);
		Assertions.assertNotSame(bean1, bean2);
	}

	@Test
	public void testInjectionUsingProgrammingLookup() {
		Assertions.assertTrue(bean1Instance.isResolvable());
		Assertions.assertTrue(bean2Instance.isResolvable());

		final Bean bean1 = bean1Instance.get();
		final Bean bean2 = bean2Instance.get();

		Assertions.assertInstanceOf(Bean.class, bean1);
		Assertions.assertInstanceOf(Bean.class, bean2);
		// Each injection of a bean create a new instance
		Assertions.assertNotEquals(bean1, bean2);
		Assertions.assertNotSame(bean1, bean2);
	}

	@Test
	public void testInjectionUsingContainer() {
		final Instance<Bean> bean1Instance = weld.container().select(Bean.class);
		final Instance<Bean> bean2Instance = weld.container().select(Bean.class);

		Assertions.assertTrue(bean1Instance.isResolvable());
		Assertions.assertTrue(bean2Instance.isResolvable());

		final Bean bean1 = bean1Instance.get();
		final Bean bean2 = bean2Instance.get();

		Assertions.assertInstanceOf(Bean.class, bean1);
		Assertions.assertInstanceOf(Bean.class, bean2);
		// Each injection of a bean create a new instance
		Assertions.assertNotEquals(bean1, bean2);
		Assertions.assertNotSame(bean1, bean2);
	}

	@Test
	public void testSingletonInjection() {
		Assertions.assertInstanceOf(SingletonBean.class, singletonBean1);
		Assertions.assertInstanceOf(SingletonBean.class, singletonBean2);
		// Because a Singleton has only one instance, the container inject the same instance of a Singleton
		Assertions.assertEquals(singletonBean1, singletonBean2);
		Assertions.assertSame(singletonBean1, singletonBean2);
	}

	@Test
	public void AmbigousDependenciesTest() {
		// Ambigous because object is the superclass of everything
		Assertions.assertFalse(ambigousBean.isResolvable());
		Assertions.assertTrue(ambigousBean.isAmbiguous());
	}

	@Test
	public void unsatisfiedDependenciesTest() {
		// Unsatisfied because no bean has these both qualifiers
		Assertions.assertFalse(weld.container().select(AnnotationUtils.toAnnotation(Asynchronous.class), AnnotationUtils.toAnnotation(Reliable.class)).isResolvable());
		Assertions.assertTrue(weld.container().select(AnnotationUtils.toAnnotation(Asynchronous.class), AnnotationUtils.toAnnotation(Reliable.class)).isUnsatisfied());
	}

	@Test
	public void testVetoed() {
		// This injection is not ambigous due to the use of the Vetoed which exclude a bean from the bean management by the container
		Assertions.assertInstanceOf(NotVetoedBean.class, notVetoedBean);
		Assertions.assertFalse(vetoedBean.isResolvable());
		// Getting an exception when trying to inject a Vetoed bean
		Assertions.assertThrows(Exception.class, () -> vetoedBean.get());
	}

	@Test
	public void testInitializers() {
		// Default constructor is not called as there is another constructor annotated @Inject
		Assertions.assertNull(initBean.getDefaultConstructorBean());

		Assertions.assertNotNull(initBean.getConstructorBean());
		Assertions.assertNotNull(initBean.getField1Bean());
		Assertions.assertNotNull(initBean.getField2Bean());
		Assertions.assertNotNull(initBean.getMethod1Bean());
		Assertions.assertNotNull(initBean.getMethod2Bean());

		final Map<Integer, String> injectionOrder = new TreeMap<>();
		injectionOrder.put(initBean.getMethod2Bean().getInstanceNumber(), "METHOD2");
		injectionOrder.put(initBean.getMethod1Bean().getInstanceNumber(), "METHOD1");
		injectionOrder.put(initBean.getField2Bean().getInstanceNumber(), "FIELD2");
		injectionOrder.put(initBean.getField1Bean().getInstanceNumber(), "FIELD1");
		injectionOrder.put(initBean.getConstructorBean().getInstanceNumber(), "CONSTRUCTOR");

		final var values = new ArrayList<String>(injectionOrder.values());

		System.out.println(Arrays.toString(values.toArray()));

		// Order of injection of fields or methods by the container is not guaranteed
		// But it is always starts with the constructor, then the fields and at the ends the methods
		Assertions.assertEquals(5, values.size());
		Assertions.assertEquals("CONSTRUCTOR", values.get(0));
		Assertions.assertEquals("FIELD", values.get(1).substring(0, values.get(1).length() - 1));
		Assertions.assertEquals("FIELD", values.get(2).substring(0, values.get(2).length() - 1));
		Assertions.assertEquals("METHOD", values.get(3).substring(0, values.get(3).length() - 1));
		Assertions.assertEquals("METHOD", values.get(4).substring(0, values.get(4).length() - 1));
	}

}
