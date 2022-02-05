package com.github.matschieu.java.test.api;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Assert;
import org.junit.Test;

public class InetAddressTest {

	@Test
	public void testGetByNameOK() throws UnknownHostException {
		final InetAddress addr = InetAddress.getByName("google.fr");
		Assert.assertNotNull(addr.getAddress());
		Assert.assertEquals(4, addr.getAddress().length);
	}

	@Test(expected = UnknownHostException.class)
	public void testGetByNameKO() throws UnknownHostException {
		InetAddress.getByName("sfhbsqhdfbhs.fr");
	}


}
