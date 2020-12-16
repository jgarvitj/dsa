package com.dsa.gs;
// Given a a string of letters and a dictionary, the function longestWord should

//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Dictionary {
	private String[] entries;

	public Dictionary(String[] entries) {
		this.entries = entries;
	}

	public boolean contains(String word) {
		return Arrays.asList(entries).contains(word);
	}
}

public class H26Dictionary {

	public static Set<String> longestWord(String letters, Dictionary dict) {
		Set<String> result = new HashSet<String>();

		Set<String> perms = new HashSet<String>();
		perms = perm("", letters, perms);

		int maxSize = -1;
		for (String str : perms) {
			if (dict.contains(str)) {
				result.add(str);
				maxSize = maxSize < str.length() ? str.length() : maxSize;
			}
		}
		for (String str : result) {
			if (str.length() < maxSize)
				result.remove(str);
		}

		for (String str : result)
			System.out.println(str);
		return result;
	}

	private static Set<String> perm(String fixedStr, String remStr, Set<String> perms) {
//		System.out.println(fixedStr);
		perms.add(fixedStr);
		if (remStr.length() == 0) {
			// perms.add(fixedStr);
			return perms;
		}
		for (int i = 0; i < remStr.length(); i++) {
			StringBuilder sb = new StringBuilder(remStr);

			perms = perm(fixedStr + remStr.charAt(i), sb.deleteCharAt(i).toString(), perms);
		}
		return perms;

	}

	public static boolean pass() {
		Dictionary dict = new Dictionary(new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "banana" });
		boolean r = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("oet", dict));
		return r;
	}

//	public static Set<String> longestWord(String letters, Dictionary dict) {
	// create all permulations for letters, removing one letter at a time
	// create a funciton to give all permutations, given string and length (call the
	// function from maxlen to min)
	// if at any iteration word is found, search only for that iteration
//	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.err.println("Fails");
		}
	}
}