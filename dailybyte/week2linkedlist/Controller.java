package com.personal.dsa.dailybyte.week2linkedlist;

import com.personal.dsa.dailybyte.ListLinked;
import com.personal.dsa.dailybyte.ListNode;

public class Controller {

	public static void printLL(ListNode result) {
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static void main(String[] args) {
		
		//merge
		ListNode x1 = new ListLinked(new int[] { 1, 2, 4 }).head;
		ListNode x2 = new ListLinked(new int[] { 2, 2, 3, 7 }).head;

		ListNode result = MergeLinkedList.mergeList(x1, x2);
		printLL(result);
		
		//check cycle
		ListNode x3 = new ListLinked(new int[] {1, 2, 3}).head;
		x3.next.next.next = x3;
		System.out.println(ContainsCycle.checkCycleLL(x3));
		
		System.out.println(CycleOrigin.getCycleOrigin(x3).val);

	}

}
