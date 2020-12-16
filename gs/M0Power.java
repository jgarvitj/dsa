package com.dsa.gs;

import java.util.ArrayList;

public class M0Power {

//}

	/**
	 * Implement power(base,exp) correctly. Assume exp is an integer.
	 *
	 */

//public class Solution {

	/*
	 * Given base and integer exponent, compute value of base raised to the power of
	 * exponent. Can you implement a solution faster than O(exp)?
	 */
	public static double power(double base, int exp) {
		// your code
		ArrayList<Integer> bitExp = new ArrayList<>();
		while (exp > 0) {
			if (exp % 2 != 0) {
				bitExp.add(1);
			} else {
				bitExp.add(0);
			}
			exp = exp / 2;
		}
		double ans = 1;
		double basePower = base;
		for (int x : bitExp) {
			if (x == 1) {
				ans = ans * basePower;
			}
			basePower = basePower * basePower;
		}
		return ans;
	}

	/* returns true if all tests pass, false otherwise */
	public static boolean doTestsPass() {
		boolean doTestsPass = true;
		double result = power(4, 3);
		if(result == 64)
			return doTestsPass;
		return false;
	}

	public static void main(String[] args) {
		if (doTestsPass())
			System.out.println("All Tests Pass");
		else
			System.out.println("There are test failures");
	}
}