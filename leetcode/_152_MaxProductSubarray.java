package com.personal.dsa.leetcode;

public class _152_MaxProductSubarray {

	/*
	 * only concerned with current, max and min till previous
	 * maintain overall max separately
	 */
	
//}
//class Solution {
	public int maxProduct(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		int ans = nums[0];
		int maxSoFar = nums[0];
		int minSoFar = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int tmp = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
			maxSoFar = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));

			minSoFar = tmp;

			ans = Math.max(maxSoFar, ans);
		}
		return ans;

	}
}