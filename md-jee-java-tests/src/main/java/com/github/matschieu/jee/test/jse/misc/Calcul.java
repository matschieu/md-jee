package com.github.matschieu.jee.test.jse.misc;

public class Calcul {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 7;
		int b = 3;
		
		int c = a / b;
		
		int d = a % b != 0 ? 1 : 0;
		
		int[] values = new int[a];
		for(int i = 0; i < a; i++) values[i] = i;
		
		int[][] array = new int[c + d][];
		int cpt = 0;
		
		for(int i = 0; i < array.length; i++) {
			int s = i == 0 ? a % b : b;
			array[i] = new int[s];
			
			for(int j = 0; j < array[i].length; j++)
				array[i][j] = values[cpt++];
			
			System.out.println("array[" + i + "]=" + s);
		}
		
		System.out.println();
		  
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
