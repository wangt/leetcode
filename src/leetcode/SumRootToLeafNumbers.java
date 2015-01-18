package leetcode;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * @author wangt
 *
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {

		return sumNumbers(root, 0);

	}

	public int sumNumbers(TreeNode root, int x) {
		if (root == null) {
			return 0;
		}

		x = x * 10 + root.val;

		if (root.left == null && root.right == null) {
			return x;
		}

		return sumNumbers(root.left, x) + sumNumbers(root.right, x);

	}
}
