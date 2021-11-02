package com.github.matschieu.jee.cdi.named;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class FileServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(TextFileService.class, JavaFileService.class).activate().inject(this).build();

    @Inject
    private @Named("JavaFileService") FileService javaFileService;

    @Inject
    private @Named("TextFileService") FileService textFileService;

	@Test
	public void testWithContainer() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		FileService javaFileService = container.select(FileService.class, new org.jboss.weld.literal.NamedLiteral("JavaFileService")).get();
		FileService textFileService = container.select(FileService.class, new org.jboss.weld.literal.NamedLiteral("TextFileService")).get();

		Assert.assertEquals(".java", javaFileService.getFileExtension());
		Assert.assertEquals(".txt", textFileService.getFileExtension());

		container.shutdown();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals(".java", this.javaFileService.getFileExtension());
		Assert.assertEquals(".txt", this.textFileService.getFileExtension());
	}
}
