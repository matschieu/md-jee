package com.github.matschieu.jee.cdi.qualifier;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.github.matschieu.jee.cdi.WeldTest;

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

		Assert.assertEquals("Rest", restWebService.getType());
		Assert.assertEquals("Soap", soapWebService.getType());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Rest", this.restWebService.getType());
		Assert.assertEquals("Soap", this.soapWebService.getType());
	}
}
