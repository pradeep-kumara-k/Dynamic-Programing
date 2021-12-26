package com.pk.dynamic.memorization;

import java.util.HashMap;
import java.util.Map;

public class FibbonaciGenerator {

	/**
	 * Used to memorize the results once calculated and reuse later when required
	 */
	static Map<Integer, Long> memory = new HashMap<Integer, Long>();

	public static long fibRecursive(int n) {
		if (n <= 2)
			return 1;
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}

	public static long fibDynamic(int n) {
		if (n <= 2)
			return 1;
		if (memory.containsKey(n))
			return memory.get(n);

		memory.put(n, fibDynamic(n - 1) + fibDynamic(n - 2));

		return memory.get(n);
	}

	public static void main(String[] args) {

		System.out.println("----------Calling fibDynamic---------");
		System.out.println(fibDynamic(7));
		System.out.println(fibDynamic(8));
		System.out.println(fibDynamic(9));
		System.out.println(fibDynamic(50));
		System.out.println("-------------------------------------");

		System.out.println("---------Calling fibRecursive--------");
		System.out.println(fibRecursive(7));
		System.out.println(fibRecursive(8));
		System.out.println(fibRecursive(9));
		System.out.println(fibRecursive(50));
		System.out.println("-------------------------------------");
	}

}
