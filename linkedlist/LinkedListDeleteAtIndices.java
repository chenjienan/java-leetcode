package linkedlist;
import tools.*;


public class LinkedListDeleteAtIndices {
  public ListNode deleteNodes(ListNode head, int[] indices) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    int curIdx = 0;   // the index of the current node 
    int removeIdx = 0;
    while (pre.next != null && removeIdx < indices.length) {
      cur = cur.next;     // get next node
      if (curIdx == indices[removeIdx]) { // remove cur node
        pre.next = cur;
        removeIdx++;
      } else {
        pre = pre.next;
      }
      curIdx++;
    }

    return dummy.next; 
  }


  public static void main(String[] args) {
    int[] A = {1,2,3,4};
    ListNode head = ListNode.createLinkedList(A);
    int[] I = {3};

		LinkedListDeleteAtIndices sol = new LinkedListDeleteAtIndices();
		ListNode.printList(sol.deleteNodes(head, I));
  }
}