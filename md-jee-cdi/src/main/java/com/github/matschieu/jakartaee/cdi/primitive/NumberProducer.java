package com.github.matschieu.jakartaee.cdi.primitive;

import jakarta.enterprise.inject.Produces;

public class NumberProducer {

	private static final java.util.Random RANDOM = new java.util.Random();

	// A producer can be a field
	// It must be a default-access, public, protected or private, field of a managed bean class.
	// A producer field may be either static or non-static.
	@Produces
	@Null
	private final Integer nullInteger = null;

	// A producer method must be a default-access, public, protected or private, non-abstract method of a managed bean class
	// A producer method may be either static or non-static
	// It can return null but it must have scope @Dependent else an IllegalProductException is thrown by the container.
	@Produces
	@Random
	public Integer getRandomInteger() {
		return Integer.valueOf(RANDOM.nextInt());
	}

	// A producer can also return a primitive type
	@Produces
	@Random
	public static double getRandomInt() {
		return 1.0 * RANDOM.nextInt();
	}

}
