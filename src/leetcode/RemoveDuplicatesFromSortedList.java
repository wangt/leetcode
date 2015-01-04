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

		ListNode cur1 = head;

		ListNode cur2 = head;

		ListNode pre = head;

		while (cur2.next != null) {

			cur2 = cur2.next;

			if (pre == null || cur2.val != pre.val) {

				cur1.next = cur2;
				cur1 = cur2;

				pre = cur2;
			}
		}

		cur1.next = null;

		return head;

	}

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();

		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);

		head = rd.deleteDuplicates(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
}
