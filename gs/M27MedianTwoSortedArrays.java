package com.personal.dsa.gs;

public class M27MedianTwoSortedArrays {

//}

//find the median of the two sorted arrays.
// ex. {1, 3} and {2} is 2

//
//public class Solution
//{

//	public static double findMedian(int[] A, int[] B, int alow, int ahigh, int blow, int bhigh,  int n) {
//		
//	}

	public static double findMedianSortedArrays(int nums1[], int input2[]) {
		// if input1 length is greater than switch them so that input1 is smaller than
		// input2.
		if (nums1.length > input2.length) {
			return findMedianSortedArrays(input2, nums1);
		}
		int xlength = nums1.length;
		int ylength = input2.length;
		int low = 0;
		int high = xlength;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (xlength + ylength + 1) / 2 - partitionX;
			// +1 here takes care of both even and odd before divide by 2

//			System.out.println(partitionX + "\t" + partitionY);
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == xlength) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == ylength) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // Break condition

				if ((xlength + ylength) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {// First partition has more elements
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

	public static double logic(int[] A, int[] B) {
		double x =  findMedianSortedArrays(A, B);
		System.out.println(x);
		return x;
	}

	public static boolean pass() {
		boolean result = true;
		int[] c = { 1, 2, 99, 100 };
		int[] d = { 4, 5, 101, 102 };
		result = result && logic(new int[] { 1, 3 }, new int[] { 2, 4 }) == 2.5 && logic(c, d) == 52;
		return result;
	};

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("pass");
		} else {
			System.out.println("some failures");
		}
	}
}