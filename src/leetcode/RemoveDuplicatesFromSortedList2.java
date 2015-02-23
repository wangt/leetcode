package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author wangt
 *
 */
public class RemoveDuplicatesFromSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = new ListNode(0);

		ListNode cur = newHead;

		ListNode pre = head;

		head = head.next;

		int dups = 0;

		while (head != null) {

			if (head.val == pre.val) {
				dups++;
			} else {

				if (dups == 0) {
					cur.next = pre;
					cur = cur.next;
					cur.next = null;
				}

				pre = head;
				dups = 0;

			}

			head = head.next;
		}

		if (dups == 0) {
			cur.next = pre;
		}

		return newHead.next;

	}

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList2 rd = new RemoveDuplicatesFromSortedList2();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);

		head = rd.deleteDuplicates(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
}
