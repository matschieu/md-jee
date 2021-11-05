package com.github.matschieu.jee.test.jse.api;


public class ParseBooleanTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Boolean.parseBoolean("TRUE"));
		System.out.println(Boolean.parseBoolean("true"));
		System.out.println(Boolean.parseBoolean("FALSE"));
		System.out.println(Boolean.parseBoolean("false"));
		System.out.println(Boolean.parseBoolean(""));
		System.out.println(Boolean.parseBoolean("sdqsdqs"));
		System.out.println(Boolean.parseBoolean(null));
		System.out.println(Boolean.parseBoolean("true,false"));
	}

}
