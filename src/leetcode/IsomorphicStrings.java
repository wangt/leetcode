package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/27808494/
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author wangt
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {

		if (s == null && t == null) {
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}

		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();

		Map<Character, Character> mappingTo = new HashMap<Character, Character>();
		Map<Character, Character> mappingFrom = new HashMap<Character, Character>();

		for (int i = 0; i < sc.length; i++) {

			Character mt = mappingTo.get(sc[i]);

			if (mt == null) {
				mappingTo.put(sc[i], tc[i]);
			} else if (!mt.equals(tc[i])) {
				return false;
			}

			Character mf = mappingFrom.get(tc[i]);

			if (mf == null) {
				mappingFrom.put(tc[i], sc[i]);
			} else if (!mf.equals(sc[i])) {
				return false;
			}
		}

		return true;

	}
}
