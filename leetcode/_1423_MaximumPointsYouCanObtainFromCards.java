package com.personal.dsa.leetcode;

public class _1423_MaximumPointsYouCanObtainFromCards {

//}
//class Solution {
	public int maxScore(int[] cardPoints, int k) {

		int n = cardPoints.length;
		long[] sumFromRt = new long[n];
		long[] sumFromLt = new long[n];

		sumFromRt[n - 1] = cardPoints[n - 1];
		sumFromLt[0] = cardPoints[0];

		for (int i = n - 2; i >= 0; i--) {
			sumFromRt[i] = cardPoints[i] + sumFromRt[i + 1];
		}

		for (int i = 1; i < n; i++) {
			sumFromLt[i] = cardPoints[i] + sumFromLt[i - 1];
		}

		long maxPoints = Math.max(sumFromLt[k - 1], sumFromRt[n - k]);

		for (int i = k - 2; i >= 0; i--) {
			maxPoints = Math.max(maxPoints, sumFromLt[i] + sumFromRt[n - (k - i) + 1]);
		}

		return (int) maxPoints;

	}
}