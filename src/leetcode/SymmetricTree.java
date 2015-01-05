package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/symmetric-tree/
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * @author wangt
 *
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return false;
		}

		return isSymmetric(root.left, root.right);

	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {

		if (left != null ^ right != null) {
			return false;
		}

		if (left == null && right == null) {
			return true;
		}

		if (left.val != right.val) {
			return false;
		}

		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

}
