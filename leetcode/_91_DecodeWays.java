package com.personal.dsa.leetcode;

import java.util.HashMap;

public class _91_DecodeWays {

//}
//class Solution {

	private static int findNumDecodings(int index, String s, HashMap<Integer, Integer> hm) {
		if (index == s.length()) {
			return 1;
		}

		if (s.charAt(index) == '0') {
			return 0;
		}

		if (index == s.length() - 1) {
			return 1;
		}

		if (hm.containsKey(index)) {
			return hm.get(index);
		}

		int numD = findNumDecodings(index + 1, s, hm);
		if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			numD += findNumDecodings(index + 2, s, hm);
		}

		hm.put(index, numD);
		return numD;

	}

	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.equals("0")) {
			return 0;
		}
		if (s.length() < 2) {
			return s.length();
		}

		HashMap<Integer, Integer> hm = new HashMap<>();

		return findNumDecodings(0, s, hm);

	}
}