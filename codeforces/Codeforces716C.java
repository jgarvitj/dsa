package com.personal.dsa.codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Codeforces716C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, List<Integer>> hm = new HashMap<>();
		for (int i = 1; i < n; i++) {
			for (Map.Entry<Integer, List<Integer>> e : hm.entrySet()) {
				int x = e.getKey();
				x = (x*i))
			}
			if (!hm.containsKey(i)) {
				hm.put(i, new ArrayList<>());
				hm.get(i).add(1);
				hm.get(i).add(i);
			}

		}
		sc.close();
	}
}
