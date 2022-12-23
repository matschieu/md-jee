package com.github.matschieu.jee.cdi.named;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

@Named("TextFileService")
public class TextFileService implements FileService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String getFileExtension() {
		return ".txt";
	}

}
