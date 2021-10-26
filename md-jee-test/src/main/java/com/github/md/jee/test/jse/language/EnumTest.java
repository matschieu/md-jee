package com.github.md.jee.test.jse.language;


public class EnumTest {

	private enum MyEnum { titi, tutu, toto }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testCompareTo();
	}

	public static void testEquals() {
		System.out.println(MyEnum.titi.equals(MyEnum.titi));
		System.out.println(MyEnum.titi.equals(MyEnum.tutu));
		System.out.println(MyEnum.titi.equals(null));
		System.out.println(MyEnum.titi.equals(""));
	}

	public static void testValueOf() {
		//Toto.valueOf("tata");
		MyEnum.valueOf("");
		MyEnum.valueOf(null);
	}

	public static void testCompareTo() {
		System.out.println(MyEnum.tutu.compareTo(MyEnum.titi));
		System.out.println(MyEnum.tutu.compareTo(MyEnum.tutu));
		System.out.println(MyEnum.tutu.compareTo(MyEnum.toto));
	}

}
