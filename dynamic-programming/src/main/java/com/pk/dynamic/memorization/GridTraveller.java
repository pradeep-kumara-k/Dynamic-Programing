package com.pk.dynamic.memorization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

	static Map<String, Long> memory = new HashMap<>();

	public static long solveRecursive(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		return solveRecursive(m - 1, n) + solveRecursive(m, n - 1);
	}

	public static long solveDynamic(int m, int n) {

		if (m > n) {
			int t = m;
			m = n;
			n = t;
		}

		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 0)
			return 0;

		if (memory.containsKey(m + "-" + n))
			return memory.get(m + "-" + n);

		memory.put(m + "-" + n, solveDynamic(m - 1, n) + solveDynamic(m, n - 1));
		return memory.get(m + "-" + n);
	}

	public static void main(String[] args) {
		System.out.println("--------Dynamic----------");
		System.out.println(solveDynamic(2, 3));
		System.out.println(solveDynamic(3, 3));
		System.out.println(solveDynamic(3, 4));
		System.out.println(solveDynamic(15, 15));
		System.out.println(solveDynamic(18, 18));
		System.out.println("--------Dynamic----------");

		System.out.println("-------Recursive---------");
		System.out.println(solveRecursive(2, 3));
		System.out.println(solveRecursive(3, 3));
		System.out.println(solveRecursive(3, 4));
		System.out.println(solveRecursive(15, 15));
		System.out.println(solveRecursive(18, 18));
		System.out.println("-------Recursive---------");
	}
}
