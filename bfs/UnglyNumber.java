package bfs;

import java.util.*;



public class UnglyNumber {
  public long kth(int k) {
    Queue<Node> minHeap = new PriorityQueue<>();
  
    minHeap.offer(new Node(1, 1, 1));

    long curSmallest = 0;
    for (int i = 0; i < k; i++) {
      // expand
      Node curNode = minHeap.poll();
      curSmallest = curNode.sum;
      
      // generate
      minHeap.offer(new Node(curNode.x + 1, curNode.y, curNode.z));
      minHeap.offer(new Node(curNode.x, curNode.y + 1, curNode.z));
      minHeap.offer(new Node(curNode.x, curNode.y, curNode.z + 1));
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
      this.sum = (long) Math.pow(3, x) * (long) Math.pow(5, y)  * (long) Math.pow(7, z);
    }   

    @Override
    public int compareTo(Node node) {
      if (this.sum == node.sum) {
        return 0;
      }

      return this.sum < node.sum ? -1 : 1;
    }
  }

  public static void main(String[] args) {
    UnglyNumber sol = new UnglyNumber();
    System.out.println(sol.kth(40));
  }
}
