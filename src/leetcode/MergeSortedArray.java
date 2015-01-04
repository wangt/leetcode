package leetcode;

/**
 * https://oj.leetcode.com/problems/merge-sorted-array/
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * 
 * @author wangt
 *
 */
public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {

		int p = m + n - 1;

		int pa = m - 1;
		int pb = n - 1;

		while (p >= 0 && pb >= 0) {

			if (pa >= 0) {
				if (A[pa] > B[pb]) {
					A[p--] = A[pa--];
				} else {
					A[p--] = B[pb--];
				}
			} else {
				A[p--] = B[pb--];
			}

		}

	}

	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();

		int[] A = { 1 };
		int[] B = {};

		msa.merge(A, 1, B, 0);

		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
