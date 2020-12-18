package com.personal.dsa.dailybyte;

public class ValidPalindromeWithRemoval {

	private static boolean checkPalindrome(String str, int removalLeft) {

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				if (removalLeft > 0) {
					boolean isValid = checkPalindrome(str.substring(0, i) + str.substring(i + 1, str.length()),
							removalLeft - 1);
					if (i > 0) {
						isValid = isValid || checkPalindrome(
								str.substring(0, str.length() - i - 1) + str.substring(str.length() - i, str.length()),
								removalLeft - 1);
					} else {
						isValid = isValid || checkPalindrome(str.substring(0, str.length() - i - 1), removalLeft - 1);
					}
					return isValid;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPalindrome("abcba", 1) && checkPalindrome("foobof", 1) && !checkPalindrome("abccab", 1)
				&& checkPalindrome("abcbad", 1));
	}

}
