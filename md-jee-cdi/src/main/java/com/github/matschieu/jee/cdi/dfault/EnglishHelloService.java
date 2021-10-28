package com.github.matschieu.jee.cdi.dfault;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Alternative;

import com.github.matschieu.jee.cdi.ServiceCounter;

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
