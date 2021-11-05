package com.github.matschieu.jee.test.jse.misc;
import java.util.Scanner;



public class FizzBuzz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String val = null;
		
		while(val == null || !"q".equals(val)) {
			val = sc.nextLine();
			
			try {
				int nval = Integer.parseInt(val);
				
				if (nval % 15 == 0) {
					System.out.println("FizzBuzz");
				} else if (nval % 5 == 0) {
					System.out.println("Buzz");
				} else if (nval % 3 == 0) {
					System.out.println("Fizz");
				} else {
					System.out.println(nval);
				}
				
			} catch(NumberFormatException e) {
				
			}
		}
		
		sc.close();
	}
	
}
