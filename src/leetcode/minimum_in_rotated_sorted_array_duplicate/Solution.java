package leetcode.minimum_in_rotated_sorted_array_duplicate;

public class Solution {

	// brute force
	public int findMin2(int[] num) {

		int min = num[0];

		for (int i = 1; i < num.length; i++) {

			if (num[i] < min) {
				min = num[i];
			}
		}

		return min;

	}

	/**
	 * For case where AL == AM == AR, the minimum could be on AM’s left or right
	 * side (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). In this case, we could not
	 * discard either subarrays and therefore such worst case degenerates to the
	 * order of O(n).
	 * 
	 * @param A
	 * @return
	 */
	public int findMin(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else if (A[M] < A[L]) {
				R = M;
			} else { // A[L] == A[M] == A[R]
				L = L + 1;
			}
		}
		return A[L];
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int min = solution.findMin(new int[] { 10, 1, 10, 10, 10 });

		System.out.println(min);

	}
}
