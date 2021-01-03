package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListLinked;
import com.personal.dsa.dailybyte.ListNode;

public class RemoveNthLastNode {

	public static ListNode removeNodeFromLast(ListNode head, int n) {
		ListNode dummy = new ListNode();
		ListNode fst = dummy;
		ListNode snd = dummy;
		dummy.next = head;

		while (n > 0) {
			if (fst == null) {
				return null;
			}
			fst = fst.next;
			n--;
		}

		while(fst.next != null) {
			fst = fst.next;
			snd = snd.next;
		}

		snd.next = snd.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {

		ListNode x1 = new ListLinked(new int[] { 1, 2, 4 }).head;
		ListNode result = removeNodeFromLast(x1, 3);
//		ListNode result1 = removeNodeFromLast(x1, 1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
//		while (result1 != null) {
//			System.out.println(result1.val);
//			result1 = result1.next;
//		}
	}
}
