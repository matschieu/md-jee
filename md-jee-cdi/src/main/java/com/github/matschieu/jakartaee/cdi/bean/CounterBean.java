package com.github.matschieu.jakartaee.cdi.bean;

public class CounterBean {

	private static int instances = 0;

	private int instanceNumber;

	public CounterBean() {
		this.instanceNumber = instances++;
	}

	public int getInstanceNumber() {
		return instanceNumber;
	}

}
