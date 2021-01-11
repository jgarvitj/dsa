package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

//}
//
//class Solution {
	public List<List<Integer>> threeSum(int[] nums) {

		/*
		 * O(n^2)
		 * a+b+c = 0 => a + b = -c 
		 * => Sort array -> O(nlogn) time 
		 * => 2Sum(nums, -c) -> O(n) called n times(for each c) =>O(n^2)
		 */
		List<List<Integer>> triplets = new ArrayList<>();
		if (nums.length < 3) {
			return triplets;
		}
		Arrays.sort(nums);

		int a;
		int b;
		int c = nums.length - 1;

		while (c > 1) {
			while (c > 1 && c < nums.length - 1 && nums[c] == nums[c + 1]) {
				c--;
			}
			b = c - 1;
			a = 0;
			while (a < b) {
				if (nums[a] + nums[b] + nums[c] == 0) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[a]);
					triplet.add(nums[b]);
					triplet.add(nums[c]);
					triplets.add(triplet);
					b--;
					a++;
					while (a < b && nums[b] == nums[b + 1]) {
						b--;
					}
					while (a < b && nums[a] == nums[a - 1]) {
						a++;
					}
				} else if (nums[a] + nums[b] > -1 * nums[c]) {
					b--;
					while (a < b && nums[b] == nums[b + 1]) {
						b--;
					}
				} else {
					a++;
					while (a < b && nums[a] == nums[a - 1]) {
						a++;
					}
				}
			}
			c--;
		}
		return triplets;
	}
}