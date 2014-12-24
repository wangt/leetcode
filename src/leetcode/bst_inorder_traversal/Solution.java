package leetcode.bst_inorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

	public List<Integer> inorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode cur = root;

		while (!stack.isEmpty() || cur != null) {

			if (cur != null) {

				stack.push(cur);
				cur = cur.left;

			} else {

				cur = stack.pop();

				result.add(cur.val);

				cur = cur.right;

			}
		}

		return result;

	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), null),
				null);

		System.out.println(solution.inorderTraversal(root));

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode(int x, TreeNode ln, TreeNode rn) {
			val = x;
			left = ln;
			right = rn;
		}
	}
}