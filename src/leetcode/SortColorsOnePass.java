package leetcode;

/**
 * https://oj.leetcode.com/problems/sort-colors/
 *
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white andblue. Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 **/

public class SortColorsOnePass {

	public void sortColors(int[] A) {

		if (A == null || A.length == 0) {
			return;
		}

		int p0 = 0, p2 = A.length - 1;

		for (int i = p0; i <= p2;) {

			if (A[i] == 0) {
				exchange(A, i, p0);
				p0++;
				i++;
			} else if (A[i] == 2) {
				exchange(A, i, p2);
				p2--;
			} else {
				i++;
			}

		}

	}

	public void exchange(int[] A, int i, int j) {

		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;

	}

	public static void main(String[] args) {

		SortColorsOnePass sc = new SortColorsOnePass();

		int[] A = new int[] { 1, 0 };
		sc.sortColors(A);

		for (int e : A) {
			System.out.println(e + " ");
		}

	}

}
