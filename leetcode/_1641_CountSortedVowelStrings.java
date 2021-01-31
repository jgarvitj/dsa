package com.personal.dsa.leetcode;

public class _1641_CountSortedVowelStrings {

//}
//class Solution {
	public int countVowelStrings(int n) {

		int[][] countVowel = new int[n][5];

		for (int i = 0; i < n; i++) {
			countVowel[i][0] = 1;
		}

		for (int i = 1; i < 5; i++) {
			countVowel[0][i] = i + 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < 5; j++) {
				countVowel[i][j] = countVowel[i - 1][j] + countVowel[i][j - 1];
			}
		}

		return countVowel[n - 1][4];

	}
}