package leetcode;

import java.util.Stack;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode cur = root;

		TreeNode pre = null;

		int pathSum = 0;

		while (!stack.isEmpty() || cur != null) {

			while (cur != null) {

				stack.add(cur);

				pathSum += cur.val;

				cur = cur.left;

			}

			cur = stack.peek();

			if (cur.right == null && cur.left == null && pathSum == sum) {
				return true;
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

		return false;

	}

	public static void main(String[] args) {

		PathSum solution = new PathSum();

		// TreeNode root = new TreeNode(4, new TreeNode(1, null, null),
		// new TreeNode(5, null, new TreeNode(2, null, null)));

		// TreeNode root = new TreeNode(0, null, new TreeNode(1, null, null));

		TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null,
				null), null), new TreeNode(5, null, null));

		System.out.println(solution.hasPathSum(root, 6));

	}
}
