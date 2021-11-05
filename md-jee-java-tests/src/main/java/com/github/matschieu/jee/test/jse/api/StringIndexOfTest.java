package com.github.matschieu.jee.test.jse.api;


public class StringIndexOfTest {

	public static void main(String[] args) {
		String str = "my.value";
		
		System.out.println(str.substring(str.indexOf('.') + 1));
		
		str = "myvalue";

		System.out.println(str.substring(str.indexOf('.')));
	}
}
