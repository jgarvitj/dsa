package com.personal.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _68_TextJustification {

//}
//class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {

		// list of strings
		// form sentences with greedy approach
		// find extra space
		/*
		 * if(words > 1) extra space(e) = maxWidth - (wordLength + words - 1)
		 * unevenspace = e%(words - 1) evenspace = e/(words - 1)
		 */

		List<String> justified = new ArrayList<>();

		int senEnd = 0;
		int senStart = 0;
		int curWidth = -1;
		int e = 0;
		int unevenspace = 0;
		int evenspace = 0;
		int wordsNum = 0;

		while (senEnd < words.length) {
			if (senStart == senEnd && words[senEnd].length() > maxWidth) {
				return null;
			}
			if (curWidth + words[senEnd].length() + 1 <= maxWidth) {
				curWidth += words[senEnd].length() + 1;
				senEnd++;
			} else {
				StringBuilder sen = new StringBuilder();
				wordsNum = senEnd - senStart;
				e = maxWidth - (curWidth);
				if (wordsNum == 1) {
					sen.append(words[senStart]);
					int y = maxWidth - sen.length();
					for (int i = 0; i < y; i++) {
						sen.append(" ");
					}
					justified.add(sen.toString());
				} else {
					unevenspace = e % (wordsNum - 1);
					evenspace = e / (wordsNum - 1);
					for (int i = senStart; i < senEnd - 1; i++) {
						sen.append(words[i]);
						for (int j = -1; j < evenspace; j++) {
							sen.append(" ");
						}
						if (unevenspace > 0) {
							sen.append(" ");
							unevenspace--;
						}
					}
					sen.append(words[senEnd - 1]);
					justified.add(sen.toString());
				}
				senStart = senEnd;
				curWidth = -1;
			}
		}

		StringBuilder last = new StringBuilder();
		for (int i = senStart; i < senEnd - 1; i++) {
			last.append(words[i]);
			last.append(" ");
		}
		last.append(words[senEnd - 1]);
		int y = maxWidth - last.length();
		for (int i = 0; i < y; i++) {
			last.append(" ");
		}
		justified.add(last.toString());

		return justified;

	}
}