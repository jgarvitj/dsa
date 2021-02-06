package com.personal.dsa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _362_DesignHitCounter {

	class Pair {
		int key;
		int value;

		public Pair(int timestamp, int value) {
			this.key = timestamp;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}

	}

//}
//class HitCounter {

	int total;
	Deque<Pair> hits;

	/** Initialize your data structure here. */
	public _362_DesignHitCounter() {
		this.total = 0;
		this.hits = new LinkedList<Pair>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {

		if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
			this.hits.add(new Pair(timestamp, 1));
		} else {
			int lastCount = this.hits.getLast().getValue();
			this.hits.removeLast();
			this.hits.add(new Pair(timestamp, lastCount + 1));
		}
		this.total++;

	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		while (!this.hits.isEmpty() && timestamp - this.hits.getFirst().getKey() >= 300) {
			this.total -= this.hits.getFirst().getValue();
			this.hits.removeFirst();
		}
		return this.total;
	}
}

/**
 * Your HitCounter object will be instantiated and called as such: HitCounter
 * obj = new HitCounter(); obj.hit(timestamp); int param_2 =
 * obj.getHits(timestamp);
 */