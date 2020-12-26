package com.personal.dsa.dailybyte;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {

	private static List<String> findUncommon(String s1, String s2) {
		// TODO Auto-generated method stub
		List<String> ans = new ArrayList<>();
		HashMap<String, Integer> uncommonWords = new HashMap<>();
		String[] sArr = s1.split(" ");
		for (String s : sArr) {
			uncommonWords.put(s, 1);
		}

		sArr = s2.split(" ");
		for (String s : sArr) {
			if (uncommonWords.containsKey(s) && uncommonWords.get(s) == 1) {
				uncommonWords.put(s, -1);
			} else if (!uncommonWords.containsKey(s)) {
				uncommonWords.put(s, 2);
			}
		}
		
		for(Map.Entry<String, Integer> e : uncommonWords.entrySet()) {
			if(e.getValue() != -1) {
				ans.add(e.getKey());
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println(findUncommon("the quick", "the brown fox"));
		
	}

}
