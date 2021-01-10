package com.personal.dsa.leetcode;

public class _647_PalindromicSubstrings {
	/*
	 * dp
	 * iterate around center
	 * better approaches available in leetcode solution
	 */
//}
//class Solution {
	public int countSubstrings(String s) {

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += oddCentred(i, s);
			if (i != s.length() - 1) {
				count += evenCentred(i, i + 1, s);
			}
		}
		return count;
	}

	private static int oddCentred(int mid, String s) {
		int count = 1;
		int left = mid - 1;
		int right = mid + 1;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}

	private static int evenCentred(int left, int right, String s) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
}
