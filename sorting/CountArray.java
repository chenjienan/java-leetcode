package sorting;
import java.util.*;

public class CountArray {

  public int[] countArray(int[] array) {
    
    if (array.length == 0) {
      return array;
    }
    
    List<Node> resList = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      resList.add(new Node(array[i], 0, i));
    }
    
    resList = splitAndMerge(resList, 0, resList.size() - 1);
    Collections.sort(resList);
    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(i).count;
    }
    
    return res;
  }

  private List<Node> splitAndMerge(List<Node> array, int left, int right) {
    // base case
    if (left >= right) {
      List<Node> base = new ArrayList<>();
      base.add(array.get(left));
      return base;
    }
    
    int mid = left + (right - left) / 2;
    List<Node> leftPart = splitAndMerge(array, left, mid);
    List<Node> rightPart = splitAndMerge(array, mid + 1, right);
    
    return merge(leftPart, rightPart);
  }


  private List<Node> merge(List<Node> left, List<Node> right) {  
    
    List<Node> res = new ArrayList<>();
    
    int i = 0;
    int j = 0;
    while (i < left.size() && j < right.size()) {    
      if (left.get(i).val <= right.get(j).val) {      
        res.add(new Node(left.get(i).val, left.get(i).count + j, left.get(i).pos));
        i++;      
      } else {
        res.add(new Node(right.get(j).val, right.get(j).count, right.get(j).pos));
        j++;
      }
    }
    
    while (i < left.size()) {
      res.add(new Node(left.get(i).val, left.get(i).count + j, left.get(i).pos));
      i++;
    }
    
    while (j < right.size()) {
      res.add(new Node(right.get(j).val, right.get(j).count, right.get(j).pos));
      j++;
    }
    
    return res;
  }

  static class Node implements Comparable<Node> {
    int val;
    int count;
    int pos;
    
    public Node(int v, int c, int i) {
      this.val = v;
      this.count = c;
      this.pos = i;
    }

    @Override
    public int compareTo(Node n) {
      if (this.pos == n.pos) {
        return 0;  
      }
      return this.pos < n.pos ? -1 : 1;      
    }    
  }

  public static void main(String[] args) {
    int[] A = {4, 1, 3, 2};

            // 3  0  1  0

    CountArray sol = new CountArray();
    System.out.println(sol.countArray(A));
  }

}