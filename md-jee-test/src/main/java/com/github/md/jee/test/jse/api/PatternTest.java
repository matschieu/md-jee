package com.github.md.jee.test.jse.api;
import java.util.regex.Pattern;



public class PatternTest {

	public static void main(String[] args) {
		final Pattern emailPattern = Pattern.compile("[a-zA-Z]");
		
		System.out.println(emailPattern.matcher("toto").matches());
		System.out.println(emailPattern.matcher("1234").matches());
		System.out.println(emailPattern.matcher("").matches());
		System.out.println(emailPattern.matcher(null).matches());
	}
}
