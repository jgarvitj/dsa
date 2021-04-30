package com.personal.dsa.codeforces;

import java.util.Scanner;

public class Codeforces715E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			boolean isPos = false;
			if (k == 1) {
				for (int i = 0; i < n; i++) {
					System.out.print(i + 1 + " ");
				}
				System.out.println();
				isPos = true;
				continue;
			}
			k--;
			long dp[] = new long[n];
			dp[0] = 1;
			int index = 1;
			while (index < n) {
				dp[index] = 1;
				for (int i = 0; i < index; i++) {
					dp[index] += dp[i];
				}
				if (k > dp[index]) {
//					k -= dp[index];
					index++;
				} else {
					isPos = true;
					for(int i = 0; i < n-index-1; i++) {
						System.out.print((i+1) + " ");
					}
					print(index-1, index, k, dp);
				}

			}
			if (!isPos) {
				System.out.println(-1);
			}
		}
		sc.close();
	}

	public static void print(int cur, int index, long k, long[] dp) {
		int n = dp.length;
		if(index == n) {
			System.out.println();
			return;
		}
		if(k > dp[cur]) {
			
		}
	}

}
