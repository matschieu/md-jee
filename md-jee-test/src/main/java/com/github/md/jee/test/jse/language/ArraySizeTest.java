package com.github.md.jee.test.jse.language;
import java.util.Arrays;



public class ArraySizeTest {

	public static void main(String[] args) {
		String[] array = new String[1];
		
		array[0] = "0";
		
		System.out.println(array.length + " => " + Arrays.toString(array));

		for(int i = 0; i < 10; i++) {
			String[] arrayTmp = new String[array.length + 1];
			
			for(int j = 0; j < array.length; j++) {
				arrayTmp[j] = array[j];
			}
			
			arrayTmp[arrayTmp.length - 1] = "" + (arrayTmp.length - 1); 
	
			array = arrayTmp;
			
			System.out.println(array.length + " => " + Arrays.toString(array));
		}
	}
	
}
