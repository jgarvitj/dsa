package com.personal.dsa.codeforces;

import java.util.Scanner;

public class Codeforces715B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			int arr[] = new int[n];
			int it = 0;
			int im = 0;
			int it2 = 0;
			String s = sc.next();
			boolean hasAllFirstTArrived = false;
			boolean isPos = true;
			if (n % 3 != 0) {
				isPos = false;
				System.out.println("NO");
			}
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!isPos) {
					continue;
				}
				if (c == 'T') {
					if (hasAllFirstTArrived) {
						if (it2 == im) {
							System.out.println("NO");
							isPos = false;
						} else {
							arr[it2] = 3;
							it2++;
						}
					} else {
						arr[it] = 1;
						it++;
						if (it == n / 3) {
							hasAllFirstTArrived = true;
						}
					}
				} else {
					if (im == it || im == n) {
						System.out.println("NO");
						isPos = false;
					} else {
						arr[im] = 2;
						im++;
					}
				}
			}
			if (isPos) {
				System.out.println("YES");
			}
		}
		sc.close();
	}

}
