package com.personal.dsa.leetcode;

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

public class ValidateBinarySearchTree {

//}
//
//class Solution {

	public static boolean checkValid(TreeNode root, Integer gt, Integer lt) {
		if (gt != null) {
			if (root.val <= gt) {
				return false;
			}
		}
		if (lt != null) {
			if (root.val >= lt) {
				return false;
			}
		}
		if (root.left != null) {
			if (root.left.val < root.val) {
				if (!checkValid(root.left, gt, root.val)) {
					return false;
				}
			} else {
				return false;
			}
		}
		if (root.right != null) {
			if (root.right.val > root.val) {
				if (!checkValid(root.right, root.val, lt)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isValidBST(TreeNode root) {

		return checkValid(root, null, null);
	}
}