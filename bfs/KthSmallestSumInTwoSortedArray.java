package bfs;
import java.util.*;


public class KthSmallestSumInTwoSortedArray {
  public int kthSum(int[] A, int[] B, int k) {
    
    Set<Node> visited = new HashSet<>();
    Queue<Node> minHeap = new PriorityQueue<>();
    Node first = new Node(0, 0, A[0] + B[0]);
    minHeap.offer(first);
    visited.add(first);

    Node curNode = null;
    for (int x = 0; x < k; x++) {
      curNode = minHeap.poll();
            
      if (curNode.i + 1 < A.length) {        
        Node nxtNode = new Node(curNode.i + 1, curNode.j, A[curNode.i + 1] + B[curNode.j]);
        if (!visited.contains(nxtNode)) {
          minHeap.offer(nxtNode);
          visited.add(nxtNode);
        }
        
      }
      
      if (curNode.j + 1 < B.length) {    
        Node nxtNode = new Node(curNode.i, curNode.j + 1, A[curNode.i] + B[curNode.j + 1]);    
        if (!visited.contains(nxtNode)) {
          minHeap.offer(nxtNode);
          visited.add(nxtNode);
        }
      }
    }
    return curNode.sum;
  }

  static class Node implements Comparable<Node> {
    int i;
    int j;
    int sum;

    public Node(int i, int j, int sum) {
      this.i = i;
      this.j = j;
      this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
      if (this.sum == o.sum) {
        return 0;
      }
      return this.sum < o.sum ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Node)) return false;
      Node another = (Node) o;
      return this.i == another.i && this.j == another.j;
    }

    @Override
    public int hashCode() {
      return this.i * 101 + this.j + this.sum;
    }
  }

  public static void main(String[] args) {
    int[] A = {1,3,5,8,9};
    int[] B = {2,3,4,7};

    KthSmallestSumInTwoSortedArray sol = new KthSmallestSumInTwoSortedArray();
    System.out.println(sol.kthSum(A, B, 20));
  }
}
