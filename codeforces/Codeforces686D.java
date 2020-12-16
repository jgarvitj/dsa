package com.personal.dsa.codeforces;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Codeforces686D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		while (x > 0) {
			x--;
			long n = sc.nextLong();
			int max  = 0;
			long maxPrime = n;
			long temp = n;
			long i = 2;
			HashMap<Long, Integer> primefac = new HashMap<Long, Integer>();
			while(n%i == 0) {
				if(primefac.containsKey(i)) {
					primefac.replace(i, primefac.get(i)  + 1);
				}
				else {
					primefac.put(i, 1);
				}
				maxPrime = 2;
				max = primefac.get(i);
				n = n / i;
			}
			for(i = 3; i <= Math.sqrt(n); i = i + 2) {
				while(n%i == 0) {
					if(primefac.containsKey(i)) {
						primefac.replace(i, primefac.get(i)  + 1);
					}
					else {
						primefac.put(i, 1);
					}
					n = n / i;
				}
				if(primefac.containsKey(i) && max < primefac.get(i)) {
					max = primefac.get(i);
					maxPrime = i;
				}
			}
			if(n > 2) {
				if(primefac.containsKey(n)) {
					primefac.replace(n, primefac.get(n)  + 1);
				}
				else {
					primefac.put(n, 1);
				}
				if(max < primefac.get(n)) {
					max = primefac.get(n);
					maxPrime = n;
				}
			}
			System.out.println(max);
			if(max > 1) {
				for(i  = 0 ; i < max - 1; i++) {
					System.out.print(maxPrime);
					System.out.print(" ");
					temp = temp/maxPrime;
				}
				System.out.print(temp);
				System.out.println();
			}
			else {
				System.out.println(temp);
			} 
		}
	}

}
