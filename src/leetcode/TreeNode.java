package leetcode;

public class TreeNode {
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

	public String toString() {
		return val + "";
	}
}