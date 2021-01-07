package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _797_AllPathsFromSourceToTarget {
	/*
	 * commented code is better and consise
	 * dfs
	 */

	private static void findPaths(int index, int[][] graph, HashMap<Integer, List<List<Integer>>> hm) {
		int target = graph.length - 1;
		List<List<Integer>> paths = new ArrayList<>();
		if (index == target) {
			List<Integer> path = new ArrayList<>();
			path.add(index);
			paths.add(path);
			hm.put(index, paths);
			return;
		}
		if (graph[index].length == 0) {
			hm.put(index, null);
		}
		for (int i = 0; i < graph[index].length; i++) {
			if (!hm.containsKey(graph[index][i])) {
				findPaths(graph[index][i], graph, hm);
			}
			if (hm.get(graph[index][i]) != null) {
				hm.get(graph[index][i]).forEach((a) -> {
					List<Integer> path = new ArrayList<>();
					path.add(index);
					path.addAll(a);
					paths.add(path);
				});
				hm.put(index, paths);
			}
		}
		return;
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		HashMap<Integer, List<List<Integer>>> hm = new HashMap<>();
		findPaths(0, graph, hm);

		if (hm.get(0) == null) {
			return new ArrayList<List<Integer>>();
		}
		return hm.get(0);

	}
}
/*
 class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0) {
            return Collections.emptyList();
        }
        int n = graph.length;
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, n-1, cur, res);
        return res;
    }
    
    private void dfs(int[][] graph, int src, int dst, List<Integer> cur, List<List<Integer>> res) {
        if(src == dst) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int adj : graph[src]) {
            cur.add(adj);
            dfs(graph, adj, dst, cur, res);
            cur.remove(cur.size() -1);
        }
    }
}
 */