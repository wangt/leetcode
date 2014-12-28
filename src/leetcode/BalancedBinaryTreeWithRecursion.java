package leetcode;

/**
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author wangt
 *
 */
public class BalancedBinaryTreeWithRecursion {

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);

	}

	public int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public static void main(String[] args) {

		BalancedBinaryTreeWithRecursion bbt = new BalancedBinaryTreeWithRecursion();

		TreeNode root = new TreeNode(2, new TreeNode(3, null, new TreeNode(1, null, null)),
				null);

		System.out.println(bbt.isBalanced(root));

	}
}
