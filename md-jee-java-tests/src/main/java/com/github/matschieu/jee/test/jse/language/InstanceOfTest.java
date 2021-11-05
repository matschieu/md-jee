package com.github.matschieu.jee.test.jse.language;

class A {
	
}

class B extends MyClass {
	
}

public class InstanceOfTest {

	public static void main(String[] args) {
		MyClass a = new MyClass();
		MyClass b = new B();
		MyClass c = null;
		
		System.out.println(a instanceof B);
		System.out.println(b instanceof B);
		System.out.println(c instanceof B);
	}
}
