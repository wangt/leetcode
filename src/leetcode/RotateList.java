package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author wangt
 *
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {

		if (head == null || head.next == null || n == 0) {
			return head;
		}

		ListNode h1 = head;

		ListNode h2 = head;

		int counter = 1;

		while (h2.next != null) {

			h2 = h2.next;
			counter++;
		}

		n = n % counter;

		if (n == 0) {
			return head;
		}

		h2 = head;
		counter = 1;

		while (h2.next != null) {

			h2 = h2.next;

			counter++;

			if (counter > n + 1) {
				h1 = h1.next;
			}

		}

		if (h1.next == null) {
			return head;
		}

		ListNode newHead = h1.next;

		ListNode cur = newHead;

		h1.next = null;

		while (cur.next != null) {
			cur = cur.next;
		}

		cur.next = head;

		return newHead;

	}

	public static void main(String[] args) {

		RotateList rl = new RotateList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		ListNode newHead = rl.rotateRight(head, 4);

		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}

	}

}
