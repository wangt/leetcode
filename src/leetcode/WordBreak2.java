package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
 * It seems that backtracking method can't pass the test case:
 * https://oj.leetcode
 * .com/discuss/7439/this-accepted-java-version-program-there-
 * any-better-solution
 * https://oj.leetcode.com/discuss/12936/accepted-solution-backtracking
 * -difference-front-tracking
 * 
 * am thinking it is because of the test case "aaaaa...ab". The first one is
 * passed is simply because you can not find any word in dict ending with "b" in
 * the loop. So, for this case, there is no such time limit error. The second
 * case, you have to start from beginning "aaaaaaa...", and then, time limit
 * error comes.
 * 
 * If there is a test case "baaaaaaaaaa...a", your first test might not be able
 * to pass the OJ.
 * 
 * @author wangt
 *
 */
public class WordBreak2 {

	public List<String> wordBreak(String s, Set<String> dict) {

		if (s == null || s.trim().length() == 0) {
			return Collections.emptyList();
		}

		int maxLen = 0;

		for (String d : dict) {
			if (d.length() > maxLen) {
				maxLen = d.length();
			}
		}

		List<String> result = new ArrayList<String>();

		dfs(result, s, 0, new Stack<String>(), dict, maxLen);

		return result;

	}

	public void dfs(List<String> result, String s, int j, Stack<String> stack, Set<String> dict, int maxLen) {

		System.out.println("j=" + j);

		if (j >= s.length()) {

			StringBuilder sb = new StringBuilder();
			for (String seg : stack) {
				sb.append(seg).append(" ");
			}
			result.add(sb.toString().trim());
			System.out.println(result.get(result.size() - 1));

		}

		for (int i = j; i < s.length() && (i - j) < maxLen; i++) {

			String seg = s.substring(j, i + 1);
			if (dict.contains(seg)) {
				stack.add(seg);
				dfs(result, s, i + 1, stack, dict, maxLen);
				stack.pop();
			}

		}
	}

	public static void main(String[] args) {

		WordBreak2 wb2 = new WordBreak2();

		List<String> result = wb2
				.wordBreak(
						"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
						new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
								"aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

		for (String s : result) {
			System.out.println(s);
		}

	}

}
