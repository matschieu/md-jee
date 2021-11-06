package com.github.matschieu.jee.interceptor.validation;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ResourceServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(ResourceService.class, ResourceServiceImpl.class).activate().inject(this).build();

    @Inject
    private ResourceService resourceService;

	@Test
	public void testMyServiceCreateResource1() {
		try {
			resourceService.createResource(null, "", "");
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		try {
			resourceService.createResource("", null, "");
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg1 is null", e.getMessage());
		}

		resourceService.createResource("", "", null);
	}

	@Test
	public void testMyServiceCreateResource2() {
		try {
			resourceService.createResource(new Resource(null, "", ""));
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("name is null", e.getMessage());
		}

		try {
			resourceService.createResource(new Resource("", null, ""));
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("type is null", e.getMessage());
		}

		resourceService.createResource(new Resource("", "", null));
	}

	@Test
	public void testMyServiceGetResource() {
		Resource resource;

		try {
			resource = resourceService.getResource(null);
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		resource = resourceService.getResource("name");

		Assert.assertNotNull(resource);
		Assert.assertEquals("name", resource.getName());
		Assert.assertEquals("type", resource.getType());
		Assert.assertEquals("description", resource.getDescription());
	}

	@Test
	public void testMyServiceDeleteResource() {
		try {
			resourceService.deleteResource(null);
			fail();
		} catch (Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		resourceService.getResource("name");
	}

}
