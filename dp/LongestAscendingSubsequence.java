package dp;
import java.util.*;

public class LongestAscendingSubsequence {
  public int[] longest(int[] a) {        
    if (a.length == 0) {      
      return new int[0];    
    }     
    int[] memo = new int[a.length];    
    int[] pred = new int[a.length];      // vlue: idx of predecessor
    int maxLen = 1;
    int idxMaxLen = -1;
        
    for (int i = 0; i < a.length; i++) {      
      memo[i] = 1;      
      pred[i] = -1;       
      
      for (int j = 0; j < i; j++) {        
        if (a[i] > a[j] && memo[i] < memo[j] + 1) {
          memo[i] = memo[j] + 1;  // update memo[i]
          pred[i] = j;  // collect the index of predecessor
        }

        if (maxLen < memo[i]) {
          maxLen = memo[i];
          idxMaxLen = i;
        }
      }
    }  
    List<Integer> resList = new ArrayList<>();

    int curIdx = idxMaxLen;
    while (curIdx != -1) {
      resList.add(a[curIdx]);
      curIdx = pred[curIdx];
    }

    if (resList.isEmpty()) {
      return new int[] {a[0]};
    }

    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(resList.size() - 1 - i);
    }

    return res;
  }

  public static void main(String[] args) {
    //int[] a = {7, 2, 3, 1, 5, 8, 9, 6};
    int[] a = {5,4,3,2,1};
    LongestAscendingSubsequence sol = new LongestAscendingSubsequence();
    System.out.println(sol.longest(a));
  }
}