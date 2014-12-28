package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/combination-sum/
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ²
 * É ² ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 * 
 * @author wangt
 *
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, candidates, 0, new Stack<Integer>(), target);
		return result;

	}

	public void dfs(List<List<Integer>> result, int[] candidates, int index,
			Stack<Integer> combination, int target) {

		if (target == 0) {

			result.add(new ArrayList<Integer>(combination));

			return;
		}

		for (int i = index; i < candidates.length; i++) {

			int newTarget = target - candidates[i];

			if (newTarget >= 0) {

				combination.push(candidates[i]);
				dfs(result, candidates, i, combination, newTarget);
				combination.pop();

			} else {
				break;
			}

		}

	}

	public static void main(String[] args) {

		CombinationSum cs = new CombinationSum();

		List<List<Integer>> result = cs.combinationSum(
				new int[] { 2, 3, 6, 7 }, 7);

		for (List<Integer> r : result) {
			System.out.println(r);
		}

	}

}
