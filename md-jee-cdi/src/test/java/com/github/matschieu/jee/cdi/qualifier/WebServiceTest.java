package com.github.matschieu.jee.cdi.qualifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.jee.cdi.WeldTest;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;

public class WebServiceTest extends WeldTest {

	@Inject
	@RestService
	private WebService restWebService;

	@Inject
	@SoapService
	private WebService soapWebService;

	@Test
	@SuppressWarnings("serial")
	public void testWithContainer() {
		this.initContainer();

		final WebService restWebService = this.getContainer().select(WebService.class, new AnnotationLiteral<RestService>() {}).get();
		final WebService soapWebService = this.getContainer().select(WebService.class, new AnnotationLiteral<SoapService>() {}).get();

		Assertions.assertEquals("Rest", restWebService.getType());
		Assertions.assertEquals("Soap", soapWebService.getType());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assertions.assertEquals("Rest", this.restWebService.getType());
		Assertions.assertEquals("Soap", this.soapWebService.getType());
	}
}
