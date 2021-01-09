package com.personal.dsa.leetcode;

import java.util.Stack;
/*
 * Stack question
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class _369_PlusOneLinkedList {

//}

//class Solution {
	public ListNode plusOne(ListNode head) {

		Stack<ListNode> nodes = new Stack<>();
		boolean flag = true;
		ListNode tempHead = new ListNode(0);
		if (head.val == 9) {

			tempHead.next = head;
			nodes.add(tempHead);
		}

		ListNode tmp = head;
		while (tmp != null) {
			if (tmp.val == 9) {
				nodes.add(tmp);
			} else {
				flag = false;
				nodes.clear();
				nodes.add(tmp);
			}
			tmp = tmp.next;
		}

		while (!nodes.isEmpty()) {
			if (nodes.peek().val == 9) {
				nodes.pop().val = 0;
			} else {
				nodes.pop().val += 1;
				if (flag && nodes.isEmpty()) {
					return tempHead;
				}
				return head;
			}
		}
		return head;

	}
}