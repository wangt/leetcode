package leetcode;

/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author wangt
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		String lastWord = null;

		int wordStart = -1;

		char[] chars = s.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {

			if (chars[i] != ' ') {

				if (wordStart < 0) { // word starts
					wordStart = i;
				}

			} else {

				if (wordStart >= 0) { // word stops
					lastWord = new String(chars, i + 1, wordStart - i);
					wordStart = -1;
					break;
				}
			}

		}

		if (wordStart >= 0) {
			lastWord = new String(chars, 0, wordStart+1);
			wordStart = -1;
		}

		if (lastWord != null) {
			return lastWord.length();
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {

		LengthOfLastWord lw = new LengthOfLastWord();

		System.out.println(lw.lengthOfLastWord(" "));

	}
}
