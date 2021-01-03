package com.personal.dsa.leetcode;

/*
 * Need to store only 2 elements
 * O(n)
 */

public class _334_IncreasingTripletSequence {

	/*
	 * maintain smallest and snd smallest
	 * brute force
	 */
//}
//class Solution {
	public boolean increasingTriplet(int[] nums) {
		int[] arr = new int[2];
		arr[0] = nums[0];
		arr[1] = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (arr[1] < nums[i]) {
				return true;
			}
			if (arr[0] < nums[i] && arr[1] > nums[i]) {
				arr[1] = nums[i];
			} else if (arr[0] > nums[i]) {
				arr[0] = nums[i];
			}
		}
		return false;

	}
}