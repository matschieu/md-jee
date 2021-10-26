package com.github.md.jee.test.jse.language;


public class AssertTest {

	public static String ko() {
		return "ko";
	}
	
	public static void main(String[] args) {
		int i = 3;
		
		System.out.println("assert 1");
		assert 3 > i : ko();
		
		System.out.println("assert 2");
		assert 4 > i : "ko";
		
		System.out.println("fin");
	}
}
