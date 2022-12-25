package com.github.matschieu.jakartaee.cdi.bean;

import jakarta.inject.Inject;

public class InitializedBean {

	// Injected fields are initialized in the order of declaration, after the constructor
	// It is a non-static, non-final field of a bean class or of any other classes supporting injection
	@Inject
	private CounterBean field2Bean;

	// Injected fields are initialized in the order of declaration, after the constructor
	// It is a non-static, non-final field of a bean class or of any other classes supporting injection
	@Inject
	private CounterBean field1Bean;

	private CounterBean constructorBean;

	private CounterBean defaultConstructorBean;

	private CounterBean method1Bean;

	private CounterBean method2Bean;

	// Method called by the container when creating an instance of this bean
	// Parameters will be injected
	// Order of execution is not guaranteed by the container
	// It is a default-access, public, protected or private, non-abstract, non-static, non-generic method of a bean class or of any other classes supporting injection
	// A bean class may declare multiple (or zero) initializer methods
	// Method interceptors are never called when the container calls an initializer method
	@Inject
	public void method2(CounterBean bean) {
		this.method2Bean = bean;
	}

	// Method called by the container when creating an instance of this bean
	// Parameters will be injected
	// Order of execution is not guaranteed by the container
	// It is a default-access, public, protected or private, non-abstract, non-static, non-generic method of a bean class or of any other classes supporting injection
	// A bean class may declare multiple (or zero) initializer methods
	// Method interceptors are never called when the container calls an initializer method
	@Inject
	private void method1(CounterBean bean) {
		this.method1Bean = bean;
	}

	// If there is no default constructor, then the container will use a constructor annotated @Inject
	// Parameters will be injected
	// If both default and parameterized constructor exists, the default is not called
	// There must be only one constructor annotated @Inject
	@Inject
	public InitializedBean(CounterBean bean) {
		this.constructorBean = bean;
	}

	// Won't be called due to the presence of the parameterized constructor
	public InitializedBean() {
		this.defaultConstructorBean = new CounterBean();
	}

	public CounterBean getConstructorBean() {
		return constructorBean;
	}

	public CounterBean getDefaultConstructorBean() {
		return defaultConstructorBean;
	}

	public CounterBean getField1Bean() {
		return field1Bean;
	}

	public CounterBean getField2Bean() {
		return field2Bean;
	}

	public CounterBean getMethod1Bean() {
		return method1Bean;
	}

	public CounterBean getMethod2Bean() {
		return method2Bean;
	}

}
