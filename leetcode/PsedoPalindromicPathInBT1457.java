package com.personal.dsa.leetcode;

import java.util.HashMap;

// * Definition for a binary tree node.
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

public class PsedoPalindromicPathInBT1457 {

//}

//class Solution {

	public static boolean checkPali(HashMap<Integer, Integer> hm) {
		int count = 0;
		boolean flag = true;
		for (int i = 1; i < 10; i++) {
			if (hm.get(i) != 0) {
				count += hm.get(i);
			}
			if (hm.get(i) % 2 != 0 && flag) {
				flag = false;
			} else if (hm.get(i) % 2 != 0 && !flag) {
				return false;
			}
		}

		if (count % 2 == 0) {
			return flag;
		} else {
			return !flag;
		}
	}

	public static int countPali(TreeNode root, HashMap<Integer, Integer> hm) {
		if (root == null) {
			return 0;
		}

		hm.put(root.val, hm.get(root.val) + 1);
		if (root.left == null && root.right == null) {
			if (checkPali(hm)) {
				hm.put(root.val, hm.get(root.val) - 1);
				return 1;
			}
			hm.put(root.val, hm.get(root.val) - 1);
			return 0;
		}

		int x = countPali(root.left, hm) + countPali(root.right, hm);
		hm.put(root.val, hm.get(root.val) - 1);
		return x;
	}

	public int pseudoPalindromicPaths(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 1; i < 10; i++) {
			hm.put(i, 0);
		}
		hm.put(root.val, 1);

		return countPali(root.left, hm) + countPali(root.right, hm);

	}
}