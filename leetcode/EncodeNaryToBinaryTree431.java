package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class EncodeNaryToBinaryTree431 {

//}

//class Codec {
	// Encodes an n-ary tree to a binary tree.
	public TreeNode encode(Node root) {

		if (root == null) {
			return null;
		}

		LinkedList<Node> nq = new LinkedList<>();
		LinkedList<TreeNode> tq = new LinkedList<>();

		TreeNode head = new TreeNode(root.val);
		nq.add(root);
		tq.add(head);

		while (!nq.isEmpty()) {
			Node nary = nq.poll();
			TreeNode tn = tq.poll();
			// check for children
			if (nary.children.size() > 0) {

				TreeNode newNode = new TreeNode(nary.children.get(0).val);
				tn.left = newNode;
				tn = newNode;
				tq.add(tn);

				nq.add(nary.children.get(0));

				for (int i = 1; i < nary.children.size(); i++) {
					newNode = new TreeNode(nary.children.get(i).val);
					tn.right = newNode;
					tn = newNode;
					tq.add(tn);

					nq.add(nary.children.get(i));
				}
			}
		}
		return head;
	}

	// Decodes your binary tree to an n-ary tree.
	public Node decode(TreeNode root) {

		if (root == null) {
			return null;
		}

		LinkedList<Node> nq = new LinkedList<>();
		// for keeping children, for later retrieval to populate their childern
		LinkedList<TreeNode> tq = new LinkedList<>();
		// to check for children later

		Node head = new Node(root.val, new ArrayList<Node>());
		tq.add(root);
		nq.add(head);

		while (!tq.isEmpty()) {
			TreeNode tn = tq.poll();
			Node nary = nq.poll();

			if (tn.left != null) {

				Node newNode = new Node(tn.left.val, new ArrayList<Node>());
				nary.children.add(newNode);
				nq.add(newNode);

				tn = tn.left;
				tq.add(tn);
				while (tn.right != null) {

					newNode = new Node(tn.right.val, new ArrayList<Node>());
					nary.children.add(newNode);
					nq.add(newNode);

					tn = tn.right;
					tq.add(tn);
				}
			}
		}

		return head;

	}
}

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(root));
