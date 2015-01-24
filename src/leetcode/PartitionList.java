package leetcode;

/**
 * https://oj.leetcode.com/problems/partition-list/
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author wangt
 *
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = new ListNode(0);

		newHead.next = head;

		ListNode smallCur = newHead;

		ListNode pre = newHead;

		ListNode cur = head;

		while (cur != null) {

			ListNode next = cur.next;

			if (cur.val < x) {

				if (pre != newHead && pre.val >= x) {

					pre.next = cur.next;
					cur.next = smallCur.next;
					smallCur.next = cur;

				} else {
					pre = cur;
				}

				smallCur = cur;
				
			} else {
				pre = cur;
			}

			cur = next;
			
			printList(newHead.next);
			
			System.out.println("smallCur:"+smallCur.val+", pre:"+pre.val);

		}

		return newHead.next;

	}
	
	private void printList(ListNode head){
		while (head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {

		PartitionList pl = new PartitionList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		head = pl.partition(head, 4);

//		while (head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}

	}

}
