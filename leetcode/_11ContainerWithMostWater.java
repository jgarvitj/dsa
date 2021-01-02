package com.personal.dsa.leetcode;

/*
 * Two pointers
 * 	pointing on opposite sides
 * 	no point in moving pointer with greater ht(consider both cases)
 * O(n) time O(1) space
 */
public class _11ContainerWithMostWater {
//}
//class Solution {
	public int maxArea(int[] height) {
		int p = 0;
		int q = height.length - 1;
		int area = 0;
		while (q > p) {
			if (height[q] > height[p]) {
				if (area < (q - p) * height[p]) {
					area = (q - p) * height[p];
				}
				p++;
			} else {
				if (area < height[q] * (q - p)) {
					area = height[q] * (q - p);
				}
				q--;
			}
		}
		return area;
	}
}