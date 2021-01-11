package com.personal.dsa.leetcode;

public class _279_PerfectSquares {

	/*
	 * dp
	 * find min no of perfect sq required st sum is n
	 */
//}
//
//class Solution {

	public void findNumSq(int n, int[] dp) {
		if (n == 0) {
			return;
		}

		int x = (int) Math.sqrt(n);
		if (x * x == n) {
			dp[n] = 1;
			return;
		}
		int minSteps = n;
		for (int i = x; i > 0; i--) {
			if (dp[n - i * i] == 0) {
				findNumSq(n - i * i, dp);
			}
			minSteps = Math.min(minSteps, 1 + dp[n - i * i]);
		}
		dp[n] = minSteps;
		return;
	}

	public int numSquares(int n) {

		int dp[] = new int[n + 1];
		dp[0] = 0;
		findNumSq(n, dp);
		return dp[n];

	}
}