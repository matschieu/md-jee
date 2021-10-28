package com.github.matschieu.jee.cdi.producer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Vetoed;

import com.github.matschieu.jee.cdi.ServiceCounter;

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
