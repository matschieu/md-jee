package com.github.md.jee.test.jse.language;

import java.util.Map.Entry;


public class SystemProperties {

	public static void main(String[] args) {
		for(Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
