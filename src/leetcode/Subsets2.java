package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/subsets-ii/
 * 
 * @author wangt
 *
 */
public class Subsets2 {

	public List<List<Integer>> subsetsWithDup(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(num);

		Stack<Integer> stack = new Stack<Integer>();

		dfs(result, num, 0, stack);

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

			while (i < cans.length - 1 && cans[i + 1] == cans[i]) {
				++i;
			}

		}

	}

	public static void main(String[] args) {
		Subsets2 subset = new Subsets2();

		List<List<Integer>> result = subset
				.subsetsWithDup(new int[] { 1, 2, 2 });

		for (List<Integer> r : result) {
			System.out.println(r);
		}

	}
}
