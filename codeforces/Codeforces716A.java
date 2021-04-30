package com.personal.dsa.codeforces;

import java.util.Scanner;

public class Codeforces716A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			boolean isPos = false;
			for(int i = 0; i < n; i++) {
				double tmp = sc.nextDouble();
				if(Math.sqrt(tmp) != (double)(int)(Math.sqrt(tmp))) {
					isPos = true;
				}
			}
			if(isPos) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
