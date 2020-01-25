package linkedlist;
import tools.*;
// import java.util.*;

public class InsertInSortedLinkedList {

	public ListNode insert(ListNode head, int value) {

		if (head == null) {
			return new ListNode(value);
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		

		while (cur.next != null && cur.next.value < value) {
			cur = cur.next;
		}
		ListNode newNode = new ListNode(value);
		newNode.next = cur.next;
		cur.next = newNode;

		return dummy.next;
	}
	public static void main(String[] args)
	{
		int[] A = {1, 2, 3, 5};
		ListNode head = ListNode.createLinkedList(A);

		InsertInSortedLinkedList sol = new InsertInSortedLinkedList();
		ListNode.printList(sol.insert(head, 6));
	}
}
