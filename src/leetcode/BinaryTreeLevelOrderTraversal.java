package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * @author wangt
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		queue.add(null);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> levellist = new ArrayList<Integer>();

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node != null) {

				levellist.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			} else {
				result.add(levellist);
				levellist = new ArrayList<Integer>();
				if (queue.size() > 0) {
					queue.add(null);
				}
			}

		}

		if (levellist.size() > 0) {
			result.add(levellist);
		}

		return result;

	}

	public static void main(String[] args) {

		BinaryTreeLevelOrderTraversal btt = new BinaryTreeLevelOrderTraversal();

		TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null),
				new TreeNode(7, null, null)));

		List<List<Integer>> result = btt.levelOrder(root);

		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}
