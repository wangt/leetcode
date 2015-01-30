package leetcode;

/**
 * https://oj.leetcode.com/problems/permutation-sequence/
 * 
 * The set [1,2,3,É,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author wangt
 *
 */
public class PermutationSequence {

	public String getPermutation(int n, int k) {
		
		k = k - 1;

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nums.length; i++) {

			int nn = n(n - 1);

			int c = k / nn;

			k = k % nn;

			n--;

			int counter = -1;
			for (int j = 0; j < nums.length; j++) {

				if (nums[j] == -1) {
					continue;
				}

				counter++;

				if (counter == c) {
					sb.append(nums[j]);
					nums[j] = -1;
					break;
				}
			}

		}

		return sb.toString();

	}

	private int n(int n) {

		int sum = 1;

		for (int i = 1; i <= n; i++) {
			sum = sum * i;
		}

		return sum;
	}
	
	public static void main(String[] args) {
		
		PermutationSequence ps = new PermutationSequence();
		
		System.out.println(ps.getPermutation(4, 24));
		
	}

}
