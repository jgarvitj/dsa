package com.personal.dsa.dailybyte;

import java.util.HashMap;

public class SpotTheDifference {

	private static Character findDiff(String s1, String s2) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> freq = new HashMap<>();
		for (Character c : s1.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		for (Character c : s2.toCharArray()) {
			if (freq.containsKey(c) && freq.get(c) > 0) {
				freq.put(c, freq.get(c) - 1);
			} else
				return c;
		}
		return null;

	}

	public static void main(String[] args) {
		System.out.println(findDiff("foobar", "barfoot") == 't' && findDiff("ide", "idea") == 'a'
				&& findDiff("coding", "ingcod") == null);
	}

}
