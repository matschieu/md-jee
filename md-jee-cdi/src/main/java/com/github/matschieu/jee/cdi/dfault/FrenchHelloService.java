package com.github.matschieu.jee.cdi.dfault;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import com.github.matschieu.jee.cdi.ServiceCounter;

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
