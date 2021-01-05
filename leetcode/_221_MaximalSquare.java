package com.personal.dsa.leetcode;

public class _221_MaximalSquare {

	/*
	 * dp
	 * top corner of sq
	 */
//}
//class Solution {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int maxArea = 0;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					if (j == m - 1 || i == n - 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1])) + 1;
					}
					maxArea = Math.max(maxArea, dp[i][j]);
				}
			}
		}
		return maxArea * maxArea;
	}
}