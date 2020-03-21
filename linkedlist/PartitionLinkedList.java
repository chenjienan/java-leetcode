package linkedlist;
import tools.*;

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
    if (head == null || head.next == null){
      return head;
    }
    // create 2 dummy nodes
    ListNode smaller = new ListNode(0);
    ListNode larger = new ListNode(0);

    ListNode smaller_ptr = smaller;
    ListNode larger_ptr = larger;

    while (head != null) {

      if (head.value < target){
        smaller_ptr.next = head;
        smaller_ptr = smaller_ptr.next;
      }else {
        larger_ptr.next = head;
        larger_ptr = larger_ptr.next;
      }

      head = head.next;
    }

    smaller_ptr.next = larger.next;
    larger_ptr.next = null;

    return smaller.next;
  }
}
