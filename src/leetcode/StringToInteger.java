package leetcode;

/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases.
 * 
 * @author wangt
 *
 */
public class StringToInteger {

	public int atoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}

		str = str.trim();

		int minus = 1;

		if (str.charAt(0) > '9' || str.charAt(0) < '0') {

			if (!(str.startsWith("+") || str.startsWith("-"))) {
				return 0;
			} else if (str.startsWith("-")) {
				minus = -1;
			}

			str = str.substring(1);

		}

		int endIndex = str.length();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				endIndex = i;
				break;
			}
		}

		str = str.substring(0, endIndex);

		int result = 0;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (c > '9' || c < '0') {

				break;
			}

			int adding = (int) (minus * (c - '0') * Math.pow(10, str.length() - 1 - i));

			if (minus > 0 && Integer.MAX_VALUE - result < adding) {
				return Integer.MAX_VALUE;
			} else if (minus < 0 && Integer.MIN_VALUE - adding > result) {
				return Integer.MIN_VALUE;
			}

			result += adding;

		}

		return result;

	}

	public static void main(String[] args) {

		StringToInteger atoi = new StringToInteger();

		System.out.println(atoi.atoi("  b11228552307"));

	}
}
