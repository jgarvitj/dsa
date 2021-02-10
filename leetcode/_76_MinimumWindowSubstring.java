package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.personal.dsa.leetcode._362_DesignHitCounter.Pair;

public class _76_MinimumWindowSubstring {

	class Pair {
		int key;
		char value;

		public Pair(int key, char val) {
			this.key = key;
			this.value = val;
		}

		public int getKey() {
			return key;
		}

		public char getValue() {
			return value;
		}

	}

//}
//class Solution {
	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		int minDist = Integer.MAX_VALUE;
		int startIndex = -1;
		HashMap<Character, Integer> freq = new HashMap<>();
		List<Pair> filtered = new ArrayList<>();

		for (int i = 0; i < t.length(); i++) {
			freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
		}

		int required = freq.size();

		for (int i = 0; i < s.length(); i++) {
			if (freq.containsKey(s.charAt(i))) {
				filtered.add(new Pair(i, s.charAt(i)));
			}
		}

		int left = 0;
		int right = 0;
		int formed = 0;

		HashMap<Character, Integer> windowCounts = new HashMap<>();

		while (right < filtered.size()) {

			char c = filtered.get(right).getValue();
			int count = windowCounts.getOrDefault(c, 0);
			windowCounts.put(c, count + 1);

			if (windowCounts.get(c).intValue() == freq.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == required) {

				int end = filtered.get(right).getKey();
				int start = filtered.get(left).getKey();

				if (minDist > end - start + 1 || startIndex == -1) {
					minDist = end - start + 1;
					startIndex = start;
				}

				c = filtered.get(left).getValue();
				windowCounts.put(c, windowCounts.get(c) - 1);
				if (freq.get(c).intValue() > windowCounts.get(c).intValue()) {
					formed--;
				}
				left++;
			}
			right++;
		}

		if (startIndex == -1) {
			return "";
		}
		return s.substring(startIndex, startIndex + minDist);

	}
}