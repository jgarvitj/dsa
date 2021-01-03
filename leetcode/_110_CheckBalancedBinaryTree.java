package com.personal.dsa.leetcode;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class _110_CheckBalancedBinaryTree {

//}
//
//class Solution {
	/*
	 * all subtrees should be balanced
	 * return -1 if not
	 */

	private static int getHt(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHt = getHt(root.left);
		int rightHt = getHt(root.right);

		if (Math.abs(leftHt - rightHt) > 1 || leftHt == -1 || rightHt == -1) {
			return -1;
		}
		return Math.max(leftHt, rightHt) + 1;
	}

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		return getHt(root) != -1;

	}
}