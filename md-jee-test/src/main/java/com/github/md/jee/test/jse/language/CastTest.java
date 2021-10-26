package com.github.md.jee.test.jse.language;


public class CastTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println((int)0.625);
		
		String str = null;
		Object obj = str;
		
		System.out.println((String)obj);
	}

}
