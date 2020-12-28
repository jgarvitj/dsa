package com.personal.dsa.dailybyte;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}

class ListLinked {
	
	ListNode head;
	
	public ListLinked(int[] x) {
		if (x.length == 0) {
			head = null;
		} else {
			head = new ListNode(x[0]);
		}
		ListNode temp = head;
		for (int i = 1; i < x.length; i++) {
			ListNode p = new ListNode(x[i]);
			temp.next = p;
			temp = p;
		}
	}
}