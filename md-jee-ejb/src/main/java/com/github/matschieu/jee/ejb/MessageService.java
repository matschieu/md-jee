package com.github.matschieu.jee.ejb;

import javax.ejb.Singleton;

@Singleton
public class MessageService {

	public void displayMessage(String str) {
		System.out.println("MESSAGE: " + str);
	}

}
