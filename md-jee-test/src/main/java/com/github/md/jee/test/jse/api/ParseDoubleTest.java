package com.github.md.jee.test.jse.api;


public class ParseDoubleTest {

	public static void main(String[] args) {
		System.out.println(Double.parseDouble("-12"));
		System.out.println(Double.parseDouble("-12.0"));
		
		System.out.println(Double.parseDouble("")); // exception
		System.out.println(Double.parseDouble(null)); // exception
	}
}
