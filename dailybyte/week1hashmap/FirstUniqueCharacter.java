package com.personal.dsa.dailybyte.week1hashmap;

import java.util.HashMap;

public class FirstUniqueCharacter {

	private static int findFirstUniqueCharacter(String s) {

		HashMap<Character, Integer> charCount = new HashMap<>();
		for (Character c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findFirstUniqueCharacter("abcabd") == 2 && findFirstUniqueCharacter("thedailybyte") == 1
				&& findFirstUniqueCharacter("developer") == 0);
	}
}
