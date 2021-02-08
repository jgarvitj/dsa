package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsOfAPhoneNumber {

//}
//class Solution {

	Map<String, String> keypad = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	List<String> combinations = new ArrayList<>();

	public void backtrack(String cur, String next_digits) {
		if (next_digits.length() == 0) {
			combinations.add(cur);
		} else {
			String digit = next_digits.substring(0, 1);
			String letters = keypad.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter = letters.substring(i, i + 1);
				backtrack(cur + letter, next_digits.substring(1));
			}
		}
	}

	public List<String> letterCombinations(String digits) {

		if (digits.length() > 0) {
			backtrack("", digits);
		}
		return combinations;
	}
}