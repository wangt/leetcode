package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * Two pointers
 * 
 * @author wangt
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] A) {

		if (A == null) {
			return 0;
		}

		if (A.length < 3) {
			return A.length;
		}

		int p1 = 2, p2 = 2;

		while (p2 < A.length) {

			if (A[p2] != A[p1 - 1] || A[p2] != A[p1 - 2]) {
				A[p1++] = A[p2];
			}

			p2++;
		}

		return p1;
	}

}
