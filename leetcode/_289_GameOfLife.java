package com.personal.dsa.leetcode;

public class _289_GameOfLife {

//}
//
//class Solution {
	public void gameOfLife(int[][] board) {

		int n = board.length;
		if (n == 0) {
			return;
		}
		int m = board[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count = 0;
				if (i - 1 >= 0 && j - 1 >= 0) {
					count += board[i - 1][j - 1] % 2;
				}
				if (i + 1 < n && j - 1 >= 0) {
					count += board[i + 1][j - 1] % 2;
				}
				if (i + 1 < n && j + 1 < m) {
					count += board[i + 1][j + 1] % 2;
				}
				if (i - 1 >= 0 && j + 1 < m) {
					count += board[i - 1][j + 1] % 2;
				}
				if (i - 1 >= 0) {
					count += board[i - 1][j] % 2;
				}
				if (j - 1 >= 0) {
					count += board[i][j - 1] % 2;
				}
				if (i + 1 < n) {
					count += board[i + 1][j] % 2;
				}
				if (j + 1 < m) {
					count += board[i][j + 1] % 2;
				}

				if (board[i][j] == 0) {
					if (count == 3) {
						board[i][j] += 2;
					}
				} else if (count < 2 || count > 3) {
					board[i][j] += 2;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = (board[i][j] / 2 + board[i][j]) % 2;
			}
		}

		return;

	}
}