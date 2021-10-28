package com.github.matschieu.jee.cdi.qualifier;

import javax.annotation.PostConstruct;

import com.github.matschieu.jee.cdi.ServiceCounter;

@RestService
public class RestWebService implements WebService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String getType() {
		return "Rest";
	}

}
