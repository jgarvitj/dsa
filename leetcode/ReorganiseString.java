package com.personal.dsa.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganiseString {

//}
//class Solution {
    public String reorganizeString(String S) {
        //count
        HashMap<Character, Integer> count = new HashMap<>();
        for(Character c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> charHeap = 
        		new PriorityQueue<Character>((a, b)-> count.get(b)-count.get(a));
        charHeap.addAll(count.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(charHeap.size() > 1) {
            char current = charHeap.remove();
            char next = charHeap.remove();
            sb.append(current);
            sb.append(next);
            count.put(current, count.get(current)-1);
            count.put(next, count.get(next)-1);
            if(count.get(current) > 0) {
                charHeap.add(current);
            }
            if(count.get(next) > 0) {
                charHeap.add(next);
            }
        }
        if(charHeap.size() == 1) {
            char current = charHeap.remove();
            if(count.get(current) == 1) {
                sb.append(current);
            } 
            else {
                return "";
            }
        }
        return sb.toString();
    }
}