package leetcode;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author wangt
 *
 */
public class FlattenBinaryTreeToLinkedListInPlace {
	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		flattenToList(root);

	}

	public TreeNode flattenToList(TreeNode head) {

		if (head.left == null && head.right == null) {
			return head;
		}

		TreeNode right = head.right;

		TreeNode left = head.left;

		head.right = null;
		head.left = null;

		TreeNode tail = head;

		if (left != null) {
			TreeNode leftTail = flattenToList(left);
			tail.right = left;
			tail = leftTail;

		}

		if (right != null) {
			
			TreeNode rightTail = flattenToList(right);

			tail.right = right;

			tail = rightTail;

		}

		return tail;
	}

	public static void main(String[] args) {

		FlattenBinaryTreeToLinkedListInPlace bbt = new FlattenBinaryTreeToLinkedListInPlace();

		// TreeNode root = new TreeNode(2, new TreeNode(3, null, new TreeNode(1,
		// null, null)), new TreeNode(4, null, null));

		TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);

		bbt.flatten(root);
		
//		while (root != null) {
//			System.out.println(root.val);
//			root = root.left;
//		}
		
		
//		while (root != null) {
//			System.out.println(root.val);
//			root = root.right;
//		}

	}
}
