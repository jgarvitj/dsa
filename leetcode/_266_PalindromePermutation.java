package com.personal.dsa.leetcode;

public class _266_PalindromePermutation {

	/*
	 * Check if any permutation is palindrome if len == odd then noofodd == 1 else
	 * noofodd == 0
	 */
//}
//class Solution {
	public boolean canPermutePalindrome(String s) {
		int noOfOdd = 0;
		int arr[] = new int[200];
		int n = s.length();

		for (int i = 0; i < n; i++) {
			arr[s.charAt(i)]++;
			if (arr[s.charAt(i)] % 2 == 0) {
				noOfOdd--;
			} else {
				noOfOdd++;
			}
		}

		if (n % 2 == 0) {
			return noOfOdd == 0;
		}
		return noOfOdd == 1;

	}
}