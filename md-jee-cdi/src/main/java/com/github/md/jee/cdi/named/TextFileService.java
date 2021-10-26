package com.github.md.jee.cdi.named;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import com.github.md.jee.cdi.ServiceCounter;

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
