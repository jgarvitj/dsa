package com.personal.dsa.leetcode;

import java.util.PriorityQueue;

public class _556_NextGreaterElementIII {

//}
//class Solution {
	public int nextGreaterElement(int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int fac = n % 10;
		int temp = 1;
		long temp1 = 1;
		boolean flag = false;
		long x;

		pq.add(fac);
		n -= fac * temp;
		temp = temp * 10;
		int max = fac;
		if (n == 0) {
			return -1;
		}
		while (n > 0) {
			fac = (n % (temp * 10)) / temp;
			pq.add(fac);
			n -= fac * temp;
			if (fac < max) {
				flag = true;
				temp1 = temp;
				temp = temp / 10;
				x = n;
				while (!pq.isEmpty()) {
					if (flag && pq.peek() > fac) {
						x += temp1 * pq.peek();

						n += temp1 * pq.poll();
						if (x > (long) Integer.MAX_VALUE) {
							return -1;
						}
						flag = false;
					} else {
						x += temp * pq.peek();
						n += temp * pq.poll();
						temp = temp / 10;
					}
				}
				if (x > Integer.MAX_VALUE) {
					return -1;
				}
				return n;
			} else {
				max = fac;
			}
			temp = temp * 10;
		}
		return -1;
	}
}