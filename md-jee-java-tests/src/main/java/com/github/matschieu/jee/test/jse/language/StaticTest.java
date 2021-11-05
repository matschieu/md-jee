package com.github.matschieu.jee.test.jse.language;

class As {
	static void astatic() {
		System.out.println("caller is " + Thread.currentThread().getStackTrace()[2]);
	}
}

class Bs extends As {
	static void astatic() {
		As.astatic();
	}
}

public class StaticTest {
	public static void main(String[] args) {
		Bs.astatic();
	}
}
