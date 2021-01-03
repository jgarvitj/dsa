package com.personal.dsa.leetcode;

public class _338_CountingBits {

//}
//class Solution {
	public int[] countBits(int num) {
		int[] arr = new int[num + 1];
		arr[0] = 0;
		long it1 = 1;
		int it2 = 1;
		int k = 1;
		while (it2 <= num) {
			if (it1 == it2) {
				arr[it2] = 1;
				it1 = it1 * 2;
				k = 1;
			} else {
				arr[it2] = arr[k] + 1;
				k++;
			}
			it2++;
		}
		return arr;
	}
}