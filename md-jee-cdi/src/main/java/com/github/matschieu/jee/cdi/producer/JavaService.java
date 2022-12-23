package com.github.matschieu.jee.cdi.producer;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Vetoed;

@Vetoed
public class JavaService implements LanguageService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String getName() {
		return "Java";
	}

}
