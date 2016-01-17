package leetcode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		int i = 1;
		ListNode cur = head;
		ListNode oddTail = head;

		while (cur != null && cur.next != null) {
			if (++i % 2 != 0) {
				ListNode next = cur.next.next;
				ListNode newOddTail = cur.next;
				insertTo(cur, cur.next, oddTail);
				oddTail = newOddTail;
				cur = next;
				i++;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

	private void insertTo(ListNode prev, ListNode node, ListNode newPrevNode) {
		prev.next = node.next;
		node.next = null;
		ListNode oldNext = newPrevNode.next;
		newPrevNode.next = node;
		node.next = oldNext;
	}

	public static void main(String[] args) {
		OddEvenLinkedList el = new OddEvenLinkedList();

		ListNode head = new ListNode(1);
		ListNode cur = head;
		int i = 1;
		while (++i < 9) {
			ListNode node = new ListNode(i);
			cur.next = node;
			cur = node;
		}

		ListNode odd = el.oddEvenList(head);
		while (odd != null) {
			System.out.println(odd.val);
			odd = odd.next;
		}
	}
}
