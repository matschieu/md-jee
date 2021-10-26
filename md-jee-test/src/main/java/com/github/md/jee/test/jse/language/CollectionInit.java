package com.github.md.jee.test.jse.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CollectionInit {

	private int a;

	String b;


	public void setA(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public static void main(String[] args) {

		CollectionInit ci = new CollectionInit() {{
			setA(3);
			b = "toto";
		}};


		@SuppressWarnings("serial")
		List<String> list = new ArrayList<String>() {{
			add("toto");
			add("titi");
			add("tata");
		}};

		System.out.println(Arrays.toString(list.toArray()));

		System.out.println(ci.getA());
		System.out.println(ci.b);
	}

}
