package leetcode;

import java.util.Stack;

public class BSTIterator {

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {

		stack = new Stack<TreeNode>();

		if (root != null) {
			visit(root);
		}
	}

	private void visit(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {

		TreeNode node = stack.pop();

		if (node.right != null) {
			visit(node.right);
		}

		return node.val;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(15, new TreeNode(13, null, null),
				new TreeNode(17, null, null)));

		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}
}
