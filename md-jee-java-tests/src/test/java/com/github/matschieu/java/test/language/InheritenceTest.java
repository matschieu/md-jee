package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;


interface Itf {
	String getName();
	public void toto();
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

public class InheritenceTest {

	@Test
	public void testInheritance() {
		Assert.assertEquals("ClassB", (new ClassB()).getName());
	}

}