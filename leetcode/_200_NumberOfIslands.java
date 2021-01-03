package com.personal.dsa.leetcode;

public class _200_NumberOfIslands {

//}
//class Solution {

	/*
	 * dfs
	 * increase count each time '1' is encountered
	 */
	public static void dfs(char[][] grid, int r, int c) {
		int n = grid.length;
		int m = grid[0].length;

		if (r < 0 || c < 0 || r > n - 1 || c > m - 1 || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r + 1, c);
		dfs(grid, r, c + 1);
		dfs(grid, r - 1, c);
		dfs(grid, r, c - 1);

		return;
	}

	public int numIslands(char[][] grid) {
		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);

				}
			}
		}
		return count;

	}
}