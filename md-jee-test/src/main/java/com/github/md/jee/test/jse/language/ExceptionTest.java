package com.github.md.jee.test.jse.language;


class Titi {
	
	public void test() {
		throw new IllegalArgumentException("this is a test");
	}
}

class Toto {
	
	public static void test() throws ArrayIndexOutOfBoundsException {
		new Titi().test();
	}
	
}

class ExceptionTest {

	public static void main(String[] args) {
		try {
			Toto.test();
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
		
}
