package dp;


public class LargestSubarraySum {
  public int largestSum(int[] array) {
    int n = array.length;

    // semantics: memo[i] largest subarray sum that ends at i
    int[] memo = new int[n];  

    // base case
    memo[0] = array[0];
    int globalMax = array[0];
    // inductive rule
    for (int i = 1; i < array.length; i++) {
      if (memo[i-1] < 0) {
        memo[i] = array[i];
      } else {
        memo[i] = array[i] + memo[i-1];
      }
      globalMax = Math.max(globalMax, memo[i]);
    }
    return globalMax;
  }

  public static void main(String[] args) {
    int[] A = {2, -1, 4, -2, 1};

    LargestSubarraySum sol = new LargestSubarraySum();
    System.out.println(sol.largestSum(A));
  }
}
