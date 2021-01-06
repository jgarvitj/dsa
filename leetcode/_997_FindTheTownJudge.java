package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _997_FindTheTownJudge {
	/*
	 * graph 
	 * make adj list of is trusted by
	 */
//}
//class Solution {
	public int findJudge(int N, int[][] trust) {

		if (N == 1 && trust.length == 0) {
			return 1;
		}

		List<HashSet<Integer>> adj = new ArrayList<>();
		// is trusted by

		for (int i = 0; i < N; i++) {
			adj.add(new HashSet<Integer>());
		}

		for (int i = 0; i < trust.length; i++) {
			adj.get(trust[i][1] - 1).add(trust[i][0] - 1);
		}

		for (int i = 0; i < N; i++) {
			if (adj.get(i).size() == N - 1) {
				for (int j = 0; j < N; j++) {
					if (j != i && adj.get(j).contains(i)) {
						return -1;
					}
				}
				return i + 1;
			}
		}
		return -1;

	}
}