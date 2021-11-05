package com.github.matschieu.jee.test.jse.language;


public class VarargTest {

	public static void toto(String arg1, String... args) {
		System.out.println(arg1);
		System.out.println(args);
		System.out.println(args == null);
		System.out.println(args.length);
	}
	
	public static void main(String[] args) {
		toto("toto");
		toto("toto", "titi");
	}
}
