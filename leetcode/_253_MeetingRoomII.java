package com.personal.dsa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253_MeetingRoomII {

//}
//class Solution {
	public int minMeetingRooms(int[][] intervals) {

		if (intervals.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> endTime = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		// PriorityQueue<Integer> endTime = new PriorityQueue<>();

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int count = 0;

		for (int i = 0; i < intervals.length; i++) {
			if (endTime.isEmpty() || endTime.peek() > intervals[i][0]) {
				count++;
				endTime.add(intervals[i][1]);
			} else {
				endTime.poll();
				endTime.add(intervals[i][1]);
			}
		}

		return count;

	}
}