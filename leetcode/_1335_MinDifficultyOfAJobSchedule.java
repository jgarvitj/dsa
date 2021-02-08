package com.personal.dsa.leetcode;

import java.util.Arrays;

public class _1335_MinDifficultyOfAJobSchedule {

//}
//class Solution {

//  class Pair {
//      int index;
//      int days;

//      public Pair(int index, int days) {
//          this.index = index;
//          this.days = days;
//      }
	// }

	public void findMin(int index, int[] jobDifficulty, int d, int[][] dp) {

		// current seg + rest

		int n = jobDifficulty.length;
		int minTillNow = Integer.MAX_VALUE;
		int maxSeg = 0;

		if (d == 1) {
			for (int i = index; i < jobDifficulty.length; i++) {
				maxSeg = Math.max(maxSeg, jobDifficulty[i]);
			}

			dp[index][d - 1] = maxSeg;

			return;
		}

		for (int i = index; i <= n - d; i++) {
			maxSeg = Math.max(maxSeg, jobDifficulty[i]);

			if (dp[i + 1][d - 2] == -1) {
				findMin(i + 1, jobDifficulty, d - 1, dp);
			}

			int rest = dp[i + 1][d - 2];
			if (rest == -1)
				break;

			minTillNow = Math.min(minTillNow, maxSeg + rest);
		}
		dp[index][d - 1] = minTillNow;

	}

	public int minDifficulty(int[] jobDifficulty, int d) {

		// HashMap<Pair, Integer> minDiff = new HashMap<>();
		int n = jobDifficulty.length;
		int dp[][] = new int[n][d];

		if (d > n) {
			return -1;
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		findMin(0, jobDifficulty, d, dp);

		return dp[0][d - 1];

	}
}