package linkedlist;
import tools.*;

public class RotateLinkedListByK {
  public ListNode rotateKplace(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int len = 0;  // count the number of nodes
    while (head != null) {
      head = head.next;
      len++;
    }

    if (n % len == 0) {
      return dummy.next;
    }
    int k = n % len;
    ListNode fast = dummy.next;
    ListNode slow = dummy.next;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    ListNode newHead = slow.next;
    slow.next = null;
    fast.next = dummy.next;

    return newHead;
  }
}