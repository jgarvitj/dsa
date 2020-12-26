package com.personal.dsa.leetcode;

public class DiagonalTraverse498 {

//}
//class Solution {
	public int[] findDiagonalOrder(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return new int[0];
		int m = matrix[0].length;
		int[] ans = new int[n * m];

		int i = 0;
		int j = 0;
		int iDir = -1;
		int jDir = 1;
		int k = 0;

		while (i < n && j < m) {

			ans[k] = matrix[i][j];
			k++;

			if (i + 1 == n && iDir == 1) {
				iDir = -1;
				jDir = 1;
				j++;
			} else if (j - 1 < 0 && jDir == -1) {
				iDir = -1;
				jDir = 1;
				i++;
			} else if (j + 1 == m && jDir == 1) {
				iDir = 1;
				jDir = -1;
				i++;
			} else if (i - 1 < 0 && iDir == -1) {
				iDir = 1;
				jDir = -1;
				j++;
			} else {
				i = i + iDir;
				j = j + jDir;
			}
		}
		return ans;
	}
}