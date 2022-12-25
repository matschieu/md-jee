package com.github.matschieu.jakartaee.cdi.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class CallbackBean {

	private static int instances = 0;

	private static int aliveInstances = 0;

	private Integer instanceNumber;

	public static int getAliveInstances() {
		return aliveInstances;
	}

	public CallbackBean() {
		instanceNumber = null;
	}

	// PostConstruct method is called after the creation of the bean instance by the container
	// It is a default-access, public, protected or private, non-abstract, non-generic method
	// It has no parameter and returns nothing
	@PostConstruct
	public void postConstruct() {
		instanceNumber = instances++;
		aliveInstances++;
	}

	// PreDestroy method is called before the destruction of the bean instance by the container
	// It is a default-access, public, protected or private, non-abstract, non-generic method
	// It has no parameter and returns nothing
	@PreDestroy
	public void preDestroy() {
		aliveInstances--;
	}

	public Integer getInstanceNumber() {
		return instanceNumber;
	}

}
