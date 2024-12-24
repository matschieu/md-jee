package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.AnyDefaultBean;
import com.github.matschieu.jakartaee.cdi.bean.Bean;
import com.github.matschieu.jakartaee.cdi.bean.NamedBean;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.UnsatisfiedResolutionException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

class BuiltInQualifiersTest extends WeldTest {

	@Inject
	private Bean bean;

	@Inject
	@Default
	private Bean beanWithDefault;

	@Inject
	@Any
	@Default
	private Bean beanWithAnyDefault;

	@Inject
	private AnyDefaultBean anyDefaultBean;

	@Inject
	private Instance<Bean> beanInstance;

	@Inject
	@Default
	private Instance<Bean> beanWithDefaultInstance;

	@Inject
	@Any
	@Default
	private Instance<Bean> beanWithAnyDefaultInstance;

	@Inject
	@Any
	@Default
	private Instance<AnyDefaultBean> anyDefaultBeanInstance;

	@Inject
	@Named("MyBean")
	private NamedBean namedBean;

	@Inject
	@Named("BadBean")
	private Instance<NamedBean> badNamedBeanInstance;

	@Test
	void testInjectionWithDefaultQualifiersUsingAnnotations() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		assertThat(bean).isInstanceOf(Bean.class);
		assertThat(beanWithDefault).isInstanceOf(Bean.class);
		assertThat(beanWithAnyDefault).isInstanceOf(Bean.class);
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		assertThat(anyDefaultBean).isInstanceOf(AnyDefaultBean.class);
	}

	@Test
	void testInjectionWithDefaultQualifiersUsingProgrammingLookup() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		assertThat(beanInstance.get()).isInstanceOf(Bean.class);
		assertThat(beanWithDefaultInstance.get()).isInstanceOf(Bean.class);
		assertThat(beanWithAnyDefaultInstance.get()).isInstanceOf(Bean.class);
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		assertThat(anyDefaultBeanInstance.get()).isInstanceOf(AnyDefaultBean.class);
	}

	@Test
	void testInjectionWithDefaultQualifiersUsingContainer() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		assertThat(weld.container().select(Bean.class).get()).isInstanceOf(Bean.class);
		assertThat(weld.container().select(Bean.class, AnnotationUtils.toAnnotation(Default.class)).get()).isInstanceOf(Bean.class);
		assertThat(weld.container().select(Bean.class, AnnotationUtils.toAnnotation(Any.class), AnnotationUtils.toAnnotation(Default.class)).get()).isInstanceOf(Bean.class);
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		assertThat(weld.container().select(AnyDefaultBean.class).get()).isInstanceOf(AnyDefaultBean.class);
	}

	@Test
	void testInjectionWithName() {
		assertThat(namedBean).isInstanceOf(NamedBean.class);
		// If no name binds with the name defined at the injection point, then an exception is thrown when injecting
		assertThatExceptionOfType(UnsatisfiedResolutionException.class).isThrownBy(() -> badNamedBeanInstance.get());
	}

}
