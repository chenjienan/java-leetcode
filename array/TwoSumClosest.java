package array;

import java.util.*;


public class TwoSumClosest {
  public List<Integer> closest(int[] A, int target) {
    List<Integer> res = new ArrayList<>();
    if (A == null || A.length == 0) {
      return res;
    }
    
    Arrays.sort(A);
    
    int[] temp = new int[2];
    int left = 0;
    int right = A.length - 1;
    
    int minDiff = Integer.MAX_VALUE;
    while (left < right) {
      
      int sum = A[left] + A[right];
      
      if (sum == target) {
        res.add(A[left]);
        res.add(A[right]);
        return res;
      }
      
      int curDiff = Math.abs(sum - target);
      if (curDiff < minDiff) {
        temp[0] = A[left];
        temp[1] = A[right];
        minDiff = curDiff;    
      }
      
      if (sum < target) {
        left++;    
      } else {
        right--;
      }
    }
    
    for (int i = 0; i < temp.length; i++) {
      res.add(temp[i]);
    }
    
    return res;
  }

  public static void main(String[] args) {


    // int[] A = {2, -3, 9};

    // TwoSumClosest sol = new TwoSumClosest();
    // System.out.println(sol.closest(A, 10));

    for (int i = 0; i <= 10; i+=2) {
      System.out.println(i);
    }
  }
}
