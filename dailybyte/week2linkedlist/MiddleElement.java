package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListLinked;
import com.personal.dsa.dailybyte.ListNode;

public class MiddleElement {

	public static ListNode middle(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.next;

	}

	public static void main(String[] args) {

		ListLinked list = new ListLinked(new int[] { 1, 2, 3, 4 });
		ListNode x = list.head;

		ListNode result = middle(x);
		System.out.println(result.val);

	}

}
