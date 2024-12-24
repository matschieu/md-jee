package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
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
import com.github.matschieu.jakartaee.cdi.vetoedpackage.VetoedClassA;
import com.github.matschieu.jakartaee.cdi.vetoedpackage.VetoedClassB;
import com.github.matschieu.jakartaee.cdi.vetoedpackage.VetoedClassC;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.UnsatisfiedResolutionException;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

class InjectionTest extends WeldTest {

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
	void testInjectionUsingAnnotation() {
		assertThat(bean1).isInstanceOf(Bean.class);
		assertThat(bean2).isInstanceOf(Bean.class);
		// Each injection of a bean create a new instance
		assertThat(bean1).isNotEqualTo(bean2);
		assertThat(bean1).isNotSameAs(bean2);
	}

	@Test
	void testInjectionUsingProgrammingLookup() {
		assertThat(bean1Instance.isResolvable()).isTrue();
		assertThat(bean2Instance.isResolvable()).isTrue();

		final Bean bean1 = bean1Instance.get();
		final Bean bean2 = bean2Instance.get();

		assertThat(bean1).isInstanceOf(Bean.class);
		assertThat(bean2).isInstanceOf(Bean.class);
		// Each injection of a bean create a new instance
		assertThat(bean1).isNotEqualTo(bean2);
		assertThat(bean1).isNotSameAs(bean2);
	}

	@Test
	void testInjectionUsingContainer() {
		final Instance<Bean> bean1Instance = weld.container().select(Bean.class);
		final Instance<Bean> bean2Instance = weld.container().select(Bean.class);

		assertThat(bean1Instance.isResolvable()).isTrue();
		assertThat(bean2Instance.isResolvable()).isTrue();

		final Bean bean1 = bean1Instance.get();
		final Bean bean2 = bean2Instance.get();

		assertThat(bean1).isInstanceOf(Bean.class);
		assertThat(bean2).isInstanceOf(Bean.class);
		// Each injection of a bean create a new instance
		assertThat(bean1).isNotEqualTo(bean2);
		assertThat(bean1).isNotSameAs(bean2);
	}

	@Test
	void testSingletonInjection() {
		assertThat(singletonBean1).isInstanceOf(SingletonBean.class);
		assertThat(singletonBean2).isInstanceOf(SingletonBean.class);
		// Because a Singleton has only one instance, the container inject the same instance of a Singleton
		assertThat(singletonBean1).isEqualTo(singletonBean2);
		assertThat(singletonBean1).isSameAs(singletonBean2);
	}

	@Test
	void AmbigousDependenciesTest() {
		// Ambigous because object is the superclass of everything
		assertThat(ambigousBean.isResolvable()).isFalse();
		assertThat(ambigousBean.isAmbiguous()).isTrue();
	}

	@Test
	void unsatisfiedDependenciesTest() {
		// Unsatisfied because no bean has these both qualifiers
		assertThat(weld.container().select(AnnotationUtils.toAnnotation(Asynchronous.class), AnnotationUtils.toAnnotation(Reliable.class)).isResolvable()).isFalse();
		assertThat(weld.container().select(AnnotationUtils.toAnnotation(Asynchronous.class), AnnotationUtils.toAnnotation(Reliable.class)).isUnsatisfied()).isTrue();
	}

	@Test
	void testVetoedPackage() {
		assertThat(CDI.current().select(VetoedClassA.class).isResolvable()).isFalse();
		assertThat(CDI.current().select(VetoedClassB.class).isResolvable()).isFalse();
		assertThat(CDI.current().select(VetoedClassC.class).isResolvable()).isFalse();

		assertThat(CDI.current().select(VetoedClassA.class).isUnsatisfied()).isTrue();
		assertThat(CDI.current().select(VetoedClassB.class).isUnsatisfied()).isTrue();
		assertThat(CDI.current().select(VetoedClassC.class).isUnsatisfied()).isTrue();

		assertThatExceptionOfType(UnsatisfiedResolutionException.class).isThrownBy(() -> CDI.current().select(VetoedClassA.class).get());
		assertThatExceptionOfType(UnsatisfiedResolutionException.class).isThrownBy(() -> CDI.current().select(VetoedClassB.class).get());
		assertThatExceptionOfType(UnsatisfiedResolutionException.class).isThrownBy(() -> CDI.current().select(VetoedClassC.class).get());
	}

	@Test
	void testVetoedClass() {
		// This injection is not ambigous due to the use of the Vetoed which exclude the package from the bean management by the container
		assertThat(notVetoedBean).isInstanceOf(NotVetoedBean.class);
		assertThat(vetoedBean.isResolvable()).isFalse();
		// Getting an exception when trying to inject a Vetoed bean
		assertThatExceptionOfType(UnsatisfiedResolutionException.class).isThrownBy(() -> vetoedBean.get());
	}

	@Test
	void testInitializers() {
		// Default constructor is not called as there is another constructor annotated @Inject
		assertThat(initBean.getDefaultConstructorBean()).isNull();

		assertThat(initBean.getConstructorBean()).isNotNull();
		assertThat(initBean.getField1Bean()).isNotNull();
		assertThat(initBean.getField2Bean()).isNotNull();
		assertThat(initBean.getMethod1Bean()).isNotNull();
		assertThat(initBean.getMethod2Bean()).isNotNull();

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
		assertThat(values.size()).isEqualTo(5);
		assertThat(values.get(0)).isEqualTo("CONSTRUCTOR");
		assertThat(values.get(1).substring(0, values.get(1).length() - 1)).isEqualTo("FIELD");
		assertThat(values.get(2).substring(0, values.get(2).length() - 1)).isEqualTo("FIELD");
		assertThat(values.get(3).substring(0, values.get(3).length() - 1)).isEqualTo("METHOD");
		assertThat(values.get(4).substring(0, values.get(4).length() - 1)).isEqualTo("METHOD");
	}

	@Test
	void testMultiContainer() {
		final WeldContainer container1 = new Weld().enableDiscovery().initialize();
		final WeldContainer container2 = new Weld().enableDiscovery().initialize();

		final SingletonBean singletonBean1 = container1.select(SingletonBean.class).get();
		final SingletonBean singletonBean2 = container2.select(SingletonBean.class).get();

		// A singleton is a unique instance, so 2 instances of a singleton inside the same container are equals
		assertThat(singletonBean1).isSameAs(container1.select(SingletonBean.class).get());
		assertThat(singletonBean2).isSameAs(container2.select(SingletonBean.class).get());
		// But 2 instances of a singleton from both container are not equals
		assertThat(singletonBean1).isNotSameAs(singletonBean2);

		container1.shutdown();
		container2.shutdown();
	}

}
