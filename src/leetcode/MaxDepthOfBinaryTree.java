package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * An more simple recursion version. 
 * https://oj.leetcode.com/discuss/13341/simple-solution-using-java
 * 
 * public int maxDepth(TreeNode root) {
 * 	   if(root==null){
 *         return 0;
 *     }
 *     return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
 * }
 * 
 * A width first recursion version
 * 
 * https://oj.leetcode.com/discuss/13192/my-accepted-solution-in-java-without-recursion
 * 
 *   public int maxDepth(TreeNode root) {
 *   int depth = 0;
 *   if(root==null) return depth;
 *   LinkedList<TreeNode> list = new LinkedList<TreeNode>();
 *   list.offer(root); TreeNode levelLast = root;
 *   while(list.size()>0){
 *       TreeNode curr = list.poll();
 *       if(curr.left!=null) list.offer(curr.left);
 *       if(curr.right!=null) list.offer(curr.right);
 *       if(curr==levelLast) {
 *           levelLast = list.peekLast();
 *           depth++;
 *       }
 *   }
 *   return depth;
 * }
 * 
 */
public class MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int maxDepth = 0;

		int curDepth = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		Map<TreeNode, Integer> visited = new HashMap<TreeNode, Integer>();

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			if (!visited.containsKey(node)) {

				curDepth++;

				if (curDepth > maxDepth) {
					maxDepth = curDepth;
				}

				visited.put(node, curDepth);

				if (node.left != null) {
					stack.push(node);
					stack.push(node.left);
					continue;
				}

			}

			// do nothing for node
			curDepth = visited.get(node);

			if (node.right != null) {

				stack.push(node.right);

			}

		}

		return maxDepth;

	}

	public static void main(String[] args) {

		MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();

		// TreeNode root = new TreeNode(4, new TreeNode(1, null, null),
		// new TreeNode(5, null, new TreeNode(2, null, null)));

		// TreeNode root = new TreeNode(0, null, new TreeNode(1, null, null));

		TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null,
				null), null), null);

		System.out.println(solution.maxDepth(root));

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
