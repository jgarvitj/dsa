package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {

//}
//class Solution {
	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int n = intervals.length;

		List<int[]> mergedIntervals = new ArrayList<>();
		if (n == 0) {
			return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
		}

		int[] newInterval = intervals[0];
		mergedIntervals.add(newInterval);

		for (int i = 0; i < n; i++) {
			if (newInterval[1] >= intervals[i][0]) {
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			} else {
				newInterval = intervals[i];
				mergedIntervals.add(newInterval);
			}
		}
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

	}
}