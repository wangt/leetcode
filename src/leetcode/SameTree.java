package leetcode;

/**
 * https://oj.leetcode.com/problems/same-tree/
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @author wangt
 *
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}

		if (p != null && q != null) {
			if (p.val == q.val) {
				if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
					return true;
				}
			}
		}

		return false;

	}
}
