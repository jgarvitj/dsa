package com.personal.dsa.leetcode;

public class _134_GasStation {

//}
//class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total_gas = 0;
		int cur_gas = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			total_gas += gas[i] - cost[i];
			cur_gas += gas[i] - cost[i];
			if (cur_gas < 0) {
				cur_gas = 0;
				start = i + 1;
			}
		}
		if (total_gas >= 0) {
			return start;
		}
		return -1;
	}
}