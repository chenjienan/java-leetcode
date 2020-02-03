package dp;

public class LIS {
  public int longest(int[] array) {
    
    if (array.length == 0) {
      return 0;
    }
    int[] memo = new int[array.length];
    memo[0] = 1;
    int globalMax = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i-1]) {
        memo[i] = memo[i-1] + 1;
        globalMax = Math.max(globalMax, memo[i]);
      } else {
        memo[i] = 1;
      }
    }
    return globalMax;
  }
}
