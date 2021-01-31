package com.personal.dsa.leetcode;

public class _300_LongestIncreasingSubsequence {

//}
//class Solution {
	// dp + binary search
	// check leetcode solution(nlogn)
	public int lengthOfLIS(int[] nums) {

		int[] seq = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			seq[i] = Integer.MIN_VALUE;
		}

		int high = 1;
		int mid = 0;

		seq[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > seq[high - 1]) {
				seq[high] = nums[i];
				high++;
			} else {
				int h = high;
				int l = 0;
				while (h > l) {
					mid = (h + l) / 2;
					if (seq[mid] < nums[i]) {
						l = mid + 1;
						mid = (h + l) / 2;
					} else if (seq[mid] > nums[i]) {
						h = mid;
						mid = (h + l) / 2;
					} else {
						break;
					}
				}
				// mid = Arrays.binarySearch(seq, 0, high, nums[i])
				// if mid < 0
				// mid = -(mid + 1)
				if (seq[mid] > nums[i]) {
					seq[mid] = nums[i];
				}
			}
		}
		return high;
	}
}