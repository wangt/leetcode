package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author wangt
 *
 */
public class WordBreak2DP {

	public List<String> wordBreak(String s, Set<String> dict) {

		if (s == null || s.trim().length() == 0) {
			return Collections.emptyList();
		}

		s = s.trim();

		int maxLen = 0;

		for (String d : dict) {
			if (d.length() > maxLen) {
				maxLen = d.length();
			}
		}

		Map<Integer, List<Integer>> segs = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < s.length(); i++) {

			for (int j = i - 1; j >= -1; j--) {

				String word = s.substring(j + 1, i + 1);

				if (dict.contains(word)) {

					if (segs.containsKey(j) || j < 0) {

						List<Integer> sens = segs.get(i);

						if (sens == null) {
							sens = new ArrayList<Integer>();
							segs.put(i, sens);
						}

						sens.add(j);

					}
				}
			}

		}

		if (!segs.containsKey(s.length() - 1)) {
			return Collections.emptyList();
		}

		List<String> result = new ArrayList<String>();

		dfs(s, segs, s.length() - 1, new Stack<String>(), result);

		return result;

	}

	private void dfs(String s, Map<Integer, List<Integer>> segs, int pos, Stack<String> stack, List<String> result) {

		if (pos < 0) {

			String sen = "";

			for (String w : stack) {
				sen = w + " " + sen;
			}

			result.add(sen.trim());

			return;

		}

		List<Integer> posList = segs.get(pos);

		for (int i = 0; i < posList.size(); i++) {

			Integer nextPos = posList.get(i);

			if (nextPos >= 0) {

				stack.push(s.substring(nextPos + 1, pos + 1));
			} else {
				stack.push(s.substring(0, pos + 1));
			}

			dfs(s, segs, nextPos, stack, result);

			stack.pop();

		}

	}

	public static void main(String[] args) {

		WordBreak2DP wb2 = new WordBreak2DP();

		// List<String> result = wb2
		// .wordBreak(
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
		// new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa",
		// "aaaaaa", "aaaaaaa",
		// "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

		List<String> result = wb2.wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa", "a")));

		// List<String> result = wb2.wordBreak("ab", new
		// HashSet<String>(Arrays.asList("a", "b")));

		for (String s : result) {
			System.out.println(s);
		}

	}

}
