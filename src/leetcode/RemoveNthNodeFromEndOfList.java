package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * @author wangt
 *
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode h1 = head;
		ListNode h2 = head;

		int i = 0;

		while (i < n && h2 != null) {
			h2 = h2.next;
			i++;
		}

		if (h2 == null) {
			// remove 1st
			// 1 2
			head = head.next;

		} else {
			while (h2.next != null) {
				h2 = h2.next;
				h1 = h1.next;
			}
			h1.next = h1.next.next;
		}

		return head;

	}

	public static void main(String[] args) {

		RemoveNthNodeFromEndOfList rn = new RemoveNthNodeFromEndOfList();

		ListNode head = new ListNode(1);

		head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);

		head = rn.removeNthFromEnd(head, 3);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}
