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

		ListNode preNode = head;
		int dups = 1;
		head = head.next;

		while (head != null) {

			if (preNode.val == head.val) {
				dups++;
			} else {
				if (dups == 1) {
					cur.next = preNode;
					cur = preNode;
					cur.next = null;
				}

				preNode = head;
				dups = 1;
			}

			head = head.next;

		}

		if (dups == 1) {
			cur.next = preNode;
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
