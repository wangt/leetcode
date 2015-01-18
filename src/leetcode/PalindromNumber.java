package leetcode;

/**
 * https://oj.leetcode.com/problems/palindrome-number/
 * 
 * Two solutions:
 * https://oj.leetcode.com/discuss/21138/sharing-simple-straightforward
 * -solution-with-explanation
 * 
 * https://oj.leetcode.com/discuss/16395/my-java-solution-in-one-pass-over-half-
 * the-length-of-x
 **/

public class PalindromNumber {

	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		int length = (int) Math.log10(x) + 1;

		for (int i = 0; i < length / 2; i++) {

			if ((int) (x / Math.pow(10, i)) % 10 != (int) (x / Math.pow(10, length - i - 1)) % 10) {
				return false;
			}

		}

		return true;

	}

	public static void main(String[] args) {

		PalindromNumber pdn = new PalindromNumber();

		System.out.println(pdn.isPalindrome(3113));

	}
}