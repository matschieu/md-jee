package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


interface Itf {
	String getName();
	void toto();
}

abstract class ClassA implements Itf {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public abstract void toto();
}


class ClassB extends ClassA {

	@Override
	public void toto() { }
}

class InheritenceTest {

	@Test
	void testInheritance() {
		Assertions.assertEquals("ClassB", (new ClassB()).getName());
	}

}