package leetcode;

/**
 * https://oj.leetcode.com/problems/single-number/
 * 
 * @author wangt
 *
 */
public class SingleNumber {
	public int singleNumber(int[] A) {

		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result ^= A[i];
		}

		return result;

	}

	public static void main(String[] args) {

		SingleNumber sn = new SingleNumber();

		System.out.println(sn.singleNumber(new int[] { 1, 2, 2, 1, 3 }));

	}
}
