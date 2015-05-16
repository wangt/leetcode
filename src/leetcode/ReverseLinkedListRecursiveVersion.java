package leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Reverse a singly linked list.
 * 
 * Solution:
 * https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-
 * java-solution
 * 
 * @author wangt
 *
 */
public class ReverseLinkedListRecursiveVersion {

	private ListNode h = null;

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return head;
		}

		reverseList2(head);

		return h;
	}

	public ListNode reverseList2(ListNode head) {

		if (head.next == null) {
			h = head;
			return head;
		}

		ListNode tail = reverseList2(head.next);

		head.next = null;

		tail.next = head;

		return head;
	}
}
