package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author wangt
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0
				|| postorder.length != inorder.length) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[0]);

		if (postorder.length == 1) {
			return root;
		}

		// key: val, value: index
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i], i);
		}

		return buildTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1, indexMap);

	}

	public TreeNode buildTree(int[] postorder, int[] inorder, int pstart, int pend, int istart, int iend,
			Map<Integer, Integer> indexMap) {

		TreeNode root = new TreeNode(postorder[pend]);

		int idx = indexMap.get(root.val);

		int leftnodes = idx - istart;

		if (leftnodes > 0) {

			root.left = buildTree(postorder, inorder, pstart, pstart + leftnodes - 1, istart, idx - 1, indexMap);
		}

		int rightnodes = iend - idx;

		if (rightnodes > 0) {
			root.right = buildTree(postorder, inorder, pend - rightnodes, pend - 1, idx + 1, iend, indexMap);
		}

		return root;
	}
}
