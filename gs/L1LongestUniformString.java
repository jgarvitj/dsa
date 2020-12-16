package com.personal.dsa.gs;

/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class L1LongestUniformString {

	private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

	static int[] longestUniformSubstring(String input) {
		// check if the string is empty
//	  parse the string and check if previous is eq to current
//	  keep tabs on counter
		int longestStart = -1;
		int longestLength = 0;
		if (input.length() < 1) {
			return new int[] { -1, 0 };
		}
		int count = 1;
		int start = 0;
		// your code goes here
		for (int i = 1; i < input.length(); i++) {
			while (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
				count++;
				i++;
			}
			if (count > longestLength) {
				longestLength = count;
				longestStart = start;

			}
			start = i;
			count = 1;

		}
		return new int[] { longestStart, longestLength };
	}

	public static void main(String[] args) {
		testCases.put("", new int[] { -1, 0 });
		testCases.put("10000111", new int[] { 1, 4 });
		testCases.put("aabbbbbCdAA", new int[] { 2, 5 });

		boolean pass = true;
		for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
			int[] result = longestUniformSubstring(testCase.getKey());
			pass = pass && (Arrays.equals(result, testCase.getValue()));
		}
		if (pass) {
			System.out.println("Pass!");
		} else {
			System.out.println("Failed! ");
		}
	}
}