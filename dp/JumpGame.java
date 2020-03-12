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

  public int minJump2(int[] array) {

  
    int[] memo = new int[array.length];
    for (int k = 1; k < array.length; k++) {    
      memo[k] = -1;      
    }
    // base case
    memo[0] = 0;    
    for (int i = 0; i < array.length - 1; i++){ 

      if (memo[i] == -1) {
        break;
      }
      int curJump = memo[i] + 1;      
      for (int j = 1; j <= array[i]; j++) {
        if (i + j < array.length) {     
          if (memo[i + j] == -1) {
            memo[i + j] = curJump;
          } else {
            memo[i + j] = Math.min(memo[i + j], curJump);
          }
        }           
      }
    }
    
    return memo[array.length - 1];
  }

  public static void main(String[] args) {
    int[] A = {2,1,0,3,1};
    // int[] A = {2, 1, 1, 0, 2};

    JumpGame sol = new JumpGame();
    System.out.println(sol.minJump2(A));
  }
}
