package com.github.matschieu.jee.test.jse.api;


public class StackTraceTest {

	public static void main(String[] args) {
		TotoException.throwException();;
	}
}


class TotoException {
	public static void throwException() {
		NullPointerException npe = new NullPointerException("BIG FAIL!");
		npe.setStackTrace(new StackTraceElement[] {
				new StackTraceElement("XavierRegnard", "delivery", "XavierRegnard.class", 1317),				
		});
		
		RuntimeException exc = new RuntimeException(npe);
		
		/*
		StackTraceElement[] ste = new StackTraceElement[exc.getStackTrace().length + 1];
		int i = 0;
		for(StackTraceElement e : exc.getStackTrace()) {
			ste[i++] = e;
		}
		ste[i++] = new StackTraceElement("XavierRegnard", "delivery", "XavierRegnard.class", 1317);
		exc.setStackTrace(ste);
		*/
		throw exc;
	}
}
