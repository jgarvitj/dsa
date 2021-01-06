package com.personal.dsa.leetcode;

public class _829_ConsecutiveNumbersSum {

//}
//class Solution {
	public int consecutiveNumbersSum(int N) {
		if (N <= 0) {
			return 0;
		}

		int ans = 0;
		int x;

		for (int i = 1; (i * (i + 1)) / 2 <= N; i++) {
			x = (i * (i + 1)) / 2;
			if ((N - x) % i == 0) {
				ans++;
			}
		}

		return ans;
	}
}