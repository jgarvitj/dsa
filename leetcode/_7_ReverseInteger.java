package com.personal.dsa.leetcode;

public class _7_ReverseInteger {

//}
//class Solution {
	public int reverse(int x) {

		int isPos = 1;

		if (x == 0) {
			return 0;
		}

		if (x < 0) {
			isPos = -1;
		}

		x = Math.abs(x);
		int y = 0;
		int z = Integer.MAX_VALUE / 10;
		int mul = 1;

		while (z > 0) {
			z = z / 10;
			mul = mul * 10;
		}

		z = Integer.MAX_VALUE;
		if (x / mul > 0) {
			int tmp = x;
			while (z > 0) {
				if (z / mul > tmp % 10) {
					break;
				} else if (z / mul < tmp % 10) {
					return 0;
				}
				z = z % mul;
				mul = mul / 10;
				tmp = tmp / 10;
			}
		}

		mul = 1;

		while (x > 0) {
			y = y * 10 + x % 10;
			mul = mul * 10;
			x = x / 10;
		}
		return y * isPos;
	}
}