package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author wangt
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return 1;
		}

		int p1 = 1, p2 = 1;

		while (p2 < A.length) {
			if (A[p2] != A[p2 - 1]) {
				A[p1++] = A[p2];
			}

			p2++;
		}

		return p1;

	}

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();

		int[] a = {  };

		System.out.println(rd.removeDuplicates(a));

		for (int i : a) {
			System.out.print(i + " ");
		}

	}
}
