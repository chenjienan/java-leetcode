package linkedlist;
import tools.*;
// import java.util.*;

public class ReverseLinkedList {

    public ListNode iterativeReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;

    }

    public ListNode recursiveReverse(ListNode head) {
         
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;       // to end the recursion
        return next;
    }
	public static void main(String[] args)
	{
		int[] A = {4,2, 6, 5};
		ListNode head = ListNode.createLinkedList(A);

        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode.printList(sol.recursiveReverse(head));
	}
}
