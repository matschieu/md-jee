package com.github.matschieu.jee.cdi.named;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import com.github.matschieu.jee.cdi.WeldTest;

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

		Assert.assertEquals(".java", javaFileService.getFileExtension());
		Assert.assertEquals(".txt", textFileService.getFileExtension());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals(".java", this.javaFileService.getFileExtension());
		Assert.assertEquals(".txt", this.textFileService.getFileExtension());
	}
}
