package com.personal.dsa.leetcode;

import java.util.ArrayDeque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class _1602_FindNearestRightNode {

//}
//
//class Solution {
	
	/*
	 * bst
	 * level order traversal
	 */
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		ArrayDeque<TreeNode> cur = new ArrayDeque<>();
		ArrayDeque<TreeNode> nxt = new ArrayDeque<>();

		cur.offer(root);
		boolean flag = false;
		while (!cur.isEmpty() || !nxt.isEmpty()) {
			while (!cur.isEmpty()) {
				if (flag) {
					return cur.poll();
				}
				if (u == cur.peek()) {
					flag = true;
				}
				if (cur.peek().left != null) {
					nxt.add(cur.peek().left);
				}
				if (cur.peek().right != null) {
					nxt.add(cur.peek().right);
				}
				cur.poll();
			}
			if (flag) {
				return null;
			}
			cur = nxt.clone();
			nxt.clear();
		}
		return null;
	}
}