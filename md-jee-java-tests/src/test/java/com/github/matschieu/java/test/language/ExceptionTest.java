package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

	@Test
	public void testException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Toto.test());
	}

}
