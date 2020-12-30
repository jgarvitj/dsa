package com.personal.dsa.dailybyte.week1hashmap;

import java.util.HashMap;

public class JewelsAndStones {
	/*
	 * to find common character
	 * O(m+n) time, O(n) space
	 * m = str1.length(), n = str2.length()
	 */
	
	private static int findCommon(String s1, String s2) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> stones = new HashMap<>();
		for(Character c : s2.toCharArray()) {
			stones.put(c, stones.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		for(Character c : s1.toCharArray()) {
			if(stones.containsKey(c)) {
				count += stones.get(c);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findCommon("abc", "ac") == 2 &&
				findCommon("Af", "AaaddfFf") == 3 &&
				findCommon("AYOPD", "ayopd") == 0 );
	}

}
