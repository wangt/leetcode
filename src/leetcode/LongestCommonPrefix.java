package leetcode;

import java.util.LinkedList;

public class LongestCommonPrefix {

	private int shortestPrefix;

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		shortestPrefix = strs[0].length();

		LinkedList<String> queue = new LinkedList<String>();

		for (String sa : strs) {
			queue.push(sa);
		}

		while (queue.size() > 1) {

			queue.addLast(prefix(queue.pop(), queue.poll(), shortestPrefix));

		}

		return queue.getFirst();

	}

	public String prefix(String s1, String s2, int maxPossibleLength) {
		int i = 0;

		while (i < s1.length() && i < s2.length() && i <= maxPossibleLength) {

			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}

			i++;

		}

		if (i < maxPossibleLength) {
			maxPossibleLength = i;
		}

		return s1.substring(0, i);
	}

	public static void main(String[] args) {

		LongestCommonPrefix lcp = new LongestCommonPrefix();

		System.out.println(lcp.longestCommonPrefix(new String[] { "ddd","abcdefg", "abcdess", "abcd3333" }));

	}
}
