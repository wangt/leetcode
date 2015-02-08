package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 * 
 * @author wangt
 *
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {

		if (s == null) {
			return false;
		}

		if (s.equals("")) {
			if (p.equals("*")) {
				return true;
			} else {
				return false;
			}
		}
		
		int m = p.length();
		int n = s.length();

		int count = 0;
		for (int i = 0; i < m; i++) {
			if (p.charAt(i) != '*')
				count++;
		}

		Set<String> prePatterns = new HashSet<String>();

		for (int i = 0; i < s.length(); i++) {

			Set<String> patterns = new HashSet<String>();

			String[] chars = new String[] { "*", "?", s.substring(i, i + 1) };

			if (i == 0) {

				patterns.addAll(Arrays.asList(chars));

			} else {

				for (String pt : prePatterns) {

					if (pt.endsWith("*") || pt.endsWith("?")) {
						patterns.add(pt);
					}

					for (String nc : chars) {
						String np = pt + nc;

						if (p.startsWith(np)) {
							patterns.add(np);
						}

					}

				}

			}

			if (patterns.isEmpty()) {
				return false;
			}

			prePatterns = patterns;

		}

		for (String pt : prePatterns) {

			if (pt.equals(p)) {
				return true;
			}

		}

		return false;

	}
	
	public static void main(String[] args) {
		
		WildcardMatching wm = new WildcardMatching();
		
		System.out.println(wm.isMatch("aa", "a*"));
		
	}
}
