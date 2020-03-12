package bfs;

import java.util.*;


public class KthClosestPointToOrigin {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    
    Set<List<Integer>> used = new HashSet<>();
    Queue<Node> minHeap = new PriorityQueue<>();

    // init
    List<Integer> first = Arrays.asList(0, 0, 0);    
    Node newNode = new Node(0,0,0, getDistance(first, a, b, c));
    used.add(first);
    minHeap.offer(newNode);

    Node cur = null;
    for (int i = 0; i < k; i++) {
      cur = minHeap.poll();

      List<Integer> newPoints = Arrays.asList(cur.x + 1, cur.y, cur.z);
      if (cur.x + 1 < a.length && !used.contains(newPoints)) {
        used.add(newPoints);
        minHeap.offer(new Node(cur.x + 1, cur.y, cur.z, getDistance(newPoints, a, b, c)));
      }

      newPoints = Arrays.asList(cur.x, cur.y + 1, cur.z);
      if (cur.y + 1 < b.length && !used.contains(newPoints)) {
        used.add(newPoints);
        minHeap.offer(new Node(cur.x, cur.y + 1, cur.z, getDistance(newPoints, a, b, c)));
      }

      newPoints = Arrays.asList(cur.x, cur.y, cur.z + 1);
      if (cur.z + 1 < c.length && !used.contains(newPoints)) {
        used.add(newPoints);
        minHeap.offer(new Node(cur.x, cur.y, cur.z + 1, getDistance(newPoints, a, b, c)));
      }
    }

    List<Integer> res = new ArrayList<>();
    res.add(a[cur.x]);
    res.add(b[cur.y]);
    res.add(c[cur.z]);

    return res;
  }


  private int getDistance(List<Integer> points, int[] a, int[] b, int[] c) {
    return a[points.get(0)] * a[points.get(0)] + b[points.get(1)] * b[points.get(1)] + c[points.get(2)] * c[points.get(2)];

  }
  class Node implements Comparable<Node> {
    int x;
    int y;
    int z;
    int sum;

    public Node(int x, int y, int z, int sum) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
      if (this.sum == o.sum) {
        return 0;
      }
      return this.sum < o.sum ? -1 : 1;
    }
  }

  public static void main(String[] args) {
    int[] A = {1,2,3};
    int[] B = {2, 4};
    int[] C = {1, 2};

    KthClosestPointToOrigin sol = new KthClosestPointToOrigin();
    System.out.println(sol.closest(A, B, C, 10));
  }
}
