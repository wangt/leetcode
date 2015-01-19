package leetcode;

/**
 * https://oj.leetcode.com/problems/reorder-list/
 * 
 * @author wangt
 *
 */
public class ReorderList {

	public void reorderList(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		// find mid

		ListNode fast = head;

		ListNode slow = head;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;

			slow = slow.next;

		}

		ListNode mid = slow;

//		System.out.println("mid=" + mid.val);

		// reverse right

		ListNode cur = mid.next;

		mid.next = null;

		ListNode right = null;

		while (cur != null) {

			ListNode next = cur.next;

			cur.next = right;

			right = cur;

			cur = next;

		}

//		System.out.println("right");

		ListNode rightNode = right;

		while (rightNode != null) {
//			System.out.println(rightNode.val);
			rightNode = rightNode.next;
		}
		
//		System.out.println("start merge");

		// merge

		ListNode newHead = new ListNode(0);

		cur = newHead;

		while (head != null || right != null) {
			cur.next = head;
			cur = cur.next;
			head = head.next;

			if (right != null) {
				cur.next = right;
				cur = cur.next;
				right = right.next;
			}

		}

		newHead.next = null;

	}

	public static void main(String[] args) {

		ReorderList rl = new ReorderList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		rl.reorderList(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
