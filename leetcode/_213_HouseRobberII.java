package com.personal.dsa.leetcode;

public class _213_HouseRobberII {

//}
//class Solution {

	private int robAcyclic(int start, int end, int[] nums) {
		int n = end - start;
		if (n == 2) {
			return Math.max(nums[start], nums[end - 1]);
		}
		int maxTillLast = Math.max(nums[start], nums[start + 1]);
		int maxTillSndLast = nums[start];
		int tmp;
		for (int i = start + 2; i < end; i++) {
			tmp = maxTillLast;
			maxTillLast = Math.max(maxTillLast, maxTillSndLast + nums[i]);
			maxTillSndLast = Math.max(maxTillSndLast, tmp);
		}
		return maxTillLast;
	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[1], nums[0]);
		}
		return Math.max(robAcyclic(0, n - 1, nums), robAcyclic(1, n, nums));
	}
}