package com.github.matschieu.jee.test.jse.api;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class GregorianCalendarTest {

	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar(2016, 9, 20, 18, 00);

		System.out.println((new SimpleDateFormat("yyyy.MM.dd HH:mm:ss")).format(gc.getTime()) + ": " + gc.getTimeInMillis());
		System.out.println(String.format("0x%x", gc.getTimeInMillis()).toUpperCase());
	}
}
