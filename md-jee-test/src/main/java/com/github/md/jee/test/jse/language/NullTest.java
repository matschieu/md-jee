package com.github.md.jee.test.jse.language;

public class NullTest {
	
	public void foo(NullTest o) {
		System.out.println(o == this);
		o = null;
		System.out.println(o == this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NullTest tn = new NullTest();
		tn.foo(tn);
		System.out.println(tn == null);
		
		System.out.println("toto".equals(null));
	}

}
