package com.personal.dsa.leetcode;

public class _1020_NumberOfEnclaves {

	/*
	 * dfs for all border lands
	 * maintain isVis
	 */
//}
//class Solution {

	private void dfs(int i, int j, int[][] A, int[][] isVis) {
		int n = A.length;
		int m = A[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m || A[i][j] == 0) {
			return;
		}

		isVis[i][j] = 1;
		if (j - 1 >= 0 && A[i][j - 1] == 1 && isVis[i][j - 1] != 1) {
			dfs(i, j - 1, A, isVis);
		}
		if (j + 1 < m && A[i][j + 1] == 1 && isVis[i][j + 1] != 1) {
			dfs(i, j + 1, A, isVis);
		}
		if (i - 1 >= 0 && A[i - 1][j] == 1 && isVis[i - 1][j] != 1) {
			dfs(i - 1, j, A, isVis);
		}
		if (i + 1 < n && A[i + 1][j] == 1 && isVis[i + 1][j] != 1) {
			dfs(i + 1, j, A, isVis);
		}
		return;

	}

	public int numEnclaves(int[][] A) {

		int n = A.length;
		if (n == 0) {
			return 0;
		}
		int m = A[0].length;

		int[][] isVis = new int[n][m];

		for (int i = 0; i < m; i++) {
			if (A[0][i] != 0 && isVis[0][i] == 0) {
				dfs(0, i, A, isVis);
			}
		}

		for (int i = 0; i < m; i++) {
			if (A[n - 1][i] != 0 && isVis[n - 1][i] == 0) {
				dfs(n - 1, i, A, isVis);
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i][0] != 0 && isVis[i][0] == 0) {
				dfs(i, 0, A, isVis);
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i][m - 1] != 0 && isVis[i][m - 1] == 0) {
				dfs(i, m - 1, A, isVis);
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] != 0 && isVis[i][j] != 1) {
					count++;
				}
			}
		}
		return count;
	}
}
