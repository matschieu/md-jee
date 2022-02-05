package com.github.matschieu.java.test.language;

import java.util.Map.Entry;

import org.junit.Test;


public class SystemPropertiesTest {

	@Test
	public void testSystemProperties() {
		for(final Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
