package com.personal.dsa.gs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class M20ApacheLogs {

//public class Solution {

	/**
	   * Given a log file, return IP address(es) which accesses the site most often.
	   */

	  public static String findTopIpaddress(String[] lines) {
	    // Your code goes here
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String line : lines) {
			String[] words = line.split(" -");
			if(hm.containsKey(words[0])) {
				hm.replace(words[0], hm.get(words[0]) + 1);
			}
			else {
				hm.put(words[0], 1);
			}
		}
//		Collections.max(hm.entrySet(), )
		int max = 0;
		String maxString = "";
		for(Map.Entry<String, Integer> e : hm.entrySet()) {
			if(e.getValue() > max) {
				maxString = e.getKey();
			}
		}
		return maxString;
//		return hm.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
//	    return "10.0.0.1";
	  }


	public static void main(String[] args) {

		String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
				"10.0.0.2 - log entry 133132" };
		String result = findTopIpaddress(lines);

		if (result.equals("10.0.0.1")) {
			System.out.println("Test passed");

		} else {
			System.out.println("Test failed");

		}

	}

}