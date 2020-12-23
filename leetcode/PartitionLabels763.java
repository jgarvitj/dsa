package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels763 {

//}
//
//class Solution {
	public List<Integer> partitionLabels(String S) {
		HashMap<Character, Integer> lastIndex = new HashMap<>();

		for (int i = 0; i < S.length(); i++) {
			lastIndex.put(S.charAt(i), i);
		}

		List<Integer> partLen = new ArrayList<>();
		int lastPartIndex = -1;
		int curPartLast = 0;

		for (int i = 0; i < S.length(); i++) {
			curPartLast = Math.max(curPartLast, lastIndex.get(S.charAt(i)));

			if (curPartLast == i) {
				partLen.add(curPartLast - lastPartIndex);
				lastPartIndex = curPartLast;
			}
		}
		return partLen;
	}
}
