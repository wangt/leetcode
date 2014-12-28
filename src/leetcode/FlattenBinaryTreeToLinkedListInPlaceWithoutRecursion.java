package leetcode;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Refer to https://oj.leetcode.com/discuss/13054/share-my-simple-non-recursive-
 * solution-o-1-space-complexity
 * 
 * @author wangt
 *
 */
public class FlattenBinaryTreeToLinkedListInPlaceWithoutRecursion {
	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		TreeNode cur = root;

		while (cur != null) {

			if (cur.left == null) {

				System.out.println(cur.val);

				cur = cur.right;

				continue;

			}

			// find precedent

			TreeNode pre = cur.left;

			// while (pre.right != null && pre.right != cur) {
			while (pre.right != null && pre.right != cur) {

				pre = pre.right;

			}

			pre.right = cur.right;

			cur.right = cur.left;

			cur.left = null;

			cur = cur.right;

			// if (pre.right != cur) {
			// pre.right = cur;
			// System.out.println(cur.val);
			// cur = cur.left;
			// } else {
			// cur = cur.right;
			// }

		}

	}

	public static void main(String[] args) {

		FlattenBinaryTreeToLinkedListInPlaceWithoutRecursion bbt = new FlattenBinaryTreeToLinkedListInPlaceWithoutRecursion();

		// TreeNode root = new TreeNode(2, new TreeNode(3, null, new TreeNode(1,
		// null, null)), new TreeNode(4, null, null));

		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3,
				null, null)),
				new TreeNode(4, new TreeNode(5, null, null), null));

		bbt.flatten(root);

		// while (root != null) {
		// System.out.println(root.val);
		// root = root.left;
		// }

		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}

	}
}
