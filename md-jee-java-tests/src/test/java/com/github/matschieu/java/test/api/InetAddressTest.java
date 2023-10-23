package com.github.matschieu.java.test.api;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InetAddressTest {

	@Test
	void testGetByNameOK() throws UnknownHostException {
		final InetAddress addr = InetAddress.getByName("google.fr");
		Assertions.assertNotNull(addr.getAddress());
		Assertions.assertEquals(4, addr.getAddress().length);
	}

	@Test
	void testGetByNameKO() throws UnknownHostException {
		Assertions.assertThrows(UnknownHostException.class, () -> InetAddress.getByName("sfhbsqhdfbhs.fr"));
	}


}
