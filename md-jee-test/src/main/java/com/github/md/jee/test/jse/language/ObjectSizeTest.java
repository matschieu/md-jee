package com.github.md.jee.test.jse.language;


public class ObjectSizeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().freeMemory());

		Runtime  r = Runtime.getRuntime();

		long mem1 = r.maxMemory() - r.freeMemory();
		
		String str = new String("toto toto toto toto toto toto toto toto totototo toto totototo toto toto toto toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto totototo toto toto");
		System.out.println(str);
		
		long mem2 = r.maxMemory() - r.freeMemory();
		
		System.out.println(mem2 - mem1);
		
	}

}
