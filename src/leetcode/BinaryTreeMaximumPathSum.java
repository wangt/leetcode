package leetcode;

/**
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * @author wangt
 *
 */
public class BinaryTreeMaximumPathSum {

	private int max = Integer.MIN_VALUE;

	public int maxPathSum2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int l = maxPathSum2(root.left);
		int r = maxPathSum2(root.right);

		l = (l < 0 ? 0 : l);
		r = (r < 0 ? 0 : r);

		max = l + r + root.val > max ? l + r + root.val : max;

		return root.val + Math.max(r, l);

	}
	
	public int maxPathSum(TreeNode root){
		
		maxPathSum2(root);
		
		return this.max;
		
	}

}
