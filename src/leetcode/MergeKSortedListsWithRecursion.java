package leetcode;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedListsWithRecursion {

	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.isEmpty()) {
			return null;
		}

		if (lists.size() == 1) {
			return lists.get(0);
		}

		int mid = (lists.size() - 1) / 2;

		ListNode h1 = mergeKLists(lists.subList(0, mid+1));
		ListNode h2 = mergeKLists(lists.subList(mid+1, lists.size()));

		return mergeTwo(h1, h2);

	}

	public ListNode mergeTwo(ListNode h1, ListNode h2) {

		if (h1 == null || h2 == null) {

			return h1 == null ? h2 : h1;
		}

		ListNode head = null;

		ListNode cur = null;

		while (h1 != null && h2 != null) {

			ListNode next = null;

			if (h1.val < h2.val) {
				next = h1;
				h1 = h1.next;
			} else {
				next = h2;
				h2 = h2.next;
			}

			if (head == null) {
				head = next;
				cur = head;
			} else {
				cur.next = next;
				cur = next;
			}

		}

		if (h1 != null) {
			cur.next = h1;
		} else {
			cur.next = h2;
		}

		return head;
	}

	public static void main(String[] args) {

		MergeKSortedListsWithRecursion mks = new MergeKSortedListsWithRecursion();

		ListNode h1 = new ListNode(-1);
		h1.next = new ListNode(5);
		h1.next.next = new ListNode(11);

		ListNode h2 = new ListNode(6);
		h2.next = new ListNode(10);

		ListNode head = mks.mergeKLists(Arrays.asList(null, h1, null, h2));

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
