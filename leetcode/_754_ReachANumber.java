package com.personal.dsa.leetcode;

public class _754_ReachANumber {

	/*
	 * Implementation
	 * think of possible cases before solving
	 */
//}
//class Solution {
	public int reachNumber(int target) {
		target = Math.abs(target);
		if (target < 2) {
			return target;
		}
		int k = 0;
		int i = 1;
		while (k < target) {
			k = k + i;
			i++;
		}
		i--;
		if (k == target) {
			return i;
		}
		if ((k - target) % 2 == 0) {
			return i;
		}
		if ((k + i + 1 - target) % 2 == 0) {
			return i + 1;
		}
		return i + 2;

	}
}