package leetcode;

/**
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author wangt
 *
 */
public class ValidBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer maxValue, Integer minValue) {

		if (root == null) {
			return true;
		}

		if (minValue != null && root.val <= minValue || maxValue != null && root.val >= maxValue) {
			return false;
		}

		if (root.left != null && root.left.val >= root.val) {
			return false;
		}

		if (root.right != null && root.right.val <= root.val) {
			return false;
		}

		return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);

	}

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2,
		// null, new TreeNode(3))), null);

		TreeNode root = new TreeNode(2147483647, null, null);

		ValidBinarySearchTree vb = new ValidBinarySearchTree();

		System.out.println(vb.isValidBST(root));

	}

}
