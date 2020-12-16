package com.personal.dsa.codeforces;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Codeforces686B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while(x > 0) {
			x--;
			int n = sc.nextInt();
			boolean flag = true;
			HashMap<Integer,Integer> auctionList = new HashMap<Integer, Integer>();
			for(int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				
				if(auctionList.containsKey(temp)) {
					auctionList.replace(temp, -1);
				}
				else {
					auctionList.put(temp, i+1);
				}
				
			}
			for(int i = 1; i <= n; i++) {
				if(auctionList.containsKey(i)) {
					if(auctionList.get(i) != -1 && flag) {
						System.out.println(auctionList.get(i));
						flag = false;
					}
				}
			}
			if(flag) {
				System.out.println(-1);
			}
		}
	}

}
