package linkedlist;
import tools.*;

public class LinkedListDeleteAtIndex {
  public ListNode deleteNode(ListNode head, int index) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    int idx = 0;          // index of current node
    while (cur != null) {
      cur = cur.next;     // get next node
      if (idx == index) {
        pre.next = cur;
        break;
      }
      pre = pre.next;
      idx++;
    }

    return dummy.next;
  }
}