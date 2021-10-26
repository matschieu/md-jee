package com.github.md.jee.cdi.qualifier;

import javax.annotation.PostConstruct;

import com.github.md.jee.cdi.ServiceCounter;

@SoapService
public class SoapWebService implements WebService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String getType() {
		return "Soap";
	}

}
