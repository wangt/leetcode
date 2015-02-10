package leetcode;

/**
 * https://oj.leetcode.com/problems/single-number-ii/
 * 
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * Solution: https://oj.leetcode.com/discuss/857/constant-space-solution
 * 
 * @author wangt
 *
 */
public class SingleNumber2 {

	public int singleNumber(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		if (A.length == 1) {
			return A[0];
		}

		int result = 0;

		for (int i = 0; i < 32; i++) {

			int n = 0;

			for (int j = 0; j < A.length; j++) {

				n += (A[j] >> i) & 1;

			}

			if (n % 3 == 1) {
				result |= (1 << i);
			}

		}

		return result;

	}
}
