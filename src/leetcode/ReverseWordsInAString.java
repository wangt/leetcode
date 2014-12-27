package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {

	public String reverseWords(String s) {

		if (s.length() == 0) {
			return "";
		}

		List<String> stack = new ArrayList<String>();

		char[] chars = s.toCharArray();

		boolean inWord = false;

		int wordStartIndex = 0;

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			if (c == ' ') {
				if (inWord) {
					// word stop
					inWord = false;
					stack.add(new String(chars, wordStartIndex, i
							- wordStartIndex));
				}
			} else {

				if (inWord) {
					// do nothing
				} else {
					inWord = true;
					wordStartIndex = i;
				}

			}

		}

		if (inWord) {
			stack.add(new String(chars, wordStartIndex, s.length()
					- wordStartIndex));
		}

		StringBuilder sb = new StringBuilder();

		if (stack.size() > 1) {

			for (int i = stack.size() - 1; i > 0; i--) {
				sb.append(stack.get(i)).append(" ");
			}
		}

		if (stack.size() > 0) {

			sb.append(stack.get(0));
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		ReverseWordsInAString rws = new ReverseWordsInAString();

		// System.out.println(rws.reverseWords(" the sky             is   blue "));

		System.out.println(rws.reverseWords(""));
	}
}
