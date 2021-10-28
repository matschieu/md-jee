package com.github.matschieu.jee.cdi.qualifier;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.github.matschieu.jee.cdi.qualifier.RestService;
import com.github.matschieu.jee.cdi.qualifier.RestWebService;
import com.github.matschieu.jee.cdi.qualifier.SoapService;
import com.github.matschieu.jee.cdi.qualifier.SoapWebService;
import com.github.matschieu.jee.cdi.qualifier.WebService;

public class WebServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(RestWebService.class, SoapWebService.class).activate().inject(this).build();

    @Inject
    @RestService
    private WebService restWebService;

    @Inject
    @SoapService
    private WebService soapWebService;

	@Test
	@SuppressWarnings("serial")
	public void testWithContainer() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		WebService restWebService = container.select(WebService.class, new AnnotationLiteral<RestService>() {}).get();
		WebService soapWebService = container.select(WebService.class, new AnnotationLiteral<SoapService>() {}).get();

		Assert.assertEquals("Rest", restWebService.getType());
		Assert.assertEquals("Soap", soapWebService.getType());

		container.shutdown();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Rest", restWebService.getType());
		Assert.assertEquals("Soap", soapWebService.getType());
	}
}
