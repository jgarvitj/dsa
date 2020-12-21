package com.personal.dsa.leetcode;

/*
 * O(n) time
 * O(n) space
 * two arrays storing leftMax and rightMax
 */
public class TrappingRainWater42 {

//}
//class Solution {
	public int trap(int[] height) {
		int n = height.length;
		int[] left = new int[n];
		int[] right = new int[n];
		if (n == 0) {
			return 0;
		}
		left[0] = 0;
		right[n - 1] = 0;
		for (int i = 1; i < n - 1; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
			right[n - i - 1] = Math.max(right[n - i], height[n - i]);
		}

		int count = 0;
		for (int i = 1; i < n - 1; i++) {
			count += Math.max(Math.min(left[i], right[i]) - height[i], 0);
		}
		return count;
	}
}