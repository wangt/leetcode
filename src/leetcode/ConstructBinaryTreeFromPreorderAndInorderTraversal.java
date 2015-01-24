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
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);

		if (preorder.length == 1) {
			return root;
		}

		// key: val, value: index
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i], i);
		}

		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, indexMap);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend,
			Map<Integer, Integer> indexMap) {

		TreeNode root = new TreeNode(preorder[pstart]);

		int idx = indexMap.get(root.val);

		int leftnodes = idx - istart;

		if (leftnodes > 0) {

			root.left = buildTree(preorder, inorder, pstart + 1, pstart + leftnodes, istart, idx - 1, indexMap);
		}

		int rightnodes = iend - idx;

		if (rightnodes > 0) {
			root.right = buildTree(preorder, inorder, pend - rightnodes + 1, pend, idx + 1, iend, indexMap);
		}

		return root;
	}
}
