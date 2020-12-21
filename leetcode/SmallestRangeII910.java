package com.personal.dsa.leetcode;

import java.util.Arrays;

public class SmallestRangeII910 {

//}
//class Solution {
    public int smallestRangeII(int[] A, int K) {
        
        /*
        * tried O(N) approach but failed
        * always think the solution through
        * O(nlogn) solution
        */
        
        Arrays.sort(A);
        int diff =  A[A.length - 1] - A[0];
        
        for(int i = 0;  i < A.length - 1; i++) {
            int a = A[i];
            int b = A[i+1];
            int high = Math.max(A[A.length - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            diff = Math.min(diff, high - low);
        }
        return diff;
    }
}