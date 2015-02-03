package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author wangt
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {

		if (s == null || s.trim().length() == 0) {
			return false;
		}

		if (dict == null || dict.isEmpty()) {
			return false;
		}

		s = s.trim();

		if (s.length() == 1) {
			return dict.contains(s);
		}

		int maxLen = 0;

		for (String item : dict) {
			if (item.length() > maxLen) {
				maxLen = item.length();
			}
		}

		boolean[] segments = new boolean[s.length()];

		if (dict.contains(s.substring(0, 1))) {
			segments[0] = true;
		} else {
			segments[0] = false;
		}

		for (int i = 1; i < s.length(); i++) {

			for (int j = i - 1; j >= 0 && (i - j) <= maxLen; j--) {

				if (segments[j] && dict.contains(s.subSequence(j + 1, i + 1))) {
					segments[i] = true;
					break;
				}

				if (j == 0 && dict.contains(s.subSequence(j, i + 1))) {
					segments[i] = true;
					break;
				}

			}

		}

		return segments[s.length() - 1];

	}

	public static void main(String[] args) {

		WordBreak wb = new WordBreak();

		Set<String> dict = new HashSet<String>(Arrays.asList("aa","a"));

		System.out.println(wb.wordBreak("baa", dict));

	}
}
