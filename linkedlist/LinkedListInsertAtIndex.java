package linkedlist;
import tools.*;

public class LinkedListInsertAtIndex {
  public ListNode insert(ListNode head, int index, int value) {
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    int idx = 0;   // the index of previous node
    while (prev.next != null && idx < index) {
      prev = prev.next;
      idx++;
    }

    // either we are running out of nodes or we find the target index
    if (idx == index) {
      ListNode newNode = new ListNode(value);
      newNode.next = prev.next;
      prev.next = newNode;
    }

    return dummy.next;
  }
}