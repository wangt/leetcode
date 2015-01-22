package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author wangt
 *
 */
public class BinaryTreePreorderTraversalWithoutRecursion {

	public List<Integer> preorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		List<Integer> result = new ArrayList<Integer>();

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			result.add(node.val);

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}

		}

		return result;

	}

}
