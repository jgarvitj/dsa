package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListNode;

public class CheckCycle {

	public static boolean checkCycleLL(ListNode x) {
		ListNode slow = x;
		ListNode fast = x;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;

	}

}
