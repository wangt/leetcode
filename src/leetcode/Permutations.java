package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * https://oj.leetcode.com/problems/permutations/
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author wangt
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] num) {

		if (num == null || num.length == 0) {
			return Collections.emptyList();
		}

		Set<Integer> numList = new HashSet<Integer>();

		for (int i : num) {
			numList.add(i);
		}

		Integer[] nums = numList.toArray(new Integer[0]);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		dfs(result, nums, new Stack<Integer>(), new HashSet<Integer>());

		return result;

	}

	/*
	 * Actually there is no need to use a Set to maintain which records have
	 * been visted.
	 * 
	 * https://oj.leetcode.com/discuss/18212/my-elegant-recursive-c-solution-with
	 * -inline-explanation
	 */
	private void dfs(List<List<Integer>> result, Integer[] num, Stack<Integer> stack, Set<Integer> indexSet) {

		if (indexSet.size() == num.length) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}

		for (int j = 0; j < num.length; j++) {

			if (indexSet.contains(j)) {
				continue;
			}

			stack.add(num[j]);
			indexSet.add(j);

			dfs(result, num, stack, indexSet);

			indexSet.remove(j);
			stack.pop();

		}

	}

	public static void main(String[] args) {

		Permutations permutations = new Permutations();
		List<List<Integer>> result = permutations.permute(new int[] { 1, 1, 2 });

		for (List<Integer> r : result) {
			for (int i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
