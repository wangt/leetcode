package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leetcode.MiniumDepthOfBinaryTree.TreeNode;

public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int pathSum = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode cur = root;

		TreeNode pre = null;

		while (!stack.isEmpty() || cur != null) {

			while (cur != null) {

				stack.push(cur);

				pathSum += cur.val;

				cur = cur.left;

			}

			cur = stack.peek();

			if (cur.left == null && cur.right == null && pathSum == sum) {

				List<Integer> path = new ArrayList<Integer>();

				for (TreeNode n : stack) {
					path.add(n.val);
				}

				result.add(path);

			}

			if (cur.right != null && cur.right != pre) {

				cur = cur.right;

			} else {

				stack.pop();

				pathSum -= cur.val;

				pre = cur;

				cur = null;

			}

		}

		return result;

	}

	public static void main(String[] args) {

		PathSum2 solution = new PathSum2();

		// TreeNode root = new TreeNode(4, new TreeNode(1, null, null),
		// new TreeNode(5, null, new TreeNode(2, null, null)));

		// TreeNode root = new TreeNode(0, null, new TreeNode(1, null, null));

		TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null,
				null), null), new TreeNode(5, null, null));

		System.out.println(solution.pathSum(root, 7));

	}
}
