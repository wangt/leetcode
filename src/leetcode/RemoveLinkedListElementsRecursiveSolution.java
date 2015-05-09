package leetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Another solution:
 * https://leetcode.com/discuss/33142/iterative-short-java-solution
 * 
 * @author wangt
 *
 */
public class RemoveLinkedListElementsRecursiveSolution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode newHead = null;
		ListNode curr1 = null;
		ListNode curr2 = head;

		while (curr2 != null) {

			if (curr2.val == val) {
				curr2 = curr2.next;
				continue;
			}

			if (curr1 != null) {
				curr1.next = curr2;
			}
			curr1 = curr2;
			curr2 = curr2.next;
			curr1.next = null;

			if (newHead == null) {
				newHead = curr1;
			}

		}
		return newHead;
	}
}
