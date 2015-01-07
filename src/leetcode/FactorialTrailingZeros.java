package leetcode;

/**
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * explanation:http://www.purplemath.com/modules/factzero.htm
 * 
 * @author wangt
 *
 */
public class FactorialTrailingZeros {

	public int trailingZeroes(int n) {

		int sum = 0;

		while (n / 5 > 0) {

			int tmp = n / 5;

			sum += tmp;

			n = tmp;

		}

		return sum;

	}

}
