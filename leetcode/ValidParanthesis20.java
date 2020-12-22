package com.personal.dsa.leetcode;

import java.util.Stack;

public class ValidParanthesis20 {

//}
//class Solution {
	public boolean isValid(String s) {
		Stack<Character> bracketStack = new Stack<>();

		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				bracketStack.add(c);
			} else if (!bracketStack.isEmpty() && ((c == ')' && bracketStack.peek() == '(')
					|| (c == '}' && bracketStack.peek() == '{') || (c == ']' && bracketStack.peek() == '['))) {

				bracketStack.pop();
			} else {
				return false;
			}
		}
		if (bracketStack.isEmpty()) {
			return true;
		}
		return false;
	}
}