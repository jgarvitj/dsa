package com.personal.dsa.dailybyte;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	private static boolean checkAnagram(String s1, String s2) {
		HashMap<Character, Integer> charCount1 = new HashMap<>();
		HashMap<Character, Integer> charCount2 = new HashMap<>();
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			charCount1.put(s1.charAt(i), charCount1.getOrDefault(s1.charAt(i), 0) + 1);
			charCount2.put(s2.charAt(i), charCount2.getOrDefault(s2.charAt(i), 0) + 1);
		}
		for (Map.Entry<Character, Integer> e : charCount1.entrySet()) {
			if (e.getValue() != charCount2.getOrDefault(e.getKey(), 0)) {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}

	public static void main(String[] args) {

		System.out.println(
				checkAnagram("cat", "tac") && checkAnagram("listen", "silent") && !checkAnagram("program", "function"));

	}

}
