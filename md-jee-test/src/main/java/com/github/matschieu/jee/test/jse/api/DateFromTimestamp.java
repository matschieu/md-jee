package com.github.matschieu.jee.test.jse.api;
import java.sql.Date;
import java.text.SimpleDateFormat;



public class DateFromTimestamp {

	public static void main(String[] args) {
		long[] timestamps = new long[] {
			1436273419981L,
			1436273425161L,
			1436273430683L,
			1436273431423L,
			1436273476102L,
			1435996800000L
		};

		for(long timestamp : timestamps) {
			System.out.println(SimpleDateFormat.getDateTimeInstance().format(new Date(timestamp)));
		}
	}
}
