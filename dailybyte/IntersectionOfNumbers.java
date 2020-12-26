package com.personal.dsa.dailybyte;

import java.util.HashSet;

public class IntersectionOfNumbers {

	private static Object[] findIntersection(int[] a1, int[] a2) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new HashSet<>();
		for(Integer i : a1) {
			hs.add(i);
		}
		HashSet<Integer> hs2 = new HashSet<>();
		for(Integer i : a2) {
			if(hs.contains(i)) {
				hs2.add(i);
			}
		}
		return hs2.toArray();
		
	}
	
	public static void main(String[] args) {
		System.out.println(findIntersection(new int[] {2, 4, 4, 2}, new int[] {3}).length);
	}
	
}
