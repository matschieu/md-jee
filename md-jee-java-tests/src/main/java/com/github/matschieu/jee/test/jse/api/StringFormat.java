package com.github.matschieu.jee.test.jse.api;

public class StringFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String format = String.format("%%0%dd", 2);
		
		System.out.println(format);
		
		for (int i = 0; i < 4; i++) {
			System.out.println(String.format(format, i));
		}
		
		System.out.println(String.valueOf('p'));
	}

}
