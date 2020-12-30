package com.personal.dsa.dailybyte.week0basics;

public class CorrectCapitalization {

	public static boolean checkLower(String s) {
		for(Character c : s.toCharArray()) {
			if(c < 'a' || c > 'z') {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check(String s) {
		if(s.length() == 0) {
			return true;
		}
		if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
			return checkLower(s);
		}
		if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
			if(s.length() == 1) {
				return true;
			}
			return check(s.substring(1));
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(check("USA"));
	}
	
}
