package com.github.md.jee.test.jse.language;


public class LabelTest {

	public static void main(String[] args) {
		label1: {
			System.out.println("label1");
		}
		label2: {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					System.out.println("label2 " + i + " " + j);
					if (j == 5) {
						break label2;
					}
				}
			}
		}
		label3: {
			System.out.println("label3");
		}
	}
}
