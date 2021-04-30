package com.personal.dsa.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class Codeforces717B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = 0;
		while (x > 0) {
			x--;
			n = sc.nextInt();
			HashMap<Integer, int[]> hm = new HashMap<>();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				long tmp = sc.nextLong();
				arr[i] = tmp;
			}
			int bin[] = new int[32];
			for (int i = 0; i < n; i++) {
				long tmp = arr[i];
				int index = 0;
				while (tmp > 0) {
					if (tmp % 2 != 0) {
						bin[index]++;
						if (bin[index] % 2 == 0) {
							bin[index] = 0;
						}
					}
					tmp = tmp / 2;
					index++;
				}
				hm.put(i, bin.clone());

			}
			boolean isPos = false;
			int bin1[] = new int[32];
			for (int i = n - 1; i >= 0; i--) {
				long tmp = arr[i];
				int index = 0;
				while (tmp > 0) {
					if (tmp % 2 != 0) {
						bin1[index]++;
						if (bin1[index] % 2 == 0) {
							bin1[index] = 0;
						}
					}
					tmp = tmp / 2;
					index++;
				}
				int check[] = new int[32];
				if(hm.containsKey(i-1))
					check = hm.get(i - 1);
				boolean flag = true;
				for (int j = 0; j < 32; j++) {
					if (check[j] != bin1[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println("YES");
					isPos = true;
					break;
				}
			}
			if (!isPos) {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
