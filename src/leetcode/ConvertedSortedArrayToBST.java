package leetcode;

public class ConvertedSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] num) {

		if (num == null || num.length == 0) {
			return null;
		}

		return sortedArrayToBST(num, 0, num.length - 1);

	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {

		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;

		TreeNode node = new TreeNode(num[mid]);

		if (start == end) {
			node.left = null;
			node.right = null;
		} else {
			node.left = sortedArrayToBST(num, start, mid - 1);
			node.right = sortedArrayToBST(num, mid + 1, end);
		}

		return node;

	}

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		ConvertedSortedArrayToBST bst = new ConvertedSortedArrayToBST();

		TreeNode root = bst.sortedArrayToBST(new int[] { 1, 3 });

		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);

	}
}
