package leetcode;

/**
 * 
 * Please refer to
 * https://oj.leetcode.com/discuss/10924/share-my-code-with-o-n-time
 * -and-o-1-space
 * 
 * and
 * 
 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 * 
 * @author wangt
 *
 */
public class ConvertSortedListToBST {

	private ListNode cur;

	private int countList(ListNode head) {

		int n = 1;
		while (head.next != null) {
			n++;
			head = head.next;
		}

		return n;

	}

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		cur = head;

		return sortedListToBST(countList(head));

	}

	public TreeNode sortedListToBST(int n) {

		if (n == 0) {
			return null;
		}

		TreeNode node = new TreeNode(0);

		node.left = sortedListToBST(n / 2);

		node.val = cur.val;

		cur = cur.next;

		node.right = sortedListToBST(n - n / 2 - 1);

		return node;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
