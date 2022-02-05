package com.github.matschieu.java.test.language;

import org.junit.Test;

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

public class ExceptionTest {

	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		Toto.test();
	}

}
