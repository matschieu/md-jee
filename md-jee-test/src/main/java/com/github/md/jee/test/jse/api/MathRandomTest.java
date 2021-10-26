package com.github.md.jee.test.jse.api;
import java.util.Random;



public class MathRandomTest {

	public static void main(String[] args) {
		System.out.println("Math.random");
		for(int i = 0; i < 20; i++) {
			System.out.println(String.format("%03d", (int)(Math.random() * 100.0)));
		}
		System.out.println("Random.nextInt");
		for(int i = 0; i < 20; i++) {
			System.out.println(String.format("%03d", new Random().nextInt(100)));
		}
	}
}
