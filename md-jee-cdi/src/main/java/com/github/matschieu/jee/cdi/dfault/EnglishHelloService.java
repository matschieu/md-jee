package com.github.matschieu.jee.cdi.dfault;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Alternative;

@Alternative
public class EnglishHelloService implements HelloService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String sayHello() {
		return "Hello";
	}

}
