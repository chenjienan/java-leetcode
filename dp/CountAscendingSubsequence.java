package dp;


public class CountAscendingSubsequence {
  public int numIncreasingSubsequences(int[] a) {
    if (a.length == 0) {
      return 0;
    }

    int[] memo = new int[a.length]; // the number of ascending subseq that ends at a[i]    

    for (int i = 0; i < a.length; i++) {
      memo[i] = 1;  // count self      
      for (int j = 0; j < i; j++) {        
        if (a[i] > a[j]) {
          memo[i] += memo[j]; // ascending subseq
        }
      }      
    }

    int res = 0;
    for (int i = 0; i < memo.length; i++) {
      res += memo[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2, 2};
    CountAscendingSubsequence sol = new CountAscendingSubsequence();
    System.out.println(sol.numIncreasingSubsequences(a));
  }
}
