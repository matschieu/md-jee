package com.github.matschieu.jee.test.jse.api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class MyBean {
	
	private String value;

	
	public String getValue() {
		return value;
	}

	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}

public class CopyCollectionTest {
	
	public static void main(String[] args) {
		List<MyBean> l1 = new ArrayList<MyBean>();
	
		for (int i = 0; i < 20; i++) {
			MyBean mb = new MyBean();
			mb.setValue("" + i);
			l1.add(mb);			
		}
		
		List<MyBean> l2 = new ArrayList<MyBean>(l1);
		
		for (int i = 0; i < 15; i++) {
			l2.remove(l1.get(i));
		}
		
		System.out.println(Arrays.toString(l1.toArray()));
		System.out.println(Arrays.toString(l2.toArray()));
	}
	
}
