package com.github.md.jee.test.jse.language;


public class AutoboxingTest {

	public static void main(String[] args) {
		Integer a = Integer.valueOf(100);
		Integer b = Integer.valueOf(100);
		Integer c = Integer.valueOf(1000);
		Integer d = Integer.valueOf(1000);

		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(c == d);
		System.out.println(c != d);

		System.out.println();

		for(int i = 250; i < 260; i++) {
			Integer a_ = Integer.valueOf(i);
			Integer b_ = Integer.valueOf(i);

			System.out.println(a_ == b_);
			System.out.println(a_ != b_);
			System.out.println();
		}
	}

}
