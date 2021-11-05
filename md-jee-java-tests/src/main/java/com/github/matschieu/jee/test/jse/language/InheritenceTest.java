package com.github.matschieu.jee.test.jse.language;


public class InheritenceTest {

	
	public static void main(String[] args) {
		System.out.println(new ClassB().getName());
	}
	
}

interface Itf {
	
	String getName();
	public void toto();
}

abstract class ClassA implements Itf {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	} 
	
	public abstract void toto();
}


class ClassB extends ClassA {
	
	public void toto() { }
}