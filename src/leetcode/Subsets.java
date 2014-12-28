package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * https://oj.leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author wangt
 *
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] S) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(S);

		Stack<Integer> stack = new Stack<Integer>();

		dfs(result, S, 0, stack);

		return result;

	}

	public void dfs(List<List<Integer>> result, int[] cans, int index,
			Stack<Integer> stack) {

		result.add(new ArrayList<Integer>(stack));

		if (index >= cans.length) {
			return;
		}

		for (int i = index; i < cans.length; i++) {
			stack.push(cans[i]);
			dfs(result, cans, i + 1, stack);
			stack.pop();
		}

	}

	public static void main(String[] args) {
		Subsets subset = new Subsets();

		List<List<Integer>> result = subset.subsets(new int[] { 1, 2, 3 });

		for (List<Integer> r : result) {
			System.out.println(r);
		}

	}

}
