package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author wangt
 *
 */
public class Combinations {

	public List<List<Integer>> combine(int n, int k) {

		if (n == 0 || k == 0) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		DFS(result, n, 1, k, new Stack<Integer>());

		return result;

	}

	private void DFS(List<List<Integer>> result, int n, int i, int k, Stack<Integer> stack) {

		if (stack.size() == k) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}

		if (i > n) {
			return;
		}

		for (int j = i; j <= n; j++) {
			stack.push(j);
			DFS(result, n, j + 1, k, stack);
			stack.pop();
		}

	}
}
