package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/combination-sum-ii/
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ²
 * É ² ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * https://oj.leetcode.com/discuss/12093/simple-solution-using-backtracking-
 * without-handle-duplicates
 * 
 * @author wangt
 *
 */
public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(num);

		dfs(result, num, 0, new Stack<Integer>(), target);

		return result;

	}

	public void dfs(List<List<Integer>> result, int[] cans, int index,
			Stack<Integer> stack, int target) {

		if (target == 0) {

			result.add(new ArrayList<Integer>(stack));

			return;
		}

		if (index >= cans.length) {
			return;
		}

		for (int i = index; i < cans.length; i++) {

			int newTarget = target - cans[i];

			if (newTarget >= 0) {

				stack.push(cans[i]);

				dfs(result, cans, i + 1, stack, newTarget);

				stack.pop();

			} else {
				break;
			}

			// https://oj.leetcode.com/discuss/12093/simple-solution-using-backtracking-without-handle-duplicates
			while (i < cans.length - 1 && cans[i + 1] == cans[i]) {
				++i;
			}

		}

	}

	public static void main(String[] args) {

		CombinationSum2 cs = new CombinationSum2();

		List<List<Integer>> result = cs.combinationSum2(new int[] { 10, 1, 2,
				7, 6, 1, 5 }, 8);

		for (List<Integer> r : result) {
			System.out.println(r);
		}

	}
}
