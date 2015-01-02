package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author wangt
 *
 */
public class MergeKSortedListsUsingHeap {

	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.isEmpty()) {
			return null;
		}

		List<ListNode> nodeList = new ArrayList<ListNode>();
		for (ListNode ln : lists) {
			if (ln != null) {
				nodeList.add(ln);
			}
		}

		ListNode[] heap = nodeList.toArray(new ListNode[0]);

		ListNode head = null;

		ListNode cur = null;

		int start = 0;

		while (start <= heap.length - 1) {

			buildHeap(heap, start);

			ListNode minNode = heap[start];

			if (minNode.next != null) {
				heap[start] = minNode.next;
			} else {
				heap[start] = null;
				start++;
			}

			if (head == null) {
				head = minNode;
				cur = head;
			} else {
				cur.next = minNode;
				cur = minNode;
			}

			// break;

		}

		return head;
	}

	private void buildHeap(ListNode[] nodes, int start) {

		if (nodes.length - start == 1) {
			return;
		}

		for (int i = (nodes.length - start) / 2 - 1; i >= 0; i--) {

			int left = 2 * (i + 1) + start - 1;
			int right = left + 1;

			int originMin = i + start;

			int min = originMin;

			if (left < nodes.length && nodes[left].val < nodes[min].val) {
				min = left;
			}

			if (right < nodes.length && nodes[right].val < nodes[min].val) {
				min = right;
			}

			if (min != originMin) {
				ListNode n = nodes[originMin];
				nodes[originMin] = nodes[min];
				nodes[min] = n;
			}

		}
	}

	public static void main(String[] args) {
		MergeKSortedListsUsingHeap mks = new MergeKSortedListsUsingHeap();

		ListNode h1 = new ListNode(3);
		h1.next = new ListNode(5);

		ListNode h3 = new ListNode(-1);
		h3.next = new ListNode(12);
		h3.next.next = new ListNode(20);

		ListNode head = mks.mergeKLists(Arrays.asList(h1, h3));

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
