package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/3sum/
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ²
 * b ² c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author wangt
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {

		if (num == null || num.length < 3) {
			return Collections.emptyList();
		}

		Arrays.sort(num);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < num.length - 2; i++) {

			int j = i + 1, k = num.length - 1;

			while (j < k) {

				int local = num[j] + num[k] + num[i];

				if (local < 0) {

					while (j < num.length - 1 && num[j] == num[j + 1]) {
						j++;
					}

					j++;

				} else if (local > 0) {

					while (k > i && num[k] == num[k - 1]) {
						k--;
					}
					k--;

				} else {

					result.add(Arrays.asList(num[i], num[j], num[k]));

					while (j < num.length - 1 && num[j] == num[j + 1]) {
						j++;
					}
					j++;
					while (k > i && num[k] == num[k - 1]) {
						k--;
					}
					k--;
				}

			}

			while (i < num.length - 2 && num[i] == num[i + 1]) {
				i++;
			}

		}

		return result;

	}

	public static void main(String[] args) {

		ThreeSum ts = new ThreeSum();

		List<List<Integer>> result = ts.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });

		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}
