package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author wangt
 *
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<Integer>();

		result.add(root.val);
		result.addAll(preorderTraversal(root.left));
		result.addAll(preorderTraversal(root.right));

		return result;

	}

}
