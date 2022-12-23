package com.github.matschieu.jee.cdi.qualifier;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;

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
