package com.personal.dsa.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

//}
//public class Solution {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		s.push(-1);
		int n = heights.length;
		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			while ((s.peek() != -1) && (heights[s.peek()] >= heights[i])) {
				int currentHeight = heights[s.pop()];
				int currentWidth = i - s.peek() - 1;
				maxArea = Math.max(maxArea, currentHeight * currentWidth);
			}
			s.push(i);
		}
		while (s.peek() != -1) {
			int currentHeight = heights[s.pop()];
			int currentWidth = n - s.peek() - 1;
			maxArea = Math.max(maxArea, currentHeight * currentWidth);
		}
		return maxArea;
	}
}