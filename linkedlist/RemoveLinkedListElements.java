package linkedlist;
import tools.*;
// import java.util.*;

public class RemoveLinkedListElements {

	public ListNode remove(ListNode head, int target) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		// if pre.next is the last node
		// pre.next.next will be null
		while (pre != null && pre.next != null) {
			if (pre.next.value == target) {
				pre.next = pre.next.next;
			}else {			
				// should use else block
				// cannot skip the next node
				pre = pre.next;		
			}
		}

		return dummy.next;
	}
	public static void main(String[] args)
	{
		int[] A = {6, 4, 2, 6, 6, 6};
		ListNode head = ListNode.createLinkedList(A);

		RemoveLinkedListElements sol = new RemoveLinkedListElements();
		ListNode.printList(sol.remove(head, 6));

	}
}
