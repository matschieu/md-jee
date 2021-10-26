package com.github.md.jee.test.jse.api;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;



@SuppressWarnings("deprecation")
public class InputStreamTest {

	
	public static void main(String[] args) {
		InputStream is = new StringBufferInputStream("toto");
		
		try {
			int i;
			for(int j = 0; j < 2; j++) {
				while ((i = is.read()) != -1) {
					System.out.println(i);
				}
				System.out.println("=======");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
