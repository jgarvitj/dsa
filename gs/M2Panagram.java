package com.personal.dsa.gs;

import java.util.HashMap;

public class M2Panagram {

//}

	/**
	 * Pangram FInder
	 *
	 * The sentence "The quick brown fox jumps over the lazy dog" contains every
	 * single letter in the alphabet. Such sentences are called pangrams. Write a
	 * function findMissingLetters, which takes a String `sentence`, and returns all
	 * the letters it is missing
	 *
	 */
//class Solution {

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String sentence) {
			HashMap<Character, Boolean> charCheck = new HashMap<>();
			char[] charcheck = new char[26];
			for (char c : sentence.toLowerCase().toCharArray()) {
				charCheck.put(c, true);
				if((int)c - (int)'a' >= 0 && (int)c - (int)'a' < 26)
					charcheck[(int)c - (int)'a'] = 1;
			}
			StringBuilder sb = new StringBuilder();
			for (char c = 'a'; c <= 'z'; c++) {
//				if (!charCheck.containsKey(c)) {
				if (charcheck[(int) c - (int) 'a'] != 1) {
					sb.append(c);
				}
			}
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Pass ");
		} else {
			System.out.println("Failed");
		}
	}
}