package com.github.md.jee.test.jse.language;
import java.io.Closeable;
import java.io.IOException;

class MyResource implements Closeable {
	
	public MyResource() throws IOException {
		System.out.println("My resource is now opened");
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("My resource is now closed");
	}
}

public class TryWithResourceTest {

	public static void main(String[] args) {
		try(MyResource myResource = new MyResource()) {
			System.out.println("the resource is exploited here");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
