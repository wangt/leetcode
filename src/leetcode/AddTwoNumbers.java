package leetcode;

/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author wangt
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode head = l1;

		ListNode preNode = null;

		int carry = 0;

		while (l1 != null || l2 != null) {

			ListNode cur = (l1 == null ? l2 : l1);

			int v1 = (l1 == null ? 0 : l1.val);
			int v2 = (l2 == null ? 0 : l2.val);

			cur.val = (v1 + v2 + carry) % 10;

			carry = (v1 + v2 + carry) / 10;

			if (preNode != null) {
				preNode.next = cur;
			}

			preNode = cur;

			l1 = (l1 == null ? null : l1.next);
			l2 = (l2 == null ? null : l2.next);
		}

		if (carry > 0) {
			preNode.next = new ListNode(carry);
		}

		return head;

	}

	public static void main(String[] args) {

		AddTwoNumbers an = new AddTwoNumbers();

		ListNode h1 = new ListNode(4);
		h1.next = new ListNode(2);

		ListNode h2 = new ListNode(6);
//		h2.next = new ListNode(7);
//		h2.next.next = new ListNode(1);

		ListNode r = an.addTwoNumbers(h1, h2);

		while (r != null) {
			System.out.print(r.val + " ");
			r = r.next;
		}

	}
}
