package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Titi {
	void test() {
		throw new IllegalArgumentException("this is a test");
	}
}

class Toto {
	static void test() throws ArrayIndexOutOfBoundsException {
		new Titi().test();
	}
}

class ExceptionTest {

	@Test
	void testException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Toto.test());
	}

}
