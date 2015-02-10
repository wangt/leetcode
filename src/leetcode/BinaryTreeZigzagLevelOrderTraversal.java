package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * @author wangt
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);

		boolean reverse = false;

		while (!nodes.isEmpty()) {

			List<TreeNode> nextNodes = new ArrayList<TreeNode>();

			LinkedList<Integer> valueList = new LinkedList<Integer>();

			for (TreeNode node : nodes) {

				if (reverse) {
					valueList.addFirst(node.val);
				} else {
					valueList.add(node.val);
				}

				if (node.left != null) {
					nextNodes.add(node.left);
				}

				if (node.right != null) {
					nextNodes.add(node.right);
				}
			}

			result.add(valueList);

			nodes = nextNodes;

			reverse = !reverse;

		}

		return result;

	}

}
