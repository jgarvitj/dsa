package com.personal.dsa.leetcode;

public class _64_MinimumPathSum {

//}
//class Solution {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;

		for (int i = n - 2; i >= 0; i--) {
			grid[i][m - 1] += grid[i + 1][m - 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			grid[n - 1][i] += grid[n - 1][i + 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
			}
		}

		return grid[0][0];
	}
}