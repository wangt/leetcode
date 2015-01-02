package leetcode;

/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author wangt
 *
 */
public class MergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode head = null;

		ListNode cur = null;

		while (l1 != null && l2 != null) {

			ListNode next = null;

			if (l1.val < l2.val) {
				next = l1;
				l1 = l1.next;
			} else {
				next = l2;
				l2 = l2.next;
			}

			if (head == null) {
				head = next;
				cur = next;
			} else {
				cur.next = next;
				cur = next;
			}

		}

		cur.next = l1 != null ? l1 : l2;

		return head;

	}

	public static void main(String[] args) {

		MergeTwoSortedList mks = new MergeTwoSortedList();

		ListNode h1 = new ListNode(-1);
		h1.next = new ListNode(5);
		h1.next.next = new ListNode(11);

		ListNode h2 = new ListNode(6);
		h2.next = new ListNode(10);
		h2.next.next = new ListNode(12);

		ListNode head = mks.mergeTwoLists(h1, h2);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
