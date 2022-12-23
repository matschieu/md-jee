package com.github.matschieu.jee.cdi.dfault;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@Default
@ApplicationScoped
public class FrenchHelloService implements HelloService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String sayHello() {
		return "Bonjour";
	}

}
