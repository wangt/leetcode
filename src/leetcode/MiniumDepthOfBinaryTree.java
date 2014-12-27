package leetcode;

import java.util.LinkedList;

/**
 *  A recursion version
 *  https://oj.leetcode.com/discuss/14688/my-simple-java-recursive-solution
 * 
 * @author wangt
 *
 */
public class MiniumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int depth = 0;

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();

		list.offer(root);

		TreeNode lastNodePerDepth = root;

		while (!list.isEmpty()) {

			TreeNode node = list.poll();

			if (node.left == null && node.right == null) {
				depth++;
				break;
			}

			if (node.left != null) {
				list.offer(node.left);
			}

			if (node.right != null) {
				list.offer(node.right);
			}

			if (node == lastNodePerDepth) {
				depth++;
				lastNodePerDepth = list.peekLast();
			}

		}

		return depth;

	}

	public static void main(String[] args) {

		MiniumDepthOfBinaryTree solution = new MiniumDepthOfBinaryTree();

		// TreeNode root = new TreeNode(4, new TreeNode(1, null, null),
		// new TreeNode(5, null, new TreeNode(2, null, null)));

		// TreeNode root = new TreeNode(0, null, new TreeNode(1, null, null));

		TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null,
				null), null), new TreeNode(5, null, null));

		System.out.println(solution.minDepth(root));

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode(int x, TreeNode ln, TreeNode rn) {
			val = x;
			left = ln;
			right = rn;
		}
	}
}
