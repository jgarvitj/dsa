package com.personal.dsa.leetcode;

import java.util.HashMap;
/*
 * a+b+c+d => a+b = -(c+d)
 * O(n^2)
 */
public class FourSumII {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> sum = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				sum.put(A[i] + B[j], sum.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}
		int count = 0;

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int s = C[i] + D[j];
				if (sum.containsKey(-1 * s)) {
					count = count + sum.get(-1 * s);
				}
			}
		}
		return count;

	}
}