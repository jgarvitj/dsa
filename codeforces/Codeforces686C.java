package com.personal.dsa.codeforces;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Codeforces686C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while(x > 0) {
			x--;
			int n = sc.nextInt();
			int pre = -1;
			HashMap<Integer,Integer> arr = new HashMap<Integer, Integer>();
			for(int i = 1; i < n-1; i++) {
				int temp = sc.nextInt();
				
				if(arr.containsKey(temp) && pre != temp) {
					arr.replace(temp, arr.get(temp)  + 1);
				}
				else {
					arr.put(temp, 1);
				}
				pre = temp;				
			}
			int min = Integer.MAX_VALUE;
			for(Map.Entry<Integer, Integer> e : arr.entrySet()) {
				if(e.getValue() < min) {
					min = e.getValue();
				}
			}
			System.out.println(min);
		}
	}

}
