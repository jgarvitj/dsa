package com.personal.dsa.leetcode;

public class _5_LongestPalindromicSubstring {

//}
//class Solution {

	/*
	 * O(n^2) check of even and odd len pali taking each char as centre
	 */
	public static int checkPali(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int lo = checkPali(s, i, i);
			int le = checkPali(s, i, i + 1);
			int l = Math.max(le, lo);
			if (l > end - start) {
				start = i - (l - 1) / 2;
				end = i + l / 2;
			}
		}
		return s.substring(start, end + 1);

	}
}