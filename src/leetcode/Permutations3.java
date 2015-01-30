package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class Permutations3 {

	public List<List<Integer>> permuteUnique(int[] num) {

		if (num == null || num.length == 0) {
			return Collections.emptyList();
		}

		Set<Integer> numList = new HashSet<Integer>();

		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

		for (int i : num) {
			numList.add(i);

			Integer n = numMap.get(i);

			if (n == null) {
				n = 0;
			}
			numMap.put(i, n + 1);

		}

		Integer[] nums = numList.toArray(new Integer[0]);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		dfs(result, nums, num.length, new Stack<Integer>(), numMap);

		return result;

	}

	/*
	 * Actually there is no need to use a Set to maintain which records have
	 * been visted.
	 * 
	 * https://oj.leetcode.com/discuss/18212/my-elegant-recursive-c-solution-with
	 * -inline-explanation
	 */
	private void dfs(List<List<Integer>> result, Integer[] num, int length, Stack<Integer> stack,
			Map<Integer, Integer> numMap) {

		if (stack.size() == length) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}

		for (int j = 0; j < num.length; j++) {

			if (numMap.get(num[j]) == 0) {
				continue;
			}

			stack.add(num[j]);
			numMap.put(num[j], numMap.get(num[j]) - 1);

			dfs(result, num, length, stack, numMap);

			numMap.put(num[j], numMap.get(num[j]) + 1);
			stack.pop();

		}

	}

	public static void main(String[] args) {

		Permutations3 permutations = new Permutations3();
		List<List<Integer>> result = permutations.permuteUnique(new int[] { 1, 1, 2 });

		for (List<Integer> r : result) {
			for (int i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
