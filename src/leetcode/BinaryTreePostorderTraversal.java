package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author wangt
 *
 */
public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<Integer>();

		result.addAll(postorderTraversal(root.left));
		result.addAll(postorderTraversal(root.right));
		result.add(root.val);

		return result;

	}

}
