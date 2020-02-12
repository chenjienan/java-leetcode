package dp;

public class JumpGame {
  public boolean canJump(int[] array) {
    
    boolean[] memo = new boolean[array.length];
    memo[0] = true;

    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        if (memo[j] && array[j] + j >= i) {
          memo[i] = true;
        }
      }
    }
    return memo[array.length - 1];
  }

  public int minJump(int[] array) {
    int n = array.length;
    int[] memo = new int[n];
    // semantics: memo[i] min steps from A[i] to A[n-1]
    
    // Base case 
    memo[n - 1] = 0;

    // Inductive rule: from fill the array from right to left
    for (int i = n - 2; i >= 0; i--) {      
      memo[i] = -1;
      for (int j = array[i]; j > 0; j--) {
        int nxtIdx = i + j;   // can reach next index
        if (nxtIdx < n && memo[nxtIdx] != -1) {
          int minSteps = 1 + memo[nxtIdx];
          if (memo[i] < 0) {
            memo[i] = minSteps;
          } else {
            memo[i] = Math.min(memo[i], 1 + memo[nxtIdx]);
          }          
        }
      }
    }

    return memo[0];
    
  }

  public static void main(String[] args) {
    int[] A = {3, 3, 1, 0, 4};
    // int[] A = {2, 1, 1, 0, 2};

    JumpGame sol = new JumpGame();
    System.out.println(sol.minJump(A));
  }
}
