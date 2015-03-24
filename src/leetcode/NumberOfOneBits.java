package leetcode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Write a function that takes an unsigned integer and returns the number of Õ1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer Õ11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author wangt
 *
 */
public class NumberOfOneBits {

	/**
	 * https://leetcode.com/discuss/27609/short-code-of-c-o-m-by-time-m-is-the-
	 * count-of-1s
	 * 
	 * "n &= n - 1" is used to delete the right "1" of n. For example:
	 * 
	 * if n = 5 (101), then n-1 = 100, so n & (n-1) = 100, the right "1" is
	 * deleted; if n = 6,(110), then n-1 = 101, so n & (n-1) = 100, the right
	 * "1" is also deleted; and so on... So time complexity is O(m), and m is
	 * the count of 1's, also m is less than or equal to 32.
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {

		if (n == 0) {
			return 0;
		}

		int num = 0;

		while (n != 0) {
			n &= n - 1;
			++num;
		}

		return num;

	}

	// you need to treat n as an unsigned value
	public int hammingWeightCommon(int n) {
		if (n == 0) {
			return 0;
		}

		int num = 0;

		int one = 1;
		for (int i = 0; i < 32; i++) {

			if ((n & one) != 0) {
				num++;
			}

			one = one << 1;

		}

		return num;

	}

}
