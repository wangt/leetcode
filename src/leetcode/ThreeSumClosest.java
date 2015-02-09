package leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/3sum-closest/
 * 
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author wangt
 *
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);

		Integer sum = null;

		for (int i = 0; i < num.length; i++) {

			int j = i + 1;

			int k = num.length - 1;

			while (j < k) {

				int s = num[i] + num[j] + num[k];

				if (s < target) {
					j++;
				} else if (s == target) {
					return target;
				} else if (s > target) {
					k--;
				}

				if (sum == null || Math.abs(sum - target) > Math.abs(s - target)) {
					sum = s;
				}

			}

		}

		return sum;

	}

	public static void main(String[] args) {

		ThreeSumClosest ts = new ThreeSumClosest();

		System.out.println(ts.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));

	}
}
