package com.personal.dsa.leetcode;

public class _880_DecodeStringAtIndex {

//}
//	class Solution {
	public String decodeAtIndex(String S, int K) {

		long size = 0;
		int j = S.length() - 1;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if (c >= 'a' && c <= 'z') {
				if (size + 1 == K) {
					return c.toString();
				} else {
					size++;
				}
			} else {
				size = size * (c - '0');
				if (size > K) {
					j = i;
					break;
				}
			}
		}

		for (int i = j; i >= 0; i--) {
			K %= size;
			if (K == 0 && S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
				return "" + S.charAt(i);
			}
			if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
				size = size / (S.charAt(i) - '0');
			} else {
				size--;
			}
		}
		return null;
	}
}