package bfs;
import java.util.*;

public class KthSmallestWithOnly357 {
  public long kth(int k) {
    Queue<Node> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    Node first = new Node(1, 1, 1);
    minHeap.offer(first);
    visited.add(first.sum);

    long curSmallest = 0;
    for (int i = 0; i < k; i++) {
      // expand
      Node curNode = minHeap.poll();
      curSmallest = curNode.sum;
      visited.add(curNode.sum);
      
      // generate with dedup
      if (visited.add(3 * curNode.sum)) {
        minHeap.offer(new Node(curNode.x + 1, curNode.y, curNode.z));
      }
      if (visited.add(5 * curNode.sum)){
        minHeap.offer(new Node(curNode.x, curNode.y + 1, curNode.z));
      }
      if (visited.add(7 * curNode.sum)){
        minHeap.offer(new Node(curNode.x, curNode.y, curNode.z + 1));
      }
    }

    return curSmallest;
  }

  static class Node implements Comparable<Node>{
    int x;
    int y;
    int z;
    long sum;
    
    public Node(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.sum = (long) Math.pow(3, x) * (long) Math.pow(5, y)  * (long) Math.pow(7, z);;
    }   

    @Override
    public int compareTo(Node node) {
      if (this.sum == node.sum) {
        return 0;
      }

      return this.sum < node.sum ? -1 : 1;
    }
  }
}
