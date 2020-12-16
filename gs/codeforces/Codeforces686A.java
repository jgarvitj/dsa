package com.personal.dsa.gs.codeforces;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Codeforces686A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x > 0) {
			x--;
			int n = sc.nextInt();
			if(n < 2) {
				continue;
			}
			if (n % 2 == 0) {
				for (int i = 0; i < n; i = i + 2) {
					System.out.print(i  + 2);
					System.out.print(" ");
					System.out.print(i  + 1);
					System.out.print(" ");
				}
			}
			else {
				for(int i = 0; i < n-3; i = i + 2) {
					System.out.print(i  + 2);
					System.out.print(" ");
					System.out.print(i  + 1);
					System.out.print(" ");
				}
				System.out.print(n);
				System.out.print(" ");
				System.out.print(n  - 2);
				System.out.print(" ");
				System.out.print(n  - 1);
				
			}
			System.out.println();
		}
	}

}
