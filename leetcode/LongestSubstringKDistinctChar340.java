package com.personal.dsa.leetcode;

import java.util.HashMap;

public class LongestSubstringKDistinctChar340 {

//}
//class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0) {
			return 0;
		}
		int p = 0;
		int q = 0;
		int max = 0;
		HashMap<Character, Integer> freq = new HashMap<>();
		int n = s.length();

		while (q < n) {
			if (p == q) {
				freq.put(s.charAt(q), 1);
				q++;
			} else {
				if (!freq.containsKey(s.charAt(q)) && freq.size() == k) {
					max = Math.max(max, q - p);
					freq.put(s.charAt(q), 1);
					q++;
					while (p < q && freq.size() > k) {
						if (freq.get(s.charAt(p)) == 1) {
							freq.remove(s.charAt(p));
						} else {
							freq.put(s.charAt(p), freq.get(s.charAt(p)) - 1);
						}
						p++;
					}
				} else {
					freq.put(s.charAt(q), freq.getOrDefault(s.charAt(q), 0) + 1);
					q++;
				}
			}
		}

		return Math.max(max, q - p);
	}
}