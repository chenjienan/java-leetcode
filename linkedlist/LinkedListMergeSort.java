package linkedlist;
import tools.*;

public class LinkedListMergeSort {
	public static void main(String[] args)
	{
		int[] A = {4,2, 6, 5};
		ListNode head = ListNode.createLinkedList(A);

		LinkedListMergeSort s = new LinkedListMergeSort();
		ListNode sortedHead = s.mergeSort(head);
		ListNode.printList(sortedHead);
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
		  return head;
		}
	
		ListNode midNode = findMidNode(head);
		ListNode secHalf = midNode.next;
		midNode.next = null;
	
		ListNode fstHalf = mergeSort(head);
		ListNode sndHalf = mergeSort(secHalf);
		head = merge(fstHalf, sndHalf);
	
		return head;
	}

	public ListNode findMidNode(ListNode head) {	
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
		  slow = slow.next;
		  fast = fast.next.next;
		}
		return slow;
	}

	public ListNode merge(ListNode one, ListNode two) {
		// Write your solution here
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
	
		while (one != null && two != null) {
		  
		  if (one.value < two.value){
			cur.next = one;
			one = one.next;
		  }else{
			cur.next = two;
			two = two.next;
		  }
		  cur = cur.next;
		}
	
		if (one != null) {
		  cur.next = one;
		}
		if (two != null) {
		  cur.next = two;
		}
	
		return dummy.next;
	}
}



