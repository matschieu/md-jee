package com.github.md.jee.test.jse.language;


public class ObjectReferenceTest {

	
	private static void update(MyClass a) {
		a = new MyClass();
		System.out.println(a + ": " + a.toto);		
	}
	
	public static void main(String[] args) {
		MyClass a = new MyClass();
		a.toto = "TOTO";
		
		System.out.println(a + ": " + a.toto);		
		update(a);
		System.out.println(a + ": " + a.toto);		
	}
	
}


class MyClass {
	
	public String toto;
	
}