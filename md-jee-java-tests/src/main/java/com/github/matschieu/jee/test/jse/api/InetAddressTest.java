package com.github.matschieu.jee.test.jse.api;
import java.net.InetAddress;
import java.net.UnknownHostException;



public class InetAddressTest {

	public static void main(String[] args) {
		try {
			System.out.println(InetAddress.getByName("yahoo.fr"));
			System.out.println(InetAddress.getByName("google.fr"));
			System.out.println(InetAddress.getByName("bidou.fr"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
