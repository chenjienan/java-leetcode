package advance;
import java.util.*;


public class LRU<K, V> {
  // limit is the max capacity of the cache
  private int cap;
  private int size;
  private Map<K, ListNode<K, V>> lookup;
  private ListNode<K, V> head; // use as dummy
  private ListNode<K, V> tail; // use as dummy

  public LRU(int limit) {
    this.cap = limit;
    this.size = 0;
    this.head = new ListNode<K, V>();
    this.tail = new ListNode<K, V>();
    this.head.next = this.tail;
    this.tail.prev = this.head;
    lookup = new HashMap<K, ListNode<K, V>>();
  }
  
  public void set(K key, V value) {
    ListNode<K, V> curNode = lookup.get(key);
    if (curNode != null) {
      curNode.value = value;
      moveNodeToHead(curNode);
    } else {
      ListNode<K, V> newNode = new ListNode<K, V>(key, value);
      lookup.put(key, newNode);
      if (size < cap) {   
        size++;
      } else {
        lookup.remove(removeTail());
      }
      addNode(newNode);
    }
  }
  
  public V get(K key) {
    ListNode<K, V> curNode = lookup.get(key);
    if (curNode != null) {
      // move to head
      V res = curNode.value;      
      moveNodeToHead(curNode);
      return res;
    }    
    return null;
  }

  private void addNode(ListNode<K, V> newNode) {
    newNode.next = head.next;
    newNode.prev = head;
    head.next.prev = newNode;
    head.next = newNode;
  }

  private void removeNode(ListNode<K, V> node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveNodeToHead(ListNode<K, V> node) {
    removeNode(node);
    addNode(node);
  }

  private K removeTail() {
    ListNode<K, V> tailNode = tail.prev;
    removeNode(tailNode);
    return tailNode.key;
  }

  static class ListNode<K, V> {
    private K key;
    private V value;
    private ListNode<K, V> prev;
    private ListNode<K, V> next;

    public ListNode() {
      this.key = null;
      this.value = null;
    }
    public ListNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    LRU<Integer, Integer> cache = new LRU<>(2);
    System.out.println(cache.get(1)); // null
    cache.set(1, 1);  // head <-> 1 <-> tail
    cache.set(2, 2);  // head <-> 2 <-> 1 <-> tail
    System.out.println(cache.get(2));   // 2
    System.out.println(cache.get(1));   // 1 head <-> 1 <-> 2 <-> tail
    cache.set(3, 3); //head <-> 3 <-> 1 <-> tail
    System.out.println(cache.get(1)); // 1 head <-> 1 <-> 3 <-> tail
    System.out.println(cache.get(2)); // null
    System.out.println(cache.get(3)); // 3 head <-> 3 <-> 1 <-> tail
  }
}

// use case
// 1. put 
//   1.0 if exist: update; move node to head;
//   1.1 size < cap: add node;
//   1.2 size >= cap: pop tail; remove from map; add node to head
// 2. get
//   2.0 if exist: cache res; move node to head;
//   2.1 return null

//most 
//recent
// head <-> 1 <-> 2 <-> 3 <-> 4 <-> tail