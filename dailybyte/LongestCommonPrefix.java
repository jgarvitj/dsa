package com.personal.dsa.dailybyte;

public class LongestCommonPrefix {

	public static String findLongestCommonPrefix(String[] sArr) {
		String minStr = "";
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < sArr.length; i++) {
			if(sArr[i].length() < min) {
				min = sArr[i].length();
				minStr = sArr[i];
			}
		}
		int h = minStr.length() - 1;
		int l = 0;
		int ans = 0;
		while(l <= h) {
			int mid = (h+l)/2;
			boolean flag = true;
			for(int i = 0; i < sArr.length; i++) {
				if(sArr[i].charAt(mid) != minStr.charAt(mid)) {
					h = mid-1;
					flag = false;
					break;
				}
			}
			if(flag) {
				l = mid+1;
				ans = mid;
			}
		}
		return minStr.substring(0,ans+1);
	}
	
	public static void main(String[] args) {
		String[] sArr = new String[3];
		sArr[0] = "colorado";
		sArr[1] = "color";
		sArr[2] = "col";
		System.out.println(findLongestCommonPrefix(sArr).equals("col"));
	}
	
}
