package com.personal.dsa.dailybyte;

import java.util.Arrays;

public class TwoSum {

	private static boolean checkTwoSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int h = arr.length - 1;
		int l = 0;
		while (l < h) {
			if (arr[l] + arr[h] == sum) {
				return true;
			} else if (arr[l] + arr[h] > sum) {
				h--;
			} else {
				l++;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		
		int[] arr = { 1, 3, 8, 2 };
		int[] arr1 = { 3, 9, 13, 7 };
		int[] arr2 = { 4, 2, 6, 5, 2 };
		System.out.println(checkTwoSum(arr, 10) && !checkTwoSum(arr1, 8) && checkTwoSum(arr2, 4));
	}

}
