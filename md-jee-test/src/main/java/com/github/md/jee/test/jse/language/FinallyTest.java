package com.github.md.jee.test.jse.language;


public class FinallyTest {

	public static void main(String[] args) throws Exception {
		System.out.println(getNumber());

		try {
			throw new Exception();
		} catch(Exception e) {
			throw new Exception(e);
		} finally {
			System.out.println("toto1");
		}
	}

	public static int getNumber() throws Exception {
		try {
			doNothing();
			return 1;
		} catch(Exception e) {
			throw new Exception(e);
		} finally {
			System.out.println("toto2");
		}
	}

	public static void doNothing() throws Exception {
		return;
	}
}
