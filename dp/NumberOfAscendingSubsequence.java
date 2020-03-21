package dp;


public class NumberOfAscendingSubsequence {
  public int numIncreasingSubsequences(int[] a) {
    if (a.length == 0) {
      return 0;
    }

    int[] memo = new int[a.length]; // the number of ascending subseq that ends at a[i]
    int[] len = new int[a.length]; // length of ascending subseq that ends at a[i]

    int maxCount = 0;
    int maxLen = 0;

    for (int i = 0; i < a.length; i++) {
      memo[i] = 1;  // add self
      len[i] = 1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {  
          if (len[i] == len[j] + 1) {
            memo[i] += memo[j]; 
          } else if (len[i] < len[j] + 1) {
            len[i] = len[j] + 1;
            memo[i] = memo[j];
          }
        } // skip if smaller than previous num
      }

      if (maxLen == len[i]) {
        maxCount += memo[i];
      } else if (maxLen < len[i]) {
        maxLen = len[i];
        maxCount = memo[i];
      }
    }
    return maxCount;
  }
}
