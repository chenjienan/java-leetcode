package heap;
import java.util.*;


public class MergeKSortedArray {
  public int[] merge(int[][] arrayOfArrays) {    
    int rows = arrayOfArrays.length;
    List<Integer> resList = new ArrayList<>();
    Queue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node n1, Node n2) {        
        if (n1.val == n2.val) {
          return 0;
        }
        return n1.val < n2.val ? -1 : 1;       
      }
    });
        
    for (int r = 0; r < rows; r++) {
      if (arrayOfArrays[r].length != 0) {
        minHeap.offer(new Node(r, 0, arrayOfArrays[r][0]));
      }       
    }
    
    while (!minHeap.isEmpty()) {
      Node curMin = minHeap.poll();
      resList.add(curMin.val);
      
      int curRow = curMin.row;
      int nxtCol = curMin.col + 1;
      if (nxtCol < arrayOfArrays[curRow].length) {
        minHeap.offer(new Node(curRow, nxtCol, arrayOfArrays[curRow][nxtCol]));
      }
    }  
    
    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(i);
    }
    
    return res;
  }

  static class Node {
    int row;
    int col;
    int val;
    
    public Node(int r, int c, int v) {
      this.row = r;
      this.col = c;
      this.val = v;
    }
  }
}