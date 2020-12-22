package com.personal.dsa.leetcode;

public class BestTimeToBuyAndSellStock121 {

//}
//class Solution {
	public int maxProfit(int[] prices) {

		int max = 0;
		if (prices.length <= 1) {
			return max;
		}
		int minTillNow = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - minTillNow > max) {
				max = prices[i] - minTillNow;
			}
			if (minTillNow > prices[i]) {
				minTillNow = prices[i];
			}
		}
		return max;

	}
}