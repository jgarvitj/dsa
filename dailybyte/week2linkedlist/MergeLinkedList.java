package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListLinked;
import com.personal.dsa.dailybyte.ListNode;

public class MergeLinkedList {

	public static ListNode mergeList(ListNode x1, ListNode x2) {

		ListNode head = new ListNode(-1);
		ListNode temp = head;
		int min;
		while (x1 != null || x2 != null) {
			min = Integer.MAX_VALUE;
			if (x1 != null) {
				min = x1.val;
			}
			if (x2 != null && x2.val <= min) {
				min = x2.val;
				x2 = x2.next;
			} else {
				x1 = x1.next;
			}
			ListNode newNode = new ListNode(min);
			temp.next = newNode;
			temp = newNode;
		}
		if(head.next == null) {
			return head;
		}
		return head.next;
	}

	public static void main(String[] args) {

		ListNode x1 = new ListLinked(new int[] { 1, 2, 4 }).head;
		ListNode x2 = new ListLinked(new int[] { 2, 2, 3, 7 }).head;

		ListNode result = mergeList(x1, x2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}
