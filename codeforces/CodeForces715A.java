package com.personal.dsa.codeforces;

import java.util.Scanner;

public class CodeForces715A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			int[] arr = new int[n];
			int a = 0;
			int b = n - 1;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				if (tmp % 2 == 0) {
					arr[b] = tmp;
					b--;
				} else {
					arr[a] = tmp;
					a++;
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
