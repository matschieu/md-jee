package com.github.matschieu.jakartaee.cdi.bean;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

public class BeanProducer {

	// This method is called to build the instance of the bean to inject
	@Produces
	@Named("ProducedBean")
	public ProducedBean getProducedBean() {
		ProducedBean bean = new ProducedBean();
		bean.setProduced(true);
	    return bean;
	}

	// A disposer method must have a producer (with same qualifiers) associated
	public void disposeProducedBean(@Disposes @Named("ProducedBean") ProducedBean bean) {
		bean.setDisposed(true);
	}

}
