package com.github.matschieu.jee.test.jse.api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ListTest {

	public static void test1() {
		List<String> l = new ArrayList<String>();

		String str = "1";
		l.add(str);

		str = "2";
		l.add(str);

		str = "3";
		l.add(str);

		System.out.println(Arrays.toString(l.toArray()));
	}

	public static void test2() {
		List<String> list = new ArrayList<String>();

		list.add("toto");
		list.add(null);
		list.add("titi");

		System.out.println(Arrays.toString(list.toArray()));
	}

	public static void main(String[] args) {
		test2();
	}
}
