package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 * 
 * @author wangt
 *
 */
public class RecoverBinarySearchTree {

	public void recoverTree(TreeNode root) {

		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		List<TreeNode> swappedNodes = new ArrayList<TreeNode>();

		Set<TreeNode> visitedNode = new HashSet<TreeNode>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.add(root);

		TreeNode preNode = null;

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			// System.out.println("Pop " + node.val);

			if (!visitedNode.contains(node) && node.left != null) {

				stack.push(node);
				// System.out.println("Push " + node.val);
				stack.push(node.left);
				// System.out.println("Push " + node.left.val);

				visitedNode.add(node);

				continue;

			}

			if (preNode != null && preNode.val > node.val) {
				swappedNodes.add(preNode);
				swappedNodes.add(node);

			}

			preNode = node;

			// System.out.println("PreNode is " + preNode.val);

			if (node.right != null) {

				stack.push(node.right);
			}

		}

		// for(TreeNode node:swappedNodes){
		// System.out.println(node.val);
		// }

		int val = swappedNodes.get(0).val;

		swappedNodes.get(0).val = swappedNodes.get(swappedNodes.size() - 1).val;

		swappedNodes.get(swappedNodes.size() - 1).val = val;

//		 System.out.println(swappedNodes.get(0).val + ","
//		 + swappedNodes.get(swappedNodes.size() - 1).val);

	}

	public static void main(String[] args) {

		RecoverBinarySearchTree solution = new RecoverBinarySearchTree();

		// TreeNode root = new TreeNode(4, new TreeNode(1, null, null),
		// new TreeNode(5, null, new TreeNode(2, null, null)));

		// TreeNode root = new TreeNode(0, new TreeNode(1, null, null), null);

		TreeNode root = new TreeNode(2, new TreeNode(3, null, null),
				new TreeNode(1, null, null));

		solution.recoverTree(root);

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
