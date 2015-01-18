package leetcode;

/**
 * https://oj.leetcode.com/problems/search-insert-position/
 * 
 * @author wangt
 *
 */
public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int start = 0, end = A.length - 1;

		while (true) {

			if (target == A[start]) {
				return start;
			} else if (target == A[end]) {
				return end;
			} else if (target > A[end]) {
				return end + 1;
			} else if (target < A[start]) {
				return 0;
			} else if (end - start == 1 && target > A[start] && target < A[end]) {
				return start + 1;
			}

			int mid = start + (end - start) / 2;

			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}

		}

	}

	public static void main(String[] args) {

		SearchInsertPosition sip = new SearchInsertPosition();

		 System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 0));

//		 System.out.println(sip.searchInsert(new int[] { 1 }, 3));

//		System.out.println(sip.searchInsert(new int[] { 1, 3 }, 3));

	}

}
