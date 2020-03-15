package advance;
import java.util.*;

public class FirstNonRepeatingCharInStream {

  private Map<Character, ListNode> lookup;
  private ListNode head;
  private ListNode tail;

  public FirstNonRepeatingCharInStream() {
    lookup = new HashMap<Character, ListNode>();
    head = new ListNode();
    tail = new ListNode();
    head.next = tail;
    tail.prev = head;
  }
  // maintain a list of nodes without pepeating char according to the insert order  
  public void read(char ch) {
    if (!lookup.containsKey(ch)) {
      // new char
      ListNode newNode = new ListNode(ch, 1);
      addNodeToTail(newNode);
      lookup.put(ch, newNode);
    } else {
      ListNode curNode = lookup.get(ch);
      if (curNode != null) { // need to be removed
        removeNode(curNode);
        lookup.put(ch, null);
      }
    }
  }
  
  public Character firstNonRepeating() {    
    
    if (head.next == tail) {
      return null;
    } else {
      return head.next.key;
    }
  }

  private void addNodeToTail(ListNode node) {
    // X <-> tail
    // X <-> New <-> tail
    node.prev = tail.prev;
    node.next = tail;

    tail.prev.next = node;
    tail.prev = node;
  }

  private void removeNode(ListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  static class ListNode {
    char key;
    int count;
    ListNode next;
    ListNode prev;
    
    public ListNode() {

    }

    public ListNode(char key, int count) {
      this.key = key;
      this.count = count;
    }          
  }

  public static void main(String[] args) {
    FirstNonRepeatingCharInStream sol = new FirstNonRepeatingCharInStream();

    sol.read('a');
    System.out.println(sol.firstNonRepeating());
    sol.read('b');
    System.out.println(sol.firstNonRepeating());
    sol.read('c');
    System.out.println(sol.firstNonRepeating());
    sol.read('a');
    System.out.println(sol.firstNonRepeating());
    sol.read('c');
    System.out.println(sol.firstNonRepeating());
    sol.read('c');
    System.out.println(sol.firstNonRepeating());
    sol.read('b');
    System.out.println(sol.firstNonRepeating());
  }
}


// Map<Character, ListNode>

// class ListNode {
//  char key;
//  int count;
//}

// a -> b -> c