package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3
 * 
 * @author wangt
 *
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p1 = head;

		ListNode p2 = head.next;

		p1.next = null;

		while (p2 != null) {

			if (p2.val != p1.val) {
				p1.next = p2;
				p1 = p2;
			}

			p2 = p2.next;

			p1.next = null;

		}

		return head;
	}

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();

		ListNode head = new ListNode(1);
		// head.next = new ListNode(1);
		// head.next.next = new ListNode(2);

		head = rd.deleteDuplicates(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
}
