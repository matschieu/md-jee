package com.github.matschieu.jee.cdi.named;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.jee.cdi.WeldTest;

import jakarta.inject.Inject;
import jakarta.inject.Named;

public class FileServiceTest extends WeldTest {

	@Inject
	private @Named("JavaFileService") FileService javaFileService;

	@Inject
	private @Named("TextFileService") FileService textFileService;

	@Test
	public void testWithContainer() {
		this.initContainer();

		final FileService javaFileService = this.getContainer().select(FileService.class, new org.jboss.weld.literal.NamedLiteral("JavaFileService")).get();
		final FileService textFileService = this.getContainer().select(FileService.class, new org.jboss.weld.literal.NamedLiteral("TextFileService")).get();

		Assertions.assertEquals(".java", javaFileService.getFileExtension());
		Assertions.assertEquals(".txt", textFileService.getFileExtension());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assertions.assertEquals(".java", this.javaFileService.getFileExtension());
		Assertions.assertEquals(".txt", this.textFileService.getFileExtension());
	}
}
