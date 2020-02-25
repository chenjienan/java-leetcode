package heap;
import java.util.*;
import tools.*;

public class MergeKSortedList {
  public ListNode merge(List<ListNode> listOfLists) {  
        
    if (listOfLists.size() == 0) {
      return null;
    }

    Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        if (l1.value == l2.value) {
          return 0;
        }
        return l1.value < l2.value ? -1 : 1;
      }      
    });

    for (ListNode head : listOfLists) {
      if (head != null) {
        minHeap.offer(head);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while (!minHeap.isEmpty()) {
      ListNode curMin = minHeap.poll();
      if (curMin.next != null) {
        minHeap.offer(curMin.next);
      }
      cur.next = curMin;      
      cur = cur.next;
    }
    
    return dummy.next;
  }

  public static void main(String[] args) {

    ListNode node1 = new ListNode(5);
    ListNode node2 = new ListNode(2);

    List<ListNode> ls = new ArrayList<>();
    ls.add(node1);
    ls.add(node2);

    MergeKSortedList sol = new MergeKSortedList();
    System.out.println(sol.merge(ls));
  }
}
