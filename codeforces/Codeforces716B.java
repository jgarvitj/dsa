package com.personal.dsa.codeforces;

import java.util.Scanner;

public class Codeforces716B {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long mod = 1000000007;
		int x = sc.nextInt();
		int n = 0;
		int k = 0;
		long ans = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			k = sc.nextInt();
			ans = 1;
			while(k > 0) {
				ans = ans*n;
				ans = ans%mod;
				k--;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
