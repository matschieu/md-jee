package com.github.matschieu.jee.cdi;

import java.util.HashMap;
import java.util.Map;

public final class ServiceCounter {

	private static Map<Class<?>, Integer> counters = new HashMap<Class<?>, Integer>();

	private ServiceCounter() { }

	public static final void register(Class<?> clazz) {
		int count = 1;

		if (!counters.containsKey(clazz)) {
			counters.put(clazz, count);
		} else {
			count = counters.get(clazz) + 1;
			counters.put(clazz, count);
		}

		System.out.println(clazz.getSimpleName() + "#" + count);
	}

}
