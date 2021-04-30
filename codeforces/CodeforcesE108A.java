package com.personal.dsa.codeforces;

import java.util.Scanner;

public class CodeforcesE108A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		long r = 0;
		long b = 0;
		long d = 0;
		while (x > 0) {
			x--;
			r = sc.nextInt();
			b = sc.nextInt();
			d = sc.nextInt();
			long smaller = Math.min(r, b);
			if (Math.abs(r - b) > d * smaller) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		sc.close();
	}

}
