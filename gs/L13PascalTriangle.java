package com.dsa.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L13PascalTriangle {

	/*
	 ** Below formation is called Pascals Triangle.
	 **
	 ** Example: 1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1 1 6 15 20 15 6 1
	 **
	 ** Complete the 'pascal' function below so that given a col and a row it will
	 * return the value in that positon.
	 **
	 ** Example, pascal(1,2) should return 2
	 **
	 */

	/*
	 * ******** IMPORTANT ********
	 *
	 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING
	 * SAME. USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
	 *
	 */

//public class Solution {


	private static HashMap<List<Integer>, Integer> pascalVal = new HashMap<>();

	public static int pascal(int col, int row) {
		List<Integer> p = new ArrayList<>();
		p.add(row);
		p.add(col);
		if (!pascalVal.containsKey(p)) {
			System.out.println(col + " " + row);
			System.out.println(Math.abs(row));

			if (row == 0 || row == col || col == 0) {
				pascalVal.put(p, 1);
			}
			else {
				pascalVal.put(p, pascal(col, row - 1) + pascal(col - 1, row - 1));
			}
		}
		return pascalVal.get(p);

	}
//	public static  int pascal(int col, int row){
//
//		if(row == 0 || row == col || col == 0) {
//			return 1;
//		}
//		return pascal(col, row-1) + pascal(col-1, row-1);
//		
//	  }

	public static void main(String[] args) {
		if (L13PascalTriangle.pascal(0, 0) == 1 && L13PascalTriangle.pascal(1, 2) == 2
				&& L13PascalTriangle.pascal(5, 6) == 6 && L13PascalTriangle.pascal(4, 8) == 70
				&& L13PascalTriangle.pascal(6, 6) == 1) {
			System.out.println("Pass");
		} else {
			System.out.println("Failed");
		}
	}
}
