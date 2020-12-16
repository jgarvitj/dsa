package com.personal.dsa.dailybyte;

public class BinaryStrSum {

	public static int findCount(char c1, char c2, char c3) {
		int count = 0;
		if (c1 == '1') {
			count++;
		}
		if (c2 == '1') {
			count++;
		}
		if (c3 == '1') {
			count++;
		}
		return count;
	}

	public static String bSum(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		char carry = '0';
		int count;
		while (i >= 0 && j >= 0) {
			count = findCount(s1.charAt(i), s2.charAt(j), carry);
			if (count / 2 == 1) {
				carry = '1';
			} else {
				carry = '0';
			}
			if (count % 2 == 1) {
				sb.insert(0, '1');
			} else {
				sb.insert(0, '0');
			}
			i--;
			j--;
		}
		while (i >= 0) {
			count = findCount(s1.charAt(i), '0', carry);
			if (count / 2 == 1) {
				carry = '1';
			} else {
				carry = '0';
			}
			if (count % 2 == 1) {
				sb.insert(0, '1');
			} else {
				sb.insert(0, '0');
			}
			i--;
		}
		while (j >= 0) {
			count = findCount('0', s2.charAt(j), carry);
			if (count / 2 == 1) {
				carry = '1';
			} else {
				carry = '0';
			}
			if (count % 2 == 1) {
				sb.insert(0, '1');
			} else {
				sb.insert(0, '0');
			}
			j--;
		}
		if (carry == '1') {
			sb.insert(0, '1');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(bSum("10", "11").equals("101") 
				&& bSum("100" , "1").equals("101") 
				&& bSum("11" , "1").equals("100")
				&& bSum("1" , "0").equals("1"));
	}

}
