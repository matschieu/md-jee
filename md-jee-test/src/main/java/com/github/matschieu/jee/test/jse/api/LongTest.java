package com.github.matschieu.jee.test.jse.api;


public class LongTest {

	public static void main(String[] args) {
		System.out.println(Long.parseLong("12"));
		System.out.println(Long.parseLong("012"));
		System.out.println(Long.parseLong(null));
		System.out.println(Long.parseLong("abc"));
	}
}
