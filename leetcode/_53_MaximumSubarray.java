package com.personal.dsa.leetcode;

public class _53_MaximumSubarray {

//}
//class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxSub = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > 0) {
				nums[i] += nums[i - 1];
			}
			maxSub = Math.max(nums[i], maxSub);
		}
		return maxSub;
	}
}