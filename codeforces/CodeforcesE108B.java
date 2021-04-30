package com.personal.dsa.codeforces;

import java.util.Scanner;

public class CodeforcesE108B {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		int m = 0;
		int k = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			if(k == n*m - 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
