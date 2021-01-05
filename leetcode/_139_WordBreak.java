package com.personal.dsa.leetcode;

import java.util.HashSet;
import java.util.List;

public class _139_WordBreak {
	/*
	 * dp
	 * from start to end check if word can be broken at cur index
	 * catdogand
	 * ->cat + dogand
	 */
//}
//class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {

		int n = s.length();
		if (n == 0) {
			return true;
		}

		HashSet<String> hs = new HashSet<>();
		wordDict.forEach((str) -> hs.add(str));

		boolean dp[] = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && hs.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}