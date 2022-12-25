package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
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

@Order(4)
public class BuiltInQualifiersTest extends WeldTest {

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
	public void testInjectionWithDefaultQualifiersUsingAnnotations() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		Assertions.assertInstanceOf(Bean.class, bean);
		Assertions.assertInstanceOf(Bean.class, beanWithDefault);
		Assertions.assertInstanceOf(Bean.class, beanWithAnyDefault);
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		Assertions.assertInstanceOf(AnyDefaultBean.class, anyDefaultBean);
	}

	@Test
	public void testInjectionWithDefaultQualifiersUsingProgrammingLookup() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		Assertions.assertInstanceOf(Bean.class, beanInstance.get());
		Assertions.assertInstanceOf(Bean.class, beanWithDefaultInstance.get());
		Assertions.assertInstanceOf(Bean.class, beanWithAnyDefaultInstance.get());
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		Assertions.assertInstanceOf(AnyDefaultBean.class, anyDefaultBeanInstance.get());
	}

	@Test
	public void testInjectionWithDefaultQualifiersUsingContainer() {
		// Qualifiers @Any and @Default are implicit and added by default to each bean
		Assertions.assertInstanceOf(Bean.class, weld.container().select(Bean.class).get());
		Assertions.assertInstanceOf(Bean.class, weld.container().select(Bean.class, AnnotationUtils.toAnnotation(Default.class)).get());
		Assertions.assertInstanceOf(Bean.class, weld.container().select(Bean.class, AnnotationUtils.toAnnotation(Any.class), AnnotationUtils.toAnnotation(Default.class)).get());
		// @Any and @Default are explicitly declared in the bean but are not necessary to inject it
		Assertions.assertInstanceOf(AnyDefaultBean.class, weld.container().select(AnyDefaultBean.class).get());
	}

	@Test
	public void testInjectionWithName() {
		Assertions.assertInstanceOf(NamedBean.class, namedBean);
		// If no name binds with the name defined at the injection point, then an exception is thrown when injecting
		Assertions.assertThrows(UnsatisfiedResolutionException.class, () -> badNamedBeanInstance.get());
	}

}
