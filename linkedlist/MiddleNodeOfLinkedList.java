package linkedlist;
import tools.*;
// import java.util.*;

public class MiddleNodeOfLinkedList {

	public ListNode getMiddleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		// ood -> fast != null
		// even -> fast.next != null
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args)
	{
		int[] A = {4,2, 6, 5};
		ListNode head = ListNode.createLinkedList(A);

		MiddleNodeOfLinkedList sol = new MiddleNodeOfLinkedList();
		ListNode.printList(sol.getMiddleNode(head));

	}
}
