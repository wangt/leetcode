package leetcode;

/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author wangt
 *
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode h = new ListNode(0);

		h.next = head;

		ListNode newHead = h;

		while (h.next != null) {

			ListNode n1 = h.next;

			ListNode n2 = n1.next;

			if (n2 == null) {
				break;
			}

			n1.next = n2.next;

			n2.next = n1;

			h.next = n2;

			h = n1;

		}

		return newHead.next;

	}

	public static void main(String[] args) {

		SwapNodesInPairs swap = new SwapNodesInPairs();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode h2 = swap.swapPairs(head);

		while (h2 != null) {
			System.out.println(h2.val);
			h2 = h2.next;
		}

	}
}
