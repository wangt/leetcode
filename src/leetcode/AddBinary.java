package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://oj.leetcode.com/problems/add-binary/
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		char[] chars1 = a.toCharArray();

		char[] chars2 = b.toCharArray();

		int maxLength = chars1.length > chars2.length ? chars1.length
				: chars2.length;

		char[] result = new char[maxLength + 1];

		int carry = 0;

		Map<Character, Integer> digits = new HashMap<Character, Integer>();

		digits.put('0', 0);
		digits.put('1', 1);

		char[] chars = new char[] { '0', '1' };

		for (int i = 0; i < maxLength; i++) {

			int r = carry;

			if (i < chars1.length) {
				r += digits.get(chars1[chars1.length - 1 - i]);
			}

			if (i < chars2.length) {
				r += digits.get(chars2[chars2.length - 1 - i]);
			}

			result[result.length - 1 - i] = chars[r % 2];

			// System.out.println("r=" + r);
			// System.out.println(result);

			carry = (r >= 2 ? 1 : 0);

			// System.out.println("h:" + h);

		}

		// System.out.println(result);

		if (carry > 0) {
			result[0] = chars[carry];
			return new String(result);
		} else {
			return new String(result, 1, result.length - 1);
		}

	}

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();

		System.out.println(ab.addBinary("1", "111"));
	}
}
