package com.github.matschieu.jee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class StartService {

	@PostConstruct
	public void init() {
		System.out.println("Starting");
	}

}
