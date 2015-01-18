package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/valid-palindrome/
 * 
 * @author wangt
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {

		if (s == null || s.trim().isEmpty()) {
			return true;
		}

		char[] chars = s.trim().toCharArray();

		int p1 = 0, p2 = chars.length - 1;

		while (true) {

			while (!isAlphanumeric(chars[p1])) {
				if (++p1 > chars.length - 1) {
					return true;
				}
			}

			while (!isAlphanumeric(chars[p2])) {
				if (--p2 < 0) {
					return true;
				}
			}

			if (p1 >= p2 || p1 > chars.length - 1 || p2 < 0) {
				break;
			}

			if (Character.toLowerCase(chars[p1]) != Character.toLowerCase(chars[p2])) {
				return false;
			}

			p1++;

			p2--;

		}

		return true;

	}

	private boolean isAlphanumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

	public static void main(String[] args) {

		ValidPalindrome vp = new ValidPalindrome();

		System.out.println(vp.isPalindrome("."));

	}

}
