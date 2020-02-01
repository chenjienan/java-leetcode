package linkedlist;
import tools.*;

public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
      
      if (head == null || head.next == null) {
        return head;
      }
  
      ListNode nxt = head.next;
      head.next = reverseInPairs(nxt.next);
      nxt.next = head;
      return nxt;
  
    }
  }