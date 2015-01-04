package leetcode;

/**
 * https://oj.leetcode.com/problems/plus-one/
 * 
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author wangt
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return new int[] { 1 };
		}

		int carry = 1;

		int[] result = new int[digits.length];

		for (int i = digits.length - 1; i >= 0; i--) {

			result[i] = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;

		}

		if (carry > 0) {

			int[] r2 = new int[digits.length + 1];

			r2[0] = carry;

			for (int i = 0; i < result.length; i++) {
				r2[i + 1] = result[i];
			}

			return r2;

		} else {
			return result;
		}

	}

	public static void main(String[] args) {

		PlusOne po = new PlusOne();

		int[] r = po.plusOne(new int[] { 8, 9, 9, 9 });

		for (int i : r) {
			System.out.print(i + " ");
		}

	}
}
