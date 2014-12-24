package leetcode.bst_inorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution_with_visited_map {

	public List<Integer> inorderTraversal(TreeNode root) {
		
		if(root == null){
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		Set<TreeNode> visited = new HashSet<TreeNode>();
		

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			if (!visited.contains(node) && node.left != null) {
				visited.add(node);
				stack.push(node);
				stack.push(node.left);
				continue;
			}

			result.add(node.val);

			if (node.right != null) {
				stack.push(node.right);
				continue;
			}

		}

		return result;

	}

	public static void main(String[] args) {

		Solution_with_visited_map solution = new Solution_with_visited_map();

		TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), null),
				null);

		System.out.println(solution.inorderTraversal(root));

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