package leetcode;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {

		if (A == null || A.length == 0) {
			return -1;
		}

		if (A.length == 1 && A[0] != target) {
			return -1;
		}

		return binarySearch(A, target, 0, A.length - 1);

	}

	private int binarySearch(int[] A, int target, int start, int end) {

		if (start == end - 1) {
			if (A[start] == target) {
				return start;
			} else if (A[end] == target) {
				return end;
			} else {
				return -1;
			}
		}

		int mid = start + (end - start) / 2;

		if (A[mid] == target) {
			return mid;
		}

		// normal
		if (A[start] < A[mid] && A[start] <= target && A[mid] > target) {
			return binarySearch(A, target, start, mid);
		}

		if (A[mid] < A[end] && A[mid] < target && A[end] >= target) {
			return binarySearch(A, target, mid, end);
		}

		if (A[start] > A[mid]) {
			return binarySearch(A, target, start, mid);
		}

		if (A[end] < A[mid]) {
			return binarySearch(A, target, mid, end);
		}

		return -1;

	}

	public static void main(String[] args) {

		SearchInRotatedSortedArray sa = new SearchInRotatedSortedArray();

		System.out.println(sa.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2));
		// System.out.println(sa.search(new int[] { 1, 3 }, 2));

	}
}
