package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/roman-to-integer/
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://baike.baidu.com/link?url=ihRERMr24JM4s7YpRUfmwIyYcvTxkRxOkwYOdSU-
 * CrG7Zq3rM0HAFqVq6mGKG9Qfa4PbUwOolwmo5bfkB1huYK#2
 * 
 * @author wangt
 *
 */
public class RomanToInteger {

	public int romanToInt(String s) {

		char[] chars = s.toCharArray();

		int sum = 0;

		Map<Character, Integer> mapping = new HashMap<Character, Integer>();

		mapping.put('I', 1);
		mapping.put('V', 5);
		mapping.put('X', 10);
		mapping.put('L', 50);
		mapping.put('C', 100);
		mapping.put('D', 500);
		mapping.put('M', 1000);

		if (chars.length == 1) {
			return mapping.get(chars[0]);
		}

		for (int i = 0; i < chars.length; i++) {

			int n1 = mapping.get(chars[i]);

			if (i < chars.length - 1) {
				int n2 = mapping.get(chars[i + 1]);

				if (n1 < n2) {
					sum -= n1;
				} else {
					sum += n1;
				}

				continue;

			} else {

				sum += n1;

			}

		}

		return sum;
	}

	public static void main(String[] args) {

		RomanToInteger r2i = new RomanToInteger();

		System.out.println(r2i.romanToInt("MMMCMXCIX"));

	}

}
