package com.personal.dsa.leetcode;

import java.util.PriorityQueue;

public class _295_FindMedianFromDataStream {

	/*
	 * maintain 2 heaps
	 * first half in max heap
	 * and snd in min heap
	 * median is the top of both heaps
	 */
//}
//class MedianFinder {

	/** initialize your data structure here. */
	static PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);
	static PriorityQueue<Integer> minH = new PriorityQueue<>(); // by default min heap

	public _295_FindMedianFromDataStream() {

		maxH.clear();
		minH.clear();

	}

	public void addNum(int num) {
		maxH.add(num);
		minH.add(maxH.poll());
		if (minH.size() > maxH.size()) {
			maxH.add(minH.poll());
		}

	}

	public double findMedian() {
		if (maxH.size() > minH.size()) {
			return (double) maxH.peek();
		}

		return ((double) maxH.peek() + (double) minH.peek()) / 2;
	}
}