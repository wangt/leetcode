package leetcode;

/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author wangt
 *
 */
public class MaxmumProductSubarray {

	public int maxProduct(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int r = A[0];

		// imax/imin stores the max/min product of
		// subarray that ends with the current number A[i]
		for (int i = 1, imax = r, imin = r; i < A.length; i++) {
			// multiplied by a negative makes big number smaller, small number
			// bigger
			// so we redefine the extremums by swapping them
			if (A[i] < 0) {
				int t = imax;
				imax = imin;
				imin = t;
			}

			// max/min product for the current number is either the current
			// number itself
			// or the max/min by the previous number times the current one
			imax = Math.max(A[i], imax * A[i]);
			imin = Math.min(A[i], imin * A[i]);

			// the newly computed max value is a candidate for our global result
			r = Math.max(r, imax);
		}
		return r;

	}

	public static void main(String[] args) {

		MaxmumProductSubarray ms = new MaxmumProductSubarray();

		System.out.println(ms.maxProduct(new int[] { 2, -5, 0, -2, -4, 3 }));

	}
}
