package dp;


public class LongestConsecutiveOnes {
  public int longest(int[] array) {
    
    
    if (array.length == 0) {
      return 0;
    }
    int[] memo = new int[array.length];
    // base case 
    memo[0] = array[0];
    int globalMax = array[0];

    // inductive rule
    for (int i = 1; i < array.length; i++) {
      if (array[i] == 1) {
        memo[i] = memo[i - 1] + 1;
      } else {
        memo[i] = 0;
      }
      globalMax = Math.max(globalMax, memo[i]);
    }

    return globalMax;
  }

  public static void main(String[] args) {
    int[] A = {1, 0, 1, 0, 0, 0, 1, 1, 1 ,0};
    LongestConsecutiveOnes sol = new LongestConsecutiveOnes();
    System.out.println(sol.longest(A));
  }
}

// 0 1 0 1 1 1 0
// 0 1 0 1 2 3 0

