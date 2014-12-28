package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author wangt
 *
 */
public class BalancedBinaryTreeWithoutRecursion {

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode cur = root;

		TreeNode pre = null;

		Map<TreeNode, Integer> heights = new HashMap<TreeNode, Integer>();

		while (!stack.isEmpty() || cur != null) {

			while (cur != null) {

				stack.push(cur);
				cur = cur.left;

			}

			cur = stack.peek();

			if (cur.right != null && cur.right != pre) {

				cur = cur.right;

			} else {

				int lheight = 0, rheight = 0;

				if (cur.left != null) {

					if (heights.containsKey(cur.left)) {
						lheight = heights.get(cur.left);
					}

				}

				if (cur.right != null) {
					if (heights.containsKey(cur.right)) {
						rheight = heights.get(cur.right);
					}
				}

				if (Math.abs(lheight - rheight) > 1) {
					return false;
				}

				heights.put(cur, Math.max(lheight, rheight) + 1);

				stack.pop();

				pre = cur;

				cur = null;

			}

		}

		return true;

	}

	public static void main(String[] args) {

		BalancedBinaryTreeWithRecursion bbt = new BalancedBinaryTreeWithRecursion();

		TreeNode root = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(1, null,
				null));

		System.out.println(bbt.isBalanced(root));

	}

}
