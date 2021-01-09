package com.personal.dsa.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _480_SlidingWindowMedian {

//}
//class Solution {
	public double[] medianSlidingWindow(int[] nums, int k) {

		PriorityQueue<Long> minH = new PriorityQueue<>();
		PriorityQueue<Long> maxH = new PriorityQueue<>(Collections.reverseOrder());

		if (nums.length < k) {
			return null;
		}
		int n = nums.length;

		double[] slidingMedian = new double[n - k + 1];

		for (int i = 0; i < k; i++) {
			maxH.add((long) nums[i]);
			minH.add(maxH.poll());
			if (minH.size() > maxH.size()) {
				maxH.add(minH.poll());
			}
		}
		int i = 0;
		for (i = k; i < n; i++) {
			if (maxH.size() > minH.size()) {
				slidingMedian[i - k] = (double) maxH.peek();
			} else {
				slidingMedian[i - k] = ((double) maxH.peek() + (double) minH.peek()) / 2;
			}

			if (nums[i - k] > maxH.peek()) {
				minH.remove((long) nums[i - k]);
			} else {
				maxH.remove((long) nums[i - k]);
			}
			maxH.add((long) nums[i]);
			minH.add(maxH.poll());
			while (minH.size() > maxH.size()) {
				maxH.add(minH.poll());
			}
		}
		if (maxH.size() > minH.size()) {
			slidingMedian[i - k] = (double) maxH.peek();
		} else {

			slidingMedian[i - k] = ((double) maxH.peek() + (double) minH.peek()) / 2;
		}
		return slidingMedian;
	}
}