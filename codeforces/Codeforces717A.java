package com.personal.dsa.codeforces;

import java.util.Scanner;

public class Codeforces717A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		int k = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			k = sc.nextInt();
			int addToLast = 0;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				if (i == n - 1) {
					tmp += addToLast;
					System.out.println(tmp);
					continue;
				}
				if (tmp <= k) {
					System.out.print(0 + " ");
					addToLast += tmp;
					k -= tmp;
				} else {
					if (k > 0) {
						tmp = tmp - k;
						addToLast += k;
						k = 0;
					}
					System.out.print(tmp + " ");
				}
			}

		}
		sc.close();
	}

}
