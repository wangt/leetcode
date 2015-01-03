package leetcode;

import java.math.BigInteger;

/**
 * https://oj.leetcode.com/problems/reverse-integer/
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author wangt
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
		if (x >= 0 && x < 10) {
			return x;
		}

		StringBuilder sb = new StringBuilder();

		char[] sx = String.valueOf(x).toCharArray();

		boolean started = false;
		for (int i = sx.length - 1; i >= 0; i--) {

			if (sx[i] == '0' && !started) {
				continue;
			}

			if (sx[i] >= '0' && sx[i] <= '9') {
				sb.append(sx[i]);
				started = true;
			}

		}

		if (sx[0] == '-') {
			sb.insert(0, '-');
		}

		BigInteger r = new BigInteger(sb.toString());

		if (r.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0
				|| r.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
			return 0;
		}

		return r.intValue();

	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();

		System.out.println(ri.reverse(-123));
	}
}
