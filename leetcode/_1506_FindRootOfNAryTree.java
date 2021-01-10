package com.personal.dsa.leetcode;

import java.util.List;

public class _1506_FindRootOfNAryTree {

//}
//class Solution {
	public Node findRoot(List<Node> tree) {
		int value = 0;
		for (Node n : tree) {
			value += n.val;
			for (Node child : n.children) {
				value -= child.val;
			}
		}

		for (Node n : tree) {
			if (n.val == value) {
				return n;
			}
		}
		return null;
	}
}