package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author wangt
 *
 */
public class RemoveElement {

	public int removeElement(int[] A, int elem) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int p = A.length - 1;

		for (int i = 0; i <= p; i++) {

			while (p >= 0 && A[p] == elem) {
				p--;
			}

			if (p < i) {
				break;
			}

			if (A[i] == elem) {

				int v = A[p];

				A[p] = A[i];

				A[i] = v;

				p--;

			}

		}

		return p + 1;
	}

	public static void main(String[] args) {

		RemoveElement re = new RemoveElement();

		int[] a = { 1,0,1 };
		System.out.println(re.removeElement(a, 1));

		for (int i : a) {
			System.out.print(i);
		}

		System.out.println();

	}

}
