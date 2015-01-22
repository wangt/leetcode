package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * There two ways to solve this problem, one is
 * https://oj.leetcode.com/discuss/9736
 * /accepted-code-with-explaination-does-anyone-have-better-idea
 * 
 * the other is https://oj.leetcode.com/discuss/13186/one-stack-accepted
 * 
 * @author wangt
 *
 */
public class BinaryTreePostorderTraversalWithoutRecursion {

	public List<Integer> postorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		LinkedList<Integer> result = new LinkedList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			result.addFirst(node.val);

			if (node.left != null) {
				stack.push(node.left);
			}

			if (node.right != null) {
				stack.push(node.right);
			}
		}

		return result;

	}

}
