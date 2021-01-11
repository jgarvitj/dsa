package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListLinked;
import com.personal.dsa.dailybyte.ListNode;

public class RemoveValue {

	public static ListNode remove(ListNode head, int x) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode it = dummy;

		while (it.next != null) {
			if (it.next.val == x) {
				it.next = it.next.next;
				return dummy.next;
			}
			it = it.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {

		ListLinked list = new ListLinked(new int[] { 1, 2, 3 });
		ListNode x = list.head;
		ListNode result = remove(x, 3);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
