package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/4sum/
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ² b ² c ² d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * @author wangt
 *
 */
public class FourSum {

	public List<List<Integer>> fourSum(int[] num, int target) {

		if (num == null || num.length < 4) {
			return Collections.emptyList();
		}

		Arrays.sort(num);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i <= num.length - 4; i++) {

			while (i > 0 && i <= num.length - 4 && num[i] == num[i - 1]) {
				i++;
			}

			for (int j = i + 1; j <= num.length - 3; j++) {

				while (j > i+1 && j <= num.length - 3 && num[j] == num[j - 1]) {
					j++;
				}

				int k = j + 1;
				int m = num.length - 1;

				while (k < m) {

					int local = num[i] + num[j] + num[k] + num[m];

					if (local < target) {

						k++;

						while (k > 0 && k < num.length - 1 && num[k] == num[k - 1]) {
							k++;
						}

					} else if (local == target) {

						result.add(Arrays.asList(num[i], num[j], num[k], num[m]));

						k++;

						while (k > 0 && k < num.length - 1 && num[k] == num[k - 1]) {
							k++;
						}

						m--;

						while (m > num.length - 1 && m > 0 && num[m] == num[m + 1]) {
							m--;
						}

					} else if (local > target) {
						m--;

						while (m > num.length - 1 && m > 0 && num[m] == num[m + 1]) {
							m--;
						}
					}

				}

			}

		}

		return result;

	}

	public static void main(String[] args) {

		FourSum ts = new FourSum();

		List<List<Integer>> result = ts.fourSum(new int[] { 0, 0, 0, 0 }, 0);

		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
