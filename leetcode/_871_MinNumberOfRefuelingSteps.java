package com.personal.dsa.leetcode;

import java.util.PriorityQueue;

public class _871_MinNumberOfRefuelingSteps {

	/*
	 * greedy
	 */
//}
//class Solution {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (target <= startFuel) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // to store fuels at diff stations
		int dist = startFuel;
		int stationIndex = 0;
		int count = 0;
		int n = stations.length;
		while (true) {
			while (stationIndex < n && dist >= stations[stationIndex][0]) {
				pq.add(stations[stationIndex][1]);
				stationIndex++;
			}

			if (pq.isEmpty()) {
				return -1;
			}

			dist = dist + pq.poll();
			count++;
			if (dist >= target) {
				return count;
			}
		}

	}
}