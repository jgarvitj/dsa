package com.personal.dsa.leetcode;

public class _238_ProductWithoutSelf {

//}
//class Solution {
	public int[] productExceptSelf(int[] nums) {

		int[] prod = new int[nums.length];
		// int rightProd = Arrays.stream(nums).reduce(1, (a,b) -> a*b);
		if (nums.length == 0) {
			return prod;
		}
		prod[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prod[i] = prod[i - 1] * nums[i - 1];
		}

		int rightProd = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			prod[i] = prod[i] * rightProd;
			rightProd = rightProd * nums[i];
		}

		return prod;

	}
}