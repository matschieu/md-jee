package com.github.md.jee.test.jse.api;


enum MyEnum {
	ITEM1, ITEM2, ITEM3;
}

public class EnumTest {



	public static void main(String[] args) {
		System.out.println(MyEnum.valueOf("ITEM1"));
		System.out.println(MyEnum.valueOf("ITEM"));
	}
}
