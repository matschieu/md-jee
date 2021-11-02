package com.github.matschieu.jee.ejb;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EjbDeploymentTest {

	@EJB
	private StartService startService;

	@EJB
	private ReverseService reverseService;

	@Deployment
	public static JavaArchive createDeployment() {
	    JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
	            .addClasses(ReverseService.class, ReverseServiceImpl.class, MessageService.class, StartService.class)
	            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	        System.out.println(jar.toString(true));
	        return jar;
	}

	@Test
	public void testReverseString() {
		Assert.assertNotNull(this.reverseService);
		Assert.assertEquals("gnirtSyM", this.reverseService.reverseString("MyString"));

	}

	@Test
	public void testStartService() {
		Assert.assertNotNull(this.startService);
	}

}
