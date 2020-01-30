package linkedlist;
import tools.*;
// import java.util.*;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode ls1, ListNode ls2) {
		if (ls1 == null) {
			return ls2;
		}
		
		if (ls2 == null) {
			return ls1;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (ls1 != null && ls2 != null) {
			int sum = ls1.value + ls2.value + carry;    
			int val = sum % 10;
			carry = sum / 10;
			
			ListNode curVal = new ListNode(val);
			cur.next = curVal;
			
			ls1 = ls1.next;
			ls2 = ls2.next;
			cur = cur.next;
		}
		
		while (ls1 != null) {
			int sum = ls1.value + carry;
			int val = sum % 10;
			carry = sum / 10;
			
			ListNode curVal = new ListNode(val);
			cur.next = curVal;
			
			ls1 = ls1.next;
			cur = cur.next;
		}
		
		while (ls2 != null) {
			int sum = ls2.value + carry;
			int val = sum % 10;
			carry = sum / 10;
			
			ListNode curVal = new ListNode(val);
			cur.next = curVal;
			
			ls2 = ls2.next;
			cur = cur.next;
		}
		
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		
		return dummy.next;
	}

	public static void main(String[] args)
	{
		// 999
		// 1
		// 0001
		int[] A = {9, 9, 9};
		int[] B = {1};
		ListNode ls1 = ListNode.createLinkedList(A);
		ListNode ls2 = ListNode.createLinkedList(B);

		AddTwoNumbers sol = new AddTwoNumbers();
		ListNode.printList(sol.addTwoNumbers(ls1, ls2));

	}
}
