package leetcode;

/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * @author wangt
 *
 */
public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int n1 = count(headA);
		int n2 = count(headB);

		if (n1 > n2) {
			headA = skip(headA, n1 - n2);
		} else if (n1 < n2) {
			headB = skip(headB, n2 - n1);
		}

		while (headA != null && headB != null) {

			if (headA == headB) {
				return headA;
			}

			headA = headA.next;
			headB = headB.next;

		}

		return null;

	}

	public ListNode skip(ListNode head, int n) {
		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		return head;
	}

	private int count(ListNode head) {
		int n = 0;

		while (head != null) {
			n++;
			head = head.next;
		}
		return n;
	}

}
