package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author wangt
 *
 */
public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		List<TreeNode> levelNodes = new ArrayList<TreeNode>();

		levelNodes.add(root);

		while (levelNodes != null && !levelNodes.isEmpty()) {

			List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();

			List<Integer> levelResult = new ArrayList<Integer>();

			for (TreeNode node : levelNodes) {

				levelResult.add(node.val);

				if (node.left != null) {
					nextLevelNodes.add(node.left);
				}

				if (node.right != null) {
					nextLevelNodes.add(node.right);
				}

			}

			result.addFirst(levelResult);

			levelNodes = nextLevelNodes;

		}

		return result;

	}

	public static void main(String[] args) {

		BinaryTreeLevelOrderTraversal2 btt = new BinaryTreeLevelOrderTraversal2();

		TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null),
				new TreeNode(7, null, null)));

		List<List<Integer>> result = btt.levelOrderBottom(root);

		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}
