package com.github.matschieu.jee.test.jse.api;

import java.util.Arrays;


public class SplitTest {

	public static void main(String[] args) {
		String[] array = "aa;aa;;aa".split(";");

		System.out.println(array.length);

		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] == null);
			System.out.println(array[i].trim() == null);
		}

		System.out.println(Arrays.toString(array));
	}
}
