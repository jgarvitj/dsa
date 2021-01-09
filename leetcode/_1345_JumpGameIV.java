package com.personal.dsa.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _1345_JumpGameIV {

	/*
	 * leetcode solution, do it yourself
	 */
//}
//class Solution {
	public int minJumps(int[] arr) {
		int n = arr.length;

		HashMap<Integer, List<Integer>> indexHm = new HashMap<>();

		for (int i = 0; i < n; i++)
			indexHm.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);

		boolean[] isVis = new boolean[n];
		isVis[0] = true;
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(0);
		int step = 0;

		while (!q.isEmpty()) {
			for (int size = q.size(); size > 0; size--) {
				int i = q.poll();

				if (i == n - 1)
					return step; // Reached to last index

				List<Integer> nxt = indexHm.get(arr[i]);
				nxt.add(i - 1);
				nxt.add(i + 1);

				for (int j : nxt) {
					if (j >= 0 && j < n && !isVis[j]) {
						isVis[j] = true;
						q.offer(j);
					}
				}
				nxt.clear();
			}
			step++;
		}
		return 0;
	}
}